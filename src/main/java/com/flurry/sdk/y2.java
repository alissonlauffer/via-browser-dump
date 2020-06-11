package com.flurry.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public final class y2 {

    /* renamed from: a  reason: collision with root package name */
    private static String f222a = "y2";

    class a implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Pattern f223a;

        a(Pattern pattern) {
            this.f223a = pattern;
        }

        public final boolean accept(File file, String str) {
            return this.f223a.matcher(str).matches();
        }
    }

    @TargetApi(21)
    public static File a() {
        File file;
        Context context = e1.a().f110a;
        if (z2.a(21)) {
            file = context.getNoBackupFilesDir();
        } else {
            file = new File(context.getFilesDir().getPath() + File.separator + "no_backup");
        }
        return new File(file.getPath() + File.separator + ".flurryNoBackup");
    }

    public static boolean b(File file) {
        if (file == null || !file.isDirectory()) {
            return false;
        }
        for (String str : file.list()) {
            if (!b(new File(file, str))) {
                return false;
            }
        }
        return file.delete();
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b A[RETURN] */
    public static String c(File file) {
        StringBuilder sb;
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            s1.a(4, f222a, "Persistent file doesn't exist.");
            return null;
        }
        s1.a(4, f222a, "Loading persistent data: " + file.getAbsolutePath());
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
                z2.a((Closeable) fileInputStream);
            } catch (Throwable th) {
                th = th;
                try {
                    s1.a(6, f222a, "Error when loading persistent file", th);
                    z2.a((Closeable) fileInputStream);
                    sb = null;
                    if (sb != null) {
                    }
                } catch (Throwable th2) {
                    z2.a((Closeable) fileInputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            s1.a(6, f222a, "Error when loading persistent file", th);
            z2.a((Closeable) fileInputStream);
            sb = null;
            if (sb != null) {
            }
        }
        if (sb != null) {
            return sb.toString();
        }
        return null;
    }

    public static boolean a(File file) {
        if (file == null || file.getAbsoluteFile() == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.mkdirs() || parentFile.isDirectory()) {
            return true;
        }
        s1.a(6, f222a, "Unable to create persistent dir: ".concat(String.valueOf(parentFile)));
        return false;
    }

    public static String[] a(File file, Pattern pattern) {
        if (!file.exists()) {
            return new String[0];
        }
        String[] list = file.list(new a(pattern));
        return list == null ? new String[0] : list;
    }
}
