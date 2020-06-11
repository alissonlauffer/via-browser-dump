package com.flurry.sdk;

import android.content.Context;
import java.util.Map;

/* renamed from: com.flurry.sdk.q0 */
public class C0235q0 implements AbstractC0282v1 {
    /* renamed from: b */
    public static synchronized C0235q0 m624b() {
        C0235q0 q0Var;
        synchronized (C0235q0.class) {
            q0Var = (C0235q0) C0118e1.m386a().mo188b(C0235q0.class);
        }
        return q0Var;
    }

    /* renamed from: c */
    private static C0077ch m625c(C0125eb ebVar) {
        if (ebVar == null) {
            return null;
        }
        return (C0077ch) ebVar.mo201g(C0077ch.class);
    }

    /* renamed from: d */
    public static C0077ch m626d() {
        return m625c(C0243q2.m650a().mo319m());
    }

    /* renamed from: e */
    public static long m627e() {
        C0077ch d = m626d();
        if (d != null) {
            return d.f234b;
        }
        return 0;
    }

    /* renamed from: f */
    public static long m628f() {
        C0077ch d = m626d();
        if (d != null) {
            return d.f235c;
        }
        return 0;
    }

    /* renamed from: g */
    public static long m629g() {
        C0077ch d = m626d();
        if (d != null) {
            return d.f236d;
        }
        return -1;
    }

    /* renamed from: h */
    public static long m630h() {
        C0077ch d = m626d();
        if (d != null) {
            return d.mo149c();
        }
        return 0;
    }

    /* renamed from: i */
    public static long m631i() {
        C0077ch d = m626d();
        if (d != null) {
            return d.f237e;
        }
        return 0;
    }

    /* renamed from: j */
    public static String m632j() {
        C0077ch d = m626d();
        if (d != null) {
            return d.mo150e();
        }
        return null;
    }

    /* renamed from: k */
    public static String m633k() {
        C0077ch d = m626d();
        if (d != null) {
            return d.mo151f();
        }
        return null;
    }

    /* renamed from: l */
    public static Map<String, String> m634l() {
        C0077ch d = m626d();
        if (d != null) {
            return d.mo152g();
        }
        return null;
    }

    /* renamed from: m */
    public static int m635m() {
        return C0054by.m254a().mo130d();
    }

    @Override // com.flurry.sdk.AbstractC0282v1
    /* renamed from: a */
    public void mo228a(Context context) {
        C0125eb.m400c(C0077ch.class);
        C0199n1.m528a();
        C0266t2.m703e();
        C0146g1.m447a();
        C0054by.m254a();
        C0044bs.m232a();
        C0306x0.m832a();
        C0279v0.m732e();
        C0314y0.m857a();
        C0273u0.m716a();
        C0098d1.m348j();
    }
}
