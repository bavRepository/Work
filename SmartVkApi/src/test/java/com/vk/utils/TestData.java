package com.vk.utils;

public class TestData {

    public static final String LOGIN = FileManager.getParameterValue("testData","login");
    public static final String PASSWORD = FileManager.getParameterValue("testData","password");
    public static final String OWNER_ID = FileManager.getParameterValue("testData","ownerId");
    public static final String ACCESS_TOKEN = FileManager.getParameterValue("testData","accessToken");
    public static final int RANDOM_STR_LENGTH = Integer.valueOf(FileManager.getParameterValue("testData","randomStrLength"));
    public static final String UPLOAD_FILE = FileManager.getParameterValue("testData","uploadFile");
}