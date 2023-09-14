package com.example.order.service;

import java.util.List;

import javax.xml.bind.JAXBException;

import com.example.order.model.HealthCheck;
import com.example.order.model.OrderVo;
public interface OrderService {
 public List<OrderVo> getOrderVo();
 public OrderVo saveOrderVo(OrderVo order);
 public HealthCheck healthcheck();
}
