package com.vungle.ads;

import android.content.Context;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.AdInternal;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.signals.SignalManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public abstract class BaseAd implements com.vungle.ads.a {
    private final b adConfig;
    private final Lazy adInternal$delegate;
    private h adListener;
    private final Context context;
    private String creativeId;
    private final x displayToClickMetric;
    private String eventId;
    private final w leaveApplicationMetric;
    private final com.vungle.ads.internal.util.n logEntry;
    private final String placementId;
    private final x presentToDisplayMetric;
    private final x requestToResponseMetric;
    private final x responseToShowMetric;
    private final w rewardedMetric;
    private final x showToCloseMetric;
    private final x showToFailMetric;
    private final Lazy signalManager$delegate;
    private com.vungle.ads.internal.signals.b signaledAd;

    /* loaded from: classes7.dex */
    public static final class a implements com.vungle.ads.internal.load.a {
        final /* synthetic */ String $adMarkup;

        a(String str) {
            this.$adMarkup = str;
        }

        @Override // com.vungle.ads.internal.load.a
        public void onFailure(VungleError error) {
            Intrinsics.h(error, "error");
            BaseAd baseAd = BaseAd.this;
            baseAd.onLoadFailure$vungle_ads_release(baseAd, error);
        }

        @Override // com.vungle.ads.internal.load.a
        public void onSuccess(AdPayload advertisement) {
            Intrinsics.h(advertisement, "advertisement");
            BaseAd.this.onAdLoaded$vungle_ads_release(advertisement);
            BaseAd baseAd = BaseAd.this;
            baseAd.onLoadSuccess$vungle_ads_release(baseAd, this.$adMarkup);
        }
    }

    public BaseAd(final Context context, String placementId, b adConfig) {
        Intrinsics.h(context, "context");
        Intrinsics.h(placementId, "placementId");
        Intrinsics.h(adConfig, "adConfig");
        this.context = context;
        this.placementId = placementId;
        this.adConfig = adConfig;
        this.adInternal$delegate = LazyKt.b(new Function0<AdInternal>() { // from class: com.vungle.ads.BaseAd$adInternal$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final AdInternal invoke() {
                BaseAd baseAd = BaseAd.this;
                AdInternal constructAdInternal$vungle_ads_release = baseAd.constructAdInternal$vungle_ads_release(baseAd.getContext());
                constructAdInternal$vungle_ads_release.setLogEntry$vungle_ads_release(BaseAd.this.getLogEntry$vungle_ads_release());
                return constructAdInternal$vungle_ads_release;
            }
        });
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        this.signalManager$delegate = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<SignalManager>() { // from class: com.vungle.ads.BaseAd$special$$inlined$inject$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.signals.SignalManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SignalManager invoke() {
                return ServiceLocator.Companion.getInstance(context).getService(SignalManager.class);
            }
        });
        com.vungle.ads.internal.util.n nVar = new com.vungle.ads.internal.util.n();
        nVar.setPlacementRefId$vungle_ads_release(placementId);
        this.logEntry = nVar;
        this.requestToResponseMetric = new x(Sdk$SDKMetric.SDKMetricType.AD_REQUEST_TO_RESPONSE_DURATION_MS);
        this.responseToShowMetric = new x(Sdk$SDKMetric.SDKMetricType.AD_RESPONSE_TO_SHOW_DURATION_MS);
        this.presentToDisplayMetric = new x(Sdk$SDKMetric.SDKMetricType.AD_PRESENT_TO_DISPLAY_DURATION_MS);
        this.showToFailMetric = new x(Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_FAIL_DURATION_MS);
        this.displayToClickMetric = new x(Sdk$SDKMetric.SDKMetricType.AD_DISPLAY_TO_CLICK_DURATION_MS);
        this.leaveApplicationMetric = new w(Sdk$SDKMetric.SDKMetricType.AD_LEAVE_APPLICATION);
        this.rewardedMetric = new w(Sdk$SDKMetric.SDKMetricType.AD_REWARD_USER);
        this.showToCloseMetric = new x(Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_CLOSE_DURATION_MS);
    }

    public static /* synthetic */ void getRequestToResponseMetric$vungle_ads_release$annotations() {
    }

    private final void onLoadEnd() {
        this.requestToResponseMetric.markEnd();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, this.requestToResponseMetric, this.logEntry, (String) null, 4, (Object) null);
        this.responseToShowMetric.markStart();
    }

    @Override // com.vungle.ads.a
    public Boolean canPlayAd() {
        return Boolean.valueOf(AdInternal.canPlayAd$default(getAdInternal$vungle_ads_release(), false, 1, null) == null);
    }

    public abstract AdInternal constructAdInternal$vungle_ads_release(Context context);

    public final b getAdConfig() {
        return this.adConfig;
    }

    public final AdInternal getAdInternal$vungle_ads_release() {
        return (AdInternal) this.adInternal$delegate.getValue();
    }

    public final h getAdListener() {
        return this.adListener;
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final x getDisplayToClickMetric$vungle_ads_release() {
        return this.displayToClickMetric;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final w getLeaveApplicationMetric$vungle_ads_release() {
        return this.leaveApplicationMetric;
    }

    public final com.vungle.ads.internal.util.n getLogEntry$vungle_ads_release() {
        return this.logEntry;
    }

    public final String getPlacementId() {
        return this.placementId;
    }

    public final x getPresentToDisplayMetric$vungle_ads_release() {
        return this.presentToDisplayMetric;
    }

    public final x getRequestToResponseMetric$vungle_ads_release() {
        return this.requestToResponseMetric;
    }

    public final x getResponseToShowMetric$vungle_ads_release() {
        return this.responseToShowMetric;
    }

    public final w getRewardedMetric$vungle_ads_release() {
        return this.rewardedMetric;
    }

    public final x getShowToCloseMetric$vungle_ads_release() {
        return this.showToCloseMetric;
    }

    public final x getShowToFailMetric$vungle_ads_release() {
        return this.showToFailMetric;
    }

    public final SignalManager getSignalManager$vungle_ads_release() {
        return (SignalManager) this.signalManager$delegate.getValue();
    }

    public final com.vungle.ads.internal.signals.b getSignaledAd$vungle_ads_release() {
        return this.signaledAd;
    }

    @Override // com.vungle.ads.a
    public void load(String str) {
        this.requestToResponseMetric.markStart();
        getAdInternal$vungle_ads_release().loadAd(this.placementId, str, new a(str));
    }

    public void onAdLoaded$vungle_ads_release(AdPayload advertisement) {
        Intrinsics.h(advertisement, "advertisement");
        advertisement.setAdConfig(this.adConfig);
        this.creativeId = advertisement.getCreativeId();
        String eventId = advertisement.eventId();
        this.eventId = eventId;
        com.vungle.ads.internal.signals.b bVar = this.signaledAd;
        if (bVar == null) {
            return;
        }
        bVar.setEventId(eventId);
    }

    public void onLoadFailure$vungle_ads_release(BaseAd baseAd, final VungleError vungleError) {
        Intrinsics.h(baseAd, "baseAd");
        Intrinsics.h(vungleError, "vungleError");
        com.vungle.ads.internal.util.u.INSTANCE.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.BaseAd$onLoadFailure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m983invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m983invoke() {
                h adListener = BaseAd.this.getAdListener();
                if (adListener != null) {
                    adListener.onAdFailedToLoad(BaseAd.this, vungleError);
                }
            }
        });
        onLoadEnd();
    }

    public void onLoadSuccess$vungle_ads_release(BaseAd baseAd, String str) {
        Intrinsics.h(baseAd, "baseAd");
        com.vungle.ads.internal.util.u.INSTANCE.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.BaseAd$onLoadSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m984invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m984invoke() {
                h adListener = BaseAd.this.getAdListener();
                if (adListener != null) {
                    adListener.onAdLoaded(BaseAd.this);
                }
            }
        });
        onLoadEnd();
    }

    public final void setAdListener(h hVar) {
        this.adListener = hVar;
    }

    public final void setSignaledAd$vungle_ads_release(com.vungle.ads.internal.signals.b bVar) {
        this.signaledAd = bVar;
    }
}
