package com.example.encrypt;

import static org.junit.Assert.*;

import org.junit.Test;

import javax.crypto.SecretKey;

public class AESTest {

    @Test
    public void AESencryptdecrypt() throws Exception {
        SecretKey key = null;
        try {
            key = AES.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Plaintext to encrypt
        String plainText = "Hello, World!";

        // Encrypt the plaintext
        String encryptedText = AES.encrypt(plainText, key);

        // Decrypt the ciphertext
        String decryptedText = AES.decrypt(encryptedText, key);

        // Asserting that the decrypted text matches the original plaintext
        assertEquals(decryptedText,"Hello, World!");
    }
    @Test
    public void keytest() throws Exception{
        SecretKey key1=AES.generateKey();
        SecretKey key2=AES.generateKey();
        assertNotEquals(key1,key2);

    }
    @Test
    public void Base64test() throws Exception {
        String plaintext="Hello World";
        String encryptedText1=Base64en.encodeToBase64(plaintext);
        String decryptedText1=Base64en.decodeFromBase64(encryptedText1);
        assertEquals(decryptedText1,"Hello World");
    }
    @Test
    public void SHAtest() throws Exception{
        String plaintext="Hello World";
        String SHA1= SHA256NR.SHA256Hash(plaintext);
        String SHA2=SHA256NR.SHA256Hash(plaintext);
        assertEquals(SHA1,SHA2);
    }

}