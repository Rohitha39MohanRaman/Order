package com.example.order.eo;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.order.dao.OrderDao;
import com.example.order.model.HealthCheck;
import com.example.order.model.OrderDto;
@Component
public class OrderEoImpl implements OrderEo{
	@Autowired
	private OrderDao orderDao;
	
	Logger logger = LoggerFactory.getLogger(OrderEo.class);
	
	@Override
	public List<OrderDto> getOrderDto() {
		logger.info("Retrieving data");
		return orderDao.getOrderDto();
	}
	@Override
	public OrderDto saveOrderDto(OrderDto orderDto){
		logger.info("Save order");
		//return orderDao.saveOrderDto(orderDto);
		  try {

	            // Create a JAXBContext for OrderDto

	            JAXBContext context = JAXBContext.newInstance(OrderDto.class);

	 

	            // Marshalling (Java object to XML)

	            Marshaller marshaller = context.createMarshaller();

	            StringWriter writer = new StringWriter();

	            marshaller.marshal(orderDto, writer);

	            String xml = writer.toString();

	 

	            // Unmarshalling (XML to Java object)

	            Unmarshaller unmarshaller = context.createUnmarshaller();

	            OrderDto unmarshalledOrderDto = (OrderDto) unmarshaller.unmarshal(new StringReader(xml));

	 

	            // Save the unmarshalledPersonDto to the database

	            OrderDto savedOrderDto = orderDao.saveOrderDto(unmarshalledOrderDto);

	 

	            return savedOrderDto;

	        } catch (JAXBException e) {

	            // Handle JAXBException

	            logger.error("Error while marshalling/unmarshalling OrderDto: {}" , e.getMessage());

	            return null; // Or throw an exception

	        }
	}
	@Override
	public HealthCheck healthcheck() {
		// TODO Auto-generated method stub
		return null;
	}
}
//	@Override
//    public HealthCheck healthcheck() {
//        try {
//            // Perform a basic health check, e.g., checking if a database connection can be established
//            boolean isDatabaseHealthy = checkDatabaseHealth();
//
//            if (isDatabaseHealthy) {
//                return new HealthCheck("Database Health Check", "Success", "Database connection is healthy.");
//            } else {
//                return new HealthCheck("Database Health Check", "Failure", "Database connection is not available.");
//            }
//        } catch (Exception e) {
//            // Handle any exceptions that may occur during the health check
//            return new HealthCheck("Health Check", "Failure", "An error occurred during the health check.");
//        }
//		return null;
//    }
//
    // Simulate a database health check (replace this with your actual logic)
//    public boolean checkDatabaseHealth() {
//        // Implement your logic here to check the database health.
//        // For example, try to establish a database connection and return true if successful.
//        // Replace this with your actual database health check logic.
//        return true;
//    }
	
	



