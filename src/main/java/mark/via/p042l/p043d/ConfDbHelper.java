package mark.via.p042l.p043d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.HashMap;
import mark.via.p042l.p043d.SiteConf;

/* renamed from: mark.via.l.d.b */
/* compiled from: ConfDbHelper */
public class ConfDbHelper extends SQLiteOpenHelper implements ConfDataSource {
    public ConfDbHelper(Context context) {
        super(context.getApplicationContext(), "siteconfs.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    /* renamed from: e */
    private void m1909e(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table confs(domain text not null primary key, data text not null)");
    }

    /* renamed from: f */
    private void m1910f(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("drop table confs");
    }

    @Override // mark.via.p042l.p043d.ConfDataSource
    /* renamed from: a */
    public HashMap<String, SiteConf> mo1223a() {
        SiteConf a;
        HashMap<String, SiteConf> hashMap = new HashMap<>();
        SQLiteDatabase readableDatabase = getReadableDatabase();
        Cursor query = readableDatabase.query("confs", null, null, null, null, null, null);
        while (query.moveToNext()) {
            String string = query.getString(query.getColumnIndex("domain"));
            String string2 = query.getString(query.getColumnIndex("data"));
            if (!(string == null || string.length() <= 0 || string2 == null || (a = SiteConf.C0470a.m1935a(string2)) == null)) {
                hashMap.put(string, a);
            }
        }
        query.close();
        readableDatabase.close();
        return hashMap;
    }

    @Override // mark.via.p042l.p043d.ConfDataSource
    /* renamed from: b */
    public void mo1224b(String str) {
        if (str != null && !str.isEmpty()) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.delete("confs", "domain = ? ", new String[]{str});
            writableDatabase.close();
        }
    }

    @Override // mark.via.p042l.p043d.ConfDataSource
    /* renamed from: c */
    public void mo1225c(String str, SiteConf dVar) {
        if (str != null && !str.isEmpty() && dVar != null) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("data", SiteConf.C0470a.m1936b(dVar));
            writableDatabase.update("confs", contentValues, "domain = ? ", new String[]{str});
            writableDatabase.close();
        }
    }

    @Override // mark.via.p042l.p043d.ConfDataSource
    /* renamed from: d */
    public long mo1226d(String str, SiteConf dVar) {
        if (str == null || str.isEmpty() || dVar == null) {
            return -1;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("domain", str);
        contentValues.put("data", SiteConf.C0470a.m1936b(dVar));
        long insert = writableDatabase.insert("confs", null, contentValues);
        writableDatabase.close();
        return insert;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m1909e(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i == 1) {
            m1910f(sQLiteDatabase);
            m1909e(sQLiteDatabase);
        }
    }
}
