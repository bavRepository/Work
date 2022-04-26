package utils;

public class QueryManager {

    public static String getParameterValue(String key) {
        return Environment.getCurrentJsonFile("dbQuery.json").getValue(String.format("/%s", key)).toString();
    }

}
