package test;

import org.testng.annotations.AfterTest;
import util.BrowserManager;

public  class BaseTest {

    @AfterTest
    public void tearDown()
    {
        BrowserManager.getDriver().quit();
        BrowserManager.setDriverNull();
    }
}
