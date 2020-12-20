package com.flurry.sdk;

import android.content.Context;
import android.os.Build;
import com.flurry.sdk.C0108dk;
import com.flurry.sdk.C0114e0;
import com.flurry.sdk.C0315y1;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;

/* renamed from: com.flurry.sdk.d0 */
public class C0095d0 {

    /* renamed from: e */
    public static final String f294e = "com.flurry.sdk.d0";

    /* renamed from: f */
    private static C0095d0 f295f;

    /* renamed from: a */
    public String f296a;

    /* renamed from: b */
    private C0174k1<List<C0114e0>> f297b;

    /* renamed from: c */
    private List<C0114e0> f298c;

    /* renamed from: d */
    private boolean f299d;

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.d0$a */
    public class C0096a implements AbstractC0201n2<List<C0114e0>> {
        C0096a(C0095d0 d0Var) {
        }

        @Override // com.flurry.sdk.AbstractC0201n2
        /* renamed from: a */
        public final AbstractC0185l2<List<C0114e0>> mo100a(int i) {
            return new C0175k2(new C0114e0.C0115a());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.flurry.sdk.d0$b */
    public class C0097b implements C0315y1.AbstractC0317b<byte[], Void> {
        C0097b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.flurry.sdk.y1, java.lang.Object] */
        @Override // com.flurry.sdk.C0315y1.AbstractC0317b
        /* renamed from: a */
        public final /* synthetic */ void mo165a(C0315y1<byte[], Void> y1Var, Void r4) {
            int i = y1Var.f337u;
            if (i <= 0) {
                C0260s1.m701r(C0095d0.f294e, "Server Error: ".concat(String.valueOf(i)));
            } else if (i < 200 || i >= 300) {
                C0260s1.m686c(3, C0095d0.f294e, "Pulse logging report sent unsuccessfully, HTTP response:".concat(String.valueOf(i)));
            } else {
                C0260s1.m686c(3, C0095d0.f294e, "Pulse logging report sent successfully HTTP response:".concat(String.valueOf(i)));
                C0095d0.this.f298c.clear();
                C0095d0.this.f297b.mo253b(C0095d0.this.f298c);
            }
        }
    }

    private C0095d0() {
    }

    /* renamed from: a */
    public static synchronized C0095d0 m338a() {
        C0095d0 d0Var;
        synchronized (C0095d0.class) {
            if (f295f == null) {
                C0095d0 d0Var2 = new C0095d0();
                f295f = d0Var2;
                Context context = C0118e1.m386a().f361a;
                d0Var2.f297b = new C0174k1<>(context.getFileStreamPath(".yflurrypulselogging." + Long.toString(C0328z2.m899n(C0118e1.m386a().f365e), 16)), ".yflurrypulselogging.", 1, new C0096a(d0Var2));
                d0Var2.f299d = ((Boolean) C0266t2.m703e().mo341a("UseHttps")).booleanValue();
                String str = f294e;
                C0260s1.m686c(4, str, "initSettings, UseHttps = " + d0Var2.f299d);
                List<C0114e0> a = d0Var2.f297b.mo252a();
                d0Var2.f298c = a;
                if (a == null) {
                    d0Var2.f298c = new ArrayList();
                }
            }
            d0Var = f295f;
        }
        return d0Var;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: byte[] */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    private synchronized void m340d(byte[] bArr) {
        if (!C0054by.m254a().f176b) {
            C0260s1.m686c(5, f294e, "Reports were not sent! No Internet connection!");
        } else if (bArr == 0 || bArr.length == 0) {
            C0260s1.m686c(3, f294e, "No report need be sent");
        } else {
            String str = this.f296a;
            if (str == null) {
                str = "https://data.flurry.com/pcr.do";
            }
            String str2 = f294e;
            C0260s1.m686c(4, str2, "PulseLoggingManager: start upload data " + Arrays.toString(bArr) + " to " + str);
            C0315y1 y1Var = new C0315y1();
            y1Var.f324h = str;
            y1Var.f226d = 100000;
            y1Var.f325i = C0108dk.EnumC0109a.kPost;
            y1Var.f328l = true;
            y1Var.mo174e("Content-Type", "application/octet-stream");
            y1Var.f869D = new C0158h2();
            y1Var.f867B = bArr;
            y1Var.f866A = new C0097b();
            C0098d1.m348j().mo309f(this, y1Var);
        }
    }

    /* renamed from: h */
    private byte[] m343h() {
        Throwable th;
        DataOutputStream dataOutputStream;
        IOException e;
        DataOutputStream dataOutputStream2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                List<C0114e0> list = this.f298c;
                if (list != null) {
                    if (!list.isEmpty()) {
                        dataOutputStream.writeShort(1);
                        dataOutputStream.writeShort(1);
                        dataOutputStream.writeLong(System.currentTimeMillis());
                        dataOutputStream.writeUTF(C0118e1.m386a().f365e);
                        dataOutputStream.writeUTF(C0314y0.m857a().mo366f());
                        dataOutputStream.writeShort(C0135f1.m416a());
                        dataOutputStream.writeShort(3);
                        C0314y0.m857a();
                        dataOutputStream.writeUTF(C0314y0.m860e());
                        dataOutputStream.writeBoolean(C0044bs.m232a().mo127j());
                        ArrayList<C0179l> arrayList = new ArrayList();
                        for (Map.Entry entry : Collections.unmodifiableMap(C0044bs.m232a().f150b).entrySet()) {
                            C0179l lVar = new C0179l();
                            lVar.f529a = ((EnumC0076ca) entry.getKey()).f231d;
                            if (((EnumC0076ca) entry.getKey()).f232e) {
                                lVar.f530b = new String((byte[]) entry.getValue());
                            } else {
                                lVar.f530b = C0328z2.m895j((byte[]) entry.getValue());
                            }
                            arrayList.add(lVar);
                        }
                        dataOutputStream.writeShort(arrayList.size());
                        for (C0179l lVar2 : arrayList) {
                            dataOutputStream.writeShort(lVar2.f529a);
                            byte[] bytes = lVar2.f530b.getBytes();
                            dataOutputStream.writeShort(bytes.length);
                            dataOutputStream.write(bytes);
                        }
                        dataOutputStream.writeShort(6);
                        dataOutputStream.writeShort(C0030at.f95b - 1);
                        dataOutputStream.writeUTF(Build.MODEL);
                        dataOutputStream.writeShort(C0030at.f96c - 1);
                        dataOutputStream.writeUTF(Build.BOARD);
                        dataOutputStream.writeShort(C0030at.f97d - 1);
                        dataOutputStream.writeUTF(Build.ID);
                        dataOutputStream.writeShort(C0030at.f98e - 1);
                        dataOutputStream.writeUTF(Build.DEVICE);
                        dataOutputStream.writeShort(C0030at.f99f - 1);
                        dataOutputStream.writeUTF(Build.PRODUCT);
                        dataOutputStream.writeShort(C0030at.f100g - 1);
                        dataOutputStream.writeUTF(Build.VERSION.RELEASE);
                        dataOutputStream.writeShort(this.f298c.size());
                        for (C0114e0 e0Var : this.f298c) {
                            dataOutputStream.write(e0Var.f357a);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        CRC32 crc32 = new CRC32();
                        crc32.update(byteArray);
                        dataOutputStream.writeInt((int) crc32.getValue());
                        byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                        C0328z2.m890e(dataOutputStream);
                        return byteArray2;
                    }
                }
                byte[] byteArray3 = byteArrayOutputStream.toByteArray();
                C0328z2.m890e(dataOutputStream);
                return byteArray3;
            } catch (IOException e2) {
                e = e2;
                try {
                    C0260s1.m687d(6, f294e, "Error when generating report", e);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream2 = dataOutputStream;
                    C0328z2.m890e(dataOutputStream2);
                    throw th;
                }
            }
        } catch (IOException e3) {
            dataOutputStream = null;
            e = e3;
            C0260s1.m687d(6, f294e, "Error when generating report", e);
            throw e;
        } catch (Throwable th3) {
            th = th3;
            C0328z2.m890e(dataOutputStream2);
            throw th;
        }
    }

    /* renamed from: c */
    public final synchronized void mo163c(C0033b0 b0Var) {
        try {
            this.f298c.add(new C0114e0(b0Var.mo116m()));
            C0260s1.m686c(4, f294e, "Saving persistent Pulse logging data.");
            this.f297b.mo253b(this.f298c);
        } catch (IOException unused) {
            C0260s1.m686c(6, f294e, "Error when generating pulse log report in addReport part");
        }
    }

    /* renamed from: f */
    public final synchronized void mo164f() {
        try {
            m340d(m343h());
        } catch (IOException unused) {
            C0260s1.m686c(6, f294e, "Report not send due to exception in generate data");
        }
    }
}
