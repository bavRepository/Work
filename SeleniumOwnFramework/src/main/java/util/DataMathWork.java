package util;

public class DataMathWork {

    private static final int OFFSET = 52;
    private static final int MIN_RANDOM_VALUE = 10000;
    private static final int MAX_RANDOM_VALUE = 100000000;

    public static int getRandomOffsetValue() {
        return -OFFSET + (int) (Math.random() * ((OFFSET - (-OFFSET)) + 1));
    }

    public static int getRandomValue() {
        return MIN_RANDOM_VALUE + (int) (Math.random() * MAX_RANDOM_VALUE);
    }

    public static boolean numbersCompare(String num){
        Log.infoLogger("Check if range value is correct");
        double value = Double.parseDouble(num);
        return value >= 0 && value <= 5;
    }

    public static String userNameCut(String name){
        Log.infoLogger("Cut user name from innerHTML");
        return name.substring(name.lastIndexOf(" ") + 1);
    }

    public static String getFileNameFromPath(String fileNameFromPath){
        Log.infoLogger("Cut file name from filePath");
        return fileNameFromPath.substring(fileNameFromPath.lastIndexOf("\\") + 1);
    }
}
