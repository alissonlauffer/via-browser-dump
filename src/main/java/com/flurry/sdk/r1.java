package com.flurry.sdk;

import com.flurry.android.b;

public final class r1 {
    public static final String b = "r1";
    private static r1 c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f187a = false;

    private r1() {
    }

    public static synchronized r1 b() {
        r1 r1Var;
        synchronized (r1.class) {
            if (c == null) {
                c = new r1();
            }
            r1Var = c;
        }
        return r1Var;
    }

    public final synchronized String a() {
        if (!this.f187a) {
            return null;
        }
        if (b.e() != null) {
            return b.e();
        }
        return h1.c().b();
    }
}
