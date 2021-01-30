package com.flurry.android;

import com.flurry.sdk.C0088d;
import com.flurry.sdk.C0118e1;
import com.flurry.sdk.C0196m3;

/* renamed from: com.flurry.android.d */
public final class C0010d {

    /* renamed from: b */
    private static C0010d f60b;

    /* renamed from: a */
    private C0088d f61a = C0088d.m317b();

    private C0010d() {
    }

    /* renamed from: b */
    public static synchronized C0010d m153b() {
        C0010d dVar;
        synchronized (C0010d.class) {
            if (f60b == null) {
                if (C0118e1.m386a() != null) {
                    f60b = new C0010d();
                } else {
                    throw new IllegalStateException("Flurry SDK must be initialized before starting config");
                }
            }
            dVar = f60b;
        }
        return dVar;
    }

    /* renamed from: a */
    public final void mo82a() {
        this.f61a.mo158k();
    }

    /* renamed from: c */
    public final int mo83c(String str, int i) {
        return this.f61a.mo157h().mo90a(str, i, C0196m3.f548c);
    }

    /* renamed from: d */
    public final String mo84d(String str, String str2) {
        return this.f61a.mo157h().mo91b(str, str2, C0196m3.f548c);
    }

    public final String toString() {
        return this.f61a.toString();
    }
}
