package com.cloud.tmc.integration.chain.hotopen.channel.activatePage;

import android.os.Bundle;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.chain.app.AppChainContext;
import com.cloud.tmc.integration.chain.hotopen.channel.IHotOpenState;
import com.cloud.tmc.integration.chain.page.PageChainContext;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.utils.DeviceUtil;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointConstants;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0013H\u0016¨\u0006\u001b"}, d2 = {"Lcom/cloud/tmc/integration/chain/hotopen/channel/activatePage/PageStageOpenEndSuccessState;", "Lcom/cloud/tmc/integration/chain/hotopen/channel/IHotOpenState;", "()V", "appendStages", "", "pageChainContext", "Lcom/cloud/tmc/integration/chain/page/PageChainContext;", "tmpStateRangeTime", "", "", "", "", "tmpStateCostTime", "steps", "", "reportAppOpenEndSuccess", "appChainContext", "Lcom/cloud/tmc/integration/chain/app/AppChainContext;", "data", "Landroid/os/Bundle;", "reportAppOpenMidSuccess", "reportNew", "dataBundle", "reportOld", "reportPageOpenEndSuccess", "reportPageOpenMidSuccess", "reset", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class PageStageOpenEndSuccessState implements IHotOpenState {
    private final void appendStages(PageChainContext pageChainContext, Map<String, List<Long>> tmpStateRangeTime, Map<String, Long> tmpStateCostTime, int[] steps) {
        TmcLogger.d("chainPoint", PageStageOpenEndSuccessState.class.getName() + "_appendStages");
        long currentTimeMillis = System.currentTimeMillis();
        for (int i11 = 1; i11 < 12; i11++) {
            tmpStateRangeTime.put(String.valueOf(i11), CollectionsKt.h(Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis)));
            tmpStateCostTime.put(String.valueOf(i11), 0L);
        }
        for (int i12 : steps) {
            tmpStateRangeTime.put(String.valueOf(i12), CollectionsKt.h(Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis)));
            tmpStateCostTime.put(String.valueOf(i12), 0L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void appendStages$default(PageStageOpenEndSuccessState pageStageOpenEndSuccessState, PageChainContext pageChainContext, Map map, Map map2, int[] iArr, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            map = new LinkedHashMap();
        }
        if ((i11 & 4) != 0) {
            map2 = new LinkedHashMap();
        }
        pageStageOpenEndSuccessState.appendStages(pageChainContext, map, map2, iArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x01d2 A[Catch: all -> 0x023e, TRY_ENTER, TryCatch #3 {all -> 0x023e, blocks: (B:7:0x0138, B:9:0x0142, B:12:0x014c, B:13:0x0160, B:15:0x016a, B:18:0x0174, B:31:0x01d2, B:34:0x01db, B:36:0x01e2, B:38:0x01e8, B:41:0x01f1, B:42:0x0233, B:47:0x0209, B:48:0x021f, B:64:0x017f, B:65:0x0184, B:67:0x0157, B:68:0x015c), top: B:6:0x0138 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01db A[Catch: all -> 0x023e, TryCatch #3 {all -> 0x023e, blocks: (B:7:0x0138, B:9:0x0142, B:12:0x014c, B:13:0x0160, B:15:0x016a, B:18:0x0174, B:31:0x01d2, B:34:0x01db, B:36:0x01e2, B:38:0x01e8, B:41:0x01f1, B:42:0x0233, B:47:0x0209, B:48:0x021f, B:64:0x017f, B:65:0x0184, B:67:0x0157, B:68:0x015c), top: B:6:0x0138 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01f1 A[Catch: all -> 0x023e, TRY_ENTER, TryCatch #3 {all -> 0x023e, blocks: (B:7:0x0138, B:9:0x0142, B:12:0x014c, B:13:0x0160, B:15:0x016a, B:18:0x0174, B:31:0x01d2, B:34:0x01db, B:36:0x01e2, B:38:0x01e8, B:41:0x01f1, B:42:0x0233, B:47:0x0209, B:48:0x021f, B:64:0x017f, B:65:0x0184, B:67:0x0157, B:68:0x015c), top: B:6:0x0138 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void reportAppOpenEndSuccess(com.cloud.tmc.integration.chain.app.AppChainContext r17, android.os.Bundle r18) {
        /*
            Method dump skipped, instructions count: 610
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.chain.hotopen.channel.activatePage.PageStageOpenEndSuccessState.reportAppOpenEndSuccess(com.cloud.tmc.integration.chain.app.AppChainContext, android.os.Bundle):void");
    }

    private final void reportAppOpenMidSuccess(AppChainContext appChainContext, Bundle data) {
        TmcLogger.d("chainPoint", PageStageOpenEndSuccessState.class.getName() + "_reportAppOpenMidSuccess");
        if (appChainContext.getPageContexts().isEmpty()) {
            return;
        }
        PageChainContext page = appChainContext.getPageContexts().peek();
        Bundle bundle = new Bundle();
        bundle.putAll(data);
        bundle.putString("pageIndex", String.valueOf(page.getPageIndexOfApp()));
        bundle.putInt("maxStage", 17);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Intrinsics.g(page, "page");
        appendStages(page, linkedHashMap, linkedHashMap2, new int[]{12, 13, 14, 15, 16, 17});
        bundle.putString("stageCostTime", GsonUtils.toJson(linkedHashMap2));
        bundle.putString("stageRangeTime", GsonUtils.toJson(linkedHashMap));
        bundle.putString("openMiniAppResult", "true");
        bundle.putString("openMiniAppFailedReason", "");
        bundle.putInt("syncType", appChainContext.getSyncType());
        bundle.putString("isExitInStage", "false");
        bundle.putString("open_channel", appChainContext.getOpenChannel());
        bundle.putString(FrameworkConstants.GLOBAL_DATA_KEY_SCENE, appChainContext.getScene());
        bundle.putString("openByLaunch", "true");
        bundle.putString(PointConstants.POINT_PAGE_PATH, String.valueOf(page.getPageUrl()));
        bundle.putString(TmcConstants.KEY_PAGE_UNIQUE_ID, DeviceUtil.getGAId() + "_" + page.getRenderId());
        bundle.remove(ChainPoint.PAGE_PATH);
        bundle.remove(ChainPoint.PAGE_ID);
        ((ReportProxy) TmcProxy.get(ReportProxy.class)).report(appChainContext.getAppId(), "mini_app_open_mid", bundle);
    }

    private final void reportPageOpenEndSuccess(AppChainContext appChainContext, Bundle data) {
        PageChainContext peek;
        TmcLogger.d("chainPoint", PageStageOpenEndSuccessState.class.getName() + "_reportPageOpenEndSuccess->pageContexts.size:" + appChainContext.getPageContexts().size());
        if (appChainContext.getPageContexts().isEmpty() || (peek = appChainContext.getPageContexts().peek()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putAll(data);
        bundle.putString("openPageResult", "true");
        bundle.putString("openPageFailedReason", "");
        bundle.putInt("maxStage", 18);
        bundle.putString("isExitInStage", "false");
        bundle.putString("open_channel", peek.getOpenChannel());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        appendStages(peek, linkedHashMap, linkedHashMap2, new int[]{12, 13, 14, 15, 16, 17, 18});
        bundle.putString("stageCostTime", GsonUtils.toJson(linkedHashMap2));
        bundle.putString("stageRangeTime", GsonUtils.toJson(linkedHashMap));
        bundle.putString(FrameworkConstants.GLOBAL_DATA_KEY_SCENE, peek.getScene());
        bundle.putString("pageIndex", String.valueOf(peek.getPageIndexOfApp()));
        bundle.putString("isAdd", "true");
        bundle.putString(PointConstants.POINT_PAGE_PATH, peek.getPageUrl());
        bundle.putString(ChainPoint.CHAIN_DRAW_END_TYPE, peek.getDrawEndType());
        bundle.putString(TmcConstants.KEY_PAGE_UNIQUE_ID, DeviceUtil.getGAId() + "_" + peek.getRenderId());
        bundle.putString("appH5ProgressStatus", String.valueOf(GsonUtils.toJson(MapsKt.l(TuplesKt.a(30, 0), TuplesKt.a(50, 0), TuplesKt.a(70, 0)))));
        bundle.remove(ChainPoint.PAGE_PATH);
        bundle.remove(ChainPoint.PAGE_ID);
        ((ReportProxy) TmcProxy.get(ReportProxy.class)).report(appChainContext.getAppId(), "mini_page_open_end", bundle);
    }

    private final void reportPageOpenMidSuccess(AppChainContext appChainContext, Bundle data) {
        PageChainContext peek;
        TmcLogger.d("chainPoint", PageStageOpenEndSuccessState.class.getName() + "_reportPageOpenMidSuccess->pageContexts.size:" + appChainContext.getPageContexts().size());
        if (appChainContext.getPageContexts().isEmpty() || (peek = appChainContext.getPageContexts().peek()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putAll(data);
        bundle.putString("openPageResult", "true");
        bundle.putString("openPageFailedReason", "");
        bundle.putInt("maxStage", 17);
        bundle.putString("isExitInStage", "false");
        bundle.putString("open_channel", peek.getOpenChannel());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        appendStages(peek, linkedHashMap, linkedHashMap2, new int[]{12, 13, 14, 15, 16, 17});
        bundle.putString("stageCostTime", GsonUtils.toJson(linkedHashMap2));
        bundle.putString("stageRangeTime", GsonUtils.toJson(linkedHashMap));
        bundle.putString(FrameworkConstants.GLOBAL_DATA_KEY_SCENE, peek.getScene());
        bundle.putString("pageIndex", String.valueOf(peek.getPageIndexOfApp()));
        bundle.putString("isAdd", "true");
        bundle.putString(PointConstants.POINT_PAGE_PATH, peek.getPageUrl());
        bundle.putString(TmcConstants.KEY_PAGE_UNIQUE_ID, DeviceUtil.getGAId() + "_" + peek.getRenderId());
        bundle.remove(ChainPoint.PAGE_PATH);
        bundle.remove(ChainPoint.PAGE_ID);
        ((ReportProxy) TmcProxy.get(ReportProxy.class)).report(appChainContext.getAppId(), "mini_page_open_mid", bundle);
    }

    @Override // com.cloud.tmc.integration.chain.hotopen.channel.IHotOpenState
    public void keepSituation(AppChainContext appChainContext, Bundle bundle) {
        IHotOpenState.DefaultImpls.keepSituation(this, appChainContext, bundle);
    }

    @Override // com.cloud.tmc.integration.chain.hotopen.channel.IHotOpenState
    public void log(String str) {
        IHotOpenState.DefaultImpls.log(this, str);
    }

    @Override // com.cloud.tmc.integration.chain.hotopen.channel.IHotOpenState
    public void reportNew(AppChainContext appChainContext, Bundle dataBundle) {
        Intrinsics.h(appChainContext, "appChainContext");
        Intrinsics.h(dataBundle, "dataBundle");
        log("reportNew");
        reportPageOpenMidSuccess(appChainContext, dataBundle);
        reportAppOpenMidSuccess(appChainContext, dataBundle);
        reportPageOpenEndSuccess(appChainContext, dataBundle);
        reportAppOpenEndSuccess(appChainContext, dataBundle);
    }

    @Override // com.cloud.tmc.integration.chain.hotopen.channel.IHotOpenState
    public void reportOld(AppChainContext appChainContext, Bundle dataBundle) {
        Intrinsics.h(appChainContext, "appChainContext");
        Intrinsics.h(dataBundle, "dataBundle");
    }

    @Override // com.cloud.tmc.integration.chain.hotopen.channel.IHotOpenState
    public void reset(AppChainContext appChainContext, Bundle dataBundle) {
        Intrinsics.h(appChainContext, "appChainContext");
        Intrinsics.h(dataBundle, "dataBundle");
        log("reset");
        if (dataBundle.containsKey(ChainPoint.CHAIN_SCENE)) {
            String string = dataBundle.getString(ChainPoint.CHAIN_SCENE, "0");
            Intrinsics.g(string, "dataBundle.getString(ChainPoint.CHAIN_SCENE, \"0\")");
            appChainContext.setScene(string);
            String string2 = dataBundle.getString(TmcConstants.HOT_OPEN_TYPE, "-2");
            Intrinsics.g(string2, "dataBundle.getString(Tmc…ants.HOT_OPEN_TYPE, \"-2\")");
            appChainContext.setHotOpenType(string2);
            for (PageChainContext pageChainContext : appChainContext.getPageContexts()) {
                String string3 = dataBundle.getString(ChainPoint.CHAIN_SCENE, "0");
                Intrinsics.g(string3, "dataBundle.getString(ChainPoint.CHAIN_SCENE, \"0\")");
                pageChainContext.setScene(string3);
            }
        }
        if (dataBundle.containsKey(ChainPoint.CHAIN_OPEN_CHANNEL)) {
            String string4 = dataBundle.getString(ChainPoint.CHAIN_OPEN_CHANNEL, TmcConstants.COLD_OPEN_TYPE);
            Intrinsics.g(string4, "dataBundle.getString(Cha…CHAIN_OPEN_CHANNEL, \"-1\")");
            appChainContext.setOpenChannel(string4);
            for (PageChainContext pageChainContext2 : appChainContext.getPageContexts()) {
                String string5 = dataBundle.getString(ChainPoint.CHAIN_OPEN_CHANNEL, TmcConstants.COLD_OPEN_TYPE);
                Intrinsics.g(string5, "dataBundle.getString(Cha…CHAIN_OPEN_CHANNEL, \"-1\")");
                pageChainContext2.setOpenChannel(string5);
            }
        }
        appChainContext.getPageIndexOfApp().set(1);
        appChainContext.getOpenedPageCount().set(1);
    }
}
