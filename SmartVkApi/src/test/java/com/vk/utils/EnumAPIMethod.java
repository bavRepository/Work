package com.vk.utils;

public enum EnumAPIMethod {

    WALL_POST(ConfigManager.getParameterValue("wallPost")),
    WALL_EDIT(ConfigManager.getParameterValue("wallEdit")),
    WALL_DELETE(ConfigManager.getParameterValue("wallDelete")),
    PHOTOS_GET_WALL_UPLOAD_SERVER(ConfigManager.getParameterValue("photosGetWallUploadServer")),
    PHOTOS_SAVE_WALL_PHOTO(ConfigManager.getParameterValue("photosSaveWallPhoto")),
    WALL_CREATE_COMMENT(ConfigManager.getParameterValue("wallCreateComment")),
    LIKES_GET_LIST(ConfigManager.getParameterValue("getLikesList")),
    TYPE_OF_FILE(ConfigManager.getParameterValue("typeOfUploadFile")),
    TYPE_OF_LIKE(ConfigManager.getParameterValue("typeOfLike"));

    private final String value;

    EnumAPIMethod(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
