package com.flurry.sdk;

import com.flurry.sdk.z;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class y extends b2 {
    /* access modifiers changed from: package-private */
    public final long g;
    /* access modifiers changed from: package-private */
    public final int h;
    /* access modifiers changed from: package-private */
    public final int i;
    /* access modifiers changed from: package-private */
    public final bc j;
    /* access modifiers changed from: package-private */
    public final Map<String, String> k;
    public ArrayList<z> l = new ArrayList<>();
    public b0 m;
    /* access modifiers changed from: package-private */
    public long n = 30000;
    /* access modifiers changed from: package-private */
    public int o;
    /* access modifiers changed from: package-private */
    public int p;
    /* access modifiers changed from: package-private */
    public String q;
    /* access modifiers changed from: package-private */
    public String r;
    /* access modifiers changed from: package-private */
    public boolean s;

    public y(String str, long j2, String str2, long j3, int i2, int i3, bc bcVar, Map<String, String> map, int i4, int i5, String str3) {
        ((b2) this).d = str2;
        ((b2) this).e = str2;
        ((b2) this).f65a = j3;
        a();
        this.r = str;
        this.g = j2;
        ((b2) this).f = i2;
        this.h = i2;
        this.i = i3;
        this.j = bcVar;
        this.k = map;
        this.o = i4;
        this.p = i5;
        this.q = str3;
    }

    public final synchronized void b() {
        this.m.c();
    }

    public final void c() {
        Iterator<z> it = this.l.iterator();
        while (it.hasNext()) {
            it.next().l = this;
        }
    }

    @Override // com.flurry.sdk.b2
    public final void a() {
        super.a();
        if (((b2) this).c != 1) {
            this.n *= 3;
        }
    }

    public static class a implements l2<y> {

        /* renamed from: a  reason: collision with root package name */
        k2<z> f219a = new k2<>(new z.a());

        /* renamed from: com.flurry.sdk.y$a$a  reason: collision with other inner class name */
        class C0023a extends DataOutputStream {
            C0023a(a aVar, OutputStream outputStream) {
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
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: MutableMD:(java.io.OutputStream, java.util.List<com.flurry.sdk.z>):void
         arg types: [java.io.OutputStream, java.util.ArrayList<com.flurry.sdk.z>]
         candidates:
          com.flurry.sdk.k2.a(java.io.OutputStream, java.lang.Object):void
          MutableMD:(java.io.OutputStream, java.lang.Object):void
          MutableMD:(java.io.OutputStream, java.util.List<com.flurry.sdk.z>):void */
        @Override // com.flurry.sdk.l2
        public final /* synthetic */ void a(OutputStream outputStream, y yVar) {
            y yVar2 = yVar;
            if (outputStream != null && yVar2 != null) {
                C0023a aVar = new C0023a(this, outputStream);
                if (yVar2.r != null) {
                    aVar.writeUTF(yVar2.r);
                } else {
                    aVar.writeUTF("");
                }
                String str = ((b2) yVar2).e;
                if (str != null) {
                    aVar.writeUTF(str);
                } else {
                    aVar.writeUTF("");
                }
                aVar.writeLong(((b2) yVar2).f65a);
                aVar.writeInt(((b2) yVar2).c);
                aVar.writeLong(yVar2.g);
                aVar.writeInt(yVar2.h);
                aVar.writeInt(yVar2.i);
                aVar.writeInt(yVar2.j.e);
                Map f = yVar2.k;
                if (f != null) {
                    aVar.writeInt(yVar2.k.size());
                    for (String str2 : yVar2.k.keySet()) {
                        aVar.writeUTF(str2);
                        aVar.writeUTF((String) f.get(str2));
                    }
                } else {
                    aVar.writeInt(0);
                }
                aVar.writeLong(yVar2.n);
                aVar.writeInt(yVar2.o);
                aVar.writeInt(yVar2.p);
                if (yVar2.q != null) {
                    aVar.writeUTF(yVar2.q);
                } else {
                    aVar.writeUTF("");
                }
                aVar.writeBoolean(yVar2.s);
                aVar.flush();
                this.f219a.a(outputStream, (List<z>) yVar2.l);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.l2
        public final /* synthetic */ y a(InputStream inputStream) {
            HashMap hashMap;
            if (inputStream == null) {
                return null;
            }
            b bVar = new b(this, inputStream);
            String readUTF = bVar.readUTF();
            String str = readUTF.equals("") ? null : readUTF;
            String readUTF2 = bVar.readUTF();
            long readLong = bVar.readLong();
            int readInt = bVar.readInt();
            long readLong2 = bVar.readLong();
            int readInt2 = bVar.readInt();
            int readInt3 = bVar.readInt();
            bc a2 = bc.a(bVar.readInt());
            int readInt4 = bVar.readInt();
            if (readInt4 != 0) {
                HashMap hashMap2 = new HashMap();
                int i = 0;
                while (i < readInt4) {
                    hashMap2.put(bVar.readUTF(), bVar.readUTF());
                    i++;
                    readInt4 = readInt4;
                }
                hashMap = hashMap2;
            } else {
                hashMap = null;
            }
            long readLong3 = bVar.readLong();
            int readInt5 = bVar.readInt();
            int readInt6 = bVar.readInt();
            String readUTF3 = bVar.readUTF();
            String str2 = readUTF3.equals("") ? null : readUTF3;
            boolean readBoolean = bVar.readBoolean();
            y yVar = new y(str, readLong2, readUTF2, readLong, readInt2, readInt3, a2, hashMap, readInt5, readInt6, str2);
            long unused = yVar.n = readLong3;
            boolean unused2 = yVar.s = readBoolean;
            ((b2) yVar).c = readInt;
            yVar.l = (ArrayList) this.f219a.a(inputStream);
            yVar.c();
            return yVar;
        }
    }
}
