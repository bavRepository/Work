package com.internet.herokuapp.page.wrapper;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import util.BrowserManager;
import util.JsExecutor;
import util.Log;
import util.Wait;

import java.util.List;

public abstract class BaseElement {

    private By locator;
    private String name;
    private Actions action = new Actions(BrowserManager.getDriver());

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public boolean isDisplayed() {
        Log.infoLogger("Check if " + name + " is displayed");
        return findElement().isDisplayed();
    }

    public void jsScriptClickElement() {
        Log.infoLogger("Click on: " + name + " by js method");
        JsExecutor.clickJsButton(findElement());
    }

    public void jsScrollPage() {
        Log.infoLogger("Scroll to " + name);
        JsExecutor.scrollToElement(findElement());
    }

    public void click() {
        Log.infoLogger("Click on: " + name);
        findElement().click();
    }

    public String getText() {
        Log.infoLogger("Get text from: " + name);
        return findElement().getText();
    }

    public String getAttribute(String str) {
        Log.infoLogger("Get attribute: " + str + " from " + name);
        return findElement().getAttribute(str);
    }

    public String getCssValue(String str) {
        Log.infoLogger("Get css value: " + str + " from " + name);
        return findElement().getCssValue(str);
    }

    public void waitForElementInvisible() {
        Log.infoLogger("Wait for element invisible: " + name);
        Wait.forElementInvisible(findElement());
    }

    public void waitForPresenceOfElementLocated() {
        Log.infoLogger("Wait for presence and located: " + name);
        Wait.forPresenceOfElementLocated(locator);
    }

    public void waitForElementVisibilityAndLocated() {
        Log.infoLogger("Wait for visible and located: " + name);
        Wait.forVisibilityOfElementLocated(locator);
    }

    public void waitForAttributeContains(String attribute, String value) {
        Log.infoLogger("Wait for " + name + " attribute:" + attribute + " contains:" + value);
        Wait.forAttributeContains(findElement(), attribute, value);
    }

    public void moveToElement() {
        Log.infoLogger("Move to element: " + name);
        action.moveToElement(findElement()).build().perform();
    }

    protected WebElement findElement() {
        return BrowserManager.getDriver().findElement(locator);
    }

    protected List<WebElement> findElements() {
        return BrowserManager.getDriver().findElements(locator);
    }
}
