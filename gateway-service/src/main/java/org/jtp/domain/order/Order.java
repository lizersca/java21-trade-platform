package org.jtp.domain.order;

import java.time.Instant;

public record Order(
        String orderId,
        String customerId,
        String market,
        SideEnum side,
        int quantity,
        Instant submittedAt
) {}