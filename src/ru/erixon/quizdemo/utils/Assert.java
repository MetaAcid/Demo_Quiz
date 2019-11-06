package ru.erixon.quizdemo.utils;

public class Assert {
    public static void assertNotEmpty(String s, String name) {
        if (s == null || s.length() == 0){
            throw new RuntimeException(name + " cannot be null or empty");
        }
    }
}
