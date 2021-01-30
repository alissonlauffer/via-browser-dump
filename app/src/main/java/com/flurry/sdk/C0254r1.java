package com.flurry.sdk;

import com.flurry.android.C0004b;

/* renamed from: com.flurry.sdk.r1 */
public final class C0254r1 {

    /* renamed from: b */
    public static final String f712b = "r1";

    /* renamed from: c */
    private static C0254r1 f713c;

    /* renamed from: a */
    public boolean f714a = false;

    private C0254r1() {
    }

    /* renamed from: a */
    public static synchronized C0254r1 m677a() {
        C0254r1 r1Var;
        synchronized (C0254r1.class) {
            if (f713c == null) {
                f713c = new C0254r1();
            }
            r1Var = f713c;
        }
        return r1Var;
    }

    /* renamed from: b */
    public final synchronized String mo325b() {
        if (!this.f714a) {
            return null;
        }
        if (C0004b.m134f() != null) {
            return C0004b.m134f();
        }
        return C0155h1.m459a().mo217e();
    }
}
