package com.flurry.sdk;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* renamed from: com.flurry.sdk.cn */
public final class C0082cn extends AbstractC0184l1 {

    /* renamed from: b */
    public WeakReference<Activity> f246b = new WeakReference<>(null);

    /* renamed from: c */
    public int f247c;

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* renamed from: com.flurry.sdk.cn$a */
    public static final class EnumC0083a extends Enum<EnumC0083a> {

        /* renamed from: a */
        public static final int f248a = 1;

        /* renamed from: b */
        public static final int f249b = 2;

        /* renamed from: c */
        public static final int f250c = 3;

        /* renamed from: d */
        public static final int f251d = 4;

        /* renamed from: e */
        public static final int f252e = 5;

        /* renamed from: f */
        public static final int f253f = 6;

        /* renamed from: g */
        public static final int f254g = 7;

        /* renamed from: h */
        private static final /* synthetic */ int[] f255h = {1, 2, 3, 4, 5, 6, 7};

        /* renamed from: a */
        public static int[] m312a() {
            return (int[]) f255h.clone();
        }
    }

    C0082cn() {
        super("com.flurry.android.sdk.ActivityLifecycleEvent");
    }
}
