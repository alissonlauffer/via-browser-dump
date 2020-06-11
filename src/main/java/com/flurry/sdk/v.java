package com.flurry.sdk;

import android.location.Location;
import java.util.Map;

public class v extends x1 {
    private static final String b = "v";

    /* JADX WARN: Type inference failed for: r8v0, types: [com.flurry.sdk.v, com.flurry.sdk.x1] */
    public final String a(String str, Map<String, String> map) {
        String a2 = a(str);
        while (a2 != null) {
            if (x1.a("timestamp_epoch_millis", a2)) {
                String valueOf = String.valueOf(System.currentTimeMillis());
                s1.a(3, b, "Replacing param timestamp_epoch_millis with: ".concat(String.valueOf(valueOf)));
                str = str.replace(a2, z2.c(valueOf));
            } else if (x1.a("session_duration_millis", a2)) {
                q0.a();
                String l = Long.toString(q0.e());
                s1.a(3, b, "Replacing param session_duration_millis with: ".concat(String.valueOf(l)));
                str = str.replace(a2, z2.c(l));
            } else if (x1.a("fg_timespent_millis", a2)) {
                q0.a();
                String l2 = Long.toString(q0.e());
                s1.a(3, b, "Replacing param fg_timespent_millis with: ".concat(String.valueOf(l2)));
                str = str.replace(a2, z2.c(l2));
            } else {
                String str2 = "";
                if (x1.a("install_referrer", a2)) {
                    String b2 = new a4().b();
                    if (b2 != null) {
                        str2 = b2;
                    }
                    s1.a(3, b, "Replacing param install_referrer with: ".concat(String.valueOf(str2)));
                    str = str.replace(a2, z2.c(str2));
                } else if (x1.a("geo_latitude", a2)) {
                    Location c = v0.d().c();
                    if (c != null) {
                        int f = v0.f();
                        str2 = str2 + z2.a(c.getLatitude(), f);
                    }
                    s1.a(3, b, "Replacing param geo_latitude with: ".concat(String.valueOf(str2)));
                    str = str.replace(a2, z2.c(str2));
                } else if (x1.a("geo_longitude", a2)) {
                    Location c2 = v0.d().c();
                    if (c2 != null) {
                        int f2 = v0.f();
                        str2 = str2 + z2.a(c2.getLongitude(), f2);
                    }
                    s1.a(3, b, "Replacing param geo_longitude with: ".concat(String.valueOf(str2)));
                    str = str.replace(a2, z2.c(str2));
                } else if (x1.a("publisher_user_id", a2)) {
                    String str3 = (String) t2.a().a("UserId");
                    s1.a(3, b, "Replacing param publisher_user_id with: ".concat(String.valueOf(str3)));
                    str = str.replace(a2, z2.c(str3));
                } else if (x1.a("event_name", a2)) {
                    if (map.containsKey("event_name")) {
                        s1.a(3, b, "Replacing param event_name with: " + map.get("event_name"));
                        str = str.replace(a2, z2.c(map.get("event_name")));
                    } else {
                        s1.a(3, b, "Replacing param event_name with empty string");
                        str = str.replace(a2, str2);
                    }
                } else if (!x1.a("event_time_millis", a2)) {
                    s1.a(3, b, "Unknown param: ".concat(String.valueOf(a2)));
                    str = str.replace(a2, str2);
                } else if (map.containsKey("event_time_millis")) {
                    s1.a(3, b, "Replacing param event_time_millis with: " + map.get("event_time_millis"));
                    str = str.replace(a2, z2.c(map.get("event_time_millis")));
                } else {
                    s1.a(3, b, "Replacing param event_time_millis with empty string");
                    str = str.replace(a2, str2);
                }
            }
            a2 = a(str);
        }
        return str;
    }
}
