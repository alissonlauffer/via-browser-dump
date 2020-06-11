package com.flurry.sdk;

/* renamed from: com.flurry.sdk.ax */
public enum EnumC0031ax {
    COMPLETE(1),
    TIMEOUT(2),
    INVALID_RESPONSE(3),
    PENDING_COMPLETION(4);
    

    /* renamed from: e */
    int f106e;

    private EnumC0031ax(int i) {
        this.f106e = i;
    }

    /* renamed from: a */
    public static EnumC0031ax m196a(int i) {
        if (i == 1) {
            return COMPLETE;
        }
        if (i == 2) {
            return TIMEOUT;
        }
        if (i == 3) {
            return INVALID_RESPONSE;
        }
        if (i != 4) {
            return null;
        }
        return PENDING_COMPLETION;
    }
}
