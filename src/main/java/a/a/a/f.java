package a.a.a;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/* compiled from: TaskViewHolder */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<View> f8a = new SparseArray<>();
    private View b;

    public f(View view) {
        this.b = view;
        view.setTag(this);
    }

    public <T extends View> T a(int i) {
        T t = this.f8a.get(i);
        if (t != null) {
            return t;
        }
        T findViewById = this.b.findViewById(i);
        this.f8a.put(i, findViewById);
        return findViewById;
    }

    public void a(int i, String str) {
        ((TextView) a(i)).setText(str);
    }
}
