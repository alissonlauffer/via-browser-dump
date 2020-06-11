package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class p0 {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public final List<m0> f174a = new ArrayList();
    /* access modifiers changed from: package-private */
    public boolean b;
    /* access modifiers changed from: package-private */
    public long c;

    public static class a implements l2<p0> {

        /* renamed from: com.flurry.sdk.p0$a$a  reason: collision with other inner class name */
        class C0020a extends DataInputStream {
            C0020a(a aVar, InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public final void close() {
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.l2
        public final /* synthetic */ p0 a(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            C0020a aVar = new C0020a(this, inputStream);
            p0 p0Var = new p0();
            aVar.readUTF();
            aVar.readUTF();
            boolean unused = p0Var.b = aVar.readBoolean();
            long unused2 = p0Var.c = aVar.readLong();
            while (true) {
                int readUnsignedShort = aVar.readUnsignedShort();
                if (readUnsignedShort == 0) {
                    return p0Var;
                }
                byte[] bArr = new byte[readUnsignedShort];
                aVar.readFully(bArr);
                p0Var.f174a.add(0, new m0(bArr));
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
        @Override // com.flurry.sdk.l2
        public final /* synthetic */ void a(OutputStream outputStream, p0 p0Var) {
            throw new UnsupportedOperationException("Serialization not supported");
        }
    }
}
