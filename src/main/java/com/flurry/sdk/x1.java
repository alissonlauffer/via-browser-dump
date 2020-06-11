package com.flurry.sdk;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class x1 {

    /* renamed from: a  reason: collision with root package name */
    private final Pattern f217a = Pattern.compile(".*?(%\\{\\w+\\}).*?");

    public final String a(String str) {
        Matcher matcher = this.f217a.matcher(str);
        if (matcher.matches()) {
            return matcher.group(1);
        }
        return null;
    }

    protected static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals("%{" + str + "}");
    }
}
