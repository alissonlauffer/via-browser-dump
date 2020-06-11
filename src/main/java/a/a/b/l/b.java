package a.a.b.l;

import a.a.b.p.a;
import android.content.Context;

/* compiled from: FrogMenuBean */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f33a;
    private String b;
    private int c = -1;
    private boolean d = true;
    private boolean e = false;
    private boolean f = false;

    public b(int i, String str, int i2) {
        b(i);
        a(str);
        a(i2);
    }

    public static b a(Context context, int i, int i2) {
        return new b(i, a.e(context, i), i2);
    }

    public void b(int i) {
        this.f33a = i;
    }

    public String c() {
        return this.b;
    }

    public boolean d() {
        return this.e;
    }

    public boolean e() {
        return this.d;
    }

    public boolean f() {
        return this.f;
    }

    public void g() {
        this.f = false;
    }

    public static b a(Context context, int i, int i2, boolean z) {
        b bVar = new b(i, a.e(context, i), i2);
        bVar.a(z);
        return bVar;
    }

    public int b() {
        return this.f33a;
    }

    public void b(boolean z) {
        this.f = z != this.d;
        this.d = z;
    }

    public void a(int i) {
        this.f = i != this.c;
        this.c = i;
    }

    public int a() {
        return this.c;
    }

    public void a(String str) {
        this.f = str == null || !str.equals(this.b);
        this.b = str;
    }

    public void a(boolean z) {
        this.e = z;
    }
}
