package mark.via.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvider extends ContentProvider {

    /* renamed from: b */
    private static final String[] f1554b = {"_display_name", "_size"};

    /* renamed from: c */
    private static final File f1555c = new File("/");

    /* renamed from: d */
    private static HashMap<String, AbstractC0507a> f1556d = new HashMap<>();

    /* renamed from: a */
    private AbstractC0507a f1557a;

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.provider.FileProvider$a */
    public interface AbstractC0507a {
        /* renamed from: a */
        File mo1335a(Uri uri);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: mark.via.provider.FileProvider$b */
    public static class C0508b implements AbstractC0507a {

        /* renamed from: a */
        private final HashMap<String, File> f1558a = new HashMap<>();

        C0508b(String str) {
        }

        @Override // mark.via.provider.FileProvider.AbstractC0507a
        /* renamed from: a */
        public File mo1335a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int indexOf = encodedPath.indexOf(47, 1);
            String decode = Uri.decode(encodedPath.substring(1, indexOf));
            String decode2 = Uri.decode(encodedPath.substring(indexOf + 1));
            File file = this.f1558a.get(decode);
            if (file != null) {
                File file2 = new File(file, decode2);
                try {
                    File canonicalFile = file2.getCanonicalFile();
                    if (canonicalFile.getPath().startsWith(file.getPath())) {
                        return canonicalFile;
                    }
                    throw new SecurityException("Resolved path jumped beyond configured root");
                } catch (IOException unused) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
                }
            } else {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo1336b(String str, File file) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.f1558a.put(str, file.getCanonicalFile());
                } catch (IOException e) {
                    throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e);
                }
            } else {
                throw new IllegalArgumentException("Name must not be empty");
            }
        }
    }

    /* renamed from: a */
    private static File m2257a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    /* renamed from: b */
    private static Object[] m2258b(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, i);
        return objArr2;
    }

    /* renamed from: c */
    private static String[] m2259c(String[] strArr, int i) {
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
    }

    /* renamed from: d */
    public static File[] m2260d(Context context) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalCacheDirs() : new File[]{context.getExternalCacheDir()};
    }

    /* renamed from: e */
    public static File[] m2261e(Context context, String str) {
        return Build.VERSION.SDK_INT >= 19 ? context.getExternalFilesDirs(str) : new File[]{context.getExternalFilesDir(str)};
    }

    /* renamed from: f */
    private static AbstractC0507a m2262f(Context context, String str) {
        AbstractC0507a aVar;
        synchronized (f1556d) {
            aVar = f1556d.get(str);
            if (aVar == null) {
                try {
                    aVar = m2264h(context, str);
                    f1556d.put(str, aVar);
                } catch (IOException e) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e);
                } catch (XmlPullParserException e2) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e2);
                }
            }
        }
        return aVar;
    }

    /* renamed from: g */
    private static int m2263g(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    /* renamed from: h */
    private static AbstractC0507a m2264h(Context context, String str) {
        C0508b bVar = new C0508b(str);
        XmlResourceParser loadXmlMetaData = context.getPackageManager().resolveContentProvider(str, 128).loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
        if (loadXmlMetaData != null) {
            while (true) {
                int next = loadXmlMetaData.next();
                if (next == 1) {
                    return bVar;
                }
                if (next == 2) {
                    String name = loadXmlMetaData.getName();
                    File file = null;
                    String attributeValue = loadXmlMetaData.getAttributeValue(null, "name");
                    String attributeValue2 = loadXmlMetaData.getAttributeValue(null, "path");
                    if ("root-path".equals(name)) {
                        file = f1555c;
                    } else if ("files-path".equals(name)) {
                        file = context.getFilesDir();
                    } else if ("cache-path".equals(name)) {
                        file = context.getCacheDir();
                    } else if ("external-path".equals(name)) {
                        file = Environment.getExternalStorageDirectory();
                    } else if ("external-files-path".equals(name)) {
                        File[] e = m2261e(context, null);
                        if (e.length > 0) {
                            file = e[0];
                        }
                    } else if ("external-cache-path".equals(name)) {
                        File[] d = m2260d(context);
                        if (d.length > 0) {
                            file = d[0];
                        }
                    } else if (Build.VERSION.SDK_INT >= 21 && "external-media-path".equals(name)) {
                        File[] externalMediaDirs = context.getExternalMediaDirs();
                        if (externalMediaDirs.length > 0) {
                            file = externalMediaDirs[0];
                        }
                    }
                    if (file != null) {
                        bVar.mo1336b(attributeValue, m2257a(file, attributeValue2));
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        } else if (providerInfo.grantUriPermissions) {
            this.f1557a = m2262f(context, providerInfo.authority);
        } else {
            throw new SecurityException("Provider must grant uri permissions");
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return this.f1557a.mo1335a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        String mimeTypeFromExtension;
        File a = this.f1557a.mo1335a(uri);
        int lastIndexOf = a.getName().lastIndexOf(46);
        return (lastIndexOf < 0 || (mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(a.getName().substring(lastIndexOf + 1))) == null) ? "application/octet-stream" : mimeTypeFromExtension;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) {
        return ParcelFileDescriptor.open(this.f1557a.mo1335a(uri), m2263g(str));
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i;
        File a = this.f1557a.mo1335a(uri);
        if (strArr == null) {
            strArr = f1554b;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i2 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i2] = "_display_name";
                i = i2 + 1;
                objArr[i2] = a.getName();
            } else if ("_size".equals(str3)) {
                strArr3[i2] = "_size";
                i = i2 + 1;
                objArr[i2] = Long.valueOf(a.length());
            }
            i2 = i;
        }
        String[] c = m2259c(strArr3, i2);
        Object[] b = m2258b(objArr, i2);
        MatrixCursor matrixCursor = new MatrixCursor(c, 1);
        matrixCursor.addRow(b);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}
