package com.vk.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import com.vk.utils.DynamicElementBuilder;
import org.openqa.selenium.By;

public class MyPage extends Form {

    public MyPage() {
        super(By.id("page_header_wrap"), "header");
    }

    public boolean waitForMessageDisplayed(String post_id, String message) {
        ITextBox myMessageTextBox = DynamicElementBuilder.getMessageTextBox(post_id);

        return myMessageTextBox.state().waitForDisplayed() &&
                myMessageTextBox.getText().equals(message);
    }

    public boolean isTheSamePhotoAdded(String post_id, String photo_id) {
        ILink myPhotoLink = DynamicElementBuilder.getPhotoLink(post_id, photo_id);
        myPhotoLink.getJsActions().scrollIntoView();
        return myPhotoLink.state().isDisplayed();
    }

    public boolean isMyCommentAdded(String post_id) {
        IButton showNextCommentButton = DynamicElementBuilder.getNextCommentButton(post_id);
        showNextCommentButton.click();
        ITextBox myCommentTextBox = DynamicElementBuilder.getCommentTextBox(post_id);
        return myCommentTextBox.state().isDisplayed();
    }

    public void setLike(String post_id) {
        ITextBox commentWrapperTextBox = DynamicElementBuilder.getCommentWrapperTextBox(post_id);
        commentWrapperTextBox.getMouseActions().moveMouseToElement();
        IButton likeButton = DynamicElementBuilder.getLikeButton(post_id);
        likeButton.click();
    }

    public boolean waitForPostNotDisplayed(String post_id) {
        ITextBox myPostTextBox = DynamicElementBuilder.getPostTextBox(post_id);
        return myPostTextBox.state().waitForNotDisplayed();
    }
}