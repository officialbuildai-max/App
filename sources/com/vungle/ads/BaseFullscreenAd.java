package com.vungle.ads;

import android.content.Context;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public abstract class BaseFullscreenAd extends BaseAd implements k {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFullscreenAd(Context context, String placementId, b adConfig) {
        super(context, placementId, adConfig);
        Intrinsics.h(context, "context");
        Intrinsics.h(placementId, "placementId");
        Intrinsics.h(adConfig, "adConfig");
    }

    @Override // com.vungle.ads.BaseAd, com.vungle.ads.a
    public void load(String str) {
        setSignaledAd$vungle_ads_release(getSignalManager$vungle_ads_release().getSignaledAd(getPlacementId()));
        super.load(str);
    }

    @Override // com.vungle.ads.BaseAd
    public void onAdLoaded$vungle_ads_release(AdPayload advertisement) {
        Intrinsics.h(advertisement, "advertisement");
        super.onAdLoaded$vungle_ads_release(advertisement);
        com.vungle.ads.internal.signals.b signaledAd$vungle_ads_release = getSignaledAd$vungle_ads_release();
        if (signaledAd$vungle_ads_release == null) {
            return;
        }
        signaledAd$vungle_ads_release.setAdAvailabilityCallbackTime(System.currentTimeMillis());
    }

    @Override // com.vungle.ads.k
    public void play(Context context) {
        AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
        AnalyticsClient.logMetric$vungle_ads_release$default(analyticsClient, new w(Sdk$SDKMetric.SDKMetricType.PLAY_AD_API), getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
        getResponseToShowMetric$vungle_ads_release().markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(analyticsClient, getResponseToShowMetric$vungle_ads_release(), getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
        getShowToFailMetric$vungle_ads_release().markStart();
        getShowToCloseMetric$vungle_ads_release().markStart();
        com.vungle.ads.internal.signals.b signaledAd$vungle_ads_release = getSignaledAd$vungle_ads_release();
        if (signaledAd$vungle_ads_release != null) {
            signaledAd$vungle_ads_release.setPlayAdTime(System.currentTimeMillis());
            signaledAd$vungle_ads_release.calculateTimeBetweenAdAvailabilityAndPlayAd();
            getSignalManager$vungle_ads_release().registerSignaledAd(context, signaledAd$vungle_ads_release);
        }
        getAdInternal$vungle_ads_release().play(context, new com.vungle.ads.internal.presenter.b() { // from class: com.vungle.ads.BaseFullscreenAd$play$2
            @Override // com.vungle.ads.internal.presenter.b
            public void onAdClick(String str) {
                com.vungle.ads.internal.util.u uVar = com.vungle.ads.internal.util.u.INSTANCE;
                final BaseFullscreenAd baseFullscreenAd = BaseFullscreenAd.this;
                uVar.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.BaseFullscreenAd$play$2$onAdClick$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m985invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m985invoke() {
                        h adListener = BaseFullscreenAd.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdClicked(BaseFullscreenAd.this);
                        }
                    }
                });
                BaseFullscreenAd.this.getDisplayToClickMetric$vungle_ads_release().markEnd();
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, BaseFullscreenAd.this.getDisplayToClickMetric$vungle_ads_release(), BaseFullscreenAd.this.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
            }

            @Override // com.vungle.ads.internal.presenter.b
            public void onAdEnd(String str) {
                com.vungle.ads.internal.util.u uVar = com.vungle.ads.internal.util.u.INSTANCE;
                final BaseFullscreenAd baseFullscreenAd = BaseFullscreenAd.this;
                uVar.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.BaseFullscreenAd$play$2$onAdEnd$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m986invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m986invoke() {
                        h adListener = BaseFullscreenAd.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdEnd(BaseFullscreenAd.this);
                        }
                    }
                });
                BaseFullscreenAd.this.getShowToCloseMetric$vungle_ads_release().markEnd();
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, BaseFullscreenAd.this.getShowToCloseMetric$vungle_ads_release(), BaseFullscreenAd.this.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
            }

            @Override // com.vungle.ads.internal.presenter.b
            public void onAdImpression(String str) {
                com.vungle.ads.internal.util.u uVar = com.vungle.ads.internal.util.u.INSTANCE;
                final BaseFullscreenAd baseFullscreenAd = BaseFullscreenAd.this;
                uVar.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.BaseFullscreenAd$play$2$onAdImpression$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m987invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m987invoke() {
                        h adListener = BaseFullscreenAd.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdImpression(BaseFullscreenAd.this);
                        }
                    }
                });
                BaseFullscreenAd.this.getPresentToDisplayMetric$vungle_ads_release().markEnd();
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, BaseFullscreenAd.this.getPresentToDisplayMetric$vungle_ads_release(), BaseFullscreenAd.this.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
                BaseFullscreenAd.this.getDisplayToClickMetric$vungle_ads_release().markStart();
            }

            @Override // com.vungle.ads.internal.presenter.b
            public void onAdLeftApplication(String str) {
                com.vungle.ads.internal.util.u uVar = com.vungle.ads.internal.util.u.INSTANCE;
                final BaseFullscreenAd baseFullscreenAd = BaseFullscreenAd.this;
                uVar.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.BaseFullscreenAd$play$2$onAdLeftApplication$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m988invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m988invoke() {
                        h adListener = BaseFullscreenAd.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdLeftApplication(BaseFullscreenAd.this);
                        }
                    }
                });
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, BaseFullscreenAd.this.getLeaveApplicationMetric$vungle_ads_release(), BaseFullscreenAd.this.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
            }

            @Override // com.vungle.ads.internal.presenter.b
            public void onAdRewarded(String str) {
                com.vungle.ads.internal.util.u uVar = com.vungle.ads.internal.util.u.INSTANCE;
                final BaseFullscreenAd baseFullscreenAd = BaseFullscreenAd.this;
                uVar.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.BaseFullscreenAd$play$2$onAdRewarded$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m989invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m989invoke() {
                        h adListener = BaseFullscreenAd.this.getAdListener();
                        v vVar = adListener instanceof v ? (v) adListener : null;
                        if (vVar != null) {
                            vVar.onAdRewarded(BaseFullscreenAd.this);
                        }
                    }
                });
                AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, BaseFullscreenAd.this.getRewardedMetric$vungle_ads_release(), BaseFullscreenAd.this.getLogEntry$vungle_ads_release(), (String) null, 4, (Object) null);
            }

            @Override // com.vungle.ads.internal.presenter.b
            public void onAdStart(String str) {
                BaseFullscreenAd.this.getSignalManager$vungle_ads_release().increaseSessionDepthCounter();
                BaseFullscreenAd.this.getPresentToDisplayMetric$vungle_ads_release().markStart();
                com.vungle.ads.internal.util.u uVar = com.vungle.ads.internal.util.u.INSTANCE;
                final BaseFullscreenAd baseFullscreenAd = BaseFullscreenAd.this;
                uVar.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.BaseFullscreenAd$play$2$onAdStart$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m990invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m990invoke() {
                        h adListener = BaseFullscreenAd.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdStart(BaseFullscreenAd.this);
                        }
                    }
                });
            }

            @Override // com.vungle.ads.internal.presenter.b
            public void onFailure(final VungleError error) {
                Intrinsics.h(error, "error");
                com.vungle.ads.internal.util.u uVar = com.vungle.ads.internal.util.u.INSTANCE;
                final BaseFullscreenAd baseFullscreenAd = BaseFullscreenAd.this;
                uVar.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.BaseFullscreenAd$play$2$onFailure$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m991invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m991invoke() {
                        h adListener = BaseFullscreenAd.this.getAdListener();
                        if (adListener != null) {
                            adListener.onAdFailedToPlay(BaseFullscreenAd.this, error);
                        }
                    }
                });
                BaseFullscreenAd.this.getShowToFailMetric$vungle_ads_release().markEnd();
                AnalyticsClient.INSTANCE.logMetric$vungle_ads_release(BaseFullscreenAd.this.getShowToFailMetric$vungle_ads_release(), BaseFullscreenAd.this.getLogEntry$vungle_ads_release(), String.valueOf(error.getCode()));
            }
        });
    }
}
