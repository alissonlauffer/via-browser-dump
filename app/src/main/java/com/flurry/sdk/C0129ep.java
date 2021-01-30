package com.flurry.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailability;
import java.io.File;
import java.util.regex.Pattern;

/* renamed from: com.flurry.sdk.ep */
public class C0129ep {

    /* renamed from: a */
    public static final String f393a = "ep";

    /* renamed from: com.flurry.sdk.ep$a */
    public enum EnumC0130a {
        UNKNOWN((byte) -1),
        ACTIVE((byte) 0),
        INACTIVE((byte) 1),
        BACKGROUND((byte) 2);
        

        /* renamed from: e */
        public byte f399e;

        private EnumC0130a(byte b) {
            this.f399e = b;
        }
    }

    /* renamed from: com.flurry.sdk.ep$b */
    public enum EnumC0131b {
        UNAVAILABLE(-2),
        UNKNOWN(-1),
        SUCCESS(0),
        SERVICE_MISSING(1),
        SERVICE_UPDATING(2),
        SERVICE_VERSION_UPDATE_REQUIRED(3),
        SERVICE_DISABLED(4),
        SERVICE_INVALID(5);
        

        /* renamed from: i */
        public int f409i;

        private EnumC0131b(int i) {
            this.f409i = i;
        }
    }

    /* renamed from: a */
    public static EnumC0131b m409a(Context context) {
        try {
            int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
            if (isGooglePlayServicesAvailable == 0) {
                return EnumC0131b.SUCCESS;
            }
            if (isGooglePlayServicesAvailable == 1) {
                return EnumC0131b.SERVICE_MISSING;
            }
            if (isGooglePlayServicesAvailable == 2) {
                return EnumC0131b.SERVICE_VERSION_UPDATE_REQUIRED;
            }
            if (isGooglePlayServicesAvailable == 3) {
                return EnumC0131b.SERVICE_DISABLED;
            }
            if (isGooglePlayServicesAvailable == 9) {
                return EnumC0131b.SERVICE_INVALID;
            }
            if (isGooglePlayServicesAvailable != 18) {
                return EnumC0131b.UNAVAILABLE;
            }
            return EnumC0131b.SERVICE_UPDATING;
        } catch (Exception | NoClassDefFoundError unused) {
            C0260s1.m688e(f393a, "Error retrieving Google Play Services Availability. This probably means google play services is unavailable.");
            return EnumC0131b.UNAVAILABLE;
        }
    }

    /* renamed from: b */
    public static String m410b(File file, String str) {
        String str2 = str + ".fcb";
        String[] c = C0318y2.m876c(file, Pattern.compile(".*" + Pattern.quote(str2) + ".*"));
        if (c.length > 0) {
            return c[0];
        }
        return null;
    }

    /* renamed from: c */
    public static String m411c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\.");
        if (split.length != 5) {
            return null;
        }
        return split[3];
    }

    /* renamed from: d */
    public static String m412d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("\\.");
        if (split.length != 5) {
            return null;
        }
        return split[4];
    }
}
