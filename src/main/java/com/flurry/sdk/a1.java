package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class a1 {

    /* renamed from: a  reason: collision with root package name */
    boolean f56a;
    byte[] b;
    byte[] c;
    int d;

    /* synthetic */ a1(byte b2) {
        this();
    }

    public a1(byte[] bArr, byte[] bArr2, boolean z, int i) {
        this.b = bArr2;
        this.c = bArr;
        this.f56a = z;
        this.d = i;
    }

    private a1() {
    }

    static class a implements l2<a1> {

        /* renamed from: com.flurry.sdk.a1$a$a  reason: collision with other inner class name */
        class C0011a extends DataOutputStream {
            C0011a(a aVar, OutputStream outputStream) {
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

        a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
        @Override // com.flurry.sdk.l2
        public final /* synthetic */ void a(OutputStream outputStream, a1 a1Var) {
            a1 a1Var2 = a1Var;
            if (outputStream != null && a1Var2 != null) {
                C0011a aVar = new C0011a(this, outputStream);
                aVar.writeBoolean(a1Var2.f56a);
                byte[] bArr = a1Var2.b;
                if (bArr == null) {
                    aVar.writeInt(0);
                } else {
                    aVar.writeInt(bArr.length);
                    aVar.write(a1Var2.b);
                }
                byte[] bArr2 = a1Var2.c;
                if (bArr2 == null) {
                    aVar.writeInt(0);
                } else {
                    aVar.writeInt(bArr2.length);
                    aVar.write(a1Var2.c);
                }
                aVar.writeInt(a1Var2.d);
                aVar.flush();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.l2
        public final /* synthetic */ a1 a(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            b bVar = new b(this, inputStream);
            a1 a1Var = new a1((byte) 0);
            a1Var.f56a = bVar.readBoolean();
            int readInt = bVar.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                a1Var.b = bArr;
                bVar.read(bArr, 0, readInt);
            } else {
                a1Var.b = null;
            }
            int readInt2 = bVar.readInt();
            if (readInt2 > 0) {
                byte[] bArr2 = new byte[readInt2];
                a1Var.c = bArr2;
                bVar.read(bArr2, 0, readInt2);
            } else {
                a1Var.c = null;
            }
            a1Var.d = bVar.readInt();
            return a1Var;
        }
    }
}
