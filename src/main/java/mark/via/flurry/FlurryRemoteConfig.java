package mark.via.flurry;

import android.os.Build;
import com.flurry.android.C0010d;

/* renamed from: mark.via.g.b */
/* compiled from: FlurryRemoteConfig */
public class FlurryRemoteConfig {

    /* renamed from: j */
    private static volatile FlurryRemoteConfig f1333j;

    /* renamed from: a */
    private boolean f1334a;

    /* renamed from: b */
    private C0010d f1335b;

    /* renamed from: c */
    private String f1336c;

    /* renamed from: d */
    private String f1337d;

    /* renamed from: e */
    private int f1338e;

    /* renamed from: f */
    private String f1339f;

    /* renamed from: g */
    private String f1340g;

    /* renamed from: h */
    private int f1341h;

    /* renamed from: i */
    private int f1342i;

    private FlurryRemoteConfig() {
        boolean z = Build.VERSION.SDK_INT >= 16;
        this.f1334a = z;
        this.f1336c = "b4e996f75bdf4c28";
        this.f1337d = "d13dda85502e18da";
        this.f1338e = 500;
        this.f1339f = "1022560v";
        this.f1340g = "1022560v";
        this.f1341h = 0;
        this.f1342i = 6000;
        if (z) {
            this.f1335b = C0010d.m153b();
            m1695f();
        }
    }

    /* renamed from: c */
    public static FlurryRemoteConfig m1694c() {
        if (f1333j == null) {
            synchronized (FlurryRemoteConfig.class) {
                if (f1333j == null) {
                    f1333j = new FlurryRemoteConfig();
                }
            }
        }
        return f1333j;
    }

    /* renamed from: f */
    private void m1695f() {
        this.f1336c = this.f1335b.mo84d("sc_sg", "b4e996f75bdf4c28");
        this.f1337d = this.f1335b.mo84d("sc_sg1", "d13dda85502e18da");
        this.f1339f = this.f1335b.mo84d("sc_bd1", "1022560v");
        this.f1340g = this.f1335b.mo84d("sc_bd2", "1022560v");
        this.f1341h = this.f1335b.mo83c("sc_sgrt", 0);
        this.f1342i = this.f1335b.mo83c("sc_bdrt", 7000);
        this.f1338e = this.f1335b.mo83c("sc_sgrt_t", 500);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo1044a() {
        C0010d dVar;
        if (this.f1334a && (dVar = this.f1335b) != null) {
            dVar.mo82a();
        }
    }

    /* renamed from: b */
    public String mo1045b(int i) {
        Object[] objArr = new Object[1];
        objArr[0] = i <= this.f1342i ? this.f1340g : this.f1339f;
        return String.format("https://m.baidu.com/s?from=%s&word=", objArr);
    }

    /* renamed from: d */
    public String mo1046d(int i) {
        Object[] objArr = new Object[1];
        objArr[0] = i <= this.f1338e ? this.f1337d : this.f1336c;
        return String.format("https://wap.sogou.com/web/sl?bid=sogou-mobb-%s&keyword=", objArr);
    }

    /* renamed from: e */
    public int mo1047e() {
        return this.f1341h;
    }
}
