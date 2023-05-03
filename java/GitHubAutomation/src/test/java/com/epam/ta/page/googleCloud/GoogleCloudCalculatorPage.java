package com.epam.ta.page.googleCloud;


import com.epam.ta.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GoogleCloudCalculatorPage extends BasePage {



    public GoogleCloudCalculatorPage(int timeLimit, WebDriver driver) {
        super(timeLimit,driver);
        PageFactory.initElements(this.driver, this);
        this.driver = driver;
        wait = new WebDriverWait(this.driver, timeLimit);
    }

    @FindBy(className= "md-tab")
    private WebElement computeEngine;



    @FindBy(xpath = "//*[@id=\"input_96\"]")
    private WebElement numberOfInstances;



    public void dataInput(){

        By iframeLocator = By.xpath("//*[@id=\"cloud-site\"]/devsite-iframe/iframe");
        WebElement iframeElement = driver.findElement(iframeLocator);
        driver.switchTo().frame(iframeElement);
        numberOfInstances.click();
        numberOfInstances.sendKeys("2");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }


}
