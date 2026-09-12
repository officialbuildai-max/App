package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.BaseAd;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.util.u;
import com.vungle.ads.y;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class BannerAdImpl extends BaseAd {
    private final com.vungle.ads.internal.presenter.c adPlayCallback;
    private final y adSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerAdImpl(Context context, String placementId, y adSize, com.vungle.ads.b adConfig) {
        super(context, placementId, adConfig);
        Intrinsics.h(context, "context");
        Intrinsics.h(placementId, "placementId");
        Intrinsics.h(adSize, "adSize");
        Intrinsics.h(adConfig, "adConfig");
        this.adSize = adSize;
        AdInternal adInternal$vungle_ads_release = getAdInternal$vungle_ads_release();
        Intrinsics.f(adInternal$vungle_ads_release, "null cannot be cast to non-null type com.vungle.ads.internal.BannerAdInternal");
        this.adPlayCallback = ((a) adInternal$vungle_ads_release).wrapCallback$vungle_ads_release(new com.vungle.ads.internal.presenter.b() { // from class: com.vungle.ads.internal.BannerAdImpl$adPlayCallback$1
            @Override // com.vungle.ads.internal.presenter.b
            public void onAdClick(String str) {
                u uVar = u.INSTANCE;
                final BannerAdImpl bannerAdImpl = BannerAdImpl.this;
                uVar.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.internal.BannerAdImpl$adPlayCallback$1$onAdClick$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1012invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1012invoke() {
                        com.vungle.ads.h adListener = BannerAdImpl.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdClicked(BannerAdImpl.this);
                        }
                    }
                });
                BannerAdImpl.this.getDisplayToClickMetric$vungle_ads_release().markEnd();
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, BannerAdImpl.this.getDisplayToClickMetric$vungle_ads_release(), BannerAdImpl.this.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
            }

            @Override // com.vungle.ads.internal.presenter.b
            public void onAdEnd(String str) {
                u uVar = u.INSTANCE;
                final BannerAdImpl bannerAdImpl = BannerAdImpl.this;
                uVar.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.internal.BannerAdImpl$adPlayCallback$1$onAdEnd$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1013invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1013invoke() {
                        com.vungle.ads.h adListener = BannerAdImpl.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdEnd(BannerAdImpl.this);
                        }
                    }
                });
                BannerAdImpl.this.getShowToCloseMetric$vungle_ads_release().markEnd();
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, BannerAdImpl.this.getShowToCloseMetric$vungle_ads_release(), BannerAdImpl.this.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
            }

            @Override // com.vungle.ads.internal.presenter.b
            public void onAdImpression(String str) {
                u uVar = u.INSTANCE;
                final BannerAdImpl bannerAdImpl = BannerAdImpl.this;
                uVar.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.internal.BannerAdImpl$adPlayCallback$1$onAdImpression$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1014invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1014invoke() {
                        com.vungle.ads.h adListener = BannerAdImpl.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdImpression(BannerAdImpl.this);
                        }
                    }
                });
                BannerAdImpl.this.getPresentToDisplayMetric$vungle_ads_release().markEnd();
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, BannerAdImpl.this.getPresentToDisplayMetric$vungle_ads_release(), BannerAdImpl.this.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
                BannerAdImpl.this.getDisplayToClickMetric$vungle_ads_release().markStart();
            }

            @Override // com.vungle.ads.internal.presenter.b
            public void onAdLeftApplication(String str) {
                u uVar = u.INSTANCE;
                final BannerAdImpl bannerAdImpl = BannerAdImpl.this;
                uVar.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.internal.BannerAdImpl$adPlayCallback$1$onAdLeftApplication$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1015invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1015invoke() {
                        com.vungle.ads.h adListener = BannerAdImpl.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdLeftApplication(BannerAdImpl.this);
                        }
                    }
                });
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, BannerAdImpl.this.getLeaveApplicationMetric$vungle_ads_release(), BannerAdImpl.this.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
            }

            @Override // com.vungle.ads.internal.presenter.b
            public void onAdRewarded(String str) {
            }

            @Override // com.vungle.ads.internal.presenter.b
            public void onAdStart(String str) {
                BannerAdImpl.this.getSignalManager$vungle_ads_release().increaseSessionDepthCounter();
                BannerAdImpl.this.getAdInternal$vungle_ads_release().getValidationToPresentMetric$vungle_ads_release().markEnd();
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, BannerAdImpl.this.getAdInternal$vungle_ads_release().getValidationToPresentMetric$vungle_ads_release(), BannerAdImpl.this.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
                BannerAdImpl.this.getPresentToDisplayMetric$vungle_ads_release().markStart();
                u uVar = u.INSTANCE;
                final BannerAdImpl bannerAdImpl = BannerAdImpl.this;
                uVar.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.internal.BannerAdImpl$adPlayCallback$1$onAdStart$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1016invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1016invoke() {
                        com.vungle.ads.h adListener = BannerAdImpl.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdStart(BannerAdImpl.this);
                        }
                    }
                });
            }

            @Override // com.vungle.ads.internal.presenter.b
            public void onFailure(final VungleError error) {
                Intrinsics.h(error, "error");
                u uVar = u.INSTANCE;
                final BannerAdImpl bannerAdImpl = BannerAdImpl.this;
                uVar.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.internal.BannerAdImpl$adPlayCallback$1$onFailure$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1017invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1017invoke() {
                        com.vungle.ads.h adListener = BannerAdImpl.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdFailedToPlay(BannerAdImpl.this, error);
                        }
                    }
                });
                BannerAdImpl.this.getShowToFailMetric$vungle_ads_release().markEnd();
                AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(BannerAdImpl.this.getShowToFailMetric$vungle_ads_release(), BannerAdImpl.this.getLogEntry$vungle_ads_release(), String.valueOf(error.getCode()));
            }
        });
    }

    @Override // com.vungle.ads.BaseAd
    public a constructAdInternal$vungle_ads_release(Context context) {
        Intrinsics.h(context, "context");
        return new a(context, this.adSize);
    }

    public final com.vungle.ads.internal.presenter.c getAdPlayCallback$vungle_ads_release() {
        return this.adPlayCallback;
    }

    public final y getAdViewSize() {
        AdInternal adInternal$vungle_ads_release = getAdInternal$vungle_ads_release();
        Intrinsics.f(adInternal$vungle_ads_release, "null cannot be cast to non-null type com.vungle.ads.internal.BannerAdInternal");
        y updatedAdSize$vungle_ads_release = ((a) adInternal$vungle_ads_release).getUpdatedAdSize$vungle_ads_release();
        return updatedAdSize$vungle_ads_release == null ? this.adSize : updatedAdSize$vungle_ads_release;
    }
}
