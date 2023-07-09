package com.platzi.util;

public class StringUtil {
    
    public static String repeat(String str, int times) {
        if (times < 0) {
            throw new IllegalArgumentException("times must be positive");
        }
        String result = "";
        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;
    }
}