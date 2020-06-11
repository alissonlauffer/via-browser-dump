package mark.via.utils;

/* renamed from: mark.via.n.s */
/* compiled from: MimeTypeUtils */
public class MimeTypeUtils {

    /* renamed from: a */
    private static final String[] f1534a = {".3gp", "video/3gpp", ".apk", "application/vnd.android.package-archive", ".asf", "video/x-ms-asf", ".avi", "video/x-msvideo", ".bin", "application/octet-stream", ".bmp", "image/bmp", ".c", "text/plain", ".class", "application/octet-stream", ".conf", "text/plain", ".cpp", "text/plain", ".doc", "application/msword", ".exe", "application/octet-stream", ".gif", "image/gif", ".gtar", "application/x-gtar", ".gz", "application/x-gzip", ".h", "text/plain", ".htm", "text/html", ".html", "text/html", ".jar", "application/java-archive", ".java", "text/plain", ".jpeg", "image/jpeg", ".jpg", "image/jpeg", ".js", "application/x-javascript", ".log", "text/plain", ".m3u", "audio/x-mpegurl", ".m4a", "audio/mp4a-latm", ".m4b", "audio/mp4a-latm", ".m4p", "audio/mp4a-latm", ".m4u", "video/vnd.mpegurl", ".m4v", "video/x-m4v", ".mov", "video/quicktime", ".mp2", "audio/x-mpeg", ".mp3", "audio/x-mpeg", ".mp4", "video/mp4", ".mpc", "application/vnd.mpohun.certificate", ".mpe", "video/mpeg", ".mpeg", "video/mpeg", ".mpg", "video/mpeg", ".mpg4", "video/mp4", ".mpga", "audio/mpeg", ".msg", "application/vnd.ms-outlook", ".ogg", "audio/ogg", ".pdf", "application/pdf", ".png", "image/png", ".pps", "application/vnd.ms-powerpoint", ".ppt", "application/vnd.ms-powerpoint", ".prop", "text/plain", ".rar", "application/x-rar-compressed", ".rc", "text/plain", ".rmvb", "audio/x-pn-realaudio", ".rtf", "application/rtf", ".sh", "text/plain", ".tar", "application/x-tar", ".tgz", "application/x-compressed", ".txt", "text/plain", ".wav", "audio/x-wav", ".wma", "audio/x-ms-wma", ".wmv", "audio/x-ms-wmv", ".wps", "application/vnd.ms-works", ".xml", "text/plain", ".z", "application/x-compress", ".zip", "application/zip"};

    /* renamed from: a */
    public static String m2186a(String str) {
        return m2187b(str, "*/*");
    }

    /* renamed from: b */
    public static String m2187b(String str, String str2) {
        int lastIndexOf;
        if (str != null && str.length() > 0 && (lastIndexOf = str.lastIndexOf(46)) >= 0) {
            String substring = str.substring(lastIndexOf);
            if (substring.length() >= 2) {
                int length = f1534a.length;
                for (int i = 0; i < length; i += 2) {
                    String[] strArr = f1534a;
                    if (strArr[i].equals(substring)) {
                        return strArr[i + 1];
                    }
                }
            }
        }
        return str2;
    }
}
