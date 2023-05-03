package com.epam.ta.test.googleCloudTests;

import com.epam.ta.driver.DriverSetup;
import com.epam.ta.model.SearchQuery;
import com.epam.ta.page.googleCloud.GoogleCloudCalculatorPage;
import com.epam.ta.page.googleCloud.GoogleCloudMainPage;
import com.epam.ta.page.googleCloud.GoogleCloudResultsPage;
import com.epam.ta.service.TestDataReader;
import com.epam.ta.service.googleCloud.QueryCreator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class calculatorTest extends DriverSetup {

    public static final String TESTDATA_GOOGLE_CLOUD_MAIN_PAGE = "testdata.googleCloud.mainPage";
    public static final String TESTDATA_GOOGLE_CLOUD_CALCULATOR_PAGE = "testdata.googleCloud.calculatorPage";

    GoogleCloudMainPage googleCloudMainPage;
    GoogleCloudResultsPage googleCloudResultsPage;
    GoogleCloudCalculatorPage googleCloudCalculatorPage;
    TestDataReader testDataReader;

    @BeforeMethod
    public void setUp(){
        testDataReader.setEnvironment("googleCloud");
        googleCloudMainPage = new GoogleCloudMainPage(5,driver);
        googleCloudResultsPage = new GoogleCloudResultsPage(5,driver);
        googleCloudCalculatorPage = new GoogleCloudCalculatorPage(5,driver);
        driver.get(TestDataReader.getTestData(TESTDATA_GOOGLE_CLOUD_MAIN_PAGE));
    }


    @Test
    public void queryAndPageTest(){
        SearchQuery query = QueryCreator.withQueryFromProperty();
        googleCloudMainPage.searchGoogleCloud(query);
        googleCloudResultsPage.ClickCalculatorResult();
        assertThat(driver.getCurrentUrl(), is(equalTo(TestDataReader.getTestData(TESTDATA_GOOGLE_CLOUD_CALCULATOR_PAGE))));

    }
}
