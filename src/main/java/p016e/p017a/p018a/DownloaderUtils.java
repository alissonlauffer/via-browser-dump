package p016e.p017a.p018a;

import android.webkit.URLUtil;
import java.net.URLDecoder;
import java.nio.charset.Charset;

/* renamed from: e.a.a.b */
/* compiled from: DownloaderUtils */
public class DownloaderUtils {
    /* renamed from: a */
    public static String m938a(String str, String str2, String str3) {
        String b = m939b(str2);
        if (b == null || b.length() <= 0) {
            b = URLUtil.guessFileName(str, str2, str3);
            if (b.endsWith(".bin")) {
                b = URLUtil.guessFileName(str, str2, null);
            }
        }
        if (b.indexOf(37) < 0) {
            return b;
        }
        try {
            return URLDecoder.decode(b, Charset.forName("UTF-8").name());
        } catch (Exception unused) {
            return b;
        }
    }

    /* renamed from: b */
    public static String m939b(String str) {
        int indexOf;
        if (str == null || str.isEmpty() || ((indexOf = str.indexOf("filename*=")) < 0 && (indexOf = str.indexOf("filename")) < 0)) {
            return null;
        }
        String substring = str.substring(indexOf);
        while (true) {
            int lastIndexOf = substring.lastIndexOf(59);
            if (lastIndexOf <= 0) {
                break;
            }
            substring = substring.substring(0, lastIndexOf).trim();
        }
        int indexOf2 = substring.indexOf(61);
        if (indexOf2 > 0) {
            substring = substring.substring(indexOf2 + 1).trim();
            int indexOf3 = substring.indexOf("''");
            if (indexOf3 > 0) {
                substring = substring.substring(indexOf3 + 2).trim();
            }
            int indexOf4 = substring.indexOf("' '");
            if (indexOf4 > 0) {
                substring = substring.substring(indexOf4 + 3).trim();
            }
        }
        if (substring.isEmpty()) {
            return null;
        }
        if (substring.charAt(0) == '\"' || substring.charAt(0) == '\'') {
            substring = substring.substring(1);
        }
        int length = substring.length() - 1;
        return (substring.charAt(length) == '\"' || substring.charAt(length) == '\'') ? substring.substring(0, length) : substring;
    }
}
