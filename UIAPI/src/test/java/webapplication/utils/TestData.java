package webapplication.utils;

import java.util.Date;

public class TestData {

    public static final String LOGIN = FileIManager.getParameterValue("testData","login");
    public static final String PASSWORD = FileIManager.getParameterValue("testData","password");
    public static final String VARIANT = FileIManager.getParameterValue("testData","variant");
    public static final String PROJECT_NAME = FileIManager.getParameterValue("testData","projectName");
    public static final String UI_TEST_TABLE_STATUS_IN_PROGRESS = "In progress";
    public static final Date SID = new Date();
}
