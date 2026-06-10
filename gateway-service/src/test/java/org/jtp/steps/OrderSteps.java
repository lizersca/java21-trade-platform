package org.jtp.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderSteps {

    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    private ResponseEntity<Void> response;

    @When("a client submits a valid order")
    public void submitOrder() {
        String url = "http://localhost:" + port + "/orders";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String json = """
            {
              "productId": "123",
              "quantity": 1
            }
            """;

        HttpEntity<String> entity = new HttpEntity<>(json, headers);

        response = restTemplate.postForEntity(url, entity, Void.class);
    }

    @Then("the order should be accepted")
    public void orderAccepted() {

        assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.ACCEPTED);
    }
}