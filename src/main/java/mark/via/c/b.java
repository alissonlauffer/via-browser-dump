package mark.via.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import mark.via.a.d;
import mark.via.gp.R;
import mark.via.util.i;
import mark.via.util.o;

/* compiled from: DatabaseHandler */
public class b extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static SQLiteDatabase f247a;
    private static volatile b b;
    private static final Comparator<mark.via.a.b> c = new a();
    private static final Comparator<mark.via.a.b> d = new C0027b();

    /* compiled from: DatabaseHandler */
    class a implements Comparator<mark.via.a.b> {
        a() {
        }

        /* renamed from: a */
        public int compare(mark.via.a.b bVar, mark.via.a.b bVar2) {
            int d = bVar.d() - bVar2.d();
            return d == 0 ? bVar.e().toLowerCase(mark.via.b.a.f245a).compareTo(bVar2.e().toLowerCase(mark.via.b.a.f245a)) : d;
        }
    }

    private b(Context context) {
        super(context, "via", (SQLiteDatabase.CursorFactory) null, 4);
        j();
    }

    public static b a(Context context) {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b(context);
                }
            }
        }
        return b;
    }

    private void j() {
        SQLiteDatabase sQLiteDatabase = f247a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            f247a = getWritableDatabase();
        }
    }

    public void b(String str, String str2) {
        j();
        String a2 = o.a(str);
        String a3 = o.a(str2);
        f247a.execSQL("DELETE FROM history" + c("url", a2));
        f247a.execSQL(o.b("history", "(url, title) VALUES ('" + a2 + "', '" + a3 + "')"));
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:8:0x002b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        if (r2 == 0) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r2 == 0) goto L_0x0039;
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    public List<Integer> c() {
        j();
        ArrayList arrayList = new ArrayList();
        ? r2 = 0;
        try {
            r2 = f247a.rawQuery("SELECT addons.oid FROM addons WHERE addons.oid > 0;", r2);
            if (r2 != 0 && r2.moveToFirst()) {
                do {
                    arrayList.add(Integer.valueOf(r2.getInt(0)));
                } while (r2.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        SQLiteDatabase sQLiteDatabase = f247a;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            f247a.close();
        }
        super.close();
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:8:0x003f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        if (r2 == 0) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003f, code lost:
        if (r2 == 0) goto L_0x004d;
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    public List<d> d() {
        j();
        ArrayList arrayList = new ArrayList();
        ? r2 = 0;
        try {
            r2 = f247a.rawQuery("SELECT ads.id, ads.url, ads.tag FROM ads ORDER BY ads.id DESC;", r2);
            if (r2 != 0 && r2.moveToFirst()) {
                do {
                    d dVar = new d();
                    dVar.a(r2.getInt(0));
                    dVar.b(r2.getString(1));
                    dVar.a(r2.getString(2));
                    arrayList.add(dVar);
                } while (r2.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:8:0x004f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0058, code lost:
        if (r2 == 0) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005a, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004f, code lost:
        if (r2 == 0) goto L_0x005d;
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    public List<mark.via.a.b> e() {
        j();
        ArrayList arrayList = new ArrayList();
        ? r2 = 0;
        try {
            r2 = f247a.rawQuery("SELECT * FROM bookmarks;", r2);
            if (r2 != 0 && r2.moveToFirst()) {
                do {
                    mark.via.a.b bVar = new mark.via.a.b();
                    bVar.a(r2.getInt(0));
                    bVar.c(r2.getString(1));
                    bVar.b(r2.getString(2));
                    bVar.a(r2.getString(3));
                    bVar.c(r2.getInt(4));
                    arrayList.add(bVar);
                } while (r2.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
    }

    public void f(String str) {
        j();
        f247a.execSQL("DELETE FROM history" + c("url", str));
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:34:0x00a3 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r6v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006d, code lost:
        if (r4 != null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0077, code lost:
        if (r4 != null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0079, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r6 = mark.via.c.b.f247a.rawQuery("SELECT url,title FROM bookmarks WHERE bookmarks.folder = '' ORDER BY clickTimes;", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0084, code lost:
        if (r6 == 0) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008a, code lost:
        if (r6.moveToFirst() == false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008c, code lost:
        r3.add(new mark.via.a.b(r6.getString(0), r6.getString(1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a1, code lost:
        if (r6.moveToNext() != false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a3, code lost:
        if (r6 == 0) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ac, code lost:
        if (r6 == 0) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ae, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b1, code lost:
        java.util.Collections.sort(r2, mark.via.c.b.c);
        r2.addAll(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b9, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ba, code lost:
        if (r6 != 0) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bc, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00bf, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c4  */
    /* JADX WARNING: Unknown variable types count: 3 */
    public List<mark.via.a.b> g() {
        Cursor cursor;
        String str;
        j();
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ? r6 = 0;
        Cursor cursor2 = null;
        try {
            cursor = f247a.rawQuery("SELECT bookmarks.folder FROM bookmarks WHERE bookmarks.folder != '';", r6);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        do {
                            String string = cursor.getString(0);
                            if (!hashSet.contains(string)) {
                                String str2 = "folder://" + string;
                                try {
                                    str = "folder://" + URLEncoder.encode(string, "utf-8");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                mark.via.a.b bVar = new mark.via.a.b(str, string);
                                hashSet.add(string);
                                arrayList.add(bVar);
                            }
                        } while (cursor.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
            }
        } catch (Exception e3) {
            e = e3;
            cursor = r6;
            e.printStackTrace();
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:6:0x005c */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0065, code lost:
        if (r1 == 0) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0067, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x006a, code lost:
        java.util.Collections.sort(r0, mark.via.c.b.d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006f, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x005c, code lost:
        if (r1 != 0) goto L_0x0067;
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    public List<mark.via.a.b> h(String str) {
        j();
        String a2 = o.a(str);
        ArrayList arrayList = new ArrayList();
        ? r1 = 0;
        try {
            r1 = f247a.rawQuery("SELECT url,title FROM history WHERE " + a("title", "url", a2) + " ORDER BY " + "id" + " DESC LIMIT 25", r1);
            if (r1.moveToLast()) {
                do {
                    arrayList.add(new mark.via.a.b(r1.getString(0), r1.getString(1), (int) R.drawable.ae));
                } while (r1.moveToPrevious());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:6:0x002f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (r2 == 0) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002f, code lost:
        if (r2 != 0) goto L_0x003a;
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    public List<mark.via.a.b> i() {
        j();
        ArrayList arrayList = new ArrayList();
        ? r2 = 0;
        try {
            r2 = f247a.rawQuery("SELECT url,title FROM history ORDER BY id DESC LIMIT 256", r2);
            if (r2.moveToFirst()) {
                do {
                    arrayList.add(new mark.via.a.b(r2.getString(0), r2.getString(1)));
                } while (r2.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:11:0x0091 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0091, code lost:
        if (r1 == 0) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x009a, code lost:
        if (r1 == 0) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009c, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a7, code lost:
        return r0.toString().trim();
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    public String k(String str) {
        j();
        String lowerCase = str.toLowerCase(mark.via.b.a.f245a);
        StringBuilder sb = new StringBuilder();
        ? r1 = 0;
        try {
            r1 = f247a.rawQuery("SELECT addons.url, addons.code FROM addons WHERE addons.url = '" + lowerCase + "' UNION SELECT " + "addons" + "." + "url" + ", " + "addons" + "." + "code" + " FROM " + "addons" + " WHERE " + "addons" + "." + "url" + " = '*';", r1);
            if (r1 != 0 && r1.moveToFirst()) {
                do {
                    String c2 = i.c(r1.getString(1));
                    if (c2.startsWith("javascript:")) {
                        c2 = c2.substring(11).trim();
                    }
                    sb.append(c2);
                } while (r1.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:8:0x0036 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r1 == 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        r4 = r0.trim();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r4.endsWith(",") == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return r4.substring(0, r4.lastIndexOf(","));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
        if (r1 != 0) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        r1.close();
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    public String l(String str) {
        j();
        String str2 = "";
        ? r1 = 0;
        try {
            r1 = f247a.rawQuery("SELECT ads.url, ads.tag FROM ads WHERE ads.url = '" + str.toLowerCase(mark.via.b.a.f245a) + "' LIMIT 1;", r1);
            if (r1 != 0 && r1.moveToFirst()) {
                str2 = r1.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE history(id INTEGER PRIMARY KEY,url TEXT,title TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE ads(id INTEGER PRIMARY KEY,url TEXT,tag TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE addons(id INTEGER PRIMARY KEY,oid INTEGER,name TEXT,author TEXT,url TEXT,info TEXT,code LONGTEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE bookmarks(id INTEGER PRIMARY KEY,url TEXT,title TEXT,folder TEXT,clickTimes INTEGER)");
        sQLiteDatabase.execSQL("CREATE TABLE favorites(f_id INTEGER PRIMARY KEY,f_url TEXT,f_title TEXT,f_order INTEGER)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i <= 3) {
            if (i <= 1) {
                sQLiteDatabase.execSQL("CREATE TABLE addons(id INTEGER PRIMARY KEY,oid INTEGER,name TEXT,author TEXT,url TEXT,info TEXT,code TEXT)");
            }
            if (i <= 2) {
                sQLiteDatabase.execSQL("CREATE TABLE bookmarks(id INTEGER PRIMARY KEY,url TEXT,title TEXT,folder TEXT,clickTimes INTEGER)");
            }
            sQLiteDatabase.execSQL("CREATE TABLE favorites(f_id INTEGER PRIMARY KEY,f_url TEXT,f_title TEXT,f_order INTEGER)");
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:7:0x0053 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005c, code lost:
        if (r1 == 0) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005e, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0061, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0053, code lost:
        if (r1 != 0) goto L_0x005e;
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    public mark.via.a.b j(String str) {
        j();
        mark.via.a.b bVar = new mark.via.a.b();
        ? r1 = 0;
        try {
            r1 = f247a.rawQuery("SELECT * FROM favorites" + c("f_url", str) + " LIMIT 1;", r1);
            if (r1 != 0 && r1.moveToFirst()) {
                bVar.a(r1.getInt(0));
                bVar.c(r1.getString(1));
                bVar.b(r1.getString(2));
                bVar.c(r1.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    /* renamed from: mark.via.c.b$b  reason: collision with other inner class name */
    /* compiled from: DatabaseHandler */
    class C0027b implements Comparator<mark.via.a.b> {
        C0027b() {
        }

        /* renamed from: a */
        public int compare(mark.via.a.b bVar, mark.via.a.b bVar2) {
            int a2 = a(bVar.f()) - a(bVar2.f());
            return a2 == 0 ? bVar.e().toLowerCase(mark.via.b.a.f245a).compareTo(bVar2.e().toLowerCase(mark.via.b.a.f245a)) : a2;
        }

        private int a(String str) {
            int length;
            if (str == null || (length = str.length()) == 0) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < length - 1; i2++) {
                if (str.charAt(i2) == '/') {
                    i++;
                }
            }
            return i;
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:8:0x003f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        if (r2 == 0) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003f, code lost:
        if (r2 == 0) goto L_0x004d;
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    public List<mark.via.a.b> f() {
        j();
        ArrayList arrayList = new ArrayList();
        ? r2 = 0;
        try {
            r2 = f247a.rawQuery("SELECT * FROM favorites ORDER BY favorites.f_order;", r2);
            if (r2 != 0 && r2.moveToFirst()) {
                do {
                    mark.via.a.b bVar = new mark.via.a.b();
                    bVar.c(r2.getString(1));
                    bVar.b(r2.getString(2));
                    bVar.c(r2.getInt(3));
                    arrayList.add(bVar);
                } while (r2.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
    }

    public void a() {
        j();
        f247a.execSQL(o.a("history", null));
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:7:0x002a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        if (r0 == 0) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002a, code lost:
        if (r0 != 0) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0.close();
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    public boolean b(int i) {
        j();
        ? r0 = 0;
        boolean z = false;
        z = false;
        z = false;
        z = false;
        try {
            r0 = f247a.rawQuery("SELECT addons.oid FROM addons WHERE addons.oid = " + i + ";", r0);
            if (r0 != 0 && r0.getCount() > 0) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (r0 != 0) {
                r0.close();
            }
            throw th;
        }
    }

    public void a(mark.via.a.a aVar) {
        j();
        if (aVar != null && aVar.g() != null && aVar.b() != null) {
            if (aVar.f() > 0) {
                f247a.delete("addons", "oid = ?", new String[]{String.valueOf(aVar.f())});
            } else if (aVar.c() > 0) {
                f247a.delete("addons", "id = ?", new String[]{String.valueOf(aVar.c())});
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("oid", Integer.valueOf(aVar.f()));
            contentValues.put("name", aVar.e());
            contentValues.put("author", aVar.a());
            contentValues.put("url", aVar.g());
            contentValues.put("info", aVar.d());
            contentValues.put("code", aVar.b());
            f247a.insert("addons", null, contentValues);
        }
    }

    private String c(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String replace = str2.replace("'", "''").replace("\"", "\"\"");
        if (replace.endsWith("/")) {
            str3 = replace.substring(0, replace.length() - 1);
        } else {
            str3 = replace + "/";
        }
        String[] strArr = {str3, replace.replace("&", "&amp;"), str3.replace("&", "&amp;"), i.d(replace), i.d(str3), replace.replace("/?", "?"), str3.replace("/?", "?")};
        sb.append(" WHERE ");
        sb.append(str);
        sb.append(" ='");
        sb.append(replace);
        sb.append("'");
        for (int i = 0; i < 7; i++) {
            String str4 = strArr[i];
            sb.append(" OR ");
            sb.append(str);
            sb.append(" ='");
            sb.append(str4);
            sb.append("'");
        }
        return sb.toString();
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:7:0x005b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0064, code lost:
        if (r1 == 0) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0066, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0069, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x005b, code lost:
        if (r1 != 0) goto L_0x0066;
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    public mark.via.a.b i(String str) {
        j();
        mark.via.a.b bVar = new mark.via.a.b();
        ? r1 = 0;
        try {
            r1 = f247a.rawQuery("SELECT * FROM bookmarks" + c("url", str) + " LIMIT 1;", r1);
            if (r1 != 0 && r1.moveToFirst()) {
                bVar.a(r1.getInt(0));
                bVar.c(r1.getString(1));
                bVar.b(r1.getString(2));
                bVar.a(r1.getString(3));
                bVar.c(r1.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    public void d(String str) {
        j();
        if (!TextUtils.isEmpty(str)) {
            String replace = str.replace("'", "''").replace("\"", "\"\"");
            f247a.execSQL("DELETE FROM bookmarks WHERE folder = '" + replace + "'");
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:8:0x004f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0058, code lost:
        if (r2 == 0) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005a, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004f, code lost:
        if (r2 == 0) goto L_0x005d;
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    public List<mark.via.a.a> b() {
        j();
        ArrayList arrayList = new ArrayList();
        ? r2 = 0;
        try {
            r2 = f247a.rawQuery("SELECT addons.id, addons.oid, addons.name, addons.url, addons.code FROM addons ORDER BY addons.id DESC;", r2);
            if (r2 != 0 && r2.moveToFirst()) {
                do {
                    mark.via.a.a aVar = new mark.via.a.a();
                    aVar.a(r2.getInt(0));
                    aVar.b(r2.getInt(1));
                    aVar.d(r2.getString(2));
                    aVar.e(r2.getString(3));
                    aVar.b(r2.getString(4));
                    arrayList.add(aVar);
                } while (r2.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
    }

    public void e(String str) {
        j();
        if (!TextUtils.isEmpty(str)) {
            f247a.execSQL("DELETE FROM favorites" + c("f_url", str));
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:6:0x0020 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r2 == 0) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        return (java.lang.String[]) r0.toArray(new java.lang.String[r0.size()]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        if (r2 != 0) goto L_0x002b;
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    public String[] h() {
        j();
        ArrayList arrayList = new ArrayList();
        ? r2 = 0;
        try {
            r2 = f247a.rawQuery("SELECT bookmarks.folder FROM bookmarks WHERE bookmarks.folder != '' GROUP BY bookmarks.folder;", r2);
            while (r2.moveToNext()) {
                arrayList.add(r2.getString(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
    }

    public void c(String str) {
        j();
        if (!TextUtils.isEmpty(str)) {
            f247a.execSQL("DELETE FROM bookmarks" + c("url", str));
        }
    }

    public void a(int i) {
        j();
        f247a.delete("addons", "oid = ?", new String[]{String.valueOf(i)});
    }

    public void c(List<mark.via.a.b> list) {
        j();
        try {
            f247a.beginTransaction();
            for (mark.via.a.b bVar : list) {
                f247a.delete("favorites", "f_url = ?", new String[]{String.valueOf(bVar.f())});
                ContentValues contentValues = new ContentValues();
                contentValues.put("f_url", bVar.f());
                contentValues.put("f_title", bVar.e());
                contentValues.put("f_order", Integer.valueOf(bVar.d()));
                f247a.insert("favorites", null, contentValues);
            }
            f247a.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            f247a.endTransaction();
            throw th;
        }
        f247a.endTransaction();
    }

    public void a(String str) {
        j();
        f247a.delete("addons", "code = ?", new String[]{str});
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    public void a(String str, String str2, boolean z) {
        String str3 = str2;
        j();
        Cursor cursor = null;
        try {
            Cursor query = f247a.query("ads", new String[]{"id", "url", "tag"}, "url=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        query.moveToFirst();
                        if (!query.getString(2).equalsIgnoreCase(str3) && !z) {
                            str3 = str3 + ", " + query.getString(2);
                        }
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("tag", str3);
                        f247a.update("ads", contentValues, "url=?", new String[]{str});
                    } else {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("url", str);
                        contentValues2.put("tag", str3);
                        f247a.insert("ads", null, contentValues2);
                    }
                } catch (Exception e) {
                    e = e;
                    cursor = query;
                    try {
                        e.printStackTrace();
                        if (cursor == null) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } else {
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("url", str);
                contentValues3.put("tag", str3);
                f247a.insert("ads", null, contentValues3);
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            if (cursor == null) {
                cursor.close();
            }
        }
    }

    public void b(String str) {
        j();
        f247a.delete("ads", "url = ?", new String[]{str});
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:9:0x0082 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x008b, code lost:
        if (r1 == 0) goto L_0x0090;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x008d, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0090, code lost:
        java.util.Collections.sort(r0, mark.via.c.b.d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0095, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0082, code lost:
        if (r1 != 0) goto L_0x008d;
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    public List<mark.via.a.b> g(String str) {
        j();
        String replace = str.replace("'", "''").replace("\"", "\"\"");
        ArrayList arrayList = new ArrayList();
        ? r1 = 0;
        try {
            r1 = f247a.rawQuery("SELECT * FROM bookmarks WHERE " + a("title", "url", replace) + " ORDER BY " + "id" + " DESC LIMIT 10", r1);
            if (r1.moveToLast()) {
                int i = 0;
                do {
                    mark.via.a.b bVar = new mark.via.a.b();
                    bVar.a(Integer.parseInt(r1.getString(0)));
                    bVar.c(r1.getString(1));
                    bVar.b(r1.getString(2));
                    bVar.b(R.drawable.a8);
                    arrayList.add(bVar);
                    i++;
                    if (!r1.moveToPrevious()) {
                        break;
                    }
                } while (i < 5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (r1 != 0) {
                r1.close();
            }
            throw th;
        }
    }

    public void b(List<mark.via.a.b> list) {
        j();
        try {
            f247a.beginTransaction();
            for (mark.via.a.b bVar : list) {
                f247a.delete("bookmarks", "url = ?", new String[]{String.valueOf(bVar.f())});
                ContentValues contentValues = new ContentValues();
                contentValues.put("url", bVar.f());
                contentValues.put("title", bVar.e());
                contentValues.put("folder", bVar.a());
                contentValues.put("clickTimes", Integer.valueOf(bVar.d()));
                f247a.insert("bookmarks", null, contentValues);
            }
            f247a.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            f247a.endTransaction();
            throw th;
        }
        f247a.endTransaction();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0097, code lost:
        if (r11 != null) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0099, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a4, code lost:
        if (r11 != null) goto L_0x0099;
     */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d6  */
    public void b(mark.via.a.b bVar, boolean z) {
        Cursor cursor;
        j();
        if (bVar != null && bVar.f() != null && bVar.e() != null) {
            try {
                f247a.beginTransaction();
                String f = bVar.f();
                f247a.delete("favorites", "f_url = ?", new String[]{f});
                if (f.endsWith("/")) {
                    f247a.delete("favorites", "f_url = ?", new String[]{f.substring(0, f.length() - 1)});
                } else {
                    f247a.delete("favorites", "f_url = ?", new String[]{f + "/"});
                }
                if (bVar.b() > 0) {
                    f247a.delete("favorites", "f_url = ?", new String[]{String.valueOf(bVar.b())});
                }
                int d2 = bVar.d();
                Cursor cursor2 = null;
                if (z || d2 == -1) {
                    try {
                        cursor = f247a.rawQuery("SELECT  MAX(f_order)  FROM favorites;", null);
                        if (cursor != null) {
                            try {
                                if (cursor.moveToFirst()) {
                                    d2 = cursor.getInt(0) + 1;
                                }
                            } catch (Exception e) {
                                e = e;
                                try {
                                    e.printStackTrace();
                                } catch (Throwable th) {
                                    th = th;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = null;
                        e.printStackTrace();
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("f_url", bVar.f());
                contentValues.put("f_title", bVar.e());
                contentValues.put("f_order", Integer.valueOf(d2));
                f247a.insert("favorites", null, contentValues);
                f247a.setTransactionSuccessful();
            } catch (Exception e3) {
                e3.printStackTrace();
            } catch (Throwable th3) {
                f247a.endTransaction();
                throw th3;
            }
            f247a.endTransaction();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0078, code lost:
        if (r10 != null) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007a, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0085, code lost:
        if (r10 != null) goto L_0x007a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00be  */
    public void a(mark.via.a.b bVar, boolean z) {
        Cursor cursor;
        if (bVar != null && bVar.f() != null && bVar.e() != null) {
            j();
            try {
                f247a.beginTransaction();
                if (bVar.b() > 0) {
                    f247a.delete("bookmarks", "id = ?", new String[]{String.valueOf(bVar.b())});
                } else {
                    f247a.execSQL("DELETE FROM bookmarks" + c("url", bVar.f()));
                }
                int d2 = bVar.d();
                Cursor cursor2 = null;
                if (z || d2 == -1) {
                    try {
                        cursor = f247a.rawQuery("SELECT  MAX(clickTimes)  FROM bookmarks;", null);
                        if (cursor != null) {
                            try {
                                if (cursor.moveToFirst()) {
                                    d2 = cursor.getInt(0) + 1;
                                }
                            } catch (Exception e) {
                                e = e;
                                try {
                                    e.printStackTrace();
                                } catch (Throwable th) {
                                    th = th;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = null;
                        e.printStackTrace();
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("url", bVar.f());
                contentValues.put("title", bVar.e());
                contentValues.put("folder", bVar.a());
                contentValues.put("clickTimes", Integer.valueOf(d2));
                f247a.insert("bookmarks", null, contentValues);
                f247a.setTransactionSuccessful();
            } catch (Exception e3) {
                e3.printStackTrace();
            } catch (Throwable th3) {
                f247a.endTransaction();
                throw th3;
            }
            f247a.endTransaction();
        }
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:13:0x009b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x009b, code lost:
        if (r4 == 0) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a4, code lost:
        if (r4 == 0) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a6, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a9, code lost:
        return r0;
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    public List<mark.via.a.b> a(String str, boolean z) {
        j();
        String replace = str.replace("''", "'").replace("\"\"", "\"");
        ArrayList arrayList = new ArrayList();
        String str2 = "SELECT * FROM bookmarks WHERE bookmarks.folder = '" + replace + "' ORDER BY " + "clickTimes" + ";";
        if (z && !TextUtils.isEmpty(replace)) {
            mark.via.a.b bVar = new mark.via.a.b();
            bVar.b("...");
            bVar.c(-1);
            bVar.c("folder://");
            arrayList.add(bVar);
        }
        ? r4 = 0;
        try {
            r4 = f247a.rawQuery(str2, r4);
            if (r4 != 0 && r4.moveToFirst()) {
                do {
                    mark.via.a.b bVar2 = new mark.via.a.b();
                    bVar2.a(r4.getInt(0));
                    bVar2.c(r4.getString(1));
                    bVar2.b(r4.getString(2));
                    bVar2.a(r4.getString(3));
                    bVar2.c(r4.getInt(4));
                    arrayList.add(bVar2);
                } while (r4.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (r4 != 0) {
                r4.close();
            }
            throw th;
        }
    }

    public void a(String str, String str2) {
        j();
        ContentValues contentValues = new ContentValues();
        contentValues.put("folder", str2);
        f247a.update("bookmarks", contentValues, "folder=?", new String[]{str});
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: mark.via.c.b.a(java.lang.String, boolean):java.util.List<mark.via.a.b>
     arg types: [java.lang.String, int]
     candidates:
      mark.via.c.b.a(int, int):void
      mark.via.c.b.a(java.lang.String, java.lang.String):void
      mark.via.c.b.a(mark.via.a.b, boolean):void
      mark.via.c.b.a(java.lang.String, boolean):java.util.List<mark.via.a.b> */
    public void a(String str, int i, int i2) {
        List<mark.via.a.b> arrayList = new ArrayList<>();
        try {
            arrayList = a(str, false);
            if (i2 > i) {
                while (i < i2) {
                    int i3 = i + 1;
                    Collections.swap(arrayList, i, i3);
                    i = i3;
                }
            } else {
                while (i > i2) {
                    Collections.swap(arrayList, i, i - 1);
                    i--;
                }
            }
            for (mark.via.a.b bVar : arrayList) {
                bVar.c(arrayList.indexOf(bVar));
            }
        } catch (Exception e) {
            a.a.b.p.d.a(e);
        } catch (Throwable th) {
            b(arrayList);
            throw th;
        }
        b(arrayList);
    }

    public void a(List<mark.via.a.a> list) {
        j();
        try {
            f247a.beginTransaction();
            for (mark.via.a.a aVar : list) {
                if (aVar.f() != 0) {
                    f247a.delete("addons", "oid = ?", new String[]{String.valueOf(aVar.f())});
                    f247a.delete("addons", "code = ?", new String[]{aVar.b()});
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("oid", Integer.valueOf(aVar.f()));
                contentValues.put("name", aVar.e());
                contentValues.put("author", aVar.a());
                contentValues.put("url", aVar.g());
                contentValues.put("info", aVar.d());
                contentValues.put("code", aVar.b());
                f247a.insert("addons", null, contentValues);
            }
            f247a.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            f247a.endTransaction();
            throw th;
        }
        f247a.endTransaction();
    }

    public void a(int i, int i2) {
        List<mark.via.a.b> arrayList = new ArrayList<>();
        try {
            arrayList = f();
            if (i2 > i) {
                while (i < i2) {
                    int i3 = i + 1;
                    Collections.swap(arrayList, i, i3);
                    i = i3;
                }
            } else {
                while (i > i2) {
                    Collections.swap(arrayList, i, i - 1);
                    i--;
                }
            }
            for (mark.via.a.b bVar : arrayList) {
                bVar.c(arrayList.indexOf(bVar));
            }
        } catch (Exception e) {
            a.a.b.p.d.a(e);
        } catch (Throwable th) {
            c(arrayList);
            throw th;
        }
        c(arrayList);
    }

    private String a(String str, String str2, String str3) {
        String str4 = "";
        if (str3 == null || str3.isEmpty()) {
            return str4;
        }
        boolean a2 = mark.via.util.a.a(str3);
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(str);
        sb.append(" NOT LIKE ");
        sb.append("'%://%");
        sb.append(str3);
        sb.append("%'");
        sb.append(" AND ");
        sb.append(str);
        sb.append(" LIKE '%");
        sb.append(str3);
        sb.append("%')");
        if (!a2) {
            return sb.toString();
        }
        if (!mark.via.util.a.a(str3.charAt(0))) {
            sb.append(" OR ");
            sb.append(str2);
            sb.append(" LIKE ");
            sb.append("'%://%");
            if ('_' == str3.charAt(0)) {
                str4 = "\\";
            }
            sb.append(str4);
            sb.append(str3);
            sb.append("%'");
        } else {
            sb.append(" OR ");
            sb.append(str2);
            sb.append(" LIKE ");
            sb.append("'%://");
            sb.append(str3);
            sb.append("%'");
            sb.append(" OR ");
            sb.append(str2);
            sb.append(" LIKE ");
            sb.append("'%://");
            sb.append("%.");
            sb.append(str3);
            sb.append("%'");
            sb.append(" OR ");
            sb.append(str2);
            sb.append(" LIKE ");
            sb.append("'%://");
            sb.append("%/");
            sb.append(str3);
            sb.append("%'");
            sb.append(" OR ");
            sb.append(str2);
            sb.append(" LIKE ");
            sb.append("'%://");
            sb.append("%?");
            sb.append(str3);
            sb.append("%'");
            sb.append(" OR ");
            sb.append(str2);
            sb.append(" LIKE ");
            sb.append("'%://");
            sb.append("%&");
            sb.append(str3);
            sb.append("%'");
            sb.append(" OR ");
            sb.append(str2);
            sb.append(" LIKE ");
            sb.append("'%://");
            sb.append("%=");
            sb.append(str3);
            sb.append("%'");
            sb.append(" OR ");
            sb.append(str2);
            sb.append(" LIKE ");
            sb.append("'%://");
            sb.append("%#");
            sb.append(str3);
            sb.append("%'");
            sb.append(" OR ");
            sb.append(str2);
            sb.append(" LIKE ");
            sb.append("'%://");
            sb.append("%@");
            sb.append(str3);
            sb.append("%'");
            sb.append(" OR ");
            sb.append(str2);
            sb.append(" LIKE ");
            sb.append("'%://");
            sb.append("%-");
            sb.append(str3);
            sb.append("%'");
            sb.append(" OR ");
            sb.append(str2);
            sb.append(" LIKE ");
            sb.append("'%://");
            sb.append("%\\_");
            sb.append(str3);
            sb.append("%'");
        }
        return sb.toString();
    }

    public Cursor a(String[] strArr, String str, String[] strArr2, String str2) {
        j();
        return f247a.query("bookmarks", strArr, str, strArr2, str2, null, null);
    }
}
