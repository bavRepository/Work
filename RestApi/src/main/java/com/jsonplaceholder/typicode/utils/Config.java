package com.jsonplaceholder.typicode.utils;

public class Config {

    public static final String JSON_EXTENSION = ".json";
    public static final String POSTS = FileManager.getParameterValue("config","posts");
    public static final String USERS = FileManager.getParameterValue("config","users");

    public static final String FILE1 = FileManager.getParameterValue("config","case1FilePath");
    public static final String FILE2 = FileManager.getParameterValue("config","case2FilePath");
    public static final String FILE3 = FileManager.getParameterValue("config","case3FilePath");
    public static final String FILE4 = FileManager.getParameterValue("config","case4FilePath");
    public static final String FILE5 = FileManager.getParameterValue("config","case5FilePath");
    public static final String FILE6 = FileManager.getParameterValue("config","case6FilePath");
    public static final String ROUTE_ID_PARAM = FileManager.getParameterValue("config","routeParam");
}
