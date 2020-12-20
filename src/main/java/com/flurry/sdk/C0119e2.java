package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/* renamed from: com.flurry.sdk.e2 */
public final class C0119e2 {

    /* renamed from: a */
    String f367a;

    /* renamed from: b */
    byte[] f368b;

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.e2$a */
    public class C0120a implements AbstractC0201n2<C0119e2> {
        C0120a() {
        }

        @Override // com.flurry.sdk.AbstractC0201n2
        /* renamed from: a */
        public final AbstractC0185l2<C0119e2> mo100a(int i) {
            return new C0121b(i);
        }
    }

    /* renamed from: com.flurry.sdk.e2$b */
    public static class C0121b implements AbstractC0185l2<C0119e2> {

        /* renamed from: a */
        private int f369a = 1;

        /* renamed from: com.flurry.sdk.e2$b$a */
        class C0122a extends DataOutputStream {
            C0122a(C0121b bVar, OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public final void close() {
            }
        }

        /* renamed from: com.flurry.sdk.e2$b$b */
        class C0123b extends DataInputStream {
            C0123b(C0121b bVar, InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public final void close() {
            }
        }

        public C0121b(int i) {
            this.f369a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: a */
        public final /* synthetic */ void mo105a(OutputStream outputStream, C0119e2 e2Var) {
            C0119e2 e2Var2 = e2Var;
            if (outputStream != null && e2Var2 != null) {
                C0122a aVar = new C0122a(this, outputStream);
                int length = e2Var2.f368b.length;
                if (this.f369a == 1) {
                    aVar.writeShort(length);
                } else {
                    aVar.writeInt(length);
                }
                aVar.write(e2Var2.f368b);
                aVar.writeShort(0);
                aVar.flush();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: b */
        public final /* synthetic */ C0119e2 mo106b(InputStream inputStream) {
            int i;
            if (inputStream == null) {
                return null;
            }
            C0123b bVar = new C0123b(this, inputStream);
            C0119e2 e2Var = new C0119e2((byte) 0);
            if (this.f369a == 1) {
                i = bVar.readShort();
            } else {
                i = bVar.readInt();
            }
            if (i == 0) {
                return null;
            }
            byte[] bArr = new byte[i];
            e2Var.f368b = bArr;
            bVar.readFully(bArr);
            bVar.readUnsignedShort();
            return e2Var;
        }
    }

    /* synthetic */ C0119e2(byte b) {
        this();
    }

    /* renamed from: a */
    public static String m394a(String str) {
        return ".yflurrydatasenderblock.".concat(String.valueOf(str));
    }

    /* renamed from: b */
    public static C0174k1<C0119e2> m395b(String str) {
        return new C0174k1<>(C0118e1.m386a().f361a.getFileStreamPath(m394a(str)), ".yflurrydatasenderblock.", 2, new C0120a());
    }

    private C0119e2() {
        this.f367a = null;
        this.f368b = null;
    }

    public C0119e2(byte[] bArr) {
        this.f367a = null;
        this.f368b = null;
        this.f367a = UUID.randomUUID().toString();
        this.f368b = bArr;
    }
}
