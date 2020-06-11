package com.flurry.sdk;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class j3 {
    public static List<n3> a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("variants");
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(b(optJSONObject));
            }
        }
        return arrayList;
    }

    private static n3 b(JSONObject jSONObject) {
        String optString;
        n3 n3Var = new n3(m3.a(jSONObject.optString("document", m3.c.toString())));
        n3Var.b = jSONObject.optInt("id");
        n3Var.c = jSONObject.optInt("version");
        n3Var.d = jSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (!(optJSONObject == null || (optString = optJSONObject.optString("name", null)) == null)) {
                    n3Var.e.put(optString, new c(optJSONObject));
                }
            }
        }
        return n3Var;
    }
}
