package com.flurry.sdk;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    final a f146a;
    private int b = b();

    public enum a {
        TEN_SEC(10),
        THIRTY_SEC(30),
        THREE_MIN(180),
        ABANDON(0);
        
        int e;

        private a(int i) {
            this.e = i;
        }

        public final a a() {
            if (ordinal() == values().length - 1) {
                return this;
            }
            return values()[ordinal() + 1];
        }
    }

    public k(a aVar) {
        this.f146a = aVar;
    }

    private static int b() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public final int a() {
        return (this.f146a.e + this.b) - b();
    }
}
