package org.jtp.infra.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Instant;

import org.jtp.application.usecase.OrderUseCase;
import org.jtp.domain.order.Order;
import org.jtp.domain.order.SideEnum;
import org.jtp.model.CreateOrderRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderUseCase orderUseCase;

    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    private OrderController orderController;

    @Test
    void shouldAcceptOrder_andCallService() {

        var request = new CreateOrderRequest(
                "ORD123",
                "C123",
                "AAPL",
                CreateOrderRequest.SideEnum.BUY,
                100
        );

        var order = new Order(
                "ORD123",
                "C123",
                "AAPL",
                SideEnum.BUY,
                100,
                Instant.now()
        );

        when(orderMapper.toDomain(any(), any()))
                .thenReturn(order);

        var response = orderController.createOrder(request);

        assertThat(response.getStatusCode().value())
                .isEqualTo(202);

        verify(orderUseCase).create(any(), eq(order));
    }
}