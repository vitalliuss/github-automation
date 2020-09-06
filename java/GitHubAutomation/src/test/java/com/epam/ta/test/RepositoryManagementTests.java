package com.epam.ta.test;

import com.epam.ta.model.Repository;
import com.epam.ta.model.User;
import com.epam.ta.page.LoginPage;
import com.epam.ta.service.UserCreator;
import com.epam.ta.util.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class RepositoryManagementTests extends CommonConditions {
    protected static final int REPOSITORY_NAME_POSTFIX_LENGTH = 6;
    protected static final String REPOSITORY_DESCRIPTION = "auto-generated test repo";
    protected static final String REPOSITORY_DESCRIPTION_LONG = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    @Test(description = "JIRA-7566")
    public void oneCanCreateProject()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        String expectedRepositoryName = StringUtils.generateRandomRepositoryNameWithPostfixLength(REPOSITORY_NAME_POSTFIX_LENGTH);
        String createdRepositoryName = new LoginPage(driver)
                .openPage()
                .login(testUser)
                .invokeNewRepositoryCreation()
                .createNewRepository(expectedRepositoryName, REPOSITORY_DESCRIPTION)
                .getCurrentRepositoryName();

        assertThat(createdRepositoryName, is(equalTo(expectedRepositoryName)));
    }

    @Test(description = "JIRA-7566")
    public void oneCanCreateProjectWithDescriptionReadMeGitignoreAndLicense()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        String expectedRepositoryName = StringUtils.generateRandomRepositoryNameWithPostfixLength(REPOSITORY_NAME_POSTFIX_LENGTH);
        Repository repository = new Repository(expectedRepositoryName, REPOSITORY_DESCRIPTION_LONG);
        repository.setPublic(false);
        repository.setGitignore("Java");
        repository.setHasReadme(false);
        repository.setLicense("Apache License 2.0");
        String createdRepositoryName = new LoginPage(driver)
                .openPage()
                .login(testUser)
                .invokeNewRepositoryCreation()
                .createNewRepository(repository)
                .getCurrentRepositoryName();

        assertThat(createdRepositoryName, is(equalTo(expectedRepositoryName)));
    }

    @Test(description = "JIRA-7567")
    public void newProjectsAreEmpty()
    {
        User testUser = UserCreator.withCredentialsFromProperty();
        String testRepositoryName = StringUtils.generateRandomRepositoryNameWithPostfixLength(REPOSITORY_NAME_POSTFIX_LENGTH);
        boolean isCurrentRepositoryEmpty = new LoginPage(driver)
                .openPage()
                .login(testUser)
                .invokeNewRepositoryCreation()
                .createNewRepository(testRepositoryName, REPOSITORY_DESCRIPTION)
                .isCurrentRepositoryEmpty();

        Assert.assertTrue(isCurrentRepositoryEmpty, "newly created repository is not empty");
    }
}
