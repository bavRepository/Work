package webapplication.utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class BrowserManager {

    public static Browser getBrowser() {
        return AqualityServices.getBrowser();
    }

    public static void addTokenCookie(String token) {
        BrowserManager.getBrowser().getDriver().manage().addCookie(new Cookie("token", token));
    }

    public static void tabSwitch(String tab) {
        Set<String> allWindows = BrowserManager.getBrowser().getDriver().getWindowHandles();

        for (String currentTab : allWindows) {

            if (!tab.equalsIgnoreCase(currentTab)) {
                BrowserManager.getBrowser().getDriver().switchTo().window((currentTab));
            }
        }
    }

    public static String getWindowHandler() {
        return BrowserManager.getBrowser().getDriver().getWindowHandle();
    }

    public static void refreshPage() {
        BrowserManager.getBrowser().refresh();
    }

    public static void goToPreviousPage() {
        BrowserManager.getBrowser().goBack();
    }
}
