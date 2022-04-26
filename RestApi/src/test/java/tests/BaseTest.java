package tests;

import com.jsonplaceholder.typicode.utils.ConfigManager;
import com.jsonplaceholder.typicode.utils.HttpCLient;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setUp() {
        HttpCLient.setDefaultUrl(ConfigManager.getConfigParam("startUrl"));
    }
}