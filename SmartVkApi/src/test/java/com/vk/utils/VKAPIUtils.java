package com.vk.utils;

import com.vk.HttpClient;
import com.vk.model.*;
import java.io.UnsupportedEncodingException;

public class VKAPIUtils extends HttpClient {

    public static WallSendMessage sendWallMessage(String randomText) {
        return postRequest(EnumAPIMethod.WALL_POST.getValue(), VKAPIFieldRequestData.wallMessageParams(randomText), WallSendMessage.class);
    }

    public static WallSavePhoto editWallMessageAndAddPhoto(String post_id, String randomText) throws UnsupportedEncodingException {
        WallGetUploadServer wallGetUploadServer = postRequest(EnumAPIMethod.PHOTOS_GET_WALL_UPLOAD_SERVER.getValue(), VKAPIFieldRequestData.photosWallUploadServerParams(), WallGetUploadServer.class);
        WallSendPhotoToServer wallSendPhotoToServer = postRequest(wallGetUploadServer.getResponse().getUpload_url(), VKAPIFieldRequestData.sendUpLoadPhotoToServerParams(), WallSendPhotoToServer.class);
        WallSavePhoto savePhoto = postRequestSavePhotoOnServer(EnumAPIMethod.PHOTOS_SAVE_WALL_PHOTO.getValue(), VKAPIFieldRequestData.savePhotoOnServer(wallSendPhotoToServer.getServer(), wallSendPhotoToServer.getHash()),wallSendPhotoToServer.getPhoto(), WallSavePhoto.class);
        postRequest(EnumAPIMethod.WALL_EDIT.getValue(), VKAPIFieldRequestData.editWallMessageWithSendPhoto(post_id, savePhoto.getResponse().get(0).getId(), randomText), WallEditPost.class);

        return savePhoto;
    }

    public static WallSendComment sendWallComment(String post_id) {
        return postRequest(EnumAPIMethod.WALL_CREATE_COMMENT.getValue(), VKAPIFieldRequestData.wallCommentParams(post_id), WallSendComment.class);
    }

    public static LikeGetList getLikesList(String comment_id) {
        return postRequest(EnumAPIMethod.LIKES_GET_LIST.getValue(), VKAPIFieldRequestData.wallOwnerCommentParams(comment_id), LikeGetList.class);
    }

    public static WallDelete wallDeletePost(String post_id) {
        return postRequest(EnumAPIMethod.WALL_DELETE.getValue(), VKAPIFieldRequestData.wallDeletePost(post_id), WallDelete.class);
    }

    public static boolean isTrueLikeOwner(String owner_id){
        return TestData.OWNER_ID.equals(owner_id);
    }

    public static boolean isIdExist(String post_id){
        return !post_id.isEmpty() && !post_id.equals(null);
    }

}
