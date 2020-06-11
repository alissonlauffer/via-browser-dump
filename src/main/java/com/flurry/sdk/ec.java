package com.flurry.sdk;

import android.content.Context;
import java.lang.ref.WeakReference;

public final class ec extends l1 {
    public WeakReference<Context> b;
    public eb c;
    public int d;
    public long e;

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class a extends Enum<a> {

        /* renamed from: a  reason: collision with root package name */
        public static final int f116a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        private static final /* synthetic */ int[] f = {1, 2, 3, 4, 5};

        public static int[] a() {
            return (int[]) f.clone();
        }
    }

    public ec() {
        super("com.flurry.android.sdk.FlurrySessionEvent");
    }
}
