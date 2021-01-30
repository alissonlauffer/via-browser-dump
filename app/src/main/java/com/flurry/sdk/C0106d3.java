package com.flurry.sdk;

import android.text.TextUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

/* renamed from: com.flurry.sdk.d3 */
public final class C0106d3 {
    static {
        Pattern.compile("/");
    }

    /* renamed from: a */
    public static String m364a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            if (new URI(str).isAbsolute() || TextUtils.isEmpty(str2)) {
                return str;
            }
            URI uri = new URI(str2);
            return uri.getScheme() + "://" + uri.getHost() + str;
        } catch (Exception unused) {
            return str;
        }
    }

    /* renamed from: b */
    public static boolean m365b(String str) {
        URI c;
        if (TextUtils.isEmpty(str) || (c = m366c(str)) == null) {
            return false;
        }
        if (c.getScheme() == null || "http".equalsIgnoreCase(c.getScheme()) || "https".equalsIgnoreCase(c.getScheme())) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private static URI m366c(String str) {
        try {
            return new URI(str);
        } catch (URISyntaxException unused) {
            return null;
        }
    }
}
