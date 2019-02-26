package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://github.com/";

	@FindBy(xpath = "//summary[contains(@aria-label, 'Create new')]")
	private WebElement buttonCreateNew;

	@FindBy(xpath = "//a[contains(text(), 'New repository')]")
	private WebElement linkNewRepository;

	private final By linkLoggedInUserLocator = By.xpath("//meta[@name='user-login']");

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public CreateNewRepositoryPage invokeNewRepositoryCreation()
	{
		buttonCreateNew.click();
		linkNewRepository.click();
		return new CreateNewRepositoryPage(driver);
	}

	@Override
	public MainPage openPage()
	{
		driver.navigate().to(BASE_URL);
		return this;
	}

	public String getLoggedInUserName()
	{
		WebElement linkLoggedInUser = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(linkLoggedInUserLocator));
		return linkLoggedInUser.getAttribute("content");
	}
}
