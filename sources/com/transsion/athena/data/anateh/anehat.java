package com.transsion.athena.data.anateh;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.cloud.config.utils.CommonUtils;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.athena.config.data.model.TidConfigBean;
import com.transsion.athena.config.data.model.aatnhe;
import com.transsion.athena.data.AppIdData;
import com.transsion.ga.anateh;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class anehat {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile anehat f42723a;

    /* renamed from: b, reason: collision with root package name */
    private com.transsion.athena.data.anateh.athena f42724b;

    /* renamed from: c, reason: collision with root package name */
    private Context f42725c;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class athena {

        /* renamed from: a, reason: collision with root package name */
        public static final athena f42726a = new athena("EVENTS", 0, "events");

        /* renamed from: b, reason: collision with root package name */
        public static final athena f42727b = new athena("COUNTER", 1, "counter");

        /* renamed from: c, reason: collision with root package name */
        public static final athena f42728c = new athena("TID_CONFIG", 2, "tidconfig");

        /* renamed from: d, reason: collision with root package name */
        public static final athena f42729d = new athena("APPID_CONFIG", 3, "appidconfig");

        /* renamed from: e, reason: collision with root package name */
        private final String f42730e;

        private athena(String str, int i11, String str2) {
            this.f42730e = str2;
        }

        public String a() {
            return this.f42730e;
        }
    }

    private anehat(Context context) {
        try {
            this.f42725c = context;
            this.f42724b = new com.transsion.athena.data.anateh.athena(context, "athena.db");
        } catch (Exception e11) {
            com.transsion.athena.taaneh.aethna.b(e11.getMessage());
        }
    }

    public static synchronized anehat a(Context context) {
        anehat anehatVar;
        synchronized (anehat.class) {
            try {
                if (f42723a == null) {
                    synchronized (anehat.class) {
                        try {
                            if (f42723a == null) {
                                f42723a = new anehat(context);
                            }
                        } finally {
                        }
                    }
                }
                anehatVar = f42723a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return anehatVar;
    }

    private void a(SQLiteException sQLiteException) {
        try {
            if (sQLiteException instanceof SQLiteFullException) {
                this.f42724b.close();
            } else {
                this.f42724b.close();
                this.f42724b.a();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private SQLiteDatabase b() {
        try {
            if (!this.f42725c.getDatabasePath("athena.db").exists()) {
                this.f42724b.close();
            }
            return this.f42724b.getWritableDatabase();
        } catch (SQLiteException e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            return null;
        }
    }

    public int a(athena athenaVar, int i11, enatha<String> enathaVar) throws anateh {
        String a11 = athenaVar.a();
        LongSparseArray longSparseArray = new LongSparseArray();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase b11 = b();
                if (b11 == null) {
                    return 0;
                }
                Cursor rawQuery = b11.rawQuery("SELECT _id,tid FROM " + a11 + " ORDER BY _id LIMIT " + i11, null);
                long j11 = 0;
                while (rawQuery != null && rawQuery.moveToNext()) {
                    long j12 = rawQuery.getLong(rawQuery.getColumnIndex("tid"));
                    longSparseArray.put(j12, Integer.valueOf(((Integer) longSparseArray.get(j12, 0)).intValue() + 1));
                    j11 = rawQuery.getLong(rawQuery.getColumnIndex("_id"));
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                int delete = b11.delete(a11, "_id<=" + j11 + " AND CAST(tid AS TEXT) NOT LIKE ?", new String[]{"9999%"});
                if (enathaVar != null && longSparseArray.size() > 0) {
                    enathaVar.a(longSparseArray.toString());
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return delete;
            } catch (SQLiteException e11) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
                if (0 != 0) {
                    cursor.close();
                }
                a(e11);
                throw new anateh("cleanupEvents_oom_sql", e11);
            }
        } catch (Throwable th2) {
            if (0 != 0) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x0196 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x027f A[Catch: all -> 0x0108, Exception -> 0x01c6, SQLiteException -> 0x01cc, TRY_LEAVE, TryCatch #22 {all -> 0x0108, blocks: (B:95:0x00f2, B:98:0x00f9, B:101:0x0123, B:106:0x0133, B:109:0x013f, B:112:0x0145, B:115:0x014e, B:118:0x0154, B:121:0x0175, B:130:0x0196, B:133:0x01aa, B:135:0x01af, B:140:0x01bd, B:142:0x01d8, B:145:0x027f, B:148:0x01d2, B:151:0x01f9), top: B:94:0x00f2 }] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0366 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x03ba A[Catch: all -> 0x03aa, TryCatch #4 {all -> 0x03aa, blocks: (B:40:0x039b, B:41:0x03a9, B:33:0x03b1, B:35:0x03ba, B:36:0x03bd, B:37:0x03c7), top: B:2:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x03d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(com.transsion.athena.data.anateh.anehat.athena r30, com.transsion.athena.data.Track r31, int r32) throws com.transsion.ga.anateh {
        /*
            Method dump skipped, instructions count: 985
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.data.anateh.anehat.a(com.transsion.athena.data.anateh.anehat$athena, com.transsion.athena.data.Track, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02b4 A[Catch: all -> 0x02a8, TRY_LEAVE, TryCatch #4 {all -> 0x02a8, blocks: (B:154:0x0299, B:155:0x02a7, B:143:0x02ab, B:145:0x02b4), top: B:6:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.transsion.athena.data.anehat a(com.transsion.athena.data.anateh.anehat.athena r33, long r34, long r36, java.lang.String r38, int r39, int r40) throws com.transsion.ga.anateh {
        /*
            Method dump skipped, instructions count: 715
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.data.anateh.anehat.a(com.transsion.athena.data.anateh.anehat$athena, long, long, java.lang.String, int, int):com.transsion.athena.data.anehat");
    }

    public List<AppIdData> a(athena athenaVar) throws anateh {
        String a11 = athenaVar.a();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase b11 = b();
                if (b11 == null) {
                    return arrayList;
                }
                cursor = b11.rawQuery("SELECT * FROM " + a11, null);
                while (cursor != null) {
                    if (!cursor.moveToNext()) {
                        break;
                    }
                    AppIdData appIdData = new AppIdData();
                    appIdData.f42696a = cursor.getInt(cursor.getColumnIndex(SafeStringUtils.SP_APPID));
                    appIdData.f42697b = cursor.getString(cursor.getColumnIndex("base"));
                    appIdData.f42698c = cursor.getString(cursor.getColumnIndex(CommonUtils.PARAM_UID));
                    appIdData.f42699d = cursor.getInt(cursor.getColumnIndex("try"));
                    arrayList.add(appIdData);
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (SQLiteException e11) {
                com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
                if (cursor != null) {
                    cursor.close();
                }
                a(e11);
                throw new anateh("getAppIdList_sql", e11);
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public void a() {
        com.transsion.athena.taaneh.aethna.a("deleteDB");
        try {
            this.f42724b.a();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.transsion.athena.data.anateh.anehat.athena r11, com.transsion.athena.config.data.model.athena r12, boolean r13) throws com.transsion.ga.anateh {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.data.anateh.anehat.a(com.transsion.athena.data.anateh.anehat$athena, com.transsion.athena.config.data.model.athena, boolean):void");
    }

    public void a(athena athenaVar, AppIdData appIdData) throws anateh {
        String a11 = athenaVar.a();
        try {
            SQLiteDatabase b11 = b();
            if (b11 == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(SafeStringUtils.SP_APPID, Integer.valueOf(appIdData.f42696a));
            contentValues.put("base", appIdData.f42697b);
            if (b11.update(a11, contentValues, "appid=" + appIdData.f42696a, null) != 1) {
                b11.insert(a11, null, contentValues);
            }
        } catch (SQLiteException e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            a(e11);
            throw new anateh("addAppId_sql", e11);
        }
    }

    public void a(athena athenaVar, String str, long j11) throws anateh {
        String a11 = athenaVar.a();
        try {
            SQLiteDatabase b11 = b();
            if (b11 == null) {
                return;
            }
            b11.execSQL("UPDATE " + a11 + " SET created_at = er_ts + " + j11 + ", boot_id = '' WHERE boot_id = '" + str + "'");
        } catch (SQLiteException e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            a(e11);
            throw new anateh("updateEvents_sql", e11);
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0064: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:40:0x0064 */
    public void a(athena athenaVar, List<AppIdData> list) throws anateh {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        String a11 = athenaVar.a();
        StringBuilder sb2 = new StringBuilder();
        SQLiteDatabase sQLiteDatabase3 = null;
        try {
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase3 = sQLiteDatabase;
        }
        try {
            try {
                sQLiteDatabase2 = b();
                if (sQLiteDatabase2 == null) {
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.endTransaction();
                        return;
                    }
                    return;
                }
                try {
                    sQLiteDatabase2.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(CommonUtils.PARAM_UID, "");
                    for (AppIdData appIdData : list) {
                        sQLiteDatabase2.update(athena.f42726a.a(), contentValues, "CAST(tid AS TEXT) LIKE ? AND uid=?", new String[]{appIdData.f42696a + "%", appIdData.f42698c});
                        com.transsion.athena.config.data.model.anehat.a(sb2, Integer.valueOf(appIdData.f42696a));
                    }
                    contentValues.put("try", (Integer) 0);
                    sQLiteDatabase2.update(a11, contentValues, "appid IN (" + sb2.toString() + ")", null);
                    sQLiteDatabase2.setTransactionSuccessful();
                    sQLiteDatabase2.endTransaction();
                } catch (SQLiteException e11) {
                    e = e11;
                    com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                    if (sQLiteDatabase2 != null) {
                        sQLiteDatabase2.endTransaction();
                    } else {
                        sQLiteDatabase3 = sQLiteDatabase2;
                    }
                    a(e);
                    throw new anateh("updateAppIdList_sql", e);
                }
            } catch (SQLiteException e12) {
                e = e12;
                sQLiteDatabase2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            if (sQLiteDatabase3 != null) {
                sQLiteDatabase3.endTransaction();
            }
            throw th;
        }
    }

    public void a(athena athenaVar, List<AppIdData> list, int i11) throws anateh {
        String a11 = athenaVar.a();
        StringBuilder sb2 = new StringBuilder();
        try {
            for (AppIdData appIdData : list) {
                com.transsion.athena.config.data.model.anehat.a(sb2, Integer.valueOf(appIdData.f42696a));
                appIdData.f42699d = i11;
            }
            SQLiteDatabase b11 = b();
            if (b11 == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("try", Integer.valueOf(i11));
            b11.update(a11, contentValues, "appid IN (" + sb2.toString() + ")", null);
        } catch (SQLiteException e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            a(e11);
            throw new anateh("updateEvents_sql", e11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0276 A[Catch: all -> 0x00c6, TryCatch #2 {all -> 0x00c6, blocks: (B:46:0x0088, B:48:0x008e, B:57:0x00a3, B:64:0x00c1, B:60:0x00d7, B:68:0x00ce, B:76:0x00e2, B:12:0x026d, B:14:0x0276, B:16:0x027b), top: B:2:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x027b A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #2 {all -> 0x00c6, blocks: (B:46:0x0088, B:48:0x008e, B:57:0x00a3, B:64:0x00c1, B:60:0x00d7, B:68:0x00ce, B:76:0x00e2, B:12:0x026d, B:14:0x0276, B:16:0x027b), top: B:2:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0282  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.transsion.athena.data.anateh.anehat.athena r22, java.util.List<com.transsion.athena.data.AppIdData> r23, long r24, java.lang.String r26, com.transsion.athena.data.anateh.enatha<android.util.SparseArray<com.transsion.athena.data.enatha>> r27) throws com.transsion.ga.anateh {
        /*
            Method dump skipped, instructions count: 671
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.data.anateh.anehat.a(com.transsion.athena.data.anateh.anehat$athena, java.util.List, long, java.lang.String, com.transsion.athena.data.anateh.enatha):void");
    }

    public void a(athena athenaVar, List<Long> list, enatha<String> enathaVar) throws anateh {
        String a11 = athenaVar.a();
        String a12 = com.transsion.athena.config.data.model.anehat.a(list, ",");
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase b11 = b();
                if (b11 == null) {
                    return;
                }
                LongSparseArray longSparseArray = new LongSparseArray();
                Cursor rawQuery = b11.rawQuery("SELECT tid FROM " + a11 + " WHERE tid IN (" + a12 + ")", null);
                while (rawQuery != null) {
                    try {
                        if (!rawQuery.moveToNext()) {
                            break;
                        }
                        long j11 = rawQuery.getLong(0);
                        longSparseArray.put(j11, Integer.valueOf(((Integer) longSparseArray.get(j11, 0)).intValue() + 1));
                    } catch (SQLiteException e11) {
                        e = e11;
                        cursor = rawQuery;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                        if (cursor != null) {
                            cursor.close();
                        }
                        a(e);
                        throw new anateh("cleanupEvents_off_sql", e);
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                b11.delete(a11, "tid IN (" + a12 + ")", null);
                if (enathaVar != null && longSparseArray.size() > 0) {
                    enathaVar.a(longSparseArray.toString());
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } catch (SQLiteException e12) {
                e = e12;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0081: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:37:0x0081 */
    public void a(athena athenaVar, List<AppIdData> list, String str) throws anateh {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        String a11 = athenaVar.a();
        StringBuilder sb2 = new StringBuilder();
        SQLiteDatabase sQLiteDatabase3 = null;
        try {
            try {
                try {
                    sQLiteDatabase = b();
                    if (sQLiteDatabase == null) {
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                            return;
                        }
                        return;
                    }
                    try {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(CommonUtils.PARAM_UID, str);
                        sQLiteDatabase.beginTransaction();
                        for (AppIdData appIdData : list) {
                            for (com.transsion.athena.data.anehat anehatVar : appIdData.f42700e) {
                                sQLiteDatabase.update(a11, contentValues, "tid=" + anehatVar.f42741a + " AND _id>=" + anehatVar.f42744d + " AND _id<=" + anehatVar.f42745e, null);
                            }
                            com.transsion.athena.config.data.model.anehat.a(sb2, Integer.valueOf(appIdData.f42696a));
                        }
                        contentValues.put("try", (Integer) 0);
                        sQLiteDatabase.update(athena.f42729d.a(), contentValues, "appid IN (" + sb2.toString() + ")", null);
                        sQLiteDatabase.setTransactionSuccessful();
                        sQLiteDatabase.endTransaction();
                    } catch (SQLiteException e11) {
                        e = e11;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                        if (sQLiteDatabase != null) {
                            sQLiteDatabase.endTransaction();
                        }
                        a(e);
                        throw new anateh("updateEvents_sql", e);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    sQLiteDatabase3 = sQLiteDatabase2;
                    if (sQLiteDatabase3 != null) {
                        sQLiteDatabase3.endTransaction();
                    }
                    throw th;
                }
            } catch (SQLiteException e12) {
                e = e12;
                sQLiteDatabase = null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void a(enatha<SparseArray<com.transsion.athena.config.data.model.athena>> enathaVar) throws anateh {
        com.transsion.athena.config.data.model.athena a11;
        SparseArray<com.transsion.athena.config.data.model.athena> sparseArray = new SparseArray<>();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase b11 = b();
                if (b11 == null) {
                    return;
                }
                Cursor rawQuery = b11.rawQuery("SELECT * FROM " + athena.f42729d.a(), null);
                while (rawQuery != null) {
                    try {
                        if (!rawQuery.moveToNext()) {
                            break;
                        }
                        String string = rawQuery.getString(rawQuery.getColumnIndex("cfg"));
                        if (!TextUtils.isEmpty(string) && (a11 = com.transsion.athena.config.data.model.athena.a(string)) != null) {
                            a11.a(rawQuery.getInt(rawQuery.getColumnIndex(SafeStringUtils.SP_APPID)));
                            sparseArray.put(a11.b(), a11);
                        }
                    } catch (SQLiteException e11) {
                        e = e11;
                        cursor = rawQuery;
                        com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e));
                        if (cursor != null) {
                            cursor.close();
                        }
                        a(e);
                        throw new anateh("getAPPIDApp_sql", e);
                    } catch (Throwable th2) {
                        th = th2;
                        cursor = rawQuery;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                cursor = b11.rawQuery("SELECT * FROM " + athena.f42728c.a(), null);
                while (cursor != null && cursor.moveToNext()) {
                    long j11 = cursor.getLong(cursor.getColumnIndex("tid"));
                    String string2 = cursor.getString(cursor.getColumnIndex("ev"));
                    aatnhe aatnheVar = new aatnhe();
                    aatnheVar.c(cursor.getLong(cursor.getColumnIndex("pt")));
                    aatnheVar.a(cursor.getString(cursor.getColumnIndex("cf")));
                    com.transsion.athena.config.data.model.athena athenaVar = sparseArray.get(com.transsion.athena.taaneh.anehat.a(j11));
                    if (athenaVar != null) {
                        athenaVar.a(new TidConfigBean(j11, string2, aatnheVar));
                    }
                }
                if (enathaVar != null) {
                    enathaVar.a(sparseArray);
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (SQLiteException e12) {
            e = e12;
        }
    }

    public void a(boolean z10) {
        if (z10) {
            try {
                this.f42724b.close();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public boolean a(athena athenaVar, int i11) throws anateh {
        String a11 = athenaVar.a();
        try {
            SQLiteDatabase b11 = b();
            if (b11 == null) {
                return false;
            }
            b11.delete(a11, "CAST(tid AS TEXT) LIKE ?", new String[]{i11 + "%"});
            return true;
        } catch (SQLiteException e11) {
            com.transsion.athena.taaneh.aethna.b(Log.getStackTraceString(e11));
            a(e11);
            throw new anateh("cleanupEvents_del_sql", e11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a2  */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v8, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int b(com.transsion.athena.data.anateh.anehat.athena r18, java.util.List<com.transsion.athena.data.Track> r19, com.transsion.athena.data.anateh.enatha<android.util.LongSparseArray<java.lang.Integer>> r20) throws com.transsion.ga.anateh {
        /*
            Method dump skipped, instructions count: 422
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.data.anateh.anehat.b(com.transsion.athena.data.anateh.anehat$athena, java.util.List, com.transsion.athena.data.anateh.enatha):int");
    }
}
