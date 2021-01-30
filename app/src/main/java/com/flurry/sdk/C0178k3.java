package com.flurry.sdk;

/* renamed from: com.flurry.sdk.k3 */
public class C0178k3 {

    /* renamed from: a */
    private static final String f527a = "k3";

    /* renamed from: b */
    private static boolean f528b;

    /* renamed from: a */
    public static synchronized void m506a() {
        synchronized (C0178k3.class) {
            if (!f528b) {
                C0274u1.m719c(C0235q0.class);
                try {
                    C0274u1.m719c(C0329z3.class);
                } catch (NoClassDefFoundError unused) {
                    C0260s1.m686c(3, f527a, "Analytics module not available");
                }
                try {
                    C0274u1.m719c(C0159h3.class);
                } catch (NoClassDefFoundError unused2) {
                    C0260s1.m686c(3, f527a, "Crash module not available");
                }
                try {
                    C0274u1.m719c(Class.forName("com.flurry.android.bridge.FlurryBridgeModule"));
                } catch (ClassNotFoundException | NoClassDefFoundError unused3) {
                    C0260s1.m686c(3, f527a, "Ads module not available");
                }
                f528b = true;
            }
        }
    }
}
