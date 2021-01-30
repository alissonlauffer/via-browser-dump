package mark.via.adapter;

/* renamed from: mark.via.c.b */
/* compiled from: HistoryItem */
public class HistoryItem implements Comparable<HistoryItem> {

    /* renamed from: a */
    private int f1277a = 0;

    /* renamed from: b */
    private String f1278b = "";

    /* renamed from: c */
    private String f1279c = "";

    /* renamed from: d */
    private String f1280d = "";

    /* renamed from: e */
    private int f1281e = 0;

    /* renamed from: f */
    private int f1282f = -1;

    public HistoryItem() {
    }

    /* renamed from: a */
    public int compareTo(HistoryItem bVar) {
        return this.f1279c.compareTo(bVar.f1279c);
    }

    /* renamed from: b */
    public String mo934b() {
        return this.f1280d;
    }

    /* renamed from: c */
    public int mo935c() {
        return this.f1277a;
    }

    /* renamed from: d */
    public int mo937d() {
        return this.f1281e;
    }

    /* renamed from: e */
    public int mo938e() {
        return this.f1282f;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || HistoryItem.class != obj.getClass()) {
            return false;
        }
        HistoryItem bVar = (HistoryItem) obj;
        if (this.f1277a != bVar.f1277a || this.f1281e != bVar.f1281e || !this.f1279c.equals(bVar.f1279c) || !this.f1278b.equals(bVar.f1278b)) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public String mo940f() {
        String str = this.f1279c;
        return str == null ? "" : str;
    }

    /* renamed from: g */
    public String mo941g() {
        String str = this.f1278b;
        return str == null ? "" : str;
    }

    /* renamed from: h */
    public void mo942h(String str) {
        this.f1280d = str;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (((((this.f1277a * 31) + this.f1278b.hashCode()) * 31) + this.f1279c.hashCode()) * 31) + this.f1281e;
    }

    /* renamed from: i */
    public void mo944i(int i) {
        this.f1277a = i;
    }

    /* renamed from: j */
    public void mo945j(int i) {
        this.f1281e = i;
    }

    /* renamed from: k */
    public void mo946k(int i) {
        this.f1282f = i;
    }

    /* renamed from: l */
    public void mo947l(String str) {
        this.f1279c = str;
    }

    /* renamed from: m */
    public void mo948m(String str) {
        this.f1278b = str;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.f1279c + "\n" + this.f1278b;
    }

    public HistoryItem(String str, String str2) {
        this.f1278b = str;
        this.f1279c = str2;
    }

    public HistoryItem(String str, String str2, String str3) {
        this.f1278b = str;
        this.f1279c = str2;
        this.f1280d = str3;
    }

    public HistoryItem(String str, String str2, int i) {
        this.f1278b = str;
        this.f1279c = str2;
        this.f1281e = i;
    }
}
