package java9.util.concurrent;

import java.lang.Thread;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.Permission;
import java.security.Permissions;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java9.util.concurrent.ForkJoinTask;
import java9.util.concurrent.ForkJoinWorkerThread;
import p011c.p012a.Objects;
import p011c.p012a.p013b.Predicate;
import sun.misc.Unsafe;

/* renamed from: java9.util.concurrent.a */
/* compiled from: ForkJoinPool */
public class ForkJoinPool extends AbstractExecutorService {

    /* renamed from: l */
    public static final AbstractC0348c f969l;

    /* renamed from: m */
    static final RuntimePermission f970m = new RuntimePermission("modifyThread");

    /* renamed from: n */
    static final ForkJoinPool f971n;

    /* renamed from: o */
    static final int f972o;

    /* renamed from: p */
    private static final int f973p;

    /* renamed from: q */
    private static int f974q;

    /* renamed from: r */
    private static final Unsafe f975r;

    /* renamed from: s */
    private static final long f976s;

    /* renamed from: t */
    private static final long f977t;

    /* renamed from: u */
    private static final int f978u;

    /* renamed from: v */
    private static final int f979v;

    /* renamed from: w */
    private static final Class<?> f980w;

    /* renamed from: a */
    volatile long f981a;

    /* renamed from: b */
    volatile long f982b;

    /* renamed from: c */
    final long f983c;

    /* renamed from: d */
    int f984d;

    /* renamed from: e */
    final int f985e;

    /* renamed from: f */
    volatile int f986f;

    /* renamed from: g */
    C0353g[] f987g;

    /* renamed from: h */
    final String f988h;

    /* renamed from: i */
    final AbstractC0348c f989i;

    /* renamed from: j */
    final Thread.UncaughtExceptionHandler f990j;

    /* renamed from: k */
    final Predicate<? super ForkJoinPool> f991k;

    /* renamed from: java9.util.concurrent.a$a */
    /* compiled from: ForkJoinPool */
    static class C0345a implements PrivilegedAction<ForkJoinPool> {
        C0345a() {
        }

        /* renamed from: a */
        public ForkJoinPool run() {
            return new ForkJoinPool((byte) 0, null);
        }
    }

    /* renamed from: java9.util.concurrent.a$b */
    /* compiled from: ForkJoinPool */
    private static final class C0346b implements AbstractC0348c {

        /* renamed from: a */
        private static final AccessControlContext f992a = ForkJoinPool.m1024f(new RuntimePermission("getClassLoader"));

        /* renamed from: java9.util.concurrent.a$b$a */
        /* compiled from: ForkJoinPool */
        class C0347a implements PrivilegedAction<ForkJoinWorkerThread> {

            /* renamed from: a */
            final /* synthetic */ ForkJoinPool f993a;

            C0347a(C0346b bVar, ForkJoinPool aVar) {
                this.f993a = aVar;
            }

            /* renamed from: a */
            public ForkJoinWorkerThread run() {
                return new ForkJoinWorkerThread(this.f993a, ClassLoader.getSystemClassLoader());
            }
        }

        private C0346b() {
        }

        @Override // java9.util.concurrent.ForkJoinPool.AbstractC0348c
        /* renamed from: a */
        public final ForkJoinWorkerThread mo549a(ForkJoinPool aVar) {
            return (ForkJoinWorkerThread) AccessController.doPrivileged(new C0347a(this, aVar), f992a);
        }

        /* synthetic */ C0346b(C0345a aVar) {
            this();
        }
    }

    /* renamed from: java9.util.concurrent.a$c */
    /* compiled from: ForkJoinPool */
    public interface AbstractC0348c {
        /* renamed from: a */
        ForkJoinWorkerThread mo549a(ForkJoinPool aVar);
    }

    /* renamed from: java9.util.concurrent.a$d */
    /* compiled from: ForkJoinPool */
    private static final class C0349d implements AbstractC0348c {

        /* renamed from: a */
        private static final AccessControlContext f994a = ForkJoinPool.m1024f(ForkJoinPool.f970m, new RuntimePermission("enableContextClassLoaderOverride"), new RuntimePermission("modifyThreadGroup"), new RuntimePermission("getClassLoader"), new RuntimePermission("setContextClassLoader"));

        /* renamed from: java9.util.concurrent.a$d$a */
        /* compiled from: ForkJoinPool */
        class C0350a implements PrivilegedAction<ForkJoinWorkerThread> {

            /* renamed from: a */
            final /* synthetic */ ForkJoinPool f995a;

            C0350a(C0349d dVar, ForkJoinPool aVar) {
                this.f995a = aVar;
            }

            /* renamed from: a */
            public ForkJoinWorkerThread run() {
                return new ForkJoinWorkerThread.C0354a(this.f995a);
            }
        }

        private C0349d() {
        }

        @Override // java9.util.concurrent.ForkJoinPool.AbstractC0348c
        /* renamed from: a */
        public final ForkJoinWorkerThread mo549a(ForkJoinPool aVar) {
            return (ForkJoinWorkerThread) AccessController.doPrivileged(new C0350a(this, aVar), f994a);
        }

        /* synthetic */ C0349d(C0345a aVar) {
            this();
        }
    }

    /* renamed from: java9.util.concurrent.a$e */
    /* compiled from: ForkJoinPool */
    public interface AbstractC0351e {
        boolean block();

        boolean isReleasable();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: java9.util.concurrent.a$f */
    /* compiled from: ForkJoinPool */
    public static final class C0352f {

        /* renamed from: a */
        private static final Mock f996a = new Mock();

        /* renamed from: b */
        private static final Unsafe f997b;

        /* renamed from: c */
        private static final long f998c;

        static {
            Unsafe unsafe = UnsafeAccess.f1031a;
            f997b = unsafe;
            try {
                f998c = unsafe.objectFieldOffset(Mock.class.getDeclaredField("a"));
            } catch (Exception e) {
                throw new ExceptionInInitializerError(e);
            }
        }

        /* renamed from: a */
        static void m1060a() {
            f997b.putIntVolatile(f996a, f998c, 0);
        }

        /* renamed from: b */
        static void m1061b() {
            f997b.putOrderedInt(f996a, f998c, 0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: java9.util.concurrent.a$g */
    /* compiled from: ForkJoinPool */
    public static final class C0353g {

        /* renamed from: k */
        private static final Unsafe f999k;

        /* renamed from: l */
        private static final long f1000l;

        /* renamed from: m */
        private static final int f1001m;

        /* renamed from: n */
        private static final int f1002n;

        /* renamed from: a */
        volatile int f1003a;

        /* renamed from: b */
        int f1004b;

        /* renamed from: c */
        int f1005c;

        /* renamed from: d */
        int f1006d;

        /* renamed from: e */
        volatile int f1007e;

        /* renamed from: f */
        volatile int f1008f = 4096;

        /* renamed from: g */
        int f1009g = 4096;

        /* renamed from: h */
        ForkJoinTask<?>[] f1010h;

        /* renamed from: i */
        final ForkJoinPool f1011i;

        /* renamed from: j */
        final ForkJoinWorkerThread f1012j;

        static {
            Unsafe unsafe = UnsafeAccess.f1031a;
            f999k = unsafe;
            try {
                f1000l = unsafe.objectFieldOffset(C0353g.class.getDeclaredField("a"));
                f1001m = unsafe.arrayBaseOffset(ForkJoinTask[].class);
                int arrayIndexScale = unsafe.arrayIndexScale(ForkJoinTask[].class);
                if (((arrayIndexScale - 1) & arrayIndexScale) == 0) {
                    f1002n = 31 - Integer.numberOfLeadingZeros(arrayIndexScale);
                    return;
                }
                throw new ExceptionInInitializerError("array index scale not a power of two");
            } catch (Exception e) {
                throw new ExceptionInInitializerError(e);
            }
        }

        C0353g(ForkJoinPool aVar, ForkJoinWorkerThread bVar) {
            this.f1011i = aVar;
            this.f1012j = bVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public final void mo554a() {
            while (true) {
                ForkJoinTask<?> i = mo562i();
                if (i != null) {
                    ForkJoinTask.cancelIgnoringExceptions(i);
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public final ForkJoinTask<?>[] mo555b() {
            int i;
            ForkJoinTask<?>[] forkJoinTaskArr = this.f1010h;
            int length = forkJoinTaskArr != null ? forkJoinTaskArr.length : 0;
            int i2 = length > 0 ? length << 1 : 8192;
            if (i2 < 8192 || i2 > 67108864) {
                throw new RejectedExecutionException("Queue capacity exceeded");
            }
            ForkJoinTask<?>[] forkJoinTaskArr2 = new ForkJoinTask[i2];
            this.f1010h = forkJoinTaskArr2;
            if (forkJoinTaskArr != null && length - 1 > 0) {
                int i3 = this.f1009g;
                int i4 = this.f1008f;
                if (i3 - i4 > 0) {
                    int i5 = i2 - 1;
                    int i6 = i4;
                    do {
                        long j = ((long) f1001m) + (((long) (i6 & i)) << f1002n);
                        Unsafe unsafe = f999k;
                        ForkJoinTask<?> forkJoinTask = (ForkJoinTask) unsafe.getObjectVolatile(forkJoinTaskArr, j);
                        if (forkJoinTask != null && unsafe.compareAndSwapObject(forkJoinTaskArr, j, forkJoinTask, (Object) null)) {
                            forkJoinTaskArr2[i6 & i5] = forkJoinTask;
                        }
                        i6++;
                    } while (i6 != i3);
                    C0352f.m1061b();
                }
            }
            return forkJoinTaskArr2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public final boolean mo556c() {
            Thread.State state;
            ForkJoinWorkerThread bVar = this.f1012j;
            return (bVar == null || (state = bVar.getState()) == Thread.State.BLOCKED || state == Thread.State.WAITING || state == Thread.State.TIMED_WAITING) ? false : true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public final int mo557d(CountedCompleter<?> countedCompleter, int i) {
            boolean z;
            int i2;
            int length;
            if (countedCompleter == null) {
                return 0;
            }
            int i3 = countedCompleter.status;
            if (i3 < 0) {
                return i3;
            }
            while (true) {
                int i4 = this.f1008f;
                int i5 = this.f1009g;
                ForkJoinTask<?>[] forkJoinTaskArr = this.f1010h;
                if (forkJoinTaskArr != null && i4 != i5 && (length = forkJoinTaskArr.length) > 0) {
                    int i6 = i5 - 1;
                    long j = (((long) ((length - 1) & i6)) << f1002n) + ((long) f1001m);
                    ForkJoinTask forkJoinTask = (ForkJoinTask) f999k.getObject(forkJoinTaskArr, j);
                    if (forkJoinTask instanceof CountedCompleter) {
                        CountedCompleter<?> countedCompleter2 = (CountedCompleter) forkJoinTask;
                        CountedCompleter<?> countedCompleter3 = countedCompleter2;
                        while (true) {
                            if (countedCompleter3 != countedCompleter) {
                                countedCompleter3 = countedCompleter3.completer;
                                if (countedCompleter3 == null) {
                                    break;
                                }
                            } else if (f999k.compareAndSwapObject(forkJoinTaskArr, j, countedCompleter2, (Object) null)) {
                                this.f1009g = i6;
                                C0352f.m1061b();
                                countedCompleter2.doExec();
                                z = true;
                            }
                        }
                    }
                }
                z = false;
                i2 = countedCompleter.status;
                if (i2 < 0 || !z || (i != 0 && i - 1 == 0)) {
                    break;
                }
            }
            return i2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public final void mo558e(int i) {
            int i2;
            int length;
            do {
                int i3 = 0;
                while (true) {
                    int i4 = this.f1008f;
                    int i5 = this.f1009g;
                    ForkJoinTask<?>[] forkJoinTaskArr = this.f1010h;
                    if (forkJoinTaskArr != null && (i2 = i4 - i5) < 0 && (length = forkJoinTaskArr.length) > 0) {
                        int i6 = i4 + 1;
                        ForkJoinTask forkJoinTask = (ForkJoinTask) ForkJoinPool.m1028m(forkJoinTaskArr, (((long) (i4 & (length - 1))) << f1002n) + ((long) f1001m), null);
                        if (forkJoinTask != null) {
                            this.f1008f = i6;
                            forkJoinTask.doExec();
                            if (i != 0 && (i3 = i3 + 1) == i) {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            } while (i2 != -1);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f */
        public final void mo559f(int i) {
            int length;
            while (true) {
                int i2 = this.f1008f;
                int i3 = this.f1009g;
                ForkJoinTask<?>[] forkJoinTaskArr = this.f1010h;
                if (forkJoinTaskArr != null && i2 != i3 && (length = forkJoinTaskArr.length) > 0) {
                    int i4 = i3 - 1;
                    ForkJoinTask forkJoinTask = (ForkJoinTask) ForkJoinPool.m1028m(forkJoinTaskArr, (((long) ((length - 1) & i4)) << f1002n) + ((long) f1001m), null);
                    if (forkJoinTask != null) {
                        this.f1009g = i4;
                        C0352f.m1061b();
                        forkJoinTask.doExec();
                        if (i != 0 && i - 1 == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public final ForkJoinTask<?> mo560g() {
            return (this.f1006d & 65536) != 0 ? mo562i() : mo563j();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: h */
        public final ForkJoinTask<?> mo561h() {
            int length;
            ForkJoinTask<?>[] forkJoinTaskArr = this.f1010h;
            if (forkJoinTaskArr == null || (length = forkJoinTaskArr.length) <= 0) {
                return null;
            }
            return forkJoinTaskArr[(length - 1) & ((this.f1006d & 65536) != 0 ? this.f1008f : this.f1009g - 1)];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i */
        public final ForkJoinTask<?> mo562i() {
            int i;
            int length;
            while (true) {
                int i2 = this.f1008f;
                int i3 = this.f1009g;
                ForkJoinTask<?>[] forkJoinTaskArr = this.f1010h;
                if (forkJoinTaskArr == null || (i = i2 - i3) >= 0 || (length = forkJoinTaskArr.length) <= 0) {
                    return null;
                }
                long j = (((long) ((length - 1) & i2)) << f1002n) + ((long) f1001m);
                Unsafe unsafe = f999k;
                ForkJoinTask<?> forkJoinTask = (ForkJoinTask) unsafe.getObjectVolatile(forkJoinTaskArr, j);
                int i4 = i2 + 1;
                if (i2 == this.f1008f) {
                    if (forkJoinTask != null) {
                        if (unsafe.compareAndSwapObject(forkJoinTaskArr, j, forkJoinTask, (Object) null)) {
                            this.f1008f = i4;
                            return forkJoinTask;
                        }
                    } else if (i == -1) {
                        return null;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public final ForkJoinTask<?> mo563j() {
            int length;
            int i = this.f1008f;
            int i2 = this.f1009g;
            ForkJoinTask<?>[] forkJoinTaskArr = this.f1010h;
            if (forkJoinTaskArr == null || i == i2 || (length = forkJoinTaskArr.length) <= 0) {
                return null;
            }
            int i3 = i2 - 1;
            long j = (((long) ((length - 1) & i3)) << f1002n) + ((long) f1001m);
            Unsafe unsafe = f999k;
            ForkJoinTask<?> forkJoinTask = (ForkJoinTask) unsafe.getObject(forkJoinTaskArr, j);
            if (forkJoinTask == null || !unsafe.compareAndSwapObject(forkJoinTaskArr, j, forkJoinTask, (Object) null)) {
                return null;
            }
            this.f1009g = i3;
            C0352f.m1061b();
            return forkJoinTask;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public final void mo564k(ForkJoinTask<?> forkJoinTask) {
            int length;
            int i = this.f1009g;
            ForkJoinTask<?>[] forkJoinTaskArr = this.f1010h;
            if (forkJoinTaskArr != null && (length = forkJoinTaskArr.length) > 0) {
                long j = (((long) ((length - 1) & i)) << f1002n) + ((long) f1001m);
                ForkJoinPool aVar = this.f1011i;
                this.f1009g = i + 1;
                f999k.putOrderedObject(forkJoinTaskArr, j, forkJoinTask);
                int i2 = this.f1008f - i;
                if (i2 == 0 && aVar != null) {
                    C0352f.m1060a();
                    aVar.mo519D();
                } else if (i2 + length == 1) {
                    mo555b();
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: l */
        public final int mo565l() {
            int i = this.f1008f - this.f1009g;
            if (i >= 0) {
                return 0;
            }
            return -i;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            r15 = r10 - 1;
            r13 = (((long) ((r0 - 1) & r15)) << java9.util.concurrent.ForkJoinPool.C0353g.f1002n) + ((long) java9.util.concurrent.ForkJoinPool.C0353g.f1001m);
            r0 = (java9.util.concurrent.ForkJoinTask) java9.util.concurrent.ForkJoinPool.C0353g.f999k.getObject(r12, r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
            if ((r0 instanceof java9.util.concurrent.CountedCompleter) == false) goto L_0x007d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
            r17 = (java9.util.concurrent.CountedCompleter) r0;
            r0 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
            if (r0 == r20) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
            r0 = r0.completer;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
            if (r0 != null) goto L_0x0039;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
            r11 = java9.util.concurrent.ForkJoinPool.C0353g.f999k;
            r4 = java9.util.concurrent.ForkJoinPool.C0353g.f1000l;
            r21 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0057, code lost:
            if (r11.compareAndSwapInt(r19, r4, 0, 1) == false) goto L_0x007f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x005b, code lost:
            if (r19.f1009g != r10) goto L_0x0071;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x005f, code lost:
            if (r19.f1010h != r12) goto L_0x0071;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0061, code lost:
            r0 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x006b, code lost:
            if (r11.compareAndSwapObject(r12, r13, r17, (java.lang.Object) null) == false) goto L_0x0072;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x006d, code lost:
            r19.f1009g = r15;
            r1 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0071, code lost:
            r0 = r11;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0072, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0073, code lost:
            r0.putOrderedInt(r19, r4, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0077, code lost:
            if (r1 == false) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0079, code lost:
            r17.doExec();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x007d, code lost:
            r21 = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x007f, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0081, code lost:
            r0 = r20.status;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0083, code lost:
            if (r0 < 0) goto L_0x008d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0085, code lost:
            if (r1 == false) goto L_0x008d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0087, code lost:
            if (r21 == 0) goto L_0x000a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0089, code lost:
            r9 = r21 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x008b, code lost:
            if (r9 != 0) goto L_0x000c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
            if (r0 >= 0) goto L_0x000a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            r9 = r21;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
            r0 = r19.f1008f;
            r10 = r19.f1009g;
            r12 = r19.f1010h;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
            if (r12 == null) goto L_0x007d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0014, code lost:
            if (r0 == r10) goto L_0x007d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
            r0 = r12.length;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r0 <= 0) goto L_0x007d;
         */
        /* renamed from: m */
        public final int mo566m(CountedCompleter<?> countedCompleter, int i) {
            if (countedCompleter == null) {
                return 0;
            }
            int i2 = countedCompleter.status;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public final boolean mo567n() {
            return f999k.compareAndSwapInt(this, f1000l, 0, 1);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public final void mo568o(ForkJoinTask<?> forkJoinTask) {
            ForkJoinTask<?>[] forkJoinTaskArr;
            int length;
            int i = this.f1008f;
            int i2 = this.f1009g;
            if (i - i2 < 0 && (forkJoinTaskArr = this.f1010h) != null && (length = forkJoinTaskArr.length) > 0) {
                int i3 = length - 1;
                int i4 = i2 - 1;
                int i5 = i4;
                while (true) {
                    long j = (long) (((i5 & i3) << f1002n) + f1001m);
                    Unsafe unsafe = f999k;
                    ForkJoinTask<?> forkJoinTask2 = (ForkJoinTask) unsafe.getObject(forkJoinTaskArr, j);
                    if (forkJoinTask2 != null) {
                        if (forkJoinTask2 != forkJoinTask) {
                            i5--;
                        } else if (unsafe.compareAndSwapObject(forkJoinTaskArr, j, forkJoinTask2, (Object) null)) {
                            this.f1009g = i4;
                            while (i5 != i4) {
                                int i6 = i5 + 1;
                                int i7 = f1002n;
                                int i8 = f1001m;
                                long j2 = (long) (((i6 & i3) << i7) + i8);
                                Unsafe unsafe2 = f999k;
                                unsafe2.putObjectVolatile(forkJoinTaskArr, j2, (Object) null);
                                unsafe2.putOrderedObject(forkJoinTaskArr, (long) (((i5 & i3) << i7) + i8), (ForkJoinTask) unsafe2.getObject(forkJoinTaskArr, j2));
                                i5 = i6;
                            }
                            C0352f.m1061b();
                            forkJoinTask2.doExec();
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: p */
        public final boolean mo569p(ForkJoinTask<?> forkJoinTask) {
            int length;
            long j;
            boolean z = true;
            int i = this.f1009g - 1;
            ForkJoinTask<?>[] forkJoinTaskArr = this.f1010h;
            if (forkJoinTaskArr == null || (length = forkJoinTaskArr.length) <= 0) {
                return false;
            }
            long j2 = (((long) ((length - 1) & i)) << f1002n) + ((long) f1001m);
            Unsafe unsafe = f999k;
            if (((ForkJoinTask) unsafe.getObject(forkJoinTaskArr, j2)) != forkJoinTask) {
                return false;
            }
            long j3 = f1000l;
            if (!unsafe.compareAndSwapInt(this, j3, 0, 1)) {
                return false;
            }
            if (this.f1009g == i + 1 && this.f1010h == forkJoinTaskArr && unsafe.compareAndSwapObject(forkJoinTaskArr, j2, forkJoinTask, (Object) null)) {
                this.f1009g = i;
                j = j3;
            } else {
                j = j3;
                z = false;
            }
            unsafe.putOrderedInt(this, j, 0);
            return z;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: q */
        public final boolean mo570q(ForkJoinTask<?> forkJoinTask) {
            int length;
            int i = this.f1008f;
            int i2 = this.f1009g;
            ForkJoinTask<?>[] forkJoinTaskArr = this.f1010h;
            if (forkJoinTaskArr == null || i == i2 || (length = forkJoinTaskArr.length) <= 0) {
                return false;
            }
            int i3 = i2 - 1;
            if (!f999k.compareAndSwapObject(forkJoinTaskArr, (((long) ((length - 1) & i3)) << f1002n) + ((long) f1001m), forkJoinTask, (Object) null)) {
                return false;
            }
            this.f1009g = i3;
            C0352f.m1061b();
            return true;
        }
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [java9.util.concurrent.a$a, java.lang.Class<?>] */
    static {
        Unsafe unsafe = UnsafeAccess.f1031a;
        f975r = unsafe;
        try {
            f976s = unsafe.objectFieldOffset(ForkJoinPool.class.getDeclaredField("a"));
            f977t = unsafe.objectFieldOffset(ForkJoinPool.class.getDeclaredField("f"));
            f978u = unsafe.arrayBaseOffset(ForkJoinTask[].class);
            int arrayIndexScale = unsafe.arrayIndexScale(ForkJoinTask[].class);
            if (((arrayIndexScale - 1) & arrayIndexScale) == 0) {
                f979v = 31 - Integer.numberOfLeadingZeros(arrayIndexScale);
                int i = 256;
                try {
                    String property = System.getProperty("java.util.concurrent.ForkJoinPool.common.maximumSpares");
                    if (property != null) {
                        i = Integer.parseInt(property);
                    }
                } catch (Exception unused) {
                }
                f973p = i;
                Class<?> cls = 0;
                f969l = new C0346b(cls);
                ForkJoinPool aVar = (ForkJoinPool) AccessController.doPrivileged(new C0345a());
                f971n = aVar;
                f972o = Math.max(aVar.f986f & 65535, 1);
                try {
                    cls = Class.forName("java9.util.concurrent.CompletableFuture$b");
                } catch (Exception unused2) {
                } finally {
                    f980w = cls;
                }
            } else {
                throw new ExceptionInInitializerError("array index scale not a power of two");
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /* synthetic */ ForkJoinPool(byte b, C0345a aVar) {
        this(b);
    }

    /* renamed from: A */
    static void m1017A() {
        f971n.mo526b(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }

    /* renamed from: H */
    private void m1018H(long j) {
        long j2 = j;
        do {
            long j3 = (-281474976710656L & (281474976710656L + j2)) | (281470681743360L & (4294967296L + j2));
            if (this.f981a != j2 || !f975r.compareAndSwapLong(this, f976s, j2, j3)) {
                j2 = this.f981a;
                if ((140737488355328L & j2) == 0) {
                    return;
                }
            } else {
                m1025g();
                return;
            }
        } while (((int) j2) == 0);
    }

    /* renamed from: I */
    private int m1019I(C0353g gVar) {
        int length;
        boolean z;
        Thread.State state;
        long j = this.f981a;
        C0353g[] gVarArr = this.f987g;
        short s = (short) ((int) (j >>> 32));
        if (s >= 0) {
            if (gVarArr == null || (length = gVarArr.length) <= 0 || gVar == null) {
                return 0;
            }
            int i = (int) j;
            if (i != 0) {
                C0353g gVar2 = gVarArr[i & (length - 1)];
                int i2 = gVar.f1003a;
                long j2 = -4294967296L & (i2 < 0 ? 281474976710656L + j : j);
                int i3 = i & Integer.MAX_VALUE;
                if (gVar2 == null) {
                    return 0;
                }
                int i4 = gVar2.f1003a;
                ForkJoinWorkerThread bVar = gVar2.f1012j;
                long j3 = (((long) gVar2.f1004b) & 4294967295L) | j2;
                if (i4 != i || !f975r.compareAndSwapLong(this, f976s, j, j3)) {
                    return 0;
                }
                gVar2.f1003a = i3;
                if (gVar2.f1007e < 0) {
                    LockSupport.unpark(bVar);
                }
                return i2 < 0 ? -1 : 1;
            } else if (((int) (j >> 48)) - ((short) (this.f985e & 65535)) > 0) {
                return f975r.compareAndSwapLong(this, f976s, j, (-281474976710656L & (j - 281474976710656L)) | (281474976710655L & j)) ? 1 : 0;
            } else {
                int i5 = this.f986f & 65535;
                int i6 = i5 + s;
                int i7 = i6;
                int i8 = 0;
                int i9 = 1;
                while (true) {
                    if (i9 >= length) {
                        z = false;
                        break;
                    }
                    C0353g gVar3 = gVarArr[i9];
                    if (gVar3 != null) {
                        if (gVar3.f1007e == 0) {
                            z = true;
                            break;
                        }
                        i7--;
                        ForkJoinWorkerThread bVar2 = gVar3.f1012j;
                        if (bVar2 != null && ((state = bVar2.getState()) == Thread.State.BLOCKED || state == Thread.State.WAITING)) {
                            i8++;
                        }
                    }
                    i9 += 2;
                }
                if (z || i7 != 0 || this.f981a != j) {
                    return 0;
                }
                if (i6 >= 32767 || s >= (this.f985e >>> 16)) {
                    Predicate<? super ForkJoinPool> aVar = this.f991k;
                    if (aVar != null && aVar.mo71a(this)) {
                        return -1;
                    }
                    if (i8 < i5) {
                        Thread.yield();
                        return 0;
                    }
                    throw new RejectedExecutionException("Thread limit exceeded replacing blocked worker");
                }
            }
        }
        if (!f975r.compareAndSwapLong(this, f976s, j, ((4294967296L + j) & 281470681743360L) | (-281470681743361L & j)) || !m1025g()) {
            return 0;
        }
        return 1;
    }

    /* renamed from: K */
    private boolean m1020K(boolean z, boolean z2) {
        int i;
        int i2;
        while (true) {
            int i3 = this.f986f;
            if ((i3 & 262144) != 0) {
                while (true) {
                    int i4 = this.f986f;
                    int i5 = 65535;
                    long j = 0;
                    int i6 = 1;
                    if ((i4 & Integer.MIN_VALUE) == 0) {
                        if (!z) {
                            while (true) {
                                long j2 = this.f981a;
                                C0353g[] gVarArr = this.f987g;
                                char c = '0';
                                if ((i4 & i5) + ((int) (j2 >> 48)) <= 0) {
                                    if (gVarArr != null) {
                                        int i7 = 0;
                                        while (true) {
                                            if (i7 >= gVarArr.length) {
                                                break;
                                            }
                                            C0353g gVar = gVarArr[i7];
                                            if (gVar != null) {
                                                int i8 = gVar.f1007e;
                                                int i9 = gVar.f1003a;
                                                int i10 = gVar.f1006d;
                                                int i11 = gVar.f1008f;
                                                if (i11 != gVar.f1009g || ((i10 & 1) == i6 && (i8 >= 0 || i9 >= 0))) {
                                                    break;
                                                }
                                                j2 += (((long) i8) << c) + (((long) i9) << 32) + (((long) i11) << 16) + ((long) i10);
                                            }
                                            i7++;
                                            c = '0';
                                            i6 = 1;
                                        }
                                        i6 = 1;
                                    }
                                    i6 = 0;
                                }
                                i4 = this.f986f;
                                if ((i4 & Integer.MIN_VALUE) != 0) {
                                    break;
                                } else if (i6 != 0) {
                                    return false;
                                } else {
                                    if (this.f987g == gVarArr) {
                                        if (j == j2) {
                                            break;
                                        }
                                        j = j2;
                                    }
                                    i5 = 65535;
                                    i6 = 1;
                                }
                            }
                        }
                        if ((i4 & Integer.MIN_VALUE) == 0) {
                            f975r.compareAndSwapInt(this, f977t, i4, i4 | Integer.MIN_VALUE);
                        }
                    } else {
                        while ((this.f986f & 524288) == 0) {
                            long j3 = 0;
                            while (true) {
                                long j4 = this.f981a;
                                C0353g[] gVarArr2 = this.f987g;
                                if (gVarArr2 != null) {
                                    for (C0353g gVar2 : gVarArr2) {
                                        if (gVar2 != null) {
                                            ForkJoinWorkerThread bVar = gVar2.f1012j;
                                            gVar2.mo554a();
                                            if (bVar != null) {
                                                try {
                                                    bVar.interrupt();
                                                } catch (Throwable unused) {
                                                }
                                            }
                                            j4 += (((long) gVar2.f1003a) << 32) + ((long) gVar2.f1008f);
                                        }
                                    }
                                }
                                i = this.f986f;
                                i2 = i & 524288;
                                if (i2 != 0) {
                                    break;
                                } else if (this.f987g == gVarArr2) {
                                    if (j3 == j4) {
                                        break;
                                    }
                                    j3 = j4;
                                }
                            }
                            if (i2 != 0 || (i & 65535) + ((short) ((int) (this.f981a >>> 32))) > 0) {
                                return true;
                            }
                            if (f975r.compareAndSwapInt(this, f977t, i, i | 524288)) {
                                synchronized (this) {
                                    notifyAll();
                                }
                                return true;
                            }
                        }
                        return true;
                    }
                }
            } else if (!z2 || this == f971n) {
                break;
            } else {
                f975r.compareAndSwapInt(this, f977t, i3, i3 | 262144);
            }
        }
        return false;
    }

    /* renamed from: c */
    private static void m1021c() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(f970m);
        }
    }

    /* renamed from: d */
    public static ForkJoinPool m1022d() {
        return f971n;
    }

    /* renamed from: e */
    static C0353g m1023e() {
        C0353g[] gVarArr;
        int length;
        ForkJoinPool aVar = f971n;
        int c = TLRandom.m1086c();
        if (aVar == null || (gVarArr = aVar.f987g) == null || (length = gVarArr.length) <= 0) {
            return null;
        }
        return gVarArr[c & (length - 1) & 126];
    }

    /* renamed from: f */
    static AccessControlContext m1024f(Permission... permissionArr) {
        Permissions permissions = new Permissions();
        for (Permission permission : permissionArr) {
            permissions.add(permission);
        }
        return new AccessControlContext(new ProtectionDomain[]{new ProtectionDomain(null, permissions)});
    }

    /* renamed from: g */
    private boolean m1025g() {
        ForkJoinWorkerThread bVar;
        AbstractC0348c cVar = this.f989i;
        Throwable th = null;
        if (cVar != null) {
            try {
                bVar = cVar.mo549a(this);
                if (bVar != null) {
                    try {
                        bVar.start();
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bVar = null;
            }
        } else {
            bVar = null;
        }
        mo528h(bVar, th);
        return false;
    }

    /* renamed from: k */
    private <T> ForkJoinTask<T> m1026k(ForkJoinTask<T> forkJoinTask) {
        C0353g gVar;
        Objects.m125a(forkJoinTask);
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread bVar = (ForkJoinWorkerThread) currentThread;
            if (bVar.f1013a == this && (gVar = bVar.f1014b) != null) {
                gVar.mo564k(forkJoinTask);
                return forkJoinTask;
            }
        }
        mo533j(forkJoinTask);
        return forkJoinTask;
    }

    /* renamed from: l */
    static long m1027l(Object obj, long j, long j2) {
        Unsafe unsafe;
        long longVolatile;
        do {
            unsafe = f975r;
            longVolatile = unsafe.getLongVolatile(obj, j);
        } while (!unsafe.compareAndSwapLong(obj, j, longVolatile, longVolatile + j2));
        return longVolatile;
    }

    /* renamed from: m */
    static Object m1028m(Object obj, long j, Object obj2) {
        Unsafe unsafe;
        Object objectVolatile;
        do {
            unsafe = f975r;
            objectVolatile = unsafe.getObjectVolatile(obj, j);
        } while (!unsafe.compareAndSwapObject(obj, j, objectVolatile, obj2));
        return objectVolatile;
    }

    /* renamed from: n */
    public static int m1029n() {
        return f972o;
    }

    /* renamed from: o */
    static int m1030o() {
        ForkJoinWorkerThread bVar;
        ForkJoinPool aVar;
        C0353g gVar;
        Thread currentThread = Thread.currentThread();
        int i = 0;
        if (!(currentThread instanceof ForkJoinWorkerThread) || (aVar = (bVar = (ForkJoinWorkerThread) currentThread).f1013a) == null || (gVar = bVar.f1014b) == null) {
            return 0;
        }
        int i2 = aVar.f986f & 65535;
        int i3 = ((int) (aVar.f981a >> 48)) + i2;
        int i4 = gVar.f1009g - gVar.f1008f;
        int i5 = i2 >>> 1;
        if (i3 <= i5) {
            int i6 = i5 >>> 1;
            if (i3 > i6) {
                i = 1;
            } else {
                int i7 = i6 >>> 1;
                i = i3 > i7 ? 2 : i3 > (i7 >>> 1) ? 4 : 8;
            }
        }
        return i4 - i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031 A[LOOP:0: B:17:0x0031->B:35:0x0031, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* renamed from: p */
    static void m1031p(Executor executor, AbstractC0351e eVar) {
        C0353g gVar;
        int i;
        int length;
        C0353g[] gVarArr;
        int length2;
        if (eVar != null && (executor instanceof ForkJoinPool)) {
            ForkJoinPool aVar = (ForkJoinPool) executor;
            Thread currentThread = Thread.currentThread();
            if (currentThread instanceof ForkJoinWorkerThread) {
                ForkJoinWorkerThread bVar = (ForkJoinWorkerThread) currentThread;
                if (bVar.f1013a == aVar) {
                    gVar = bVar.f1014b;
                    if (gVar == null) {
                        while (true) {
                            int i2 = gVar.f1008f;
                            int i3 = gVar.f1009g;
                            ForkJoinTask<?>[] forkJoinTaskArr = gVar.f1010h;
                            if (forkJoinTaskArr != null && (i = i2 - i3) < 0 && (length = forkJoinTaskArr.length) > 0) {
                                long j = (((long) ((length - 1) & i2)) << f979v) + ((long) f978u);
                                Unsafe unsafe = f975r;
                                ForkJoinTask forkJoinTask = (ForkJoinTask) unsafe.getObjectVolatile(forkJoinTaskArr, j);
                                if (!eVar.isReleasable()) {
                                    int i4 = i2 + 1;
                                    if (i2 == gVar.f1008f) {
                                        if (forkJoinTask == null) {
                                            if (i == -1) {
                                                return;
                                            }
                                        } else if (m1032s(forkJoinTask)) {
                                            if (unsafe.compareAndSwapObject(forkJoinTaskArr, j, forkJoinTask, (Object) null)) {
                                                gVar.f1008f = i4;
                                                forkJoinTask.doExec();
                                            }
                                        } else {
                                            return;
                                        }
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
            int c = TLRandom.m1086c();
            gVar = (c == 0 || (gVarArr = aVar.f987g) == null || (length2 = gVarArr.length) <= 0) ? null : gVarArr[c & (length2 - 1) & 126];
            if (gVar == null) {
            }
        }
    }

    /* renamed from: s */
    static boolean m1032s(ForkJoinTask<?> forkJoinTask) {
        Class<?> cls;
        if (forkJoinTask == null || (cls = f980w) == null) {
            return false;
        }
        return cls.isAssignableFrom(forkJoinTask.getClass());
    }

    /* renamed from: u */
    public static void m1033u(AbstractC0351e eVar) {
        ForkJoinWorkerThread bVar;
        ForkJoinPool aVar;
        C0353g gVar;
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof ForkJoinWorkerThread) || (aVar = (bVar = (ForkJoinWorkerThread) currentThread).f1013a) == null || (gVar = bVar.f1014b) == null) {
            while (!eVar.isReleasable() && !eVar.block()) {
            }
            return;
        }
        while (!eVar.isReleasable()) {
            int I = aVar.m1019I(gVar);
            if (I != 0) {
                do {
                    long j = 281474976710656L;
                    try {
                        if (eVar.isReleasable()) {
                            break;
                        }
                    } finally {
                        long j2 = f976s;
                        if (I <= 0) {
                            j = 0;
                        }
                        m1027l(aVar, j2, j);
                    }
                } while (!eVar.block());
                return;
            }
        }
    }

    /* renamed from: v */
    private static Object m1034v(String str) {
        String property = System.getProperty(str);
        if (property == null) {
            return null;
        }
        return ClassLoader.getSystemClassLoader().loadClass(property).getConstructor(new Class[0]).newInstance(new Object[0]);
    }

    /* renamed from: w */
    private static final synchronized int m1035w() {
        int i;
        synchronized (ForkJoinPool.class) {
            i = f974q + 1;
            f974q = i;
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003d, code lost:
        r14 = (((long) ((r11 - 1) & r10)) << java9.util.concurrent.ForkJoinPool.f979v) + ((long) java9.util.concurrent.ForkJoinPool.f978u);
        r12 = java9.util.concurrent.ForkJoinPool.f975r;
        r1 = (java9.util.concurrent.ForkJoinTask) r12.getObjectVolatile(r13, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        if (r1 == null) goto L_0x0002;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        r2 = r10 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        if (r10 != r9.f1008f) goto L_0x0002;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0062, code lost:
        if (r12.compareAndSwapObject(r13, r14, r1, (java.lang.Object) null) == false) goto L_0x0002;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        r9.f1008f = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0002, code lost:
        continue;
     */
    /* renamed from: y */
    private ForkJoinTask<?> m1036y(boolean z) {
        C0353g[] gVarArr;
        int length;
        int i;
        int i2;
        ForkJoinTask<?>[] forkJoinTaskArr;
        while ((this.f986f & Integer.MIN_VALUE) == 0 && (gVarArr = this.f987g) != null && (length = gVarArr.length) > 0) {
            int i3 = length - 1;
            int l = TLRandom.m1095l();
            int i4 = l >>> 16;
            if (z) {
                i2 = l & -2 & i3;
                i = (i4 & -2) | 2;
            } else {
                i2 = l & i3;
                i = i4 | 1;
            }
            int i5 = i2;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                C0353g gVar = gVarArr[i5];
                if (gVar != null) {
                    int i8 = gVar.f1008f;
                    i6 += i8;
                    if (i8 - gVar.f1009g < 0 && (forkJoinTaskArr = gVar.f1010h) != null && (r11 = forkJoinTaskArr.length) > 0) {
                        break;
                    }
                }
                i5 = (i5 + i) & i3;
                if (i5 == i2) {
                    if (i7 == i6) {
                        return null;
                    }
                    i7 = i6;
                    i6 = 0;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public final C0353g mo517B(ForkJoinWorkerThread bVar) {
        int i;
        int length;
        bVar.setDaemon(true);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f990j;
        if (uncaughtExceptionHandler != null) {
            bVar.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        C0353g gVar = new C0353g(this, bVar);
        int i2 = this.f986f & 65536;
        String str = this.f988h;
        if (str != null) {
            synchronized (str) {
                C0353g[] gVarArr = this.f987g;
                int i3 = this.f984d - 1640531527;
                this.f984d = i3;
                i = 0;
                if (gVarArr != null && (length = gVarArr.length) > 1) {
                    int i4 = length - 1;
                    int i5 = i3 & i4;
                    int i6 = ((i3 << 1) | 1) & i4;
                    int i7 = length >>> 1;
                    while (true) {
                        C0353g gVar2 = gVarArr[i6];
                        if (gVar2 == null) {
                            break;
                        } else if (gVar2.f1003a == 1073741824) {
                            break;
                        } else {
                            i7--;
                            if (i7 == 0) {
                                i6 = length | 1;
                                break;
                            }
                            i6 = (i6 + 2) & i4;
                        }
                    }
                    int i8 = i2 | i6 | (i3 & 1073610752);
                    gVar.f1006d = i8;
                    gVar.f1003a = i8;
                    if (i6 < length) {
                        gVarArr[i6] = gVar;
                    } else {
                        int i9 = length << 1;
                        C0353g[] gVarArr2 = new C0353g[i9];
                        gVarArr2[i6] = gVar;
                        int i10 = i9 - 1;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            C0353g gVar3 = gVarArr[i];
                            if (gVar3 != null) {
                                gVarArr2[gVar3.f1006d & i10 & 126] = gVar3;
                            }
                            int i11 = i + 1;
                            if (i11 >= length) {
                                break;
                            }
                            gVarArr2[i11] = gVarArr[i11];
                            i = i11 + 1;
                        }
                        this.f987g = gVarArr2;
                    }
                    i = i5;
                }
            }
            bVar.setName(str.concat(Integer.toString(i)));
        }
        return gVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c2, code lost:
        r10 = r24.f1003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ce, code lost:
        if (r10 < 0) goto L_0x00f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00d0, code lost:
        r15 = (r10 + 65536) | Integer.MIN_VALUE;
        r24.f1003a = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d9, code lost:
        r4 = r23.f981a;
        r24.f1004b = (int) r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f1, code lost:
        if (java9.util.concurrent.ForkJoinPool.f975r.compareAndSwapLong(r23, java9.util.concurrent.ForkJoinPool.f976s, r4, ((r4 - 281474976710656L) & -4294967296L) | (((long) r15) & 4294967295L)) == false) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f4, code lost:
        r15 = r24.f1004b;
        r24.f1007e = -1073741824;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00fd, code lost:
        if (r24.f1003a < 0) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ff, code lost:
        r24.f1007e = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0106, code lost:
        r0 = r23.f986f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0108, code lost:
        if (r0 >= 0) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x010a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010b, code lost:
        r4 = r23.f981a;
        r1 = (65535 & r0) + ((int) (r4 >> 48));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0117, code lost:
        if (r1 > 0) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x011c, code lost:
        if ((r0 & 262144) == 0) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0123, code lost:
        if (m1020K(false, false) == false) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0125, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0127, code lost:
        r17 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012d, code lost:
        if ((r17 & 1) != 0) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x012f, code lost:
        java.lang.Thread.interrupted();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0135, code lost:
        if (r1 > 0) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0137, code lost:
        if (r15 == 0) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x013a, code lost:
        if (r10 != ((int) r4)) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x013c, code lost:
        r0 = r23.f983c + java.lang.System.currentTimeMillis();
        java.util.concurrent.locks.LockSupport.parkUntil(r23, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x014a, code lost:
        if (r23.f981a != r4) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0155, code lost:
        if ((r0 - java.lang.System.currentTimeMillis()) > 20) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0171, code lost:
        if (java9.util.concurrent.ForkJoinPool.f975r.compareAndSwapLong(r23, java9.util.concurrent.ForkJoinPool.f976s, r4, ((r4 - 4294967296L) & -4294967296L) | (((long) r15) & 4294967295L)) == false) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0173, code lost:
        r24.f1003a = 1073741824;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0177, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0178, code lost:
        java.util.concurrent.locks.LockSupport.park(r23);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x017d, code lost:
        r2 = r17;
     */
    /* renamed from: C */
    public final void mo518C(C0353g gVar) {
        int i;
        C0353g[] gVarArr;
        C0353g gVar2;
        ForkJoinTask<?>[] forkJoinTaskArr;
        int length;
        gVar.mo555b();
        int l = gVar.f1006d ^ TLRandom.m1095l();
        if (l == 0) {
            l = 1;
        }
        while (true) {
            int i2 = 0;
            while (true) {
                C0353g[] gVarArr2 = this.f987g;
                if (gVarArr2 != null) {
                    int length2 = gVarArr2.length;
                    int i3 = length2 - 1;
                    int i4 = l;
                    int i5 = length2;
                    boolean z = false;
                    while (true) {
                        if (i5 <= 0) {
                            i = i4;
                            break;
                        }
                        int i6 = i4 & i3;
                        if (i6 >= 0 && i6 < length2 && (gVar2 = gVarArr2[i6]) != null) {
                            int i7 = gVar2.f1008f;
                            if (i7 - gVar2.f1009g < 0 && (forkJoinTaskArr = gVar2.f1010h) != null && (length = forkJoinTaskArr.length) > 0) {
                                int i8 = gVar2.f1006d;
                                long j = ((long) f978u) + (((long) ((length - 1) & i7)) << f979v);
                                Unsafe unsafe = f975r;
                                ForkJoinTask forkJoinTask = (ForkJoinTask) unsafe.getObjectVolatile(forkJoinTaskArr, j);
                                if (forkJoinTask != null) {
                                    int i9 = i7 + 1;
                                    gVarArr = gVarArr2;
                                    if (i7 == gVar2.f1008f && unsafe.compareAndSwapObject(forkJoinTaskArr, j, forkJoinTask, (Object) null)) {
                                        gVar2.f1008f = i9;
                                        if (i9 - gVar2.f1009g < 0 && i8 != i2) {
                                            mo519D();
                                        }
                                        gVar.f1007e = i8;
                                        forkJoinTask.doExec();
                                        if ((gVar.f1006d & 65536) != 0) {
                                            gVar.mo558e(1024);
                                        } else {
                                            gVar.mo559f(1024);
                                        }
                                        ForkJoinWorkerThread bVar = gVar.f1012j;
                                        gVar.f1005c++;
                                        gVar.f1007e = 0;
                                        if (bVar != null) {
                                            bVar.mo571a();
                                        }
                                        i2 = i8;
                                    }
                                } else {
                                    gVarArr = gVarArr2;
                                }
                                i4 = i4;
                                z = true;
                                i5--;
                                gVarArr2 = gVarArr;
                            }
                        }
                        gVarArr = gVarArr2;
                        i = i4;
                        if (z) {
                            break;
                        }
                        i4 = i + 1;
                        i5--;
                        gVarArr2 = gVarArr;
                    }
                    if (!z) {
                        break;
                    }
                    int i10 = i ^ (i << 13);
                    int i11 = i10 ^ (i10 >>> 17);
                    l = i11 ^ (i11 << 5);
                } else {
                    return;
                }
            }
            l = i;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public final void mo519D() {
        int i;
        C0353g gVar;
        while (true) {
            long j = this.f981a;
            if (j < 0) {
                int i2 = (int) j;
                if (i2 != 0) {
                    C0353g[] gVarArr = this.f987g;
                    if (gVarArr != null && gVarArr.length > (i = 65535 & i2) && (gVar = gVarArr[i]) != null) {
                        int i3 = i2 & Integer.MAX_VALUE;
                        int i4 = gVar.f1003a;
                        long j2 = (((long) gVar.f1004b) & 4294967295L) | (-4294967296L & (281474976710656L + j));
                        ForkJoinWorkerThread bVar = gVar.f1012j;
                        if (i2 == i4 && f975r.compareAndSwapLong(this, f976s, j, j2)) {
                            gVar.f1003a = i3;
                            if (gVar.f1007e < 0) {
                                LockSupport.unpark(bVar);
                                return;
                            }
                            return;
                        }
                    } else {
                        return;
                    }
                } else if ((140737488355328L & j) != 0) {
                    m1018H(j);
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: E */
    public ForkJoinTask<?> submit(Runnable runnable) {
        Objects.m125a(runnable);
        ForkJoinTask<?> adaptedRunnableAction = runnable instanceof ForkJoinTask ? (ForkJoinTask) runnable : new ForkJoinTask.AdaptedRunnableAction(runnable);
        m1026k(adaptedRunnableAction);
        return adaptedRunnableAction;
    }

    /* renamed from: F */
    public <T> ForkJoinTask<T> submit(Runnable runnable, T t) {
        ForkJoinTask.AdaptedRunnable adaptedRunnable = new ForkJoinTask.AdaptedRunnable(runnable, t);
        m1026k(adaptedRunnable);
        return adaptedRunnable;
    }

    /* renamed from: G */
    public <T> ForkJoinTask<T> submit(Callable<T> callable) {
        ForkJoinTask.AdaptedCallable adaptedCallable = new ForkJoinTask.AdaptedCallable(callable);
        m1026k(adaptedCallable);
        return adaptedCallable;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: J */
    public final boolean mo523J(ForkJoinTask<?> forkJoinTask) {
        int length;
        C0353g gVar;
        int c = TLRandom.m1086c();
        C0353g[] gVarArr = this.f987g;
        if (gVarArr == null || (length = gVarArr.length) <= 0 || (gVar = gVarArr[c & (length - 1) & 126]) == null || !gVar.mo569p(forkJoinTask)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final int mo524a(C0353g gVar, ForkJoinTask<?> forkJoinTask, long j) {
        long j2;
        C0353g gVar2;
        ForkJoinTask<?>[] forkJoinTaskArr;
        int length;
        int d;
        if (gVar == null || forkJoinTask == null) {
            return 0;
        }
        if ((forkJoinTask instanceof CountedCompleter) && (d = gVar.mo557d((CountedCompleter) forkJoinTask, 0)) < 0) {
            return d;
        }
        gVar.mo568o(forkJoinTask);
        int i = gVar.f1007e;
        int i2 = gVar.f1006d;
        int i3 = forkJoinTask.status;
        while (i3 >= 0) {
            boolean z = true;
            int l = TLRandom.m1095l() | 1;
            C0353g[] gVarArr = this.f987g;
            if (gVarArr != null) {
                int length2 = gVarArr.length;
                int i4 = length2 - 1;
                int i5 = -length2;
                while (true) {
                    if (i5 >= length2) {
                        break;
                    }
                    int i6 = (l + i5) & i4;
                    if (i6 >= 0 && i6 < length2 && (gVar2 = gVarArr[i6]) != null && gVar2.f1007e == i2) {
                        int i7 = gVar2.f1008f;
                        if (i7 - gVar2.f1009g < 0 && (forkJoinTaskArr = gVar2.f1010h) != null && (length = forkJoinTaskArr.length) > 0) {
                            int i8 = gVar2.f1006d;
                            long j3 = (((long) ((length - 1) & i7)) << f979v) + ((long) f978u);
                            Unsafe unsafe = f975r;
                            ForkJoinTask forkJoinTask2 = (ForkJoinTask) unsafe.getObjectVolatile(forkJoinTaskArr, j3);
                            if (forkJoinTask2 != null) {
                                int i9 = i7 + 1;
                                if (i7 == gVar2.f1008f && i2 == gVar2.f1007e && unsafe.compareAndSwapObject(forkJoinTaskArr, j3, forkJoinTask2, (Object) null)) {
                                    gVar2.f1008f = i9;
                                    gVar.f1007e = i8;
                                    forkJoinTask2.doExec();
                                    gVar.f1007e = i;
                                }
                            }
                        }
                    }
                    i5 += 2;
                }
            }
            z = false;
            int i10 = forkJoinTask.status;
            if (i10 < 0) {
                return i10;
            }
            if (!z) {
                long j4 = 0;
                if (j == 0) {
                    j2 = 0;
                } else {
                    long nanoTime = j - System.nanoTime();
                    if (nanoTime <= 0) {
                        return i10;
                    }
                    j2 = TimeUnit.NANOSECONDS.toMillis(nanoTime);
                    if (j2 <= 0) {
                        j2 = 1;
                    }
                }
                int I = m1019I(gVar);
                if (I != 0) {
                    forkJoinTask.internalWait(j2);
                    long j5 = f976s;
                    if (I > 0) {
                        j4 = 281474976710656L;
                    }
                    m1027l(this, j5, j4);
                }
                i10 = forkJoinTask.status;
            }
            i3 = i10;
        }
        return i3;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        if (Thread.interrupted()) {
            throw new InterruptedException();
        } else if (this == f971n) {
            mo526b(j, timeUnit);
            return false;
        } else {
            long nanos = timeUnit.toNanos(j);
            if (isTerminated()) {
                return true;
            }
            if (nanos <= 0) {
                return false;
            }
            long nanoTime = System.nanoTime() + nanos;
            synchronized (this) {
                while (!isTerminated()) {
                    if (nanos <= 0) {
                        return false;
                    }
                    long millis = TimeUnit.NANOSECONDS.toMillis(nanos);
                    if (millis <= 0) {
                        millis = 1;
                    }
                    wait(millis);
                    nanos = nanoTime - System.nanoTime();
                }
                return true;
            }
        }
    }

    /* renamed from: b */
    public boolean mo526b(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread bVar = (ForkJoinWorkerThread) currentThread;
            if (bVar.f1013a == this) {
                mo537r(bVar.f1014b);
                return true;
            }
        }
        long nanoTime = System.nanoTime();
        while (true) {
            ForkJoinTask<?> y = m1036y(false);
            if (y != null) {
                y.doExec();
            } else if (mo543t()) {
                return true;
            } else {
                if (System.nanoTime() - nanoTime > nanos) {
                    return false;
                }
                Thread.yield();
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        ForkJoinTask forkJoinTask;
        Objects.m125a(runnable);
        if (runnable instanceof ForkJoinTask) {
            forkJoinTask = (ForkJoinTask) runnable;
        } else {
            forkJoinTask = new ForkJoinTask.RunnableExecuteAction(runnable);
        }
        m1026k(forkJoinTask);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040 A[LOOP:0: B:26:0x0040->B:27:0x0064, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0080  */
    /* renamed from: h */
    public final void mo528h(ForkJoinWorkerThread bVar, Throwable th) {
        int i;
        C0353g gVar;
        Unsafe unsafe;
        long j;
        long j2;
        if (bVar != null) {
            gVar = bVar.f1014b;
            if (gVar != null) {
                String str = this.f988h;
                long j3 = ((long) gVar.f1005c) & 4294967295L;
                int i2 = gVar.f1006d & 65535;
                if (str != null) {
                    synchronized (str) {
                        C0353g[] gVarArr = this.f987g;
                        if (gVarArr != null && gVarArr.length > i2 && gVarArr[i2] == gVar) {
                            gVarArr[i2] = null;
                        }
                        this.f982b += j3;
                    }
                }
                i = gVar.f1003a;
                if (i == 1073741824) {
                    do {
                        unsafe = f975r;
                        j = f976s;
                        j2 = this.f981a;
                    } while (!unsafe.compareAndSwapLong(this, j, j2, (-281474976710656L & (j2 - 281474976710656L)) | (281470681743360L & (j2 - 4294967296L)) | (j2 & 4294967295L)));
                }
                if (gVar != null) {
                    gVar.mo554a();
                }
                if (!(m1020K(false, false) || gVar == null || gVar.f1010h == null)) {
                    mo519D();
                }
                if (th != null) {
                    ForkJoinTask.helpExpungeStaleExceptions();
                    return;
                } else {
                    ForkJoinTask.rethrow(th);
                    return;
                }
            }
        } else {
            gVar = null;
        }
        i = 0;
        if (i == 1073741824) {
        }
        if (gVar != null) {
        }
        mo519D();
        if (th != null) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final int mo529i(CountedCompleter<?> countedCompleter, int i) {
        int length;
        C0353g gVar;
        int c = TLRandom.m1086c();
        C0353g[] gVarArr = this.f987g;
        if (gVarArr == null || (length = gVarArr.length) <= 0 || (gVar = gVarArr[c & (length - 1) & 126]) == null) {
            return 0;
        }
        return gVar.mo566m(countedCompleter, i);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        try {
            Iterator<? extends Callable<T>> it = collection.iterator();
            while (it.hasNext()) {
                ForkJoinTask.AdaptedCallable adaptedCallable = new ForkJoinTask.AdaptedCallable((Callable) it.next());
                arrayList.add(adaptedCallable);
                m1026k(adaptedCallable);
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((ForkJoinTask) arrayList.get(i)).quietlyJoin();
            }
            return arrayList;
        } catch (Throwable th) {
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((Future) arrayList.get(i2)).cancel(false);
            }
            throw th;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return (this.f986f & 262144) != 0;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return (this.f986f & 524288) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public final void mo533j(ForkJoinTask<?> forkJoinTask) {
        int length;
        boolean z;
        boolean z2;
        int length2;
        int length3;
        int length4;
        int c = TLRandom.m1086c();
        if (c == 0) {
            TLRandom.m1092i();
            c = TLRandom.m1086c();
        }
        while (true) {
            int i = this.f986f;
            C0353g[] gVarArr = this.f987g;
            if ((i & 262144) != 0 || gVarArr == null || (length = gVarArr.length) <= 0) {
                break;
            }
            C0353g gVar = gVarArr[(length - 1) & c & 126];
            if (gVar == null) {
                String str = this.f988h;
                int i2 = (c | 1073741824) & -65538;
                C0353g gVar2 = new C0353g(this, null);
                gVar2.f1006d = i2;
                gVar2.f1007e = 1073741824;
                gVar2.f1003a = 1;
                if (str != null) {
                    synchronized (str) {
                        C0353g[] gVarArr2 = this.f987g;
                        if (gVarArr2 != null && (length4 = gVarArr2.length) > 0) {
                            int i3 = i2 & (length4 - 1) & 126;
                            if (gVarArr2[i3] == null) {
                                gVarArr2[i3] = gVar2;
                                z2 = true;
                                z = true;
                            }
                        }
                        z2 = false;
                        z = false;
                    }
                } else {
                    z2 = false;
                    z = false;
                }
                gVar = gVar2;
            } else if (gVar.mo567n()) {
                int i4 = gVar.f1008f;
                int i5 = gVar.f1009g;
                ForkJoinTask<?>[] forkJoinTaskArr = gVar.f1010h;
                if (forkJoinTaskArr != null && (length3 = forkJoinTaskArr.length) > 0) {
                    int i6 = length3 - 1;
                    int i7 = i4 - i5;
                    if (i6 + i7 > 0) {
                        forkJoinTaskArr[i6 & i5] = forkJoinTask;
                        gVar.f1009g = i5 + 1;
                        gVar.f1003a = 0;
                        if (i7 >= 0 || gVar.f1008f - i5 >= -1) {
                            z = false;
                            z2 = true;
                        } else {
                            return;
                        }
                    }
                }
                z = true;
                z2 = true;
            } else {
                z2 = false;
                z = false;
            }
            if (z2) {
                if (z) {
                    try {
                        gVar.mo555b();
                        int i8 = gVar.f1009g;
                        ForkJoinTask<?>[] forkJoinTaskArr2 = gVar.f1010h;
                        if (forkJoinTaskArr2 != null && (length2 = forkJoinTaskArr2.length) > 0) {
                            forkJoinTaskArr2[(length2 - 1) & i8] = forkJoinTask;
                            gVar.f1009g = i8 + 1;
                        }
                    } finally {
                        gVar.f1003a = 0;
                    }
                }
                mo519D();
                return;
            }
            c = TLRandom.m1084a(c);
        }
        throw new RejectedExecutionException();
    }

    /* access modifiers changed from: protected */
    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new ForkJoinTask.AdaptedRunnable(runnable, t);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: q */
    public final int mo536q(C0353g gVar, CountedCompleter<?> countedCompleter, int i) {
        if (gVar == null) {
            return 0;
        }
        return gVar.mo557d(countedCompleter, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public final void mo537r(C0353g gVar) {
        boolean z;
        boolean z2;
        int i;
        char c;
        C0353g gVar2;
        ForkJoinTask<?>[] forkJoinTaskArr;
        int length;
        int i2 = gVar.f1007e;
        int i3 = gVar.f1006d & 65536;
        char c2 = 65535;
        int i4 = i2;
        char c3 = 65535;
        while (true) {
            if (i3 != 0) {
                gVar.mo558e(0);
            } else {
                gVar.mo559f(0);
            }
            if (c3 == c2 && gVar.f1003a >= 0) {
                c3 = 1;
            }
            int l = TLRandom.m1095l();
            C0353g[] gVarArr = this.f987g;
            long j = 281474976710656L;
            if (gVarArr != null) {
                int length2 = gVarArr.length;
                int i5 = length2 - 1;
                int i6 = length2;
                z = true;
                while (true) {
                    if (i6 <= 0) {
                        z2 = true;
                        break;
                    }
                    int i7 = (l - i6) & i5;
                    if (i7 >= 0 && i7 < length2 && (gVar2 = gVarArr[i7]) != null) {
                        int i8 = gVar2.f1008f;
                        if (i8 - gVar2.f1009g < 0 && (forkJoinTaskArr = gVar2.f1010h) != null && (length = forkJoinTaskArr.length) > 0) {
                            int i9 = gVar2.f1006d;
                            if (c3 == 0) {
                                m1027l(this, f976s, j);
                                c3 = 1;
                            }
                            long j2 = (((long) ((length - 1) & i8)) << f979v) + ((long) f978u);
                            Unsafe unsafe = f975r;
                            ForkJoinTask forkJoinTask = (ForkJoinTask) unsafe.getObjectVolatile(forkJoinTaskArr, j2);
                            if (forkJoinTask != null) {
                                int i10 = i8 + 1;
                                if (i8 == gVar2.f1008f && unsafe.compareAndSwapObject(forkJoinTaskArr, j2, forkJoinTask, (Object) null)) {
                                    gVar2.f1008f = i10;
                                    gVar.f1007e = gVar2.f1006d;
                                    forkJoinTask.doExec();
                                    gVar.f1007e = i2;
                                    i4 = i2;
                                }
                            }
                            z2 = false;
                            z = false;
                        } else if ((gVar2.f1007e & 1073741824) == 0) {
                            z = false;
                        }
                    }
                    i6--;
                    j = 281474976710656L;
                }
            } else {
                z2 = true;
                z = true;
            }
            if (z) {
                break;
            }
            if (z2) {
                if (i4 != 1073741824) {
                    gVar.f1007e = 1073741824;
                    c = 1;
                    i = 1073741824;
                } else {
                    i = i4;
                    c = 1;
                }
                if (c3 == c) {
                    m1027l(this, f976s, -281474976710656L);
                    i4 = i;
                    c3 = 0;
                } else {
                    i4 = i;
                }
            }
            c2 = 65535;
        }
        if (c3 == 0) {
            m1027l(this, f976s, 281474976710656L);
        }
        gVar.f1007e = i2;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        m1021c();
        m1020K(false, true);
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        m1021c();
        m1020K(true, true);
        return Collections.emptyList();
    }

    /* renamed from: t */
    public boolean mo543t() {
        while (true) {
            long j = this.f981a;
            int i = this.f986f;
            int i2 = 65535 & i;
            int i3 = ((short) ((int) (j >>> 32))) + i2;
            int i4 = i2 + ((int) (j >> 48));
            if ((i & -2146959360) != 0) {
                return true;
            }
            if (i4 > 0) {
                return false;
            }
            C0353g[] gVarArr = this.f987g;
            if (gVarArr != null) {
                for (int i5 = 1; i5 < gVarArr.length; i5 += 2) {
                    C0353g gVar = gVarArr[i5];
                    if (gVar != null) {
                        if ((gVar.f1007e & 1073741824) == 0) {
                            return false;
                        }
                        i3--;
                    }
                }
            }
            if (i3 == 0 && this.f981a == j) {
                return true;
            }
        }
    }

    @Override // java.lang.Object
    public String toString() {
        int i;
        long j = this.f982b;
        C0353g[] gVarArr = this.f987g;
        long j2 = 0;
        int i2 = 0;
        long j3 = 0;
        if (gVarArr != null) {
            i = 0;
            for (int i3 = 0; i3 < gVarArr.length; i3++) {
                C0353g gVar = gVarArr[i3];
                if (gVar != null) {
                    int l = gVar.mo565l();
                    if ((i3 & 1) == 0) {
                        j3 += (long) l;
                    } else {
                        j2 += (long) l;
                        j += ((long) gVar.f1005c) & 4294967295L;
                        if (gVar.mo556c()) {
                            i++;
                        }
                    }
                }
            }
        } else {
            i = 0;
        }
        int i4 = this.f986f;
        int i5 = 65535 & i4;
        long j4 = this.f981a;
        int i6 = ((short) ((int) (j4 >>> 32))) + i5;
        int i7 = ((int) (j4 >> 48)) + i5;
        if (i7 >= 0) {
            i2 = i7;
        }
        return super.toString() + "[" + ((524288 & i4) != 0 ? "Terminated" : (Integer.MIN_VALUE & i4) != 0 ? "Terminating" : (i4 & 262144) != 0 ? "Shutting down" : "Running") + ", parallelism = " + i5 + ", size = " + i6 + ", active = " + i2 + ", running = " + i + ", steals = " + j + ", tasks = " + j2 + ", submissions = " + j3 + "]";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: x */
    public final ForkJoinTask<?> mo545x(C0353g gVar) {
        if (gVar != null) {
            ForkJoinTask<?> i = (gVar.f1006d & 65536) != 0 ? gVar.mo562i() : gVar.mo563j();
            if (i != null) {
                return i;
            }
        }
        return m1036y(false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public ForkJoinTask<?> mo546z() {
        return m1036y(true);
    }

    public ForkJoinPool() {
        this(Math.min(32767, Runtime.getRuntime().availableProcessors()), f969l, null, false, 0, 32767, 1, null, 60000, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: protected */
    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new ForkJoinTask.AdaptedCallable(callable);
    }

    public ForkJoinPool(int i, AbstractC0348c cVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, boolean z, int i2, int i3, int i4, Predicate<? super ForkJoinPool> aVar, long j, TimeUnit timeUnit) {
        if (i <= 0 || i > 32767 || i3 < i || j <= 0) {
            throw new IllegalArgumentException();
        }
        Objects.m125a(cVar);
        long max = Math.max(timeUnit.toMillis(j), 20L);
        long j2 = ((((long) (-Math.min(Math.max(i2, i), 32767))) << 32) & 281470681743360L) | ((((long) (-i)) << 48) & -281474976710656L);
        int i5 = (z ? 65536 : 0) | i;
        int min = ((Math.min(i3, 32767) - i) << 16) | ((Math.min(Math.max(i4, 0), 32767) - i) & 65535);
        int i6 = i > 1 ? i - 1 : 1;
        int i7 = i6 | (i6 >>> 1);
        int i8 = i7 | (i7 >>> 2);
        int i9 = i8 | (i8 >>> 4);
        int i10 = i9 | (i9 >>> 8);
        this.f988h = "ForkJoinPool-" + m1035w() + "-worker-";
        this.f987g = new C0353g[(((i10 | (i10 >>> 16)) + 1) << 1)];
        this.f989i = cVar;
        this.f990j = uncaughtExceptionHandler;
        this.f991k = aVar;
        this.f983c = max;
        this.f985e = min;
        this.f986f = i5;
        this.f981a = j2;
        m1021c();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006c  */
    private ForkJoinPool(byte b) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        AbstractC0348c cVar;
        int i = -1;
        try {
            String property = System.getProperty("java.util.concurrent.ForkJoinPool.common.parallelism");
            i = property != null ? Integer.parseInt(property) : i;
            cVar = (AbstractC0348c) m1034v("java.util.concurrent.ForkJoinPool.common.threadFactory");
            try {
                uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) m1034v("java.util.concurrent.ForkJoinPool.common.exceptionHandler");
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            cVar = null;
            uncaughtExceptionHandler = null;
            if (cVar == null) {
            }
            i = 1;
            if (i > 32767) {
            }
            long j = (long) (-i);
            long j2 = ((j << 48) & -281474976710656L) | ((j << 32) & 281470681743360L);
            int i2 = ((1 - i) & 65535) | (f973p << 16);
            if (i <= 1) {
            }
            int i3 = r7 | (r7 >>> 1);
            int i4 = i3 | (i3 >>> 2);
            int i5 = i4 | (i4 >>> 4);
            int i6 = i5 | (i5 >>> 8);
            this.f988h = "ForkJoinPool.commonPool-worker-";
            this.f987g = new C0353g[(((i6 | (i6 >>> 16)) + 1) << 1)];
            this.f989i = cVar;
            this.f990j = uncaughtExceptionHandler;
            this.f991k = null;
            this.f983c = 60000;
            this.f985e = i2;
            this.f986f = i;
            this.f981a = j2;
        }
        if (cVar == null) {
            if (System.getSecurityManager() == null) {
                cVar = f969l;
            } else {
                cVar = new C0349d(null);
            }
        }
        if (i < 0 && (i = Runtime.getRuntime().availableProcessors() - 1) <= 0) {
            i = 1;
        }
        i = i > 32767 ? 32767 : i;
        long j3 = (long) (-i);
        long j22 = ((j3 << 48) & -281474976710656L) | ((j3 << 32) & 281470681743360L);
        int i22 = ((1 - i) & 65535) | (f973p << 16);
        int i7 = i <= 1 ? i - 1 : 1;
        int i32 = i7 | (i7 >>> 1);
        int i42 = i32 | (i32 >>> 2);
        int i52 = i42 | (i42 >>> 4);
        int i62 = i52 | (i52 >>> 8);
        this.f988h = "ForkJoinPool.commonPool-worker-";
        this.f987g = new C0353g[(((i62 | (i62 >>> 16)) + 1) << 1)];
        this.f989i = cVar;
        this.f990j = uncaughtExceptionHandler;
        this.f991k = null;
        this.f983c = 60000;
        this.f985e = i22;
        this.f986f = i;
        this.f981a = j22;
    }
}
