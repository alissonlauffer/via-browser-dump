package com.flurry.sdk;

import android.text.TextUtils;

public abstract class l1 {

    /* renamed from: a  reason: collision with root package name */
    protected String f155a = "com.flurry.android.sdk.ReplaceMeWithAProperEventName";

    public l1(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f155a = str;
            return;
        }
        throw new IllegalArgumentException("Event must have a name!");
    }

    public final String a() {
        return this.f155a;
    }

    public final void b() {
        n1.a().a(this);
    }
}
