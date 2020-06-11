package mark.via.util;

import a.a.b.o.c;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import mark.via.gp.R;
import mark.via.ui.activity.BrowserActivity;

/* compiled from: AppUtils */
public final class a {

    /* renamed from: mark.via.util.a$a  reason: collision with other inner class name */
    /* compiled from: AppUtils */
    class C0052a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f473a;
        final /* synthetic */ List b;

        C0052a(Context context, List list) {
            this.f473a = context;
            this.b = list;
        }

        public void onClick(View view) {
            List list = this.b;
            ((Activity) this.f473a).requestPermissions((String[]) list.toArray(new String[list.size()]), 111);
        }
    }

    /* compiled from: AppUtils */
    class b extends c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f474a;

        b(Context context) {
            this.f474a = context;
        }

        @Override // a.a.b.o.c
        public void a() {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + a.a(this.f474a)));
            intent.setFlags(805306368);
            this.f474a.startActivity(intent);
        }
    }

    public static String a(Context context, boolean z) {
        mark.via.f.a b2 = mark.via.f.a.b(context);
        StringBuilder sb = new StringBuilder();
        sb.append(mark.via.b.a.i);
        sb.append("/");
        String o = b2.o();
        if (z) {
            try {
                o = URLEncoder.encode(o, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        sb.append(o);
        sb.append("/");
        return sb.toString();
    }

    public static boolean a(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    public static int b(Context context) {
        return b(context, context.getPackageName());
    }

    public static String c(Context context) {
        return c(context, context.getPackageName());
    }

    public static void d(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            a(context, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.ACCESS_FINE_LOCATION");
        }
    }

    public static void e(Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(2, 0);
        }
    }

    private static void f(Context context) {
        new a.a.b.o.a((Activity) context, (int) R.string.bi, 17039370, new b(context)).h();
    }

    private static int b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String c(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean c() {
        return mark.via.b.a.b.equalsIgnoreCase("CN");
    }

    public static boolean b() {
        return mark.via.b.a.c.equalsIgnoreCase("ar");
    }

    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(Activity activity, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setComponent(null);
        if (Build.VERSION.SDK_INT >= 15) {
            intent.setSelector(null);
        }
        intent.setData(Uri.parse("market://details?id=" + str));
        try {
            activity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append(c() ? "http://coolapk.com/apk/" : "https://play.google.com/store/apps/details?id=");
            sb.append(str);
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(sb.toString()), activity, BrowserActivity.class));
        }
    }

    public static boolean a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null || !packageInfo.applicationInfo.enabled) {
            return false;
        }
        return true;
    }

    public static boolean a(Context context, int i) {
        if (Build.VERSION.SDK_INT < 26) {
            return a(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        } else if (i == 0) {
            return a(context, "android.permission.READ_EXTERNAL_STORAGE");
        } else if (i != 1) {
            return a(context, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
        } else {
            return a(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
    }

    private static boolean a(Context context, String... strArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (context.checkSelfPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            if (arrayList.size() > 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getResources().getString(R.string.f2));
                if (arrayList.contains("android.permission.WRITE_EXTERNAL_STORAGE") || arrayList.contains("android.permission.READ_EXTERNAL_STORAGE")) {
                    sb.append(context.getResources().getString(R.string.ho));
                }
                if (arrayList.contains("android.permission.ACCESS_FINE_LOCATION")) {
                    sb.append(context.getResources().getString(R.string.ei));
                }
                a.a.b.i.c cVar = (a.a.b.i.c) new a.a.b.i.c(context).b(R.string.cl);
                cVar.c(sb.toString().trim());
                cVar.c(false);
                a.a.b.i.c cVar2 = cVar;
                cVar2.b(false);
                ((a.a.b.i.c) cVar2.c(17039370, new C0052a(context, arrayList))).g();
            } else {
                ((Activity) context).requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 111);
            }
        }
        if (arrayList.size() <= 0) {
            return true;
        }
        return false;
    }

    public static void a(Context context, int i, int[] iArr) {
        if (i == 111) {
            int i2 = 0;
            boolean z = true;
            boolean z2 = iArr.length == 0;
            int length = iArr.length;
            while (true) {
                if (i2 >= length) {
                    z = z2;
                    break;
                } else if (iArr[i2] != 0) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                f(context);
            }
        }
    }

    public static void a(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt < '!' || charAt > '~') {
                return false;
            }
        }
        return true;
    }

    public static String a() {
        return c() ? "江流天地外，山色有无中。" : "Less is more.";
    }
}
