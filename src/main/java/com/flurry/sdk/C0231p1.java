package com.flurry.sdk;

import java.lang.ref.WeakReference;
import java.util.concurrent.FutureTask;

/* renamed from: com.flurry.sdk.p1 */
public final class C0231p1<V> extends FutureTask<V> {

    /* renamed from: a */
    private final WeakReference<Runnable> f674a;

    public C0231p1(Runnable runnable, V v) {
        super(runnable, v);
        new WeakReference(null);
        this.f674a = new WeakReference<>(runnable);
    }

    /* renamed from: a */
    public final Runnable mo307a() {
        return this.f674a.get();
    }
}
