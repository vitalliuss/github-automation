package com.epam.ta.page;

import com.epam.ta.model.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewRepositoryPage extends AbstractPage
{
	private final String BASE_URL = "http://www.github.com/new";
	private final Logger logger = LogManager.getRootLogger();

	@FindBy(id = "repository_name")
	private WebElement inputRepositoryName;

	@FindBy(id = "repository_description")
	private WebElement inputRepositoryDescription;

	@FindBy(name = "repository[auto_init]")
	private WebElement addReadMeCheckbox;

	@FindBy(id = "repository_gitignore_template_toggle")
	private WebElement gitignoreCheckbox;

	@FindBy(xpath = "//*[@role='button']//*[contains(text(), '.gitignore template:')]")
	private WebElement gitignoreDropDown;

	@FindBy(xpath = "//input[@aria-label='Choose .gitignore type']")
	private WebElement gitignoreInput;

	@FindBy(id = "repository_license_template_toggle")
	private WebElement licenseCheckbox;

	@FindBy(xpath = "//*[@role='button']//*[contains(text(), 'License:')]")
	private WebElement licenseDropDown;

	@FindBy(xpath = "//input[@aria-label='License']")
	private WebElement licenseInput;

	@FindBy(xpath = "//input[@type='radio'][@value='public']")
	private WebElement repositoryVisibilityOptionPublic;

	@FindBy(xpath = "//input[@type='radio'][@value='private']")
	private WebElement repositoryVisibilityOptionPrivate;

	private final By buttonCreateLocator = By.xpath("//form[@id='new_repository']//button[@type='submit']");

	private final By labelEmptyRepoSetupOptionLocator = By.xpath("//h3/strong[text()='Quick setup']");

	@FindBy(xpath = "//a[@data-pjax='#js-repo-pjax-container']")
	private WebElement linkCurrentRepository;

	public CreateNewRepositoryPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public boolean isCurrentRepositoryEmpty()
	{
		WebElement labelEmptyRepoSetupOption = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until(ExpectedConditions.presenceOfElementLocated(labelEmptyRepoSetupOptionLocator));
		return labelEmptyRepoSetupOption.isDisplayed();
	}

	public CreateNewRepositoryPage createNewRepository(String repositoryName, String repositoryDescription)
	{
		inputRepositoryName.sendKeys(repositoryName);
		inputRepositoryDescription.sendKeys(repositoryDescription);
		WebElement buttonCreate = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
				.until((ExpectedConditions.elementToBeClickable(buttonCreateLocator)));
		buttonCreate.click();
		logger.info("Created repository with name: [" + repositoryName +
				"] and description: [" + repositoryDescription + "]");
		return this;
	}

	public CreateNewRepositoryPage createNewRepository(Repository repository)
	{
		inputRepositoryName.sendKeys(repository.getName());
		inputRepositoryDescription.sendKeys(repository.getDescription());

		if(repository.isPublic()){
			repositoryVisibilityOptionPublic.click();
			logger.info("Repository visibility is set to PUBLIC");
		}
		else {
			repositoryVisibilityOptionPrivate.click();
			logger.info("Repository visibility is set to PRIVATE");
		}

		if(repository.hasReadme()){
			addReadMeCheckbox.click();
			logger.info("Added README");
		}

		if(null != repository.getGitignore()){
			gitignoreCheckbox.click();
			gitignoreDropDown.click();
			gitignoreInput.sendKeys(repository.getGitignore());
			driver.findElement(By.xpath("//span[text()='" + repository.getGitignore() + "']")).click();
			logger.info(".gitignore set to " + repository.getGitignore());
		}

		if(null != repository.getLicense()){
			licenseCheckbox.click();
			licenseDropDown.click();
			licenseInput.sendKeys(repository.getLicense());
			WebElement license = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
					.until((ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(), '" + repository.getLicense() + "')]"))));
			jsClickElement(license);
			logger.info("License set to " + repository.getLicense());
		}

//		WebElement buttonCreate = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
//				.until((ExpectedConditions.elementToBeClickable(buttonCreateLocator)));
//		buttonCreate.click();

		logger.info("Created repository with name: [" + repository.getName() +
				"] and description: [" + repository.getDescription() + "]");
		return this;
	}

	public String getCurrentRepositoryName()
	{
		return linkCurrentRepository.getText();
	}

	@Override
	public CreateNewRepositoryPage openPage()
	{
		driver.navigate().to(BASE_URL);
		return this;
	}

}
