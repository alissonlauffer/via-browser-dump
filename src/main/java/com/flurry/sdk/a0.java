package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.Toast;
import com.flurry.sdk.b0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class a0 {
    public static final String d = "a0";
    public static int e;
    public static int f;
    public static AtomicInteger g;
    static k1<List<b0>> h;
    private static a0 i;
    private static Map<Integer, b0> j;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f52a;
    private long b;
    private m1<w0> c = new a(this);

    class a implements m1<w0> {

        /* renamed from: com.flurry.sdk.a0$a$a  reason: collision with other inner class name */
        class C0010a implements Runnable {
            C0010a(a aVar) {
            }

            public final void run() {
                d0.b().a();
            }
        }

        a(a0 a0Var) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.m1
        public final /* synthetic */ void a(w0 w0Var) {
            w0 w0Var2 = w0Var;
            String str = a0.d;
            s1.a(4, str, "onNetworkStateChanged : isNetworkEnable = " + w0Var2.b);
            if (w0Var2.b) {
                e1.a().b(new C0010a(this));
            }
        }
    }

    class b implements n2<List<b0>> {
        b() {
        }

        @Override // com.flurry.sdk.n2
        public final l2<List<b0>> a(int i) {
            return new k2(new b0.a());
        }
    }

    class c implements Runnable {
        c() {
        }

        public final void run() {
            a0.this.g();
        }
    }

    class d implements Runnable {
        d() {
        }

        public final void run() {
            a0.this.g();
        }
    }

    class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ z f55a;

        e(a0 a0Var, z zVar) {
            this.f55a = zVar;
        }

        public final void run() {
            Context context = e1.a().f110a;
            Toast.makeText(context, "PulseCallbackReportInfo HTTP Response Code: " + this.f55a.e + " for url: " + ((b2) this.f55a.l).e, 1).show();
        }
    }

    class f implements Runnable {
        f(a0 a0Var) {
        }

        public final void run() {
            a0.c();
            List<b0> b = a0.b();
            if (a0.h == null) {
                a0.f();
            }
            a0.h.a(b);
        }
    }

    @SuppressLint({"UseSparseArrays"})
    private a0() {
        j = new ConcurrentHashMap();
        this.f52a = new AtomicInteger(0);
        g = new AtomicInteger(0);
        if (f == 0) {
            f = 600000;
        }
        if (e == 0) {
            e = 15;
        }
        this.b = e1.a().f110a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getLong("timeToSendNextPulseReport", 0);
        if (h == null) {
            f();
        }
        n1.a().a("com.flurry.android.sdk.NetworkStateEvent", this.c);
    }

    public static void b(int i2) {
        f = i2;
    }

    private void c(z zVar) {
        zVar.d = true;
        zVar.a();
        g.incrementAndGet();
        zVar.l.b();
        String str = d;
        s1.a(3, str, zVar.l.m.g + " report to " + zVar.l.r + " finalized.");
        a();
        i();
    }

    public static List<b0> d() {
        if (h == null) {
            f();
        }
        return h.a();
    }

    /* access modifiers changed from: private */
    public static void f() {
        h = new k1<>(e1.a().f110a.getFileStreamPath(".yflurryanongoingpulsecallbackreporter"), ".yflurryanongoingpulsecallbackreporter", 2, new b());
    }

    /* access modifiers changed from: private */
    public void g() {
        SharedPreferences.Editor edit = e1.a().f110a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        edit.putLong("timeToSendNextPulseReport", this.b);
        edit.apply();
    }

    private synchronized int h() {
        return this.f52a.incrementAndGet();
    }

    private void i() {
        if (j() || k()) {
            s1.a(3, d, "Threshold reached. Sending callback logging reports");
            l();
        }
    }

    private static boolean j() {
        return g.intValue() >= e;
    }

    private boolean k() {
        return System.currentTimeMillis() > this.b;
    }

    private void l() {
        Iterator<b0> it = b().iterator();
        while (true) {
            boolean z = false;
            if (it.hasNext()) {
                b0 next = it.next();
                for (y yVar : next.a()) {
                    Iterator<z> it2 = yVar.l.iterator();
                    while (it2.hasNext()) {
                        z next2 = it2.next();
                        if (next2.j) {
                            it2.remove();
                        } else if (!next2.f.equals(ax.PENDING_COMPLETION)) {
                            next2.j = true;
                            z = true;
                        }
                    }
                }
                if (z) {
                    d0.b().a(next);
                }
            } else {
                d0.b().a();
                this.b = System.currentTimeMillis() + ((long) f);
                g();
                m();
                g = new AtomicInteger(0);
                a();
                return;
            }
        }
    }

    private void m() {
        for (b0 b0Var : b()) {
            if (b0Var.b()) {
                c(b0Var.f);
            } else {
                for (y yVar : b0Var.a()) {
                    if (yVar.s) {
                        b0Var.j.remove(Long.valueOf(yVar.g));
                    } else {
                        Iterator<z> it = yVar.l.iterator();
                        while (it.hasNext()) {
                            if (it.next().j) {
                                it.remove();
                            }
                        }
                    }
                }
            }
        }
    }

    public static void a(int i2) {
        e = i2;
    }

    public final synchronized void b(b0 b0Var) {
        if (b0Var == null) {
            s1.a(3, d, "Must add valid PulseCallbackAsyncReportInfo");
            return;
        }
        if (this.b == 0) {
            this.b = System.currentTimeMillis() + ((long) f);
            e1.a().b(new d());
        }
        int h2 = h();
        b0Var.f = h2;
        j.put(Integer.valueOf(h2), b0Var);
        for (y yVar : b0Var.a()) {
            Iterator<z> it = yVar.l.iterator();
            while (it.hasNext()) {
                it.next();
                g.incrementAndGet();
                if (j()) {
                    s1.a(3, d, "Max Callback Attempts threshold reached. Sending callback logging reports");
                    l();
                }
            }
        }
        if (k()) {
            s1.a(3, d, "Time threshold reached. Sending callback logging reports");
            l();
        }
        String str = d;
        s1.a(3, str, "Restoring " + b0Var.g + " report to PulseCallbackManager. Number of stored completed callbacks: " + g.get());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007d, code lost:
        return;
     */
    public final synchronized void a(b0 b0Var) {
        if (b0Var == null) {
            s1.a(3, d, "Must add valid PulseCallbackAsyncReportInfo");
            return;
        }
        String str = d;
        s1.a(3, str, "Adding and sending " + b0Var.g + " report to PulseCallbackManager.");
        if (b0Var.a().size() != 0) {
            if (this.b == 0) {
                this.b = System.currentTimeMillis() + ((long) f);
                e1.a().b(new c());
            }
            int h2 = h();
            b0Var.f = h2;
            j.put(Integer.valueOf(h2), b0Var);
            for (y yVar : b0Var.a()) {
                z3.a().c.b(yVar);
            }
        }
    }

    public static synchronized a0 c() {
        a0 a0Var;
        synchronized (a0.class) {
            if (i == null) {
                i = new a0();
            }
            a0Var = i;
        }
        return a0Var;
    }

    private synchronized void c(int i2) {
        String str = d;
        s1.a(3, str, "Removing report " + i2 + " from PulseCallbackManager");
        j.remove(Integer.valueOf(i2));
    }

    public final synchronized void a(z zVar) {
        String str = d;
        s1.a(3, str, zVar.l.m.g + " report sent successfully to " + zVar.l.r);
        zVar.f = ax.COMPLETE;
        zVar.g = "";
        c(zVar);
        if (s1.c() <= 3 && s1.d()) {
            e1.a().a(new e(this, zVar));
        }
    }

    public static List<b0> b() {
        return new ArrayList(j.values());
    }

    public final synchronized void b(z zVar) {
        String str = d;
        s1.a(3, str, "Maximum number of attempts reached. Aborting: " + zVar.l.m.g);
        zVar.f = ax.TIMEOUT;
        zVar.i = System.currentTimeMillis();
        zVar.g = "";
        c(zVar);
    }

    public final void a() {
        e1.a().b(new f(this));
    }

    public final synchronized boolean a(z zVar, String str) {
        zVar.h++;
        zVar.i = System.currentTimeMillis();
        if (!(zVar.h > zVar.l.i)) {
            if (!TextUtils.isEmpty(str)) {
                s1.a(3, d, "Report to " + zVar.l.r + " redirecting to url: " + str);
                ((b2) zVar.l).e = str;
                a();
                return true;
            }
        }
        s1.a(3, d, "Maximum number of redirects attempted. Aborting: " + zVar.l.m.g + " report to " + zVar.l.r);
        zVar.f = ax.INVALID_RESPONSE;
        zVar.g = "";
        c(zVar);
        return false;
    }

    public final synchronized boolean b(z zVar, String str) {
        boolean z;
        zVar.f = ax.INVALID_RESPONSE;
        zVar.i = System.currentTimeMillis();
        if (str == null) {
            str = "";
        }
        zVar.g = str;
        y yVar = zVar.l;
        z = true;
        if (((b2) yVar).c >= yVar.h) {
            String str2 = d;
            s1.a(3, str2, "Maximum number of attempts reached. Aborting: " + zVar.l.m.g + " report to " + zVar.l.r);
            c(zVar);
        } else if (!d3.a(((b2) zVar.l).e)) {
            String str3 = d;
            s1.a(3, str3, "Url: " + ((b2) zVar.l).e + " is invalid.");
            c(zVar);
        } else {
            String str4 = d;
            s1.a(3, str4, "Retrying callback to " + zVar.l.m.g + " in: " + (zVar.l.n / 1000) + " seconds.");
            zVar.a();
            g.incrementAndGet();
            a();
            i();
        }
        z = false;
        return z;
    }
}
