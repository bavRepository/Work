package webapplication.utils;

public class UrlBuilder {

    public static String setUrlParams(String url) {
        String login = TestData.LOGIN;
        String password = TestData.PASSWORD;
        String urlName = url.replace("https://", "").replace("http://", "");
        return String.format("http://%s:%s@%s",login,password,urlName);
    }
}
