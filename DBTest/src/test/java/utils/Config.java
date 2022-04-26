package utils;

public class Config {

    public static final String JSON_EXTENSION = ".json";
    public static final String BROWSER_NAME = FileManager.getParameterValue("settings","browserName");
    public static final String DB_HOST = FileManager.getParameterValue("config","db_host");
    public static final String DB_PORT = FileManager.getParameterValue("config","db_port");
    public static final String DB_USER = FileManager.getParameterValue("config","db_user");
    public static final String DB_PASS = FileManager.getParameterValue("config","db_pass");
    public static final String DB_NAME = FileManager.getParameterValue("config","db_name");
    public static final String SYSTEM_USER_NAME = System.getProperty("user.name");
    public static final String DATE_MASK = "y-MM-dd HH:mm:ss";

}
