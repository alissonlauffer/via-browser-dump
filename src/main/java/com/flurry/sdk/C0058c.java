package com.flurry.sdk;

import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.c */
public class C0058c {

    /* renamed from: c */
    private static final String f185c = "c";

    /* renamed from: d */
    private static String f186d;

    /* renamed from: e */
    private static String f187e;

    /* renamed from: a */
    EnumC0059a f188a;

    /* renamed from: b */
    private Object f189b;

    /* renamed from: com.flurry.sdk.c$a */
    public enum EnumC0059a {
        String("string"),
        Locale("localizedString"),
        Tombstone("tombstone");
        

        /* renamed from: d */
        private String f194d;

        private EnumC0059a(String str) {
            this.f194d = str;
        }

        @Override // java.lang.Enum, java.lang.Object
        public final String toString() {
            return this.f194d;
        }
    }

    public C0058c(JSONObject jSONObject) {
        String optString = jSONObject.optString("type");
        EnumC0059a aVar = EnumC0059a.String;
        if (aVar.f194d.equals(optString)) {
            this.f188a = aVar;
            this.f189b = jSONObject.optString("value");
            return;
        }
        EnumC0059a aVar2 = EnumC0059a.Locale;
        if (aVar2.f194d.equals(optString)) {
            this.f188a = aVar2;
            this.f189b = jSONObject.optJSONObject("value");
            return;
        }
        EnumC0059a aVar3 = EnumC0059a.Tombstone;
        if (aVar3.f194d.equals(optString)) {
            this.f188a = aVar3;
        } else {
            C0260s1.m693j(f185c, "Unknown ConfigItem type: ".concat(String.valueOf(optString)));
        }
    }

    /* renamed from: a */
    public final String mo132a() {
        Object obj = this.f189b;
        if (obj == null) {
            return null;
        }
        if (this.f188a != EnumC0059a.Locale) {
            return (String) obj;
        }
        if (f186d == null) {
            f186d = Locale.getDefault().toString();
            f187e = Locale.getDefault().getLanguage();
        }
        JSONObject jSONObject = (JSONObject) this.f189b;
        String optString = jSONObject.optString(f186d, null);
        if (optString == null) {
            optString = jSONObject.optString(f187e, null);
        }
        return optString == null ? jSONObject.optString("default") : optString;
    }

    /* renamed from: b */
    public final JSONObject mo133b(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("type", this.f188a.toString());
            jSONObject.put("value", this.f189b);
            return jSONObject;
        } catch (JSONException e) {
            C0260s1.m689f(f185c, "Error to create JSON object.", e);
            return null;
        }
    }
}
