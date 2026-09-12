package androidx.media3.datasource.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import androidx.media3.database.DatabaseIOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
final class d {

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f10896c = {"name", "length", "last_touch_timestamp"};

    /* renamed from: a, reason: collision with root package name */
    private final v1.a f10897a;

    /* renamed from: b, reason: collision with root package name */
    private String f10898b;

    public d(v1.a aVar) {
        this.f10897a = aVar;
    }

    private static void a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }

    private Cursor c() {
        androidx.media3.common.util.a.e(this.f10898b);
        return this.f10897a.getReadableDatabase().query(this.f10898b, f10896c, null, null, null, null, null);
    }

    private static String d(String str) {
        return "ExoPlayerCacheFileMetadata" + str;
    }

    public Map b() {
        try {
            Cursor c11 = c();
            try {
                HashMap hashMap = new HashMap(c11.getCount());
                while (c11.moveToNext()) {
                    hashMap.put((String) androidx.media3.common.util.a.e(c11.getString(0)), new c(c11.getLong(1), c11.getLong(2)));
                }
                c11.close();
                return hashMap;
            } finally {
            }
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    public void e(long j11) {
        try {
            String hexString = Long.toHexString(j11);
            this.f10898b = d(hexString);
            if (v1.c.b(this.f10897a.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = this.f10897a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    v1.c.d(writableDatabase, 2, hexString, 1);
                    a(writableDatabase, this.f10898b);
                    writableDatabase.execSQL("CREATE TABLE " + this.f10898b + " (name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                } catch (Throwable th2) {
                    writableDatabase.endTransaction();
                    throw th2;
                }
            }
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    public void f(String str) {
        androidx.media3.common.util.a.e(this.f10898b);
        try {
            this.f10897a.getWritableDatabase().delete(this.f10898b, "name = ?", new String[]{str});
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    public void g(Set set) {
        androidx.media3.common.util.a.e(this.f10898b);
        try {
            SQLiteDatabase writableDatabase = this.f10897a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete(this.f10898b, "name = ?", new String[]{(String) it.next()});
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (Throwable th2) {
                writableDatabase.endTransaction();
                throw th2;
            }
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    public void h(String str, long j11, long j12) {
        androidx.media3.common.util.a.e(this.f10898b);
        try {
            SQLiteDatabase writableDatabase = this.f10897a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("length", Long.valueOf(j11));
            contentValues.put("last_touch_timestamp", Long.valueOf(j12));
            writableDatabase.replaceOrThrow(this.f10898b, null, contentValues);
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }
}
