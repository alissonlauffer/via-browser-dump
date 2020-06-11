package com.flurry.sdk;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g0 implements l2<j> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f127a = "g0";

    private static j b(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        String str = new String(z2.a(inputStream));
        s1.a(5, f127a, "Proton response string: ".concat(str));
        j jVar = new j();
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optLong("issued_at", -1);
            jVar.f143a = jSONObject.optLong("refresh_ttl", 3600);
            jVar.b = jSONObject.optLong("expiration_ttl", 86400);
            JSONObject optJSONObject = jSONObject.optJSONObject("global_settings");
            jVar.c = new r();
            if (optJSONObject != null) {
                a(optJSONObject.optString("log_level"));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("pulse");
            h hVar = new h();
            if (optJSONObject2 != null) {
                a(hVar, optJSONObject2.optJSONArray("callbacks"));
                hVar.b = optJSONObject2.optInt("max_callback_retries", 3);
                hVar.c = optJSONObject2.optInt("max_callback_attempts_per_report", 15);
                hVar.d = optJSONObject2.optInt("max_report_delay_seconds", 600);
                hVar.e = optJSONObject2.optString("agent_report_url", "");
            }
            jVar.d = hVar;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("analytics");
            t tVar = new t();
            jVar.e = tVar;
            if (optJSONObject3 != null) {
                tVar.b = optJSONObject3.optBoolean("analytics_enabled", true);
                jVar.e.f193a = optJSONObject3.optInt("max_session_properties", 10);
            }
            return jVar;
        } catch (JSONException e) {
            throw new IOException("Exception while deserialize: ", e);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.flurry.sdk.l2
    public final /* synthetic */ j a(InputStream inputStream) {
        return b(inputStream);
    }

    private static an a(String str) {
        an anVar = an.OFF;
        try {
            return !TextUtils.isEmpty(str) ? (an) Enum.valueOf(an.class, str) : anVar;
        } catch (Exception unused) {
            return anVar;
        }
    }

    private static void a(h hVar, JSONArray jSONArray) {
        JSONObject optJSONObject;
        if (jSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    f fVar = new f();
                    fVar.b = optJSONObject2.optString("partner", "");
                    a(fVar, optJSONObject2.optJSONArray("events"));
                    fVar.d = b(optJSONObject2.optString("method"));
                    fVar.e = optJSONObject2.optString("uri_template", "");
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("body_template");
                    if (optJSONObject3 != null) {
                        String optString = optJSONObject3.optString("string", "null");
                        if (!optString.equals("null")) {
                            fVar.f = optString;
                        }
                    }
                    fVar.g = optJSONObject2.optInt("max_redirects", 5);
                    fVar.h = optJSONObject2.optInt("connect_timeout", 20);
                    fVar.i = optJSONObject2.optInt("request_timeout", 20);
                    fVar.f120a = optJSONObject2.optLong("callback_id", -1);
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("headers");
                    if (!(optJSONObject4 == null || (optJSONObject = optJSONObject4.optJSONObject("map")) == null)) {
                        fVar.j = a3.a(optJSONObject);
                    }
                    arrayList.add(fVar);
                }
            }
            hVar.f132a = arrayList;
        }
    }

    private static void a(f fVar, JSONArray jSONArray) {
        String[] strArr;
        if (jSONArray != null) {
            ArrayList arrayList = null;
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    if (optJSONObject.has("string")) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        n nVar = new n();
                        nVar.f161a = optJSONObject.optString("string", "");
                        arrayList.add(nVar);
                    } else if (optJSONObject.has("com.flurry.proton.generated.avro.v2.EventParameterCallbackTrigger")) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("com.flurry.proton.generated.avro.v2.EventParameterCallbackTrigger");
                        if (optJSONObject2 != null) {
                            o oVar = new o();
                            ((n) oVar).f161a = optJSONObject2.optString("event_name", "");
                            oVar.c = optJSONObject2.optString("event_parameter_name", "");
                            JSONArray optJSONArray = optJSONObject2.optJSONArray("event_parameter_values");
                            if (optJSONArray != null) {
                                strArr = new String[optJSONArray.length()];
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    strArr[i2] = optJSONArray.optString(i2, "");
                                }
                            } else {
                                strArr = new String[0];
                            }
                            oVar.d = strArr;
                            arrayList.add(oVar);
                        }
                    }
                }
            }
            fVar.c = arrayList;
        }
    }

    private static bc b(String str) {
        bc bcVar = bc.GET;
        try {
            return !TextUtils.isEmpty(str) ? (bc) Enum.valueOf(bc.class, str) : bcVar;
        } catch (Exception unused) {
            return bcVar;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
    @Override // com.flurry.sdk.l2
    public final /* synthetic */ void a(OutputStream outputStream, j jVar) {
        throw new IOException("Serialize not supported for response");
    }
}
