package com.cloud.tmc.integration.chain.page;

import android.os.Bundle;
import android.text.TextUtils;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.chain.ChainContext;
import com.cloud.tmc.integration.chain.ChainState;
import com.cloud.tmc.integration.chain.ChainType;
import com.cloud.tmc.integration.chain.ContextType;
import com.cloud.tmc.integration.chain.app.AppChainContext;
import com.cloud.tmc.integration.chain.endState.ChainMidEndState;
import com.cloud.tmc.integration.chain.endState.DrawViewEndState;
import com.cloud.tmc.integration.chain.startState.CreateContainerStartState;
import com.cloud.tmc.integration.proxy.ReportProxy;
import com.cloud.tmc.integration.utils.DeviceUtil;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointConstants;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.transsion.push.PushConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J:\u0010Q\u001a\u00020R2\u001a\b\u0002\u0010S\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e0\u00062\u0014\b\u0002\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002J\u0010\u0010U\u001a\u00020R2\u0006\u0010V\u001a\u00020WH\u0016J\u0012\u0010X\u001a\u0004\u0018\u00010\u00002\u0006\u0010E\u001a\u00020\u0007H\u0002J\u0010\u0010Y\u001a\u00020W2\u0006\u0010Z\u001a\u00020WH\u0002J\u0010\u0010[\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\u0016H\u0002J\u0010\u0010]\u001a\u00020R2\u0006\u0010\\\u001a\u00020\u0016H\u0002J\u0010\u0010^\u001a\u00020R2\u0006\u0010_\u001a\u00020\u0016H\u0002J\u0010\u0010`\u001a\u00020R2\u0006\u0010a\u001a\u00020\u0016H\u0002J\u0010\u0010b\u001a\u00020R2\u0006\u0010c\u001a\u00020\u0016H\u0002J\u0010\u0010d\u001a\u00020R2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010e\u001a\u00020R2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010f\u001a\u00020R2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010g\u001a\u00020R2\u0006\u0010V\u001a\u00020WH\u0002J\u0010\u0010h\u001a\u00020W2\u0006\u0010i\u001a\u00020\u0007H\u0002J\u0010\u0010j\u001a\u00020R2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0010\u0010k\u001a\u00020R2\u0006\u0010\\\u001a\u00020\u0016H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR,\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e0\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*R\u001a\u0010-\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010 \"\u0004\b5\u0010\"R\u001a\u00106\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010(\"\u0004\b8\u0010*R\u001a\u00109\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010 \"\u0004\b;\u0010\"R\u001a\u0010<\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010(\"\u0004\b>\u0010*R\u001a\u0010?\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00100\"\u0004\bA\u00102R\u001a\u0010B\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010 \"\u0004\bD\u0010\"R\u001a\u0010E\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010 \"\u0004\bG\u0010\"R\u001a\u0010H\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010 \"\u0004\bJ\u0010\"R&\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\n\"\u0004\bM\u0010\fR,\u0010N\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000e0\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\n\"\u0004\bP\u0010\f¨\u0006l"}, d2 = {"Lcom/cloud/tmc/integration/chain/page/PageChainContext;", "Lcom/cloud/tmc/integration/chain/ChainContext;", "()V", "appChainContext", "Lcom/cloud/tmc/integration/chain/app/AppChainContext;", "appStateCostTime", "", "", "", "getAppStateCostTime", "()Ljava/util/Map;", "setAppStateCostTime", "(Ljava/util/Map;)V", "appStateRangeTime", "", "getAppStateRangeTime", "setAppStateRangeTime", "contextType", "Lcom/cloud/tmc/integration/chain/ContextType;", "getContextType", "()Lcom/cloud/tmc/integration/chain/ContextType;", "currentChainEndState", "Lcom/cloud/tmc/integration/chain/ChainState;", "getCurrentChainEndState", "()Lcom/cloud/tmc/integration/chain/ChainState;", "setCurrentChainEndState", "(Lcom/cloud/tmc/integration/chain/ChainState;)V", "currentChainStartState", "getCurrentChainStartState", "setCurrentChainStartState", "drawEndType", "getDrawEndType", "()Ljava/lang/String;", "setDrawEndType", "(Ljava/lang/String;)V", "h5ProgressCollectList", "getH5ProgressCollectList", "setH5ProgressCollectList", "isReportEnd", "", "()Z", "setReportEnd", "(Z)V", "isReportMid", "setReportMid", "maxStage", "", "getMaxStage", "()I", "setMaxStage", "(I)V", "openChannel", "getOpenChannel", "setOpenChannel", "openMiniPageEndResult", "getOpenMiniPageEndResult", "setOpenMiniPageEndResult", "openMiniPageFailedReason", "getOpenMiniPageFailedReason", "setOpenMiniPageFailedReason", "openMiniPageMidResult", "getOpenMiniPageMidResult", "setOpenMiniPageMidResult", "pageIndexOfApp", "getPageIndexOfApp", "setPageIndexOfApp", "pageUrl", "getPageUrl", "setPageUrl", "renderId", "getRenderId", "setRenderId", FrameworkConstants.GLOBAL_DATA_KEY_SCENE, "getScene", "setScene", "stateCostTime", "getStateCostTime", "setStateCostTime", "stateRangeTime", "getStateRangeTime", "setStateRangeTime", "appendStages", "", "tmpStateRangeTime", "tmpStateCostTime", PushConstants.PROVIDER_FIELD_DESTROY, "data", "Landroid/os/Bundle;", "findPageContext", "generateAppReportData", "dataBundle", "getTime", "chainState", "insertData", "parseChainEnd", "chainEndState", "parseChainStart", "chainStartState", "parseChianError", "pageErrorState", "reportPageOpenEndFail", "reportPageOpenEndSuccess", "reportPageOpenMidFail", "reportPageOpenMidSuccess", "reportPsData", "appId", "setAppChainContext", "setChainState", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class PageChainContext implements ChainContext {
    private AppChainContext appChainContext;
    private ChainState currentChainEndState;
    private ChainState currentChainStartState;
    private boolean isReportEnd;
    private boolean isReportMid;
    private int maxStage;
    private boolean openMiniPageEndResult;
    private boolean openMiniPageMidResult;
    private int pageIndexOfApp;
    private String renderId = "";
    private String openMiniPageFailedReason = "";
    private Map<String, Long> appStateCostTime = new LinkedHashMap();
    private Map<String, List<Long>> appStateRangeTime = new LinkedHashMap();
    private Map<String, Long> stateCostTime = new LinkedHashMap();
    private Map<String, List<Long>> stateRangeTime = new LinkedHashMap();
    private String scene = "0";
    private String openChannel = "0";
    private String h5ProgressCollectList = "";
    private String pageUrl = "";
    private String drawEndType = "0";

    @Metadata(k = 3, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ChainType.values().length];
            try {
                iArr[ChainType.TYPE_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ChainType.TYPE_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ChainType.TYPE_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ChainType.TYPE_INSERT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void appendStages(Map<String, List<Long>> tmpStateRangeTime, Map<String, Long> tmpStateCostTime) {
        TmcLogger.d("chainPoint", PageChainContext.class.getName() + "_appendStages");
        if (this.appChainContext != null) {
            if (this.pageIndexOfApp == 1) {
                tmpStateRangeTime.putAll(this.appStateRangeTime);
                tmpStateCostTime.putAll(this.appStateCostTime);
            } else {
                for (int i11 = 1; i11 < 12; i11++) {
                    String valueOf = String.valueOf(i11);
                    List<Long> list = this.stateRangeTime.get("12");
                    Long valueOf2 = Long.valueOf(list != null ? list.get(0).longValue() : 0L);
                    List<Long> list2 = this.stateRangeTime.get("12");
                    tmpStateRangeTime.put(valueOf, CollectionsKt.h(valueOf2, Long.valueOf(list2 != null ? list2.get(0).longValue() : 0L)));
                    tmpStateCostTime.put(String.valueOf(i11), 0L);
                }
            }
            tmpStateRangeTime.putAll(this.stateRangeTime);
            tmpStateCostTime.putAll(this.stateCostTime);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void appendStages$default(PageChainContext pageChainContext, Map map, Map map2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            map = new LinkedHashMap();
        }
        if ((i11 & 2) != 0) {
            map2 = new LinkedHashMap();
        }
        pageChainContext.appendStages(map, map2);
    }

    private final PageChainContext findPageContext(String renderId) {
        Stack<PageChainContext> pageContexts;
        AppChainContext appChainContext = this.appChainContext;
        PageChainContext pageChainContext = null;
        if (appChainContext != null && (pageContexts = appChainContext.getPageContexts()) != null) {
            for (PageChainContext pageChainContext2 : pageContexts) {
                if (Intrinsics.c(pageChainContext2.renderId, renderId)) {
                    pageChainContext = pageChainContext2;
                }
            }
        }
        return pageChainContext;
    }

    private final Bundle generateAppReportData(Bundle dataBundle) {
        Bundle bundle = new Bundle();
        bundle.putAll(dataBundle);
        bundle.putString("pageIndex", String.valueOf(this.pageIndexOfApp));
        bundle.putInt("maxStage", this.maxStage);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        AppChainContext appChainContext = this.appChainContext;
        if (appChainContext != null) {
            appChainContext.appendStagesSuccess(this, linkedHashMap, linkedHashMap2, this.maxStage);
        }
        bundle.putString("stageCostTime", GsonUtils.toJson(linkedHashMap2));
        bundle.putString("stageRangeTime", GsonUtils.toJson(linkedHashMap));
        return bundle;
    }

    private final long getTime(ChainState chainState) {
        return chainState.getDataBundle().containsKey(ChainPoint.TIME) ? chainState.getDataBundle().getLong(ChainPoint.TIME) : chainState.getTime();
    }

    private final void insertData(ChainState chainState) {
        try {
            Bundle dataBundle = chainState.getDataBundle();
            if (dataBundle.containsKey(ChainPoint.OPEN_PAGE_FAILED_REASON)) {
                String string = dataBundle.getString(ChainPoint.OPEN_PAGE_FAILED_REASON);
                if (string == null) {
                    string = "解析失败原因错误";
                }
                this.openMiniPageFailedReason = string;
            }
            if (dataBundle.containsKey(ChainPoint.PAGE_H5_PROGRESS_STATUS)) {
                String string2 = dataBundle.getString(ChainPoint.PAGE_H5_PROGRESS_STATUS, "");
                Intrinsics.g(string2, "data.getString(ChainPoin…E_H5_PROGRESS_STATUS, \"\")");
                this.h5ProgressCollectList = string2;
            }
        } catch (Throwable unused) {
        }
    }

    private final void parseChainEnd(ChainState chainEndState) {
        AppChainContext appChainContext;
        long time;
        AppChainContext appChainContext2;
        AppChainContext appChainContext3;
        log("parseChainEnd_" + chainEndState);
        if (this.isReportEnd || (appChainContext = this.appChainContext) == null || TextUtils.isEmpty(appChainContext.getAppId())) {
            return;
        }
        String string = chainEndState.getDataBundle().getString(ChainPoint.CHAIN_RENDER_ID);
        if (string == null) {
            string = "";
        }
        Intrinsics.g(string, "chainEndState.dataBundle…ng(CHAIN_RENDER_ID) ?: \"\"");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.currentChainEndState = chainEndState;
        boolean z10 = chainEndState instanceof DrawViewEndState;
        if (z10 && Intrinsics.c(chainEndState.getDataBundle().getString(ChainPoint.CHAIN_DRAW_END_TYPE), "2")) {
            time = chainEndState.getDataBundle().getLong(ChainPoint.FCP_CURRENT_TIMEMILLIS, System.currentTimeMillis());
            TmcLogger.d("chainState", "fcpTime:" + time);
        } else {
            time = getTime(chainEndState);
        }
        List<Long> list = this.stateRangeTime.get(String.valueOf(chainEndState.getStep()));
        if (list != null) {
            list.add(Long.valueOf(time));
        }
        List<Long> list2 = this.stateRangeTime.get(String.valueOf(chainEndState.getStep()));
        long j11 = 0;
        if (list2 != null && list2.size() == 2) {
            j11 = list2.get(1).longValue() - list2.get(0).longValue();
        }
        this.stateCostTime.put(String.valueOf(chainEndState.getStep()), Long.valueOf(j11));
        if (this.pageIndexOfApp == 1) {
            appChainContext.setFirstPageStateRangeTime(this.stateRangeTime);
            appChainContext.setFirstPageStateCostTime(this.stateCostTime);
        }
        if (chainEndState instanceof ChainMidEndState) {
            reportPageOpenMidSuccess(chainEndState.getDataBundle());
            int i11 = this.pageIndexOfApp;
            if (i11 == 1) {
                appChainContext.reportAppOpenMidSuccess(generateAppReportData(chainEndState.getDataBundle()), true);
            } else if (i11 != 1 && (appChainContext3 = this.appChainContext) != null && !appChainContext3.getIsReportMid()) {
                appChainContext.reportAppOpenMidSuccess(generateAppReportData(chainEndState.getDataBundle()), false);
            }
        }
        if (z10) {
            String string2 = chainEndState.getDataBundle().getString(ChainPoint.CHAIN_DRAW_END_TYPE, "0");
            Intrinsics.g(string2, "chainEndState.dataBundle…CHAIN_DRAW_END_TYPE, \"0\")");
            this.drawEndType = string2;
            reportPageOpenEndSuccess(chainEndState.getDataBundle());
            int i12 = this.pageIndexOfApp;
            if (i12 == 1) {
                String appId = appChainContext.getAppId();
                Bundle reportPsData = reportPsData(appId != null ? appId : "");
                Bundle generateAppReportData = generateAppReportData(chainEndState.getDataBundle());
                generateAppReportData.putAll(reportPsData);
                appChainContext.reportAppOpenEndSuccess(generateAppReportData, true);
                return;
            }
            if (i12 == 1 || (appChainContext2 = this.appChainContext) == null || appChainContext2.getIsReportEnd()) {
                return;
            }
            appChainContext.reportAppOpenEndSuccess(generateAppReportData(chainEndState.getDataBundle()), false);
        }
    }

    private final void parseChainStart(ChainState chainStartState) {
        log("parseChainStart_" + chainStartState);
        AppChainContext appChainContext = this.appChainContext;
        if (appChainContext == null || TextUtils.isEmpty(appChainContext.getAppId())) {
            return;
        }
        String string = chainStartState.getDataBundle().getString(ChainPoint.CHAIN_RENDER_ID);
        if (string == null) {
            string = "";
        }
        Intrinsics.g(string, "chainStartState.dataBund…ng(CHAIN_RENDER_ID) ?: \"\"");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        if (findPageContext(string) == null) {
            this.renderId = string;
            appChainContext.getPageContexts().push(this);
        }
        if (chainStartState instanceof CreateContainerStartState) {
            this.pageIndexOfApp = appChainContext.getPageIndexOfApp().addAndGet(1);
            this.scene = appChainContext.getScene();
            this.openChannel = appChainContext.getOpenChannel();
            String string2 = chainStartState.getDataBundle().getString(ChainPoint.PAGE_PATH, "");
            Intrinsics.g(string2, "chainStartState.dataBund…ChainPoint.PAGE_PATH, \"\")");
            this.pageUrl = string2;
            this.appStateCostTime = appChainContext.getStateCostTime();
            this.appStateRangeTime = appChainContext.getStateRangeTime();
        }
        this.maxStage = chainStartState.getStep();
        this.currentChainEndState = null;
        this.currentChainStartState = chainStartState;
        this.stateRangeTime.put(String.valueOf(chainStartState.getStep()), CollectionsKt.h(Long.valueOf(getTime(chainStartState))));
        if (this.pageIndexOfApp == 1) {
            appChainContext.setFirstPageStateRangeTime(this.stateRangeTime);
            appChainContext.setFirstPageMaxStage(this.maxStage);
        }
    }

    private final void parseChianError(ChainState pageErrorState) {
        AppChainContext appChainContext;
        List<Long> list;
        log("parseChianError_" + pageErrorState);
        if (this.isReportEnd || (appChainContext = this.appChainContext) == null || TextUtils.isEmpty(appChainContext.getAppId())) {
            return;
        }
        String string = pageErrorState.getDataBundle().getString(ChainPoint.CHAIN_RENDER_ID);
        if (string == null) {
            string = "";
        }
        Intrinsics.g(string, "pageErrorState.dataBundl…ng(CHAIN_RENDER_ID) ?: \"\"");
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.currentChainEndState = pageErrorState;
        ChainState chainState = this.currentChainStartState;
        if (chainState != null && (list = this.stateRangeTime.get(String.valueOf(chainState.getStep()))) != null && list.size() == 1) {
            list.add(Long.valueOf(System.currentTimeMillis()));
            this.stateCostTime.put(String.valueOf(chainState.getStep()), Long.valueOf(list.get(1).longValue() - list.get(0).longValue()));
        }
        if (this.pageIndexOfApp == 1) {
            appChainContext.setFirstPageStateRangeTime(this.stateRangeTime);
            appChainContext.setFirstPageStateCostTime(this.stateCostTime);
        }
    }

    private final void reportPageOpenEndFail(Bundle data) {
        ChainState chainState;
        TmcLogger.d("chainPoint", PageChainContext.class.getName() + "_reportPageOpenEndFail->isReportEnd:" + this.isReportEnd);
        if (this.isReportEnd) {
            return;
        }
        this.isReportEnd = true;
        Bundle bundle = new Bundle();
        bundle.putAll(data);
        bundle.putString("openPageResult", "false");
        bundle.putString("openPageFailedReason", this.openMiniPageFailedReason);
        bundle.putInt("maxStage", this.maxStage);
        bundle.putString("open_channel", String.valueOf(this.openChannel));
        AppChainContext appChainContext = this.appChainContext;
        bundle.putString(TmcConstants.HOT_OPEN_TYPE, String.valueOf(appChainContext != null ? appChainContext.getHotOpenType() : null));
        long j11 = bundle.containsKey(ChainPoint.TIME) ? bundle.getLong(ChainPoint.TIME) : System.currentTimeMillis();
        boolean z10 = this.currentChainStartState != null && this.currentChainEndState == null;
        bundle.putString("isExitInStage", String.valueOf(z10));
        if (z10 && (chainState = this.currentChainStartState) != null) {
            Map<String, List<Long>> map = this.stateRangeTime;
            Intrinsics.e(chainState);
            if (map.get(String.valueOf(chainState.getStep())) != null) {
                Map<String, List<Long>> map2 = this.stateRangeTime;
                ChainState chainState2 = this.currentChainStartState;
                Intrinsics.e(chainState2);
                List<Long> list = map2.get(String.valueOf(chainState2.getStep()));
                if (list != null && list.size() == 1) {
                    Map<String, List<Long>> map3 = this.stateRangeTime;
                    ChainState chainState3 = this.currentChainStartState;
                    Intrinsics.e(chainState3);
                    List<Long> list2 = map3.get(String.valueOf(chainState3.getStep()));
                    if (list2 != null) {
                        list2.add(Long.valueOf(j11));
                    }
                    Map<String, Long> map4 = this.stateCostTime;
                    ChainState chainState4 = this.currentChainStartState;
                    Intrinsics.e(chainState4);
                    String valueOf = String.valueOf(chainState4.getStep());
                    Map<String, List<Long>> map5 = this.stateRangeTime;
                    ChainState chainState5 = this.currentChainStartState;
                    Intrinsics.e(chainState5);
                    List<Long> list3 = map5.get(String.valueOf(chainState5.getStep()));
                    long longValue = list3 != null ? list3.get(1).longValue() : 0L;
                    Map<String, List<Long>> map6 = this.stateRangeTime;
                    ChainState chainState6 = this.currentChainStartState;
                    Intrinsics.e(chainState6);
                    List<Long> list4 = map6.get(String.valueOf(chainState6.getStep()));
                    map4.put(valueOf, Long.valueOf(longValue - (list4 != null ? list4.get(0).longValue() : 0L)));
                }
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        appendStages(linkedHashMap, linkedHashMap2);
        bundle.putString("stageCostTime", GsonUtils.toJson(linkedHashMap2));
        bundle.putString("stageRangeTime", GsonUtils.toJson(linkedHashMap));
        bundle.putString(FrameworkConstants.GLOBAL_DATA_KEY_SCENE, String.valueOf(this.scene));
        bundle.putString("pageIndex", String.valueOf(this.pageIndexOfApp));
        bundle.putString("isAdd", "true");
        bundle.putString(TmcConstants.KEY_PAGE_UNIQUE_ID, DeviceUtil.getGAId() + "_" + this.renderId);
        String string = bundle.getString(ChainPoint.PAGE_PATH);
        if (string != null) {
            bundle.putString(PointConstants.POINT_PAGE_PATH, string);
        }
        bundle.putString("appH5ProgressStatus", this.h5ProgressCollectList);
        bundle.remove(ChainPoint.PAGE_PATH);
        bundle.remove(ChainPoint.PAGE_ID);
        ReportProxy reportProxy = (ReportProxy) TmcProxy.get(ReportProxy.class);
        AppChainContext appChainContext2 = this.appChainContext;
        reportProxy.report(appChainContext2 != null ? appChainContext2.getAppId() : null, "mini_page_open_end", bundle);
    }

    private final void reportPageOpenEndSuccess(Bundle data) {
        TmcLogger.d("chainPoint", PageChainContext.class.getName() + "_reportPageOpenEndSuccess->isReportEnd:" + this.isReportEnd);
        if (this.isReportEnd) {
            return;
        }
        this.isReportEnd = true;
        this.openMiniPageEndResult = true;
        Bundle bundle = new Bundle();
        bundle.putAll(data);
        bundle.putString("openPageResult", "true");
        bundle.putString("openPageFailedReason", "");
        bundle.putInt("maxStage", this.maxStage);
        bundle.putString("isExitInStage", "false");
        bundle.putString("open_channel", String.valueOf(this.openChannel));
        AppChainContext appChainContext = this.appChainContext;
        bundle.putString(TmcConstants.HOT_OPEN_TYPE, String.valueOf(appChainContext != null ? appChainContext.getHotOpenType() : null));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        appendStages(linkedHashMap, linkedHashMap2);
        bundle.putString("stageCostTime", GsonUtils.toJson(linkedHashMap2));
        bundle.putString("stageRangeTime", GsonUtils.toJson(linkedHashMap));
        bundle.putString(FrameworkConstants.GLOBAL_DATA_KEY_SCENE, String.valueOf(this.scene));
        bundle.putString("pageIndex", String.valueOf(this.pageIndexOfApp));
        bundle.putString("isAdd", "true");
        String string = bundle.getString(ChainPoint.PAGE_PATH);
        if (string != null) {
            bundle.putString(PointConstants.POINT_PAGE_PATH, string);
        }
        bundle.putString("appH5ProgressStatus", this.h5ProgressCollectList);
        bundle.remove(ChainPoint.PAGE_PATH);
        bundle.remove(ChainPoint.PAGE_ID);
        ReportProxy reportProxy = (ReportProxy) TmcProxy.get(ReportProxy.class);
        AppChainContext appChainContext2 = this.appChainContext;
        reportProxy.report(appChainContext2 != null ? appChainContext2.getAppId() : null, "mini_page_open_end", bundle);
    }

    private final void reportPageOpenMidFail(Bundle data) {
        ChainState chainState;
        TmcLogger.d("chainPoint", PageChainContext.class.getName() + "_reportPageOpenMidFail->isReportMid:" + this.isReportMid);
        if (this.isReportMid) {
            return;
        }
        this.isReportMid = true;
        Bundle bundle = new Bundle();
        bundle.putAll(data);
        bundle.putString("openPageResult", "false");
        bundle.putString("openPageFailedReason", this.openMiniPageFailedReason);
        bundle.putInt("maxStage", this.maxStage);
        bundle.putString("open_channel", String.valueOf(this.openChannel));
        AppChainContext appChainContext = this.appChainContext;
        bundle.putString(TmcConstants.HOT_OPEN_TYPE, String.valueOf(appChainContext != null ? appChainContext.getHotOpenType() : null));
        long j11 = bundle.containsKey(ChainPoint.TIME) ? bundle.getLong(ChainPoint.TIME) : System.currentTimeMillis();
        boolean z10 = this.currentChainStartState != null && this.currentChainEndState == null;
        bundle.putString("isExitInStage", String.valueOf(z10));
        if (z10 && (chainState = this.currentChainStartState) != null) {
            Map<String, List<Long>> map = this.stateRangeTime;
            Intrinsics.e(chainState);
            if (map.get(String.valueOf(chainState.getStep())) != null) {
                Map<String, List<Long>> map2 = this.stateRangeTime;
                ChainState chainState2 = this.currentChainStartState;
                Intrinsics.e(chainState2);
                List<Long> list = map2.get(String.valueOf(chainState2.getStep()));
                if (list != null && list.size() == 1) {
                    Map<String, List<Long>> map3 = this.stateRangeTime;
                    ChainState chainState3 = this.currentChainStartState;
                    Intrinsics.e(chainState3);
                    List<Long> list2 = map3.get(String.valueOf(chainState3.getStep()));
                    if (list2 != null) {
                        list2.add(Long.valueOf(j11));
                    }
                    Map<String, Long> map4 = this.stateCostTime;
                    ChainState chainState4 = this.currentChainStartState;
                    Intrinsics.e(chainState4);
                    String valueOf = String.valueOf(chainState4.getStep());
                    Map<String, List<Long>> map5 = this.stateRangeTime;
                    ChainState chainState5 = this.currentChainStartState;
                    Intrinsics.e(chainState5);
                    List<Long> list3 = map5.get(String.valueOf(chainState5.getStep()));
                    long longValue = list3 != null ? list3.get(1).longValue() : 0L;
                    Map<String, List<Long>> map6 = this.stateRangeTime;
                    ChainState chainState6 = this.currentChainStartState;
                    Intrinsics.e(chainState6);
                    List<Long> list4 = map6.get(String.valueOf(chainState6.getStep()));
                    map4.put(valueOf, Long.valueOf(longValue - (list4 != null ? list4.get(0).longValue() : 0L)));
                }
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        appendStages(linkedHashMap, linkedHashMap2);
        bundle.putString("stageCostTime", GsonUtils.toJson(linkedHashMap2));
        bundle.putString("stageRangeTime", GsonUtils.toJson(linkedHashMap));
        bundle.putString(FrameworkConstants.GLOBAL_DATA_KEY_SCENE, String.valueOf(this.scene));
        bundle.putString("pageIndex", String.valueOf(this.pageIndexOfApp));
        bundle.putString("isAdd", "true");
        bundle.putString(TmcConstants.KEY_PAGE_UNIQUE_ID, DeviceUtil.getGAId() + "_" + this.renderId);
        String string = bundle.getString(ChainPoint.PAGE_PATH);
        if (string != null) {
            bundle.putString(PointConstants.POINT_PAGE_PATH, string);
        }
        bundle.remove(ChainPoint.PAGE_PATH);
        bundle.remove(ChainPoint.PAGE_ID);
        ReportProxy reportProxy = (ReportProxy) TmcProxy.get(ReportProxy.class);
        AppChainContext appChainContext2 = this.appChainContext;
        reportProxy.report(appChainContext2 != null ? appChainContext2.getAppId() : null, "mini_page_open_mid", bundle);
    }

    private final void reportPageOpenMidSuccess(Bundle data) {
        TmcLogger.d("chainPoint", PageChainContext.class.getName() + "_reportPageOpenMidSuccess->isReportMid:" + this.isReportMid);
        if (this.isReportMid) {
            return;
        }
        this.isReportMid = true;
        this.openMiniPageMidResult = true;
        Bundle bundle = new Bundle();
        bundle.putAll(data);
        bundle.putString("openPageResult", "true");
        bundle.putString("openPageFailedReason", "");
        bundle.putInt("maxStage", this.maxStage);
        bundle.putString("isExitInStage", "false");
        bundle.putString("open_channel", String.valueOf(this.openChannel));
        AppChainContext appChainContext = this.appChainContext;
        bundle.putString(TmcConstants.HOT_OPEN_TYPE, String.valueOf(appChainContext != null ? appChainContext.getHotOpenType() : null));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        appendStages(linkedHashMap, linkedHashMap2);
        bundle.putString("stageCostTime", GsonUtils.toJson(linkedHashMap2));
        bundle.putString("stageRangeTime", GsonUtils.toJson(linkedHashMap));
        bundle.putString(FrameworkConstants.GLOBAL_DATA_KEY_SCENE, String.valueOf(this.scene));
        bundle.putString("pageIndex", String.valueOf(this.pageIndexOfApp));
        bundle.putString("isAdd", "true");
        String string = bundle.getString(ChainPoint.PAGE_PATH);
        if (string != null) {
            bundle.putString(PointConstants.POINT_PAGE_PATH, string);
        }
        bundle.remove(ChainPoint.PAGE_PATH);
        bundle.remove(ChainPoint.PAGE_ID);
        ReportProxy reportProxy = (ReportProxy) TmcProxy.get(ReportProxy.class);
        AppChainContext appChainContext2 = this.appChainContext;
        reportProxy.report(appChainContext2 != null ? appChainContext2.getAppId() : null, "mini_page_open_mid", bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008d A[Catch: all -> 0x00e7, TRY_ENTER, TryCatch #1 {all -> 0x00e7, blocks: (B:3:0x0005, B:5:0x0012, B:9:0x001d, B:10:0x0031, B:12:0x003d, B:15:0x0045, B:27:0x008d, B:30:0x0096, B:33:0x009f, B:34:0x00e1, B:39:0x00b7, B:40:0x00cd, B:50:0x0050, B:51:0x0055, B:52:0x0028, B:53:0x002d), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096 A[Catch: all -> 0x00e7, TRY_LEAVE, TryCatch #1 {all -> 0x00e7, blocks: (B:3:0x0005, B:5:0x0012, B:9:0x001d, B:10:0x0031, B:12:0x003d, B:15:0x0045, B:27:0x008d, B:30:0x0096, B:33:0x009f, B:34:0x00e1, B:39:0x00b7, B:40:0x00cd, B:50:0x0050, B:51:0x0055, B:52:0x0028, B:53:0x002d), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f A[Catch: all -> 0x00e7, TRY_ENTER, TryCatch #1 {all -> 0x00e7, blocks: (B:3:0x0005, B:5:0x0012, B:9:0x001d, B:10:0x0031, B:12:0x003d, B:15:0x0045, B:27:0x008d, B:30:0x0096, B:33:0x009f, B:34:0x00e1, B:39:0x00b7, B:40:0x00cd, B:50:0x0050, B:51:0x0055, B:52:0x0028, B:53:0x002d), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.os.Bundle reportPsData(java.lang.String r13) {
        /*
            r12 = this;
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.util.Map<java.lang.String, java.util.List<java.lang.Long>> r1 = r12.appStateRangeTime     // Catch: java.lang.Throwable -> Le7
            java.lang.String r2 = "1"
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> Le7
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> Le7
            r2 = 0
            if (r1 == 0) goto L17
            int r3 = r1.size()     // Catch: java.lang.Throwable -> Le7
            goto L18
        L17:
            r3 = r2
        L18:
            r4 = 1
            if (r3 < r4) goto L2d
            if (r1 == 0) goto L28
            java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> Le7
            java.lang.Number r1 = (java.lang.Number) r1     // Catch: java.lang.Throwable -> Le7
            long r5 = r1.longValue()     // Catch: java.lang.Throwable -> Le7
            goto L31
        L28:
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Le7
            goto L31
        L2d:
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Le7
        L31:
            java.util.Map<java.lang.String, java.util.List<java.lang.Long>> r1 = r12.stateRangeTime     // Catch: java.lang.Throwable -> Le7
            java.lang.String r3 = "18"
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> Le7
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> Le7
            if (r1 == 0) goto L41
            int r2 = r1.size()     // Catch: java.lang.Throwable -> Le7
        L41:
            if (r2 < r4) goto L55
            if (r1 == 0) goto L50
            java.lang.Object r1 = r1.get(r4)     // Catch: java.lang.Throwable -> Le7
            java.lang.Number r1 = (java.lang.Number) r1     // Catch: java.lang.Throwable -> Le7
            long r1 = r1.longValue()     // Catch: java.lang.Throwable -> Le7
            goto L59
        L50:
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Le7
            goto L59
        L55:
            long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Le7
        L59:
            r3 = 0
            java.lang.Class<com.cloud.tmc.integration.structure.AppManager> r7 = com.cloud.tmc.integration.structure.AppManager.class
            java.lang.Object r7 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r7)     // Catch: java.lang.Throwable -> L76
            com.cloud.tmc.integration.structure.AppManager r7 = (com.cloud.tmc.integration.structure.AppManager) r7     // Catch: java.lang.Throwable -> L76
            com.cloud.tmc.integration.structure.App r13 = r7.findApp(r13)     // Catch: java.lang.Throwable -> L76
            if (r13 == 0) goto L78
            android.os.Bundle r7 = r13.getSceneParams()     // Catch: java.lang.Throwable -> L76
            if (r7 == 0) goto L78
            java.lang.String r8 = "start_main_first_time"
            long r7 = r7.getLong(r8)     // Catch: java.lang.Throwable -> L76
            goto L79
        L76:
            r7 = r3
            goto L88
        L78:
            r7 = r3
        L79:
            if (r13 == 0) goto L88
            android.os.Bundle r13 = r13.getSceneParams()     // Catch: java.lang.Throwable -> L88
            if (r13 == 0) goto L88
            java.lang.String r9 = "start_mini_first_time"
            long r9 = r13.getLong(r9)     // Catch: java.lang.Throwable -> L88
            goto L89
        L88:
            r9 = r3
        L89:
            int r13 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r13 == 0) goto L92
            java.lang.String r11 = "mini_first_time"
            r0.putLong(r11, r7)     // Catch: java.lang.Throwable -> Le7
        L92:
            int r3 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r3 == 0) goto L9b
            java.lang.String r4 = "mini_second_time"
            r0.putLong(r4, r9)     // Catch: java.lang.Throwable -> Le7
        L9b:
            java.lang.String r4 = "Tmc"
            if (r13 == 0) goto Lb5
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le7
            r13.<init>()     // Catch: java.lang.Throwable -> Le7
            java.lang.String r3 = "firstStartTime:"
            r13.append(r3)     // Catch: java.lang.Throwable -> Le7
            r13.append(r7)     // Catch: java.lang.Throwable -> Le7
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> Le7
            com.cloud.tmc.kernel.log.TmcLogger.d(r4, r13)     // Catch: java.lang.Throwable -> Le7
            r5 = r7
            goto Le1
        Lb5:
            if (r3 == 0) goto Lcd
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le7
            r13.<init>()     // Catch: java.lang.Throwable -> Le7
            java.lang.String r3 = "secondStartTime:"
            r13.append(r3)     // Catch: java.lang.Throwable -> Le7
            r13.append(r9)     // Catch: java.lang.Throwable -> Le7
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> Le7
            com.cloud.tmc.kernel.log.TmcLogger.d(r4, r13)     // Catch: java.lang.Throwable -> Le7
            r5 = r9
            goto Le1
        Lcd:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Le7
            r13.<init>()     // Catch: java.lang.Throwable -> Le7
            java.lang.String r3 = "reportStartTime:"
            r13.append(r3)     // Catch: java.lang.Throwable -> Le7
            r13.append(r5)     // Catch: java.lang.Throwable -> Le7
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Throwable -> Le7
            com.cloud.tmc.kernel.log.TmcLogger.d(r4, r13)     // Catch: java.lang.Throwable -> Le7
        Le1:
            long r1 = r1 - r5
            java.lang.String r13 = "miniapp_all_start_time"
            r0.putLong(r13, r1)     // Catch: java.lang.Throwable -> Le7
        Le7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.integration.chain.page.PageChainContext.reportPsData(java.lang.String):android.os.Bundle");
    }

    @Override // com.cloud.tmc.integration.chain.ChainContext
    public void destroy(Bundle data) {
        Stack<PageChainContext> pageContexts;
        Intrinsics.h(data, "data");
        try {
            TmcLogger.d("chainPoint", PageChainContext.class.getName() + "_destroy->openMiniPageMidResult:" + this.openMiniPageMidResult + " ,openMiniPageEndResult:" + this.openMiniPageEndResult);
            if (!this.openMiniPageMidResult) {
                reportPageOpenMidFail(data);
            }
            if (!this.openMiniPageEndResult) {
                reportPageOpenEndFail(data);
            }
            AppChainContext appChainContext = this.appChainContext;
            if (appChainContext != null && (pageContexts = appChainContext.getPageContexts()) != null) {
                CollectionsKt.I(pageContexts, new Function1<PageChainContext, Boolean>() { // from class: com.cloud.tmc.integration.chain.page.PageChainContext$destroy$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(PageChainContext pageChainContext) {
                        return Boolean.valueOf(Intrinsics.c(pageChainContext.getRenderId(), PageChainContext.this.getRenderId()));
                    }
                });
            }
            this.appChainContext = null;
        } catch (Throwable unused) {
        }
    }

    public final Map<String, Long> getAppStateCostTime() {
        return this.appStateCostTime;
    }

    public final Map<String, List<Long>> getAppStateRangeTime() {
        return this.appStateRangeTime;
    }

    @Override // com.cloud.tmc.integration.chain.ChainContext
    public ContextType getContextType() {
        return ContextType.TYPE_PAGE;
    }

    public final ChainState getCurrentChainEndState() {
        return this.currentChainEndState;
    }

    public final ChainState getCurrentChainStartState() {
        return this.currentChainStartState;
    }

    public final String getDrawEndType() {
        return this.drawEndType;
    }

    public final String getH5ProgressCollectList() {
        return this.h5ProgressCollectList;
    }

    public final int getMaxStage() {
        return this.maxStage;
    }

    public final String getOpenChannel() {
        return this.openChannel;
    }

    public final boolean getOpenMiniPageEndResult() {
        return this.openMiniPageEndResult;
    }

    public final String getOpenMiniPageFailedReason() {
        return this.openMiniPageFailedReason;
    }

    public final boolean getOpenMiniPageMidResult() {
        return this.openMiniPageMidResult;
    }

    public final int getPageIndexOfApp() {
        return this.pageIndexOfApp;
    }

    public final String getPageUrl() {
        return this.pageUrl;
    }

    public final String getRenderId() {
        return this.renderId;
    }

    public final String getScene() {
        return this.scene;
    }

    public final Map<String, Long> getStateCostTime() {
        return this.stateCostTime;
    }

    public final Map<String, List<Long>> getStateRangeTime() {
        return this.stateRangeTime;
    }

    /* renamed from: isReportEnd, reason: from getter */
    public final boolean getIsReportEnd() {
        return this.isReportEnd;
    }

    /* renamed from: isReportMid, reason: from getter */
    public final boolean getIsReportMid() {
        return this.isReportMid;
    }

    @Override // com.cloud.tmc.integration.chain.ChainContext
    public void log(String str) {
        ChainContext.DefaultImpls.log(this, str);
    }

    public final void setAppChainContext(AppChainContext appChainContext) {
        this.appChainContext = appChainContext;
    }

    public final void setAppStateCostTime(Map<String, Long> map) {
        Intrinsics.h(map, "<set-?>");
        this.appStateCostTime = map;
    }

    public final void setAppStateRangeTime(Map<String, List<Long>> map) {
        Intrinsics.h(map, "<set-?>");
        this.appStateRangeTime = map;
    }

    @Override // com.cloud.tmc.integration.chain.ChainContext
    public void setChainState(ChainState chainState) {
        Intrinsics.h(chainState, "chainState");
        try {
            log("setChainState_" + chainState.getStep());
            int i11 = WhenMappings.$EnumSwitchMapping$0[chainState.getChainType().ordinal()];
            if (i11 == 1) {
                parseChainStart(chainState);
            } else if (i11 == 2) {
                parseChainEnd(chainState);
            } else if (i11 == 3) {
                parseChianError(chainState);
            } else if (i11 == 4) {
                insertData(chainState);
            }
        } catch (Throwable unused) {
        }
    }

    public final void setCurrentChainEndState(ChainState chainState) {
        this.currentChainEndState = chainState;
    }

    public final void setCurrentChainStartState(ChainState chainState) {
        this.currentChainStartState = chainState;
    }

    public final void setDrawEndType(String str) {
        Intrinsics.h(str, "<set-?>");
        this.drawEndType = str;
    }

    public final void setH5ProgressCollectList(String str) {
        Intrinsics.h(str, "<set-?>");
        this.h5ProgressCollectList = str;
    }

    public final void setMaxStage(int i11) {
        this.maxStage = i11;
    }

    public final void setOpenChannel(String str) {
        Intrinsics.h(str, "<set-?>");
        this.openChannel = str;
    }

    public final void setOpenMiniPageEndResult(boolean z10) {
        this.openMiniPageEndResult = z10;
    }

    public final void setOpenMiniPageFailedReason(String str) {
        Intrinsics.h(str, "<set-?>");
        this.openMiniPageFailedReason = str;
    }

    public final void setOpenMiniPageMidResult(boolean z10) {
        this.openMiniPageMidResult = z10;
    }

    public final void setPageIndexOfApp(int i11) {
        this.pageIndexOfApp = i11;
    }

    public final void setPageUrl(String str) {
        Intrinsics.h(str, "<set-?>");
        this.pageUrl = str;
    }

    public final void setRenderId(String str) {
        Intrinsics.h(str, "<set-?>");
        this.renderId = str;
    }

    public final void setReportEnd(boolean z10) {
        this.isReportEnd = z10;
    }

    public final void setReportMid(boolean z10) {
        this.isReportMid = z10;
    }

    public final void setScene(String str) {
        Intrinsics.h(str, "<set-?>");
        this.scene = str;
    }

    public final void setStateCostTime(Map<String, Long> map) {
        Intrinsics.h(map, "<set-?>");
        this.stateCostTime = map;
    }

    public final void setStateRangeTime(Map<String, List<Long>> map) {
        Intrinsics.h(map, "<set-?>");
        this.stateRangeTime = map;
    }
}
