package com.userinnyeface.forms.gamepage;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import com.userinnyeface.utils.ElementsManager;
import org.openqa.selenium.By;
import java.util.List;
import static aquality.selenium.elements.ElementType.BUTTON;

public class AuthorizationForm extends Form {

        private final ITextBox passwordTextBox  = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Choose Password']"), "password");
        private final ITextBox emailTextBox = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Your email']"), "email");
        private final ITextBox domainTextBox = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Domain']"), "domain");
        private final ICheckBox termAndConditionsCheckBox = getElementFactory().getCheckBox(By.xpath("//span[contains(@class, 'icon-check') and ancestor::span[@class='checkbox__box']]"),
                "terms & conditions");
        private final IButton dropListButton = getElementFactory().getButton(By.className("dropdown__header"), "Drop list");
        private final IButton nextButton = getElementFactory().getButton(By.className("button--secondary"), "next");

        public AuthorizationForm() {
            super(By.className("login-form__fields"), "authorization form");
        }

        public void fillDataPasswordField(String data){
            passwordTextBox.clearAndType(data);
        }

        public void fillDataEmailField(String data){
            emailTextBox.clearAndType(data);
        }

        public void checkBoxClick(){
            termAndConditionsCheckBox.click();
        }

        public void fillDataDomainField(String data){
            domainTextBox.clearAndType(data);
        }

        public void selectItemFromdropList(){
            dropListButton.click();
            List<IButton> domainList = getElementFactory().
                    findElements(By.xpath("//div[@class='dropdown__list-item']"),BUTTON);
            ElementsManager.clickRandomButton(domainList);
        }

        public void btnNextClick(){
            nextButton.click();
        }

}
