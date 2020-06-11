package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.flurry.sdk.C0275u2;

/* renamed from: com.flurry.sdk.y0 */
public class C0314y0 implements C0275u2.AbstractC0276a {

    /* renamed from: c */
    private static final String f862c = "y0";

    /* renamed from: d */
    private static C0314y0 f863d;

    /* renamed from: a */
    private String f864a;

    /* renamed from: b */
    private String f865b;

    private C0314y0() {
        C0266t2 e = C0266t2.m703e();
        this.f864a = (String) e.mo341a("VersionName");
        e.mo342b("VersionName", this);
        String str = f862c;
        C0260s1.m686c(4, str, "initSettings, VersionName = " + this.f864a);
    }

    /* renamed from: a */
    public static synchronized C0314y0 m857a() {
        C0314y0 y0Var;
        synchronized (C0314y0.class) {
            if (f863d == null) {
                f863d = new C0314y0();
            }
            y0Var = f863d;
        }
        return y0Var;
    }

    /* renamed from: c */
    public static int m858c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return 0;
        }
        try {
            return packageManager.getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    /* renamed from: d */
    public static String m859d() {
        return Build.VERSION.RELEASE;
    }

    /* renamed from: e */
    public static String m860e() {
        return Build.DEVICE;
    }

    /* renamed from: g */
    private static String m861g() {
        try {
            Context context = C0118e1.m386a().f361a;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str = packageInfo.versionName;
            if (str != null) {
                return str;
            }
            int i = packageInfo.versionCode;
            if (i != 0) {
                return Integer.toString(i);
            }
            return "Unknown";
        } catch (Throwable th) {
            C0260s1.m687d(6, f862c, "", th);
            return "Unknown";
        }
    }

    @Override // com.flurry.sdk.C0275u2.AbstractC0276a
    /* renamed from: b */
    public final void mo197b(String str, Object obj) {
        if (str.equals("VersionName")) {
            this.f864a = (String) obj;
            String str2 = f862c;
            C0260s1.m686c(4, str2, "onSettingUpdate, VersionName = " + this.f864a);
            return;
        }
        C0260s1.m686c(6, f862c, "onSettingUpdate internal error!");
    }

    /* renamed from: f */
    public final synchronized String mo366f() {
        if (!TextUtils.isEmpty(this.f864a)) {
            return this.f864a;
        } else if (!TextUtils.isEmpty(this.f865b)) {
            return this.f865b;
        } else {
            String g = m861g();
            this.f865b = g;
            return g;
        }
    }
}
