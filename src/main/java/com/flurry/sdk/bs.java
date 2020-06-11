package com.flurry.sdk;

import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import com.flurry.sdk.ec;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class bs {
    private static final String j = "bs";
    private static bs k;

    /* renamed from: a  reason: collision with root package name */
    private final Set<String> f70a;
    public final Map<ca, byte[]> b = new HashMap();
    private a c = a.NONE;
    private z0 d;
    public String e;
    private b1 f;
    private List<h> g = new ArrayList();
    private final m1<ec> h = new b();
    private SharedPreferences i = e1.a().f110a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);

    /* access modifiers changed from: package-private */
    public enum a {
        NONE,
        ADVERTISING,
        DEVICE,
        INSTALL_ID,
        REPORTED_IDS,
        FINISHED
    }

    class b implements m1<ec> {

        class a extends b3 {
            a() {
            }

            @Override // com.flurry.sdk.b3
            public final void a() {
                bs.this.g();
            }
        }

        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.m1
        public final /* synthetic */ void a(ec ecVar) {
            if (g.f73a[ecVar.d - 1] == 1 && bs.this.a()) {
                e1.a().b(new a());
            }
        }
    }

    class c extends b3 {
        c() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            bs.b(bs.this);
        }
    }

    class d extends b3 {
        d() {
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            bs.a(bs.this, bs.h());
        }
    }

    class e extends b3 {
        final /* synthetic */ z0 d;

        e(z0 z0Var) {
            this.d = z0Var;
        }

        @Override // com.flurry.sdk.b3
        public final void a() {
            bs.a(bs.this, this.d);
        }
    }

    class f implements FilenameFilter {
        f(bs bsVar) {
        }

        public final boolean accept(File file, String str) {
            return str.startsWith(".flurryagent.");
        }
    }

    /* access modifiers changed from: package-private */
    public static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f73a;
        static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[a.values().length];
            b = iArr;
            iArr[a.NONE.ordinal()] = 1;
            b[a.ADVERTISING.ordinal()] = 2;
            b[a.INSTALL_ID.ordinal()] = 3;
            b[a.DEVICE.ordinal()] = 4;
            b[a.REPORTED_IDS.ordinal()] = 5;
            int[] iArr2 = new int[ec.a.a().length];
            f73a = iArr2;
            try {
                iArr2[ec.a.f116a - 1] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public interface h {
        void a();
    }

    private bs() {
        HashSet hashSet = new HashSet();
        hashSet.add("null");
        hashSet.add("9774d56d682e549c");
        hashSet.add("dead00beef");
        this.f70a = Collections.unmodifiableSet(hashSet);
        n1.a().a("com.flurry.android.sdk.FlurrySessionEvent", this.h);
        e1.a().b(new c());
    }

    public static synchronized bs e() {
        bs bsVar;
        synchronized (bs.class) {
            if (k == null) {
                k = new bs();
            }
            bsVar = k;
        }
        return bsVar;
    }

    /* access modifiers changed from: private */
    public void g() {
        z0 z0Var;
        z2.a();
        String string = this.i.getString("advertising_id", null);
        boolean z = this.i.getBoolean("ad_tracking_enabled", false);
        if (string != null) {
            e1.a().a(new d(), 5000);
            z0Var = new z0(string, z);
        } else {
            z0 h2 = h();
            e1.a().a(new e(h2), 5000);
            z0Var = h2;
        }
        this.d = z0Var;
        if (a()) {
            k();
            n1.a().a(new t0());
        }
    }

    /* access modifiers changed from: private */
    public static z0 h() {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(e1.a().f110a);
            return new z0(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (NoClassDefFoundError unused) {
            s1.b(j, "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return null;
        } catch (Exception e2) {
            String str = j;
            s1.b(str, "GOOGLE PLAY SERVICES ERROR: " + e2.getMessage());
            s1.b(j, "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return null;
        }
    }

    private static String i() {
        DataInputStream dataInputStream;
        File fileStreamPath = e1.a().f110a.getFileStreamPath(".flurryb.");
        String str = null;
        if (fileStreamPath == null || !fileStreamPath.exists()) {
            return null;
        }
        try {
            dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
            try {
                if (1 == dataInputStream.readInt()) {
                    str = dataInputStream.readUTF();
                }
            } catch (Throwable th) {
                th = th;
                try {
                    s1.a(6, j, "Error when loading deviceId", th);
                    z2.a((Closeable) dataInputStream);
                    return str;
                } catch (Throwable th2) {
                    z2.a((Closeable) dataInputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            dataInputStream = null;
            s1.a(6, j, "Error when loading deviceId", th);
            z2.a((Closeable) dataInputStream);
            return str;
        }
        z2.a((Closeable) dataInputStream);
        return str;
    }

    private String j() {
        String[] list;
        File fileStreamPath;
        DataInputStream dataInputStream;
        File filesDir = e1.a().f110a.getFilesDir();
        String str = null;
        if (filesDir == null || (list = filesDir.list(new f(this))) == null || list.length == 0 || (fileStreamPath = e1.a().f110a.getFileStreamPath(list[0])) == null || !fileStreamPath.exists()) {
            return null;
        }
        try {
            dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
            try {
                if (46586 == dataInputStream.readUnsignedShort()) {
                    if (2 == dataInputStream.readUnsignedShort()) {
                        dataInputStream.readUTF();
                        str = dataInputStream.readUTF();
                    }
                }
            } catch (Throwable th) {
                th = th;
                try {
                    s1.a(6, j, "Error when loading deviceId", th);
                    z2.a((Closeable) dataInputStream);
                    return str;
                } catch (Throwable th2) {
                    z2.a((Closeable) dataInputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            dataInputStream = null;
            s1.a(6, j, "Error when loading deviceId", th);
            z2.a((Closeable) dataInputStream);
            return str;
        }
        z2.a((Closeable) dataInputStream);
        return str;
    }

    private void k() {
        String b2 = b();
        if (b2 != null) {
            s1.a(3, j, "Fetched advertising id");
            this.b.put(ca.AndroidAdvertisingId, z2.d(b2));
        }
        byte[] c2 = c();
        if (c2 != null) {
            s1.a(3, j, "Fetched install id");
            this.b.put(ca.AndroidInstallationId, c2);
        }
        String str = this.e;
        if (str != null) {
            s1.a(3, j, "Fetched device id");
            this.b.put(ca.DeviceId, z2.d(str));
        }
    }

    public final String b() {
        z0 z0Var = this.d;
        if (z0Var == null) {
            return null;
        }
        return z0Var.f226a;
    }

    public final byte[] c() {
        try {
            if (this.f == null) {
                this.f = new b1();
            }
            return this.f.a();
        } catch (Exception e2) {
            String str = j;
            s1.a(5, str, "Error while generating Install ID" + e2.getMessage(), e2);
            return null;
        }
    }

    public final boolean d() {
        z0 z0Var = this.d;
        if (z0Var != null && z0Var.b) {
            return false;
        }
        return true;
    }

    public final boolean a() {
        return a.FINISHED.equals(this.c);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007e A[Catch:{ Exception -> 0x010f }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0080 A[Catch:{ Exception -> 0x010f }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0090 A[Catch:{ Exception -> 0x010f }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0091 A[Catch:{ Exception -> 0x010f }] */
    static /* synthetic */ void b(bs bsVar) {
        String str;
        while (!a.FINISHED.equals(bsVar.c)) {
            int i2 = g.b[bsVar.c.ordinal()];
            boolean z = true;
            if (i2 == 1) {
                bsVar.c = a.ADVERTISING;
            } else if (i2 == 2) {
                bsVar.c = a.INSTALL_ID;
            } else if (i2 == 3) {
                bsVar.c = a.DEVICE;
            } else if (i2 == 4) {
                bsVar.c = a.REPORTED_IDS;
            } else if (i2 == 5) {
                bsVar.c = a.FINISHED;
            }
            try {
                int i3 = g.b[bsVar.c.ordinal()];
                if (i3 == 2) {
                    bsVar.g();
                } else if (i3 == 3) {
                    z2.a();
                    if (bsVar.f == null) {
                        bsVar.f = new b1();
                    }
                } else if (i3 == 4) {
                    z2.a();
                    String string = Settings.Secure.getString(e1.a().f110a.getContentResolver(), "android_id");
                    if (!TextUtils.isEmpty(string)) {
                        if (!bsVar.f70a.contains(string.toLowerCase(Locale.US))) {
                            if (z) {
                                str = null;
                            } else {
                                str = "AND".concat(String.valueOf(string));
                            }
                            if (!TextUtils.isEmpty(str)) {
                                str = i();
                                if (TextUtils.isEmpty(str)) {
                                    String j2 = bsVar.j();
                                    if (TextUtils.isEmpty(j2)) {
                                        long doubleToLongBits = Double.doubleToLongBits(Math.random()) + ((System.nanoTime() + (z2.f(w2.a(e1.a().f110a)) * 37)) * 37);
                                        j2 = "ID" + Long.toString(doubleToLongBits, 16);
                                    }
                                    if (!TextUtils.isEmpty(str)) {
                                        File fileStreamPath = e1.a().f110a.getFileStreamPath(".flurryb.");
                                        if (y2.a(fileStreamPath)) {
                                            a(str, fileStreamPath);
                                        }
                                    }
                                }
                            }
                            bsVar.e = str;
                        }
                    }
                    z = false;
                    if (z) {
                    }
                    if (!TextUtils.isEmpty(str)) {
                    }
                    bsVar.e = str;
                } else if (i3 == 5) {
                    bsVar.k();
                }
            } catch (Exception e2) {
                s1.a(4, j, "Exception during id fetch:" + bsVar.c + ", " + e2);
            }
        }
        n1.a().a(new s0());
        if (bsVar.g.size() > 0) {
            Iterator<h> it = bsVar.g.iterator();
            while (it.hasNext()) {
                it.next().a();
                it.remove();
            }
        }
    }

    public final void a(h hVar) {
        if (a()) {
            hVar.a();
        } else {
            this.g.add(hVar);
        }
    }

    private static void a(String str, File file) {
        DataOutputStream dataOutputStream = null;
        try {
            DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream2.writeInt(1);
                dataOutputStream2.writeUTF(str);
                z2.a(dataOutputStream2);
            } catch (Throwable th) {
                th = th;
                dataOutputStream = dataOutputStream2;
                try {
                    s1.a(6, j, "Error when saving deviceId", th);
                } finally {
                    z2.a(dataOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            s1.a(6, j, "Error when saving deviceId", th);
        }
    }

    static /* synthetic */ void a(bs bsVar, z0 z0Var) {
        if (z0Var != null) {
            bsVar.i.edit().putString("advertising_id", z0Var.f226a).putBoolean("ad_tracking_enabled", z0Var.b).apply();
        }
    }
}
