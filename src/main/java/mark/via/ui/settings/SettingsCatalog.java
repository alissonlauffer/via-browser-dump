package mark.via.ui.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import mark.lib.frogsupport.navigator.FrogNavigator;
import mark.lib.frogsupport.settings.FrogSettings;
import mark.lib.frogsupport.settings.FrogSettingsBean;
import mark.lib.frogsupport.settings.OnFrogSettingsClickListener;
import mark.lib.frogsupport.util.LayoutUtils;
import mark.via.flurry.FlurryHelper;
import mark.via.gp.R;
import mark.via.p044m.p045a.PageManager;
import mark.via.ui.activity.BrowserActivity;
import mark.via.utils.BrowserUtils;
import mark.via.utils.ViewUtils;

public class SettingsCatalog extends BaseSettings {

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.ui.settings.SettingsCatalog$a */
    public class C0598a implements OnFrogSettingsClickListener {
        C0598a() {
        }

        @Override // mark.lib.frogsupport.settings.OnFrogSettingsClickListener
        /* renamed from: a */
        public void mo764a(FrogSettingsBean bVar, int i) {
            SettingsCatalog.this.m2810d(bVar.mo754b());
        }
    }

    /* renamed from: b */
    private List<FrogSettingsBean> m2808b() {
        ArrayList arrayList = new ArrayList();
        int[] iArr = {R.string.hf, R.string.hj, R.string.hh, R.string.hd, R.string.hi, R.string.hb};
        for (int i = 0; i < 6; i++) {
            arrayList.add(FrogSettingsBean.m1292k(this.f1039b, iArr[i]));
        }
        return arrayList;
    }

    /* renamed from: c */
    private View m2809c() {
        FrogNavigator g = FrogNavigator.m1261g(this.f1039b);
        g.mo736m(R.string.ha);
        g.mo734k(R.string.cg);
        View p = g.mo738p();
        FrogSettings j = FrogSettings.m1279j(this.f1039b);
        j.mo742d(m2808b());
        j.mo748l(new C0598a());
        j.mo744g();
        return LayoutUtils.m1365c(p, j.mo750o());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: d */
    private void m2810d(int i) {
        switch (i) {
            case R.string.hb /* 2131558697 */:
                FlurryHelper.m1681a().mo1039h("about");
                Context context = this.f1039b;
                BrowserUtils.m2075F(context, PageManager.m1937a(context), BrowserActivity.class);
                finish();
                return;
            case R.string.hc /* 2131558698 */:
            case R.string.he /* 2131558700 */:
            case R.string.hg /* 2131558702 */:
            default:
                return;
            case R.string.hd /* 2131558699 */:
                FlurryHelper.m1681a().mo1039h("advanced");
                startActivity(new Intent(this.f1039b, AdvancedSettings.class));
                return;
            case R.string.hf /* 2131558701 */:
                FlurryHelper.m1681a().mo1039h("general");
                startActivity(new Intent(this.f1039b, GeneralSettings.class));
                return;
            case R.string.hh /* 2131558703 */:
                FlurryHelper.m1681a().mo1039h("privacy");
                startActivity(new Intent(this.f1039b, PrivacySettings.class));
                return;
            case R.string.hi /* 2131558704 */:
                FlurryHelper.m1681a().mo1039h("scripts");
                startActivity(new Intent(this.f1039b, ScriptSettings.class));
                return;
            case R.string.hj /* 2131558705 */:
                FlurryHelper.m1681a().mo1039h("skin");
                startActivity(new Intent(this.f1039b, SkinSettings.class));
                return;
        }
    }

    @Override // mark.via.ui.settings.BaseSettings, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(m2809c());
        ViewUtils.m2237o(findViewById(FrogNavigator.f1148f));
    }
}
