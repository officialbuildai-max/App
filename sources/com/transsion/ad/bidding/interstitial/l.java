package com.transsion.ad.bidding.interstitial;

import android.app.Activity;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.mediation.ad.TInterstitialAd;
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
public final class l extends AbsBiddingInterceptHiSavanaAdManager {

    /* renamed from: j, reason: collision with root package name */
    public static final a f42034j = new a(null);

    /* renamed from: k, reason: collision with root package name */
    private static final Lazy f42035k = LazyKt.b(new Function0() { // from class: com.transsion.ad.bidding.interstitial.k
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            HashMap w11;
            w11 = l.w();
            return w11;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    private TInterstitialAd f42036i;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final HashMap a() {
            return (HashMap) l.f42035k.getValue();
        }

        public final l b(String str) {
            String h11;
            if (TextUtils.isEmpty(str) || (h11 = com.transsion.ad.scene.a.f42255a.h(str)) == null) {
                return null;
            }
            l lVar = (l) a().get(h11);
            if (lVar != null) {
                return lVar;
            }
            l lVar2 = new l();
            lVar2.q(h11);
            a().put(h11, lVar2);
            return lVar2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap w() {
        return new HashMap();
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager
    public ce.b e() {
        if (this.f42036i == null) {
            TInterstitialAd tInterstitialAd = new TInterstitialAd(Utils.a(), i());
            this.f42036i = tInterstitialAd;
            tInterstitialAd.setRequestBody(new TAdRequestBody.AdRequestBodyBuild().setAdditionalListener(this).build());
        }
        return this.f42036i;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager
    public int f() {
        return 4;
    }

    @Override // oi.b
    public String getLogTag() {
        return "ad_int";
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager
    public void o() {
        TInterstitialAd tInterstitialAd = this.f42036i;
        if (tInterstitialAd != null) {
            tInterstitialAd.destroy();
        }
        this.f42036i = null;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager
    public void r(Activity topActivity, String sceneId, Integer num, Map map) {
        Object m1185constructorimpl;
        di.a h11;
        Unit unit;
        TInterstitialAd tInterstitialAd;
        Intrinsics.h(topActivity, "topActivity");
        Intrinsics.h(sceneId, "sceneId");
        if (com.transsion.ad.strategy.d.f42285a.d(map) && (tInterstitialAd = this.f42036i) != null) {
            tInterstitialAd.setContainVulgarContent(true);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            TInterstitialAd tInterstitialAd2 = this.f42036i;
            if (tInterstitialAd2 != null) {
                tInterstitialAd2.show(topActivity);
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
