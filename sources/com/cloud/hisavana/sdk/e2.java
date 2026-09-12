package com.cloud.hisavana.sdk;

import android.content.Context;
import android.content.Intent;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.hisavana.sdk.common.activity.HisavanaInterstitialRewardedActivity;
import com.cloud.hisavana.sdk.common.activity.HisavanaRewardedActivity;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import java.lang.ref.WeakReference;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class e2 implements q {

    /* renamed from: a, reason: collision with root package name */
    private x3 f22508a;

    /* renamed from: b, reason: collision with root package name */
    private final String f22509b;

    /* renamed from: c, reason: collision with root package name */
    private AdsDTO f22510c;

    /* renamed from: d, reason: collision with root package name */
    private long f22511d;

    public e2(x3 tranRewarded) {
        Intrinsics.h(tranRewarded, "tranRewarded");
        this.f22508a = tranRewarded;
        this.f22509b = "Rewarded";
        this.f22511d = b2.f21767a.b(this);
    }

    private final String d() {
        String d11 = com.cloud.sdk.commonutil.util.e.d();
        if (d11 == null) {
            return null;
        }
        return d11 + "_rewarded";
    }

    private final void e() {
        try {
            HisavanaRewardedActivity.INSTANCE.a(new WeakReference(this.f22508a));
            AdsDTO adsDTO = this.f22510c;
            if (adsDTO != null) {
                adsDTO.setCloseDelayTime(this.f22508a.n(adsDTO));
            }
            AdsDTO adsDTO2 = this.f22510c;
            Intent intent = new Intent(com.cloud.sdk.commonutil.util.e.a(), (Class<?>) ((adsDTO2 == null || adsDTO2.getAdType() != 7) ? HisavanaRewardedActivity.class : HisavanaInterstitialRewardedActivity.class));
            intent.setFlags(268500992);
            intent.putExtra("adBean", this.f22510c);
            intent.putExtra(RequestParameters.PREFIX, d());
            intent.putExtra("observerId", this.f22511d);
            intent.putExtra("triggerTs", System.currentTimeMillis());
            com.cloud.sdk.commonutil.util.e.a().startActivity(intent);
        } catch (Exception e11) {
            e4.b().e(this.f22509b, "show failed --> " + e11.getMessage());
        }
    }

    @Override // com.cloud.hisavana.sdk.q
    public void a(long j11, String event, Object obj) {
        AdsDTO adsDTO;
        Intrinsics.h(event, "event");
        if (e4.c()) {
            e4.b().d(this.f22509b, "onEvent --> id = " + j11 + ", event = " + event + ", params = " + obj);
        }
        if (Intrinsics.c(event, d() + "_show")) {
            this.f22508a.I();
            return;
        }
        if (Intrinsics.c(event, d() + "_rewarded")) {
            if (obj != null && (adsDTO = this.f22510c) != null) {
                adsDTO.setTriggerShowSpend(((Long) obj).longValue());
            }
            this.f22508a.J();
            return;
        }
        if (Intrinsics.c(event, d() + "_error")) {
            this.f22508a.F(obj == null ? new TaErrorCode(-1, "ad show error") : (TaErrorCode) obj);
            return;
        }
        if (!Intrinsics.c(event, d() + "_click")) {
            if (Intrinsics.c(event, d() + "_close")) {
                this.f22508a.H();
                return;
            }
            return;
        }
        DownUpPointBean downUpPointBean = new DownUpPointBean();
        if (obj != null) {
            Pair pair = (Pair) obj;
            Object first = pair.getFirst();
            Intrinsics.f(first, "null cannot be cast to non-null type com.cloud.hisavana.sdk.data.bean.response.AdsDTO");
            this.f22510c = (AdsDTO) first;
            if (pair.getSecond() != null) {
                Object second = pair.getSecond();
                Intrinsics.f(second, "null cannot be cast to non-null type com.cloud.hisavana.sdk.common.tracking.DownUpPointBean");
                downUpPointBean = (DownUpPointBean) second;
            }
        }
        AdsDTO adsDTO2 = this.f22510c;
        boolean isAllowTrackingADClick = adsDTO2 != null ? adsDTO2.isAllowTrackingADClick() : true;
        Context a11 = com.cloud.sdk.commonutil.util.e.a();
        AdsDTO adsDTO3 = this.f22510c;
        q3 p11 = this.f22508a.p();
        N0.c(a11, adsDTO3, downUpPointBean, p11 != null && p11.v(), !isAllowTrackingADClick);
        if (isAllowTrackingADClick) {
            AthenaTracker.W(this.f22510c);
        } else {
            AdsDTO adsDTO4 = this.f22510c;
            if (adsDTO4 != null) {
                adsDTO4.setAdClickTracking(true);
            }
            e4.b().d("ssp", "tracking is not allowed，change isAdClickTracking = true");
        }
        this.f22508a.G();
    }

    public final void b() {
        b2.f21767a.c(this.f22511d);
    }

    public final void c(AdsDTO adsDTO) {
        Unit unit;
        this.f22510c = adsDTO;
        if (adsDTO != null) {
            e();
            unit = Unit.f67184a;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.f22508a.F(TaErrorCode.ERROR_SHOW_ADBEAN_NULL);
            e4.b().w(this.f22509b, "show() --> adBean == null");
        }
    }
}
