package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* renamed from: com.flurry.sdk.w2 */
public final class C0300w2 {

    /* renamed from: a */
    private static final String f830a = "w2";

    /* renamed from: a */
    public static String m815a(Context context) {
        String str;
        PackageInfo c = m817c(context);
        return (c == null || (str = c.packageName) == null) ? "" : str;
    }

    /* renamed from: b */
    public static String m816b(Context context) {
        String str;
        PackageInfo c = m817c(context);
        return (c == null || (str = c.versionName) == null) ? "" : str;
    }

    /* renamed from: c */
    private static PackageInfo m817c(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
                String str = f830a;
                C0260s1.m688e(str, "Cannot find package info for package: " + context.getPackageName());
            }
        }
        return null;
    }
}
