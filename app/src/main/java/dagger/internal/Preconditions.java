package dagger.internal;

/* renamed from: b.a.b */
/* compiled from: Preconditions */
public final class Preconditions {
    /* renamed from: a */
    public static <T> void m122a(T t, Class<T> cls) {
        if (t == null) {
            throw new IllegalStateException(cls.getCanonicalName() + " must be set");
        }
    }

    /* renamed from: b */
    public static <T> T m123b(T t) {
        t.getClass();
        return t;
    }

    /* renamed from: c */
    public static <T> T m124c(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
