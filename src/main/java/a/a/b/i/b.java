package a.a.b.i;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

/* compiled from: FrogCustomDialog */
public class b extends a<b> {
    private View o;

    public b(Context context) {
        super(context);
    }

    public b b(View view) {
        ((a) this).e.removeAllViews();
        if (view != null) {
            ((a) this).e.addView(view, new LinearLayout.LayoutParams(-1, -2));
            this.o = view;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    @Override // a.a.b.i.a
    public int a(boolean z) {
        View view = this.o;
        if (view == null) {
            return 0;
        }
        return a.a.b.p.b.a(view, ((a) this).l);
    }
}
