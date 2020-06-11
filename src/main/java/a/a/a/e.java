package a.a.a;

/* compiled from: Task */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private long f7a;
    private int b = 1;
    private long c;
    private long d;
    private String e;
    private String f;

    public e(long j, int i, long j2, long j3, String str, String str2) {
        this.f7a = j;
        this.b = i;
        this.c = j2;
        this.d = j3;
        this.e = str;
        this.f = str2;
    }

    public long a() {
        return this.c;
    }

    public String b() {
        int lastIndexOf;
        String str = this.e;
        if (str == null || str.isEmpty() || (lastIndexOf = this.e.lastIndexOf("/")) <= -1) {
            return "";
        }
        return this.e.substring(lastIndexOf + 1);
    }

    public String c() {
        return this.e;
    }

    public long d() {
        return this.f7a;
    }

    public int e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && ((e) obj).d() == this.f7a;
    }

    public long f() {
        return this.d;
    }

    public String g() {
        return this.f;
    }

    public boolean h() {
        return this.b == 8;
    }

    public boolean i() {
        int i = this.b;
        return i == 2 || i == 1 || i == 4;
    }
}
