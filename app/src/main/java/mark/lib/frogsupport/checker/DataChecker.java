package mark.lib.frogsupport.checker;

import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* renamed from: mark.lib.frogsupport.j.a */
/* compiled from: DataChecker */
public class DataChecker {

    /* renamed from: c */
    private static DataChecker f1092c;

    /* renamed from: a */
    private SparseBooleanArray f1093a = new SparseBooleanArray();

    /* renamed from: b */
    private SparseArray<String> f1094b = new SparseArray<>();

    private DataChecker() {
    }

    /* renamed from: c */
    public static DataChecker m1181c() {
        if (f1092c == null) {
            f1092c = new DataChecker();
        }
        return f1092c;
    }

    /* renamed from: a */
    public boolean mo661a(int i) {
        return this.f1093a.get(i);
    }

    /* renamed from: b */
    public String mo662b() {
        StringBuilder sb = new StringBuilder();
        int size = this.f1093a.size();
        for (int i = 0; i < size; i++) {
            if (this.f1093a.valueAt(i)) {
                sb.append(sb.length() > 0 ? "," : "");
                sb.append(this.f1093a.keyAt(i));
            }
        }
        return sb.toString();
    }

    /* renamed from: d */
    public String mo663d(int i) {
        return this.f1094b.get(i);
    }

    /* renamed from: e */
    public void mo664e(int i) {
        this.f1093a.put(i, false);
    }

    /* renamed from: f */
    public void mo665f(String str) {
        if (str == null || str.isEmpty()) {
            this.f1093a.clear();
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
                        this.f1093a.put(Integer.valueOf(sb.toString()).intValue(), true);
                    }
                    sb.delete(0, sb.length());
                }
            }
        }
    }

    /* renamed from: g */
    public void mo666g(int i, String str) {
        if (str == null) {
            this.f1094b.remove(i);
        } else {
            this.f1094b.put(i, str);
        }
    }

    /* renamed from: h */
    public void mo667h(int i) {
        this.f1093a.put(i, true);
    }

    /* renamed from: i */
    public void mo668i(int... iArr) {
        for (int i : iArr) {
            this.f1093a.put(i, true);
        }
    }
}
