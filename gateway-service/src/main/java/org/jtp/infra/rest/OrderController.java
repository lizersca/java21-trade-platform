package org.jtp.infra.rest;

import lombok.extern.slf4j.Slf4j;
import org.jtp.model.OrderRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping
    public ResponseEntity<Void> createOrder(
            @RequestHeader Map<String, String> headers,
            @RequestBody OrderRequest request
    ) {
        String correlationId = headers.get("x-correlation-id");
        log.info("[{}] Order request received: {}", correlationId, request);
        return ResponseEntity.status(201).build();
    }
}