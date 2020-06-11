package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public final class e2 {

    /* renamed from: a  reason: collision with root package name */
    String f111a;
    byte[] b;

    class a implements n2<e2> {
        a() {
        }

        @Override // com.flurry.sdk.n2
        public final l2<e2> a(int i) {
            return new b(i);
        }
    }

    /* synthetic */ e2(byte b2) {
        this();
    }

    public static String a(String str) {
        return ".yflurrydatasenderblock.".concat(String.valueOf(str));
    }

    public static k1<e2> b(String str) {
        return new k1<>(e1.a().f110a.getFileStreamPath(a(str)), ".yflurrydatasenderblock.", 2, new a());
    }

    private e2() {
        this.f111a = null;
        this.b = null;
    }

    public e2(byte[] bArr) {
        this.f111a = null;
        this.b = null;
        this.f111a = UUID.randomUUID().toString();
        this.b = bArr;
    }

    public static class b implements l2<e2> {

        /* renamed from: a  reason: collision with root package name */
        private int f112a = 1;

        class a extends DataOutputStream {
            a(b bVar, OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public final void close() {
            }
        }

        /* renamed from: com.flurry.sdk.e2$b$b  reason: collision with other inner class name */
        class C0015b extends DataInputStream {
            C0015b(b bVar, InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public final void close() {
            }
        }

        public b(int i) {
            this.f112a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
        @Override // com.flurry.sdk.l2
        public final /* synthetic */ void a(OutputStream outputStream, e2 e2Var) {
            e2 e2Var2 = e2Var;
            if (outputStream != null && e2Var2 != null) {
                a aVar = new a(this, outputStream);
                int length = e2Var2.b.length;
                if (this.f112a == 1) {
                    aVar.writeShort(length);
                } else {
                    aVar.writeInt(length);
                }
                aVar.write(e2Var2.b);
                aVar.writeShort(0);
                aVar.flush();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.l2
        public final /* synthetic */ e2 a(InputStream inputStream) {
            int i;
            if (inputStream == null) {
                return null;
            }
            C0015b bVar = new C0015b(this, inputStream);
            e2 e2Var = new e2((byte) 0);
            if (this.f112a == 1) {
                i = bVar.readShort();
            } else {
                i = bVar.readInt();
            }
            if (i == 0) {
                return null;
            }
            byte[] bArr = new byte[i];
            e2Var.b = bArr;
            bVar.readFully(bArr);
            bVar.readUnsignedShort();
            return e2Var;
        }
    }
}
