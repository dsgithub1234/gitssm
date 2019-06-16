package com.itheima.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordUtils {

    private static BCryptPasswordEncoder bcryptPasswordEncoder=new BCryptPasswordEncoder();

    public static String getBcryptPassword(String password){
        return bcryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String s = getBcryptPassword("123");
        System.out.println(s);
    }
}
