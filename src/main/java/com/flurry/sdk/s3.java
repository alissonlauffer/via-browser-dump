package com.flurry.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class s3 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f192a = "s3";

    public static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
            jSONObject.put("guid", str);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("APP");
            try {
                Class.forName("com.flurry.android.config.killswitch.KillSwitch");
                jSONArray.put("KILLSWITCH");
            } catch (ClassNotFoundException unused) {
            }
            jSONObject.put("documents", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(v3.a() ? "com.flurry.configkey.prod.ec.1" : "com.flurry.configkey.prod.rot.6");
            jSONArray2.put("com.flurry.configkey.prod.fs.0");
            jSONObject.put("signatureKeys", jSONArray2);
            y0 b = y0.b();
            Context context = e1.a().f110a;
            d d = d.d();
            o2 o2Var = d.d;
            if (v3.a(o2Var.d())) {
                String str2 = null;
                if (o2Var.f171a != null) {
                    str2 = o2Var.f171a.getString("lastETag", null);
                }
                if (str2 != null) {
                    jSONObject.put("etag", str2);
                }
            }
            jSONObject.put("apiKey", e1.a().e);
            jSONObject.put("appVersion", b.a());
            jSONObject.put("appBuild", Integer.toString(y0.a(context)));
            jSONObject.put("sdkVersion", f1.a());
            jSONObject.put("platform", 3);
            jSONObject.put("platformVersion", y0.c());
            JSONArray jSONArray3 = new JSONArray();
            for (Map.Entry entry : Collections.unmodifiableMap(bs.e().b).entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                byte[] bArr = (byte[]) entry.getValue();
                jSONObject2.put("id", ((ca) entry.getKey()).e ? new String(bArr) : Base64.encodeToString(bArr, 2));
                jSONObject2.put("type", ((ca) entry.getKey()).d);
                jSONArray3.put(jSONObject2);
            }
            jSONObject.put("deviceIds", jSONArray3);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("brand", Build.BRAND);
            jSONObject3.put("device", Build.DEVICE);
            jSONObject3.put("id", Build.ID);
            jSONObject3.put("model", Build.MODEL);
            jSONObject3.put("product", Build.PRODUCT);
            jSONObject3.put("version_release", Build.VERSION.RELEASE);
            jSONObject.put("deviceTags", jSONObject3);
            jSONObject.put("bundleId", w2.a(context));
            u0.a();
            jSONObject.put("locale", u0.b());
            String str3 = (String) t2.a().a("UserId");
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("publisherUserId", str3);
            }
            List<n3> c = d.c();
            if (c != null && c.size() > 0) {
                JSONArray jSONArray4 = new JSONArray();
                for (n3 n3Var : c) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("id", n3Var.b);
                    jSONObject4.put("version", n3Var.c);
                    jSONArray4.put(jSONObject4);
                }
                jSONObject.put("currentVariants", jSONArray4);
            }
        } catch (JSONException e) {
            s1.a(f192a, "ParameterProvider error", e);
        }
        String jSONObject5 = jSONObject.toString();
        s1.a(f192a, "Request Parameters: ".concat(String.valueOf(jSONObject5)));
        return jSONObject5;
    }
}
