package ru.erixon.quizdemo.utils;

import ru.erixon.quizdemo.model.exceptions.ApplicationException;

public class Assert {

    public static void assertNotEmpty(String s, String name) throws ApplicationException {
        if (s == null || s.length() == 0){
            throw new ApplicationException(name + " cannot be null or empty");
        }
    }

    public static void assertPositive(Number number, String name) throws ApplicationException {
        if (number.doubleValue() <= 0)
            throw new ApplicationException(name + " must be positive");
    }
}
