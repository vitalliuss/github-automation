using EPAM.ReportPortal.Addins.NUnit;
using NUnit.Core.Extensibility;

namespace GitHubAutomation.ReportPortalIntegration
{
    [NUnitAddin]
    public class CustomAddin: IAddin
    {
        public bool Install(IExtensionHost host)
        {
			if (ReportPortalAddin.InstalledAddin == null)
			{
				new ReportPortalAddin().Install(host);

				// subscribe on ReportPortalAddin.InstalledAddin events here
			}
			
            return true;
        }
    }
}
