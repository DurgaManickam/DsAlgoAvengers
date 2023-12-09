@stack
Feature: Functionalities of Stack Page

  #https://dsportalapp.herokuapp.com/stack/
  Background: User must login into DSAlgo website and navigate to Stack page.
    Given Login DsAlsgo website with valid username "numpyninja@123" and password "Qwerty@123" and Navigate to Stack page.
   

  @allTest
  Scenario: Operations in Stack
    When The user clicks on Operations in Stack link.
    Then The user must be directed to Operations in Stack page.

  @tag2
  Scenario: TryHere button in  Operations in Stack
    Given The user is in Operations in Stack page.
    When The user clicks on TryHere button.
    Then The user should be redirected to a page having an tryEditor with a Run button to test.

  @allTest
  Scenario: Implementation in Stack
    
    When The user clicks on Implementation link.
    Then The user must be directed to Implementation in Stack page.

  @tag4
  Scenario: TryHere button in  Implementation in Stack
    Given The user is in Implementation in Stack page.
    When The user clicks on TryHere button.
    Then The user should be redirected to a page having an tryEditor with a Run button to test.

  @allTest
  Scenario: Applications of Stack
   
    When The user clicks on Applications link.
    Then The user must be directed to Applications in Stack page.

  @tag6
  Scenario: TryHere button in  Applications in Stack
    Given The user is in Applications in Stack page.
    When The user clicks on TryHere button.
    Then The user should be redirected to a page having an tryEditor with a Run button to test.

  @tag7
  Scenario: Practice Questions of Stack
    Given The user is in Operations in Stack page after logging in.
    When The user clicks on Practice Questions link.
    Then The user must be directed to Practice Questions page of Stack.