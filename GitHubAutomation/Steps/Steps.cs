using OpenQA.Selenium;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using GitHubAutomation.Configuration;

namespace GitHubAutomation.Steps
{
    public class Steps
    {
        IWebDriver driver = Driver.DriverInstance.GetInstance();

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
    }
}
