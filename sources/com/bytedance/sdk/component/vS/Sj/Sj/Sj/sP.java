package com.bytedance.sdk.component.vS.Sj.Sj.Sj;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.sdk.component.vS.Sj.Dq;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.meituan.android.walle.ChannelReader;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class sP {
    private C0239sP Sj;
    private Context sP;

    /* loaded from: classes2.dex */
    private class Sj extends AbstractCursor {
        private Sj() {
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

    /* renamed from: com.bytedance.sdk.component.vS.Sj.Sj.Sj.sP$sP, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0239sP {
        private volatile SQLiteDatabase sP = null;

        public C0239sP() {
        }

        private void Sj() {
            try {
                if (this.sP != null && this.sP.isOpen()) {
                    return;
                }
                synchronized (this) {
                    try {
                        if (this.sP != null) {
                            if (!this.sP.isOpen()) {
                            }
                        }
                        this.sP = Dq.Jcg().EjP().Sj(Dq.Jcg().vS());
                        this.sP.setLockingEnabled(false);
                    } finally {
                    }
                }
            } catch (Throwable th2) {
                if (sP()) {
                    throw th2;
                }
            }
        }

        private boolean sP() {
            SQLiteDatabase sQLiteDatabase = this.sP;
            return sQLiteDatabase != null && sQLiteDatabase.inTransaction();
        }

        public int Sj(String str, ContentValues contentValues, String str2, String[] strArr) {
            try {
                Sj();
                return this.sP.update(str, contentValues, str2, strArr);
            } catch (Exception e11) {
                if (sP()) {
                    throw e11;
                }
                return 0;
            }
        }

        public int Sj(String str, String str2, String[] strArr) {
            try {
                Sj();
                return this.sP.delete(str, str2, strArr);
            } catch (Exception e11) {
                if (sP()) {
                    throw e11;
                }
                return 0;
            }
        }

        public long Sj(String str, String str2, ContentValues contentValues) {
            try {
                Sj();
                return this.sP.insert(str, str2, contentValues);
            } catch (Exception e11) {
                if (sP()) {
                    throw e11;
                }
                return -1L;
            }
        }

        public Cursor Sj(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
            try {
                Sj();
                return this.sP.query(str, strArr, str2, strArr2, str3, str4, str5);
            } catch (Throwable th2) {
                Sj sj2 = new Sj();
                if (sP()) {
                    throw th2;
                }
                return sj2;
            }
        }

        public void Sj(String str) throws SQLException {
            try {
                Sj();
                this.sP.execSQL(str);
            } catch (Throwable th2) {
                if (sP()) {
                    throw th2;
                }
            }
        }

        public synchronized void Sj(String str, String str2, List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> list) {
            JSONObject Jcg;
            try {
                try {
                    Sj();
                    this.sP.beginTransaction();
                    ContentValues contentValues = new ContentValues();
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        com.bytedance.sdk.component.vS.Sj.EjP.Sj sj2 = list.get(i11);
                        if (sj2 != null && (Jcg = sj2.Jcg()) != null) {
                            contentValues.put("id", sj2.TKC());
                            String sP = Dq.Jcg().uvD().sP(Jcg.toString());
                            if (!TextUtils.isEmpty(sP)) {
                                contentValues.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, sP);
                                contentValues.put("gen_time", Long.valueOf(System.currentTimeMillis()));
                                contentValues.put("retry", (Integer) 0);
                                contentValues.put("encrypt", (Integer) 1);
                                if (com.bytedance.sdk.component.vS.Sj.TKC.Sj.EjP()) {
                                    if (sj2.TEQ() > 0) {
                                        if (sj2.EjP() != 0) {
                                            if (sj2.EjP() == 3) {
                                            }
                                        }
                                        contentValues.put(ChannelReader.CHANNEL_KEY, Integer.valueOf(sj2.TEQ()));
                                    }
                                }
                                this.sP.insert(str, str2, contentValues);
                            }
                            contentValues.clear();
                        }
                    }
                    this.sP.setTransactionSuccessful();
                    list.size();
                    if (this.sP != null) {
                        this.sP.endTransaction();
                    }
                } catch (Exception e11) {
                    list.size();
                    if (sP()) {
                        throw e11;
                    }
                    if (this.sP != null) {
                        this.sP.endTransaction();
                    }
                }
            } catch (Throwable th2) {
                if (this.sP != null) {
                    this.sP.endTransaction();
                }
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public sP(Context context) {
        try {
            this.sP = context.getApplicationContext();
            if (this.Sj == null) {
                this.Sj = new C0239sP();
            }
        } catch (Throwable unused) {
        }
    }

    public C0239sP Sj() {
        return this.Sj;
    }
}
