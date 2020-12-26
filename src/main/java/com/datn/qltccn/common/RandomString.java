package com.datn.qltccn.common;

public class RandomString {
    public static String rdMaThe(String theID){
        String rdpw = "0123456789";
        StringBuilder sb = new StringBuilder(8);
        sb.append(theID);
        for (int i = 0; i < 5; i++) {

            int index
                    = (int)(rdpw.length()
                    * Math.random());
            sb.append(rdpw.charAt(index));
        }
        return sb.toString();
    }

    public static String rdPW() {
        String rdpw = "0123456789abcdefghiklmnopqrstuvxywzABCDEFGHIKLMNOPQRSTUVXYWZ";
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {

            int index
                    = (int)(rdpw.length()
                    * Math.random());
            sb.append(rdpw.charAt(index));
        }
        return sb.toString();
    }
}
