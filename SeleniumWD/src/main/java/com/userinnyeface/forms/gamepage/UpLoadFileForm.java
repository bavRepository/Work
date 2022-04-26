package com.userinnyeface.forms.gamepage;


import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import com.userinnyeface.utils.ElementsManager;
import org.openqa.selenium.By;
import java.util.List;
import static aquality.selenium.elements.ElementType.CHECKBOX;

public class UpLoadFileForm extends Form {

    private final ICheckBox unselectAllCheckBox = getElementFactory().getCheckBox(By.xpath("//input[@id = 'interest_unselectall']//following-sibling::span[@class ='checkbox__box']"),
            "unselect all");

    private final ITextBox avatarAndInterestsTextBox = getElementFactory().getTextBox(By.className("avatar-and-interests"),
            "avatar and interests");
    private final IButton uploadFileButton = getElementFactory().getButton(By.className("avatar-and-interests__upload-button"),
            "upload file");
    private final IButton nextButton = getElementFactory().getButton(By.xpath("//button[contains(@class, 'button--stroked')]"),
            "next");
    private final ITextBox imageTextBox = getElementFactory().getTextBox(By.className("avatar-and-interests__avatar-image"),
            "image");

    public UpLoadFileForm() {
        super(By.className("avatar-and-interests__form"), "upLoadFile form");
    }

    public void unselectAllClick() {
        avatarAndInterestsTextBox.getJsActions().scrollIntoView();
        unselectAllCheckBox.click();
    }

    public void selectInterestsElements(int count) {
        List<ICheckBox> checkBoxList = getElementFactory().
                findElements(By.xpath("//span[@class='checkbox small' and ./label[not(@for='interest_unselectall')]" +
                        " and ./label[not(@for='interest_selectall')]]"),CHECKBOX);
        ElementsManager.selectCheckBoxElements(checkBoxList, count);
    }

    public void uploadFile(){
        uploadFileButton.click();
    }

    public void clickNextButton(){
        imageTextBox.state().waitForDisplayed();
        nextButton.click();
    }
}
