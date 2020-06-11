package mark.via.ui.settings;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.lib.frogsupport.adapter.CommonAdapter;
import mark.lib.frogsupport.adapter.ViewHolder;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.navigator.FrogNavigator;
import mark.lib.frogsupport.util.CompatUtils;
import mark.lib.frogsupport.util.LayoutUtils;
import mark.lib.frogsupport.util.QuickUtils;
import mark.via.BrowserApp;
import mark.via.adapter.AddonItem;
import mark.via.flurry.FlurryHelper;
import mark.via.gp.R;
import mark.via.handler.DatabaseHandler;
import mark.via.preference.PreferenceManager;
import mark.via.ui.activity.BrowserActivity;
import mark.via.utils.BrowserUtils;
import mark.via.utils.InfoUtils;
import mark.via.utils.IntentUtils;
import mark.via.utils.ViewUtils;

public class ScriptSettings extends BaseSettings {

    /* renamed from: d */
    private DatabaseHandler f1824d;

    /* renamed from: e */
    private List<AddonItem> f1825e;

    /* renamed from: f */
    private String f1826f;

    /* renamed from: g */
    private CommonAdapter f1827g;

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.ScriptSettings$a */
    public class View$OnClickListenerC0591a implements View.OnClickListener {
        View$OnClickListenerC0591a() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void mo1511b(AdapterView adapterView, View view, int i, long j) {
            if (i == 0) {
                ScriptSettings.this.m2791x();
            } else if (i == 1) {
                FlurryHelper.m1681a().mo1042k("online");
                BrowserUtils.m2075F(((BaseActivity) ScriptSettings.this).f1039b, ScriptSettings.this.f1826f, BrowserActivity.class);
                ScriptSettings.this.finish();
            }
        }

        public void onClick(View view) {
            TaoDialog g = TaoDialog.m1134g(((BaseActivity) ScriptSettings.this).f1039b);
            g.mo643u(new String[]{((BaseActivity) ScriptSettings.this).f1039b.getString(R.string.a0), ((BaseActivity) ScriptSettings.this).f1039b.getString(R.string.dw)}, new C0676w0(this));
            g.mo624P(view);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.ScriptSettings$b */
    public class C0592b extends CommonAdapter<AddonItem> {
        C0592b(ScriptSettings scriptSettings, Context context, int i, List list) {
            super(context, i, list);
        }

        /* access modifiers changed from: protected */
        /* renamed from: h */
        public void mo675b(ViewHolder cVar, AddonItem aVar, int i) {
            cVar.mo689g(R.id.a1, aVar.mo923g());
            cVar.mo689g(R.id.y, InfoUtils.m2170i(aVar.mo918b()));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.ScriptSettings$c */
    public class C0593c implements CommonAdapter.AbstractC0386b {

        /* renamed from: a */
        final /* synthetic */ ListView f1829a;

        /* renamed from: b */
        final /* synthetic */ TextView f1830b;

        C0593c(ScriptSettings scriptSettings, ListView listView, TextView textView) {
            this.f1829a = listView;
            this.f1830b = textView;
        }

        @Override // mark.lib.frogsupport.adapter.CommonAdapter.AbstractC0386b
        /* renamed from: a */
        public void mo596a(boolean z) {
            int i = 8;
            this.f1829a.setVisibility(z ? 8 : 0);
            TextView textView = this.f1830b;
            if (z) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.ScriptSettings$d */
    public class C0594d implements AdapterView.OnItemClickListener {
        C0594d() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ScriptSettings.this.m2793z((AddonItem) ScriptSettings.this.f1825e.get(i));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.ScriptSettings$e */
    public class C0595e implements AdapterView.OnItemLongClickListener {
        C0595e() {
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void mo1515b(AddonItem aVar, View view) {
            QuickUtils.m1371c(((BaseActivity) ScriptSettings.this).f1039b, InfoUtils.m2170i(aVar.mo918b()), CompatUtils.m1336f(((BaseActivity) ScriptSettings.this).f1039b, R.string.iq));
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void mo1516d(AddonItem aVar, View view, TaoDialog.C0384l lVar) {
            ScriptSettings.this.m2767E(aVar, "", "");
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void mo1517f(int i, AdapterView adapterView, View view, int i2, long j) {
            String str;
            AddonItem aVar = (AddonItem) ScriptSettings.this.f1825e.get(i);
            if (i2 == 0) {
                ScriptSettings.this.m2793z(aVar);
            } else if (i2 == 1) {
                TaoDialog g = TaoDialog.m1134g(((BaseActivity) ScriptSettings.this).f1039b);
                g.mo621M(aVar.mo923g());
                g.mo645w(InfoUtils.m2170i(aVar.mo918b()));
                g.mo614F(17039370, null);
                g.mo610B(R.string.l, new View$OnClickListenerC0679x0(this, aVar));
                g.mo622N();
            } else if (i2 == 2) {
                TaoDialog g2 = TaoDialog.m1134g(((BaseActivity) ScriptSettings.this).f1039b);
                g2.mo620L(R.string.m);
                g2.mo645w(aVar.mo923g() + "\n\n" + InfoUtils.m2170i(aVar.mo918b()));
                g2.mo614F(17039370, new C0682y0(this, aVar));
                g2.mo648z(17039360, null);
                g2.mo622N();
            } else if (i2 == 3) {
                if (aVar.mo922f() == 0) {
                    str = InfoUtils.m2172k(((BaseActivity) ScriptSettings.this).f1039b, aVar.mo923g(), aVar.mo918b());
                } else {
                    String g3 = aVar.mo923g();
                    if ("*".equals(g3)) {
                        g3 = CompatUtils.m1336f(((BaseActivity) ScriptSettings.this).f1039b, R.string.az);
                    }
                    str = ((BaseActivity) ScriptSettings.this).f1039b.getResources().getString(R.string.hk, g3 + " (" + aVar.mo921e() + ") ", ScriptSettings.this.f1826f);
                }
                if (!TextUtils.isEmpty(str)) {
                    IntentUtils.m2179f(((BaseActivity) ScriptSettings.this).f1039b, str);
                }
            }
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            TaoDialog g = TaoDialog.m1134g(((BaseActivity) ScriptSettings.this).f1039b);
            g.mo643u(new String[]{((BaseActivity) ScriptSettings.this).f1039b.getString(R.string.r), ((BaseActivity) ScriptSettings.this).f1039b.getString(R.string.a9), ((BaseActivity) ScriptSettings.this).f1039b.getString(R.string.m), ((BaseActivity) ScriptSettings.this).f1039b.getString(R.string.ae)}, new C0685z0(this, i));
            g.mo624P(view);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.ScriptSettings$f */
    public class RunnableC0596f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ AddonItem f1833a;

        RunnableC0596f(AddonItem aVar) {
            this.f1833a = aVar;
        }

        public void run() {
            ScriptSettings.this.f1824d.mo970F(this.f1833a);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.ScriptSettings$g */
    public class RunnableC0597g implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f1835a;

        /* renamed from: b */
        final /* synthetic */ String f1836b;

        /* renamed from: c */
        final /* synthetic */ AddonItem f1837c;

        RunnableC0597g(String str, String str2, AddonItem aVar) {
            this.f1835a = str;
            this.f1836b = str2;
            this.f1837c = aVar;
        }

        public void run() {
            if (this.f1835a.equalsIgnoreCase("") || this.f1836b.equalsIgnoreCase("")) {
                ScriptSettings.this.f1824d.mo978e(this.f1837c.mo918b());
            } else {
                ScriptSettings.this.f1824d.mo970F(this.f1837c);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public /* synthetic */ void mo1509B(View view, TaoDialog.C0384l lVar) {
        String[] strArr = lVar.f1091c;
        String str = strArr[0];
        String str2 = strArr[1];
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            FlurryHelper.m1681a().mo1042k("add");
            AddonItem aVar = new AddonItem();
            aVar.mo931o(str);
            aVar.mo926j(InfoUtils.m2169h(str2));
            this.f1825e.add(0, aVar);
            BrowserApp.m1388b().execute(new RunnableC0596f(aVar));
            this.f1827g.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public /* synthetic */ void mo1510D(AddonItem aVar, View view, TaoDialog.C0384l lVar) {
        if (!TextUtils.isEmpty(lVar.f1091c[0]) && !TextUtils.isEmpty(lVar.f1091c[1])) {
            String[] strArr = lVar.f1091c;
            m2767E(aVar, strArr[0], strArr[1]);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: E */
    private void m2767E(AddonItem aVar, String str, String str2) {
        if (aVar != null) {
            if ("".equalsIgnoreCase(str) || "".equalsIgnoreCase(str2)) {
                this.f1825e.remove(aVar);
            } else {
                aVar.mo931o(str);
                aVar.mo926j(InfoUtils.m2169h(str2));
            }
            BrowserApp.m1388b().execute(new RunnableC0597g(str, str2, aVar));
            this.f1827g.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: x */
    private void m2791x() {
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.aq);
        g.mo630e("", R.string.h1, 1);
        g.mo630e("", R.string.h0, 8);
        g.mo614F(17039370, new C0610a1(this));
        g.mo622N();
    }

    /* renamed from: y */
    private View m2792y() {
        FrogNavigator g = FrogNavigator.m1261g(this.f1039b);
        g.mo736m(R.string.hi);
        g.mo734k(R.string.cg);
        g.mo729a(R.drawable.a4, new View$OnClickListenerC0591a());
        View p = g.mo738p();
        TextView a = LayoutUtils.m1363a(this.f1039b, R.string.d_);
        ListView listView = new ListView(new ContextThemeWrapper(this.f1039b, (int) R.style.j));
        listView.setDividerHeight(0);
        listView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        C0592b bVar = new C0592b(this, this.f1039b, R.layout.t, this.f1825e);
        this.f1827g = bVar;
        bVar.mo670g(new C0593c(this, listView, a));
        listView.setAdapter((ListAdapter) this.f1827g);
        listView.setOnItemClickListener(new C0594d());
        listView.setOnItemLongClickListener(new C0595e());
        return LayoutUtils.m1365c(p, a, listView);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: z */
    private void m2793z(AddonItem aVar) {
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.r);
        g.mo636n(false);
        g.mo630e(aVar.mo923g(), R.string.h1, 1);
        g.mo630e(InfoUtils.m2170i(aVar.mo918b()), R.string.h0, 8);
        g.mo614F(17039370, new C0614b1(this, aVar));
        g.mo648z(17039360, null);
        g.mo622N();
    }

    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DatabaseHandler v = DatabaseHandler.m1595v(this.f1039b);
        this.f1824d = v;
        this.f1825e = v.mo986m();
        setContentView(m2792y());
        ViewUtils.m2237o(findViewById(FrogNavigator.f1148f));
        this.f1826f = PreferenceManager.m1743M(this.f1039b).mo1178q() == 1 ? "https://app.viayoo.com/addons/" : "http://via.oktutu.com/addons/";
    }
}
