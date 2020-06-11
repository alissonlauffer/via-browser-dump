package com.flurry.sdk;

import android.content.Context;

/* renamed from: com.flurry.sdk.u3 */
public final class C0277u3 {
    /* renamed from: a */
    public static AbstractRunnableC0267t3 m727a(Context context, String str) {
        if (str.startsWith("http://") || str.startsWith("https://")) {
            return new C0251q3(str);
        }
        return new C0257r3(context, str);
    }
}
