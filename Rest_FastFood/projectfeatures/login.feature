Feature: The Login Page
					As a regisred customer I want to
					login to the application
	
	Background:
	Given the user is on the login page	
	
	Scenario Outline: the user should be able to login
		When the user enters "<username>" and "<password>"
		And the user clicks on login button
		Then the "<name>" should be logged in
		
	Examples:
	| username	| password | name|
	| test@test.com		| pass | testName|
	
	Scenario Outline: the user should not be able to login with the wrong password
										or username
		When the user enters "<username>" and "<password>"
		And the user clicks on the login button
		Then the user should get  "<message>" authentication failed
	
	Examples:
	|username|password|message|
	|test@test.com|pass|Authentication failed.|
