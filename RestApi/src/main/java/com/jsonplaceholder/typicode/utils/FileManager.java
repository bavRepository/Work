package com.jsonplaceholder.typicode.utils;

import aquality.selenium.core.logging.Logger;

public class FileManager {

    public static String getParameterValue(String fileName, String key) {
        return Environment.getCurrentJsonFile(String.format(fileName.concat("%s"),Config.JSON_EXTENSION)).getValue(String.format("/%s", key)).toString();
    }
}
