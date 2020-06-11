package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.flurry.sdk.p0 */
public class C0228p0 {

    /* renamed from: a */
    final List<C0188m0> f671a = new ArrayList();

    /* renamed from: b */
    boolean f672b;

    /* renamed from: c */
    long f673c;

    /* renamed from: com.flurry.sdk.p0$a */
    public static class C0229a implements AbstractC0185l2<C0228p0> {

        /* renamed from: com.flurry.sdk.p0$a$a */
        class C0230a extends DataInputStream {
            C0230a(C0229a aVar, InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public final void close() {
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: a */
        public final /* synthetic */ void mo105a(OutputStream outputStream, C0228p0 p0Var) {
            throw new UnsupportedOperationException("Serialization not supported");
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: b */
        public final /* synthetic */ C0228p0 mo106b(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            C0230a aVar = new C0230a(this, inputStream);
            C0228p0 p0Var = new C0228p0();
            aVar.readUTF();
            aVar.readUTF();
            p0Var.f672b = aVar.readBoolean();
            p0Var.f673c = aVar.readLong();
            while (true) {
                int readUnsignedShort = aVar.readUnsignedShort();
                if (readUnsignedShort == 0) {
                    return p0Var;
                }
                byte[] bArr = new byte[readUnsignedShort];
                aVar.readFully(bArr);
                p0Var.f671a.add(0, new C0188m0(bArr));
            }
        }
    }
}
