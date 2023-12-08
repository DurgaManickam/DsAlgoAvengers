Feature: Functionality of DataStructures Page

  Background: User must log into the DSAlgo website and navigate to the DataStructures page
    # https://dsportalapp.herokuapp.com/login
    Given Login to DsAlsgo website with valid username "numpyninja@123" and password "Qwerty@123" and navigate to DataStructures page.

  @tag1
  Scenario Outline: validate all the options inside DataStructures page.
    When user in DS page clicks on "<Page name>" with the corresponding "<URL>"
    Then user must be directed to "<URL>" of DS page
    And click on Tryhere button in DS page and click the run button.

    Examples: 
      | Page name       | URL                                                                             |
      | Time Complexity | https://dsportalapp.herokuapp.com/data-structures-introduction/time-complexity/ |

  @tag2
  Scenario Outline: Practice question validation
    Given User navigates to DataStructures Time complexity page.
    When user in DS page clicks on "<Page name>" with the corresponding "<URL>"
    Then user must be directed to "<URL>" of DS page

    Examples: 
      | Page name          | URL                                                                     |
      | Practice Questions | https://dsportalapp.herokuapp.com/data-structures-introduction/practice |
