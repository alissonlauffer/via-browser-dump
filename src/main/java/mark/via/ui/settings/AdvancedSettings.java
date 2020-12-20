package mark.via.ui.settings;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import mark.lib.frogsupport.checker.DataChecker;
import mark.lib.frogsupport.navigator.FrogNavigator;
import mark.lib.frogsupport.settings.FrogSettings;
import mark.lib.frogsupport.settings.FrogSettingsBean;
import mark.lib.frogsupport.util.LayoutUtils;
import mark.lib.frogsupport.util.QuickUtils;
import mark.via.gp.R;
import mark.via.utils.ViewUtils;

public class AdvancedSettings extends BaseSettings {
    /* renamed from: a */
    private List<FrogSettingsBean> m2604a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(FrogSettingsBean.m1297p(this.f1039b, R.string.RES_2131558711, this.f1803c.mo1148g()));
        arrayList.add(FrogSettingsBean.m1297p(this.f1039b, R.string.RES_2131558587, this.f1803c.mo1089J()));
        arrayList.add(FrogSettingsBean.m1297p(this.f1039b, R.string.RES_2131558475, this.f1803c.mo1160k()));
        arrayList.add(FrogSettingsBean.m1297p(this.f1039b, R.string.RES_2131558607, this.f1803c.mo1100N()));
        arrayList.add(FrogSettingsBean.m1297p(this.f1039b, R.string.RES_2131558676, this.f1803c.mo1135b0()));
        if (Build.VERSION.SDK_INT >= 19) {
            arrayList.add(FrogSettingsBean.m1297p(this.f1039b, R.string.RES_2131558784, this.f1803c.mo1200x0()));
        }
        return arrayList;
    }

    /* renamed from: b */
    private View m2605b() {
        FrogNavigator g = FrogNavigator.m1261g(this.f1039b);
        g.mo736m(R.string.RES_2131558699);
        g.mo734k(R.string.RES_2131558517);
        View p = g.mo738p();
        FrogSettings j = FrogSettings.m1279j(this.f1039b);
        j.mo742d(m2604a());
        j.mo748l(new C0636j(this));
        j.mo744g();
        return LayoutUtils.m1365c(p, j.mo750o());
    }

    /* renamed from: c */
    private void m2606c(FrogSettingsBean bVar) {
        switch (bVar.mo754b()) {
            case R.string.RES_2131558475 /* 2131558475 */:
                this.f1803c.mo1084H0(bVar.mo757e());
                return;
            case R.string.RES_2131558565 /* 2131558565 */:
                this.f1803c.mo1122V0(bVar.mo757e());
                return;
            case R.string.RES_2131558587 /* 2131558587 */:
                this.f1803c.mo1153h1(bVar.mo757e());
                DataChecker.m1181c().mo667h(158);
                return;
            case R.string.RES_2131558607 /* 2131558607 */:
                this.f1803c.mo1162k1(bVar.mo757e());
                DataChecker.m1181c().mo667h(158);
                return;
            case R.string.RES_2131558673 /* 2131558673 */:
                this.f1803c.mo1198w1(bVar.mo757e());
                DataChecker.m1181c().mo667h(158);
                return;
            case R.string.RES_2131558676 /* 2131558676 */:
                this.f1803c.mo1201x1(bVar.mo757e());
                DataChecker.m1181c().mo667h(158);
                return;
            case R.string.RES_2131558711 /* 2131558711 */:
                this.f1803c.mo1072D0(bVar.mo757e());
                return;
            case R.string.RES_2131558784 /* 2131558784 */:
                this.f1803c.mo1108P1(bVar.mo757e());
                DataChecker.m1181c().mo667h(158);
                if (bVar.mo757e()) {
                    QuickUtils.m1378j(this.f1039b, R.string.RES_2131558784, R.string.RES_2131558785);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void mo1463e(FrogSettingsBean bVar, int i) {
        m2606c(bVar);
    }

    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m2605b());
        ViewUtils.m2237o(findViewById(FrogNavigator.f1148f));
    }
}
