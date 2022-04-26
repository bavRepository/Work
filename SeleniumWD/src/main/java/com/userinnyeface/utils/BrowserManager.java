package com.userinnyeface.utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;

public abstract class BrowserManager {

    public static Browser getBrowser(){
        return AqualityServices.getBrowser();
    }
}
