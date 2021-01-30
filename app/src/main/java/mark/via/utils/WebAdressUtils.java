package mark.via.utils;

import java.net.URLEncoder;

/* renamed from: mark.via.n.z */
/* compiled from: WebAdressUtils */
public class WebAdressUtils {
    /* renamed from: a */
    public static String m2249a(String str) {
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

    /* renamed from: b */
    public static int m2250b(String str) {
        if (str == null) {
            return 0;
        }
        String a = m2249a(str);
        if (a.isEmpty()) {
            return 0;
        }
        int indexOf = a.indexOf(32);
        int indexOf2 = a.indexOf(58);
        int indexOf3 = a.indexOf("://");
        int length = a.length();
        if (indexOf3 > 0) {
            String substring = a.substring(0, indexOf3);
            if (substring.contains("/") || substring.contains("?")) {
                indexOf3 = -1;
            } else if (!"http|https|ftp".contains(substring)) {
                if (!CharUtils.m2112d(substring, 3) || indexOf >= 0) {
                    return 0;
                }
                return 1;
            }
        } else if (indexOf2 > 0) {
            if (a.startsWith("javascript:")) {
                return 1;
            }
            String[] strArr = {"about:", "mailto:", "tel:", "magnet:", "tg:", "data:image/", "data:", "view-source:"};
            String substring2 = a.substring(0, indexOf2);
            if (!"localhost".equals(substring2) && CharUtils.m2112d(substring2, 1)) {
                for (int i = 0; i < 8; i++) {
                    String str2 = strArr[i];
                    if (a.startsWith(str2)) {
                        if (length <= str2.length() || indexOf >= 0) {
                            return 0;
                        } else {
                            return 1;
                        }
                    }
                }
            }
        }
        int i2 = indexOf3 > 0 ? indexOf3 + 3 : 0;
        int indexOf4 = a.indexOf(47, i2);
        if (indexOf4 < 0) {
            indexOf4 = a.indexOf(63, i2);
        }
        if (indexOf > 0 && indexOf4 > indexOf) {
            return 0;
        }
        if (indexOf4 > 0) {
            length = indexOf4;
        }
        if (m2252d(a.substring(i2, length), indexOf3 > 0)) {
            return indexOf3 > 0 ? 1 : 2;
        }
        return 0;
    }

    /* renamed from: c */
    public static boolean m2251c(String str) {
        return str != null && !str.isEmpty() && str.startsWith("data:image/") && str.contains(";base64,");
    }

    /* renamed from: d */
    public static boolean m2252d(String str, boolean z) {
        if (str == null || str.isEmpty() || str.indexOf(32) >= 0 || str.indexOf(47) >= 0) {
            return false;
        }
        int lastIndexOf = str.lastIndexOf(58);
        if (lastIndexOf > 0) {
            if (!CharUtils.m2112d(str.substring(lastIndexOf + 1), 2)) {
                return false;
            }
            str = str.substring(0, lastIndexOf);
        }
        if ("localhost".equals(str) || (z && CharUtils.m2112d(str, 1))) {
            return true;
        }
        if (str.charAt(0) == '[' && str.charAt(str.length() - 1) == ']') {
            return CharUtils.m2113e(str.substring(1, str.length() - 1), 4, new int[]{58});
        }
        int lastIndexOf2 = str.lastIndexOf(46);
        if (lastIndexOf2 >= 0 && !str.contains("..")) {
            String substring = str.substring(lastIndexOf2 + 1);
            if (CharUtils.m2112d(substring, 2)) {
                if (Integer.parseInt(substring) > 255) {
                    return false;
                }
                int i = 0;
                while (true) {
                    int indexOf = str.indexOf(46, i);
                    if (indexOf < 0) {
                        return true;
                    }
                    String substring2 = str.substring(i, indexOf);
                    if (substring2.isEmpty() || !CharUtils.m2112d(substring2, 2) || Integer.parseInt(substring2) > 255) {
                        break;
                    }
                    i = indexOf + 1;
                }
                return false;
            } else if (substring.length() > 1) {
                String str2 = "|" + substring + "|";
                if ("|中国|网址|在线|我爱你|商标|企业|商店|游戏|购物|中文网|商城|招聘|餐厅|公司|集团|网络|佛山|广东|".contains(str2)) {
                    return true;
                }
                if ("|apk|json|mp4|mp3|avi|jpg|png|svg|txt|html|xhtml|js|css|scss|gif|jpeg|".contains(str2)) {
                    return false;
                }
                return CharUtils.m2112d(substring, 1);
            }
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m2253e(String str) {
        return m2250b(str) != 0;
    }

    /* renamed from: f */
    public static String m2254f(String str) {
        return m2255g(str, null);
    }

    /* renamed from: g */
    public static String m2255g(String str, String str2) {
        if (str == null) {
            return "";
        }
        String trim = str.trim();
        if (trim.isEmpty()) {
            return "";
        }
        int b = m2250b(trim);
        if (b == 0 && str2 != null && !str2.isEmpty()) {
            try {
                trim = URLEncoder.encode(trim, "utf-8");
            } catch (Exception unused) {
            }
            return str2 + trim;
        } else if (b != 2) {
            return trim;
        } else {
            return "http://" + trim;
        }
    }
}
