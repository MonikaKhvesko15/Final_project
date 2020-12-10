package com.epam.web.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CustomCipher {
    private static final String CIPHER_FORMAT = "%02x";

    public static String encrypt(String string) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        byte[] data = messageDigest.digest(string.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            stringBuilder.append(String.format(CIPHER_FORMAT, data[i]));
        }
        return stringBuilder.toString();
    }
}
