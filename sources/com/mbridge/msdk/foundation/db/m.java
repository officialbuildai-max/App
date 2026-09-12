package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.cloud.tmc.integration.permission.PermissionConstant;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.Campaign;

/* loaded from: classes5.dex */
public class m extends a<Campaign> {

    /* renamed from: a, reason: collision with root package name */
    private static m f35157a;

    private m(f fVar) {
        super(fVar);
    }

    public static synchronized m a(f fVar) {
        m mVar;
        synchronized (m.class) {
            try {
                if (f35157a == null) {
                    f35157a = new m(fVar);
                }
                mVar = f35157a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return mVar;
    }

    public synchronized long a(CampaignEx campaignEx, long j11, String str, int i11) {
        if (campaignEx == null) {
            return 0L;
        }
        try {
            try {
                if (getWritableDatabase() == null) {
                    return -1L;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("unitid", campaignEx.getCampaignUnitId());
                contentValues.put("id", campaignEx.getId());
                contentValues.put("package_name", campaignEx.getPackageName());
                contentValues.put("app_name", campaignEx.getAppName());
                contentValues.put("app_desc", campaignEx.getAppDesc());
                contentValues.put(CampaignEx.JSON_KEY_APP_SIZE, campaignEx.getSize());
                contentValues.put(CampaignEx.JSON_KEY_IMAGE_SIZE, campaignEx.getImageSize());
                contentValues.put("icon_url", campaignEx.getIconUrl());
                contentValues.put("image_url", campaignEx.getImageUrl());
                contentValues.put(CampaignEx.JSON_KEY_IMPRESSION_URL, campaignEx.getImpressionURL());
                contentValues.put(CampaignEx.JSON_KEY_NOTICE_URL, campaignEx.getNoticeUrl());
                contentValues.put("download_url", campaignEx.getClickURL());
                contentValues.put("only_impression", campaignEx.getOnlyImpressionURL());
                contentValues.put("ts", Long.valueOf(campaignEx.getTimestamp()));
                contentValues.put("template", Integer.valueOf(campaignEx.getTemplate()));
                contentValues.put(CampaignEx.JSON_KEY_CLICK_MODE, campaignEx.getClick_mode());
                contentValues.put(CampaignEx.JSON_KEY_LANDING_TYPE, campaignEx.getLandingType());
                contentValues.put(CampaignEx.JSON_KEY_LINK_TYPE, Integer.valueOf(campaignEx.getLinkType()));
                contentValues.put("star", Double.valueOf(campaignEx.getRating()));
                contentValues.put("cti", Integer.valueOf(campaignEx.getClickInterval()));
                contentValues.put(PermissionConstant.level, Integer.valueOf(campaignEx.getCacheLevel()));
                contentValues.put("adSource", Integer.valueOf(campaignEx.getType()));
                contentValues.put("ad_call", campaignEx.getAdCall());
                contentValues.put("fc_a", Integer.valueOf(campaignEx.getFca()));
                contentValues.put(CampaignEx.JSON_KEY_AD_URL_LIST, campaignEx.getAd_url_list());
                contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, campaignEx.getVideoUrlEncode());
                contentValues.put("total_size", Long.valueOf(j11));
                contentValues.put("video_state", Integer.valueOf(i11));
                contentValues.put("video_download_start", Long.valueOf(System.currentTimeMillis() / 1000));
                contentValues.put("ad_bid_token", campaignEx.getBidToken());
                if (!TextUtils.isEmpty(str)) {
                    contentValues.put("video_path", str);
                }
                if (a(campaignEx.getVideoUrlEncode(), campaignEx.getId())) {
                    return 0L;
                }
                return getWritableDatabase().insert("video", null, contentValues);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("VideoDao", e11.getLocalizedMessage());
                }
                return -1L;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized long a(String str, long j11, int i11) {
        int i12 = -1;
        try {
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("VideoDao", e11.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("pregeress_size", Long.valueOf(j11));
        contentValues.put("video_state", Integer.valueOf(i11));
        if (a(str, "")) {
            String[] strArr = {str};
            synchronized (new Object()) {
                i12 = getWritableDatabase().update("video", contentValues, "video_url = ? ", strArr);
            }
        }
        return i12;
    }

    public synchronized void a(String str) {
        String[] strArr;
        try {
            strArr = new String[]{str};
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("VideoDao", e11.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return;
        }
        getWritableDatabase().delete("video", "video_url = ? ", strArr);
    }

    public synchronized void a(String str, long j11) {
        if (j11 == 0) {
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("video_download_start", Long.valueOf(j11 / 1000));
            if (a(str, "")) {
                getWritableDatabase().update("video", contentValues, "video_url = ? ", new String[]{str});
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("VideoDao", e11.getLocalizedMessage());
            }
        }
    }

    public synchronized boolean a(String str, String str2) {
        String[] strArr;
        String str3;
        try {
            if (TextUtils.isEmpty(str2)) {
                str3 = "SELECT id FROM video WHERE video_url = ? ";
                strArr = new String[]{str};
            } else {
                strArr = new String[]{str, str2};
                str3 = "SELECT id FROM video WHERE video_url = ? AND id = ? ";
            }
            Cursor rawQuery = getReadableDatabase().rawQuery(str3, strArr);
            if (rawQuery != null && rawQuery.getCount() > 0) {
                try {
                    rawQuery.close();
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("VideoDao", e11.getLocalizedMessage());
                    }
                }
                return true;
            }
            if (rawQuery != null) {
                try {
                    rawQuery.close();
                } catch (Exception e12) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("VideoDao", e12.getLocalizedMessage());
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
        throw th2;
    }

    public synchronized long b(String str, long j11) {
        int i11 = -1;
        try {
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("VideoDao", e11.getLocalizedMessage());
            }
        }
        if (getWritableDatabase() == null) {
            return -1;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("total_size", Long.valueOf(j11));
        if (a(str, "")) {
            String[] strArr = {str};
            synchronized (new Object()) {
                i11 = getWritableDatabase().update("video", contentValues, "video_url = ? ", strArr);
            }
        }
        return i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9 A[Catch: all -> 0x007d, TRY_LEAVE, TryCatch #7 {all -> 0x007d, blocks: (B:23:0x001a, B:25:0x0020, B:27:0x0025, B:29:0x002b, B:34:0x00a5, B:36:0x00a9), top: B:22:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.mbridge.msdk.foundation.entity.l b(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.m.b(java.lang.String):com.mbridge.msdk.foundation.entity.l");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0092, code lost:
    
        if (r0 != null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ab, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a4, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a2, code lost:
    
        if (r0 != null) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized com.mbridge.msdk.foundation.entity.l b(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Throwable -> La8
            r0 = 0
            if (r7 == 0) goto La
            monitor-exit(r5)
            return r0
        La:
            com.mbridge.msdk.foundation.entity.l r7 = new com.mbridge.msdk.foundation.entity.l     // Catch: java.lang.Throwable -> La8
            r7.<init>()     // Catch: java.lang.Throwable -> La8
            java.lang.String[] r6 = new java.lang.String[]{r6}     // Catch: java.lang.Throwable -> La8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La8
            r1.<init>()     // Catch: java.lang.Throwable -> La8
            java.lang.String r2 = "SELECT * FROM video"
            r1.append(r2)     // Catch: java.lang.Throwable -> La8
            java.lang.String r2 = " WHERE video_url = ? "
            r1.append(r2)     // Catch: java.lang.Throwable -> La8
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La8
            android.database.sqlite.SQLiteDatabase r2 = r5.getReadableDatabase()     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            android.database.Cursor r0 = r2.rawQuery(r1, r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            if (r0 == 0) goto L92
            int r6 = r0.getCount()     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            if (r6 <= 0) goto L92
        L36:
            boolean r6 = r0.moveToNext()     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            if (r6 == 0) goto L92
            java.lang.String r6 = "video_url"
            int r6 = r0.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            java.lang.String r6 = r0.getString(r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            r7.b(r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            java.lang.String r6 = "video_state"
            int r6 = r0.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            int r6 = r0.getInt(r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            r7.a(r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            java.lang.String r6 = "pregeress_size"
            int r6 = r0.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            long r1 = r0.getLong(r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            r7.b(r1)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            java.lang.String r6 = "total_size"
            int r6 = r0.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            int r6 = r0.getInt(r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            r7.b(r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            java.lang.String r6 = "video_path"
            int r6 = r0.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            java.lang.String r6 = r0.getString(r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            r7.a(r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            java.lang.String r6 = "video_download_start"
            int r6 = r0.getColumnIndex(r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            long r1 = r0.getLong(r6)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 * r3
            r7.a(r1)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            goto L36
        L8e:
            r6 = move-exception
            goto Lac
        L90:
            r6 = move-exception
            goto L95
        L92:
            if (r0 == 0) goto Laa
            goto La4
        L95:
            boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch: java.lang.Throwable -> L8e
            if (r1 == 0) goto La2
            java.lang.String r1 = "VideoDao"
            java.lang.String r6 = r6.getLocalizedMessage()     // Catch: java.lang.Throwable -> L8e
            com.mbridge.msdk.foundation.tools.o0.b(r1, r6)     // Catch: java.lang.Throwable -> L8e
        La2:
            if (r0 == 0) goto Laa
        La4:
            r0.close()     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Laa
            goto Laa
        La8:
            r6 = move-exception
            goto Lb2
        Laa:
            monitor-exit(r5)
            return r7
        Lac:
            if (r0 == 0) goto Lb1
            r0.close()     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Lb1
        Lb1:
            throw r6     // Catch: java.lang.Throwable -> La8
        Lb2:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> La8
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.m.b(java.lang.String, java.lang.String):com.mbridge.msdk.foundation.entity.l");
    }
}
