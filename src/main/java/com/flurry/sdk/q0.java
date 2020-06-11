package com.flurry.sdk;

import android.content.Context;
import java.util.Map;

public class q0 implements v1 {
    public static synchronized q0 a() {
        q0 q0Var;
        synchronized (q0.class) {
            q0Var = (q0) e1.a().a(q0.class);
        }
        return q0Var;
    }

    public static ch b() {
        return a(q2.d().c());
    }

    public static long c() {
        ch b = b();
        if (b != null) {
            return b.b;
        }
        return 0;
    }

    public static long d() {
        ch b = b();
        if (b != null) {
            return b.c;
        }
        return 0;
    }

    public static long e() {
        ch b = b();
        if (b != null) {
            return b.d;
        }
        return -1;
    }

    public static long f() {
        ch b = b();
        if (b != null) {
            return b.b();
        }
        return 0;
    }

    public static long g() {
        ch b = b();
        if (b != null) {
            return b.e;
        }
        return 0;
    }

    public static String h() {
        ch b = b();
        if (b != null) {
            return b.c();
        }
        return null;
    }

    public static String i() {
        ch b = b();
        if (b != null) {
            return b.d();
        }
        return null;
    }

    public static Map<String, String> j() {
        ch b = b();
        if (b != null) {
            return b.e();
        }
        return null;
    }

    public static int k() {
        return by.b().a();
    }

    @Override // com.flurry.sdk.v1
    public void a(Context context) {
        eb.b(ch.class);
        n1.a();
        t2.a();
        g1.b();
        by.b();
        bs.e();
        x0.a();
        v0.d();
        y0.b();
        u0.a();
        d1.a();
    }

    private static ch a(eb ebVar) {
        if (ebVar == null) {
            return null;
        }
        return (ch) ebVar.a(ch.class);
    }
}
