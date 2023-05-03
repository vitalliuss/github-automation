package com.epam.ta.page.googleCloud;


import com.epam.ta.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudResultsPage extends BasePage {

    public GoogleCloudResultsPage(int timeLimit, WebDriver driver) {
        super(timeLimit,driver);
        PageFactory.initElements(this.driver, this);
        this.driver = driver;
        wait = new WebDriverWait(this.driver, timeLimit);
    }


    @FindBy(xpath = "//*[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement search_element;

    public void ClickCalculatorResult()
    {
        search_element.click();
    }

}
