package p016e.p017a.p018a;

/* renamed from: e.a.a.e */
/* compiled from: Task */
public class Task {

    /* renamed from: a */
    private long f928a;

    /* renamed from: b */
    private int f929b = 1;

    /* renamed from: c */
    private long f930c;

    /* renamed from: d */
    private long f931d;

    /* renamed from: e */
    private String f932e;

    /* renamed from: f */
    private String f933f;

    public Task(long j, int i, long j2, long j3, String str, String str2) {
        this.f928a = j;
        this.f929b = i;
        this.f930c = j2;
        this.f931d = j3;
        this.f932e = str;
        this.f933f = str2;
    }

    /* renamed from: a */
    public long mo406a() {
        return this.f930c;
    }

    /* renamed from: b */
    public String mo407b() {
        int lastIndexOf;
        String str = this.f932e;
        if (str == null || str.isEmpty() || (lastIndexOf = this.f932e.lastIndexOf("/")) <= -1) {
            return "";
        }
        return this.f932e.substring(lastIndexOf + 1);
    }

    /* renamed from: c */
    public String mo408c() {
        return this.f932e;
    }

    /* renamed from: d */
    public long mo409d() {
        return this.f928a;
    }

    /* renamed from: e */
    public int mo410e() {
        return this.f929b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Task) && ((Task) obj).mo409d() == this.f928a;
    }

    /* renamed from: f */
    public long mo412f() {
        return this.f931d;
    }

    /* renamed from: g */
    public String mo413g() {
        return this.f933f;
    }

    /* renamed from: h */
    public boolean mo414h() {
        return this.f929b == 8;
    }

    /* renamed from: i */
    public boolean mo415i() {
        int i = this.f929b;
        return i == 2 || i == 1 || i == 4;
    }
}
