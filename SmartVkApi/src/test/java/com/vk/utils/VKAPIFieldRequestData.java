package com.vk.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class VKAPIFieldRequestData {

    private static Map<String , Object> paramsSave;
        public static Map wallMessageParams(String randomText){
        paramsSave = new HashMap<>();
        paramsSave.put("owner_id", TestData.OWNER_ID);
        paramsSave.put("message", randomText);
        paramsSave.put("access_token", TestData.ACCESS_TOKEN);
        paramsSave.put("v", Config.V);
        return paramsSave;
    }

    public static Map photosWallUploadServerParams(){
        paramsSave = new HashMap<>();
        paramsSave.put("owner_id", TestData.OWNER_ID);
        paramsSave.put("access_token", TestData.ACCESS_TOKEN);
        paramsSave.put("v", Config.V);
        return paramsSave;
    }

    public static Map sendUpLoadPhotoToServerParams(){
        paramsSave = new HashMap<>();
        paramsSave.put(EnumAPIMethod.TYPE_OF_FILE.getValue(), new File(TestData.UPLOAD_FILE));
        return paramsSave;
    }

    public static Map savePhotoOnServer(String server, String hash) {
        paramsSave = new HashMap<>();
        paramsSave.put("user_id",TestData.OWNER_ID);
        paramsSave.put("server", server);
        paramsSave.put("hash", hash);
        paramsSave.put("access_token", TestData.ACCESS_TOKEN);
        paramsSave.put("v", Config.V);
        return paramsSave;
    }

    public static Map editWallMessageWithSendPhoto(String post_id, String photoId, String randomText){
        paramsSave = new HashMap<>();
        paramsSave.put("owner_id", TestData.OWNER_ID);
        paramsSave.put("post_id", post_id);
        paramsSave.put("attachments", String.format("photo%s_%s",TestData.OWNER_ID, photoId));
        paramsSave.put("message", randomText);
        paramsSave.put("access_token", TestData.ACCESS_TOKEN);
        paramsSave.put("v", Config.V);
        return paramsSave;
    }

    public static Map wallCommentParams(String post_id){
        paramsSave = new HashMap<>();
        paramsSave.put("owner_id", TestData.OWNER_ID);
        paramsSave.put("post_id", post_id);
        paramsSave.put("message", DataMathWork.getRandomStringValue(TestData.RANDOM_STR_LENGTH));
        paramsSave.put("access_token", TestData.ACCESS_TOKEN);
        paramsSave.put("v", Config.V);
        return paramsSave;
    }

    public static Map wallOwnerCommentParams(String comment_id){
        paramsSave = new HashMap<>();
        paramsSave.put("owner_id", TestData.OWNER_ID);
        paramsSave.put("type", EnumAPIMethod.TYPE_OF_LIKE.getValue());
        paramsSave.put("extended", "1");
        paramsSave.put("item_id", comment_id);
        paramsSave.put("access_token", TestData.ACCESS_TOKEN);
        paramsSave.put("v", Config.V);
        return paramsSave;
    }

    public static Map wallDeletePost(String post_id){
        paramsSave = new HashMap<>();
        paramsSave.put("owner_id", TestData.OWNER_ID);
        paramsSave.put("post_id", post_id);
        paramsSave.put("access_token", TestData.ACCESS_TOKEN);
        paramsSave.put("v", Config.V);
        return paramsSave;
    }
}
