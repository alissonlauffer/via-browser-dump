package mark.via.flurry;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.flurry.android.C0004b;
import java.io.PrintStream;
import java.util.HashMap;
import mark.via.utils.ChannelUtils;

/* renamed from: mark.via.g.a */
/* compiled from: FlurryHelper */
public class FlurryHelper {

    /* renamed from: b */
    private static volatile FlurryHelper f1331b;

    /* renamed from: a */
    private boolean f1332a;

    private FlurryHelper() {
        this.f1332a = Build.VERSION.SDK_INT >= 16;
    }

    /* renamed from: a */
    public static FlurryHelper m1681a() {
        if (f1331b == null) {
            synchronized (FlurryHelper.class) {
                if (f1331b == null) {
                    f1331b = new FlurryHelper();
                }
            }
        }
        return f1331b;
    }

    /* renamed from: g */
    private void m1682g(String str, String str2) {
        if (this.f1332a && !TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            hashMap.put(str, str2);
            C0004b.m137i("app_settings", hashMap);
        }
    }

    /* renamed from: m */
    public static boolean m1683m(long j, int i) {
        if (i <= 800 || (i > 5000 && i <= 6500)) {
            return true;
        }
        double d = (double) (j - 1596816001000L);
        Double.isNaN(d);
        double ceil = Math.ceil((((d / 1000.0d) / 60.0d) / 60.0d) / 24.0d);
        PrintStream printStream = System.out;
        printStream.println("gap: " + ceil);
        if (ceil <= 0.0d) {
            return false;
        }
        if (i <= 5000) {
            if (((double) i) > 5000.0d - Math.min(2600.0d, ceil * 15.0d)) {
                return true;
            }
        } else if (((double) i) < Math.min(2000.0d, ceil * 10.0d) + 6500.0d) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public void mo1034b(Application application, int i) {
        if (this.f1332a) {
            C0004b.m145q(false);
            boolean z = !ChannelUtils.m2108c() && m1683m(System.currentTimeMillis(), i);
            C0004b.C0008c cVar = new C0004b.C0008c();
            cVar.mo79d(false);
            cVar.mo80e(2);
            cVar.mo77b(false);
            cVar.mo78c(10);
            cVar.mo76a(application, z ? "7HJQD989JKF8KXM4JMNT" : "X5NX7B4ZQBVSMBNF9X2R");
            FlurryRemoteConfig.m1694c().mo1044a();
        }
    }

    /* renamed from: c */
    public void mo1035c(String str) {
        if (this.f1332a && !TextUtils.isEmpty(str)) {
            C0004b.m136h(str);
        }
    }

    /* renamed from: d */
    public void mo1036d(String str, boolean z) {
        if (this.f1332a && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(z ? "main" : "tools", str);
            C0004b.m137i("app_menu", hashMap);
        }
    }

    /* renamed from: e */
    public void mo1037e(int i) {
        if (this.f1332a) {
            String a = ChannelUtils.m2106a();
            StringBuilder sb = new StringBuilder();
            sb.append("channel_");
            if (i == 0) {
                sb.append("new_");
            }
            sb.append(a);
            mo1035c(sb.toString());
        }
    }

    /* renamed from: f */
    public void mo1038f(String str) {
        if (this.f1332a && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("search", str);
            C0004b.m137i("web_search", hashMap);
        }
    }

    /* renamed from: h */
    public void mo1039h(String str) {
        m1682g("catalog", str);
    }

    /* renamed from: i */
    public void mo1040i(String str) {
        m1682g("cloud", str);
    }

    /* renamed from: j */
    public void mo1041j(String str) {
        m1682g("general", str);
    }

    /* renamed from: k */
    public void mo1042k(String str) {
        m1682g("scripts", str);
    }

    /* renamed from: l */
    public void mo1043l(String str) {
        m1682g("skin", str);
    }
}
