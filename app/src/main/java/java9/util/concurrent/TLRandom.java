package java9.util.concurrent;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import sun.misc.Unsafe;

/* access modifiers changed from: package-private */
/* renamed from: java9.util.concurrent.d */
/* compiled from: TLRandom */
public final class TLRandom {

    /* renamed from: a */
    private static final Unsafe f1018a;

    /* renamed from: b */
    private static final boolean f1019b;

    /* renamed from: c */
    private static final boolean f1020c;

    /* renamed from: d */
    private static final long f1021d;

    /* renamed from: e */
    private static final long f1022e;

    /* renamed from: f */
    private static final long f1023f;

    /* renamed from: g */
    private static final long f1024g;

    /* renamed from: h */
    private static final ThreadLocal<C0358c> f1025h = new C0356a();

    /* renamed from: i */
    private static final AtomicInteger f1026i = new AtomicInteger();

    /* renamed from: j */
    private static final AtomicLong f1027j = new AtomicLong(m1094k(System.currentTimeMillis()) ^ m1094k(System.nanoTime()));

    /* renamed from: java9.util.concurrent.d$a */
    /* compiled from: TLRandom */
    static class C0356a extends ThreadLocal<C0358c> {
        C0356a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C0358c initialValue() {
            return new C0358c(null);
        }
    }

    /* renamed from: java9.util.concurrent.d$b */
    /* compiled from: TLRandom */
    static class C0357b implements PrivilegedAction<Boolean> {
        C0357b() {
        }

        /* renamed from: a */
        public Boolean run() {
            return Boolean.valueOf(Boolean.getBoolean("java.util.secureRandomSeed"));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: java9.util.concurrent.d$c */
    /* compiled from: TLRandom */
    public static final class C0358c {

        /* renamed from: a */
        long f1028a;

        /* renamed from: b */
        int f1029b;

        /* renamed from: c */
        int f1030c;

        private C0358c() {
        }

        /* synthetic */ C0358c(C0356a aVar) {
            this();
        }
    }

    static {
        Unsafe unsafe = UnsafeAccess.f1031a;
        f1018a = unsafe;
        try {
            boolean h = m1091h();
            f1019b = h;
            boolean f = m1089f();
            f1020c = f;
            if (!f) {
                f1021d = unsafe.objectFieldOffset(Thread.class.getDeclaredField("threadLocals"));
                f1022e = unsafe.objectFieldOffset(Thread.class.getDeclaredField("inheritableThreadLocals"));
                f1023f = unsafe.objectFieldOffset(Thread.class.getDeclaredField(h ? "accessControlContext" : "inheritedAccessControlContext"));
                f1024g = unsafe.objectFieldOffset(Thread.class.getDeclaredField("contextClassLoader"));
            } else {
                f1021d = 0;
                f1022e = 0;
                f1023f = 0;
                f1024g = 0;
            }
            if (((Boolean) AccessController.doPrivileged(new C0357b())).booleanValue()) {
                byte[] seed = SecureRandom.getSeed(8);
                long j = ((long) seed[0]) & 255;
                for (int i = 1; i < 8; i++) {
                    j = (j << 8) | (((long) seed[i]) & 255);
                }
                f1027j.set(j);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private TLRandom() {
    }

    /* renamed from: a */
    static final int m1084a(int i) {
        int i2 = i ^ (i << 13);
        int i3 = i2 ^ (i2 >>> 17);
        int i4 = i3 ^ (i3 << 5);
        m1098o(i4);
        return i4;
    }

    /* renamed from: b */
    static final void m1085b(Thread thread) {
        if (!f1020c) {
            Unsafe unsafe = f1018a;
            unsafe.putObject(thread, f1021d, (Object) null);
            unsafe.putObject(thread, f1022e, (Object) null);
        }
    }

    /* renamed from: c */
    static final int m1086c() {
        return m1087d();
    }

    /* renamed from: d */
    static int m1087d() {
        return f1025h.get().f1029b;
    }

    /* renamed from: e */
    private static int m1088e() {
        return f1025h.get().f1030c;
    }

    /* renamed from: f */
    private static boolean m1089f() {
        if (m1090g("android.util.DisplayMetrics")) {
            return true;
        }
        return m1090g("org.robovm.rt.bro.Bro");
    }

    /* renamed from: g */
    private static boolean m1090g(String str) {
        Class<?> cls;
        try {
            cls = Class.forName(str, false, TLRandom.class.getClassLoader());
        } catch (Throwable unused) {
            cls = null;
        }
        return cls != null;
    }

    /* renamed from: h */
    private static boolean m1091h() {
        String property;
        if (!m1090g("com.ibm.misc.JarVersion") || (property = System.getProperty("java.class.version", "45")) == null || property.length() < 2 || "52".compareTo(property.substring(0, 2)) <= 0) {
            return false;
        }
        return true;
    }

    /* renamed from: i */
    static final void m1092i() {
        int addAndGet = f1026i.addAndGet(-1640531527);
        if (addAndGet == 0) {
            addAndGet = 1;
        }
        m1100q(m1094k(f1027j.getAndAdd(-4942790177534073029L)));
        m1098o(addAndGet);
    }

    /* renamed from: j */
    static int m1093j(long j) {
        long j2 = (j ^ (j >>> 33)) * -49064778989728563L;
        return (int) (((j2 ^ (j2 >>> 33)) * -4265267296055464877L) >>> 32);
    }

    /* renamed from: k */
    static long m1094k(long j) {
        long j2 = (j ^ (j >>> 33)) * -49064778989728563L;
        long j3 = (j2 ^ (j2 >>> 33)) * -4265267296055464877L;
        return j3 ^ (j3 >>> 33);
    }

    /* renamed from: l */
    static final int m1095l() {
        int i;
        int e = m1088e();
        if (e != 0) {
            int i2 = e ^ (e << 13);
            int i3 = i2 ^ (i2 >>> 17);
            i = i3 ^ (i3 << 5);
        } else {
            i = m1093j(f1027j.getAndAdd(-4942790177534073029L));
            if (i == 0) {
                i = 1;
            }
        }
        m1099p(i);
        return i;
    }

    /* renamed from: m */
    static final void m1096m(Thread thread, ClassLoader classLoader) {
        if (!f1020c) {
            f1018a.putObject(thread, f1024g, classLoader);
        }
    }

    /* renamed from: n */
    static final void m1097n(Thread thread, AccessControlContext accessControlContext) {
        if (!f1020c) {
            f1018a.putOrderedObject(thread, f1023f, accessControlContext);
        }
    }

    /* renamed from: o */
    private static void m1098o(int i) {
        f1025h.get().f1029b = i;
    }

    /* renamed from: p */
    private static void m1099p(int i) {
        f1025h.get().f1030c = i;
    }

    /* renamed from: q */
    private static void m1100q(long j) {
        f1025h.get().f1028a = j;
    }
}
