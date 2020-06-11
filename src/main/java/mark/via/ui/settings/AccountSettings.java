package mark.via.ui.settings;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.via.BrowserApp;
import mark.via.gp.R;
import mark.via.util.e;
import mark.via.util.q;
import mark.via.util.r;

public class AccountSettings extends BaseSettings {
    /* access modifiers changed from: private */
    public a.a.b.n.a d;
    /* access modifiers changed from: private */
    public int e;
    private List<a.a.b.n.b> f = new ArrayList();

    class a implements a.a.b.n.c {
        a() {
        }

        @Override // a.a.b.n.c
        public void a(a.a.b.n.b bVar, int i) {
            AccountSettings.this.a(bVar, i);
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        public void onClick(View view) {
            ((BaseSettings) AccountSettings.this).c.q(false);
            AccountSettings.this.b();
        }
    }

    class c extends a.a.b.i.i {
        c() {
        }

        @Override // a.a.b.i.i
        public void a(String[] strArr) {
            if (!a.a.b.p.a.a(strArr, 2)) {
                AccountSettings.this.a(strArr[0], strArr[1]);
            }
        }
    }

    class d implements e.d {
        d() {
        }

        @Override // mark.via.util.e.d
        public void a(String str) {
            AccountSettings.this.a(str);
        }
    }

    class e implements View.OnClickListener {

        class a implements e.d {
            a() {
            }

            @Override // mark.via.util.e.d
            public void a(String str) {
                AccountSettings.this.b(str);
            }
        }

        e() {
        }

        public void onClick(View view) {
            StringBuilder sb = new StringBuilder();
            sb.append(AccountSettings.this.e == 1 ? "https://app.viayoo.com/api/sync?" : "http://via.oktutu.com/api/sync?");
            sb.append("name=");
            sb.append(((BaseSettings) AccountSettings.this).c.h0());
            sb.append("&psw=");
            sb.append(((BaseSettings) AccountSettings.this).c.i0());
            String sb2 = sb.toString();
            mark.via.util.e eVar = new mark.via.util.e(((BaseActivity) AccountSettings.this).b);
            eVar.a(new a());
            eVar.a(sb2);
        }
    }

    class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f374a;

        f(String str) {
            this.f374a = str;
        }

        public void run() {
            mark.via.util.i.a(((BaseActivity) AccountSettings.this).b, this.f374a);
        }
    }

    class g implements View.OnClickListener {

        class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f376a;

            a(Map map) {
                this.f376a = map;
            }

            public void onClick(View view) {
                AccountSettings.this.a(this.f376a);
            }
        }

        g() {
        }

        public void onClick(View view) {
            HashMap<String, String> c = mark.via.util.i.c(((BaseActivity) AccountSettings.this).b, true);
            c.put("name", ((BaseSettings) AccountSettings.this).c.h0());
            c.put("psw", ((BaseSettings) AccountSettings.this).c.i0());
            if (c.get("bookmark").length() > 48000) {
                c.remove("bookmark");
                c.put("bookmark", "");
                a.a.b.p.e.a(((BaseActivity) AccountSettings.this).b, (int) R.string.cl, (int) R.string.bd, new a(c));
                return;
            }
            AccountSettings.this.a(c);
        }
    }

    class h implements q.d {
        h() {
        }

        @Override // mark.via.util.q.d
        public void a() {
            a.a.b.p.e.b(((BaseActivity) AccountSettings.this).f233a, ((BaseActivity) AccountSettings.this).b.getResources().getString(R.string.cl), ((BaseActivity) AccountSettings.this).b.getResources().getString(R.string.in));
        }
    }

    class i extends a.a.b.i.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.a.b.n.b f378a;
        final /* synthetic */ int b;

        i(a.a.b.n.b bVar, int i) {
            this.f378a = bVar;
            this.b = i;
        }

        @Override // a.a.b.i.i
        public void a(int i) {
            if (AccountSettings.this.e != i) {
                ((BaseSettings) AccountSettings.this).c.q(false);
                AccountSettings.this.b();
                ((BaseSettings) AccountSettings.this).c.f(i);
                this.f378a.a(a.a.b.p.a.b(((BaseActivity) AccountSettings.this).b, R.array.b, i));
                AccountSettings.this.d.a(this.b, this.f378a);
                int unused = AccountSettings.this.e = i;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a());
        r.b(findViewById(a.a.b.m.a.f));
        b();
    }

    private void c() {
        if (((BaseSettings) this).c.N()) {
            mark.via.d.a.a().e("logout");
            a.a.b.p.e.a(((BaseActivity) this).b, ((BaseSettings) this).c.h0(), getResources().getString(R.string.ej), new b());
            return;
        }
        mark.via.d.a.a().e("login");
        a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(((BaseActivity) this).b).b(R.string.is);
        dVar.a(0, ((BaseSettings) this).c.h0(), R.string.ds);
        dVar.a(1, "", R.string.f0do);
        a.a.b.i.d dVar2 = (a.a.b.i.d) ((a.a.b.i.d) ((a.a.b.i.d) dVar.a(R.string.hp)).a(17039370, new c())).a(17039360, (View.OnClickListener) null);
        if (Build.VERSION.SDK_INT >= 26) {
            dVar2.c(0).setAutofillHints(new String[]{"username"});
            dVar2.c(1).setAutofillHints(new String[]{"password"});
        }
        dVar2.g();
    }

    private void d() {
        a.a.b.p.e.a(((BaseActivity) this).b, (int) R.string.it, (int) R.string.hq, new e());
    }

    private void e() {
        a.a.b.p.e.a(((BaseActivity) this).b, (int) R.string.cl, (int) R.string.im, new g());
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.f.isEmpty()) {
            this.f.add(a.a.b.n.b.a(((BaseActivity) this).b, R.string.is));
            List<a.a.b.n.b> list = this.f;
            Context context = ((BaseActivity) this).b;
            int j = ((BaseSettings) this).c.j();
            this.e = j;
            list.add(a.a.b.n.b.a(context, (int) R.string.bm, a.a.b.p.a.b(context, R.array.b, j)));
        }
        if (((BaseSettings) this).c.N()) {
            this.f.get(0).b(((BaseSettings) this).c.h0());
            this.f.add(1, a.a.b.n.b.a(((BaseActivity) this).b, R.string.iu));
            this.f.add(1, a.a.b.n.b.a(((BaseActivity) this).b, R.string.it));
        } else {
            this.f.get(0).b(a.a.b.p.a.e(((BaseActivity) this).b, R.string.is));
            if (this.f.size() == 4) {
                this.f.remove(1);
                this.f.remove(1);
            }
        }
        this.d.b(this.f);
    }

    private View a() {
        a.a.b.m.a a2 = a.a.b.m.a.a(((BaseActivity) this).b);
        a2.b(R.string.gu);
        a2.a(R.string.ca);
        View a3 = a2.a();
        a.a.b.n.a a4 = a.a.b.n.a.a(((BaseActivity) this).b);
        a4.a(new a());
        a4.a();
        this.d = a4;
        return a.a.b.p.c.a(a3, a4.b());
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            a.a.b.p.e.a(((BaseActivity) this).b, (int) R.string.d3);
        } else if (TextUtils.isEmpty(str2)) {
            a.a.b.p.e.a(((BaseActivity) this).b, (int) R.string.d2);
        } else {
            ((BaseSettings) this).c.s(str);
            ((BaseSettings) this).c.t(str2);
            StringBuilder sb = new StringBuilder();
            sb.append(this.e == 1 ? "https://app.viayoo.com/api/user?" : "http://via.oktutu.com/api/user?");
            sb.append("name=");
            sb.append(str);
            sb.append("&psw=");
            sb.append(mark.via.util.f.a(str2));
            String sb2 = sb.toString();
            mark.via.util.e eVar = new mark.via.util.e(((BaseActivity) this).b);
            eVar.a(true);
            eVar.a(new d());
            eVar.a(sb2);
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        if (!str.isEmpty()) {
            a.a.b.p.e.b(((BaseActivity) this).f233a, getResources().getString(R.string.cl), getResources().getString(R.string.hr));
            BrowserApp.a().execute(new f(str));
            return;
        }
        a.a.b.p.e.b(((BaseActivity) this).f233a, getResources().getString(R.string.cl), getResources().getString(R.string.bn));
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        if (str.equalsIgnoreCase("0")) {
            ((BaseSettings) this).c.q(true);
        } else if (str.equalsIgnoreCase("1")) {
            a.a.b.p.e.a(((BaseActivity) this).b, (int) R.string.iz);
            ((BaseSettings) this).c.q(false);
        } else if (str.equalsIgnoreCase("2")) {
            a.a.b.p.e.a(((BaseActivity) this).b, (int) R.string.h6);
            ((BaseSettings) this).c.q(true);
        } else {
            a.a.b.p.e.a(((BaseActivity) this).b, (int) R.string.bn);
            ((BaseSettings) this).c.q(false);
        }
        b();
    }

    /* access modifiers changed from: private */
    public void a(Map<String, String> map) {
        q qVar = new q(((BaseActivity) this).b);
        qVar.a(new h());
        qVar.a(this.e == 1 ? "https://app.viayoo.com/api/update" : "http://via.oktutu.com/api/update", map);
    }

    /* access modifiers changed from: private */
    public void a(a.a.b.n.b bVar, int i2) {
        int b2 = bVar.b();
        if (b2 != R.string.bm) {
            switch (b2) {
                case R.string.is /*{ENCODED_INT: 2131493215}*/:
                    c();
                    return;
                case R.string.it /*{ENCODED_INT: 2131493216}*/:
                    mark.via.d.a.a().e("sync");
                    d();
                    return;
                case R.string.iu /*{ENCODED_INT: 2131493217}*/:
                    mark.via.d.a.a().e("upload");
                    e();
                    return;
                default:
                    return;
            }
        } else {
            a.a.b.i.h hVar = (a.a.b.i.h) ((a.a.b.i.h) new a.a.b.i.h(((BaseActivity) this).b).b(R.string.bm)).a(R.string.gk);
            hVar.b(R.array.b, this.e);
            hVar.a(new i(bVar, i2));
            hVar.g();
        }
    }
}
