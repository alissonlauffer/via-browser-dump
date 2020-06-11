package mark.via.a;

/* compiled from: HistoryItem */
public class b implements Comparable<b> {

    /* renamed from: a  reason: collision with root package name */
    private int f239a = 0;
    private String b = "";
    private String c = "";
    private String d = "";
    private int e = 0;
    private int f = -1;

    public b() {
    }

    public void a(int i) {
        this.f239a = i;
    }

    public int b() {
        return this.f239a;
    }

    public int c() {
        return this.e;
    }

    public int d() {
        return this.f;
    }

    public String e() {
        String str = this.c;
        return str == null ? "" : str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f239a != bVar.f239a || this.e != bVar.e || !this.c.equals(bVar.c) || !this.b.equals(bVar.b)) {
            return false;
        }
        return true;
    }

    public String f() {
        String str = this.b;
        return str == null ? "" : str;
    }

    public int hashCode() {
        return (((((this.f239a * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.e;
    }

    public String toString() {
        return this.c + "\n" + this.b;
    }

    public void a(String str) {
        this.d = str;
    }

    public void b(int i) {
        this.e = i;
    }

    public void c(int i) {
        this.f = i;
    }

    public String a() {
        return this.d;
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.b = str;
    }

    /* renamed from: a */
    public int compareTo(b bVar) {
        return this.c.compareTo(bVar.c);
    }

    public b(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    public b(String str, String str2, String str3) {
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public b(String str, String str2, int i) {
        this.b = str;
        this.c = str2;
        this.e = i;
    }
}
