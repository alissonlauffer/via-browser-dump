package mark.via.ui.settings;

import a.a.b.n.b;
import a.a.b.n.c;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.via.gp.R;
import mark.via.util.r;

public class PrivacySettings extends BaseSettings {

    class a implements c {
        a() {
        }

        @Override // a.a.b.n.c
        public void a(b bVar, int i) {
            PrivacySettings.this.a(bVar);
        }
    }

    private View b() {
        a.a.b.m.a a2 = a.a.b.m.a.a(((BaseActivity) this).b);
        a2.b(R.string.gx);
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
        arrayList.add(b.a(((BaseActivity) this).b, (int) R.string.eh, ((BaseSettings) this).c.M()));
        arrayList.add(b.a(((BaseActivity) this).b, (int) R.string.cp, ((BaseSettings) this).c.n()));
        if (Build.VERSION.SDK_INT < 19) {
            arrayList.add(b.a(((BaseActivity) this).b, (int) R.string.g3, ((BaseSettings) this).c.V()));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            arrayList.add(b.a(((BaseActivity) this).b, (int) R.string.b8, ((BaseSettings) this).c.e()));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void a(b bVar) {
        switch (bVar.b()) {
            case R.string.b8 /*{ENCODED_INT: 2131492935}*/:
                ((BaseSettings) this).c.d(bVar.e());
                a.a.b.j.a.b().d(158);
                return;
            case R.string.cp /*{ENCODED_INT: 2131492990}*/:
                ((BaseSettings) this).c.h(bVar.e());
                a.a.b.j.a.b().d(158);
                return;
            case R.string.eh /*{ENCODED_INT: 2131493056}*/:
                ((BaseSettings) this).c.p(bVar.e());
                a.a.b.j.a.b().d(158);
                return;
            case R.string.g3 /*{ENCODED_INT: 2131493115}*/:
                ((BaseSettings) this).c.v(bVar.e());
                a.a.b.j.a.b().d(158);
                return;
            default:
                return;
        }
    }
}
