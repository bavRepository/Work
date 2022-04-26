package webapplication.pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import webapplication.model.TestTable;
import webapplication.utils.DataMathWork;
import webapplication.utils.DynamicElementBuilder;
import webapplication.utils.UITestColumnIndexEnum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static aquality.selenium.elements.ElementType.TEXTBOX;

public class AllTests extends Form {

    private static final String CLASS_HEADING_PANEL = "panel-heading";
    private final String CLASS_ELEMENT_LOADING = "messi-box";

    private ITextBox loadingTextBox = getElementFactory().getTextBox(By.className(CLASS_ELEMENT_LOADING),
            "loading");

    public AllTests() {
        super(By.className(CLASS_HEADING_PANEL), "Tests progress panel");
    }

    public boolean isDateListSorted() {
        List date = DataMathWork.addDateToList(DynamicElementBuilder.getStartTimeTextBox(UITestColumnIndexEnum.START_TIME.getValue()));
        List sortDate = new ArrayList(date);
        Collections.sort(sortDate, Collections.reverseOrder());
        return sortDate.equals(date);
    }

    public List<TestTable> getObjects() {
        List<ITextBox> trList = getElementFactory().
                findElements(By.xpath("//table[@class='table']//tr[.//following-sibling::td]"), TEXTBOX);
        return DynamicElementBuilder.getTestUiObjects(trList.size());
    }

    public boolean waitIsProjectDisplayed(String name) {
        ILink testNameTd = getElementFactory().getLink(By.xpath(("//tr//a[@href]")),"test name");
        testNameTd.state().waitForDisplayed();
        return testNameTd.getText().equals(name);
    }

    public void waitForLoadingInvisible() {
        loadingTextBox.state().waitForNotDisplayed();
    }
}
