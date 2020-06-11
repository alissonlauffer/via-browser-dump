package com.flurry.sdk;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.flurry.sdk.b4 */
public class C0041b4 {

    /* renamed from: a */
    private static final String f134a = "b4";

    /* renamed from: a */
    public static Map<String, List<String>> m229a(String str) {
        C0260s1.m686c(3, f134a, "Parsing referrer map");
        if (str == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String[] split = str.split("&");
        for (String str2 : split) {
            String[] split2 = str2.split("=");
            if (split2.length != 2) {
                C0260s1.m686c(5, f134a, "Invalid referrer Element: " + str2 + " in referrer tag " + str);
            } else {
                String decode = URLDecoder.decode(split2[0]);
                String decode2 = URLDecoder.decode(split2[1]);
                if (hashMap.get(decode) == null) {
                    hashMap.put(decode, new ArrayList());
                }
                ((List) hashMap.get(decode)).add(decode2);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            C0260s1.m686c(3, f134a, "entry: " + ((String) entry.getKey()) + "=" + entry.getValue());
        }
        StringBuilder sb = new StringBuilder();
        if (hashMap.get("utm_source") == null) {
            sb.append("Campaign Source is missing.\n");
        }
        if (hashMap.get("utm_medium") == null) {
            sb.append("Campaign Medium is missing.\n");
        }
        if (hashMap.get("utm_campaign") == null) {
            sb.append("Campaign Name is missing.\n");
        }
        if (sb.length() > 0) {
            C0260s1.m686c(5, f134a, "Detected missing referrer keys : " + sb.toString());
        }
        return hashMap;
    }
}
