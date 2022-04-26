package webapplication.utils;

public enum APIMethodEnum {

    GET_TOKEN(FileIManager.getParameterValue("config","postGetToken")),
    GET_TESTS(FileIManager.getParameterValue("config","postGetTests")),
    PUT_TEST(FileIManager.getParameterValue("config","postPutTest")),
    PUT_LOG_IN_TEST(FileIManager.getParameterValue("config","postPutLogInTest")),
    PUT_IMAGE_IN_TEST(FileIManager.getParameterValue("config","postPutImageInTest"));

    private final String value;

    APIMethodEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
