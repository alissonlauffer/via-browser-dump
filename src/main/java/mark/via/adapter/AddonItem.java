package mark.via.adapter;

import android.text.TextUtils;

/* renamed from: mark.via.c.a */
/* compiled from: AddonItem */
public class AddonItem {

    /* renamed from: a */
    private int f1270a;

    /* renamed from: b */
    private int f1271b = 0;

    /* renamed from: c */
    private String f1272c;

    /* renamed from: d */
    private String f1273d;

    /* renamed from: e */
    private String f1274e;

    /* renamed from: f */
    private String f1275f;

    /* renamed from: g */
    private String f1276g;

    public AddonItem() {
    }

    /* renamed from: a */
    public String mo917a() {
        return this.f1273d;
    }

    /* renamed from: b */
    public String mo918b() {
        return this.f1276g;
    }

    /* renamed from: c */
    public int mo919c() {
        return this.f1270a;
    }

    /* renamed from: d */
    public String mo920d() {
        return this.f1275f;
    }

    /* renamed from: e */
    public String mo921e() {
        return this.f1272c;
    }

    /* renamed from: f */
    public int mo922f() {
        return this.f1271b;
    }

    /* renamed from: g */
    public String mo923g() {
        return this.f1274e;
    }

    /* renamed from: h */
    public boolean mo924h() {
        return !TextUtils.isEmpty(this.f1274e) && !TextUtils.isEmpty(this.f1276g);
    }

    /* renamed from: i */
    public void mo925i(String str) {
        this.f1273d = str;
    }

    /* renamed from: j */
    public void mo926j(String str) {
        this.f1276g = str;
    }

    /* renamed from: k */
    public void mo927k(int i) {
        this.f1270a = i;
    }

    /* renamed from: l */
    public void mo928l(String str) {
        this.f1275f = str;
    }

    /* renamed from: m */
    public void mo929m(String str) {
        this.f1272c = str;
    }

    /* renamed from: n */
    public void mo930n(int i) {
        this.f1271b = i;
    }

    /* renamed from: o */
    public void mo931o(String str) {
        this.f1274e = str;
    }

    public String toString() {
        return "id: " + this.f1270a + ";\noid: " + this.f1271b + ";\nurl: " + this.f1274e + ";\ncode: " + this.f1276g + ";\n";
    }

    public AddonItem(String str, String str2) {
        this.f1274e = str;
        this.f1276g = str2;
    }
}
