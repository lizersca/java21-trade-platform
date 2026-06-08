package org.jtp.testcontainers;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.kafka.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

public abstract class TestContainersConfig {

    static final KafkaContainer kafka =
            new KafkaContainer(
                    DockerImageName.parse("apache/kafka:3.9.0")
            );

    static {
        kafka.start();
    }

    @DynamicPropertySource
    static void kafkaProperties(
            DynamicPropertyRegistry registry
    ) {
        registry.add(
                "spring.kafka.bootstrap-servers",
                kafka::getBootstrapServers
        );
    }
}