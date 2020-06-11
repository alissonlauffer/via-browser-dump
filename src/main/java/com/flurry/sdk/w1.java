package com.flurry.sdk;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class w1<ObjectType> {
    public static final String c = "w1";
    private static final byte[] d = {113, -92, -8, 125, 121, 107, -65, -61, -74, -114, -32, 0, -57, -87, -35, -56, -6, -52, 51, 126, -104, 49, 79, -52, 118, -84, 99, -52, -14, -126, -27, -64};

    /* renamed from: a  reason: collision with root package name */
    public String f211a;
    public l2<ObjectType> b;

    public w1(String str, l2<ObjectType> l2Var) {
        this.f211a = str;
        this.b = l2Var;
    }

    public static int b(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        j1 j1Var = new j1();
        j1Var.update(bArr);
        return j1Var.b();
    }

    public static void c(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int length2 = d.length;
            for (int i = 0; i < length; i++) {
                bArr[i] = (byte) ((bArr[i] ^ d[i % length2]) ^ ((i * 31) % 251));
            }
        }
    }

    private static void d(byte[] bArr) {
        c(bArr);
    }

    public final ObjectType a(byte[] bArr) {
        if (bArr != null) {
            d(bArr);
            byte[] bArr2 = (byte[]) new j2(new h2()).a(new ByteArrayInputStream(bArr));
            String str = c;
            s1.a(3, str, "Decoding: " + this.f211a + ": " + new String(bArr2));
            return this.b.a(new ByteArrayInputStream(bArr2));
        }
        throw new IOException("Decoding: " + this.f211a + ": Nothing to decode");
    }
}
