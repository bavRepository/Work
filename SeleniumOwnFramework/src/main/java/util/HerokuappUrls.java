package util;


public class HerokuappUrls {

    private static final String BASIC_URL = ConfigManager.getParam("baseUrl");

    public static void navigateToHerokuapp(String pageName){
        BrowserManager.navigateTo(BASIC_URL + pageName);
    }

    public static void navigateToHerokuapp(String firstParam, String secondParam, String pageName){
        BrowserManager.navigateTo(UrlBuilder.setUrlParams(firstParam, secondParam, BASIC_URL + pageName));
    }
}
