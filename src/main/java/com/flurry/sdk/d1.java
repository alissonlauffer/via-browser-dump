package com.flurry.sdk;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class d1 extends q1<dk> {
    private static d1 f;

    protected d1() {
        super(d1.class.getName(), TimeUnit.MILLISECONDS, new PriorityBlockingQueue(11, new o1()));
    }

    public static synchronized d1 a() {
        d1 d1Var;
        synchronized (d1.class) {
            if (f == null) {
                f = new d1();
            }
            d1Var = f;
        }
        return d1Var;
    }
}
