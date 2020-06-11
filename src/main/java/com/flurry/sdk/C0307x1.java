package com.flurry.sdk;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.flurry.sdk.x1 */
public class C0307x1 {

    /* renamed from: a */
    private final Pattern f840a = Pattern.compile(".*?(%\\{\\w+\\}).*?");

    /* renamed from: b */
    protected static boolean m835b(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals("%{" + str + "}");
    }

    /* renamed from: a */
    public final String mo361a(String str) {
        Matcher matcher = this.f840a.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }
}
