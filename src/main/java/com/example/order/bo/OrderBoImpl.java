package com.example.order.bo;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.example.order.eo.OrderEo;
import com.example.order.model.HealthCheck;
import com.example.order.model.OrderDto;

@Service
public class OrderBoImpl implements OrderBo {
	@Autowired
	private OrderEo orderEo;
	Logger logger = LoggerFactory.getLogger(OrderBoImpl.class);
	@Override
	public List<OrderDto> getOrderDto() {
		logger.info("retrieving order details");
		return orderEo.getOrderDto();
	}
	@Override
	public OrderDto saveOrderDto(OrderDto orderDto){
		logger.info("saving the order details");
		return orderEo.saveOrderDto(orderDto);
	}
	@Override
	public HealthCheck healthcheck(){
		HealthCheck healthcheck= new HealthCheck();
		healthcheck.setHealthComment("Check table is available in db");
		try {
			if(getOrderDto()!=null)
			{
				healthcheck.setHealthStatus("Success");
				healthcheck.setHealthDescription("Table is available");
			}
		}
		catch(Exception ex)
		{
		healthcheck.setHealthStatus("Failure");
		healthcheck.setHealthDescription("Table is not available");
		}
		return healthcheck;
	}
}
