package mark.via.ui.activity;

import a.a.b.p.d;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import mark.via.gp.R;
import mark.via.util.CrashUtils;
import mark.via.util.b;
import mark.via.util.q;

public final class CrashActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Class<? extends Activity> f353a;
    private CrashUtils.EventListener b;
    /* access modifiers changed from: private */
    public Context c;
    private Activity d;
    /* access modifiers changed from: private */
    public boolean e;
    private boolean f;
    private boolean g;
    /* access modifiers changed from: private */
    public TextView h;
    /* access modifiers changed from: private */
    public TextView i;
    private String j;

    class a implements q.d {
        a() {
        }

        @Override // mark.via.util.q.d
        public void a() {
            boolean unused = CrashActivity.this.e = true;
            CrashActivity.this.findViewById(R.id.p).setVisibility(8);
            CrashActivity.this.findViewById(R.id.m).setVisibility(8);
            CrashActivity.this.i.setText(CrashActivity.this.getResources().getString(CrashActivity.this.f353a != null ? R.string.bw : R.string.bt));
            CrashActivity.this.h.setText(CrashActivity.this.c.getResources().getString(R.string.ik));
        }
    }

    public void onBtnClick(View view) {
        int id = view.getId();
        if (id == R.id.m) {
            a();
        } else if (id == R.id.q) {
            if (this.f) {
                mark.via.util.a.a(this.d, "com.google.android.webview");
            } else if (!this.g || this.e) {
                a();
            } else {
                q qVar = new q(this.c);
                qVar.a(new a());
                qVar.a(mark.via.f.a.b(this.c).j() == 1 ? "https://app.viayoo.com/api/error" : "http://via.oktutu.com/api/error", CrashUtils.a(this.c, getIntent()));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = this;
        this.d = this;
        setContentView(R.layout.i);
        b();
    }

    private void b() {
        this.e = false;
        this.f = false;
        this.g = b.g(this.c) != 0;
        this.h = (TextView) findViewById(R.id.n);
        this.i = (TextView) findViewById(R.id.q);
        this.f353a = CrashUtils.b(getIntent());
        this.b = CrashUtils.a(getIntent());
        this.j = CrashUtils.c(getIntent());
        Class<? extends Activity> cls = this.f353a;
        int i2 = R.string.bw;
        if (cls != null) {
            ((TextView) findViewById(R.id.m)).setText(getResources().getString(R.string.bw));
        }
        if (this.j != null) {
            this.h.setVisibility(0);
            d.a("crash: ", this.j);
            if (this.j.contains("MissingWebViewPackageException") || this.j.contains("Unsupported ABI") || this.j.contains("android.webkit.WebView.<init>") || (this.j.contains("NameNotFoundException") && !mark.via.util.a.a(this.c, "com.android.webview") && !mark.via.util.a.a(this.c, "com.google.android.webview"))) {
                this.f = true;
                this.h.setText(getResources().getString(R.string.ez));
                this.i.setText(getResources().getString(R.string.ed));
            } else if (this.g) {
                this.h.setText(getResources().getString(R.string.il));
                this.i.setText(getResources().getString(R.string.bx));
            } else {
                this.h.setText(getResources().getString(R.string.bu));
                findViewById(R.id.m).setVisibility(8);
                TextView textView = this.i;
                Resources resources = getResources();
                if (this.f353a == null) {
                    i2 = R.string.bt;
                }
                textView.setText(resources.getString(i2));
            }
        }
    }

    private void a() {
        if (this.f353a != null) {
            CrashUtils.a(this, new Intent(this, this.f353a), this.b);
        } else {
            CrashUtils.a(this, this.b);
        }
    }
}
