package mark.lib.frogsupport.settings;

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
import mark.lib.frogsupport.C0364c;
import mark.lib.frogsupport.C0365d;
import mark.lib.frogsupport.C0366e;
import mark.lib.frogsupport.C0367f;
import mark.lib.frogsupport.C0368g;
import mark.lib.frogsupport.adapter.CommonAdapter;
import mark.lib.frogsupport.adapter.ViewHolder;
import mark.lib.frogsupport.adapter.util.ListUtils;
import mark.lib.frogsupport.util.CompatUtils;

/* renamed from: mark.lib.frogsupport.n.a */
/* compiled from: FrogSettings */
public class FrogSettings {

    /* renamed from: a */
    private Context f1159a;

    /* renamed from: b */
    private ListView f1160b;

    /* renamed from: c */
    private List<FrogSettingsBean> f1161c = new ArrayList();

    /* renamed from: d */
    private boolean f1162d;

    /* renamed from: e */
    private OnFrogSettingsClickListener f1163e;

    /* renamed from: f */
    private CommonAdapter f1164f;

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.n.a$a */
    /* compiled from: FrogSettings */
    public class C0399a extends CommonAdapter<FrogSettingsBean> {
        C0399a(Context context, int i, List list) {
            super(context, i, list);
        }

        /* access modifiers changed from: protected */
        /* renamed from: h */
        public void mo675b(ViewHolder cVar, FrogSettingsBean bVar, int i) {
            FrogSettings.this.m1280n(cVar, bVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.lib.frogsupport.n.a$b */
    /* compiled from: FrogSettings */
    public class C0400b implements AdapterView.OnItemClickListener {
        C0400b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            FrogSettingsBean bVar = (FrogSettingsBean) FrogSettings.this.f1164f.getItem(i);
            if (bVar.mo753a()) {
                bVar.mo759g(!bVar.mo757e());
            }
            if (FrogSettings.this.f1163e != null) {
                FrogSettings.this.f1163e.mo764a(bVar, i);
            }
            FrogSettings.this.mo749m(i, bVar);
        }
    }

    private FrogSettings(Context context) {
        this.f1159a = context;
    }

    /* renamed from: f */
    private void m1278f() {
        ListView listView = new ListView(new ContextThemeWrapper(this.f1159a, C0368g.d));
        this.f1160b = listView;
        listView.setDividerHeight(0);
        this.f1160b.setId(77);
        this.f1160b.setOverScrollMode(2);
        this.f1160b.setCacheColorHint(0);
        this.f1160b.setSelector(C0365d.b);
        if (Build.VERSION.SDK_INT >= 16) {
            this.f1160b.setScrollBarSize(CompatUtils.m1333c(this.f1159a, C0364c.g));
        }
        this.f1160b.setHorizontalScrollBarEnabled(true);
        this.f1160b.setVerticalScrollBarEnabled(false);
        this.f1160b.setLayoutParams(new ViewGroup.LayoutParams(-1, this.f1162d ? -1 : -2));
        C0399a aVar = new C0399a(this.f1159a, C0367f.g, this.f1161c);
        this.f1164f = aVar;
        this.f1160b.setAdapter((ListAdapter) aVar);
        this.f1160b.setOnItemClickListener(new C0400b());
    }

    /* renamed from: j */
    public static FrogSettings m1279j(Context context) {
        return new FrogSettings(context);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: n */
    private void m1280n(ViewHolder cVar, FrogSettingsBean bVar) {
        if (cVar != null && bVar != null) {
            cVar.mo689g(C0366e.o, bVar.mo756d());
            int i = C0366e.n;
            cVar.mo689g(i, bVar.mo755c());
            cVar.mo690h(i, !TextUtils.isEmpty(bVar.mo755c()));
            int i2 = C0366e.c;
            cVar.mo685c(i2, bVar.mo757e());
            cVar.mo690h(i2, bVar.mo753a());
            bVar.mo763q();
        }
    }

    /* renamed from: d */
    public FrogSettings mo742d(List<FrogSettingsBean> list) {
        this.f1161c.addAll(list);
        return this;
    }

    /* renamed from: e */
    public FrogSettings mo743e(FrogSettingsBean bVar) {
        if (bVar != null) {
            this.f1161c.add(bVar);
        }
        return this;
    }

    /* renamed from: g */
    public FrogSettings mo744g() {
        this.f1162d = true;
        return this;
    }

    /* renamed from: h */
    public FrogSettingsBean mo745h(int i) {
        if (i < 0 || i >= this.f1161c.size()) {
            return null;
        }
        return this.f1161c.get(i);
    }

    /* renamed from: i */
    public int mo746i(int i) {
        int size = this.f1161c.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f1161c.get(i2).mo754b() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: k */
    public FrogSettings mo747k(List<FrogSettingsBean> list) {
        CommonAdapter aVar = this.f1164f;
        this.f1161c = list;
        aVar.mo669f(list);
        return this;
    }

    /* renamed from: l */
    public FrogSettings mo748l(OnFrogSettingsClickListener cVar) {
        this.f1163e = cVar;
        return this;
    }

    /* renamed from: m */
    public void mo749m(int i, FrogSettingsBean bVar) {
        if (bVar.mo758f()) {
            m1280n(ListUtils.m1228a(this.f1160b, i), bVar);
        }
    }

    /* renamed from: o */
    public View mo750o() {
        if (this.f1160b == null) {
            m1278f();
        }
        return this.f1160b;
    }
}
