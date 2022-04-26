package webapplication.utils;

public class JsFunction {

    public static void closePopUpWindow() {
        BrowserManager.getBrowser().executeScript("window.close();");
    }
}
