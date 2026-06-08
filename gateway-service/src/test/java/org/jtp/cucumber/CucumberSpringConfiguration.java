package org.jtp.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.jtp.testcontainers.TestContainersConfig;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class CucumberSpringConfiguration extends TestContainersConfig {
}