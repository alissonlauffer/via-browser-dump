package mark.via.util;

import a.a.b.p.d;
import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileIntentUtils */
public class g {
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004d A[SYNTHETIC, Splitter:B:32:0x004d] */
    public static String a(Context context, Uri uri, String str) {
        String scheme;
        InputStream inputStream;
        String str2 = null;
        str2 = null;
        InputStream inputStream2 = null;
        str2 = null;
        str2 = null;
        str2 = null;
        str2 = null;
        if (!(uri == null || (scheme = uri.getScheme()) == null)) {
            if (!"content".equals(scheme)) {
                return uri.toString();
            }
            if (uri.getAuthority() != null) {
                try {
                    inputStream = context.getContentResolver().openInputStream(uri);
                    try {
                        File a2 = a(context, inputStream, str);
                        if (a2 != null) {
                            str2 = a2.getPath();
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e) {
                                d.a(e);
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            d.a(e);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return str2;
                        } catch (Throwable th) {
                            th = th;
                            inputStream2 = inputStream;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e3) {
                                    d.a(e3);
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    inputStream = null;
                    d.a(e);
                    if (inputStream != null) {
                    }
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    if (inputStream2 != null) {
                    }
                    throw th;
                }
            }
        }
        return str2;
    }

    private static File a(Context context, InputStream inputStream, String str) {
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
}
