package com.epam.kzta2014.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage
{
	private final Logger logger = Logger.getLogger(LoginPage.class);
	private final String BASE_URL = "https://github.com/login";

	@FindBy(id = "login_field")
	private WebElement inputLogin;

	@FindBy(id = "password")
	private WebElement inputPassword;

	@FindBy(xpath = "//input[@value='Sign in']")
	private WebElement buttonSubmit;

	@FindBy(xpath = "//ul[@id='user-links']//a")
	private WebElement linkLoggedInUser;

	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Login page opened");
	}

	public void login(String username, String password)
	{
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		buttonSubmit.click();
		logger.info("Login performed");
	}

	public String getLoggedInUserName()
	{
		return linkLoggedInUser.getText();
	}

}
