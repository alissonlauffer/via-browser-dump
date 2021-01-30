package mark.via.utils;

import android.text.TextUtils;

/* renamed from: mark.via.n.v */
/* compiled from: SqlUtils */
public class SqlUtils {
    /* renamed from: a */
    public static String m2192a(String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(str);
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = " WHERE " + str2;
        }
        sb.append(str3);
        sb.append(";");
        return sb.toString();
    }

    /* renamed from: b */
    public static String m2193b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.replace("'", "''");
        }
        return null;
    }

    /* renamed from: c */
    public static String m2194c(String str, String str2) {
        return "INSERT INTO " + str + " " + str2 + ";";
    }
}
