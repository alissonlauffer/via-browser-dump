package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.a1 */
public final class C0022a1 {

    /* renamed from: a */
    boolean f77a;

    /* renamed from: b */
    byte[] f78b;

    /* renamed from: c */
    byte[] f79c;

    /* renamed from: d */
    int f80d;

    /* renamed from: com.flurry.sdk.a1$a */
    static class C0023a implements AbstractC0185l2<C0022a1> {

        /* renamed from: com.flurry.sdk.a1$a$a */
        class C0024a extends DataOutputStream {
            C0024a(C0023a aVar, OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public final void close() {
            }
        }

        /* renamed from: com.flurry.sdk.a1$a$b */
        class C0025b extends DataInputStream {
            C0025b(C0023a aVar, InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public final void close() {
            }
        }

        C0023a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: a */
        public final /* synthetic */ void mo105a(OutputStream outputStream, C0022a1 a1Var) {
            C0022a1 a1Var2 = a1Var;
            if (outputStream != null && a1Var2 != null) {
                C0024a aVar = new C0024a(this, outputStream);
                aVar.writeBoolean(a1Var2.f77a);
                byte[] bArr = a1Var2.f78b;
                if (bArr == null) {
                    aVar.writeInt(0);
                } else {
                    aVar.writeInt(bArr.length);
                    aVar.write(a1Var2.f78b);
                }
                byte[] bArr2 = a1Var2.f79c;
                if (bArr2 == null) {
                    aVar.writeInt(0);
                } else {
                    aVar.writeInt(bArr2.length);
                    aVar.write(a1Var2.f79c);
                }
                aVar.writeInt(a1Var2.f80d);
                aVar.flush();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: b */
        public final /* synthetic */ C0022a1 mo106b(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            C0025b bVar = new C0025b(this, inputStream);
            C0022a1 a1Var = new C0022a1((byte) 0);
            a1Var.f77a = bVar.readBoolean();
            int readInt = bVar.readInt();
            if (readInt > 0) {
                byte[] bArr = new byte[readInt];
                a1Var.f78b = bArr;
                bVar.read(bArr, 0, readInt);
            } else {
                a1Var.f78b = null;
            }
            int readInt2 = bVar.readInt();
            if (readInt2 > 0) {
                byte[] bArr2 = new byte[readInt2];
                a1Var.f79c = bArr2;
                bVar.read(bArr2, 0, readInt2);
            } else {
                a1Var.f79c = null;
            }
            a1Var.f80d = bVar.readInt();
            return a1Var;
        }
    }

    /* synthetic */ C0022a1(byte b) {
        this();
    }

    public C0022a1(byte[] bArr, byte[] bArr2, boolean z, int i) {
        this.f78b = bArr2;
        this.f79c = bArr;
        this.f77a = z;
        this.f80d = i;
    }

    private C0022a1() {
    }
}
