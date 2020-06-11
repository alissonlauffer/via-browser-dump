package mark.lib.frogsupport.settings;

import android.content.Context;
import mark.lib.frogsupport.util.CompatUtils;

/* renamed from: mark.lib.frogsupport.n.b */
/* compiled from: FrogSettingsBean */
public class FrogSettingsBean {

    /* renamed from: a */
    private int f1167a;

    /* renamed from: b */
    private String f1168b;

    /* renamed from: c */
    private String f1169c = null;

    /* renamed from: d */
    private byte f1170d = -1;

    /* renamed from: e */
    private boolean f1171e = false;

    public FrogSettingsBean(int i, String str) {
        mo760h(i);
        mo762j(str);
    }

    /* renamed from: k */
    public static FrogSettingsBean m1292k(Context context, int i) {
        return new FrogSettingsBean(i, CompatUtils.m1336f(context, i));
    }

    /* renamed from: l */
    public static FrogSettingsBean m1293l(Context context, int i, int i2) {
        FrogSettingsBean k = m1292k(context, i);
        k.mo761i(CompatUtils.m1336f(context, i2));
        return k;
    }

    /* renamed from: m */
    public static FrogSettingsBean m1294m(Context context, int i, int i2, boolean z) {
        FrogSettingsBean k = m1292k(context, i);
        k.mo761i(CompatUtils.m1336f(context, i2));
        k.mo759g(z);
        return k;
    }

    /* renamed from: n */
    public static FrogSettingsBean m1295n(Context context, int i, String str) {
        FrogSettingsBean k = m1292k(context, i);
        k.mo761i(str);
        return k;
    }

    /* renamed from: o */
    public static FrogSettingsBean m1296o(Context context, int i, String str, boolean z) {
        FrogSettingsBean k = m1292k(context, i);
        k.mo761i(str);
        k.mo759g(z);
        return k;
    }

    /* renamed from: p */
    public static FrogSettingsBean m1297p(Context context, int i, boolean z) {
        FrogSettingsBean k = m1292k(context, i);
        k.mo759g(z);
        return k;
    }

    /* renamed from: a */
    public boolean mo753a() {
        return this.f1170d != -1;
    }

    /* renamed from: b */
    public int mo754b() {
        return this.f1167a;
    }

    /* renamed from: c */
    public String mo755c() {
        return this.f1169c;
    }

    /* renamed from: d */
    public String mo756d() {
        return this.f1168b;
    }

    /* renamed from: e */
    public boolean mo757e() {
        return this.f1170d == 1;
    }

    /* renamed from: f */
    public boolean mo758f() {
        return this.f1171e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    public void mo759g(boolean z) {
        this.f1171e = (z ? (byte) 1 : 0) != this.f1170d;
        this.f1170d = z ? (byte) 1 : 0;
    }

    /* renamed from: h */
    public void mo760h(int i) {
        this.f1167a = i;
    }

    /* renamed from: i */
    public void mo761i(String str) {
        this.f1171e = str == null || !str.equals(this.f1169c);
        this.f1169c = str;
    }

    /* renamed from: j */
    public void mo762j(String str) {
        this.f1171e = str == null || !str.equals(this.f1168b);
        this.f1168b = str;
    }

    /* renamed from: q */
    public void mo763q() {
        this.f1171e = false;
    }
}
