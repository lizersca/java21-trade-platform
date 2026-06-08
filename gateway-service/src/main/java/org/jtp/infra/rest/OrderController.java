package org.jtp.infra.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jtp.domain.port.TimeProvider;
import org.jtp.model.CreateOrderRequest;
import org.jtp.application.usecase.OrderUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private TimeProvider timeProvider;
    private OrderMapper orderMapper;
    private OrderUseCase useCase;

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderRequest request) {

        UUID correlationId = UUID.randomUUID();
        log.info("[{}] Order request received: {}", correlationId, request);

        useCase.create(correlationId, orderMapper.toDomain(request, timeProvider));
        return ResponseEntity.status(202).build();
    }
}