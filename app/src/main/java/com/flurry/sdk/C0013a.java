package com.flurry.sdk;

/* renamed from: com.flurry.sdk.a */
public class C0013a {

    /* renamed from: a */
    public final C0186l3 f62a;

    /* renamed from: b */
    public C0226o3 f63b;

    public C0013a(C0186l3 l3Var, C0226o3 o3Var) {
        this.f62a = l3Var;
        this.f63b = o3Var;
    }

    /* renamed from: a */
    public final int mo90a(String str, int i, C0196m3 m3Var) {
        C0058c a = this.f63b.mo296a(str, m3Var);
        if (a == null) {
            a = this.f62a.mo262a(str);
        }
        if (a != null) {
            try {
                return Integer.decode(a.mo132a()).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    /* renamed from: b */
    public final String mo91b(String str, String str2, C0196m3 m3Var) {
        C0058c a = this.f63b.mo296a(str, m3Var);
        if (a == null) {
            a = this.f62a.mo262a(str);
        }
        return a != null ? a.mo132a() : str2;
    }
}
