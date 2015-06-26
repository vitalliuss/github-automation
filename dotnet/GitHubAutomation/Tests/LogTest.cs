using EPAM.ReportPortal.Client.Models;
using EPAM.ReportPortal.Client.Requests;
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
    [TestFixture]
    public class LogTest
    {
        private static readonly ILog logger = LogManager.GetLogger(typeof(LogTest));
        public static readonly string PATH_TO_SCREENSHOT = "D:\\demoScreenshot.png";

        [Test]
        public void OneCanUseLog4Net()
        {
            BasicConfigurator.Configure();
            //DOMConfigurator.Configure();

            logger.Debug("Here is a debug log.");
            logger.Info("... and an Info log.");
            logger.Warn("... and a warning.");
            logger.Error("... and an error.");
            logger.Fatal("... and a fatal error.");
        }

        [Test]
        public void OneCanUploadFileToReportPortal()
        {
            var attach = new Attach("screenshot", "image/jpeg", File.ReadAllBytes(PATH_TO_SCREENSHOT));
            var log = new AddLogItemRequest
            {
                Time = DateTime.UtcNow,
                Attach = attach,
                Level = LogLevel.Info,
                TestItemId = EPAM.ReportPortal.Shared.Bridge.Context.TestId,
                Text = "http://epam.com"
            };

            EPAM.ReportPortal.Shared.Bridge.Service.AddLogItem(log);
            //Assert.True(false);
        }

        [Test]
        public void OneCanUploadAnotherFileToReportPortal()
        {
            var attach = new Attach("screenshot", "image/jpeg", File.ReadAllBytes(PATH_TO_SCREENSHOT));
            var log = new AddLogItemRequest
            {
                Time = DateTime.UtcNow,
                Attach = attach,
                Level = LogLevel.Info,
                TestItemId = EPAM.ReportPortal.Shared.Bridge.Context.TestId,
                Text = "http://epam.com"
            };


            EPAM.ReportPortal.Shared.Bridge.Service.AddLogItem(log);
            Assert.True(false);
        }
    }
}
