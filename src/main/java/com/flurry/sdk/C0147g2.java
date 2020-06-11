package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.g2 */
public final class C0147g2 {

    /* renamed from: a */
    String f452a;

    /* renamed from: com.flurry.sdk.g2$a */
    public static class C0148a implements AbstractC0185l2<C0147g2> {

        /* renamed from: com.flurry.sdk.g2$a$a */
        class C0149a extends DataOutputStream {
            C0149a(C0148a aVar, OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public final void close() {
            }
        }

        /* renamed from: com.flurry.sdk.g2$a$b */
        class C0150b extends DataInputStream {
            C0150b(C0148a aVar, InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public final void close() {
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: a */
        public final /* synthetic */ void mo105a(OutputStream outputStream, C0147g2 g2Var) {
            C0147g2 g2Var2 = g2Var;
            if (outputStream != null && g2Var2 != null) {
                C0149a aVar = new C0149a(this, outputStream);
                aVar.writeUTF(g2Var2.f452a);
                aVar.flush();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: b */
        public final /* synthetic */ C0147g2 mo106b(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            C0150b bVar = new C0150b(this, inputStream);
            C0147g2 g2Var = new C0147g2((byte) 0);
            g2Var.f452a = bVar.readUTF();
            return g2Var;
        }
    }

    /* synthetic */ C0147g2(byte b) {
        this();
    }

    private C0147g2() {
    }

    public C0147g2(String str) {
        this.f452a = str;
    }
}
