using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GitHubAutomation.Steps
{
    public class Steps
    {
        IWebDriver driver;

        public void InitBrowser()
        {
            driver = Driver.DriverInstance.GetInstance();
        }

        public void CloseBrowser()
        {
            Driver.DriverInstance.CloseBrowser();
        }

        public void LoginGithub(string username, string password)
        {
            Pages.LoginPage loginPage = new Pages.LoginPage(driver);
            loginPage.OpenPage();
            loginPage.Login(username, password);
        }

        public bool IsLoggedIn(string username)
        {
            Pages.LoginPage loginPage = new Pages.LoginPage(driver);
            return (loginPage.GetLoggedInUserName().Trim().ToLower().Equals(username));
        }

        public bool CreateNewRepository(string repositoryName, string repositoryDescription)
        {
            Pages.MainPage mainPage = new Pages.MainPage(driver);
            mainPage.ClickOnCreateNewRepositoryButton();
            Pages.CreateNewRepositoryPage createNewRepositoryPage = new Pages.CreateNewRepositoryPage(driver);
            string expectedRepoName = createNewRepositoryPage.CreateNewRepository(repositoryName, repositoryDescription);

            return expectedRepoName.Equals(createNewRepositoryPage.GetCurrentRepositoryName());
        }

        public bool CurrentRepositoryIsEmpty()
        {
            Pages.CreateNewRepositoryPage createNewRepositoryPage = new Pages.CreateNewRepositoryPage(driver);
            return createNewRepositoryPage.IsCurrentRepositoryEmpty();
        }
    }
}
