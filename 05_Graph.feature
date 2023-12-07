Feature: Functionality of Graph Page

  Background: User must log into the DSAlgo website and navigate to the Graph page
    # https://dsportalapp.herokuapp.com/login
    Given Login to DsAlsgo website with valid username "numpyninja@123" and password "Qwerty@123" and navigate to Graph page.

  @tag1
  Scenario Outline: validate all the options inside Queue page.
    When user clicks on "<Page name>" with the corresponding "<URL>"
    Then user must be directed to "<URL>"
    And click on Tryhere button and click the run button.

    Examples: 
      | Page name             | URL                                                            |
      | Graph                 | https://dsportalapp.herokuapp.com/graph/graph/                 |
      | Graph Representations | https://dsportalapp.herokuapp.com/graph/graph-representations/ |

  @tag2
  Scenario Outline: Practice question validation
    Given User navigates to Graph Representations.
    When user clicks on "<Page name>" with the corresponding "<URL>"
    Then user must be directed to "<URL>"

    Examples: 
      | Page name          | URL                                              |
      | Practice Questions | https://dsportalapp.herokuapp.com/graph/practice |
