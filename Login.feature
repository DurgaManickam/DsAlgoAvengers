Feature: Testing Login functionality with valid and invalid data

  Background: 
    Given User must launch a browser and navigate to the DSAlgo website
   When User clicks on Get started button
    Then User navigates to Signin Page

  @runBoth
  Scenario Outline: Try to Login successfully with valid and invalid credentials.
    When User enters "<username>" and "<password>"
    And click on Login button
    Then User must navigate to Home Page with the message "You are logged in" and with the user name on the top

    Examples: 
      | username       | password   |
     | numpyninja@123 | Qwerty@123 |
   |                | Qwerty@123    |
     | numpyninja@123 |               |
   # | user@123       | wrongpasscode |
   # | ninja          | Qwerty@123    |
   # | numpyninja@123 | wrongcode     |
   # |                |               |
