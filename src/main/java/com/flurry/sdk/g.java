package com.flurry.sdk;

public final class g {
    public static final g c = new g(a.SUCCEED, null);
    public static final g d = new g(a.NO_CHANGE, null);

    /* renamed from: a  reason: collision with root package name */
    String f125a;
    a b;

    public enum a {
        SUCCEED(1),
        NO_CHANGE(0),
        IO(-1),
        NOT_VALID_JSON(-2),
        AUTHENTICATE(-3),
        UNKNOWN_CERTIFICATE(-4),
        OTHER(-5);
        
        int h;

        private a(int i2) {
            this.h = i2;
        }
    }

    public g(a aVar, String str) {
        this.b = aVar;
        this.f125a = str;
    }

    public final String toString() {
        return "[Error:" + this.b.name() + "] " + this.f125a;
    }
}
