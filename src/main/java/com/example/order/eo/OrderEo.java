package com.example.order.eo;

import java.util.List;

import javax.xml.bind.JAXBException;

import com.example.order.model.HealthCheck;
import com.example.order.model.OrderDto;

public interface OrderEo {
	public List<OrderDto> getOrderDto();
	public OrderDto saveOrderDto(OrderDto orderDto);
	public HealthCheck healthcheck();
}
