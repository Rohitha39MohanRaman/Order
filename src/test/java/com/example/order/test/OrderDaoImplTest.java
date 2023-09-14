package com.example.order.test;
import static org.hamcrest.Matchers.hasSize;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;
import com.example.order.model.OrderDto;
import com.fasterxml.jackson.databind.ObjectMapper;


@AutoConfigureMockMvc
@SpringBootTest
class OrderDaoImplTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	JdbcTemplate jdbcTemplate;
	
	ObjectMapper obj = new ObjectMapper();
    
	 @Test
	  void saveOrderDto() throws Exception{
           OrderDto orderDto=new OrderDto(1,"Sitha");
           String json=obj.writeValueAsString(orderDto);
           when(jdbcTemplate.update("insert into ordervo values('"+orderDto.getOrderId()+"','"+orderDto.getOrderName()+"')")).thenReturn(1);
           mockMvc.perform(post("/orderdetails/post")
        		   .content(json)
        		   .contentType(MediaType.APPLICATION_JSON_VALUE)
                   .accept(MediaType.APPLICATION_JSON))
                   .andDo(print())
                  .andExpect(status().isOk()); 
	    }
	 @Test
    void getOrderDto() throws Exception{
		 List<OrderDto> listOrderDto =new ArrayList<>();
         OrderDto orderDto=new OrderDto();
         orderDto.setOrderId(1);
         orderDto.setOrderName("Sitha");
         OrderDto orderDto1=new OrderDto();
         orderDto1.setOrderId(2);
         orderDto1.setOrderName("Githa");
         listOrderDto.add(orderDto);
         listOrderDto.add(orderDto1);
           String sql = "select*from ordervo";
         when(jdbcTemplate.query(sql,
                  new BeanPropertyRowMapper<OrderDto>(OrderDto.class))).thenReturn(listOrderDto);
         mockMvc.perform(get("/orderdetails/get")
        		  .accept(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk());     
	    }
	}