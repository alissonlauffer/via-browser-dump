package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    byte[] f109a;

    public e0() {
    }

    public e0(byte[] bArr) {
        this.f109a = bArr;
    }

    public static class a implements l2<e0> {

        /* renamed from: com.flurry.sdk.e0$a$a  reason: collision with other inner class name */
        class C0014a extends DataOutputStream {
            C0014a(a aVar, OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public final void close() {
            }
        }

        class b extends DataInputStream {
            b(a aVar, InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public final void close() {
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
        @Override // com.flurry.sdk.l2
        public final /* synthetic */ void a(OutputStream outputStream, e0 e0Var) {
            e0 e0Var2 = e0Var;
            if (outputStream != null && e0Var2 != null) {
                C0014a aVar = new C0014a(this, outputStream);
                aVar.writeShort(e0Var2.f109a.length);
                aVar.write(e0Var2.f109a);
                aVar.writeShort(0);
                aVar.flush();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.l2
        public final /* synthetic */ e0 a(InputStream inputStream) {
            b bVar;
            int readShort;
            if (inputStream == null || (readShort = (bVar = new b(this, inputStream)).readShort()) == 0) {
                return null;
            }
            e0 e0Var = new e0();
            byte[] bArr = new byte[readShort];
            e0Var.f109a = bArr;
            bVar.readFully(bArr);
            bVar.readUnsignedShort();
            return e0Var;
        }
    }
}
