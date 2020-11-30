package mark.via.handler;

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
import java.util.Locale;
import mark.via.adapter.AddonItem;
import mark.via.adapter.HistoryItem;
import mark.via.constants.Constants;
import mark.via.gp.R;
import mark.via.utils.AppUtils;
import mark.via.utils.InfoUtils;
import mark.via.utils.SqlUtils;
import timber.log.Timber;

/* renamed from: mark.via.e.b */
/* compiled from: DatabaseHandler */
public class DatabaseHandler extends SQLiteOpenHelper {

    /* renamed from: a */
    private static SQLiteDatabase f1306a;

    /* renamed from: b */
    private static volatile DatabaseHandler f1307b;

    /* renamed from: c */
    private static final Comparator<HistoryItem> f1308c = new C0442a();

    /* renamed from: d */
    private static final Comparator<HistoryItem> f1309d = new C0443b();

    /* renamed from: mark.via.e.b$a */
    /* compiled from: DatabaseHandler */
    class C0442a implements Comparator<HistoryItem> {
        C0442a() {
        }

        /* renamed from: a */
        public int compare(HistoryItem bVar, HistoryItem bVar2) {
            int e = bVar.mo938e() - bVar2.mo938e();
            if (e != 0) {
                return e;
            }
            String f = bVar.mo940f();
            Locale locale = Constants.f1296a;
            return f.toLowerCase(locale).compareTo(bVar2.mo940f().toLowerCase(locale));
        }
    }

    /* renamed from: mark.via.e.b$b */
    /* compiled from: DatabaseHandler */
    class C0443b implements Comparator<HistoryItem> {
        C0443b() {
        }

        /* renamed from: b */
        private int m1629b(String str) {
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

        /* renamed from: a */
        public int compare(HistoryItem bVar, HistoryItem bVar2) {
            int b = m1629b(bVar.mo941g()) - m1629b(bVar2.mo941g());
            if (b != 0) {
                return b;
            }
            String f = bVar.mo940f();
            Locale locale = Constants.f1296a;
            return f.toLowerCase(locale).compareTo(bVar2.mo940f().toLowerCase(locale));
        }
    }

    private DatabaseHandler(Context context) {
        super(context, "via", (SQLiteDatabase.CursorFactory) null, 4);
        m1594c();
    }

    /* renamed from: E */
    private String m1592E(String str, String str2, String str3) {
        String str4 = "";
        if (str3 == null || str3.isEmpty()) {
            return str4;
        }
        boolean i = AppUtils.m2061i(str3);
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
        if (!i) {
            return sb.toString();
        }
        if (!AppUtils.m2058f(str3.charAt(0))) {
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

    /* renamed from: J */
    private String m1593J(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String replace = str2.replace("'", "''").replace("\"", "\"\"");
        String substring = replace.endsWith("/") ? replace.substring(0, replace.length() - 1) : replace + "/";
        String[] strArr = {substring, replace.replace("&", "&amp;"), substring.replace("&", "&amp;"), InfoUtils.m2171j(replace), InfoUtils.m2171j(substring), replace.replace("/?", "?"), substring.replace("/?", "?")};
        sb.append(" WHERE ");
        sb.append(str);
        sb.append(" ='");
        sb.append(replace);
        sb.append("'");
        for (int i = 0; i < 7; i++) {
            String str3 = strArr[i];
            sb.append(" OR ");
            sb.append(str);
            sb.append(" ='");
            sb.append(str3);
            sb.append("'");
        }
        return sb.toString();
    }

    /* renamed from: c */
    private void m1594c() {
        SQLiteDatabase sQLiteDatabase = f1306a;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            f1306a = getWritableDatabase();
        }
    }

    /* renamed from: v */
    public static DatabaseHandler m1595v(Context context) {
        if (f1307b == null) {
            synchronized (DatabaseHandler.class) {
                if (f1307b == null) {
                    f1307b = new DatabaseHandler(context);
                }
            }
        }
        return f1307b;
    }

    /* renamed from: A */
    public void mo966A(List<HistoryItem> list) {
        m1594c();
        try {
            f1306a.beginTransaction();
            for (HistoryItem bVar : list) {
                f1306a.delete("favorites", "f_url = ?", new String[]{String.valueOf(bVar.mo941g())});
                ContentValues contentValues = new ContentValues();
                contentValues.put("f_url", bVar.mo941g());
                contentValues.put("f_title", bVar.mo940f());
                contentValues.put("f_order", Integer.valueOf(bVar.mo938e()));
                f1306a.insert("favorites", null, contentValues);
            }
            f1306a.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            f1306a.endTransaction();
            throw th;
        }
        f1306a.endTransaction();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0036, code lost:
        if (0 == 0) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002a, code lost:
        if (r0 != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r0.close();
     */
    /* renamed from: B */
    public boolean mo967B(int i) {
        m1594c();
        Cursor cursor = null;
        boolean z = false;
        try {
            cursor = f1306a.rawQuery("SELECT addons.oid FROM addons WHERE addons.oid = " + i + ";", null);
            if (cursor != null && cursor.getCount() > 0) {
                z = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: C */
    public Cursor mo968C(String[] strArr, String str, String[] strArr2, String str2) {
        m1594c();
        return f1306a.query("bookmarks", strArr, str, strArr2, str2, null, null);
    }

    /* renamed from: D */
    public void mo969D(String str, String str2) {
        m1594c();
        ContentValues contentValues = new ContentValues();
        contentValues.put("folder", str2);
        f1306a.update("bookmarks", contentValues, "folder=?", new String[]{str});
    }

    /* renamed from: F */
    public void mo970F(AddonItem aVar) {
        m1594c();
        if (aVar != null && aVar.mo923g() != null && aVar.mo918b() != null) {
            if (aVar.mo922f() > 0) {
                f1306a.delete("addons", "oid = ?", new String[]{String.valueOf(aVar.mo922f())});
            } else if (aVar.mo919c() > 0) {
                f1306a.delete("addons", "id = ?", new String[]{String.valueOf(aVar.mo919c())});
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("oid", Integer.valueOf(aVar.mo922f()));
            contentValues.put("name", aVar.mo921e());
            contentValues.put("author", aVar.mo917a());
            contentValues.put("url", aVar.mo923g());
            contentValues.put("info", aVar.mo920d());
            contentValues.put("code", aVar.mo918b());
            f1306a.insert("addons", null, contentValues);
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
    /* renamed from: G */
    public void mo971G(HistoryItem bVar, boolean z) {
        Throwable th;
        Cursor cursor;
        Exception e;
        if (bVar != null && bVar.mo941g() != null && bVar.mo940f() != null) {
            m1594c();
            try {
                f1306a.beginTransaction();
                if (bVar.mo935c() > 0) {
                    f1306a.delete("bookmarks", "id = ?", new String[]{String.valueOf(bVar.mo935c())});
                } else {
                    f1306a.execSQL("DELETE FROM bookmarks" + m1593J("url", bVar.mo941g()));
                }
                int e2 = bVar.mo938e();
                Cursor cursor2 = null;
                if (z || e2 == -1) {
                    try {
                        cursor = f1306a.rawQuery("SELECT  MAX(clickTimes)  FROM bookmarks;", null);
                        if (cursor != null) {
                            try {
                                if (cursor.moveToFirst()) {
                                    e2 = cursor.getInt(0) + 1;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                try {
                                    e.printStackTrace();
                                } catch (Throwable th2) {
                                    th = th2;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        cursor = null;
                        e.printStackTrace();
                    } catch (Throwable th3) {
                        th = th3;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("url", bVar.mo941g());
                contentValues.put("title", bVar.mo940f());
                contentValues.put("folder", bVar.mo934b());
                contentValues.put("clickTimes", Integer.valueOf(e2));
                f1306a.insert("bookmarks", null, contentValues);
                f1306a.setTransactionSuccessful();
            } catch (Exception e5) {
                e5.printStackTrace();
            } catch (Throwable th4) {
                f1306a.endTransaction();
                throw th4;
            }
            f1306a.endTransaction();
        }
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
    /* renamed from: H */
    public void mo972H(HistoryItem bVar, boolean z) {
        Throwable th;
        Cursor cursor;
        Exception e;
        m1594c();
        if (bVar != null && bVar.mo941g() != null && bVar.mo940f() != null) {
            try {
                f1306a.beginTransaction();
                String g = bVar.mo941g();
                f1306a.delete("favorites", "f_url = ?", new String[]{g});
                if (g.endsWith("/")) {
                    f1306a.delete("favorites", "f_url = ?", new String[]{g.substring(0, g.length() - 1)});
                } else {
                    f1306a.delete("favorites", "f_url = ?", new String[]{g + "/"});
                }
                if (bVar.mo935c() > 0) {
                    f1306a.delete("favorites", "f_url = ?", new String[]{String.valueOf(bVar.mo935c())});
                }
                int e2 = bVar.mo938e();
                Cursor cursor2 = null;
                if (z || e2 == -1) {
                    try {
                        cursor = f1306a.rawQuery("SELECT  MAX(f_order)  FROM favorites;", null);
                        if (cursor != null) {
                            try {
                                if (cursor.moveToFirst()) {
                                    e2 = cursor.getInt(0) + 1;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                try {
                                    e.printStackTrace();
                                } catch (Throwable th2) {
                                    th = th2;
                                    cursor2 = cursor;
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                    throw th;
                                }
                            }
                        }
                    } catch (Exception e4) {
                        e = e4;
                        cursor = null;
                        e.printStackTrace();
                    } catch (Throwable th3) {
                        th = th3;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("f_url", bVar.mo941g());
                contentValues.put("f_title", bVar.mo940f());
                contentValues.put("f_order", Integer.valueOf(e2));
                f1306a.insert("favorites", null, contentValues);
                f1306a.setTransactionSuccessful();
            } catch (Exception e5) {
                e5.printStackTrace();
            } catch (Throwable th4) {
                f1306a.endTransaction();
                throw th4;
            }
            f1306a.endTransaction();
        }
    }

    /* renamed from: I */
    public void mo973I(String str, String str2) {
        m1594c();
        String b = SqlUtils.m2193b(str);
        String b2 = SqlUtils.m2193b(str2);
        f1306a.execSQL("DELETE FROM history" + m1593J("url", b));
        f1306a.execSQL(SqlUtils.m2194c("history", "(url, title) VALUES ('" + b + "', '" + b2 + "')"));
    }

    /* renamed from: a */
    public void mo974a(String str, int i, int i2) {
        List<HistoryItem> arrayList = new ArrayList<>();
        try {
            arrayList = mo994s(str, false);
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
            for (HistoryItem bVar : arrayList) {
                bVar.mo946k(arrayList.indexOf(bVar));
            }
        } catch (Exception e) {
            Timber.m973c(e);
        } catch (Throwable th) {
            mo1000z(arrayList);
            throw th;
        }
        mo1000z(arrayList);
    }

    /* renamed from: b */
    public void mo975b(int i, int i2) {
        List<HistoryItem> arrayList = new ArrayList<>();
        try {
            arrayList = mo991p();
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
            for (HistoryItem bVar : arrayList) {
                bVar.mo946k(arrayList.indexOf(bVar));
            }
        } catch (Exception e) {
            Timber.m973c(e);
        } catch (Throwable th) {
            mo966A(arrayList);
            throw th;
        }
        mo966A(arrayList);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        SQLiteDatabase sQLiteDatabase = f1306a;
        if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
            f1306a.close();
        }
        super.close();
    }

    /* renamed from: d */
    public void mo977d(int i) {
        m1594c();
        f1306a.delete("addons", "oid = ?", new String[]{String.valueOf(i)});
    }

    /* renamed from: e */
    public void mo978e(String str) {
        m1594c();
        f1306a.delete("addons", "code = ?", new String[]{str});
    }

    /* renamed from: f */
    public void mo979f() {
        m1594c();
        f1306a.execSQL(SqlUtils.m2192a("history", null));
    }

    /* renamed from: g */
    public void mo980g(String str) {
        m1594c();
        if (!TextUtils.isEmpty(str)) {
            f1306a.execSQL("DELETE FROM bookmarks" + m1593J("url", str));
        }
    }

    /* renamed from: h */
    public void mo981h(String str) {
        m1594c();
        if (!TextUtils.isEmpty(str)) {
            String replace = str.replace("'", "''").replace("\"", "\"\"");
            f1306a.execSQL("DELETE FROM bookmarks WHERE folder = '" + replace + "'");
        }
    }

    /* renamed from: i */
    public void mo982i(String str) {
        m1594c();
        if (!TextUtils.isEmpty(str)) {
            f1306a.execSQL("DELETE FROM favorites" + m1593J("f_url", str));
        }
    }

    /* renamed from: j */
    public void mo983j(String str) {
        m1594c();
        f1306a.execSQL("DELETE FROM history" + m1593J("url", str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0090, code lost:
        if (r1 != null) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0099, code lost:
        if (0 == 0) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009b, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x009e, code lost:
        java.util.Collections.sort(r0, mark.via.handler.DatabaseHandler.f1309d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a3, code lost:
        return r0;
     */
    /* renamed from: k */
    public List<HistoryItem> mo984k(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                m1594c();
                String replace = trim.replace("'", "''").replace("\"", "\"\"");
                Cursor cursor = null;
                try {
                    cursor = f1306a.rawQuery("SELECT * FROM bookmarks WHERE " + m1592E("title", "url", replace) + " ORDER BY id LIMIT 10", null);
                    if (cursor.moveToLast()) {
                        int i = 0;
                        do {
                            HistoryItem bVar = new HistoryItem();
                            bVar.mo944i(Integer.parseInt(cursor.getString(0)));
                            bVar.mo948m(cursor.getString(1));
                            bVar.mo947l(cursor.getString(2));
                            bVar.mo945j(R.drawable.RES_2131165203);
                            arrayList.add(bVar);
                            i++;
                            if (!cursor.moveToPrevious()) {
                                break;
                            }
                        } while (i < 5);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    if (0 != 0) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0069, code lost:
        if (r1 != null) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0072, code lost:
        if (0 == 0) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0074, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0077, code lost:
        java.util.Collections.sort(r0, mark.via.handler.DatabaseHandler.f1309d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007c, code lost:
        return r0;
     */
    /* renamed from: l */
    public List<HistoryItem> mo985l(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                m1594c();
                String b = SqlUtils.m2193b(trim);
                Cursor cursor = null;
                try {
                    cursor = f1306a.rawQuery("SELECT url,title FROM history WHERE " + m1592E("title", "url", b) + " ORDER BY id LIMIT 25", null);
                    if (cursor.moveToLast()) {
                        do {
                            arrayList.add(new HistoryItem(cursor.getString(0), cursor.getString(1), (int) R.drawable.RES_2131165213));
                        } while (cursor.moveToPrevious());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } catch (Throwable th) {
                    if (0 != 0) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0058, code lost:
        if (0 == 0) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005a, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004f, code lost:
        if (r2 == null) goto L_0x005d;
     */
    /* renamed from: m */
    public List<AddonItem> mo986m() {
        m1594c();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = f1306a.rawQuery("SELECT addons.id, addons.oid, addons.name, addons.url, addons.code FROM addons ORDER BY addons.id DESC;", null);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    AddonItem aVar = new AddonItem();
                    aVar.mo927k(cursor.getInt(0));
                    aVar.mo930n(cursor.getInt(1));
                    aVar.mo929m(cursor.getString(2));
                    aVar.mo931o(cursor.getString(3));
                    aVar.mo926j(cursor.getString(4));
                    arrayList.add(aVar);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        if (0 == 0) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002b, code lost:
        if (r2 == null) goto L_0x0039;
     */
    /* renamed from: n */
    public List<Integer> mo987n() {
        m1594c();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = f1306a.rawQuery("SELECT addons.oid FROM addons WHERE addons.oid > 0;", null);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    arrayList.add(Integer.valueOf(cursor.getInt(0)));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0058, code lost:
        if (0 == 0) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005a, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004f, code lost:
        if (r2 == null) goto L_0x005d;
     */
    /* renamed from: o */
    public List<HistoryItem> mo988o() {
        m1594c();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = f1306a.rawQuery("SELECT * FROM bookmarks;", null);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    HistoryItem bVar = new HistoryItem();
                    bVar.mo944i(cursor.getInt(0));
                    bVar.mo948m(cursor.getString(1));
                    bVar.mo947l(cursor.getString(2));
                    bVar.mo942h(cursor.getString(3));
                    bVar.mo946k(cursor.getInt(4));
                    arrayList.add(bVar);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
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

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0048, code lost:
        if (0 == 0) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003f, code lost:
        if (r2 == null) goto L_0x004d;
     */
    /* renamed from: p */
    public List<HistoryItem> mo991p() {
        m1594c();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = f1306a.rawQuery("SELECT * FROM favorites ORDER BY favorites.f_order;", null);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    HistoryItem bVar = new HistoryItem();
                    bVar.mo948m(cursor.getString(1));
                    bVar.mo947l(cursor.getString(2));
                    bVar.mo946k(cursor.getInt(3));
                    arrayList.add(bVar);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0064, code lost:
        if (0 == 0) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0066, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0069, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x005b, code lost:
        if (r1 != null) goto L_0x0066;
     */
    /* renamed from: q */
    public HistoryItem mo992q(String str) {
        m1594c();
        HistoryItem bVar = new HistoryItem();
        Cursor cursor = null;
        try {
            cursor = f1306a.rawQuery("SELECT * FROM bookmarks" + m1593J("url", str) + " LIMIT 1;", null);
            if (cursor != null && cursor.moveToFirst()) {
                bVar.mo944i(cursor.getInt(0));
                bVar.mo948m(cursor.getString(1));
                bVar.mo947l(cursor.getString(2));
                bVar.mo942h(cursor.getString(3));
                bVar.mo946k(cursor.getInt(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

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
        r6 = mark.via.handler.DatabaseHandler.f1306a.rawQuery("SELECT url,title FROM bookmarks WHERE bookmarks.folder = '' ORDER BY clickTimes;", null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0084, code lost:
        if (r6 == null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008a, code lost:
        if (r6.moveToFirst() == false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008c, code lost:
        r3.add(new mark.via.adapter.HistoryItem(r6.getString(0), r6.getString(1)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a1, code lost:
        if (r6.moveToNext() != false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a3, code lost:
        if (r6 == null) goto L_0x00b1;
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
        if (0 == 0) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ae, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b1, code lost:
        java.util.Collections.sort(r2, mark.via.handler.DatabaseHandler.f1308c);
        r2.addAll(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b9, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ba, code lost:
        if (0 != 0) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00bc, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00bf, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c4  */
    /* renamed from: r */
    public List<HistoryItem> mo993r() {
        Throwable th;
        Cursor cursor;
        Exception e;
        String str;
        m1594c();
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Cursor cursor2 = null;
        try {
            cursor = f1306a.rawQuery("SELECT bookmarks.folder FROM bookmarks WHERE bookmarks.folder != '';", null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        do {
                            String string = cursor.getString(0);
                            if (!hashSet.contains(string)) {
                                String str2 = "folder://" + string;
                                try {
                                    str = "folder://" + URLEncoder.encode(string, "utf-8");
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                                HistoryItem bVar = new HistoryItem(str, string);
                                hashSet.add(string);
                                arrayList.add(bVar);
                            }
                        } while (cursor.moveToNext());
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                }
            }
        } catch (Exception e4) {
            e = e4;
            cursor = null;
            e.printStackTrace();
        } catch (Throwable th3) {
            th = th3;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x009b, code lost:
        if (r4 == null) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00a4, code lost:
        if (0 == 0) goto L_0x00a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a6, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a9, code lost:
        return r0;
     */
    /* renamed from: s */
    public List<HistoryItem> mo994s(String str, boolean z) {
        m1594c();
        String replace = str.replace("''", "'").replace("\"\"", "\"");
        ArrayList arrayList = new ArrayList();
        String str2 = "SELECT * FROM bookmarks WHERE bookmarks.folder = '" + replace + "' ORDER BY clickTimes;";
        if (z && !TextUtils.isEmpty(replace)) {
            HistoryItem bVar = new HistoryItem();
            bVar.mo947l("...");
            bVar.mo946k(-1);
            bVar.mo948m("folder://");
            arrayList.add(bVar);
        }
        Cursor cursor = null;
        try {
            cursor = f1306a.rawQuery(str2, null);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    HistoryItem bVar2 = new HistoryItem();
                    bVar2.mo944i(cursor.getInt(0));
                    bVar2.mo948m(cursor.getString(1));
                    bVar2.mo947l(cursor.getString(2));
                    bVar2.mo942h(cursor.getString(3));
                    bVar2.mo946k(cursor.getInt(4));
                    arrayList.add(bVar2);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005c, code lost:
        if (0 == 0) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005e, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0061, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0053, code lost:
        if (r1 != null) goto L_0x005e;
     */
    /* renamed from: t */
    public HistoryItem mo995t(String str) {
        m1594c();
        HistoryItem bVar = new HistoryItem();
        Cursor cursor = null;
        try {
            cursor = f1306a.rawQuery("SELECT * FROM favorites" + m1593J("f_url", str) + " LIMIT 1;", null);
            if (cursor != null && cursor.moveToFirst()) {
                bVar.mo944i(cursor.getInt(0));
                bVar.mo948m(cursor.getString(1));
                bVar.mo947l(cursor.getString(2));
                bVar.mo946k(cursor.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (0 == 0) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        return (java.lang.String[]) r0.toArray(new java.lang.String[r0.size()]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        if (r2 != null) goto L_0x002b;
     */
    /* renamed from: u */
    public String[] mo996u() {
        m1594c();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = f1306a.rawQuery("SELECT bookmarks.folder FROM bookmarks WHERE bookmarks.folder != '' GROUP BY bookmarks.folder;", null);
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (0 == 0) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002f, code lost:
        if (r2 != null) goto L_0x003a;
     */
    /* renamed from: w */
    public List<HistoryItem> mo997w() {
        m1594c();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = f1306a.rawQuery("SELECT url,title FROM history ORDER BY id DESC LIMIT 256", null);
            if (cursor.moveToFirst()) {
                do {
                    arrayList.add(new HistoryItem(cursor.getString(0), cursor.getString(1)));
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0091, code lost:
        if (r1 == null) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x009a, code lost:
        if (0 == 0) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x009c, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a7, code lost:
        return r0.toString().trim();
     */
    /* renamed from: x */
    public String mo998x(String str) {
        m1594c();
        String lowerCase = str.toLowerCase(Constants.f1296a);
        StringBuilder sb = new StringBuilder();
        Cursor cursor = null;
        try {
            cursor = f1306a.rawQuery("SELECT addons.url, addons.code FROM addons WHERE addons.url = '" + lowerCase + "' UNION SELECT addons.url, addons.code FROM addons WHERE addons.url = '*';", null);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String i = InfoUtils.m2170i(cursor.getString(1));
                    if (i.startsWith("javascript:")) {
                        i = i.substring(11).trim();
                    }
                    sb.append(i);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* renamed from: y */
    public void mo999y(List<AddonItem> list) {
        m1594c();
        try {
            f1306a.beginTransaction();
            for (AddonItem aVar : list) {
                if (aVar.mo922f() != 0) {
                    f1306a.delete("addons", "oid = ?", new String[]{String.valueOf(aVar.mo922f())});
                    f1306a.delete("addons", "code = ?", new String[]{aVar.mo918b()});
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("oid", Integer.valueOf(aVar.mo922f()));
                contentValues.put("name", aVar.mo921e());
                contentValues.put("author", aVar.mo917a());
                contentValues.put("url", aVar.mo923g());
                contentValues.put("info", aVar.mo920d());
                contentValues.put("code", aVar.mo918b());
                f1306a.insert("addons", null, contentValues);
            }
            f1306a.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            f1306a.endTransaction();
            throw th;
        }
        f1306a.endTransaction();
    }

    /* renamed from: z */
    public void mo1000z(List<HistoryItem> list) {
        m1594c();
        try {
            f1306a.beginTransaction();
            for (HistoryItem bVar : list) {
                f1306a.delete("bookmarks", "url = ?", new String[]{String.valueOf(bVar.mo941g())});
                ContentValues contentValues = new ContentValues();
                contentValues.put("url", bVar.mo941g());
                contentValues.put("title", bVar.mo940f());
                contentValues.put("folder", bVar.mo934b());
                contentValues.put("clickTimes", Integer.valueOf(bVar.mo938e()));
                f1306a.insert("bookmarks", null, contentValues);
            }
            f1306a.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            f1306a.endTransaction();
            throw th;
        }
        f1306a.endTransaction();
    }
}
