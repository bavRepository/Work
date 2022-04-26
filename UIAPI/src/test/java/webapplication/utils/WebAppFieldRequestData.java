package webapplication.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WebAppFieldRequestData {

    private static Map<String , Object> paramsSave;

    public static Map getTokenRequestParam(){
        paramsSave = new HashMap<>();
        paramsSave.put(ApiRouteParamNameEnum.VARIANT.getValue(), TestData.VARIANT);
        return paramsSave;
    }

    public static Map getTestsRequestParam(String projectId){
        paramsSave = new HashMap<>();
        paramsSave.put(ApiRouteParamNameEnum.PROJECT_ID.getValue(), projectId);
        return paramsSave;
    }

    public static Map putTestRequestParam(String testName, String methodName, String startTime){
        paramsSave = new HashMap<>();
        paramsSave.put(ApiRouteParamNameEnum.SID.getValue(), TestData.SID);
        paramsSave.put(ApiRouteParamNameEnum.PROJECT_NAME.getValue(), TestData.PROJECT_NAME);
        paramsSave.put(ApiRouteParamNameEnum.TEST_NAME.getValue(), testName);
        paramsSave.put(ApiRouteParamNameEnum.METHOD_NAME.getValue(), methodName);
        paramsSave.put(ApiRouteParamNameEnum.ENV.getValue(), Config.SYSTEM_USER_NAME);
        paramsSave.put(ApiRouteParamNameEnum.START_TIME.getValue(), startTime);
        paramsSave.put(ApiRouteParamNameEnum.BROWSER.getValue(), Config.BROWSER_NAME);
        return paramsSave;
    }

    public static Map putLogInTestGetRequestParam(String testId, String content){
        paramsSave = new HashMap<>();
        paramsSave.put(ApiRouteParamNameEnum.TEST_ID.getValue(), testId);
        paramsSave.put(ApiRouteParamNameEnum.CONTENT.getValue(), content);
        return paramsSave;
    }

    public static Map putImageInTestGetRequestParam(String testId) throws IOException {
        paramsSave = new HashMap<>();
        paramsSave.put(ApiRouteParamNameEnum.TEST_ID.getValue(), testId);
        paramsSave.put(ApiRouteParamNameEnum.CONTENT.getValue(), FileIManager.getScreenShot());
        return paramsSave;
    }
}
