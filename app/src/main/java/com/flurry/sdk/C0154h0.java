package com.flurry.sdk;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.h0 */
public final class C0154h0 {

    /* renamed from: a */
    private int f460a;

    /* renamed from: b */
    private long f461b;

    /* renamed from: c */
    public String f462c;

    /* renamed from: d */
    private String f463d;

    /* renamed from: e */
    private String f464e;

    /* renamed from: f */
    private Throwable f465f;

    /* renamed from: g */
    private Map<String, String> f466g = new HashMap();

    /* renamed from: h */
    private Map<String, String> f467h = new HashMap();

    /* renamed from: i */
    private List<C0124e3> f468i = new ArrayList();

    /* renamed from: j */
    public String f469j;

    /* renamed from: k */
    public String f470k;

    public C0154h0(int i, long j, String str, String str2, String str3, Throwable th, Map<String, String> map, Map<String, String> map2) {
        this.f460a = i;
        this.f461b = j;
        this.f462c = str;
        this.f463d = str2;
        this.f464e = str3;
        this.f465f = th;
        if (map != null) {
            this.f466g = map;
        }
        if (map2 != null) {
            this.f467h = map2;
        }
    }

    /* renamed from: a */
    public final void mo213a(List<C0124e3> list) {
        if (list != null) {
            this.f468i = list;
        }
    }

    /* renamed from: b */
    public final byte[] mo214b() {
        Throwable th;
        byte[] bArr;
        DataOutputStream dataOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream2.writeShort(this.f460a);
                dataOutputStream2.writeLong(this.f461b);
                dataOutputStream2.writeUTF(this.f462c);
                dataOutputStream2.writeUTF(this.f463d);
                dataOutputStream2.writeUTF(this.f464e);
                dataOutputStream2.writeShort(this.f466g.size());
                for (Map.Entry<String, String> entry : this.f466g.entrySet()) {
                    dataOutputStream2.writeUTF(entry.getKey());
                    dataOutputStream2.writeUTF(entry.getValue());
                }
                dataOutputStream2.writeShort(this.f467h.size());
                for (Map.Entry<String, String> entry2 : this.f467h.entrySet()) {
                    dataOutputStream2.writeUTF(entry2.getKey());
                    dataOutputStream2.writeUTF(entry2.getValue());
                }
                if (this.f465f != null) {
                    if ("uncaught".equals(this.f462c)) {
                        dataOutputStream2.writeByte(3);
                    } else {
                        dataOutputStream2.writeByte(2);
                    }
                    dataOutputStream2.writeByte(2);
                    StringBuilder sb = new StringBuilder("");
                    String property = System.getProperty("line.separator");
                    for (StackTraceElement stackTraceElement : this.f465f.getStackTrace()) {
                        sb.append(stackTraceElement);
                        sb.append(property);
                    }
                    if (this.f465f.getCause() != null) {
                        sb.append(property);
                        sb.append("Caused by: ");
                        for (StackTraceElement stackTraceElement2 : this.f465f.getCause().getStackTrace()) {
                            sb.append(stackTraceElement2);
                            sb.append(property);
                        }
                    }
                    byte[] bytes = sb.toString().getBytes();
                    dataOutputStream2.writeInt(bytes.length);
                    dataOutputStream2.write(bytes);
                } else if (mo215c()) {
                    dataOutputStream2.writeByte(3);
                    if (TextUtils.isEmpty(this.f470k)) {
                        dataOutputStream2.writeByte(0);
                    } else {
                        dataOutputStream2.writeByte(3);
                        byte[] bytes2 = this.f470k.getBytes();
                        dataOutputStream2.writeInt(bytes2.length);
                        dataOutputStream2.write(bytes2);
                    }
                } else {
                    dataOutputStream2.writeByte(1);
                    dataOutputStream2.writeByte(0);
                }
                if (TextUtils.isEmpty(this.f469j)) {
                    dataOutputStream2.writeByte(0);
                } else {
                    dataOutputStream2.writeByte(1);
                    byte[] bytes3 = this.f469j.getBytes();
                    dataOutputStream2.writeInt(bytes3.length);
                    dataOutputStream2.write(bytes3);
                }
                dataOutputStream2.writeShort(C0142f3.m438c());
                List<C0124e3> list = this.f468i;
                if (list != null) {
                    dataOutputStream2.writeShort(list.size());
                    for (C0124e3 e3Var : this.f468i) {
                        dataOutputStream2.write(e3Var.mo194a());
                    }
                } else {
                    dataOutputStream2.writeShort(0);
                }
                dataOutputStream2.flush();
                bArr = byteArrayOutputStream.toByteArray();
                C0328z2.m890e(dataOutputStream2);
            } catch (IOException unused) {
                dataOutputStream = dataOutputStream2;
                try {
                    bArr = new byte[0];
                    C0328z2.m890e(dataOutputStream);
                    return bArr;
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
        } catch (IOException unused2) {
            bArr = new byte[0];
            C0328z2.m890e(dataOutputStream);
            return bArr;
        }
        return bArr;
    }

    /* renamed from: c */
    public final boolean mo215c() {
        return "native".equals(this.f462c);
    }
}
