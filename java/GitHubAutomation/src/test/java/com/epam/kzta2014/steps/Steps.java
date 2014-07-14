package com.epam.kzta2014.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.kzta2014.pages.CreateNewRepositoryPage;
import com.epam.kzta2014.pages.LoginPage;
import com.epam.kzta2014.pages.MainPage;

public class Steps
{
	private WebDriver driver;

	public void initBrowser()
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void closeDriver()
	{
		driver.quit();
	}

	public void loginGithub(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);

	}

	public boolean isLoggedIn(String username)
	{
		LoginPage loginPage = new LoginPage(driver);
		return (loginPage.getLoggedInUserName().trim().toLowerCase().equals(username));
	}

	public boolean createNewRepository(String repositoryName, String repositoryDescription)
	{
		boolean success = false;
		MainPage mainPage = new MainPage(driver);
		mainPage.clickOnCreateNewRepositoryButton();
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		String expectedRepoName = createNewRepositoryPage.createNewRepository(repositoryName, repositoryDescription);
		if (expectedRepoName.equals(createNewRepositoryPage.getCurrentRepositoryName()))
		{
			success = true;
		}
		return success;
	}

	public boolean currentRepositoryIsEmpty()
	{
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.isCurrentRepositoryEmpty();
	}

}
