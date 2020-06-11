package mark.via.refactor.config;

import a.a.b.p.d;
import android.content.Context;
import mark.via.util.b;

/* compiled from: GlobalSiteConf */
public class a {
    private static volatile a r;

    /* renamed from: a  reason: collision with root package name */
    private boolean f288a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private String n;
    private String o;
    private int p;
    private int q;

    private a(Context context) {
        a(context);
    }

    public static a b(Context context) {
        if (r == null) {
            synchronized (a.class) {
                if (r == null) {
                    r = new a(context);
                }
            }
        }
        return r;
    }

    public void a(Context context) {
        mark.via.f.a b2 = mark.via.f.a.b(context);
        this.n = b2.v();
        this.g = true;
        this.b = b2.M();
        this.c = b2.V();
        this.f = b2.F();
        int g2 = b.g(context);
        this.e = (b2.D() && g2 == 2) || (!b2.D() && b2.f());
        this.i = g2 == 0;
        this.p = b2.b0();
        this.d = b2.n() || b2.E();
        this.h = b2.S();
        this.j = b2.B();
        this.f288a = b2.T();
        b2.R();
        this.k = b2.k0();
        this.l = b2.e();
        this.q = b2.g0();
        this.m = b2.a(context);
        d.a("night mode: " + this.m);
        this.o = mark.via.h.c.a.a(this.q, b2.e((String) null), this.f288a);
    }

    public int c() {
        return this.q;
    }

    public String d() {
        return this.o;
    }

    public boolean e() {
        return this.l;
    }

    public boolean f() {
        return this.e;
    }

    public boolean g() {
        return this.f288a;
    }

    public boolean h() {
        return this.d;
    }

    public boolean i() {
        return this.j;
    }

    public boolean j() {
        return this.f;
    }

    public boolean k() {
        return this.i;
    }

    public boolean l() {
        return this.b;
    }

    public boolean m() {
        return this.g;
    }

    public boolean n() {
        return this.m;
    }

    public boolean o() {
        return this.h;
    }

    public boolean p() {
        return this.c;
    }

    public boolean q() {
        return this.k;
    }

    public int b() {
        return this.p;
    }

    public String a() {
        return this.n;
    }
}
