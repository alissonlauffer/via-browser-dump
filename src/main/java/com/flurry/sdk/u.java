package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    long f197a;
    boolean b;
    byte[] c;

    public static class a implements l2<u> {

        /* renamed from: com.flurry.sdk.u$a$a  reason: collision with other inner class name */
        class C0022a extends DataOutputStream {
            C0022a(a aVar, OutputStream outputStream) {
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
        public final /* synthetic */ void a(OutputStream outputStream, u uVar) {
            u uVar2 = uVar;
            if (outputStream != null && uVar2 != null) {
                C0022a aVar = new C0022a(this, outputStream);
                aVar.writeLong(uVar2.f197a);
                aVar.writeBoolean(uVar2.b);
                aVar.writeInt(uVar2.c.length);
                aVar.write(uVar2.c);
                aVar.flush();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.l2
        public final /* synthetic */ u a(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            b bVar = new b(this, inputStream);
            u uVar = new u();
            uVar.f197a = bVar.readLong();
            uVar.b = bVar.readBoolean();
            byte[] bArr = new byte[bVar.readInt()];
            uVar.c = bArr;
            bVar.readFully(bArr);
            return uVar;
        }
    }
}
