package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import java.util.List;

/* loaded from: classes5.dex */
public class b extends a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f35122a;

    public b(f fVar) {
        super(fVar);
    }

    public static b a(Context context) {
        if (f35122a == null) {
            synchronized (b.class) {
                try {
                    if (f35122a == null) {
                        f35122a = new b(g.a(context));
                    }
                } finally {
                }
            }
        }
        return f35122a;
    }

    public int a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return 0;
            }
            return writableDatabase.delete("bid_replace_campaign", "is_replace = 0", null);
        } catch (Exception e11) {
            o0.b("BidReplaceCampaignDao", e11.getLocalizedMessage());
            return 0;
        }
    }

    public int a(String str) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return 0;
            }
            return writableDatabase.delete("bid_replace_campaign", "real_request_id = ? AND is_replace = 1", new String[]{str});
        } catch (Exception e11) {
            o0.b("BidReplaceCampaignDao", e11.getLocalizedMessage());
            return 0;
        }
    }

    public int a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || getWritableDatabase() == null) {
            return 0;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("expect_encrypt_price", str3);
            return getWritableDatabase().update("bid_replace_campaign", contentValues, "bid_unit_id = ? AND expect_bid_token = ?", new String[]{str2, str});
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00bf, code lost:
    
        if (r2 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00d3, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00d0, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ce, code lost:
    
        if (0 == 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.mbridge.msdk.foundation.entity.d> a(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = android.text.TextUtils.isEmpty(r9)
            if (r1 == 0) goto Lc
            return r0
        Lc:
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 == 0) goto L13
            return r0
        L13:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "SELECT * FROM bid_replace_campaign WHERE "
            r1.append(r2)
            java.lang.String r2 = "bid_unit_id"
            r1.append(r2)
            java.lang.String r2 = " = ? AND "
            r1.append(r2)
            java.lang.String r2 = "real_request_id"
            r1.append(r2)
            java.lang.String r2 = " = ?"
            r1.append(r2)
            r2 = 0
            java.lang.Object r3 = new java.lang.Object     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            r3.<init>()     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            monitor-enter(r3)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            android.database.sqlite.SQLiteDatabase r4 = r8.getReadableDatabase()     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lc2
            java.lang.String[] r9 = new java.lang.String[]{r9, r10}     // Catch: java.lang.Throwable -> Lc2
            android.database.Cursor r2 = r4.rawQuery(r1, r9)     // Catch: java.lang.Throwable -> Lc2
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lc2
            if (r2 == 0) goto Lbf
            int r9 = r2.getCount()     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            if (r9 <= 0) goto Lbf
        L51:
            boolean r9 = r2.moveToNext()     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            if (r9 == 0) goto Lbf
            com.mbridge.msdk.foundation.entity.d r9 = new com.mbridge.msdk.foundation.entity.d     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            r9.<init>()     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            java.lang.String r10 = "bid_unit_id"
            int r10 = r2.getColumnIndex(r10)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            java.lang.String r10 = r2.getString(r10)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            java.lang.String r1 = "expect_bid_token"
            int r1 = r2.getColumnIndex(r1)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            java.lang.String r1 = r2.getString(r1)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            java.lang.String r3 = "expect_encrypt_price"
            int r3 = r2.getColumnIndex(r3)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            java.lang.String r3 = r2.getString(r3)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            java.lang.String r4 = "real_request_id"
            int r4 = r2.getColumnIndex(r4)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            java.lang.String r4 = r2.getString(r4)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            java.lang.String r5 = "real_encrypt_price"
            int r5 = r2.getColumnIndex(r5)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            java.lang.String r5 = r2.getString(r5)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            java.lang.String r6 = "real_token_rule"
            int r6 = r2.getColumnIndex(r6)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            int r6 = r2.getInt(r6)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            java.lang.String r7 = "is_replace"
            int r7 = r2.getColumnIndex(r7)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            int r7 = r2.getInt(r7)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            r9.a(r10)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            r9.b(r1)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            r9.c(r3)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            r9.e(r4)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            r9.d(r5)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            r9.b(r6)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            r9.a(r7)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            r0.add(r9)     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
            goto L51
        Lbb:
            r9 = move-exception
            goto Ld4
        Lbd:
            r9 = move-exception
            goto Lc5
        Lbf:
            if (r2 == 0) goto Ld3
            goto Ld0
        Lc2:
            r9 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> Lc2
            throw r9     // Catch: java.lang.Throwable -> Lbb java.lang.Exception -> Lbd
        Lc5:
            java.lang.String r10 = "BidReplaceCampaignDao"
            java.lang.String r9 = r9.getLocalizedMessage()     // Catch: java.lang.Throwable -> Lbb
            com.mbridge.msdk.foundation.tools.o0.b(r10, r9)     // Catch: java.lang.Throwable -> Lbb
            if (r2 == 0) goto Ld3
        Ld0:
            r2.close()
        Ld3:
            return r0
        Ld4:
            if (r2 == 0) goto Ld9
            r2.close()
        Ld9:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.b.a(java.lang.String, java.lang.String):java.util.List");
    }

    public void a(String str, List<CampaignEx> list) {
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0) {
            return;
        }
        try {
            String requestId = list.get(0).getRequestId();
            String encryptPrice = list.get(0).getEncryptPrice();
            String campaignUnitId = list.get(0).getCampaignUnitId();
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("bid_unit_id", campaignUnitId);
            contentValues.put("expect_bid_token", str);
            contentValues.put("expect_encrypt_price", "");
            contentValues.put("real_request_id", requestId);
            contentValues.put("real_encrypt_price", encryptPrice);
            contentValues.put("real_token_rule", (Integer) 1);
            contentValues.put("is_replace", (Integer) 0);
            writableDatabase.insert("bid_replace_campaign", null, contentValues);
            o0.b("HBOPTIMIZE", "插入数据到对应关系表 期望 bidToken 值" + str + "+ 用于替换期望Offer 的RequestId " + requestId);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public int b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || getWritableDatabase() == null) {
            return 0;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_replace", (Integer) 1);
            return getWritableDatabase().update("bid_replace_campaign", contentValues, "bid_unit_id = ? AND expect_bid_token = ?", new String[]{str2, str});
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }
}
