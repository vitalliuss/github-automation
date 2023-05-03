package com.epam.ta.service;

import java.util.ResourceBundle;

public class TestDataReader {


    public static String environment;

    public TestDataReader(String environment) {
        this.environment = environment;
    }

    public static void setEnvironment(String environment) {
        resourceBundle = ResourceBundle.getBundle(environment);
    }
    private static ResourceBundle resourceBundle;

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
