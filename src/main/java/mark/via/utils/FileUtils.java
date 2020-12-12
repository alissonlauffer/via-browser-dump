package mark.via.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mark.via.constants.Constants;

/* renamed from: mark.via.n.m */
/* compiled from: FileUtils */
public final class FileUtils {
    /* renamed from: a */
    public static boolean m2145a(File file) {
        String[] list;
        if (file != null && file.isDirectory() && (list = file.list()) != null && list.length > 0) {
            for (String str : list) {
                if (!m2145a(new File(file, str))) {
                    return false;
                }
            }
        }
        if (file == null || !file.delete()) {
            return false;
        }
        return true;
    }

    /* renamed from: b */
    public static String m2146b(Context context) {
        return m2153i(context, "backup");
    }

    /* renamed from: c */
    public static String m2147c(Context context) {
        return m2155k(context, "custom.txt");
    }

    /* renamed from: d */
    public static String m2148d() {
        return m2149e(null);
    }

    /* renamed from: e */
    public static String m2149e(String str) {
        String str2;
        if (Build.VERSION.SDK_INT >= 29) {
            str2 = "/sdcard/";
        } else {
            str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
        }
        if (str == null || str.isEmpty()) {
            return str2;
        }
        return str2 + str;
    }

    /* renamed from: f */
    public static List<String> m2150f(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null && !str.isEmpty()) {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else if (!readLine.isEmpty()) {
                            arrayList.add(readLine);
                        }
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    fileInputStream.close();
                } catch (IOException unused) {
                }
            }
        }
        return arrayList;
    }

    /* renamed from: g */
    public static long m2151g(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return new File(str).lastModified();
    }

    /* renamed from: h */
    public static String m2152h(String str, String str2, String str3) {
        if (!str2.endsWith("/")) {
            str2 = str2 + "/";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Constants.f1296a);
        Date date = new Date(System.currentTimeMillis());
        String str4 = str + "_" + simpleDateFormat.format(date);
        File file = new File(str2);
        boolean exists = file.exists();
        if (!exists) {
            exists = file.mkdirs();
        }
        String str5 = str2 + str4 + str3;
        if (exists) {
            File file2 = new File(str5);
            int i = 0;
            while (file2.exists()) {
                i++;
                str5 = str2 + str4 + "_" + i + str3;
                file2 = new File(str5);
            }
        }
        return str5;
    }

    /* renamed from: i */
    public static String m2153i(Context context, String str) {
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir == null) {
            externalFilesDir = new File(context.getFilesDir(), str);
        }
        if (externalFilesDir.exists() || externalFilesDir.mkdirs()) {
            return externalFilesDir.toString();
        }
        return null;
    }

    /* renamed from: j */
    public static String m2154j(Context context, String str, String str2) {
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir == null) {
            externalFilesDir = new File(context.getFilesDir(), str);
        }
        if (externalFilesDir.exists() || externalFilesDir.mkdirs()) {
            return new File(externalFilesDir, str2).toString();
        }
        return null;
    }

    /* renamed from: k */
    public static String m2155k(Context context, String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return m2154j(context, "filters", str);
    }

    /* renamed from: l */
    public static String m2156l(Context context, Uri uri) {
        if (uri == null) {
            return "";
        }
        if (uri.toString().startsWith("file://")) {
            String uri2 = uri.toString();
            return uri2.substring(uri2.indexOf("file://") + 7);
        } else if (Build.VERSION.SDK_INT < 19 || !DocumentsContract.isDocumentUri(context, uri)) {
            return m2158n(context, uri);
        } else {
            return m2157m(context, uri);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @TargetApi(19)
    /* renamed from: m */
    private static String m2157m(Context context, Uri uri) {
        String str;
        try {
            String[] strArr = {"_data"};
            Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, "_id=?", new String[]{DocumentsContract.getDocumentId(uri).split(":")[1]}, null);
            if (query != null) {
                try {
                    int columnIndexOrThrow = query.getColumnIndexOrThrow(strArr[0]);
                    if (query.moveToFirst()) {
                        str = query.getString(columnIndexOrThrow);
                    } else {
                        str = "";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    query.close();
                }
                if (str != null) {
                    return "";
                }
                return str;
            }
            str = "";
            if (str != null) {
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* renamed from: n */
    private static String m2158n(Context context, Uri uri) {
        String str;
        String[] strArr = {"_data"};
        Cursor query = context.getContentResolver().query(uri, strArr, null, null, null);
        if (query != null) {
            try {
                query.moveToFirst();
                str = query.getString(query.getColumnIndex(strArr[0]));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                query.close();
            }
            if (str != null) {
                return "";
            }
            return str;
        }
        str = "";
        if (str != null) {
        }
    }

    /* renamed from: o */
    public static String m2159o(Context context) {
        return m2153i(context, "offline");
    }

    /* renamed from: p */
    public static boolean m2160p(Context context, String str) {
        if (!context.getFilesDir().exists()) {
            return false;
        }
        return new File(context.getFilesDir(), str).exists();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002d A[SYNTHETIC, Splitter:B:20:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* renamed from: q */
    public static void m2161q(String str, File file) {
        Throwable th;
        Exception e;
        OutputStreamWriter outputStreamWriter = null;
        try {
            OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file), Constants.f1299d);
            try {
                outputStreamWriter2.write(str);
                try {
                    outputStreamWriter2.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                outputStreamWriter = outputStreamWriter2;
                try {
                    e.printStackTrace();
                    if (outputStreamWriter == null) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (outputStreamWriter != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStreamWriter = outputStreamWriter2;
                if (outputStreamWriter != null) {
                    try {
                        outputStreamWriter.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e5) {
            e = e5;
            e.printStackTrace();
            if (outputStreamWriter == null) {
                outputStreamWriter.close();
            }
        }
    }
}
