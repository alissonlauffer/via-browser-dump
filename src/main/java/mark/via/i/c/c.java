package mark.via.i.c;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: Slice */
public abstract class c {
    /* access modifiers changed from: private */
    public static int d = -2;

    /* renamed from: a  reason: collision with root package name */
    protected Activity f274a;
    protected Context b;
    protected View c;

    /* compiled from: Slice */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private int f275a = -2;

        private a() {
        }

        public static a b() {
            return new a();
        }

        public a a(int i) {
            this.f275a = i;
            return this;
        }

        public void a() {
            int unused = c.d = this.f275a;
        }
    }

    c(Activity activity) {
        this.f274a = activity;
        this.b = activity;
    }

    /* access modifiers changed from: protected */
    public int b() {
        return d;
    }

    public abstract View c();

    public void d() {
    }

    public void e() {
        this.c = null;
    }

    public View a() {
        if (this.c == null) {
            View c2 = c();
            this.c = c2;
            ViewGroup.LayoutParams layoutParams = c2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
            }
            layoutParams.width = b();
            this.c.setLayoutParams(layoutParams);
        }
        d();
        return this.c;
    }
}
