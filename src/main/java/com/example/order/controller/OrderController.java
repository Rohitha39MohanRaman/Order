package com.example.order.controller;
import java.util.List;



import javax.validation.Valid;
import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.order.model.HealthCheck;
import com.example.order.model.OrderVo;
import com.example.order.service.OrderService;
import com.example.order.service.OrderServiceImpl;
@RestController
@RequestMapping("/orderdetails")
public class OrderController {
	@Autowired
	private OrderService orderService;
	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	@GetMapping("/get")
	public ResponseEntity<List<OrderVo>> getOrderVo(){
	List<OrderVo> orderVo=orderService.getOrderVo();
	
	logger.info("Data of order details is retriving");
	return ResponseEntity.ok(orderVo);
} 
	@PostMapping(value="/post",produces="application/json")
	public ResponseEntity<OrderVo> saveOrderVo(@Valid @RequestBody OrderVo orderVo){
		OrderVo orderVos=orderService.saveOrderVo(orderVo);
		if(orderVos==null)
			return new ResponseEntity("Insertion Error", HttpStatus.BAD_REQUEST);
		logger.info("Data is saving");
		return ResponseEntity.status(HttpStatus.OK).body(orderVos);
	}
	@GetMapping("/healthcheck")
	public ResponseEntity<HealthCheck> healthcheck(){
		HealthCheck healthcheck= orderService.healthcheck();
		logger.info("Data is saving in db");
		return ResponseEntity.status(HttpStatus.OK).body(healthcheck);
	}	
}
