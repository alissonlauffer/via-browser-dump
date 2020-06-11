package mark.via.utils;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import timber.log.Timber;

/* renamed from: mark.via.n.u */
/* compiled from: RomUtils */
public class RomUtils {
    /* renamed from: a */
    private static boolean m2189a(String str) {
        String str2 = "FLYME";
        if (!TextUtils.isEmpty(m2190b("ro.miui.ui.version.name"))) {
            str2 = "MIUI";
        } else if (!TextUtils.isEmpty(m2190b("ro.build.version.emui"))) {
            str2 = "EMUI";
        } else if (!TextUtils.isEmpty(m2190b("ro.build.version.opporom"))) {
            str2 = "OPPO";
        } else if (!TextUtils.isEmpty(m2190b("ro.vivo.os.version"))) {
            str2 = "VIVO";
        } else if (!TextUtils.isEmpty(m2190b("ro.smartisan.version"))) {
            str2 = "SMARTISAN";
        } else if (!Build.DISPLAY.toUpperCase().contains(str2)) {
            str2 = Build.MANUFACTURER.toUpperCase();
        }
        return str2.equals(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004a A[SYNTHETIC, Splitter:B:21:0x004a] */
    /* renamed from: b */
    private static String m2190b(String str) {
        Throwable th;
        IOException e;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        r0 = null;
        String str2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                str2 = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    Timber.m973c(e);
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
            Timber.m973c(e);
            if (bufferedReader != null) {
            }
            return str2;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader2 != null) {
            }
            throw th;
        }
        return str2;
    }

    /* renamed from: c */
    public static boolean m2191c() {
        return m2189a("EMUI");
    }
}
