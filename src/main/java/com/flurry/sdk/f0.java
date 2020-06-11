package com.flurry.sdk;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f0 implements l2<i> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f121a = "f0";

    class a extends DataOutputStream {
        a(f0 f0Var, OutputStream outputStream) {
            super(outputStream);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.io.FilterOutputStream, java.lang.AutoCloseable
        public final void close() {
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
    @Override // com.flurry.sdk.l2
    public final /* synthetic */ void a(OutputStream outputStream, i iVar) {
        JSONObject jSONObject;
        i iVar2 = iVar;
        if (outputStream != null && iVar2 != null) {
            a aVar = new a(this, outputStream);
            JSONObject jSONObject2 = new JSONObject();
            try {
                a(jSONObject2, "project_key", iVar2.f137a);
                a(jSONObject2, "bundle_id", iVar2.b);
                a(jSONObject2, "app_version", iVar2.c);
                jSONObject2.put("sdk_version", iVar2.d);
                jSONObject2.put("platform", iVar2.e);
                a(jSONObject2, "platform_version", iVar2.f);
                jSONObject2.put("limit_ad_tracking", iVar2.g);
                JSONObject jSONObject3 = null;
                jSONObject3 = null;
                if (iVar2.h == null || iVar2.h.f157a == null) {
                    jSONObject = null;
                } else {
                    jSONObject = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    a(jSONObject4, "model", iVar2.h.f157a.f108a);
                    a(jSONObject4, "brand", iVar2.h.f157a.b);
                    a(jSONObject4, "id", iVar2.h.f157a.c);
                    a(jSONObject4, "device", iVar2.h.f157a.d);
                    a(jSONObject4, "product", iVar2.h.f157a.e);
                    a(jSONObject4, "version_release", iVar2.h.f157a.f);
                    jSONObject.put("com.flurry.proton.generated.avro.v2.AndroidTags", jSONObject4);
                }
                if (jSONObject != null) {
                    jSONObject2.put("device_tags", jSONObject);
                } else {
                    jSONObject2.put("device_tags", JSONObject.NULL);
                }
                JSONArray jSONArray = new JSONArray();
                for (l lVar : iVar2.i) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("type", lVar.f152a);
                    a(jSONObject5, "id", lVar.b);
                    jSONArray.put(jSONObject5);
                }
                jSONObject2.put("device_ids", jSONArray);
                if (!(iVar2.j == null || iVar2.j.f177a == null)) {
                    jSONObject3 = new JSONObject();
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.putOpt("latitude", Double.valueOf(iVar2.j.f177a.f173a));
                    jSONObject6.putOpt("longitude", Double.valueOf(iVar2.j.f177a.b));
                    jSONObject6.putOpt("accuracy", Float.valueOf(iVar2.j.f177a.c));
                    jSONObject3.put("com.flurry.proton.generated.avro.v2.Geolocation", jSONObject6);
                }
                if (jSONObject3 != null) {
                    jSONObject2.put("geo", jSONObject3);
                } else {
                    jSONObject2.put("geo", JSONObject.NULL);
                }
                JSONObject jSONObject7 = new JSONObject();
                if (iVar2.k != null) {
                    a(jSONObject7, "string", iVar2.k.f190a);
                    jSONObject2.put("publisher_user_id", jSONObject7);
                } else {
                    jSONObject2.put("publisher_user_id", JSONObject.NULL);
                }
                s1.a(5, f121a, "Proton Request String: " + jSONObject2.toString());
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

    private static void a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            jSONObject.put(str, str2);
        } else {
            jSONObject.put(str, JSONObject.NULL);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.flurry.sdk.l2
    public final /* synthetic */ i a(InputStream inputStream) {
        throw new IOException("Deserialize not supported for request");
    }
}
