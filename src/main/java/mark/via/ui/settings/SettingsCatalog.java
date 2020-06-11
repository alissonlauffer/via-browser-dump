package mark.via.ui.settings;

import a.a.b.n.b;
import a.a.b.n.c;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.via.gp.R;
import mark.via.ui.activity.BrowserActivity;
import mark.via.util.r;

public class SettingsCatalog extends BaseSettings {

    class a implements c {
        a() {
        }

        @Override // a.a.b.n.c
        public void a(b bVar, int i) {
            SettingsCatalog.this.a(bVar.b());
        }
    }

    private View b() {
        a.a.b.m.a a2 = a.a.b.m.a.a(((BaseActivity) this).b);
        a2.b(R.string.gq);
        a2.a(R.string.ca);
        View a3 = a2.a();
        a.a.b.n.a a4 = a.a.b.n.a.a(((BaseActivity) this).b);
        a4.a(a());
        a4.a(new a());
        a4.a();
        return a.a.b.p.c.a(a3, a4.b());
    }

    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b());
        r.b(findViewById(a.a.b.m.a.f));
    }

    private List<b> a() {
        ArrayList arrayList = new ArrayList();
        int[] iArr = {R.string.gv, R.string.gz, R.string.gx, R.string.gt, R.string.gy, R.string.gr};
        for (int i = 0; i < 6; i++) {
            arrayList.add(b.a(((BaseActivity) this).b, iArr[i]));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void a(int i) {
        switch (i) {
            case R.string.gr /*{ENCODED_INT: 2131493140}*/:
                mark.via.d.a.a().d("about");
                Context context = ((BaseActivity) this).b;
                mark.via.util.b.a(context, mark.via.i.b.a.a(context), BrowserActivity.class);
                finish();
                return;
            case R.string.gs /*{ENCODED_INT: 2131493141}*/:
            case R.string.gu /*{ENCODED_INT: 2131493143}*/:
            case R.string.gw /*{ENCODED_INT: 2131493145}*/:
            default:
                return;
            case R.string.gt /*{ENCODED_INT: 2131493142}*/:
                mark.via.d.a.a().d("advanced");
                startActivity(new Intent(((BaseActivity) this).b, AdvancedSettings.class));
                return;
            case R.string.gv /*{ENCODED_INT: 2131493144}*/:
                mark.via.d.a.a().d("general");
                startActivity(new Intent(((BaseActivity) this).b, GeneralSettings.class));
                return;
            case R.string.gx /*{ENCODED_INT: 2131493146}*/:
                mark.via.d.a.a().d("privacy");
                startActivity(new Intent(((BaseActivity) this).b, PrivacySettings.class));
                return;
            case R.string.gy /*{ENCODED_INT: 2131493147}*/:
                mark.via.d.a.a().d("scripts");
                startActivity(new Intent(((BaseActivity) this).b, ScriptSettings.class));
                return;
            case R.string.gz /*{ENCODED_INT: 2131493148}*/:
                mark.via.d.a.a().d("skin");
                startActivity(new Intent(((BaseActivity) this).b, SkinSettings.class));
                return;
        }
    }
}
