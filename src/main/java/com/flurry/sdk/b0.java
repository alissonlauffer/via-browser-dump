package com.flurry.sdk;

import android.annotation.SuppressLint;
import com.flurry.sdk.y;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class b0 {
    private static final String k = d0.class.getName();

    /* renamed from: a  reason: collision with root package name */
    public long f62a;
    /* access modifiers changed from: private */
    public long b = System.currentTimeMillis();
    /* access modifiers changed from: private */
    public long c;
    /* access modifiers changed from: package-private */
    public bd d;
    /* access modifiers changed from: private */
    public boolean e;
    /* access modifiers changed from: package-private */
    public int f;
    public String g;
    /* access modifiers changed from: private */
    public int h;
    /* access modifiers changed from: private */
    public AtomicInteger i;
    /* access modifiers changed from: package-private */
    public Map<Long, y> j;

    public b0(String str, boolean z, long j2, long j3, bd bdVar, Map<Long, y> map) {
        this.g = str;
        this.e = z;
        this.f62a = j2;
        this.c = j3;
        this.d = bdVar;
        this.j = map;
        if (map != null) {
            for (Long l : map.keySet()) {
                map.get(l).m = this;
            }
            this.h = map.size();
        } else {
            this.h = 0;
        }
        this.i = new AtomicInteger(0);
    }

    public final synchronized void c() {
        this.i.incrementAndGet();
    }

    public final byte[] d() {
        DataOutputStream dataOutputStream;
        IOException e2;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(this.d.e);
                dataOutputStream.writeLong(this.f62a);
                dataOutputStream.writeLong(this.c);
                dataOutputStream.writeBoolean(this.e);
                if (this.e) {
                    dataOutputStream.writeShort(this.f);
                    dataOutputStream.writeUTF(this.g);
                }
                dataOutputStream.writeShort(this.j.size());
                if (this.j != null) {
                    for (Map.Entry<Long, y> entry : this.j.entrySet()) {
                        y value = entry.getValue();
                        dataOutputStream.writeLong(entry.getKey().longValue());
                        dataOutputStream.writeUTF(((b2) value).e);
                        dataOutputStream.writeShort(value.l.size());
                        Iterator<z> it = value.l.iterator();
                        while (it.hasNext()) {
                            z next = it.next();
                            dataOutputStream.writeShort(next.f225a);
                            dataOutputStream.writeLong(next.b);
                            dataOutputStream.writeLong(next.c);
                            dataOutputStream.writeBoolean(next.d);
                            dataOutputStream.writeShort(next.e);
                            dataOutputStream.writeShort(next.f.e);
                            if ((next.e < 200 || next.e >= 400) && next.g != null) {
                                byte[] bytes = next.g.getBytes();
                                dataOutputStream.writeShort(bytes.length);
                                dataOutputStream.write(bytes);
                            }
                            dataOutputStream.writeShort(next.h);
                            dataOutputStream.writeInt((int) next.k);
                        }
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                z2.a(dataOutputStream);
                return byteArray;
            } catch (IOException e3) {
                e2 = e3;
                try {
                    s1.a(6, k, "Error when generating report", e2);
                    throw e2;
                } catch (Throwable th) {
                    th = th;
                    z2.a(dataOutputStream);
                    throw th;
                }
            }
        } catch (IOException e4) {
            dataOutputStream = null;
            e2 = e4;
            s1.a(6, k, "Error when generating report", e2);
            throw e2;
        } catch (Throwable th2) {
            dataOutputStream = null;
            th = th2;
            z2.a(dataOutputStream);
            throw th;
        }
    }

    public final synchronized boolean b() {
        return this.i.intValue() >= this.h;
    }

    public final List<y> a() {
        if (this.j != null) {
            return new ArrayList(this.j.values());
        }
        return Collections.emptyList();
    }

    public static class a implements l2<b0> {

        /* renamed from: a  reason: collision with root package name */
        k2<y> f63a = new k2<>(new y.a());

        /* renamed from: com.flurry.sdk.b0$a$a  reason: collision with other inner class name */
        class C0012a extends DataOutputStream {
            C0012a(a aVar, OutputStream outputStream) {
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
        public final /* synthetic */ void a(OutputStream outputStream, b0 b0Var) {
            b0 b0Var2 = b0Var;
            if (outputStream != null && b0Var2 != null) {
                C0012a aVar = new C0012a(this, outputStream);
                aVar.writeLong(b0Var2.f62a);
                aVar.writeLong(b0Var2.b);
                aVar.writeLong(b0Var2.c);
                aVar.writeInt(b0Var2.d.e);
                aVar.writeBoolean(b0Var2.e);
                aVar.writeInt(b0Var2.f);
                if (b0Var2.g != null) {
                    aVar.writeUTF(b0Var2.g);
                } else {
                    aVar.writeUTF("");
                }
                aVar.writeInt(b0Var2.h);
                aVar.writeInt(b0Var2.i.intValue());
                aVar.flush();
                this.f63a.a(outputStream, b0Var2.a());
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.l2
        @SuppressLint({"UseSparseArrays"})
        public final /* synthetic */ b0 a(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            b bVar = new b(this, inputStream);
            long readLong = bVar.readLong();
            long readLong2 = bVar.readLong();
            long readLong3 = bVar.readLong();
            bd a2 = bd.a(bVar.readInt());
            boolean readBoolean = bVar.readBoolean();
            int readInt = bVar.readInt();
            String readUTF = bVar.readUTF();
            int readInt2 = bVar.readInt();
            int readInt3 = bVar.readInt();
            b0 b0Var = new b0(readUTF, readBoolean, readLong, readLong3, a2, null);
            long unused = b0Var.b = readLong2;
            int unused2 = b0Var.f = readInt;
            int unused3 = b0Var.h = readInt2;
            AtomicInteger unused4 = b0Var.i = new AtomicInteger(readInt3);
            List<y> b2 = this.f63a.a(inputStream);
            if (b2 != null) {
                Map unused5 = b0Var.j = new HashMap();
                for (y yVar : b2) {
                    yVar.m = b0Var;
                    b0Var.j.put(Long.valueOf(yVar.g), yVar);
                }
            }
            return b0Var;
        }
    }
}
