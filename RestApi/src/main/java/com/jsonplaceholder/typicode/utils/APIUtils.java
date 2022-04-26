package com.jsonplaceholder.typicode.utils;

import com.google.gson.Gson;
import com.jsonplaceholder.typicode.model.IModel;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class APIUtils {

    private static Gson gson = new Gson();
    private static Writer writer;
    private static Reader reader;
    private static final String EMPTY_BODY = "{}";

    public static void getSerialize(List list, String filePathParam) throws IOException {
        writer = Files.newBufferedWriter(Paths.get(filePathParam));
        gson.toJson(list, writer);
        writer.close();
    }

    public static void getSerialize(IModel obj, String filePathParam) throws IOException {
        writer = Files.newBufferedWriter(Paths.get(filePathParam));
        gson.toJson(obj, writer);
        writer.close();
    }

    public static void getSerialize(String obj, String filePathParam) throws IOException {
        writer = Files.newBufferedWriter(Paths.get(filePathParam));
        gson.toJson(obj, writer);
        writer.close();
    }

    public static <T> List<T> getDeSerializeListObj(String filePathParam, Class<T[]> clazz) throws IOException {
        reader = Files.newBufferedReader(Paths.get(filePathParam));
        T[] arr = new Gson().fromJson(reader, clazz);
        reader.close();
        return Arrays.asList(arr);
    }

    public static <T> T getDeSerializeObj(String filePathParam, Class<T> clazz) throws IOException {
        reader = Files.newBufferedReader(Paths.get(filePathParam));
        T obj = new Gson().fromJson(reader, clazz);
        reader.close();
        return obj;
    }

    public static boolean isRequestBodyEmpty(String body){
        return body.equals(EMPTY_BODY);
    }
}