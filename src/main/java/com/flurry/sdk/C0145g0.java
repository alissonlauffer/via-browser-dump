package com.flurry.sdk;

import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.g0 */
public class C0145g0 implements AbstractC0185l2<C0166j> {

    /* renamed from: a */
    private static final String f449a = "g0";

    /* renamed from: c */
    private static EnumC0029an m440c(String str) {
        EnumC0029an anVar = EnumC0029an.OFF;
        try {
            return !TextUtils.isEmpty(str) ? (EnumC0029an) Enum.valueOf(EnumC0029an.class, str) : anVar;
        } catch (Exception unused) {
            return anVar;
        }
    }

    /* renamed from: d */
    private static void m441d(C0132f fVar, JSONArray jSONArray) {
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
                        C0197n nVar = new C0197n();
                        nVar.f550a = optJSONObject.optString("string", "");
                        arrayList.add(nVar);
                    } else if (optJSONObject.has("com.flurry.proton.generated.avro.v2.EventParameterCallbackTrigger")) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("com.flurry.proton.generated.avro.v2.EventParameterCallbackTrigger");
                        if (optJSONObject2 != null) {
                            C0203o oVar = new C0203o();
                            oVar.f550a = optJSONObject2.optString("event_name", "");
                            oVar.f589c = optJSONObject2.optString("event_parameter_name", "");
                            JSONArray optJSONArray = optJSONObject2.optJSONArray("event_parameter_values");
                            if (optJSONArray != null) {
                                strArr = new String[optJSONArray.length()];
                                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                    strArr[i2] = optJSONArray.optString(i2, "");
                                }
                            } else {
                                strArr = new String[0];
                            }
                            oVar.f590d = strArr;
                            arrayList.add(oVar);
                        }
                    }
                }
            }
            fVar.f412c = arrayList;
        }
    }

    /* renamed from: e */
    private static void m442e(C0153h hVar, JSONArray jSONArray) {
        JSONObject optJSONObject;
        if (jSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    C0132f fVar = new C0132f();
                    fVar.f411b = optJSONObject2.optString("partner", "");
                    m441d(fVar, optJSONObject2.optJSONArray("events"));
                    fVar.f413d = m444g(optJSONObject2.optString("method"));
                    fVar.f414e = optJSONObject2.optString("uri_template", "");
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("body_template");
                    if (optJSONObject3 != null) {
                        String optString = optJSONObject3.optString("string", "null");
                        if (!optString.equals("null")) {
                            fVar.f415f = optString;
                        }
                    }
                    fVar.f416g = optJSONObject2.optInt("max_redirects", 5);
                    fVar.f417h = optJSONObject2.optInt("connect_timeout", 20);
                    fVar.f418i = optJSONObject2.optInt("request_timeout", 20);
                    fVar.f410a = optJSONObject2.optLong("callback_id", -1);
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("headers");
                    if (!(optJSONObject4 == null || (optJSONObject = optJSONObject4.optJSONObject("map")) == null)) {
                        fVar.f419j = C0027a3.m191a(optJSONObject);
                    }
                    arrayList.add(fVar);
                }
            }
            hVar.f455a = arrayList;
        }
    }

    /* renamed from: f */
    private static C0166j m443f(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        String str = new String(C0328z2.m893h(inputStream));
        C0260s1.m686c(5, f449a, "Proton response string: ".concat(str));
        C0166j jVar = new C0166j();
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.optLong("issued_at", -1);
            jVar.f500a = jSONObject.optLong("refresh_ttl", 3600);
            jVar.f501b = jSONObject.optLong("expiration_ttl", 86400);
            JSONObject optJSONObject = jSONObject.optJSONObject("global_settings");
            jVar.f502c = new C0252r();
            if (optJSONObject != null) {
                m440c(optJSONObject.optString("log_level"));
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("pulse");
            C0153h hVar = new C0153h();
            if (optJSONObject2 != null) {
                m442e(hVar, optJSONObject2.optJSONArray("callbacks"));
                hVar.f456b = optJSONObject2.optInt("max_callback_retries", 3);
                hVar.f457c = optJSONObject2.optInt("max_callback_attempts_per_report", 15);
                hVar.f458d = optJSONObject2.optInt("max_report_delay_seconds", 600);
                hVar.f459e = optJSONObject2.optString("agent_report_url", "");
            }
            jVar.f503d = hVar;
            JSONObject optJSONObject3 = jSONObject.optJSONObject("analytics");
            C0263t tVar = new C0263t();
            jVar.f504e = tVar;
            if (optJSONObject3 != null) {
                tVar.f726b = optJSONObject3.optBoolean("analytics_enabled", true);
                jVar.f504e.f725a = optJSONObject3.optInt("max_session_properties", 10);
            }
            return jVar;
        } catch (JSONException e) {
            throw new IOException("Exception while deserialize: ", e);
        }
    }

    /* renamed from: g */
    private static EnumC0042bc m444g(String str) {
        EnumC0042bc bcVar = EnumC0042bc.GET;
        try {
            return !TextUtils.isEmpty(str) ? (EnumC0042bc) Enum.valueOf(EnumC0042bc.class, str) : bcVar;
        } catch (Exception unused) {
            return bcVar;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.io.OutputStream, java.lang.Object] */
    @Override // com.flurry.sdk.AbstractC0185l2
    /* renamed from: a */
    public final /* synthetic */ void mo105a(OutputStream outputStream, C0166j jVar) {
        throw new IOException("Serialize not supported for response");
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.flurry.sdk.AbstractC0185l2
    /* renamed from: b */
    public final /* synthetic */ C0166j mo106b(InputStream inputStream) {
        return m443f(inputStream);
    }
}
