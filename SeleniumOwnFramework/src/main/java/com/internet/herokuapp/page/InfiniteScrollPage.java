package com.internet.herokuapp.page;

import com.internet.herokuapp.page.uniqelement.DivElement;
import com.internet.herokuapp.page.uniqelement.ImageElement;
import com.internet.herokuapp.page.wrapper.BaseForm;
import org.openqa.selenium.By;


public class InfiniteScrollPage extends BaseForm {

    private final String X_PATH_TO_PARAGRAPH = "//div[@class='jscroll-added'][%s]";

    private DivElement paragraph;
    private DivElement requiredParagraph = new DivElement(By.xpath("//div[36][@class='jscroll-added']"), "Div ageExpected Paragraph");
    private DivElement smallLoadElement = new DivElement(By.xpath("//small[/.//div[@class='jscroll-loading']]"), "small element of loading ");
    private int counter = 1;

    public InfiniteScrollPage() {
        super(new ImageElement(By.xpath("//img[@alt='Fork me on GitHub']"),
                "Img logo"), "InfiniteScroll Page");
    }

    public void scrollUntilElementFind() {

        while (!requiredParagraph.isElementPresent()) {
            paragraph = new DivElement(By.xpath(String.format(X_PATH_TO_PARAGRAPH, counter)), "Div Paragraph " + counter);
            if (smallLoadElement.isElementPresent()) {
                smallLoadElement.waitForElementInvisible();
            }
            paragraph.waitForElementVisibilityAndLocated();
            paragraph.jsScrollPage();
            counter++;
        }
    }

    public boolean isParagraphDisplayed() {
        return requiredParagraph.isDisplayed();
    }
}
