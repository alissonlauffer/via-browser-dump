package com.flurry.sdk;

import java.util.Locale;

/* renamed from: com.flurry.sdk.u0 */
public final class C0273u0 {

    /* renamed from: a */
    public static C0273u0 f762a;

    private C0273u0() {
    }

    /* renamed from: a */
    public static synchronized C0273u0 m716a() {
        C0273u0 u0Var;
        synchronized (C0273u0.class) {
            if (f762a == null) {
                f762a = new C0273u0();
            }
            u0Var = f762a;
        }
        return u0Var;
    }

    /* renamed from: b */
    public static String m717b() {
        return Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
    }
}
