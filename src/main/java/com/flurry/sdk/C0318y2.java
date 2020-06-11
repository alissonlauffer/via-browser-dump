package com.flurry.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* renamed from: com.flurry.sdk.y2 */
public final class C0318y2 {

    /* renamed from: a */
    private static String f872a = "y2";

    /* renamed from: com.flurry.sdk.y2$a */
    class C0319a implements FilenameFilter {

        /* renamed from: a */
        final /* synthetic */ Pattern f873a;

        C0319a(Pattern pattern) {
            this.f873a = pattern;
        }

        public final boolean accept(File file, String str) {
            return this.f873a.matcher(str).matches();
        }
    }

    @TargetApi(21)
    /* renamed from: a */
    public static File m874a() {
        File file;
        Context context = C0118e1.m386a().f361a;
        if (C0328z2.m891f(21)) {
            file = context.getNoBackupFilesDir();
        } else {
            file = new File(context.getFilesDir().getPath() + File.separator + "no_backup");
        }
        return new File(file.getPath() + File.separator + ".flurryNoBackup");
    }

    /* renamed from: b */
    public static boolean m875b(File file) {
        if (file == null || file.getAbsoluteFile() == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.mkdirs() || parentFile.isDirectory()) {
            return true;
        }
        C0260s1.m686c(6, f872a, "Unable to create persistent dir: ".concat(String.valueOf(parentFile)));
        return false;
    }

    /* renamed from: c */
    public static String[] m876c(File file, Pattern pattern) {
        if (!file.exists()) {
            return new String[0];
        }
        String[] list = file.list(new C0319a(pattern));
        return list == null ? new String[0] : list;
    }

    /* renamed from: d */
    public static boolean m877d(File file) {
        if (file == null || !file.isDirectory()) {
            return false;
        }
        for (String str : file.list()) {
            if (!m877d(new File(file, str))) {
                return false;
            }
        }
        return file.delete();
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b A[RETURN] */
    /* renamed from: e */
    public static String m878e(File file) {
        StringBuilder sb;
        Throwable th;
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            C0260s1.m686c(4, f872a, "Persistent file doesn't exist.");
            return null;
        }
        C0260s1.m686c(4, f872a, "Loading persistent data: " + file.getAbsolutePath());
        try {
            fileInputStream = new FileInputStream(file);
            try {
                sb = new StringBuilder();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                }
                C0328z2.m890e(fileInputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    C0260s1.m687d(6, f872a, "Error when loading persistent file", th);
                    C0328z2.m890e(fileInputStream);
                    sb = null;
                    if (sb != null) {
                    }
                } catch (Throwable th3) {
                    C0328z2.m890e(fileInputStream);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            fileInputStream = null;
            C0260s1.m687d(6, f872a, "Error when loading persistent file", th);
            C0328z2.m890e(fileInputStream);
            sb = null;
            if (sb != null) {
            }
        }
        if (sb != null) {
            return sb.toString();
        }
        return null;
    }
}
