Feature: Checking the functionalities of Linkedlist page

  Background: User must log into the DSAlgo website and navigate to the Linkedlist page   
  # https://dsportalapp.herokuapp.com/login
    Given Login to DsAlsgo website with valid username "numpyninja@123" and password "Qwerty@123" and navigate to Linkedlist page.

  Scenario: Introduction section of Linkedlist page
    When The user clicks Introduction link
    Then The user should be directed to Introduction of Linked List Page

  Scenario: checking Try Here button functionality
    Given The user is in the Introduction of Linked list page
    When The user clicks Try Here button
    Then The user should be redirected to a page having an tryEditor with a Run button to test

  Scenario: Creating a Linked List Page
    When The user clicks the Creating a Linked List link
    Then The user should be directed to Creating Linked List Page

  Scenario: checking Try Here button functionality in create Linkedlist
    Given The user is in the Creating a Linked List of Linked list page
    When The user clicks Try Here button
    Then The user should be redirected to a page having an tryEditor with a Run button to test

  Scenario: Types of Linked List page
    When The user clicks the Types of Linked List link
    Then The user should be directed to Types of Linked List Page

  Scenario: Try here button in Types of Linked List page
    Given The user is in Types of Linked List page
    When The user clicks Try Here button
    Then The user should be redirected to a page having an tryEditor with a Run button to test

  Scenario: Implement Linked List in Python page
    When The user clicks the Implement Linked List in Python link
    Then The user should be directed to Implement Linked List in Python Page

  Scenario: Try here button in Implement Linked List in Python page
    Given The user is in the Implement Linked List in Python page
    When The user clicks Try Here button
    Then The user should be redirected to a page having an tryEditor with a Run button to test

  Scenario: Traversal page
    When The user clicks the Traversal link
    Then The user should be directed to Traversal Page

  Scenario: Try here button in Traversal page
    Given The user is in the Traversal page
    When The user clicks Try Here button
    Then The user should be redirected to a page having an tryEditor with a Run button to test

  Scenario: Insertion page
    When The user clicks the Insertion link
    Then The user should be directed to Insertion Page

  Scenario: Try here button in Insertion page
    Given The user is in the Insertion page
    When The user clicks Try Here button
    Then The user should be redirected to a page having an tryEditor with a Run button to test

  Scenario: Deletion page
    When The user clicks the Deletion link
    Then The user should be directed to Deletion Page

  Scenario: Try here button in Deletion page
    Given The user is in the Deletion page
    When The user clicks Try Here button
    Then The user should be redirected to a page having an tryEditor with a Run button to test

  Scenario: Practice page
    Given The user is in the Introduction of Linked list page
    When The user clicks Practice Questions link
    Then The user should be redirected to Practice page
