package com.flurry.sdk;

import android.app.Activity;
import java.lang.ref.WeakReference;

public final class cn extends l1 {
    public WeakReference<Activity> b = new WeakReference<>(null);
    public int c;

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class a extends Enum<a> {

        /* renamed from: a  reason: collision with root package name */
        public static final int f92a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        private static final /* synthetic */ int[] h = {1, 2, 3, 4, 5, 6, 7};

        public static int[] a() {
            return (int[]) h.clone();
        }
    }

    cn() {
        super("com.flurry.android.sdk.ActivityLifecycleEvent");
    }
}
