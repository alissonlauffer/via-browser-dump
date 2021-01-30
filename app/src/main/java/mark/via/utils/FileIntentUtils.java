package mark.via.utils;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import timber.log.Timber;

/* renamed from: mark.via.n.k */
/* compiled from: FileIntentUtils */
public class FileIntentUtils {
    /* renamed from: a */
    public static File m2140a(Context context, InputStream inputStream, String str) {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[8192];
        File externalFilesDir = context.getExternalFilesDir("content");
        if (externalFilesDir == null || (!externalFilesDir.exists() && !externalFilesDir.mkdir())) {
            externalFilesDir = new File(context.getFilesDir(), "content/");
            if (!externalFilesDir.exists() && !externalFilesDir.mkdir()) {
                return null;
            }
        }
        File file = new File(externalFilesDir, str);
        if (file.exists() && !file.delete()) {
            return null;
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            fileOutputStream.write(bArr, 0, read);
        }
        fileOutputStream.flush();
        try {
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003a A[SYNTHETIC, Splitter:B:27:0x003a] */
    /* renamed from: b */
    public static String m2141b(Context context, Uri uri, String str) {
        Throwable th;
        InputStream inputStream;
        Exception e;
        String str2 = null;
        str2 = null;
        InputStream inputStream2 = null;
        str2 = null;
        str2 = null;
        if (uri == null) {
            return null;
        }
        if (uri.getAuthority() != null) {
            try {
                inputStream = context.getContentResolver().openInputStream(uri);
                try {
                    File a = m2140a(context, inputStream, str);
                    if (a != null) {
                        str2 = a.getPath();
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                            Timber.m973c(e2);
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        Timber.m973c(e);
                        if (inputStream != null) {
                        }
                        return str2;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e4) {
                                Timber.m973c(e4);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                inputStream = null;
                Timber.m973c(e);
                if (inputStream != null) {
                    inputStream.close();
                }
                return str2;
            } catch (Throwable th3) {
                th = th3;
                if (inputStream2 != null) {
                }
                throw th;
            }
        }
        return str2;
    }
}
