package java9.util.concurrent;

import sun.misc.Unsafe;

public abstract class CountedCompleter<T> extends ForkJoinTask<T> {

    /* renamed from: f */
    private static final Unsafe f958f;

    /* renamed from: g */
    private static final long f959g;
    private static final long serialVersionUID = 5232453752276485070L;
    final CountedCompleter<?> completer;
    volatile int pending;

    static {
        Unsafe unsafe = UnsafeAccess.f1031a;
        f958f = unsafe;
        try {
            f959g = unsafe.objectFieldOffset(CountedCompleter.class.getDeclaredField("pending"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    protected CountedCompleter(CountedCompleter<?> countedCompleter, int i) {
        this.completer = countedCompleter;
        this.pending = i;
    }

    public final void addToPendingCount(int i) {
        Unsafe unsafe;
        long j;
        int i2;
        do {
            unsafe = f958f;
            j = f959g;
            i2 = this.pending;
        } while (!unsafe.compareAndSwapInt(this, j, i2, i2 + i));
    }

    public final boolean compareAndSetPendingCount(int i, int i2) {
        return f958f.compareAndSwapInt(this, f959g, i, i2);
    }

    @Override // java9.util.concurrent.ForkJoinTask
    public void complete(T t) {
        setRawResult(t);
        onCompletion(this);
        quietlyComplete();
        CountedCompleter<?> countedCompleter = this.completer;
        if (countedCompleter != null) {
            countedCompleter.tryComplete();
        }
    }

    public abstract void compute();

    public final int decrementPendingCountUnlessZero() {
        int i;
        do {
            i = this.pending;
            if (i == 0) {
                break;
            }
        } while (!f958f.compareAndSwapInt(this, f959g, i, i - 1));
        return i;
    }

    /* access modifiers changed from: protected */
    @Override // java9.util.concurrent.ForkJoinTask
    public final boolean exec() {
        compute();
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java9.util.concurrent.CountedCompleter<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final CountedCompleter<?> firstComplete() {
        int i;
        do {
            i = this.pending;
            if (i == 0) {
                return this;
            }
        } while (!f958f.compareAndSwapInt(this, f959g, i, i - 1));
        return null;
    }

    public final CountedCompleter<?> getCompleter() {
        return this.completer;
    }

    public final int getPendingCount() {
        return this.pending;
    }

    @Override // java9.util.concurrent.ForkJoinTask
    public T getRawResult() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java9.util.concurrent.CountedCompleter, java9.util.concurrent.CountedCompleter<?> */
    public final CountedCompleter<?> getRoot() {
        CountedCompleter countedCompleter = this;
        while (true) {
            CountedCompleter countedCompleter2 = countedCompleter.completer;
            if (countedCompleter2 == null) {
                return countedCompleter;
            }
            countedCompleter = countedCompleter2;
        }
    }

    public final void helpComplete(int i) {
        if (i > 0 && this.status >= 0) {
            Thread currentThread = Thread.currentThread();
            if (currentThread instanceof ForkJoinWorkerThread) {
                ForkJoinWorkerThread bVar = (ForkJoinWorkerThread) currentThread;
                bVar.f1013a.mo536q(bVar.f1014b, this, i);
                return;
            }
            ForkJoinPool.f971n.mo529i(this, i);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // java9.util.concurrent.ForkJoinTask
    public void internalPropagateException(Throwable th) {
        CountedCompleter<?> countedCompleter;
        CountedCompleter<?> countedCompleter2 = this;
        CountedCompleter<?> countedCompleter3 = countedCompleter2;
        while (countedCompleter2.onExceptionalCompletion(th, countedCompleter3) && (countedCompleter = countedCompleter2.completer) != null && countedCompleter.status >= 0 && countedCompleter.recordExceptionalCompletion(th) == Integer.MIN_VALUE) {
            countedCompleter3 = countedCompleter2;
            countedCompleter2 = countedCompleter;
        }
    }

    public final CountedCompleter<?> nextComplete() {
        CountedCompleter<?> countedCompleter = this.completer;
        if (countedCompleter != null) {
            return countedCompleter.firstComplete();
        }
        quietlyComplete();
        return null;
    }

    public void onCompletion(CountedCompleter<?> countedCompleter) {
    }

    public boolean onExceptionalCompletion(Throwable th, CountedCompleter<?> countedCompleter) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java9.util.concurrent.CountedCompleter<?> */
    public final void propagateCompletion() {
        CountedCompleter countedCompleter = this;
        while (true) {
            int i = countedCompleter.pending;
            if (i == 0) {
                CountedCompleter countedCompleter2 = countedCompleter.completer;
                if (countedCompleter2 == null) {
                    countedCompleter.quietlyComplete();
                    return;
                }
                countedCompleter = countedCompleter2;
            } else if (f958f.compareAndSwapInt(countedCompleter, f959g, i, i - 1)) {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: java9.util.concurrent.CountedCompleter<?> */
    public final void quietlyCompleteRoot() {
        CountedCompleter countedCompleter = this;
        while (true) {
            CountedCompleter countedCompleter2 = countedCompleter.completer;
            if (countedCompleter2 == null) {
                countedCompleter.quietlyComplete();
                return;
            }
            countedCompleter = countedCompleter2;
        }
    }

    public final void setPendingCount(int i) {
        this.pending = i;
    }

    /* access modifiers changed from: protected */
    @Override // java9.util.concurrent.ForkJoinTask
    public void setRawResult(T t) {
    }

    public final void tryComplete() {
        CountedCompleter<?> countedCompleter = this;
        CountedCompleter<?> countedCompleter2 = countedCompleter;
        while (true) {
            int i = countedCompleter.pending;
            if (i == 0) {
                countedCompleter.onCompletion(countedCompleter2);
                CountedCompleter<?> countedCompleter3 = countedCompleter.completer;
                if (countedCompleter3 == null) {
                    countedCompleter.quietlyComplete();
                    return;
                } else {
                    countedCompleter2 = countedCompleter;
                    countedCompleter = countedCompleter3;
                }
            } else if (f958f.compareAndSwapInt(countedCompleter, f959g, i, i - 1)) {
                return;
            }
        }
    }

    protected CountedCompleter(CountedCompleter<?> countedCompleter) {
        this.completer = countedCompleter;
    }

    protected CountedCompleter() {
        this.completer = null;
    }
}
