package com.example.order.test;
import static org.hamcrest.Matchers.hasSize;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.order.bo.OrderBo;
import com.example.order.controller.OrderController;
import com.example.order.mapper.OrderMapper;
import com.example.order.model.HealthCheck;
import com.example.order.model.OrderDto;
import com.example.order.model.OrderVo;
import com.example.order.service.OrderService;
import com.example.order.service.OrderServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
@AutoConfigureMockMvc
@SpringBootTest
class OrderServiceImplTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private OrderBo orderBo;
	@MockBean
	private OrderMapper orderMapper;
	ObjectMapper obj = new ObjectMapper();
    
	 @Test
	  void saveOrderVoTest() throws Exception{
          OrderVo orderVos=new OrderVo(1,"Sitha");
          String json=obj.writeValueAsString(orderVos);
          when(orderMapper.toOrderVo(orderBo.saveOrderDto(orderMapper.toOrderDto(orderVos))))
          .thenReturn(orderVos);
          mockMvc.perform(post("/orderdetails/post").content(json)
      		    .contentType(MediaType.APPLICATION_JSON_VALUE)
                  .accept(MediaType.APPLICATION_JSON))
                  .andDo(print())
                  .andExpect(status().isOk());
	    }
	    @Test
	    void getOrderVoTest() throws Exception{
	         List<OrderVo> listOrderVo=new ArrayList<>();
	         OrderVo orderVo=new OrderVo();
	         orderVo.setOrderId(1);
	         orderVo.setOrderName("Sitha");
	         OrderVo orderVo1=new OrderVo();
	         orderVo1.setOrderId(2);
	         orderVo1.setOrderName("Githa");
	         listOrderVo.add(orderVo);
	         listOrderVo.add(orderVo1);
	         when(orderMapper.toOrderVos(orderBo.getOrderDto()))
	         .thenReturn(listOrderVo);
	          mockMvc.perform(get("/orderdetails/get"))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$", hasSize(2)));
	    }
	    @Test
	        void healthCheck()  throws Exception{
	    	   HealthCheck healthCheck=new HealthCheck("Check table is available in db","Success","Table is available");
	    	   String json=obj.writeValueAsString(healthCheck);
	    	   when(orderBo.healthcheck()).thenReturn(healthCheck);
	    	   mockMvc.perform(get("/orderdetails/healthcheck").content(json)
	       		    .contentType(MediaType.APPLICATION_JSON_VALUE)
	                   .accept(MediaType.APPLICATION_JSON))
	                   .andDo(print())
	                   .andExpect(status().isOk());
	       }
	}

	
