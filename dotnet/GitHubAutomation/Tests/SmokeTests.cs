using NUnit.Framework;

namespace GitHubAutomation
{
    [TestFixture]
    public class SmokeTests
    {
        private Steps.Steps steps = new Steps.Steps();
        private const string USERNAME = "testautomationuser";
        private const string PASSWORD = "Time4Death!";

        [SetUp]
        public void Init()
        {
            steps.InitBrowser();
        }

        [TearDown]
        public void Cleanup()
        {
            steps.CloseBrowser();
        }

        [Test]
        public void OneCanLoginGithub()
        {
            steps.LoginGithub(USERNAME, PASSWORD);
            Assert.True(steps.IsLoggedIn(USERNAME));
        }

        [Test]
        public void OneCanCreateProject()
        {
            steps.LoginGithub(USERNAME, PASSWORD);
            Assert.IsTrue(steps.CreateNewRepository("testRepo", "auto-generated test repo"));
            Assert.IsTrue(steps.CurrentRepositoryIsEmpty());
        }
    }
}
