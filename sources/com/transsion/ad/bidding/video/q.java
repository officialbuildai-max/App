package com.transsion.ad.bidding.video;

import android.app.Activity;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.mediation.ad.TRewardedAd;
import com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class q extends AbsBiddingInterceptHiSavanaAdManager {

    /* renamed from: j, reason: collision with root package name */
    public static final a f42121j = new a(null);

    /* renamed from: k, reason: collision with root package name */
    private static final Lazy f42122k = LazyKt.b(new Function0() { // from class: com.transsion.ad.bidding.video.p
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            HashMap w11;
            w11 = q.w();
            return w11;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    private TRewardedAd f42123i;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final HashMap a() {
            return (HashMap) q.f42122k.getValue();
        }

        public final q b(String str) {
            String h11;
            if (TextUtils.isEmpty(str) || (h11 = com.transsion.ad.scene.a.f42255a.h(str)) == null) {
                return null;
            }
            q qVar = (q) a().get(h11);
            if (qVar != null) {
                return qVar;
            }
            q qVar2 = new q();
            qVar2.q(h11);
            a().put(h11, qVar2);
            return qVar2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap w() {
        return new HashMap();
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager
    public ce.b e() {
        String i11 = i();
        if (TextUtils.isEmpty(i11)) {
            return null;
        }
        if (this.f42123i == null) {
            TRewardedAd tRewardedAd = new TRewardedAd(Utils.a(), i11);
            this.f42123i = tRewardedAd;
            tRewardedAd.setRequestBody(new TAdRequestBody.AdRequestBodyBuild().setAdditionalListener(this).build());
        }
        return this.f42123i;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager
    public int f() {
        return 3;
    }

    @Override // oi.b
    public String getLogTag() {
        return "ad_v";
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager
    public void o() {
        TRewardedAd tRewardedAd = this.f42123i;
        if (tRewardedAd != null) {
            tRewardedAd.destroy();
        }
        this.f42123i = null;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager
    public void r(Activity topActivity, String sceneId, Integer num, Map map) {
        Object m1185constructorimpl;
        di.a h11;
        Unit unit;
        TRewardedAd tRewardedAd;
        Intrinsics.h(topActivity, "topActivity");
        Intrinsics.h(sceneId, "sceneId");
        if (com.transsion.ad.strategy.d.f42285a.d(map) && (tRewardedAd = this.f42123i) != null) {
            tRewardedAd.setContainVulgarContent(true);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            TRewardedAd tRewardedAd2 = this.f42123i;
            if (tRewardedAd2 != null) {
                tRewardedAd2.show(topActivity);
                unit = Unit.f67184a;
            } else {
                di.a h12 = h();
                if (h12 != null) {
                    h12.onShowError(new TAdErrorCode(-1, "tInterstitialAd == null"), new AdditionalInfo());
                    unit = Unit.f67184a;
                } else {
                    unit = null;
                }
            }
            m1185constructorimpl = Result.m1185constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null || (h11 = h()) == null) {
            return;
        }
        h11.onShowError(new TAdErrorCode(-1, "程序化 show 异常 it = " + m1188exceptionOrNullimpl.getMessage()), new AdditionalInfo());
    }
}
