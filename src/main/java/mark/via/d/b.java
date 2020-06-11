package mark.via.d;

import android.os.Build;
import com.flurry.android.d;

/* compiled from: FlurryRemoteConfig */
public class b {
    private static volatile b j;

    /* renamed from: a  reason: collision with root package name */
    private boolean f249a;
    private d b;
    private String c;
    private String d;
    private int e;
    private String f;
    private String g;
    private int h;
    private int i;

    private b() {
        boolean z = Build.VERSION.SDK_INT >= 16;
        this.f249a = z;
        this.c = "b4e996f75bdf4c28";
        this.d = "d13dda85502e18da";
        this.e = 500;
        this.f = "1022560v";
        this.g = "1022560v";
        this.h = 0;
        this.i = 6000;
        if (z) {
            this.b = d.b();
            d();
        }
    }

    public static b c() {
        if (j == null) {
            synchronized (b.class) {
                if (j == null) {
                    j = new b();
                }
            }
        }
        return j;
    }

    private void d() {
        this.c = this.b.a("sc_sg", "b4e996f75bdf4c28");
        this.d = this.b.a("sc_sg1", "d13dda85502e18da");
        this.f = this.b.a("sc_bd1", "1022560v");
        this.g = this.b.a("sc_bd2", "1022560v");
        this.h = this.b.a("sc_sgrt", 0);
        this.i = this.b.a("sc_bdrt", 7000);
        this.e = this.b.a("sc_sgrt_t", 500);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        d dVar;
        if (this.f249a && (dVar = this.b) != null) {
            dVar.a();
        }
    }

    public String b(int i2) {
        return i2 <= this.i ? this.g : this.f;
    }

    public int b() {
        return this.h;
    }

    public String a(int i2) {
        Object[] objArr = new Object[1];
        objArr[0] = i2 <= this.i ? this.g : this.f;
        return String.format("https://m.baidu.com/s?from=%s&word=", objArr);
    }

    public String c(int i2) {
        Object[] objArr = new Object[1];
        objArr[0] = i2 <= this.e ? this.d : this.c;
        return String.format("https://wap.sogou.com/web/sl?bid=sogou-mobb-%s&keyword=", objArr);
    }
}
