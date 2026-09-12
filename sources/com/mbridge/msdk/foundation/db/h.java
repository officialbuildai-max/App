package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.Campaign;

/* loaded from: classes5.dex */
public class h extends a<Campaign> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35150a = "com.mbridge.msdk.foundation.db.h";

    /* renamed from: b, reason: collision with root package name */
    private static h f35151b;

    private h(f fVar) {
        super(fVar);
    }

    public static h a(f fVar) {
        if (f35151b == null) {
            synchronized (h.class) {
                try {
                    if (f35151b == null) {
                        f35151b = new h(fVar);
                    }
                } finally {
                }
            }
        }
        return f35151b;
    }

    private synchronized void c(String str) {
        try {
        } catch (Throwable unused) {
            o0.c(f35150a, "resetTimeAndTimestamp error");
        }
        if (getWritableDatabase() == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("first_insert_timestamp", (Integer) 0);
        contentValues.put("play_time", (Integer) 0);
        getWritableDatabase().update("dailyplaycap", contentValues, "unit_id = ?", new String[]{str});
    }

    public synchronized boolean a(String str) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT play_time FROM dailyplaycap WHERE unit_id= ?", new String[]{str});
            if (rawQuery != null && rawQuery.getCount() > 0) {
                rawQuery.close();
                return true;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0053, code lost:
    
        if (r0 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006e, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
    
        if (r0 == null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r11, int r12) {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            java.lang.String r2 = "SELECT * FROM dailyplaycap where unit_id = ?"
            android.database.sqlite.SQLiteDatabase r3 = r10.getReadableDatabase()     // Catch: java.lang.Throwable -> L49
            java.lang.String[] r4 = new java.lang.String[]{r11}     // Catch: java.lang.Throwable -> L49
            android.database.Cursor r0 = r3.rawQuery(r2, r4)     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L53
            int r2 = r0.getCount()     // Catch: java.lang.Throwable -> L49
            if (r2 <= 0) goto L53
            boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L49
            if (r2 == 0) goto L53
            java.lang.String r2 = "first_insert_timestamp"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L49
            long r2 = r0.getLong(r2)     // Catch: java.lang.Throwable -> L49
            java.lang.String r4 = "play_time"
            int r4 = r0.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L49
            int r4 = r0.getInt(r4)     // Catch: java.lang.Throwable -> L49
            long r4 = (long) r4     // Catch: java.lang.Throwable -> L49
            r6 = 0
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 == 0) goto L53
            long r6 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L49
            r8 = 86400000(0x5265c00, double:4.2687272E-316)
            long r6 = r6 - r8
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r2 <= 0) goto L4b
            r10.c(r11)     // Catch: java.lang.Throwable -> L49
            goto L53
        L49:
            r11 = move-exception
            goto L56
        L4b:
            if (r12 <= 0) goto L53
            long r11 = (long) r12
            int r11 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r11 < 0) goto L53
            r1 = 1
        L53:
            if (r0 == 0) goto L71
            goto L6e
        L56:
            java.lang.String r12 = com.mbridge.msdk.foundation.db.h.f35150a     // Catch: java.lang.Throwable -> L72
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L72
            r2.<init>()     // Catch: java.lang.Throwable -> L72
            java.lang.String r3 = "isOverCap is error"
            r2.append(r3)     // Catch: java.lang.Throwable -> L72
            r2.append(r11)     // Catch: java.lang.Throwable -> L72
            java.lang.String r11 = r2.toString()     // Catch: java.lang.Throwable -> L72
            com.mbridge.msdk.foundation.tools.o0.c(r12, r11)     // Catch: java.lang.Throwable -> L72
            if (r0 == 0) goto L71
        L6e:
            r0.close()     // Catch: java.lang.Throwable -> L71
        L71:
            return r1
        L72:
            r11 = move-exception
            if (r0 == 0) goto L78
            r0.close()     // Catch: java.lang.Throwable -> L78
        L78:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.h.a(java.lang.String, int):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a8, code lost:
    
        if (r1 != null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b0, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ae, code lost:
    
        if (0 == 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void b(java.lang.String r16) {
        /*
            r15 = this;
            monitor-enter(r15)
            r1 = 0
            android.database.sqlite.SQLiteDatabase r0 = r15.getWritableDatabase()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            if (r0 != 0) goto La
            monitor-exit(r15)
            return
        La:
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r0.<init>()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            boolean r4 = r15.a(r16)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r5 = 1
            if (r4 == 0) goto L86
            java.lang.String r4 = "SELECT * FROM dailyplaycap where unit_id = ?"
            android.database.sqlite.SQLiteDatabase r7 = r15.getReadableDatabase()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            java.lang.String[] r8 = new java.lang.String[]{r16}     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            android.database.Cursor r1 = r7.rawQuery(r4, r8)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r7 = 0
            if (r1 == 0) goto L5d
            int r4 = r1.getCount()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            if (r4 <= 0) goto L5d
            r1.moveToFirst()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            java.lang.String r4 = "first_insert_timestamp"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            long r9 = r1.getLong(r4)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            java.lang.String r4 = "play_time"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            int r4 = r1.getInt(r4)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            long r11 = (long) r4     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r13 = 86400000(0x5265c00, double:4.2687272E-316)
            long r13 = r2 - r13
            int r4 = (r13 > r9 ? 1 : (r13 == r9 ? 0 : -1))
            if (r4 <= 0) goto L5f
            r15.c(r16)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r11 = r7
            goto L5f
        L59:
            r0 = move-exception
            goto Lb5
        L5b:
            r0 = move-exception
            goto Lab
        L5d:
            r9 = r7
            r11 = r9
        L5f:
            int r4 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r4 != 0) goto L6c
            java.lang.String r4 = "first_insert_timestamp"
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r0.put(r4, r2)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
        L6c:
            java.lang.String r2 = "play_time"
            long r11 = r11 + r5
            java.lang.Long r3 = java.lang.Long.valueOf(r11)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r0.put(r2, r3)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            java.lang.String r2 = "unit_id = ?"
            android.database.sqlite.SQLiteDatabase r3 = r15.getWritableDatabase()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            java.lang.String r4 = "dailyplaycap"
            java.lang.String[] r5 = new java.lang.String[]{r16}     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r3.update(r4, r0, r2, r5)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            goto La8
        L86:
            java.lang.String r4 = "first_insert_timestamp"
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r0.put(r4, r2)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            java.lang.String r2 = "play_time"
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r0.put(r2, r3)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            java.lang.String r2 = "unit_id"
            r3 = r16
            r0.put(r2, r3)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            android.database.sqlite.SQLiteDatabase r2 = r15.getWritableDatabase()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            java.lang.String r3 = "dailyplaycap"
            r2.insert(r3, r1, r0)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
        La8:
            if (r1 == 0) goto Lb3
            goto Lb0
        Lab:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L59
            if (r1 == 0) goto Lb3
        Lb0:
            r1.close()     // Catch: java.lang.Throwable -> Lb3
        Lb3:
            monitor-exit(r15)
            return
        Lb5:
            if (r1 == 0) goto Lba
            r1.close()     // Catch: java.lang.Throwable -> Lba
        Lba:
            throw r0     // Catch: java.lang.Throwable -> Lbb
        Lbb:
            r0 = move-exception
            monitor-exit(r15)     // Catch: java.lang.Throwable -> Lbb
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.h.b(java.lang.String):void");
    }
}
