@login
Feature: Testing Login functionality with valid and invalid data

  Background: User must be in Login Page
    Given User must launch a browser and navigate to the DSAlgo website.
    When User clicks on Get started button
    Then User navigates to Signin Page

  Scenario Outline: Try to Login successfully with valid and invalid credentials.
    When User enters "<username>" and "<password>"
    And click on Login button
    And validate logins "<username>" and "<password>"
    Then Valid User must navigate to Home Page with the message "You are logged in" and with the username "<username>" on the top

    Examples: 
      | username       | password      |
      | numpyninja@123 | Qwerty@123    |
      |                | Qwerty@123    |
      | numpyninja@123 |               |
      | user@123       | wrongpasscode |
      | ninja          | Qwerty@123    |
      | numpyninja@123 | wrongcode     |
      |                |               |
      | invalid        | Qwerty@123    |