package com.flurry.sdk;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: com.flurry.sdk.z2 */
public final class C0328z2 {

    /* renamed from: a */
    private static final String f897a = "z2";

    /* renamed from: a */
    public static double m886a(double d, int i) {
        if (i == -1) {
            return d;
        }
        double d2 = (double) i;
        double round = (double) Math.round(d * Math.pow(10.0d, d2));
        double pow = Math.pow(10.0d, d2);
        Double.isNaN(round);
        return round / pow;
    }

    /* renamed from: b */
    public static long m887b(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read < 0) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    /* renamed from: c */
    public static String m888c(String str) {
        return (!TextUtils.isEmpty(str) && Uri.parse(str).getScheme() == null) ? "http://".concat(String.valueOf(str)) : str;
    }

    /* renamed from: d */
    public static void m889d() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Must be called from a background thread!");
        }
    }

    /* renamed from: e */
    public static void m890e(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: f */
    public static boolean m891f(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    /* renamed from: g */
    public static boolean m892g(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                String str2 = f897a;
                C0260s1.m686c(6, str2, "Error occured when checking if app has permission.  Error: " + e.getMessage());
            }
        }
        return false;
    }

    /* renamed from: h */
    public static byte[] m893h(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m887b(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: i */
    public static String m894i(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 255) {
            return str;
        }
        return str.substring(0, 255);
    }

    /* renamed from: j */
    public static String m895j(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            String str = f897a;
            C0260s1.m686c(5, str, "Unsupported ISO-8859-1:" + e.getMessage());
            return null;
        }
    }

    /* renamed from: k */
    public static String m896k(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            String str2 = f897a;
            C0260s1.m686c(5, str2, "Cannot encode '" + str + "'");
            return "";
        }
    }

    /* renamed from: l */
    public static byte[] m897l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            String str2 = f897a;
            C0260s1.m686c(5, str2, "Unsupported UTF-8: " + e.getMessage());
            return null;
        }
    }

    /* renamed from: m */
    public static byte[] m898m(String str) {
        byte[] bArr = new byte[(str.length() / 2)];
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i += 2) {
            StringBuilder sb = new StringBuilder(2);
            sb.append(charArray[i]);
            sb.append(charArray[i + 1]);
            bArr[i / 2] = (byte) Integer.parseInt(sb.toString(), 16);
        }
        return bArr;
    }

    /* renamed from: n */
    public static long m899n(String str) {
        if (str == null) {
            return 0;
        }
        long j = 1125899906842597L;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            j = (j * 31) + ((long) str.charAt(i));
        }
        return j;
    }
}
