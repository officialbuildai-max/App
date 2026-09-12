package com.mbridge.msdk.tracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.hisavana.common.tracking.TrackingKey;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final b f38552a;

    /* renamed from: b, reason: collision with root package name */
    private final String f38553b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f38554c = new Object();

    public c(b bVar, String str) {
        this.f38552a = bVar;
        this.f38553b = str;
    }

    private static void a(SQLiteDatabase sQLiteDatabase) {
        if (y.b(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.beginTransaction();
        } catch (Exception e11) {
            if (a.f38550a) {
                Log.e("TrackManager", "beginTransaction: ", e11);
            }
        }
    }

    private static void b(SQLiteDatabase sQLiteDatabase) {
        if (y.b(sQLiteDatabase) || !sQLiteDatabase.inTransaction()) {
            return;
        }
        try {
            sQLiteDatabase.endTransaction();
        } catch (Exception e11) {
            if (a.f38550a) {
                Log.e("TrackManager", "endTransaction: ", e11);
            }
        }
    }

    private static boolean c(SQLiteDatabase sQLiteDatabase) {
        return sQLiteDatabase == null || !sQLiteDatabase.isOpen() || sQLiteDatabase.isReadOnly();
    }

    private static void d(SQLiteDatabase sQLiteDatabase) {
        if (y.b(sQLiteDatabase)) {
            return;
        }
        try {
            sQLiteDatabase.setTransactionSuccessful();
        } catch (Exception e11) {
            if (a.f38550a) {
                Log.e("TrackManager", "transactionSuccess: ", e11);
            }
        }
    }

    public int a() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.f38554c) {
            int i11 = -1;
            if (y.b(this.f38552a)) {
                return -1;
            }
            try {
                sQLiteDatabase = this.f38552a.getWritableDatabase();
            } catch (Exception e11) {
                if (a.f38550a) {
                    Log.e("TrackManager", "deleteInvalidEvents getWritableDatabase: " + e11.getMessage());
                }
                sQLiteDatabase = null;
            }
            if (c(sQLiteDatabase)) {
                return -1;
            }
            try {
                try {
                    a(sQLiteDatabase);
                    i11 = sQLiteDatabase.delete(this.f38553b, "state = ? OR state = ?", new String[]{String.valueOf(-1), String.valueOf(2)});
                    d(sQLiteDatabase);
                    b(sQLiteDatabase);
                } catch (Exception e12) {
                    if (a.f38550a) {
                        Log.e("TrackManager", "deleteInvalidEvents: " + e12.getMessage());
                    }
                }
                return i11;
            } finally {
                b(sQLiteDatabase);
            }
        }
    }

    public long a(i iVar) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.f38554c) {
            long j11 = -1;
            if (y.b(this.f38552a)) {
                return -1L;
            }
            try {
                sQLiteDatabase = this.f38552a.getWritableDatabase();
            } catch (Exception e11) {
                if (a.f38550a) {
                    Log.e("TrackManager", "insert getWritableDatabase: " + e11.getMessage());
                }
                sQLiteDatabase = null;
            }
            if (c(sQLiteDatabase)) {
                return -1L;
            }
            try {
                a(sQLiteDatabase);
                ContentValues contentValues = new ContentValues(16);
                e a11 = iVar.a();
                contentValues.put("name", a11.b());
                contentValues.put(NativeComponentConstants.KEY_COMPONENT_TYPE, Integer.valueOf(a11.h()));
                contentValues.put("time_stamp", Long.valueOf(a11.g()));
                contentValues.put("properties", a11.d().toString());
                contentValues.put(TrackingKey.PRIORITY, Integer.valueOf(a11.c()));
                contentValues.put("state", Integer.valueOf(iVar.e()));
                contentValues.put("report_count", Integer.valueOf(iVar.c()));
                contentValues.put("uuid", a11.i());
                contentValues.put("ignore_max_timeout", Integer.valueOf(!a11.k() ? 1 : 0));
                contentValues.put("ignore_max_retry_times", Integer.valueOf(!a11.j() ? 1 : 0));
                contentValues.put("invalid_time", Long.valueOf(iVar.b()));
                j11 = sQLiteDatabase.insert(this.f38553b, null, contentValues);
                d(sQLiteDatabase);
            } catch (Exception e12) {
                if (a.f38550a) {
                    Log.e("TrackManager", "insert: " + e12.getMessage());
                }
            } finally {
                b(sQLiteDatabase);
            }
            return j11;
        }
    }

    public List<i> a(int i11) {
        SQLiteDatabase sQLiteDatabase;
        Throwable th2;
        Cursor cursor;
        List<i> list;
        synchronized (this.f38554c) {
            Cursor cursor2 = null;
            List<i> list2 = null;
            cursor2 = null;
            if (y.b(this.f38552a)) {
                return null;
            }
            try {
                sQLiteDatabase = this.f38552a.getWritableDatabase();
            } catch (Exception e11) {
                if (a.f38550a) {
                    Log.e("TrackManager", "getAvailable getWritableDatabase: " + e11.getMessage());
                }
                sQLiteDatabase = null;
            }
            if (c(sQLiteDatabase)) {
                return null;
            }
            try {
                try {
                    a(sQLiteDatabase);
                    cursor = sQLiteDatabase.query(this.f38553b, null, "state = ? OR state = ?", new String[]{String.valueOf(0), String.valueOf(3)}, null, null, "priority DESC", String.valueOf(i11));
                } catch (Exception e12) {
                    e = e12;
                    list = null;
                }
            } catch (Throwable th3) {
                Cursor cursor3 = cursor2;
                th2 = th3;
                cursor = cursor3;
            }
            try {
                list2 = y.b(cursor);
                d(sQLiteDatabase);
                b(sQLiteDatabase);
                y.a(cursor);
            } catch (Exception e13) {
                e = e13;
                List<i> list3 = list2;
                cursor2 = cursor;
                list = list3;
                if (a.f38550a) {
                    Log.e("TrackManager", "getAvailable: " + e.getMessage());
                }
                b(sQLiteDatabase);
                y.a(cursor2);
                list2 = list;
                return list2;
            } catch (Throwable th4) {
                th2 = th4;
                b(sQLiteDatabase);
                y.a(cursor);
                throw th2;
            }
            return list2;
        }
    }

    public void a(List<i> list) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.f38554c) {
            if (y.b(this.f38552a) || y.b((List<?>) list)) {
                return;
            }
            try {
                sQLiteDatabase = this.f38552a.getWritableDatabase();
            } catch (Exception e11) {
                if (a.f38550a) {
                    Log.e("TrackManager", "updateReportStateFailed getWritableDatabase: " + e11.getMessage());
                }
                sQLiteDatabase = null;
            }
            if (c(sQLiteDatabase)) {
                return;
            }
            try {
                try {
                    a(sQLiteDatabase);
                    for (i iVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", Integer.valueOf(iVar.e()));
                        contentValues.put("report_count", Integer.valueOf(iVar.c()));
                        String d11 = iVar.d();
                        if (!TextUtils.isEmpty(d11)) {
                            contentValues.put("report_error_message", d11);
                        }
                        sQLiteDatabase.update(this.f38553b, contentValues, "uuid = ?", new String[]{iVar.f()});
                    }
                    d(sQLiteDatabase);
                    b(sQLiteDatabase);
                } catch (Exception e12) {
                    if (a.f38550a) {
                        Log.e("TrackManager", "updateReportStateFailed: " + e12.getMessage());
                    }
                    b(sQLiteDatabase);
                }
            } catch (Throwable th2) {
                b(sQLiteDatabase);
                throw th2;
            }
        }
    }

    public int b() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.f38554c) {
            int i11 = 0;
            if (y.b(this.f38552a)) {
                return 0;
            }
            Cursor cursor = null;
            try {
                sQLiteDatabase = this.f38552a.getWritableDatabase();
            } catch (Exception e11) {
                if (a.f38550a) {
                    Log.e("TrackManager", "getAvailableCount getWritableDatabase: " + e11.getMessage());
                }
                sQLiteDatabase = null;
            }
            try {
                if (c(sQLiteDatabase)) {
                    return 0;
                }
                try {
                    a(sQLiteDatabase);
                    cursor = sQLiteDatabase.query(this.f38553b, null, "state = ? OR state = ?", new String[]{String.valueOf(3), String.valueOf(0)}, null, null, null, null);
                    if (cursor != null && cursor.moveToNext()) {
                        i11 = Math.max(cursor.getCount(), 0);
                    }
                    d(sQLiteDatabase);
                    b(sQLiteDatabase);
                    y.a(cursor);
                } catch (Exception e12) {
                    if (a.f38550a) {
                        Log.e("TrackManager", "getAvailableCount: " + e12.getMessage());
                    }
                    b(sQLiteDatabase);
                    y.a(cursor);
                }
                return i11;
            } catch (Throwable th2) {
                b(sQLiteDatabase);
                y.a(cursor);
                throw th2;
            }
        }
    }

    public void b(List<i> list) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.f38554c) {
            if (y.b(this.f38552a) || y.b((List<?>) list)) {
                return;
            }
            try {
                sQLiteDatabase = this.f38552a.getWritableDatabase();
            } catch (Exception e11) {
                if (a.f38550a) {
                    Log.e("TrackManager", "updateReportStateReporting getWritableDatabase: " + e11.getMessage());
                }
                sQLiteDatabase = null;
            }
            if (c(sQLiteDatabase)) {
                return;
            }
            try {
                try {
                    a(sQLiteDatabase);
                    for (i iVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", (Integer) 1);
                        sQLiteDatabase.update(this.f38553b, contentValues, "uuid = ?", new String[]{iVar.f()});
                    }
                    d(sQLiteDatabase);
                    b(sQLiteDatabase);
                } catch (Exception e12) {
                    if (a.f38550a) {
                        Log.e("TrackManager", "updateReportStateReporting: " + e12.getMessage());
                    }
                    b(sQLiteDatabase);
                }
            } catch (Throwable th2) {
                b(sQLiteDatabase);
                throw th2;
            }
        }
    }

    public void c() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.f38554c) {
            if (y.b(this.f38552a)) {
                return;
            }
            try {
                sQLiteDatabase = this.f38552a.getWritableDatabase();
            } catch (Exception e11) {
                if (a.f38550a) {
                    Log.e("TrackManager", "updateReportStateForReporting getWritableDatabase: " + e11.getMessage());
                }
                sQLiteDatabase = null;
            }
            if (c(sQLiteDatabase)) {
                return;
            }
            try {
                try {
                    a(sQLiteDatabase);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("state", (Integer) 3);
                    contentValues.put("report_error_message", "update from reporting");
                    sQLiteDatabase.update(this.f38553b, contentValues, "state = ?", new String[]{String.valueOf(1)});
                    d(sQLiteDatabase);
                    b(sQLiteDatabase);
                } catch (Exception e12) {
                    if (a.f38550a) {
                        Log.e("TrackManager", "updateReportStateForReporting: " + e12.getMessage());
                    }
                }
            } finally {
                b(sQLiteDatabase);
            }
        }
    }

    public void c(List<i> list) {
        SQLiteDatabase sQLiteDatabase;
        synchronized (this.f38554c) {
            if (y.b(this.f38552a) || y.b((List<?>) list)) {
                return;
            }
            try {
                sQLiteDatabase = this.f38552a.getWritableDatabase();
            } catch (Exception e11) {
                if (a.f38550a) {
                    Log.e("TrackManager", "updateReportStateSuccess getWritableDatabase: " + e11.getMessage());
                }
                sQLiteDatabase = null;
            }
            if (c(sQLiteDatabase)) {
                return;
            }
            try {
                try {
                    a(sQLiteDatabase);
                    for (i iVar : list) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("state", (Integer) 2);
                        sQLiteDatabase.update(this.f38553b, contentValues, "uuid = ?", new String[]{iVar.f()});
                    }
                    d(sQLiteDatabase);
                    b(sQLiteDatabase);
                } catch (Exception e12) {
                    if (a.f38550a) {
                        Log.e("TrackManager", "updateReportStateSuccess: " + e12.getMessage());
                    }
                    b(sQLiteDatabase);
                }
            } catch (Throwable th2) {
                b(sQLiteDatabase);
                throw th2;
            }
        }
    }
}
