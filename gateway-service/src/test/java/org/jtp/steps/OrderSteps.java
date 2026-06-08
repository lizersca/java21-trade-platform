package org.jtp.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderSteps {

    private final TestRestTemplate restTemplate =
            new TestRestTemplate();

    private ResponseEntity<Void> response;

    @When("a client submits a valid order")
    public void submitOrder() {

        String payload = """
                {
                  "customerId":"C123",
                  "symbol":"AAPL",
                  "side":"BUY",
                  "quantity":100
                }
                """;

        response = restTemplate.postForEntity(
                "http://localhost:8080/orders",
                payload,
                Void.class
        );
    }

    @Then("the order should be accepted")
    public void orderAccepted() {

        assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.ACCEPTED);
    }
}