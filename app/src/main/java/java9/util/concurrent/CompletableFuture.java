package java9.util.concurrent;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.LockSupport;
import java9.util.concurrent.ForkJoinPool;
import p011c.p012a.Objects;
import sun.misc.Unsafe;

public class CompletableFuture<T> implements Future<T> {

    /* renamed from: c */
    static final C0341a f947c = new C0341a(null);

    /* renamed from: d */
    private static final boolean f948d;

    /* renamed from: e */
    private static final Executor f949e;

    /* renamed from: f */
    private static final Unsafe f950f;

    /* renamed from: g */
    private static final long f951g;

    /* renamed from: h */
    private static final long f952h;

    /* renamed from: i */
    private static final long f953i;

    /* renamed from: a */
    volatile Object f954a;

    /* renamed from: b */
    volatile Completion f955b;

    /* access modifiers changed from: package-private */
    public static final class AsyncRun extends ForkJoinTask<Void> implements Runnable, AbstractC0342b {
        CompletableFuture<Void> dep;

        /* renamed from: fn */
        Runnable f956fn;

        AsyncRun(CompletableFuture<Void> completableFuture, Runnable runnable) {
            this.dep = completableFuture;
            this.f956fn = runnable;
        }

        @Override // java9.util.concurrent.ForkJoinTask
        public final boolean exec() {
            run();
            return false;
        }

        @Override // java9.util.concurrent.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable;
            CompletableFuture<Void> completableFuture = this.dep;
            if (completableFuture != null && (runnable = this.f956fn) != null) {
                this.dep = null;
                this.f956fn = null;
                if (completableFuture.f954a == null) {
                    try {
                        runnable.run();
                        completableFuture.mo444e();
                    } catch (Throwable th) {
                        completableFuture.mo445f(th);
                    }
                }
                completableFuture.mo452k();
            }
        }

        public final void setRawResult(Void r1) {
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class Completion extends ForkJoinTask<Void> implements Runnable, AbstractC0342b {
        volatile Completion next;

        Completion() {
        }

        @Override // java9.util.concurrent.ForkJoinTask
        public final boolean exec() {
            tryFire(1);
            return false;
        }

        @Override // java9.util.concurrent.ForkJoinTask
        public final Void getRawResult() {
            return null;
        }

        /* access modifiers changed from: package-private */
        public abstract boolean isLive();

        @Override // java.lang.Runnable
        public final void run() {
            tryFire(1);
        }

        public final void setRawResult(Void r1) {
        }

        /* access modifiers changed from: package-private */
        public abstract CompletableFuture<?> tryFire(int i);
    }

    /* access modifiers changed from: package-private */
    public static final class Signaller extends Completion implements ForkJoinPool.AbstractC0351e {
        final long deadline;
        boolean interrupted;
        final boolean interruptible;
        long nanos;
        volatile Thread thread = Thread.currentThread();

        Signaller(boolean z, long j, long j2) {
            this.interruptible = z;
            this.nanos = j;
            this.deadline = j2;
        }

        @Override // java9.util.concurrent.ForkJoinPool.AbstractC0351e
        public boolean block() {
            while (!isReleasable()) {
                if (this.deadline == 0) {
                    LockSupport.park(this);
                } else {
                    LockSupport.parkNanos(this, this.nanos);
                }
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        @Override // java9.util.concurrent.CompletableFuture.Completion
        public final boolean isLive() {
            return this.thread != null;
        }

        @Override // java9.util.concurrent.ForkJoinPool.AbstractC0351e
        public boolean isReleasable() {
            if (Thread.interrupted()) {
                this.interrupted = true;
            }
            if (this.interrupted && this.interruptible) {
                return true;
            }
            long j = this.deadline;
            if (j != 0) {
                if (this.nanos <= 0) {
                    return true;
                }
                long nanoTime = j - System.nanoTime();
                this.nanos = nanoTime;
                if (nanoTime <= 0) {
                    return true;
                }
            }
            if (this.thread == null) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        @Override // java9.util.concurrent.CompletableFuture.Completion
        public final CompletableFuture<?> tryFire(int i) {
            Thread thread2 = this.thread;
            if (thread2 != null) {
                this.thread = null;
                LockSupport.unpark(thread2);
            }
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: java9.util.concurrent.CompletableFuture$a */
    public static final class C0341a {

        /* renamed from: a */
        final Throwable f957a;

        C0341a(Throwable th) {
            this.f957a = th;
        }
    }

    /* renamed from: java9.util.concurrent.CompletableFuture$b */
    public interface AbstractC0342b {
    }

    /* renamed from: java9.util.concurrent.CompletableFuture$c */
    static final class ExecutorC0343c implements Executor {
        ExecutorC0343c() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }

    static {
        boolean z = true;
        if (ForkJoinPool.m1029n() <= 1) {
            z = false;
        }
        f948d = z;
        f949e = z ? ForkJoinPool.m1022d() : new ExecutorC0343c();
        Unsafe unsafe = UnsafeAccess.f1031a;
        f950f = unsafe;
        try {
            f951g = unsafe.objectFieldOffset(CompletableFuture.class.getDeclaredField("a"));
            f952h = unsafe.objectFieldOffset(CompletableFuture.class.getDeclaredField("b"));
            f953i = unsafe.objectFieldOffset(Completion.class.getDeclaredField("next"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /* renamed from: a */
    static CompletableFuture<Void> m990a(Executor executor, Runnable runnable) {
        Objects.m125a(runnable);
        CompletableFuture<Void> completableFuture = new CompletableFuture<>();
        executor.execute(new AsyncRun(completableFuture, runnable));
        return completableFuture;
    }

    /* renamed from: b */
    static boolean m991b(Completion completion, Completion completion2, Completion completion3) {
        return f950f.compareAndSwapObject(completion, f953i, completion2, completion3);
    }

    /* renamed from: h */
    static C0341a m992h(Throwable th) {
        if (!(th instanceof CompletionException)) {
            th = new CompletionException(th);
        }
        return new C0341a(th);
    }

    /* renamed from: j */
    static void m993j(Completion completion, Completion completion2) {
        f950f.putOrderedObject(completion, f953i, completion2);
    }

    /* renamed from: m */
    private static Object m994m(Object obj) {
        Throwable cause;
        if (obj == null) {
            throw new InterruptedException();
        } else if (!(obj instanceof C0341a)) {
            return obj;
        } else {
            Throwable th = ((C0341a) obj).f957a;
            if (th == null) {
                return null;
            }
            if (!(th instanceof CancellationException)) {
                if ((th instanceof CompletionException) && (cause = th.getCause()) != null) {
                    th = cause;
                }
                throw new ExecutionException(th);
            }
            throw ((CancellationException) th);
        }
    }

    /* renamed from: n */
    public static CompletableFuture<Void> m995n(Runnable runnable) {
        return m990a(f949e, runnable);
    }

    /* renamed from: o */
    private Object m996o(long j) {
        Object obj;
        if (Thread.interrupted()) {
            return null;
        }
        if (j > 0) {
            long nanoTime = System.nanoTime() + j;
            if (nanoTime == 0) {
                nanoTime = 1;
            }
            boolean z = false;
            Signaller signaller = null;
            while (true) {
                obj = this.f954a;
                if (obj != null) {
                    break;
                } else if (signaller == null) {
                    Signaller signaller2 = new Signaller(true, j, nanoTime);
                    if (Thread.currentThread() instanceof ForkJoinWorkerThread) {
                        ForkJoinPool.m1031p(mo446g(), signaller2);
                    }
                    signaller = signaller2;
                } else if (!z) {
                    z = mo454p(signaller);
                } else if (signaller.nanos <= 0) {
                    break;
                } else {
                    try {
                        ForkJoinPool.m1033u(signaller);
                    } catch (InterruptedException unused) {
                        signaller.interrupted = true;
                    }
                    if (signaller.interrupted) {
                        break;
                    }
                }
            }
            if (signaller != null && z) {
                signaller.thread = null;
                if (obj == null) {
                    mo443d();
                }
            }
            if (!(obj == null && (obj = this.f954a) == null)) {
                mo452k();
            }
            if (obj != null || (signaller != null && signaller.interrupted)) {
                return obj;
            }
        }
        throw new TimeoutException();
    }

    /* renamed from: q */
    private Object m997q(boolean z) {
        Object obj;
        boolean z2 = false;
        Signaller signaller = null;
        while (true) {
            obj = this.f954a;
            if (obj == null) {
                if (signaller != null) {
                    if (z2) {
                        try {
                            ForkJoinPool.m1033u(signaller);
                        } catch (InterruptedException unused) {
                            signaller.interrupted = true;
                        }
                        if (signaller.interrupted && z) {
                            break;
                        }
                    } else {
                        z2 = mo454p(signaller);
                    }
                } else {
                    signaller = new Signaller(z, 0, 0);
                    if (Thread.currentThread() instanceof ForkJoinWorkerThread) {
                        ForkJoinPool.m1031p(mo446g(), signaller);
                    }
                }
            } else {
                break;
            }
        }
        if (signaller != null && z2) {
            signaller.thread = null;
            if (!z && signaller.interrupted) {
                Thread.currentThread().interrupt();
            }
            if (obj == null) {
                mo443d();
            }
        }
        if (!(obj == null && (obj = this.f954a) == null)) {
            mo452k();
        }
        return obj;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final boolean mo441c(Completion completion, Completion completion2) {
        return f950f.compareAndSwapObject(this, f952h, completion, completion2);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        boolean z2 = this.f954a == null && mo449i(new C0341a(new CancellationException()));
        mo452k();
        if (z2 || isCancelled()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final void mo443d() {
        Completion completion;
        boolean z = false;
        while (true) {
            completion = this.f955b;
            if (completion == null || completion.isLive()) {
                break;
            }
            z = mo441c(completion, completion.next);
        }
        if (completion != null && !z) {
            Completion completion2 = completion.next;
            Completion completion3 = completion;
            while (completion2 != null) {
                Completion completion4 = completion2.next;
                if (completion2.isLive()) {
                    completion3 = completion2;
                    completion2 = completion4;
                } else {
                    m991b(completion3, completion2, completion4);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public final boolean mo444e() {
        return f950f.compareAndSwapObject(this, f951g, (Object) null, f947c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public final boolean mo445f(Throwable th) {
        return f950f.compareAndSwapObject(this, f951g, (Object) null, m992h(th));
    }

    /* renamed from: g */
    public Executor mo446g() {
        return f949e;
    }

    @Override // java.util.concurrent.Future
    public T get() {
        Object obj = this.f954a;
        if (obj == null) {
            obj = m997q(true);
        }
        return (T) m994m(obj);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public final boolean mo449i(Object obj) {
        return f950f.compareAndSwapObject(this, f951g, (Object) null, obj);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        Object obj = this.f954a;
        return (obj instanceof C0341a) && (((C0341a) obj).f957a instanceof CancellationException);
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f954a != null;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0001 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x0001 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java9.util.concurrent.CompletableFuture, java9.util.concurrent.CompletableFuture<?> */
    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public final void mo452k() {
        while (true) {
            CompletableFuture completableFuture = this;
            while (true) {
                Completion completion = completableFuture.f955b;
                completableFuture = completableFuture;
                if (completion == null) {
                    if (completableFuture != this && (completion = this.f955b) != null) {
                        completableFuture = this;
                    } else {
                        return;
                    }
                }
                Completion completion2 = completion.next;
                if (completableFuture.mo441c(completion, completion2)) {
                    if (completion2 != null) {
                        if (completableFuture != this) {
                            mo453l(completion);
                        } else {
                            m991b(completion, completion2, null);
                        }
                    }
                    completableFuture = completion.tryFire(-1);
                    if (completableFuture == null) {
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public final void mo453l(Completion completion) {
        do {
        } while (!mo454p(completion));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: p */
    public final boolean mo454p(Completion completion) {
        Completion completion2 = this.f955b;
        m993j(completion, completion2);
        return f950f.compareAndSwapObject(this, f952h, completion2, completion);
    }

    @Override // java.lang.Object
    public String toString() {
        String str;
        Object obj = this.f954a;
        int i = 0;
        for (Completion completion = this.f955b; completion != null; completion = completion.next) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (obj != null) {
            if (obj instanceof C0341a) {
                C0341a aVar = (C0341a) obj;
                if (aVar.f957a != null) {
                    str = "[Completed exceptionally: " + aVar.f957a + "]";
                }
            }
            str = "[Completed normally]";
        } else if (i == 0) {
            str = "[Not completed]";
        } else {
            str = "[Not completed, " + i + " dependents]";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j);
        Object obj = this.f954a;
        if (obj == null) {
            obj = m996o(nanos);
        }
        return (T) m994m(obj);
    }
}
