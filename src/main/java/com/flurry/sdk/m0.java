package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class m0 {
    private static final String b = "m0";

    /* renamed from: a  reason: collision with root package name */
    byte[] f158a;

    /* synthetic */ m0(byte b2) {
        this();
    }

    private m0() {
    }

    public m0(byte[] bArr) {
        this.f158a = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0197 A[Catch:{ IOException -> 0x02f0, all -> 0x02ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x019b A[Catch:{ IOException -> 0x02f0, all -> 0x02ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01ab A[Catch:{ IOException -> 0x02f0, all -> 0x02ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01af A[Catch:{ IOException -> 0x02f0, all -> 0x02ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01e3 A[Catch:{ IOException -> 0x02f0, all -> 0x02ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01e7 A[Catch:{ IOException -> 0x02f0, all -> 0x02ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x020f A[Catch:{ IOException -> 0x02f0, all -> 0x02ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x023e A[Catch:{ IOException -> 0x02f0, all -> 0x02ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x024a A[Catch:{ IOException -> 0x02f0, all -> 0x02ed }, LOOP:5: B:80:0x0248->B:81:0x024a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x027a A[Catch:{ IOException -> 0x02f0, all -> 0x02ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02a7  */
    @SuppressLint({"NewApi"})
    public m0(n0 n0Var) {
        boolean z;
        Map<String, i0> map;
        List<j0> list;
        List<h0> list2;
        int i;
        int i2;
        String str;
        byte[] bytes;
        DataOutputStream dataOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream2.writeShort(14);
                dataOutputStream2.writeUTF(n0Var.f162a);
                dataOutputStream2.writeUTF("");
                dataOutputStream2.writeUTF("11070100");
                dataOutputStream2.writeLong(n0Var.b);
                dataOutputStream2.writeLong(n0Var.c);
                dataOutputStream2.writeLong(n0Var.d);
                dataOutputStream2.writeBoolean(true);
                dataOutputStream2.writeByte(n0Var.r);
                dataOutputStream2.writeBoolean(n0Var.s);
                if (!TextUtils.isEmpty(n0Var.f)) {
                    dataOutputStream2.writeBoolean(true);
                    dataOutputStream2.writeUTF(n0Var.f);
                } else {
                    dataOutputStream2.writeBoolean(false);
                }
                if (!TextUtils.isEmpty(n0Var.g)) {
                    dataOutputStream2.writeBoolean(true);
                    dataOutputStream2.writeUTF(n0Var.g);
                } else {
                    dataOutputStream2.writeBoolean(false);
                }
                Map<String, String> map2 = n0Var.h;
                if (map2 == null) {
                    dataOutputStream2.writeShort(0);
                } else {
                    dataOutputStream2.writeShort(map2.size());
                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                        dataOutputStream2.writeUTF(entry.getKey());
                        dataOutputStream2.writeUTF(entry.getValue());
                    }
                }
                Map<String, String> map3 = n0Var.e;
                if (map3 == null) {
                    dataOutputStream2.writeShort(0);
                } else {
                    dataOutputStream2.writeShort(map3.size());
                    for (Map.Entry<String, String> entry2 : map3.entrySet()) {
                        dataOutputStream2.writeUTF(entry2.getKey());
                        dataOutputStream2.writeUTF(entry2.getValue());
                        dataOutputStream2.writeByte(0);
                    }
                }
                dataOutputStream2.writeUTF(n0Var.i);
                dataOutputStream2.writeUTF(n0Var.j);
                dataOutputStream2.writeByte(n0Var.k);
                dataOutputStream2.writeByte(n0Var.l);
                dataOutputStream2.writeUTF(n0Var.m);
                if (n0Var.n != null) {
                    int e = v0.e();
                    dataOutputStream2.writeBoolean(true);
                    Location location = n0Var.n;
                    dataOutputStream2.writeDouble(z2.a(location.getLatitude(), e));
                    dataOutputStream2.writeDouble(z2.a(location.getLongitude(), e));
                    dataOutputStream2.writeFloat(location.getAccuracy());
                    dataOutputStream2.writeLong(location.getTime());
                    dataOutputStream2.writeDouble(location.getAltitude());
                    if (Build.VERSION.SDK_INT >= 26) {
                        dataOutputStream2.writeFloat(location.getVerticalAccuracyMeters());
                    } else {
                        dataOutputStream2.writeFloat(0.0f);
                    }
                    dataOutputStream2.writeFloat(location.getBearing());
                    dataOutputStream2.writeFloat(location.getSpeed());
                    if (Build.VERSION.SDK_INT >= 26) {
                        boolean z2 = location.hasBearingAccuracy() && location.hasSpeedAccuracy();
                        dataOutputStream2.writeBoolean(z2);
                        if (z2) {
                            dataOutputStream2.writeFloat(location.getBearingAccuracyDegrees());
                            dataOutputStream2.writeFloat(location.getSpeedAccuracyMetersPerSecond());
                        }
                    } else {
                        dataOutputStream2.writeBoolean(false);
                    }
                    if (e != -1) {
                        z = true;
                        dataOutputStream2.writeBoolean(z);
                        dataOutputStream2.writeInt(n0Var.o);
                        dataOutputStream2.writeByte(n0Var.x);
                        dataOutputStream2.writeByte(-1);
                        dataOutputStream2.writeByte(-1);
                        dataOutputStream2.writeByte(n0Var.p);
                        if (n0Var.q != null) {
                            dataOutputStream2.writeBoolean(false);
                        } else {
                            dataOutputStream2.writeBoolean(true);
                            dataOutputStream2.writeLong(n0Var.q.longValue());
                        }
                        map = n0Var.t;
                        if (map != null) {
                            dataOutputStream2.writeShort(0);
                        } else {
                            dataOutputStream2.writeShort(map.size());
                            for (Map.Entry<String, i0> entry3 : map.entrySet()) {
                                dataOutputStream2.writeUTF(entry3.getKey());
                                dataOutputStream2.writeInt(entry3.getValue().f138a);
                            }
                        }
                        list = n0Var.u;
                        if (list != null) {
                            dataOutputStream2.writeShort(0);
                        } else {
                            dataOutputStream2.writeShort(list.size());
                            for (j0 j0Var : list) {
                                dataOutputStream2.write(j0Var.b());
                            }
                        }
                        dataOutputStream2.writeBoolean(n0Var.w);
                        list2 = n0Var.z;
                        if (list2 == null) {
                            Iterator<h0> it = list2.iterator();
                            int i3 = 0;
                            i = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                h0 next = it.next();
                                if (!next.b() && (i3 = i3 + next.a().length) > 160000) {
                                    s1.a(5, b, "Error Log size exceeded. No more event details logged.");
                                    break;
                                }
                                i++;
                            }
                        } else {
                            i = 0;
                        }
                        dataOutputStream2.writeInt(n0Var.y);
                        dataOutputStream2.writeShort(i);
                        for (i2 = 0; i2 < i; i2++) {
                            dataOutputStream2.write(list2.get(i2).a());
                        }
                        dataOutputStream2.writeInt(0);
                        dataOutputStream2.writeShort(0);
                        dataOutputStream2.writeShort(0);
                        dataOutputStream2.writeShort(0);
                        List<String> list3 = n0Var.v;
                        dataOutputStream2.writeShort(list3.size());
                        for (String str2 : list3) {
                            byte[] bArr = new byte[0];
                            try {
                                bytes = str2.getBytes("UTF8");
                            } catch (UnsupportedEncodingException unused) {
                                s1.a(6, b, "Error encoding purchase receipt.");
                            }
                            dataOutputStream2.writeByte(2);
                            dataOutputStream2.writeInt(bytes.length);
                            dataOutputStream2.write(bytes);
                        }
                        str = n0Var.A;
                        if (!TextUtils.isEmpty(str)) {
                            dataOutputStream2.writeShort(0);
                        } else {
                            String[] split = str.split(",");
                            if (split.length % 2 == 1) {
                                dataOutputStream2.writeShort(Short.parseShort(split[0]));
                                int length = split.length - 1;
                                int i4 = 1;
                                while (i4 < length) {
                                    dataOutputStream2.writeShort(1);
                                    dataOutputStream2.writeLong(Long.parseLong(split[i4]));
                                    int i5 = i4 + 1;
                                    dataOutputStream2.writeInt(Integer.parseInt(split[i5]));
                                    i4 = i5 + 1;
                                }
                            } else {
                                s1.a(6, b, "Error variant IDs.");
                                dataOutputStream2.writeShort(0);
                            }
                        }
                        this.f158a = byteArrayOutputStream.toByteArray();
                        z2.a(dataOutputStream2);
                    }
                }
                z = false;
                dataOutputStream2.writeBoolean(z);
                dataOutputStream2.writeInt(n0Var.o);
                dataOutputStream2.writeByte(n0Var.x);
                dataOutputStream2.writeByte(-1);
                dataOutputStream2.writeByte(-1);
                dataOutputStream2.writeByte(n0Var.p);
                if (n0Var.q != null) {
                }
                map = n0Var.t;
                if (map != null) {
                }
                list = n0Var.u;
                if (list != null) {
                }
                dataOutputStream2.writeBoolean(n0Var.w);
                list2 = n0Var.z;
                if (list2 == null) {
                }
                dataOutputStream2.writeInt(n0Var.y);
                dataOutputStream2.writeShort(i);
                while (i2 < i) {
                }
                dataOutputStream2.writeInt(0);
                dataOutputStream2.writeShort(0);
                dataOutputStream2.writeShort(0);
                dataOutputStream2.writeShort(0);
                List<String> list32 = n0Var.v;
                dataOutputStream2.writeShort(list32.size());
                while (r5.hasNext()) {
                }
                str = n0Var.A;
                if (!TextUtils.isEmpty(str)) {
                }
                this.f158a = byteArrayOutputStream.toByteArray();
                z2.a(dataOutputStream2);
            } catch (IOException e2) {
                e = e2;
                dataOutputStream = dataOutputStream2;
                try {
                    s1.a(6, b, "", e);
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    z2.a(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream = dataOutputStream2;
                z2.a(dataOutputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            s1.a(6, b, "", e);
            throw e;
        }
    }

    public static class a implements l2<m0> {

        /* renamed from: com.flurry.sdk.m0$a$a  reason: collision with other inner class name */
        class C0018a extends DataOutputStream {
            C0018a(a aVar, OutputStream outputStream) {
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
        public final /* synthetic */ void a(OutputStream outputStream, m0 m0Var) {
            m0 m0Var2 = m0Var;
            if (outputStream != null && m0Var2 != null) {
                C0018a aVar = new C0018a(this, outputStream);
                int i = 0;
                byte[] bArr = m0Var2.f158a;
                if (bArr != null) {
                    i = bArr.length;
                }
                aVar.writeShort(i);
                if (i > 0) {
                    aVar.write(m0Var2.f158a);
                }
                aVar.flush();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.l2
        public final /* synthetic */ m0 a(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            b bVar = new b(this, inputStream);
            m0 m0Var = new m0((byte) 0);
            int readUnsignedShort = bVar.readUnsignedShort();
            if (readUnsignedShort > 0) {
                byte[] bArr = new byte[readUnsignedShort];
                bVar.readFully(bArr);
                m0Var.f158a = bArr;
            }
            return m0Var;
        }
    }
}
