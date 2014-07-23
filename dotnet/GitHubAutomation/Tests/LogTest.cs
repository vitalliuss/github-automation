using log4net;
using log4net.Config;
using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GitHubAutomation.Tests
{
    public class LogTest
    {
        private static readonly ILog logger = LogManager.GetLogger(typeof(LogTest));
        private Steps.Steps steps = new Steps.Steps();
        private const string USERNAME = "testautomationuser";
        private const string PASSWORD = "password";

        [Test]
        public void OneCanUseLog4Net()
        {
            // BasicConfigurator.Configure();
            DOMConfigurator.Configure();

            logger.Debug("Here is a debug log.");
            logger.Info("... and an Info log.");
            logger.Warn("... and a warning.");
            logger.Error("... and an error.");
            logger.Fatal("... and a fatal error.");
        }

        [Test]
        public void OneCanTakeAScreenshot()
        {
            steps.InitBrowser();
            steps.LoginGithub(USERNAME, PASSWORD);
            //steps.TakeScreenshot();
            steps.CloseBrowser();
        }
    }
}
