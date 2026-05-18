package mc.sbm.operaconductor.utils;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.kafka.support.serializer.JacksonJsonSerde;

public class SerdeUtils {

    /** Creates a Jackson-based JSON Serde for the given type. */
    public static <T> Serde<T> jsonSerde(Class<T> type) {
        return new JacksonJsonSerde<>(type);
    }

    /** Creates a Kafka Streams Consumed descriptor using a String key serde and a JSON value serde. */
    public static <T> Consumed<String, T> consumedWith(Class<T> type) {
        return Consumed.with(Serdes.String(), jsonSerde(type));
    }

    /** Creates a Kafka Streams Produced descriptor using a String key serde and a JSON value serde. */
    public static <T> Produced<String, T> producedWith(Class<T> type) {
        return Produced.with(Serdes.String(), jsonSerde(type));
    }
}
