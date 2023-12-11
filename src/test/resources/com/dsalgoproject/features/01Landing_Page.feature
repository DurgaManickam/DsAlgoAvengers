@landing
Feature: Get Started Test

  Scenario: Clicking on Get Started button in landing Page should redirect to home page
    Given The user opens DS Algo portal link
    When The user clicks the "Get Started" button
    Then The user should land in DS Algo portal page
    And The user should be redirected to homepage

