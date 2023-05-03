package com.epam.ta.page;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class BasePage {

    private final Logger logger = LogManager.getRootLogger();

    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(int timelimit, WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, timelimit);
    }

    //Click Element
    protected void clickElement(By by) {
        elementIsDisplayed(by);
        driver.findElement(by).click();
    }

    public boolean elementIsDisplayed(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            driver.findElement(by);
            System.out.println("Element with Locator: " + by.toString() + " was found.");
            logger.info("Element was Working");
            return true;
        } catch (Exception e) {
            System.out.println("Element Was Not Found");
            logger.info("Element Was Not Found");
            System.out.println(e);
            Assert.fail("Element with Locator: " + by.toString() + " was not found on the page.");
            logger.error("Element with Locator: " + by.toString() + " was not found on the page.");
            return false;
        }
    }


}
