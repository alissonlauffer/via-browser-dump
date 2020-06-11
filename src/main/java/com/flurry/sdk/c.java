package com.flurry.sdk;

import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    private static final String c = "c";
    private static String d;
    private static String e;

    /* renamed from: a  reason: collision with root package name */
    a f78a;
    private Object b;

    public enum a {
        String("string"),
        Locale("localizedString"),
        Tombstone("tombstone");
        
        /* access modifiers changed from: private */
        public String d;

        private a(String str) {
            this.d = str;
        }

        public final String toString() {
            return this.d;
        }
    }

    public c(JSONObject jSONObject) {
        String optString = jSONObject.optString("type");
        if (a.String.d.equals(optString)) {
            this.f78a = a.String;
            this.b = jSONObject.optString("value");
        } else if (a.Locale.d.equals(optString)) {
            this.f78a = a.Locale;
            this.b = jSONObject.optJSONObject("value");
        } else if (a.Tombstone.d.equals(optString)) {
            this.f78a = a.Tombstone;
        } else {
            s1.b(c, "Unknown ConfigItem type: ".concat(String.valueOf(optString)));
        }
    }

    public final String a() {
        Object obj = this.b;
        if (obj == null) {
            return null;
        }
        if (this.f78a != a.Locale) {
            return (String) obj;
        }
        if (d == null) {
            d = Locale.getDefault().toString();
            e = Locale.getDefault().getLanguage();
        }
        JSONObject jSONObject = (JSONObject) this.b;
        String optString = jSONObject.optString(d, null);
        if (optString == null) {
            optString = jSONObject.optString(e, null);
        }
        return optString == null ? jSONObject.optString("default") : optString;
    }

    public final JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("type", this.f78a.toString());
            jSONObject.put("value", this.b);
            return jSONObject;
        } catch (JSONException e2) {
            s1.a(c, "Error to create JSON object.", e2);
            return null;
        }
    }
}
