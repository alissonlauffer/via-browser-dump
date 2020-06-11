package mark.via.ui.settings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import mark.lib.frogsupport.activity.BaseActivity;
import mark.via.gp.R;
import mark.via.ui.activity.FileFinder;
import mark.via.util.r;
import mark.via.util.s;
import org.json.JSONObject;

public class GeneralSettings extends BaseSettings {
    /* access modifiers changed from: private */
    public mark.via.e.a d;
    /* access modifiers changed from: private */
    public a.a.b.n.a e;
    /* access modifiers changed from: private */
    public String[][] f = ((String[][]) Array.newInstance(String.class, 0, 0));
    /* access modifiers changed from: private */
    public int g = 0;
    private a.a.b.n.c h = new b();

    class a extends a.a.b.i.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.a.b.n.b f390a;
        final /* synthetic */ int b;

        a(a.a.b.n.b bVar, int i) {
            this.f390a = bVar;
            this.b = i;
        }

        @Override // a.a.b.i.i
        public void a(String[] strArr) {
            if (!a.a.b.p.a.a(strArr, 1)) {
                String i = s.i(strArr[0]);
                if (i.contains("://")) {
                    ((BaseSettings) GeneralSettings.this).c.v(0);
                    ((BaseSettings) GeneralSettings.this).c.p(i);
                    this.f390a.a(a.a.b.p.a.e(((BaseActivity) GeneralSettings.this).b, R.string.c0));
                    GeneralSettings.this.e.a(this.b, this.f390a);
                }
            }
        }
    }

    class b implements a.a.b.n.c {

        class a extends a.a.b.i.i {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a.a.b.n.b f392a;
            final /* synthetic */ int b;

            a(a.a.b.n.b bVar, int i) {
                this.f392a = bVar;
                this.b = i;
            }

            @Override // a.a.b.i.i
            public void a(int i) {
                ((BaseSettings) GeneralSettings.this).c.w(i + 1);
                a.a.b.j.a.b().d(158);
                this.f392a.a(a.a.b.p.a.b(((BaseActivity) GeneralSettings.this).b, R.array.l, i));
                GeneralSettings.this.e.a(this.b, this.f392a);
            }
        }

        /* renamed from: mark.via.ui.settings.GeneralSettings$b$b  reason: collision with other inner class name */
        class C0044b extends a.a.b.i.i {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a.a.b.n.b f393a;
            final /* synthetic */ int b;

            C0044b(a.a.b.n.b bVar, int i) {
                this.f393a = bVar;
                this.b = i;
            }

            @Override // a.a.b.i.i
            public void a(int i) {
                ((BaseSettings) GeneralSettings.this).c.u(i + 1);
                this.f393a.a(a.a.b.p.a.b(((BaseActivity) GeneralSettings.this).b, R.array.j, i));
                GeneralSettings.this.e.a(this.b, this.f393a);
            }
        }

        class c extends a.a.b.i.i {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a.a.b.n.b f394a;
            final /* synthetic */ int b;

            c(a.a.b.n.b bVar, int i) {
                this.f394a = bVar;
                this.b = i;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: mark.via.util.a.a(android.content.Context, boolean):java.lang.String
             arg types: [android.content.Context, int]
             candidates:
              mark.via.util.a.a(android.app.Activity, java.lang.String):void
              mark.via.util.a.a(android.content.Context, android.view.View):void
              mark.via.util.a.a(android.content.Context, int):boolean
              mark.via.util.a.a(android.content.Context, java.lang.String):boolean
              mark.via.util.a.a(android.content.Context, java.lang.String[]):boolean
              mark.via.util.a.a(android.content.Context, boolean):java.lang.String */
            @Override // a.a.b.i.i
            public void a(String[] strArr) {
                if (!a.a.b.p.a.a(strArr, 1)) {
                    ((BaseSettings) GeneralSettings.this).c.h(strArr[0]);
                    this.f394a.a(mark.via.util.a.a(((BaseActivity) GeneralSettings.this).b, false));
                    GeneralSettings.this.e.a(this.b, this.f394a);
                }
            }
        }

        class d extends a.a.b.i.i {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a.a.b.n.b f395a;
            final /* synthetic */ int b;

            d(a.a.b.n.b bVar, int i) {
                this.f395a = bVar;
                this.b = i;
            }

            @Override // a.a.b.i.i
            public void a(int i) {
                ((BaseSettings) GeneralSettings.this).c.z(i);
                this.f395a.a(a.a.b.p.a.b(((BaseActivity) GeneralSettings.this).b, R.array.n, i));
                GeneralSettings.this.e.a(this.b, this.f395a);
            }
        }

        class e implements View.OnClickListener {
            e() {
            }

            public void onClick(View view) {
                if (view.getId() == 0) {
                    if (mark.via.util.a.a(((BaseActivity) GeneralSettings.this).b, 1)) {
                        GeneralSettings.this.d.a();
                    }
                } else if (view.getId() == 1 && mark.via.util.a.a(((BaseActivity) GeneralSettings.this).b, 0)) {
                    GeneralSettings.this.a(112);
                }
            }
        }

        class f extends a.a.b.i.i {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a.a.b.n.b f397a;
            final /* synthetic */ int b;

            f(a.a.b.n.b bVar, int i) {
                this.f397a = bVar;
                this.b = i;
            }

            @Override // a.a.b.i.i
            public void a(int i) {
                ((BaseSettings) GeneralSettings.this).c.t(i);
                this.f397a.a(a.a.b.p.a.b(((BaseActivity) GeneralSettings.this).b, R.array.i, i));
                GeneralSettings.this.e.a(this.b, this.f397a);
                if (i != 0) {
                    a.a.b.p.e.a(((BaseActivity) GeneralSettings.this).b, (int) R.string.gd);
                }
            }
        }

        class g extends a.a.b.i.i {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a.a.b.n.b f398a;
            final /* synthetic */ int b;

            g(a.a.b.n.b bVar, int i) {
                this.f398a = bVar;
                this.b = i;
            }

            @Override // a.a.b.i.i
            public void a(int i) {
                GeneralSettings generalSettings = GeneralSettings.this;
                ((BaseSettings) generalSettings).c.i(generalSettings.f[0][i]);
                this.f398a.a(GeneralSettings.this.f[1][i]);
                GeneralSettings.this.e.a(this.b, this.f398a);
            }
        }

        b() {
        }

        @Override // a.a.b.n.c
        public void a(a.a.b.n.b bVar, int i) {
            switch (bVar.b()) {
                case R.string.ar /*{ENCODED_INT: 2131492918}*/:
                    a.a.b.i.h hVar = (a.a.b.i.h) new a.a.b.i.h(((BaseActivity) GeneralSettings.this).b).b(R.string.ar);
                    hVar.a(GeneralSettings.this.f[1], GeneralSettings.this.g);
                    hVar.a(new g(bVar, i));
                    hVar.g();
                    return;
                case R.string.as /*{ENCODED_INT: 2131492919}*/:
                    mark.via.d.a.a().f("ua");
                    GeneralSettings.this.b(bVar, i);
                    return;
                case R.string.b9 /*{ENCODED_INT: 2131492936}*/:
                    mark.via.d.a.a().f("adblock");
                    ((BaseSettings) GeneralSettings.this).c.a(bVar.e());
                    a.a.b.j.a.b().d(158);
                    if (bVar.e()) {
                        bVar.a(a.a.b.p.a.a(((BaseActivity) GeneralSettings.this).b, (int) R.string.an, Integer.valueOf(((BaseSettings) GeneralSettings.this).c.b()), mark.via.util.b.b(((BaseSettings) GeneralSettings.this).c.W())));
                    } else {
                        bVar.a(a.a.b.p.a.e(((BaseActivity) GeneralSettings.this).b, R.string.cn));
                    }
                    GeneralSettings.this.e.a(i, bVar);
                    return;
                case R.string.bk /*{ENCODED_INT: 2131492948}*/:
                    mark.via.d.a.a().f("clear_data");
                    GeneralSettings.this.c();
                    return;
                case R.string.bl /*{ENCODED_INT: 2131492949}*/:
                    mark.via.d.a.a().f("clear_data_exit");
                    GeneralSettings.this.d();
                    return;
                case R.string.bo /*{ENCODED_INT: 2131492952}*/:
                    mark.via.d.a.a().f("color_mode");
                    ((BaseSettings) GeneralSettings.this).c.g(bVar.e());
                    return;
                case R.string.cs /*{ENCODED_INT: 2131492993}*/:
                    mark.via.d.a.a().f("download_dir");
                    String o = ((BaseSettings) GeneralSettings.this).c.o();
                    a.a.b.i.d dVar = new a.a.b.i.d(((BaseActivity) GeneralSettings.this).b);
                    dVar.b(mark.via.b.a.i + '/');
                    a.a.b.i.d dVar2 = dVar;
                    dVar2.a(0, o, "");
                    ((a.a.b.i.d) dVar2.a(17039370, new c(bVar, i))).g();
                    return;
                case R.string.d6 /*{ENCODED_INT: 2131493007}*/:
                    mark.via.d.a.a().f("data_export");
                    if (mark.via.util.a.a(((BaseActivity) GeneralSettings.this).b, 1)) {
                        String a2 = mark.via.util.h.a(a.a.b.p.a.e(((BaseActivity) GeneralSettings.this).b, R.string.b2) + "_" + a.a.b.p.a.e(((BaseActivity) GeneralSettings.this).b, R.string.c4), mark.via.b.a.i + "/" + ((BaseSettings) GeneralSettings.this).c.o() + "/", ".txt");
                        mark.via.util.h.a(new JSONObject(mark.via.util.i.c(((BaseActivity) GeneralSettings.this).b, false)).toString(), new File(a2));
                        a.a.b.p.e.a(((BaseActivity) GeneralSettings.this).b, (int) R.string.cl, a.a.b.p.a.a(((BaseActivity) GeneralSettings.this).b, (int) R.string.d7, a2));
                        return;
                    }
                    return;
                case R.string.dd /*{ENCODED_INT: 2131493015}*/:
                    mark.via.d.a.a().f("bar_hide");
                    GeneralSettings.this.c(bVar, i);
                    return;
                case R.string.du /*{ENCODED_INT: 2131493032}*/:
                    mark.via.d.a.a().f("homepage");
                    GeneralSettings.this.e(bVar, i);
                    return;
                case R.string.e4 /*{ENCODED_INT: 2131493042}*/:
                    mark.via.d.a.a().f("data_import");
                    if (mark.via.util.a.a(((BaseActivity) GeneralSettings.this).b, 0)) {
                        GeneralSettings.this.a(113);
                        return;
                    }
                    return;
                case R.string.e7 /*{ENCODED_INT: 2131493045}*/:
                    mark.via.d.a.a().f("bookmark_backup");
                    a.a.b.i.e eVar = new a.a.b.i.e(((BaseActivity) GeneralSettings.this).b);
                    eVar.b(0, R.string.d5);
                    eVar.b(1, R.string.e1);
                    eVar.a(new e());
                    eVar.g();
                    return;
                case R.string.fv /*{ENCODED_INT: 2131493107}*/:
                    mark.via.d.a.a().f("orientation");
                    a.a.b.i.h hVar2 = (a.a.b.i.h) new a.a.b.i.h(((BaseActivity) GeneralSettings.this).b).b(R.string.fv);
                    hVar2.b(R.array.j, ((BaseSettings) GeneralSettings.this).c.X() - 1);
                    hVar2.a(new C0044b(bVar, i));
                    hVar2.g();
                    return;
                case R.string.gb /*{ENCODED_INT: 2131493124}*/:
                    mark.via.d.a.a().f("restore_tabs");
                    a.a.b.i.h hVar3 = (a.a.b.i.h) new a.a.b.i.h(((BaseActivity) GeneralSettings.this).b).b(R.string.gb);
                    hVar3.b(R.array.i, ((BaseSettings) GeneralSettings.this).c.U());
                    hVar3.a(new f(bVar, i));
                    hVar3.g();
                    return;
                case R.string.gh /*{ENCODED_INT: 2131493130}*/:
                    mark.via.d.a.a().f("search");
                    GeneralSettings.this.f(bVar, i);
                    return;
                case R.string.gs /*{ENCODED_INT: 2131493141}*/:
                    mark.via.d.a.a().f("admarks");
                    GeneralSettings.this.startActivity(new Intent(((BaseActivity) GeneralSettings.this).b, BlockSettings.class));
                    return;
                case R.string.gu /*{ENCODED_INT: 2131493143}*/:
                    mark.via.d.a.a().f("cloud");
                    GeneralSettings.this.startActivity(new Intent(((BaseActivity) GeneralSettings.this).b, AccountSettings.class));
                    return;
                case R.string.gw /*{ENCODED_INT: 2131493145}*/:
                    mark.via.d.a.a().f("operation");
                    GeneralSettings.this.startActivity(new Intent(((BaseActivity) GeneralSettings.this).b, OperationSettings.class));
                    return;
                case R.string.h8 /*{ENCODED_INT: 2131493157}*/:
                    mark.via.d.a.a().f("font_size");
                    a.a.b.i.h hVar4 = (a.a.b.i.h) new a.a.b.i.h(((BaseActivity) GeneralSettings.this).b).b(R.string.h8);
                    hVar4.b(R.array.l, ((BaseSettings) GeneralSettings.this).c.b0() - 1);
                    hVar4.a(new a(bVar, i));
                    hVar4.g();
                    return;
                case R.string.ic /*{ENCODED_INT: 2131493199}*/:
                    mark.via.d.a.a().f("layout");
                    GeneralSettings.this.h(bVar, i);
                    return;
                case R.string.io /*{ENCODED_INT: 2131493211}*/:
                    mark.via.d.a.a().f("urlbar_content");
                    a.a.b.i.h hVar5 = (a.a.b.i.h) new a.a.b.i.h(((BaseActivity) GeneralSettings.this).b).b(R.string.io);
                    hVar5.b(R.array.n, ((BaseSettings) GeneralSettings.this).c.f0());
                    hVar5.a(new d(bVar, i));
                    hVar5.g();
                    return;
                default:
                    return;
            }
        }
    }

    class c extends a.a.b.i.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.a.b.n.b f399a;
        final /* synthetic */ int b;

        c(a.a.b.n.b bVar, int i) {
            this.f399a = bVar;
            this.b = i;
        }

        @Override // a.a.b.i.i
        public void a(int i) {
            if (i == 5) {
                GeneralSettings.this.a(this.f399a, this.b);
                return;
            }
            ((BaseSettings) GeneralSettings.this).c.A(i + 1);
            a.a.b.j.a.b().d(158);
            this.f399a.a(a.a.b.p.a.b(((BaseActivity) GeneralSettings.this).b, R.array.o, i));
            GeneralSettings.this.e.a(this.b, this.f399a);
        }
    }

    class d extends a.a.b.i.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.a.b.n.b f400a;
        final /* synthetic */ int b;

        d(a.a.b.n.b bVar, int i) {
            this.f400a = bVar;
            this.b = i;
        }

        @Override // a.a.b.i.i
        public void a(String[] strArr) {
            if (!a.a.b.p.a.a(strArr, 1)) {
                ((BaseSettings) GeneralSettings.this).c.A(6);
                this.f400a.a(a.a.b.p.a.e(((BaseActivity) GeneralSettings.this).b, R.string.au));
                GeneralSettings.this.e.a(this.b, this.f400a);
                ((BaseSettings) GeneralSettings.this).c.r(strArr[0]);
                a.a.b.j.a.b().d(158);
            }
        }
    }

    class e extends a.a.b.i.i {
        e() {
        }

        @Override // a.a.b.i.i
        public void a(boolean[] zArr) {
            ((BaseSettings) GeneralSettings.this).c.a(0, zArr[0]);
            ((BaseSettings) GeneralSettings.this).c.a(1, zArr[1]);
            ((BaseSettings) GeneralSettings.this).c.a(2, zArr[2]);
            ((BaseSettings) GeneralSettings.this).c.a(3, zArr[3]);
            ((BaseSettings) GeneralSettings.this).c.a(4, zArr[4]);
            if (zArr[0]) {
                mark.via.util.b.c(((BaseActivity) GeneralSettings.this).b);
                mark.via.util.b.b(((BaseActivity) GeneralSettings.this).b);
                ((BaseSettings) GeneralSettings.this).c.m0();
            }
            if (zArr[1]) {
                mark.via.util.b.e(((BaseActivity) GeneralSettings.this).b);
            }
            if (zArr[2]) {
                mark.via.util.b.f(((BaseActivity) GeneralSettings.this).b);
                a.a.b.j.a.b().d(3);
            }
            if (zArr[3]) {
                mark.via.util.b.a();
            }
            if (zArr[4]) {
                mark.via.util.b.d(((BaseActivity) GeneralSettings.this).b);
            }
            if (zArr[0] || zArr[1] || zArr[2] || zArr[3] || zArr[4]) {
                a.a.b.p.e.a(((BaseActivity) GeneralSettings.this).b, GeneralSettings.this.getResources().getString(R.string.c2));
            }
        }
    }

    class f extends a.a.b.i.i {
        f() {
        }

        @Override // a.a.b.i.i
        public void a(boolean[] zArr) {
            ((BaseSettings) GeneralSettings.this).c.b(0, zArr[0]);
            ((BaseSettings) GeneralSettings.this).c.b(1, zArr[1]);
            ((BaseSettings) GeneralSettings.this).c.b(2, zArr[2]);
            ((BaseSettings) GeneralSettings.this).c.b(3, zArr[3]);
            ((BaseSettings) GeneralSettings.this).c.b(4, zArr[4]);
        }
    }

    class g extends a.a.b.i.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.a.b.n.b f403a;
        final /* synthetic */ int b;

        g(a.a.b.n.b bVar, int i) {
            this.f403a = bVar;
            this.b = i;
        }

        @Override // a.a.b.i.i
        public void a(int i) {
            ((BaseSettings) GeneralSettings.this).c.h(i);
            a.a.b.j.a.b().d(158);
            this.f403a.a(a.a.b.p.a.b(((BaseActivity) GeneralSettings.this).b, R.array.d, i));
            GeneralSettings.this.e.a(this.b, this.f403a);
        }
    }

    class h extends a.a.b.i.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.a.b.n.b f404a;
        final /* synthetic */ int b;

        h(a.a.b.n.b bVar, int i) {
            this.f404a = bVar;
            this.b = i;
        }

        @Override // a.a.b.i.i
        public void a(int i) {
            ((BaseSettings) GeneralSettings.this).c.x(i);
            this.f404a.a(a.a.b.p.a.b(((BaseActivity) GeneralSettings.this).b, R.array.m, i));
            GeneralSettings.this.e.a(this.b, this.f404a);
        }
    }

    class i extends a.a.b.i.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.a.b.n.b f405a;
        final /* synthetic */ int b;

        i(a.a.b.n.b bVar, int i) {
            this.f405a = bVar;
            this.b = i;
        }

        @Override // a.a.b.i.i
        public void a(int i) {
            if (i == 3) {
                GeneralSettings.this.d(this.f405a, this.b);
                return;
            }
            ((BaseSettings) GeneralSettings.this).c.k(new String[]{"about:home", "about:blank", "about:bookmarks"}[i]);
            this.f405a.a(a.a.b.p.a.b(((BaseActivity) GeneralSettings.this).b, R.array.e, i));
            GeneralSettings.this.e.a(this.b, this.f405a);
            a.a.b.j.a.b().d(158);
        }
    }

    class j extends a.a.b.i.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.a.b.n.b f406a;
        final /* synthetic */ int b;

        j(a.a.b.n.b bVar, int i) {
            this.f406a = bVar;
            this.b = i;
        }

        @Override // a.a.b.i.i
        public void a(String[] strArr) {
            if (!a.a.b.p.a.a(strArr, 1)) {
                String i = s.i(strArr[0]);
                if (i.contains("://")) {
                    ((BaseSettings) GeneralSettings.this).c.k(i);
                    this.f406a.a(i);
                    a.a.b.j.a.b().d(158);
                    GeneralSettings.this.e.a(this.b, this.f406a);
                }
            }
        }
    }

    class k extends a.a.b.i.i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.a.b.n.b f407a;
        final /* synthetic */ int b;

        k(a.a.b.n.b bVar, int i) {
            this.f407a = bVar;
            this.b = i;
        }

        @Override // a.a.b.i.i
        public void a(int i) {
            if (i == 0) {
                GeneralSettings.this.g(this.f407a, this.b);
                return;
            }
            ((BaseSettings) GeneralSettings.this).c.v(i);
            this.f407a.a(a.a.b.p.a.b(((BaseActivity) GeneralSettings.this).b, R.array.k, i));
            GeneralSettings.this.e.a(this.b, this.f407a);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        if (i3 == -1) {
            if (i2 == 112) {
                String a2 = mark.via.util.h.a(((BaseActivity) this).b, intent.getData());
                if (a2 == null) {
                    a.a.b.p.e.a(((BaseActivity) this).b, (int) R.string.e3);
                    return;
                }
                int a3 = this.d.a(new File(a2));
                Context context = ((BaseActivity) this).b;
                if (a3 > 0) {
                    str = a3 + " " + ((BaseActivity) this).b.getResources().getString(R.string.eu);
                } else {
                    str = context.getResources().getString(R.string.e3);
                }
                a.a.b.p.e.a(context, str);
                f();
            } else if (i2 == 113) {
                String a4 = mark.via.util.h.a(((BaseActivity) this).b, intent.getData());
                if (a4 == null) {
                    Context context2 = ((BaseActivity) this).b;
                    a.a.b.p.e.a(context2, context2.getResources().getString(R.string.e5));
                    return;
                }
                mark.via.util.i.a(((BaseActivity) this).b, mark.via.util.h.b(new File(a4)));
                a.a.b.p.e.a(((BaseActivity) this).b, (int) R.string.e6);
                a.a.b.j.a.b().d(158);
                f();
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    /* access modifiers changed from: protected */
    @Override // mark.via.ui.settings.BaseSettings, mark.lib.frogsupport.activity.BaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = new mark.via.e.a(((BaseActivity) this).b);
        setContentView(b());
        r.b(findViewById(a.a.b.m.a.f));
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        mark.via.util.a.a(((BaseActivity) this).b, i2, iArr);
    }

    /* access modifiers changed from: protected */
    @Override // mark.via.ui.settings.BaseSettings
    public void onResume() {
        super.onResume();
        e();
    }

    private View b() {
        a.a.b.m.a a2 = a.a.b.m.a.a(((BaseActivity) this).b);
        a2.b(R.string.gv);
        a2.a(R.string.ca);
        View a3 = a2.a();
        a.a.b.n.a a4 = a.a.b.n.a.a(((BaseActivity) this).b);
        a4.a(a());
        a4.a(this.h);
        a4.a();
        this.e = a4;
        return a.a.b.p.c.a(a3, a4.b());
    }

    /* access modifiers changed from: private */
    public void c() {
        boolean[] zArr = {((BaseSettings) this).c.b(0), ((BaseSettings) this).c.b(1), ((BaseSettings) this).c.b(2), ((BaseSettings) this).c.b(3), ((BaseSettings) this).c.b(4)};
        a.a.b.i.f fVar = (a.a.b.i.f) new a.a.b.i.f(((BaseActivity) this).b).b(R.string.bk);
        fVar.a(R.array.c, zArr);
        ((a.a.b.i.f) fVar.a(17039370, new e())).g();
    }

    /* access modifiers changed from: private */
    public void d() {
        boolean[] zArr = {((BaseSettings) this).c.c(0), ((BaseSettings) this).c.c(1), ((BaseSettings) this).c.c(2), ((BaseSettings) this).c.c(3), ((BaseSettings) this).c.c(4)};
        a.a.b.i.f fVar = (a.a.b.i.f) new a.a.b.i.f(((BaseActivity) this).b).b(R.string.bl);
        fVar.a(R.array.c, zArr);
        ((a.a.b.i.f) fVar.a(17039370, new f())).g();
    }

    private void e() {
        String[][] a2 = a.a.a.a.c(((BaseActivity) this).b).a(((BaseActivity) this).f233a);
        this.f = a2;
        a2[1][0] = a.a.b.p.a.e(((BaseActivity) this).b, R.string.hs);
        String p = ((BaseSettings) this).c.p();
        int length = this.f[0].length;
        for (int i2 = 0; i2 < length; i2++) {
            if (p.equals(this.f[0][i2])) {
                this.g = i2;
            }
        }
    }

    /* access modifiers changed from: private */
    public void f(a.a.b.n.b bVar, int i2) {
        a.a.b.i.h hVar = (a.a.b.i.h) new a.a.b.i.h(((BaseActivity) this).b).b(R.string.gh);
        hVar.b(R.array.k, ((BaseSettings) this).c.Z());
        hVar.a(new k(bVar, i2));
        hVar.g();
    }

    /* access modifiers changed from: private */
    public void g(a.a.b.n.b bVar, int i2) {
        a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(((BaseActivity) this).b).b(R.string.c0);
        dVar.a(0, ((BaseSettings) this).c.a0(), R.string.c0);
        dVar.b(0, 3);
        ((a.a.b.i.d) dVar.a(17039370, new a(bVar, i2))).g();
    }

    /* access modifiers changed from: private */
    public void h(a.a.b.n.b bVar, int i2) {
        a.a.b.i.h hVar = (a.a.b.i.h) new a.a.b.i.h(((BaseActivity) this).b).b(R.string.ic);
        hVar.b(R.array.m, ((BaseSettings) this).c.d0());
        hVar.a(new h(bVar, i2));
        hVar.g();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.util.a.a(android.content.Context, boolean):java.lang.String
     arg types: [android.content.Context, int]
     candidates:
      mark.via.util.a.a(android.app.Activity, java.lang.String):void
      mark.via.util.a.a(android.content.Context, android.view.View):void
      mark.via.util.a.a(android.content.Context, int):boolean
      mark.via.util.a.a(android.content.Context, java.lang.String):boolean
      mark.via.util.a.a(android.content.Context, java.lang.String[]):boolean
      mark.via.util.a.a(android.content.Context, boolean):java.lang.String */
    private List<a.a.b.n.b> a() {
        String str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, R.string.gu));
        Context context = ((BaseActivity) this).b;
        arrayList.add(a.a.b.n.b.a(context, (int) R.string.as, a.a.b.p.a.b(context, R.array.o, ((BaseSettings) this).c.g0() - 1)));
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, R.string.bk));
        boolean a2 = ((BaseSettings) this).c.a();
        if (!a2) {
            str = a.a.b.p.a.e(((BaseActivity) this).b, R.string.cn);
        } else {
            str = a.a.b.p.a.a(((BaseActivity) this).b, (int) R.string.an, Integer.valueOf(((BaseSettings) this).c.b()), mark.via.util.b.b(((BaseSettings) this).c.W()));
        }
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, (int) R.string.b9, str, a2));
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, R.string.gs));
        Context context2 = ((BaseActivity) this).b;
        arrayList.add(a.a.b.n.b.a(context2, (int) R.string.dd, a.a.b.p.a.b(context2, R.array.d, ((BaseSettings) this).c.s())));
        Context context3 = ((BaseActivity) this).b;
        arrayList.add(a.a.b.n.b.a(context3, (int) R.string.ic, a.a.b.p.a.b(context3, R.array.m, ((BaseSettings) this).c.d0())));
        int x = ((BaseSettings) this).c.x();
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, (int) R.string.du, x == 3 ? ((BaseSettings) this).c.v() : a.a.b.p.a.b(((BaseActivity) this).b, R.array.e, x)));
        Context context4 = ((BaseActivity) this).b;
        arrayList.add(a.a.b.n.b.a(context4, (int) R.string.gh, a.a.b.p.a.b(context4, R.array.k, ((BaseSettings) this).c.Z())));
        Context context5 = ((BaseActivity) this).b;
        arrayList.add(a.a.b.n.b.a(context5, (int) R.string.h8, a.a.b.p.a.b(context5, R.array.l, ((BaseSettings) this).c.b0() - 1)));
        Context context6 = ((BaseActivity) this).b;
        arrayList.add(a.a.b.n.b.a(context6, (int) R.string.fv, a.a.b.p.a.b(context6, R.array.j, ((BaseSettings) this).c.X() - 1)));
        Context context7 = ((BaseActivity) this).b;
        arrayList.add(a.a.b.n.b.a(context7, (int) R.string.cs, mark.via.util.a.a(context7, false)));
        e();
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, (int) R.string.ar, this.f[1][this.g]));
        Context context8 = ((BaseActivity) this).b;
        arrayList.add(a.a.b.n.b.a(context8, (int) R.string.io, a.a.b.p.a.b(context8, R.array.n, ((BaseSettings) this).c.f0())));
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, (int) R.string.bo, (int) R.string.bp, ((BaseSettings) this).c.l()));
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, R.string.bl));
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, (int) R.string.gw, (int) R.string.fl));
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, R.string.e7));
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, R.string.e4));
        arrayList.add(a.a.b.n.b.a(((BaseActivity) this).b, R.string.d6));
        Context context9 = ((BaseActivity) this).b;
        arrayList.add(a.a.b.n.b.a(context9, (int) R.string.gb, a.a.b.p.a.b(context9, R.array.i, ((BaseSettings) this).c.U())));
        return arrayList;
    }

    private void f() {
        a.a.b.j.a.b().d(2);
    }

    /* access modifiers changed from: private */
    public void e(a.a.b.n.b bVar, int i2) {
        a.a.b.i.h hVar = (a.a.b.i.h) new a.a.b.i.h(((BaseActivity) this).b).b(R.string.du);
        hVar.b(R.array.e, ((BaseSettings) this).c.x());
        hVar.a(new i(bVar, i2));
        hVar.g();
    }

    /* access modifiers changed from: private */
    public void b(a.a.b.n.b bVar, int i2) {
        a.a.b.i.h hVar = (a.a.b.i.h) new a.a.b.i.h(((BaseActivity) this).b).b(R.string.as);
        hVar.b(R.array.o, ((BaseSettings) this).c.g0() - 1);
        hVar.a(new c(bVar, i2));
        hVar.g();
    }

    /* access modifiers changed from: private */
    public void c(a.a.b.n.b bVar, int i2) {
        a.a.b.i.h hVar = (a.a.b.i.h) new a.a.b.i.h(((BaseActivity) this).b).b(R.string.dd);
        hVar.b(R.array.d, ((BaseSettings) this).c.s());
        hVar.a(new g(bVar, i2));
        hVar.g();
    }

    /* access modifiers changed from: private */
    public void d(a.a.b.n.b bVar, int i2) {
        String v = ((BaseSettings) this).c.x() == 3 ? ((BaseSettings) this).c.v() : mark.via.b.a.h;
        a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(((BaseActivity) this).b).b(R.string.hv);
        dVar.a(0, v, a.a.b.p.a.e(((BaseActivity) this).b, R.string.hv));
        dVar.b(0, 3);
        ((a.a.b.i.d) dVar.a(17039370, new j(bVar, i2))).g();
    }

    /* access modifiers changed from: private */
    public void a(a.a.b.n.b bVar, int i2) {
        a.a.b.i.d dVar = (a.a.b.i.d) new a.a.b.i.d(((BaseActivity) this).b).b(R.string.au);
        dVar.a(0, ((BaseSettings) this).c.e("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36"), R.string.i2);
        dVar.b(0, 3);
        ((a.a.b.i.d) dVar.a(17039370, new d(bVar, i2))).g();
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        Intent intent = new Intent();
        intent.putExtra("Path", Environment.getExternalStorageDirectory().getPath() + "/" + Environment.DIRECTORY_DOWNLOADS);
        intent.setDataAndType(Uri.fromFile(new File(Environment.getExternalStorageDirectory().getPath())), "*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setClass(((BaseActivity) this).f233a, FileFinder.class);
        startActivityForResult(intent, i2);
    }
}
