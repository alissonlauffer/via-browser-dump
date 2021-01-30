package com.flurry.sdk;

import android.annotation.SuppressLint;
import com.flurry.sdk.C0310y;
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

/* renamed from: com.flurry.sdk.b0 */
public final class C0033b0 {

    /* renamed from: k */
    private static final String f108k = C0095d0.class.getName();

    /* renamed from: a */
    public long f109a;

    /* renamed from: b */
    private long f110b = System.currentTimeMillis();

    /* renamed from: c */
    private long f111c;

    /* renamed from: d */
    EnumC0043bd f112d;

    /* renamed from: e */
    private boolean f113e;

    /* renamed from: f */
    int f114f;

    /* renamed from: g */
    public String f115g;

    /* renamed from: h */
    private int f116h;

    /* renamed from: i */
    private AtomicInteger f117i;

    /* renamed from: j */
    Map<Long, C0310y> f118j;

    /* renamed from: com.flurry.sdk.b0$a */
    public static class C0034a implements AbstractC0185l2<C0033b0> {

        /* renamed from: a */
        C0175k2<C0310y> f119a = new C0175k2<>(new C0310y.C0311a());

        /* renamed from: com.flurry.sdk.b0$a$a */
        class C0035a extends DataOutputStream {
            C0035a(C0034a aVar, OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public final void close() {
            }
        }

        /* renamed from: com.flurry.sdk.b0$a$b */
        class C0036b extends DataInputStream {
            C0036b(C0034a aVar, InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public final void close() {
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: a */
        public final /* synthetic */ void mo105a(OutputStream outputStream, C0033b0 b0Var) {
            C0033b0 b0Var2 = b0Var;
            if (outputStream != null && b0Var2 != null) {
                C0035a aVar = new C0035a(this, outputStream);
                aVar.writeLong(b0Var2.f109a);
                aVar.writeLong(b0Var2.f110b);
                aVar.writeLong(b0Var2.f111c);
                aVar.writeInt(b0Var2.f112d.f146e);
                aVar.writeBoolean(b0Var2.f113e);
                aVar.writeInt(b0Var2.f114f);
                if (b0Var2.f115g != null) {
                    aVar.writeUTF(b0Var2.f115g);
                } else {
                    aVar.writeUTF("");
                }
                aVar.writeInt(b0Var2.f116h);
                aVar.writeInt(b0Var2.f117i.intValue());
                aVar.flush();
                this.f119a.mo105a(outputStream, b0Var2.mo113d());
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.AbstractC0185l2
        @SuppressLint({"UseSparseArrays"})
        /* renamed from: b */
        public final /* synthetic */ C0033b0 mo106b(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            C0036b bVar = new C0036b(this, inputStream);
            long readLong = bVar.readLong();
            long readLong2 = bVar.readLong();
            long readLong3 = bVar.readLong();
            EnumC0043bd a = EnumC0043bd.m231a(bVar.readInt());
            boolean readBoolean = bVar.readBoolean();
            int readInt = bVar.readInt();
            String readUTF = bVar.readUTF();
            int readInt2 = bVar.readInt();
            int readInt3 = bVar.readInt();
            C0033b0 b0Var = new C0033b0(readUTF, readBoolean, readLong, readLong3, a, null);
            b0Var.f110b = readLong2;
            b0Var.f114f = readInt;
            b0Var.f116h = readInt2;
            b0Var.f117i = new AtomicInteger(readInt3);
            List<C0310y> d = this.f119a.mo106b(inputStream);
            if (d != null) {
                b0Var.f118j = new HashMap();
                for (C0310y yVar : d) {
                    yVar.f854m = b0Var;
                    b0Var.f118j.put(Long.valueOf(yVar.f848g), yVar);
                }
            }
            return b0Var;
        }
    }

    public C0033b0(String str, boolean z, long j, long j2, EnumC0043bd bdVar, Map<Long, C0310y> map) {
        this.f115g = str;
        this.f113e = z;
        this.f109a = j;
        this.f111c = j2;
        this.f112d = bdVar;
        this.f118j = map;
        if (map != null) {
            for (Long l : map.keySet()) {
                map.get(l).f854m = this;
            }
            this.f116h = map.size();
        } else {
            this.f116h = 0;
        }
        this.f117i = new AtomicInteger(0);
    }

    /* renamed from: d */
    public final List<C0310y> mo113d() {
        if (this.f118j != null) {
            return new ArrayList(this.f118j.values());
        }
        return Collections.emptyList();
    }

    /* renamed from: i */
    public final synchronized boolean mo114i() {
        return this.f117i.intValue() >= this.f116h;
    }

    /* renamed from: k */
    public final synchronized void mo115k() {
        this.f117i.incrementAndGet();
    }

    /* renamed from: m */
    public final byte[] mo116m() {
        DataOutputStream dataOutputStream;
        Throwable th;
        IOException e;
        String str;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeShort(this.f112d.f146e);
                dataOutputStream.writeLong(this.f109a);
                dataOutputStream.writeLong(this.f111c);
                dataOutputStream.writeBoolean(this.f113e);
                if (this.f113e) {
                    dataOutputStream.writeShort(this.f114f);
                    dataOutputStream.writeUTF(this.f115g);
                }
                dataOutputStream.writeShort(this.f118j.size());
                Map<Long, C0310y> map = this.f118j;
                if (map != null) {
                    for (Map.Entry<Long, C0310y> entry : map.entrySet()) {
                        C0310y value = entry.getValue();
                        dataOutputStream.writeLong(entry.getKey().longValue());
                        dataOutputStream.writeUTF(value.f129e);
                        dataOutputStream.writeShort(value.f853l.size());
                        Iterator<C0321z> it = value.f853l.iterator();
                        while (it.hasNext()) {
                            C0321z next = it.next();
                            dataOutputStream.writeShort(next.f878a);
                            dataOutputStream.writeLong(next.f879b);
                            dataOutputStream.writeLong(next.f880c);
                            dataOutputStream.writeBoolean(next.f881d);
                            dataOutputStream.writeShort(next.f882e);
                            dataOutputStream.writeShort(next.f883f.f106e);
                            int i = next.f882e;
                            if ((i < 200 || i >= 400) && (str = next.f884g) != null) {
                                byte[] bytes = str.getBytes();
                                dataOutputStream.writeShort(bytes.length);
                                dataOutputStream.write(bytes);
                            }
                            dataOutputStream.writeShort(next.f885h);
                            dataOutputStream.writeInt((int) next.f888k);
                        }
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                C0328z2.m890e(dataOutputStream);
                return byteArray;
            } catch (IOException e2) {
                e = e2;
                try {
                    C0260s1.m687d(6, f108k, "Error when generating report", e);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    C0328z2.m890e(dataOutputStream);
                    throw th;
                }
            }
        } catch (IOException e3) {
            dataOutputStream = null;
            e = e3;
            C0260s1.m687d(6, f108k, "Error when generating report", e);
            throw e;
        } catch (Throwable th3) {
            dataOutputStream = null;
            th = th3;
            C0328z2.m890e(dataOutputStream);
            throw th;
        }
    }
}
