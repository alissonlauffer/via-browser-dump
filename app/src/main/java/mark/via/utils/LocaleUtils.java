package mark.via.utils;

import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.List;

/* renamed from: mark.via.n.q */
/* compiled from: LocaleUtils */
public class LocaleUtils {
    /* renamed from: a */
    public static List<String> m2184a() {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList locales = Resources.getSystem().getConfiguration().getLocales();
            int size = locales.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(locales.get(i).getLanguage());
            }
        } else {
            arrayList.add(Resources.getSystem().getConfiguration().locale.getLanguage());
        }
        return arrayList;
    }
}
