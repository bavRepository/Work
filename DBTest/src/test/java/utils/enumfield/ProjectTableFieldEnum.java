package utils.enumfield;

public enum ProjectTableFieldEnum {

    ID("id"),
    NAME("name");

    private final String value;

    ProjectTableFieldEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
