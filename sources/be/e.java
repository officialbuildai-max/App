package be;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.hisavana.common.utils.AdLogUtil;
import com.hisavana.mediation.bean.CloudControlConfig;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class e implements j {

    /* renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f16469a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f16470b;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final e f16471a = new e();
    }

    public e() {
        this.f16470b = new AtomicInteger();
    }

    public static e d() {
        return b.f16471a;
    }

    @Override // be.j
    public void a() {
        try {
            e();
            this.f16469a.delete("cloudList", null, null);
        } catch (Exception e11) {
            AdLogUtil.Log().e("CloudControlDatabaseManager", Log.getStackTraceString(e11));
        }
    }

    @Override // be.j
    public void a(CloudControlConfig.CodeSeat codeSeat) {
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        try {
            try {
                e();
                sQLiteDatabase2 = this.f16469a;
            } catch (Exception e11) {
                AdLogUtil.Log().e("CloudControlDatabaseManager", "update e " + Log.getStackTraceString(e11));
                sQLiteDatabase = this.f16469a;
                if (sQLiteDatabase == null) {
                    return;
                }
            }
            if (sQLiteDatabase2 == null) {
                if (sQLiteDatabase2 != null) {
                    sQLiteDatabase2.endTransaction();
                    return;
                }
                return;
            }
            sQLiteDatabase2.beginTransaction();
            String d11 = GsonUtil.d(codeSeat);
            ContentValues contentValues = new ContentValues();
            contentValues.put("codeSeatId", codeSeat.getCodeSeatId());
            contentValues.put("json", d11);
            this.f16469a.update("cloudList", contentValues, "codeSeatId=?", new String[]{codeSeat.getCodeSeatId()});
            this.f16469a.setTransactionSuccessful();
            sQLiteDatabase = this.f16469a;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.endTransaction();
        } catch (Throwable th2) {
            SQLiteDatabase sQLiteDatabase3 = this.f16469a;
            if (sQLiteDatabase3 != null) {
                sQLiteDatabase3.endTransaction();
            }
            throw th2;
        }
    }

    @Override // be.j
    public boolean a(List list) {
        if (list != null) {
            try {
                if (list.size() >= 1) {
                    try {
                        e();
                        SQLiteDatabase sQLiteDatabase = this.f16469a;
                        if (sQLiteDatabase == null) {
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            return false;
                        }
                        sQLiteDatabase.beginTransaction();
                        this.f16469a.delete("cloudList", null, null);
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            CloudControlConfig.CodeSeat codeSeat = (CloudControlConfig.CodeSeat) it.next();
                            if (codeSeat != null) {
                                String d11 = GsonUtil.d(codeSeat);
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("codeSeatId", codeSeat.getCodeSeatId());
                                contentValues.put("json", d11);
                                this.f16469a.insert("cloudList", null, contentValues);
                            }
                        }
                        this.f16469a.setTransactionSuccessful();
                        SQLiteDatabase sQLiteDatabase2 = this.f16469a;
                        if (sQLiteDatabase2 != null) {
                            sQLiteDatabase2.endTransaction();
                        }
                        return true;
                    } catch (Exception e11) {
                        AdLogUtil.Log().e("CloudControlDatabaseManager", "insert cloud data 2 db failed in work thread " + Log.getStackTraceString(e11));
                        SQLiteDatabase sQLiteDatabase3 = this.f16469a;
                        if (sQLiteDatabase3 != null) {
                            sQLiteDatabase3.endTransaction();
                        }
                        return false;
                    }
                }
            } catch (Throwable th2) {
                SQLiteDatabase sQLiteDatabase4 = this.f16469a;
                if (sQLiteDatabase4 != null) {
                    sQLiteDatabase4.endTransaction();
                }
                throw th2;
            }
        }
        return false;
    }

    @Override // be.j
    public long b() {
        Cursor cursor = null;
        try {
            try {
                e();
                cursor = this.f16469a.rawQuery("select count(*) from cloudList", null);
                cursor.moveToFirst();
                long j11 = cursor.getLong(0);
                cursor.close();
                return j11;
            } catch (Exception e11) {
                AdLogUtil.Log().e("CloudControlDatabaseManager", Log.getStackTraceString(e11));
                if (cursor != null) {
                    cursor.close();
                }
                return 0L;
            }
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
    
        if (r1 == null) goto L14;
     */
    @Override // be.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List c() {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            r5.e()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            android.database.sqlite.SQLiteDatabase r2 = r5.f16469a     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            java.lang.String r3 = "select * from cloudList"
            android.database.Cursor r1 = r2.rawQuery(r3, r1)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
        L11:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            if (r2 == 0) goto L3f
            java.lang.String r2 = "json"
            int r2 = r1.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            java.lang.Class<com.hisavana.mediation.bean.CloudControlConfig$CodeSeat> r3 = com.hisavana.mediation.bean.CloudControlConfig.CodeSeat.class
            java.lang.Object r2 = com.cloud.sdk.commonutil.gsonutil.GsonUtil.a(r2, r3)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            com.hisavana.mediation.bean.CloudControlConfig$CodeSeat r2 = (com.hisavana.mediation.bean.CloudControlConfig.CodeSeat) r2     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            r0.add(r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            goto L11
        L2d:
            r0 = move-exception
            goto L43
        L2f:
            r2 = move-exception
            com.hisavana.common.utils.AdLogUtil r3 = com.hisavana.common.utils.AdLogUtil.Log()     // Catch: java.lang.Throwable -> L2d
            java.lang.String r4 = "CloudControlDatabaseManager"
            java.lang.String r2 = android.util.Log.getStackTraceString(r2)     // Catch: java.lang.Throwable -> L2d
            r3.e(r4, r2)     // Catch: java.lang.Throwable -> L2d
            if (r1 == 0) goto L42
        L3f:
            r1.close()
        L42:
            return r0
        L43:
            if (r1 == 0) goto L48
            r1.close()
        L48:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: be.e.c():java.util.List");
    }

    public final synchronized SQLiteDatabase e() {
        if (this.f16470b.incrementAndGet() == 1 || this.f16469a == null) {
            try {
                this.f16469a = new d(com.cloud.sdk.commonutil.util.e.a()).getWritableDatabase();
            } catch (Exception e11) {
                AdLogUtil.Log().e("CloudControlDatabaseManager", Log.getStackTraceString(e11));
            }
        }
        return this.f16469a;
    }
}
