package mark.via.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import mark.via.handler.DatabaseHandler;
import mark.via.utils.ChannelUtils;

public class BookmarksProvider extends ContentProvider {

    /* renamed from: c */
    private static final String f1550c;

    /* renamed from: d */
    private static final String f1551d;

    /* renamed from: a */
    private UriMatcher f1552a;

    /* renamed from: b */
    private DatabaseHandler f1553b = null;

    static {
        String str = ChannelUtils.m2108c() ? "mark.via.gp.database" : "mark.via.database";
        f1550c = str;
        f1551d = "vnd.android.cursor.dir/vnd." + str;
    }

    /* renamed from: a */
    private int m2256a(Uri uri) {
        if (this.f1552a == null) {
            UriMatcher uriMatcher = new UriMatcher(-1);
            this.f1552a = uriMatcher;
            uriMatcher.addURI(f1550c, "bookmarks", 0);
        }
        return this.f1552a.match(uri);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return m2256a(uri) == 0 ? f1551d : "";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f1553b = DatabaseHandler.m1595v(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (m2256a(uri) == 0) {
            return this.f1553b.mo968C(strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
