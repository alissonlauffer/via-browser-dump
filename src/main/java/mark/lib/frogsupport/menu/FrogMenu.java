package mark.lib.frogsupport.menu;

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
import mark.lib.frogsupport.C0361a;
import mark.lib.frogsupport.C0363b;
import mark.lib.frogsupport.C0366e;
import mark.lib.frogsupport.C0367f;
import mark.lib.frogsupport.C0368g;
import mark.lib.frogsupport.adapter.CommonAdapter;
import mark.lib.frogsupport.adapter.ViewHolder;
import mark.lib.frogsupport.adapter.util.ListUtils;
import mark.lib.frogsupport.util.CompatUtils;
import mark.lib.frogsupport.util.FrogUtils;

/* renamed from: mark.lib.frogsupport.l.a */
/* compiled from: FrogMenu */
public class FrogMenu {

    /* renamed from: a */
    private Context f1133a;

    /* renamed from: b */
    private GridView f1134b;

    /* renamed from: c */
    private List<FrogMenuBean> f1135c = new ArrayList();

    /* renamed from: d */
    private boolean f1136d;

    /* renamed from: e */
    private OnFrogMenusClickListener f1137e;

    /* renamed from: f */
    private CommonAdapter f1138f;

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.l.a$a */
    /* compiled from: FrogMenu */
    public class C0393a extends CommonAdapter<FrogMenuBean> {
        C0393a(Context context, int i, List list) {
            super(context, i, list);
        }

        /* access modifiers changed from: protected */
        /* renamed from: h */
        public void mo675b(ViewHolder cVar, FrogMenuBean bVar, int i) {
            FrogMenu.this.m1235j(cVar, bVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.l.a$b */
    /* compiled from: FrogMenu */
    public class C0394b implements AdapterView.OnItemClickListener {
        C0394b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            FrogMenuBean bVar = (FrogMenuBean) FrogMenu.this.f1138f.getItem(i);
            if (bVar.mo719e() && FrogMenu.this.f1137e != null) {
                FrogMenu.this.f1137e.mo727a(bVar, i);
            }
            FrogMenu.this.mo710i(i, bVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.l.a$c */
    /* compiled from: FrogMenu */
    public class C0395c implements AdapterView.OnItemLongClickListener {
        C0395c() {
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            FrogMenuBean bVar = (FrogMenuBean) FrogMenu.this.f1138f.getItem(i);
            if (!bVar.mo719e() || FrogMenu.this.f1137e == null) {
                return true;
            }
            FrogMenu.this.f1137e.mo728b(bVar, i);
            return true;
        }
    }

    private FrogMenu(Context context) {
        this.f1133a = context;
    }

    /* renamed from: d */
    private void m1233d() {
        GridView gridView = new GridView(new ContextThemeWrapper(this.f1133a, C0368g.d));
        this.f1134b = gridView;
        gridView.setId(79);
        this.f1134b.setNumColumns(5);
        this.f1134b.setSelector(17170445);
        this.f1134b.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f1136d ? -1 : -2));
        C0393a aVar = new C0393a(this.f1133a, C0367f.f, this.f1135c);
        this.f1138f = aVar;
        this.f1134b.setAdapter((ListAdapter) aVar);
        this.f1134b.setOnItemClickListener(new C0394b());
        this.f1134b.setOnItemLongClickListener(new C0395c());
    }

    /* renamed from: f */
    public static FrogMenu m1234f(Context context) {
        return new FrogMenu(context);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: j */
    private void m1235j(ViewHolder cVar, FrogMenuBean bVar) {
        int i;
        Drawable d;
        int i2;
        if (cVar != null && bVar != null) {
            int i3 = C0366e.m;
            TextView textView = (TextView) cVar.mo684b(i3);
            textView.setText(bVar.mo717c());
            int a = bVar.mo715a();
            if (!(a == -1 || (d = CompatUtils.m1334d(this.f1133a, a)) == null)) {
                int a2 = FrogUtils.m1354a(this.f1133a, 20.0f);
                d.setBounds(0, 0, a2, a2);
                if (bVar.mo718d()) {
                    i2 = CompatUtils.m1331a(this.f1133a, C0363b.a);
                } else {
                    i2 = CompatUtils.m1332b(this.f1133a, C0361a.a);
                }
                d.setColorFilter(i2, PorterDuff.Mode.SRC_ATOP);
                ((TextView) cVar.mo684b(i3)).setCompoundDrawables(null, d, null, null);
            }
            if (bVar.mo718d()) {
                i = CompatUtils.m1331a(this.f1133a, C0363b.a);
            } else {
                i = CompatUtils.m1332b(this.f1133a, C0361a.b);
            }
            textView.setTextColor(i);
            textView.setEnabled(bVar.mo719e());
            if (Build.VERSION.SDK_INT >= 11) {
                textView.setAlpha(bVar.mo719e() ? 1.0f : 0.5f);
            }
            bVar.mo726n();
        }
    }

    /* renamed from: e */
    public View mo707e(int i) {
        ViewHolder a = ListUtils.m1228a(this.f1134b, i);
        if (a == null) {
            return null;
        }
        return a.mo683a();
    }

    /* renamed from: g */
    public FrogMenu mo708g(List<FrogMenuBean> list) {
        if (this.f1135c != list) {
            this.f1135c = list;
            CommonAdapter aVar = this.f1138f;
            if (aVar != null) {
                aVar.mo669f(list);
            }
        }
        return this;
    }

    /* renamed from: h */
    public FrogMenu mo709h(OnFrogMenusClickListener cVar) {
        this.f1137e = cVar;
        return this;
    }

    /* renamed from: i */
    public void mo710i(int i, FrogMenuBean bVar) {
        if (bVar.mo720f()) {
            m1235j(ListUtils.m1228a(this.f1134b, i), bVar);
        }
    }

    /* renamed from: k */
    public View mo711k() {
        if (this.f1134b == null) {
            m1233d();
        }
        return this.f1134b;
    }
}
