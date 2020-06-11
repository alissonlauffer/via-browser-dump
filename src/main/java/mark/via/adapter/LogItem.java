package mark.via.adapter;

import mark.via.constants.Constants;
import mark.via.utils.BrowserUtils;

/* renamed from: mark.via.c.c */
/* compiled from: LogItem */
public class LogItem {

    /* renamed from: a */
    private String f1283a;

    /* renamed from: b */
    private String f1284b;

    /* renamed from: c */
    private String f1285c;

    /* renamed from: d */
    private int f1286d = 0;

    public LogItem(String str, boolean z) {
        mo955g(str);
        m1571f(z);
    }

    /* renamed from: f */
    private void m1571f(boolean z) {
        this.f1286d = (z ? 1 : 0) | this.f1286d;
    }

    /* renamed from: a */
    public String mo950a() {
        return this.f1285c;
    }

    /* renamed from: b */
    public String mo951b() {
        return this.f1284b;
    }

    /* renamed from: c */
    public String mo952c() {
        return this.f1283a;
    }

    /* renamed from: d */
    public boolean mo953d() {
        return (this.f1286d & 1) == 1;
    }

    /* renamed from: e */
    public boolean mo954e() {
        return (this.f1286d & 2) == 2;
    }

    /* renamed from: g */
    public void mo955g(String str) {
        this.f1283a = str;
        this.f1284b = BrowserUtils.m2099t(str).toLowerCase();
        this.f1285c = Constants.f1303h.format(Long.valueOf(System.currentTimeMillis()));
        this.f1286d = ((BrowserUtils.m2071B(this.f1284b) || BrowserUtils.m2072C(str)) ? 2 : 0) | this.f1286d;
    }
}
