package p016e.p017a.p018a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: e.a.a.c */
/* compiled from: ExtraDownloader */
class ExtraDownloader {

    /* renamed from: b */
    private static volatile ExtraDownloader f924b;

    /* renamed from: c */
    private static final String[][] f925c = {new String[]{""}, new String[]{"com.dv.adm.pay", "com.dv.get.Main", "com.dv.adm.pay.AEditor", "ADM+"}, new String[]{"com.dv.adm", "com.dv.get.Main", "com.dv.adm.AEditor", "ADM"}, new String[]{"idm.internet.download.manager.plus", "idm.internet.download.manager.MainActivity", "idm.internet.download.manager.Downloader", "IDM+"}, new String[]{"idm.internet.download.manager", "idm.internet.download.manager.MainActivity", "idm.internet.download.manager.Downloader", "IDM"}, new String[]{"com.vanda_adm.vanda", "com.vanda_adm.vanda.MainActivity", "com.vanda_adm.vanda.ClipActivity", "QKADM"}};

    /* renamed from: a */
    private int f926a = 0;

    ExtraDownloader() {
    }

    /* renamed from: c */
    static ExtraDownloader m940c() {
        if (f924b == null) {
            synchronized (ExtraDownloader.class) {
                if (f924b == null) {
                    f924b = new ExtraDownloader();
                }
            }
        }
        return f924b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo401a(Activity activity, String str) {
        if (this.f926a != 0 && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setType("text/plain");
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", str);
            String[][] strArr = f925c;
            int i = this.f926a;
            intent.setComponent(new ComponentName(strArr[i][0], strArr[i][2]));
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String[][] mo402b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add("");
        arrayList2.add("");
        int length = f925c.length;
        PackageInfo packageInfo = null;
        for (int i = 1; i < length; i++) {
            try {
                packageInfo = packageManager.getPackageInfo(f925c[i][0], 1);
            } catch (Exception unused) {
            }
            if (packageInfo != null && packageInfo.applicationInfo.enabled) {
                arrayList.add(f925c[i][0]);
                arrayList2.add(packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
                packageInfo = null;
            }
        }
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        String[] strArr2 = (String[]) arrayList2.toArray(new String[0]);
        Log.d("ExtraDownloader", Arrays.toString(strArr2));
        Log.d("ExtraDownloader", Arrays.toString(strArr));
        return new String[][]{strArr, strArr2};
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo403d() {
        return this.f926a != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo404e(Activity activity) {
        if (this.f926a == 0) {
            return false;
        }
        Intent intent = new Intent();
        String[][] strArr = f925c;
        int i = this.f926a;
        intent.setClassName(strArr[i][0], strArr[i][1]);
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo405f(String str) {
        this.f926a = 0;
        if (!TextUtils.isEmpty(str)) {
            int length = f925c.length;
            for (int i = 0; i < length; i++) {
                if (str.equals(f925c[i][0])) {
                    this.f926a = i;
                    return;
                }
            }
        }
    }
}
