package com.cloud.tmc.integration.utils;

import android.os.Bundle;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.utils.ext.StringExtKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007J\u001e\u0010\f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J$\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u0004H\u0007J4\u0010\u000f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/cloud/tmc/integration/utils/TrackPointUtils;", "", "()V", "TAG", "", "openPageActionTrack", "", "page", "Lcom/cloud/tmc/integration/structure/Page;", "navigationType", FrameworkConstants.GLOBAL_DATA_KEY_PAGE_PATH, "pageRandomIdByGAId", "pageRouteTrackEnd", "appId", "chainId", "pageRouteTrackStart", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class TrackPointUtils {
    public static final TrackPointUtils INSTANCE = new TrackPointUtils();
    private static final String TAG = "TrackPointUtils";

    private TrackPointUtils() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void openPageActionTrack(Page page, String navigationType) {
        Intrinsics.h(navigationType, "navigationType");
        openPageActionTrack$default(page, navigationType, null, null, 12, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void openPageActionTrack(Page page, String navigationType, String str) {
        Intrinsics.h(navigationType, "navigationType");
        openPageActionTrack$default(page, navigationType, str, null, 8, null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void openPageActionTrack(Page page, String navigationType, String pagePath, String pageRandomIdByGAId) {
        App app;
        Intrinsics.h(navigationType, "navigationType");
        try {
            boolean contains = CollectionsKt.o(TmcConstants.NAVIGATION_ON_START, TmcConstants.NAVIGATION_HOT_RE_LAUNCH, TmcConstants.NAVIGATION_HOT_NAVIGATE_TO, TmcConstants.NAVIGATION_HOT_SHELL_START).contains(navigationType);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            String appId = (page == null || (app = page.getApp()) == null) ? null : app.getAppId();
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_OPEN_PAGE_ACTION;
            Bundle bundle = new Bundle();
            String str = ChainPoint.PAGE_PATH;
            String pagePath2 = page != null ? page.getPagePath() : null;
            if (pagePath2 == null) {
                pagePath2 = "";
            }
            bundle.putString(str, StringExtKt.orDefault(pagePath, pagePath2));
            bundle.putString("navigationType", navigationType);
            bundle.putBoolean(ChainPoint.NAVIGATION_IS_FIRST_PAGE, contains);
            if (pageRandomIdByGAId == null) {
                pageRandomIdByGAId = "null";
            }
            bundle.putString(TmcConstants.KEY_PAGE_RANDOM_ID, pageRandomIdByGAId);
            Unit unit = Unit.f67184a;
            performanceAnalyseProxy.record(appId, pointAnalyseType, "", bundle);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2.getMessage(), th2);
        }
    }

    public static /* synthetic */ void openPageActionTrack$default(Page page, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        if ((i11 & 8) != 0) {
            str3 = null;
        }
        openPageActionTrack(page, str, str2, str3);
    }

    @JvmStatic
    @JvmOverloads
    public static final void pageRouteTrackEnd(Page page) {
        pageRouteTrackEnd$default(page, null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:23:0x0005, B:25:0x000b, B:27:0x0011, B:4:0x001b, B:6:0x0021, B:8:0x0027, B:10:0x002f, B:13:0x0037), top: B:22:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    @kotlin.jvm.JvmStatic
    @kotlin.jvm.JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void pageRouteTrackEnd(com.cloud.tmc.integration.structure.Page r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "-1"
            r1 = 0
            if (r4 == 0) goto L1a
            com.cloud.tmc.integration.structure.App r2 = r4.getApp()     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L1a
            android.os.Bundle r2 = r2.getStartParams()     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L1a
            java.lang.String r3 = "uniqueChainID"
            java.lang.String r2 = r2.getString(r3, r0)     // Catch: java.lang.Throwable -> L18
            goto L1b
        L18:
            r4 = move-exception
            goto L3f
        L1a:
            r2 = r1
        L1b:
            java.lang.String r0 = com.cloud.tmc.integration.utils.ext.StringExtKt.orDefault(r2, r0)     // Catch: java.lang.Throwable -> L18
            if (r4 == 0) goto L2c
            com.cloud.tmc.integration.structure.App r2 = r4.getApp()     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L2c
            java.lang.String r2 = r2.getAppId()     // Catch: java.lang.Throwable -> L18
            goto L2d
        L2c:
            r2 = r1
        L2d:
            if (r4 == 0) goto L33
            java.lang.String r1 = r4.getPagePath()     // Catch: java.lang.Throwable -> L18
        L33:
            if (r1 != 0) goto L37
            java.lang.String r1 = ""
        L37:
            java.lang.String r4 = com.cloud.tmc.integration.utils.ext.StringExtKt.orDefault(r5, r1)     // Catch: java.lang.Throwable -> L18
            pageRouteTrackEnd(r2, r0, r4)     // Catch: java.lang.Throwable -> L18
            goto L48
        L3f:
            java.lang.String r5 = "TrackPointUtils"
            java.lang.String r0 = r4.getMessage()
            com.cloud.tmc.kernel.log.TmcLogger.e(r5, r0, r4)
        L48:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.utils.TrackPointUtils.pageRouteTrackEnd(com.cloud.tmc.integration.structure.Page, java.lang.String):void");
    }

    @JvmStatic
    @JvmOverloads
    public static final void pageRouteTrackEnd(String appId, String chainId, String pagePath) {
        Intrinsics.h(chainId, "chainId");
        try {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_CHAIN_END;
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "page");
            bundle.putString(ChainPoint.CHAIN_ID, chainId);
            bundle.putString(ChainPoint.PAGE_PATH, String.valueOf(pagePath));
            Unit unit = Unit.f67184a;
            performanceAnalyseProxy.record(appId, pointAnalyseType, ChainPoint.ROUTE_PAGE, bundle);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2.getMessage(), th2);
        }
    }

    public static /* synthetic */ void pageRouteTrackEnd$default(Page page, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        pageRouteTrackEnd(page, str);
    }

    @JvmStatic
    public static final void pageRouteTrackStart(Page page, String navigationType) {
        String pageRandomIdByGAId;
        App app;
        App app2;
        Bundle startParams;
        Intrinsics.h(navigationType, "navigationType");
        if (page != null) {
            try {
                pageRandomIdByGAId = page.getPageRandomIdByGAId();
            } catch (Throwable th2) {
                TmcLogger.e(TAG, th2.getMessage(), th2);
                return;
            }
        } else {
            pageRandomIdByGAId = null;
        }
        openPageActionTrack(page, navigationType, null, pageRandomIdByGAId);
        pageRouteTrackStart((page == null || (app = page.getApp()) == null) ? null : app.getAppId(), StringExtKt.orDefault((page == null || (app2 = page.getApp()) == null || (startParams = app2.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE), TmcConstants.COLD_OPEN_TYPE), String.valueOf(page != null ? page.getPagePath() : null), navigationType, page != null ? page.getPageRandomIdByGAId() : null);
    }

    @JvmStatic
    public static final void pageRouteTrackStart(String appId, String chainId, String pagePath, String navigationType, String pageRandomIdByGAId) {
        Intrinsics.h(chainId, "chainId");
        Intrinsics.h(pagePath, "pagePath");
        Intrinsics.h(navigationType, "navigationType");
        try {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_CHAIN_START;
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "page");
            bundle.putString(ChainPoint.CHAIN_ID, chainId);
            bundle.putString(ChainPoint.PAGE_PATH, pagePath);
            bundle.putString("navigationType", navigationType);
            bundle.putString(TmcConstants.KEY_PAGE_RANDOM_ID, String.valueOf(pageRandomIdByGAId));
            Unit unit = Unit.f67184a;
            performanceAnalyseProxy.record(appId, pointAnalyseType, ChainPoint.ROUTE_PAGE, bundle);
        } catch (Throwable th2) {
            TmcLogger.e(TAG, th2.getMessage(), th2);
        }
    }
}
