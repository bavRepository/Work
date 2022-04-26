package com.jsonplaceholder.typicode.utils;

import java.util.HashMap;
import java.util.Map;

public class TestData {

    public static final String POST_USERID_99 = FileManager.getParameterValue("testData","post99UserId");
    public static final String POST_ID_99 = FileManager.getParameterValue("testData","post99Id");
    public static final String POST_ID_150 = FileManager.getParameterValue("testData","post150Id");
    public static final String USER_ID_5 = FileManager.getParameterValue("testData","userId5");
    public static final String USER_ID_1 = FileManager.getParameterValue("testData","userId1");
    public static final int RANDOM_STR_LENGTH = Integer.valueOf(FileManager.getParameterValue("testData","randomStrLength"));


    private static Map<String , Object> body;

    public static Map getPostFielsData(){
        body = new HashMap<>();
        body.put("title", DataMathWork.getRandomStringValue(RANDOM_STR_LENGTH));
        body.put("body", DataMathWork.getRandomStringValue(RANDOM_STR_LENGTH));
        body.put("userId", USER_ID_1);
        return body;
    }

    public static Map getRouteParam(String keyOfParam ,String valueOfParam){
        body = new HashMap<>();
        body.put(keyOfParam, valueOfParam);
        return body;
    }
}
