package mark.via.ui.settings;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java9.util.concurrent.CompletableFuture;
import mark.lib.frogsupport.adapter.CommonAdapter;
import mark.lib.frogsupport.adapter.ViewHolder;
import mark.lib.frogsupport.adapter.listener.SwipeDismissListViewTouchListener;
import mark.lib.frogsupport.adapter.util.ListUtils;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.navigator.FrogNavigator;
import mark.lib.frogsupport.util.LayoutUtils;
import mark.lib.frogsupport.util.QuickUtils;
import mark.via.BrowserApp;
import mark.via.component.DaggerBlockerComponent;
import mark.via.gp.R;
import mark.via.ui.activity.BrowserActivity;
import mark.via.utils.BrowserUtils;
import mark.via.utils.FileUtils;
import mark.via.utils.ViewUtils;
import p000a.p001a.p002a.Blocker;
import timber.log.Timber;

public class CustomFiltersUI extends BaseSettings {

    /* renamed from: d */
    private ListView f1804d;

    /* renamed from: e */
    private List<String> f1805e;

    /* renamed from: f */
    private CommonAdapter<String> f1806f;

    /* renamed from: g */
    private String f1807g;

    /* renamed from: h */
    Blocker f1808h;

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.CustomFiltersUI$a */
    public class C0584a extends CommonAdapter<String> {
        C0584a(Context context, int i, List list) {
            super(context, i, list);
        }

        /* access modifiers changed from: protected */
        /* renamed from: h */
        public void mo675b(ViewHolder cVar, String str, int i) {
            CustomFiltersUI.this.m2617e(cVar, str, i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.CustomFiltersUI$b */
    public class C0585b implements SwipeDismissListViewTouchListener.AbstractC0391e {
        C0585b() {
        }

        @Override // mark.lib.frogsupport.adapter.listener.SwipeDismissListViewTouchListener.AbstractC0391e
        /* renamed from: a */
        public boolean mo703a(int i) {
            return true;
        }

        @Override // mark.lib.frogsupport.adapter.listener.SwipeDismissListViewTouchListener.AbstractC0391e
        /* renamed from: b */
        public void mo704b(ListView listView, int[] iArr) {
            for (int i : iArr) {
                CustomFiltersUI.this.f1808h.mo12l((String) CustomFiltersUI.this.f1806f.getItem(i));
                CustomFiltersUI.this.f1805e.remove(i);
            }
            CustomFiltersUI.this.f1806f.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public /* synthetic */ void mo1464B() {
        this.f1806f.mo669f(this.f1805e);
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public /* synthetic */ void mo1465D() {
        List<String> f = FileUtils.m2150f(this.f1807g);
        this.f1805e = f;
        Timber.m971a("string data size: %d", Integer.valueOf(f.size()));
        runOnUiThread(new RunnableC0654p(this));
    }

    /* renamed from: E */
    private void m2611E() {
        CompletableFuture.m995n(new RunnableC0642l(this));
    }

    /* renamed from: F */
    private void m2612F(String str, int i) {
        m2617e(ListUtils.m1228a(this.f1804d, i), str, i);
    }

    /* renamed from: d */
    private void m2616d() {
        m2619g(-1);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: e */
    private void m2617e(ViewHolder cVar, String str, int i) {
        if (cVar != null) {
            cVar.mo689g(R.id.o, str);
        }
    }

    /* renamed from: f */
    private View m2618f() {
        FrogNavigator g = FrogNavigator.m1261g(this.f1039b);
        g.mo736m(R.string.RES_2131558503);
        g.mo734k(R.string.RES_2131558517);
        g.mo729a(R.drawable.RES_2131165200, new View$OnClickListenerC0666t(this));
        g.mo732d(getString(R.string.RES_2131558576), new View$OnClickListenerC0651o(this));
        View p = g.mo738p();
        TextView a = LayoutUtils.m1363a(this.f1039b, R.string.RES_2131558547);
        ListView listView = new ListView(new ContextThemeWrapper(this.f1039b, (int) R.style.d));
        this.f1804d = listView;
        listView.setDividerHeight(0);
        this.f1804d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f1805e = new ArrayList();
        C0584a aVar = new C0584a(this.f1039b, R.layout.RES_2131361806, this.f1805e);
        this.f1806f = aVar;
        aVar.mo670g(new C0660r(this, a));
        this.f1804d.setOnItemClickListener(new C0657q(this));
        this.f1804d.setOnItemLongClickListener(new C0645m(this));
        if (Build.VERSION.SDK_INT >= 12) {
            SwipeDismissListViewTouchListener aVar2 = new SwipeDismissListViewTouchListener(this.f1804d, new C0585b());
            this.f1804d.setOnTouchListener(aVar2);
            this.f1804d.setOnScrollListener(aVar2.mo695i());
        }
        this.f1804d.setAdapter((ListAdapter) this.f1806f);
        m2611E();
        return LayoutUtils.m1365c(p, a, this.f1804d);
    }

    /* renamed from: g */
    private void m2619g(int i) {
        boolean z = i < 0;
        String str = z ? "" : this.f1805e.get(i);
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.RES_2131558502);
        g.mo628c(1, str, R.string.RES_2131558502, 3);
        g.mo614F(17039370, new C0648n(this, z, str, i));
        g.mo648z(17039360, null);
        g.mo622N();
    }

    /* renamed from: h */
    private void m2620h() {
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.RES_2131558576);
        g.mo644v(R.string.RES_2131558713);
        g.mo614F(17039370, null);
        g.mo610B(R.string.RES_2131558609, new View$OnClickListenerC0669u(this));
        g.mo622N();
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void mo1466j(View view) {
        m2616d();
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void mo1467l(View view) {
        m2620h();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void mo1468n(TextView textView, boolean z) {
        int i = 8;
        this.f1804d.setVisibility(z ? 8 : 0);
        if (z) {
            i = 0;
        }
        textView.setVisibility(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void mo1469p(AdapterView adapterView, View view, int i, long j) {
        m2619g(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ void mo1470r(int i, View view, TaoDialog.C0384l lVar) {
        this.f1808h.mo12l(this.f1805e.get(i));
        this.f1805e.remove(i);
        this.f1806f.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void mo1471t(int i, AdapterView adapterView, View view, int i2, long j) {
        String str = this.f1805e.get(i);
        if (i2 == 0) {
            QuickUtils.m1370b(this.f1039b, str, R.string.RES_2131558749);
        } else if (i2 == 1) {
            QuickUtils.m1375g(this.f1039b, R.string.RES_2131558412, str, new C0663s(this, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ boolean mo1472v(AdapterView adapterView, View view, int i, long j) {
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo643u(new String[]{this.f1039b.getString(R.string.RES_2131558411), this.f1039b.getString(R.string.RES_2131558412)}, new C0639k(this, i));
        g.mo624P(view);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: w */
    public /* synthetic */ void mo1473x(boolean z, String str, int i, View view, TaoDialog.C0384l lVar) {
        String str2;
        String[] strArr = lVar.f1091c;
        if (strArr.length == 1 && (str2 = strArr[0]) != null && !str2.isEmpty()) {
            if (z) {
                this.f1805e.add(str2);
                this.f1806f.notifyDataSetChanged();
                this.f1808h.mo5a(str2);
            } else if (!str.equals(str2)) {
                this.f1808h.mo12l(str);
                this.f1808h.mo5a(str2);
                this.f1805e.set(i, str2);
                m2612F(str2, i);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: y */
    public /* synthetic */ void mo1474z(View view) {
        BrowserUtils.m2075F(this.f1039b, "https://help.eyeo.com/en/adblockplus/how-to-write-filters", BrowserActivity.class);
        onBackPressed();
    }

    /* access modifiers changed from: protected */
    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        DaggerBlockerComponent.C0447b d = DaggerBlockerComponent.m1665d();
        d.mo1029a(BrowserApp.m1387a(this).f1192a);
        d.mo1030b().mo1022c(this);
        super.onCreate(bundle);
        this.f1807g = FileUtils.m2155k(this.f1039b, "custom.txt");
        setContentView(m2618f());
        ViewUtils.m2237o(findViewById(FrogNavigator.f1148f));
    }
}
