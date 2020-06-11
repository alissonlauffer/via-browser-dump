package a.a.a;

import android.text.TextUtils;

/* compiled from: MimeTypeUtils */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f6a = {".aac", "audio/aac", ".abw", "application/x-abiword", ".apk", "application/vnd.android.package-archive", ".arc", "application/x-freearc", ".asf", "video/x-ms-asf", ".avi", "video/x-msvideo", ".azw", "application/vnd.amazon.ebook", ".bin", "application/octet-stream", ".bmp", "image/bmp", ".bz", "application/x-bzip", ".bz2", "application/x-bzip2", ".csh", "application/x-csh", ".css", "text/css", ".csv", "text/csv", ".doc", "application/msword", ".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", ".eot", "application/vnd.ms-fontobject", ".epub", "application/epub+zip", ".exe", "application/octet-stream", ".gif", "image/gif", ".gtar", "application/x-gtar", ".gz", "application/x-gzip", ".htm", "text/html", ".html", "text/html", ".ico", "image/vnd.microsoft.icon", ".ics", "text/calendar", ".jar", "application/java-archive", ".jpeg", "image/jpeg", ".jpg", "image/jpeg", ".js", "text/javascript", ".json", "application/json", ".jsonld", "application/ld+json", ".mid", "audio/midi", ".midi", "audio/x-midi", ".mjs", "text/javascript", ".mov", "video/quicktime", ".mpc", "application/vnd.mpohun.certificate", ".mpe", "video/mpeg", ".mpeg", "video/mpeg", ".mpg", "video/mpeg", ".mpga", "audio/mpeg", ".mpg4", "video/mp4", ".mpkg", "application/vnd.apple.installer+xml", ".mp2", "audio/x-mpeg", ".mp3", "audio/mpeg", ".mp4", "video/mp4", ".m3u", "audio/x-mpegurl", ".m4a", "audio/mp4a-latm", ".m4b", "audio/mp4a-latm", ".m4p", "audio/mp4a-latm", ".m4u", "video/vnd.mpegurl", ".m4v", "video/x-m4v", ".odp", "application/vnd.oasis.opendocument.presentation", ".ods", "application/vnd.oasis.opendocument.spreadsheet", ".odt", "application/vnd.oasis.opendocument.text", ".oga", "audio/ogg", ".ogg", "audio/ogg", ".ogv", "video/ogg", ".ogx", "application/ogg", ".otf", "font/otf", ".png", "image/png", ".pdf", "application/pdf", ".pps", "application/vnd.ms-powerpoint", ".ppt", "application/vnd.ms-powerpoint", ".pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation", ".rar", "application/x-rar-compressed", ".rmvb", "audio/x-pn-realaudio", ".rtf", "application/rtf", ".sh", "application/x-sh", ".svg", "image/svg+xml", ".swf", "application/x-shockwave-flash", ".tar", "application/x-tar", ".tgz", "application/x-compressed", ".tif", "image/tiff", ".tiff", "image/tiff", ".ttf", "font/ttf", ".txt", "text/plain", ".vsd", "application/vnd.visio", ".wav", "audio/wav", ".weba", "audio/webm", ".webm", "video/webm", ".webp", "image/webp", ".wma", "audio/x-ms-wma", ".wmv", "audio/x-ms-wmv", ".woff", "font/woff", ".woff2", "font/woff2", ".wps", "application/vnd.ms-works", ".xhtml", "application/xhtml+xml", ".xls", "application/vnd.ms-excel", ".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", ".xml", "text/xml", ".xul", "application/vnd.mozilla.xul+xml", ".z", "application/x-compress", ".zip", "application/zip", ".3gp", "video/3gpp", ".3g2", "video/3gpp2", ".7z", "application/x-7z-compressed"};

    public static int a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.charAt(0) == '.') {
                int length = f6a.length / 2;
                for (int i = 0; i < length; i++) {
                    int i2 = i * 2;
                    if (f6a[i2].equals(str)) {
                        return i2 + 1;
                    }
                }
            }
        }
        return -1;
    }

    public static int a(String[] strArr) {
        int length = strArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int a2 = a(strArr[i2]);
            if (a2 > -1) {
                i++;
                strArr[i2] = f6a[a2];
            }
        }
        return i;
    }
}
