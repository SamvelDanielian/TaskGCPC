package com.project.hardcore.framework.service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public static String getTestData(String key){
        return resourceBundle.getString(key);
    }
}
