package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.m2 */
public final class C0193m2<T> implements AbstractC0185l2<T> {

    /* renamed from: a */
    private final String f544a;

    /* renamed from: b */
    private final int f545b;

    /* renamed from: c */
    private final AbstractC0201n2<T> f546c;

    /* renamed from: com.flurry.sdk.m2$a */
    class C0194a extends DataOutputStream {
        C0194a(C0193m2 m2Var, OutputStream outputStream) {
            super(outputStream);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
        public final void close() {
        }
    }

    /* renamed from: com.flurry.sdk.m2$b */
    class C0195b extends DataInputStream {
        C0195b(C0193m2 m2Var, InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public final void close() {
        }
    }

    public C0193m2(String str, int i, AbstractC0201n2<T> n2Var) {
        this.f544a = str;
        this.f545b = i;
        this.f546c = n2Var;
    }

    @Override // com.flurry.sdk.AbstractC0185l2
    /* renamed from: a */
    public final void mo105a(OutputStream outputStream, T t) {
        if (outputStream != null && this.f546c != null) {
            C0194a aVar = new C0194a(this, outputStream);
            aVar.writeUTF(this.f544a);
            aVar.writeInt(this.f545b);
            this.f546c.mo100a(this.f545b).mo105a(aVar, t);
            aVar.flush();
        }
    }

    @Override // com.flurry.sdk.AbstractC0185l2
    /* renamed from: b */
    public final T mo106b(InputStream inputStream) {
        if (inputStream == null || this.f546c == null) {
            return null;
        }
        C0195b bVar = new C0195b(this, inputStream);
        String readUTF = bVar.readUTF();
        if (this.f544a.equals(readUTF)) {
            return this.f546c.mo100a(bVar.readInt()).mo106b(bVar);
        }
        throw new IOException("Signature: " + readUTF + " is invalid");
    }
}
