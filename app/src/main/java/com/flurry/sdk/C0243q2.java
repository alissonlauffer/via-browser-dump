package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import com.flurry.sdk.C0082cn;
import com.flurry.sdk.C0125eb;
import com.flurry.sdk.C0127ec;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.flurry.sdk.q2 */
public class C0243q2 {

    /* renamed from: j */
    private static final String f685j = "q2";

    /* renamed from: k */
    private static C0243q2 f686k;

    /* renamed from: a */
    private final Map<Context, C0125eb> f687a = new WeakHashMap();

    /* renamed from: b */
    private final C0255r2 f688b = new C0255r2();

    /* renamed from: c */
    private final Object f689c = new Object();

    /* renamed from: d */
    public long f690d = 0;

    /* renamed from: e */
    private C0125eb f691e;

    /* renamed from: f */
    private boolean f692f;

    /* renamed from: g */
    private AtomicBoolean f693g = new AtomicBoolean(false);

    /* renamed from: h */
    private AbstractC0192m1<C0261s2> f694h = new C0244a();

    /* renamed from: i */
    private AbstractC0192m1<C0082cn> f695i = new C0245b();

    /* renamed from: com.flurry.sdk.q2$a */
    class C0244a implements AbstractC0192m1<C0261s2> {
        C0244a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.AbstractC0192m1
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo74a(C0261s2 s2Var) {
            C0243q2.this.m659o();
        }
    }

    /* renamed from: com.flurry.sdk.q2$b */
    class C0245b implements AbstractC0192m1<C0082cn> {
        C0245b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.AbstractC0192m1
        /* renamed from: a */
        public final /* synthetic */ void mo74a(C0082cn cnVar) {
            C0082cn cnVar2 = cnVar;
            Activity activity = cnVar2.f246b.get();
            if (activity == null) {
                C0260s1.m688e(C0243q2.f685j, "Activity has been destroyed, can't pass ActivityLifecycleEvent to adobject.");
                return;
            }
            int i = C0250g.f705a[cnVar2.f247c - 1];
            if (i == 1) {
                String str = C0243q2.f685j;
                C0260s1.m686c(3, str, "Automatic onStartSession for context:" + cnVar2.f246b);
                C0243q2.this.m657l(activity);
            } else if (i == 2) {
                String str2 = C0243q2.f685j;
                C0260s1.m686c(3, str2, "Automatic onEndSession for context:" + cnVar2.f246b);
                C0243q2.this.mo317j(activity);
            } else if (i == 3) {
                String str3 = C0243q2.f685j;
                C0260s1.m686c(3, str3, "Automatic onEndSession (destroyed) for context:" + cnVar2.f246b);
                C0243q2.this.mo317j(activity);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.q2$c */
    public class RunnableC0246c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f698a;

        RunnableC0246c(Context context) {
            this.f698a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C0243q2.this.m657l(this.f698a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.q2$d */
    public class C0247d extends AbstractRunnableC0040b3 {

        /* renamed from: d */
        final /* synthetic */ C0125eb f700d;

        /* renamed from: e */
        final /* synthetic */ Context f701e;

        C0247d(C0243q2 q2Var, C0125eb ebVar, Context context) {
            this.f700d = ebVar;
            this.f701e = context;
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            this.f700d.mo196a(C0125eb.EnumC0126a.f381c);
            C0127ec ecVar = new C0127ec();
            ecVar.f383b = new WeakReference<>(this.f701e);
            ecVar.f384c = this.f700d;
            ecVar.f385d = C0127ec.EnumC0128a.f391e;
            ecVar.mo261b();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.q2$e */
    public class C0248e extends AbstractRunnableC0040b3 {

        /* renamed from: d */
        final /* synthetic */ C0125eb f702d;

        C0248e(C0125eb ebVar) {
            this.f702d = ebVar;
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0243q2.m654f(C0243q2.this, this.f702d);
            C0243q2.this.f692f = false;
        }
    }

    /* renamed from: com.flurry.sdk.q2$f */
    class C0249f extends AbstractRunnableC0040b3 {
        C0249f() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0243q2.this.m659o();
        }
    }

    /* renamed from: com.flurry.sdk.q2$g */
    static /* synthetic */ class C0250g {

        /* renamed from: a */
        static final /* synthetic */ int[] f705a;

        static {
            int[] iArr = new int[C0082cn.EnumC0083a.m312a().length];
            f705a = iArr;
            try {
                iArr[C0082cn.EnumC0083a.f252e - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f705a[C0082cn.EnumC0083a.f253f - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f705a[C0082cn.EnumC0083a.f249b - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private C0243q2() {
        C0199n1.m528a().mo271e("com.flurry.android.sdk.ActivityLifecycleEvent", this.f695i);
        C0199n1.m528a().mo271e("com.flurry.android.sdk.FlurrySessionTimerEvent", this.f694h);
    }

    /* renamed from: a */
    public static synchronized C0243q2 m650a() {
        C0243q2 q2Var;
        synchronized (C0243q2.class) {
            if (f686k == null) {
                f686k = new C0243q2();
            }
            q2Var = f686k;
        }
        return q2Var;
    }

    /* renamed from: c */
    private synchronized void m651c(Context context, boolean z) {
        C0125eb ebVar;
        if (mo319m() != null && mo319m().mo198d() && z) {
            if (!this.f688b.mo327b()) {
                C0260s1.m686c(3, f685j, "A background session has already started. Not storing in context map because we use application context only.");
                return;
            }
            C0260s1.m686c(3, f685j, "Returning from a paused background session.");
        }
        if (mo319m() == null || mo319m().mo198d() || !z) {
            boolean z2 = true;
            if (mo319m() != null && mo319m().mo198d() && !z) {
                C0260s1.m688e(f685j, "New session started while background session is running.  Ending background session, then will create foreground session.");
                this.f693g.set(true);
                m655g(C0118e1.m386a().f361a, true);
                C0118e1.m386a().mo191g(new RunnableC0246c(context));
            } else if (this.f687a.get(context) == null) {
                this.f688b.mo328c();
                C0125eb m = mo319m();
                if (m == null) {
                    if (z) {
                        ebVar = new C0232p2();
                    } else {
                        ebVar = new C0125eb();
                    }
                    m = ebVar;
                    m.mo196a(C0125eb.EnumC0126a.f380b);
                    C0260s1.m701r(f685j, "Flurry session started for context:".concat(String.valueOf(context)));
                    C0127ec ecVar = new C0127ec();
                    ecVar.f383b = new WeakReference<>(context);
                    ecVar.f384c = m;
                    ecVar.f385d = C0127ec.EnumC0128a.f387a;
                    ecVar.mo261b();
                } else {
                    z2 = false;
                }
                this.f687a.put(context, m);
                synchronized (this.f689c) {
                    this.f691e = m;
                }
                this.f693g.set(false);
                C0260s1.m701r(f685j, "Flurry session resumed for context:".concat(String.valueOf(context)));
                C0127ec ecVar2 = new C0127ec();
                ecVar2.f383b = new WeakReference<>(context);
                ecVar2.f384c = m;
                ecVar2.f385d = C0127ec.EnumC0128a.f388b;
                ecVar2.mo261b();
                if (z2) {
                    C0118e1.m386a().mo191g(new C0247d(this, m, context));
                }
                this.f690d = 0;
            } else if (C0155h1.m459a().mo216d()) {
                C0260s1.m686c(3, f685j, "Session already started with context:".concat(String.valueOf(context)));
            } else {
                C0260s1.m701r(f685j, "Session already started with context:".concat(String.valueOf(context)));
            }
        } else {
            C0260s1.m688e(f685j, "A Flurry background session can't be started while a foreground session is running.");
        }
    }

    /* renamed from: f */
    static /* synthetic */ void m654f(C0243q2 q2Var, C0125eb ebVar) {
        synchronized (q2Var.f689c) {
            C0125eb ebVar2 = q2Var.f691e;
            if (ebVar2 == ebVar) {
                C0266t2.m703e().mo344d("ContinueSessionMillis", ebVar2);
                ebVar2.mo196a(C0125eb.EnumC0126a.f379a);
                q2Var.f691e = null;
            }
        }
    }

    /* renamed from: g */
    private synchronized void m655g(Context context, boolean z) {
        C0125eb remove = this.f687a.remove(context);
        if (z && mo319m() != null && mo319m().mo198d() && this.f688b.mo327b()) {
            m659o();
        } else if (remove != null) {
            C0260s1.m701r(f685j, "Flurry session paused for context:".concat(String.valueOf(context)));
            C0127ec ecVar = new C0127ec();
            ecVar.f383b = new WeakReference<>(context);
            ecVar.f384c = remove;
            C0235q0.m624b();
            ecVar.f386e = C0235q0.m627e();
            ecVar.f385d = C0127ec.EnumC0128a.f389c;
            ecVar.mo261b();
            if (m660p() == 0) {
                if (z) {
                    m659o();
                } else {
                    this.f688b.mo326a(remove.mo199e());
                }
                this.f690d = System.currentTimeMillis();
                return;
            }
            this.f690d = 0;
        } else if (C0155h1.m459a().mo216d()) {
            C0260s1.m686c(3, f685j, "Session cannot be ended, session not found for context:".concat(String.valueOf(context)));
        } else {
            C0260s1.m701r(f685j, "Session cannot be ended, session not found for context:".concat(String.valueOf(context)));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: l */
    private synchronized void m657l(Context context) {
        m651c(context, false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: o */
    private synchronized void m659o() {
        int p = m660p();
        if (p > 0) {
            C0260s1.m686c(5, f685j, "Session cannot be finalized, sessionContextCount:".concat(String.valueOf(p)));
            return;
        }
        C0125eb m = mo319m();
        if (m == null) {
            C0260s1.m686c(5, f685j, "Session cannot be finalized, current session not found");
            return;
        }
        String str = f685j;
        StringBuilder sb = new StringBuilder("Flurry ");
        sb.append(m.mo198d() ? "background" : "");
        sb.append(" session ended");
        C0260s1.m701r(str, sb.toString());
        C0127ec ecVar = new C0127ec();
        ecVar.f384c = m;
        ecVar.f385d = C0127ec.EnumC0128a.f390d;
        C0235q0.m624b();
        ecVar.f386e = C0235q0.m627e();
        ecVar.mo261b();
        C0118e1.m386a().mo191g(new C0248e(m));
    }

    /* renamed from: p */
    private synchronized int m660p() {
        return this.f687a.size();
    }

    /* renamed from: b */
    public final synchronized void mo315b(Context context) {
        if (context instanceof Activity) {
            if (C0155h1.m459a().mo216d()) {
                C0260s1.m686c(3, f685j, "bootstrap for context:".concat(String.valueOf(context)));
                m657l(context);
            }
        }
    }

    /* renamed from: i */
    public final synchronized void mo316i() {
        for (Map.Entry<Context, C0125eb> entry : this.f687a.entrySet()) {
            C0127ec ecVar = new C0127ec();
            ecVar.f383b = new WeakReference<>(entry.getKey());
            ecVar.f384c = entry.getValue();
            ecVar.f385d = C0127ec.EnumC0128a.f389c;
            C0235q0.m624b();
            ecVar.f386e = C0235q0.m627e();
            ecVar.mo261b();
        }
        this.f687a.clear();
        C0118e1.m386a().mo191g(new C0249f());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final synchronized void mo317j(Context context) {
        m655g(context, false);
    }

    /* renamed from: k */
    public final synchronized int mo318k() {
        if (this.f693g.get()) {
            return C0125eb.EnumC0126a.f380b;
        }
        C0125eb m = mo319m();
        if (m == null) {
            C0260s1.m686c(2, f685j, "Session not found. No active session");
            return C0125eb.EnumC0126a.f379a;
        }
        return m.mo200f();
    }

    /* renamed from: m */
    public final C0125eb mo319m() {
        C0125eb ebVar;
        synchronized (this.f689c) {
            ebVar = this.f691e;
        }
        return ebVar;
    }
}
