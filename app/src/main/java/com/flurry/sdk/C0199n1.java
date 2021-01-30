package com.flurry.sdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.flurry.sdk.n1 */
public final class C0199n1 {

    /* renamed from: c */
    private static C0199n1 f579c;

    /* renamed from: a */
    private final C0162i1<String, C0026a2<AbstractC0192m1<?>>> f580a = new C0162i1<>();

    /* renamed from: b */
    private final C0162i1<C0026a2<AbstractC0192m1<?>>, String> f581b = new C0162i1<>();

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.n1$a */
    public class C0200a extends AbstractRunnableC0040b3 {

        /* renamed from: d */
        final /* synthetic */ AbstractC0192m1 f582d;

        /* renamed from: e */
        final /* synthetic */ AbstractC0184l1 f583e;

        C0200a(C0199n1 n1Var, AbstractC0192m1 m1Var, AbstractC0184l1 l1Var) {
            this.f582d = m1Var;
            this.f583e = l1Var;
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            this.f582d.mo74a(this.f583e);
        }
    }

    private C0199n1() {
    }

    /* renamed from: a */
    public static synchronized C0199n1 m528a() {
        C0199n1 n1Var;
        synchronized (C0199n1.class) {
            if (f579c == null) {
                f579c = new C0199n1();
            }
            n1Var = f579c;
        }
        return n1Var;
    }

    /* renamed from: b */
    private synchronized List<AbstractC0192m1<?>> m529b(String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<C0026a2<AbstractC0192m1<?>>> it = this.f580a.mo230a(str).iterator();
        while (it.hasNext()) {
            AbstractC0192m1<?> m1Var = it.next().get();
            if (m1Var == null) {
                it.remove();
            } else {
                arrayList.add(m1Var);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public final void mo269c(AbstractC0184l1 l1Var) {
        for (AbstractC0192m1<?> m1Var : m529b(l1Var.mo260a())) {
            C0118e1.m386a().mo191g(new C0200a(this, m1Var, l1Var));
        }
    }

    /* renamed from: d */
    public final synchronized void mo270d(AbstractC0192m1<?> m1Var) {
        if (m1Var != null) {
            C0026a2<AbstractC0192m1<?>> a2Var = new C0026a2<>(m1Var);
            for (String str : this.f581b.mo230a(a2Var)) {
                this.f580a.mo236g(str, a2Var);
            }
            this.f581b.mo235f(a2Var);
        }
    }

    /* renamed from: e */
    public final synchronized void mo271e(String str, AbstractC0192m1<?> m1Var) {
        if (!TextUtils.isEmpty(str)) {
            if (m1Var != null) {
                C0026a2<AbstractC0192m1<?>> a2Var = new C0026a2<>(m1Var);
                boolean z = false;
                List<C0026a2<AbstractC0192m1<?>>> b = this.f580a.mo231b(str, false);
                if (b != null) {
                    z = b.contains(a2Var);
                }
                if (!z) {
                    this.f580a.mo233d(str, a2Var);
                    this.f581b.mo233d(a2Var, str);
                }
            }
        }
    }

    /* renamed from: f */
    public final synchronized void mo272f(String str, AbstractC0192m1<?> m1Var) {
        if (!TextUtils.isEmpty(str)) {
            C0026a2<AbstractC0192m1<?>> a2Var = new C0026a2<>(m1Var);
            this.f580a.mo236g(str, a2Var);
            this.f581b.mo236g(a2Var, str);
        }
    }
}
