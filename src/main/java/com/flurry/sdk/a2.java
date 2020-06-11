package com.flurry.sdk;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class a2<T> extends WeakReference<T> {
    public a2(T t) {
        super(t);
    }

    public final boolean equals(Object obj) {
        T t = get();
        if (obj instanceof Reference) {
            return t.equals(((Reference) obj).get());
        }
        return t.equals(obj);
    }

    public final int hashCode() {
        T t = get();
        if (t == null) {
            return super.hashCode();
        }
        return t.hashCode();
    }
}
