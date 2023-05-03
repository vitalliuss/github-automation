package com.epam.ta.service;

import java.util.ResourceBundle;

public class TestDataReader {


    public static String environment;

    public TestDataReader(String environment) {
        this.environment = environment;
    }

    private static ResourceBundle resourceBundle;

    public static void setEnvironment(String environment) {
        resourceBundle = ResourceBundle.getBundle(environment);
    }


    //Remove comment below & also comment out lines 14 - 18 in order to execute tests via command line in older version
    //private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));



    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
