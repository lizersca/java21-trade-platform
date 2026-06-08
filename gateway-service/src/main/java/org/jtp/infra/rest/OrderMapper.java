package org.jtp.infra.rest;

import org.jtp.domain.order.Order;
import org.jtp.domain.port.TimeProvider;
import org.jtp.model.CreateOrderRequest;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "submittedAt", expression = "java(timeProvider.now())")
    Order toDomain(CreateOrderRequest request, @Context TimeProvider timeProvider);
}