package mark.via.utils;

import android.text.TextUtils;

/* renamed from: mark.via.n.f */
/* compiled from: ChannelUtils */
public class ChannelUtils {
    /* renamed from: a */
    public static String m2106a() {
        return "google";
    }

    /* renamed from: b */
    public static boolean m2107b(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && str.equals("google")) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m2108c() {
        return true;
    }
}
