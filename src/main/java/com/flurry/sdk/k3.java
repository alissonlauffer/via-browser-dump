package com.flurry.sdk;

public class k3 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f151a = "k3";
    private static boolean b;

    public static synchronized void a() {
        synchronized (k3.class) {
            if (!b) {
                u1.b(q0.class);
                try {
                    u1.b(z3.class);
                } catch (NoClassDefFoundError unused) {
                    s1.a(3, f151a, "Analytics module not available");
                }
                try {
                    u1.b(h3.class);
                } catch (NoClassDefFoundError unused2) {
                    s1.a(3, f151a, "Crash module not available");
                }
                try {
                    u1.b(Class.forName("com.flurry.android.bridge.FlurryBridgeModule"));
                } catch (ClassNotFoundException | NoClassDefFoundError unused3) {
                    s1.a(3, f151a, "Ads module not available");
                }
                b = true;
            }
        }
    }
}
