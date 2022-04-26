package webapplication.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import webapplication.utils.DataMathWork;
import webapplication.utils.DynamicElementBuilder;
import webapplication.utils.TestData;

public class Projects extends Form {

    private final String X_PATH_TO_ADD_BUTTON = "//a[contains(@class,'btn') and contains(@class,'btn-primary')]";
    private final String X_PATH_TO_VARIANT_NUMBER = "//p[contains(@class,'text-muted') and contains(@class,'footer-text')] //following-sibling::span";
    private final String X_PATH_TO_PROJECT_NEXAGE_LINK = "//div[@class='list-group'] //following-sibling::a[@href='allTests?projectId=1']";
    private static final String X_PATH_TO_FOOTER = "footer";

    private IButton projectButton;
    private IButton addButton = getElementFactory().getButton(By.xpath(X_PATH_TO_ADD_BUTTON),
            "add");
    private ITextBox variantTextBox = getElementFactory().getTextBox(By.xpath(X_PATH_TO_VARIANT_NUMBER),
            "variant");
    private ILink nexageLink = getElementFactory().getLink(By.xpath(X_PATH_TO_PROJECT_NEXAGE_LINK),
            "nexage");

    public Projects() {
        super(By.className(X_PATH_TO_FOOTER), "footer");
    }

    public boolean isVariantCorrect() {
        variantTextBox.state().waitForDisplayed();
        return DataMathWork.intVariantValueCutFromString(variantTextBox.getText()) == Integer.valueOf(TestData.VARIANT);
    }

    public String getProjectId() {
        return DataMathWork.projectIdValueCutFromLink(nexageLink.getHref());
    }

    public void clickNexageLink() {
        nexageLink.click();
    }

    public void clickAddProject() {
        addButton.click();
    }

    public void clickProjectButton() {
        projectButton = DynamicElementBuilder.getProjectButtonElement();
        projectButton.click();
    }

    public boolean waitIsProjectDisplayed() {
        projectButton = DynamicElementBuilder.getProjectButtonElement();
        return projectButton.state().waitForDisplayed();
    }
}
