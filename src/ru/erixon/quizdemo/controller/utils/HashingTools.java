package ru.erixon.quizdemo.controller.utils;

import javax.xml.bind.DatatypeConverter;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingTools {
    public static String hash(char[] msg) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            CharBuffer cb = CharBuffer.wrap(msg);
            ByteBuffer bb = StandardCharsets.UTF_8.encode(cb);
            md.update(bb);
            byte[] digest = md.digest();
            return DatatypeConverter.printHexBinary(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
