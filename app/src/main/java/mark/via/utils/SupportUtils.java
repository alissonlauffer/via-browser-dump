package mark.via.utils;

import android.content.Context;
import mark.lib.frogsupport.checker.DataChecker;
import mark.lib.frogsupport.util.QuickUtils;

/* renamed from: mark.via.n.w */
/* compiled from: SupportUtils */
public class SupportUtils {
    /* renamed from: a */
    public static void m2195a(Context context, String str, int i) {
        m2196b(context, str, context.getString(i));
    }

    /* renamed from: b */
    public static void m2196b(Context context, String str, String str2) {
        QuickUtils.m1371c(context, str, str2);
        DataChecker.m1181c().mo666g(1, str);
    }
}
