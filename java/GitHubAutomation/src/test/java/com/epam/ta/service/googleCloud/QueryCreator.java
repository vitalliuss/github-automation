package com.epam.ta.service.googleCloud;

import com.epam.ta.model.SearchQuery;
import com.epam.ta.service.TestDataReader;

public class QueryCreator {
    public static final String TESTDATA_GOOGLE_CLOUD_SEARCH_QUERY = "testdata.googleCloud.searchQuery";


    public static SearchQuery withQueryFromProperty(){
        return new SearchQuery(TestDataReader.getTestData(TESTDATA_GOOGLE_CLOUD_SEARCH_QUERY));
    }

    public static SearchQuery withEmptyQuery(){return new SearchQuery("");
    }

}
