package a.a.b.i;

import a.a.b.e;
import a.a.b.f;
import a.a.b.g;
import a.a.b.i.a;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/* compiled from: FrogBaseDialog */
abstract class a<T extends a> {

    /* renamed from: a  reason: collision with root package name */
    protected Context f11a;
    protected Dialog b;
    protected RelativeLayout c;
    protected TextView d;
    protected LinearLayout e;
    private ScrollView f;
    protected TextView g;
    protected CheckBox h;
    protected TextView i;
    protected TextView j;
    protected TextView k;
    protected int l = 0;
    protected int m = 0;
    protected int[] n = new int[5];

    /* renamed from: a.a.b.i.a$a  reason: collision with other inner class name */
    /* compiled from: FrogBaseDialog */
    class C0001a implements View.OnClickListener {
        C0001a() {
        }

        public void onClick(View view) {
            CheckBox checkBox = a.this.h;
            checkBox.setChecked(!checkBox.isChecked());
        }
    }

    /* compiled from: FrogBaseDialog */
    class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f13a;

        b(View.OnClickListener onClickListener) {
            this.f13a = onClickListener;
        }

        public void onClick(View view) {
            View.OnClickListener onClickListener = this.f13a;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            a.this.c();
        }
    }

    /* compiled from: FrogBaseDialog */
    class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f14a;

        c(i iVar) {
            this.f14a = iVar;
        }

        public void onClick(View view) {
            if (this.f14a != null) {
                if (a.this.b() && a.this.h.getVisibility() == 0) {
                    this.f14a.a(a.this.h.isChecked());
                }
                this.f14a.a();
            }
            a.this.c();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, T, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    protected a(Context context) {
        this.f11a = context;
        View inflate = LayoutInflater.from(context).inflate(f.k, (ViewGroup) ((Activity) this.f11a).findViewById(16908290), false);
        this.c = inflate.findViewById(e.ai);
        this.e = inflate.findViewById(e.aa);
        this.d = inflate.findViewById(e.bk);
        this.g = inflate.findViewById(e.ba);
        this.h = inflate.findViewById(e.i);
        T findViewById = inflate.findViewById(e.as);
        this.f = findViewById;
        findViewById.setOverScrollMode(Build.VERSION.SDK_INT >= 21 ? 1 : 2);
        this.i = inflate.findViewById(e.b6);
        this.j = inflate.findViewById(e.b4);
        T findViewById2 = inflate.findViewById(e.b5);
        this.k = findViewById2;
        a.a.b.p.b.a(this.d, this.i, this.j, findViewById2, this.g, this.h);
        Dialog dialog = new Dialog(this.f11a, g.h);
        this.b = dialog;
        dialog.setContentView(inflate);
        Window window = this.b.getWindow();
        if (window != null) {
            window.setWindowAnimations(g.d);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.b.a(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      a.a.b.p.b.a(android.content.Context, int):int
      a.a.b.p.b.a(android.view.View, int):int
      a.a.b.p.b.a(android.content.Context, float):int */
    private void d(boolean z) {
        int a2 = a.a.b.p.b.a(this.f11a);
        if (z) {
            a2 = (a2 * 2) / 3;
        }
        this.m = a2;
        int d2 = d();
        if (z) {
            d2 = Math.max((d2 * 4) / 5, a.a.b.p.b.a(this.f11a, 160.0f));
        }
        this.l = d2;
        int a3 = a.a.b.p.b.a(this.f11a, 12.0f);
        int a4 = a.a.b.p.b.a(this.f11a, 0.0f);
        this.c.setPadding(a4, a3, a4, a3);
        int i2 = -2;
        this.c.setLayoutParams(new FrameLayout.LayoutParams(this.l, -2));
        int i3 = 0;
        this.n[0] = this.d.getVisibility() == 0 ? a.a.b.p.b.a(this.d, this.l) : 0;
        this.n[2] = this.g.getVisibility() == 0 ? a.a.b.p.b.a(this.g, this.l) : 0;
        int[] iArr = this.n;
        if (this.i.getVisibility() == 0) {
            i3 = a.a.b.p.b.a(this.i, this.l);
        }
        iArr[3] = i3;
        this.n[1] = a(z);
        this.n[4] = a3 * 2;
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        int h2 = h();
        int i4 = this.m;
        if (h2 >= i4) {
            i2 = (i4 - h2) + this.n[1];
        }
        layoutParams.height = i2;
        this.f.setLayoutParams(layoutParams);
    }

    private int h() {
        int length = this.n.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 += this.n[i3];
        }
        return i2;
    }

    private T i() {
        return this;
    }

    /* access modifiers changed from: protected */
    public abstract int a(boolean z);

    public T a(int i2, boolean z) {
        return a(a.a.b.p.a.e(this.f11a, i2), z);
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        return true;
    }

    public T b(boolean z) {
        this.b.setCancelable(z);
        i();
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return true;
    }

    public T c(boolean z) {
        this.b.setCanceledOnTouchOutside(z);
        i();
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean e() {
        return true;
    }

    public boolean f() {
        Dialog dialog = this.b;
        return dialog != null && dialog.isShowing();
    }

    public void g() {
        if (!((Activity) this.f11a).isFinishing() && a(false) != 0) {
            d(false);
            this.b.show();
        }
    }

    public T a(String str, boolean z) {
        if (!c(str) || !b()) {
            this.h.setVisibility(8);
        } else {
            this.h.setChecked(z);
            this.g.setOnClickListener(new C0001a());
            this.h.setVisibility(0);
        }
        i();
        return this;
    }

    private boolean c(String str) {
        if (!e() || !TextUtils.isEmpty(str)) {
            this.g.setText(str);
            this.g.setVisibility(0);
            return true;
        }
        this.g.setVisibility(8);
        return false;
    }

    public T b(int i2) {
        return b(a.a.b.p.a.e(this.f11a, i2));
    }

    public T b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.d.setVisibility(8);
        } else {
            this.d.setText(str);
            this.d.setVisibility(0);
        }
        i();
        return this;
    }

    public T c(int i2, View.OnClickListener onClickListener) {
        return c(a.a.b.p.a.e(this.f11a, i2), onClickListener);
    }

    public T a(int i2) {
        return a(a.a.b.p.a.e(this.f11a, i2));
    }

    public T c(String str, View.OnClickListener onClickListener) {
        a(this.i, str, onClickListener);
        i();
        return this;
    }

    public T a(String str) {
        if (c(str)) {
            this.h.setVisibility(8);
        }
        i();
        return this;
    }

    public T b(int i2, View.OnClickListener onClickListener) {
        return b(a.a.b.p.a.e(this.f11a, i2), onClickListener);
    }

    public T b(String str, View.OnClickListener onClickListener) {
        a(this.k, str, onClickListener);
        i();
        return this;
    }

    public void c() {
        Dialog dialog;
        if (!((Activity) this.f11a).isFinishing() && (dialog = this.b) != null && dialog.isShowing()) {
            this.b.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(TextView textView, String str) {
        if (textView != null && a()) {
            if (!TextUtils.isEmpty(str)) {
                if (Build.VERSION.SDK_INT >= 14) {
                    textView.setAllCaps(true);
                }
                textView.setText(str);
                textView.setVisibility(0);
                return true;
            }
            textView.setVisibility(8);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int d() {
        return a.a.b.p.b.b(this.f11a);
    }

    private void a(TextView textView, String str, View.OnClickListener onClickListener) {
        if (a(textView, str)) {
            textView.setOnClickListener(new b(onClickListener));
        }
    }

    public T a(int i2, i iVar) {
        return a(a.a.b.p.a.e(this.f11a, i2), iVar);
    }

    public T a(String str, i iVar) {
        if (a(this.i, str)) {
            this.i.setOnClickListener(new c(iVar));
        }
        i();
        return this;
    }

    public T a(int i2, View.OnClickListener onClickListener) {
        return a(a.a.b.p.a.e(this.f11a, i2), onClickListener);
    }

    public T a(String str, View.OnClickListener onClickListener) {
        a(this.j, str, onClickListener);
        i();
        return this;
    }

    public void a(View view) {
        a(view, -a.a.b.p.a.c(this.f11a, a.a.b.c.e), 0);
    }

    public void a(View view, int i2, int i3) {
        if (view == null) {
            g();
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        view.getRootView().findViewById(16908290).getLocationOnScreen(iArr2);
        iArr[0] = iArr[0] - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        a(iArr[0] + (view.getWidth() / 2) + i2, iArr[1] + (view.getHeight() / 2) + i3);
    }

    public void a(int i2, int i3) {
        if (!((Activity) this.f11a).isFinishing() && a(true) != 0) {
            d(true);
            int d2 = a.a.b.p.b.d(this.f11a);
            int c2 = a.a.b.p.b.c(this.f11a);
            if (i2 > d2 / 2) {
                i2 -= this.l;
            }
            int h2 = h();
            if (i3 > c2 / 2) {
                i3 -= h2;
            }
            Window window = this.b.getWindow();
            if (window != null) {
                window.setSoftInputMode(16);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 51;
                attributes.x = i2;
                attributes.y = i3;
                attributes.flags &= -3;
                window.setAttributes(attributes);
            }
            this.b.setCancelable(true);
            this.b.setCanceledOnTouchOutside(true);
            this.b.show();
        }
    }
}
