package a.a.b.n;

import a.a.b.p.a;
import android.content.Context;

/* compiled from: FrogSettingsBean */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f39a;
    private String b;
    private String c = null;
    private byte d = -1;
    private boolean e = false;

    public b(int i, String str) {
        a(i);
        b(str);
    }

    public static b a(Context context, int i) {
        return new b(i, a.e(context, i));
    }

    public int b() {
        return this.f39a;
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.b;
    }

    public boolean e() {
        return this.d == 1;
    }

    public boolean f() {
        return this.e;
    }

    public void g() {
        this.e = false;
    }

    public static b a(Context context, int i, boolean z) {
        b a2 = a(context, i);
        a2.a(z);
        return a2;
    }

    public void b(String str) {
        this.e = str == null || !str.equals(this.b);
        this.b = str;
    }

    public static b a(Context context, int i, int i2) {
        b a2 = a(context, i);
        a2.a(a.e(context, i2));
        return a2;
    }

    public static b a(Context context, int i, String str) {
        b a2 = a(context, i);
        a2.a(str);
        return a2;
    }

    public static b a(Context context, int i, String str, boolean z) {
        b a2 = a(context, i);
        a2.a(str);
        a2.a(z);
        return a2;
    }

    public static b a(Context context, int i, int i2, boolean z) {
        b a2 = a(context, i);
        a2.a(a.e(context, i2));
        a2.a(z);
        return a2;
    }

    public void a(int i) {
        this.f39a = i;
    }

    public void a(String str) {
        this.e = str == null || !str.equals(this.c);
        this.c = str;
    }

    public void a(boolean z) {
        this.e = (z ? (byte) 1 : 0) != this.d;
        this.d = z ? (byte) 1 : 0;
    }

    public boolean a() {
        return this.d != -1;
    }
}
