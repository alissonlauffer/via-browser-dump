package a.a.a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: ExtraDownloader */
class c {
    private static volatile c b;
    private static final String[][] c = {new String[]{""}, new String[]{"com.dv.adm.pay", "com.dv.get.Main", "com.dv.adm.pay.AEditor", "ADM+"}, new String[]{"com.dv.adm", "com.dv.get.Main", "com.dv.adm.AEditor", "ADM"}, new String[]{"idm.internet.download.manager.plus", "idm.internet.download.manager.MainActivity", "idm.internet.download.manager.Downloader", "IDM+"}, new String[]{"idm.internet.download.manager", "idm.internet.download.manager.MainActivity", "idm.internet.download.manager.Downloader", "IDM"}, new String[]{"com.vanda_adm.vanda", "com.vanda_adm.vanda.MainActivity", "com.vanda_adm.vanda.ClipActivity", "QKADM"}};

    /* renamed from: a  reason: collision with root package name */
    private int f5a = 0;

    c() {
    }

    static c b() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    /* access modifiers changed from: package-private */
    public String[][] a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add("");
        arrayList2.add("");
        int length = c.length;
        PackageInfo packageInfo = null;
        for (int i = 1; i < length; i++) {
            try {
                packageInfo = packageManager.getPackageInfo(c[i][0], 1);
            } catch (Exception unused) {
            }
            if (packageInfo != null && packageInfo.applicationInfo.enabled) {
                arrayList.add(c[i][0]);
                arrayList2.add(packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
                packageInfo = null;
            }
        }
        return new String[][]{(String[]) arrayList.toArray(new String[0]), (String[]) arrayList2.toArray(new String[0])};
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.f5a = 0;
        if (!TextUtils.isEmpty(str)) {
            int length = c.length;
            for (int i = 0; i < length; i++) {
                if (str.equals(c[i][0])) {
                    this.f5a = i;
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.f5a != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean a(Activity activity) {
        if (this.f5a == 0) {
            return false;
        }
        Intent intent = new Intent();
        String[][] strArr = c;
        int i = this.f5a;
        intent.setClassName(strArr[i][0], strArr[i][1]);
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(Activity activity, String str) {
        if (this.f5a != 0 && !TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setType("text/plain");
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", str);
            String[][] strArr = c;
            int i = this.f5a;
            intent.setComponent(new ComponentName(strArr[i][0], strArr[i][2]));
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
