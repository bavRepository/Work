package util;


import com.internet.herokuapp.BrowserFactory;
import org.openqa.selenium.WebDriver;
public abstract class BrowserManager {

    private static WebDriver driver = null;

    public static WebDriver getDriver(){

        if (driver == null) {
            driver = BrowserFactory.getDriver();
        }
        return driver;
    }

    public static void setDriverNull() {
        BrowserManager.driver = null;
    }

    public static String getCurrentURL() {
        Log.infoLogger("Get current Url");
        return BrowserManager.getDriver().getCurrentUrl();
    }

    public static void navigateToPreviousPage() {
        Log.infoLogger("Back to previous page");
        BrowserManager.getDriver().navigate().back();
    }

    public static void switchToDefaultWindow(){
        Log.infoLogger("Switch to default window");
        BrowserManager.getDriver().switchTo().defaultContent();
    }

    public static void navigateTo(String url){
        BrowserManager.getDriver().get(url);
    }

}
