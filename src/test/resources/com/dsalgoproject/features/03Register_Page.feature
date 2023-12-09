@registerpage
Feature: Register Page
Background:
Given The user is in register page
	
#	@blankinputs
#	Scenario: Username is blank the tool tip must be validated
#	When the username fie is blank
  @validregistration
  Scenario Outline: Validate that the user registered successfully to the portal
    When The user enters selects the data from <Rownumber> in valid excel sheet
    And Clicks on Register button
    Then The user is redirected to the Home Page 
    And Validate the success message in home page.
    Examples:
    | Rownumber |
    | 0 |
    | 1 |
  
  @registerInvalidUserSheet
  Scenario Outline: Validate the invalid registration for various inputs
    When The user enters selects the data from <Rownumber> in invalid excel sheet
    And Clicks on Register button
    Then Validate the error message.
    Examples:
    | Rownumber |
    | 0 |
    | 1 |
    | 2 |
    | 3 |
    
 @registerPageLogin
  Scenario: Clicking on Login button redirects to sigin page
    When The user clicks on login button
    Then Validate that the user redirected to the login page.
    