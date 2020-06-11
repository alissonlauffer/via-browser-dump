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

public final class z2 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f229a = "z2";

    public static void a() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException("Must be called from a background thread!");
        }
    }

    public static String b(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 255) {
            return str;
        }
        return str.substring(0, 255);
    }

    public static String c(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            String str2 = f229a;
            s1.a(5, str2, "Cannot encode '" + str + "'");
            return "";
        }
    }

    public static byte[] d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            String str2 = f229a;
            s1.a(5, str2, "Unsupported UTF-8: " + e.getMessage());
            return null;
        }
    }

    public static byte[] e(String str) {
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

    public static long f(String str) {
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

    public static String a(String str) {
        return (!TextUtils.isEmpty(str) && Uri.parse(str).getScheme() == null) ? "http://".concat(String.valueOf(str)) : str;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(int i) {
        return Build.VERSION.SDK_INT >= i;
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            String str = f229a;
            s1.a(5, str, "Unsupported ISO-8859-1:" + e.getMessage());
            return null;
        }
    }

    public static byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static long a(InputStream inputStream, OutputStream outputStream) {
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

    public static double a(double d, int i) {
        if (i == -1) {
            return d;
        }
        double d2 = (double) i;
        double round = (double) Math.round(d * Math.pow(10.0d, d2));
        double pow = Math.pow(10.0d, d2);
        Double.isNaN(round);
        return round / pow;
    }

    public static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                    return true;
                }
                return false;
            } catch (Exception e) {
                String str2 = f229a;
                s1.a(6, str2, "Error occured when checking if app has permission.  Error: " + e.getMessage());
            }
        }
        return false;
    }
}
