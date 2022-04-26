package com.vk.utils;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

import static aquality.selenium.browser.AqualityServices.getElementFactory;

public class DynamicElementBuilder {

    public static ITextBox getMessageTextBox(String post_id){
        ITextBox myMessageTextBox = getElementFactory().getTextBox(By.id(String.format("wpt%s_%s",
                TestData.OWNER_ID, post_id)), "my message");
        return myMessageTextBox;
    }

    public static ILink getPhotoLink(String post_id, String photo_id){
        ILink myPhotoLink = getElementFactory().getLink(By.xpath(String.format("//div[@id='post%s_%s'] //a[@data-photo-id='%s_%s']",
                TestData.OWNER_ID, post_id, TestData.OWNER_ID, photo_id)), "my Photo");
        return myPhotoLink;
    }

    public static IButton getNextCommentButton(String post_id){
        IButton showNextCommentButton = getElementFactory().getButton(By.xpath(String.format("//div[@id='post%s_%s'] //span[@class='js-replies_next_label']",
                TestData.OWNER_ID, post_id)), "next comment");
        return showNextCommentButton;
    }

    public static ITextBox getCommentTextBox(String post_id){
        ITextBox myCommentTextBox = getElementFactory().getTextBox(By.id(String.format("wpt%s_%s",
                TestData.OWNER_ID, post_id)), "my comment text");
        return myCommentTextBox;
    }

    public static ITextBox getCommentWrapperTextBox(String post_id){
        ITextBox commentWrapperTextBox = getElementFactory().getTextBox(By.id(String.format("replies%s_%s",
                TestData.OWNER_ID, post_id)), "Comment wrapper");
        return commentWrapperTextBox;
    }

    public static IButton getLikeButton(String post_id){
        IButton likeButton = getElementFactory().getButton(By.xpath(String.format("//div[@id='replies%s_%s']//a[contains(@class, 'like_btn') and contains(@class, '_like')]",
                TestData.OWNER_ID, post_id)), "next comment");
        return likeButton;
    }

    public static ITextBox getPostTextBox(String post_id){
        ITextBox myPostTextBox = getElementFactory().getTextBox(By.id(String.format("wpt%s_%s",
                TestData.OWNER_ID, post_id)), "my post");
        return myPostTextBox;
    }

}


