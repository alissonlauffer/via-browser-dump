package mark.via.util;

import java.net.URLEncoder;

/* compiled from: WebAdressUtils */
public class s {
    private static boolean a(String str) {
        if (str != null && !str.isEmpty()) {
            int length = str.length();
            while (length > 0) {
                length--;
                char charAt = str.charAt(length);
                if (charAt >= '0' && charAt <= '9') {
                    return true;
                }
            }
        }
        return false;
    }

    public static String b(String str) {
        if (str == null) {
            return "";
        }
        String trim = str.trim();
        if (trim.isEmpty()) {
            return "";
        }
        char[] charArray = trim.toCharArray();
        int length = charArray.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (charArray[i2] >= 'A' && charArray[i2] <= 'Z') {
                charArray[i2] = (char) (charArray[i2] + ' ');
                i++;
            }
        }
        return i > 0 ? String.valueOf(charArray) : trim;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0132, code lost:
        if ("|apk|json|mp4|avi|jpg|png|js|svg|txt|".contains("|" + r1 + "|") != false) goto L_0x0134;
     */
    public static int c(String str) {
        if (str != null) {
            String b = b(str);
            if (!b.isEmpty()) {
                int indexOf = b.indexOf(32);
                int indexOf2 = b.indexOf(58);
                int indexOf3 = b.indexOf("://");
                int length = b.length();
                if (indexOf3 > 0) {
                    String substring = b.substring(0, indexOf3);
                    if (!"http|https|ftp".contains(substring)) {
                        if (!e(substring) || indexOf >= 0) {
                            return 0;
                        }
                        return 1;
                    }
                } else if (indexOf2 > 0) {
                    if (b.startsWith("javascript:")) {
                        return 1;
                    }
                    String[] strArr = {"about:", "mailto:", "tel:", "magnet:", "tg:", "data:image/", "data:", "view-source:"};
                    int i = 0;
                    while (i < 8) {
                        String str2 = strArr[i];
                        if (!b.startsWith(str2)) {
                            i++;
                        } else if (length <= str2.length() || indexOf >= 0) {
                            return 0;
                        } else {
                            return 1;
                        }
                    }
                }
                int indexOf4 = b.indexOf(46);
                int i2 = indexOf3 + 3;
                int indexOf5 = b.indexOf(47, i2);
                if (indexOf <= 0 && indexOf4 >= 0 && (indexOf4 <= indexOf5 || indexOf5 <= 0)) {
                    if (indexOf3 <= 0) {
                        i2 = 0;
                    }
                    if (indexOf5 > 0) {
                        length = indexOf5;
                    }
                    String substring2 = b.substring(i2, length);
                    int indexOf6 = substring2.indexOf(58);
                    if (indexOf6 > 0) {
                        if (!f(substring2.substring(indexOf6 + 1))) {
                            return 0;
                        }
                        substring2 = substring2.substring(0, indexOf6);
                    }
                    String substring3 = substring2.substring(substring2.lastIndexOf(46) + 1);
                    if (a(substring3)) {
                        if (!g(substring3)) {
                            return 0;
                        }
                        int i3 = 0;
                        int i4 = 0;
                        while (true) {
                            int indexOf7 = substring2.indexOf(46, i3);
                            if (indexOf7 > 0) {
                                if (!g(substring2.substring(i3, indexOf7))) {
                                    return 0;
                                }
                                i3 = indexOf7 + 1;
                                i4++;
                            } else if (i4 == 3) {
                                return indexOf3 > 0 ? 1 : 2;
                            } else {
                                return 0;
                            }
                        }
                    } else if (substring3.length() >= 2 && !substring2.contains("..") && substring2.charAt(0) != '.') {
                        if (indexOf3 < 0) {
                            if (d(substring3)) {
                            }
                            return 0;
                        }
                        if (indexOf3 > 0) {
                            return 1;
                        }
                        return 2;
                    }
                }
            }
        }
        return 0;
    }

    private static boolean d(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z')) {
                return false;
            }
        }
        return true;
    }

    private static boolean e(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && (charAt < '0' || charAt > '9'))) {
                return false;
            }
        }
        return true;
    }

    private static boolean f(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d  */
    private static boolean g(String str) {
        int length;
        if (str == null || (length = str.length()) > 3) {
            return false;
        }
        char charAt = str.charAt(0);
        if (length == 3 && charAt != '1' && charAt != '2') {
            return false;
        }
        while (length > 1) {
            length--;
            char charAt2 = str.charAt(length);
            if (charAt2 < '0' || charAt2 > '9') {
                return false;
            }
            while (length > 1) {
            }
        }
        return true;
    }

    public static boolean h(String str) {
        return c(str) != 0;
    }

    public static String i(String str) {
        return a(str, null);
    }

    public static String a(String str, String str2) {
        if (str == null) {
            return "";
        }
        String trim = str.trim();
        if (trim.isEmpty()) {
            return "";
        }
        int c = c(trim);
        if (c == 0 && str2 != null && !str2.isEmpty()) {
            try {
                trim = URLEncoder.encode(trim, "utf-8");
            } catch (Exception unused) {
            }
            return str2 + trim;
        } else if (c != 2) {
            return trim;
        } else {
            return "http://" + trim;
        }
    }
}
