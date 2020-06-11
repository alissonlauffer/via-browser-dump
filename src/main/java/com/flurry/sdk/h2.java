package com.flurry.sdk;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class h2 implements l2<byte[]> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
    @Override // com.flurry.sdk.l2
    public final /* synthetic */ void a(OutputStream outputStream, byte[] bArr) {
        byte[] bArr2 = bArr;
        if (outputStream != null && bArr2 != null) {
            outputStream.write(bArr2, 0, bArr2.length);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.flurry.sdk.l2
    public final /* synthetic */ byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        z2.a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
