package com.flurry.sdk;

/* renamed from: com.flurry.sdk.k */
public final class C0171k {

    /* renamed from: a */
    final EnumC0172a f513a;

    /* renamed from: b */
    private int f514b = m496b();

    /* renamed from: com.flurry.sdk.k$a */
    public enum EnumC0172a {
        TEN_SEC(10),
        THIRTY_SEC(30),
        THREE_MIN(180),
        ABANDON(0);
        

        /* renamed from: e */
        int f520e;

        private EnumC0172a(int i) {
            this.f520e = i;
        }

        /* renamed from: a */
        public final EnumC0172a mo251a() {
            if (ordinal() == values().length - 1) {
                return this;
            }
            return values()[ordinal() + 1];
        }
    }

    public C0171k(EnumC0172a aVar) {
        this.f513a = aVar;
    }

    /* renamed from: b */
    private static int m496b() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    /* renamed from: a */
    public final int mo250a() {
        return (this.f513a.f520e + this.f514b) - m496b();
    }
}
