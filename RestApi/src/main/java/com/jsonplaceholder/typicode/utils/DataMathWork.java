package com.jsonplaceholder.typicode.utils;

import com.jsonplaceholder.typicode.model.Post;
import com.jsonplaceholder.typicode.model.User;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class DataMathWork {

    private static final int LEFT_LIMIT = 97;
    private static final int RIGHT_LIMIT = 122;

    public static String getRandomStringValue(int subStrLength) {
        Random random = new Random();
        StringBuilder randomString = new StringBuilder(subStrLength);
        for (int i = 0; i < subStrLength; i++) {
            int randomLimitedCapitalInt = LEFT_LIMIT + (int)
                    (random.nextFloat() * (RIGHT_LIMIT - LEFT_LIMIT + 1));
            randomString.append((char) +randomLimitedCapitalInt);
        }

        return randomString.toString();
    }

    public static boolean isPostIdSorted(List<Post> posts) {
        boolean isSored = true;

        for (int i = 1; i < posts.size(); i++) {

            if (posts. get(i - 1).getId() > posts.get(i).getId())
                isSored = false;
        }
        return isSored;
    }

    public static int getUserObjectIndexById(List<User> users , String id){

       return IntStream.range(0, users.size())
                .filter(i -> users.get(i).getId() == Integer.valueOf(id))
                .findFirst().orElse(-1);
    }
}
