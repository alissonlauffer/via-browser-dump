package com.flurry.sdk;

public enum bc {
    GET("GET", 0),
    PUT("PUT", 1),
    POST("POST", 2);
    
    String d;
    int e;

    private bc(String str, int i) {
        this.d = str;
        this.e = i;
    }

    public static bc a(int i) {
        if (i == 0) {
            return GET;
        }
        if (i == 1) {
            return PUT;
        }
        if (i != 2) {
            return null;
        }
        return POST;
    }
}
