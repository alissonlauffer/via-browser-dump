package com.flurry.sdk;

import java.util.Comparator;

/* renamed from: com.flurry.sdk.o1 */
public class C0224o1 implements Comparator<Runnable> {

    /* renamed from: a */
    private static final String f656a = C0224o1.class.getSimpleName();

    /* renamed from: a */
    private static int m583a(Runnable runnable) {
        if (runnable == null) {
            return Integer.MAX_VALUE;
        }
        if (runnable instanceof C0231p1) {
            AbstractC0075c3 c3Var = (AbstractC0075c3) ((C0231p1) runnable).mo307a();
            if (c3Var != null) {
                return c3Var.f226d;
            }
            return Integer.MAX_VALUE;
        } else if (runnable instanceof AbstractC0075c3) {
            return ((AbstractC0075c3) runnable).f226d;
        } else {
            String str = f656a;
            C0260s1.m686c(6, str, "Unknown runnable class: " + runnable.getClass().getName());
            return Integer.MAX_VALUE;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public /* synthetic */ int compare(Runnable runnable, Runnable runnable2) {
        int a = m583a(runnable);
        int a2 = m583a(runnable2);
        if (a < a2) {
            return -1;
        }
        return a > a2 ? 1 : 0;
    }
}
