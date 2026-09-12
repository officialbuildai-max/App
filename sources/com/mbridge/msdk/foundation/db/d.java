package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.u0;

/* loaded from: classes5.dex */
public class d extends a<JumpLoaderResult> {

    /* renamed from: a, reason: collision with root package name */
    public static final String f35124a = "d";

    /* renamed from: b, reason: collision with root package name */
    private static d f35125b;

    private d(f fVar) {
        super(fVar);
    }

    public static synchronized d a(f fVar) {
        d dVar;
        synchronized (d.class) {
            try {
                if (f35125b == null) {
                    f35125b = new d(fVar);
                }
                dVar = f35125b;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return dVar;
    }

    public synchronized long a(CampaignEx campaignEx, String str) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            try {
                String a11 = u0.a(campaignEx.getJumpResult());
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", campaignEx.getId());
                contentValues.put("unitid", str);
                contentValues.put("result", a11);
                contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval() * 1000));
                contentValues.put("package_name", campaignEx.getPackageName());
                com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                contentValues.put("ts", Long.valueOf(System.currentTimeMillis()));
                if (d11 != null && d11.X() > 0) {
                    contentValues.put("cpei", Integer.valueOf(d11.X() * 1000));
                }
                if (d11 != null && d11.Y() > 0) {
                    contentValues.put("cpoci", Integer.valueOf(d11.Y() * 1000));
                }
                if (!a(campaignEx.getId(), str)) {
                    return getWritableDatabase().insert("campaignclick", null, contentValues);
                }
                if (getWritableDatabase() == null) {
                    return -1L;
                }
                return getWritableDatabase().update("campaignclick", contentValues, "id = ? AND unitid = ? ", new String[]{campaignEx.getId(), str});
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b(f35124a, e11.getMessage());
                }
                return -1L;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a() {
        try {
            getWritableDatabase().delete("campaignclick", " ( " + System.currentTimeMillis() + " - ts) > cti", null);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b(f35124a, e11.getMessage());
            }
        }
    }

    public synchronized boolean a(String str, String str2) {
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT id FROM campaignclick WHERE id= ? AND unitid= ?", new String[]{str, str2});
        if (rawQuery != null && rawQuery.getCount() > 0) {
            rawQuery.close();
            return true;
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x005d, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        if (r11 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0047, code lost:
    
        if (r11 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0061, code lost:
    
        return null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.mbridge.msdk.click.entity.JumpLoaderResult b(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.getReadableDatabase()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            java.lang.String r2 = "campaignclick"
            java.lang.String r4 = "id=? AND unitid=?"
            java.lang.String[] r5 = new java.lang.String[]{r11, r12}     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r8 = 0
            r9 = 0
            r3 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r11 == 0) goto L47
            int r12 = r11.getCount()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            if (r12 <= 0) goto L47
            boolean r12 = r11.moveToFirst()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            if (r12 == 0) goto L47
            java.lang.String r12 = "result"
            int r12 = r11.getColumnIndex(r12)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            java.lang.String r12 = r11.getString(r12)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            if (r1 != 0) goto L47
            java.lang.Object r12 = com.mbridge.msdk.foundation.tools.u0.a(r12)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            com.mbridge.msdk.click.entity.JumpLoaderResult r12 = (com.mbridge.msdk.click.entity.JumpLoaderResult) r12     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            r11.close()     // Catch: java.lang.Throwable -> L40
            monitor-exit(r10)
            return r12
        L40:
            r11 = move-exception
            goto L68
        L42:
            r12 = move-exception
            r0 = r11
            goto L62
        L45:
            r12 = move-exception
            goto L4e
        L47:
            if (r11 == 0) goto L60
            goto L5d
        L4a:
            r12 = move-exception
            goto L62
        L4c:
            r12 = move-exception
            r11 = r0
        L4e:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L5b
            java.lang.String r1 = com.mbridge.msdk.foundation.db.d.f35124a     // Catch: java.lang.Throwable -> L42
            java.lang.String r12 = r12.getMessage()     // Catch: java.lang.Throwable -> L42
            com.mbridge.msdk.foundation.tools.o0.b(r1, r12)     // Catch: java.lang.Throwable -> L42
        L5b:
            if (r11 == 0) goto L60
        L5d:
            r11.close()     // Catch: java.lang.Throwable -> L40
        L60:
            monitor-exit(r10)
            return r0
        L62:
            if (r0 == 0) goto L67
            r0.close()     // Catch: java.lang.Throwable -> L40
        L67:
            throw r12     // Catch: java.lang.Throwable -> L40
        L68:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L40
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.d.b(java.lang.String, java.lang.String):com.mbridge.msdk.click.entity.JumpLoaderResult");
    }

    public synchronized boolean c(String str, String str2) {
        try {
            Cursor rawQuery = getReadableDatabase().rawQuery("SELECT id FROM campaignclick WHERE id= ? AND unitid= ? AND cti + ts > " + System.currentTimeMillis(), new String[]{str, str2});
            if (rawQuery != null && rawQuery.getCount() > 0) {
                rawQuery.close();
                return true;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return false;
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b(f35124a, e11.getMessage());
            }
            return false;
        }
    }
}
