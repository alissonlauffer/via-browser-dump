package com.flurry.sdk;

import java.lang.ref.WeakReference;
import java.util.concurrent.FutureTask;

public final class p1<V> extends FutureTask<V> {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Runnable> f175a;

    public p1(Runnable runnable, V v) {
        super(runnable, v);
        new WeakReference(null);
        this.f175a = new WeakReference<>(runnable);
    }

    public final Runnable a() {
        return this.f175a.get();
    }
}
