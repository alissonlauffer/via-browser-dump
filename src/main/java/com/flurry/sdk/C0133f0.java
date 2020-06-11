package com.flurry.sdk;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.f0 */
public class C0133f0 implements AbstractC0185l2<C0160i> {

    /* renamed from: a */
    private static final String f420a = "f0";

    /* renamed from: com.flurry.sdk.f0$a */
    class C0134a extends DataOutputStream {
        C0134a(C0133f0 f0Var, OutputStream outputStream) {
            super(outputStream);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
        public final void close() {
        }
    }

    /* renamed from: c */
    private static void m413c(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            jSONObject.put(str, str2);
        } else {
            jSONObject.put(str, JSONObject.NULL);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
    @Override // com.flurry.sdk.AbstractC0185l2
    /* renamed from: a */
    public final /* synthetic */ void mo105a(OutputStream outputStream, C0160i iVar) {
        JSONObject jSONObject;
        C0160i iVar2 = iVar;
        if (outputStream != null && iVar2 != null) {
            C0134a aVar = new C0134a(this, outputStream);
            JSONObject jSONObject2 = new JSONObject();
            try {
                m413c(jSONObject2, "project_key", iVar2.f481a);
                m413c(jSONObject2, "bundle_id", iVar2.f482b);
                m413c(jSONObject2, "app_version", iVar2.f483c);
                jSONObject2.put("sdk_version", iVar2.f484d);
                jSONObject2.put("platform", iVar2.f485e);
                m413c(jSONObject2, "platform_version", iVar2.f486f);
                jSONObject2.put("limit_ad_tracking", iVar2.f487g);
                C0187m mVar = iVar2.f488h;
                JSONObject jSONObject3 = null;
                if (mVar == null || mVar.f541a == null) {
                    jSONObject = null;
                } else {
                    jSONObject = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    m413c(jSONObject4, "model", iVar2.f488h.f541a.f351a);
                    m413c(jSONObject4, "brand", iVar2.f488h.f541a.f352b);
                    m413c(jSONObject4, "id", iVar2.f488h.f541a.f353c);
                    m413c(jSONObject4, "device", iVar2.f488h.f541a.f354d);
                    m413c(jSONObject4, "product", iVar2.f488h.f541a.f355e);
                    m413c(jSONObject4, "version_release", iVar2.f488h.f541a.f356f);
                    jSONObject.put("com.flurry.proton.generated.avro.v2.AndroidTags", jSONObject4);
                }
                if (jSONObject != null) {
                    jSONObject2.put("device_tags", jSONObject);
                } else {
                    jSONObject2.put("device_tags", JSONObject.NULL);
                }
                JSONArray jSONArray = new JSONArray();
                for (C0179l lVar : iVar2.f489i) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("type", lVar.f529a);
                    m413c(jSONObject5, "id", lVar.f530b);
                    jSONArray.put(jSONObject5);
                }
                jSONObject2.put("device_ids", jSONArray);
                C0234q qVar = iVar2.f490j;
                if (!(qVar == null || qVar.f676a == null)) {
                    jSONObject3 = new JSONObject();
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.putOpt("latitude", Double.valueOf(iVar2.f490j.f676a.f668a));
                    jSONObject6.putOpt("longitude", Double.valueOf(iVar2.f490j.f676a.f669b));
                    jSONObject6.putOpt("accuracy", Float.valueOf(iVar2.f490j.f676a.f670c));
                    jSONObject3.put("com.flurry.proton.generated.avro.v2.Geolocation", jSONObject6);
                }
                if (jSONObject3 != null) {
                    jSONObject2.put("geo", jSONObject3);
                } else {
                    jSONObject2.put("geo", JSONObject.NULL);
                }
                JSONObject jSONObject7 = new JSONObject();
                C0258s sVar = iVar2.f491k;
                if (sVar != null) {
                    m413c(jSONObject7, "string", sVar.f720a);
                    jSONObject2.put("publisher_user_id", jSONObject7);
                } else {
                    jSONObject2.put("publisher_user_id", JSONObject.NULL);
                }
                C0260s1.m686c(5, f420a, "Proton Request String: " + jSONObject2.toString());
                aVar.write(jSONObject2.toString().getBytes());
                aVar.flush();
                aVar.close();
            } catch (JSONException e) {
                throw new IOException("Invalid Json", e);
            } catch (Throwable th) {
                aVar.close();
                throw th;
            }
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.flurry.sdk.AbstractC0185l2
    /* renamed from: b */
    public final /* synthetic */ C0160i mo106b(InputStream inputStream) {
        throw new IOException("Deserialize not supported for request");
    }
}
