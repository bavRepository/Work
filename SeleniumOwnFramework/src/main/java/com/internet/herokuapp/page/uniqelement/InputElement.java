package com.internet.herokuapp.page.uniqelement;

import com.internet.herokuapp.page.wrapper.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import util.BrowserManager;
import util.DataMathWork;
import util.FilePathManager;
import util.Log;

public class InputElement extends BaseElement {

    private Actions action = new Actions(BrowserManager.getDriver());

    public InputElement(By locator, String name) {
        super(locator, name);
    }

    public void dragAndDropSlider() {
        Log.infoLogger("Random drag and drop slider");
        action.dragAndDropBy(findElement(), DataMathWork.getRandomOffsetValue(), 0).build().perform();
    }

    public void fileUpload(String relativePath){
        findElement().sendKeys(FilePathManager.getAbsolutePath(relativePath));
    }
}
