package util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JsExecutor {

    private static JavascriptExecutor jsExecutor = (JavascriptExecutor) BrowserManager.getDriver();

    public static void clickJsButton(WebElement webElem) {
        jsExecutor.executeScript("arguments[0].click();", webElem);
    }

    public static void scrollToElement(WebElement webElem) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", webElem);
    }
}
