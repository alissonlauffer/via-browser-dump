package a.a.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TasksAdapter */
public abstract class g extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<e> f9a = new ArrayList();
    private List<Long> b = new ArrayList();
    private int c;
    private int d;
    private a e;
    private int f = -1;

    /* compiled from: TasksAdapter */
    public interface a {
        void a(boolean z);
    }

    public g(int i) {
        this.d = i;
    }

    private int b(long j) {
        int i = this.c;
        if (i >= 0 && i < this.b.size() && this.b.get(this.c).longValue() == j) {
            return this.c;
        }
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (j == this.b.get(i2).longValue()) {
                this.c = i2;
                return i2;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public abstract void a(f fVar, e eVar);

    public boolean a(long j) {
        return b(j) >= 0;
    }

    public int getCount() {
        return this.f9a.size();
    }

    public long getItemId(int i) {
        return (long) i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View getView(int i, View view, ViewGroup viewGroup) {
        f fVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(this.d, viewGroup, false);
            fVar = new f(view);
        } else {
            fVar = (f) view.getTag();
        }
        a(fVar, this.f9a.get(i));
        return view;
    }

    public boolean isEmpty() {
        return getCount() == 0;
    }

    public void a(int i, e eVar) {
        if (i >= 0 && i < this.b.size() && eVar != null && this.b.get(i).longValue() != eVar.d()) {
            this.b.set(i, Long.valueOf(eVar.d()));
            this.f9a.set(i, eVar);
            notifyDataSetChanged();
        }
    }

    public e getItem(int i) {
        return this.f9a.get(i);
    }

    private void b() {
        if (this.e != null) {
            boolean z = getCount() > 0;
            if (this.f != z) {
                this.e.a(!z);
                this.f = z ? 1 : 0;
            }
        }
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Long l : this.b) {
            long longValue = l.longValue();
            if (z) {
                z = false;
            } else {
                sb.append(",");
            }
            sb.append(longValue);
        }
        return sb.toString();
    }

    public void a(List<e> list) {
        if (list != null && !list.isEmpty()) {
            this.f9a = list;
            this.b = new ArrayList();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                this.b.add(Long.valueOf(list.get(i).d()));
            }
            notifyDataSetChanged();
        }
        b();
    }

    public void a(e eVar) {
        if (eVar != null) {
            int b2 = b(eVar.d());
            if (b2 > -1) {
                this.f9a.set(b2, eVar);
            } else {
                this.f9a.add(0, eVar);
                this.b.add(0, Long.valueOf(eVar.d()));
            }
            notifyDataSetChanged();
            b();
        }
    }

    public long a(int i) {
        if (i < 0 || i > this.b.size()) {
            return -1;
        }
        long longValue = this.b.get(i).longValue();
        this.b.remove(i);
        this.f9a.remove(i);
        notifyDataSetChanged();
        b();
        return longValue;
    }

    public void a(a aVar) {
        this.e = aVar;
    }
}
