package com.internet.herokuapp.page.uniqelement;

import com.internet.herokuapp.page.wrapper.BaseElement;
import org.openqa.selenium.By;

public class DivElement extends BaseElement {

    public DivElement(By locator, String name) {
        super(locator, name);
    }

    public boolean isElementPresent() {
        return findElements().size() > 0;
    }
}
