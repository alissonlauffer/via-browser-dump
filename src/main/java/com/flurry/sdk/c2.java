package com.flurry.sdk;

import com.flurry.sdk.b2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class c2<ReportInfo extends b2> {
    private static final String h = "c2";
    protected static long i = 10000;

    /* renamed from: a  reason: collision with root package name */
    private final k1<List<ReportInfo>> f85a;
    /* access modifiers changed from: private */
    public final List<ReportInfo> b = new ArrayList();
    public boolean c;
    private int d;
    protected long e;
    public final Runnable f = new a();
    public final m1<w0> g = new b();

    class a extends b3 {
        a() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            c2.this.b();
        }
    }

    class b implements m1<w0> {
        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.m1
        public final /* bridge */ /* synthetic */ void a(w0 w0Var) {
            if (w0Var.b) {
                c2.this.b();
            }
        }
    }

    class c extends b3 {
        c() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            c2 c2Var = c2.this;
            c2Var.a(c2Var.b);
            c2.this.b();
        }
    }

    class d extends b3 {
        d() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            c2.this.d();
        }
    }

    public class e extends b3 {
        public e() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            c2.this.b();
        }
    }

    class f extends b3 {
        f() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            c2.this.b();
        }
    }

    class g extends b3 {
        g() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            c2.this.d();
        }
    }

    class h extends b3 {
        h() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            c2.this.d();
        }
    }

    public c2() {
        n1.a().a("com.flurry.android.sdk.NetworkStateEvent", this.g);
        this.f85a = a();
        this.e = i;
        this.d = -1;
        e1.a().b(new c());
    }

    /* access modifiers changed from: private */
    public synchronized void d() {
        z2.a();
        ReportInfo reportinfo = null;
        if (by.b().b) {
            while (true) {
                if (this.d >= this.b.size()) {
                    break;
                }
                List<ReportInfo> list = this.b;
                int i2 = this.d;
                this.d = i2 + 1;
                ReportInfo reportinfo2 = list.get(i2);
                if (!((b2) reportinfo2).b) {
                    reportinfo = reportinfo2;
                    break;
                }
            }
        } else {
            s1.a(3, h, "Network is not available, aborting transmission");
        }
        if (reportinfo == null) {
            e();
        } else {
            a((b2) reportinfo);
        }
    }

    private synchronized void e() {
        c();
        b(this.b);
        if (this.c) {
            s1.a(3, h, "Reporter paused");
            this.e = i;
        } else if (this.b.isEmpty()) {
            s1.a(3, h, "All reports sent successfully");
            this.e = i;
        } else {
            this.e <<= 1;
            s1.a(3, h, "One or more reports failed to send, backing off: " + this.e + "ms");
            e1.a().a(this.f, this.e);
        }
        this.d = -1;
    }

    /* access modifiers changed from: protected */
    public abstract k1<List<ReportInfo>> a();

    /* access modifiers changed from: protected */
    public abstract void a(ReportInfo reportinfo);

    /* access modifiers changed from: protected */
    public synchronized void a(List<ReportInfo> list) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public synchronized void b(List<ReportInfo> list) {
        throw null;
    }

    /* access modifiers changed from: private */
    public synchronized void b() {
        if (!this.c) {
            if (this.d >= 0) {
                s1.a(3, h, "Transmit is in progress");
                return;
            }
            c();
            if (this.b.isEmpty()) {
                this.e = i;
                this.d = -1;
                return;
            }
            this.d = 0;
            e1.a().b(new d());
        }
    }

    private synchronized void c() {
        Iterator<ReportInfo> it = this.b.iterator();
        while (it.hasNext()) {
            ReportInfo next = it.next();
            if (((b2) next).b) {
                String str = h;
                s1.a(3, str, "Url transmitted - " + ((b2) next).d + " Attempts: " + ((b2) next).c);
                it.remove();
            } else if (((b2) next).c > ((b2) next).f) {
                String str2 = h;
                s1.a(3, str2, "Exceeded max no of attempts - " + ((b2) next).d + " Attempts: " + ((b2) next).c);
                it.remove();
            } else if (System.currentTimeMillis() > ((b2) next).f65a && ((b2) next).c > 0) {
                String str3 = h;
                s1.a(3, str3, "Expired: Time expired - " + ((b2) next).d + " Attempts: " + ((b2) next).c);
                it.remove();
            }
        }
    }

    public final synchronized void d(ReportInfo reportinfo) {
        reportinfo.a();
        e1.a().b(new h());
    }

    public final synchronized void b(ReportInfo reportinfo) {
        if (reportinfo != null) {
            this.b.add(reportinfo);
            e1.a().b(new f());
        }
    }

    public final synchronized void c(ReportInfo reportinfo) {
        ((b2) reportinfo).b = true;
        e1.a().b(new g());
    }
}
