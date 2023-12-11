package com.dsalgoproject.utilities;

/**
 * Class that contains the CONSTANTS to be used in the project
 */
public final class AppConstants {
	public static final String CURRENT_DIRECTORY = System.getProperty("user.dir");
	// Landing page is the Main page which has Get Started button
	public static final String LANDING_PAGE_URL = "https://dsportalapp.herokuapp.com/";
	// HOME page consists of all the options
	public static final String HOME_PAGE_URL = LANDING_PAGE_URL + "home";
	public static final String REGISTER_URL = LANDING_PAGE_URL + "register";
	public static final String SIGN_IN_URL = LANDING_PAGE_URL + "login";
	// Array page url's
	public static final String ARRAY_PAGE_URL = LANDING_PAGE_URL + "array/";
	public static final String ARRAY_PAGE_PYTHON_URL = ARRAY_PAGE_URL + "arrays-in-python/";
	public static final String ARRAY_PAGE_USING_LIST_URL = ARRAY_PAGE_URL + "arrays-using-list/";
	public static final String ARRAY_PAGE_BASIC_OPERATIONS_URL = ARRAY_PAGE_URL + "basic-operations-in-lists/";
	public static final String ARRAY_PAGE_APP_OF_ARRAY_URL = ARRAY_PAGE_URL + "applications-of-array/";
	public static final String ARRAY_PAGE_PRACTICE = ARRAY_PAGE_URL + "practice";
	public static final String TRY_EDITOR_URL = LANDING_PAGE_URL + "tryEditor";
	// Test data files
	public static final String TEST_DATA_EXCEL_PATH = CURRENT_DIRECTORY
			+ "/src/test/resources/com/dsalgoproject/testData/dsAlgoTestData.xlsx";
	public static final String REGISTER_VALID_USER_TEST_SHEET = "registerValidUserSheet";
	public static final String REGISTER_INVALID_USER_TEST_SHEET = "registerInvalidUserSheet";
	public static final String ARRAY_PRACTICE_QUES_ANSWER_SHEET = "practiceQuestionSheet";
	public static final String CONFIG_PROPERTIES_FILE_NAME = CURRENT_DIRECTORY
			+ "/src/test/resources/com/dsalgoproject/testData/configData.properties";
	public static final String username = "numpyninja@123";
	public static final String password = "Qwerty@123";

}
