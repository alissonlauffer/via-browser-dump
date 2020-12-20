package com.flurry.sdk;

import com.flurry.sdk.AbstractC0039b2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.flurry.sdk.c2 */
public abstract class AbstractC0066c2<ReportInfo extends AbstractC0039b2> {

    /* renamed from: h */
    private static final String f209h = "c2";

    /* renamed from: i */
    protected static long f210i = 10000;

    /* renamed from: a */
    private final C0174k1<List<ReportInfo>> f211a;

    /* renamed from: b */
    private final List<ReportInfo> f212b = new ArrayList();

    /* renamed from: c */
    public boolean f213c;

    /* renamed from: d */
    private int f214d;

    /* renamed from: e */
    protected long f215e;

    /* renamed from: f */
    public final Runnable f216f = new C0067a();

    /* renamed from: g */
    public final AbstractC0192m1<C0298w0> f217g;

    /* renamed from: com.flurry.sdk.c2$a */
    class C0067a extends AbstractRunnableC0040b3 {
        C0067a() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            AbstractC0066c2.this.m282f();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.c2$b */
    public class C0068b implements AbstractC0192m1<C0298w0> {
        C0068b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.AbstractC0192m1
        /* renamed from: a */
        public final /* bridge */ /* synthetic */ void mo74a(C0298w0 w0Var) {
            if (w0Var.f825b) {
                AbstractC0066c2.this.m282f();
            }
        }
    }

    /* renamed from: com.flurry.sdk.c2$c */
    class C0069c extends AbstractRunnableC0040b3 {
        C0069c() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            AbstractC0066c2 c2Var = AbstractC0066c2.this;
            c2Var.mo142d(c2Var.f212b);
            AbstractC0066c2.this.m282f();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.c2$d */
    public class C0070d extends AbstractRunnableC0040b3 {
        C0070d() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            AbstractC0066c2.this.m285l();
        }
    }

    /* renamed from: com.flurry.sdk.c2$e */
    public class C0071e extends AbstractRunnableC0040b3 {
        public C0071e() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            AbstractC0066c2.this.m282f();
        }
    }

    /* renamed from: com.flurry.sdk.c2$f */
    class C0072f extends AbstractRunnableC0040b3 {
        C0072f() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            AbstractC0066c2.this.m282f();
        }
    }

    /* renamed from: com.flurry.sdk.c2$g */
    class C0073g extends AbstractRunnableC0040b3 {
        C0073g() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            AbstractC0066c2.this.m285l();
        }
    }

    /* renamed from: com.flurry.sdk.c2$h */
    class C0074h extends AbstractRunnableC0040b3 {
        C0074h() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            AbstractC0066c2.this.m285l();
        }
    }

    public AbstractC0066c2() {
        C0068b bVar = new C0068b();
        this.f217g = bVar;
        C0199n1.m528a().mo271e("com.flurry.android.sdk.NetworkStateEvent", bVar);
        this.f211a = mo140a();
        this.f215e = f210i;
        this.f214d = -1;
        C0118e1.m386a().mo191g(new C0069c());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: f */
    private synchronized void m282f() {
        if (!this.f213c) {
            if (this.f214d >= 0) {
                C0260s1.m686c(3, f209h, "Transmit is in progress");
                return;
            }
            m283i();
            if (this.f212b.isEmpty()) {
                this.f215e = f210i;
                this.f214d = -1;
                return;
            }
            this.f214d = 0;
            C0118e1.m386a().mo191g(new C0070d());
        }
    }

    /* renamed from: i */
    private synchronized void m283i() {
        Iterator<ReportInfo> it = this.f212b.iterator();
        while (it.hasNext()) {
            ReportInfo next = it.next();
            if (next.f126b) {
                String str = f209h;
                C0260s1.m686c(3, str, "Url transmitted - " + next.f128d + " Attempts: " + next.f127c);
                it.remove();
            } else if (next.f127c > next.f130f) {
                String str2 = f209h;
                C0260s1.m686c(3, str2, "Exceeded max no of attempts - " + next.f128d + " Attempts: " + next.f127c);
                it.remove();
            } else if (System.currentTimeMillis() > next.f125a && next.f127c > 0) {
                String str3 = f209h;
                C0260s1.m686c(3, str3, "Expired: Time expired - " + next.f128d + " Attempts: " + next.f127c);
                it.remove();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: l */
    private synchronized void m285l() {
        C0328z2.m889d();
        ReportInfo reportinfo = null;
        if (C0054by.m254a().f176b) {
            while (true) {
                if (this.f214d >= this.f212b.size()) {
                    break;
                }
                List<ReportInfo> list = this.f212b;
                int i = this.f214d;
                this.f214d = i + 1;
                ReportInfo reportinfo2 = list.get(i);
                if (!reportinfo2.f126b) {
                    reportinfo = reportinfo2;
                    break;
                }
            }
        } else {
            C0260s1.m686c(3, f209h, "Network is not available, aborting transmission");
        }
        if (reportinfo == null) {
            m286n();
        } else {
            mo141b(reportinfo);
        }
    }

    /* renamed from: n */
    private synchronized void m286n() {
        m283i();
        mo144h(this.f212b);
        if (this.f213c) {
            C0260s1.m686c(3, f209h, "Reporter paused");
            this.f215e = f210i;
        } else if (this.f212b.isEmpty()) {
            C0260s1.m686c(3, f209h, "All reports sent successfully");
            this.f215e = f210i;
        } else {
            this.f215e <<= 1;
            C0260s1.m686c(3, f209h, "One or more reports failed to send, backing off: " + this.f215e + "ms");
            C0118e1.m386a().mo190e(this.f216f, this.f215e);
        }
        this.f214d = -1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract C0174k1<List<ReportInfo>> mo140a();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo141b(ReportInfo reportinfo);

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public synchronized void mo142d(List<ReportInfo> list) {
        throw null;
    }

    /* renamed from: g */
    public final synchronized void mo143g(ReportInfo reportinfo) {
        if (reportinfo != null) {
            this.f212b.add(reportinfo);
            C0118e1.m386a().mo191g(new C0072f());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public synchronized void mo144h(List<ReportInfo> list) {
        throw null;
    }

    /* renamed from: j */
    public final synchronized void mo145j(ReportInfo reportinfo) {
        reportinfo.f126b = true;
        C0118e1.m386a().mo191g(new C0073g());
    }

    /* renamed from: m */
    public final synchronized void mo146m(ReportInfo reportinfo) {
        reportinfo.mo120a();
        C0118e1.m386a().mo191g(new C0074h());
    }
}
