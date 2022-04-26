package webapplication.utils;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;
import webapplication.model.TestTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static aquality.selenium.browser.AqualityServices.getElementFactory;
import static aquality.selenium.elements.ElementType.TEXTBOX;

public class DynamicElementBuilder {

    private static final String X_PATH_TO_TD_START_TIME = "//table[@class='table']//tr//td[%s]";
    private static final String X_PATH_TO_TD = "//table[@class='table']//tr[.//following-sibling::td][%s]//td[%s]";

    public static List<ITextBox> getStartTimeTextBox(int columnIndex) {
        return getElementFactory().
                findElements(By.xpath(String.format(X_PATH_TO_TD_START_TIME, columnIndex)), TEXTBOX);
    }

    public static List<TestTable> getTestUiObjects(int size) {
        List<TestTable> uiTests = new ArrayList<>();
        int testListIndex = 0;
        for (int uiIndex = 1; uiIndex <= size; uiIndex++) {
            testListIndex = uiIndex - 1;
            uiTests.add(new TestTable());
            ITextBox testName = getElementFactory().getTextBox(By.xpath(String.format(X_PATH_TO_TD, uiIndex, UITestColumnIndexEnum.NAME.getValue())),
                    "test name");
            ITextBox testMethod = getElementFactory().getTextBox(By.xpath(String.format(X_PATH_TO_TD, uiIndex, UITestColumnIndexEnum.METHOD.getValue())),
                    "test method");
            ITextBox testResult = getElementFactory().getTextBox(By.xpath(String.format(X_PATH_TO_TD, uiIndex, UITestColumnIndexEnum.RESULT.getValue())),
                    "test result");
            ITextBox testStartTime = getElementFactory().getTextBox(By.xpath(String.format(X_PATH_TO_TD, uiIndex, UITestColumnIndexEnum.START_TIME.getValue())),
                    "test start time");
            ITextBox testEndTime = getElementFactory().getTextBox(By.xpath(String.format(X_PATH_TO_TD, uiIndex, UITestColumnIndexEnum.END_TIME.getValue())),
                    "test end time");
            ITextBox testDuration = getElementFactory().getTextBox(By.xpath(String.format(X_PATH_TO_TD, uiIndex, UITestColumnIndexEnum.DURATION.getValue())),
                    "test duration");
            testName.getJsActions().scrollToTheCenter();
            uiTests.get(testListIndex).setName(testName.getText());
            uiTests.get(testListIndex).setMethod(testMethod.getText());
            if (!testResult.getText().equals(TestData.UI_TEST_TABLE_STATUS_IN_PROGRESS)) {
                uiTests.get(testListIndex).setStatus(testResult.getText().toUpperCase(Locale.ROOT));
            } else uiTests.get(testListIndex).setStatus(testResult.getText());
            uiTests.get(testListIndex).setStartTime(testStartTime.getText());
            if (testEndTime.getText().isEmpty()) {
                uiTests.get(testListIndex).setEndTime(null);
            } else uiTests.get(testListIndex).setEndTime(testEndTime.getText());
            uiTests.get(testListIndex).setDuration(testDuration.getText());
        }
        return uiTests;
    }

    public static IButton getProjectButtonElement() {
        return getElementFactory().getButton(By.xpath(String.format("//a[text()='%s']", TestData.PROJECT_NAME)), "project name");
    }
}

