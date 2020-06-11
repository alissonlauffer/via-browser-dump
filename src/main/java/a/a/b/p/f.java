package a.a.b.p;

/* compiled from: StringUtils */
public class f {
    public static boolean a(String str, String[] strArr) {
        return b(str, strArr) != null;
    }

    public static String b(String str, String[] strArr) {
        for (String str2 : strArr) {
            if (str.contains(str2)) {
                return str2;
            }
        }
        return null;
    }
}
