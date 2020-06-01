package com.da.common;

public class RandomString {
    public static String rdMaThe(){
        String rdpw = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
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
