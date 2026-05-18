package mc.sbm.operaconductor.config;

import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.errors.DeserializationExceptionHandler;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class DeadLetterDeserializationExceptionHandler implements DeserializationExceptionHandler {

    @Value("${env}")
    private static String env;

    private static final Logger logger = LoggerFactory.getLogger(DeadLetterDeserializationExceptionHandler.class);

    private static KafkaTemplate<String, Object> staticKafkaTemplate;
    private static String staticDeadLetterTopic = "data-sim-deadletter-" + env;

    /** Creates a new instance (required by Kafka Streams). */
    public DeadLetterDeserializationExceptionHandler() {}

    /** Sets the shared KafkaTemplate and dead-letter topic name used by all handler instances. */
    public static void setKafkaTemplate(KafkaTemplate<String, Object> kafkaTemplate, String topic) {
        staticKafkaTemplate = kafkaTemplate;
        staticDeadLetterTopic = topic;
    }

    @Override
    public DeserializationHandlerResponse handle(ProcessorContext context, ConsumerRecord<byte[], byte[]> record, Exception exception) {
        try {
            logger.error(
                "Deserialization error for topic={}, partition={}, offset={}. Sending to {}",
                record.topic(),
                record.partition(),
                record.offset(),
                staticDeadLetterTopic,
                exception
            );

            DeadLetterMessage dltMessage = new DeadLetterMessage(
                record.topic(),
                record.partition(),
                record.offset(),
                exception.getMessage(),
                record.value()
            );

            if (staticKafkaTemplate != null) {
                staticKafkaTemplate.send(staticDeadLetterTopic, dltMessage);
            } else {
                logger.error("KafkaTemplate is not set in DeadLetterDeserializationExceptionHandler!");
            }
        } catch (Exception e) {
            logger.error("Failed to send record to DLT", e);
        }

        return DeserializationHandlerResponse.CONTINUE;
    }

    @Override
    public void configure(Map<String, ?> configs) {
        // nothing
    }

    public static class DeadLetterMessage {

        public String sourceTopic;
        public int partition;
        public long offset;
        public String errorMessage;
        public byte[] rawValue;

        /** Creates a new DeadLetterMessage with the given metadata and raw payload. */
        public DeadLetterMessage(String sourceTopic, int partition, long offset, String errorMessage, byte[] rawValue) {
            this.sourceTopic = sourceTopic;
            this.partition = partition;
            this.offset = offset;
            this.errorMessage = errorMessage;
            this.rawValue = rawValue;
        }
    }
}
