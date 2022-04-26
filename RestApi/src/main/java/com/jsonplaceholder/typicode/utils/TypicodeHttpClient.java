package com.jsonplaceholder.typicode.utils;

import com.jsonplaceholder.typicode.model.Post;
import com.jsonplaceholder.typicode.model.User;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import java.util.List;
import java.util.Map;

public class TypicodeHttpClient extends HttpCLient{

    public static PostsResponse getPosts(String route){
        HttpResponse<JsonNode> response = getHttpResponse(route);
        int statusCode = response.getStatus();
        boolean isSuccess = response.isSuccess();
        List<Post> postsList = getObjectsList(route, Post[].class);
        return new PostsResponse(statusCode, isSuccess, postsList);
    }

    public static PostsResponse getPost(String route, String headRouteParam, Map<String, Object> param){
        HttpResponse<JsonNode> response = getHttpResponse(route, headRouteParam, param);
        int statusCode = response.getStatus();
        Post post = getObjectByRouteParam(route, headRouteParam, param, Post.class);
        return new PostsResponse(statusCode, post);
    }

    public static UsersResponse getUsers(String route){
        HttpResponse<JsonNode> response = getHttpResponse(route);
        int statusCode = response.getStatus();
        boolean isSuccess = response.isSuccess();
        List<User> usersList = getObjectsList(route, User[].class);
        return new UsersResponse(statusCode, isSuccess, usersList);
    }

    public static UsersResponse getUser(String route, String headRouteParam, Map<String, Object> param){
        HttpResponse<JsonNode> response = getHttpResponse(route, headRouteParam, param);
        int statusCode = response.getStatus();
        User user = getObjectByRouteParam(route, headRouteParam, param, User.class);
        return new UsersResponse(statusCode, user);
    }

    public static PostsResponse postNewPost(String route, Map<String, Object> fieldsData){
        HttpResponse<JsonNode> response = postHttpResponse(route, fieldsData);
        int statusCode = response.getStatus();
        Post post = postRequest(route, fieldsData, Post.class);
        return new PostsResponse(statusCode, post);
    }
}
