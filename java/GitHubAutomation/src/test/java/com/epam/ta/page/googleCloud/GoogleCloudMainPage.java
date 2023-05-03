package com.epam.ta.page.googleCloud;

import com.epam.ta.model.SearchQuery;
import com.epam.ta.page.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudMainPage extends BasePage {

    private final Logger logger = LogManager.getRootLogger();



    @FindBy(xpath = "/html/body/section/devsite-header/div/div[1]/div/div/div[2]/devsite-search/form/div[1]/div/input")
    private WebElement searchBar;


    public GoogleCloudMainPage(int timeLimit,WebDriver driver) {
        super(timeLimit,driver);
        PageFactory.initElements(this.driver, this);
        this.driver = driver;
        wait = new WebDriverWait(this.driver,timeLimit);
    }

    public void searchGoogleCloud(SearchQuery searchQuery){
        searchBar.sendKeys(searchQuery.getSearchQuery());
        searchBar.sendKeys(Keys.ENTER);
        logger.info("Search query performed");
    }


}
