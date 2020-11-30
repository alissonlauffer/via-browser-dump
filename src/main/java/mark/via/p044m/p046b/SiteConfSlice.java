package mark.via.p044m.p046b;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.util.CompatUtils;
import mark.via.gp.R;
import mark.via.p042l.ConfManager;
import mark.via.p042l.p043d.GlobalConf;
import mark.via.p042l.p043d.SiteConf;
import mark.via.utils.AppUtils;
import mark.via.utils.BrowserUtils;
import mark.via.utils.ViewUtils;
import timber.log.Timber;

/* renamed from: mark.via.m.b.i */
/* compiled from: SiteConfSlice */
public class SiteConfSlice extends Slice {

    /* renamed from: e */
    private ConfManager f1447e;

    /* renamed from: f */
    private CheckBox f1448f;

    /* renamed from: g */
    private CheckBox f1449g;

    /* renamed from: h */
    private CheckBox f1450h;

    /* renamed from: i */
    private CheckBox f1451i;

    /* renamed from: j */
    private CheckBox f1452j;

    /* renamed from: k */
    private TextView f1453k;

    /* renamed from: l */
    private EditText f1454l;

    /* renamed from: m */
    private View f1455m;

    /* renamed from: n */
    private boolean f1456n = false;

    /* renamed from: o */
    private String f1457o;

    public SiteConfSlice(Activity activity, ConfManager cVar) {
        super(activity);
        this.f1447e = cVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void mo1265i(SiteConf dVar, CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case R.id.RES_2131230726 /* 2131230726 */:
                Timber.m971a("set adblock: %s", Boolean.valueOf(z));
                dVar.mo1238k(z);
                break;
            case R.id.RES_2131230727 /* 2131230727 */:
                dVar.mo1239l(z);
                break;
            case R.id.RES_2131230728 /* 2131230728 */:
                dVar.mo1240n(z);
                break;
            case R.id.RES_2131230732 /* 2131230732 */:
                dVar.mo1243q(z);
                break;
            case R.id.RES_2131230733 /* 2131230733 */:
                ViewUtils.m2216C((ViewGroup) this.f1461c, z, R.id.RES_2131230733);
                dVar.mo1241o(z);
                Timber.m971a("set siteconf: %s", dVar.toString());
                break;
        }
        this.f1456n = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void mo1266k(SiteConf dVar, AdapterView adapterView, View view, int i, long j) {
        int i2 = i + 1;
        if (i2 != dVar.mo1231d()) {
            dVar.mo1245s(i2);
            int i3 = 0;
            this.f1454l.setVisibility(i == 5 ? 0 : 8);
            View view2 = this.f1455m;
            if (i != 5) {
                i3 = 8;
            }
            view2.setVisibility(i3);
            this.f1453k.setText(CompatUtils.m1338h(this.f1459a, R.array.RES_2130837518, i));
            this.f1456n = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void mo1267m(SiteConf dVar, View view) {
        TaoDialog g = TaoDialog.m1134g(this.f1459a);
        g.mo620L(R.string.RES_2131558456);
        g.mo618J(R.array.RES_2130837518, dVar.mo1231d() - 1, new C0478g(this, dVar));
        g.mo624P(this.f1453k);
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ boolean mo1268o(SiteConf dVar, View view, int i, KeyEvent keyEvent) {
        if (i != 66) {
            return i == 82;
        }
        AppUtils.m2057e(this.f1459a, this.f1454l);
        this.f1454l.clearFocus();
        dVar.mo1244r(this.f1454l.getText().toString().trim());
        this.f1456n = true;
        return true;
    }

    @Override // mark.via.p044m.p046b.Slice
    /* renamed from: d */
    public View mo1254d() {
        View inflate = this.f1459a.getLayoutInflater().inflate(R.layout.RES_2131361795, (ViewGroup) this.f1459a.findViewById(16908290), false);
        this.f1448f = (CheckBox) inflate.findViewById(R.id.RES_2131230733);
        this.f1453k = (TextView) inflate.findViewById(R.id.RES_2131230786);
        this.f1454l = (EditText) inflate.findViewById(R.id.RES_2131230735);
        this.f1455m = inflate.findViewById(R.id.RES_2131230736);
        this.f1449g = (CheckBox) inflate.findViewById(R.id.RES_2131230728);
        this.f1450h = (CheckBox) inflate.findViewById(R.id.RES_2131230732);
        this.f1451i = (CheckBox) inflate.findViewById(R.id.RES_2131230727);
        this.f1452j = (CheckBox) inflate.findViewById(R.id.RES_2131230726);
        return inflate;
    }

    @Override // mark.via.p044m.p046b.Slice
    /* renamed from: e */
    public void mo1263e() {
        SiteConf d = this.f1447e.mo1219d(this.f1457o);
        Timber.m971a("siteconf: %s", d.toString());
        C0476e eVar = new C0476e(this, d);
        this.f1448f.setText(this.f1459a.getString(R.string.RES_2131558552, new Object[]{this.f1457o}));
        this.f1448f.setOnCheckedChangeListener(null);
        this.f1448f.setChecked(d.mo1235h());
        this.f1448f.setOnCheckedChangeListener(eVar);
        this.f1453k.setText(CompatUtils.m1338h(this.f1459a, R.array.RES_2130837518, d.mo1231d() - 1));
        int i = 8;
        this.f1454l.setVisibility(d.mo1231d() == 6 ? 0 : 8);
        View view = this.f1455m;
        if (d.mo1231d() == 6) {
            i = 0;
        }
        view.setVisibility(i);
        this.f1454l.setText(d.mo1230c(""));
        View$OnClickListenerC0477f fVar = new View$OnClickListenerC0477f(this, d);
        this.f1453k.setOnClickListener(fVar);
        this.f1461c.findViewById(R.id.RES_2131230787).setOnClickListener(fVar);
        this.f1454l.setOnKeyListener(new View$OnKeyListenerC0475d(this, d));
        this.f1449g.setOnCheckedChangeListener(null);
        this.f1450h.setOnCheckedChangeListener(null);
        this.f1451i.setOnCheckedChangeListener(null);
        this.f1452j.setOnCheckedChangeListener(null);
        this.f1449g.setChecked(d.mo1234g(GlobalConf.f1402b));
        this.f1450h.setChecked(d.mo1236i(GlobalConf.f1407g));
        this.f1451i.setChecked(d.mo1233f(GlobalConf.f1406f));
        this.f1452j.setChecked(d.mo1232e(GlobalConf.f1415o));
        this.f1449g.setOnCheckedChangeListener(eVar);
        this.f1450h.setOnCheckedChangeListener(eVar);
        this.f1451i.setOnCheckedChangeListener(eVar);
        this.f1452j.setOnCheckedChangeListener(eVar);
        ViewUtils.m2216C((ViewGroup) this.f1461c, d.mo1235h(), R.id.RES_2131230733);
        this.f1456n = false;
    }

    /* renamed from: g */
    public boolean mo1264g() {
        return this.f1456n;
    }

    /* renamed from: p */
    public boolean mo1269p(WebView webView) {
        if (this.f1456n && webView != null) {
            this.f1447e.mo1222j(this.f1457o);
            webView.setTag(null);
            this.f1447e.mo1218c(webView, this.f1457o);
            if (this.f1456n) {
                webView.reload();
                this.f1456n = false;
                return true;
            }
        }
        return false;
    }

    /* renamed from: q */
    public SiteConfSlice mo1270q(String str) {
        this.f1457o = BrowserUtils.m2093n(str, false);
        return this;
    }
}
