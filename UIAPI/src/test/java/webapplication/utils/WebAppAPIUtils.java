package webapplication.utils;
import webapplication.model.TestTable;
import java.io.IOException;
import java.util.List;

public class WebAppAPIUtils extends HttpClient {

    public static String getToken() {
        return postRequest(APIMethodEnum.GET_TOKEN.getValue(), WebAppFieldRequestData.getTokenRequestParam());
    }

    public static String putTest(String testName, String methodName, String startTime) {
        return postRequest(APIMethodEnum.PUT_TEST.getValue(), WebAppFieldRequestData.putTestRequestParam(testName, methodName, startTime));
    }

    public static void putLogInTest(String testId, String content) {
        postRequestPutLogInTest(APIMethodEnum.PUT_LOG_IN_TEST.getValue(), WebAppFieldRequestData.putLogInTestGetRequestParam(testId, content));
    }

    public static void putImageInTest(String testId) throws IOException {
        postRequestPutImageInTest(APIMethodEnum.PUT_IMAGE_IN_TEST.getValue(), WebAppFieldRequestData.putImageInTestGetRequestParam(testId));
    }

    public static <T> List<T> getTestList(String projectId) {
        return postRequestGetTests(APIMethodEnum.GET_TESTS.getValue(), WebAppFieldRequestData.getTestsRequestParam(projectId), TestTable[].class);
    }

    public static boolean isTokenExist(String token) {
        return !token.isEmpty();
    }
}
