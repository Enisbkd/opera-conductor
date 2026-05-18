package mc.sbm.operaconductor.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mc.sbm.operaconductor.GenericEvent;
import mc.sbm.operaconductor.service.mapper.GenericEventWrapper;
import mc.sbm.operaconductor.service.mapper.SinkMapper;
import mc.sbm.operaconductor.service.mapper.SinkMapperRegistry;
import mc.sbm.operaconductor.utils.SerdeUtils;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.stereotype.Component;

@Component
@EnableKafkaStreams
@Slf4j
public class KafkaStreamsProcessor {

    private static final String INPUT_TOPIC = "oracle-hospitality-events";

    private final SinkMapperRegistry mapperRegistry;
    private final List<SinkMapper<?>> allMappers;

    /** Creates a new KafkaStreamsProcessor with the given mapper registry and all available sink mappers. */
    @Autowired
    public KafkaStreamsProcessor(SinkMapperRegistry mapperRegistry, List<SinkMapper<?>> allMappers) {
        this.mapperRegistry = mapperRegistry;
        this.allMappers = allMappers;
    }

    /** Builds the Kafka Streams processing pipeline, creating a sink branch for each registered mapper. */
    @Autowired
    public void buildPipeline(StreamsBuilder builder) {
        // Single shared stream from the one input topic
        KStream<String, GenericEventWrapper> source = builder
            .stream(INPUT_TOPIC, SerdeUtils.consumedWith(GenericEventWrapper.class))
            .peek((key, wrapper) -> log.debug("Received message key={} from topic={}", key, INPUT_TOPIC))
            .filter(
                (key, wrapper) ->
                    wrapper != null &&
                    wrapper.getPayload() != null &&
                    wrapper.getPayload().getData() != null &&
                    wrapper.getPayload().getData().getNewEvent() != null
            );

        // For each registered mapper, declare a filtered branch -> map -> produce to output topic
        for (SinkMapper<?> mapper : allMappers) {
            buildSinkBranch(source, mapper);
        }
    }

    private <T> void buildSinkBranch(KStream<String, GenericEventWrapper> source, SinkMapper<T> mapper) {
        String eventKey = mapper.eventKey();

        source
            .filter((key, wrapper) -> {
                GenericEvent event = wrapper.getPayload().getData().getNewEvent();
                String incoming = SinkMapperRegistry.toEventKey(event.getModuleName(), event.getEventName());
                return eventKey.equals(incoming);
            })
            .map((key, wrapper) -> {
                GenericEvent event = wrapper.getPayload().getData().getNewEvent();
                String uniqueEventId = event.getMetadata() != null ? event.getMetadata().getUniqueEventId() : key;
                log.debug("Mapping event eventKey={}, uniqueEventId={}", eventKey, uniqueEventId);
                T mapped = mapper.map(event);
                mapper.sink(mapped);
                return KeyValue.pair(uniqueEventId, mapped);
            })
            .to(eventKey, SerdeUtils.producedWith(mapper.targetClass()));
    }
}
