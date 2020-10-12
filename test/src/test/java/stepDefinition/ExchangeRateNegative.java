package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ExchangeRateNegative {
	
	Response response;
	int responseStatus;
	
	@Given("the API {string}")
	public void the_api(String URI) {
		
	    response = RestAssured.get(URI);
	    
	}
	
	@When("get status of incorrect API")
	public void get_status_of_incorrect_api() {
		
		responseStatus = response.getStatusCode();
		
	}

	@Then("validate the response status {string}")
	public void validate_the_response_status(String status) {
		
		int s_code = Integer.parseInt(status);
		response.then().log().body();
		Assert.assertEquals(responseStatus, s_code, "Enter valid URI");
		
	}
	
	
}
