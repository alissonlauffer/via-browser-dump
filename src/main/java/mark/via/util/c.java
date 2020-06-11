package mark.via.util;

import android.text.TextUtils;

/* compiled from: ChannelUtils */
public class c {
    public static String a() {
        return "google";
    }

    public static boolean a(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && str.equals("google")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b() {
        return true;
    }
}
