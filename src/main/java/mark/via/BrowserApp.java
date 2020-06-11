package mark.via;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.tuyafeng.nuwa.Nuwa;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import mark.via.component.AppComponent;
import mark.via.component.AppModule;
import mark.via.component.DaggerAppComponent;
import mark.via.flurry.FlurryHelper;
import timber.log.Timber;

public class BrowserApp extends Application {

    /* renamed from: b */
    private static final Executor f1190b = Executors.newSingleThreadExecutor();

    /* renamed from: c */
    private static final Executor f1191c = Executors.newCachedThreadPool();

    /* renamed from: a */
    public AppComponent f1192a;

    /* renamed from: a */
    public static BrowserApp m1387a(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof BrowserApp) {
            return (BrowserApp) applicationContext;
        }
        throw new IllegalArgumentException("context must be from BrowserApp");
    }

    /* renamed from: b */
    public static Executor m1388b() {
        return f1190b;
    }

    /* renamed from: c */
    public static Executor m1389c() {
        return f1191c;
    }

    /* renamed from: d */
    private void m1390d() {
        DaggerAppComponent.C0445b d = DaggerAppComponent.m1658d();
        d.mo1027a(new AppModule(this));
        this.f1192a = d.mo1028b();
    }

    /* renamed from: e */
    private void m1391e() {
        Nuwa.m916c(new C0403a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void mo781g(Thread thread, Throwable th) {
        try {
            Timber.m972b("Exception Happend\n" + thread + "\n" + Nuwa.m915b(th), new Object[0]);
            Toast.makeText(this, "Exception Happend\n" + thread + "\n" + th.toString(), 0).show();
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void mo782i(Thread thread, Throwable th) {
        new Handler(Looper.getMainLooper()).post(new RunnableC0404b(this, thread, th));
    }

    public void onCreate() {
        super.onCreate();
        m1390d();
        m1391e();
        FlurryHelper.m1681a().mo1034b(this, this.f1192a.mo1007c().mo1181r());
    }
}
