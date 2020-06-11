package a.a.b.k;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: ViewHolder */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<View> f22a = new SparseArray<>();
    protected int b;
    private View c;

    public c(Context context, View view, ViewGroup viewGroup, int i) {
        this.c = view;
        this.c.setTag(this);
    }

    public <T extends View> T a(int i) {
        T t = this.f22a.get(i);
        if (t != null) {
            return t;
        }
        T findViewById = this.c.findViewById(i);
        this.f22a.put(i, findViewById);
        return findViewById;
    }

    public c b(int i, boolean z) {
        a(i).setVisibility(z ? 0 : 8);
        return this;
    }

    public View a() {
        return this.c;
    }

    public c a(int i, String str) {
        ((TextView) a(i)).setText(str);
        return this;
    }

    public c a(int i, int i2) {
        ((ImageView) a(i)).setImageResource(i2);
        return this;
    }

    public c a(int i, Bitmap bitmap) {
        ((ImageView) a(i)).setImageBitmap(bitmap);
        return this;
    }

    public c a(int i, Drawable drawable) {
        ((ImageView) a(i)).setImageDrawable(drawable);
        return this;
    }

    public c a(int i, boolean z) {
        ((Checkable) a(i)).setChecked(z);
        return this;
    }

    public c a(int i, View.OnClickListener onClickListener) {
        a(i).setOnClickListener(onClickListener);
        return this;
    }
}
