package com.flurry.sdk;

import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import com.flurry.sdk.C0127ec;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
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

/* renamed from: com.flurry.sdk.bs */
public class C0044bs {

    /* renamed from: j */
    private static final String f147j = "bs";

    /* renamed from: k */
    private static C0044bs f148k;

    /* renamed from: a */
    private final Set<String> f149a;

    /* renamed from: b */
    public final Map<EnumC0076ca, byte[]> f150b = new HashMap();

    /* renamed from: c */
    private EnumC0045a f151c = EnumC0045a.NONE;

    /* renamed from: d */
    private C0325z0 f152d;

    /* renamed from: e */
    public String f153e;

    /* renamed from: f */
    private C0037b1 f154f;

    /* renamed from: g */
    private List<AbstractC0053h> f155g = new ArrayList();

    /* renamed from: h */
    private final AbstractC0192m1<C0127ec> f156h;

    /* renamed from: i */
    private SharedPreferences f157i;

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.bs$a */
    public enum EnumC0045a {
        NONE,
        ADVERTISING,
        DEVICE,
        INSTALL_ID,
        REPORTED_IDS,
        FINISHED
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.bs$b */
    public class C0046b implements AbstractC0192m1<C0127ec> {

        /* renamed from: com.flurry.sdk.bs$b$a */
        class C0047a extends AbstractRunnableC0040b3 {
            C0047a() {
            }

            @Override // com.flurry.sdk.AbstractRunnableC0040b3
            /* renamed from: a */
            public final void mo121a() {
                C0044bs.this.m238l();
            }
        }

        C0046b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.l1] */
        @Override // com.flurry.sdk.AbstractC0192m1
        /* renamed from: a */
        public final /* synthetic */ void mo74a(C0127ec ecVar) {
            if (C0052g.f171a[ecVar.f385d - 1] == 1 && C0044bs.this.mo124g()) {
                C0118e1.m386a().mo191g(new C0047a());
            }
        }
    }

    /* renamed from: com.flurry.sdk.bs$c */
    class C0048c extends AbstractRunnableC0040b3 {
        C0048c() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0044bs.m236f(C0044bs.this);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.bs$d */
    public class C0049d extends AbstractRunnableC0040b3 {
        C0049d() {
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0044bs.m234d(C0044bs.this, C0044bs.m239m());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.bs$e */
    public class C0050e extends AbstractRunnableC0040b3 {

        /* renamed from: d */
        final /* synthetic */ C0325z0 f169d;

        C0050e(C0325z0 z0Var) {
            this.f169d = z0Var;
        }

        @Override // com.flurry.sdk.AbstractRunnableC0040b3
        /* renamed from: a */
        public final void mo121a() {
            C0044bs.m234d(C0044bs.this, this.f169d);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.bs$f */
    public class C0051f implements FilenameFilter {
        C0051f(C0044bs bsVar) {
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            return str.startsWith(".flurryagent.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.bs$g */
    public static /* synthetic */ class C0052g {

        /* renamed from: a */
        static final /* synthetic */ int[] f171a;

        /* renamed from: b */
        static final /* synthetic */ int[] f172b;

        static {
            int[] iArr = new int[EnumC0045a.values().length];
            f172b = iArr;
            try {
                iArr[EnumC0045a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f172b[EnumC0045a.ADVERTISING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f172b[EnumC0045a.INSTALL_ID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f172b[EnumC0045a.DEVICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f172b[EnumC0045a.REPORTED_IDS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[C0127ec.EnumC0128a.m408a().length];
            f171a = iArr2;
            try {
                iArr2[C0127ec.EnumC0128a.f387a - 1] = 1;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* renamed from: com.flurry.sdk.bs$h */
    public interface AbstractC0053h {
        /* renamed from: a */
        void mo129a();
    }

    private C0044bs() {
        HashSet hashSet = new HashSet();
        hashSet.add("null");
        hashSet.add("9774d56d682e549c");
        hashSet.add("dead00beef");
        this.f149a = Collections.unmodifiableSet(hashSet);
        C0046b bVar = new C0046b();
        this.f156h = bVar;
        this.f157i = C0118e1.m386a().f361a.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
        C0199n1.m528a().mo271e("com.flurry.android.sdk.FlurrySessionEvent", bVar);
        C0118e1.m386a().mo191g(new C0048c());
    }

    /* renamed from: a */
    public static synchronized C0044bs m232a() {
        C0044bs bsVar;
        synchronized (C0044bs.class) {
            if (f148k == null) {
                f148k = new C0044bs();
            }
            bsVar = f148k;
        }
        return bsVar;
    }

    /* renamed from: d */
    static /* synthetic */ void m234d(C0044bs bsVar, C0325z0 z0Var) {
        if (z0Var != null) {
            bsVar.f157i.edit().putString("advertising_id", z0Var.f890a).putBoolean("ad_tracking_enabled", z0Var.f891b).apply();
        }
    }

    /* renamed from: e */
    private static void m235e(String str, File file) {
        Throwable th;
        DataOutputStream dataOutputStream = null;
        try {
            DataOutputStream dataOutputStream2 = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream2.writeInt(1);
                dataOutputStream2.writeUTF(str);
                C0328z2.m890e(dataOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = dataOutputStream2;
                try {
                    C0260s1.m687d(6, f147j, "Error when saving deviceId", th);
                } finally {
                    C0328z2.m890e(dataOutputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            C0260s1.m687d(6, f147j, "Error when saving deviceId", th);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007a A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008c A[Catch:{ Exception -> 0x010b }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008d A[Catch:{ Exception -> 0x010b }] */
    /* renamed from: f */
    static /* synthetic */ void m236f(C0044bs bsVar) {
        String str;
        while (true) {
            EnumC0045a aVar = EnumC0045a.FINISHED;
            if (aVar.equals(bsVar.f151c)) {
                break;
            }
            int[] iArr = C0052g.f172b;
            int i = iArr[bsVar.f151c.ordinal()];
            boolean z = true;
            if (i == 1) {
                bsVar.f151c = EnumC0045a.ADVERTISING;
            } else if (i == 2) {
                bsVar.f151c = EnumC0045a.INSTALL_ID;
            } else if (i == 3) {
                bsVar.f151c = EnumC0045a.DEVICE;
            } else if (i == 4) {
                bsVar.f151c = EnumC0045a.REPORTED_IDS;
            } else if (i == 5) {
                bsVar.f151c = aVar;
            }
            try {
                int i2 = iArr[bsVar.f151c.ordinal()];
                if (i2 == 2) {
                    bsVar.m238l();
                } else if (i2 == 3) {
                    C0328z2.m889d();
                    if (bsVar.f154f == null) {
                        bsVar.f154f = new C0037b1();
                    }
                } else if (i2 == 4) {
                    C0328z2.m889d();
                    String string = Settings.Secure.getString(C0118e1.m386a().f361a.getContentResolver(), "android_id");
                    if (!TextUtils.isEmpty(string)) {
                        if (!bsVar.f149a.contains(string.toLowerCase(Locale.US))) {
                            if (z) {
                                str = null;
                            } else {
                                str = "AND".concat(String.valueOf(string));
                            }
                            if (!TextUtils.isEmpty(str)) {
                                str = m240n();
                                if (TextUtils.isEmpty(str)) {
                                    str = bsVar.m241o();
                                    if (TextUtils.isEmpty(str)) {
                                        long doubleToLongBits = Double.doubleToLongBits(Math.random()) + ((System.nanoTime() + (C0328z2.m899n(C0300w2.m815a(C0118e1.m386a().f361a)) * 37)) * 37);
                                        str = "ID" + Long.toString(doubleToLongBits, 16);
                                    }
                                    if (!TextUtils.isEmpty(str)) {
                                        File fileStreamPath = C0118e1.m386a().f361a.getFileStreamPath(".flurryb.");
                                        if (C0318y2.m875b(fileStreamPath)) {
                                            m235e(str, fileStreamPath);
                                        }
                                    }
                                }
                            }
                            bsVar.f153e = str;
                        }
                    }
                    z = false;
                    if (z) {
                    }
                    if (!TextUtils.isEmpty(str)) {
                    }
                    bsVar.f153e = str;
                } else if (i2 == 5) {
                    bsVar.m242p();
                }
            } catch (Exception e) {
                C0260s1.m686c(4, f147j, "Exception during id fetch:" + bsVar.f151c + ", " + e);
            }
        }
        C0199n1.m528a().mo269c(new C0259s0());
        if (bsVar.f155g.size() > 0) {
            Iterator<AbstractC0053h> it = bsVar.f155g.iterator();
            while (it.hasNext()) {
                it.next().mo129a();
                it.remove();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: l */
    private void m238l() {
        C0325z0 z0Var;
        C0328z2.m889d();
        String string = this.f157i.getString("advertising_id", null);
        boolean z = this.f157i.getBoolean("ad_tracking_enabled", false);
        if (string != null) {
            C0118e1.m386a().mo190e(new C0049d(), 5000);
            z0Var = new C0325z0(string, z);
        } else {
            C0325z0 m = m239m();
            C0118e1.m386a().mo190e(new C0050e(m), 5000);
            z0Var = m;
        }
        this.f152d = z0Var;
        if (mo124g()) {
            m242p();
            C0199n1.m528a().mo269c(new C0264t0());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public static C0325z0 m239m() {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(C0118e1.m386a().f361a);
            return new C0325z0(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled());
        } catch (NoClassDefFoundError unused) {
            C0260s1.m693j(f147j, "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return null;
        } catch (Exception e) {
            String str = f147j;
            C0260s1.m693j(str, "GOOGLE PLAY SERVICES ERROR: " + e.getMessage());
            C0260s1.m693j(str, "There is a problem with the Google Play Services library, which is required for Android Advertising ID support. The Google Play Services library should be integrated in any app shipping in the Play Store that uses analytics or advertising.");
            return null;
        }
    }

    /* renamed from: n */
    private static String m240n() {
        DataInputStream dataInputStream;
        Throwable th;
        File fileStreamPath = C0118e1.m386a().f361a.getFileStreamPath(".flurryb.");
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
            } catch (Throwable th2) {
                th = th2;
                try {
                    C0260s1.m687d(6, f147j, "Error when loading deviceId", th);
                    C0328z2.m890e(dataInputStream);
                    return str;
                } catch (Throwable th3) {
                    C0328z2.m890e(dataInputStream);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataInputStream = null;
            C0260s1.m687d(6, f147j, "Error when loading deviceId", th);
            C0328z2.m890e(dataInputStream);
            return str;
        }
        C0328z2.m890e(dataInputStream);
        return str;
    }

    /* renamed from: o */
    private String m241o() {
        String[] list;
        File fileStreamPath;
        DataInputStream dataInputStream;
        Throwable th;
        File filesDir = C0118e1.m386a().f361a.getFilesDir();
        String str = null;
        if (filesDir == null || (list = filesDir.list(new C0051f(this))) == null || list.length == 0 || (fileStreamPath = C0118e1.m386a().f361a.getFileStreamPath(list[0])) == null || !fileStreamPath.exists()) {
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
            } catch (Throwable th2) {
                th = th2;
                try {
                    C0260s1.m687d(6, f147j, "Error when loading deviceId", th);
                    C0328z2.m890e(dataInputStream);
                    return str;
                } catch (Throwable th3) {
                    C0328z2.m890e(dataInputStream);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataInputStream = null;
            C0260s1.m687d(6, f147j, "Error when loading deviceId", th);
            C0328z2.m890e(dataInputStream);
            return str;
        }
        C0328z2.m890e(dataInputStream);
        return str;
    }

    /* renamed from: p */
    private void m242p() {
        String h = mo125h();
        if (h != null) {
            C0260s1.m686c(3, f147j, "Fetched advertising id");
            this.f150b.put(EnumC0076ca.AndroidAdvertisingId, C0328z2.m897l(h));
        }
        byte[] i = mo126i();
        if (i != null) {
            C0260s1.m686c(3, f147j, "Fetched install id");
            this.f150b.put(EnumC0076ca.AndroidInstallationId, i);
        }
        String str = this.f153e;
        if (str != null) {
            C0260s1.m686c(3, f147j, "Fetched device id");
            this.f150b.put(EnumC0076ca.DeviceId, C0328z2.m897l(str));
        }
    }

    /* renamed from: b */
    public final void mo123b(AbstractC0053h hVar) {
        if (mo124g()) {
            hVar.mo129a();
        } else {
            this.f155g.add(hVar);
        }
    }

    /* renamed from: g */
    public final boolean mo124g() {
        return EnumC0045a.FINISHED.equals(this.f151c);
    }

    /* renamed from: h */
    public final String mo125h() {
        C0325z0 z0Var = this.f152d;
        if (z0Var == null) {
            return null;
        }
        return z0Var.f890a;
    }

    /* renamed from: i */
    public final byte[] mo126i() {
        try {
            if (this.f154f == null) {
                this.f154f = new C0037b1();
            }
            return this.f154f.mo119b();
        } catch (Exception e) {
            String str = f147j;
            C0260s1.m687d(5, str, "Error while generating Install ID" + e.getMessage(), e);
            return null;
        }
    }

    /* renamed from: j */
    public final boolean mo127j() {
        C0325z0 z0Var = this.f152d;
        if (z0Var != null && z0Var.f891b) {
            return false;
        }
        return true;
    }
}
