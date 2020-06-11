package mark.via.b;

import android.os.Build;
import android.os.Environment;
import android.webkit.WebResourceResponse;
import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: Constants */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Locale f245a;
    public static final String b;
    public static final String c = f245a.getLanguage();
    public static final Charset d = Charset.forName("UTF-8");
    public static final String e = Charset.forName("UTF-8").name();
    public static final Object f = (Build.VERSION.SDK_INT >= 11 ? new WebResourceResponse("text/plain", e, new ByteArrayInputStream("".getBytes(d))) : null);
    public static final int g = Build.VERSION.SDK_INT;
    public static final String h = (mark.via.util.a.c() ? "https://m.baidu.com/?tn=&from=1009664u" : "https://www.google.com/");
    public static final String i = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final SimpleDateFormat j = new SimpleDateFormat("HH:mm:ss", f245a);

    static {
        Locale locale = Locale.getDefault();
        f245a = locale;
        b = locale.getCountry();
    }
}
