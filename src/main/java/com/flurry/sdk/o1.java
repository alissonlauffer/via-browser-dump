package com.flurry.sdk;

import java.util.Comparator;

public class o1 implements Comparator<Runnable> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f170a = o1.class.getSimpleName();

    private static int a(Runnable runnable) {
        if (runnable == null) {
            return Integer.MAX_VALUE;
        }
        if (runnable instanceof p1) {
            c3 c3Var = (c3) ((p1) runnable).a();
            if (c3Var != null) {
                return c3Var.d;
            }
            return Integer.MAX_VALUE;
        } else if (runnable instanceof c3) {
            return ((c3) runnable).d;
        } else {
            String str = f170a;
            s1.a(6, str, "Unknown runnable class: " + runnable.getClass().getName());
            return Integer.MAX_VALUE;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public /* synthetic */ int compare(Runnable runnable, Runnable runnable2) {
        int a2 = a(runnable);
        int a3 = a(runnable2);
        if (a2 < a3) {
            return -1;
        }
        return a2 > a3 ? 1 : 0;
    }
}
