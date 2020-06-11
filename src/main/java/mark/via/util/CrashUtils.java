package mark.via.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mark.via.BrowserApp;
import mark.via.ui.activity.CrashActivity;

@SuppressLint({"NewApi"})
public final class CrashUtils {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static WeakReference<Activity> f470a = new WeakReference<>(null);
    /* access modifiers changed from: private */
    public static Class<? extends Activity> b = null;
    /* access modifiers changed from: private */
    public static Class<? extends Activity> c = null;
    /* access modifiers changed from: private */
    public static final EventListener d = null;

    public interface EventListener extends Serializable {
        void onCloseAppFromErrorActivity();

        void onRestartAppFromErrorActivity();
    }

    class a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Application f471a;
        final /* synthetic */ Thread.UncaughtExceptionHandler b;

        a(Application application, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f471a = application;
            this.b = uncaughtExceptionHandler;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            Log.e("CrashUtils", "App has crashed, executing CrashUtils's UncaughtExceptionHandler", th);
            if (CrashUtils.j(this.f471a)) {
                Log.e("CrashUtils", "App already crashed in the last 2 seconds, not starting custom error activity because we could enter a restart loop. Are you sure that your app does not crash directly on init?", th);
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                    return;
                }
            } else {
                CrashUtils.b(this.f471a, new Date().getTime());
                if (CrashUtils.b == null) {
                    Class unused = CrashUtils.b = CrashUtils.h(this.f471a);
                }
                if (CrashUtils.b(th, CrashUtils.b)) {
                    Log.e("CrashUtils", "Your application class or your error activity have crashed, the custom activity will not be launched!");
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.b;
                    if (uncaughtExceptionHandler2 != null) {
                        uncaughtExceptionHandler2.uncaughtException(thread, th);
                        return;
                    }
                } else {
                    Intent intent = new Intent(this.f471a, CrashUtils.b);
                    StringWriter stringWriter = new StringWriter();
                    th.printStackTrace(new PrintWriter(stringWriter));
                    String stringWriter2 = stringWriter.toString();
                    if (stringWriter2.length() > 131071) {
                        stringWriter2 = stringWriter2.substring(0, 131047) + " [stack trace too large]";
                    }
                    if (CrashUtils.c == null) {
                        Class unused2 = CrashUtils.c = CrashUtils.i(this.f471a);
                    }
                    intent.putExtra("mark.via.util.CrashUtils.EXTRA_STACK_TRACE", stringWriter2);
                    intent.putExtra("mark.via.util.CrashUtils.EXTRA_RESTART_ACTIVITY_CLASS", CrashUtils.c);
                    intent.putExtra("mark.via.util.CrashUtils.EXTRA_EVENT_LISTENER", CrashUtils.d);
                    intent.setFlags(268468224);
                    this.f471a.startActivity(intent);
                }
            }
            Activity activity = (Activity) CrashUtils.f470a.get();
            if (activity != null) {
                activity.finish();
                CrashUtils.f470a.clear();
            }
            CrashUtils.g();
        }
    }

    class b implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        int f472a = 0;

        b() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity.getClass() != CrashUtils.b) {
                WeakReference unused = CrashUtils.f470a = new WeakReference(activity);
            }
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            boolean z = true;
            int i = this.f472a + 1;
            this.f472a = i;
            if (i != 0) {
                z = false;
            }
            CrashUtils.a(z);
        }

        public void onActivityStopped(Activity activity) {
            boolean z = true;
            int i = this.f472a - 1;
            this.f472a = i;
            if (i != 0) {
                z = false;
            }
            CrashUtils.a(z);
        }
    }

    static /* synthetic */ boolean a(boolean z) {
        return z;
    }

    private static String f() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return a(str2);
        }
        return a(str) + " " + str2;
    }

    /* JADX DEBUG: Type inference failed for r2v11. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends android.app.Activity> */
    private static Class<? extends Activity> g(Context context) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent().setAction("mark.via.util.CrashUtils.RESTART").setPackage(context.getPackageName()), 64);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return null;
        }
        try {
            return Class.forName(queryIntentActivities.get(0).activityInfo.name);
        } catch (ClassNotFoundException e) {
            Log.e("CrashUtils", "Failed when resolving the restart activity class via intent filter, stack trace follows!", e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static Class<? extends Activity> h(Context context) {
        Class<? extends Activity> d2 = d(context);
        return d2 == null ? CrashActivity.class : d2;
    }

    /* access modifiers changed from: private */
    public static Class<? extends Activity> i(Context context) {
        Class<? extends Activity> g = g(context);
        return g == null ? f(context) : g;
    }

    /* access modifiers changed from: private */
    public static boolean j(Context context) {
        long e = e(context);
        long time = new Date().getTime();
        return e <= time && time - e < 2000;
    }

    public static void k(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 14) {
                Log.w("CrashUtils", "CrashUtils will be installed, but may not be reliable in API lower than 14");
            }
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler == null || !defaultUncaughtExceptionHandler.getClass().getName().startsWith("mark.via.util.CrashUtils")) {
                if (defaultUncaughtExceptionHandler != null && !defaultUncaughtExceptionHandler.getClass().getName().startsWith("com.android.internal.os")) {
                    Log.e("CrashUtils", "IMPORTANT WARNING! You already have an UncaughtExceptionHandler, are you sure this is correct? If you use ACRA, Crashlytics or similar libraries, you must initialize them AFTER CrashUtils! Installing anyway, but your original handler will not be called.");
                }
                BrowserApp a2 = BrowserApp.a(context);
                Thread.setDefaultUncaughtExceptionHandler(new a(a2, defaultUncaughtExceptionHandler));
                if (Build.VERSION.SDK_INT >= 14) {
                    a2.registerActivityLifecycleCallbacks(new b());
                }
                Log.i("CrashUtils", "CrashUtils has been installed.");
                return;
            }
            Log.e("CrashUtils", "You have already installed CrashUtils, doing nothing!");
        } catch (Throwable th) {
            Log.e("CrashUtils", "An unknown error occurred while installing CrashUtils, it may not have been properly initialized. Please report this as a bug if needed.", th);
        }
    }

    /* JADX DEBUG: Type inference failed for r2v11. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends android.app.Activity> */
    private static Class<? extends Activity> d(Context context) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent().setAction("mark.via.util.CrashUtils.ERROR").setPackage(context.getPackageName()), 64);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return null;
        }
        try {
            return Class.forName(queryIntentActivities.get(0).activityInfo.name);
        } catch (ClassNotFoundException e) {
            Log.e("CrashUtils", "Failed when resolving the error activity class via intent filter, stack trace follows!", e);
            return null;
        }
    }

    private static long e(Context context) {
        return context.getSharedPreferences("custom_activity_on_crash", 0).getLong("last_crash_timestamp", -1);
    }

    public static String c(Intent intent) {
        return intent.getStringExtra("mark.via.util.CrashUtils.EXTRA_STACK_TRACE");
    }

    public static Class<? extends Activity> b(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("mark.via.util.CrashUtils.EXTRA_RESTART_ACTIVITY_CLASS");
        if (serializableExtra instanceof Class) {
            return (Class) serializableExtra;
        }
        return null;
    }

    /* JADX DEBUG: Type inference failed for r3v10. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends android.app.Activity> */
    private static Class<? extends Activity> f(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            return null;
        }
        try {
            return Class.forName(launchIntentForPackage.getComponent().getClassName());
        } catch (ClassNotFoundException e) {
            Log.e("CrashUtils", "Failed when resolving the restart activity class via getLaunchIntentForPackage, stack trace follows!", e);
            return null;
        } catch (NullPointerException e2) {
            Log.e("CrashUtils", "Failed when resolving the restart activity class via getLaunchIntentForPackage, stack trace follows!", e2);
            return null;
        }
    }

    public static void a(Application application, String str) {
        Intent intent = new Intent(application, CrashActivity.class);
        intent.putExtra("mark.via.util.CrashUtils.EXTRA_STACK_TRACE", str);
        intent.setFlags(268468224);
        application.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public static boolean b(Throwable th, Class<? extends Activity> cls) {
        do {
            StackTraceElement[] stackTrace = th.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                if ((stackTraceElement.getClassName().equals("android.app.ActivityThread") && stackTraceElement.getMethodName().equals("handleBindApplication")) || stackTraceElement.getClassName().equals(cls.getName())) {
                    return true;
                }
            }
            th = th.getCause();
        } while (th != null);
        return false;
    }

    /* access modifiers changed from: private */
    public static void g() {
        Process.killProcess(Process.myPid());
        System.exit(10);
    }

    public static Map<String, String> a(Context context, Intent intent) {
        HashMap hashMap = new HashMap();
        hashMap.put("versionCode", String.valueOf(a.b(context)));
        hashMap.put("versionName", a.c(context));
        hashMap.put("deviceName", f());
        hashMap.put("androidVersion", String.valueOf(mark.via.b.a.g));
        hashMap.put("details", i.a(c(intent)));
        return hashMap;
    }

    /* access modifiers changed from: private */
    public static void b(Context context, long j) {
        context.getSharedPreferences("custom_activity_on_crash", 0).edit().putLong("last_crash_timestamp", j).apply();
    }

    public static EventListener a(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("mark.via.util.CrashUtils.EXTRA_EVENT_LISTENER");
        if (serializableExtra == null || !(serializableExtra instanceof EventListener)) {
            return null;
        }
        return (EventListener) serializableExtra;
    }

    public static void a(Activity activity, Intent intent, EventListener eventListener) {
        intent.addFlags(268468224);
        if (eventListener != null) {
            eventListener.onRestartAppFromErrorActivity();
        }
        activity.finish();
        activity.startActivity(intent);
        g();
    }

    public static void a(Activity activity, EventListener eventListener) {
        if (eventListener != null) {
            eventListener.onCloseAppFromErrorActivity();
        }
        activity.finish();
        g();
    }

    private static String a(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }
}
