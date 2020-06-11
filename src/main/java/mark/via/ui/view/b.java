package mark.via.ui.view;

import android.content.Context;
import mark.via.h.c.d;

/* compiled from: FastViewWrapper */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f468a;
    /* access modifiers changed from: private */
    public FastView b = null;
    private boolean c = false;
    private String d = null;
    private C0051b e;
    private int f = 0;
    /* access modifiers changed from: private */
    public int g;
    /* access modifiers changed from: private */
    public int h;

    /* compiled from: FastViewWrapper */
    class a implements Runnable {
        a() {
        }

        public void run() {
            if (b.this.b != null) {
                b.this.b.scrollTo(b.this.g, b.this.h);
                int unused = b.this.g = 0;
                int unused2 = b.this.h = 0;
            }
        }
    }

    /* renamed from: mark.via.ui.view.b$b  reason: collision with other inner class name */
    /* compiled from: FastViewWrapper */
    public interface C0051b {
        void a(FastView fastView);
    }

    public b(Context context, C0051b bVar) {
        this.f468a = context;
        this.e = bVar;
        f();
    }

    private void f() {
        if (this.b == null) {
            FastView fastView = new FastView(this.f468a);
            this.b = fastView;
            C0051b bVar = this.e;
            if (bVar != null) {
                bVar.a(fastView);
            }
        }
    }

    private void g() {
        FastView fastView = this.b;
        if (fastView != null) {
            d.a(fastView);
            this.b = null;
        }
    }

    public boolean d() {
        return this.c;
    }

    public void e() {
        if (this.c && this.b == null) {
            f();
            String str = this.d;
            if (str != null && str.length() > 0) {
                this.b.setWebColor(this.f);
                int cacheMode = this.b.getSettings().getCacheMode();
                this.b.getSettings().setCacheMode(1);
                this.b.loadUrl(this.d);
                this.b.getSettings().setCacheMode(cacheMode);
                this.d = null;
                this.b.postDelayed(new a(), 300);
            }
            this.c = false;
        }
    }

    public FastView c() {
        return this.b;
    }

    public void a() {
        FastView fastView;
        if (!this.c && (fastView = this.b) != null) {
            this.d = fastView.getUrl();
            this.h = this.b.getScrollY();
            this.g = this.b.getScrollX();
            this.f = this.b.getWebColor();
            g();
            this.c = true;
        }
    }

    public void b() {
        g();
        this.e = null;
        this.d = null;
    }
}
