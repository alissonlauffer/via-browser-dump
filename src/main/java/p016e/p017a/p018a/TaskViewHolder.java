package p016e.p017a.p018a;

import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/* renamed from: e.a.a.f */
/* compiled from: TaskViewHolder */
public class TaskViewHolder {

    /* renamed from: a */
    private SparseArray<View> f934a = new SparseArray<>();

    /* renamed from: b */
    private View f935b;

    public TaskViewHolder(View view) {
        this.f935b = view;
        view.setTag(this);
    }

    /* renamed from: a */
    public <T extends View> T mo416a(int i) {
        T t = (T) this.f934a.get(i);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.f935b.findViewById(i);
        this.f934a.put(i, t2);
        return t2;
    }

    /* renamed from: b */
    public void mo417b(int i, String str) {
        ((TextView) mo416a(i)).setText(str);
    }
}
