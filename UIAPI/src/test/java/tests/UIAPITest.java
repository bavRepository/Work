package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import webapplication.model.TestTable;
import webapplication.pages.AddProject;
import webapplication.pages.Projects;
import webapplication.utils.*;

import java.util.List;

public class UIAPITest extends BaseTest {

    Projects projectsPage = new Projects();
    AddProject addProjectPage = new AddProject();

    @Test
    public void testUIAPI() {
        String token = WebAppAPIUtils.getToken();
        Assert.assertTrue(WebAppAPIUtils.isTokenExist(token), "Invalid token");
        BrowserManager.getBrowser().goTo(UrlBuilder.setUrlParams(Config.SELENIUM_BASE_URL));
        Assert.assertTrue(projectsPage.state().waitForDisplayed(), "Projects page is not open");
        String projectId = projectsPage.getProjectId();
        BrowserManager.addTokenCookie(token);
        BrowserManager.refreshPage();
        Assert.assertTrue(projectsPage.isVariantCorrect(), "Incorrect variant number");
        projectsPage.clickNexageLink();
        allTestsPage.waitForLoadingInvisible();
        Assert.assertTrue(allTestsPage.isDateListSorted(), "Date not sorted");
        List<TestTable> uiTests = allTestsPage.getObjects();
        List<TestTable> apiTests = WebAppAPIUtils.getTestList(projectId);
        Assert.assertTrue(DataMathWork.isTestObjectsEquals(apiTests, uiTests), "Wrong objects equals");
        BrowserManager.getBrowser().waitForPageToLoad();
        BrowserManager.goToPreviousPage();
        String parentWindow = BrowserManager.getWindowHandler();
        projectsPage.clickAddProject();
        BrowserManager.tabSwitch(parentWindow);
        String childWindow = BrowserManager.getWindowHandler();
        addProjectPage.state().waitForDisplayed();
        addProjectPage.enterProjectName(TestData.PROJECT_NAME);
        Assert.assertTrue(addProjectPage.isProjectSavedSuccessfully(), "Project not saved");
        JsFunction.closePopUpWindow();
        BrowserManager.tabSwitch(childWindow);
        BrowserManager.refreshPage();
        Assert.assertTrue(projectsPage.waitIsProjectDisplayed(), "Project is not displayed");
        projectsPage.clickProjectButton();
        allTestsPage.waitForLoadingInvisible();
     }
}
