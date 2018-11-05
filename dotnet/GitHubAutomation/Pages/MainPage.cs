using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium.Support.PageObjects;
using OpenQA.Selenium;

namespace GitHubAutomation.Pages
{
    public class MainPage
    {
        private const string BASE_URL = "http://www.github.com/";

        [FindsBy(How = How.XPath, Using = "//summary[@aria-label='Create new…']")]
        private IWebElement buttonCreateNew;

        [FindsBy(How = How.XPath, Using = "//a[contains(text(), 'New repository')]")]
        private IWebElement linkNewRepository;

        private IWebDriver driver;

        public MainPage(IWebDriver driver)
        {
            this.driver = driver;
            PageFactory.InitElements(this.driver, this);
        }

        public void OpenPage()
        {
            driver.Navigate().GoToUrl(BASE_URL);
        }

        public void ClickOnCreateNewRepositoryButton()
        {
            buttonCreateNew.Click();
            linkNewRepository.Click();
        }

    }
}
