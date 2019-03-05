package com.epam.ta.test;

import com.epam.ta.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

public class CommonConditions {

    protected WebDriver driver;
    protected static final String USER_NAME = "test-automation-user";
    protected static final String USER_PASSWORD = "Time4Death!";


    @BeforeMethod()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
