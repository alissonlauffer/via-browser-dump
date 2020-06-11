package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class w2 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f212a = "w2";

    public static String a(Context context) {
        String str;
        PackageInfo c = c(context);
        return (c == null || (str = c.packageName) == null) ? "" : str;
    }

    public static String b(Context context) {
        String str;
        PackageInfo c = c(context);
        return (c == null || (str = c.versionName) == null) ? "" : str;
    }

    private static PackageInfo c(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
                String str = f212a;
                s1.a(str, "Cannot find package info for package: " + context.getPackageName());
            }
        }
        return null;
    }
}
