package mark.via.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.lib.frogsupport.navigator.FrogNavigator;
import mark.lib.frogsupport.settings.FrogSettings;
import mark.lib.frogsupport.settings.FrogSettingsBean;
import mark.lib.frogsupport.settings.OnFrogSettingsClickListener;
import mark.lib.frogsupport.util.CompatUtils;
import mark.lib.frogsupport.util.LayoutUtils;
import mark.via.BrowserApp;
import mark.via.component.DaggerBlockerComponent;
import mark.via.flurry.FlurryHelper;
import mark.via.gp.R;
import mark.via.utils.BrowserUtils;
import mark.via.utils.ViewUtils;
import p000a.p001a.p002a.Blocker;

public class AdBlockUI extends BaseSettings {

    /* renamed from: d */
    private FrogSettings f1798d;

    /* renamed from: e */
    private boolean f1799e = false;

    /* renamed from: f */
    Blocker f1800f;

    /* renamed from: g */
    private OnFrogSettingsClickListener f1801g = new C0583a();

    /* renamed from: mark.via.ui.settings.AdBlockUI$a */
    class C0583a implements OnFrogSettingsClickListener {
        C0583a() {
        }

        @Override // mark.lib.frogsupport.settings.OnFrogSettingsClickListener
        /* renamed from: a */
        public void mo764a(FrogSettingsBean bVar, int i) {
            switch (bVar.mo754b()) {
                case R.string.b_ /* 2131558473 */:
                    FlurryHelper.m1681a().mo1041j("adblock");
                    AdBlockUI.this.f1803c.mo1069C0(bVar.mo757e());
                    if (bVar.mo757e()) {
                        bVar.mo761i(CompatUtils.m1337g(((BaseActivity) AdBlockUI.this).f1039b, R.string.an, Integer.valueOf(AdBlockUI.this.f1803c.mo1145f()), BrowserUtils.m2092m(AdBlockUI.this.f1803c.mo1146f0())));
                    } else {
                        bVar.mo761i(CompatUtils.m1336f(((BaseActivity) AdBlockUI.this).f1039b, R.string.cu));
                    }
                    AdBlockUI.this.f1798d.mo749m(i, bVar);
                    return;
                case R.string.c3 /* 2131558503 */:
                    AdBlockUI.this.startActivity(new Intent(((BaseActivity) AdBlockUI.this).f1039b, CustomFiltersUI.class));
                    return;
                case R.string.dc /* 2131558550 */:
                    AdBlockUI.this.f1799e = true;
                    AdBlockUI.this.f1803c.mo1087I0(bVar.mo757e());
                    AdBlockUI.this.f1798d.mo749m(i, bVar);
                    return;
                case R.string.dm /* 2131558560 */:
                    AdBlockUI.this.startActivity(new Intent(((BaseActivity) AdBlockUI.this).f1039b, SubscribedFiltersUI.class));
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: g */
    private List<FrogSettingsBean> m2601g() {
        String str;
        ArrayList arrayList = new ArrayList();
        boolean e = this.f1803c.mo1142e();
        if (!e) {
            str = CompatUtils.m1336f(this.f1039b, R.string.cu);
        } else {
            str = CompatUtils.m1337g(this.f1039b, R.string.an, Integer.valueOf(this.f1803c.mo1145f()), BrowserUtils.m2092m(this.f1803c.mo1146f0()));
        }
        arrayList.add(FrogSettingsBean.m1296o(this.f1039b, R.string.b_, str, e));
        arrayList.add(FrogSettingsBean.m1294m(this.f1039b, R.string.dc, R.string.dd, this.f1803c.mo1163l()));
        arrayList.add(FrogSettingsBean.m1293l(this.f1039b, R.string.c3, R.string.c4));
        arrayList.add(FrogSettingsBean.m1293l(this.f1039b, R.string.dm, R.string.dn));
        return arrayList;
    }

    /* renamed from: h */
    private View m2602h() {
        FrogNavigator g = FrogNavigator.m1261g(this.f1039b);
        g.mo736m(R.string.b_);
        g.mo734k(R.string.cg);
        View p = g.mo738p();
        FrogSettings j = FrogSettings.m1279j(this.f1039b);
        j.mo742d(m2601g());
        j.mo748l(this.f1801g);
        j.mo744g();
        this.f1798d = j;
        return LayoutUtils.m1365c(p, j.mo750o());
    }

    /* access modifiers changed from: protected */
    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        DaggerBlockerComponent.C0447b d = DaggerBlockerComponent.m1665d();
        d.mo1029a(BrowserApp.m1387a(this).f1192a);
        d.mo1030b().mo1020a(this);
        super.onCreate(bundle);
        setContentView(m2602h());
        ViewUtils.m2237o(findViewById(FrogNavigator.f1148f));
    }

    /* access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        if (this.f1799e) {
            this.f1800f.mo14n(this.f1803c.mo1163l());
        }
        super.onPause();
    }
}
