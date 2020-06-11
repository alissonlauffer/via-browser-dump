package a.a.b.i;

import a.a.b.d;
import a.a.b.g;
import a.a.b.p.b;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* compiled from: FrogMenuDialog */
public class e extends a<e> {
    private int o = 0;
    /* access modifiers changed from: private */
    public View.OnClickListener p;

    /* compiled from: FrogMenuDialog */
    class a implements View.OnClickListener {
        a() {
        }

        public void onClick(View view) {
            if (e.this.p != null) {
                e.this.p.onClick(view);
            }
            e.this.c();
        }
    }

    public e(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    @Override // a.a.b.i.a
    public boolean a() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // a.a.b.i.a
    public boolean b() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // a.a.b.i.a
    public int d() {
        return (super.d() / 3) * 2;
    }

    public e b(int i, int i2) {
        a(i, a.a.b.p.a.e(((a) this).f11a, i2));
        return this;
    }

    public e b(int i, boolean z) {
        TextView textView = (TextView) ((a) this).e.findViewById(i);
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
        return this;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.b.a(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      a.a.b.p.b.a(android.content.Context, int):int
      a.a.b.p.b.a(android.view.View, int):int
      a.a.b.p.b.a(android.content.Context, float):int */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.a.a(android.view.View, int):void
     arg types: [android.widget.TextView, int]
     candidates:
      a.a.b.p.a.a(android.content.Context, int):int
      a.a.b.p.a.a(android.view.View, android.graphics.drawable.Drawable):void
      a.a.b.p.a.a(android.view.View, boolean):void
      a.a.b.p.a.a(android.widget.TextView, int):void
      a.a.b.p.a.a(java.lang.String[], int):boolean
      a.a.b.p.a.a(android.view.View, int):void */
    private void b(int i, String str) {
        TextView textView = (TextView) ((a) this).e.findViewById(i);
        if (textView == null) {
            textView = new TextView(((a) this).f11a);
            a.a.b.p.a.a(textView, b.a(((a) this).f11a, 20.0f), b.a(((a) this).f11a, 11.0f));
            a.a.b.p.a.a(textView, g.k);
            textView.setMaxLines(1);
            textView.setSingleLine();
            textView.setId(i);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            a.a.b.p.a.a((View) textView, d.f);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int a2 = b.a(((a) this).f11a, 0.0f);
            layoutParams.topMargin = a2;
            layoutParams.bottomMargin = a2;
            ((a) this).e.addView(textView, layoutParams);
            textView.setOnClickListener(new a());
            if (this.o == 0) {
                this.o = b.a(textView, ((a) this).l);
            }
        }
        textView.setText(str);
    }

    public e a(int i, String str) {
        b(i, str);
        return this;
    }

    public e a(View.OnClickListener onClickListener) {
        this.p = onClickListener;
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // a.a.b.i.a
    public int a(boolean z) {
        LinearLayout linearLayout = ((a) this).e;
        if (linearLayout == null || linearLayout.getVisibility() == 8) {
            return 0;
        }
        return this.o * ((a) this).e.getChildCount();
    }
}
