package com.flurry.sdk;

import android.location.Location;

public final class t2 extends u2 {
    public static final Integer c = 295;
    public static final Integer d = 11;
    public static final Integer e = 7;
    public static final Integer f = 1;
    public static final String g = null;
    public static final Boolean h;
    public static final Boolean i;
    public static final String j = null;
    public static final Boolean k;
    public static final Location l = null;
    public static final Long m = 10000L;
    public static final Boolean n = Boolean.TRUE;
    public static final Long o = null;
    public static final Byte p = (byte) -1;
    public static final Boolean q = Boolean.FALSE;
    public static final String r = null;
    public static final Boolean s;
    public static final Boolean t;
    private static t2 u;

    static {
        Boolean bool = Boolean.TRUE;
        h = bool;
        i = bool;
        k = bool;
        Boolean bool2 = Boolean.TRUE;
        s = bool2;
        t = bool2;
    }

    private t2() {
        a("AgentVersion", c);
        a("ReleaseMajorVersion", d);
        a("ReleaseMinorVersion", e);
        a("ReleasePatchVersion", f);
        a("ReleaseBetaVersion", "");
        a("VersionName", g);
        a("CaptureUncaughtExceptions", h);
        a("UseHttps", i);
        a("ReportUrl", j);
        a("ReportLocation", k);
        a("ExplicitLocation", l);
        a("ContinueSessionMillis", m);
        a("LogEvents", n);
        a("Age", o);
        a("Gender", p);
        a("UserId", "");
        a("ProtonEnabled", q);
        a("ProtonConfigUrl", r);
        a("analyticsEnabled", s);
        a("IncludeBackgroundSessionsInMetrics", t);
        a("notificationsEnabled", Boolean.FALSE);
    }

    public static synchronized t2 a() {
        t2 t2Var;
        synchronized (t2.class) {
            if (u == null) {
                u = new t2();
            }
            t2Var = u;
        }
        return t2Var;
    }
}
