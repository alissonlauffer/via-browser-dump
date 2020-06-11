package dagger.internal;

import p014d.p015a.Provider;

/* renamed from: b.a.a */
/* compiled from: DoubleCheck */
public final class DoubleCheck<T> implements Provider<T> {

    /* renamed from: c */
    private static final Object f39c = new Object();

    /* renamed from: a */
    private volatile Provider<T> f40a;

    /* renamed from: b */
    private volatile Object f41b = f39c;

    private DoubleCheck(Provider<T> aVar) {
        this.f40a = aVar;
    }

    /* renamed from: a */
    public static <P extends Provider<T>, T> Provider<T> m120a(P p) {
        Preconditions.m123b(p);
        if (p instanceof DoubleCheck) {
            return p;
        }
        return new DoubleCheck(p);
    }

    /* renamed from: b */
    public static Object m121b(Object obj, Object obj2) {
        if (!(obj != f39c) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // p014d.p015a.Provider
    public T get() {
        T t = (T) this.f41b;
        Object obj = f39c;
        if (t == obj) {
            synchronized (this) {
                t = this.f41b;
                if (t == obj) {
                    t = this.f40a.get();
                    m121b(this.f41b, t);
                    this.f41b = t;
                    this.f40a = null;
                }
            }
        }
        return t;
    }
}
