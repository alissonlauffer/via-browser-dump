package com.flurry.sdk;

import android.location.Location;

/* renamed from: com.flurry.sdk.t2 */
public final class C0266t2 extends C0275u2 {

    /* renamed from: c */
    public static final Integer f729c = 295;

    /* renamed from: d */
    public static final Integer f730d = 11;

    /* renamed from: e */
    public static final Integer f731e = 7;

    /* renamed from: f */
    public static final Integer f732f = 1;

    /* renamed from: g */
    public static final String f733g = null;

    /* renamed from: h */
    public static final Boolean f734h;

    /* renamed from: i */
    public static final Boolean f735i;

    /* renamed from: j */
    public static final String f736j = null;

    /* renamed from: k */
    public static final Boolean f737k;

    /* renamed from: l */
    public static final Location f738l = null;

    /* renamed from: m */
    public static final Long f739m = 10000L;

    /* renamed from: n */
    public static final Boolean f740n;

    /* renamed from: o */
    public static final Long f741o = null;

    /* renamed from: p */
    public static final Byte f742p = (byte) -1;

    /* renamed from: q */
    public static final Boolean f743q = Boolean.FALSE;

    /* renamed from: r */
    public static final String f744r = null;

    /* renamed from: s */
    public static final Boolean f745s;

    /* renamed from: t */
    public static final Boolean f746t;

    /* renamed from: u */
    private static C0266t2 f747u;

    static {
        Boolean bool = Boolean.TRUE;
        f734h = bool;
        f735i = bool;
        f737k = bool;
        f740n = bool;
        f745s = bool;
        f746t = bool;
    }

    private C0266t2() {
        mo343c("AgentVersion", f729c);
        mo343c("ReleaseMajorVersion", f730d);
        mo343c("ReleaseMinorVersion", f731e);
        mo343c("ReleasePatchVersion", f732f);
        mo343c("ReleaseBetaVersion", "");
        mo343c("VersionName", f733g);
        mo343c("CaptureUncaughtExceptions", f734h);
        mo343c("UseHttps", f735i);
        mo343c("ReportUrl", f736j);
        mo343c("ReportLocation", f737k);
        mo343c("ExplicitLocation", f738l);
        mo343c("ContinueSessionMillis", f739m);
        mo343c("LogEvents", f740n);
        mo343c("Age", f741o);
        mo343c("Gender", f742p);
        mo343c("UserId", "");
        mo343c("ProtonEnabled", f743q);
        mo343c("ProtonConfigUrl", f744r);
        mo343c("analyticsEnabled", f745s);
        mo343c("IncludeBackgroundSessionsInMetrics", f746t);
        mo343c("notificationsEnabled", Boolean.FALSE);
    }

    /* renamed from: e */
    public static synchronized C0266t2 m703e() {
        C0266t2 t2Var;
        synchronized (C0266t2.class) {
            if (f747u == null) {
                f747u = new C0266t2();
            }
            t2Var = f747u;
        }
        return t2Var;
    }
}
