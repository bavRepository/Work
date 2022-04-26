package utils.enumfield;

public enum StatusTableFieldEnum {

    ID("id"),
    NAME("name");

    private final String value;

    StatusTableFieldEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
