package com.internet.herokuapp.page.wrapper;

import util.Log;

public abstract class BaseForm {

    private BaseElement webElement;
    private String name;

    public BaseForm(BaseElement webElement, String name) {
        this.webElement = webElement;
        this.name = name;
    }

    public void waitForOpeningPage() {
        Log.infoLogger("Opening " + name);
        webElement.waitForPresenceOfElementLocated();
    }

    public boolean isDisplayed() {
        Log.infoLogger("Check if " + name + " is open");
        return webElement.findElement().isDisplayed();
    }

    public boolean isPageLoaded() {
        waitForOpeningPage();
        return isDisplayed();
    }
}
