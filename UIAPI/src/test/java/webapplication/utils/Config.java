package webapplication.utils;

public class Config {

    public static final String JSON_EXTENSION = ".json";
    public static final String BROWSER_NAME = FileIManager.getParameterValue("settings","browserName");
    public static final String SELENIUM_BASE_URL = FileIManager.getParameterValue("config","seleniumStartUrl");
    public static final String UNIREST_BASE_URL = FileIManager.getParameterValue("config","unirestStartUrl");
    public static final String DATE_MASK = FileIManager.getParameterValue("config","dateMask");
    public static final String SYSTEM_USER_NAME = System.getProperty("user.name");
    public static final String LiNE_SEPARATOR = System.getProperty("line.separator");
    public static final String LOG_FILE_RELATIVE_PATH = FileIManager.getParameterValue("config","logFileRelativePath");
}
