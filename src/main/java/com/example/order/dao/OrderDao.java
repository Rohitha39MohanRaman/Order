package com.example.order.dao;

import java.util.List;
import com.example.order.model.OrderDto;
public interface OrderDao {
	public List<OrderDto> getOrderDto();
	public OrderDto saveOrderDto(OrderDto orderDto);
	
}
