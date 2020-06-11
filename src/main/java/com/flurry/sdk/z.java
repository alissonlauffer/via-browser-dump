package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class z {

    /* renamed from: a  reason: collision with root package name */
    public int f225a;
    public long b;
    public long c;
    public boolean d;
    public int e;
    public ax f;
    public String g;
    public int h;
    public long i;
    public boolean j;
    public long k = 0;
    public y l;

    public z(y yVar, long j2, long j3, int i2) {
        this.l = yVar;
        this.b = j2;
        this.c = j3;
        this.f225a = i2;
        this.e = 0;
        this.f = ax.PENDING_COMPLETION;
    }

    public final void a() {
        this.l.l.add(this);
        if (this.d) {
            this.l.s = true;
        }
    }

    public static class a implements l2<z> {

        /* renamed from: com.flurry.sdk.z$a$a  reason: collision with other inner class name */
        class C0024a extends DataOutputStream {
            C0024a(a aVar, OutputStream outputStream) {
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
        public final /* synthetic */ void a(OutputStream outputStream, z zVar) {
            z zVar2 = zVar;
            if (outputStream != null && zVar2 != null) {
                C0024a aVar = new C0024a(this, outputStream);
                aVar.writeInt(zVar2.f225a);
                aVar.writeLong(zVar2.b);
                aVar.writeLong(zVar2.c);
                aVar.writeBoolean(zVar2.d);
                aVar.writeInt(zVar2.e);
                aVar.writeInt(zVar2.f.e);
                String str = zVar2.g;
                if (str != null) {
                    aVar.writeUTF(str);
                } else {
                    aVar.writeUTF("");
                }
                aVar.writeInt(zVar2.h);
                aVar.writeLong(zVar2.i);
                aVar.writeBoolean(zVar2.j);
                aVar.writeLong(zVar2.k);
                aVar.flush();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.l2
        public final /* synthetic */ z a(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            b bVar = new b(this, inputStream);
            int readInt = bVar.readInt();
            long readLong = bVar.readLong();
            long readLong2 = bVar.readLong();
            boolean readBoolean = bVar.readBoolean();
            int readInt2 = bVar.readInt();
            ax a2 = ax.a(bVar.readInt());
            String readUTF = bVar.readUTF();
            int readInt3 = bVar.readInt();
            long readLong3 = bVar.readLong();
            boolean readBoolean2 = bVar.readBoolean();
            long readLong4 = bVar.readLong();
            z zVar = new z(null, readLong, readLong2, readInt);
            zVar.d = readBoolean;
            zVar.e = readInt2;
            zVar.f = a2;
            zVar.g = readUTF;
            zVar.h = readInt3;
            zVar.i = readLong3;
            zVar.j = readBoolean2;
            zVar.k = readLong4;
            return zVar;
        }
    }
}
