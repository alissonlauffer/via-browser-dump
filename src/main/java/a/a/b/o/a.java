package a.a.b.o;

import a.a.b.e;
import a.a.b.f;
import a.a.b.p.b;
import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/* compiled from: FrogToast */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Activity f40a;
    private ViewGroup b;
    private View c;
    private TextView d;
    private TextView e;
    /* access modifiers changed from: private */
    public c f;
    private int g;
    /* access modifiers changed from: private */
    public boolean h = false;

    /* renamed from: a.a.b.o.a$a  reason: collision with other inner class name */
    /* compiled from: FrogToast */
    class C0007a implements View.OnClickListener {
        C0007a() {
        }

        public void onClick(View view) {
            if (a.this.f != null) {
                boolean unused = a.this.h = true;
                a.this.f.a();
            }
            a.this.i();
        }
    }

    public a(Activity activity, String str, int i, c cVar) {
        a(activity, str, a.a.b.p.a.e(activity, i), cVar);
    }

    /* access modifiers changed from: private */
    public void i() {
        b.c().a(true);
    }

    public int c() {
        return this.g;
    }

    public View d() {
        return this.c;
    }

    public ViewGroup e() {
        return this.b;
    }

    public boolean f() {
        return this.b == null || this.c == null;
    }

    public boolean g() {
        View view = this.c;
        return view != null && view.isShown();
    }

    public void h() {
        if (!this.f40a.isFinishing()) {
            b.c().a(this);
        }
    }

    public Activity b() {
        return this.f40a;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void a(Activity activity, String str, String str2, c cVar) {
        this.f40a = activity;
        if (activity != null && !TextUtils.isEmpty(str)) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            this.b = viewGroup;
            if (viewGroup != null) {
                View inflate = LayoutInflater.from(activity).inflate(f.q, this.b, false);
                this.c = inflate;
                this.d = (TextView) inflate.findViewById(e.bm);
                TextView textView = (TextView) this.c.findViewById(e.bl);
                this.e = textView;
                if (Build.VERSION.SDK_INT >= 16) {
                    textView.setAllCaps(true);
                }
                this.d.setText(str);
                this.g = 1600;
                this.f = cVar;
                if (TextUtils.isEmpty(str2)) {
                    b.a(this.e);
                    return;
                }
                this.g = 3500;
                this.e.setText(str2);
                this.e.setOnClickListener(new C0007a());
            }
        }
    }

    public a(Activity activity, int i, int i2, c cVar) {
        a(activity, a.a.b.p.a.e(activity, i), a.a.b.p.a.e(activity, i2), cVar);
    }

    public a(Activity activity, String str, String str2, c cVar) {
        a(activity, str, str2, cVar);
    }

    public void a() {
        c cVar = this.f;
        if (cVar != null && !this.h) {
            cVar.b();
        }
    }
}
