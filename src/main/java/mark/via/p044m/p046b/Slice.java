package mark.via.p044m.p046b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: mark.via.m.b.j */
/* compiled from: Slice */
public abstract class Slice {

    /* renamed from: d */
    private static int f1458d = -2;

    /* renamed from: a */
    protected Activity f1459a;

    /* renamed from: b */
    protected Context f1460b;

    /* renamed from: c */
    protected View f1461c;

    /* renamed from: mark.via.m.b.j$a */
    /* compiled from: Slice */
    public static class C0483a {

        /* renamed from: a */
        private int f1462a = -2;

        private C0483a() {
        }

        /* renamed from: b */
        public static C0483a m2001b() {
            return new C0483a();
        }

        /* renamed from: a */
        public void mo1273a() {
            int unused = Slice.f1458d = this.f1462a;
        }

        /* renamed from: c */
        public C0483a mo1274c(int i) {
            this.f1462a = i;
            return this;
        }
    }

    Slice(Activity activity) {
        this.f1459a = activity;
        this.f1460b = activity;
    }

    /* renamed from: b */
    public View mo1271b() {
        if (this.f1461c == null) {
            View d = mo1254d();
            this.f1461c = d;
            ViewGroup.LayoutParams layoutParams = d.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
            }
            layoutParams.width = mo1272c();
            this.f1461c.setLayoutParams(layoutParams);
        }
        mo1263e();
        return this.f1461c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public int mo1272c() {
        return f1458d;
    }

    /* renamed from: d */
    public abstract View mo1254d();

    /* renamed from: e */
    public void mo1263e() {
    }

    /* renamed from: f */
    public void mo1255f() {
        this.f1461c = null;
    }
}
