package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.flurry.sdk.C0033b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.flurry.sdk.a0 */
public class C0014a0 {

    /* renamed from: d */
    public static final String f64d = "a0";

    /* renamed from: e */
    public static int f65e;

    /* renamed from: f */
    public static int f66f;

    /* renamed from: g */
    public static AtomicInteger f67g;

    /* renamed from: h */
    static C0174k1<List<C0033b0>> f68h;

    /* renamed from: i */
    private static C0014a0 f69i;

    /* renamed from: j */
    private static Map<Integer, C0033b0> f70j;

    /* renamed from: a */
    private final AtomicInteger f71a;

    /* renamed from: b */
    private long f72b;

    /* renamed from: c */
    private AbstractC0192m1<C0298w0> f73c = new C0015a(this);

    /* renamed from: com.flurry.sdk.a0$a */
    class C0015a implements AbstractC0192m1<C0298w0> {

        /* renamed from: com.flurry.sdk.a0$a$a */
        class RunnableC0016a implements Runnable {
            RunnableC0016a(C0015a aVar) {
            }

            public final void run() {
                C0095d0.m338a().mo164f();
            }
        }

        C0015a(C0014a0 a0Var) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.AbstractC0192m1
        /* renamed from: a */
        public final /* synthetic */ void mo74a(C0298w0 w0Var) {
            C0298w0 w0Var2 = w0Var;
            String str = C0014a0.f64d;
            C0260s1.m686c(4, str, "onNetworkStateChanged : isNetworkEnable = " + w0Var2.f825b);
            if (w0Var2.f825b) {
                C0118e1.m386a().mo191g(new RunnableC0016a(this));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.a0$b */
    public class C0017b implements AbstractC0201n2<List<C0033b0>> {
        C0017b() {
        }

        @Override // com.flurry.sdk.AbstractC0201n2
        /* renamed from: a */
        public final AbstractC0185l2<List<C0033b0>> mo100a(int i) {
            return new C0175k2(new C0033b0.C0034a());
        }
    }

    /* renamed from: com.flurry.sdk.a0$c */
    class RunnableC0018c implements Runnable {
        RunnableC0018c() {
        }

        public final void run() {
            C0014a0.this.m173r();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.a0$d */
    public class RunnableC0019d implements Runnable {
        RunnableC0019d() {
        }

        public final void run() {
            C0014a0.this.m173r();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.a0$e */
    public class RunnableC0020e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C0321z f76a;

        RunnableC0020e(C0014a0 a0Var, C0321z zVar) {
            this.f76a = zVar;
        }

        public final void run() {
            Context context = C0118e1.m386a().f361a;
            Toast.makeText(context, "PulseCallbackReportInfo HTTP Response Code: " + this.f76a.f882e + " for url: " + this.f76a.f889l.f129e, 1).show();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.a0$f */
    public class RunnableC0021f implements Runnable {
        RunnableC0021f(C0014a0 a0Var) {
        }

        public final void run() {
            C0014a0.m169n();
            List<C0033b0> k = C0014a0.m166k();
            if (C0014a0.f68h == null) {
                C0014a0.m172q();
            }
            C0014a0.f68h.mo253b(k);
        }
    }

    @SuppressLint({"UseSparseArrays"})
    private C0014a0() {
        f70j = new ConcurrentHashMap();
        this.f71a = new AtomicInteger(0);
        f67g = new AtomicInteger(0);
        if (f66f == 0) {
            f66f = 600000;
        }
        if (f65e == 0) {
            f65e = 15;
        }
        this.f72b = C0118e1.m386a().f361a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getLong("timeToSendNextPulseReport", 0);
        if (f68h == null) {
            m172q();
        }
        C0199n1.m528a().mo271e("com.flurry.android.sdk.NetworkStateEvent", this.f73c);
    }

    /* renamed from: a */
    public static void m163a(int i) {
        f65e = i;
    }

    /* renamed from: g */
    public static void m165g(int i) {
        f66f = i;
    }

    /* renamed from: k */
    public static List<C0033b0> m166k() {
        return new ArrayList(f70j.values());
    }

    /* renamed from: l */
    private synchronized void m167l(int i) {
        String str = f64d;
        C0260s1.m686c(3, str, "Removing report " + i + " from PulseCallbackManager");
        f70j.remove(Integer.valueOf(i));
    }

    /* renamed from: m */
    private void m168m(C0321z zVar) {
        zVar.f881d = true;
        zVar.mo368a();
        f67g.incrementAndGet();
        zVar.f889l.mo362f();
        String str = f64d;
        C0260s1.m686c(3, str, zVar.f889l.f854m.f115g + " report to " + zVar.f889l.f859r + " finalized.");
        mo95f();
        m175t();
    }

    /* renamed from: n */
    public static synchronized C0014a0 m169n() {
        C0014a0 a0Var;
        synchronized (C0014a0.class) {
            if (f69i == null) {
                f69i = new C0014a0();
            }
            a0Var = f69i;
        }
        return a0Var;
    }

    /* renamed from: o */
    public static List<C0033b0> m170o() {
        if (f68h == null) {
            m172q();
        }
        return f68h.mo252a();
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public static void m172q() {
        f68h = new C0174k1<>(C0118e1.m386a().f361a.getFileStreamPath(".yflurryanongoingpulsecallbackreporter"), ".yflurryanongoingpulsecallbackreporter", 2, new C0017b());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: r */
    private void m173r() {
        SharedPreferences.Editor edit = C0118e1.m386a().f361a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        edit.putLong("timeToSendNextPulseReport", this.f72b);
        edit.apply();
    }

    /* renamed from: s */
    private synchronized int m174s() {
        return this.f71a.incrementAndGet();
    }

    /* renamed from: t */
    private void m175t() {
        if (m176u() || m177v()) {
            C0260s1.m686c(3, f64d, "Threshold reached. Sending callback logging reports");
            m178w();
        }
    }

    /* renamed from: u */
    private static boolean m176u() {
        return f67g.intValue() >= f65e;
    }

    /* renamed from: v */
    private boolean m177v() {
        return System.currentTimeMillis() > this.f72b;
    }

    /* renamed from: w */
    private void m178w() {
        Iterator<C0033b0> it = m166k().iterator();
        while (true) {
            boolean z = false;
            if (it.hasNext()) {
                C0033b0 next = it.next();
                for (C0310y yVar : next.mo113d()) {
                    Iterator<C0321z> it2 = yVar.f853l.iterator();
                    while (it2.hasNext()) {
                        C0321z next2 = it2.next();
                        if (next2.f887j) {
                            it2.remove();
                        } else if (!next2.f883f.equals(EnumC0031ax.PENDING_COMPLETION)) {
                            next2.f887j = true;
                            z = true;
                        }
                    }
                }
                if (z) {
                    C0095d0.m338a().mo163c(next);
                }
            } else {
                C0095d0.m338a().mo164f();
                this.f72b = System.currentTimeMillis() + ((long) f66f);
                m173r();
                m179x();
                f67g = new AtomicInteger(0);
                mo95f();
                return;
            }
        }
    }

    /* renamed from: x */
    private void m179x() {
        for (C0033b0 b0Var : m166k()) {
            if (b0Var.mo114i()) {
                m167l(b0Var.f114f);
            } else {
                for (C0310y yVar : b0Var.mo113d()) {
                    if (yVar.f860s) {
                        b0Var.f118j.remove(Long.valueOf(yVar.f848g));
                    } else {
                        Iterator<C0321z> it = yVar.f853l.iterator();
                        while (it.hasNext()) {
                            if (it.next().f887j) {
                                it.remove();
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public final synchronized void mo92b(C0321z zVar) {
        String str = f64d;
        C0260s1.m686c(3, str, zVar.f889l.f854m.f115g + " report sent successfully to " + zVar.f889l.f859r);
        zVar.f883f = EnumC0031ax.COMPLETE;
        zVar.f884g = "";
        m168m(zVar);
        if (C0260s1.m695l() <= 3 && C0260s1.m700q()) {
            C0118e1.m386a().mo189d(new RunnableC0020e(this, zVar));
        }
    }

    /* renamed from: d */
    public final synchronized void mo93d(C0033b0 b0Var) {
        if (b0Var == null) {
            C0260s1.m686c(3, f64d, "Must add valid PulseCallbackAsyncReportInfo");
            return;
        }
        String str = f64d;
        C0260s1.m686c(3, str, "Adding and sending " + b0Var.f115g + " report to PulseCallbackManager.");
        if (b0Var.mo113d().size() != 0) {
            if (this.f72b == 0) {
                this.f72b = System.currentTimeMillis() + ((long) f66f);
                C0118e1.m386a().mo191g(new RunnableC0018c());
            }
            int s = m174s();
            b0Var.f114f = s;
            f70j.put(Integer.valueOf(s), b0Var);
            for (C0310y yVar : b0Var.mo113d()) {
                C0329z3.m900e().f901c.mo143g(yVar);
            }
        }
    }

    /* renamed from: e */
    public final synchronized boolean mo94e(C0321z zVar, String str) {
        zVar.f885h++;
        zVar.f886i = System.currentTimeMillis();
        if (!(zVar.f885h > zVar.f889l.f850i)) {
            if (!TextUtils.isEmpty(str)) {
                C0260s1.m686c(3, f64d, "Report to " + zVar.f889l.f859r + " redirecting to url: " + str);
                zVar.f889l.f129e = str;
                mo95f();
                return true;
            }
        }
        C0260s1.m686c(3, f64d, "Maximum number of redirects attempted. Aborting: " + zVar.f889l.f854m.f115g + " report to " + zVar.f889l.f859r);
        zVar.f883f = EnumC0031ax.INVALID_RESPONSE;
        zVar.f884g = "";
        m168m(zVar);
        return false;
    }

    /* renamed from: f */
    public final void mo95f() {
        C0118e1.m386a().mo191g(new RunnableC0021f(this));
    }

    /* renamed from: h */
    public final synchronized void mo96h(C0321z zVar) {
        String str = f64d;
        C0260s1.m686c(3, str, "Maximum number of attempts reached. Aborting: " + zVar.f889l.f854m.f115g);
        zVar.f883f = EnumC0031ax.TIMEOUT;
        zVar.f886i = System.currentTimeMillis();
        zVar.f884g = "";
        m168m(zVar);
    }

    /* renamed from: i */
    public final synchronized void mo97i(C0033b0 b0Var) {
        if (b0Var == null) {
            C0260s1.m686c(3, f64d, "Must add valid PulseCallbackAsyncReportInfo");
            return;
        }
        if (this.f72b == 0) {
            this.f72b = System.currentTimeMillis() + ((long) f66f);
            C0118e1.m386a().mo191g(new RunnableC0019d());
        }
        int s = m174s();
        b0Var.f114f = s;
        f70j.put(Integer.valueOf(s), b0Var);
        for (C0310y yVar : b0Var.mo113d()) {
            Iterator<C0321z> it = yVar.f853l.iterator();
            while (it.hasNext()) {
                it.next();
                f67g.incrementAndGet();
                if (m176u()) {
                    C0260s1.m686c(3, f64d, "Max Callback Attempts threshold reached. Sending callback logging reports");
                    m178w();
                }
            }
        }
        if (m177v()) {
            C0260s1.m686c(3, f64d, "Time threshold reached. Sending callback logging reports");
            m178w();
        }
        String str = f64d;
        C0260s1.m686c(3, str, "Restoring " + b0Var.f115g + " report to PulseCallbackManager. Number of stored completed callbacks: " + f67g.get());
    }

    /* renamed from: j */
    public final synchronized boolean mo98j(C0321z zVar, String str) {
        boolean z;
        zVar.f883f = EnumC0031ax.INVALID_RESPONSE;
        zVar.f886i = System.currentTimeMillis();
        if (str == null) {
            str = "";
        }
        zVar.f884g = str;
        C0310y yVar = zVar.f889l;
        z = true;
        if (yVar.f127c >= yVar.f849h) {
            String str2 = f64d;
            C0260s1.m686c(3, str2, "Maximum number of attempts reached. Aborting: " + zVar.f889l.f854m.f115g + " report to " + zVar.f889l.f859r);
            m168m(zVar);
        } else if (!C0106d3.m365b(yVar.f129e)) {
            String str3 = f64d;
            C0260s1.m686c(3, str3, "Url: " + zVar.f889l.f129e + " is invalid.");
            m168m(zVar);
        } else {
            String str4 = f64d;
            C0260s1.m686c(3, str4, "Retrying callback to " + zVar.f889l.f854m.f115g + " in: " + (zVar.f889l.f855n / 1000) + " seconds.");
            zVar.mo368a();
            f67g.incrementAndGet();
            mo95f();
            m175t();
        }
        z = false;
        return z;
    }
}
