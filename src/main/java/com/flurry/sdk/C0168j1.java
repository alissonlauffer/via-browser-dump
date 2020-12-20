package com.flurry.sdk;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.zip.CRC32;

/* renamed from: com.flurry.sdk.j1 */
public final class C0168j1 extends MessageDigest {

    /* renamed from: a */
    private CRC32 f512a = new CRC32();

    public C0168j1() {
        super("CRC");
    }

    /* renamed from: a */
    public final byte[] mo244a() {
        return engineDigest();
    }

    /* renamed from: b */
    public final int mo245b() {
        return ByteBuffer.wrap(engineDigest()).getInt();
    }

    /* access modifiers changed from: protected */
    @Override // java.security.MessageDigestSpi
    public final byte[] engineDigest() {
        long value = this.f512a.getValue();
        return new byte[]{(byte) ((int) ((-16777216 & value) >> 24)), (byte) ((int) ((16711680 & value) >> 16)), (byte) ((int) ((65280 & value) >> 8)), (byte) ((int) ((value & 255) >> 0))};
    }

    /* access modifiers changed from: protected */
    @Override // java.security.MessageDigestSpi
    public final void engineReset() {
        this.f512a.reset();
    }

    /* access modifiers changed from: protected */
    @Override // java.security.MessageDigestSpi
    public final void engineUpdate(byte b) {
        this.f512a.update(b);
    }

    /* access modifiers changed from: protected */
    @Override // java.security.MessageDigestSpi
    public final void engineUpdate(byte[] bArr, int i, int i2) {
        this.f512a.update(bArr, i, i2);
    }
}
