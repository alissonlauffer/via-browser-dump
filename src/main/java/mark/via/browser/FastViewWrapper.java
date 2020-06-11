package mark.via.browser;

import android.content.Context;
import mark.via.utils.WebViewUtil;

/* renamed from: mark.via.browser.z */
/* compiled from: FastViewWrapper */
public class FastViewWrapper {

    /* renamed from: a */
    private int f1261a;

    /* renamed from: b */
    private Context f1262b;

    /* renamed from: c */
    private FastView f1263c = null;

    /* renamed from: d */
    private AbstractC0436a f1264d;

    /* renamed from: e */
    private C0437b f1265e;

    /* renamed from: mark.via.browser.z$a */
    /* compiled from: FastViewWrapper */
    public interface AbstractC0436a {
        /* renamed from: a */
        void mo906a(FastView fastView);
    }

    /* renamed from: mark.via.browser.z$b */
    /* compiled from: FastViewWrapper */
    public static class C0437b {

        /* renamed from: a */
        String f1266a = null;

        /* renamed from: b */
        int f1267b = 0;

        /* renamed from: c */
        int f1268c = 0;

        /* renamed from: d */
        int f1269d = 0;
    }

    public FastViewWrapper(Context context) {
        this.f1262b = context;
        this.f1265e = new C0437b();
    }

    /* renamed from: c */
    private FastView m1530c() {
        FastView fastView = new FastView(this.f1262b);
        fastView.setId(this.f1261a);
        AbstractC0436a aVar = this.f1264d;
        if (aVar != null) {
            aVar.mo906a(fastView);
        }
        return fastView;
    }

    /* renamed from: e */
    private void m1531e() {
        FastView fastView = this.f1263c;
        if (fastView != null) {
            WebViewUtil.m2041a(fastView);
            this.f1263c = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void mo913i(int i) {
        FastView fastView = this.f1263c;
        if (fastView != null) {
            C0437b bVar = this.f1265e;
            fastView.scrollTo(bVar.f1268c, bVar.f1269d);
            C0437b bVar2 = this.f1265e;
            bVar2.f1268c = 0;
            bVar2.f1269d = 0;
            this.f1263c.getSettings().setCacheMode(i);
        }
    }

    /* renamed from: a */
    public void mo908a() {
        this.f1263c = m1530c();
    }

    /* renamed from: b */
    public void mo909b() {
        FastView fastView = this.f1263c;
        if (fastView != null) {
            this.f1265e.f1266a = fastView.getUrl();
            this.f1265e.f1269d = this.f1263c.getScrollY();
            this.f1265e.f1268c = this.f1263c.getScrollX();
            this.f1265e.f1267b = this.f1263c.getWebColor();
            m1531e();
        }
    }

    /* renamed from: d */
    public void mo910d() {
        m1531e();
        this.f1264d = null;
        this.f1265e = null;
    }

    /* renamed from: f */
    public FastView mo911f() {
        return this.f1263c;
    }

    /* renamed from: g */
    public boolean mo912g() {
        return this.f1263c == null;
    }

    /* renamed from: j */
    public void mo914j() {
        if (this.f1263c == null) {
            this.f1263c = m1530c();
            String str = this.f1265e.f1266a;
            if (str != null && str.length() > 0) {
                this.f1263c.setWebColor(this.f1265e.f1267b);
                int cacheMode = this.f1263c.getSettings().getCacheMode();
                this.f1263c.getSettings().setCacheMode(1);
                this.f1263c.loadUrl(this.f1265e.f1266a);
                this.f1265e.f1266a = null;
                this.f1263c.postDelayed(new RunnableC0405a(this, cacheMode), 300);
            }
        }
    }

    /* renamed from: k */
    public FastViewWrapper mo915k(AbstractC0436a aVar) {
        this.f1264d = aVar;
        return this;
    }

    /* renamed from: l */
    public FastViewWrapper mo916l(int i) {
        this.f1261a = i;
        return this;
    }
}
