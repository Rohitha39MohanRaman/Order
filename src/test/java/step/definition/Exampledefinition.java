package step.definition;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;

import com.example.order.OrderApplication;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import org.junit.Assert;
	
@CucumberContextConfiguration
	@SpringBootTest(classes = OrderApplication.class)
	public class Exampledefinition{
	     private Response response;
	    @Given("Get Call to url")
	    public void get_call_to_url(){
	         RestAssured.baseURI = "http://localhost:9001/orderdetails/get";
	            RequestSpecification httpRequest = RestAssured.given();
	            response=httpRequest.request(Method.GET);
	            System.out.println("Get order data from URL"); 
	        }
	    @Then("Response Code status is validated")
	     public void response_code_status_is_validated() {
	         int responseStatus = response.getStatusCode();
	         System.out.println("Get the status code"+ responseStatus );
	         Assert.assertEquals(responseStatus, 200);
	        }
	     @Then("verify response content type is {string}")
	     public void verify_response_content_type_is(String contentType) {
	         assertTrue(response.getContentType().contains(contentType));
	     }

	     @Then("print out the response body to console")
	     public void print_out_the_response_body_to_console() {
	    	 String responseBody=response.getBody().asString();
	    	 System.out.println("ResponseBody:"+responseBody);
	     }
	        }
	
