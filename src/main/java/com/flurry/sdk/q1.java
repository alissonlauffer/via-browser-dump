package com.flurry.sdk;

import com.flurry.sdk.c3;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class q1<T extends c3> {
    private static final String e = "q1";

    /* renamed from: a  reason: collision with root package name */
    private final i1<Object, T> f178a = new i1<>();
    private final HashMap<T, Object> b = new HashMap<>();
    /* access modifiers changed from: private */
    public final HashMap<T, Future<?>> c = new HashMap<>();
    private final ThreadPoolExecutor d;

    class b extends ThreadPoolExecutor.DiscardPolicy {

        class a extends b3 {
            a(b bVar, c3 c3Var) {
            }

            @Override // com.flurry.sdk.b3
            public final void a() {
            }
        }

        b() {
        }

        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            super.rejectedExecution(runnable, threadPoolExecutor);
            c3 a2 = q1.a(runnable);
            if (a2 != null) {
                synchronized (q1.this.c) {
                    q1.this.c.remove(a2);
                }
                q1.this.a(a2);
                new a(this, a2).run();
            }
        }
    }

    class c extends b3 {
        final /* synthetic */ c3 d;

        c(q1 q1Var, c3 c3Var) {
            this.d = c3Var;
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            this.d.b();
        }
    }

    public q1(String str, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        a aVar = new a(timeUnit, blockingQueue);
        this.d = aVar;
        aVar.setRejectedExecutionHandler(new b());
        this.d.setThreadFactory(new v2(str));
    }

    private synchronized void b(Object obj, T t) {
        this.f178a.b(obj, t);
        this.b.remove(t);
    }

    private synchronized void c(Object obj, T t) {
        this.f178a.a(obj, t);
        this.b.put(t, obj);
    }

    /* access modifiers changed from: private */
    public synchronized void a(T t) {
        b(this.b.get(t), t);
    }

    class a extends ThreadPoolExecutor {

        /* renamed from: com.flurry.sdk.q1$a$a  reason: collision with other inner class name */
        class C0021a extends b3 {
            C0021a(a aVar, c3 c3Var) {
            }

            @Override // com.flurry.sdk.b3
            public final void a() {
            }
        }

        class b extends b3 {
            b(a aVar, c3 c3Var) {
            }

            @Override // com.flurry.sdk.b3
            public final void a() {
            }
        }

        a(TimeUnit timeUnit, BlockingQueue blockingQueue) {
            super(0, 5, 5000, timeUnit, blockingQueue);
        }

        /* access modifiers changed from: protected */
        public final void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
            c3 a2 = q1.a(runnable);
            if (a2 != null) {
                synchronized (q1.this.c) {
                    q1.this.c.remove(a2);
                }
                q1.this.a(a2);
                new b(this, a2).run();
            }
        }

        /* access modifiers changed from: protected */
        public final void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            c3 a2 = q1.a(runnable);
            if (a2 != null) {
                new C0021a(this, a2).run();
            }
        }

        /* access modifiers changed from: protected */
        @Override // java.util.concurrent.AbstractExecutorService
        public final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
            V p1Var = new p1(runnable, v);
            synchronized (q1.this.c) {
                q1.this.c.put((c3) runnable, p1Var);
            }
            return p1Var;
        }

        /* access modifiers changed from: protected */
        @Override // java.util.concurrent.AbstractExecutorService
        public final <V> RunnableFuture<V> newTaskFor(Callable<V> callable) {
            throw new UnsupportedOperationException("Callable not supported");
        }
    }

    private synchronized void b(T t) {
        Future<?> remove;
        if (t != null) {
            synchronized (this.c) {
                remove = this.c.remove(t);
            }
            a((c3) t);
            if (remove != null) {
                remove.cancel(true);
            }
            new c(this, t).run();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        return;
     */
    public final synchronized void a(Object obj, T t) {
        if (obj != null && t != null) {
            c(obj, t);
            this.d.submit((Runnable) t);
        }
    }

    public final synchronized void a(Object obj) {
        if (obj != null) {
            HashSet<T> hashSet = new HashSet();
            hashSet.addAll(this.f178a.a(obj));
            for (T t : hashSet) {
                b(t);
            }
        }
    }

    static /* synthetic */ c3 a(Runnable runnable) {
        if (runnable instanceof p1) {
            return (c3) ((p1) runnable).a();
        }
        if (runnable instanceof c3) {
            return (c3) runnable;
        }
        String str = e;
        s1.a(6, str, "Unknown runnable class: " + runnable.getClass().getName());
        return null;
    }
}
