package com.flurry.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.flurry.sdk.e1;
import com.flurry.sdk.m3;

public final class d {
    private static d b;

    /* renamed from: a  reason: collision with root package name */
    private com.flurry.sdk.d f50a = com.flurry.sdk.d.d();

    private d() {
    }

    public static synchronized d b() {
        d dVar;
        synchronized (d.class) {
            if (b == null) {
                if (e1.a() != null) {
                    b = new d();
                } else {
                    throw new IllegalStateException("Flurry SDK must be initialized before starting config");
                }
            }
            dVar = b;
        }
        return dVar;
    }

    public final void a() {
        this.f50a.b();
    }

    public final String toString() {
        return this.f50a.toString();
    }

    public final String a(@NonNull String str, @Nullable String str2) {
        return this.f50a.a().a(str, str2, m3.c);
    }

    public final int a(@NonNull String str, int i) {
        return this.f50a.a().a(str, i, m3.c);
    }
}
