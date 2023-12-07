#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#@registerpage
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
    