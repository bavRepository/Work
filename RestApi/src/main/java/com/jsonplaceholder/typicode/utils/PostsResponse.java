package com.jsonplaceholder.typicode.utils;

import com.jsonplaceholder.typicode.model.Post;

import java.util.List;

public class PostsResponse {

    private int StatusCode;
    private boolean isSuccess;
    private List<Post> postList;
    private Post post;

    public PostsResponse(int statusCode, Post post) {
        StatusCode = statusCode;
        this.post = post;
    }

    public PostsResponse(int statusCode, boolean isSuccess, List<Post> postList) {
        StatusCode = statusCode;
        this.isSuccess = isSuccess;
        this.postList = postList;
    }


    public Post getPost() {
        return post;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    public List<Post> getPostList() {
        return postList;
    }

}
