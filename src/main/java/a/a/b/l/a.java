package a.a.b.l;

import a.a.b.e;
import a.a.b.f;
import a.a.b.g;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FrogMenu */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f30a;
    private GridView b;
    private List<b> c = new ArrayList();
    private boolean d;
    /* access modifiers changed from: private */
    public c e;
    /* access modifiers changed from: private */
    public a.a.b.k.a f;

    /* renamed from: a.a.b.l.a$a  reason: collision with other inner class name */
    /* compiled from: FrogMenu */
    class C0004a extends a.a.b.k.a<b> {
        C0004a(Context context, int i, List list) {
            super(context, i, list);
        }

        /* access modifiers changed from: protected */
        public void a(a.a.b.k.c cVar, b bVar, int i) {
            a.this.a(cVar, bVar);
        }
    }

    /* compiled from: FrogMenu */
    class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar = (b) a.this.f.getItem(i);
            if (bVar.e() && a.this.e != null) {
                a.this.e.a(bVar, i);
            }
            a.this.a(i, bVar);
        }
    }

    /* compiled from: FrogMenu */
    class c implements AdapterView.OnItemLongClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            b bVar = (b) a.this.f.getItem(i);
            if (!bVar.e() || a.this.e == null) {
                return true;
            }
            a.this.e.b(bVar, i);
            return true;
        }
    }

    private a(Context context) {
        this.f30a = context;
    }

    private void b() {
        GridView gridView = new GridView(new ContextThemeWrapper(this.f30a, g.i));
        this.b = gridView;
        gridView.setId(79);
        this.b.setNumColumns(5);
        this.b.setSelector(17170445);
        this.b.setLayoutParams(new ViewGroup.LayoutParams(-1, this.d ? -1 : -2));
        C0004a aVar = new C0004a(this.f30a, f.m, this.c);
        this.f = aVar;
        this.b.setAdapter((ListAdapter) aVar);
        this.b.setOnItemClickListener(new b());
        this.b.setOnItemLongClickListener(new c());
    }

    public static a a(Context context) {
        return new a(context);
    }

    public a a(List<b> list) {
        if (this.c != list) {
            this.c = list;
            a.a.b.k.a aVar = this.f;
            if (aVar != null) {
                aVar.a(list);
            }
        }
        return this;
    }

    public a a(c cVar) {
        this.e = cVar;
        return this;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: a.a.b.p.b.a(android.content.Context, float):int
     arg types: [android.content.Context, int]
     candidates:
      a.a.b.p.b.a(android.content.Context, int):int
      a.a.b.p.b.a(android.view.View, int):int
      a.a.b.p.b.a(android.content.Context, float):int */
    /* access modifiers changed from: private */
    public void a(a.a.b.k.c cVar, b bVar) {
        int i;
        Drawable d2;
        int i2;
        if (cVar != null && bVar != null) {
            TextView textView = (TextView) cVar.a(e.bb);
            textView.setText(bVar.c());
            int a2 = bVar.a();
            if (!(a2 == -1 || (d2 = a.a.b.p.a.d(this.f30a, a2)) == null)) {
                int a3 = a.a.b.p.b.a(this.f30a, 20.0f);
                d2.setBounds(0, 0, a3, a3);
                if (bVar.d()) {
                    i2 = a.a.b.p.a.a(this.f30a, a.a.b.b.p);
                } else {
                    i2 = a.a.b.p.a.b(this.f30a, a.a.b.a.f);
                }
                d2.setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
                ((TextView) cVar.a(e.bb)).setCompoundDrawables(null, d2, null, null);
            }
            if (bVar.d()) {
                i = a.a.b.p.a.a(this.f30a, a.a.b.b.p);
            } else {
                i = a.a.b.p.a.b(this.f30a, a.a.b.a.h);
            }
            textView.setTextColor(i);
            textView.setEnabled(bVar.e());
            if (Build.VERSION.SDK_INT >= 11) {
                textView.setAlpha(bVar.e() ? 1.0f : 0.5f);
            }
            bVar.g();
        }
    }

    public void a(int i, b bVar) {
        if (bVar.f()) {
            a(a.a.b.k.f.a.a(this.b, i), bVar);
        }
    }

    public View a(int i) {
        a.a.b.k.c a2 = a.a.b.k.f.a.a(this.b, i);
        if (a2 == null) {
            return null;
        }
        return a2.a();
    }

    public View a() {
        if (this.b == null) {
            b();
        }
        return this.b;
    }
}
