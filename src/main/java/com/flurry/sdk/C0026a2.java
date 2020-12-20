package com.flurry.sdk;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* renamed from: com.flurry.sdk.a2 */
public final class C0026a2<T> extends WeakReference<T> {
    public C0026a2(T t) {
        super(t);
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        T t = get();
        if (obj instanceof Reference) {
            return t.equals(((Reference) obj).get());
        }
        return t.equals(obj);
    }

    @Override // java.lang.Object
    public final int hashCode() {
        T t = get();
        if (t == null) {
            return super.hashCode();
        }
        return t.hashCode();
    }
}
