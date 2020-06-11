package mark.lib.frogsupport.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;

/* renamed from: mark.lib.frogsupport.k.c */
/* compiled from: ViewHolder */
public class ViewHolder {

    /* renamed from: a */
    private SparseArray<View> f1101a = new SparseArray<>();

    /* renamed from: b */
    protected int f1102b;

    /* renamed from: c */
    private View f1103c;

    public ViewHolder(Context context, View view, ViewGroup viewGroup, int i) {
        this.f1103c = view;
        this.f1103c.setTag(this);
    }

    /* renamed from: a */
    public View mo683a() {
        return this.f1103c;
    }

    /* renamed from: b */
    public <T extends View> T mo684b(int i) {
        T t = (T) this.f1101a.get(i);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.f1103c.findViewById(i);
        this.f1101a.put(i, t2);
        return t2;
    }

    /* renamed from: c */
    public ViewHolder mo685c(int i, boolean z) {
        ((Checkable) mo684b(i)).setChecked(z);
        return this;
    }

    /* renamed from: d */
    public ViewHolder mo686d(int i, Bitmap bitmap) {
        ((ImageView) mo684b(i)).setImageBitmap(bitmap);
        return this;
    }

    /* renamed from: e */
    public ViewHolder mo687e(int i, Drawable drawable) {
        ((ImageView) mo684b(i)).setImageDrawable(drawable);
        return this;
    }

    /* renamed from: f */
    public ViewHolder mo688f(int i, View.OnClickListener onClickListener) {
        mo684b(i).setOnClickListener(onClickListener);
        return this;
    }

    /* renamed from: g */
    public ViewHolder mo689g(int i, String str) {
        ((TextView) mo684b(i)).setText(str);
        return this;
    }

    /* renamed from: h */
    public ViewHolder mo690h(int i, boolean z) {
        mo684b(i).setVisibility(z ? 0 : 8);
        return this;
    }
}
