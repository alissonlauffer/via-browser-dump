package com.flurry.sdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class n1 {
    private static n1 c;

    /* renamed from: a  reason: collision with root package name */
    private final i1<String, a2<m1<?>>> f163a = new i1<>();
    private final i1<a2<m1<?>>, String> b = new i1<>();

    class a extends b3 {
        final /* synthetic */ m1 d;
        final /* synthetic */ l1 e;

        a(n1 n1Var, m1 m1Var, l1 l1Var) {
            this.d = m1Var;
            this.e = l1Var;
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            this.d.a(this.e);
        }
    }

    private n1() {
    }

    public static synchronized n1 a() {
        n1 n1Var;
        synchronized (n1.class) {
            if (c == null) {
                c = new n1();
            }
            n1Var = c;
        }
        return n1Var;
    }

    public final synchronized void b(String str, m1<?> m1Var) {
        if (!TextUtils.isEmpty(str)) {
            a2<m1<?>> a2Var = new a2<>(m1Var);
            this.f163a.b(str, a2Var);
            this.b.b(a2Var, str);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: MutableMD:(java.lang.String, boolean):java.util.List<V>
     arg types: [java.lang.String, int]
     candidates:
      MutableMD:(java.lang.String, com.flurry.sdk.a2<com.flurry.sdk.m1<?>>):void
      MutableMD:(java.lang.String, boolean):java.util.List<V> */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002d, code lost:
        return;
     */
    public final synchronized void a(String str, m1<?> m1Var) {
        if (!TextUtils.isEmpty(str)) {
            if (m1Var != null) {
                a2<m1<?>> a2Var = new a2<>(m1Var);
                boolean z = false;
                List<a2<m1<?>>> a2 = this.f163a.a(str, false);
                if (a2 != null) {
                    z = a2.contains(a2Var);
                }
                if (!z) {
                    this.f163a.a(str, a2Var);
                    this.b.a(a2Var, str);
                }
            }
        }
    }

    public final synchronized void a(m1<?> m1Var) {
        if (m1Var != null) {
            a2<m1<?>> a2Var = new a2<>(m1Var);
            for (String str : this.b.a(a2Var)) {
                this.f163a.b(str, a2Var);
            }
            this.b.b(a2Var);
        }
    }

    public final void a(l1 l1Var) {
        for (m1<?> m1Var : a(l1Var.a())) {
            e1.a().b(new a(this, m1Var, l1Var));
        }
    }

    private synchronized List<m1<?>> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<a2<m1<?>>> it = this.f163a.a(str).iterator();
        while (it.hasNext()) {
            m1<?> m1Var = it.next().get();
            if (m1Var == null) {
                it.remove();
            } else {
                arrayList.add(m1Var);
            }
        }
        return arrayList;
    }
}
