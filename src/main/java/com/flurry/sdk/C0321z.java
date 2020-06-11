package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.z */
public class C0321z {

    /* renamed from: a */
    public int f878a;

    /* renamed from: b */
    public long f879b;

    /* renamed from: c */
    public long f880c;

    /* renamed from: d */
    public boolean f881d;

    /* renamed from: e */
    public int f882e;

    /* renamed from: f */
    public EnumC0031ax f883f;

    /* renamed from: g */
    public String f884g;

    /* renamed from: h */
    public int f885h;

    /* renamed from: i */
    public long f886i;

    /* renamed from: j */
    public boolean f887j;

    /* renamed from: k */
    public long f888k = 0;

    /* renamed from: l */
    public C0310y f889l;

    /* renamed from: com.flurry.sdk.z$a */
    public static class C0322a implements AbstractC0185l2<C0321z> {

        /* renamed from: com.flurry.sdk.z$a$a */
        class C0323a extends DataOutputStream {
            C0323a(C0322a aVar, OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public final void close() {
            }
        }

        /* renamed from: com.flurry.sdk.z$a$b */
        class C0324b extends DataInputStream {
            C0324b(C0322a aVar, InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public final void close() {
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: a */
        public final /* synthetic */ void mo105a(OutputStream outputStream, C0321z zVar) {
            C0321z zVar2 = zVar;
            if (outputStream != null && zVar2 != null) {
                C0323a aVar = new C0323a(this, outputStream);
                aVar.writeInt(zVar2.f878a);
                aVar.writeLong(zVar2.f879b);
                aVar.writeLong(zVar2.f880c);
                aVar.writeBoolean(zVar2.f881d);
                aVar.writeInt(zVar2.f882e);
                aVar.writeInt(zVar2.f883f.f106e);
                String str = zVar2.f884g;
                if (str != null) {
                    aVar.writeUTF(str);
                } else {
                    aVar.writeUTF("");
                }
                aVar.writeInt(zVar2.f885h);
                aVar.writeLong(zVar2.f886i);
                aVar.writeBoolean(zVar2.f887j);
                aVar.writeLong(zVar2.f888k);
                aVar.flush();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: b */
        public final /* synthetic */ C0321z mo106b(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            C0324b bVar = new C0324b(this, inputStream);
            int readInt = bVar.readInt();
            long readLong = bVar.readLong();
            long readLong2 = bVar.readLong();
            boolean readBoolean = bVar.readBoolean();
            int readInt2 = bVar.readInt();
            EnumC0031ax a = EnumC0031ax.m196a(bVar.readInt());
            String readUTF = bVar.readUTF();
            int readInt3 = bVar.readInt();
            long readLong3 = bVar.readLong();
            boolean readBoolean2 = bVar.readBoolean();
            long readLong4 = bVar.readLong();
            C0321z zVar = new C0321z(null, readLong, readLong2, readInt);
            zVar.f881d = readBoolean;
            zVar.f882e = readInt2;
            zVar.f883f = a;
            zVar.f884g = readUTF;
            zVar.f885h = readInt3;
            zVar.f886i = readLong3;
            zVar.f887j = readBoolean2;
            zVar.f888k = readLong4;
            return zVar;
        }
    }

    public C0321z(C0310y yVar, long j, long j2, int i) {
        this.f889l = yVar;
        this.f879b = j;
        this.f880c = j2;
        this.f878a = i;
        this.f882e = 0;
        this.f883f = EnumC0031ax.PENDING_COMPLETION;
    }

    /* renamed from: a */
    public final void mo368a() {
        this.f889l.f853l.add(this);
        if (this.f881d) {
            this.f889l.f860s = true;
        }
    }
}
