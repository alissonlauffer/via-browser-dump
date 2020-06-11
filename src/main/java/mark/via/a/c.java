package mark.via.a;

import mark.via.b.a;
import mark.via.util.b;

/* compiled from: LogItem */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f240a;
    private String b;
    private String c;
    private int d = 0;

    public c(String str, boolean z) {
        a(str);
        a(z);
    }

    public void a(String str) {
        this.f240a = str;
        this.b = b.g(str).toLowerCase();
        this.c = a.j.format(Long.valueOf(System.currentTimeMillis()));
        this.d = ((b.j(this.b) || b.k(str)) ? 2 : 0) | this.d;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.f240a;
    }

    public boolean d() {
        return (this.d & 1) == 1;
    }

    public boolean e() {
        return (this.d & 2) == 2;
    }

    public String a() {
        return this.c;
    }

    private void a(boolean z) {
        this.d = z | this.d ? 1 : 0;
    }
}
