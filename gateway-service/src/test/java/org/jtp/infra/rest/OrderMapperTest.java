package org.jtp.infra.rest;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;

import org.jtp.domain.order.SideEnum;
import org.jtp.domain.port.TimeProvider;
import org.jtp.model.CreateOrderRequest;
import org.jtp.testutil.FixedTimeProvider;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class OrderMapperTest {

    private static final Instant FIXED_TIME =
            Instant.parse("2024-01-01T00:00:00Z");

    private final OrderMapper mapper =
            Mappers.getMapper(OrderMapper.class);

    private final TimeProvider timeProvider =
            new FixedTimeProvider(FIXED_TIME);

    @Test
    void shouldMapCreateOrderRequestToOrderCorrectly() {

        var request = new CreateOrderRequest(
                "ORD123",
                "C123",
                "AAPL",
                CreateOrderRequest.SideEnum.BUY,
                100
        );

        var result = mapper.toDomain(request, timeProvider);

        assertThat(result.orderId()).isEqualTo("ORD123");
        assertThat(result.customerId()).isEqualTo("C123");
        assertThat(result.market()).isEqualTo("AAPL");

        assertThat(result.side())
                .isEqualTo(SideEnum.BUY);

        assertThat(result.quantity()).isEqualTo(100);

        assertThat(result.submittedAt())
                .isEqualTo(FIXED_TIME);
    }

    @Test
    void shouldMapSellOrderCorrectly() {

        var request = new CreateOrderRequest(
                "ORD999",
                "C999",
                "TSLA",
                CreateOrderRequest.SideEnum.SELL,
                50
        );

        var result = mapper.toDomain(request, timeProvider);

        assertThat(result.orderId()).isEqualTo("ORD999");
        assertThat(result.customerId()).isEqualTo("C999");
        assertThat(result.market()).isEqualTo("TSLA");

        assertThat(result.side())
                .isEqualTo(SideEnum.SELL);

        assertThat(result.quantity()).isEqualTo(50);

        assertThat(result.submittedAt())
                .isEqualTo(FIXED_TIME);
    }
}