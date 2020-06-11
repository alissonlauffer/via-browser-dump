package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.n3 */
public final class C0202n3 implements Comparable<C0202n3> {

    /* renamed from: a */
    C0196m3 f584a;

    /* renamed from: b */
    public int f585b;

    /* renamed from: c */
    public int f586c;

    /* renamed from: d */
    JSONObject f587d;

    /* renamed from: e */
    Map<String, C0058c> f588e = new HashMap();

    public C0202n3(C0202n3 n3Var) {
        this.f584a = n3Var.f584a;
        this.f585b = n3Var.f585b;
        this.f586c = n3Var.f586c;
        this.f587d = n3Var.f587d;
        this.f588e = new HashMap(n3Var.f588e);
    }

    /* renamed from: a */
    public final C0058c mo273a(String str) {
        return this.f588e.get(str);
    }

    /* renamed from: b */
    public final Set<Map.Entry<String, C0058c>> mo274b() {
        return this.f588e.entrySet();
    }

    /* renamed from: c */
    public final void mo275c(C0202n3 n3Var) {
        for (Map.Entry<String, C0058c> entry : n3Var.mo274b()) {
            String key = entry.getKey();
            if (!this.f588e.containsKey(key)) {
                this.f588e.put(key, entry.getValue());
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(C0202n3 n3Var) {
        C0202n3 n3Var2 = n3Var;
        C0196m3 m3Var = this.f584a;
        if (m3Var != n3Var2.f584a) {
            return m3Var == C0196m3.f548c ? -1 : 1;
        }
        return this.f585b - n3Var2.f585b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0202n3)) {
            return false;
        }
        C0202n3 n3Var = (C0202n3) obj;
        return this.f584a == n3Var.f584a && this.f585b == n3Var.f585b;
    }

    public final int hashCode() {
        return (this.f584a.hashCode() * 31) + this.f585b;
    }

    public final String toString() {
        return this.f584a + ":" + this.f585b + ":" + this.f586c;
    }

    public C0202n3(C0196m3 m3Var) {
        this.f584a = m3Var;
    }
}
