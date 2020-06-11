package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class n3 implements Comparable<n3> {

    /* renamed from: a  reason: collision with root package name */
    m3 f164a;
    public int b;
    public int c;
    JSONObject d;
    Map<String, c> e = new HashMap();

    public n3(n3 n3Var) {
        this.f164a = n3Var.f164a;
        this.b = n3Var.b;
        this.c = n3Var.c;
        this.d = n3Var.d;
        this.e = new HashMap(n3Var.e);
    }

    public final c a(String str) {
        return this.e.get(str);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(n3 n3Var) {
        n3 n3Var2 = n3Var;
        m3 m3Var = this.f164a;
        if (m3Var != n3Var2.f164a) {
            return m3Var == m3.c ? -1 : 1;
        }
        return this.b - n3Var2.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n3)) {
            return false;
        }
        n3 n3Var = (n3) obj;
        return this.f164a == n3Var.f164a && this.b == n3Var.b;
    }

    public final int hashCode() {
        return (this.f164a.hashCode() * 31) + this.b;
    }

    public final String toString() {
        return this.f164a + ":" + this.b + ":" + this.c;
    }

    public final Set<Map.Entry<String, c>> a() {
        return this.e.entrySet();
    }

    public final void a(n3 n3Var) {
        for (Map.Entry<String, c> entry : n3Var.a()) {
            String key = entry.getKey();
            if (!this.e.containsKey(key)) {
                this.e.put(key, entry.getValue());
            }
        }
    }

    public n3(m3 m3Var) {
        this.f164a = m3Var;
    }
}
