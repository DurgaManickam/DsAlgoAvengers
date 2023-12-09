@array
Feature: Arrays Page
  Background: User must log into the DSAlgo website and navigate to the Array page   
  # https://dsportalapp.herokuapp.com/login
  Given Login to DsAlsgo website with valid username "numpyninja@123" and password "Qwerty@123" and navigate to Array page.

	@array1
  Scenario Outline: Clicking on "<option>" button should redirect to the <option> page
    Given The user is on the Array Page after logged in
    When The user clicks "<option>" button
    Then The user should be redirected to "<destinationUrl>" page

    Examples: 
      | option                   | destinationUrl |
      | Arrays in Python       |  https://dsportalapp.herokuapp.com/array/arrays-in-python/ |
      | Arrays using List        | https://dsportalapp.herokuapp.com/array/arrays-using-list/ |
      | Basic Operations in List | https://dsportalapp.herokuapp.com/array/basic-operations-in-lists/ |
      | Applications of Array    | https://dsportalapp.herokuapp.com/array/applications-of-array/ |

	@array2
  Scenario Outline: Clicking on TryHere button should redirect to the tryeditor page and validate the output
    Given The user is in the "<option>" page after clicking on the option
    When The user clicks "Try Here" button in "<option>" page
    Then The user will be redirected to a page having an tryEditor with a Run button to test

    Examples: 
      | option                   |
      | Arrays in Python         |
      | Arrays using List        |
      | Basic Operations in List |
      | Applications of Array    |
      
  @array3
  Scenario Outline: Passing different valid input to TryEditor and clicking on Run button and Validate the result
    Given The user is in the TryEditor page
    When The user passes "<inputString>" to textarea and click Run button
    Then Validate the "<outputString>" with actual result

    Examples: 
      | inputString				 | outputString |
      | print \'hello\'        | hello |
      |x = 5\ny = 10\nprint(x + y) | 15|
      
   @array4
  Scenario Outline: Passing different invalid input to TryEditor and clicking on Run button should display a alert
    Given The user is in the TryEditor page
    When The user passes "<inputString>" to textarea and click Run button
    Then Validate the alert box "<expectedOutputString>"  
      
    Examples:
      | inputString | expectedOutputString |
      | pri 123 | SyntaxError: bad input on line 1 |
      | hello | NameError: name 'hello' is not defined on line 1 |
      
  @arrayInvalidNumberAsInputToTextEditor @usindDataTable
  Scenario: Passing number as input to TryEditor and clicking on Run button should display a alert
    Given The user is in the TryEditor page
    When The user passes input as number to textarea and click Run button
  	| 1234 | 
  Then The output should be null
   | |
  
       
	@arrayPracticeQuestion
  Scenario: Clicking on "Practice Questions" button should redirect to the "Practice Questions" page
    Given The user is on any of the links in the Array Page after logged in
    When The user clicks "Practice Questions" button
    Then The user should be redirected to page
    | https://dsportalapp.herokuapp.com/array/practice |

	@gotoQuestionPage
  Scenario Outline: Clicking on "<question>" button should redirect to the respective "<question>" page
    Given The user is in the Practice page
    When The user clicks the "<question>" link
    And enters answer from excelfile for <RowNumber> in tryEditor
    And clickRun button 
    And clickSubmit button
    Then Validate the runoutput
    And Validate the submitoutput

    Examples: 
      | question                                | RowNumber |
      | Search the array                        | 0 |
      #| Search the array                        | 1 |
      #| Max Consecutive Ones                    | 2 |
      | Max Consecutive Ones                    | 3 |
      #| Find Numbers with Even Number of Digits | 4 |
      #| Find Numbers with Even Number of Digits | 5 |
      #| Squares of a  Sorted Array              | 6 |
      #| Squares of a  Sorted Array              | 7 |
      
      
