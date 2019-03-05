package com.epam.ta.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {

    protected WebDriver driver;
    protected static final String USER_NAME = "test-automation-user";
    protected static final String USER_PASSWORD = "Time4Death!";
    private static final String RESOURCES_PATH = "src\\test\\resources\\";


    @BeforeMethod()
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", RESOURCES_PATH + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        driver.quit();
    }
}
