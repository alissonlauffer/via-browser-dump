package mark.lib.frogsupport.menu;

import android.content.Context;
import mark.lib.frogsupport.util.CompatUtils;

/* renamed from: mark.lib.frogsupport.l.b */
/* compiled from: FrogMenuBean */
public class FrogMenuBean {

    /* renamed from: a */
    private int f1142a;

    /* renamed from: b */
    private String f1143b;

    /* renamed from: c */
    private int f1144c = -1;

    /* renamed from: d */
    private boolean f1145d = true;

    /* renamed from: e */
    private boolean f1146e = false;

    /* renamed from: f */
    private boolean f1147f = false;

    public FrogMenuBean(int i, String str, int i2) {
        mo724j(i);
        mo725k(str);
        mo722h(i2);
    }

    /* renamed from: l */
    public static FrogMenuBean m1243l(Context context, int i, int i2) {
        return new FrogMenuBean(i, CompatUtils.m1336f(context, i), i2);
    }

    /* renamed from: m */
    public static FrogMenuBean m1244m(Context context, int i, int i2, boolean z) {
        FrogMenuBean bVar = new FrogMenuBean(i, CompatUtils.m1336f(context, i), i2);
        bVar.mo721g(z);
        return bVar;
    }

    /* renamed from: a */
    public int mo715a() {
        return this.f1144c;
    }

    /* renamed from: b */
    public int mo716b() {
        return this.f1142a;
    }

    /* renamed from: c */
    public String mo717c() {
        return this.f1143b;
    }

    /* renamed from: d */
    public boolean mo718d() {
        return this.f1146e;
    }

    /* renamed from: e */
    public boolean mo719e() {
        return this.f1145d;
    }

    /* renamed from: f */
    public boolean mo720f() {
        return this.f1147f;
    }

    /* renamed from: g */
    public void mo721g(boolean z) {
        this.f1146e = z;
    }

    /* renamed from: h */
    public void mo722h(int i) {
        this.f1147f = i != this.f1144c;
        this.f1144c = i;
    }

    /* renamed from: i */
    public void mo723i(boolean z) {
        this.f1147f = z != this.f1145d;
        this.f1145d = z;
    }

    /* renamed from: j */
    public void mo724j(int i) {
        this.f1142a = i;
    }

    /* renamed from: k */
    public void mo725k(String str) {
        this.f1147f = str == null || !str.equals(this.f1143b);
        this.f1143b = str;
    }

    /* renamed from: n */
    public void mo726n() {
        this.f1147f = false;
    }
}
