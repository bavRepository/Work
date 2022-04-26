package com.internet.herokuapp.page;

import com.internet.herokuapp.page.uniqelement.Button;
import com.internet.herokuapp.page.uniqelement.ImageElement;
import com.internet.herokuapp.page.uniqelement.ParagraphElement;
import com.internet.herokuapp.page.wrapper.BaseForm;
import org.openqa.selenium.By;

public class JsAlertsPage extends BaseForm {

    private Button jsAlertButton = new Button(By.xpath("//button[@onclick='jsAlert()']"), "Js Alert Button");
    private Button jsConfirmButton = new Button(By.xpath("//button[@onclick='jsConfirm()']"), "Js Confirm Button");
    private Button jsPromptButton = new Button(By.xpath("//button[@onclick='jsPrompt()']"), "Js Prompt Button");;

    ParagraphElement textField =
            new ParagraphElement(By.xpath("//*[@id='result']"), "Paragraph of text result");

    public JsAlertsPage() {
        super(new ImageElement(By.xpath("//img[@alt='Fork me on GitHub']"),
                "Img logo"), "JsAlertPage");
    }


    public void clickJsAlertButton() {
        jsAlertButton.waitForPresenceOfElementLocated();
        jsAlertButton.click();
    }

    public void clickJsConfirmButton() {
        jsConfirmButton.click();
    }

    public void clickJsPromptButton() {
        jsPromptButton.click();
    }

    public void clickJsMethodAlertButton(){
        jsAlertButton.waitForPresenceOfElementLocated();
        jsAlertButton.jsScriptClickElement();
    }

    public void clickJsMethodConfirmButton(){
        jsConfirmButton.jsScriptClickElement();
    }

    public void clickJsMethodPromptButton(){
        jsPromptButton.jsScriptClickElement();
    }

    public String compareResultText() {
        return textField.getText();
    }
}
