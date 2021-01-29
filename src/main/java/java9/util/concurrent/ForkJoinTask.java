package java9.util.concurrent;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java9.util.concurrent.ForkJoinPool;
import p011c.p012a.Objects;
import sun.misc.Unsafe;

public abstract class ForkJoinTask<V> implements Future<V>, Serializable {
    static final int CANCELLED = -1073741824;
    static final int DONE_MASK = -268435456;
    static final int EXCEPTIONAL = Integer.MIN_VALUE;
    static final int NORMAL = -268435456;
    static final int SIGNAL = 65536;
    static final int SMASK = 65535;

    /* renamed from: a */
    private static final C0344a[] f960a = new C0344a[32];

    /* renamed from: b */
    private static final ReentrantLock f961b = new ReentrantLock();

    /* renamed from: c */
    private static final ReferenceQueue<ForkJoinTask<?>> f962c = new ReferenceQueue<>();

    /* renamed from: d */
    private static final Unsafe f963d;

    /* renamed from: e */
    private static final long f964e;
    private static final long serialVersionUID = -7721805057305804111L;
    volatile int status;

    /* access modifiers changed from: package-private */
    public static final class AdaptedCallable<T> extends ForkJoinTask<T> implements RunnableFuture<T> {
        private static final long serialVersionUID = 2838392045355241008L;
        final Callable<? extends T> callable;
        T result;

        AdaptedCallable(Callable<? extends T> callable2) {
            Objects.m125a(callable2);
            this.callable = callable2;
        }

        @Override // java9.util.concurrent.ForkJoinTask
        public final boolean exec() {
            try {
                this.result = (T) this.callable.call();
                return true;
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // java9.util.concurrent.ForkJoinTask
        public final T getRawResult() {
            return this.result;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        @Override // java9.util.concurrent.ForkJoinTask
        public final void setRawResult(T t) {
            this.result = t;
        }

        @Override // java.lang.Object
        public String toString() {
            return super.toString() + "[Wrapped task = " + this.callable + "]";
        }
    }

    /* access modifiers changed from: package-private */
    public static final class AdaptedRunnable<T> extends ForkJoinTask<T> implements RunnableFuture<T> {
        private static final long serialVersionUID = 5232453952276885070L;
        T result;
        final Runnable runnable;

        AdaptedRunnable(Runnable runnable2, T t) {
            Objects.m125a(runnable2);
            this.runnable = runnable2;
            this.result = t;
        }

        @Override // java9.util.concurrent.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // java9.util.concurrent.ForkJoinTask
        public final T getRawResult() {
            return this.result;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        @Override // java9.util.concurrent.ForkJoinTask
        public final void setRawResult(T t) {
            this.result = t;
        }

        @Override // java.lang.Object
        public String toString() {
            return super.toString() + "[Wrapped task = " + this.runnable + "]";
        }
    }

    /* access modifiers changed from: package-private */
    public static final class AdaptedRunnableAction extends ForkJoinTask<Void> implements RunnableFuture<Void> {
        private static final long serialVersionUID = 5232453952276885070L;
        final Runnable runnable;

        AdaptedRunnableAction(Runnable runnable2) {
            Objects.m125a(runnable2);
            this.runnable = runnable2;
        }

        @Override // java9.util.concurrent.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // java9.util.concurrent.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
        public final void run() {
            invoke();
        }

        public final void setRawResult(Void r1) {
        }

        @Override // java.lang.Object
        public String toString() {
            return super.toString() + "[Wrapped task = " + this.runnable + "]";
        }
    }

    static final class RunnableExecuteAction extends ForkJoinTask<Void> {
        private static final long serialVersionUID = 5232453952276885070L;
        final Runnable runnable;

        RunnableExecuteAction(Runnable runnable2) {
            Objects.m125a(runnable2);
            this.runnable = runnable2;
        }

        @Override // java9.util.concurrent.ForkJoinTask
        public final boolean exec() {
            this.runnable.run();
            return true;
        }

        @Override // java9.util.concurrent.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        /* access modifiers changed from: package-private */
        @Override // java9.util.concurrent.ForkJoinTask
        public void internalPropagateException(Throwable th) {
            ForkJoinTask.rethrow(th);
        }

        public final void setRawResult(Void r1) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: java9.util.concurrent.ForkJoinTask$a */
    public static final class C0344a extends WeakReference<ForkJoinTask<?>> {

        /* renamed from: a */
        final Throwable f965a;

        /* renamed from: b */
        C0344a f966b;

        /* renamed from: c */
        final long f967c = Thread.currentThread().getId();

        /* renamed from: d */
        final int f968d;

        C0344a(ForkJoinTask<?> forkJoinTask, Throwable th, C0344a aVar, ReferenceQueue<ForkJoinTask<?>> referenceQueue) {
            super(forkJoinTask, referenceQueue);
            this.f965a = th;
            this.f966b = aVar;
            this.f968d = System.identityHashCode(forkJoinTask);
        }
    }

    static {
        Unsafe unsafe = UnsafeAccess.f1031a;
        f963d = unsafe;
        try {
            f964e = unsafe.objectFieldOffset(ForkJoinTask.class.getDeclaredField("status"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /* renamed from: a */
    private void m1007a() {
        int identityHashCode = System.identityHashCode(this);
        ReentrantLock reentrantLock = f961b;
        reentrantLock.lock();
        try {
            C0344a[] aVarArr = f960a;
            int length = identityHashCode & (aVarArr.length - 1);
            C0344a aVar = aVarArr[length];
            C0344a aVar2 = null;
            while (true) {
                if (aVar == null) {
                    break;
                }
                C0344a aVar3 = aVar.f966b;
                if (aVar.get() != this) {
                    aVar2 = aVar;
                    aVar = aVar3;
                } else if (aVar2 == null) {
                    aVarArr[length] = aVar3;
                } else {
                    aVar2.f966b = aVar3;
                }
            }
            m1010d();
            this.status = 0;
        } finally {
            reentrantLock.unlock();
        }
    }

    public static ForkJoinTask<?> adapt(Runnable runnable) {
        return new AdaptedRunnableAction(runnable);
    }

    /* renamed from: b */
    private int m1008b() {
        int doExec = doExec();
        if (doExec < 0) {
            return doExec;
        }
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof ForkJoinWorkerThread)) {
            return m1011e();
        }
        ForkJoinWorkerThread bVar = (ForkJoinWorkerThread) currentThread;
        return bVar.f1013a.mo524a(bVar.f1014b, this, f964e);
    }

    /* renamed from: c */
    private int m1009c() {
        int doExec;
        int i = this.status;
        if (i < 0) {
            return i;
        }
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof ForkJoinWorkerThread)) {
            return m1011e();
        }
        ForkJoinWorkerThread bVar = (ForkJoinWorkerThread) currentThread;
        ForkJoinPool.C0353g gVar = bVar.f1014b;
        if (!gVar.mo570q(this) || (doExec = doExec()) >= 0) {
            return bVar.f1013a.mo524a(gVar, this, f964e);
        }
        return doExec;
    }

    static final void cancelIgnoringExceptions(ForkJoinTask<?> forkJoinTask) {
        if (forkJoinTask != null && forkJoinTask.status >= 0) {
            try {
                forkJoinTask.cancel(false);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: d */
    private static void m1010d() {
        while (true) {
            Reference<? extends ForkJoinTask<?>> poll = f962c.poll();
            if (poll == null) {
                return;
            }
            if (poll instanceof C0344a) {
                C0344a[] aVarArr = f960a;
                int length = ((C0344a) poll).f968d & (aVarArr.length - 1);
                C0344a aVar = aVarArr[length];
                C0344a aVar2 = null;
                while (true) {
                    if (aVar == null) {
                        break;
                    }
                    C0344a aVar3 = aVar.f966b;
                    if (aVar != poll) {
                        aVar2 = aVar;
                        aVar = aVar3;
                    } else if (aVar2 == null) {
                        aVarArr[length] = aVar3;
                    } else {
                        aVar2.f966b = aVar3;
                    }
                }
            }
        }
    }

    /* renamed from: e */
    private int m1011e() {
        int i;
        boolean z = false;
        if (this instanceof CountedCompleter) {
            i = ForkJoinPool.f971n.mo529i((CountedCompleter) this, 0);
        } else {
            i = ForkJoinPool.f971n.mo523J(this) ? doExec() : 0;
        }
        if (i < 0) {
            return i;
        }
        int i2 = this.status;
        if (i2 < 0) {
            return i2;
        }
        int i3 = i2;
        do {
            if (f963d.compareAndSwapInt(this, f964e, i3, i3 | SIGNAL)) {
                synchronized (this) {
                    if (this.status >= 0) {
                        try {
                            wait(f964e);
                        } catch (InterruptedException unused) {
                            z = true;
                        }
                    } else {
                        notifyAll();
                    }
                }
            }
            i3 = this.status;
        } while (i3 >= 0);
        if (z) {
            Thread.currentThread().interrupt();
        }
        return i3;
    }

    /* renamed from: f */
    private int m1012f() {
        int i;
        if (!Thread.interrupted()) {
            int i2 = this.status;
            if (i2 < 0) {
                return i2;
            }
            if (this instanceof CountedCompleter) {
                i = ForkJoinPool.f971n.mo529i((CountedCompleter) this, 0);
            } else {
                i = ForkJoinPool.f971n.mo523J(this) ? doExec() : 0;
            }
            if (i < 0) {
                return i;
            }
            while (true) {
                int i3 = this.status;
                if (i3 < 0) {
                    return i3;
                }
                if (f963d.compareAndSwapInt(this, f964e, i3, i3 | SIGNAL)) {
                    synchronized (this) {
                        if (this.status >= 0) {
                            wait(f964e);
                        } else {
                            notifyAll();
                        }
                    }
                }
            }
        } else {
            throw new InterruptedException();
        }
    }

    /* JADX INFO: finally extract failed */
    /* renamed from: g */
    private Throwable m1013g() {
        Throwable th;
        int identityHashCode = System.identityHashCode(this);
        ReentrantLock reentrantLock = f961b;
        reentrantLock.lock();
        try {
            m1010d();
            C0344a[] aVarArr = f960a;
            C0344a aVar = aVarArr[identityHashCode & (aVarArr.length - 1)];
            while (aVar != null && aVar.get() != this) {
                aVar = aVar.f966b;
            }
            reentrantLock.unlock();
            Constructor<?> constructor = null;
            if (aVar == null || (th = aVar.f965a) == null) {
                return null;
            }
            if (aVar.f967c != Thread.currentThread().getId()) {
                try {
                    Constructor<?>[] constructors = th.getClass().getConstructors();
                    for (Constructor<?> constructor2 : constructors) {
                        Class<?>[] parameterTypes = constructor2.getParameterTypes();
                        if (parameterTypes.length == 0) {
                            constructor = constructor2;
                        } else if (parameterTypes.length == 1 && parameterTypes[0] == Throwable.class) {
                            return (Throwable) constructor2.newInstance(th);
                        }
                    }
                    if (constructor != null) {
                        Throwable th2 = (Throwable) constructor.newInstance(new Object[0]);
                        th2.initCause(th);
                        return th2;
                    }
                } catch (Exception unused) {
                }
            }
            return th;
        } catch (Throwable th3) {
            reentrantLock.unlock();
            throw th3;
        }
    }

    public static ForkJoinPool getPool() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            return ((ForkJoinWorkerThread) currentThread).f1013a;
        }
        return null;
    }

    public static int getQueuedTaskCount() {
        ForkJoinPool.C0353g gVar;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            gVar = ((ForkJoinWorkerThread) currentThread).f1014b;
        } else {
            gVar = ForkJoinPool.m1023e();
        }
        if (gVar == null) {
            return 0;
        }
        return gVar.mo565l();
    }

    public static int getSurplusQueuedTaskCount() {
        return ForkJoinPool.m1030o();
    }

    /* renamed from: h */
    private void m1014h(int i) {
        if (i == CANCELLED) {
            throw new CancellationException();
        } else if (i == EXCEPTIONAL) {
            rethrow(m1013g());
        }
    }

    static final void helpExpungeStaleExceptions() {
        ReentrantLock reentrantLock = f961b;
        if (reentrantLock.tryLock()) {
            try {
                m1010d();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public static void helpQuiesce() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            ForkJoinWorkerThread bVar = (ForkJoinWorkerThread) currentThread;
            bVar.f1013a.mo537r(bVar.f1014b);
            return;
        }
        ForkJoinPool.m1017A();
    }

    /* renamed from: i */
    private int m1015i(int i) {
        int i2;
        do {
            i2 = this.status;
            if (i2 < 0) {
                return i2;
            }
        } while (!f963d.compareAndSwapInt(this, f964e, i2, i2 | i));
        if ((i2 >>> 16) != 0) {
            synchronized (this) {
                notifyAll();
            }
        }
        return i;
    }

    public static boolean inForkJoinPool() {
        return Thread.currentThread() instanceof ForkJoinWorkerThread;
    }

    public static void invokeAll(ForkJoinTask<?> forkJoinTask, ForkJoinTask<?> forkJoinTask2) {
        forkJoinTask2.fork();
        int b = forkJoinTask.m1008b() & -268435456;
        if (b != -268435456) {
            forkJoinTask.m1014h(b);
        }
        int c = forkJoinTask2.m1009c() & -268435456;
        if (c != -268435456) {
            forkJoinTask2.m1014h(c);
        }
    }

    /* renamed from: j */
    private int m1016j(Throwable th) {
        int recordExceptionalCompletion = recordExceptionalCompletion(th);
        if ((-268435456 & recordExceptionalCompletion) == EXCEPTIONAL) {
            internalPropagateException(th);
        }
        return recordExceptionalCompletion;
    }

    protected static ForkJoinTask<?> peekNextLocalTask() {
        ForkJoinPool.C0353g gVar;
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            gVar = ((ForkJoinWorkerThread) currentThread).f1014b;
        } else {
            gVar = ForkJoinPool.m1023e();
        }
        if (gVar == null) {
            return null;
        }
        return gVar.mo561h();
    }

    protected static ForkJoinTask<?> pollNextLocalTask() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            return ((ForkJoinWorkerThread) currentThread).f1014b.mo560g();
        }
        return null;
    }

    protected static ForkJoinTask<?> pollSubmission() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            return ((ForkJoinWorkerThread) currentThread).f1013a.mo546z();
        }
        return null;
    }

    protected static ForkJoinTask<?> pollTask() {
        Thread currentThread = Thread.currentThread();
        if (!(currentThread instanceof ForkJoinWorkerThread)) {
            return null;
        }
        ForkJoinWorkerThread bVar = (ForkJoinWorkerThread) currentThread;
        return bVar.f1013a.mo545x(bVar.f1014b);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        Object readObject = objectInputStream.readObject();
        if (readObject != null) {
            m1016j((Throwable) readObject);
        }
    }

    static void rethrow(Throwable th) {
        uncheckedThrow(th);
    }

    static <T extends Throwable> void uncheckedThrow(Throwable th) {
        if (th != null) {
            throw th;
        }
        throw new Error("Unknown Exception");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getException());
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return (m1015i(CANCELLED) & -268435456) == CANCELLED;
    }

    public final boolean compareAndSetForkJoinTaskTag(short s, short s2) {
        int i;
        do {
            i = this.status;
            if (((short) i) != s) {
                return false;
            }
        } while (!f963d.compareAndSwapInt(this, f964e, i, (SMASK & s2) | (-65536 & i)));
        return true;
    }

    public void complete(V v) {
        try {
            setRawResult(v);
            m1015i(-268435456);
        } catch (Throwable th) {
            m1016j(th);
        }
    }

    public void completeExceptionally(Throwable th) {
        if (!(th instanceof RuntimeException) && !(th instanceof Error)) {
            th = new RuntimeException(th);
        }
        m1016j(th);
    }

    /* access modifiers changed from: package-private */
    public final int doExec() {
        int i = this.status;
        if (i < 0) {
            return i;
        }
        try {
            if (exec()) {
                return m1015i(-268435456);
            }
            return i;
        } catch (Throwable th) {
            return m1016j(th);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean exec();

    public final ForkJoinTask<V> fork() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            ((ForkJoinWorkerThread) currentThread).f1014b.mo564k(this);
        } else {
            ForkJoinPool.f971n.mo533j(this);
        }
        return this;
    }

    @Override // java.util.concurrent.Future
    public final V get() {
        int c = (Thread.currentThread() instanceof ForkJoinWorkerThread ? m1009c() : m1012f()) & -268435456;
        if (c == CANCELLED) {
            throw new CancellationException();
        } else if (c != EXCEPTIONAL) {
            return getRawResult();
        } else {
            throw new ExecutionException(m1013g());
        }
    }

    public final Throwable getException() {
        int i = this.status & -268435456;
        if (i >= -268435456) {
            return null;
        }
        if (i == CANCELLED) {
            return new CancellationException();
        }
        return m1013g();
    }

    public final short getForkJoinTaskTag() {
        return (short) this.status;
    }

    public abstract V getRawResult();

    /* access modifiers changed from: package-private */
    public void internalPropagateException(Throwable th) {
    }

    /* access modifiers changed from: package-private */
    public final void internalWait(long j) {
        int i = this.status;
        if (i >= 0 && f963d.compareAndSwapInt(this, f964e, i, i | SIGNAL)) {
            synchronized (this) {
                if (this.status >= 0) {
                    try {
                        wait(j);
                    } catch (InterruptedException unused) {
                    }
                } else {
                    notifyAll();
                }
            }
        }
    }

    public final V invoke() {
        int b = m1008b() & -268435456;
        if (b != -268435456) {
            m1014h(b);
        }
        return getRawResult();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return (this.status & -268435456) == CANCELLED;
    }

    public final boolean isCompletedAbnormally() {
        return this.status < -268435456;
    }

    public final boolean isCompletedNormally() {
        return (this.status & -268435456) == -268435456;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.status < 0;
    }

    public final V join() {
        int c = m1009c() & -268435456;
        if (c != -268435456) {
            m1014h(c);
        }
        return getRawResult();
    }

    public final void quietlyComplete() {
        m1015i(-268435456);
    }

    public final void quietlyInvoke() {
        m1008b();
    }

    public final void quietlyJoin() {
        m1009c();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final int recordExceptionalCompletion(Throwable th) {
        int i = this.status;
        if (i < 0) {
            return i;
        }
        int identityHashCode = System.identityHashCode(this);
        ReentrantLock reentrantLock = f961b;
        reentrantLock.lock();
        try {
            m1010d();
            C0344a[] aVarArr = f960a;
            int length = identityHashCode & (aVarArr.length - 1);
            C0344a aVar = aVarArr[length];
            while (true) {
                if (aVar == null) {
                    aVarArr[length] = new C0344a(this, th, aVarArr[length], f962c);
                    break;
                } else if (aVar.get() == this) {
                    break;
                } else {
                    aVar = aVar.f966b;
                }
            }
            reentrantLock.unlock();
            return m1015i(EXCEPTIONAL);
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public void reinitialize() {
        if ((this.status & -268435456) == EXCEPTIONAL) {
            m1007a();
        } else {
            this.status = 0;
        }
    }

    public final short setForkJoinTaskTag(short s) {
        Unsafe unsafe;
        long j;
        int i;
        do {
            unsafe = f963d;
            j = f964e;
            i = this.status;
        } while (!unsafe.compareAndSwapInt(this, j, i, (-65536 & i) | (SMASK & s)));
        return (short) i;
    }

    /* access modifiers changed from: protected */
    public abstract void setRawResult(V v);

    public boolean tryUnfork() {
        Thread currentThread = Thread.currentThread();
        if (currentThread instanceof ForkJoinWorkerThread) {
            return ((ForkJoinWorkerThread) currentThread).f1014b.mo570q(this);
        }
        return ForkJoinPool.f971n.mo523J(this);
    }

    public static <T> ForkJoinTask<T> adapt(Runnable runnable, T t) {
        return new AdaptedRunnable(runnable, t);
    }

    public static <T> ForkJoinTask<T> adapt(Callable<? extends T> callable) {
        return new AdaptedCallable(callable);
    }

    public static void invokeAll(ForkJoinTask<?>... forkJoinTaskArr) {
        int length = forkJoinTaskArr.length - 1;
        Throwable th = null;
        for (int i = length; i >= 0; i--) {
            ForkJoinTask<?> forkJoinTask = forkJoinTaskArr[i];
            if (forkJoinTask == null) {
                if (th == null) {
                    th = new NullPointerException();
                }
            } else if (i != 0) {
                forkJoinTask.fork();
            } else if (forkJoinTask.m1008b() < -268435456 && th == null) {
                th = forkJoinTask.getException();
            }
        }
        for (int i2 = 1; i2 <= length; i2++) {
            ForkJoinTask<?> forkJoinTask2 = forkJoinTaskArr[i2];
            if (forkJoinTask2 != null) {
                if (th != null) {
                    forkJoinTask2.cancel(false);
                } else if (forkJoinTask2.m1009c() < -268435456) {
                    th = forkJoinTask2.getException();
                }
            }
        }
        if (th != null) {
            rethrow(th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052 A[LOOP:0: B:21:0x0052->B:59:0x0052, LOOP_START] */
    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) {
        int i;
        int doExec;
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            int i2 = this.status;
            if (i2 >= 0 && nanos > f964e) {
                long nanoTime = System.nanoTime() + nanos;
                if (nanoTime == f964e) {
                    nanoTime = 1;
                }
                Thread currentThread = Thread.currentThread();
                if (currentThread instanceof ForkJoinWorkerThread) {
                    ForkJoinWorkerThread bVar = (ForkJoinWorkerThread) currentThread;
                    i2 = bVar.f1013a.mo524a(bVar.f1014b, this, nanoTime);
                } else {
                    if (this instanceof CountedCompleter) {
                        doExec = ForkJoinPool.f971n.mo529i((CountedCompleter) this, 0);
                    } else if (ForkJoinPool.f971n.mo523J(this)) {
                        doExec = doExec();
                    } else {
                        i2 = 0;
                        if (i2 >= 0) {
                            while (true) {
                                i = this.status;
                                if (i < 0) {
                                    break;
                                }
                                long nanoTime2 = nanoTime - System.nanoTime();
                                if (nanoTime2 <= f964e) {
                                    break;
                                }
                                long millis = TimeUnit.NANOSECONDS.toMillis(nanoTime2);
                                if (millis > f964e && f963d.compareAndSwapInt(this, f964e, i, i | SIGNAL)) {
                                    synchronized (this) {
                                        if (this.status >= 0) {
                                            wait(millis);
                                        } else {
                                            notifyAll();
                                        }
                                    }
                                }
                            }
                            i2 = i;
                        }
                    }
                    i2 = doExec;
                    if (i2 >= 0) {
                    }
                }
            }
            if (i2 >= 0) {
                i2 = this.status;
            }
            int i3 = i2 & -268435456;
            if (i3 == -268435456) {
                return getRawResult();
            }
            if (i3 == CANCELLED) {
                throw new CancellationException();
            } else if (i3 != EXCEPTIONAL) {
                throw new TimeoutException();
            } else {
                throw new ExecutionException(m1013g());
            }
        } else {
            throw new InterruptedException();
        }
    }

    public static <T extends ForkJoinTask<?>> Collection<T> invokeAll(Collection<T> collection) {
        if (!(collection instanceof RandomAccess) || !(collection instanceof List)) {
            invokeAll((ForkJoinTask[]) collection.toArray(new ForkJoinTask[0]));
            return collection;
        }
        List list = (List) collection;
        Throwable th = null;
        int size = list.size() - 1;
        for (int i = size; i >= 0; i--) {
            ForkJoinTask forkJoinTask = (ForkJoinTask) list.get(i);
            if (forkJoinTask == null) {
                if (th == null) {
                    th = new NullPointerException();
                }
            } else if (i != 0) {
                forkJoinTask.fork();
            } else if (forkJoinTask.m1008b() < -268435456 && th == null) {
                th = forkJoinTask.getException();
            }
        }
        for (int i2 = 1; i2 <= size; i2++) {
            ForkJoinTask forkJoinTask2 = (ForkJoinTask) list.get(i2);
            if (forkJoinTask2 != null) {
                if (th != null) {
                    forkJoinTask2.cancel(false);
                } else if (forkJoinTask2.m1009c() < -268435456) {
                    th = forkJoinTask2.getException();
                }
            }
        }
        if (th != null) {
            rethrow(th);
        }
        return collection;
    }
}
