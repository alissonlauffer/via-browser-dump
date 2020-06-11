package a.a.a;

import android.webkit.URLUtil;
import java.net.URLDecoder;
import java.nio.charset.Charset;

/* compiled from: DownloaderUtils */
public class b {
    public static String a(String str, String str2, String str3) {
        String a2 = a(str2);
        if (a2 == null || a2.length() <= 0) {
            a2 = URLUtil.guessFileName(str, str2, str3);
            if (a2.endsWith(".bin")) {
                a2 = URLUtil.guessFileName(str, str2, null);
            }
        }
        if (a2.indexOf(37) < 0) {
            return a2;
        }
        try {
            return URLDecoder.decode(a2, Charset.forName("UTF-8").name());
        } catch (Exception unused) {
            return a2;
        }
    }

    private static String a(String str) {
        int indexOf;
        int indexOf2;
        int lastIndexOf;
        if (str != null && str.length() > 0 && (indexOf = str.indexOf("filename")) >= 0) {
            String trim = str.substring(indexOf + 8).trim();
            if (trim.length() > 0 && (indexOf2 = trim.indexOf(61)) >= 0) {
                String trim2 = trim.substring(indexOf2 + 1).trim();
                if (trim2.length() > 0) {
                    while (trim2.indexOf(61) >= 0 && (lastIndexOf = trim2.lastIndexOf(59)) >= 0) {
                        trim2 = trim2.substring(0, lastIndexOf).trim();
                    }
                    if (trim2.length() <= 0) {
                        return null;
                    }
                    if (trim2.charAt(0) == '\"' || trim2.charAt(0) == '\'') {
                        trim2 = trim2.substring(1);
                    }
                    int length = trim2.length() - 1;
                    return (trim2.charAt(length) == '\"' || trim2.charAt(length) == '\'') ? trim2.substring(0, length) : trim2;
                }
            }
        }
        return null;
    }
}
