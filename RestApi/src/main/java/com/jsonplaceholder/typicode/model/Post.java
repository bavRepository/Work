package com.jsonplaceholder.typicode.model;

import java.util.Objects;

public class Post implements IModel {

    private int userId;
    private int id;
    private String title;
    private String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "{" + "\n\t" +
                "\"userId\": " + userId + ",\n\t" +
                "\"id\": " + id + ",\n\t" +
                "\"title\": " + title + ",\n\t" +
                "\"body\": " + body + ",\n" +
                " }" + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return userId == post.userId && Objects.equals(title, post.title) && Objects.equals(body, post.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, title, body);
    }
}