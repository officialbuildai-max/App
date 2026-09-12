package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes5.dex */
public class c extends a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f35123a;

    private c(f fVar) {
        super(fVar);
    }

    public static c a(f fVar) {
        if (f35123a == null) {
            synchronized (c.class) {
                try {
                    if (f35123a == null) {
                        f35123a = new c(fVar);
                    }
                } finally {
                }
            }
        }
        return f35123a;
    }

    public long a(String str, String str2, String str3, int i11) {
        if (!a(str, str3)) {
            return -1L;
        }
        new ContentValues().put("state", Integer.valueOf(i11));
        return getWritableDatabase().update("CacheCampaign", r3, "rid= ? AND unitid = ? AND state = 0", new String[]{str, str3});
    }

    public long a(List<CampaignEx> list, String str) {
        CampaignEx campaignEx;
        if (list != null) {
            try {
                if (list.size() == 0 || TextUtils.isEmpty(str) || (campaignEx = list.get(0)) == null) {
                    return 0L;
                }
                if (getWritableDatabase() == null) {
                    return -1L;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("rid", campaignEx.getRequestId());
                contentValues.put("lrid", campaignEx.getLocalRequestId());
                contentValues.put("unitid", str);
                JSONArray jSONArray = new JSONArray();
                Iterator<CampaignEx> it = list.iterator();
                while (it.hasNext()) {
                    jSONArray.put(CampaignEx.campaignToJsonObject(it.next()));
                }
                contentValues.put("campaigns", jSONArray.toString());
                contentValues.put("ts", Long.valueOf(campaignEx.getTimestamp()));
                long candidateCacheTime = campaignEx.getCandidateCacheTime();
                if (candidateCacheTime == 0) {
                    candidateCacheTime = campaignEx.getPlctb();
                    if (candidateCacheTime == 0) {
                        com.mbridge.msdk.setting.g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                        if (d11 == null) {
                            d11 = com.mbridge.msdk.setting.h.b().a();
                        }
                        candidateCacheTime = d11.a0();
                    }
                }
                try {
                    if (q0.a().a("c_e_t", false)) {
                        candidateCacheTime *= 24;
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                contentValues.put("interval_ts", Long.valueOf(candidateCacheTime * 1000));
                contentValues.put("ecppv", campaignEx.getEcppv());
                contentValues.put("show_count", Integer.valueOf(campaignEx.getShowCount()));
                contentValues.put("state", (Integer) 0);
                return a(campaignEx.getRequestId(), str) ? getWritableDatabase().update("CacheCampaign", contentValues, "rid= ? AND lrid= ? AND unitid = ? AND state = 1", new String[]{campaignEx.getRequestId(), campaignEx.getLocalRequestId(), str}) : getWritableDatabase().insert("CacheCampaign", null, contentValues);
            } catch (Exception e12) {
                e12.printStackTrace();
                return -1L;
            }
        }
        return 0L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0107, code lost:
    
        if (r5 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x00ff, code lost:
    
        if (r5 != null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0109, code lost:
    
        r5.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.mbridge.msdk.foundation.cache.b> a(java.lang.String r5, int r6, long r7) {
        /*
            r4 = this;
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7}
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "SELECT * FROM CacheCampaign"
            r6.append(r7)
            java.lang.String r7 = " WHERE unitid = ? AND state > ? and (show_time is null or show_time < ? )"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r7 = 0
            android.database.sqlite.SQLiteDatabase r8 = r4.getReadableDatabase()     // Catch: java.lang.Throwable -> L102
            android.database.Cursor r5 = r8.rawQuery(r6, r5)     // Catch: java.lang.Throwable -> L102
            if (r5 == 0) goto Lff
            int r6 = r5.getCount()     // Catch: java.lang.Throwable -> L7b
            if (r6 <= 0) goto Lff
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L7b
            r6.<init>()     // Catch: java.lang.Throwable -> L7b
        L35:
            boolean r8 = r5.moveToNext()     // Catch: java.lang.Throwable -> L7b
            if (r8 == 0) goto Lfb
            com.mbridge.msdk.foundation.cache.b r8 = new com.mbridge.msdk.foundation.cache.b     // Catch: java.lang.Throwable -> L7b
            r8.<init>()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = "campaigns"
            int r0 = r5.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = r5.getString(r0)     // Catch: java.lang.Throwable -> L7b
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L7b
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L7b
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L7b
            if (r0 == 0) goto L59
            r5.close()     // Catch: java.lang.Exception -> L58
        L58:
            return r7
        L59:
            int r0 = r1.length()     // Catch: java.lang.Throwable -> L7b
            if (r0 <= 0) goto L81
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList     // Catch: java.lang.Throwable -> L7b
            r0.<init>()     // Catch: java.lang.Throwable -> L7b
            r2 = 0
        L65:
            int r3 = r1.length()     // Catch: java.lang.Throwable -> L7b
            if (r2 >= r3) goto L7e
            java.lang.Object r3 = r1.get(r2)     // Catch: java.lang.Throwable -> L7b
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch: java.lang.Throwable -> L7b
            com.mbridge.msdk.foundation.entity.CampaignEx r3 = com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaignWithBackData(r3)     // Catch: java.lang.Throwable -> L7b
            r0.add(r3)     // Catch: java.lang.Throwable -> L7b
            int r2 = r2 + 1
            goto L65
        L7b:
            r6 = move-exception
            goto L104
        L7e:
            r8.a(r0)     // Catch: java.lang.Throwable -> L7b
        L81:
            java.lang.String r0 = "lrid"
            int r0 = r5.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = r5.getString(r0)     // Catch: java.lang.Throwable -> L7b
            r8.b(r0)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = "rid"
            int r0 = r5.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = r5.getString(r0)     // Catch: java.lang.Throwable -> L7b
            r8.c(r0)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = "unitid"
            int r0 = r5.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = r5.getString(r0)     // Catch: java.lang.Throwable -> L7b
            r8.d(r0)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = "ecppv"
            int r0 = r5.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = r5.getString(r0)     // Catch: java.lang.Throwable -> L7b
            r8.a(r0)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = "ts"
            int r0 = r5.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7b
            long r0 = r5.getLong(r0)     // Catch: java.lang.Throwable -> L7b
            r8.c(r0)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = "state"
            int r0 = r5.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7b
            int r0 = r5.getInt(r0)     // Catch: java.lang.Throwable -> L7b
            r8.b(r0)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = "show_count"
            int r0 = r5.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7b
            int r0 = r5.getInt(r0)     // Catch: java.lang.Throwable -> L7b
            r8.a(r0)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = "show_time"
            int r0 = r5.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7b
            long r0 = r5.getLong(r0)     // Catch: java.lang.Throwable -> L7b
            r8.b(r0)     // Catch: java.lang.Throwable -> L7b
            java.lang.String r0 = "interval_ts"
            int r0 = r5.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L7b
            long r0 = r5.getLong(r0)     // Catch: java.lang.Throwable -> L7b
            r8.a(r0)     // Catch: java.lang.Throwable -> L7b
            r6.add(r8)     // Catch: java.lang.Throwable -> L7b
            goto L35
        Lfb:
            r5.close()     // Catch: java.lang.Exception -> Lfe
        Lfe:
            return r6
        Lff:
            if (r5 == 0) goto L10c
            goto L109
        L102:
            r6 = move-exception
            r5 = r7
        L104:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L10d
            if (r5 == 0) goto L10c
        L109:
            r5.close()     // Catch: java.lang.Exception -> L10c
        L10c:
            return r7
        L10d:
            r6 = move-exception
            if (r5 == 0) goto L113
            r5.close()     // Catch: java.lang.Exception -> L113
        L113:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.c.a(java.lang.String, int, long):java.util.List");
    }

    public List<com.mbridge.msdk.foundation.cache.b> a(String str, long j11) {
        return a(str, 0, j11);
    }

    public synchronized void a(String str, int i11) {
        String str2;
        SQLiteDatabase writableDatabase;
        if (i11 <= 0) {
            i11 = 1;
        }
        try {
            str2 = "unitid = ? AND ( (ts + interval_ts) < " + System.currentTimeMillis() + " OR show_count >= ?)";
            writableDatabase = getWritableDatabase();
        } catch (Exception e11) {
            o0.b("CacheCampaignDao", e11.getLocalizedMessage());
        }
        if (writableDatabase == null) {
            return;
        }
        try {
            writableDatabase.delete("CacheCampaign", str2, new String[]{str, String.valueOf(i11)});
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public synchronized void a(String str, String str2, String str3) {
        try {
            if (a(str2, str)) {
                SQLiteDatabase writableDatabase = getWritableDatabase();
                if (writableDatabase == null) {
                    return;
                }
                try {
                    writableDatabase.delete("CacheCampaign", "unitid = ? AND rid = ? ", new String[]{str, str2});
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        } catch (Exception e12) {
            o0.b("CampaignDao", e12.getLocalizedMessage());
        }
    }

    public synchronized boolean a(String str, String str2) {
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT rid FROM CacheCampaign WHERE rid= ? AND unitid = ? ", new String[]{str, str2});
        if (rawQuery != null && rawQuery.getCount() > 0) {
            try {
                rawQuery.close();
            } catch (Exception unused) {
            }
            return true;
        }
        if (rawQuery != null) {
            try {
                rawQuery.close();
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    public void b(String str, String str2, String str3) {
        if (a(str, str3)) {
            try {
                getWritableDatabase().execSQL("UPDATE CacheCampaign SET show_count = show_count + 1, show_time = ? WHERE rid = ? AND unitid = ? AND state = ?", new Object[]{Long.valueOf(System.currentTimeMillis()), str, str3, "1"});
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }
}
