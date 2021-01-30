package com.flurry.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.s3 */
public class C0262s3 {

    /* renamed from: a */
    private static final String f724a = "s3";

    /* renamed from: a */
    public static String m702a(String str) {
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
            jSONArray2.put(C0284v3.m749c() ? "com.flurry.configkey.prod.ec.1" : "com.flurry.configkey.prod.rot.6");
            jSONArray2.put("com.flurry.configkey.prod.fs.0");
            jSONObject.put("signatureKeys", jSONArray2);
            C0314y0 a = C0314y0.m857a();
            Context context = C0118e1.m386a().f361a;
            C0088d b = C0088d.m317b();
            C0225o2 o2Var = b.f272d;
            if (C0284v3.m751e(o2Var.mo295f())) {
                SharedPreferences sharedPreferences = o2Var.f658a;
                Object obj = null;
                if (sharedPreferences != null) {
                    obj = sharedPreferences.getString("lastETag", null);
                }
                if (obj != null) {
                    jSONObject.put("etag", obj);
                }
            }
            jSONObject.put("apiKey", C0118e1.m386a().f365e);
            jSONObject.put("appVersion", a.mo366f());
            jSONObject.put("appBuild", Integer.toString(C0314y0.m858c(context)));
            jSONObject.put("sdkVersion", C0135f1.m416a());
            jSONObject.put("platform", 3);
            jSONObject.put("platformVersion", C0314y0.m859d());
            JSONArray jSONArray3 = new JSONArray();
            for (Map.Entry entry : Collections.unmodifiableMap(C0044bs.m232a().f150b).entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                byte[] bArr = (byte[]) entry.getValue();
                jSONObject2.put("id", ((EnumC0076ca) entry.getKey()).f232e ? new String(bArr) : Base64.encodeToString(bArr, 2));
                jSONObject2.put("type", ((EnumC0076ca) entry.getKey()).f231d);
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
            jSONObject.put("bundleId", C0300w2.m815a(context));
            C0273u0.m716a();
            jSONObject.put("locale", C0273u0.m717b());
            String str2 = (String) C0266t2.m703e().mo341a("UserId");
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("publisherUserId", str2);
            }
            List<C0202n3> m = b.mo159m();
            if (m != null && m.size() > 0) {
                JSONArray jSONArray4 = new JSONArray();
                for (C0202n3 n3Var : m) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("id", n3Var.f585b);
                    jSONObject4.put("version", n3Var.f586c);
                    jSONArray4.put(jSONObject4);
                }
                jSONObject.put("currentVariants", jSONArray4);
            }
        } catch (JSONException e) {
            C0260s1.m689f(f724a, "ParameterProvider error", e);
        }
        String jSONObject5 = jSONObject.toString();
        C0260s1.m688e(f724a, "Request Parameters: ".concat(String.valueOf(jSONObject5)));
        return jSONObject5;
    }
}
