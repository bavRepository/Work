package utils;

public class TestData {

    public static final int COUNT_TEST = Integer.valueOf(FileManager.getParameterValue("testData","countTest"));
    // first and second id numbers have matches for select from table 'test'
    public static final int MIN_TEST_ID = 1;
    public static final int MAX_TEST_ID = 9;
    // set status id value for update test
    public static final int MIN_STATUS_ID = 1;
    public static final int MAX_STATUS_ID = 3;
    // author table
    public static final String AUTHOR_NAME = FileManager.getParameterValue("testData","authorName");
    public static final String AUTHOR_LOGIN = FileManager.getParameterValue("testData","authorLogin");
    public static final String AUTHOR_EMAIL = FileManager.getParameterValue("testData","authorEmail");
    // project table
    public static final String CURRENT_PROJECT_NAME = FileManager.getParameterValue("testData","projectName");
    // session Id
    public static final int SESSION_ID = 1;
    // status Id
    public static final int STATUS_ID = 1;
}