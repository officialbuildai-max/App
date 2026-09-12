package com.cloud.hisavana.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.cloud.hisavana.sdk.common.activity.TAdInterstitialActivity;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.transsion.push.PushConstants;

/* loaded from: classes3.dex */
public class p4 {

    /* renamed from: a, reason: collision with root package name */
    private a f22924a;

    /* renamed from: c, reason: collision with root package name */
    private final s3 f22926c;

    /* renamed from: d, reason: collision with root package name */
    private AdsDTO f22927d;

    /* renamed from: b, reason: collision with root package name */
    private boolean f22925b = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f22928e = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        private final p4 f22929a;

        a(p4 p4Var) {
            this.f22929a = p4Var;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action;
            e4.b().d("InterGemini", "fc_problem_onReceive,intent: " + intent);
            if (intent == null || (action = intent.getAction()) == null || this.f22929a == null) {
                return;
            }
            if (action.equals(this.f22929a.g() + "_click")) {
                e4.b().d("InterGemini", "receive interstitial click");
                AdsDTO adsDTO = (AdsDTO) intent.getParcelableExtra("mAdBean");
                if (adsDTO != null) {
                    this.f22929a.f22927d = adsDTO;
                    this.f22929a.f22926c.G(adsDTO);
                }
                if (adsDTO != null && adsDTO.isAllowTrackingADClick()) {
                    AthenaTracker.W(adsDTO);
                } else if (adsDTO != null) {
                    adsDTO.setAdClickTracking(true);
                    e4.b().d("InterGemini", "tracking is not allowed，change isAdClickTracking = true");
                }
                this.f22929a.f22926c.I();
                return;
            }
            if (action.equals(this.f22929a.g() + "_close")) {
                e4.b().d("InterGemini", "receive interstitial ad_close");
                AdsDTO adsDTO2 = (AdsDTO) intent.getParcelableExtra("mAdBean");
                if (adsDTO2 != null) {
                    this.f22929a.f22927d = adsDTO2;
                    this.f22929a.f22926c.G(adsDTO2);
                }
                this.f22929a.f22926c.J();
                this.f22929a.k();
                this.f22929a.f22924a = null;
                return;
            }
            if (action.equals(this.f22929a.g() + "_error")) {
                e4.b().d("InterGemini", "receive interstitial error");
                this.f22929a.f22926c.F(new TaErrorCode(intent.getIntExtra("error_code", -1), intent.getStringExtra(OfflineConstantsKt.TRACK_KEY_PRE_ERROR_MSG)));
                this.f22929a.k();
                this.f22929a.f22924a = null;
                return;
            }
            if (action.equals(this.f22929a.g() + "_show")) {
                e4.b().d("InterGemini", "receive interstitial show");
                this.f22929a.f22926c.K();
                return;
            }
            if (action.equals(this.f22929a.g() + "_pre_imp")) {
                e4.b().d("InterGemini", "receive interstitial pre impression");
                return;
            }
            if (action.equals(this.f22929a.g() + "_destroy")) {
                e4.b().d("InterGemini", "receive interstitial ad_destroy");
                p4 p4Var = this.f22929a;
                if (p4Var != null) {
                    p4Var.k();
                    this.f22929a.f22924a = null;
                }
            }
        }
    }

    public p4(s3 s3Var) {
        this.f22926c = s3Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g() {
        if (this.f22927d == null) {
            return null;
        }
        return com.cloud.sdk.commonutil.util.e.d() + "_adx_" + this.f22927d.getId();
    }

    private void h() {
        if (this.f22925b) {
            e4.b().w("InterGemini", "registerInterstitialAdReceiver: already registered, skip");
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            String g11 = g();
            intentFilter.addAction(g11 + "_click");
            intentFilter.addAction(g11 + "_close");
            intentFilter.addAction(g11 + "_show");
            intentFilter.addAction(g11 + "_pre_imp");
            intentFilter.addAction(g11 + "_error");
            intentFilter.addAction(g11 + "_destroy");
            if (Build.VERSION.SDK_INT >= 33) {
                com.cloud.sdk.commonutil.util.e.a().registerReceiver(this.f22924a, intentFilter, 2);
            } else {
                com.cloud.sdk.commonutil.util.e.a().registerReceiver(this.f22924a, intentFilter);
            }
            this.f22925b = true;
            e4.b().d("InterGemini", "registerInterstitialAdReceiver");
        } catch (Exception e11) {
            e4.b().w("InterGemini", "registerInterstitialAdReceiver error: " + e11.getMessage());
        }
    }

    private void j() {
        e4.b().d("InterGemini", "interstitial showNormalAd");
        if (this.f22924a == null) {
            this.f22924a = new a(this);
        }
        h();
        AdsDTO adsDTO = this.f22927d;
        if (adsDTO != null) {
            adsDTO.setCloseDelayTime(this.f22926c.n(adsDTO));
            this.f22927d.setRetentionEndCardRatio(this.f22926c.x());
        }
        TAdInterstitialActivity.M(this.f22926c);
        Intent intent = new Intent(com.cloud.sdk.commonutil.util.e.a(), (Class<?>) TAdInterstitialActivity.class);
        intent.setFlags(268500992);
        intent.putExtra("mAdBean", this.f22927d);
        intent.putExtra("BroadCastPrefix", g());
        com.cloud.sdk.commonutil.util.e.a().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f22924a != null) {
            try {
                try {
                    com.cloud.sdk.commonutil.util.e.a().unregisterReceiver(this.f22924a);
                } catch (IllegalArgumentException e11) {
                    e4.b().w("InterGemini", "unregisterReceiver: " + e11.getMessage());
                }
            } finally {
                this.f22924a = null;
                this.f22925b = false;
            }
        }
    }

    public void d() {
        k();
        e4.b().d("InterGemini", PushConstants.PROVIDER_FIELD_DESTROY);
    }

    public void e(AdsDTO adsDTO) {
        this.f22927d = adsDTO;
        if (adsDTO != null) {
            j();
            return;
        }
        s3 s3Var = this.f22926c;
        if (s3Var != null) {
            s3Var.F(TaErrorCode.ERROR_SHOW_ADBEAN_NULL);
        }
        e4.b().d("InterGemini", "show() --> mAdBean == null");
    }
}
