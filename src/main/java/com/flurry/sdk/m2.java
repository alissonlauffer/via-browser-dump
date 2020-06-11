package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class m2<T> implements l2<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f159a;
    private final int b;
    private final n2<T> c;

    class a extends DataOutputStream {
        a(m2 m2Var, OutputStream outputStream) {
            super(outputStream);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
        public final void close() {
        }
    }

    class b extends DataInputStream {
        b(m2 m2Var, InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
        public final void close() {
        }
    }

    public m2(String str, int i, n2<T> n2Var) {
        this.f159a = str;
        this.b = i;
        this.c = n2Var;
    }

    @Override // com.flurry.sdk.l2
    public final void a(OutputStream outputStream, T t) {
        if (outputStream != null && this.c != null) {
            a aVar = new a(this, outputStream);
            aVar.writeUTF(this.f159a);
            aVar.writeInt(this.b);
            this.c.a(this.b).a(aVar, t);
            aVar.flush();
        }
    }

    @Override // com.flurry.sdk.l2
    public final T a(InputStream inputStream) {
        if (inputStream == null || this.c == null) {
            return null;
        }
        b bVar = new b(this, inputStream);
        String readUTF = bVar.readUTF();
        if (this.f159a.equals(readUTF)) {
            return this.c.a(bVar.readInt()).a(bVar);
        }
        throw new IOException("Signature: " + readUTF + " is invalid");
    }
}
