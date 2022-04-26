package com.userinnyeface.utils;

import java.util.Random;

public class DataMathWork {

    private static final int LEFT_LIMIT_CAPITAL = 65;
    private static final int RIGHT_LIMIT_CAPITAL = 90;
    private static final int LEFT_LIMIT_LOWERCASE = 97;
    private static final int RIGHT_LIMIT_LOWERCASE = 122;
    private static final int CYR_LEFT_LIMIT_CAPITAL = 1040;
    private static final int CYR_RIGHT_LIMIT_CAPITAL = 1071;
    private static final int DIG_LEFT_LIMIT_CAPITAL = 48;
    private static final int DIG_RIGHT_LIMIT_CAPITAL = 57;
    private static StringBuilder password;


    public static String getRandomStringValue(int subStrLength) {
        Random random = new Random();
        password = new StringBuilder(subStrLength);
        for (int i = 0; i < subStrLength; i++) {
            int randomLimitedCapitalInt = LEFT_LIMIT_CAPITAL + (int)
                    (random.nextFloat() * (RIGHT_LIMIT_CAPITAL - LEFT_LIMIT_CAPITAL + 1));
            password.append((char) +randomLimitedCapitalInt);
        }

        for (int i = 0; i < subStrLength; i++) {
            int randomLimitedLowercaseInt = LEFT_LIMIT_LOWERCASE + (int)
                    (random.nextFloat() * (RIGHT_LIMIT_LOWERCASE - LEFT_LIMIT_LOWERCASE + 1));
            password.append((char) +randomLimitedLowercaseInt);
        }

        int randomLimitedCyrInt = CYR_LEFT_LIMIT_CAPITAL + (int)
                (random.nextFloat() * (CYR_RIGHT_LIMIT_CAPITAL - CYR_LEFT_LIMIT_CAPITAL + 1));
        password.append((char) +randomLimitedCyrInt);

        int randomLimitedDigInt = DIG_LEFT_LIMIT_CAPITAL + (int)
                (random.nextFloat() * (DIG_RIGHT_LIMIT_CAPITAL - DIG_LEFT_LIMIT_CAPITAL + 1));
        password.append((char) +randomLimitedDigInt);

        return password.toString();
    }

    public static String addPasswordCharToRandomEmail(int length) {
        String strEmail = getRandomStringValue(length);

        return new StringBuilder().append(strEmail).append(password.toString().charAt(0)).toString();
    }

    public static String getRandomDomain(int subStrLength) {
        return new StringBuilder(getRandomStringValue(subStrLength)).toString();
    }
}