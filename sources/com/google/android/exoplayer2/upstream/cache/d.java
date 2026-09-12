package com.google.android.exoplayer2.upstream.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.exoplayer2.database.DatabaseIOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
final class d {

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f27387c = {"name", "length", "last_touch_timestamp"};

    /* renamed from: a, reason: collision with root package name */
    private final f9.a f27388a;

    /* renamed from: b, reason: collision with root package name */
    private String f27389b;

    public d(f9.a aVar) {
        this.f27388a = aVar;
    }

    private static void a(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }

    private Cursor c() {
        com.google.android.exoplayer2.util.a.e(this.f27389b);
        return this.f27388a.getReadableDatabase().query(this.f27389b, f27387c, null, null, null, null, null);
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
                    hashMap.put((String) com.google.android.exoplayer2.util.a.e(c11.getString(0)), new c(c11.getLong(1), c11.getLong(2)));
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
            this.f27389b = d(hexString);
            if (f9.c.b(this.f27388a.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = this.f27388a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    f9.c.d(writableDatabase, 2, hexString, 1);
                    a(writableDatabase, this.f27389b);
                    writableDatabase.execSQL("CREATE TABLE " + this.f27389b + " (name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
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
        com.google.android.exoplayer2.util.a.e(this.f27389b);
        try {
            this.f27388a.getWritableDatabase().delete(this.f27389b, "name = ?", new String[]{str});
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }

    public void g(Set set) {
        com.google.android.exoplayer2.util.a.e(this.f27389b);
        try {
            SQLiteDatabase writableDatabase = this.f27388a.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            try {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    writableDatabase.delete(this.f27389b, "name = ?", new String[]{(String) it.next()});
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
        com.google.android.exoplayer2.util.a.e(this.f27389b);
        try {
            SQLiteDatabase writableDatabase = this.f27388a.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("length", Long.valueOf(j11));
            contentValues.put("last_touch_timestamp", Long.valueOf(j12));
            writableDatabase.replaceOrThrow(this.f27389b, null, contentValues);
        } catch (SQLException e11) {
            throw new DatabaseIOException(e11);
        }
    }
}
