package mark.lib.frogsupport.util;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: mark.lib.frogsupport.p.d */
/* compiled from: IOUtils */
public class IOUtils {
    /* renamed from: a */
    public static void m1362a(Closeable... closeableArr) {
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
