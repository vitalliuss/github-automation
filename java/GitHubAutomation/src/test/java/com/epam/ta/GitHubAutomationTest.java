package com.epam.ta;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.ta.steps.Steps;

public class GitHubAutomationTest
{
	private Steps steps;
	private final String USERNAME = "testautomationuser";
	private final String PASSWORD = "Time4Death!";
	private final int REPOSITORY_NAME_POSTFIX_LENGTH = 6;

	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.openBrowser();
	}

	@Test
	public void oneCanCreateProject()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		String repositoryName = steps.generateRandomRepositoryNameWithCharLength(REPOSITORY_NAME_POSTFIX_LENGTH);
		steps.createNewRepository(repositoryName, "auto-generated test repo");
		Assert.assertEquals(steps.getCurrentRepositoryName(), repositoryName);
	}

	@Test(description = "Login to Github")
	public void oneCanLoginGithub()
	{
		steps.loginGithub(USERNAME, PASSWORD);
		Assert.assertEquals(USERNAME, steps.getLoggedInUserName());
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeBrowser();
	}

}
