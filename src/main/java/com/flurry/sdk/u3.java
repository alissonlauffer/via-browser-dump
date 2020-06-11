package com.flurry.sdk;

import android.content.Context;

public final class u3 {
    public static t3 a(Context context, String str) {
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return new q3(str);
        }
        return new r3(context, str);
    }
}
