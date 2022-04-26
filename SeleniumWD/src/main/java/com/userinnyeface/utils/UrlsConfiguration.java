package com.userinnyeface.utils;

public class UrlsConfiguration {

    public static String getStartUrl() {
        return FileConfiguration.getParameterValue("config.json","startUrl");
    }
}