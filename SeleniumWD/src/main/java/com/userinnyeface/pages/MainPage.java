package com.userinnyeface.pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {

    private final ILink gamePageLink = getElementFactory().getLink(By.className("start__link"), "next page");

    public MainPage(){
        super(By.className("logo__icon"), "user inyerface logo");
    }

    public void linkClick(){
        gamePageLink.click();
    }

}
