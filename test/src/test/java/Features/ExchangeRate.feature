Feature: Exchange Rates Scenarios

	Background: 
	Given Go to the Rates API for Exchange rates "https://api.ratesapi.io/api/latest"
	
	Scenario: Exchange Rates API status code
		When get the response status from the API
		Then validate the status code of the response is "200" 
		
	Scenario: Exchange Rates API body
		When get the response body from the API
		Then Verify the response body is not null