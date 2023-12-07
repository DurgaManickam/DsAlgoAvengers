package hooks;

import driverFactory.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {


    @Before
    public void setUp() {

            DriverManager.getDriver();

    }

    @After
    public void tearDown() {
        // Quit WebDriver after the last scenario
        DriverManager.quitDriver();
    }
}