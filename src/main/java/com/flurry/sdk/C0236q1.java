package com.flurry.sdk;

import com.flurry.sdk.AbstractC0075c3;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.flurry.sdk.q1 */
public class C0236q1<T extends AbstractC0075c3> {

    /* renamed from: e */
    private static final String f677e = "q1";

    /* renamed from: a */
    private final C0162i1<Object, T> f678a = new C0162i1<>();

    /* renamed from: b */
    private final HashMap<T, Object> f679b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<T, Future<?>> f680c = new HashMap<>();

    /* renamed from: d */
    private final ThreadPoolExecutor f681d;

    /* renamed from: com.flurry.sdk.q1$b */
    class C0240b extends ThreadPoolExecutor.DiscardPolicy {

        /* access modifiers changed from: package-private */
        /* renamed from: com.flurry.sdk.q1$b$a */
        public class C0241a extends AbstractRunnableC0040b3 {
            C0241a(C0240b bVar, AbstractC0075c3 c3Var) {
            }

            @Override // com.flurry.sdk.AbstractRunnableC0040b3
            /* renamed from: a */
            public final void mo121a() {
            }
        }

        C0240b() {
        }

        @Override // java.util.concurrent.ThreadPoolExecutor.DiscardPolicy, java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            super.rejectedExecution(runnable, threadPoolExecutor);
            AbstractC0075c3 a = C0236q1.m637a(runnable);
            if (a != null) {
                synchronized (C0236q1.this.f680c) {
                    C0236q1.this.f680c.remove(a);
                }
                C0236q1.this.m640d(a);
                new C0241a(this, a).run();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.q1$c */
    public class C0242c extends AbstractRunnableC0040b3 {

        /* renamed from: d */
        final /* synthetic */ AbstractC0075c3 f684d;

        C0242c(C0236q1 q1Var, AbstractC0075c3 c3Var) {
            this.f684d = c3Var;
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            this.f684d.mo147b();
        }
    }

    public C0236q1(String str, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        C0237a aVar = new C0237a(timeUnit, blockingQueue);
        this.f681d = aVar;
        aVar.setRejectedExecutionHandler(new C0240b());
        aVar.setThreadFactory(new ThreadFactoryC0283v2(str));
    }

    /* renamed from: a */
    static /* synthetic */ AbstractC0075c3 m637a(Runnable runnable) {
        if (runnable instanceof C0231p1) {
            return (AbstractC0075c3) ((C0231p1) runnable).mo307a();
        }
        if (runnable instanceof AbstractC0075c3) {
            return (AbstractC0075c3) runnable;
        }
        String str = f677e;
        C0260s1.m686c(6, str, "Unknown runnable class: " + runnable.getClass().getName());
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: d */
    private synchronized void m640d(T t) {
        m642h(this.f679b.get(t), t);
    }

    /* renamed from: g */
    private synchronized void m641g(T t) {
        Future<?> remove;
        if (t != null) {
            synchronized (this.f680c) {
                remove = this.f680c.remove(t);
            }
            m640d(t);
            if (remove != null) {
                remove.cancel(true);
            }
            new C0242c(this, t).run();
        }
    }

    /* renamed from: h */
    private synchronized void m642h(Object obj, T t) {
        this.f678a.mo236g(obj, t);
        this.f679b.remove(t);
    }

    /* renamed from: i */
    private synchronized void m643i(Object obj, T t) {
        this.f678a.mo233d(obj, t);
        this.f679b.put(t, obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.flurry.sdk.q1<T extends com.flurry.sdk.c3> */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    public final synchronized void mo308e(Object obj) {
        if (obj != null) {
            HashSet<AbstractC0075c3> hashSet = new HashSet();
            hashSet.addAll(this.f678a.mo230a(obj));
            for (AbstractC0075c3 c3Var : hashSet) {
                m641g(c3Var);
            }
        }
    }

    /* renamed from: f */
    public final synchronized void mo309f(Object obj, T t) {
        if (obj != null && t != null) {
            m643i(obj, t);
            this.f681d.submit(t);
        }
    }

    /* renamed from: com.flurry.sdk.q1$a */
    class C0237a extends ThreadPoolExecutor {

        /* access modifiers changed from: package-private */
        /* renamed from: com.flurry.sdk.q1$a$a */
        public class C0238a extends AbstractRunnableC0040b3 {
            C0238a(C0237a aVar, AbstractC0075c3 c3Var) {
            }

            @Override // com.flurry.sdk.AbstractRunnableC0040b3
            /* renamed from: a */
            public final void mo121a() {
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.flurry.sdk.q1$a$b */
        public class C0239b extends AbstractRunnableC0040b3 {
            C0239b(C0237a aVar, AbstractC0075c3 c3Var) {
            }

            @Override // com.flurry.sdk.AbstractRunnableC0040b3
            /* renamed from: a */
            public final void mo121a() {
            }
        }

        C0237a(TimeUnit timeUnit, BlockingQueue blockingQueue) {
            super(0, 5, 5000, timeUnit, blockingQueue);
        }

        /* access modifiers changed from: protected */
        @Override // java.util.concurrent.ThreadPoolExecutor
        public final void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
            AbstractC0075c3 a = C0236q1.m637a(runnable);
            if (a != null) {
                synchronized (C0236q1.this.f680c) {
                    C0236q1.this.f680c.remove(a);
                }
                C0236q1.this.m640d(a);
                new C0239b(this, a).run();
            }
        }

        /* access modifiers changed from: protected */
        @Override // java.util.concurrent.ThreadPoolExecutor
        public final void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            AbstractC0075c3 a = C0236q1.m637a(runnable);
            if (a != null) {
                new C0238a(this, a).run();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.HashMap */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: protected */
        @Override // java.util.concurrent.AbstractExecutorService
        public final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
            C0231p1 p1Var = new C0231p1(runnable, v);
            synchronized (C0236q1.this.f680c) {
                C0236q1.this.f680c.put((AbstractC0075c3) runnable, p1Var);
            }
            return p1Var;
        }

        /* access modifiers changed from: protected */
        @Override // java.util.concurrent.AbstractExecutorService
        public final <V> RunnableFuture<V> newTaskFor(Callable<V> callable) {
            throw new UnsupportedOperationException("Callable not supported");
        }
    }
}
