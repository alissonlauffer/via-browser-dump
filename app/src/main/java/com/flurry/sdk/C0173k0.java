package com.flurry.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.flurry.android.AbstractC0003a;
import com.flurry.android.C0004b;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.security.DigestOutputStream;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.k0 */
public class C0173k0 {

    /* renamed from: b */
    private static final String f521b = "k0";

    /* renamed from: a */
    public byte[] f522a = null;

    /* JADX INFO: finally extract failed */
    public C0173k0(String str, String str2, boolean z, boolean z2, long j, long j2, List<C0188m0> list, Map<EnumC0076ca, byte[]> map, Map<String, List<String>> map2, Map<String, List<String>> map3, Map<String, Map<String, String>> map4, long j3, C0266t2 t2Var, boolean z3) {
        byte[] bArr;
        DataOutputStream dataOutputStream;
        Throwable th;
        String str3;
        Map<String, String> map5;
        int i;
        String str4;
        String str5;
        int identifier;
        try {
            C0168j1 j1Var = new C0168j1();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DigestOutputStream digestOutputStream = new DigestOutputStream(byteArrayOutputStream, j1Var);
            dataOutputStream = new DataOutputStream(digestOutputStream);
            try {
                dataOutputStream.writeShort(35);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeLong(0);
                dataOutputStream.writeShort(0);
                dataOutputStream.writeShort(3);
                dataOutputStream.writeShort(C0135f1.m416a());
                dataOutputStream.writeLong(j3);
                dataOutputStream.writeUTF(str);
                dataOutputStream.writeUTF(str2);
                String str6 = (String) t2Var.mo341a("VersionName");
                if (TextUtils.isEmpty(str6)) {
                    dataOutputStream.writeUTF("");
                } else {
                    dataOutputStream.writeUTF(str6);
                }
                Context context = C0118e1.m386a().f361a;
                dataOutputStream.writeUTF(String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
                dataOutputStream.writeByte(3);
                if (C0254r1.m677a().f714a) {
                    dataOutputStream.writeByte(3);
                    C0260s1.m697n(f521b, "Agent report type: instant app");
                } else {
                    dataOutputStream.writeByte(1);
                    C0260s1.m697n(f521b, "Agent report type: main device");
                }
                dataOutputStream.writeShort(map.size());
                for (Map.Entry<EnumC0076ca, byte[]> entry : map.entrySet()) {
                    dataOutputStream.writeShort(entry.getKey().f231d);
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
                dataOutputStream.writeBoolean(((Boolean) t2Var.mo341a("IncludeBackgroundSessionsInMetrics")).booleanValue());
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
                C0253r0.m676a();
                Context context2 = C0118e1.m386a().f361a;
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
                    C0260s1.m686c(3, f521b, "sending referrer values because it exists");
                    for (Map.Entry<String, List<String>> entry2 : map2.entrySet()) {
                        String str7 = f521b;
                        C0260s1.m686c(3, str7, "Referrer Entry:  " + entry2.getKey() + "=" + entry2.getValue());
                        dataOutputStream.writeUTF(entry2.getKey());
                        StringBuilder sb = new StringBuilder("referrer key is :");
                        sb.append(entry2.getKey());
                        C0260s1.m686c(3, str7, sb.toString());
                        dataOutputStream.writeShort(entry2.getValue().size());
                        for (String str8 : entry2.getValue()) {
                            dataOutputStream.writeUTF(str8);
                            C0260s1.m686c(3, f521b, "referrer value is :".concat(String.valueOf(str8)));
                        }
                    }
                }
                String str9 = (String) t2Var.mo341a("notificationToken");
                if (!TextUtils.isEmpty(str9)) {
                    dataOutputStream.writeBoolean(true);
                    dataOutputStream.writeUTF(str9);
                } else {
                    dataOutputStream.writeBoolean(false);
                }
                dataOutputStream.writeBoolean(((Boolean) t2Var.mo341a("notificationsEnabled")).booleanValue());
                int size = map3 != null ? map3.keySet().size() : 0;
                String str10 = f521b;
                C0260s1.m686c(3, str10, "optionsMapSize is:  ".concat(String.valueOf(size)));
                dataOutputStream.writeShort(size);
                if (map3 != null) {
                    C0260s1.m686c(3, str10, "sending launch options");
                    for (Map.Entry<String, List<String>> entry3 : map3.entrySet()) {
                        String str11 = f521b;
                        C0260s1.m686c(3, str11, "Launch Options Key:  " + entry3.getKey());
                        dataOutputStream.writeUTF(entry3.getKey());
                        dataOutputStream.writeShort(entry3.getValue().size());
                        for (String str12 : entry3.getValue()) {
                            dataOutputStream.writeUTF(str12);
                            C0260s1.m686c(3, f521b, "Launch Options value is :".concat(String.valueOf(str12)));
                        }
                    }
                }
                int size2 = map4 != null ? map4.keySet().size() : 0;
                C0260s1.m686c(3, f521b, "numOriginAttributions is:  ".concat(String.valueOf(size)));
                dataOutputStream.writeShort(size2);
                if (map4 != null) {
                    for (Map.Entry<String, Map<String, String>> entry4 : map4.entrySet()) {
                        String str13 = f521b;
                        C0260s1.m686c(3, str13, "Origin Atttribute Key:  " + entry4.getKey());
                        dataOutputStream.writeUTF(entry4.getKey());
                        dataOutputStream.writeShort(entry4.getValue().size());
                        C0260s1.m686c(3, str13, "Origin Attribute Map Size for " + entry4.getKey() + ":  " + entry4.getValue().size());
                        for (Map.Entry<String, String> entry5 : entry4.getValue().entrySet()) {
                            String str14 = f521b;
                            C0260s1.m686c(3, str14, "Origin Atttribute for " + entry4.getKey() + ":  " + entry5.getKey() + ":" + entry5.getValue());
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
                dataOutputStream.writeUTF(C0300w2.m815a(C0118e1.m386a().f361a));
                AbstractC0003a e = C0004b.m133e();
                if (e == null) {
                    map5 = null;
                } else {
                    map5 = e.mo72a();
                }
                if (e == null) {
                    i = 0;
                } else {
                    i = e.mo73b() ? 1 : 2;
                }
                dataOutputStream.writeByte(i);
                if (map5 == null) {
                    dataOutputStream.writeShort(0);
                } else {
                    dataOutputStream.writeShort(map5.size());
                }
                if (map5 != null) {
                    for (Map.Entry<String, String> entry6 : map5.entrySet()) {
                        String str15 = f521b;
                        C0260s1.m686c(3, str15, "Consent string for " + entry6.getKey() + ": " + entry6.getValue());
                        dataOutputStream.writeUTF(entry6.getKey());
                        dataOutputStream.writeUTF(entry6.getValue());
                    }
                }
                dataOutputStream.writeShort(list.size());
                for (C0188m0 m0Var : list) {
                    dataOutputStream.write(m0Var.f543a);
                }
                dataOutputStream.writeShort(0);
                dataOutputStream.writeShort(0);
                digestOutputStream.on(false);
                dataOutputStream.write(j1Var.mo244a());
                dataOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
                C0328z2.m890e(dataOutputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    C0260s1.m687d(6, f521b, "Error when generating report", th);
                    C0328z2.m890e(dataOutputStream);
                    bArr = null;
                    this.f522a = bArr;
                } catch (Throwable th3) {
                    C0328z2.m890e(dataOutputStream);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            dataOutputStream = null;
            C0260s1.m687d(6, f521b, "Error when generating report", th);
            C0328z2.m890e(dataOutputStream);
            bArr = null;
            this.f522a = bArr;
        }
        this.f522a = bArr;
    }
}
