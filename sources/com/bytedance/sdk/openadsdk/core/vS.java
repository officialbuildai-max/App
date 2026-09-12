package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class vS {
    private static final Object TKC = new Object();
    private TKC Sj;
    private Context sP;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class Sj extends SQLiteOpenHelper {
        final Context Sj;

        public Sj(Context context) {
            super(context, "ttopensdk.db", (SQLiteDatabase.CursorFactory) null, 11);
            this.Sj = context;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x002f, code lost:
        
            if (r1 != null) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
        
            r1.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x003b, code lost:
        
            if (r1 != null) goto L16;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private java.util.ArrayList<java.lang.String> EjP(android.database.sqlite.SQLiteDatabase r4) {
            /*
                r3 = this;
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                r1 = 0
                java.lang.String r2 = "select name from sqlite_master where type='table' order by name"
                android.database.Cursor r1 = r4.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L3b
                if (r1 == 0) goto L2f
            Le:
                boolean r4 = r1.moveToNext()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L3b
                if (r4 == 0) goto L2f
                r4 = 0
                java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L3b
                java.lang.String r2 = "android_metadata"
                boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L3b
                if (r2 != 0) goto Le
                java.lang.String r2 = "sqlite_sequence"
                boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L3b
                if (r2 != 0) goto Le
                r0.add(r4)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L3b
                goto Le
            L2d:
                r4 = move-exception
                goto L35
            L2f:
                if (r1 == 0) goto L3e
            L31:
                r1.close()
                goto L3e
            L35:
                if (r1 == 0) goto L3a
                r1.close()
            L3a:
                throw r4
            L3b:
                if (r1 == 0) goto L3e
                goto L31
            L3e:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.vS.Sj.EjP(android.database.sqlite.SQLiteDatabase):java.util.ArrayList");
        }

        private void Sj(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.EjP.EjP.sP());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.EjP.uA.EjP());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.EjP.sef.sP());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.EjP.Fmk.sP());
        }

        private void Sj(SQLiteDatabase sQLiteDatabase, Context context) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.EjP.EjP.Sj());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.EjP.uA.TKC());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.EjP.sef.Sj());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.EjP.Fmk.Sj());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.kF.sP.Sj());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.EjP.uvD.TKC());
            sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.Sj.sP.sP.TKC());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.TEQ.Sj.TKC.TKC());
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.EjP.Zq.Sj());
        }

        private void TKC(SQLiteDatabase sQLiteDatabase) {
            ArrayList<String> EjP = EjP(sQLiteDatabase);
            if (EjP == null || EjP.size() <= 0) {
                return;
            }
            Iterator<String> it = EjP.iterator();
            while (it.hasNext()) {
                sQLiteDatabase.execSQL(String.format("DROP TABLE IF EXISTS %s ;", it.next()));
            }
        }

        private void sP(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.core.TEQ.Sj.TKC.EjP());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            try {
                Sj(sQLiteDatabase, this.Sj);
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.sU.sP("DBHelper", th2.getMessage());
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
            if (i11 > i12) {
                try {
                    TKC(sQLiteDatabase);
                    Sj(sQLiteDatabase, vS.this.sP);
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.sU.sP(th2.getMessage(), new Object[0]);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
            if (i11 > i12) {
                try {
                    TKC(sQLiteDatabase);
                } catch (Throwable unused) {
                }
            }
            Sj(sQLiteDatabase, vS.this.sP);
            switch (i11) {
                case 1:
                    Sj(sQLiteDatabase);
                    break;
                case 2:
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                    Sj(sQLiteDatabase);
                    break;
                case 3:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.EjP.sef.Sj());
                    Sj(sQLiteDatabase);
                    break;
                case 4:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.component.adexpress.Sj.sP.sP.TKC());
                    Sj(sQLiteDatabase);
                    break;
                case 5:
                    sQLiteDatabase.execSQL(com.bytedance.sdk.openadsdk.EjP.Fmk.Sj());
                    Sj(sQLiteDatabase);
                    break;
                case 6:
                    Sj(sQLiteDatabase);
                    break;
            }
            if (i11 < 11) {
                try {
                    sP(sQLiteDatabase);
                    com.bytedance.sdk.openadsdk.kF.sP.Sj(sQLiteDatabase);
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.sU.sP("DBHelper", th2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class TKC {
        private SQLiteDatabase sP = null;

        public TKC() {
        }

        private synchronized void HiB() {
            try {
                synchronized (vS.TKC) {
                    try {
                        SQLiteDatabase sQLiteDatabase = this.sP;
                        if (sQLiteDatabase != null) {
                            if (!sQLiteDatabase.isOpen()) {
                            }
                        }
                        vS vSVar = vS.this;
                        SQLiteDatabase writableDatabase = new Sj(vSVar.TKC()).getWritableDatabase();
                        this.sP = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    } finally {
                    }
                }
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.sU.sP("DBHelper", th2.getMessage());
                if (vS()) {
                    throw th2;
                }
            }
        }

        private synchronized boolean vS() {
            SQLiteDatabase sQLiteDatabase = this.sP;
            if (sQLiteDatabase != null) {
                if (sQLiteDatabase.inTransaction()) {
                    return true;
                }
            }
            return false;
        }

        public synchronized void EjP() {
            HiB();
            SQLiteDatabase sQLiteDatabase = this.sP;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.endTransaction();
        }

        public synchronized int Sj(String str, ContentValues contentValues, String str2, String[] strArr) {
            int i11;
            try {
                HiB();
                i11 = this.sP.update(str, contentValues, str2, strArr);
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.sU.sP("DBHelper", e11.getMessage());
                if (vS()) {
                    throw e11;
                }
                i11 = 0;
            }
            return i11;
        }

        public synchronized int Sj(String str, String str2, String[] strArr) {
            int i11;
            try {
                HiB();
                i11 = this.sP.delete(str, str2, strArr);
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.sU.sP("DBHelper", e11.getMessage());
                if (vS()) {
                    throw e11;
                }
                i11 = 0;
            }
            return i11;
        }

        public synchronized long Sj(String str, String str2, ContentValues contentValues) {
            long j11;
            try {
                HiB();
                j11 = this.sP.replace(str, str2, contentValues);
            } catch (Exception e11) {
                com.bytedance.sdk.component.utils.sU.sP("DBHelper", e11.getMessage());
                if (vS()) {
                    throw e11;
                }
                j11 = -1;
            }
            return j11;
        }

        public synchronized Cursor Sj(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            Cursor cursor;
            try {
                HiB();
                cursor = this.sP.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th2) {
                com.bytedance.sdk.component.utils.sU.sP("DBHelper", th2.getMessage());
                sP sPVar = new sP();
                if (vS()) {
                    throw th2;
                }
                cursor = sPVar;
            }
            return cursor;
        }

        public SQLiteDatabase Sj() {
            HiB();
            return this.sP;
        }

        public synchronized void Sj(String str) throws SQLException {
            try {
                HiB();
                this.sP.execSQL(str);
            } catch (Throwable th2) {
                if (vS()) {
                    throw th2;
                }
            }
        }

        public synchronized void TKC() {
            HiB();
            SQLiteDatabase sQLiteDatabase = this.sP;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.setTransactionSuccessful();
        }

        public synchronized void sP() {
            HiB();
            SQLiteDatabase sQLiteDatabase = this.sP;
            if (sQLiteDatabase == null) {
                return;
            }
            sQLiteDatabase.beginTransaction();
        }
    }

    /* loaded from: classes3.dex */
    private class sP extends AbstractCursor {
        private sP() {
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String[] getColumnNames() {
            return new String[0];
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getCount() {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public double getDouble(int i11) {
            return 0.0d;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public float getFloat(int i11) {
            return 0.0f;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public int getInt(int i11) {
            return 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public long getLong(int i11) {
            return 0L;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public short getShort(int i11) {
            return (short) 0;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public String getString(int i11) {
            return null;
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public boolean isNull(int i11) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public vS(Context context) {
        try {
            this.sP = context == null ? dNu.Sj() : context.getApplicationContext();
            if (this.Sj == null) {
                this.Sj = new TKC();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context TKC() {
        Context context = this.sP;
        return context == null ? dNu.Sj() : context;
    }

    public TKC Sj() {
        return this.Sj;
    }
}
