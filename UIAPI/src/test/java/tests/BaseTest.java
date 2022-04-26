package tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import webapplication.pages.AllTests;
import webapplication.utils.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    protected DateFormat df = new SimpleDateFormat(Config.DATE_MASK);
    protected Date startTestDate;
    protected AllTests allTestsPage = new AllTests();

    @BeforeMethod
    public void setUp() {
        startTestDate = new Date();
        HttpClient.setDefaultUrl(Config.UNIREST_BASE_URL);
        BrowserManager.getBrowser().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result, ITestContext testContext) throws IOException {
        String testId = WebAppAPIUtils.putTest(testContext.getName(),
                result.getMethod().getMethodName(), df.format(startTestDate));
        WebAppAPIUtils.putLogInTest(testId, FileIManager.getLog(Config.LOG_FILE_RELATIVE_PATH));
        WebAppAPIUtils.putImageInTest(testId);
        Assert.assertTrue(allTestsPage.waitIsProjectDisplayed(testContext.getName()), "Test not displayed");
        BrowserManager.getBrowser().quit();
    }
}
