package util;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Wait {

    private static WebDriverWait wait = new WebDriverWait(BrowserManager.getDriver(), Duration.ofSeconds(Integer.valueOf(ConfigManager.getParam("ExplicitWait"))));

    public static Alert alertIsPresentWait() {
        return wait.until(alertIsPresent());
    }

    public static void forVisibilityOfElementLocated(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void forPresenceOfElementLocated(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void forElementToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void forElementInvisible(WebElement webElem) {
        wait.until(ExpectedConditions.invisibilityOf(webElem));
    }

    public static void forAttributeContains(WebElement webElem, String attr, String value) {
        wait.until(ExpectedConditions.attributeContains(webElem,attr,value));
    }

    public static void forFrameToBeAvailableAndSwitchToIt(WebElement webElem) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(webElem));
    }
}
