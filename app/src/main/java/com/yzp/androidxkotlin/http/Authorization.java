package com.yzp.androidxkotlin.http;

import android.text.format.Time;

import java.util.Random;

public class Authorization {
    String AUTH_SECRET_KEY = "OmOCClU3mnDIlXBs0heiLEYyDNVhB9AIu6eniwJgu6g=";
    private static Authorization mAuthorization;

    private Authorization() {

    }

    public static Authorization getInstance() {
        if (mAuthorization == null) {
            mAuthorization = new Authorization();
        }
        return mAuthorization;
    }


    public String getAuthorization() {
        return "Basic c2FiZXI6c2FiZXJfc2VjcmV0";
    }
    public String getContentType() {
        return "application/x-www-form-urlencoded";
    }


    private String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    private String getRFC3339Time() {
        Time time = new Time();
        time.setToNow();
        return time.format3339(false);
    }


}
