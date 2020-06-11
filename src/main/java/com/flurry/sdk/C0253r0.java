package com.flurry.sdk;

/* renamed from: com.flurry.sdk.r0 */
public final class C0253r0 {

    /* renamed from: a */
    private static C0253r0 f711a;

    private C0253r0() {
    }

    /* renamed from: a */
    public static synchronized C0253r0 m676a() {
        C0253r0 r0Var;
        synchronized (C0253r0.class) {
            if (f711a == null) {
                f711a = new C0253r0();
            }
            r0Var = f711a;
        }
        return r0Var;
    }
}
