package com.flurry.sdk;

import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    private int f133a;
    private long b;
    public String c;
    private String d;
    private String e;
    private Throwable f;
    private Map<String, String> g = new HashMap();
    private Map<String, String> h = new HashMap();
    private List<e3> i = new ArrayList();
    public String j;
    public String k;

    public h0(int i2, long j2, String str, String str2, String str3, Throwable th, Map<String, String> map, Map<String, String> map2) {
        this.f133a = i2;
        this.b = j2;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = th;
        if (map != null) {
            this.g = map;
        }
        if (map2 != null) {
            this.h = map2;
        }
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x018a */
    public final byte[] a() {
        byte[] bArr;
        DataOutputStream dataOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream2.writeShort(this.f133a);
            dataOutputStream2.writeLong(this.b);
            dataOutputStream2.writeUTF(this.c);
            dataOutputStream2.writeUTF(this.d);
            dataOutputStream2.writeUTF(this.e);
            dataOutputStream2.writeShort(this.g.size());
            for (Map.Entry<String, String> entry : this.g.entrySet()) {
                dataOutputStream2.writeUTF(entry.getKey());
                dataOutputStream2.writeUTF(entry.getValue());
            }
            dataOutputStream2.writeShort(this.h.size());
            for (Map.Entry<String, String> entry2 : this.h.entrySet()) {
                dataOutputStream2.writeUTF(entry2.getKey());
                dataOutputStream2.writeUTF(entry2.getValue());
            }
            if (this.f != null) {
                if ("uncaught".equals(this.c)) {
                    dataOutputStream2.writeByte(3);
                } else {
                    dataOutputStream2.writeByte(2);
                }
                dataOutputStream2.writeByte(2);
                StringBuilder sb = new StringBuilder("");
                String property = System.getProperty("line.separator");
                for (StackTraceElement stackTraceElement : this.f.getStackTrace()) {
                    sb.append(stackTraceElement);
                    sb.append(property);
                }
                if (this.f.getCause() != null) {
                    sb.append(property);
                    sb.append("Caused by: ");
                    for (StackTraceElement stackTraceElement2 : this.f.getCause().getStackTrace()) {
                        sb.append(stackTraceElement2);
                        sb.append(property);
                    }
                }
                byte[] bytes = sb.toString().getBytes();
                dataOutputStream2.writeInt(bytes.length);
                dataOutputStream2.write(bytes);
            } else if (b()) {
                dataOutputStream2.writeByte(3);
                if (TextUtils.isEmpty(this.k)) {
                    dataOutputStream2.writeByte(0);
                } else {
                    dataOutputStream2.writeByte(3);
                    byte[] bytes2 = this.k.getBytes();
                    dataOutputStream2.writeInt(bytes2.length);
                    dataOutputStream2.write(bytes2);
                }
            } else {
                dataOutputStream2.writeByte(1);
                dataOutputStream2.writeByte(0);
            }
            if (TextUtils.isEmpty(this.j)) {
                dataOutputStream2.writeByte(0);
            } else {
                dataOutputStream2.writeByte(1);
                byte[] bytes3 = this.j.getBytes();
                dataOutputStream2.writeInt(bytes3.length);
                dataOutputStream2.write(bytes3);
            }
            dataOutputStream2.writeShort(f3.b());
            if (this.i != null) {
                dataOutputStream2.writeShort(this.i.size());
                for (e3 e3Var : this.i) {
                    dataOutputStream2.write(e3Var.a());
                }
            } else {
                dataOutputStream2.writeShort(0);
            }
            dataOutputStream2.flush();
            bArr = byteArrayOutputStream.toByteArray();
            z2.a(dataOutputStream2);
        } catch (IOException unused) {
            dataOutputStream = dataOutputStream2;
            try {
                bArr = new byte[0];
                z2.a(dataOutputStream);
                return bArr;
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
        return bArr;
    }

    public final boolean b() {
        return "native".equals(this.c);
    }

    public final void a(List<e3> list) {
        if (list != null) {
            this.i = list;
        }
    }
}
