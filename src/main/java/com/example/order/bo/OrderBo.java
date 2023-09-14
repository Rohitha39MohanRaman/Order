package com.example.order.bo;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.example.order.model.HealthCheck;
import com.example.order.model.OrderDto;
public interface OrderBo {
	public List<OrderDto> getOrderDto();
	public OrderDto saveOrderDto(OrderDto orderDto);
	public HealthCheck healthcheck();
}
 