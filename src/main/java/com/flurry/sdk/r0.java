package com.flurry.sdk;

public final class r0 {

    /* renamed from: a  reason: collision with root package name */
    private static r0 f186a;

    private r0() {
    }

    public static synchronized r0 a() {
        r0 r0Var;
        synchronized (r0.class) {
            if (f186a == null) {
                f186a = new r0();
            }
            r0Var = f186a;
        }
        return r0Var;
    }
}
