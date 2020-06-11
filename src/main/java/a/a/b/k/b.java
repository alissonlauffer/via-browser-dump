package a.a.b.k;

import a.a.b.k.d.a;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

/* compiled from: MultiItemTypeAdapter */
public class b<T> extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    protected Context f21a;
    protected List<T> b;
    private a.a.b.k.d.b c = new a.a.b.k.d.b();

    public b(Context context, List<T> list) {
        this.f21a = context;
        this.b = list;
    }

    public b a(a<T> aVar) {
        this.c.a(aVar);
        return this;
    }

    public void a(c cVar, View view) {
    }

    /* access modifiers changed from: protected */
    public void a(c cVar, T t, int i) {
        throw null;
    }

    public int getCount() {
        return this.b.size();
    }

    public T getItem(int i) {
        return this.b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        if (a()) {
            return this.c.b(this.b.get(i), i);
        }
        return super.getItemViewType(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        int a2 = this.c.a(this.b.get(i), i).a();
        if (view == null) {
            cVar = new c(this.f21a, LayoutInflater.from(this.f21a).inflate(a2, viewGroup, false), viewGroup, i);
            a(cVar, cVar.a());
        } else {
            cVar = (c) view.getTag();
            cVar.b = i;
        }
        a(cVar, getItem(i), i);
        return cVar.a();
    }

    public int getViewTypeCount() {
        if (a()) {
            return this.c.a();
        }
        return super.getViewTypeCount();
    }

    private boolean a() {
        return this.c.a() > 0;
    }
}
