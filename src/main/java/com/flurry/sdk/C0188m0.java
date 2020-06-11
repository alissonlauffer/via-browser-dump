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

/* renamed from: com.flurry.sdk.m0 */
public class C0188m0 {

    /* renamed from: b */
    private static final String f542b = "m0";

    /* renamed from: a */
    byte[] f543a;

    /* renamed from: com.flurry.sdk.m0$a */
    public static class C0189a implements AbstractC0185l2<C0188m0> {

        /* renamed from: com.flurry.sdk.m0$a$a */
        class C0190a extends DataOutputStream {
            C0190a(C0189a aVar, OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
            public final void close() {
            }
        }

        /* renamed from: com.flurry.sdk.m0$a$b */
        class C0191b extends DataInputStream {
            C0191b(C0189a aVar, InputStream inputStream) {
                super(inputStream);
            }

            @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public final void close() {
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: a */
        public final /* synthetic */ void mo105a(OutputStream outputStream, C0188m0 m0Var) {
            C0188m0 m0Var2 = m0Var;
            if (outputStream != null && m0Var2 != null) {
                C0190a aVar = new C0190a(this, outputStream);
                int i = 0;
                byte[] bArr = m0Var2.f543a;
                if (bArr != null) {
                    i = bArr.length;
                }
                aVar.writeShort(i);
                if (i > 0) {
                    aVar.write(m0Var2.f543a);
                }
                aVar.flush();
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.flurry.sdk.AbstractC0185l2
        /* renamed from: b */
        public final /* synthetic */ C0188m0 mo106b(InputStream inputStream) {
            if (inputStream == null) {
                return null;
            }
            C0191b bVar = new C0191b(this, inputStream);
            C0188m0 m0Var = new C0188m0((byte) 0);
            int readUnsignedShort = bVar.readUnsignedShort();
            if (readUnsignedShort > 0) {
                byte[] bArr = new byte[readUnsignedShort];
                bVar.readFully(bArr);
                m0Var.f543a = bArr;
            }
            return m0Var;
        }
    }

    /* synthetic */ C0188m0(byte b) {
        this();
    }

    private C0188m0() {
    }

    public C0188m0(byte[] bArr) {
        this.f543a = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0195 A[Catch:{ IOException -> 0x02ee, all -> 0x02eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0199 A[Catch:{ IOException -> 0x02ee, all -> 0x02eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01a9 A[Catch:{ IOException -> 0x02ee, all -> 0x02eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01ad A[Catch:{ IOException -> 0x02ee, all -> 0x02eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01e1 A[Catch:{ IOException -> 0x02ee, all -> 0x02eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01e5 A[Catch:{ IOException -> 0x02ee, all -> 0x02eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x020d A[Catch:{ IOException -> 0x02ee, all -> 0x02eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x023c A[Catch:{ IOException -> 0x02ee, all -> 0x02eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0248 A[Catch:{ IOException -> 0x02ee, all -> 0x02eb }, LOOP:5: B:80:0x0246->B:81:0x0248, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0278 A[Catch:{ IOException -> 0x02ee, all -> 0x02eb }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02a5  */
    @SuppressLint({"NewApi"})
    public C0188m0(C0198n0 n0Var) {
        Throwable th;
        IOException e;
        boolean z;
        Map<String, C0161i0> map;
        List<C0167j0> list;
        List<C0154h0> list2;
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
                dataOutputStream2.writeUTF(n0Var.f553a);
                dataOutputStream2.writeUTF("");
                dataOutputStream2.writeUTF("11070100");
                dataOutputStream2.writeLong(n0Var.f554b);
                dataOutputStream2.writeLong(n0Var.f555c);
                dataOutputStream2.writeLong(n0Var.f556d);
                dataOutputStream2.writeBoolean(true);
                dataOutputStream2.writeByte(n0Var.f570r);
                dataOutputStream2.writeBoolean(n0Var.f571s);
                if (!TextUtils.isEmpty(n0Var.f558f)) {
                    dataOutputStream2.writeBoolean(true);
                    dataOutputStream2.writeUTF(n0Var.f558f);
                } else {
                    dataOutputStream2.writeBoolean(false);
                }
                if (!TextUtils.isEmpty(n0Var.f559g)) {
                    dataOutputStream2.writeBoolean(true);
                    dataOutputStream2.writeUTF(n0Var.f559g);
                } else {
                    dataOutputStream2.writeBoolean(false);
                }
                Map<String, String> map2 = n0Var.f560h;
                if (map2 == null) {
                    dataOutputStream2.writeShort(0);
                } else {
                    dataOutputStream2.writeShort(map2.size());
                    for (Map.Entry<String, String> entry : map2.entrySet()) {
                        dataOutputStream2.writeUTF(entry.getKey());
                        dataOutputStream2.writeUTF(entry.getValue());
                    }
                }
                Map<String, String> map3 = n0Var.f557e;
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
                dataOutputStream2.writeUTF(n0Var.f561i);
                dataOutputStream2.writeUTF(n0Var.f562j);
                dataOutputStream2.writeByte(n0Var.f563k);
                dataOutputStream2.writeByte(n0Var.f564l);
                dataOutputStream2.writeUTF(n0Var.f565m);
                if (n0Var.f566n != null) {
                    int i3 = C0279v0.m736i();
                    dataOutputStream2.writeBoolean(true);
                    Location location = n0Var.f566n;
                    dataOutputStream2.writeDouble(C0328z2.m886a(location.getLatitude(), i3));
                    dataOutputStream2.writeDouble(C0328z2.m886a(location.getLongitude(), i3));
                    dataOutputStream2.writeFloat(location.getAccuracy());
                    dataOutputStream2.writeLong(location.getTime());
                    dataOutputStream2.writeDouble(location.getAltitude());
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 >= 26) {
                        dataOutputStream2.writeFloat(location.getVerticalAccuracyMeters());
                    } else {
                        dataOutputStream2.writeFloat(0.0f);
                    }
                    dataOutputStream2.writeFloat(location.getBearing());
                    dataOutputStream2.writeFloat(location.getSpeed());
                    if (i4 >= 26) {
                        boolean z2 = location.hasBearingAccuracy() && location.hasSpeedAccuracy();
                        dataOutputStream2.writeBoolean(z2);
                        if (z2) {
                            dataOutputStream2.writeFloat(location.getBearingAccuracyDegrees());
                            dataOutputStream2.writeFloat(location.getSpeedAccuracyMetersPerSecond());
                        }
                    } else {
                        dataOutputStream2.writeBoolean(false);
                    }
                    if (i3 != -1) {
                        z = true;
                        dataOutputStream2.writeBoolean(z);
                        dataOutputStream2.writeInt(n0Var.f567o);
                        dataOutputStream2.writeByte(n0Var.f576x);
                        dataOutputStream2.writeByte(-1);
                        dataOutputStream2.writeByte(-1);
                        dataOutputStream2.writeByte(n0Var.f568p);
                        if (n0Var.f569q != null) {
                            dataOutputStream2.writeBoolean(false);
                        } else {
                            dataOutputStream2.writeBoolean(true);
                            dataOutputStream2.writeLong(n0Var.f569q.longValue());
                        }
                        map = n0Var.f572t;
                        if (map != null) {
                            dataOutputStream2.writeShort(0);
                        } else {
                            dataOutputStream2.writeShort(map.size());
                            for (Map.Entry<String, C0161i0> entry3 : map.entrySet()) {
                                dataOutputStream2.writeUTF(entry3.getKey());
                                dataOutputStream2.writeInt(entry3.getValue().f492a);
                            }
                        }
                        list = n0Var.f573u;
                        if (list != null) {
                            dataOutputStream2.writeShort(0);
                        } else {
                            dataOutputStream2.writeShort(list.size());
                            for (C0167j0 j0Var : list) {
                                dataOutputStream2.write(j0Var.mo243e());
                            }
                        }
                        dataOutputStream2.writeBoolean(n0Var.f575w);
                        list2 = n0Var.f578z;
                        if (list2 == null) {
                            Iterator<C0154h0> it = list2.iterator();
                            int i5 = 0;
                            i = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                C0154h0 next = it.next();
                                if (!next.mo215c() && (i5 = i5 + next.mo214b().length) > 160000) {
                                    C0260s1.m686c(5, f542b, "Error Log size exceeded. No more event details logged.");
                                    break;
                                }
                                i++;
                            }
                        } else {
                            i = 0;
                        }
                        dataOutputStream2.writeInt(n0Var.f577y);
                        dataOutputStream2.writeShort(i);
                        for (i2 = 0; i2 < i; i2++) {
                            dataOutputStream2.write(list2.get(i2).mo214b());
                        }
                        dataOutputStream2.writeInt(0);
                        dataOutputStream2.writeShort(0);
                        dataOutputStream2.writeShort(0);
                        dataOutputStream2.writeShort(0);
                        List<String> list3 = n0Var.f574v;
                        dataOutputStream2.writeShort(list3.size());
                        for (String str2 : list3) {
                            byte[] bArr = new byte[0];
                            try {
                                bytes = str2.getBytes("UTF8");
                            } catch (UnsupportedEncodingException unused) {
                                C0260s1.m686c(6, f542b, "Error encoding purchase receipt.");
                            }
                            dataOutputStream2.writeByte(2);
                            dataOutputStream2.writeInt(bytes.length);
                            dataOutputStream2.write(bytes);
                        }
                        str = n0Var.f552A;
                        if (!TextUtils.isEmpty(str)) {
                            dataOutputStream2.writeShort(0);
                        } else {
                            String[] split = str.split(",");
                            if (split.length % 2 == 1) {
                                dataOutputStream2.writeShort(Short.parseShort(split[0]));
                                int length = split.length - 1;
                                int i6 = 1;
                                while (i6 < length) {
                                    dataOutputStream2.writeShort(1);
                                    dataOutputStream2.writeLong(Long.parseLong(split[i6]));
                                    int i7 = i6 + 1;
                                    dataOutputStream2.writeInt(Integer.parseInt(split[i7]));
                                    i6 = i7 + 1;
                                }
                            } else {
                                C0260s1.m686c(6, f542b, "Error variant IDs.");
                                dataOutputStream2.writeShort(0);
                            }
                        }
                        this.f543a = byteArrayOutputStream.toByteArray();
                        C0328z2.m890e(dataOutputStream2);
                    }
                }
                z = false;
                dataOutputStream2.writeBoolean(z);
                dataOutputStream2.writeInt(n0Var.f567o);
                dataOutputStream2.writeByte(n0Var.f576x);
                dataOutputStream2.writeByte(-1);
                dataOutputStream2.writeByte(-1);
                dataOutputStream2.writeByte(n0Var.f568p);
                if (n0Var.f569q != null) {
                }
                map = n0Var.f572t;
                if (map != null) {
                }
                list = n0Var.f573u;
                if (list != null) {
                }
                dataOutputStream2.writeBoolean(n0Var.f575w);
                list2 = n0Var.f578z;
                if (list2 == null) {
                }
                dataOutputStream2.writeInt(n0Var.f577y);
                dataOutputStream2.writeShort(i);
                while (i2 < i) {
                }
                dataOutputStream2.writeInt(0);
                dataOutputStream2.writeShort(0);
                dataOutputStream2.writeShort(0);
                dataOutputStream2.writeShort(0);
                List<String> list32 = n0Var.f574v;
                dataOutputStream2.writeShort(list32.size());
                while (r5.hasNext()) {
                }
                str = n0Var.f552A;
                if (!TextUtils.isEmpty(str)) {
                }
                this.f543a = byteArrayOutputStream.toByteArray();
                C0328z2.m890e(dataOutputStream2);
            } catch (IOException e2) {
                e = e2;
                dataOutputStream = dataOutputStream2;
                try {
                    C0260s1.m687d(6, f542b, "", e);
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    C0328z2.m890e(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = dataOutputStream2;
                C0328z2.m890e(dataOutputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            C0260s1.m687d(6, f542b, "", e);
            throw e;
        }
    }
}
