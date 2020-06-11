package a.a.b.n;

import a.a.b.d;
import a.a.b.e;
import a.a.b.f;
import a.a.b.g;
import a.a.b.k.c;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FrogSettings */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f37a;
    private ListView b;
    private List<b> c = new ArrayList();
    private boolean d;
    /* access modifiers changed from: private */
    public c e;
    /* access modifiers changed from: private */
    public a.a.b.k.a f;

    /* renamed from: a.a.b.n.a$a  reason: collision with other inner class name */
    /* compiled from: FrogSettings */
    class C0006a extends a.a.b.k.a<b> {
        C0006a(Context context, int i, List list) {
            super(context, i, list);
        }

        /* access modifiers changed from: protected */
        public void a(c cVar, b bVar, int i) {
            a.this.a(cVar, bVar);
        }
    }

    /* compiled from: FrogSettings */
    class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar = (b) a.this.f.getItem(i);
            if (bVar.a()) {
                bVar.a(!bVar.e());
            }
            if (a.this.e != null) {
                a.this.e.a(bVar, i);
            }
            a.this.a(i, bVar);
        }
    }

    private a(Context context) {
        this.f37a = context;
    }

    private void c() {
        ListView listView = new ListView(new ContextThemeWrapper(this.f37a, g.i));
        this.b = listView;
        listView.setDividerHeight(0);
        this.b.setId(77);
        this.b.setOverScrollMode(2);
        this.b.setCacheColorHint(0);
        this.b.setSelector(d.f);
        if (Build.VERSION.SDK_INT >= 16) {
            this.b.setScrollBarSize(a.a.b.p.a.c(this.f37a, a.a.b.c.h));
        }
        this.b.setHorizontalScrollBarEnabled(true);
        this.b.setVerticalScrollBarEnabled(false);
        this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, this.d ? -1 : -2));
        C0006a aVar = new C0006a(this.f37a, f.n, this.c);
        this.f = aVar;
        this.b.setAdapter((ListAdapter) aVar);
        this.b.setOnItemClickListener(new b());
    }

    public a b(List<b> list) {
        a.a.b.k.a aVar = this.f;
        this.c = list;
        aVar.a(list);
        return this;
    }

    public static a a(Context context) {
        return new a(context);
    }

    public View b() {
        if (this.b == null) {
            c();
        }
        return this.b;
    }

    public a a(b bVar) {
        if (bVar != null) {
            this.c.add(bVar);
        }
        return this;
    }

    public a a(List<b> list) {
        this.c.addAll(list);
        return this;
    }

    public a a(c cVar) {
        this.e = cVar;
        return this;
    }

    public a a() {
        this.d = true;
        return this;
    }

    /* access modifiers changed from: private */
    public void a(c cVar, b bVar) {
        if (cVar != null && bVar != null) {
            cVar.a(e.be, bVar.d());
            cVar.a(e.bc, bVar.c());
            cVar.b(e.bc, !TextUtils.isEmpty(bVar.c()));
            cVar.a(e.j, bVar.e());
            cVar.b(e.j, bVar.a());
            bVar.g();
        }
    }

    public void a(int i, b bVar) {
        if (bVar.f()) {
            a(a.a.b.k.f.a.a(this.b, i), bVar);
        }
    }
}
