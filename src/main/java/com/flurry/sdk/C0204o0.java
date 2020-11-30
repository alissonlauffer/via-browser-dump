package com.flurry.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.TextUtils;
import com.flurry.android.FlurryEventRecordStatus;
import com.flurry.sdk.AbstractC0066c2;
import com.flurry.sdk.C0054by;
import com.flurry.sdk.C0127ec;
import com.flurry.sdk.C0129ep;
import com.flurry.sdk.C0188m0;
import com.flurry.sdk.C0275u2;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* renamed from: com.flurry.sdk.o0 */
public class C0204o0 implements C0275u2.AbstractC0276a {

    /* renamed from: E */
    static final String f591E = "o0";

    /* renamed from: F */
    static int f592F = 500;

    /* renamed from: G */
    static int f593G = 10;

    /* renamed from: H */
    static int f594H = 1000;

    /* renamed from: I */
    static int f595I = 160000;

    /* renamed from: J */
    static int f596J = 50;

    /* renamed from: A */
    boolean f597A;

    /* renamed from: B */
    boolean f598B = true;

    /* renamed from: C */
    final AbstractC0192m1<C0259s0> f599C = new C0205a();

    /* renamed from: D */
    private final AbstractC0192m1<C0127ec> f600D;

    /* renamed from: a */
    private final AtomicInteger f601a = new AtomicInteger(0);

    /* renamed from: b */
    private final AtomicInteger f602b = new AtomicInteger(0);

    /* renamed from: c */
    private final List<C0188m0> f603c = new ArrayList();

    /* renamed from: d */
    private final Map<String, List<String>> f604d = new HashMap();

    /* renamed from: e */
    private final Map<String, String> f605e = new HashMap();

    /* renamed from: f */
    private final Map<String, C0161i0> f606f = new HashMap();

    /* renamed from: g */
    private final List<C0167j0> f607g = new ArrayList();

    /* renamed from: h */
    private final List<C0154h0> f608h = new ArrayList();

    /* renamed from: i */
    private final List<String> f609i = new ArrayList();

    /* renamed from: j */
    private final C0028a4 f610j = new C0028a4();

    /* renamed from: k */
    WeakReference<C0125eb> f611k;

    /* renamed from: l */
    File f612l;

    /* renamed from: m */
    C0174k1<List<C0188m0>> f613m;

    /* renamed from: n */
    public boolean f614n;

    /* renamed from: o */
    private long f615o;

    /* renamed from: p */
    private String f616p;

    /* renamed from: q */
    private String f617q;

    /* renamed from: r */
    boolean f618r;

    /* renamed from: s */
    String f619s;

    /* renamed from: t */
    byte f620t;

    /* renamed from: u */
    Long f621u;

    /* renamed from: v */
    private int f622v = -1;

    /* renamed from: w */
    private boolean f623w = true;

    /* renamed from: x */
    private int f624x = 0;

    /* renamed from: y */
    private int f625y = 0;

    /* renamed from: z */
    private int f626z = 0;

    /* renamed from: com.flurry.sdk.o0$a */
    class C0205a implements AbstractC0192m1<C0259s0> {

        /* renamed from: com.flurry.sdk.o0$a$a */
        class C0206a extends AbstractRunnableC0040b3 {
            C0206a() {
            }

            @Override // com.flurry.sdk.AbstractRunnableC0040b3
            /* renamed from: a */
            public final void mo121a() {
                C0204o0 o0Var = C0204o0.this;
                C0235q0.m624b();
                o0Var.m545n(true, C0235q0.m627e());
            }
        }

        C0205a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.AbstractC0192m1
        /* renamed from: a */
        public final /* synthetic */ void mo74a(C0259s0 s0Var) {
            C0118e1.m386a().mo191g(new C0206a());
        }
    }

    /* renamed from: com.flurry.sdk.o0$b */
    class C0207b implements AbstractC0192m1<C0127ec> {
        C0207b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.AbstractC0192m1
        /* renamed from: a */
        public final /* synthetic */ void mo74a(C0127ec ecVar) {
            C0127ec ecVar2 = ecVar;
            if (C0204o0.this.f611k == null || ecVar2.f384c == C0204o0.this.f611k.get()) {
                int i = C0223q.f655a[ecVar2.f385d - 1];
                if (i == 1) {
                    C0204o0 o0Var = C0204o0.this;
                    C0125eb ebVar = ecVar2.f384c;
                    Context context = ecVar2.f383b.get();
                    o0Var.f611k = new WeakReference<>(ebVar);
                    C0266t2 e = C0266t2.m703e();
                    o0Var.f618r = ((Boolean) e.mo341a("LogEvents")).booleanValue();
                    e.mo342b("LogEvents", o0Var);
                    String str = C0204o0.f591E;
                    C0260s1.m686c(4, str, "initSettings, LogEvents = " + o0Var.f618r);
                    o0Var.f619s = (String) e.mo341a("UserId");
                    e.mo342b("UserId", o0Var);
                    C0260s1.m686c(4, str, "initSettings, UserId = " + o0Var.f619s);
                    o0Var.f620t = ((Byte) e.mo341a("Gender")).byteValue();
                    e.mo342b("Gender", o0Var);
                    C0260s1.m686c(4, str, "initSettings, Gender = " + ((int) o0Var.f620t));
                    o0Var.f621u = (Long) e.mo341a("Age");
                    e.mo342b("Age", o0Var);
                    C0260s1.m686c(4, str, "initSettings, BirthDate = " + o0Var.f621u);
                    o0Var.f598B = ((Boolean) e.mo341a("analyticsEnabled")).booleanValue();
                    e.mo342b("analyticsEnabled", o0Var);
                    C0260s1.m686c(4, str, "initSettings, AnalyticsEnabled = " + o0Var.f598B);
                    o0Var.f612l = context.getFileStreamPath(".flurryagent." + Integer.toString(C0118e1.m386a().f365e.hashCode(), 16));
                    o0Var.f613m = new C0174k1<>(context.getFileStreamPath(".yflurryreport." + Long.toString(C0328z2.m899n(C0118e1.m386a().f365e), 16)), ".yflurryreport.", 1, new C0208c(o0Var));
                    o0Var.f597A = ebVar.mo198d();
                    o0Var.mo283h(context);
                    o0Var.mo286m(true);
                    if (C0329z3.m900e().f899a != null) {
                        C0118e1.m386a().mo191g(new C0209d(o0Var));
                    }
                    C0118e1.m386a().mo191g(new C0210e());
                    C0118e1.m386a().mo191g(new C0211f());
                    C0118e1.m386a().mo191g(new C0212g());
                    if (C0044bs.m232a().mo124g()) {
                        C0118e1.m386a().mo191g(new C0213h());
                    } else {
                        C0199n1.m528a().mo271e("com.flurry.android.sdk.IdProviderFinishedEvent", o0Var.f599C);
                    }
                } else if (i == 2) {
                    C0204o0 o0Var2 = C0204o0.this;
                    ecVar2.f383b.get();
                    o0Var2.mo281f();
                } else if (i == 3) {
                    C0204o0 o0Var3 = C0204o0.this;
                    ecVar2.f383b.get();
                    o0Var3.mo287p();
                } else if (i == 4) {
                    C0199n1.m528a().mo272f("com.flurry.android.sdk.FlurrySessionEvent", C0204o0.this.f600D);
                    C0204o0.this.mo282g(ecVar2.f386e);
                }
            }
        }
    }

    /* renamed from: com.flurry.sdk.o0$c */
    class C0208c implements AbstractC0201n2<List<C0188m0>> {
        C0208c(C0204o0 o0Var) {
        }

        @Override // com.flurry.sdk.AbstractC0201n2
        /* renamed from: a */
        public final AbstractC0185l2<List<C0188m0>> mo100a(int i) {
            return new C0175k2(new C0188m0.C0189a());
        }
    }

    /* renamed from: com.flurry.sdk.o0$d */
    class C0209d extends AbstractRunnableC0040b3 {
        C0209d(C0204o0 o0Var) {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0329z3.m900e().f899a.mo355d();
        }
    }

    /* renamed from: com.flurry.sdk.o0$e */
    class C0210e extends AbstractRunnableC0040b3 {
        C0210e() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0204o0.this.m551u();
        }
    }

    /* renamed from: com.flurry.sdk.o0$f */
    class C0211f extends AbstractRunnableC0040b3 {
        C0211f() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0204o0.m550t(C0204o0.this);
        }
    }

    /* renamed from: com.flurry.sdk.o0$g */
    class C0212g extends AbstractRunnableC0040b3 {
        C0212g() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0204o0.m552v(C0204o0.this);
        }
    }

    /* renamed from: com.flurry.sdk.o0$h */
    class C0213h extends AbstractRunnableC0040b3 {
        C0213h() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0204o0 o0Var = C0204o0.this;
            C0235q0.m624b();
            o0Var.m545n(true, C0235q0.m627e());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.o0$i */
    public class C0214i extends AbstractRunnableC0040b3 {
        C0214i(C0204o0 o0Var) {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0302x xVar = C0329z3.m900e().f901c;
            xVar.f213c = false;
            C0118e1.m386a().mo191g(new AbstractC0066c2.C0071e());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.o0$j */
    public class C0215j extends AbstractRunnableC0040b3 {
        C0215j(C0204o0 o0Var) {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0329z3.m900e().f899a.mo358n();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.o0$k */
    public class C0216k extends AbstractRunnableC0040b3 {

        /* renamed from: d */
        final /* synthetic */ long f634d;

        C0216k(C0204o0 o0Var, long j) {
            this.f634d = j;
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0329z3.m900e().f899a.mo356e(this.f634d);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.o0$l */
    public class C0217l extends AbstractRunnableC0040b3 {
        C0217l() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0204o0.this.m553w();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.o0$m */
    public class C0218m extends AbstractRunnableC0040b3 {

        /* renamed from: d */
        final /* synthetic */ long f636d;

        /* renamed from: e */
        final /* synthetic */ long f637e;

        /* renamed from: f */
        final /* synthetic */ long f638f;

        /* renamed from: g */
        final /* synthetic */ int f639g;

        /* renamed from: h */
        final /* synthetic */ String f640h;

        /* renamed from: i */
        final /* synthetic */ String f641i;

        /* renamed from: j */
        final /* synthetic */ Map f642j;

        C0218m(long j, long j2, long j3, int i, String str, String str2, Map map) {
            this.f636d = j;
            this.f637e = j2;
            this.f638f = j3;
            this.f639g = i;
            this.f640h = str;
            this.f641i = str2;
            this.f642j = map;
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0204o0.m543i(C0204o0.this, this.f636d, this.f637e, this.f638f, this.f639g, this.f640h, this.f641i, this.f642j);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.o0$n */
    public class C0219n extends AbstractRunnableC0040b3 {

        /* renamed from: com.flurry.sdk.o0$n$a */
        class C0220a extends AbstractRunnableC0040b3 {
            C0220a(C0219n nVar) {
            }

            @Override // com.flurry.sdk.AbstractRunnableC0040b3
            /* renamed from: a */
            public final void mo121a() {
                C0329z3.m900e().f901c.f213c = true;
            }
        }

        C0219n() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            if (C0204o0.this.f598B && C0329z3.m900e().f899a != null) {
                C0329z3.m900e().f899a.mo359s();
            }
            if (C0329z3.m900e().f901c != null) {
                C0118e1.m386a().mo191g(new C0220a(this));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.o0$o */
    public class C0221o extends AbstractRunnableC0040b3 {

        /* renamed from: d */
        final /* synthetic */ long f645d;

        /* renamed from: e */
        final /* synthetic */ long f646e;

        /* renamed from: f */
        final /* synthetic */ long f647f;

        /* renamed from: g */
        final /* synthetic */ int f648g;

        /* renamed from: h */
        final /* synthetic */ String f649h;

        /* renamed from: i */
        final /* synthetic */ String f650i;

        /* renamed from: j */
        final /* synthetic */ Map f651j;

        C0221o(long j, long j2, long j3, int i, String str, String str2, Map map) {
            this.f645d = j;
            this.f646e = j2;
            this.f647f = j3;
            this.f648g = i;
            this.f649h = str;
            this.f650i = str2;
            this.f651j = map;
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0204o0.m543i(C0204o0.this, this.f645d, this.f646e, this.f647f, this.f648g, this.f649h, this.f650i, this.f651j);
            C0204o0.this.m545n(false, this.f645d);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.o0$p */
    public class RunnableC0222p implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f653a;

        /* renamed from: b */
        final /* synthetic */ Map f654b;

        RunnableC0222p(C0204o0 o0Var, String str, Map map) {
            this.f653a = str;
            this.f654b = map;
        }

        public final void run() {
            C0329z3.m900e().f899a.mo357j(this.f653a, this.f654b);
        }
    }

    /* renamed from: com.flurry.sdk.o0$q */
    static /* synthetic */ class C0223q {

        /* renamed from: a */
        static final /* synthetic */ int[] f655a;

        static {
            int[] iArr = new int[C0127ec.EnumC0128a.m408a().length];
            f655a = iArr;
            try {
                iArr[C0127ec.EnumC0128a.f387a - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f655a[C0127ec.EnumC0128a.f388b - 1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f655a[C0127ec.EnumC0128a.f389c - 1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f655a[C0127ec.EnumC0128a.f390d - 1] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public C0204o0() {
        C0207b bVar = new C0207b();
        this.f600D = bVar;
        C0199n1.m528a().mo271e("com.flurry.android.sdk.FlurrySessionEvent", bVar);
    }

    /* renamed from: A */
    private synchronized void m539A() {
        mo286m(false);
        C0235q0.m624b();
        long e = C0235q0.m627e();
        long g = C0235q0.m629g();
        long i = C0235q0.m631i();
        int m = C0235q0.m635m() - 1;
        String j = C0235q0.m632j();
        String k = C0235q0.m633k();
        Map<String, String> l = C0235q0.m634l();
        if (this.f598B && C0329z3.m900e().f899a != null) {
            C0118e1.m386a().mo191g(new C0216k(this, e));
        }
        C0118e1.m386a().mo191g(new C0217l());
        if (C0044bs.m232a().mo124g()) {
            C0118e1.m386a().mo191g(new C0218m(e, g, i, m, j, k, l));
        }
    }

    /* renamed from: c */
    private synchronized C0188m0 m540c(long j, long j2, long j3, int i, String str, String str2, Map<String, String> map) {
        C0188m0 m0Var;
        C0198n0 n0Var = new C0198n0();
        n0Var.f571s = ((Boolean) C0266t2.m703e().mo341a("IncludeBackgroundSessionsInMetrics")).booleanValue();
        if (this.f597A) {
            n0Var.f570r = C0129ep.EnumC0130a.BACKGROUND.f399e;
        } else {
            n0Var.f570r = C0129ep.EnumC0130a.ACTIVE.f399e;
        }
        n0Var.f553a = C0314y0.m857a().mo366f();
        n0Var.f554b = j;
        n0Var.f555c = j2;
        n0Var.f556d = j3;
        n0Var.f557e = this.f605e;
        n0Var.f558f = str;
        n0Var.f559g = str2;
        n0Var.f560h = map;
        C0273u0.m716a();
        n0Var.f561i = C0273u0.m717b();
        C0273u0.m716a();
        n0Var.f562j = TimeZone.getDefault().getID();
        n0Var.f563k = i;
        int i2 = this.f622v;
        if (i2 == -1) {
            i2 = C0308x2.m837a();
        }
        n0Var.f564l = i2;
        String str3 = this.f619s;
        if (str3 == null) {
            str3 = "";
        }
        n0Var.f565m = str3;
        n0Var.f566n = C0279v0.m732e().mo348n();
        n0Var.f567o = this.f626z;
        n0Var.f576x = C0129ep.m409a(C0118e1.m386a().f361a).f409i;
        n0Var.f568p = this.f620t;
        n0Var.f569q = this.f621u;
        n0Var.f572t = this.f606f;
        List<C0167j0> list = this.f607g;
        String str4 = f591E;
        C0260s1.m686c(3, str4, "Total events in session report: " + list.size());
        n0Var.f573u = list;
        n0Var.f575w = this.f623w;
        n0Var.f578z = this.f608h;
        n0Var.f577y = this.f625y;
        C0260s1.m686c(3, str4, "Total errors in session report: " + this.f625y);
        n0Var.f574v = this.f609i;
        n0Var.f552A = this.f617q;
        m0Var = null;
        try {
            m0Var = new C0188m0(n0Var);
        } catch (IOException e) {
            C0260s1.m686c(5, f591E, "Error creating analytics session report: ".concat(String.valueOf(e)));
        }
        if (m0Var == null) {
            C0260s1.m701r(f591E, "New session report wasn't created");
        }
        return m0Var;
    }

    /* renamed from: d */
    private synchronized C0188m0 m541d(long j, long j2, C0154h0 h0Var) {
        C0188m0 m0Var;
        C0198n0 n0Var = new C0198n0();
        n0Var.f571s = false;
        n0Var.f570r = C0129ep.EnumC0130a.UNKNOWN.f399e;
        n0Var.f553a = C0314y0.m857a().mo366f();
        n0Var.f554b = j;
        n0Var.f555c = j2;
        n0Var.f556d = 0;
        m0Var = null;
        n0Var.f557e = null;
        n0Var.f558f = null;
        n0Var.f559g = null;
        n0Var.f560h = null;
        n0Var.f561i = "";
        n0Var.f562j = "";
        n0Var.f563k = C0054by.EnumC0055a.f179a - 1;
        n0Var.f564l = 0;
        n0Var.f565m = "";
        n0Var.f566n = null;
        n0Var.f567o = 0;
        n0Var.f576x = C0129ep.m409a(C0118e1.m386a().f361a).f409i;
        n0Var.f568p = -1;
        n0Var.f569q = null;
        n0Var.f572t = null;
        n0Var.f573u = null;
        n0Var.f575w = true;
        ArrayList arrayList = new ArrayList();
        arrayList.add(h0Var);
        n0Var.f578z = arrayList;
        n0Var.f577y = arrayList.size();
        String str = f591E;
        C0260s1.m686c(3, str, "Total errors in native crash session report: " + arrayList.size());
        n0Var.f574v = new ArrayList();
        n0Var.f552A = null;
        try {
            m0Var = new C0188m0(n0Var);
        } catch (IOException e) {
            C0260s1.m686c(5, f591E, "Error creating analytics native crash session report: ".concat(String.valueOf(e)));
        }
        if (m0Var == null) {
            C0260s1.m701r(f591E, "New native crash session report wasn't created");
        }
        return m0Var;
    }

    /* renamed from: i */
    static /* synthetic */ void m543i(C0204o0 o0Var, long j, long j2, long j3, int i, String str, String str2, Map map) {
        C0188m0 c = o0Var.m540c(j, j2, j3, i, str, str2, map);
        o0Var.f603c.clear();
        o0Var.f603c.add(c);
        o0Var.m555y();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: n */
    private synchronized void m545n(boolean z, long j) {
        if (!this.f598B) {
            C0260s1.m686c(3, f591E, "Analytics disabled, not sending agent report.");
        } else if (z || !this.f603c.isEmpty()) {
            String str = f591E;
            C0260s1.m686c(3, str, "generating agent report with " + this.f603c.size() + " session reports.");
            byte[] bArr = null;
            try {
                bArr = new C0173k0(C0118e1.m386a().f365e, C0314y0.m857a().mo366f(), this.f614n, C0044bs.m232a().mo127j(), this.f615o, j, this.f603c, Collections.unmodifiableMap(C0044bs.m232a().f150b), this.f610j.mo111a(), this.f604d, C0146g1.m447a().mo209b(), System.currentTimeMillis(), C0266t2.m703e(), this.f597A).f522a;
            } catch (Exception e) {
                C0260s1.m701r(f591E, "Exception while generating report: ".concat(String.valueOf(e)));
            }
            if (bArr == null) {
                C0260s1.m701r(f591E, "Error generating report");
            } else {
                String str2 = f591E;
                C0260s1.m686c(3, str2, "generated report of size " + bArr.length + " with " + this.f603c.size() + " reports.");
                C0180l0 l0Var = C0329z3.m900e().f900b;
                StringBuilder sb = new StringBuilder();
                sb.append(C0135f1.m416a());
                l0Var.mo169f(bArr, C0118e1.m386a().f365e, sb.toString());
            }
            this.f603c.clear();
            this.f613m.mo254c();
        }
    }

    /* renamed from: q */
    private synchronized void m547q(long j) {
        for (C0167j0 j0Var : this.f607g) {
            if (j0Var.f509e && !j0Var.f510f) {
                j0Var.mo240b(j);
            }
        }
    }

    /* renamed from: s */
    private static String m549s() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d").getInputStream()));
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null && i < 1000) {
                    sb.append(readLine);
                    sb.append("\n");
                    i++;
                }
            }
            return sb.toString();
        } catch (IOException e) {
            String str = f591E;
            C0260s1.m686c(6, str, "There was an issue grabbing logcat. " + e.getMessage());
            return "";
        }
    }

    /* renamed from: t */
    static /* synthetic */ void m550t(C0204o0 o0Var) {
        SharedPreferences sharedPreferences = C0118e1.m386a().f361a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
        o0Var.f614n = sharedPreferences.getBoolean("com.flurry.sdk.previous_successful_report", false);
        C0235q0.m624b();
        o0Var.f615o = sharedPreferences.getLong("com.flurry.sdk.initial_run_time", C0235q0.m627e());
        o0Var.f616p = sharedPreferences.getString("com.flurry.sdk.api_key", "");
        o0Var.f617q = sharedPreferences.getString("com.flurry.sdk.variant_ids", null);
        if (TextUtils.isEmpty(o0Var.f616p) && o0Var.f615o > 0) {
            o0Var.f616p = C0118e1.m386a().f365e;
        } else if (!o0Var.f616p.equals(C0118e1.m386a().f365e)) {
            C0235q0.m624b();
            o0Var.f615o = C0235q0.m627e();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: u */
    private synchronized void m551u() {
        C0328z2.m889d();
        String str = f591E;
        C0260s1.m686c(4, str, "Loading persistent session report data.");
        List<C0188m0> a = this.f613m.mo252a();
        if (a != null) {
            this.f603c.addAll(a);
            return;
        }
        if (this.f612l.exists()) {
            C0260s1.m686c(4, str, "Legacy persistent agent data found, converting.");
            C0228p0 a2 = C0032b.m197a(this.f612l);
            if (a2 != null) {
                boolean z = a2.f672b;
                long j = a2.f673c;
                if (j <= 0) {
                    C0235q0.m624b();
                    j = C0235q0.m627e();
                }
                this.f614n = z;
                this.f615o = j;
                m553w();
                List unmodifiableList = Collections.unmodifiableList(a2.f671a);
                if (unmodifiableList != null) {
                    this.f603c.addAll(unmodifiableList);
                }
            }
            this.f612l.delete();
            m555y();
        }
    }

    /* renamed from: v */
    static /* synthetic */ void m552v(C0204o0 o0Var) {
        boolean z;
        long j;
        C0328z2.m889d();
        File fileStreamPath = C0118e1.m386a().f361a.getFileStreamPath(".yflurrynativecrash");
        String[] c = C0318y2.m876c(fileStreamPath, Pattern.compile(".*" + Pattern.quote(".dmp") + "$"));
        for (String str : c) {
            String str2 = f591E;
            C0260s1.m686c(3, str2, "Native crash occurred in previous session! Found minidump file - ".concat(String.valueOf(str)));
            String b = C0129ep.m410b(fileStreamPath, str);
            boolean z2 = true;
            if (TextUtils.isEmpty(b)) {
                C0260s1.m686c(6, str2, "There was no breadcrumbs file associated with the minidump file.");
                z = true;
            } else {
                z = false;
            }
            C0260s1.m686c(2, str2, "Breadcrumbs file associated with minidump file - ".concat(String.valueOf(b)));
            String c2 = C0129ep.m411c(b);
            String d = C0129ep.m412d(b);
            if (TextUtils.isEmpty(c2)) {
                C0260s1.m686c(6, str2, "There is no session id specified with crash breadcrumbs file: ".concat(String.valueOf(b)));
                z = true;
            }
            long j2 = 0;
            long currentTimeMillis = System.currentTimeMillis();
            try {
                j2 = Long.parseLong(c2);
                j = Long.parseLong(d);
            } catch (NumberFormatException unused) {
                C0260s1.m686c(6, f591E, "Issue parsing session id into start time: ".concat(String.valueOf(c2)));
                j = currentTimeMillis;
                z = true;
            }
            C0154h0 h0Var = new C0154h0(1, j, "native", "", "", null, null, null);
            h0Var.f469j = m549s();
            File file = new File(fileStreamPath, b);
            if (file.exists()) {
                List<C0124e3> b2 = new C0142f3(file).mo206b();
                C0260s1.m686c(2, f591E, "Number of crash breadcrumbs - " + b2.size());
                h0Var.mo213a(b2);
                file.delete();
                z2 = z;
            } else {
                C0260s1.m686c(6, f591E, "Breadcrumbs file does not exist.");
            }
            File file2 = new File(fileStreamPath, str);
            if (!file2.exists()) {
                C0260s1.m686c(6, f591E, "Minidump file doesn't exist.");
            } else if (z2) {
                C0260s1.m686c(6, f591E, "Some error occurred with minidump file. Deleting it.");
                file2.delete();
            } else {
                h0Var.f470k = C0318y2.m878e(file2);
                file2.delete();
                C0188m0 d2 = o0Var.m541d(j2, j - j2, h0Var);
                if (d2 != null) {
                    o0Var.f603c.add(d2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: w */
    private void m553w() {
        SharedPreferences.Editor edit = C0118e1.m386a().f361a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        edit.putBoolean("com.flurry.sdk.previous_successful_report", this.f614n);
        edit.putLong("com.flurry.sdk.initial_run_time", this.f615o);
        edit.putString("com.flurry.sdk.api_key", C0118e1.m386a().f365e);
        edit.apply();
    }

    /* renamed from: y */
    private synchronized void m555y() {
        C0260s1.m686c(4, f591E, "Saving persistent agent data.");
        this.f613m.mo253b(this.f603c);
    }

    /* renamed from: a */
    public final synchronized FlurryEventRecordStatus mo280a(String str, Map<String, String> map, boolean z, int i) {
        FlurryEventRecordStatus flurryEventRecordStatus;
        FlurryEventRecordStatus flurryEventRecordStatus2 = FlurryEventRecordStatus.kFlurryEventRecorded;
        if (!this.f598B) {
            FlurryEventRecordStatus flurryEventRecordStatus3 = FlurryEventRecordStatus.kFlurryEventAnalyticsDisabled;
            C0260s1.m701r(f591E, "Analytics has been disabled, not logging event.");
            return flurryEventRecordStatus3;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        C0235q0.m624b();
        long f = elapsedRealtime - C0235q0.m628f();
        String i2 = C0328z2.m894i(str);
        if (i2.length() == 0) {
            return FlurryEventRecordStatus.kFlurryEventFailed;
        }
        C0161i0 i0Var = this.f606f.get(i2);
        if (i0Var != null) {
            i0Var.f492a++;
            C0260s1.m701r(f591E, "Event count incremented: ".concat(String.valueOf(i2)));
        } else if (this.f606f.size() < f592F) {
            C0161i0 i0Var2 = new C0161i0();
            i0Var2.f492a = 1;
            this.f606f.put(i2, i0Var2);
            C0260s1.m701r(f591E, "Event count started: ".concat(String.valueOf(i2)));
        } else {
            C0260s1.m701r(f591E, "Too many different events. Event not counted: ".concat(String.valueOf(i2)));
            flurryEventRecordStatus = FlurryEventRecordStatus.kFlurryEventUniqueCountExceeded;
            if (this.f618r || this.f607g.size() >= f594H || this.f624x >= f595I) {
                this.f623w = false;
                flurryEventRecordStatus2 = flurryEventRecordStatus;
            } else {
                Map<String, String> emptyMap = map == null ? Collections.emptyMap() : map;
                if (emptyMap.size() - i > f593G) {
                    C0260s1.m701r(f591E, "MaxEventParams exceeded: " + (emptyMap.size() - i));
                    flurryEventRecordStatus2 = FlurryEventRecordStatus.kFlurryEventParamsCountExceeded;
                } else {
                    C0167j0 j0Var = new C0167j0(this.f601a.incrementAndGet(), i2, emptyMap, f, z);
                    int length = j0Var.mo243e().length + this.f624x;
                    int i3 = f595I;
                    if (length <= i3) {
                        this.f607g.add(j0Var);
                        this.f624x += j0Var.mo243e().length;
                        if ("Flurry.purchase".equals(i2)) {
                            Map<String, String> a = j0Var.mo239a();
                            String str2 = a.get("fl.OrderJSON");
                            String str3 = a.get("fl.OrderJSONSignature");
                            if (!(str2 == null || str3 == null)) {
                                a.remove("fl.OrderJSON");
                                a.remove("fl.OrderJSONSignature");
                                j0Var.mo242d(a);
                                this.f609i.add(str3 + '\n' + str2);
                            }
                        }
                        if (this.f598B && C0329z3.m900e().f899a != null) {
                            C0118e1.m386a().mo191g(new RunnableC0222p(this, i2, emptyMap));
                        }
                    } else {
                        this.f624x = i3;
                        this.f623w = false;
                        C0260s1.m701r(f591E, "Event Log size exceeded. No more event details logged.");
                        flurryEventRecordStatus2 = FlurryEventRecordStatus.kFlurryEventLogCountExceeded;
                    }
                }
            }
            return flurryEventRecordStatus2;
        }
        flurryEventRecordStatus = flurryEventRecordStatus2;
        if (this.f618r) {
        }
        this.f623w = false;
        flurryEventRecordStatus2 = flurryEventRecordStatus;
        return flurryEventRecordStatus2;
    }

    @Override // com.flurry.sdk.C0275u2.AbstractC0276a
    /* renamed from: b */
    public final void mo197b(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1752163738:
                if (str.equals("UserId")) {
                    c = 0;
                    break;
                }
                break;
            case -1720015653:
                if (str.equals("analyticsEnabled")) {
                    c = 1;
                    break;
                }
                break;
            case -738063011:
                if (str.equals("LogEvents")) {
                    c = 2;
                    break;
                }
                break;
            case 65759:
                if (str.equals("Age")) {
                    c = 3;
                    break;
                }
                break;
            case 2129321697:
                if (str.equals("Gender")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f619s = (String) obj;
                String str2 = f591E;
                C0260s1.m686c(4, str2, "onSettingUpdate, UserId = " + this.f619s);
                return;
            case 1:
                this.f598B = ((Boolean) obj).booleanValue();
                String str3 = f591E;
                C0260s1.m686c(4, str3, "onSettingUpdate, AnalyticsEnabled = " + this.f598B);
                return;
            case 2:
                this.f618r = ((Boolean) obj).booleanValue();
                String str4 = f591E;
                C0260s1.m686c(4, str4, "onSettingUpdate, LogEvents = " + this.f618r);
                return;
            case 3:
                this.f621u = (Long) obj;
                String str5 = f591E;
                C0260s1.m686c(4, str5, "onSettingUpdate, Birthdate = " + this.f621u);
                return;
            case 4:
                this.f620t = ((Byte) obj).byteValue();
                String str6 = f591E;
                C0260s1.m686c(4, str6, "onSettingUpdate, Gender = " + ((int) this.f620t));
                return;
            default:
                C0260s1.m686c(6, f591E, "onSettingUpdate internal error!");
                return;
        }
    }

    /* renamed from: f */
    public final synchronized void mo281f() {
        this.f622v = C0308x2.m837a();
        if (C0329z3.m900e().f901c != null) {
            C0118e1.m386a().mo191g(new C0214i(this));
        }
        if (this.f598B && C0329z3.m900e().f899a != null) {
            C0118e1.m386a().mo191g(new C0215j(this));
        }
    }

    /* renamed from: g */
    public final synchronized void mo282g(long j) {
        C0199n1.m528a().mo270d(this.f599C);
        C0235q0.m624b();
        m547q(C0235q0.m629g());
        C0118e1.m386a().mo191g(new C0219n());
        if (C0044bs.m232a().mo124g()) {
            C0235q0.m624b();
            C0118e1.m386a().mo191g(new C0221o(j, C0235q0.m629g(), C0235q0.m631i(), C0235q0.m635m() - 1, C0235q0.m632j(), C0235q0.m633k(), C0235q0.m634l()));
        }
        C0266t2.m703e().mo344d("Gender", this);
        C0266t2.m703e().mo344d("UserId", this);
        C0266t2.m703e().mo344d("Age", this);
        C0266t2.m703e().mo344d("LogEvents", this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public final void mo283h(Context context) {
        Bundle extras;
        if ((context instanceof Activity) && (extras = ((Activity) context).getIntent().getExtras()) != null) {
            String str = f591E;
            C0260s1.m686c(3, str, "Launch Options Bundle is present " + extras.toString());
            for (String str2 : extras.keySet()) {
                if (str2 != null) {
                    Object obj = extras.get(str2);
                    String obj2 = obj != null ? obj.toString() : "null";
                    this.f604d.put(str2, Collections.singletonList(obj2));
                    String str3 = f591E;
                    C0260s1.m686c(3, str3, "Launch options Key: " + str2 + ". Its value: " + obj2);
                }
            }
        }
    }

    /* renamed from: k */
    public final synchronized void mo284k(C0309x3 x3Var) {
        String str = x3Var.f841a;
        boolean z = str != null && "uncaught".equals(str);
        this.f625y++;
        if (this.f608h.size() < f596J) {
            C0154h0 h0Var = new C0154h0(this.f602b.incrementAndGet(), Long.valueOf(System.currentTimeMillis()).longValue(), x3Var.f841a, x3Var.f842b, x3Var.f843c, x3Var.f844d, x3Var.f845e, x3Var.f846f);
            h0Var.mo213a(x3Var.f847g);
            this.f608h.add(h0Var);
            C0260s1.m701r(f591E, "Error logged: " + h0Var.f462c);
        } else if (z) {
            for (int i = 0; i < this.f608h.size(); i++) {
                String str2 = this.f608h.get(i).f462c;
                if (str2 != null && !"uncaught".equals(str2)) {
                    C0154h0 h0Var2 = new C0154h0(this.f602b.incrementAndGet(), Long.valueOf(System.currentTimeMillis()).longValue(), x3Var.f841a, x3Var.f842b, x3Var.f843c, x3Var.f844d, x3Var.f845e, x3Var.f846f);
                    h0Var2.mo213a(x3Var.f847g);
                    this.f608h.set(i, h0Var2);
                    return;
                }
            }
        } else {
            C0260s1.m701r(f591E, "Max errors logged. No more errors logged.");
        }
    }

    /* renamed from: l */
    public final synchronized void mo285l(String str, Map<String, String> map) {
        boolean z;
        int i;
        for (C0167j0 j0Var : this.f607g) {
            if (!j0Var.f509e || j0Var.f511g != 0 || !j0Var.f507c.equals(str)) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                C0235q0.m624b();
                long f = elapsedRealtime - C0235q0.m628f();
                if (map != null && map.size() > 0 && (i = this.f624x) < f595I) {
                    int length = i - j0Var.mo243e().length;
                    HashMap hashMap = new HashMap(j0Var.mo239a());
                    j0Var.mo241c(map);
                    if (j0Var.mo243e().length + length > f595I) {
                        j0Var.mo242d(hashMap);
                        this.f623w = false;
                        this.f624x = f595I;
                        C0260s1.m701r(f591E, "Event Log size exceeded. No more event details logged.");
                    } else if (j0Var.mo239a().size() > f593G) {
                        String str2 = f591E;
                        C0260s1.m701r(str2, "MaxEventParams exceeded on endEvent: " + j0Var.mo239a().size());
                        j0Var.mo242d(hashMap);
                    } else {
                        this.f624x = length + j0Var.mo243e().length;
                    }
                }
                j0Var.mo240b(f);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    @TargetApi(18)
    /* renamed from: m */
    public final void mo286m(boolean z) {
        int i;
        String str;
        int i2;
        Exception e;
        String str2;
        int i3 = Build.VERSION.SDK_INT;
        if (z) {
            this.f605e.put("boot.time", Long.toString(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (i3 >= 18) {
                this.f605e.put("disk.size.total.internal", Long.toString(statFs.getAvailableBlocksLong()));
                this.f605e.put("disk.size.available.internal", Long.toString(statFs.getAvailableBlocksLong()));
                this.f605e.put("disk.size.total.external", Long.toString(statFs2.getAvailableBlocksLong()));
                this.f605e.put("disk.size.available.external", Long.toString(statFs2.getAvailableBlocksLong()));
            } else {
                this.f605e.put("disk.size.total.internal", Long.toString((long) statFs.getAvailableBlocks()));
                this.f605e.put("disk.size.available.internal", Long.toString((long) statFs.getAvailableBlocks()));
                this.f605e.put("disk.size.total.external", Long.toString((long) statFs2.getAvailableBlocks()));
                this.f605e.put("disk.size.available.external", Long.toString((long) statFs2.getAvailableBlocks()));
            }
            Map<String, String> map = this.f605e;
            C0306x0.m832a();
            map.put("carrier.name", C0306x0.m833b());
            Map<String, String> map2 = this.f605e;
            C0306x0.m832a();
            map2.put("carrier.details", C0306x0.m834c());
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) C0118e1.m386a().f361a.getSystemService("activity")).getMemoryInfo(memoryInfo);
        Map<String, String> map3 = this.f605e;
        StringBuilder sb = new StringBuilder("memory.available");
        String str3 = ".start";
        sb.append(z ? str3 : ".end");
        map3.put(sb.toString(), Long.toString(memoryInfo.availMem));
        if (i3 >= 16) {
            Map<String, String> map4 = this.f605e;
            StringBuilder sb2 = new StringBuilder("memory.total");
            if (z) {
                str2 = str3;
            } else {
                str2 = ".end";
            }
            sb2.append(str2);
            map4.put(sb2.toString(), Long.toString(memoryInfo.availMem));
        }
        boolean z2 = false;
        int i4 = -1;
        try {
            Intent registerReceiver = C0118e1.m386a().f361a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra("status", -1);
                if (intExtra == 2 || intExtra == 5) {
                    z2 = true;
                }
                i2 = registerReceiver.getIntExtra("level", -1);
                try {
                    i = registerReceiver.getIntExtra("scale", -1);
                    i4 = i2;
                } catch (Exception e2) {
                    e = e2;
                    C0260s1.m686c(5, f591E, "Error getting battery status: ".concat(String.valueOf(e)));
                    i4 = i2;
                    i = -1;
                    float f = ((float) i4) / ((float) i);
                    Map<String, String> map5 = this.f605e;
                    StringBuilder sb3 = new StringBuilder("battery.charging");
                    if (!z) {
                    }
                    sb3.append(str);
                    map5.put(sb3.toString(), Boolean.toString(z2));
                    Map<String, String> map6 = this.f605e;
                    StringBuilder sb4 = new StringBuilder("battery.remaining");
                    if (!z) {
                    }
                    sb4.append(str3);
                    map6.put(sb4.toString(), Float.toString(f));
                    if (!C0254r1.m677a().f714a) {
                    }
                }
                float f2 = ((float) i4) / ((float) i);
                Map<String, String> map52 = this.f605e;
                StringBuilder sb32 = new StringBuilder("battery.charging");
                if (!z) {
                    str = str3;
                } else {
                    str = ".end";
                }
                sb32.append(str);
                map52.put(sb32.toString(), Boolean.toString(z2));
                Map<String, String> map62 = this.f605e;
                StringBuilder sb42 = new StringBuilder("battery.remaining");
                if (!z) {
                    str3 = ".end";
                }
                sb42.append(str3);
                map62.put(sb42.toString(), Float.toString(f2));
                if (!C0254r1.m677a().f714a) {
                    String b = C0254r1.m677a().mo325b();
                    this.f605e.put("instantapp.name", b != null ? b : "instant app");
                    C0260s1.m697n(f591E, "instantAppName: ".concat(String.valueOf(b)));
                    return;
                }
                return;
            }
        } catch (Exception e3) {
            e = e3;
            i2 = -1;
            C0260s1.m686c(5, f591E, "Error getting battery status: ".concat(String.valueOf(e)));
            i4 = i2;
            i = -1;
            float f22 = ((float) i4) / ((float) i);
            Map<String, String> map522 = this.f605e;
            StringBuilder sb322 = new StringBuilder("battery.charging");
            if (!z) {
            }
            sb322.append(str);
            map522.put(sb322.toString(), Boolean.toString(z2));
            Map<String, String> map622 = this.f605e;
            StringBuilder sb422 = new StringBuilder("battery.remaining");
            if (!z) {
            }
            sb422.append(str3);
            map622.put(sb422.toString(), Float.toString(f22));
            if (!C0254r1.m677a().f714a) {
            }
        }
        i = -1;
        float f222 = ((float) i4) / ((float) i);
        Map<String, String> map5222 = this.f605e;
        StringBuilder sb3222 = new StringBuilder("battery.charging");
        if (!z) {
        }
        sb3222.append(str);
        map5222.put(sb3222.toString(), Boolean.toString(z2));
        Map<String, String> map6222 = this.f605e;
        StringBuilder sb4222 = new StringBuilder("battery.remaining");
        if (!z) {
        }
        sb4222.append(str3);
        map6222.put(sb4222.toString(), Float.toString(f222));
        if (!C0254r1.m677a().f714a) {
        }
    }

    /* renamed from: p */
    public final synchronized void mo287p() {
        m539A();
    }
}
