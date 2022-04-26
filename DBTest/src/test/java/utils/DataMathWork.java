package utils;

import java.util.Random;

public class DataMathWork {

    public static int getRandomValue(int max, int min){
        return new Random().nextInt(max - min + 1) + min;
    }
}
