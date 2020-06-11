package mark.via.d;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.flurry.android.b;
import java.util.HashMap;
import mark.via.util.c;

/* compiled from: FlurryHelper */
public class a {
    private static volatile a b;

    /* renamed from: a  reason: collision with root package name */
    private boolean f248a;

    private a() {
        this.f248a = Build.VERSION.SDK_INT >= 16;
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public void b(String str) {
        if (this.f248a && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put("search", str);
            b.a("web_search", hashMap);
        }
    }

    public void c(String str) {
        a("admarks", str);
    }

    public void d(String str) {
        a("catalog", str);
    }

    public void e(String str) {
        a("cloud", str);
    }

    public void f(String str) {
        a("general", str);
    }

    public void g(String str) {
        a("scripts", str);
    }

    public void h(String str) {
        a("skin", str);
    }

    public void a(Application application, int i) {
        if (this.f248a) {
            b.c(false);
            b.c cVar = new b.c();
            cVar.b(false);
            cVar.a(2);
            cVar.a(false);
            cVar.a(10L);
            cVar.a(application, i <= 600 ? "7HJQD989JKF8KXM4JMNT" : "X5NX7B4ZQBVSMBNF9X2R");
            b.c().a();
        }
    }

    public void a(String str) {
        if (this.f248a && !TextUtils.isEmpty(str)) {
            b.a(str);
        }
    }

    public void a(String str, boolean z) {
        if (this.f248a && !TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(z ? "main" : "tools", str);
            b.a("app_menu", hashMap);
        }
    }

    public void a(int i) {
        if (this.f248a) {
            String a2 = c.a();
            StringBuilder sb = new StringBuilder();
            sb.append("channel_");
            if (i == 0) {
                sb.append("new_");
            }
            sb.append(a2);
            a(sb.toString());
        }
    }

    private void a(String str, String str2) {
        if (this.f248a && !TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            hashMap.put(str, str2);
            b.a("app_settings", hashMap);
        }
    }
}
