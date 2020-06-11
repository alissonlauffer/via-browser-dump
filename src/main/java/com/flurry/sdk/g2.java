package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class g2 {

    /* renamed from: a  reason: collision with root package name */
    String f129a;

    /* synthetic */ g2(byte b) {
        this();
    }

    private g2() {
    }

    public g2(String str) {
        this.f129a = str;
    }

    public static class a implements l2<g2> {

        /* renamed from: com.flurry.sdk.g2$a$a  reason: collision with other inner class name */
        class C0016a extends DataOutputStream {
            C0016a(a aVar, OutputStream outputStream) {
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
        public final /* synthetic */ void a(OutputStream outputStream, g2 g2Var) {
            g2 g2Var2 = g2Var;
            if (outputStream != null && g2Var2 != null) {
                C0016a aVar = new C0016a(this, outputStream);
                aVar.writeUTF(g2Var2.f129a);
                aVar.flush();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.l2
        public final /* synthetic */ g2 a(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            b bVar = new b(this, inputStream);
            g2 g2Var = new g2((byte) 0);
            g2Var.f129a = bVar.readUTF();
            return g2Var;
        }
    }
}
