package com.epam.byta2016;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Vitali_Shulha on 12-Feb-16.
 */
public class LogTest {

    @Test(enabled = true)
    public void oneCanWriteMessagesToLog(){
        Logger logger = LogManager.getRootLogger();

        logger.debug("Debug message");
        logger.info("Info message");
        logger.error("Error message");
        logger.fatal("Fatal message");
        logger.warn("Warn message");
        logger.trace("Trace message");
    }


    @Test
    public void oneCanFail(){
        Assert.fail();
    }

    @Test(enabled = false)
    public void oneCanTakeScreenshotWithWebDriver(){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.reddit.com/");

        WebElement buttonLogin = driver.findElement(By.xpath("//button[text()='login']"));
        highlightElement(driver, buttonLogin);
    }

    public String takeScreenshot(WebDriver driver) {
        String path;
        try {
            File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            path = "./target/screenshots/" + source.getName();
            FileUtils.copyFile(source, new File(path));
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }

    private void highlightElement(WebDriver driver, WebElement element)
    {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        takeScreenshot(driver);
        sleep(2000); // just for demo
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }

    public void sleep(int millis)
    {
        try
        {
            Thread.sleep(millis);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
