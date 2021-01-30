package com.tuyafeng.nuwa;

import android.os.Handler;
import android.os.Looper;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

/* renamed from: com.tuyafeng.nuwa.a */
/* compiled from: Nuwa */
public final class Nuwa {

    /* renamed from: a */
    private static AbstractC0334c f912a = null;

    /* renamed from: b */
    private static boolean f913b = false;

    /* renamed from: com.tuyafeng.nuwa.a$a */
    /* compiled from: Nuwa */
    class RunnableC0332a implements Runnable {
        RunnableC0332a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th) {
                    if (!(th instanceof NuwaException)) {
                        if (Nuwa.f912a != null) {
                            Nuwa.f912a.mo381a(Looper.getMainLooper().getThread(), th);
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* renamed from: com.tuyafeng.nuwa.a$b */
    /* compiled from: Nuwa */
    class C0333b implements Thread.UncaughtExceptionHandler {
        C0333b() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (Nuwa.f912a != null) {
                Nuwa.f912a.mo381a(thread, th);
            }
        }
    }

    /* renamed from: com.tuyafeng.nuwa.a$c */
    /* compiled from: Nuwa */
    public interface AbstractC0334c {
        /* renamed from: a */
        void mo381a(Thread thread, Throwable th);
    }

    /* renamed from: b */
    public static String m915b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th.printStackTrace(printWriter);
            return stringWriter.toString();
        } finally {
            printWriter.close();
        }
    }

    /* renamed from: c */
    public static synchronized void m916c(AbstractC0334c cVar) {
        synchronized (Nuwa.class) {
            if (!f913b) {
                f913b = true;
                f912a = cVar;
                new Handler(Looper.getMainLooper()).post(new RunnableC0332a());
                Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(new C0333b());
            }
        }
    }
}
