package org.jtp.application.usecase;

import lombok.extern.slf4j.Slf4j;
import org.jtp.domain.order.Order;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class OrderUseCase {

    public void create(UUID correlationId, Order order) {

    }
}
