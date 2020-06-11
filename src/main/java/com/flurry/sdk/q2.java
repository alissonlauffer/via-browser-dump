package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import com.flurry.sdk.cn;
import com.flurry.sdk.eb;
import com.flurry.sdk.ec;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class q2 {
    /* access modifiers changed from: private */
    public static final String j = "q2";
    private static q2 k;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Context, eb> f181a = new WeakHashMap();
    private final r2 b = new r2();
    private final Object c = new Object();
    public long d = 0;
    private eb e;
    /* access modifiers changed from: private */
    public boolean f;
    private AtomicBoolean g = new AtomicBoolean(false);
    private m1<s2> h = new a();
    private m1<cn> i = new b();

    class a implements m1<s2> {
        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.m1
        public final /* bridge */ /* synthetic */ void a(s2 s2Var) {
            q2.this.f();
        }
    }

    class b implements m1<cn> {
        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.m1
        public final /* synthetic */ void a(cn cnVar) {
            cn cnVar2 = cnVar;
            Activity activity = cnVar2.b.get();
            if (activity == null) {
                s1.a(q2.j, "Activity has been destroyed, can't pass ActivityLifecycleEvent to adobject.");
                return;
            }
            int i = g.f185a[cnVar2.c - 1];
            if (i == 1) {
                String e = q2.j;
                s1.a(3, e, "Automatic onStartSession for context:" + cnVar2.b);
                q2.this.c(activity);
            } else if (i == 2) {
                String e2 = q2.j;
                s1.a(3, e2, "Automatic onEndSession for context:" + cnVar2.b);
                q2.this.b(activity);
            } else if (i == 3) {
                String e3 = q2.j;
                s1.a(3, e3, "Automatic onEndSession (destroyed) for context:" + cnVar2.b);
                q2.this.b(activity);
            }
        }
    }

    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f184a;

        c(Context context) {
            this.f184a = context;
        }

        public final void run() {
            q2.this.c(this.f184a);
        }
    }

    class d extends b3 {
        final /* synthetic */ eb d;
        final /* synthetic */ Context e;

        d(q2 q2Var, eb ebVar, Context context) {
            this.d = ebVar;
            this.e = context;
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            this.d.a(eb.a.c);
            ec ecVar = new ec();
            ecVar.b = new WeakReference<>(this.e);
            ecVar.c = this.d;
            ecVar.d = ec.a.e;
            ecVar.b();
        }
    }

    class e extends b3 {
        final /* synthetic */ eb d;

        e(eb ebVar) {
            this.d = ebVar;
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            q2.a(q2.this, this.d);
            boolean unused = q2.this.f = false;
        }
    }

    class f extends b3 {
        f() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            q2.this.f();
        }
    }

    static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f185a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Code restructure failed: missing block: B:9:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0017 */
        static {
            int[] iArr = new int[cn.a.a().length];
            f185a = iArr;
            iArr[cn.a.e - 1] = 1;
            f185a[cn.a.f - 1] = 2;
            f185a[cn.a.b - 1] = 3;
        }
    }

    private q2() {
        n1.a().a("com.flurry.android.sdk.ActivityLifecycleEvent", this.i);
        n1.a().a("com.flurry.android.sdk.FlurrySessionTimerEvent", this.h);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.flurry.sdk.q2.a(android.content.Context, boolean):void
     arg types: [android.content.Context, int]
     candidates:
      com.flurry.sdk.q2.a(com.flurry.sdk.q2, android.content.Context):void
      com.flurry.sdk.q2.a(com.flurry.sdk.q2, com.flurry.sdk.eb):void
      com.flurry.sdk.q2.a(android.content.Context, boolean):void */
    /* access modifiers changed from: private */
    public synchronized void c(Context context) {
        a(context, false);
    }

    public static synchronized q2 d() {
        q2 q2Var;
        synchronized (q2.class) {
            if (k == null) {
                k = new q2();
            }
            q2Var = k;
        }
        return q2Var;
    }

    /* access modifiers changed from: private */
    public synchronized void f() {
        int g2 = g();
        if (g2 > 0) {
            s1.a(5, j, "Session cannot be finalized, sessionContextCount:".concat(String.valueOf(g2)));
            return;
        }
        eb c2 = c();
        if (c2 == null) {
            s1.a(5, j, "Session cannot be finalized, current session not found");
            return;
        }
        String str = j;
        StringBuilder sb = new StringBuilder("Flurry ");
        sb.append(c2.a() ? "background" : "");
        sb.append(" session ended");
        s1.e(str, sb.toString());
        ec ecVar = new ec();
        ecVar.c = c2;
        ecVar.d = ec.a.d;
        q0.a();
        ecVar.e = q0.c();
        ecVar.b();
        e1.a().b(new e(c2));
    }

    private synchronized int g() {
        return this.f181a.size();
    }

    /* access modifiers changed from: package-private */
    public final synchronized void b(Context context) {
        b(context, false);
    }

    public final synchronized void a(Context context) {
        if (context instanceof Activity) {
            if (h1.c().a()) {
                s1.a(3, j, "bootstrap for context:".concat(String.valueOf(context)));
                c(context);
            }
        }
    }

    public final eb c() {
        eb ebVar;
        synchronized (this.c) {
            ebVar = this.e;
        }
        return ebVar;
    }

    private synchronized void b(Context context, boolean z) {
        eb remove = this.f181a.remove(context);
        if (z && c() != null && c().a() && this.b.a()) {
            f();
        } else if (remove != null) {
            s1.e(j, "Flurry session paused for context:".concat(String.valueOf(context)));
            ec ecVar = new ec();
            ecVar.b = new WeakReference<>(context);
            ecVar.c = remove;
            q0.a();
            ecVar.e = q0.c();
            ecVar.d = ec.a.c;
            ecVar.b();
            if (g() == 0) {
                if (z) {
                    f();
                } else {
                    this.b.a(remove.b());
                }
                this.d = System.currentTimeMillis();
                return;
            }
            this.d = 0;
        } else if (h1.c().a()) {
            s1.a(3, j, "Session cannot be ended, session not found for context:".concat(String.valueOf(context)));
        } else {
            s1.e(j, "Session cannot be ended, session not found for context:".concat(String.valueOf(context)));
        }
    }

    private synchronized void a(Context context, boolean z) {
        eb ebVar;
        if (c() != null && c().a() && z) {
            if (!this.b.a()) {
                s1.a(3, j, "A background session has already started. Not storing in context map because we use application context only.");
                return;
            }
            s1.a(3, j, "Returning from a paused background session.");
        }
        if (c() == null || c().a() || !z) {
            boolean z2 = true;
            if (c() != null && c().a() && !z) {
                s1.a(j, "New session started while background session is running.  Ending background session, then will create foreground session.");
                this.g.set(true);
                b(e1.a().f110a, true);
                e1.a().b(new c(context));
            } else if (this.f181a.get(context) == null) {
                this.b.b();
                eb c2 = c();
                if (c2 == null) {
                    if (z) {
                        ebVar = new p2();
                    } else {
                        ebVar = new eb();
                    }
                    c2 = ebVar;
                    c2.a(eb.a.b);
                    s1.e(j, "Flurry session started for context:".concat(String.valueOf(context)));
                    ec ecVar = new ec();
                    ecVar.b = new WeakReference<>(context);
                    ecVar.c = c2;
                    ecVar.d = ec.a.f116a;
                    ecVar.b();
                } else {
                    z2 = false;
                }
                this.f181a.put(context, c2);
                synchronized (this.c) {
                    this.e = c2;
                }
                this.g.set(false);
                s1.e(j, "Flurry session resumed for context:".concat(String.valueOf(context)));
                ec ecVar2 = new ec();
                ecVar2.b = new WeakReference<>(context);
                ecVar2.c = c2;
                ecVar2.d = ec.a.b;
                ecVar2.b();
                if (z2) {
                    e1.a().b(new d(this, c2, context));
                }
                this.d = 0;
            } else if (h1.c().a()) {
                s1.a(3, j, "Session already started with context:".concat(String.valueOf(context)));
            } else {
                s1.e(j, "Session already started with context:".concat(String.valueOf(context)));
            }
        } else {
            s1.a(j, "A Flurry background session can't be started while a foreground session is running.");
        }
    }

    public final synchronized int b() {
        if (this.g.get()) {
            return eb.a.b;
        }
        eb c2 = c();
        if (c2 == null) {
            s1.a(2, j, "Session not found. No active session");
            return eb.a.f115a;
        }
        return c2.c();
    }

    public final synchronized void a() {
        for (Map.Entry<Context, eb> entry : this.f181a.entrySet()) {
            ec ecVar = new ec();
            ecVar.b = new WeakReference<>(entry.getKey());
            ecVar.c = entry.getValue();
            ecVar.d = ec.a.c;
            q0.a();
            ecVar.e = q0.c();
            ecVar.b();
        }
        this.f181a.clear();
        e1.a().b(new f());
    }

    static /* synthetic */ void a(q2 q2Var, eb ebVar) {
        synchronized (q2Var.c) {
            if (q2Var.e == ebVar) {
                eb ebVar2 = q2Var.e;
                t2.a().b("ContinueSessionMillis", ebVar2);
                ebVar2.a(eb.a.f115a);
                q2Var.e = null;
            }
        }
    }
}
