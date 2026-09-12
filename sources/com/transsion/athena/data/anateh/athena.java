package com.transsion.athena.data.anateh;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.cloud.config.utils.CommonUtils;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.athena.config.data.model.ehanat;
import com.transsion.athena.data.anateh.anehat;
import java.io.File;

/* loaded from: classes5.dex */
public class athena extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final String f42731a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f42732b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f42733c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f42734d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f42735e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f42736f;

    /* renamed from: g, reason: collision with root package name */
    private static final String f42737g;

    /* renamed from: h, reason: collision with root package name */
    private static final String f42738h;

    /* renamed from: i, reason: collision with root package name */
    private static final String f42739i;

    /* renamed from: j, reason: collision with root package name */
    private final File f42740j;

    static {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("CREATE TABLE ");
        anehat.athena athenaVar = anehat.athena.f42726a;
        sb2.append(athenaVar.a());
        sb2.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb2.append("tid");
        sb2.append(" INTEGER NOT NULL,");
        sb2.append(NotificationCompat.CATEGORY_EVENT);
        sb2.append(" TEXT NOT NULL,");
        sb2.append("et");
        sb2.append(" INTEGER NOT NULL,");
        sb2.append("pi");
        sb2.append(" INTEGER NOT NULL,");
        sb2.append("created_at");
        sb2.append(" INTEGER NOT NULL,");
        sb2.append(CommonUtils.PARAM_UID);
        sb2.append(" TEXT,");
        sb2.append("ext");
        sb2.append(" TEXT,");
        sb2.append("er_ts");
        sb2.append(" INTEGER DEFAULT 0,");
        sb2.append("boot_id");
        sb2.append(" TEXT)");
        f42731a = sb2.toString();
        f42732b = "CREATE TABLE " + anehat.athena.f42728c.a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, tid INTEGER NOT NULL UNIQUE,ev TEXT,pt INTEGER DEFAULT 0,cf TEXT,ext TEXT)";
        f42733c = "CREATE TABLE " + anehat.athena.f42729d.a() + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + SafeStringUtils.SP_APPID + " INTEGER NOT NULL UNIQUE,base TEXT,cfg TEXT," + CommonUtils.PARAM_UID + " TEXT,try INTEGER DEFAULT 0,date TEXT,cnt INTEGER DEFAULT 0,ext TEXT)";
        StringBuilder sb3 = new StringBuilder();
        sb3.append("ALTER TABLE ");
        sb3.append(athenaVar.a());
        sb3.append(" ADD COLUMN ");
        sb3.append(CommonUtils.PARAM_UID);
        sb3.append(" TEXT");
        f42734d = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("ALTER TABLE ");
        sb4.append(athenaVar.a());
        sb4.append(" ADD COLUMN ");
        sb4.append("ext");
        sb4.append(" TEXT");
        f42735e = sb4.toString();
        f42736f = "ALTER TABLE " + athenaVar.a() + " ADD COLUMN er_ts INTEGER";
        f42737g = "ALTER TABLE " + athenaVar.a() + " ADD COLUMN boot_id TEXT";
        f42738h = "CREATE INDEX IF NOT EXISTS t_idx ON " + athenaVar.a() + " (tid,created_at)";
        StringBuilder sb5 = new StringBuilder();
        sb5.append("DROP TABLE ");
        sb5.append(athenaVar.a());
        f42739i = sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public athena(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 6);
        this.f42740j = context.getDatabasePath(str);
    }

    public void a() {
        close();
        if (this.f42740j.delete()) {
            com.transsion.athena.taaneh.aethna.a("mDatabaseFile deleted");
        }
    }

    public boolean b() {
        return this.f42740j.exists() && this.f42740j.length() > ((long) ehanat.k());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        super.onConfigure(sQLiteDatabase);
        sQLiteDatabase.enableWriteAheadLogging();
        Cursor cursor = null;
        try {
            cursor = sQLiteDatabase.rawQuery("PRAGMA mmap_size=0;", null);
            cursor.moveToFirst();
            cursor.close();
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        com.transsion.athena.taaneh.aethna.a("Creating a new Athena DB");
        try {
            try {
                sQLiteDatabase.beginTransaction();
                sQLiteDatabase.execSQL(f42731a);
                sQLiteDatabase.execSQL(f42738h);
                sQLiteDatabase.execSQL(f42732b);
                sQLiteDatabase.execSQL(f42733c);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e11) {
                com.transsion.athena.taaneh.aethna.a(Log.getStackTraceString(e11));
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        com.transsion.athena.taaneh.aethna.a("Upgrading app, replacing Athena DB oldVersion = " + i11);
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (i11 < 4) {
                    sQLiteDatabase.execSQL(f42732b);
                    sQLiteDatabase.execSQL(f42733c);
                }
                if (i11 < 3) {
                    try {
                        sQLiteDatabase.execSQL(f42734d);
                    } catch (SQLiteException e11) {
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
                        sQLiteDatabase.execSQL(f42739i);
                        sQLiteDatabase.execSQL(f42731a);
                    }
                }
                if (i11 < 5) {
                    sQLiteDatabase.execSQL(f42735e);
                }
                if (i11 < 6) {
                    sQLiteDatabase.execSQL(f42736f);
                    sQLiteDatabase.execSQL(f42737g);
                }
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e12) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e12));
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }
}
