package com.flurry.sdk;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/* renamed from: com.flurry.sdk.w1 */
public class C0299w1<ObjectType> {

    /* renamed from: c */
    public static final String f826c = "w1";

    /* renamed from: d */
    private static final byte[] f827d = {113, -92, -8, 125, 121, 107, -65, -61, -74, -114, -32, 0, -57, -87, -35, -56, -6, -52, 51, 126, -104, 49, 79, -52, 118, -84, 99, -52, -14, -126, -27, -64};

    /* renamed from: a */
    public String f828a;

    /* renamed from: b */
    public AbstractC0185l2<ObjectType> f829b;

    public C0299w1(String str, AbstractC0185l2<ObjectType> l2Var) {
        this.f828a = str;
        this.f829b = l2Var;
    }

    /* renamed from: a */
    public static int m811a(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        C0168j1 j1Var = new C0168j1();
        j1Var.update(bArr);
        return j1Var.mo245b();
    }

    /* renamed from: b */
    public static void m812b(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            int length2 = f827d.length;
            for (int i = 0; i < length; i++) {
                bArr[i] = (byte) ((bArr[i] ^ f827d[i % length2]) ^ ((i * 31) % 251));
            }
        }
    }

    /* renamed from: d */
    private static void m813d(byte[] bArr) {
        m812b(bArr);
    }

    /* renamed from: c */
    public final ObjectType mo360c(byte[] bArr) {
        if (bArr != null) {
            m813d(bArr);
            byte[] bArr2 = (byte[]) new C0169j2(new C0158h2()).mo106b(new ByteArrayInputStream(bArr));
            String str = f826c;
            C0260s1.m686c(3, str, "Decoding: " + this.f828a + ": " + new String(bArr2));
            return this.f829b.mo106b(new ByteArrayInputStream(bArr2));
        }
        throw new IOException("Decoding: " + this.f828a + ": Nothing to decode");
    }
}
