package com.example.encrypt;
import android.annotation.SuppressLint;

import java.util.Base64;
public class Base64en {


    // Method to encode a string to Base64
    @SuppressLint("NewApi")
    public static String encodeToBase64(String input) {
        // Get bytes from the string
        byte[] encodedBytes = new byte[0];
        encodedBytes = Base64.getEncoder().encode(input.getBytes());

        // Convert bytes to string and return
        return new String(encodedBytes);
    }

    // Method to decode a Base64 encoded string
    @SuppressLint("NewApi")
    public static String decodeFromBase64(String input) {
        // Get bytes from the Base64 encoded string
        byte[] decodedBytes = new byte[0];
        decodedBytes = Base64.getDecoder().decode(input);

        // Convert bytes to string and return
        return new String(decodedBytes);
    }

}
