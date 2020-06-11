package com.flurry.sdk;

import com.flurry.sdk.C0321z;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.flurry.sdk.y */
public class C0310y extends AbstractC0039b2 {

    /* renamed from: g */
    final long f848g;

    /* renamed from: h */
    final int f849h;

    /* renamed from: i */
    final int f850i;

    /* renamed from: j */
    final EnumC0042bc f851j;

    /* renamed from: k */
    final Map<String, String> f852k;

    /* renamed from: l */
    public ArrayList<C0321z> f853l = new ArrayList<>();

    /* renamed from: m */
    public C0033b0 f854m;

    /* renamed from: n */
    long f855n = 30000;

    /* renamed from: o */
    int f856o;

    /* renamed from: p */
    int f857p;

    /* renamed from: q */
    String f858q;

    /* renamed from: r */
    String f859r;

    /* renamed from: s */
    boolean f860s;

    /* renamed from: com.flurry.sdk.y$a */
    public static class C0311a implements AbstractC0185l2<C0310y> {

        /* renamed from: a */
        C0175k2<C0321z> f861a = new C0175k2<>(new C0321z.C0322a());

        /* renamed from: com.flurry.sdk.y$a$a */
        class C0312a extends DataOutputStream {
            C0312a(C0311a aVar, OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public final void close() {
            }
        }

        /* renamed from: com.flurry.sdk.y$a$b */
        class C0313b extends DataInputStream {
            C0313b(C0311a aVar, InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public final void close() {
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: a */
        public final /* synthetic */ void mo105a(OutputStream outputStream, C0310y yVar) {
            C0310y yVar2 = yVar;
            if (!(outputStream == null || yVar2 == null)) {
                C0312a aVar = new C0312a(this, outputStream);
                if (yVar2.f859r != null) {
                    aVar.writeUTF(yVar2.f859r);
                } else {
                    aVar.writeUTF("");
                }
                String str = yVar2.f129e;
                if (str != null) {
                    aVar.writeUTF(str);
                } else {
                    aVar.writeUTF("");
                }
                aVar.writeLong(yVar2.f125a);
                aVar.writeInt(yVar2.f127c);
                aVar.writeLong(yVar2.f848g);
                aVar.writeInt(yVar2.f849h);
                aVar.writeInt(yVar2.f850i);
                aVar.writeInt(yVar2.f851j.f140e);
                Map map = yVar2.f852k;
                if (map != null) {
                    aVar.writeInt(yVar2.f852k.size());
                    for (String str2 : yVar2.f852k.keySet()) {
                        aVar.writeUTF(str2);
                        aVar.writeUTF((String) map.get(str2));
                    }
                } else {
                    aVar.writeInt(0);
                }
                aVar.writeLong(yVar2.f855n);
                aVar.writeInt(yVar2.f856o);
                aVar.writeInt(yVar2.f857p);
                if (yVar2.f858q != null) {
                    aVar.writeUTF(yVar2.f858q);
                } else {
                    aVar.writeUTF("");
                }
                aVar.writeBoolean(yVar2.f860s);
                aVar.flush();
                this.f861a.mo105a(outputStream, yVar2.f853l);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: b */
        public final /* synthetic */ C0310y mo106b(InputStream inputStream) {
            HashMap hashMap;
            if (inputStream == null) {
                return null;
            }
            C0313b bVar = new C0313b(this, inputStream);
            String readUTF = bVar.readUTF();
            String str = readUTF.equals("") ? null : readUTF;
            String readUTF2 = bVar.readUTF();
            long readLong = bVar.readLong();
            int readInt = bVar.readInt();
            long readLong2 = bVar.readLong();
            int readInt2 = bVar.readInt();
            int readInt3 = bVar.readInt();
            EnumC0042bc a = EnumC0042bc.m230a(bVar.readInt());
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
            C0310y yVar = new C0310y(str, readLong2, readUTF2, readLong, readInt2, readInt3, a, hashMap, readInt5, readInt6, str2);
            yVar.f855n = readLong3;
            yVar.f860s = readBoolean;
            yVar.f127c = readInt;
            yVar.f853l = (ArrayList) this.f861a.mo106b(inputStream);
            yVar.mo363h();
            return yVar;
        }
    }

    public C0310y(String str, long j, String str2, long j2, int i, int i2, EnumC0042bc bcVar, Map<String, String> map, int i3, int i4, String str3) {
        this.f128d = str2;
        this.f129e = str2;
        this.f125a = j2;
        mo120a();
        this.f859r = str;
        this.f848g = j;
        this.f130f = i;
        this.f849h = i;
        this.f850i = i2;
        this.f851j = bcVar;
        this.f852k = map;
        this.f856o = i3;
        this.f857p = i4;
        this.f858q = str3;
    }

    @Override // com.flurry.sdk.AbstractC0039b2
    /* renamed from: a */
    public final void mo120a() {
        super.mo120a();
        if (this.f127c != 1) {
            this.f855n *= 3;
        }
    }

    /* renamed from: f */
    public final synchronized void mo362f() {
        this.f854m.mo115k();
    }

    /* renamed from: h */
    public final void mo363h() {
        Iterator<C0321z> it = this.f853l.iterator();
        while (it.hasNext()) {
            it.next().f889l = this;
        }
    }
}
