package com.example.order.dao;

import java.util.List;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.order.model.OrderDto;
import org.slf4j.Logger;
@Repository
public class OrderDaoImpl implements OrderDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	Logger logger = LoggerFactory.getLogger(OrderDao.class);
	@Override
	public OrderDto saveOrderDto(OrderDto orderDto) {
		String query = "insert into ordervo values('"+orderDto.getOrderId()+"','"+orderDto.getOrderName()+"')";
		jdbcTemplate.update(query);
		logger.info("Creating");
		return orderDto;
	}
	@Override
	public List<OrderDto> getOrderDto() {
		/*String query1="select * from ordervo";
		logger.info("Find all the data");
		return jdbcTemplate.query(query1,(rs,rowNum)->
		new OrderDto(
				rs.getInt("orderId"),
				rs.getString("orderName")
		));*/
		String sql = "select*from ordervo";
		logger.info("Find all the data");
        List<OrderDto> orderDto = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<OrderDto>(OrderDto.class));
        return orderDto;
	}
}
