package webapplication.utils;

public enum UITestColumnIndexEnum {

    NAME(1),
    METHOD(2),
    RESULT(3),
    START_TIME(4),
    END_TIME(5),
    DURATION(6);

    private final int value;

    UITestColumnIndexEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
