package stepDefinition;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.testng.Assert;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class SpecificDate {
	
	Response response;
	int responseStatus;
	String responseBody ;
	
	@Given("API for Latest Foreign Exchange rates {string}")
	public void api_for_latest_foreign_exchange_rates(String URI) {
		
	    response = RestAssured.get(URI);
	    
	}
	
	@When("get response status of the API")
	public void get_response_status_of_the_api() {
		
		responseStatus = response.getStatusCode();
		
	} 
	
	@Then("validate the response status code as {string}")
	public void validate_the_response_status_code_as(String status) {
		
		int s_code = Integer.parseInt(status);
		Assert.assertEquals(responseStatus, s_code);
		
	}
	
	@When("get response body of API")
	public void get_response_body_of_api() {
		
		responseBody = response.getBody().asString();
		
	}


	@Then("Validate the response body of API")
	public void validate_the_response_body_of_API() {
		
		Assert.assertNotNull(responseBody);
			
	}
	
	@When("get the response")
	public void get_the_response() {
		 
		responseBody = response.getBody().asString();
		 
	}
	
	@Then("validate date in response with current date")
	public void validate_date_in_response_with_current_date() {
		 
		JsonPath extractor = response.jsonPath() ;
	    String date = extractor.getString("date") ;
	    Date currDate = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd"); 
	    String curr = sdf.format(currDate);
	    Assert.assertNotEquals(curr,date) ;
	    
	}

}