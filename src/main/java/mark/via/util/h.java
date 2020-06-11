package mark.via.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import mark.via.b.a;

/* compiled from: FileUtils */
public final class h {
    public static String a(Context context, Uri uri) {
        if (uri == null) {
            return null;
        }
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            try {
                Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                if (query.moveToFirst()) {
                    String string = query.getString(columnIndexOrThrow);
                    query.close();
                    return string;
                }
            } catch (Exception unused) {
            }
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    public static String b(Context context, Uri uri) {
        if (uri == null) {
            return "";
        }
        if (uri.toString().startsWith("file://")) {
            String uri2 = uri.toString();
            return uri2.substring(uri2.indexOf("file://") + 7);
        } else if (Build.VERSION.SDK_INT < 19 || !DocumentsContract.isDocumentUri(context, uri)) {
            return d(context, uri);
        } else {
            return c(context, uri);
        }
    }

    public static String c(File file) {
        String name = file.getName();
        return name.lastIndexOf(".") != -1 ? name.substring(name.lastIndexOf(".")) : "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    private static String d(Context context, Uri uri) {
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

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    @TargetApi(19)
    private static String c(Context context, Uri uri) {
        String str;
        String str2 = DocumentsContract.getDocumentId(uri).split(":")[1];
        try {
            String[] strArr = {"_data"};
            Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, strArr, "_id=?", new String[]{str2}, null);
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

    public static String b(File file) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                sb.append(readLine);
                sb.append("\n");
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static boolean a(File file) {
        String[] list;
        if (file != null && file.isDirectory() && (list = file.list()) != null && list.length > 0) {
            for (String str : list) {
                if (!a(new File(file, str))) {
                    return false;
                }
            }
        }
        if (file == null || !file.delete()) {
            return false;
        }
        return true;
    }

    public static boolean a(Context context, String str) {
        if (!context.getFilesDir().exists()) {
            return false;
        }
        return new File(context.getFilesDir(), str).exists();
    }

    public static String a(String str, String str2, String str3) {
        if (!str2.endsWith("/")) {
            str2 = str2 + "/";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", a.f245a);
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

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002d A[SYNTHETIC, Splitter:B:20:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    public static void a(String str, File file) {
        OutputStreamWriter outputStreamWriter = null;
        try {
            OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file), a.d);
            try {
                outputStreamWriter2.write(str);
                try {
                    outputStreamWriter2.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e = e2;
                outputStreamWriter = outputStreamWriter2;
                try {
                    e.printStackTrace();
                    if (outputStreamWriter == null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    if (outputStreamWriter != null) {
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStreamWriter = outputStreamWriter2;
                if (outputStreamWriter != null) {
                    try {
                        outputStreamWriter.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            e.printStackTrace();
            if (outputStreamWriter == null) {
                outputStreamWriter.close();
            }
        }
    }
}
