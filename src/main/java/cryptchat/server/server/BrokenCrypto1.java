package com.ibm.integration.resources.java.BrokenCrypto1;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

// vulnerability:  DES algorithm

public class BrokenCrypto1 {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("DES");
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE,keyGen.generateKey());
        String message = "Message";
        byte[] encryptedMessage = cipher.doFinal(message.getBytes());
        System.out.println("Original String -> " + message);
        System.out.println("Encrypted String -> " + encryptedMessage);
    }
    
}
