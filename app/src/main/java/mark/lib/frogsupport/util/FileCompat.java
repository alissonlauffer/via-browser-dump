package mark.lib.frogsupport.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/* renamed from: mark.lib.frogsupport.p.b */
/* compiled from: FileCompat */
public class FileCompat {
    @TargetApi(19)
    /* renamed from: a */
    public static void m1347a(Activity activity, String str, String str2, int i) {
        if (Build.VERSION.SDK_INT >= 19 && str != null && !str.isEmpty() && str2 != null && !str2.isEmpty()) {
            Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType(str2);
            intent.putExtra("android.intent.extra.TITLE", str);
            try {
                activity.startActivityForResult(intent, i);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private static boolean m1348b(Context context, String str, Bitmap bitmap) {
        boolean z = false;
        if (!(bitmap == null || str == null || str.isEmpty())) {
            File file = new File(str);
            if (!file.exists() || file.delete()) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream)) {
                        fileOutputStream.flush();
                        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                        intent.setData(Uri.fromFile(file));
                        context.sendBroadcast(intent);
                        z = true;
                    }
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    bitmap.recycle();
                    throw th;
                }
                bitmap.recycle();
                return z;
            }
        }
        return false;
    }

    /* renamed from: c */
    private static boolean m1349c(Context context, String str, String str2, Bitmap bitmap) {
        if (Build.VERSION.SDK_INT < 29 || context == null || str == null || bitmap == null) {
            return false;
        }
        Log.d("FileCompat", "downloading...");
        if (str2 == null) {
            str2 = "*/*";
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", str2);
        contentValues.put("relative_path", "Download/");
        Log.d("FileCompat", contentValues.toString());
        Uri uri = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = context.getContentResolver();
        Uri insert = contentResolver.insert(uri, contentValues);
        if (insert == null) {
            return false;
        }
        Log.d("FileCompat", insert.toString());
        try {
            OutputStream openOutputStream = contentResolver.openOutputStream(insert);
            if (openOutputStream == null) {
                bitmap.recycle();
                IOUtils.m1362a(openOutputStream);
                return false;
            }
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, openOutputStream);
            bitmap.recycle();
            IOUtils.m1362a(openOutputStream);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            bitmap.recycle();
            IOUtils.m1362a(null);
        } catch (Throwable th) {
            bitmap.recycle();
            IOUtils.m1362a(null);
            throw th;
        }
    }

    /* renamed from: d */
    public static InputStream m1350d(Context context, Uri uri) {
        if (context == null || uri == null) {
            return null;
        }
        try {
            return context.getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    public static OutputStream m1351e(Context context, Uri uri) {
        if (context == null || uri == null) {
            return null;
        }
        try {
            return context.getContentResolver().openOutputStream(uri);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: f */
    public static boolean m1352f(Context context, String str, String str2, String str3) {
        int indexOf;
        if (context != null && str != null && str.startsWith("data:image/") && (indexOf = str.indexOf(";base64,")) >= 0) {
            String substring = str.substring(4, indexOf);
            String trim = str.substring(indexOf + 8).trim();
            Bitmap bitmap = null;
            boolean z = true;
            if (str3 == null || str3.isEmpty()) {
                str3 = UUID.randomUUID() + "." + substring.substring(substring.indexOf(47) + 1);
            }
            try {
                Log.d("FileCompat", trim);
                byte[] decode = Base64.decode(trim, 0);
                bitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            } catch (Exception unused) {
            }
            StringBuilder sb = new StringBuilder();
            sb.append("bitmap is null: ");
            if (bitmap != null) {
                z = false;
            }
            sb.append(z);
            Log.d("FileCompat", sb.toString());
            if (Build.VERSION.SDK_INT >= 29) {
                Log.d("FileCompat", "download bitmap with android Q");
                return m1349c(context, str3, substring, bitmap);
            }
            Log.d("FileCompat", "download bitmap");
            if (str2 != null) {
                File file = new File(str2);
                if (!file.exists() && !file.mkdirs()) {
                    return false;
                }
                return m1348b(context, str2 + str3, bitmap);
            }
        }
        return false;
    }

    /* renamed from: g */
    public static void m1353g(Activity activity, String str, int i) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(str);
        try {
            activity.startActivityForResult(intent, i);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
        }
    }
}
