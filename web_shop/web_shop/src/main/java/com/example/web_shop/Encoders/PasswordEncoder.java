package com.example.web_shop.Encoders;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoder {

    public static String hashPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            byte[] bytes = messageDigest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : bytes) {
                stringBuilder.append(String.format("%02x", b));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
