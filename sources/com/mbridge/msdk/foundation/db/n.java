package com.mbridge.msdk.foundation.db;

import android.content.ContentValues;
import android.text.TextUtils;
import com.cloud.tmc.integration.bridge.NetworkBridge;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.y0;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.net.URLEncoder;

/* loaded from: classes5.dex */
public class n extends a<com.mbridge.msdk.foundation.entity.m> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f35168a = "com.mbridge.msdk.foundation.db.n";

    /* renamed from: b, reason: collision with root package name */
    private static n f35169b;

    private n(f fVar) {
        super(fVar);
    }

    public static n a(f fVar) {
        if (f35169b == null) {
            synchronized (n.class) {
                try {
                    if (f35169b == null) {
                        f35169b = new n(fVar);
                    }
                } finally {
                }
            }
        }
        return f35169b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        if (r1 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0026, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0024, code lost:
    
        if (r1 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized int a() {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            r1 = 0
            java.lang.String r2 = "select count(*) from reward_report"
            android.database.sqlite.SQLiteDatabase r3 = r4.getReadableDatabase()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            android.database.Cursor r1 = r3.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r1 == 0) goto L1e
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            if (r2 == 0) goto L1e
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L1a java.lang.Exception -> L1c
            goto L1e
        L1a:
            r0 = move-exception
            goto L2e
        L1c:
            r2 = move-exception
            goto L21
        L1e:
            if (r1 == 0) goto L2c
            goto L26
        L21:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L1a
            if (r1 == 0) goto L2c
        L26:
            r1.close()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2c
            goto L2c
        L2a:
            r0 = move-exception
            goto L34
        L2c:
            monitor-exit(r4)
            return r0
        L2e:
            if (r1 == 0) goto L33
            r1.close()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L33
        L33:
            throw r0     // Catch: java.lang.Throwable -> L2a
        L34:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L2a
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.a():int");
    }

    public synchronized long a(com.mbridge.msdk.foundation.entity.m mVar) {
        try {
            if (mVar != null) {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("key", mVar.n());
                    contentValues.put(NetworkBridge.KEY_NETWORK_TYPE, Integer.valueOf(mVar.q()));
                    contentValues.put("network_str", mVar.r());
                    contentValues.put("isCompleteView", Integer.valueOf(mVar.m()));
                    contentValues.put("watchedMillis", Integer.valueOf(mVar.F()));
                    contentValues.put(MRAIDPresenter.VIDEO_LENGTH, Integer.valueOf(mVar.C()));
                    if (!TextUtils.isEmpty(mVar.s())) {
                        contentValues.put("offerUrl", mVar.s());
                    }
                    if (!TextUtils.isEmpty(mVar.t())) {
                        contentValues.put("reason", URLEncoder.encode(mVar.t(), "utf-8"));
                    }
                    contentValues.put("result", Integer.valueOf(mVar.x()));
                    contentValues.put("duration", mVar.g());
                    contentValues.put("videoSize", Long.valueOf(mVar.D()));
                    contentValues.put(NativeComponentConstants.KEY_COMPONENT_TYPE, mVar.h());
                    String i11 = mVar.i();
                    if (!TextUtils.isEmpty(i11)) {
                        contentValues.put("endcard_url", i11);
                    }
                    String E = mVar.E();
                    if (!TextUtils.isEmpty(E)) {
                        contentValues.put(CampaignEx.JSON_KEY_VIDEO_URL, E);
                    }
                    String u11 = mVar.u();
                    if (!TextUtils.isEmpty(u11)) {
                        contentValues.put("rid", u11);
                    }
                    String v11 = mVar.v();
                    if (!TextUtils.isEmpty(v11)) {
                        contentValues.put("rid_n", v11);
                    }
                    String z10 = mVar.z();
                    if (!TextUtils.isEmpty(z10)) {
                        contentValues.put("template_url", z10);
                    }
                    String l11 = mVar.l();
                    if (!TextUtils.isEmpty(l11)) {
                        contentValues.put("image_url", l11);
                    }
                    String a11 = mVar.a();
                    if (!TextUtils.isEmpty(a11)) {
                        contentValues.put("ad_type", URLEncoder.encode(a11, "utf-8"));
                    }
                    contentValues.put("unitId", mVar.B());
                    contentValues.put("campaignId", mVar.d());
                    if ("2000039".equals(mVar.n())) {
                        String b11 = o.b(mVar);
                        if (y0.b(b11)) {
                            contentValues.put("h5_click_data", b11);
                        }
                    }
                    String w11 = mVar.w();
                    if (!TextUtils.isEmpty(w11)) {
                        contentValues.put("resource_type", URLEncoder.encode(w11, "utf-8"));
                    }
                    String f11 = mVar.f();
                    if (!TextUtils.isEmpty(f11)) {
                        contentValues.put("device_id", URLEncoder.encode(f11, "utf-8"));
                    }
                    String e11 = mVar.e();
                    if (!TextUtils.isEmpty(e11)) {
                        contentValues.put("creative", URLEncoder.encode(e11, "utf-8"));
                    }
                    contentValues.put(CampaignEx.JSON_KEY_NEW_INTERSTITIAL_AD_SPACE_T, Integer.valueOf(mVar.b()));
                    return getWritableDatabase().insert("reward_report", null, contentValues);
                } catch (Exception e12) {
                    o0.b(f35168a, e12.getMessage());
                }
            }
            return -1L;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x035b, code lost:
    
        if (r11 == null) goto L129;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0363 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.List<com.mbridge.msdk.foundation.entity.m> a(java.lang.String r25) {
        /*
            Method dump skipped, instructions count: 876
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.db.n.a(java.lang.String):java.util.List");
    }
}
