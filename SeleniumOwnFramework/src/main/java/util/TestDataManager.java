package util;


import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataManager {

    private static final String TEST_DATA_PATH = "src\\test\\resources\\TestData";

    public static String getTestData(String prop) {

        Properties properties = new Properties();
        FileInputStream in = null;
        String param = null;
        try {
            in = new FileInputStream(TEST_DATA_PATH);
            properties.load(in);
            if (properties.getProperty(prop) == null)
                throw new NullPointerException("Undefined parameter name");
            param = properties.getProperty(prop).trim();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return param;
    }

    @DataProvider(name = "user_name")
    public static Object[][] userNum() {
        return new Object[][]{{"1"}, {"3"}};
    }
}
