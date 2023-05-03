package com.epam.ta.driver;

import com.epam.ta.page.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverSetup {
    protected BasePage basePage;
    protected WebDriver driver;
    private final Logger logger = LogManager.getRootLogger();


    @BeforeMethod(alwaysRun = true)
    public void setup() {
        logger.info("Beginning test configuration");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        ChromeDriver Chromedriver = new ChromeDriver(options);
        driver=Chromedriver;
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        basePage=new BasePage(5,driver);
        logger.info("Configuration has been successful");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        logger.info("Teardown has initialized");
        try {
            driver.quit();
            logger.info("Teardown has been completed successfully");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Teardown unsuccessful");
        }
    }
}

