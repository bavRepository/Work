package com.internet.herokuapp.page;

import com.internet.herokuapp.page.uniqelement.*;
import com.internet.herokuapp.page.wrapper.BaseForm;
import org.openqa.selenium.By;
import util.BrowserManager;

public class IFramePage extends BaseForm {

    private IframeElement iFrame = new IframeElement(By.xpath("//iframe[contains(@id, 'mce_0_ifr')]"), "iFrame");
    private SpanElement changedTextSpan = new SpanElement(By.xpath("//span[/.//body[contains(@id, 'tinymce')]]"), "Span");
    private ParagraphElement iFrameParagraph = new ParagraphElement(By.xpath("//p[//body[@id='tinymce']]"), "iFrame paragraph");
    private Button leftAlignButton = new Button(By.xpath("//button[@aria-label='Align left' and @type='button']"), "Left Align Button");
    private Button formatButton = new Button(By.xpath("//button[./span[text()='Format']]"), "Format button");
    private Button fileButton = new Button(By.xpath("//button[.//span[contains(text(), 'File')]]"), "File button");
    private Button newDocument = new Button(By.xpath("//div[@class='tox-collection__item-label' and text()='New document']"), "New document Button");
    private Button fontSizesMenu = new Button(By.xpath("//div[@title='Font sizes' and ./div[text()='Font sizes']]"), " Font sizes menu"); ////div[text()='Font sizes'] //div[@title='Font sizes']
    private Button fontSize = new Button(By.xpath("//div[@class='tox-collection__item-label' and contains(text(), '8pt')]"), "text size 8 Button");

    public IFramePage() {
        super(new ImageElement(By.xpath("//img[@alt='Fork me on GitHub']"),
                "Img logo"), "iFrame page");
    }

    public String getTextAlign() {
        leftAlignButton.waitForButtonClickAble();
        leftAlignButton.click();
        iFrame.frameToBeAvailableAndSwitchToIt();
        iFrameParagraph.waitForElementVisibilityAndLocated();
        iFrameParagraph.waitForAttributeContains("style","text-align: left;");
        return iFrameParagraph.getCssValue("text-align");
    }

    public String getTextSize() {
        iFrameParagraph.selectHalfOfChars();
        BrowserManager.switchToDefaultWindow();
        formatButton.click();
        fontSizesMenu.moveToElement();
        fontSize.click();
        iFrame.frameToBeAvailableAndSwitchToIt();
        return changedTextSpan.getCssValue("font-size");
    }

    public boolean isDocumentTextEmpty() {
        BrowserManager.switchToDefaultWindow();
        fileButton.click();
        newDocument.click();
        iFrame.frameToBeAvailableAndSwitchToIt();
        return iFrameParagraph.isTextPresent();
    }

    public boolean isDocumentDefaultFormat() {
        return changedTextSpan.isElementPresent();
    }
}
