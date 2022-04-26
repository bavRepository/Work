package tests;

import com.userinnyeface.utils.BrowserManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    @BeforeTest
    public void setUp() {
        BrowserManager.getBrowser().maximize();
    }

    @AfterTest
    public void tearDown() {
        BrowserManager.getBrowser().quit();
    }
}