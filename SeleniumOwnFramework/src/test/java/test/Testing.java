package test;

import com.internet.herokuapp.page.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.*;

public class Testing extends BaseTest {

    private AuthPage authPage = new AuthPage();
    private JsAlertsPage jsAlertPage = new JsAlertsPage();
    private SliderPage sliderPage = new SliderPage();
    private HoversPage hoversPage = new HoversPage();
    private HoversUserProfilePage hoversUserProfilePage = new HoversUserProfilePage();
    private IFramePage iFramePage = new IFramePage();
    private InfiniteScrollPage infScrollPage = new InfiniteScrollPage();
    private UploadPage uploadPage = new UploadPage();

    @Test
    public void authTest() {

        // Open AuthPage with test Data
        HerokuappUrls.navigateToHerokuapp("login", "password", "/basic_auth");
        // Wait for page load
        authPage.waitForOpeningPage();
        // Check if text valid
        Assert.assertEquals(authPage.getResultText(),
                "Congratulations! You must have the proper credentials.", "Wrong expected result of text");
    }

    @Test
    public void alertsTest() {

        // Open JsAlert page
        HerokuappUrls.navigateToHerokuapp("/javascript_alerts");
        // Check if Page is loaded
        Assert.assertTrue(jsAlertPage.isPageLoaded(), "javascript_alerts page has been not loaded");

        // Click on jsAlert Button
        jsAlertPage.clickJsAlertButton();
        // Check text from Alert modal window
        Assert.assertEquals(AlertManager.getModalWindowText(), "I am a JS Alert",
                "Wrong text result of modal window after click on jsAlert button");
        // Click OK button
        AlertManager.clickOk();
        // Check if Alert window is closed
        Assert.assertTrue(AlertManager.isModalWindowClosed(), "Modal window is not closed");
        // Check result text
        Assert.assertEquals(jsAlertPage.compareResultText(), "You successfully clicked an alert",
                "Wrong text result after click OK on modal window: jsAlert button");

        // Click on jsConfirm Button
        jsAlertPage.clickJsConfirmButton();
        // Check text from Confirm modal window
        Assert.assertEquals(AlertManager.getModalWindowText(), "I am a JS Confirm",
                "Wrong text result of modal window after click on jsConfirm button");
        // Click Ok button
        AlertManager.clickOk();
        // Check if Confirm window is closed
        Assert.assertTrue(AlertManager.isModalWindowClosed(), "Modal window is not closed");
        // Check result text
        Assert.assertEquals(jsAlertPage.compareResultText(), "You clicked: OK",
                "Wrong text result after click OK on modal window: jsConfirm button");

        // Click on jsPrompt Button
        jsAlertPage.clickJsPromptButton();
        // Check text from Prompt modal window
        Assert.assertEquals(AlertManager.getModalWindowText(), "I am a JS prompt",
                "Wrong text result of modal window after click on jsPrompt button");
        // Click on OK button
        AlertManager.clickOk();
        // Check if Prompt window is closed
        Assert.assertTrue(AlertManager.isModalWindowClosed(), "Modal window is not closed");
        // Check result text
        Assert.assertEquals(jsAlertPage.compareResultText(), "You entered: " + DataMathWork.getRandomValue(),
                "Wrong text result after click OK on modal window: jsPrompt button");
    }

    @Test
    public void horizontalSliderTest() {

        // Open Slider page
        HerokuappUrls.navigateToHerokuapp("/horizontal_slider");
        // Check if Page is loaded
        Assert.assertTrue(sliderPage.isPageLoaded(), "horizontal_slider page has been not loaded");
        // Random drag and drop position slider
        sliderPage.randomSliderDragAndDropAction();
        // Check if value is valid
        Assert.assertTrue(DataMathWork.numbersCompare(sliderPage.getDragAndDropSpanValue()), "Value is not valid");
    }

    @Test(dataProvider = "user_name", dataProviderClass = TestDataManager.class)
    public void hoversTest(String userNum) {

        // Open Hovers page
        HerokuappUrls.navigateToHerokuapp("/hovers");
        // Check if Page is loaded
        Assert.assertTrue(hoversPage.isPageLoaded(), "hovers page has been not loaded");
        // Move to user Img
        hoversPage.moveToUserImg(userNum);
        // Wait for user Div wrapper displayed
        hoversPage.waitForUserDivDisplayed(userNum);
        // Compare user name
        Assert.assertEquals(hoversPage.userCompareName(userNum), "user" + userNum, " name is not correct");
        // Check if user link is displayed
        Assert.assertTrue(hoversPage.isUserLinkDisplayed(userNum), "Link user" + userNum + " is not displayed");
        // Get hrefUserProfileLink
        String userLinkHref = hoversPage.getUserLinkHref(userNum);
        // Click on userProfile link to navigate userPageProfile
        hoversPage.clickUserProfileLink(userNum);
        // Check match of our CurrentUrl and user link
        Assert.assertEquals(hoversUserProfilePage.getCurrentUrl(), userLinkHref,
                "ProfileUser" + userNum + " Link does not match the currentUrl");
        // Navigate to previous page
        BrowserManager.navigateToPreviousPage();
        // Check if Page is loaded
        Assert.assertTrue(hoversPage.isPageLoaded(), "hovers page has been not loaded");
    }

    @Test
    public void iFrameTest() {

        // Open iFrame page
        HerokuappUrls.navigateToHerokuapp("/iframe");
        // Check if Page is loaded
        Assert.assertTrue(iFramePage.isPageLoaded(), "iframe page has not been loaded");
        // Check if Paragraph text Align is "left"
        Assert.assertEquals(iFramePage.getTextAlign(), "left", "Text does not have left align");
        // Check if Paragraph text has changed font size
        Assert.assertEquals(iFramePage.getTextSize(), "8px", "Font size is not 8px");
        // Check if Paragraph text is empty
        Assert.assertTrue(iFramePage.isDocumentTextEmpty(), "Paragraph text field in not empty");
        // Check if Paragraph format is default
        Assert.assertTrue(iFramePage.isDocumentDefaultFormat(), "Document format is not default");
    }

    @Test
    public void jsAlertTest() {

        // Open JsAlert page
        HerokuappUrls.navigateToHerokuapp("/javascript_alerts");
        // Check if Page is loaded
        Assert.assertTrue(jsAlertPage.isPageLoaded(), "javascript_alerts page has been not loaded");
        // Click on jsAlert Button
        jsAlertPage.clickJsMethodAlertButton();
        // Check text from Alert modal window
        Assert.assertEquals(AlertManager.getModalWindowText(), "I am a JS Alert",
                "Wrong text result of modal window after click on jsAlert button");
        // Click OK button
        AlertManager.clickOk();
        // Check if Alert window is closed
        Assert.assertTrue(AlertManager.isModalWindowClosed(), "Alert modal window is not closed");
        // Check result text
        Assert.assertEquals(jsAlertPage.compareResultText(), "You successfully clicked an alert",
                "Wrong text result after click OK on modal window: jsAlert button");
        // Click on jsConfirm Button
        jsAlertPage.clickJsMethodConfirmButton();
        // Check text from Confirm modal window
        Assert.assertEquals(AlertManager.getModalWindowText(), "I am a JS Confirm",
                "Wrong text result of modal window after click on jsConfirm button");
        // Click OK button
        AlertManager.clickOk();
        // Check if Confirm window is closed
        Assert.assertTrue(AlertManager.isModalWindowClosed(), "Confirm modal window is not closed");
        // Check result text
        Assert.assertEquals(jsAlertPage.compareResultText(), "You clicked: Ok",
                "Wrong text result after click OK on modal window: jsConfirm button");
        // Click on jsPrompt Button
        jsAlertPage.clickJsMethodPromptButton();
        // Check text from Prompt modal window
        Assert.assertEquals(AlertManager.getModalWindowText(), "I am a JS prompt",
                "Wrong text result of modal window after click on jsPrompt button");
        // Enter random text in Prompt modal window
        AlertManager.enterRandomText();
        // Click Ok button
        AlertManager.clickOk();
        // Check if Prompt window is closed
        Assert.assertTrue(AlertManager.isModalWindowClosed(), "Modal window is not closed");
        // Check result text
        Assert.assertEquals(jsAlertPage.compareResultText(), "You entered: "
                + DataMathWork.getRandomValue(), "Wrong text result after click OK on modal window: jsPrompt button");
    }

    @Test
    public void infiniteScrollTest() {
        // Open JsAlert page
        HerokuappUrls.navigateToHerokuapp("/infinite_scroll");
        // Check if Page is loaded
        Assert.assertTrue(infScrollPage.isPageLoaded(), "infinite_scroll Page has been not loaded");
        // Scroll the page until appropriate paragraph will be found
        infScrollPage.scrollUntilElementFind();
        // Check if age match with paragraphs count
        Assert.assertTrue(infScrollPage.isParagraphDisplayed(), "Age does not match with paragraphs count");
    }

    @Test
    public void uploadTest() {
        // Open Upload page
        HerokuappUrls.navigateToHerokuapp("/upload");
        // Check if Page is loaded
        Assert.assertTrue(uploadPage.isPageLoaded(), "Upload page has been not loaded");
        // Choose file for further upload
        uploadPage.chooseFileForUpload();
        // Local file uploading to page
        uploadPage.uploadFileButtonClick();
        // Check if page has been Refreshed
        Assert.assertTrue(uploadPage.isPageRefreshed(), "Upload page has been not refreshed");
        // Check result text
        Assert.assertEquals(uploadPage.getResultTextFromH3(), "File Uploaded!",
                "Wrong h3 text result");
        // Check file name
        Assert.assertEquals(uploadPage.getFileNameTextFromDiv(),
                DataMathWork.getFileNameFromPath(TestDataManager.getTestData("uploadFile")),
                "File name is not correct");
    }
}
