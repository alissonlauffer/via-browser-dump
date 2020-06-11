package mark.via.ui.settings;

import a.a.b.i.i;
import a.a.b.n.c;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.via.gp.R;
import mark.via.util.r;

public class AdvancedSettings extends BaseSettings {

    class a implements c {
        a() {
        }

        @Override // a.a.b.n.c
        public void a(a.a.b.n.b bVar, int i) {
            AdvancedSettings.this.a(bVar);
        }
    }

    class b extends i {
        b(AdvancedSettings advancedSettings) {
        }
    }

    private View b() {
        a.a.b.m.a a2 = a.a.b.m.a.a(((BaseActivity) this).b);
        a2.b(R.string.gt);
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

    private List<a.a.b.n.b> a() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, (int) R.string.h5, ((BaseSettings) this).c.c()));
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, (int) R.string.dw, ((BaseSettings) this).c.B()));
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, (int) R.string.ba, ((BaseSettings) this).c.g()));
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, (int) R.string.ef, ((BaseSettings) this).c.F()));
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, (int) R.string.g7, ((BaseSettings) this).c.S()));
        if (Build.VERSION.SDK_INT >= 19) {
            arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, (int) R.string.ix, ((BaseSettings) this).c.k0()));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void a(a.a.b.n.b bVar) {
        switch (bVar.b()) {
            case R.string.ba /*{ENCODED_INT: 2131492938}*/:
                ((BaseSettings) this).c.f(bVar.e());
                return;
            case R.string.dc /*{ENCODED_INT: 2131493014}*/:
                ((BaseSettings) this).c.i(bVar.e());
                return;
            case R.string.dw /*{ENCODED_INT: 2131493034}*/:
                ((BaseSettings) this).c.l(bVar.e());
                a.a.b.j.a.b().d(158);
                return;
            case R.string.ef /*{ENCODED_INT: 2131493054}*/:
                ((BaseSettings) this).c.o(bVar.e());
                a.a.b.j.a.b().d(158);
                return;
            case R.string.g5 /*{ENCODED_INT: 2131493117}*/:
                ((BaseSettings) this).c.s(bVar.e());
                a.a.b.j.a.b().d(158);
                return;
            case R.string.g7 /*{ENCODED_INT: 2131493119}*/:
                ((BaseSettings) this).c.t(bVar.e());
                a.a.b.j.a.b().d(158);
                return;
            case R.string.h5 /*{ENCODED_INT: 2131493154}*/:
                ((BaseSettings) this).c.b(bVar.e());
                return;
            case R.string.ix /*{ENCODED_INT: 2131493220}*/:
                ((BaseSettings) this).c.x(bVar.e());
                a.a.b.j.a.b().d(158);
                if (bVar.e()) {
                    a.a.b.i.c cVar = (a.a.b.i.c) new a.a.b.i.c(((BaseActivity) this).b).b(R.string.ix);
                    cVar.c(R.string.iy);
                    ((a.a.b.i.c) cVar.a(17039370, new b(this))).g();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
