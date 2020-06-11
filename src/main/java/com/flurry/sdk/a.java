package com.flurry.sdk;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final l3 f51a;
    public o3 b;

    public a(l3 l3Var, o3 o3Var) {
        this.f51a = l3Var;
        this.b = o3Var;
    }

    public final String a(String str, String str2, m3 m3Var) {
        c a2 = this.b.a(str, m3Var);
        if (a2 == null) {
            a2 = this.f51a.a(str);
        }
        return a2 != null ? a2.a() : str2;
    }

    public final int a(String str, int i, m3 m3Var) {
        c a2 = this.b.a(str, m3Var);
        if (a2 == null) {
            a2 = this.f51a.a(str);
        }
        if (a2 != null) {
            try {
                return Integer.decode(a2.a()).intValue();
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }
}
