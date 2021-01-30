package com.flurry.sdk;

import android.text.TextUtils;

/* renamed from: com.flurry.sdk.l1 */
public abstract class AbstractC0184l1 {

    /* renamed from: a */
    protected String f539a = "com.flurry.android.sdk.ReplaceMeWithAProperEventName";

    public AbstractC0184l1(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f539a = str;
            return;
        }
        throw new IllegalArgumentException("Event must have a name!");
    }

    /* renamed from: a */
    public final String mo260a() {
        return this.f539a;
    }

    /* renamed from: b */
    public final void mo261b() {
        C0199n1.m528a().mo269c(this);
    }
}
