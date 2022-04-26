package utils.enumfield;

public enum SessionTableFieldEnum {

    ID("id"),
    SESSION_KEY("session_key"),
    CREATED_TIME("created_time"),
    BUILD_NUMBER("build_number");

    private final String value;

    SessionTableFieldEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
