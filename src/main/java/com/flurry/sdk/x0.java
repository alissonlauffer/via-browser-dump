package com.flurry.sdk;

import android.telephony.TelephonyManager;

public class x0 {

    /* renamed from: a  reason: collision with root package name */
    private static x0 f216a;

    private x0() {
    }

    public static synchronized x0 a() {
        x0 x0Var;
        synchronized (x0.class) {
            if (f216a == null) {
                f216a = new x0();
            }
            x0Var = f216a;
        }
        return x0Var;
    }

    public static String b() {
        TelephonyManager telephonyManager = (TelephonyManager) e1.a().f110a.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getNetworkOperatorName();
    }

    public static String c() {
        TelephonyManager telephonyManager = (TelephonyManager) e1.a().f110a.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getNetworkOperator();
    }
}
