package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.flurry.sdk.u2;

public class y0 implements u2.a {
    private static final String c = "y0";
    private static y0 d;

    /* renamed from: a  reason: collision with root package name */
    private String f220a;
    private String b;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.flurry.sdk.u2.a(java.lang.String, com.flurry.sdk.u2$a):void
     arg types: [java.lang.String, com.flurry.sdk.y0]
     candidates:
      com.flurry.sdk.u2.a(java.lang.String, java.lang.Object):void
      com.flurry.sdk.u2.a(java.lang.String, com.flurry.sdk.u2$a):void */
    private y0() {
        t2 a2 = t2.a();
        this.f220a = (String) a2.a("VersionName");
        a2.a("VersionName", (u2.a) this);
        String str = c;
        s1.a(4, str, "initSettings, VersionName = " + this.f220a);
    }

    public static int a(Context context) {
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

    public static synchronized y0 b() {
        y0 y0Var;
        synchronized (y0.class) {
            if (d == null) {
                d = new y0();
            }
            y0Var = d;
        }
        return y0Var;
    }

    public static String c() {
        return Build.VERSION.RELEASE;
    }

    public static String d() {
        return Build.DEVICE;
    }

    private static String e() {
        try {
            Context context = e1.a().f110a;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo.versionName != null) {
                return packageInfo.versionName;
            }
            if (packageInfo.versionCode != 0) {
                return Integer.toString(packageInfo.versionCode);
            }
            return "Unknown";
        } catch (Throwable th) {
            s1.a(6, c, "", th);
            return "Unknown";
        }
    }

    public final synchronized String a() {
        if (!TextUtils.isEmpty(this.f220a)) {
            return this.f220a;
        } else if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        } else {
            String e = e();
            this.b = e;
            return e;
        }
    }

    @Override // com.flurry.sdk.u2.a
    public final void a(String str, Object obj) {
        if (str.equals("VersionName")) {
            this.f220a = (String) obj;
            String str2 = c;
            s1.a(4, str2, "onSettingUpdate, VersionName = " + this.f220a);
            return;
        }
        s1.a(6, c, "onSettingUpdate internal error!");
    }
}
