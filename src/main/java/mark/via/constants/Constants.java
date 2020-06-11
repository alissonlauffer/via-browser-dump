package mark.via.constants;

import android.os.Build;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Locale;
import mark.via.utils.AppUtils;

/* renamed from: mark.via.d.a */
/* compiled from: Constants */
public final class Constants {

    /* renamed from: a */
    public static final Locale f1296a;

    /* renamed from: b */
    public static final String f1297b;

    /* renamed from: c */
    public static final String f1298c;

    /* renamed from: d */
    public static final Charset f1299d = Charset.forName("UTF-8");

    /* renamed from: e */
    public static final String f1300e = Charset.forName("UTF-8").name();

    /* renamed from: f */
    public static final int f1301f = Build.VERSION.SDK_INT;

    /* renamed from: g */
    public static final String f1302g = (AppUtils.m2060h() ? "https://m.baidu.com/?tn=&from=1009664u" : "https://www.google.com/");

    /* renamed from: h */
    public static final SimpleDateFormat f1303h;

    static {
        Locale locale = Locale.getDefault();
        f1296a = locale;
        f1297b = locale.getCountry();
        f1298c = locale.getLanguage();
        f1303h = new SimpleDateFormat("HH:mm:ss", locale);
    }
}
