package a.a.b.j;

import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* compiled from: DataChecker */
public class a {
    private static a c;

    /* renamed from: a  reason: collision with root package name */
    private SparseBooleanArray f19a = new SparseBooleanArray();
    private SparseArray<String> b = new SparseArray<>();

    private a() {
    }

    public static a b() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    public void a(int... iArr) {
        for (int i : iArr) {
            this.f19a.put(i, true);
        }
    }

    public void c(int i) {
        this.f19a.put(i, false);
    }

    public void d(int i) {
        this.f19a.put(i, true);
    }

    public boolean a(int i) {
        return this.f19a.get(i);
    }

    public void a(int i, String str) {
        if (str == null) {
            this.b.remove(i);
        } else {
            this.b.put(i, str);
        }
    }

    public String b(int i) {
        return this.b.get(i);
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        int size = this.f19a.size();
        for (int i = 0; i < size; i++) {
            if (this.f19a.valueAt(i)) {
                sb.append(sb.length() > 0 ? "," : "");
                sb.append(this.f19a.keyAt(i));
            }
        }
        return sb.toString();
    }

    public void a(String str) {
        if (str == null || str.isEmpty()) {
            this.f19a.clear();
            return;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt != ' ') {
                if (charAt != ',') {
                    sb.append(charAt);
                }
                if (charAt == ',' || i == length - 1) {
                    if (sb.length() > 0 && TextUtils.isDigitsOnly(sb)) {
                        this.f19a.put(Integer.valueOf(sb.toString()).intValue(), true);
                    }
                    sb.delete(0, sb.length());
                }
            }
        }
    }
}
