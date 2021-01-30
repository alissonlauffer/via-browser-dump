package com.flurry.sdk;

import android.location.Location;
import java.util.Map;

/* renamed from: com.flurry.sdk.v */
public class C0278v extends C0307x1 {

    /* renamed from: b */
    private static final String f770b = "v";

    /* renamed from: c */
    public final String mo345c(String str, Map<String, String> map) {
        String a = mo361a(str);
        while (a != null) {
            if (C0307x1.m835b("timestamp_epoch_millis", a)) {
                String valueOf = String.valueOf(System.currentTimeMillis());
                C0260s1.m686c(3, f770b, "Replacing param timestamp_epoch_millis with: ".concat(String.valueOf(valueOf)));
                str = str.replace(a, C0328z2.m896k(valueOf));
            } else if (C0307x1.m835b("session_duration_millis", a)) {
                C0235q0.m624b();
                String l = Long.toString(C0235q0.m629g());
                C0260s1.m686c(3, f770b, "Replacing param session_duration_millis with: ".concat(String.valueOf(l)));
                str = str.replace(a, C0328z2.m896k(l));
            } else if (C0307x1.m835b("fg_timespent_millis", a)) {
                C0235q0.m624b();
                String l2 = Long.toString(C0235q0.m629g());
                C0260s1.m686c(3, f770b, "Replacing param fg_timespent_millis with: ".concat(String.valueOf(l2)));
                str = str.replace(a, C0328z2.m896k(l2));
            } else {
                String str2 = "";
                if (C0307x1.m835b("install_referrer", a)) {
                    String b = new C0028a4().mo112b();
                    if (b != null) {
                        str2 = b;
                    }
                    C0260s1.m686c(3, f770b, "Replacing param install_referrer with: ".concat(String.valueOf(str2)));
                    str = str.replace(a, C0328z2.m896k(str2));
                } else if (C0307x1.m835b("geo_latitude", a)) {
                    Location n = C0279v0.m732e().mo348n();
                    if (n != null) {
                        int k = C0279v0.m738k();
                        str2 = str2 + C0328z2.m886a(n.getLatitude(), k);
                    }
                    C0260s1.m686c(3, f770b, "Replacing param geo_latitude with: ".concat(String.valueOf(str2)));
                    str = str.replace(a, C0328z2.m896k(str2));
                } else if (C0307x1.m835b("geo_longitude", a)) {
                    Location n2 = C0279v0.m732e().mo348n();
                    if (n2 != null) {
                        int k2 = C0279v0.m738k();
                        str2 = str2 + C0328z2.m886a(n2.getLongitude(), k2);
                    }
                    C0260s1.m686c(3, f770b, "Replacing param geo_longitude with: ".concat(String.valueOf(str2)));
                    str = str.replace(a, C0328z2.m896k(str2));
                } else if (C0307x1.m835b("publisher_user_id", a)) {
                    String str3 = (String) C0266t2.m703e().mo341a("UserId");
                    C0260s1.m686c(3, f770b, "Replacing param publisher_user_id with: ".concat(String.valueOf(str3)));
                    str = str.replace(a, C0328z2.m896k(str3));
                } else if (C0307x1.m835b("event_name", a)) {
                    if (map.containsKey("event_name")) {
                        C0260s1.m686c(3, f770b, "Replacing param event_name with: " + map.get("event_name"));
                        str = str.replace(a, C0328z2.m896k(map.get("event_name")));
                    } else {
                        C0260s1.m686c(3, f770b, "Replacing param event_name with empty string");
                        str = str.replace(a, str2);
                    }
                } else if (!C0307x1.m835b("event_time_millis", a)) {
                    C0260s1.m686c(3, f770b, "Unknown param: ".concat(String.valueOf(a)));
                    str = str.replace(a, str2);
                } else if (map.containsKey("event_time_millis")) {
                    C0260s1.m686c(3, f770b, "Replacing param event_time_millis with: " + map.get("event_time_millis"));
                    str = str.replace(a, C0328z2.m896k(map.get("event_time_millis")));
                } else {
                    C0260s1.m686c(3, f770b, "Replacing param event_time_millis with empty string");
                    str = str.replace(a, str2);
                }
            }
            a = mo361a(str);
        }
        return str;
    }
}
