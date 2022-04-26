package com.jsonplaceholder.typicode.utils;

public enum HttpStatusCode {

    OK(200),
    CREATED(201),
    NOT_FOUND(404);

    private final int value;

    HttpStatusCode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
