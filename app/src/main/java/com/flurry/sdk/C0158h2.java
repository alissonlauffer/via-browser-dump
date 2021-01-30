package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.h2 */
public final class C0158h2 implements AbstractC0185l2<byte[]> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
    @Override // com.flurry.sdk.AbstractC0185l2
    /* renamed from: a */
    public final /* synthetic */ void mo105a(OutputStream outputStream, byte[] bArr) {
        byte[] bArr2 = bArr;
        if (outputStream != null && bArr2 != null) {
            outputStream.write(bArr2, 0, bArr2.length);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.flurry.sdk.AbstractC0185l2
    /* renamed from: b */
    public final /* synthetic */ byte[] mo106b(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        C0328z2.m887b(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
