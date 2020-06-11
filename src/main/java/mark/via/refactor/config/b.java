package mark.via.refactor.config;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Base64;
import java.util.HashMap;
import mark.via.h.c.c;

/* compiled from: SiteConfDbHelper */
public class b extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f289a;

    private b(Context context) {
        super(context.getApplicationContext(), "siteconfs.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static b a(Context context) {
        if (f289a == null) {
            synchronized (b.class) {
                if (f289a == null) {
                    f289a = new b(context);
                }
            }
        }
        return f289a;
    }

    private static ContentValues b(String str, SiteConf siteConf) {
        if (siteConf == null || str == null || str.length() <= 0) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("domain", str);
        contentValues.put("data", b(siteConf));
        return contentValues;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table confs(_id integer primary key autoincrement, domain text not null, data text not null)");
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    private static String b(SiteConf siteConf) {
        return siteConf == null ? "" : Base64.encodeToString(c.a(siteConf), 0);
    }

    public HashMap<String, SiteConf> a() {
        SiteConf a2;
        HashMap<String, SiteConf> hashMap = new HashMap<>();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor query = readableDatabase.query("confs", null, null, null, null, null, null);
        while (query.moveToNext()) {
            long j = query.getLong(query.getColumnIndex("_id"));
            String string = query.getString(query.getColumnIndex("domain"));
            String string2 = query.getString(query.getColumnIndex("data"));
            if (!(string == null || string.length() <= 0 || string2 == null || (a2 = a(string2)) == null)) {
                a2.a(j);
                hashMap.put(string, a2);
            }
        }
        query.close();
        readableDatabase.close();
        return hashMap;
    }

    public long a(String str, SiteConf siteConf) {
        if ((str == null && str.length() <= 0) || siteConf == null) {
            return -1;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        long insert = writableDatabase.insert("confs", null, b(str, siteConf));
        writableDatabase.close();
        return insert;
    }

    public void a(long j) {
        if (j >= 0) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.delete("confs", "_id = ?", new String[]{String.valueOf(j)});
            writableDatabase.close();
        }
    }

    public void a(SiteConf siteConf) {
        if (siteConf != null) {
            long c = siteConf.c();
            if (c >= 0) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("data", b(siteConf));
                writableDatabase.update("confs", contentValues, "_id = ?", new String[]{String.valueOf(c)});
                writableDatabase.close();
            }
        }
    }

    private static SiteConf a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return new SiteConf(c.a(Base64.decode(str, 0)));
    }
}
