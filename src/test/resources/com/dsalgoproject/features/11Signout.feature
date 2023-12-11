@signout
Feature: Validate Signout functionality.

  Background: User must log into the DSAlgo website.
     https://dsportalapp.herokuapp.com/login
    Given Login to DsAlsgo website with valid username "numpyninja@123" and password "Qwerty@123" for validating signout button.

  Scenario: 
    When user clicks on signout button.
    Then user must be logged out and navigate to Home page"https://dsportalapp.herokuapp.com/home".