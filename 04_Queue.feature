Feature: Functionality of Queue Page

  Background: User must log into the DSAlgo website and navigate to the Queue page
    # https://dsportalapp.herokuapp.com/login
    Given Login to DsAlsgo website with valid username "numpyninja@123" and password "Qwerty@123" and navigate to Queue page.

  @tag1
  Scenario Outline: validate all the options inside Queue page.
    When user clicks on "<Page name>" with the corresponding "<URL>"
    Then user must be directed to "<URL>"
    And click on Tryhere button and click the run button.

    Examples: 
      | Page name                              | URL                                                                 |
      | Implementation of Queue in Python      | https://dsportalapp.herokuapp.com/queue/implementation-lists/       |
      | Implementation using collections.deque | https://dsportalapp.herokuapp.com/queue/implementation-collections/ |
      | Implementation using array             | https://dsportalapp.herokuapp.com/queue/Implementation-array/       |
      | Queue Operations                       | https://dsportalapp.herokuapp.com/queue/QueueOp/                    |

  @tag2
  Scenario Outline: Practice question validation
    Given User navigates to Implementation of Queue in Python page.
    When user clicks on "<Page name>" with the corresponding "<URL>"
    Then user must be directed to "<URL>"
    
    Examples:
    
      | Page name                  | URL                                              |
      | Practice Questions         | https://dsportalapp.herokuapp.com/queue/practice |
     