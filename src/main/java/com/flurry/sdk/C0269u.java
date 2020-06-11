package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.u */
public final class C0269u {

    /* renamed from: a */
    long f759a;

    /* renamed from: b */
    boolean f760b;

    /* renamed from: c */
    byte[] f761c;

    /* renamed from: com.flurry.sdk.u$a */
    public static class C0270a implements AbstractC0185l2<C0269u> {

        /* renamed from: com.flurry.sdk.u$a$a */
        class C0271a extends DataOutputStream {
            C0271a(C0270a aVar, OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public final void close() {
            }
        }

        /* renamed from: com.flurry.sdk.u$a$b */
        class C0272b extends DataInputStream {
            C0272b(C0270a aVar, InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public final void close() {
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: a */
        public final /* synthetic */ void mo105a(OutputStream outputStream, C0269u uVar) {
            C0269u uVar2 = uVar;
            if (outputStream != null && uVar2 != null) {
                C0271a aVar = new C0271a(this, outputStream);
                aVar.writeLong(uVar2.f759a);
                aVar.writeBoolean(uVar2.f760b);
                aVar.writeInt(uVar2.f761c.length);
                aVar.write(uVar2.f761c);
                aVar.flush();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: b */
        public final /* synthetic */ C0269u mo106b(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            C0272b bVar = new C0272b(this, inputStream);
            C0269u uVar = new C0269u();
            uVar.f759a = bVar.readLong();
            uVar.f760b = bVar.readBoolean();
            byte[] bArr = new byte[bVar.readInt()];
            uVar.f761c = bArr;
            bVar.readFully(bArr);
            return uVar;
        }
    }
}
