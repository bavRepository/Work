package utils.enumfield;

public enum TestTableFieldEnum {

    ID("id"),
    NAME("name"),
    STATUS_ID("status_id"),
    METHOD_NAME("method_name"),
    PROJECT_ID("project_id"),
    SESSION_ID("session_id"),
    START_TIME("start_time"),
    END_TIME("end_time"),
    ENV("env"),
    BROWSER("browser"),
    AUTHOR_ID("author_id");

    private final String value;

    TestTableFieldEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
