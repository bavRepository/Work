package com.internet.herokuapp.page.uniqelement;

import com.internet.herokuapp.page.wrapper.BaseElement;
import org.openqa.selenium.By;
import util.Wait;

public class Button extends BaseElement {

    public Button(By locator, String name) {
        super(locator, name);
    }

    public void waitForButtonClickAble(){
        Wait.forElementToBeClickable(findElement());
    }
}
