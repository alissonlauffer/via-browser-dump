package com.flurry.sdk;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.flurry.sdk.d1 */
public final class C0098d1 extends C0236q1<C0108dk> {

    /* renamed from: f */
    private static C0098d1 f301f;

    protected C0098d1() {
        super(C0098d1.class.getName(), TimeUnit.MILLISECONDS, new PriorityBlockingQueue(11, new C0224o1()));
    }

    /* renamed from: j */
    public static synchronized C0098d1 m348j() {
        C0098d1 d1Var;
        synchronized (C0098d1.class) {
            if (f301f == null) {
                f301f = new C0098d1();
            }
            d1Var = f301f;
        }
        return d1Var;
    }
}
