package a.a.b.i;

import a.a.b.g;
import a.a.b.p.a;
import a.a.b.p.b;
import android.content.Context;
import android.widget.TextView;

/* compiled from: FrogDialog */
public class c extends a<c> {
    private TextView o;

    public c(Context context) {
        super(context);
    }

    public c c(int i) {
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
    public c c(String str) {
        if (this.o == null) {
            this.o = new TextView(((a) this).f11a);
            int a2 = b.a(((a) this).f11a, 2.0f);
            int a3 = b.a(((a) this).f11a, 20.0f);
            this.o.setPadding(a3, a2, a3, a2);
            this.o.setMinimumHeight(b.a(((a) this).f11a, 80.0f));
            a.a(this.o, g.k);
            this.o.setLineSpacing((float) b.a(((a) this).f11a, 2.0f), 1.0f);
            ((a) this).e.addView(this.o);
        }
        this.o.setText(str);
        this.o.setVisibility(0);
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
