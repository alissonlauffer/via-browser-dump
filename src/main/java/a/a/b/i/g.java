package a.a.b.i;

import a.a.b.d;
import a.a.b.p.a;
import a.a.b.p.b;
import android.content.Context;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/* compiled from: FrogProgressDialog */
public class g extends a<g> {
    private TextView o;
    private ProgressBar p;

    public g(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // a.a.b.i.a
    public boolean a() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // a.a.b.i.a
    public int d() {
        return (super.d() / 3) * 2;
    }

    /* access modifiers changed from: protected */
    @Override // a.a.b.i.a
    public boolean e() {
        return false;
    }

    public g c(int i) {
        c(a.e(((a) this).f11a, i));
        return this;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.b.a(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      a.a.b.p.b.a(android.content.Context, int):int
      a.a.b.p.b.a(android.view.View, int):int
      a.a.b.p.b.a(android.content.Context, float):int */
    @Override // a.a.b.i.a
    public g c(String str) {
        if (this.o == null) {
            ((a) this).e.setOrientation(0);
            ProgressBar progressBar = new ProgressBar(((a) this).f11a);
            this.p = progressBar;
            progressBar.setIndeterminate(false);
            this.p.setIndeterminateDrawable(a.d(((a) this).f11a, d.p));
            this.o = new TextView(((a) this).f11a);
            int a2 = b.a(((a) this).f11a, 2.0f);
            int a3 = b.a(((a) this).f11a, 20.0f);
            int i = a3 - (a3 / 2);
            a.a(this.p, a3, a2, i, a2);
            a.a(this.o, i, a2, a3, a2);
            a.a(this.o, a.a.b.g.k);
            ((a) this).e.addView(this.p);
            ((a) this).e.addView(this.o);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.o.getLayoutParams();
            layoutParams.gravity = 16;
            this.o.setLayoutParams(layoutParams);
        }
        if (TextUtils.isEmpty(str)) {
            this.o.setVisibility(8);
            this.p.setVisibility(8);
        } else {
            this.o.setText(str);
            this.o.setVisibility(0);
            this.p.setVisibility(0);
        }
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // a.a.b.i.a
    public int a(boolean z) {
        TextView textView = this.o;
        if (textView == null || textView.getVisibility() == 8) {
            return 0;
        }
        return b.a(this.o, ((a) this).l);
    }
}
