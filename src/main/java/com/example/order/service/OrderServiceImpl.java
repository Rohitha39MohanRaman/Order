package com.example.order.service;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.order.bo.OrderBo;
import com.example.order.mapper.OrderMapper;
import com.example.order.model.HealthCheck;
import com.example.order.model.OrderVo;
@Component
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderBo orderBo;
	@Autowired
	private OrderMapper orderMapper;
	Logger logger= LoggerFactory.getLogger(OrderServiceImpl.class);
	@Override
	public List<OrderVo> getOrderVo() {
		logger.info("Retrieving data");
		return orderMapper.toOrderVos(orderBo.getOrderDto());
	}
	@Override
	public OrderVo saveOrderVo(OrderVo order){
	
		logger.info("Saving Order");
		return orderMapper.toOrderVo(orderBo.saveOrderDto(orderMapper.toOrderDto(order)));
	}
	@Override
	public HealthCheck healthcheck() {
		logger.info("Healthcheck in progress");
		return orderBo.healthcheck();
	}

}
