package com.internet.herokuapp.page;

import com.internet.herokuapp.page.uniqelement.HeadingElement;
import com.internet.herokuapp.page.wrapper.BaseForm;
import org.openqa.selenium.By;
import util.BrowserManager;

public class HoversUserProfilePage extends BaseForm {

    public HoversUserProfilePage() {
        super(new HeadingElement(By.xpath("//h1[text()='Not Found']"),
                "H1 text 'Not Found'"), "HoversUserProfile page");
    }

    public String getCurrentUrl() {
        return BrowserManager.getCurrentURL();
    }
}
