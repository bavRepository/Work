package webapplication.utils;

public enum ApiRouteParamNameEnum {

    VARIANT("variant"),
    PROJECT_ID("projectId"),
    SID("SID"),
    PROJECT_NAME("projectName"),
    TEST_NAME("testName"),
    METHOD_NAME("methodName"),
    ENV("env"),
    START_TIME("startTime"),
    BROWSER("browser"),
    TEST_ID("testId"),
    CONTENT("content");

    private final String value;

    ApiRouteParamNameEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
