package com.flurry.sdk;

import android.content.Context;
import java.lang.ref.WeakReference;

/* renamed from: com.flurry.sdk.ec */
public final class C0127ec extends AbstractC0184l1 {

    /* renamed from: b */
    public WeakReference<Context> f383b;

    /* renamed from: c */
    public C0125eb f384c;

    /* renamed from: d */
    public int f385d;

    /* renamed from: e */
    public long f386e;

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* renamed from: com.flurry.sdk.ec$a */
    public static final class EnumC0128a extends Enum<EnumC0128a> {

        /* renamed from: a */
        public static final int f387a = 1;

        /* renamed from: b */
        public static final int f388b = 2;

        /* renamed from: c */
        public static final int f389c = 3;

        /* renamed from: d */
        public static final int f390d = 4;

        /* renamed from: e */
        public static final int f391e = 5;

        /* renamed from: f */
        private static final /* synthetic */ int[] f392f = {1, 2, 3, 4, 5};

        /* renamed from: a */
        public static int[] m408a() {
            return (int[]) f392f.clone();
        }
    }

    public C0127ec() {
        super("com.flurry.android.sdk.FlurrySessionEvent");
    }
}
