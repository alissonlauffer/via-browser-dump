package mark.via.ui.settings;

import android.content.Context;
import android.content.Intent;
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
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.navigator.FrogNavigator;
import mark.lib.frogsupport.util.LayoutUtils;
import mark.lib.frogsupport.util.QuickUtils;
import mark.via.gp.R;
import mark.via.utils.FileUtils;
import mark.via.utils.ViewUtils;
import timber.log.Timber;

public class ViewFiltersUI extends BaseSettings {

    /* renamed from: i */
    private static String f1861i = "path";

    /* renamed from: j */
    private static String f1862j = "title";

    /* renamed from: d */
    private ListView f1863d;

    /* renamed from: e */
    private List<String> f1864e;

    /* renamed from: f */
    private CommonAdapter<String> f1865f;

    /* renamed from: g */
    private String f1866g;

    /* renamed from: h */
    private String f1867h;

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.ViewFiltersUI$a */
    public class C0607a extends CommonAdapter<String> {
        C0607a(Context context, int i, List list) {
            super(context, i, list);
        }

        /* access modifiers changed from: protected */
        /* renamed from: h */
        public void mo675b(ViewHolder cVar, String str, int i) {
            ViewFiltersUI.this.m2886b(cVar, str, i);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: b */
    private void m2886b(ViewHolder cVar, String str, int i) {
        if (cVar != null) {
            cVar.mo689g(R.id.o, str);
        }
    }

    /* renamed from: c */
    private View m2887c() {
        FrogNavigator g = FrogNavigator.m1261g(this.f1039b);
        g.mo737n(this.f1867h);
        g.mo734k(R.string.RES_2131558517);
        View p = g.mo738p();
        TextView a = LayoutUtils.m1363a(this.f1039b, R.string.RES_2131558547);
        ListView listView = new ListView(new ContextThemeWrapper(this.f1039b, (int) R.style.d));
        this.f1863d = listView;
        listView.setDividerHeight(0);
        this.f1863d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f1864e = new ArrayList();
        C0607a aVar = new C0607a(this.f1039b, R.layout.RES_2131361806, this.f1864e);
        this.f1865f = aVar;
        aVar.mo670g(new C0686z1(this, a));
        this.f1863d.setOnItemClickListener(new C0680x1(this));
        this.f1863d.setOnItemLongClickListener(new C0677w1(this));
        this.f1863d.setAdapter((ListAdapter) this.f1865f);
        m2894p();
        return LayoutUtils.m1365c(p, a, this.f1863d);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void mo1555e(TextView textView, boolean z) {
        int i = 8;
        this.f1863d.setVisibility(z ? 8 : 0);
        if (z) {
            i = 0;
        }
        textView.setVisibility(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void mo1556g(AdapterView adapterView, View view, int i, long j) {
        m2896r(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void mo1557i(int i, AdapterView adapterView, View view, int i2, long j) {
        String str = this.f1864e.get(i);
        if (i2 == 0) {
            QuickUtils.m1370b(this.f1039b, str, R.string.RES_2131558749);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ boolean mo1558k(AdapterView adapterView, View view, int i, long j) {
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo643u(new String[]{this.f1039b.getString(R.string.RES_2131558411)}, new C0683y1(this, i));
        g.mo624P(view);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void mo1559m() {
        this.f1865f.mo669f(this.f1864e);
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void mo1560o() {
        List<String> f = FileUtils.m2150f(this.f1866g);
        this.f1864e = f;
        Timber.m971a("string data size: %d", Integer.valueOf(f.size()));
        runOnUiThread(new RunnableC0674v1(this));
    }

    /* renamed from: p */
    private void m2894p() {
        CompletableFuture.m995n(new RunnableC0611a2(this));
    }

    /* renamed from: q */
    public static void m2895q(Context context, String str, String str2) {
        Intent intent = new Intent(context, ViewFiltersUI.class);
        intent.putExtra(f1861i, str);
        if (str2 != null && !str2.isEmpty()) {
            intent.putExtra(f1862j, str2);
        }
        context.startActivity(intent);
    }

    /* renamed from: r */
    private void m2896r(int i) {
        QuickUtils.m1379k(this.f1039b, R.string.RES_2131558435, this.f1864e.get(i));
    }

    /* access modifiers changed from: protected */
    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1867h = getString(R.string.RES_2131558435);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra(f1861i)) {
                this.f1866g = intent.getStringExtra(f1861i);
            }
            if (intent.hasExtra(f1862j)) {
                this.f1867h = intent.getStringExtra(f1862j);
            }
        }
        setContentView(m2887c());
        ViewUtils.m2237o(findViewById(FrogNavigator.f1148f));
    }
}
