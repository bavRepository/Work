package com.internet.herokuapp.page;

import com.internet.herokuapp.page.uniqelement.DivElement;
import com.internet.herokuapp.page.uniqelement.HeadingElement;
import com.internet.herokuapp.page.uniqelement.ImageElement;
import com.internet.herokuapp.page.uniqelement.InputElement;
import com.internet.herokuapp.page.wrapper.BaseForm;
import org.openqa.selenium.By;
import util.TestDataManager;

public class UploadPage extends BaseForm {

    InputElement chooseFileInput = new InputElement(By.xpath("//input[@id='file-upload']"), "Input of choose file");
    InputElement uploadFileButton = new InputElement(By.xpath("//input[@id='file-submit']"), "Input of upload file");
    DivElement fileNameTextDiv = new DivElement(By.xpath("//div[@id='uploaded-files']"), "Div of file name");
    HeadingElement refreshIndicatorH3 = new HeadingElement(By.xpath("//h3[text()='File Uploaded!' and //../div[@class='example']]"), "H3 of refresh page");


    public UploadPage() {
        super(new ImageElement(By.xpath("//img[@alt='Fork me on GitHub']"),
                "Img logo"), "Upload page");
    }

    public void chooseFileForUpload(){
        chooseFileInput.waitForPresenceOfElementLocated();
        chooseFileInput.fileUpload(TestDataManager.getTestData("uploadFile"));
    }

    public void uploadFileButtonClick(){
        uploadFileButton.click();
    }

    public boolean isPageRefreshed(){
        refreshIndicatorH3.waitForPresenceOfElementLocated();
        return refreshIndicatorH3.isDisplayed();
    }

    public String getResultTextFromH3(){
        return refreshIndicatorH3.getAttribute("innerHTML");
    }

    public String getFileNameTextFromDiv(){
        return fileNameTextDiv.getText();
    }
}
