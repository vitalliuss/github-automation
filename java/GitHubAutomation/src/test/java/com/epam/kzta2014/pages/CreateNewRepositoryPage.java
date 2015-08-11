package com.epam.kzta2014.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.kzta2014.utils.Utils;

public class CreateNewRepositoryPage extends AbstractPage
{
	private final String BASE_URL = "http://www.github.com/new";
	private final Logger logger = Logger.getLogger(CreateNewRepositoryPage.class);

	@FindBy(id = "repository_name")
	private WebElement inputRepositoryName;

	@FindBy(id = "repository_description")
	private WebElement inputRepositoryDescription;

	@FindBy(xpath = "//form[@id='new_repository']//button[@type='submit']")
	private WebElement butttonCreate;

	@FindBy(className = "empty-repo-setup-option")
	private WebElement labelEmptyRepoSetupOption;

	@FindBy(xpath = "//a[@data-pjax='#js-repo-pjax-container']")
	private WebElement linkCurrentRepository;

	public CreateNewRepositoryPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public boolean isCurrentRepositoryEmpty()
	{
		return labelEmptyRepoSetupOption.isDisplayed();
	}

	public String createNewRepository(String repositoryName, String repositoryDescription)
	{
		String repositoryFullName = repositoryName + Utils.getRandomString(6);
		inputRepositoryName.sendKeys(repositoryFullName);
		inputRepositoryDescription.sendKeys(repositoryDescription);
		butttonCreate.click();
		return repositoryFullName;
	}

	public String getCurrentRepositoryName()
	{
		return linkCurrentRepository.getText();
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}

}
