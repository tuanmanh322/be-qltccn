package com.datn.qltccn.common;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class ImageUtil {
    public static String convertByte2Base64(byte[] bytes){
        byte[] encodeBase64 = Base64.encodeBase64(bytes);
        String imageBase64 = "data:image/png;base64,";

        try {
            imageBase64 = imageBase64 + new String(encodeBase64, "UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return imageBase64;
    }
}
