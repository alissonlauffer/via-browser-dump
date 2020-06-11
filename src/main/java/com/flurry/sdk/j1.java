package com.flurry.sdk;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.zip.CRC32;

public final class j1 extends MessageDigest {

    /* renamed from: a  reason: collision with root package name */
    private CRC32 f145a = new CRC32();

    public j1() {
        super("CRC");
    }

    public final byte[] a() {
        return engineDigest();
    }

    public final int b() {
        return ByteBuffer.wrap(engineDigest()).getInt();
    }

    /* access modifiers changed from: protected */
    public final byte[] engineDigest() {
        long value = this.f145a.getValue();
        return new byte[]{(byte) ((int) ((-16777216 & value) >> 24)), (byte) ((int) ((16711680 & value) >> 16)), (byte) ((int) ((65280 & value) >> 8)), (byte) ((int) ((value & 255) >> 0))};
    }

    /* access modifiers changed from: protected */
    public final void engineReset() {
        this.f145a.reset();
    }

    /* access modifiers changed from: protected */
    @Override // java.security.MessageDigestSpi
    public final void engineUpdate(byte b) {
        this.f145a.update(b);
    }

    /* access modifiers changed from: protected */
    public final void engineUpdate(byte[] bArr, int i, int i2) {
        this.f145a.update(bArr, i, i2);
    }
}
