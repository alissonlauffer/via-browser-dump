package mark.via.a;

import android.text.TextUtils;

/* compiled from: AddonItem */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f238a;
    private int b = 0;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;

    public a() {
    }

    public void a(int i) {
        this.f238a = i;
    }

    public void b(int i) {
        this.b = i;
    }

    public int c() {
        return this.f238a;
    }

    public void d(String str) {
        this.c = str;
    }

    public String e() {
        return this.c;
    }

    public int f() {
        return this.b;
    }

    public String g() {
        return this.e;
    }

    public boolean h() {
        return !TextUtils.isEmpty(this.e) && !TextUtils.isEmpty(this.g);
    }

    public String toString() {
        return "id: " + this.f238a + ";\noid: " + this.b + ";\nurl: " + this.e + ";\ncode: " + this.g + ";\n";
    }

    public void a(String str) {
        this.d = str;
    }

    public void b(String str) {
        this.g = str;
    }

    public void c(String str) {
        this.f = str;
    }

    public String d() {
        return this.f;
    }

    public void e(String str) {
        this.e = str;
    }

    public a(String str, String str2) {
        this.e = str;
        this.g = str2;
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.g;
    }
}
