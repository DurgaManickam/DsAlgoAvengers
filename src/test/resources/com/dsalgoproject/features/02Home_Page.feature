@home
Feature: Home Page
Background:
Given The user is on the Home Page

  Scenario: Check the number of options listed in the home page
    When The user is in home page
    Then The user should see 7 panes with different data structures
    
  Scenario: Clicking on Data Structures drop down should display 6 options
    When The user clicks "Data Structures" drop down
    Then The user should see 6 different data structure entries in that dropdown
    
  Scenario Outline: User is in home page, selecting the dropdown "<option>" without sign in displays the error message
    When The user selects "<option>" data structures from the drop down without Sign in.
    Then It should alert the user with a message "You are not logged in" 
 
 		Examples:
      | option     |
      | Arrays     |
      | Linked List |
      | Stack      |
      | Queue      |
      | Tree       |
      | Graph      |
      
  Scenario Outline: User is in home page, selecting the "Get Started" under the pane "<option>" without sign in displays the error message
    When The user clicks any of the "Get Started" buttons below the data structures "<option>"
    Then Display the messsage "You are not logged in"
    Examples:
      | option     |
      | Data Structures-Introduction     |
      | Array     |
      | Linked List |
      | Stack      |
      | Queue      |
      | Tree       |
      | Graph      |
     
  Scenario: Clicking on "Register" redirects to Register form
    When The user clicks "Register"
    Then The user should be redirected to Register form
  
  @home @signin 
  Scenario: Clicking on "Sign in" redirects to Sign in form
    When The user clicks "Sign in"
    Then The user should be redirected to Sign in form
   
    
  
    