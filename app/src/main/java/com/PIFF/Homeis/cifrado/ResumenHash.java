package com.PIFF.Homeis.cifrado;

import android.util.Base64;

import org.jsoup.Connection;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ResumenHash {
    public static String cifrarPassword(String user_password){
        String pass_cifrada = "";
        byte[] password_a_bytes = user_password.getBytes();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(password_a_bytes);
            byte[] resumen = md.digest();
            pass_cifrada = Base64.encodeToString(resumen,Base64.DEFAULT);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return pass_cifrada;
    }
}
