package mark.via.util;

/* compiled from: PageUtil */
public class n {
    public static int a(String str) {
        if (str == null) {
            return 0;
        }
        String trim = str.trim();
        if (trim.isEmpty()) {
            return 0;
        }
        if (!trim.startsWith("v://")) {
            return -1;
        }
        String substring = trim.substring(4);
        if ("bookmark".equals(substring)) {
            return 2;
        }
        if ("history".equals(substring)) {
            return 3;
        }
        if ("log".equals(substring)) {
            return 6;
        }
        if ("offline".equals(substring)) {
            return 7;
        }
        if ("about".equals(substring)) {
            return 4;
        }
        return "home".equals(substring) ? 1 : 5;
    }
}
