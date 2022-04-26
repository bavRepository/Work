package com.internet.herokuapp.page.uniqelement;

import com.internet.herokuapp.page.wrapper.BaseElement;
import org.openqa.selenium.By;
import util.Log;
import util.Wait;

public class IframeElement extends BaseElement {

    public IframeElement(By locator, String name) {
        super(locator, name);
    }

    public void frameToBeAvailableAndSwitchToIt() {
        Log.infoLogger("Switch to iFrame");
        Wait.forFrameToBeAvailableAndSwitchToIt(findElement());
    }
}
