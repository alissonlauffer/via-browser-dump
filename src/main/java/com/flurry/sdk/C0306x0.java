package com.flurry.sdk;

import android.telephony.TelephonyManager;

/* renamed from: com.flurry.sdk.x0 */
public class C0306x0 {

    /* renamed from: a */
    private static C0306x0 f839a;

    private C0306x0() {
    }

    /* renamed from: a */
    public static synchronized C0306x0 m832a() {
        C0306x0 x0Var;
        synchronized (C0306x0.class) {
            if (f839a == null) {
                f839a = new C0306x0();
            }
            x0Var = f839a;
        }
        return x0Var;
    }

    /* renamed from: b */
    public static String m833b() {
        TelephonyManager telephonyManager = (TelephonyManager) C0118e1.m386a().f361a.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getNetworkOperatorName();
    }

    /* renamed from: c */
    public static String m834c() {
        TelephonyManager telephonyManager = (TelephonyManager) C0118e1.m386a().f361a.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getNetworkOperator();
    }
}
