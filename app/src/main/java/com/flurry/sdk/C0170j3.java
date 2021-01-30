package com.flurry.sdk;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.j3 */
public class C0170j3 {
    /* renamed from: a */
    public static List<C0202n3> m494a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("variants");
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m495b(optJSONObject));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private static C0202n3 m495b(JSONObject jSONObject) {
        String optString;
        C0202n3 n3Var = new C0202n3(C0196m3.m526a(jSONObject.optString("document", C0196m3.f548c.toString())));
        n3Var.f585b = jSONObject.optInt("id");
        n3Var.f586c = jSONObject.optInt("version");
        n3Var.f587d = jSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (!(optJSONObject == null || (optString = optJSONObject.optString("name", null)) == null)) {
                    n3Var.f588e.put(optString, new C0058c(optJSONObject));
                }
            }
        }
        return n3Var;
    }
}
