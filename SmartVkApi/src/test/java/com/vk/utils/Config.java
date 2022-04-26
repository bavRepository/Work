package com.vk.utils;

public class Config {

    public static final String JSON_EXTENSION = ".json";
    public static final String BASE_URL = FileManager.getParameterValue("config","seleniumStartUrl");
    public static final String V = FileManager.getParameterValue("config","v");

}