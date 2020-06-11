package com.flurry.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.flurry.android.a;
import com.flurry.android.b;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.security.DigestOutputStream;
import java.util.List;
import java.util.Map;

public class k0 {
    private static final String b = "k0";

    /* renamed from: a  reason: collision with root package name */
    public byte[] f148a = null;

    /* JADX INFO: finally extract failed */
    public k0(String str, String str2, boolean z, boolean z2, long j, long j2, List<m0> list, Map<ca, byte[]> map, Map<String, List<String>> map2, Map<String, List<String>> map3, Map<String, Map<String, String>> map4, long j3, t2 t2Var, boolean z3) {
        byte[] bArr;
        DataOutputStream dataOutputStream;
        String str3;
        Map<String, String> map5;
        int i;
        String str4;
        String str5;
        int identifier;
        try {
            j1 j1Var = new j1();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DigestOutputStream digestOutputStream = new DigestOutputStream(byteArrayOutputStream, j1Var);
            dataOutputStream = new DataOutputStream(digestOutputStream);
            try {
                dataOutputStream.writeShort(35);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeLong(0);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeShort(3);
                dataOutputStream.writeShort(f1.a());
                dataOutputStream.writeLong(j3);
                dataOutputStream.writeUTF(str);
                dataOutputStream.writeUTF(str2);
                String str6 = (String) t2Var.a("VersionName");
                if (TextUtils.isEmpty(str6)) {
                    dataOutputStream.writeUTF("");
                } else {
                    dataOutputStream.writeUTF(str6);
                }
                Context context = e1.a().f110a;
                dataOutputStream.writeUTF(String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
                dataOutputStream.writeByte(3);
                if (r1.b().f187a) {
                    dataOutputStream.writeByte(3);
                    s1.c(b, "Agent report type: instant app");
                } else {
                    dataOutputStream.writeByte(1);
                    s1.c(b, "Agent report type: main device");
                }
                dataOutputStream.writeShort(map.size());
                for (Map.Entry<ca, byte[]> entry : map.entrySet()) {
                    dataOutputStream.writeShort(entry.getKey().d);
                    byte[] value = entry.getValue();
                    dataOutputStream.writeShort(value.length);
                    dataOutputStream.write(value);
                }
                dataOutputStream.writeByte(0);
                dataOutputStream.writeBoolean(z);
                dataOutputStream.writeBoolean(z2);
                dataOutputStream.writeLong(j);
                dataOutputStream.writeLong(j2);
                if (z3) {
                    dataOutputStream.writeByte(2);
                } else {
                    dataOutputStream.writeByte(0);
                }
                dataOutputStream.writeBoolean(((Boolean) t2Var.a("IncludeBackgroundSessionsInMetrics")).booleanValue());
                String property = System.getProperty("os.arch");
                property = TextUtils.isEmpty(property) ? "" : property;
                dataOutputStream.writeShort(8);
                dataOutputStream.writeUTF("device.model");
                dataOutputStream.writeUTF(Build.MODEL);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("build.brand");
                dataOutputStream.writeUTF(Build.BRAND);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("build.id");
                dataOutputStream.writeUTF(Build.ID);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("version.release");
                dataOutputStream.writeUTF(Build.VERSION.RELEASE);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("build.device");
                dataOutputStream.writeUTF(Build.DEVICE);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("build.product");
                dataOutputStream.writeUTF(Build.PRODUCT);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("proguard.build.uuid");
                r0.a();
                Context context2 = e1.a().f110a;
                if (context2 == null || (identifier = context2.getResources().getIdentifier("com.flurry.crash.map_id", "string", context2.getPackageName())) == 0) {
                    str3 = "";
                } else {
                    str3 = context2.getResources().getString(identifier);
                }
                dataOutputStream.writeUTF(str3);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeUTF("device.arch");
                dataOutputStream.writeUTF(property);
                dataOutputStream.writeByte(0);
                dataOutputStream.writeShort(map2 != null ? map2.keySet().size() : 0);
                if (map2 != null) {
                    s1.a(3, b, "sending referrer values because it exists");
                    for (Map.Entry<String, List<String>> entry2 : map2.entrySet()) {
                        String str7 = b;
                        s1.a(3, str7, "Referrer Entry:  " + entry2.getKey() + "=" + entry2.getValue());
                        dataOutputStream.writeUTF(entry2.getKey());
                        String str8 = b;
                        s1.a(3, str8, "referrer key is :" + entry2.getKey());
                        dataOutputStream.writeShort(entry2.getValue().size());
                        for (String str9 : entry2.getValue()) {
                            dataOutputStream.writeUTF(str9);
                            s1.a(3, b, "referrer value is :".concat(String.valueOf(str9)));
                        }
                    }
                }
                String str10 = (String) t2Var.a("notificationToken");
                if (!TextUtils.isEmpty(str10)) {
                    dataOutputStream.writeBoolean(true);
                    dataOutputStream.writeUTF(str10);
                } else {
                    dataOutputStream.writeBoolean(false);
                }
                dataOutputStream.writeBoolean(((Boolean) t2Var.a("notificationsEnabled")).booleanValue());
                int size = map3 != null ? map3.keySet().size() : 0;
                s1.a(3, b, "optionsMapSize is:  ".concat(String.valueOf(size)));
                dataOutputStream.writeShort(size);
                if (map3 != null) {
                    s1.a(3, b, "sending launch options");
                    for (Map.Entry<String, List<String>> entry3 : map3.entrySet()) {
                        String str11 = b;
                        s1.a(3, str11, "Launch Options Key:  " + entry3.getKey());
                        dataOutputStream.writeUTF(entry3.getKey());
                        dataOutputStream.writeShort(entry3.getValue().size());
                        for (String str12 : entry3.getValue()) {
                            dataOutputStream.writeUTF(str12);
                            s1.a(3, b, "Launch Options value is :".concat(String.valueOf(str12)));
                        }
                    }
                }
                int size2 = map4 != null ? map4.keySet().size() : 0;
                s1.a(3, b, "numOriginAttributions is:  ".concat(String.valueOf(size)));
                dataOutputStream.writeShort(size2);
                if (map4 != null) {
                    for (Map.Entry<String, Map<String, String>> entry4 : map4.entrySet()) {
                        String str13 = b;
                        s1.a(3, str13, "Origin Atttribute Key:  " + entry4.getKey());
                        dataOutputStream.writeUTF(entry4.getKey());
                        dataOutputStream.writeShort(entry4.getValue().size());
                        String str14 = b;
                        s1.a(3, str14, "Origin Attribute Map Size for " + entry4.getKey() + ":  " + entry4.getValue().size());
                        for (Map.Entry<String, String> entry5 : entry4.getValue().entrySet()) {
                            String str15 = b;
                            s1.a(3, str15, "Origin Atttribute for " + entry4.getKey() + ":  " + entry5.getKey() + ":" + entry5.getValue());
                            if (entry5.getKey() != null) {
                                str4 = entry5.getKey();
                            } else {
                                str4 = "";
                            }
                            dataOutputStream.writeUTF(str4);
                            if (entry5.getValue() != null) {
                                str5 = entry5.getValue();
                            } else {
                                str5 = "";
                            }
                            dataOutputStream.writeUTF(str5);
                        }
                    }
                }
                dataOutputStream.writeUTF(w2.a(e1.a().f110a));
                a d = b.d();
                if (d == null) {
                    map5 = null;
                } else {
                    map5 = d.a();
                }
                if (d == null) {
                    i = 0;
                } else {
                    i = d.b() ? 1 : 2;
                }
                dataOutputStream.writeByte(i);
                if (map5 == null) {
                    dataOutputStream.writeShort(0);
                } else {
                    dataOutputStream.writeShort(map5.size());
                }
                if (map5 != null) {
                    for (Map.Entry<String, String> entry6 : map5.entrySet()) {
                        String str16 = b;
                        s1.a(3, str16, "Consent string for " + entry6.getKey() + ": " + entry6.getValue());
                        dataOutputStream.writeUTF(entry6.getKey());
                        dataOutputStream.writeUTF(entry6.getValue());
                    }
                }
                dataOutputStream.writeShort(list.size());
                for (m0 m0Var : list) {
                    dataOutputStream.write(m0Var.f158a);
                }
                dataOutputStream.writeShort(0);
                dataOutputStream.writeShort(0);
                digestOutputStream.on(false);
                dataOutputStream.write(j1Var.a());
                dataOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
                z2.a(dataOutputStream);
            } catch (Throwable th) {
                th = th;
                try {
                    s1.a(6, b, "Error when generating report", th);
                    z2.a(dataOutputStream);
                    bArr = null;
                    this.f148a = bArr;
                } catch (Throwable th2) {
                    z2.a(dataOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            dataOutputStream = null;
            s1.a(6, b, "Error when generating report", th);
            z2.a(dataOutputStream);
            bArr = null;
            this.f148a = bArr;
        }
        this.f148a = bArr;
    }
}
