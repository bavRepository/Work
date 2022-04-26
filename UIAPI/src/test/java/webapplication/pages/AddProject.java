package webapplication.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AddProject extends Form {

    private static final String X_PATH_TO_LABEL = "//label[@for='projectName']";
    private final String CLASS_MESSAGE_SUCCESS_SAVE_PROJECT = "alert-success";
    private final String ID_PROJECT_NAME = "projectName";
    private final String X_PATH_TO_SAVE_PROJECT_BUTTON = "//button[contains(@class, 'btn-primary')]";

    private ITextBox saveProjectTextBox = getElementFactory().getTextBox(By.className(CLASS_MESSAGE_SUCCESS_SAVE_PROJECT),
            "save project");
    private ITextBox inputTextBox = getElementFactory().getTextBox(By.id(ID_PROJECT_NAME),
            "enter Project Name");

    private IButton saveProjectButton = getElementFactory().getButton(By.xpath(X_PATH_TO_SAVE_PROJECT_BUTTON),
            "save Project");

    public AddProject() {super(By.xpath(X_PATH_TO_LABEL), "Project name");}

    public void enterProjectName(String name) {
        inputTextBox.sendKeys(name);
        saveProjectButton.click();
    }

    public boolean isProjectSavedSuccessfully() {
        return saveProjectTextBox.state().isDisplayed();
    }

}
