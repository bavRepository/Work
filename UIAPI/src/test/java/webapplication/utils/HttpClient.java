package webapplication.utils;

import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HttpClient {

    public static void setDefaultUrl(String url) {
        Unirest.config().defaultBaseUrl(url);
    }

    public static String postRequest(String route, Map<String, Object> params) {
        String response = Unirest.post(route)
                .queryString(params)
                .asString().getBody();
        return response;
    }

    public static void postRequestPutLogInTest(String route, Map<String, Object> params) {
        Unirest.post(route)
                .fields(params)
                .asEmpty();
    }

    public static void postRequestPutImageInTest(String route, Map<String, Object> params) {
        Unirest.post(route)
                .fields(params)
                .asEmpty();
    }

    public static <T> List<T> postRequestGetTests(String route, Map<String, Object> params, Class<T[]> clazz) {
        String jsonString = Unirest.post(route)
                .fields(params)
                .asString().getBody();

        T[] arr = new Gson().fromJson(jsonString, clazz);
        return Arrays.asList(arr);
    }
}
