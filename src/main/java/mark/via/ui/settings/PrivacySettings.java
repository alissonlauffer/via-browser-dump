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
import mark.via.gp.R;
import mark.via.utils.AppUtils;
import mark.via.utils.ViewUtils;

public class PrivacySettings extends BaseSettings {

    /* renamed from: d */
    private FrogSettings f1823d;

    /* renamed from: a */
    private List<FrogSettingsBean> m2760a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(FrogSettingsBean.m1297p(this.f1039b, R.string.RES_2131558611, this.f1803c.mo1119U()));
        arrayList.add(FrogSettingsBean.m1297p(this.f1039b, R.string.RES_2131558533, this.f1803c.mo1190u()));
        int i = Build.VERSION.SDK_INT;
        if (i < 19) {
            arrayList.add(FrogSettingsBean.m1297p(this.f1039b, R.string.RES_2131558671, this.f1803c.mo1143e0()));
        }
        if (i >= 21) {
            arrayList.add(FrogSettingsBean.m1297p(this.f1039b, R.string.RES_2131558472, this.f1803c.mo1154i()));
        }
        return arrayList;
    }

    /* renamed from: b */
    private View m2761b() {
        FrogNavigator g = FrogNavigator.m1261g(this.f1039b);
        g.mo736m(R.string.RES_2131558703);
        g.mo734k(R.string.RES_2131558517);
        View p = g.mo738p();
        FrogSettings j = FrogSettings.m1279j(this.f1039b);
        j.mo742d(m2760a());
        j.mo748l(new C0673v0(this));
        j.mo744g();
        this.f1823d = j;
        return LayoutUtils.m1365c(p, j.mo750o());
    }

    /* renamed from: c */
    private void m2762c(FrogSettingsBean bVar) {
        switch (bVar.mo754b()) {
            case R.string.RES_2131558472 /* 2131558472 */:
                this.f1803c.mo1078F0(bVar.mo757e());
                DataChecker.m1181c().mo667h(158);
                return;
            case R.string.RES_2131558533 /* 2131558533 */:
                this.f1803c.mo1110Q0(bVar.mo757e());
                DataChecker.m1181c().mo667h(158);
                return;
            case R.string.RES_2131558611 /* 2131558611 */:
                if (bVar.mo757e()) {
                    this.f1803c.mo1180q1(true);
                    AppUtils.m2063k(this.f1039b);
                } else {
                    this.f1803c.mo1180q1(false);
                }
                DataChecker.m1181c().mo667h(158);
                return;
            case R.string.RES_2131558671 /* 2131558671 */:
                this.f1803c.mo1064A1(bVar.mo757e());
                DataChecker.m1181c().mo667h(158);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void mo1507e(FrogSettingsBean bVar, int i) {
        m2762c(bVar);
    }

    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m2761b());
        ViewUtils.m2237o(findViewById(FrogNavigator.f1148f));
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2;
        FrogSettingsBean h;
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (AppUtils.m2062j(this.f1039b, i, iArr) && strArr.length == 1 && "android.permission.ACCESS_FINE_LOCATION".equals(strArr[0]) && (h = this.f1823d.mo745h((i2 = this.f1823d.mo746i(R.string.RES_2131558611)))) != null) {
            h.mo759g(false);
            this.f1823d.mo749m(i2, h);
            this.f1803c.mo1180q1(false);
        }
    }
}
