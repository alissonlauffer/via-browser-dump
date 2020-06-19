package mark.via.util;

import android.os.Handler;
import android.os.Looper;
import java.lang.Thread;

/* compiled from: CrashGot */
public final class d {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static c f480a;
    private static boolean b;

    /* compiled from: CrashGot */
    class a implements Runnable {
        a() {
        }

        public void run() {
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th) {
                    if (!(th instanceof QuitCockroachException)) {
                        if (d.f480a != null) {
                            d.f480a.a(Looper.getMainLooper().getThread(), th);
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    /* compiled from: CrashGot */
    class b implements Thread.UncaughtExceptionHandler {
        b() {
        }

        public void uncaughtException(Thread thread, Throwable th) {
            if (d.f480a != null) {
                d.f480a.a(thread, th);
            }
        }
    }

    /* compiled from: CrashGot */
    public interface c {
        void a(Thread thread, Throwable th);
    }

    public static synchronized void a(c cVar) {
        synchronized (d.class) {
            if (!b) {
                b = true;
                f480a = cVar;
                new Handler(Looper.getMainLooper()).post(new a());
                Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(new b());
            }
        }
    }
}
