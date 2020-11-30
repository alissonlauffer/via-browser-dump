package mark.via.ui.settings;

import android.content.Context;
import android.content.IntentFilter;
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
import java9.util.concurrent.CompletableFuture;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.lib.frogsupport.adapter.CommonAdapter;
import mark.lib.frogsupport.adapter.ViewHolder;
import mark.lib.frogsupport.adapter.util.ListUtils;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.navigator.FrogNavigator;
import mark.lib.frogsupport.util.LayoutUtils;
import mark.lib.frogsupport.util.QuickUtils;
import mark.via.BrowserApp;
import mark.via.component.DaggerBlockerComponent;
import mark.via.gp.R;
import mark.via.receivers.BlockerReceiver;
import mark.via.services.BlockerService;
import mark.via.utils.FileUtil;
import mark.via.utils.FileUtils;
import mark.via.utils.ViewUtils;
import mark.via.utils.WebAdressUtils;
import p000a.p001a.p002a.Blocker;
import p000a.p001a.p002a.filter.FilterSubscription;
import p000a.p001a.p002a.util.FilterUtils;
import timber.log.Timber;

public class SubscribedFiltersUI extends BaseSettings {

    /* renamed from: d */
    private List<FilterSubscription> f1853d;

    /* renamed from: e */
    private CommonAdapter<FilterSubscription> f1854e;

    /* renamed from: f */
    private BlockerReceiver f1855f;

    /* renamed from: g */
    private ListView f1856g;

    /* renamed from: h */
    private boolean f1857h = false;

    /* renamed from: i */
    Blocker f1858i;

    /* renamed from: mark.via.ui.settings.SubscribedFiltersUI$a */
    class C0605a implements BlockerReceiver.AbstractC0466a {
        C0605a() {
        }

        @Override // mark.via.receivers.BlockerReceiver.AbstractC0466a
        /* renamed from: a */
        public void mo1209a(String str) {
        }

        @Override // mark.via.receivers.BlockerReceiver.AbstractC0466a
        /* renamed from: b */
        public void mo1210b(String str, boolean z) {
            if (z) {
                SubscribedFiltersUI.this.f1857h = true;
                SubscribedFiltersUI.this.m2850H(str, 100);
                return;
            }
            QuickUtils.m1384p(((BaseActivity) SubscribedFiltersUI.this).f1039b, SubscribedFiltersUI.this.getString(R.string.RES_2131558766, new Object[]{str}));
        }

        @Override // mark.via.receivers.BlockerReceiver.AbstractC0466a
        /* renamed from: c */
        public void mo1211c() {
            SubscribedFiltersUI.this.f1857h = true;
            Timber.m971a("Update filters finished", new Object[0]);
            QuickUtils.m1382n(((BaseActivity) SubscribedFiltersUI.this).f1039b, R.string.RES_2131558767);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.SubscribedFiltersUI$b */
    public class C0606b extends CommonAdapter<FilterSubscription> {
        C0606b(Context context, int i, List list) {
            super(context, i, list);
        }

        /* access modifiers changed from: protected */
        /* renamed from: h */
        public void mo675b(ViewHolder cVar, FilterSubscription cVar2, int i) {
            SubscribedFiltersUI.this.m2857g(cVar, cVar2, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ void mo1543C(FilterSubscription cVar, int i) {
        FilterUtils.m97b(cVar);
        this.f1853d.set(i, cVar);
        runOnUiThread(new RunnableC0665s1(this, cVar, i));
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public /* synthetic */ void mo1544E(FilterSubscription cVar, boolean z, int i, View view, TaoDialog.C0384l lVar) {
        FilterSubscription cVar2;
        String str = lVar.f1091c[0];
        if (!WebAdressUtils.m2253e(str)) {
            QuickUtils.m1382n(this.f1039b, R.string.RES_2131558778);
            return;
        }
        if (z) {
            cVar2 = new FilterSubscription();
            Context context = this.f1039b;
            cVar2.mo31h(FileUtils.m2155k(context, System.currentTimeMillis() + ".txt"));
        } else {
            cVar2 = cVar;
        }
        cVar2.mo37m(WebAdressUtils.m2254f(str));
        if (this.f1853d.contains(cVar2)) {
            QuickUtils.m1382n(this.f1039b, R.string.RES_2131558558);
            return;
        }
        if (z) {
            this.f1853d.add(cVar2);
            Timber.m971a("add: %s", cVar2.mo38n());
            this.f1854e.notifyDataSetChanged();
        } else {
            this.f1853d.set(i, cVar);
            m2869z(cVar, i);
        }
        this.f1857h = true;
    }

    /* renamed from: F */
    private void m2848F() {
        if (this.f1857h) {
            this.f1858i.mo13m(this.f1853d);
            Timber.m971a("Save filtes", new Object[0]);
            this.f1857h = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: G */
    public void m2869z(FilterSubscription cVar, int i) {
        m2857g(ListUtils.m1228a(this.f1856g, i), cVar, i);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: H */
    private void m2850H(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            int size = this.f1853d.size();
            for (int i2 = 0; i2 < size; i2++) {
                FilterSubscription cVar = this.f1853d.get(i2);
                if (str.equals(cVar.mo27d())) {
                    if (i == 100) {
                        m2869z(cVar, i2);
                        m2859i(cVar, i2);
                        return;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: f */
    private void m2856f() {
        m2860j(-1, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: g */
    private void m2857g(ViewHolder cVar, FilterSubscription cVar2, int i) {
        String str;
        int indexOf;
        if (cVar != null) {
            cVar.mo690h(R.id.n, true);
            cVar.mo690h(R.id.c, true);
            String c = cVar2.mo26c();
            if ((c == null || c.isEmpty()) && (indexOf = (c = cVar2.mo27d()).indexOf("://")) >= 0) {
                c = c.substring(indexOf + 3);
            }
            cVar.mo689g(R.id.o, c);
            long g = FileUtils.m2151g(cVar2.mo24a());
            String quantityString = getResources().getQuantityString(R.plurals.RES_2131492865, cVar2.mo25b(), Integer.valueOf(cVar2.mo25b()));
            if (g == 0) {
                str = getString(R.string.RES_2131558575);
            } else {
                int currentTimeMillis = (int) (((System.currentTimeMillis() - g) / 1000) / 60);
                if (currentTimeMillis < 1) {
                    str = getString(R.string.RES_2131558768, new Object[]{getString(R.string.RES_2131558608)});
                } else if (currentTimeMillis < 60) {
                    str = getString(R.string.RES_2131558768, new Object[]{getResources().getQuantityString(R.plurals.RES_2131492867, currentTimeMillis, Integer.valueOf(currentTimeMillis))});
                } else {
                    int i2 = currentTimeMillis / 60;
                    if (i2 < 24) {
                        str = getString(R.string.RES_2131558768, new Object[]{getResources().getQuantityString(R.plurals.RES_2131492866, i2, Integer.valueOf(i2))});
                    } else {
                        int i3 = i2 / 24;
                        if (i3 < 8) {
                            str = getString(R.string.RES_2131558768, new Object[]{getResources().getQuantityString(R.plurals.RES_2131492864, i3, Integer.valueOf(i3))});
                        } else {
                            str = getString(R.string.RES_2131558768, new Object[]{getString(R.string.RES_2131558615)});
                        }
                    }
                }
            }
            cVar.mo689g(R.id.n, getString(R.string.RES_2131558559, new Object[]{quantityString, str}));
            cVar.mo685c(R.id.c, cVar2.mo28e());
        }
    }

    /* renamed from: h */
    private View m2858h() {
        FrogNavigator g = FrogNavigator.m1261g(this.f1039b);
        g.mo736m(R.string.RES_2131558560);
        g.mo734k(R.string.RES_2131558517);
        g.mo729a(R.drawable.RES_2131165200, new View$OnClickListenerC0659q1(this));
        g.mo732d(getString(R.string.RES_2131558765), new View$OnClickListenerC0668t1(this));
        View p = g.mo738p();
        TextView a = LayoutUtils.m1363a(this.f1039b, R.string.RES_2131558547);
        ListView listView = new ListView(new ContextThemeWrapper(this.f1039b, (int) R.style.d));
        this.f1856g = listView;
        listView.setDividerHeight(0);
        this.f1856g.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f1853d = this.f1858i.mo8d();
        C0606b bVar = new C0606b(this.f1039b, R.layout.g, this.f1853d);
        this.f1854e = bVar;
        bVar.mo670g(new C0662r1(this, a));
        this.f1856g.setOnItemClickListener(new C0650n1(this));
        this.f1856g.setOnItemLongClickListener(new C0653o1(this));
        this.f1856g.setAdapter((ListAdapter) this.f1854e);
        return LayoutUtils.m1365c(p, a, this.f1856g);
    }

    /* renamed from: i */
    private void m2859i(FilterSubscription cVar, int i) {
        CompletableFuture.m995n(new RunnableC0656p1(this, cVar, i));
    }

    /* renamed from: j */
    private void m2860j(int i, FilterSubscription cVar) {
        String str;
        boolean z = i < 0 || cVar == null;
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(z ? R.string.RES_2131558451 : R.string.RES_2131558546);
        if (z) {
            str = "https://";
        } else {
            str = cVar.mo27d();
        }
        g.mo628c(1, str, R.string.RES_2131558582, 3);
        g.mo636n(false);
        g.mo614F(17039370, new C0644l1(this, cVar, z, i));
        g.mo648z(17039360, null);
        g.mo622N();
    }

    /* renamed from: k */
    private void m2861k() {
        int i = 0;
        for (FilterSubscription cVar : this.f1853d) {
            if (cVar.mo28e()) {
                i++;
                BlockerService.m2271d(this.f1039b, cVar.mo27d(), cVar.mo24a());
            }
        }
        if (i > 0) {
            QuickUtils.m1382n(this.f1039b, R.string.RES_2131558769);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void mo1545m(View view) {
        m2856f();
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void mo1546o(View view) {
        m2861k();
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void mo1549q(TextView textView, boolean z) {
        int i = 8;
        this.f1856g.setVisibility(z ? 8 : 0);
        if (z) {
            i = 0;
        }
        textView.setVisibility(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void mo1550s(AdapterView adapterView, View view, int i, long j) {
        this.f1857h = true;
        FilterSubscription cVar = this.f1853d.get(i);
        cVar.mo30g(true ^ cVar.mo28e());
        m2869z(cVar, i);
    }

    /* access modifiers changed from: private */
    /* renamed from: t */
    public /* synthetic */ void mo1551u(int i, View view, TaoDialog.C0384l lVar) {
        FileUtil.m2142a(this.f1853d.get(i).mo24a());
        this.f1857h = true;
        this.f1853d.remove(i);
        this.f1854e.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public /* synthetic */ void mo1552w(int i, AdapterView adapterView, View view, int i2, long j) {
        FilterSubscription cVar = this.f1853d.get(i);
        if (i2 == 0) {
            ViewFiltersUI.m2895q(this.f1039b, cVar.mo24a(), cVar.mo26c());
        } else if (i2 == 1) {
            m2860j(i, cVar);
        } else if (i2 == 2) {
            QuickUtils.m1370b(this.f1039b, cVar.mo27d(), R.string.RES_2131558750);
        } else if (i2 == 3) {
            QuickUtils.m1375g(this.f1039b, R.string.RES_2131558412, cVar.mo27d(), new C0647m1(this, i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: x */
    public /* synthetic */ boolean mo1553y(AdapterView adapterView, View view, int i, long j) {
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo643u(new String[]{this.f1039b.getString(R.string.RES_2131558435), this.f1039b.getString(R.string.RES_2131558417), this.f1039b.getString(R.string.RES_2131558408), this.f1039b.getString(R.string.RES_2131558412)}, new C0671u1(this, i));
        g.mo624P(view);
        return true;
    }

    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        DaggerBlockerComponent.C0447b d = DaggerBlockerComponent.m1665d();
        d.mo1029a(BrowserApp.m1387a(this).f1192a);
        d.mo1030b().mo1021b(this);
        super.onCreate(bundle);
        setContentView(m2858h());
        ViewUtils.m2237o(findViewById(FrogNavigator.f1148f));
        this.f1855f = new BlockerReceiver(new C0605a());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("mark.via.fetching");
        intentFilter.addAction("mark.via.fetching");
        registerReceiver(this.f1855f, intentFilter, "mark.via.permission.BROADCAST", null);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        unregisterReceiver(this.f1855f);
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        m2848F();
        super.onPause();
    }
}
