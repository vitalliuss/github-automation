using OpenQA.Selenium;
using OpenQA.Selenium.Support.PageObjects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GitHubAutomation.Pages
{
    public class LoginPage
    {
        private const string BASE_URL = "https://github.com/login";

        [FindsBy(How = How.Id, Using = "login_field")]
        private IWebElement inputLogin;

        [FindsBy(How = How.Id, Using = "password")]
        private IWebElement inputPassword;

        [FindsBy(How = How.XPath, Using = "//input[@value='Sign in']")]
        private IWebElement buttonSubmit;
        
        [FindsBy(How = How.XPath, Using = "//span[@aria-label='Switch account context']/span")]
        private IWebElement linkLoggedInUser;

        private IWebDriver driver;

        public LoginPage(IWebDriver driver)
        {
            this.driver = driver;
            PageFactory.InitElements(this.driver, this);
        }

        public void OpenPage()
        {
            driver.Navigate().GoToUrl(BASE_URL);
            Console.WriteLine("Login Page opened");
        }

        public void Login(string username, string password)
        {
            inputLogin.SendKeys(username);
            inputPassword.SendKeys(password);
            buttonSubmit.Click();
        }

        public string GetLoggedInUserName()
        {
            return linkLoggedInUser.Text;
        }
    }
}
