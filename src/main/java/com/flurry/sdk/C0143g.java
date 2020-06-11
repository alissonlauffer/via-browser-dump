package com.flurry.sdk;

/* renamed from: com.flurry.sdk.g */
public final class C0143g {

    /* renamed from: c */
    public static final C0143g f436c = new C0143g(EnumC0144a.SUCCEED, null);

    /* renamed from: d */
    public static final C0143g f437d = new C0143g(EnumC0144a.NO_CHANGE, null);

    /* renamed from: a */
    String f438a;

    /* renamed from: b */
    EnumC0144a f439b;

    /* renamed from: com.flurry.sdk.g$a */
    public enum EnumC0144a {
        SUCCEED(1),
        NO_CHANGE(0),
        IO(-1),
        NOT_VALID_JSON(-2),
        AUTHENTICATE(-3),
        UNKNOWN_CERTIFICATE(-4),
        OTHER(-5);
        

        /* renamed from: h */
        int f448h;

        private EnumC0144a(int i) {
            this.f448h = i;
        }
    }

    public C0143g(EnumC0144a aVar, String str) {
        this.f439b = aVar;
        this.f438a = str;
    }

    public final String toString() {
        return "[Error:" + this.f439b.name() + "] " + this.f438a;
    }
}
