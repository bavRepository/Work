package utils.enumfield;

public enum AuthorTableFieldEnum {

    ID("id"),
    NAME("name"),
    LOGIN("login"),
    EMAIL("email");

    private final String value;

    AuthorTableFieldEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
