Feature: Specific Date Exchange Rates Scenario

	Background: 
	Given API for Latest Foreign Exchange rates "https://api.ratesapi.io/api/2030-11-12"
	
	Scenario: Exchange Rates Specific Date Status Code 
		When get response status of the API
		Then validate the response status code as "200" 
		 
	Scenario: Exchange Rates Specific Date Response Body
		When get response body of API
		Then Validate the response body of API
		
	Scenario: Exchange Rates Future Date Validation
		When get the response
		Then validate date in response with current date