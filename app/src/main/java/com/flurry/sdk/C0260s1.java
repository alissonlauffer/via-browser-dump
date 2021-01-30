package com.flurry.sdk;

import android.text.TextUtils;
import android.util.Log;

/* renamed from: com.flurry.sdk.s1 */
public final class C0260s1 {

    /* renamed from: a */
    private static boolean f721a = false;

    /* renamed from: b */
    private static int f722b = 5;

    /* renamed from: c */
    private static boolean f723c = false;

    /* renamed from: a */
    public static void m684a() {
        f721a = true;
    }

    /* renamed from: b */
    public static void m685b(int i) {
        f722b = i;
    }

    /* renamed from: c */
    public static void m686c(int i, String str, String str2) {
        m698o(i, str, str2);
    }

    /* renamed from: d */
    public static void m687d(int i, String str, String str2, Throwable th) {
        m698o(i, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    /* renamed from: e */
    public static void m688e(String str, String str2) {
        m691h(3, str, str2);
    }

    /* renamed from: f */
    public static void m689f(String str, String str2, Throwable th) {
        m692i(6, str, str2, th);
    }

    /* renamed from: g */
    public static void m690g() {
        f721a = false;
    }

    /* renamed from: h */
    private static void m691h(int i, String str, String str2) {
        if (!f721a && f722b <= i) {
            m696m(i, str, str2);
        }
    }

    /* renamed from: i */
    private static void m692i(int i, String str, String str2, Throwable th) {
        m691h(i, str, str2 + '\n' + Log.getStackTraceString(th));
    }

    /* renamed from: j */
    public static void m693j(String str, String str2) {
        m691h(6, str, str2);
    }

    /* renamed from: k */
    public static void m694k(String str, String str2, Throwable th) {
        m692i(5, str, str2, th);
    }

    /* renamed from: l */
    public static int m695l() {
        return f722b;
    }

    /* renamed from: m */
    private static void m696m(int i, String str, String str2) {
        if (!f723c) {
            str = "FlurryAgent";
        }
        int i2 = 0;
        int length = TextUtils.isEmpty(str2) ? 0 : str2.length();
        while (i2 < length) {
            int i3 = 4000 > length - i2 ? length : i2 + 4000;
            if (Log.println(i, str, str2.substring(i2, i3)) > 0) {
                i2 = i3;
            } else {
                return;
            }
        }
    }

    /* renamed from: n */
    public static void m697n(String str, String str2) {
        m691h(4, str, str2);
    }

    /* renamed from: o */
    private static void m698o(int i, String str, String str2) {
        if (f723c) {
            m696m(i, str, str2);
        }
    }

    /* renamed from: p */
    public static void m699p(String str, String str2) {
        m691h(2, str, str2);
    }

    /* renamed from: q */
    public static boolean m700q() {
        return f723c;
    }

    /* renamed from: r */
    public static void m701r(String str, String str2) {
        m691h(5, str, str2);
    }
}
