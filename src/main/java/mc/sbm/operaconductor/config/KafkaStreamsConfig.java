package mc.sbm.operaconductor.config;

import static org.apache.kafka.streams.StreamsConfig.DEFAULT_DESERIALIZATION_EXCEPTION_HANDLER_CLASS_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.SECURITY_PROTOCOL_CONFIG;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

@Configuration
public class KafkaStreamsConfig {

    private static final Logger logger = LoggerFactory.getLogger(KafkaStreamsConfig.class);

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.properties.application.id}")
    private String applicationId;

    @Value(value = "${spring.kafka.properties.ssl.sslTruststoreLocation}")
    private String trustStoreLocation;

    @Value(value = "${spring.kafka.properties.security.protocol}")
    private String protocolConfig;

    @Value(value = "${spring.kafka.properties.sasl.jaas.config}")
    private String saslJaasConfig;

    @Value(value = "${spring.kafka.properties.sasl.mechanism}")
    private String saslMechanism;

    @Value(value = "${spring.kafka.properties.auto.offset.reset}")
    private String autoOffsetReset;

    private final String trustStorePassword = System.getProperty("javax.net.ssl.trustStorePassword");

    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration kStreamsConfig() {
        logger.info("Configuring Kafka Streams with bootstrap servers: {} and application ID: {}", bootstrapServers, applicationId);

        Map<String, Object> props = new HashMap<>();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, applicationId);
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);

        // Disable caching for immediate processing
        props.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, 1000);

        // Add more debugging configurations
        props.put(StreamsConfig.PROCESSING_GUARANTEE_CONFIG, StreamsConfig.AT_LEAST_ONCE);
        props.put(StreamsConfig.REPLICATION_FACTOR_CONFIG, 1);
        props.put(StreamsConfig.NUM_STREAM_THREADS_CONFIG, 1);

        // Consumer specific configs
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 30000);
        props.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG, 3000);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 500);

        if (protocolConfig != null) {
            props.put(SECURITY_PROTOCOL_CONFIG, protocolConfig);
        }
        if (saslJaasConfig != null) {
            props.put(SaslConfigs.SASL_JAAS_CONFIG, saslJaasConfig);
        }
        if (saslMechanism != null) {
            props.put(SaslConfigs.SASL_MECHANISM, saslMechanism);
        }
        if (trustStoreLocation != null) {
            props.put("ssl.truststore.location", trustStoreLocation);
        }
        if (trustStorePassword != null) {
            props.put("ssl.truststore.password", trustStorePassword);
        }

        props.put(DEFAULT_DESERIALIZATION_EXCEPTION_HANDLER_CLASS_CONFIG, DeadLetterDeserializationExceptionHandler.class);

        logger.info("Kafka Streams configuration: {}", props);

        return new KafkaStreamsConfiguration(props);
    }
}
