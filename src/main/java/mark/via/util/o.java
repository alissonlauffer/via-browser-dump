package mark.via.util;

import android.text.TextUtils;

/* compiled from: SqlUtils */
public class o {
    public static String a(String str, String str2) {
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

    public static String b(String str, String str2) {
        return "INSERT INTO " + str + " " + str2 + ";";
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.replace("'", "''");
        }
        return null;
    }
}
