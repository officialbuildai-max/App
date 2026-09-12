package com.vungle.ads.internal.presenter;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.vungle.ads.AdNotLoadedCantPlay;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.HeartbeatMissingError;
import com.vungle.ads.IndexHtmlError;
import com.vungle.ads.LinkError;
import com.vungle.ads.NetworkUnreachable;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.VungleError;
import com.vungle.ads.WebViewError;
import com.vungle.ads.WebViewRenderProcessUnresponsive;
import com.vungle.ads.WebViewRenderingProcessGone;
import com.vungle.ads.internal.ClickCoordinateTracker;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.BidPayload;
import com.vungle.ads.internal.model.c;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.network.f;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.signals.SignalManager;
import com.vungle.ads.internal.ui.view.MRAIDAdWidget;
import com.vungle.ads.internal.ui.view.b;
import com.vungle.ads.internal.util.SuspendableTimer;
import com.vungle.ads.internal.util.n;
import com.vungle.ads.internal.util.o;
import com.vungle.ads.internal.util.p;
import com.vungle.ads.internal.util.u;
import com.vungle.ads.w;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class MRAIDPresenter implements b.a, b.InterfaceC0742b {
    private static final String ACTION = "action";
    public static final String ACTION_WITH_VALUE = "actionWithValue";
    public static final String CLOSE = "close";
    public static final String CONSENT_ACTION = "consentAction";
    public static final String CREATIVE_HEARTBEAT = "creativeHeartbeat";
    public static final String ERROR = "error";
    public static final String GET_AVAILABLE_DISK_SPACE = "getAvailableDiskSpace";
    private static final double HEARTBEAT_INTERVAL = 6.0d;
    public static final String OPEN = "open";
    private static final String OPEN_NON_MRAID = "openNonMraid";
    public static final String OPEN_PRIVACY = "openPrivacy";
    public static final String PING_URL = "pingUrl";
    public static final String SET_ORIENTATION_PROPERTIES = "setOrientationProperties";
    public static final String SUCCESSFUL_VIEW = "successfulView";
    private static final String TAG = "MRAIDPresenter";
    public static final String TPAT = "tpat";
    public static final String UPDATE_SIGNALS = "updateSignals";
    private static final String USE_CUSTOM_CLOSE = "useCustomClose";
    private static final String USE_CUSTOM_PRIVACY = "useCustomPrivacy";
    public static final String VIDEO_LENGTH = "videoLength";
    public static final String VIDEO_VIEWED = "videoViewed";
    private Long adStartTime;
    private boolean adViewed;
    private final MRAIDAdWidget adWidget;
    private final AdPayload advertisement;
    private boolean backEnabled;
    private final BidPayload bidPayload;
    private com.vungle.ads.internal.presenter.a bus;
    private final Lazy clickCoordinateTracker$delegate;
    private boolean cp0Fired;
    private Executor executor;
    private boolean heartbeatEnabled;
    private final AtomicBoolean isDestroying;
    private long lastUserInteractionTimestamp;
    private final Lazy logEntry$delegate;
    private final com.vungle.ads.internal.omsdk.c omTracker;
    private final Lazy pathProvider$delegate;
    private final com.vungle.ads.internal.model.g placement;
    private final com.vungle.ads.internal.platform.d platform;
    private l presenterDelegate;
    private final Lazy scheduler$delegate;
    private final AtomicBoolean sendReportIncentivized;
    private final Lazy signalManager$delegate;
    private final Lazy suspendableTimer$delegate;
    private final Lazy tpatSender$delegate;
    private String userId;
    private long videoLength;
    private final Lazy vungleApiClient$delegate;
    private final com.vungle.ads.internal.ui.i vungleWebClient;
    public static final a Companion = new a(null);
    private static final Map<String, Sdk$SDKMetric.SDKMetricType> eventMap = MapsKt.l(TuplesKt.a(com.vungle.ads.internal.b.CHECKPOINT_0, Sdk$SDKMetric.SDKMetricType.AD_START_EVENT), TuplesKt.a(com.vungle.ads.internal.b.CLICK_URL, Sdk$SDKMetric.SDKMetricType.AD_CLICK_EVENT));

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getACTION_WITH_VALUE$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getCLOSE$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getCONSENT_ACTION$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getCREATIVE_HEARTBEAT$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getERROR$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getEventMap$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getGET_AVAILABLE_DISK_SPACE$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getOPEN$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getOPEN_PRIVACY$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getPING_URL$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getSET_ORIENTATION_PROPERTIES$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getSUCCESSFUL_VIEW$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getTPAT$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getUPDATE_SIGNALS$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getVIDEO_LENGTH$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getVIDEO_VIEWED$vungle_ads_release$annotations() {
        }

        public final Map<String, Sdk$SDKMetric.SDKMetricType> getEventMap$vungle_ads_release() {
            return MRAIDPresenter.eventMap;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements com.vungle.ads.internal.network.b {
        b() {
        }

        @Override // com.vungle.ads.internal.network.b
        public void onFailure(com.vungle.ads.internal.network.a aVar, Throwable th2) {
            o.Companion.d(MRAIDPresenter.TAG, "send RI Failure");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error RI API calls: ");
            sb2.append(th2 != null ? th2.getLocalizedMessage() : null);
            new NetworkUnreachable(sb2.toString()).setLogEntry$vungle_ads_release(MRAIDPresenter.this.getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
        }

        @Override // com.vungle.ads.internal.network.b
        public void onResponse(com.vungle.ads.internal.network.a aVar, com.vungle.ads.internal.network.e eVar) {
            o.Companion.d(MRAIDPresenter.TAG, "send RI success");
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements com.vungle.ads.internal.ui.b {
        final /* synthetic */ String $deeplinkUrl;
        final /* synthetic */ MRAIDPresenter this$0;

        c(String str, MRAIDPresenter mRAIDPresenter) {
            this.$deeplinkUrl = str;
            this.this$0 = mRAIDPresenter;
        }

        @Override // com.vungle.ads.internal.ui.b
        public void onDeeplinkClick(boolean z10) {
            if (!z10) {
                new LinkError(Sdk$SDKError.Reason.DEEPLINK_OPEN_FAILED, "Fail to open " + this.$deeplinkUrl).setLogEntry$vungle_ads_release(this.this$0.getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
            }
            List tpatUrls$default = AdPayload.getTpatUrls$default(this.this$0.advertisement, com.vungle.ads.internal.b.DEEPLINK_CLICK, String.valueOf(z10), null, 4, null);
            if (tpatUrls$default != null) {
                MRAIDPresenter mRAIDPresenter = this.this$0;
                Iterator it = tpatUrls$default.iterator();
                while (it.hasNext()) {
                    com.vungle.ads.internal.network.h.sendTpat$default(mRAIDPresenter.getTpatSender(), new f.a((String) it.next()).tpatKey(com.vungle.ads.internal.b.DEEPLINK_CLICK).withLogEntry(mRAIDPresenter.getLogEntry()).build(), false, 2, null);
                }
            }
        }
    }

    public MRAIDPresenter(MRAIDAdWidget adWidget, AdPayload advertisement, com.vungle.ads.internal.model.g placement, com.vungle.ads.internal.ui.i vungleWebClient, Executor executor, com.vungle.ads.internal.omsdk.c omTracker, BidPayload bidPayload, com.vungle.ads.internal.platform.d platform) {
        Intrinsics.h(adWidget, "adWidget");
        Intrinsics.h(advertisement, "advertisement");
        Intrinsics.h(placement, "placement");
        Intrinsics.h(vungleWebClient, "vungleWebClient");
        Intrinsics.h(executor, "executor");
        Intrinsics.h(omTracker, "omTracker");
        Intrinsics.h(platform, "platform");
        this.adWidget = adWidget;
        this.advertisement = advertisement;
        this.placement = placement;
        this.vungleWebClient = vungleWebClient;
        this.executor = executor;
        this.omTracker = omTracker;
        this.bidPayload = bidPayload;
        this.platform = platform;
        this.isDestroying = new AtomicBoolean(false);
        this.sendReportIncentivized = new AtomicBoolean(false);
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        final Context context = adWidget.getContext();
        Intrinsics.g(context, "adWidget.context");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        this.vungleApiClient$delegate = LazyKt.a(lazyThreadSafetyMode, new Function0<VungleApiClient>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$special$$inlined$inject$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.network.VungleApiClient, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final VungleApiClient invoke() {
                return ServiceLocator.Companion.getInstance(context).getService(VungleApiClient.class);
            }
        });
        final Context context2 = adWidget.getContext();
        Intrinsics.g(context2, "adWidget.context");
        this.pathProvider$delegate = LazyKt.a(lazyThreadSafetyMode, new Function0<p>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$special$$inlined$inject$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.util.p, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final p invoke() {
                return ServiceLocator.Companion.getInstance(context2).getService(p.class);
            }
        });
        final Context context3 = adWidget.getContext();
        Intrinsics.g(context3, "adWidget.context");
        this.signalManager$delegate = LazyKt.a(lazyThreadSafetyMode, new Function0<SignalManager>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$special$$inlined$inject$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.signals.SignalManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SignalManager invoke() {
                return ServiceLocator.Companion.getInstance(context3).getService(SignalManager.class);
            }
        });
        final Context context4 = adWidget.getContext();
        Intrinsics.g(context4, "adWidget.context");
        this.tpatSender$delegate = LazyKt.a(lazyThreadSafetyMode, new Function0<com.vungle.ads.internal.network.h>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$special$$inlined$inject$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.network.h, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final com.vungle.ads.internal.network.h invoke() {
                return ServiceLocator.Companion.getInstance(context4).getService(com.vungle.ads.internal.network.h.class);
            }
        });
        this.scheduler$delegate = LazyKt.b(new Function0<com.vungle.ads.internal.util.h>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$scheduler$2
            @Override // kotlin.jvm.functions.Function0
            public final com.vungle.ads.internal.util.h invoke() {
                return new com.vungle.ads.internal.util.h();
            }
        });
        this.logEntry$delegate = LazyKt.b(new Function0<n>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$logEntry$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final n invoke() {
                return MRAIDPresenter.this.advertisement.getLogEntry$vungle_ads_release();
            }
        });
        this.suspendableTimer$delegate = LazyKt.b(new Function0<SuspendableTimer>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$suspendableTimer$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final SuspendableTimer invoke() {
                final MRAIDPresenter mRAIDPresenter = MRAIDPresenter.this;
                return new SuspendableTimer(6.0d, true, null, new Function0<Unit>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$suspendableTimer$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m1076invoke();
                        return Unit.f67184a;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m1076invoke() {
                        MRAIDPresenter.this.reportErrorAndCloseAd(new HeartbeatMissingError());
                    }
                }, 4, null);
            }
        });
        this.clickCoordinateTracker$delegate = LazyKt.b(new Function0<ClickCoordinateTracker>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$clickCoordinateTracker$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ClickCoordinateTracker invoke() {
                MRAIDAdWidget mRAIDAdWidget;
                mRAIDAdWidget = MRAIDPresenter.this.adWidget;
                Context context5 = mRAIDAdWidget.getContext();
                Intrinsics.g(context5, "adWidget.context");
                return new ClickCoordinateTracker(context5, MRAIDPresenter.this.advertisement);
            }
        });
    }

    private final void closeView() {
        Long l11 = this.adStartTime;
        if (l11 != null) {
            List<String> tpatUrls = this.advertisement.getTpatUrls(com.vungle.ads.internal.b.AD_CLOSE, String.valueOf(System.currentTimeMillis() - l11.longValue()), String.valueOf(this.platform.getVolumeLevel()));
            if (tpatUrls != null) {
                Iterator<T> it = tpatUrls.iterator();
                while (it.hasNext()) {
                    com.vungle.ads.internal.network.h.sendTpat$default(getTpatSender(), new f.a((String) it.next()).tpatKey(com.vungle.ads.internal.b.AD_CLOSE).withLogEntry(getLogEntry()).build(), false, 2, null);
                }
            }
        }
        u.INSTANCE.runOnUiThread(new Function0<Unit>() { // from class: com.vungle.ads.internal.presenter.MRAIDPresenter$closeView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m1074invoke();
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1074invoke() {
                MRAIDAdWidget mRAIDAdWidget;
                mRAIDAdWidget = MRAIDPresenter.this.adWidget;
                mRAIDAdWidget.close();
            }
        });
    }

    public static /* synthetic */ void getAdStartTime$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getBackEnabled$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getBus$annotations() {
    }

    public static /* synthetic */ void getClickCoordinateTracker$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getHeartbeatEnabled$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getLastUserInteractionTimestamp$vungle_ads_release$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n getLogEntry() {
        return (n) this.logEntry$delegate.getValue();
    }

    private final p getPathProvider() {
        return (p) this.pathProvider$delegate.getValue();
    }

    private final com.vungle.ads.internal.util.h getScheduler() {
        return (com.vungle.ads.internal.util.h) this.scheduler$delegate.getValue();
    }

    private final SignalManager getSignalManager() {
        return (SignalManager) this.signalManager$delegate.getValue();
    }

    public static /* synthetic */ void getSuspendableTimer$vungle_ads_release$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.vungle.ads.internal.network.h getTpatSender() {
        return (com.vungle.ads.internal.network.h) this.tpatSender$delegate.getValue();
    }

    public static /* synthetic */ void getUserId$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getVideoLength$vungle_ads_release$annotations() {
    }

    private final VungleApiClient getVungleApiClient() {
        return (VungleApiClient) this.vungleApiClient$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleWebViewException(VungleError vungleError, boolean z10, String str) {
        o.Companion.e(TAG, "handleWebViewException: " + vungleError.getLocalizedMessage() + ", fatal: " + z10 + ", errorMsg: " + str);
        vungleError.setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
        if (z10) {
            makeBusError(vungleError);
            closeView();
        }
    }

    static /* synthetic */ void handleWebViewException$default(MRAIDPresenter mRAIDPresenter, VungleError vungleError, boolean z10, String str, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str = null;
        }
        mRAIDPresenter.handleWebViewException(vungleError, z10, str);
    }

    public static /* synthetic */ void isDestroying$vungle_ads_release$annotations() {
    }

    private final VungleError loadMraidAd(File file) {
        File file2 = new File(file.getPath(), com.vungle.ads.internal.b.AD_INDEX_FILE_NAME);
        if (!file2.exists()) {
            return new IndexHtmlError(Sdk$SDKError.Reason.AD_HTML_FAILED_TO_LOAD, "Fail to load html " + file2.getPath());
        }
        this.adWidget.showWebsite(AdPayload.FILE_SCHEME + file2.getPath());
        return null;
    }

    private final void makeBusError(VungleError vungleError) {
        com.vungle.ads.internal.presenter.a aVar = this.bus;
        if (aVar != null) {
            aVar.onError(vungleError, this.placement.getReferenceId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: prepare$lambda-14, reason: not valid java name */
    public static final void m1069prepare$lambda14(MRAIDPresenter this$0) {
        Intrinsics.h(this$0, "this$0");
        this$0.backEnabled = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processCommand$lambda-10, reason: not valid java name */
    public static final void m1070processCommand$lambda10(MRAIDPresenter this$0) {
        Intrinsics.h(this$0, "this$0");
        List list = null;
        c.b bVar = null;
        com.vungle.ads.internal.network.a ri2 = this$0.getVungleApiClient().ri(new c.i(list, bVar, this$0.adStartTime, this$0.advertisement.advAppId(), this$0.placement.getReferenceId(), this$0.userId, 3, (DefaultConstructorMarker) null));
        if (ri2 != null) {
            ri2.enqueue(new b());
            return;
        }
        o.Companion.e(TAG, "Invalid ri call.");
        new NetworkUnreachable("Error RI API for placement: " + this$0.placement.getReferenceId()).setLogEntry$vungle_ads_release(this$0.getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processCommand$lambda-11, reason: not valid java name */
    public static final void m1071processCommand$lambda11(MRAIDPresenter this$0) {
        Intrinsics.h(this$0, "this$0");
        this$0.getSuspendableTimer$vungle_ads_release().reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processCommand$lambda-12, reason: not valid java name */
    public static final void m1072processCommand$lambda12(MRAIDPresenter this$0, long j11) {
        Intrinsics.h(this$0, "this$0");
        this$0.vungleWebClient.notifyDiskAvailableSize(j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: processCommand$lambda-5, reason: not valid java name */
    public static final void m1073processCommand$lambda5(MRAIDPresenter this$0) {
        Intrinsics.h(this$0, "this$0");
        this$0.adWidget.setVisibility(0);
    }

    private final void recordPlayAssetMetric() {
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new w(this.advertisement.getAssetsFullyDownloaded() ? Sdk$SDKMetric.SDKMetricType.LOCAL_ASSETS_USED : Sdk$SDKMetric.SDKMetricType.REMOTE_ASSETS_USED), getLogEntry(), (String) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportErrorAndCloseAd(VungleError vungleError) {
        vungleError.setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
        makeBusError(vungleError);
        closeView();
    }

    private final void triggerEventMetricForTpat(String str) {
        Sdk$SDKMetric.SDKMetricType sDKMetricType = eventMap.get(str);
        if (sDKMetricType != null) {
            AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new w(sDKMetricType), getLogEntry(), (String) null, 4, (Object) null);
        }
    }

    public final void detach(int i11) {
        com.vungle.ads.internal.presenter.a aVar;
        o.Companion.d(TAG, "detach()");
        boolean z10 = (i11 & 1) != 0;
        boolean z11 = (i11 & 2) != 0;
        this.vungleWebClient.setWebViewObserver(null);
        this.vungleWebClient.setMraidDelegate(null);
        if (!z10 && z11 && !this.isDestroying.getAndSet(true) && (aVar = this.bus) != null) {
            aVar.onNext(TtmlNode.END, null, this.placement.getReferenceId());
        }
        this.adWidget.destroyWebView(this.omTracker.stop());
        if (this.heartbeatEnabled) {
            getSuspendableTimer$vungle_ads_release().cancel();
        }
    }

    public final Long getAdStartTime$vungle_ads_release() {
        return this.adStartTime;
    }

    public final boolean getBackEnabled$vungle_ads_release() {
        return this.backEnabled;
    }

    public final com.vungle.ads.internal.presenter.a getBus() {
        return this.bus;
    }

    public final ClickCoordinateTracker getClickCoordinateTracker$vungle_ads_release() {
        return (ClickCoordinateTracker) this.clickCoordinateTracker$delegate.getValue();
    }

    public final boolean getHeartbeatEnabled$vungle_ads_release() {
        return this.heartbeatEnabled;
    }

    public final long getLastUserInteractionTimestamp$vungle_ads_release() {
        return this.lastUserInteractionTimestamp;
    }

    public final SuspendableTimer getSuspendableTimer$vungle_ads_release() {
        return (SuspendableTimer) this.suspendableTimer$delegate.getValue();
    }

    public final String getUserId$vungle_ads_release() {
        return this.userId;
    }

    public final long getVideoLength$vungle_ads_release() {
        return this.videoLength;
    }

    public final Long getViewStatus() {
        boolean z10 = this.adViewed;
        if (!z10 && !this.cp0Fired) {
            return 3L;
        }
        if (this.cp0Fired) {
            return !z10 ? 2L : null;
        }
        return 1L;
    }

    public final void handleExit() {
        if (this.backEnabled) {
            this.adWidget.showWebsite("javascript:window.vungle.mraidBridgeExt.requestMRAIDClose()");
        }
    }

    public final AtomicBoolean isDestroying$vungle_ads_release() {
        return this.isDestroying;
    }

    @Override // com.vungle.ads.internal.ui.view.b.InterfaceC0742b
    public void onReceivedError(String errorDesc, boolean z10) {
        Intrinsics.h(errorDesc, "errorDesc");
        if (z10) {
            reportErrorAndCloseAd(new WebViewError(errorDesc));
        }
    }

    @Override // com.vungle.ads.internal.ui.view.b.InterfaceC0742b
    public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        handleWebViewException$default(this, new WebViewRenderProcessUnresponsive("fatal=true"), true, null, 4, null);
    }

    public final void onViewConfigurationChanged() {
        this.vungleWebClient.notifyPropertiesChange(true);
    }

    public final void onViewTouched(MotionEvent motionEvent) {
        if (motionEvent != null) {
            o.Companion.d(TAG, "user interaction");
            this.lastUserInteractionTimestamp = System.currentTimeMillis();
            getClickCoordinateTracker$vungle_ads_release().trackCoordinate(motionEvent);
        }
    }

    @Override // com.vungle.ads.internal.ui.view.b.InterfaceC0742b
    public boolean onWebRenderingProcessGone(WebView webView, Boolean bool) {
        boolean booleanValue = bool != null ? bool.booleanValue() : true;
        handleWebViewException$default(this, new WebViewRenderingProcessGone("didCrash=" + booleanValue), booleanValue, null, 4, null);
        return true;
    }

    public final void prepare() {
        String str;
        String str2;
        String str3;
        String str4;
        int settings;
        boolean z10 = false;
        this.isDestroying.set(false);
        this.adWidget.linkWebView(this.vungleWebClient, this.advertisement.getWebViewSettings());
        com.vungle.ads.b adConfig = this.advertisement.getAdConfig();
        if (adConfig != null && (settings = adConfig.getSettings()) > 0) {
            this.backEnabled = (settings & 2) == 2;
        }
        this.heartbeatEnabled = this.advertisement.heartbeatEnabled();
        com.vungle.ads.b adConfig2 = this.advertisement.getAdConfig();
        Integer valueOf = adConfig2 != null ? Integer.valueOf(adConfig2.getAdOrientation()) : null;
        this.adWidget.setOrientation((valueOf != null && valueOf.intValue() == 0) ? 7 : (valueOf != null && valueOf.intValue() == 1) ? 6 : 4);
        this.omTracker.start();
        this.vungleWebClient.setMraidDelegate(this);
        this.vungleWebClient.setErrorHandler(this);
        File assetDirectory = this.advertisement.getAssetDirectory();
        if (assetDirectory == null || !assetDirectory.exists()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("adv dir not exists: ");
            sb2.append(assetDirectory != null ? assetDirectory.getPath() : null);
            reportErrorAndCloseAd(new AdNotLoadedCantPlay(sb2.toString()));
            return;
        }
        VungleError loadMraidAd = loadMraidAd(assetDirectory);
        if (loadMraidAd != null) {
            reportErrorAndCloseAd(loadMraidAd);
            return;
        }
        this.adStartTime = Long.valueOf(System.currentTimeMillis());
        l lVar = this.presenterDelegate;
        this.userId = lVar != null ? lVar.getUserId() : null;
        l lVar2 = this.presenterDelegate;
        if (lVar2 == null || (str = lVar2.getAlertTitleText()) == null) {
            str = "";
        }
        l lVar3 = this.presenterDelegate;
        if (lVar3 == null || (str2 = lVar3.getAlertBodyText()) == null) {
            str2 = "";
        }
        l lVar4 = this.presenterDelegate;
        if (lVar4 == null || (str3 = lVar4.getAlertContinueButtonText()) == null) {
            str3 = "";
        }
        l lVar5 = this.presenterDelegate;
        if (lVar5 == null || (str4 = lVar5.getAlertCloseButtonText()) == null) {
            str4 = "";
        }
        this.advertisement.setIncentivizedText(str, str2, str3, str4);
        ConfigManager configManager = ConfigManager.INSTANCE;
        if (configManager.getGDPRIsCountryDataProtected() && Intrinsics.c(TmcConstants.ROUTE_UNKNOWN, PrivacyManager.INSTANCE.getConsentStatus())) {
            z10 = true;
        }
        this.vungleWebClient.setConsentStatus(z10, configManager.getGDPRConsentTitle(), configManager.getGDPRConsentMessage(), configManager.getGDPRButtonAccept(), configManager.getGDPRButtonDeny());
        if (z10) {
            PrivacyManager.INSTANCE.updateGdprConsent("opted_out_by_timeout", "vungle_modal", "");
        }
        int showCloseDelay = this.advertisement.getShowCloseDelay(Boolean.valueOf(this.placement.isRewardedVideo()));
        if (showCloseDelay > 0) {
            getScheduler().schedule(new Runnable() { // from class: com.vungle.ads.internal.presenter.h
                @Override // java.lang.Runnable
                public final void run() {
                    MRAIDPresenter.m1069prepare$lambda14(MRAIDPresenter.this);
                }
            }, showCloseDelay);
        } else {
            this.backEnabled = true;
        }
        com.vungle.ads.internal.presenter.a aVar = this.bus;
        if (aVar != null) {
            aVar.onNext("start", null, this.placement.getReferenceId());
        }
        if (this.heartbeatEnabled) {
            getSuspendableTimer$vungle_ads_release().start();
        }
        if (this.advertisement.adLoadOptimizationEnabled()) {
            recordPlayAssetMetric();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x021d, code lost:
    
        if (r24.equals(com.vungle.ads.internal.presenter.MRAIDPresenter.OPEN_NON_MRAID) == false) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0208, code lost:
    
        if (r24.equals(com.vungle.ads.internal.presenter.MRAIDPresenter.OPEN) == false) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0221, code lost:
    
        r0 = r23.advertisement.adUnit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0227, code lost:
    
        if (r0 == null) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0229, code lost:
    
        r8 = r0.getDeeplinkUrl();
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x022d, code lost:
    
        r0 = com.vungle.ads.internal.util.m.INSTANCE.getContentStringValue(r25, "url");
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0239, code lost:
    
        if (com.vungle.ads.internal.util.g.INSTANCE.isValidUrl(r0) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x023b, code lost:
    
        new com.vungle.ads.InvalidCTAUrl("Unable to open CTA Url (" + r0 + ')').setLogEntry$vungle_ads_release(getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0265, code lost:
    
        if (shouldBlockAutoRedirect$vungle_ads_release() == false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0267, code lost:
    
        r23.lastUserInteractionTimestamp = 0;
        com.vungle.ads.AnalyticsClient.logMetric$vungle_ads_release$default(com.vungle.ads.AnalyticsClient.INSTANCE, new com.vungle.ads.w(com.vungle.ads.internal.protos.Sdk$SDKMetric.SDKMetricType.BANNER_AUTO_REDIRECT), getLogEntry(), (java.lang.String) null, 4, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0283, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0284, code lost:
    
        r23.lastUserInteractionTimestamp = 0;
        r2 = r23.adWidget.getContext();
        kotlin.jvm.internal.Intrinsics.g(r2, "adWidget.context");
        r0 = com.vungle.ads.internal.util.d.launch(r8, r0, r2, getLogEntry(), new com.vungle.ads.internal.presenter.MRAIDPresenter.c(r8, r23));
        r2 = r23.bus;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02a0, code lost:
    
        if (r2 == null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02a2, code lost:
    
        r2.onNext(com.vungle.ads.internal.presenter.MRAIDPresenter.OPEN, "adClick", r23.placement.getReferenceId());
        r2 = kotlin.Unit.f67184a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02af, code lost:
    
        if (r0 == false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02b1, code lost:
    
        r0 = r23.bus;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02b3, code lost:
    
        if (r0 == null) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02b5, code lost:
    
        r0.onNext(com.vungle.ads.internal.presenter.MRAIDPresenter.OPEN, "adLeftApplication", r23.placement.getReferenceId());
        r0 = kotlin.Unit.f67184a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02c0, code lost:
    
        return true;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x002f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:178:0x051e  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0542 A[LOOP:1: B:184:0x053c->B:186:0x0542, LOOP_END] */
    @Override // com.vungle.ads.internal.ui.view.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean processCommand(java.lang.String r24, kotlinx.serialization.json.JsonObject r25) {
        /*
            Method dump skipped, instructions count: 1594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.presenter.MRAIDPresenter.processCommand(java.lang.String, kotlinx.serialization.json.JsonObject):boolean");
    }

    public final void setAdStartTime$vungle_ads_release(Long l11) {
        this.adStartTime = l11;
    }

    public final void setAdVisibility(boolean z10) {
        this.vungleWebClient.setAdVisibility(z10);
    }

    public final void setBackEnabled$vungle_ads_release(boolean z10) {
        this.backEnabled = z10;
    }

    public final void setBus(com.vungle.ads.internal.presenter.a aVar) {
        this.bus = aVar;
    }

    public final void setEventListener(com.vungle.ads.internal.presenter.a aVar) {
        this.bus = aVar;
    }

    public final void setHeartbeatEnabled$vungle_ads_release(boolean z10) {
        this.heartbeatEnabled = z10;
    }

    public final void setLastUserInteractionTimestamp$vungle_ads_release(long j11) {
        this.lastUserInteractionTimestamp = j11;
    }

    public final void setPresenterDelegate$vungle_ads_release(l lVar) {
        this.presenterDelegate = lVar;
    }

    public final void setUserId$vungle_ads_release(String str) {
        this.userId = str;
    }

    public final void setVideoLength$vungle_ads_release(long j11) {
        this.videoLength = j11;
    }

    public final boolean shouldBlockAutoRedirect$vungle_ads_release() {
        ConfigManager configManager = ConfigManager.INSTANCE;
        if (configManager.allowAutoRedirects()) {
            return false;
        }
        return this.lastUserInteractionTimestamp == 0 || System.currentTimeMillis() - this.lastUserInteractionTimestamp > configManager.afterClickDuration();
    }

    public final void start() {
        o.Companion.d(TAG, "start()");
        this.adWidget.resumeWeb();
        setAdVisibility(true);
    }

    public final void stop() {
        o.Companion.d(TAG, "stop()");
        this.adWidget.pauseWeb();
        setAdVisibility(false);
    }
}
