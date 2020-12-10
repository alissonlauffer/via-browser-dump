package p000a.p001a.p002a.util;

import android.annotation.TargetApi;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceRequest;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import p000a.p001a.p002a.filter.ElementFilter;
import p000a.p001a.p002a.filter.Filter;
import p000a.p001a.p002a.filter.FilterSubscription;
import p000a.p001a.p002a.filter.RequestFilter;

/* renamed from: a.a.a.g.a */
/* compiled from: FilterUtils */
public class FilterUtils {

    /* renamed from: a */
    private static final char[] f38a = {'@', '|', '*', '^'};

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0057, code lost:
        r5 = false;
     */
    /* renamed from: a */
    public static String m96a(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            return str;
        }
        if (str == null || str.isEmpty()) {
            return str2;
        }
        int length = str2.length();
        int i = 0;
        while (i < length) {
            int indexOf = str2.indexOf(44, i);
            if (indexOf < 0) {
                indexOf = length;
            }
            String substring = str2.substring(i, indexOf);
            boolean z = true;
            int i2 = indexOf + 1;
            if (!substring.isEmpty()) {
                int i3 = 0;
                while (true) {
                    int indexOf2 = str.indexOf(substring, i3);
                    if (indexOf2 < 0) {
                        break;
                    }
                    int i4 = indexOf2 - 1;
                    int length2 = substring.length() + indexOf2;
                    if ((i4 < 0 || str.charAt(i4) == ',') && (length2 >= str.length() || str.charAt(length2) == ',')) {
                        break;
                    }
                    i3 = indexOf2 + 1;
                }
                if (z) {
                    str = str + "," + substring;
                }
            }
            i = i2;
        }
        return str;
    }

    /* renamed from: b */
    public static FilterSubscription m97b(FilterSubscription cVar) {
        LineNumberReader lineNumberReader;
        int i;
        String[] strArr;
        String readLine;
        System.out.println("Try complete filter");
        if (!(cVar == null || cVar.mo24a() == null)) {
            File file = new File(cVar.mo24a());
            if (file.exists()) {
                System.out.println("Complete filter");
                try {
                    lineNumberReader = new LineNumberReader(new FileReader(file));
                    i = 20;
                    try {
                        strArr = new String[]{"Title:", "Homepage:", "License:"};
                        lineNumberReader.skip(Long.MAX_VALUE);
                        cVar.mo35k(lineNumberReader.getLineNumber() + 1);
                        lineNumberReader.close();
                        System.out.println(cVar.toString());
                        return cVar;
                    } catch (Throwable unused) {
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                while (true) {
                    int i2 = i - 1;
                    if (i <= 0 || (readLine = lineNumberReader.readLine()) == null) {
                        break;
                    }
                    if (!readLine.isEmpty()) {
                        if (readLine.charAt(0) == '!') {
                            for (int i3 = 0; i3 < 3; i3++) {
                                int indexOf = readLine.indexOf(strArr[i3]);
                                if (indexOf >= 0) {
                                    readLine = readLine.substring(indexOf + strArr[i3].length()).trim();
                                    if (i3 == 0) {
                                        cVar.mo36l(readLine);
                                    } else if (i3 == 1) {
                                        cVar.mo33i(readLine);
                                    } else if (i3 == 2) {
                                        cVar.mo34j(readLine);
                                    }
                                }
                            }
                        }
                    }
                    i = i2;
                }
            }
        }
        System.out.println("return");
        return cVar;
        throw th;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e7 A[SYNTHETIC, Splitter:B:48:0x00e7] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ef A[Catch:{ IOException -> 0x00eb }] */
    /* renamed from: c */
    public static boolean m98c(String str, String str2) {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        Exception e;
        System.out.println("downloading: " + str);
        BufferedInputStream bufferedInputStream = null;
        boolean z = false;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36");
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            String headerField = httpURLConnection.getHeaderField("Content-Type");
            System.out.println("status code: " + responseCode);
            System.out.println("content type: " + headerField);
            if (responseCode != 200 || headerField == null || !headerField.trim().startsWith("text/plain")) {
                bufferedOutputStream = null;
            } else {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str2));
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream = null;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                        }
                        if (bufferedOutputStream != null) {
                        }
                        return z;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                throw th;
                            }
                        }
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        bufferedOutputStream.write(bArr, 0, read);
                    }
                    System.out.println("download done");
                    bufferedInputStream = bufferedInputStream2;
                    z = true;
                } catch (Exception e4) {
                    e = e4;
                    bufferedInputStream = bufferedInputStream2;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    return z;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    throw th;
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
        } catch (Exception e6) {
            e = e6;
            bufferedOutputStream = null;
            e.printStackTrace();
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            return z;
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream = null;
            if (bufferedInputStream != null) {
            }
            if (bufferedOutputStream != null) {
            }
            throw th;
        }
        return z;
    }

    /* renamed from: d */
    public static String m99d(String str, Set<String> set) {
        if (!(str == null || str.isEmpty() || set == null)) {
            int indexOf = str.indexOf("://");
            int i = indexOf < 0 ? 0 : indexOf + 3;
            int indexOf2 = str.indexOf(36);
            int i2 = -1;
            if (indexOf2 == -1) {
                indexOf2 = str.length();
            }
            int i3 = indexOf2 - 5;
            while (i <= i3) {
                String substring = str.substring(i, i + 5);
                char[] cArr = f38a;
                int length = cArr.length;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    i2 = substring.lastIndexOf(cArr[i4]);
                    if (i2 >= 0) {
                        i += i2;
                        break;
                    }
                    i4++;
                }
                if (i2 < 0 && !set.contains(substring)) {
                    return substring;
                }
                i++;
            }
        }
        return null;
    }

    @TargetApi(21)
    /* renamed from: e */
    public static int m100e(WebResourceRequest webResourceRequest, String str) {
        int i;
        boolean z;
        String uri = webResourceRequest.getUrl().toString();
        if (!webResourceRequest.isForMainFrame() || !uri.equals(str)) {
            i = 0;
            z = false;
        } else {
            i = 32;
            z = true;
        }
        if (uri.startsWith("ws")) {
            i |= 512;
        }
        if ("XMLHttpRequest".equals(webResourceRequest.getRequestHeaders().get("X-Requested-With"))) {
            i |= 1024;
        }
        String i2 = m104i(uri);
        if ("js".equals(i2)) {
            return i | 2;
        }
        if ("css".equals(i2)) {
            return i | 8;
        }
        if ("otf".equals(i2) || "ttf".equals(i2) || "ttc".equals(i2) || "woff".equals(i2) || "woff2".equals(i2)) {
            return i | 128;
        }
        if (!"php".equals(i2)) {
            String j = m105j(i2);
            if (!"application/octet-stream".equals(j)) {
                return m102g(j) | i;
            }
        }
        if (z) {
            return i | 1;
        }
        String str2 = webResourceRequest.getRequestHeaders().get("Accept");
        if (str2 == null || "*/*".equals(str2)) {
            return i | 1 | 64 | 4 | 128 | 8 | 2;
        }
        int indexOf = str2.indexOf(44);
        if (indexOf > 0) {
            str2 = str2.substring(0, indexOf).trim();
        }
        return m102g(str2) | i;
    }

    /* renamed from: f */
    public static int m101f(String str, String str2) {
        boolean z;
        int i = 0;
        if (str.equals(str2)) {
            i = 32;
            z = true;
        } else {
            z = false;
        }
        if (str.startsWith("ws")) {
            i |= 512;
        }
        String i2 = m104i(str);
        if ("js".equals(i2)) {
            return i | 2;
        }
        if ("css".equals(i2)) {
            return i | 8;
        }
        if ("otf".equals(i2) || "ttf".equals(i2) || "ttc".equals(i2) || "woff".equals(i2) || "woff2".equals(i2)) {
            return i | 128;
        }
        if (!"php".equals(i2)) {
            String j = m105j(i2);
            if (!"application/octet-stream".equals(j)) {
                return m102g(j) | i;
            }
        }
        return z ? i | 1 : i | 1 | 64 | 4 | 128 | 8 | 2;
    }

    /* renamed from: g */
    public static int m102g(String str) {
        if (str == null || str.isEmpty()) {
            return 1;
        }
        if ("application/javascript".equals(str) || "application/x-javascript".equals(str) || "text/javascript".equals(str) || "application/json".equals(str)) {
            return 2;
        }
        if ("text/css".equals(str)) {
            return 8;
        }
        if (str.startsWith("image/")) {
            return 4;
        }
        if (str.startsWith("video/") || str.startsWith("audio/")) {
            return 64;
        }
        if (str.startsWith("font/")) {
            return 128;
        }
        return 1;
    }

    /* renamed from: h */
    public static String m103h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        int indexOf = str.indexOf("://");
        if (indexOf >= 0) {
            str = str.substring(indexOf + 3);
        }
        int indexOf2 = str.indexOf(47);
        if (indexOf2 > 0) {
            str = str.substring(0, indexOf2);
        }
        int indexOf3 = str.indexOf(58);
        return indexOf3 > 0 ? str.substring(0, indexOf3) : str;
    }

    /* renamed from: i */
    public static String m104i(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        int indexOf = str.indexOf(63);
        if (indexOf > 0) {
            str = str.substring(0, indexOf);
        }
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf > 0) {
            str = str.substring(lastIndexOf + 1);
        }
        int indexOf2 = str.indexOf(46);
        if (indexOf2 <= 0) {
            return null;
        }
        String lowerCase = str.substring(indexOf2 + 1).toLowerCase();
        if (lowerCase.isEmpty() || lowerCase.length() > 8) {
            return null;
        }
        return lowerCase;
    }

    /* renamed from: j */
    public static String m105j(String str) {
        if ("js".equals(str)) {
            return "application/javascript";
        }
        if ("mhtml".equals(str) || "mht".equals(str)) {
            return "multipart/related";
        }
        if ("json".equals(str)) {
            return "application/json";
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        return (mimeTypeFromExtension == null || mimeTypeFromExtension.isEmpty()) ? "application/octet-stream" : mimeTypeFromExtension;
    }

    /* renamed from: k */
    public static String m106k(String str) {
        int lastIndexOf;
        int lastIndexOf2;
        if (str == null || str.length() == 0 || (lastIndexOf = str.lastIndexOf(46)) < 0 || (lastIndexOf2 = str.lastIndexOf(46, lastIndexOf - 1)) < 0) {
            return str;
        }
        String substring = str.substring(lastIndexOf2 + 1, lastIndexOf);
        if ("|com|net|org|gov|co|".contains("|" + substring + "|")) {
            lastIndexOf2 = str.lastIndexOf(".", lastIndexOf2 - 1);
        }
        return str.substring(lastIndexOf2 + 1);
    }

    /* renamed from: l */
    public static boolean m107l(String str, String str2) {
        return str2 == null || str.equals(str2) || str.contains(m106k(str2));
    }

    /* renamed from: m */
    private static boolean m108m(char c) {
        return c == '/' || c == '.';
    }

    /* renamed from: n */
    private static boolean m109n(char c) {
        return (c < '0' || c > '9') && (c < 'A' || c > 'Z') && !((c >= 'a' && c <= 'z') || c == '_' || c == '-' || c == '.' || c == '%');
    }

    /* renamed from: o */
    public static List<Filter> m110o(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null && !str.isEmpty()) {
            File file = new File(str);
            if (!file.isDirectory() && file.exists()) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            Filter t = m115t(readLine);
                            if (t != null) {
                                arrayList.add(t);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    bufferedReader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
        throw th;
    }

    /* renamed from: p */
    public static boolean m111p(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        if (str.indexOf(42) >= 0 || str.indexOf(94) >= 0 || str.indexOf(124) >= 0) {
            return m113r(m117v(str), str2);
        }
        return str2.contains(str);
    }

    /* renamed from: q */
    public static boolean m112q(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        if (str2 != null && !str2.isEmpty()) {
            boolean z = str.charAt(0) == '~';
            int length = str.length();
            int i = 0;
            do {
                int indexOf = str.indexOf(124, i);
                if (indexOf < 0) {
                    indexOf = length;
                }
                if (z) {
                    i++;
                }
                if (str2.contains(str.substring(i, indexOf))) {
                    return !z;
                }
                i = indexOf + 1;
            } while (i < length);
            return false;
        } else if (str.charAt(0) == '~') {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: r */
    public static boolean m113r(String str, String str2) {
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        while (i < str2.length()) {
            if (i2 < str.length() && ((str.charAt(i2) == '^' && m109n(str2.charAt(i))) || ((str.charAt(i2) == '|' && m108m(str2.charAt(i))) || str.charAt(i2) == str2.charAt(i)))) {
                i++;
                i2++;
            } else if (i2 < str.length() && str.charAt(i2) == '*') {
                i4 = i;
                i3 = i2;
                i2++;
            } else if (i3 == -1) {
                return false;
            } else {
                i2 = i3 + 1;
                i4++;
                i = i4;
            }
        }
        while (i2 < str.length() && str.charAt(i2) == '*') {
            i2++;
        }
        if (i2 == str.length()) {
            return true;
        }
        return false;
    }

    /* renamed from: s */
    public static boolean m114s(Boolean bool, boolean z) {
        return bool == null || bool.booleanValue() == z;
    }

    /* renamed from: t */
    public static Filter m115t(String str) {
        if (str == null || str.isEmpty() || str.charAt(0) == '!') {
            return null;
        }
        return (str.contains("##") || str.contains("#@#")) ? ElementFilter.m16c(str) : RequestFilter.m37g(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        if (r5 != 0) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005c, code lost:
        if (r7 < r9.length()) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005e, code lost:
        r9 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        r9 = r9.substring((r5 + r2.length()) + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006d, code lost:
        r9 = r9.substring(0, r6) + r9.substring(r5 + r2.length());
     */
    /* renamed from: u */
    public static String m116u(String str, String str2) {
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty()) {
            int length = str2.length();
            int i = 0;
            while (i < length) {
                int indexOf = str2.indexOf(44, i);
                if (indexOf < 0) {
                    indexOf = length;
                }
                String substring = str2.substring(i, indexOf);
                int i2 = indexOf + 1;
                if (!substring.isEmpty()) {
                    int i3 = 0;
                    while (true) {
                        int indexOf2 = str.indexOf(substring, i3);
                        if (indexOf2 < 0) {
                            break;
                        }
                        int i4 = indexOf2 - 1;
                        int length2 = substring.length() + indexOf2;
                        if ((i4 < 0 || str.charAt(i4) == ',') && (length2 >= str.length() || str.charAt(length2) == ',')) {
                            break;
                        }
                        i3 = indexOf2 + 1;
                    }
                }
                i = i2;
            }
        }
        return str;
    }

    /* renamed from: v */
    public static String m117v(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str.charAt(0) != '*') {
            str = '*' + str;
        }
        if (str.charAt(str.length() - 1) == '*') {
            return str;
        }
        return str + '*';
    }

    /* renamed from: w */
    public static String m118w(String str, String str2) {
        String h;
        if (str2 == null || str2.isEmpty() || (h = m103h(str)) == null || h.isEmpty()) {
            return null;
        }
        return String.format("%s##%s", h, str2.trim());
    }

    /* renamed from: x */
    public static String m119x(String str, boolean z) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (z) {
            return String.format("||%s^", m103h(str));
        }
        return String.format("|%s", str);
    }
}
