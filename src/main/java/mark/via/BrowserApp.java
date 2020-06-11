package mark.via;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import mark.via.util.CrashUtils;
import mark.via.util.d;

public class BrowserApp extends Application {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f235a = Executors.newSingleThreadExecutor();
    private static final Executor b = Executors.newCachedThreadPool();

    class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Application f236a;

        /* renamed from: mark.via.BrowserApp$a$a  reason: collision with other inner class name */
        class C0025a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Throwable f237a;
            final /* synthetic */ Thread b;

            C0025a(Throwable th, Thread thread) {
                this.f237a = th;
                this.b = thread;
            }

            public void run() {
                try {
                    StringWriter stringWriter = new StringWriter();
                    this.f237a.printStackTrace(new PrintWriter(stringWriter));
                    String stringWriter2 = stringWriter.toString();
                    a.a.b.p.d.a(stringWriter2);
                    if (stringWriter2.contains("android.webkit.WebView.<init>")) {
                        CrashUtils.a(a.this.f236a, stringWriter2);
                        return;
                    }
                    this.f237a.printStackTrace();
                    BrowserApp browserApp = BrowserApp.this;
                    Toast.makeText(browserApp, "Exception Happend\n" + this.b + "\n" + this.f237a.toString(), 0).show();
                } catch (Exception e) {
                    a.a.b.p.d.a(e);
                }
            }
        }

        a(Application application) {
            this.f236a = application;
        }

        @Override // mark.via.util.d.c
        public void a(Thread thread, Throwable th) {
            new Handler(Looper.getMainLooper()).post(new C0025a(th, thread));
        }
    }

    public static BrowserApp a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof BrowserApp) {
            return (BrowserApp) applicationContext;
        }
        throw new IllegalArgumentException("context must be from BrowserApp");
    }

    public static Executor b() {
        return b;
    }

    public void onCreate() {
        super.onCreate();
        a.a.b.p.d.a();
        d.a(new a(this));
        CrashUtils.k(this);
        mark.via.d.a.a().a(this, mark.via.f.a.b(this).k());
    }

    public static Executor a() {
        return f235a;
    }
}
