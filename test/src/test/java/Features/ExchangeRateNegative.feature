Feature: Exchange Rate Negative Scenario

	Scenario: Validate status code for incorrect URI
		Given the API "https://api.ratesapi.io/api/"
		When get status of incorrect API
		Then validate the response status "400"