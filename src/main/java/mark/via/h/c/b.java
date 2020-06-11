package mark.via.h.c;

import java.io.File;
import java.util.UUID;

/* compiled from: FileUtil */
public class b {
    public static String a(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.isEmpty() || str2 == null) {
            return null;
        }
        String trim2 = str2.trim();
        if (trim2.isEmpty()) {
            return null;
        }
        File file = new File(trim);
        if (!file.exists() && !file.mkdirs()) {
            return null;
        }
        if (str3 == null) {
            str3 = "";
        }
        File file2 = new File(trim, trim2 + str3);
        int i = 1;
        while (file2.exists()) {
            file2 = new File(trim, trim2 + "_" + i + str3);
            i++;
        }
        return file2.getAbsolutePath();
    }

    public static String b(String str) {
        return str == null ? UUID.randomUUID().toString() : str.replaceAll("[\\\\/:*?\"<>|]", "");
    }

    public static boolean a(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        File file = new File(str);
        if (!file.isFile() || !file.exists() || !file.delete()) {
            return false;
        }
        return true;
    }
}
