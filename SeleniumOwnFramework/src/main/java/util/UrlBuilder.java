package util;

public class UrlBuilder {

    public static String setUrlParams(String firstParam, String secondParam, String url) {
        String first = TestDataManager.getTestData(firstParam);
        String second = TestDataManager.getTestData(secondParam);
        String urlName = url.replace("https://", "").replace("http://", "");
        return "http://" + first + ":" + second + "@" + urlName;
    }
}
