package com.internet.herokuapp.page.uniqelement;

import com.internet.herokuapp.page.wrapper.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import util.BrowserManager;
import util.Log;

public class ParagraphElement extends BaseElement {

    private int strLen;
    private Actions action = new Actions(BrowserManager.getDriver());

    public ParagraphElement(By locator, String name) {
        super(locator, name);
    }

    public void selectHalfOfChars() {

        strLen = getText().length() / 2;
        Log.infoLogger("Select the first half of Paragraph text symbols");
        action.keyDown(Keys.SHIFT).build().perform();
        for (int i = 0; i < strLen; i++) {
            action.moveToElement(findElement()).sendKeys(Keys.ARROW_RIGHT).build().perform();
        }
        action.keyUp(Keys.SHIFT).build().perform();

    }

    public boolean isTextPresent() {
        return getText().isEmpty();
    }
}
