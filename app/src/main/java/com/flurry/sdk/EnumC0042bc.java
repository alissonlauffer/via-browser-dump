package com.flurry.sdk;

/* renamed from: com.flurry.sdk.bc */
public enum EnumC0042bc {
    GET("GET", 0),
    PUT("PUT", 1),
    POST("POST", 2);
    

    /* renamed from: d */
    String f139d;

    /* renamed from: e */
    int f140e;

    private EnumC0042bc(String str, int i) {
        this.f139d = str;
        this.f140e = i;
    }

    /* renamed from: a */
    public static EnumC0042bc m230a(int i) {
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
