package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import com.mbridge.msdk.MBridgeConstans;

/* loaded from: classes5.dex */
public class l extends a<com.mbridge.msdk.foundation.entity.h> {

    /* renamed from: a, reason: collision with root package name */
    private static l f35156a;

    private l(f fVar) {
        super(fVar);
    }

    public static l a(f fVar) {
        if (f35156a == null) {
            synchronized (l.class) {
                try {
                    if (f35156a == null) {
                        f35156a = new l(fVar);
                    }
                } finally {
                }
            }
        }
        return f35156a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0054, code lost:
    
        if (r0 != null) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.List<com.mbridge.msdk.foundation.entity.i> a(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "select * from unit_id WHERE ad_type = ?"
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r5.getReadableDatabase()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            java.lang.String r3 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            android.database.Cursor r0 = r2.rawQuery(r0, r3)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            if (r0 == 0) goto L54
            int r2 = r0.getCount()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L51
            if (r2 <= 0) goto L54
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L51
            int r3 = r0.getCount()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L51
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L51
        L25:
            boolean r1 = r0.moveToNext()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            if (r1 == 0) goto L4d
            java.lang.String r1 = "placement_id"
            int r1 = r0.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.lang.String r3 = "unitId"
            int r3 = r0.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            java.lang.String r3 = r0.getString(r3)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            com.mbridge.msdk.foundation.entity.i r4 = new com.mbridge.msdk.foundation.entity.i     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r4.<init>(r1, r3, r6)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            r2.add(r4)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4b
            goto L25
        L48:
            r6 = move-exception
            r1 = r0
            goto L6b
        L4b:
            r6 = move-exception
            goto L4f
        L4d:
            r1 = r2
            goto L54
        L4f:
            r1 = r0
            goto L5b
        L51:
            r6 = move-exception
            r2 = r1
            goto L4f
        L54:
            if (r0 == 0) goto L69
            goto L62
        L57:
            r6 = move-exception
            goto L6b
        L59:
            r6 = move-exception
            r2 = r1
        L5b:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L57
            if (r1 == 0) goto L68
            r0 = r1
            r1 = r2
        L62:
            r0.close()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L69
            goto L69
        L66:
            r6 = move-exception
            goto L71
        L68:
            r1 = r2
        L69:
            monitor-exit(r5)
            return r1
        L6b:
            if (r1 == 0) goto L70
            r1.close()     // Catch: java.lang.Throwable -> L66 java.lang.Exception -> L70
        L70:
            throw r6     // Catch: java.lang.Throwable -> L66
        L71:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L66
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.l.a(int):java.util.List");
    }

    public synchronized void a(String str) {
        if (getWritableDatabase() != null) {
            getWritableDatabase().delete(MBridgeConstans.PROPERTIES_UNIT_ID, "unitId = ?", new String[]{str + ""});
        }
    }

    public synchronized void a(String str, String str2, int i11) {
        if (getWritableDatabase() == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("placement_id", str);
        contentValues.put("unitId", str2);
        contentValues.put("ad_type", Integer.valueOf(i11));
        getWritableDatabase().insert(MBridgeConstans.PROPERTIES_UNIT_ID, null, contentValues);
    }
}
