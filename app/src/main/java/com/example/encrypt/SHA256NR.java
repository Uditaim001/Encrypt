package com.example.encrypt;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256NR {
    public static void main(String[] args) {
        // Sample input string
//
    }

    // Method to compute the SHA-256 hash of a string
    public static String SHA256Hash(String input) throws NoSuchAlgorithmException {
        // Create a MessageDigest instance for SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Compute the hash as a byte array
        byte[] hashBytes = digest.digest(input.getBytes());

        // Convert the byte array to a hexadecimal string
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            // Convert each byte to a two-digit hexadecimal string
            String hex = Integer.toHexString(0xff & b);
            // Pad with leading zero if necessary
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
