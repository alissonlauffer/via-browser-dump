package com.flurry.sdk;

import android.content.Context;
import com.flurry.android.FlurryEventRecordStatus;
import com.flurry.sdk.C0125eb;
import com.flurry.sdk.C0127ec;
import com.google.android.instantapps.InstantApps;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.flurry.sdk.z3 */
public class C0329z3 implements AbstractC0282v1 {

    /* renamed from: k */
    private static final String f898k = "z3";

    /* renamed from: a */
    public C0285w f899a;

    /* renamed from: b */
    public C0180l0 f900b;

    /* renamed from: c */
    public C0302x f901c;

    /* renamed from: d */
    public C0142f3 f902d;

    /* renamed from: e */
    public boolean f903e = false;

    /* renamed from: f */
    private final Object f904f = new Object();

    /* renamed from: g */
    private Queue<C0320y3> f905g = new LinkedList();

    /* renamed from: h */
    private Queue<C0320y3> f906h = new LinkedList();

    /* renamed from: i */
    private Queue<C0309x3> f907i = new LinkedList();

    /* renamed from: j */
    private final AbstractC0192m1<C0127ec> f908j = new C0330a();

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.z3$a */
    public class C0330a implements AbstractC0192m1<C0127ec> {
        C0330a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.AbstractC0192m1
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo74a(C0127ec ecVar) {
            if (C0331b.f910a[ecVar.f385d - 1] == 1) {
                C0329z3.m901g(C0329z3.this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.z3$b */
    public static /* synthetic */ class C0331b {

        /* renamed from: a */
        static final /* synthetic */ int[] f910a;

        /* renamed from: b */
        static final /* synthetic */ int[] f911b;

        static {
            int[] iArr = new int[C0125eb.EnumC0126a.m407a().length];
            f911b = iArr;
            try {
                iArr[C0125eb.EnumC0126a.f379a - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f911b[C0125eb.EnumC0126a.f380b - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f911b[C0125eb.EnumC0126a.f381c - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[C0127ec.EnumC0128a.m408a().length];
            f910a = iArr2;
            try {
                iArr2[C0127ec.EnumC0128a.f391e - 1] = 1;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: e */
    public static synchronized C0329z3 m900e() {
        C0329z3 z3Var;
        synchronized (C0329z3.class) {
            z3Var = (C0329z3) C0118e1.m386a().mo188b(C0329z3.class);
        }
        return z3Var;
    }

    /* renamed from: g */
    static /* synthetic */ void m901g(C0329z3 z3Var) {
        C0260s1.m688e(f898k, "Flushing deferred events queues.");
        synchronized (z3Var.f904f) {
            while (z3Var.f905g.peek() != null) {
                m902i(z3Var.f905g.poll());
            }
            while (z3Var.f907i.peek() != null) {
                m904k(z3Var.f907i.poll());
            }
            while (z3Var.f906h.peek() != null) {
                m906m(z3Var.f906h.poll());
            }
        }
    }

    /* renamed from: i */
    private static FlurryEventRecordStatus m902i(C0320y3 y3Var) {
        C0204o0 j = m903j();
        return j != null ? j.mo280a(y3Var.f874a, y3Var.f875b, y3Var.f876c, y3Var.f877d) : FlurryEventRecordStatus.kFlurryEventFailed;
    }

    /* renamed from: j */
    public static C0204o0 m903j() {
        C0125eb m = C0243q2.m650a().mo319m();
        if (m == null) {
            return null;
        }
        return (C0204o0) m.mo201g(C0204o0.class);
    }

    /* renamed from: k */
    private static void m904k(C0309x3 x3Var) {
        C0204o0 j = m903j();
        if (j != null) {
            j.mo284k(x3Var);
        }
    }

    /* renamed from: l */
    private synchronized int m905l() {
        return C0243q2.m650a().mo318k();
    }

    /* renamed from: m */
    private static void m906m(C0320y3 y3Var) {
        C0204o0 j = m903j();
        if (j != null) {
            j.mo285l(y3Var.f874a, y3Var.f875b);
        }
    }

    @Override // com.flurry.sdk.AbstractC0282v1
    /* renamed from: a */
    public void mo228a(Context context) {
        C0125eb.m400c(C0204o0.class);
        this.f900b = new C0180l0();
        this.f899a = new C0285w();
        this.f901c = new C0302x();
        this.f902d = new C0142f3();
        C0199n1.m528a().mo271e("com.flurry.android.sdk.FlurrySessionEvent", this.f908j);
        if (!C0328z2.m892g(context, "android.permission.INTERNET")) {
            C0260s1.m693j(f898k, "Application must declare permission: android.permission.INTERNET");
        }
        if (!C0328z2.m892g(context, "android.permission.ACCESS_NETWORK_STATE")) {
            C0260s1.m701r(f898k, "It is highly recommended that the application declare permission: android.permission.ACCESS_NETWORK_STATE");
        }
        int identifier = context.getResources().getIdentifier("FLURRY_IS_YAHOO_APP", "bool", context.getPackageName());
        if (identifier != 0) {
            this.f903e = context.getResources().getBoolean(identifier);
            String str = f898k;
            C0260s1.m697n(str, "Found FLURRY_IS_YAHOO_APP resource id. Value: " + this.f903e);
        }
        C0254r1 a = C0254r1.m677a();
        try {
            Class.forName("com.google.android.instantapps.InstantApps");
            a.f714a = InstantApps.isInstantApp(context);
            String str2 = C0254r1.f712b;
            C0260s1.m688e(str2, "isInstantApp: " + String.valueOf(a.f714a));
        } catch (ClassNotFoundException unused) {
            C0260s1.m688e(C0254r1.f712b, "isInstantApps dependency is not added");
        }
    }

    /* renamed from: b */
    public final FlurryEventRecordStatus mo374b(String str, Map<String, String> map, int i) {
        return mo376d(str, map, false, i);
    }

    /* renamed from: c */
    public final FlurryEventRecordStatus mo375c(String str, Map<String, String> map, boolean z) {
        return mo376d(str, map, z, 0);
    }

    /* renamed from: d */
    public final FlurryEventRecordStatus mo376d(String str, Map<String, String> map, boolean z, int i) {
        C0320y3 y3Var = new C0320y3(str, map, z, i);
        synchronized (this.f904f) {
            int i2 = C0331b.f911b[m905l() - 1];
            if (i2 == 1) {
                String str2 = f898k;
                C0260s1.m688e(str2, "There is no active Flurry session. Adding this event to deferred queue and flush them when the session initializes. Event: " + y3Var.f874a);
                this.f905g.add(y3Var);
                return FlurryEventRecordStatus.kFlurryEventLoggingDelayed;
            } else if (i2 == 2) {
                String str3 = f898k;
                C0260s1.m688e(str3, "Waiting for Flurry session to initialize before logging event: " + y3Var.f874a);
                this.f905g.add(y3Var);
                return FlurryEventRecordStatus.kFlurryEventLoggingDelayed;
            } else if (i2 != 3) {
                return FlurryEventRecordStatus.kFlurryEventFailed;
            } else {
                return m902i(y3Var);
            }
        }
    }

    /* renamed from: f */
    public final void mo377f(C0309x3 x3Var) {
        synchronized (this.f904f) {
            int i = C0331b.f911b[m905l() - 1];
            if (i == 1) {
                String str = f898k;
                C0260s1.m688e(str, "There is no active Flurry session. Adding this logging error to deferred queue and flush them when the session initializes. Error: " + x3Var.f841a);
                this.f907i.add(x3Var);
            } else if (i == 2) {
                String str2 = f898k;
                C0260s1.m688e(str2, "Waiting for Flurry session to initialize before logging error: " + x3Var.f841a);
                this.f907i.add(x3Var);
            } else if (i == 3) {
                m904k(x3Var);
            }
        }
    }

    /* renamed from: h */
    public final void mo378h(String str, String str2, Throwable th, Map<String, String> map) {
        C0142f3 f3Var;
        boolean z = str != null && "uncaught".equals(str);
        C0309x3 x3Var = new C0309x3(str, str2, th.getClass().getName(), th, C0151g3.m451a(z), map);
        if (z && (f3Var = this.f902d) != null) {
            List<C0124e3> b = f3Var.mo206b();
            x3Var.f847g = b;
            String str3 = f898k;
            C0260s1.m686c(4, str3, "Total breadcrumbs - " + b.size());
        }
        mo377f(x3Var);
    }
}
