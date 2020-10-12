package stepDefinition;

import org.testng.Assert;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.RestAssured;

public class ExchangeRate {
	
	Response response;
	int responseStatus;
	String responseBody;
	
	@Given("Go to the Rates API for Exchange rates {string}")
	public void go_to_the_rates_api_for_exchange_rates(String URI) {
		
	    response = RestAssured.get(URI);
	    
	}
	
	@When("get the response status from the API")
	public void get_the_response_status_from_the_api() {
		
		responseStatus = response.getStatusCode();
		
	}

	
	@Then("validate the status code of the response is {string}")
	public void validate_the_status_code_of_the_response_is(String status) {
	    
		int s_code = Integer.parseInt(status);
		Assert.assertEquals(responseStatus, s_code);
		
	}

	
	@When("get the response body from the API")
	public void get_the_response_body_from_the_api() {
		
		responseBody = response.getBody().asString();
		
	}

	@Then("Verify the response body is not null")
	public void verify_the_response_body_is_not_null() {
		
	    Assert.assertNotNull(responseBody);
	    
	}
	
	
}
