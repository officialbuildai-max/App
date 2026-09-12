package com.transsion.athena.attribution;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import g5.a;
import g5.c;
import g5.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class ReferrerTask implements Runnable {
    private final int mAppId;
    private final Context mContext;
    private a referrerClient;

    public ReferrerTask(Context context, int i11) {
        this.mContext = context;
        this.mAppId = i11;
    }

    private void checkGpReferrer() {
        if (isAppIdGpRefTracked()) {
            AttrLog.d("appId : " + this.mAppId + " referrer has tracked !");
            return;
        }
        String cachedGpRef = getCachedGpRef();
        if (!TextUtils.isEmpty(cachedGpRef)) {
            AttrLog.d("appId : " + this.mAppId + " has cached GP referrer !");
            try {
                trackGpReferrer(cachedGpRef);
                markAppIdGpRefTracked();
                return;
            } catch (Exception e11) {
                AttrLog.printStackTrace(e11);
                return;
            }
        }
        try {
            if (this.referrerClient == null) {
                this.referrerClient = a.c(this.mContext).a();
            }
            AttrLog.d("appId : " + this.mAppId + " referrerClient startConnection");
            this.referrerClient.d(new c() { // from class: com.transsion.athena.attribution.ReferrerTask.1
                @Override // g5.c
                public void onInstallReferrerServiceDisconnected() {
                    if (ReferrerTask.this.referrerClient != null) {
                        ReferrerTask.this.referrerClient.a();
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0050 A[ORIG_RETURN, RETURN] */
                @Override // g5.c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onInstallReferrerSetupFinished(int r2) {
                    /*
                        r1 = this;
                        if (r2 == 0) goto L19
                        r0 = 1
                        if (r2 == r0) goto L13
                        r0 = 2
                        if (r2 == r0) goto L9
                        goto L32
                    L9:
                        java.lang.String r2 = "InstallReferrerResponse.FEATURE_NOT_SUPPORTED"
                        com.transsion.athena.attribution.AttrLog.d(r2)     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
                        goto L32
                    Lf:
                        r2 = move-exception
                        goto L51
                    L11:
                        r2 = move-exception
                        goto L44
                    L13:
                        java.lang.String r2 = "InstallReferrerResponse.SERVICE_UNAVAILABLE"
                        com.transsion.athena.attribution.AttrLog.d(r2)     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
                        goto L32
                    L19:
                        java.lang.String r2 = "InstallReferrerResponse.OK"
                        com.transsion.athena.attribution.AttrLog.d(r2)     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
                        com.transsion.athena.attribution.ReferrerTask r2 = com.transsion.athena.attribution.ReferrerTask.this     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
                        g5.a r2 = com.transsion.athena.attribution.ReferrerTask.access$000(r2)     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
                        g5.d r2 = r2.b()     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
                        com.transsion.athena.attribution.ReferrerTask r0 = com.transsion.athena.attribution.ReferrerTask.this     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
                        com.transsion.athena.attribution.ReferrerTask.access$100(r0, r2)     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
                        com.transsion.athena.attribution.ReferrerTask r2 = com.transsion.athena.attribution.ReferrerTask.this     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
                        com.transsion.athena.attribution.ReferrerTask.access$200(r2)     // Catch: java.lang.Throwable -> Lf java.lang.Exception -> L11
                    L32:
                        com.transsion.athena.attribution.ReferrerTask r2 = com.transsion.athena.attribution.ReferrerTask.this
                        g5.a r2 = com.transsion.athena.attribution.ReferrerTask.access$000(r2)
                        if (r2 == 0) goto L50
                    L3a:
                        com.transsion.athena.attribution.ReferrerTask r2 = com.transsion.athena.attribution.ReferrerTask.this
                        g5.a r2 = com.transsion.athena.attribution.ReferrerTask.access$000(r2)
                        r2.a()
                        goto L50
                    L44:
                        com.transsion.athena.attribution.AttrLog.printStackTrace(r2)     // Catch: java.lang.Throwable -> Lf
                        com.transsion.athena.attribution.ReferrerTask r2 = com.transsion.athena.attribution.ReferrerTask.this
                        g5.a r2 = com.transsion.athena.attribution.ReferrerTask.access$000(r2)
                        if (r2 == 0) goto L50
                        goto L3a
                    L50:
                        return
                    L51:
                        com.transsion.athena.attribution.ReferrerTask r0 = com.transsion.athena.attribution.ReferrerTask.this
                        g5.a r0 = com.transsion.athena.attribution.ReferrerTask.access$000(r0)
                        if (r0 == 0) goto L62
                        com.transsion.athena.attribution.ReferrerTask r0 = com.transsion.athena.attribution.ReferrerTask.this
                        g5.a r0 = com.transsion.athena.attribution.ReferrerTask.access$000(r0)
                        r0.a()
                    L62:
                        throw r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.transsion.athena.attribution.ReferrerTask.AnonymousClass1.onInstallReferrerSetupFinished(int):void");
                }
            });
        } catch (Exception e12) {
            AttrLog.printStackTrace(e12);
        }
    }

    private void checkPsReferrer() {
        if (isAppIdPsRefTracked()) {
            return;
        }
        String cachedPsRef = getCachedPsRef();
        if (!TextUtils.isEmpty(cachedPsRef)) {
            try {
                trackPsReferrer(cachedPsRef);
                markAppIdPsRefTracked();
                return;
            } catch (Exception e11) {
                AttrLog.printStackTrace(e11);
                return;
            }
        }
        try {
            Cursor query = this.mContext.getContentResolver().query(Uri.parse(AttrConstant.PS_REFERRER_PROVIDER_URI), null, null, new String[]{this.mContext.getPackageName()}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        trackPsReferrer(query.getString(0), query.getString(1), query.getString(2), query.getString(3));
                        markAppIdPsRefTracked();
                    } else {
                        AttrLog.d(this.mContext.getPackageName() + " Referrer not found");
                    }
                } finally {
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e12) {
            AttrLog.printStackTrace(e12);
        }
    }

    private String getCachedGpRef() {
        return SpUtils.getInstance(this.mContext).getString(AttrConstant.KEY_GP_REF);
    }

    private String getCachedPsRef() {
        return SpUtils.getInstance(this.mContext).getString(AttrConstant.KEY_PS_REF);
    }

    private boolean isAppIdGpRefTracked() {
        SpUtils spUtils = SpUtils.getInstance(this.mContext);
        return !TextUtils.isEmpty(spUtils.getString("key_appid_gp_track_flag_" + this.mAppId));
    }

    private boolean isAppIdPsRefTracked() {
        SpUtils spUtils = SpUtils.getInstance(this.mContext);
        return !TextUtils.isEmpty(spUtils.getString("key_appid_ps_track_flag_" + this.mAppId));
    }

    private boolean isGpReferrerValid(d dVar) {
        if (dVar == null) {
            return false;
        }
        String d11 = dVar.d();
        long f11 = dVar.f();
        return !TextUtils.isEmpty(d11) && f11 > 0 && dVar.b() >= f11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markAppIdGpRefTracked() {
        SpUtils.getInstance(this.mContext).saveString("key_appid_gp_track_flag_" + this.mAppId, String.valueOf(System.currentTimeMillis()));
    }

    private void markAppIdPsRefTracked() {
        SpUtils.getInstance(this.mContext).saveString("key_appid_ps_track_flag_" + this.mAppId, String.valueOf(System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trackGpReferrer(d dVar) {
        if (dVar == null) {
            return;
        }
        String d11 = dVar.d();
        String e11 = dVar.e();
        long f11 = dVar.f();
        long g11 = dVar.g();
        long b11 = dVar.b();
        long c11 = dVar.c();
        boolean a11 = dVar.a();
        Bundle bundle = new Bundle();
        bundle.putString(AttrConstant.KEY_INSTALL_REFERRER, d11);
        bundle.putString(AttrConstant.KEY_INSTALL_VERSION, e11);
        bundle.putLong(AttrConstant.KEY_REFERRER_CLICK_TIMESTAMP, f11);
        bundle.putLong(AttrConstant.KEY_REFERRER_CLICK_TIMESTAMP_SERVER, g11);
        bundle.putLong(AttrConstant.KEY_INSTALL_BEGIN_TIMESTAMP, b11);
        bundle.putLong(AttrConstant.KEY_INSTALL_BEGIN_TIMESTAMP_SERVER, c11);
        bundle.putBoolean(AttrConstant.KEY_GOOGLE_PLAY_INSTANT, a11);
        new yi.a(AttrConstant.GP_REFERRER_EVENT, this.mAppId).c(bundle, null).b();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AttrConstant.KEY_INSTALL_REFERRER, d11);
            jSONObject.put(AttrConstant.KEY_INSTALL_VERSION, e11);
            jSONObject.put(AttrConstant.KEY_REFERRER_CLICK_TIMESTAMP, f11);
            jSONObject.put(AttrConstant.KEY_REFERRER_CLICK_TIMESTAMP_SERVER, g11);
            jSONObject.put(AttrConstant.KEY_INSTALL_BEGIN_TIMESTAMP, b11);
            jSONObject.put(AttrConstant.KEY_INSTALL_BEGIN_TIMESTAMP_SERVER, c11);
            jSONObject.put(AttrConstant.KEY_GOOGLE_PLAY_INSTANT, a11);
            SpUtils.getInstance(this.mContext).saveString(AttrConstant.KEY_GP_REF, jSONObject.toString());
        } catch (Exception e12) {
            AttrLog.printStackTrace(e12);
        }
    }

    private void trackGpReferrer(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        Bundle bundle = new Bundle();
        bundle.putString(AttrConstant.KEY_INSTALL_REFERRER, jSONObject.optString(AttrConstant.KEY_INSTALL_REFERRER));
        bundle.putString(AttrConstant.KEY_INSTALL_VERSION, jSONObject.optString(AttrConstant.KEY_INSTALL_VERSION));
        bundle.putLong(AttrConstant.KEY_REFERRER_CLICK_TIMESTAMP, jSONObject.optLong(AttrConstant.KEY_REFERRER_CLICK_TIMESTAMP));
        bundle.putLong(AttrConstant.KEY_REFERRER_CLICK_TIMESTAMP_SERVER, jSONObject.optLong(AttrConstant.KEY_REFERRER_CLICK_TIMESTAMP_SERVER));
        bundle.putLong(AttrConstant.KEY_INSTALL_BEGIN_TIMESTAMP, jSONObject.optLong(AttrConstant.KEY_INSTALL_BEGIN_TIMESTAMP));
        bundle.putLong(AttrConstant.KEY_INSTALL_BEGIN_TIMESTAMP_SERVER, jSONObject.optLong(AttrConstant.KEY_INSTALL_BEGIN_TIMESTAMP_SERVER));
        bundle.putBoolean(AttrConstant.KEY_GOOGLE_PLAY_INSTANT, jSONObject.optBoolean(AttrConstant.KEY_GOOGLE_PLAY_INSTANT));
        new yi.a(AttrConstant.GP_REFERRER_EVENT, this.mAppId).c(bundle, null).b();
    }

    private void trackPsReferrer(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        Bundle bundle = new Bundle();
        bundle.putString(AttrConstant.KEY_INSTALL_REFERRER, jSONObject.optString(AttrConstant.KEY_INSTALL_REFERRER));
        bundle.putString(AttrConstant.KEY_START_CLICK_TIME, jSONObject.optString(AttrConstant.KEY_START_CLICK_TIME));
        bundle.putString(AttrConstant.KEY_START_DOWNLOAD_TIME, jSONObject.optString(AttrConstant.KEY_START_DOWNLOAD_TIME));
        bundle.putString(AttrConstant.KEY_INSTALLED_FINISH_TIME, jSONObject.optString(AttrConstant.KEY_INSTALLED_FINISH_TIME));
        new yi.a(AttrConstant.PS_REFERRER_EVENT, this.mAppId).c(bundle, null).b();
    }

    private void trackPsReferrer(String str, String str2, String str3, String str4) {
        Bundle bundle = new Bundle();
        bundle.putString(AttrConstant.KEY_INSTALL_REFERRER, str);
        bundle.putString(AttrConstant.KEY_START_CLICK_TIME, str2);
        bundle.putString(AttrConstant.KEY_START_DOWNLOAD_TIME, str3);
        bundle.putString(AttrConstant.KEY_INSTALLED_FINISH_TIME, str4);
        new yi.a(AttrConstant.PS_REFERRER_EVENT, this.mAppId).c(bundle, null).b();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AttrConstant.KEY_INSTALL_REFERRER, str);
            jSONObject.put(AttrConstant.KEY_START_CLICK_TIME, str2);
            jSONObject.put(AttrConstant.KEY_START_DOWNLOAD_TIME, str3);
            jSONObject.put(AttrConstant.KEY_INSTALLED_FINISH_TIME, str4);
            SpUtils.getInstance(this.mContext).saveString(AttrConstant.KEY_PS_REF, jSONObject.toString());
        } catch (Exception e11) {
            AttrLog.printStackTrace(e11);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        AttrLog.d("====================\\ ReferrerTask start \\================");
        try {
            checkGpReferrer();
            checkPsReferrer();
        } catch (Exception e11) {
            AttrLog.printStackTrace(e11);
        }
        AttrLog.d("====================\\ ReferrerTask end \\================");
    }
}
