/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.interceptors;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

/*
 Author  : Mark Kpodo
 Date    : 2/27/2020
 Email   : markkpodo26@gmail.com
 Twitter : https://twitter.com/mark_kpodo
 Github  : https://github.com/processor1
 */
public class CipherInterceptor implements ReaderInterceptor, WriterInterceptor {

    private final AESCipher cipher;

    CipherInterceptor()throws Exception {
        final byte[] salt = {1, 2, 4, 8, 16, 32, 64, -64, -32, -16, -8, -4, -2, -1};
        final String password = "java1995";
        cipher = new AESCipher(password,salt);
    }

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
        InputStream old = context.getInputStream();
        context.setInputStream(new CipherInputStream(old, cipher.getDecryptCipher()));
        try {
            return context.proceed();
        } finally {
            context.setInputStream(old);
        }
    }

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
        OutputStream old = context.getOutputStream();
        context.setOutputStream(new CipherOutputStream(old, cipher.getEncryptCipher()));
        try {
            context.proceed();
            context.getHeaders().add("X-Encryption", "AES");
        } finally {
            context.setOutputStream(old);
        }
    }

}
