package com.userinnyeface.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class GamePage extends Form {

    private final ITextBox timerTextBox = getElementFactory().getTextBox(By.xpath("//div[contains(@class, 'timer--center') and ancestor::div[@class='view__row']]"), "timer");
    private final ITextBox helpFormTextBox = getElementFactory().getTextBox(By.xpath("//div[@class='help-form']"), "help form");
    private final ITextBox formCoockiesTextBox = getElementFactory().getTextBox(By.className("cookies"), "coockies form");
    private final IButton sendToBottomButton = getElementFactory().getButton(By.xpath("//button[contains(@class, 'button--blue') and ancestor::div[@class='align__cell u-right']]"), "send to bottom");
    private final IButton coockiesButton = getElementFactory().getButton(By.xpath("//button[contains(@class,'cookies__button') and ancestor::div[@class='align__cell']]"), "accept coockies");

    public GamePage(){
        super(By.className("logo__icon"), "user inyerface logo");
    }

    public void hideHelpForm(){
        sendToBottomButton.click();
    }

    public boolean waitForHelpFormNotDisplayed() {
        return helpFormTextBox.state().waitForNotDisplayed();
    }

    public void acceptCoockiesBtnClick(){
        coockiesButton.click();
    }

    public boolean isCoockiesFormClose(){
        return !formCoockiesTextBox.state().isDisplayed();
    }

    public String getStartTime(){
        return timerTextBox.getText();
    }
}