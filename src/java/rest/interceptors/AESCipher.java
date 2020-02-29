/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.interceptors;

import javax.crypto.*;
import java.io.*;
import java.security.spec.KeySpec;

import javax.crypto.spec.*;
/*
 Author  : Mark Kpodo
 Date    : 2/27/2020
 Email   : markkpodo26@gmail.com
 Twitter : https://twitter.com/mark_kpodo
 Github  : https://github.com/processor1
 */
public class AESCipher {

    private final KeyGenerator keyGen;
    private final Cipher encryptCipher, decryptChipher;

    public Cipher getEncryptCipher() {
        return encryptCipher;
    }

    public Cipher getDecryptCipher() {
        return decryptChipher;
    }

     public AESCipher(String passwordText, final byte[] salt) throws Exception {
        keyGen = KeyGenerator.getInstance("AES");
        final char[] password = passwordText.toCharArray();
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(password, salt, 65536, 128);
        SecretKey tmp = factory.generateSecret(spec);
        SecretKey aesKey = new SecretKeySpec(tmp.getEncoded(), "AES");
        encryptCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(aesKey.getEncoded());
        encryptCipher.init(Cipher.ENCRYPT_MODE, aesKey, ivParameterSpec);
        decryptChipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        decryptChipher.init(Cipher.DECRYPT_MODE, aesKey, ivParameterSpec);
     }

    public byte[] encrypt(String plainText) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, encryptCipher);
        try {
            cipherOutputStream.write(plainText.getBytes());
            cipherOutputStream.flush();
            cipherOutputStream.close();
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            return null;
        }
    }

    public String decrypt(byte[] cipherText) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(cipherText);
        CipherInputStream cipherInputStream = null;
        try {
            cipherInputStream = new CipherInputStream(inputStream, decryptChipher);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = cipherInputStream.read(buf)) >= 0) {
                output.write(buf, 0, bytesRead);
            }
            cipherInputStream.close();
            return new String(output.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
