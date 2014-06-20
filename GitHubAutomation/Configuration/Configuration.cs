using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GitHubAutomation.Configuration
{
    public class Configuration
    {
        public static string GetProjectConfig(string key)
        {
            return System.Configuration.ConfigurationManager.AppSettings[key];
        }

        public static BrowserType ReadBrowserTypeFromConfig()
        {
            switch (GetProjectConfig("Browser"))
            {
                case "IE":
                    return BrowserType.IEXPLORER;
                    break;
                case "CHROME":
                    return BrowserType.CHROME;
                    break;
                default:
                    return BrowserType.FIREFOX;
                    break;
            }
        }
    }
}
