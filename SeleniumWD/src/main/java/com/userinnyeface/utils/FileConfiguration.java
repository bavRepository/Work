package com.userinnyeface.utils;

import aquality.selenium.core.logging.Logger;

public class FileConfiguration {

    public static String getParameterValue(String fileName, String key) {
        Logger.getInstance().info("Get parameter " + key + " value");
        return Environment.getCurrentJsonFile(String.format(fileName.concat("%s"),FilePathManager.JSON_EXTENSION)).getValue(String.format("/%s", key)).toString();
    }

}