using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GitHubAutomation.Pages
{
    public class CreateNewRepositoryPage : AbstractPage
    {
        private const string BASE_URL = "http://www.github.com/new";
        private IWebDriver driver;

        [FindsBy(How = How.Id, Using = "repository_name")]
        private IWebElement inputRepositoryName;

        [FindsBy(How = How.Id, Using = "repository_description")]
        private IWebElement inputRepositoryDescription;
        
        [FindsBy(How = How.XPath, Using = "//form[@id='new_repository']//button[@type='submit']")]
        private IWebElement butttonCreate;

        [FindsBy(How = How.ClassName, Using = "empty-repo-recommendations")]
        private IWebElement labelEmptyRepoRecommendations;

        [FindsBy(How = How.ClassName, Using = "js-current-repository")]
        private IWebElement linkCurrentRepository;


        public CreateNewRepositoryPage(IWebDriver driver)
        {
            this.driver = driver;
            PageFactory.InitElements(this.driver, this);
        }

        public override void OpenPage()
        {
            driver.Navigate().GoToUrl(BASE_URL);
        }

        public string CreateNewRepository(string repositoryName, string repositoryDescription)
        {
            string repositoryFullName = repositoryName + Utils.RandomGenerator.GetRandomString(6);
            inputRepositoryName.SendKeys(repositoryFullName);
            inputRepositoryDescription.SendKeys(repositoryDescription);
            butttonCreate.Click();
            return repositoryFullName;
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
