package mark.lib.frogsupport.toast;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import mark.lib.frogsupport.C0366e;
import mark.lib.frogsupport.C0367f;
import mark.lib.frogsupport.util.CompatUtils;
import mark.lib.frogsupport.util.FrogUtils;

/* renamed from: mark.lib.frogsupport.o.a */
/* compiled from: FrogToast */
public class FrogToast {

    /* renamed from: a */
    private Activity f1172a;

    /* renamed from: b */
    private ViewGroup f1173b;

    /* renamed from: c */
    private View f1174c;

    /* renamed from: d */
    private TextView f1175d;

    /* renamed from: e */
    private TextView f1176e;

    /* renamed from: f */
    private OnFrogToastListener f1177f;

    /* renamed from: g */
    private int f1178g;

    /* renamed from: h */
    private boolean f1179h = false;

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.o.a$a */
    /* compiled from: FrogToast */
    public class View$OnClickListenerC0401a implements View.OnClickListener {
        View$OnClickListenerC0401a() {
        }

        public void onClick(View view) {
            if (FrogToast.this.f1177f != null) {
                FrogToast.this.f1179h = true;
                FrogToast.this.f1177f.mo778a();
            }
            FrogToast.this.m1313e();
        }
    }

    public FrogToast(Activity activity, String str, int i, OnFrogToastListener cVar) {
        mo765d(activity, str, CompatUtils.m1336f(activity, i), cVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: e */
    private void m1313e() {
        FrogToastManager.m1325d().mo776f(true);
    }

    /* renamed from: d */
    public void mo765d(Activity activity, String str, String str2, OnFrogToastListener cVar) {
        this.f1172a = activity;
        if (activity != null && !TextUtils.isEmpty(str)) {
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(16908290);
            this.f1173b = viewGroup;
            if (viewGroup != null) {
                View inflate = LayoutInflater.from(activity).inflate(C0367f.h, this.f1173b, false);
                this.f1174c = inflate;
                this.f1175d = (TextView) inflate.findViewById(C0366e.t);
                TextView textView = (TextView) this.f1174c.findViewById(C0366e.s);
                this.f1176e = textView;
                if (Build.VERSION.SDK_INT >= 16) {
                    textView.setAllCaps(true);
                }
                this.f1175d.setText(str);
                this.f1178g = 1600;
                this.f1177f = cVar;
                if (TextUtils.isEmpty(str2)) {
                    FrogUtils.m1361h(this.f1176e);
                    return;
                }
                this.f1178g = 3500;
                this.f1176e.setText(str2);
                this.f1176e.setOnClickListener(new View$OnClickListenerC0401a());
            }
        }
    }

    /* renamed from: f */
    public void mo766f() {
        OnFrogToastListener cVar = this.f1177f;
        if (cVar != null && !this.f1179h) {
            cVar.mo779b();
        }
    }

    /* renamed from: g */
    public Activity mo767g() {
        return this.f1172a;
    }

    /* renamed from: h */
    public int mo768h() {
        return this.f1178g;
    }

    /* renamed from: i */
    public View mo769i() {
        return this.f1174c;
    }

    /* renamed from: j */
    public ViewGroup mo770j() {
        return this.f1173b;
    }

    /* renamed from: k */
    public boolean mo771k() {
        return this.f1173b == null || this.f1174c == null;
    }

    /* renamed from: l */
    public boolean mo772l() {
        View view = this.f1174c;
        return view != null && view.isShown();
    }

    /* renamed from: m */
    public void mo773m() {
        if (!this.f1172a.isFinishing()) {
            FrogToastManager.m1325d().mo775a(this);
        }
    }

    public FrogToast(Activity activity, int i, int i2, OnFrogToastListener cVar) {
        mo765d(activity, CompatUtils.m1336f(activity, i), CompatUtils.m1336f(activity, i2), cVar);
    }

    public FrogToast(Activity activity, String str, String str2, OnFrogToastListener cVar) {
        mo765d(activity, str, str2, cVar);
    }
}
