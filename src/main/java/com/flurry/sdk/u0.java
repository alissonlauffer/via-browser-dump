package com.flurry.sdk;

import java.util.Locale;

public final class u0 {

    /* renamed from: a  reason: collision with root package name */
    public static u0 f198a;

    private u0() {
    }

    public static synchronized u0 a() {
        u0 u0Var;
        synchronized (u0.class) {
            if (f198a == null) {
                f198a = new u0();
            }
            u0Var = f198a;
        }
        return u0Var;
    }

    public static String b() {
        return Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
    }
}
