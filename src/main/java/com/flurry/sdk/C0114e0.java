package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.e0 */
public final class C0114e0 {

    /* renamed from: a */
    byte[] f357a;

    /* renamed from: com.flurry.sdk.e0$a */
    public static class C0115a implements AbstractC0185l2<C0114e0> {

        /* renamed from: com.flurry.sdk.e0$a$a */
        class C0116a extends DataOutputStream {
            C0116a(C0115a aVar, OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public final void close() {
            }
        }

        /* renamed from: com.flurry.sdk.e0$a$b */
        class C0117b extends DataInputStream {
            C0117b(C0115a aVar, InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public final void close() {
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: a */
        public final /* synthetic */ void mo105a(OutputStream outputStream, C0114e0 e0Var) {
            C0114e0 e0Var2 = e0Var;
            if (outputStream != null && e0Var2 != null) {
                C0116a aVar = new C0116a(this, outputStream);
                aVar.writeShort(e0Var2.f357a.length);
                aVar.write(e0Var2.f357a);
                aVar.writeShort(0);
                aVar.flush();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: b */
        public final /* synthetic */ C0114e0 mo106b(InputStream inputStream) {
            C0117b bVar;
            int readShort;
            if (inputStream == null || (readShort = (bVar = new C0117b(this, inputStream)).readShort()) == 0) {
                return null;
            }
            C0114e0 e0Var = new C0114e0();
            byte[] bArr = new byte[readShort];
            e0Var.f357a = bArr;
            bVar.readFully(bArr);
            bVar.readUnsignedShort();
            return e0Var;
        }
    }

    public C0114e0() {
    }

    public C0114e0(byte[] bArr) {
        this.f357a = bArr;
    }
}
