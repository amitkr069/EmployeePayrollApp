package com.util;

import java.security.MessageDigest;

public class PasswordUtil {

    public static String hashPassword(String password) {

        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();

            for(byte b : bytes)
                sb.append(String.format("%02x", b));

            return sb.toString();

        } catch(Exception e) {
            return null;
        }
    }

    public static boolean verifyPassword(String password, String storedHash) {

        String hash = hashPassword(password);
        return hash.equals(storedHash);
    }
}
