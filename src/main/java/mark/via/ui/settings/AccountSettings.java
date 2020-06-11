package mark.via.ui.settings;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.lib.frogsupport.dialog.TaoDialog;
import mark.lib.frogsupport.navigator.FrogNavigator;
import mark.lib.frogsupport.settings.FrogSettings;
import mark.lib.frogsupport.settings.FrogSettingsBean;
import mark.lib.frogsupport.util.CompatUtils;
import mark.lib.frogsupport.util.LayoutUtils;
import mark.lib.frogsupport.util.QuickUtils;
import mark.via.BrowserApp;
import mark.via.flurry.FlurryHelper;
import mark.via.gp.R;
import mark.via.utils.DownloadUtils;
import mark.via.utils.EncodeUtils;
import mark.via.utils.InfoUtils;
import mark.via.utils.UploadUtils;
import mark.via.utils.ViewUtils;

public class AccountSettings extends BaseSettings {

    /* renamed from: d */
    private FrogSettings f1792d;

    /* renamed from: e */
    private int f1793e;

    /* renamed from: f */
    private List<FrogSettingsBean> f1794f = new ArrayList();

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.AccountSettings$a */
    public class C0581a implements DownloadUtils.AbstractC0499d {
        C0581a() {
        }

        @Override // mark.via.utils.DownloadUtils.AbstractC0499d
        /* renamed from: a */
        public void mo1311a(String str) {
            AccountSettings.this.m2571d(str);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.AccountSettings$b */
    public class RunnableC0582b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f1796a;

        RunnableC0582b(String str) {
            this.f1796a = str;
        }

        public void run() {
            InfoUtils.m2173l(((BaseActivity) AccountSettings.this).f1039b, this.f1796a);
        }
    }

    /* renamed from: A */
    private void m2566A() {
        QuickUtils.m1374f(this.f1039b, R.string.cr, R.string.jc, new C0618d(this));
    }

    /* renamed from: B */
    private void m2567B(Map<String, String> map) {
        UploadUtils xVar = new UploadUtils(this.f1039b);
        xVar.mo1312n(new C0615c(this));
        xVar.mo1313p(this.f1793e == 1 ? "https://app.viayoo.com/api/update" : "http://via.oktutu.com/api/update", map);
    }

    /* renamed from: c */
    private View m2570c() {
        FrogNavigator g = FrogNavigator.m1261g(this.f1039b);
        g.mo736m(R.string.he);
        g.mo734k(R.string.cg);
        View p = g.mo738p();
        FrogSettings j = FrogSettings.m1279j(this.f1039b);
        j.mo748l(new C0627g(this));
        j.mo744g();
        this.f1792d = j;
        return LayoutUtils.m1365c(p, j.mo750o());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: d */
    private void m2571d(String str) {
        if (str.equalsIgnoreCase("0")) {
            this.f1803c.mo1183r1(true);
        } else if (str.equalsIgnoreCase("1")) {
            QuickUtils.m1382n(this.f1039b, R.string.jq);
            this.f1803c.mo1183r1(false);
        } else if (str.equalsIgnoreCase("2")) {
            QuickUtils.m1382n(this.f1039b, R.string.hq);
            this.f1803c.mo1183r1(true);
        } else {
            QuickUtils.m1382n(this.f1039b, R.string.bp);
            this.f1803c.mo1183r1(false);
        }
        m2573f();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m2572e(FrogSettingsBean bVar, int i) {
        int b = bVar.mo754b();
        if (b != R.string.bo) {
            switch (b) {
                case R.string.jj /* 2131558779 */:
                    m2584x();
                    return;
                case R.string.jk /* 2131558780 */:
                    FlurryHelper.m1681a().mo1040i("sync");
                    m2585y();
                    return;
                case R.string.jl /* 2131558781 */:
                    FlurryHelper.m1681a().mo1040i("upload");
                    m2566A();
                    return;
                default:
                    return;
            }
        } else {
            TaoDialog g = TaoDialog.m1134g(this.f1039b);
            g.mo620L(R.string.bo);
            g.mo640r(R.string.h5);
            g.mo618J(R.array.b, this.f1793e, new C0633i(this, bVar, i));
            g.mo622N();
        }
    }

    /* renamed from: f */
    private void m2573f() {
        if (this.f1794f.isEmpty()) {
            this.f1794f.add(FrogSettingsBean.m1292k(this.f1039b, R.string.jj));
            List<FrogSettingsBean> list = this.f1794f;
            Context context = this.f1039b;
            int q = this.f1803c.mo1178q();
            this.f1793e = q;
            list.add(FrogSettingsBean.m1295n(context, R.string.bo, CompatUtils.m1338h(context, R.array.b, q)));
        }
        if (this.f1803c.mo1121V()) {
            this.f1794f.get(0).mo762j(this.f1803c.mo1191u0());
            this.f1794f.add(1, FrogSettingsBean.m1292k(this.f1039b, R.string.jl));
            this.f1794f.add(1, FrogSettingsBean.m1292k(this.f1039b, R.string.jk));
        } else {
            this.f1794f.get(0).mo762j(CompatUtils.m1336f(this.f1039b, R.string.jj));
            if (this.f1794f.size() == 4) {
                this.f1794f.remove(1);
                this.f1794f.remove(1);
            }
        }
        this.f1792d.mo747k(this.f1794f);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void mo1454h(FrogSettingsBean bVar, int i, AdapterView adapterView, View view, int i2, long j) {
        if (this.f1793e != i2) {
            this.f1803c.mo1183r1(false);
            m2573f();
            this.f1803c.mo1101N0(i2);
            bVar.mo761i(CompatUtils.m1338h(this.f1039b, R.array.b, i2));
            this.f1792d.mo749m(i, bVar);
            this.f1793e = i2;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public /* synthetic */ void mo1455l(View view, TaoDialog.C0384l lVar) {
        this.f1803c.mo1183r1(false);
        m2573f();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void mo1456n(View view, TaoDialog.C0384l lVar) {
        if (!CompatUtils.m1339i(lVar.f1091c, 2)) {
            String[] strArr = lVar.f1091c;
            m2583w(strArr[0], strArr[1]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void mo1457p(View view, TaoDialog.C0384l lVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1793e == 1 ? "https://app.viayoo.com/api/sync?" : "http://via.oktutu.com/api/sync?");
        sb.append("name=");
        sb.append(this.f1803c.mo1191u0());
        sb.append("&psw=");
        sb.append(this.f1803c.mo1194v0());
        String sb2 = sb.toString();
        DownloadUtils iVar = new DownloadUtils(this.f1039b);
        iVar.mo1307r(new C0624f(this));
        iVar.mo1305o(sb2);
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ void mo1458r(Map map, View view, TaoDialog.C0384l lVar) {
        m2567B(map);
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public /* synthetic */ void mo1459t(View view, TaoDialog.C0384l lVar) {
        HashMap<String, String> b = InfoUtils.m2163b(this.f1039b, true);
        b.put("name", this.f1803c.mo1191u0());
        b.put("psw", this.f1803c.mo1194v0());
        if (b.get("bookmark").length() > 48000) {
            b.put("bookmark", "");
            QuickUtils.m1374f(this.f1039b, R.string.cr, R.string.be, new C0630h(this, b));
            return;
        }
        m2567B(b);
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public /* synthetic */ void mo1460v() {
        QuickUtils.m1380l(this.f1038a, this.f1039b.getResources().getString(R.string.cr), this.f1039b.getResources().getString(R.string.jd));
    }

    /* renamed from: w */
    private void m2583w(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            QuickUtils.m1382n(this.f1039b, R.string.db);
        } else if (TextUtils.isEmpty(str2)) {
            QuickUtils.m1382n(this.f1039b, R.string.da);
        } else {
            this.f1803c.mo1099M1(str);
            this.f1803c.mo1102N1(str2);
            StringBuilder sb = new StringBuilder();
            sb.append(this.f1793e == 1 ? "https://app.viayoo.com/api/user?" : "http://via.oktutu.com/api/user?");
            sb.append("name=");
            sb.append(str);
            sb.append("&psw=");
            sb.append(EncodeUtils.m2139a(str2));
            String sb2 = sb.toString();
            DownloadUtils iVar = new DownloadUtils(this.f1039b);
            iVar.mo1306q(true);
            iVar.mo1307r(new C0581a());
            iVar.mo1305o(sb2);
        }
    }

    /* renamed from: x */
    private void m2584x() {
        if (this.f1803c.mo1121V()) {
            FlurryHelper.m1681a().mo1040i("logout");
            QuickUtils.m1376h(this.f1039b, this.f1803c.mo1191u0(), getResources().getString(R.string.f2), new C0612b(this));
            return;
        }
        FlurryHelper.m1681a().mo1040i("login");
        TaoDialog g = TaoDialog.m1134g(this.f1039b);
        g.mo620L(R.string.jj);
        g.mo628c(0, this.f1803c.mo1191u0(), R.string.e9, 1);
        g.mo628c(1, "", R.string.e5, 1);
        g.mo640r(R.string.ia);
        g.mo614F(17039370, new C0621e(this));
        g.mo648z(17039360, null);
        if (Build.VERSION.SDK_INT >= 26) {
            g.mo633j(0).setAutofillHints(new String[]{"username"});
            g.mo633j(1).setAutofillHints(new String[]{"password"});
        }
        g.mo622N();
    }

    /* renamed from: y */
    private void m2585y() {
        QuickUtils.m1374f(this.f1039b, R.string.jk, R.string.ib, new C0608a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: z */
    public void m2586z(String str) {
        if (!str.isEmpty()) {
            QuickUtils.m1380l(this.f1038a, getResources().getString(R.string.cr), getResources().getString(R.string.ic));
            BrowserApp.m1388b().execute(new RunnableC0582b(str));
            return;
        }
        QuickUtils.m1380l(this.f1038a, getResources().getString(R.string.cr), getResources().getString(R.string.bp));
    }

    /* access modifiers changed from: protected */
    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m2570c());
        ViewUtils.m2237o(findViewById(FrogNavigator.f1148f));
        m2573f();
    }
}
