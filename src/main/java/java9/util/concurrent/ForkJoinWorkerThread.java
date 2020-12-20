package java9.util.concurrent;

import java.lang.Thread;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java9.util.concurrent.ForkJoinPool;

/* renamed from: java9.util.concurrent.b */
/* compiled from: ForkJoinWorkerThread */
public class ForkJoinWorkerThread extends Thread {

    /* renamed from: a */
    final ForkJoinPool f1013a;

    /* renamed from: b */
    final ForkJoinPool.C0353g f1014b;

    /* access modifiers changed from: package-private */
    /* renamed from: java9.util.concurrent.b$a */
    /* compiled from: ForkJoinWorkerThread */
    public static final class C0354a extends ForkJoinWorkerThread {

        /* renamed from: c */
        private static final ThreadGroup f1015c = ((ThreadGroup) AccessController.doPrivileged(new C0355a()));

        /* renamed from: d */
        private static final AccessControlContext f1016d = new AccessControlContext(new ProtectionDomain[]{new ProtectionDomain(null, null)});

        /* renamed from: java9.util.concurrent.b$a$a */
        /* compiled from: ForkJoinWorkerThread */
        static class C0355a implements PrivilegedAction<ThreadGroup> {
            C0355a() {
            }

            /* renamed from: a */
            public ThreadGroup run() {
                ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
                while (true) {
                    ThreadGroup parent = threadGroup.getParent();
                    if (parent == null) {
                        return new ThreadGroup(threadGroup, "InnocuousForkJoinWorkerThreadGroup");
                    }
                    threadGroup = parent;
                }
            }
        }

        C0354a(ForkJoinPool aVar) {
            super(aVar, ClassLoader.getSystemClassLoader(), f1015c, f1016d);
        }

        /* access modifiers changed from: package-private */
        @Override // java9.util.concurrent.ForkJoinWorkerThread
        /* renamed from: a */
        public void mo571a() {
            TLRandom.m1085b(this);
        }

        @Override // java.lang.Thread
        public void setContextClassLoader(ClassLoader classLoader) {
            if (classLoader != null && ClassLoader.getSystemClassLoader() != classLoader) {
                throw new SecurityException("setContextClassLoader");
            }
        }

        @Override // java.lang.Thread
        public void setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        }
    }

    ForkJoinWorkerThread(ForkJoinPool aVar, ClassLoader classLoader) {
        super("aForkJoinWorkerThread");
        TLRandom.m1096m(this, classLoader);
        this.f1013a = aVar;
        this.f1014b = aVar.mo517B(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo571a() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo572b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo573c(Throwable th) {
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.f1014b.f1010h == null) {
            Throwable th = null;
            try {
                mo572b();
                this.f1013a.mo518C(this.f1014b);
                try {
                    mo573c(null);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable unused) {
            }
            this.f1013a.mo528h(this, th);
        }
    }

    ForkJoinWorkerThread(ForkJoinPool aVar, ClassLoader classLoader, ThreadGroup threadGroup, AccessControlContext accessControlContext) {
        super(threadGroup, "aForkJoinWorkerThread");
        super.setContextClassLoader(classLoader);
        TLRandom.m1097n(this, accessControlContext);
        TLRandom.m1085b(this);
        this.f1013a = aVar;
        this.f1014b = aVar.mo517B(this);
    }
}
