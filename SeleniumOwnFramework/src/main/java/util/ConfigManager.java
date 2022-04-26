package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public abstract class ConfigManager {

    private static final String BROWSER_CONFIG_PATH = "src\\main\\resources\\BrowserConfig";

    public static String getParam(String prop) {

        Properties properties = new Properties();
        FileInputStream in = null;
        String param = null;
        try {
            in = new FileInputStream(BROWSER_CONFIG_PATH);
            properties.load(in);
            if (properties.getProperty(prop) == null)
                throw new NullPointerException("Undefined parameter name");
            param = properties.getProperty(prop).replace(" ", "");
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
}
