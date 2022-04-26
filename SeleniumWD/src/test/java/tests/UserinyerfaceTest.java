package tests;



import com.userinnyeface.forms.gamepage.AuthorizationForm;
import com.userinnyeface.forms.gamepage.PersonalDetailsForm;
import com.userinnyeface.forms.gamepage.UpLoadFileForm;
import com.userinnyeface.pages.GamePage;
import com.userinnyeface.pages.MainPage;

import com.userinnyeface.utils.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserinyerfaceTest extends BaseTest {

    MainPage mainPage = new MainPage();
    GamePage gamePage = new GamePage();
    AuthorizationForm authForm = new AuthorizationForm();
    UpLoadFileForm upLoadFileForm = new UpLoadFileForm();
    PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm();

    private final int PASSWORD_AND_EMAIL_UP_DOWN_CASES_LENGTH = 4;
    private final int DOMAIN_UP_DOWN_CASES_LENGTH = 1;

    @Test
    public void formsTest() {
        BrowserManager.getBrowser().goTo(UrlsConfiguration.getStartUrl());
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page is not open");
        mainPage.linkClick();
        gamePage.state().waitForDisplayed();

        Assert.assertTrue(authForm.state().waitForDisplayed(), "Auth form is not open");
        String password = DataMathWork.getRandomStringValue(PASSWORD_AND_EMAIL_UP_DOWN_CASES_LENGTH);
        authForm.fillDataPasswordField(password);
        authForm.fillDataEmailField(DataMathWork.addPasswordCharToRandomEmail(PASSWORD_AND_EMAIL_UP_DOWN_CASES_LENGTH));
        authForm.checkBoxClick();
        authForm.fillDataDomainField(DataMathWork.getRandomDomain(DOMAIN_UP_DOWN_CASES_LENGTH));
        authForm.selectItemFromdropList();
        authForm.btnNextClick();
        Assert.assertTrue(upLoadFileForm.state().waitForDisplayed(), "Upload file form is not open");
        upLoadFileForm.unselectAllClick();
        upLoadFileForm.selectInterestsElements(3);
        upLoadFileForm.uploadFile();
        RobotWork.uploadFile(FilePathManager.getAbsolutePath(FileConfiguration.getParameterValue("testData", "uploadImage")));
        upLoadFileForm.clickNextButton();
        Assert.assertTrue(personalDetailsForm.state().waitForDisplayed(), "Personal details form is not open");
    }

    @Test
    public void hideFormHelp() {
        BrowserManager.getBrowser().goTo(UrlsConfiguration.getStartUrl());
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page is not open");
        mainPage.linkClick();
        gamePage.state().waitForDisplayed();
        gamePage.hideHelpForm();
        Assert.assertTrue(gamePage.waitForHelpFormNotDisplayed(), "Help Form is Displayed");
    }

    @Test
    public void acceptCoockies() {
        BrowserManager.getBrowser().goTo(UrlsConfiguration.getStartUrl());
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page is not open");
        mainPage.linkClick();
        gamePage.state().waitForDisplayed();
        gamePage.acceptCoockiesBtnClick();
        Assert.assertTrue(gamePage.isCoockiesFormClose(), "Coockies form must be close after accept action. It stays open");
    }

    @Test
    public void timerStartZero() {
        BrowserManager.getBrowser().goTo(UrlsConfiguration.getStartUrl());
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main Page is not open");
        mainPage.linkClick();
        gamePage.state().waitForDisplayed();
        Assert.assertEquals(gamePage.getStartTime(), FileConfiguration.getParameterValue("testData","startTimer"), "Time does not get start from zero");
    }
}