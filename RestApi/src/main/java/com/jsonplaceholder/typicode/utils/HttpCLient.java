package com.jsonplaceholder.typicode.utils;

import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class HttpCLient {

    public static void setDefaultUrl(String url){
        Unirest.config().defaultBaseUrl(url);
    }

    public static HttpResponse<JsonNode> getHttpResponse(String route){
        return Unirest.get(route).asJson();
    }

    public static HttpResponse<JsonNode> getHttpResponse(String route, String headRouteParam, Map<String, Object> routeParam){
        return Unirest.get(route + String.format("/{%s}", headRouteParam))
                .routeParam(routeParam)
                .asJson();
    }

    public static HttpResponse<JsonNode> postHttpResponse(String route, Map<String , Object> body) {
        return Unirest.post(route).fields(body).asJson();
    }

    public static HttpResponse<String> getStringResponse(String route, String headRouteParam, Map<String, Object> param){
        return Unirest.get(route + String.format("/{%s}", headRouteParam))
                .routeParam(param)
                .asString();
    }

    public static <T> T postRequest(String route, Map<String , Object> body, Class<T> clazz){
        String jsonString = Unirest.post(route)
                .fields(body)
                .asString().getBody();
        return new Gson().fromJson(jsonString, clazz);
    }

    public static <T> T getObjectByRouteParam(String route, String headRouteParam, Map<String, Object> param, Class<T> clazz){
        String jsonString = Unirest.get(route + String.format("/{%s}", headRouteParam))
                .routeParam(param)
                .asString().getBody();
        return new Gson().fromJson(jsonString, clazz);
    }

    public static <T> List<T> getObjectsList(String route, Class<T[]> clazz){
        String jsonString = Unirest.get(route).asString().getBody();
        T[] arr = new Gson().fromJson(jsonString, clazz);
        return Arrays.asList(arr);
    }
}
