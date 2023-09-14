package com.example.order.test;

import static org.hamcrest.Matchers.hasSize;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.order.bo.OrderBo;
import com.example.order.eo.OrderEo;
import com.example.order.mapper.OrderMapper;
import com.example.order.model.HealthCheck;
import com.example.order.model.OrderDto;
import com.example.order.model.OrderVo;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
 class OrderBoImplTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private OrderEo orderEo;
	
	ObjectMapper obj = new ObjectMapper();
    
	 @Test
	  void saveOrderDtoTest() throws Exception{
          OrderDto orderDto=new OrderDto(1,"Sitha");
          String json=obj.writeValueAsString(orderDto);
          when(orderEo.saveOrderDto(any())).thenReturn(orderDto);
          mockMvc.perform(post("/orderdetails/post").content(json)
      		    .contentType(MediaType.APPLICATION_JSON_VALUE)
                  .accept(MediaType.APPLICATION_JSON))
                  .andDo(print())
                  .andExpect(status().isOk());
	    }
	    @Test
	     void getOrderDtoTest() throws Exception{
	         List<OrderDto> listOrderDto=new ArrayList<>();
	         OrderDto orderDto=new OrderDto();
	         orderDto.setOrderId(1);
	         orderDto.setOrderName("Sitha");
	         OrderDto orderDto1=new OrderDto();
	         orderDto1.setOrderId(2);
	         orderDto1.setOrderName("Githa");
	         listOrderDto.add(orderDto);
	         listOrderDto.add(orderDto1);
	         when(orderEo.getOrderDto()).thenReturn(listOrderDto);
	          mockMvc.perform(get("/orderdetails/get"))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$", hasSize(2)));
	    }
	   @Test
	       public void healthCheck()  throws Exception{
	    	   HealthCheck healthCheck=new HealthCheck("Check table is available in db","Success","Table is available");
	    	   String json=obj.writeValueAsString(healthCheck);
	    	   when(orderEo.healthcheck()).thenReturn(healthCheck);
	    	   mockMvc.perform(get("/orderdetails/healthcheck").content(json)
	       		    .contentType(MediaType.APPLICATION_JSON_VALUE)
	                   .accept(MediaType.APPLICATION_JSON))
	                   .andDo(print())
	                   .andExpect(status().isOk());
	    	   
}
}