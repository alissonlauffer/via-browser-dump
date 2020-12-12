package mark.via.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.util.ArrayList;
import mark.lib.frogsupport.toast.FrogToast;
import mark.lib.frogsupport.toast.OnFrogToastListener;
import mark.via.constants.Constants;
import mark.via.gp.R;
import mark.via.preference.PreferenceManager;

/* renamed from: mark.via.n.c */
/* compiled from: AppUtils */
public final class AppUtils {

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.n.c$a */
    /* compiled from: AppUtils */
    public class C0493a extends OnFrogToastListener {

        /* renamed from: a */
        final /* synthetic */ Context f1513a;

        C0493a(Context context) {
            this.f1513a = context;
        }

        @Override // mark.lib.frogsupport.toast.OnFrogToastListener
        /* renamed from: a */
        public void mo778a() {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + AppUtils.m2054b(this.f1513a)));
            intent.setFlags(805306368);
            this.f1513a.startActivity(intent);
        }
    }

    /* renamed from: a */
    public static boolean m2053a(Context context, String str) {
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

    /* renamed from: b */
    public static String m2054b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static String m2055c(Context context) {
        PreferenceManager M = PreferenceManager.m1743M(context);
        try {
            return Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + M.mo1193v() + "/";
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: d */
    public static String m2056d() {
        return m2060h() ? "返景入深林，复照青苔上。" : "Less is more.";
    }

    /* renamed from: e */
    public static void m2057e(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    /* renamed from: f */
    public static boolean m2058f(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    /* renamed from: g */
    public static boolean m2059g() {
        return Constants.f1298c.equalsIgnoreCase("ar");
    }

    /* renamed from: h */
    public static boolean m2060h() {
        return Constants.f1297b.equalsIgnoreCase("CN");
    }

    /* renamed from: i */
    public static boolean m2061i(String str) {
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

    /* renamed from: j */
    public static boolean m2062j(Context context, int i, int[] iArr) {
        int i2 = 0;
        if (i != 111) {
            return false;
        }
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
            m2067o(context);
        }
        return z;
    }

    /* renamed from: k */
    public static boolean m2063k(Context context) {
        return m2064l(context, "android.permission.ACCESS_FINE_LOCATION");
    }

    /* renamed from: l */
    private static boolean m2064l(Context context, String... strArr) {
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
            ((Activity) context).requestPermissions((String[]) arrayList.toArray(new String[0]), 111);
        }
        if (arrayList.size() <= 0) {
            return true;
        }
        return false;
    }

    /* renamed from: m */
    public static boolean m2065m(Context context, int i) {
        if (Build.VERSION.SDK_INT < 26) {
            return m2064l(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        if (i == 0) {
            return m2064l(context, "android.permission.READ_EXTERNAL_STORAGE");
        }
        if (i != 1) {
            return m2064l(context, "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
        }
        return m2064l(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    /* renamed from: n */
    public static void m2066n(Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(2, 0);
        }
    }

    /* renamed from: o */
    private static void m2067o(Context context) {
        new FrogToast((Activity) context, (int) R.string.RES_2131558484, 17039370, new C0493a(context)).mo773m();
    }
}
