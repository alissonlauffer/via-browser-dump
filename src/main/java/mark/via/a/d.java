package mark.via.a;

import android.text.TextUtils;

/* compiled from: RuleItem */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private String f241a;
    private String b;

    public void a(int i) {
    }

    public void a(String str) {
        this.b = str;
    }

    public void b(String str) {
        this.f241a = str;
    }

    public boolean c() {
        return !TextUtils.isEmpty(this.f241a) && !TextUtils.isEmpty(this.b);
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.f241a;
    }
}
