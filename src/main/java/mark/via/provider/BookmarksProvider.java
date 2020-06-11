package mark.via.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import mark.via.c.b;
import mark.via.util.c;

public class BookmarksProvider extends ContentProvider {
    private static final String c = (c.b() ? "mark.via.gp.database" : "mark.via.database");
    private static final String d = ("vnd.android.cursor.dir/vnd." + c);

    /* renamed from: a  reason: collision with root package name */
    private UriMatcher f284a;
    private b b = null;

    private int a(Uri uri) {
        if (this.f284a == null) {
            UriMatcher uriMatcher = new UriMatcher(-1);
            this.f284a = uriMatcher;
            uriMatcher.addURI(c, "bookmarks", 0);
        }
        return this.f284a.match(uri);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return a(uri) == 0 ? d : "";
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        this.b = b.a(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (a(uri) == 0) {
            return this.b.a(strArr, str, strArr2, str2);
        }
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
