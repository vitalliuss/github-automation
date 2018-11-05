using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;

namespace GitHubAutomation.Pages
{
    public class CreateNewRepositoryPage
    {
        private const string BASE_URL = "http://www.github.com/new";
        private IWebDriver driver;

        [FindsBy(How = How.Id, Using = "repository_name")]
        private IWebElement inputRepositoryName;

        [FindsBy(How = How.Id, Using = "repository_description")]
        private IWebElement inputRepositoryDescription;
        
        [FindsBy(How = How.XPath, Using = "//form[@id='new_repository']//button[@type='submit']")]
        private IWebElement butttonCreate;

        [FindsBy(How = How.ClassName, Using = "//h3/strong[text()='Quick setup']")]
        private IWebElement labelEmptyRepoRecommendations;

        [FindsBy(How = How.XPath, Using = "//a[@data-pjax='#js-repo-pjax-container']")]
        private IWebElement linkCurrentRepository;


        public CreateNewRepositoryPage(IWebDriver driver)
        {
            this.driver = driver;
            PageFactory.InitElements(this.driver, this);
        }

        public void OpenPage()
        {
            driver.Navigate().GoToUrl(BASE_URL);
        }

        public void CreateNewRepository(string repositoryName, string repositoryDescription)
        {
            inputRepositoryName.SendKeys(repositoryName);
            inputRepositoryDescription.SendKeys(repositoryDescription);
            butttonCreate.Click();
        }

        public bool IsCurrentRepositoryEmpty()
        {
            return labelEmptyRepoRecommendations.Displayed;
        }

        public string GetCurrentRepositoryName()
        {
            return linkCurrentRepository.Text;
        }

    }
}
