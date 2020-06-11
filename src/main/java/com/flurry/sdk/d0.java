package com.flurry.sdk;

import android.content.Context;
import android.os.Build;
import com.flurry.sdk.dk;
import com.flurry.sdk.e0;
import com.flurry.sdk.y1;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;

public class d0 {
    public static final String e = "com.flurry.sdk.d0";
    private static d0 f;

    /* renamed from: a  reason: collision with root package name */
    public String f101a;
    /* access modifiers changed from: private */
    public k1<List<e0>> b;
    /* access modifiers changed from: private */
    public List<e0> c;
    private boolean d;

    class a implements n2<List<e0>> {
        a(d0 d0Var) {
        }

        @Override // com.flurry.sdk.n2
        public final l2<List<e0>> a(int i) {
            return new k2(new e0.a());
        }
    }

    class b implements y1.b<byte[], Void> {
        b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.y1, java.lang.Object] */
        @Override // com.flurry.sdk.y1.b
        public final /* synthetic */ void a(y1<byte[], Void> y1Var, Void voidR) {
            int i = ((dk) y1Var).u;
            if (i <= 0) {
                s1.e(d0.e, "Server Error: ".concat(String.valueOf(i)));
            } else if (i < 200 || i >= 300) {
                s1.a(3, d0.e, "Pulse logging report sent unsuccessfully, HTTP response:".concat(String.valueOf(i)));
            } else {
                s1.a(3, d0.e, "Pulse logging report sent successfully HTTP response:".concat(String.valueOf(i)));
                d0.this.c.clear();
                d0.this.b.a(d0.this.c);
            }
        }
    }

    private d0() {
    }

    private byte[] d() {
        DataOutputStream dataOutputStream;
        IOException e2;
        DataOutputStream dataOutputStream2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                if (this.c != null) {
                    if (!this.c.isEmpty()) {
                        dataOutputStream.writeShort(1);
                        dataOutputStream.writeShort(1);
                        dataOutputStream.writeLong(System.currentTimeMillis());
                        dataOutputStream.writeUTF(e1.a().e);
                        dataOutputStream.writeUTF(y0.b().a());
                        dataOutputStream.writeShort(f1.a());
                        dataOutputStream.writeShort(3);
                        y0.b();
                        dataOutputStream.writeUTF(y0.d());
                        dataOutputStream.writeBoolean(bs.e().d());
                        ArrayList<l> arrayList = new ArrayList();
                        for (Map.Entry entry : Collections.unmodifiableMap(bs.e().b).entrySet()) {
                            l lVar = new l();
                            lVar.f152a = ((ca) entry.getKey()).d;
                            if (((ca) entry.getKey()).e) {
                                lVar.b = new String((byte[]) entry.getValue());
                            } else {
                                lVar.b = z2.a((byte[]) entry.getValue());
                            }
                            arrayList.add(lVar);
                        }
                        dataOutputStream.writeShort(arrayList.size());
                        for (l lVar2 : arrayList) {
                            dataOutputStream.writeShort(lVar2.f152a);
                            byte[] bytes = lVar2.b.getBytes();
                            dataOutputStream.writeShort(bytes.length);
                            dataOutputStream.write(bytes);
                        }
                        dataOutputStream.writeShort(6);
                        dataOutputStream.writeShort(at.b - 1);
                        dataOutputStream.writeUTF(Build.MODEL);
                        dataOutputStream.writeShort(at.c - 1);
                        dataOutputStream.writeUTF(Build.BOARD);
                        dataOutputStream.writeShort(at.d - 1);
                        dataOutputStream.writeUTF(Build.ID);
                        dataOutputStream.writeShort(at.e - 1);
                        dataOutputStream.writeUTF(Build.DEVICE);
                        dataOutputStream.writeShort(at.f - 1);
                        dataOutputStream.writeUTF(Build.PRODUCT);
                        dataOutputStream.writeShort(at.g - 1);
                        dataOutputStream.writeUTF(Build.VERSION.RELEASE);
                        dataOutputStream.writeShort(this.c.size());
                        for (e0 e0Var : this.c) {
                            dataOutputStream.write(e0Var.f109a);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        CRC32 crc32 = new CRC32();
                        crc32.update(byteArray);
                        dataOutputStream.writeInt((int) crc32.getValue());
                        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                        z2.a(dataOutputStream);
                        return byteArray2;
                    }
                }
                byte[] byteArray3 = byteArrayOutputStream.toByteArray();
                z2.a(dataOutputStream);
                return byteArray3;
            } catch (IOException e3) {
                e2 = e3;
                try {
                    s1.a(6, e, "Error when generating report", e2);
                    throw e2;
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream2 = dataOutputStream;
                    z2.a(dataOutputStream2);
                    throw th;
                }
            }
        } catch (IOException e4) {
            dataOutputStream = null;
            e2 = e4;
            s1.a(6, e, "Error when generating report", e2);
            throw e2;
        } catch (Throwable th2) {
            th = th2;
            z2.a(dataOutputStream2);
            throw th;
        }
    }

    public static synchronized d0 b() {
        d0 d0Var;
        synchronized (d0.class) {
            if (f == null) {
                d0 d0Var2 = new d0();
                f = d0Var2;
                Context context = e1.a().f110a;
                d0Var2.b = new k1<>(context.getFileStreamPath(".yflurrypulselogging." + Long.toString(z2.f(e1.a().e), 16)), ".yflurrypulselogging.", 1, new a(d0Var2));
                d0Var2.d = ((Boolean) t2.a().a("UseHttps")).booleanValue();
                String str = e;
                s1.a(4, str, "initSettings, UseHttps = " + d0Var2.d);
                List<e0> a2 = d0Var2.b.a();
                d0Var2.c = a2;
                if (a2 == null) {
                    d0Var2.c = new ArrayList();
                }
            }
            d0Var = f;
        }
        return d0Var;
    }

    public final synchronized void a(b0 b0Var) {
        try {
            this.c.add(new e0(b0Var.d()));
            s1.a(4, e, "Saving persistent Pulse logging data.");
            this.b.a(this.c);
        } catch (IOException unused) {
            s1.a(6, e, "Error when generating pulse log report in addReport part");
        }
    }

    public final synchronized void a() {
        try {
            a(d());
        } catch (IOException unused) {
            s1.a(6, e, "Report not send due to exception in generate data");
        }
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [byte[], RequestObjectType] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private synchronized void a(byte[] r6) {
        if (!by.b().b) {
            s1.a(5, e, "Reports were not sent! No Internet connection!");
        } else if (r6 == 0 || r6.length == 0) {
            s1.a(3, e, "No report need be sent");
        } else {
            String str = this.f101a != null ? this.f101a : "https://data.flurry.com/pcr.do";
            String str2 = e;
            s1.a(4, str2, "PulseLoggingManager: start upload data " + Arrays.toString((byte[]) r6) + " to " + str);
            y1 y1Var = new y1();
            ((dk) y1Var).h = str;
            ((c3) y1Var).d = 100000;
            ((dk) y1Var).i = dk.a.kPost;
            ((dk) y1Var).l = true;
            y1Var.a("Content-Type", "application/octet-stream");
            y1Var.D = new h2();
            y1Var.B = r6;
            y1Var.A = new b();
            d1.a().a(this, y1Var);
        }
    }
}
