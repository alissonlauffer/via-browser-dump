package com.flurry.sdk;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.a3 */
public final class C0027a3 {
    /* renamed from: a */
    public static Map<String, String> m191a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next instanceof String) {
                String str = next;
                Object obj = jSONObject.get(str);
                if (obj instanceof String) {
                    hashMap.put(str, (String) obj);
                } else {
                    throw new JSONException("JSONObject contains unsupported type for value in the map.");
                }
            } else {
                throw new JSONException("JSONObject contains unsupported type for key in the map.");
            }
        }
        return hashMap;
    }
}
