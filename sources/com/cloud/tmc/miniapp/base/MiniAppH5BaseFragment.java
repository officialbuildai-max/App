package com.cloud.tmc.miniapp.base;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.collection.s;
import androidx.fragment.app.FragmentActivity;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.chain.endState.ChainMidEndState;
import com.cloud.tmc.integration.chain.endState.CreateContainerEndState;
import com.cloud.tmc.integration.chain.endState.CreateRenderEndState;
import com.cloud.tmc.integration.chain.endState.CreateWorkerEndState;
import com.cloud.tmc.integration.chain.endState.DrawViewEndState;
import com.cloud.tmc.integration.chain.endState.LoadRenderFrameworkEndState;
import com.cloud.tmc.integration.chain.endState.LoadWorkerFrameworkEndState;
import com.cloud.tmc.integration.chain.errorState.PageErrorState;
import com.cloud.tmc.integration.chain.insert.AppInsertState;
import com.cloud.tmc.integration.chain.insert.PageInsertState;
import com.cloud.tmc.integration.chain.page.PageChainContext;
import com.cloud.tmc.integration.chain.startState.ChainMidStartState;
import com.cloud.tmc.integration.chain.startState.CreateContainerStartState;
import com.cloud.tmc.integration.chain.startState.CreateRenderStartState;
import com.cloud.tmc.integration.chain.startState.CreateWorkerStartState;
import com.cloud.tmc.integration.chain.startState.DrawViewStartState;
import com.cloud.tmc.integration.chain.startState.LoadRenderFrameworkStartState;
import com.cloud.tmc.integration.chain.startState.LoadWorkerFrameworkStartState;
import com.cloud.tmc.integration.defaultImpl.InjectJSProxyImp;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.integration.utils.DeviceUtil;
import com.cloud.tmc.integration.utils.PrivacyUtils;
import com.cloud.tmc.integration.utils.TrackPointUtils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.eventcenter.IEvent;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenter;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventSubscriber;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.render.IRender;
import com.cloud.tmc.launcherlib.LauncherMiniAppConfigHelper;
import com.cloud.tmc.miniutils.util.GsonUtils;
import com.cloud.tmc.render.IPageChainCallback;
import com.cloud.tmc.render.MonitorWebviewListener;
import com.cloud.tmc.render.bean.InjectStrategy;
import com.cloud.tmc.render.proxy.InjectJSProxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@SourceDebugExtension
/* loaded from: classes3.dex */
public abstract class MiniAppH5BaseFragment extends MiniAppBaseFragment implements MonitorWebviewListener {
    private IEventCenter h5EventCenter;
    private IEventSubscriber h5OnPageFinishedEventCenter;
    private boolean isFirstLoadHomePage;
    private boolean trackPointLoadData;
    private final String TAG = "h5PointTrack";
    private final String TAG_NEW = "h5PointTrackNew";
    private String loadingUrl = "";
    private final Stack<PageStatus> backForwardStack = new Stack<>();
    private final AtomicInteger h5PageId = new AtomicInteger(0);
    private String virtual_h5PageId = "0";
    private final Map<String, String> urlMap = new LinkedHashMap();
    private final String TAG_REDIRECT = "h5Redirect";
    private final Stack<String> pageStartStack = new Stack<>();
    private final List<String> redirectUrls = new ArrayList();

    @SourceDebugExtension
    /* loaded from: classes3.dex */
    public final class H5OnPageFinishedEventCenter implements IEventSubscriber {
        private final App app;
        private final Page page;

        public H5OnPageFinishedEventCenter(App app, Page page) {
            this.app = app;
            this.page = page;
        }

        public final App getApp() {
            return this.app;
        }

        public final Page getPage() {
            return this.page;
        }

        @Override // com.cloud.tmc.kernel.proxy.eventcenter.IEventSubscriber
        public boolean onEvent(IEvent iEvent) {
            ShowPageStore showPageStore;
            Stack<ShowPageData> findShowPages;
            Map<String, Object> data;
            try {
                TmcLogger.d(MiniAppH5BaseFragment.this.TAG_NEW, "juggist[FCP] -> 执行回调");
                App app = this.app;
                if (app != null && (showPageStore = (ShowPageStore) app.getData(ShowPageStore.class)) != null && (findShowPages = showPageStore.findShowPages()) != null) {
                    if (findShowPages.size() == 0) {
                        TmcLogger.d(MiniAppH5BaseFragment.this.TAG_NEW, "juggist[FCP] -> showPages.size == 0 return");
                        return true;
                    }
                    ShowPageData peek = findShowPages.peek();
                    if (peek == null) {
                        return true;
                    }
                    TmcLogger.d(MiniAppH5BaseFragment.this.TAG_NEW, "juggist[FCP] -> originalUrl:" + peek.getOriginalUrl());
                    TmcLogger.d(MiniAppH5BaseFragment.this.TAG_NEW, "juggist[FCP] -> url        :" + peek.getUrl());
                    TmcLogger.d(MiniAppH5BaseFragment.this.TAG_NEW, "juggist[FCP] -> requestUrl :" + peek.getRequestUrl());
                    TmcLogger.d(MiniAppH5BaseFragment.this.TAG_NEW, "juggist[FCP] -> showPages:" + peek);
                    if (peek.getStatus().getType() != ShowPageStatus.PAGE_START.getType()) {
                        TmcLogger.d(MiniAppH5BaseFragment.this.TAG_NEW, "juggist[FCP] -> showPage.status != ShowPageStatus.PAGE_START return");
                        return true;
                    }
                    Object obj = (iEvent == null || (data = iEvent.getData()) == null) ? null : data.get("params");
                    String str = obj instanceof String ? (String) obj : null;
                    if (str == null) {
                        str = "";
                    }
                    Object fromJson = GsonUtils.fromJson(str, (Class<Object>) IPageChainCallback.OnPageFinishedData.class);
                    Intrinsics.g(fromJson, "fromJson(params, IPageCh…FinishedData::class.java)");
                    IPageChainCallback.OnPageFinishedData onPageFinishedData = (IPageChainCallback.OnPageFinishedData) fromJson;
                    String url = onPageFinishedData.getUrl();
                    long fcpCurrentTimeMillis = onPageFinishedData.getFcpCurrentTimeMillis();
                    TmcLogger.d(MiniAppH5BaseFragment.this.TAG_NEW, "juggist[FCP] -> FCPUrl:" + url);
                    TmcLogger.d(MiniAppH5BaseFragment.this.TAG_NEW, "juggist[FCP] -> FCPTime:" + fcpCurrentTimeMillis);
                    if (!Intrinsics.c(peek.getUrl(), url)) {
                        TmcLogger.d(MiniAppH5BaseFragment.this.TAG_NEW, "juggist[FCP] -> url != FCPUrl return");
                        return true;
                    }
                    boolean z10 = false;
                    if (MiniAppH5BaseFragment.this.getTrackPointLoadData()) {
                        MiniAppH5BaseFragment.this.setTrackPointLoadData(false);
                        z10 = true;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString(ChainPoint.PAGE_PATH, peek.getRequestUrl());
                    bundle.putString(ChainPoint.PAGE_ID, peek.getVirtual_h5PageId());
                    bundle.putLong(ChainPoint.FCP_CURRENT_TIMEMILLIS, fcpCurrentTimeMillis);
                    bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
                    bundle.putString(ChainPoint.CHAIN_DRAW_END_TYPE, "2");
                    bundle.putBoolean(ChainPoint.PAGE_TYPE_LOAD_DATA, z10);
                    Page page = this.page;
                    bundle.putString(TmcConstants.KEY_PAGE_RANDOM_ID, String.valueOf(page != null ? page.getPageRandomIdByGAId() : null));
                    bundle.putString(TmcConstants.KEY_PAGE_UNIQUE_ID, DeviceUtil.getGAId() + "_" + peek.getVirtual_h5PageId());
                    App app2 = this.app;
                    if (app2 != null) {
                        app2.setMiniAppLoadStatus(true);
                    }
                    peek.setStatus(ShowPageStatus.PAGE_PROGRESS100);
                    FragmentActivity activity = MiniAppH5BaseFragment.this.getActivity();
                    if (activity != null) {
                        PrivacyUtils privacyUtils = PrivacyUtils.INSTANCE;
                        App app3 = this.app;
                        privacyUtils.updateNewUserStatus(activity, app3 != null ? app3.getAppId() : null);
                    }
                    new DrawViewEndState(bundle).setChainContext(MiniAppH5BaseFragment.this.getPageChainContext(peek.getVirtual_h5PageId()));
                    TmcLogger.d(MiniAppH5BaseFragment.this.TAG_NEW, "juggist[FCP] -> 静态资源渲染成功");
                }
            } catch (Throwable unused) {
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class PageStatus {
        private boolean canGoBack;
        private boolean isDomContentLoaded;
        private boolean isHomePage;
        private boolean isLoadError;
        private boolean isPageFinished;
        private boolean isProgressChangedTo100;
        private String pageRandomIdByGAID;
        private ConcurrentHashMap<Integer, Long> progressCollectList;
        private ProgressStep progressCurrentStep;
        private long progressStartTime;
        private String url;
        private String virtual_h5PageId;

        public PageStatus() {
            this(null, false, false, false, false, false, null, null, null, 0L, false, 2047, null);
        }

        public PageStatus(String url, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, String virtual_h5PageId, ConcurrentHashMap<Integer, Long> progressCollectList, ProgressStep progressStep, long j11, boolean z15) {
            Intrinsics.h(url, "url");
            Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
            Intrinsics.h(progressCollectList, "progressCollectList");
            this.url = url;
            this.isProgressChangedTo100 = z10;
            this.isPageFinished = z11;
            this.isHomePage = z12;
            this.isLoadError = z13;
            this.canGoBack = z14;
            this.virtual_h5PageId = virtual_h5PageId;
            this.progressCollectList = progressCollectList;
            this.progressCurrentStep = progressStep;
            this.progressStartTime = j11;
            this.isDomContentLoaded = z15;
            this.pageRandomIdByGAID = "";
        }

        public /* synthetic */ PageStatus(String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, String str2, ConcurrentHashMap concurrentHashMap, ProgressStep progressStep, long j11, boolean z15, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? false : z10, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? false : z12, (i11 & 16) != 0 ? false : z13, (i11 & 32) != 0 ? false : z14, (i11 & 64) != 0 ? "0" : str2, (i11 & 128) != 0 ? new ConcurrentHashMap() : concurrentHashMap, (i11 & 256) != 0 ? null : progressStep, (i11 & 512) != 0 ? System.currentTimeMillis() : j11, (i11 & 1024) == 0 ? z15 : false);
        }

        public final String component1() {
            return this.url;
        }

        public final long component10() {
            return this.progressStartTime;
        }

        public final boolean component11() {
            return this.isDomContentLoaded;
        }

        public final boolean component2() {
            return this.isProgressChangedTo100;
        }

        public final boolean component3() {
            return this.isPageFinished;
        }

        public final boolean component4() {
            return this.isHomePage;
        }

        public final boolean component5() {
            return this.isLoadError;
        }

        public final boolean component6() {
            return this.canGoBack;
        }

        public final String component7() {
            return this.virtual_h5PageId;
        }

        public final ConcurrentHashMap<Integer, Long> component8() {
            return this.progressCollectList;
        }

        public final ProgressStep component9() {
            return this.progressCurrentStep;
        }

        public final PageStatus copy(String url, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, String virtual_h5PageId, ConcurrentHashMap<Integer, Long> progressCollectList, ProgressStep progressStep, long j11, boolean z15) {
            Intrinsics.h(url, "url");
            Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
            Intrinsics.h(progressCollectList, "progressCollectList");
            return new PageStatus(url, z10, z11, z12, z13, z14, virtual_h5PageId, progressCollectList, progressStep, j11, z15);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PageStatus)) {
                return false;
            }
            PageStatus pageStatus = (PageStatus) obj;
            return Intrinsics.c(this.url, pageStatus.url) && this.isProgressChangedTo100 == pageStatus.isProgressChangedTo100 && this.isPageFinished == pageStatus.isPageFinished && this.isHomePage == pageStatus.isHomePage && this.isLoadError == pageStatus.isLoadError && this.canGoBack == pageStatus.canGoBack && Intrinsics.c(this.virtual_h5PageId, pageStatus.virtual_h5PageId) && Intrinsics.c(this.progressCollectList, pageStatus.progressCollectList) && this.progressCurrentStep == pageStatus.progressCurrentStep && this.progressStartTime == pageStatus.progressStartTime && this.isDomContentLoaded == pageStatus.isDomContentLoaded;
        }

        public final boolean getCanGoBack() {
            return this.canGoBack;
        }

        public final String getPageRandomIdByGAID() {
            return this.pageRandomIdByGAID;
        }

        public final ConcurrentHashMap<Integer, Long> getProgressCollectList() {
            return this.progressCollectList;
        }

        public final ProgressStep getProgressCurrentStep() {
            return this.progressCurrentStep;
        }

        public final long getProgressStartTime() {
            return this.progressStartTime;
        }

        public final String getUrl() {
            return this.url;
        }

        public final String getVirtual_h5PageId() {
            return this.virtual_h5PageId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.url.hashCode() * 31;
            boolean z10 = this.isProgressChangedTo100;
            int i11 = z10;
            if (z10 != 0) {
                i11 = 1;
            }
            int i12 = (hashCode + i11) * 31;
            boolean z11 = this.isPageFinished;
            int i13 = z11;
            if (z11 != 0) {
                i13 = 1;
            }
            int i14 = (i12 + i13) * 31;
            boolean z12 = this.isHomePage;
            int i15 = z12;
            if (z12 != 0) {
                i15 = 1;
            }
            int i16 = (i14 + i15) * 31;
            boolean z13 = this.isLoadError;
            int i17 = z13;
            if (z13 != 0) {
                i17 = 1;
            }
            int i18 = (i16 + i17) * 31;
            boolean z14 = this.canGoBack;
            int i19 = z14;
            if (z14 != 0) {
                i19 = 1;
            }
            int hashCode2 = (this.progressCollectList.hashCode() + ((this.virtual_h5PageId.hashCode() + ((i18 + i19) * 31)) * 31)) * 31;
            ProgressStep progressStep = this.progressCurrentStep;
            int a11 = (s.a(this.progressStartTime) + ((hashCode2 + (progressStep == null ? 0 : progressStep.hashCode())) * 31)) * 31;
            boolean z15 = this.isDomContentLoaded;
            return a11 + (z15 ? 1 : z15 ? 1 : 0);
        }

        public final boolean isDomContentLoaded() {
            return this.isDomContentLoaded;
        }

        public final boolean isHomePage() {
            return this.isHomePage;
        }

        public final boolean isLoadError() {
            return this.isLoadError;
        }

        public final boolean isPageFinished() {
            return this.isPageFinished;
        }

        public final boolean isProgressChangedTo100() {
            return this.isProgressChangedTo100;
        }

        public final void setCanGoBack(boolean z10) {
            this.canGoBack = z10;
        }

        public final void setDomContentLoaded(boolean z10) {
            this.isDomContentLoaded = z10;
        }

        public final void setHomePage(boolean z10) {
            this.isHomePage = z10;
        }

        public final void setLoadError(boolean z10) {
            this.isLoadError = z10;
        }

        public final void setPageFinished(boolean z10) {
            this.isPageFinished = z10;
        }

        public final void setPageRandomIdByGAID(String value) {
            Intrinsics.h(value, "value");
            this.pageRandomIdByGAID = value;
        }

        public final void setProgressChangedTo100(boolean z10) {
            this.isProgressChangedTo100 = z10;
        }

        public final void setProgressCollectList(ConcurrentHashMap<Integer, Long> concurrentHashMap) {
            Intrinsics.h(concurrentHashMap, "<set-?>");
            this.progressCollectList = concurrentHashMap;
        }

        public final void setProgressCurrentStep(ProgressStep progressStep) {
            this.progressCurrentStep = progressStep;
        }

        public final void setProgressStartTime(long j11) {
            this.progressStartTime = j11;
        }

        public final void setUrl(String str) {
            Intrinsics.h(str, "<set-?>");
            this.url = str;
        }

        public final void setVirtual_h5PageId(String str) {
            Intrinsics.h(str, "<set-?>");
            this.virtual_h5PageId = str;
        }

        public String toString() {
            return "PageStatus(url=" + this.url + ", isProgressChangedTo100=" + this.isProgressChangedTo100 + ", isPageFinished=" + this.isPageFinished + ", isHomePage=" + this.isHomePage + ", isLoadError=" + this.isLoadError + ", canGoBack=" + this.canGoBack + ", virtual_h5PageId=" + this.virtual_h5PageId + ", progressCollectList=" + this.progressCollectList + ", progressCurrentStep=" + this.progressCurrentStep + ", progressStartTime=" + this.progressStartTime + ", isDomContentLoaded=" + this.isDomContentLoaded + ")";
        }
    }

    /* loaded from: classes3.dex */
    public enum ProgressStep {
        INIT(0),
        STEP_30(30),
        STEP_50(50),
        STEP_70(70),
        STEP_100(100);

        private final int step;

        ProgressStep(int i11) {
            this.step = i11;
        }

        /* synthetic */ ProgressStep(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? 0 : i11);
        }

        public final int getStep() {
            return this.step;
        }
    }

    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProgressStep.values().length];
            try {
                iArr[ProgressStep.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProgressStep.STEP_30.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProgressStep.STEP_50.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProgressStep.STEP_70.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProgressStep.STEP_100.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void addNewPageTrack(String str, String str2, boolean z10) {
        TmcLogger.d(this.TAG_NEW, "addNewPageTrack");
        if (!z10) {
            pointTrackCreateContainerStartNew(str, str2);
            pointTrackCreateContainerEndNew(str, str2);
        }
        pointTrackCreateRenderStartNew(str, str2);
        pointTrackCreateRenderEndNew(str, str2);
        pointTrackLoadRenderFrameworkStartNew(str, str2);
        pointTrackLoadRenderFrameworkEndNew(str, str2);
        pointTrackCreateWorkerStartNew(str, str2);
        pointTrackCreateWorkerEndNew(str, str2);
        pointTrackLoadWorkerFrameworkStartNew(str, str2);
        pointTrackLoadWorkerFrameworkEndNew(str, str2);
        pointTrackMidStartNew(str, str2);
        pointTrackMidEndNew(str, str2);
        pointTrackDrawViewStartNew(str, str2);
    }

    private final boolean checkDomLoadMonitorSwitch(int i11) {
        if (i11 == 1) {
            return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_MINIAPP_ENABLE_H5_MONITOR, true);
        }
        if (i11 != 2) {
            return false;
        }
        return MiniAppConfigHelper.INSTANCE.getConfigTargetBool(LauncherMiniAppConfigHelper.KEY_MINIAPP_ENABLE_SHELL_MONITOR, true);
    }

    private final String findPrePage() {
        try {
            String peek = this.pageStartStack.peek();
            if (peek == null) {
                return null;
            }
            if (!CollectionsKt.b0(this.redirectUrls, peek)) {
                return peek;
            }
            this.pageStartStack.pop();
            return findPrePage();
        } catch (Throwable unused) {
            return null;
        }
    }

    public final PageChainContext getPageChainContext(String str) {
        ShowPageStore showPageStore;
        Stack<ShowPageData> findShowPages;
        App app = this.app;
        if (app == null || (showPageStore = (ShowPageStore) app.getData(ShowPageStore.class)) == null || (findShowPages = showPageStore.findShowPages()) == null) {
            return null;
        }
        for (ShowPageData showPageData : findShowPages) {
            if (Intrinsics.c(showPageData.getVirtual_h5PageId(), str)) {
                return showPageData.getPageChainContext();
            }
        }
        return null;
    }

    public static /* synthetic */ void goBackNew$default(MiniAppH5BaseFragment miniAppH5BaseFragment, TmcFragment.ExitType exitType, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: goBackNew");
        }
        if ((i11 & 1) != 0) {
            exitType = TmcFragment.ExitType.BACK;
        }
        miniAppH5BaseFragment.goBackNew(exitType);
    }

    public static final void injectJSFromConfig$lambda$35$lambda$34(String injectJSStrategy, String scriptWrapper, String str) {
        Intrinsics.h(injectJSStrategy, "$injectJSStrategy");
        Intrinsics.h(scriptWrapper, "$scriptWrapper");
        TmcLogger.d(InjectJSProxyImp.TAG, injectJSStrategy + " inject success script:\n" + scriptWrapper + "\n");
    }

    public static /* synthetic */ void pointTrackDrawViewEndForApp$default(MiniAppH5BaseFragment miniAppH5BaseFragment, String str, String str2, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pointTrackDrawViewEndForApp");
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        miniAppH5BaseFragment.pointTrackDrawViewEndForApp(str, str2, z10);
    }

    public static /* synthetic */ void pointTrackDrawViewEndNew$default(MiniAppH5BaseFragment miniAppH5BaseFragment, String str, String str2, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pointTrackDrawViewEndNew");
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        miniAppH5BaseFragment.pointTrackDrawViewEndNew(str, str2, z10);
    }

    public static /* synthetic */ void pointTrackDrawViewFailNew$default(MiniAppH5BaseFragment miniAppH5BaseFragment, String str, String str2, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pointTrackDrawViewFailNew");
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        miniAppH5BaseFragment.pointTrackDrawViewFailNew(str, str2, z10);
    }

    public final void addPage(String originalUrl, String url, String requestUrl, String virtual_h5PageId, PageChainContext pageChainContext) {
        String str;
        Intrinsics.h(originalUrl, "originalUrl");
        Intrinsics.h(url, "url");
        Intrinsics.h(requestUrl, "requestUrl");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        Intrinsics.h(pageChainContext, "pageChainContext");
        try {
            TmcLogger.d(this.TAG_NEW, "Add New Home Page -> requestUrl:" + requestUrl);
            App app = this.app;
            if (app != null) {
                if (app.getData(ShowPageStore.class) == null) {
                    app.setData(ShowPageStore.class, new ShowPageStore());
                }
                ShowPageStore showPageStore = (ShowPageStore) app.getData(ShowPageStore.class);
                if (showPageStore != null) {
                    Stack<ShowPageData> findShowPages = showPageStore.findShowPages();
                    ShowPageStatus showPageStatus = ShowPageStatus.SHOULDOVERRIDEURKLOADING;
                    Page page = this.page;
                    if (page != null) {
                        str = page.getPageRandomIdByGAId();
                        if (str == null) {
                        }
                        String str2 = str;
                        Intrinsics.g(str2, "page?.pageRandomIdByGAId ?: \"null\"");
                        findShowPages.add(new ShowPageData(originalUrl, url, requestUrl, virtual_h5PageId, showPageStatus, false, str2, pageChainContext, false, null, null, 0L, 3840, null));
                    }
                    str = "null";
                    String str22 = str;
                    Intrinsics.g(str22, "page?.pageRandomIdByGAId ?: \"null\"");
                    findShowPages.add(new ShowPageData(originalUrl, url, requestUrl, virtual_h5PageId, showPageStatus, false, str22, pageChainContext, false, null, null, 0L, 3840, null));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean canGoBack(WebView webView) {
        TmcLogger.d(this.TAG_REDIRECT, "canGoBack => originalUrl:" + getCurrentOriginalUrl(webView) + " , url:" + getCurrentUrl(webView));
        if (webView != null) {
            try {
                if (webView.canGoBack()) {
                    if (!this.redirectUrls.isEmpty()) {
                        TmcLogger.d(this.TAG_REDIRECT, "canGoBack => 重定向回退");
                        return redirectCanGoBack(webView);
                    }
                    TmcLogger.d(this.TAG_REDIRECT, "canGoBack => 正常回退");
                    webView.goBack();
                    goBackNew$default(this, null, 1, null);
                    goBack();
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        TmcLogger.d(this.TAG_REDIRECT, "canGoBack => 直接退出");
        return false;
    }

    public final void createSubscriber() {
        Page page;
        try {
            App app = this.app;
            if (app == null || (page = this.page) == null) {
                return;
            }
            this.h5EventCenter = ((IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class)).getEventCenterInstance(page);
            H5OnPageFinishedEventCenter h5OnPageFinishedEventCenter = new H5OnPageFinishedEventCenter(app, page);
            this.h5OnPageFinishedEventCenter = h5OnPageFinishedEventCenter;
            IEventCenter iEventCenter = this.h5EventCenter;
            if (iEventCenter != null) {
                iEventCenter.register(TmcConstants.EVENT_H5_ONPAGEFINISHED, h5OnPageFinishedEventCenter);
            }
        } catch (Throwable unused) {
        }
    }

    public final void destroySubscriber() {
        IEventCenter iEventCenter;
        try {
            IEventSubscriber iEventSubscriber = this.h5OnPageFinishedEventCenter;
            if (iEventSubscriber == null || (iEventCenter = this.h5EventCenter) == null) {
                return;
            }
            iEventCenter.unregister(TmcConstants.EVENT_H5_ONPAGEFINISHED, iEventSubscriber);
        } catch (Throwable unused) {
        }
    }

    public final String getCurrentOriginalUrl(WebView webView) {
        String url;
        if (webView != null && (url = webView.getUrl()) != null && StringsKt.W(url, TmcConstants.LOAD_BASE_DATA_URL, false, 2, null)) {
            return this.loadingUrl;
        }
        if (webView != null) {
            return webView.getOriginalUrl();
        }
        return null;
    }

    public final String getCurrentUrl(WebView webView) {
        String url;
        if (webView != null && (url = webView.getUrl()) != null && StringsKt.W(url, TmcConstants.LOAD_BASE_DATA_URL, false, 2, null)) {
            return this.loadingUrl;
        }
        if (webView != null) {
            return webView.getUrl();
        }
        return null;
    }

    public final IEventCenter getH5EventCenter() {
        return this.h5EventCenter;
    }

    public final IEventSubscriber getH5OnPageFinishedEventCenter() {
        return this.h5OnPageFinishedEventCenter;
    }

    public final AtomicInteger getH5PageId() {
        return this.h5PageId;
    }

    public final String getReportOriginalUrl(String str) {
        String str2;
        if (str == null) {
            return "";
        }
        Iterator<Map.Entry<String, String>> it = this.urlMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str2 = str;
                break;
            }
            Map.Entry<String, String> next = it.next();
            if (Intrinsics.c(next.getValue(), str)) {
                str2 = next.getKey();
                break;
            }
        }
        TmcLogger.d("oldChain", "getReportOriginalUrl -> realUrl:" + str + ", originalUrl:" + str2);
        return str2;
    }

    public final boolean getTrackPointLoadData() {
        return this.trackPointLoadData;
    }

    public final Map<String, String> getUrlMap() {
        return this.urlMap;
    }

    public final void goBack() {
        try {
            if (this.backForwardStack.size() > 1) {
                PageStatus pop = this.backForwardStack.pop();
                pointTrackClear(pop.getUrl(), pop.getPageRandomIdByGAID());
                PageStatus peek = this.backForwardStack.peek();
                TmcLogger.d(this.TAG, "goBack => exitPage: " + pop + ", showPage: " + peek);
                setLoadingUrl(peek.getUrl(), false, peek.getVirtual_h5PageId());
                if (!pop.getCanGoBack()) {
                    TmcLogger.d(this.TAG, "goBack 页面未入栈，继续退出 => exitPage: " + pop + ", showPage: " + peek);
                    goBack();
                }
            } else {
                TmcLogger.e(this.TAG, "goBack fail: backForwardStack.size <= 1");
            }
        } catch (Throwable th2) {
            TmcLogger.e("goback fail: " + th2);
        }
    }

    public final void goBackNew(TmcFragment.ExitType exitType) {
        ShowPageStore showPageStore;
        Stack<ShowPageData> findShowPages;
        Intrinsics.h(exitType, "exitType");
        try {
            App app = this.app;
            if (app != null && (showPageStore = (ShowPageStore) app.getData(ShowPageStore.class)) != null && (findShowPages = showPageStore.findShowPages()) != null) {
                if (findShowPages.size() == 0) {
                    TmcLogger.d(this.TAG_NEW, "goBackNew currentPage -> showPages.size == 0 return");
                    return;
                }
                ShowPageData pop = findShowPages.pop();
                if (pop == null) {
                    return;
                }
                TmcLogger.d(this.TAG_NEW, "goBackNew currentPage -> " + pop);
                setExitType(exitType);
                pointTrackClearNew(pop.getRequestUrl(), pop.getVirtual_h5PageId(), pop);
                if (findShowPages.size() == 0) {
                    TmcLogger.d(this.TAG_NEW, "goBackNew prePage= -> showPages.size == 0 return");
                    return;
                }
                ShowPageData peek = findShowPages.peek();
                if (peek == null) {
                    return;
                }
                TmcLogger.d(this.TAG_NEW, "goBackNew prePage -> " + peek);
                if (peek.getStatus().getType() == ShowPageStatus.SHOULDOVERRIDEURKLOADING.getType() || peek.getStatus().getType() == ShowPageStatus.PAGE_START.getType()) {
                    TmcLogger.d(this.TAG_NEW, "goBackNew -> prePage.status == ShowPageStatus.SHOULDOVERRIDEURKLOADING || prePage.status == ShowPageStatus.PAGE_START 主动清除页面栈内的页面");
                    goBackNew(TmcFragment.ExitType.BACK_CLEAR_PRE_PAGE);
                }
            }
        } catch (Throwable th2) {
            TmcLogger.e("goback fail: " + th2);
        }
    }

    public final void initDomLoadMonitor(int i11) {
        IRender render;
        try {
            if (checkDomLoadMonitorSwitch(i11)) {
                Page page = this.page;
                View view = (page == null || (render = page.getRender()) == null) ? null : render.getView();
                WebView webView = view instanceof WebView ? (WebView) view : null;
                if (webView != null) {
                    webView.loadUrl("javascript:document.addEventListener('DOMContentLoaded', function() {window.dltMonitor.reportDomLoadTime(" + i11 + "," + hashCode() + ");});");
                }
            }
        } catch (Throwable th2) {
            TmcLogger.e(this.TAG, "domLoadMonitorInit error", th2);
        }
    }

    public final void injectJSFromConfig(WebView webView, final String injectJSStrategy) {
        String script;
        Intrinsics.h(injectJSStrategy, "injectJSStrategy");
        InjectJSProxy injectJSProxy = (InjectJSProxy) TmcProxy.get(InjectJSProxy.class);
        App app = this.app;
        String appId = app != null ? app.getAppId() : null;
        if (appId == null) {
            appId = "";
        }
        InjectStrategy injectStrategy = injectJSProxy.getInjectStrategy(appId).get(injectJSStrategy);
        if (injectStrategy == null || (script = injectStrategy.getScript()) == null) {
            return;
        }
        final String str = ";(function (window, document) {\n    function inject() {\n        " + script + "    }\n    if (document && document.head) {\n        console.log('立即Inject');\n        inject();\n    }\n    else{\n        const observerOptions = {\n            childList: true,\n            subtree: true,\n        };\n        const observer = new MutationObserver(observerFunc);\n        observer.observe(document.getRootNode(), observerOptions);\n        let isInjected = false;\n        function observerFunc() {\n            if ((!isInjected) && document && document.head) {\n                console.log('监听callback后Inject');\n                inject();\n                isInjected = true;\n                observer.disconnect();\n            }\n        }\n    }\n\n})(window, document);\n" + StringsKt.n1("\n").toString();
        if (webView != null) {
            webView.evaluateJavascript(str, new ValueCallback() { // from class: com.cloud.tmc.miniapp.base.m
                @Override // android.webkit.ValueCallback
                public final void onReceiveValue(Object obj) {
                    MiniAppH5BaseFragment.injectJSFromConfig$lambda$35$lambda$34(injectJSStrategy, str, (String) obj);
                }
            });
        }
    }

    public final void loadingUrlError() {
        ShowPageStore showPageStore;
        Stack<ShowPageData> findShowPages;
        try {
            TmcLogger.d(this.TAG, "loadingUrlError => loadingUrl: " + this.loadingUrl);
            this.backForwardStack.peek().setLoadError(true);
            App app = this.app;
            ShowPageData peek = (app == null || (showPageStore = (ShowPageStore) app.getData(ShowPageStore.class)) == null || (findShowPages = showPageStore.findShowPages()) == null) ? null : findShowPages.peek();
            if (peek == null) {
                return;
            }
            peek.setLoadFail(true);
        } catch (Throwable unused) {
        }
    }

    public final void loadingUrlFinish() {
        try {
            if (this.backForwardStack.size() <= 0) {
                TmcLogger.e(this.TAG, "loadingUrlFinish fail: backForwardStack.size = 0");
                return;
            }
            PageStatus peek = this.backForwardStack.peek();
            TmcLogger.d(this.TAG, "loadingUrlFinish => loadingUrl: " + this.loadingUrl + ", isProgressChangedTo100:" + peek.isProgressChangedTo100() + ", isPageFinished: " + peek.isPageFinished());
            if (!Intrinsics.c(this.loadingUrl, peek.getUrl())) {
                TmcLogger.e(this.TAG, "loadingUrlFinish fail: url不匹配, loadingUrl:" + this.loadingUrl + " , pageStatus.url:" + peek.getUrl());
                return;
            }
            if (peek.isLoadError()) {
                TmcLogger.e(this.TAG, "loadingUrlFinish fail: 加载页面失败, loadingUrl: " + this.loadingUrl);
                return;
            }
            if (peek.isProgressChangedTo100()) {
                return;
            }
            TmcLogger.d(this.TAG, "loadingUrlFinish => reportDate");
            peek.setProgressChangedTo100(true);
            pointTrackDrawViewEnd();
            pointTrackPageEnd(peek.getPageRandomIdByGAID());
            pointTrackAppEnd(peek.getPageRandomIdByGAID());
            FragmentActivity activity = getActivity();
            if (activity != null) {
                PrivacyUtils privacyUtils = PrivacyUtils.INSTANCE;
                App app = this.app;
                privacyUtils.updateNewUserStatus(activity, app != null ? app.getAppId() : null);
            }
        } catch (EmptyStackException e11) {
            TmcLogger.e(this.TAG, "loadingUrlFinish fail: " + e11);
        }
    }

    public final void loadingUrlStart(String pageRandomIdByGAID) {
        Intrinsics.h(pageRandomIdByGAID, "pageRandomIdByGAID");
        TmcLogger.d(this.TAG, "loadingUrlStart => loadingUrl: " + this.loadingUrl);
        Stack<PageStatus> stack = this.backForwardStack;
        PageStatus pageStatus = new PageStatus(this.loadingUrl, false, false, this.isFirstLoadHomePage, false, false, this.virtual_h5PageId, null, null, 0L, false, 1920, null);
        pageStatus.setPageRandomIdByGAID(pageRandomIdByGAID);
        stack.add(pageStatus);
    }

    public final void pointTrackAppEnd(String pageRandomIdByGAID) {
        App app;
        Bundle startParams;
        Intrinsics.h(pageRandomIdByGAID, "pageRandomIdByGAID");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "app");
            String str = ChainPoint.CHAIN_ID;
            Page page = this.page;
            bundle.putString(str, (page == null || (app = page.getApp()) == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(this.loadingUrl));
            bundle.putString(ChainPoint.REPORT_PAGE_PATH, this.loadingUrl);
            bundle.putString(TmcConstants.KEY_PAGE_RANDOM_ID, pageRandomIdByGAID);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_END, ChainPoint.app, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackAppStart() {
    }

    public final void pointTrackClear() {
        String str;
        try {
        } catch (Throwable th2) {
            TmcLogger.e("pointTrackClear fail: " + th2);
        }
        if (this.backForwardStack.size() > 1) {
            str = this.backForwardStack.peek().getPageRandomIdByGAID();
            pointTrackClear(this.loadingUrl, str);
        } else {
            TmcLogger.e(this.TAG, "pointTrackClear fail: backForwardStack.size <= 1");
            str = "";
            pointTrackClear(this.loadingUrl, str);
        }
    }

    public final void pointTrackClear(String pagePath, String pageRandomIdByGAID) {
        Bundle startParams;
        Intrinsics.h(pagePath, "pagePath");
        Intrinsics.h(pageRandomIdByGAID, "pageRandomIdByGAID");
        try {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = this.app;
            String str = null;
            String appId = app != null ? app.getAppId() : null;
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_CHAIN_CLEAR;
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "page");
            String str2 = ChainPoint.CHAIN_ID;
            App app2 = this.app;
            if (app2 != null && (startParams = app2.getStartParams()) != null) {
                str = startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE);
            }
            bundle.putString(str2, String.valueOf(str));
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(pagePath));
            bundle.putString(ChainPoint.REPORT_PAGE_PATH, pagePath);
            bundle.putString(TmcConstants.KEY_PAGE_RANDOM_ID, pageRandomIdByGAID);
            Unit unit = Unit.f67184a;
            performanceAnalyseProxy.record(appId, pointAnalyseType, "clear", bundle);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackClearNew() {
        ShowPageStore showPageStore;
        Stack<ShowPageData> findShowPages;
        ShowPageData pop;
        try {
            App app = this.app;
            if (app == null || (showPageStore = (ShowPageStore) app.getData(ShowPageStore.class)) == null || (findShowPages = showPageStore.findShowPages()) == null || (pop = findShowPages.pop()) == null) {
                return;
            }
            pointTrackClearNew(pop.getRequestUrl(), pop.getVirtual_h5PageId(), pop);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackClearNew(String pagePath, String virtual_h5PageId, ShowPageData showPageData) {
        Intrinsics.h(pagePath, "pagePath");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        Intrinsics.h(showPageData, "showPageData");
        try {
            TmcLogger.d(this.TAG_NEW, "juggist[pointTrackClearNew] -> requestUrl :" + pagePath);
            TmcLogger.d(this.TAG_NEW, "juggist[pointTrackClearNew] -> virtual_h5PageId: " + virtual_h5PageId + " ");
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.OPEN_PAGE_FAILED_REASON, this.exitType.getDes());
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(pagePath));
            bundle.putString(ChainPoint.PAGE_ID, virtual_h5PageId);
            bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
            Page page = this.page;
            bundle.putString(TmcConstants.KEY_PAGE_RANDOM_ID, String.valueOf(page != null ? page.getPageRandomIdByGAId() : null));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = this.app;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_CLEAR, "clear", bundle);
            new PageInsertState(bundle).setChainContext(showPageData.getPageChainContext());
            PageChainContext pageChainContext = showPageData.getPageChainContext();
            if (pageChainContext != null) {
                pageChainContext.destroy(bundle);
            }
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackCreateContainerEndNew(String url, String virtual_h5PageId) {
        Intrinsics.h(url, "url");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(url));
            bundle.putString(ChainPoint.PAGE_ID, virtual_h5PageId);
            bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = this.app;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_END, ChainPoint.PageCreateContainer, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_END, ChainPoint.PageCreateContainer, bundle);
            new CreateContainerEndState(bundle).setChainContext(getPageChainContext(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackCreateContainerStartNew(String url, String virtual_h5PageId) {
        Intrinsics.h(url, "url");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(url));
            bundle.putString(ChainPoint.PAGE_ID, virtual_h5PageId);
            bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = this.app;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, ChainPoint.PageCreateContainer, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, ChainPoint.PageCreateContainer, bundle);
            new CreateContainerStartState(bundle).setChainContext(getPageChainContext(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackCreateRenderEnd() {
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "page");
            String str = ChainPoint.CHAIN_ID;
            App app = this.app;
            bundle.putString(str, String.valueOf((app == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE)));
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(this.loadingUrl));
            String str2 = ChainPoint.RENDER_ID;
            Page page = this.page;
            bundle.putString(str2, page != null ? page.getPageId() : null);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_END, ChainPoint.CreateRender, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackCreateRenderEndNew(String url, String virtual_h5PageId) {
        Intrinsics.h(url, "url");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(url));
            bundle.putString(ChainPoint.PAGE_ID, virtual_h5PageId);
            bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = this.app;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_END, ChainPoint.PageCreateRender, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_END, ChainPoint.PageCreateRender, bundle);
            new CreateRenderEndState(bundle).setChainContext(getPageChainContext(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackCreateRenderStart() {
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "page");
            String str = ChainPoint.CHAIN_ID;
            App app = this.app;
            bundle.putString(str, String.valueOf((app == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE)));
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(this.loadingUrl));
            String str2 = ChainPoint.RENDER_ID;
            Page page = this.page;
            bundle.putString(str2, page != null ? page.getPageId() : null);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_START, ChainPoint.CreateRender, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackCreateRenderStartNew(String url, String virtual_h5PageId) {
        Intrinsics.h(url, "url");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(url));
            bundle.putString(ChainPoint.PAGE_ID, virtual_h5PageId);
            bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = this.app;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, ChainPoint.PageCreateRender, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, ChainPoint.PageCreateRender, bundle);
            new CreateRenderStartState(bundle).setChainContext(getPageChainContext(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackCreateWorkerEnd() {
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "page");
            String str = ChainPoint.CHAIN_ID;
            App app = this.app;
            bundle.putString(str, String.valueOf((app == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE)));
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(this.loadingUrl));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_END, ChainPoint.CreateWorker, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackCreateWorkerEndNew(String url, String virtual_h5PageId) {
        Intrinsics.h(url, "url");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(url));
            bundle.putString(ChainPoint.PAGE_ID, virtual_h5PageId);
            bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = this.app;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_END, ChainPoint.PageCreateWorker, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_END, ChainPoint.PageCreateWorker, bundle);
            new CreateWorkerEndState(bundle).setChainContext(getPageChainContext(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackCreateWorkerStart() {
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "page");
            String str = ChainPoint.CHAIN_ID;
            App app = this.app;
            bundle.putString(str, String.valueOf((app == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE)));
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(this.loadingUrl));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_START, ChainPoint.CreateWorker, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackCreateWorkerStartNew(String url, String virtual_h5PageId) {
        Intrinsics.h(url, "url");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(url));
            bundle.putString(ChainPoint.PAGE_ID, virtual_h5PageId);
            bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = this.app;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, ChainPoint.PageCreateWorker, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, ChainPoint.PageCreateWorker, bundle);
            new CreateWorkerStartState(bundle).setChainContext(getPageChainContext(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackDrawViewEnd() {
        App app;
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "page");
            String str = ChainPoint.CHAIN_ID;
            Page page = this.page;
            bundle.putString(str, (page == null || (app = page.getApp()) == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(this.loadingUrl));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_END, ChainPoint.DrawView, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackDrawViewEndForApp(String url, String virtual_h5PageId, boolean z10) {
        Intrinsics.h(url, "url");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(url));
            bundle.putString(ChainPoint.PAGE_ID, virtual_h5PageId);
            bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
            bundle.putBoolean(ChainPoint.PAGE_TYPE_LOAD_DATA, z10);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = this.app;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_END, ChainPoint.PageDrawView, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackDrawViewEndNew(String url, String virtual_h5PageId, boolean z10) {
        Intrinsics.h(url, "url");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(url));
            bundle.putString(ChainPoint.PAGE_ID, virtual_h5PageId);
            bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
            bundle.putString(ChainPoint.CHAIN_DRAW_END_TYPE, "1");
            bundle.putBoolean(ChainPoint.PAGE_TYPE_LOAD_DATA, z10);
            Page page = this.page;
            bundle.putString(TmcConstants.KEY_PAGE_RANDOM_ID, String.valueOf(page != null ? page.getPageRandomIdByGAId() : null));
            bundle.putString(TmcConstants.KEY_PAGE_UNIQUE_ID, DeviceUtil.getGAId() + "_" + virtual_h5PageId);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = this.app;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_END, ChainPoint.PageDrawView, bundle);
            App app2 = this.app;
            if (app2 != null) {
                app2.setMiniAppLoadStatus(true);
            }
            new DrawViewEndState(bundle).setChainContext(getPageChainContext(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackDrawViewFailNew(String url, String virtual_h5PageId, boolean z10) {
        Intrinsics.h(url, "url");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(url));
            bundle.putString(ChainPoint.PAGE_ID, virtual_h5PageId);
            bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
            bundle.putString(ChainPoint.OPEN_PAGE_FAILED_REASON, "网络异常");
            bundle.putBoolean(ChainPoint.PAGE_TYPE_LOAD_DATA, z10);
            new PageInsertState(bundle).setChainContext(getPageChainContext(virtual_h5PageId));
            new PageErrorState(bundle).setChainContext(getPageChainContext(virtual_h5PageId));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = this.app;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_FAIL, "pageOpenFail", bundle);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackDrawViewStart() {
        App app;
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "page");
            String str = ChainPoint.CHAIN_ID;
            Page page = this.page;
            bundle.putString(str, String.valueOf((page == null || (app = page.getApp()) == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE)));
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(this.loadingUrl));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_START, ChainPoint.DrawView, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackDrawViewStartNew(String url, String virtual_h5PageId) {
        Intrinsics.h(url, "url");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(url));
            bundle.putString(ChainPoint.PAGE_ID, virtual_h5PageId);
            bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = this.app;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, ChainPoint.PageDrawView, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, ChainPoint.PageDrawView, bundle);
            new DrawViewStartState(bundle).setChainContext(getPageChainContext(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackLoadRenderFrameworkEnd() {
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "page");
            String str = ChainPoint.CHAIN_ID;
            App app = this.app;
            bundle.putString(str, String.valueOf((app == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE)));
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(this.loadingUrl));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_END, ChainPoint.LoadRenderFramework, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackLoadRenderFrameworkEndNew(String url, String virtual_h5PageId) {
        Intrinsics.h(url, "url");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(url));
            bundle.putString(ChainPoint.PAGE_ID, virtual_h5PageId);
            bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = this.app;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_END, ChainPoint.PageLoadRenderFramework, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_END, ChainPoint.PageLoadRenderFramework, bundle);
            new LoadRenderFrameworkEndState(bundle).setChainContext(getPageChainContext(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackLoadRenderFrameworkStart() {
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "page");
            String str = ChainPoint.CHAIN_ID;
            App app = this.app;
            bundle.putString(str, String.valueOf((app == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE)));
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(this.loadingUrl));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_START, ChainPoint.LoadRenderFramework, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackLoadRenderFrameworkStartNew(String url, String virtual_h5PageId) {
        Intrinsics.h(url, "url");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(url));
            bundle.putString(ChainPoint.PAGE_ID, virtual_h5PageId);
            bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = this.app;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, ChainPoint.PageLoadRenderFramework, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, ChainPoint.PageLoadRenderFramework, bundle);
            new LoadRenderFrameworkStartState(bundle).setChainContext(getPageChainContext(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackLoadWorkerFrameworkEnd() {
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "page");
            String str = ChainPoint.CHAIN_ID;
            App app = this.app;
            bundle.putString(str, String.valueOf((app == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE)));
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(this.loadingUrl));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_END, ChainPoint.LoadWorkerFramework, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackLoadWorkerFrameworkEndNew(String url, String virtual_h5PageId) {
        Intrinsics.h(url, "url");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(url));
            bundle.putString(ChainPoint.PAGE_ID, virtual_h5PageId);
            bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = this.app;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_END, ChainPoint.PageLoadWorkerFramework, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_END, ChainPoint.PageLoadWorkerFramework, bundle);
            new LoadWorkerFrameworkEndState(bundle).setChainContext(getPageChainContext(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackLoadWorkerFrameworkStart() {
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "page");
            String str = ChainPoint.CHAIN_ID;
            App app = this.app;
            bundle.putString(str, String.valueOf((app == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE)));
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(this.loadingUrl));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_START, ChainPoint.LoadWorkerFramework, bundle);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackLoadWorkerFrameworkStartNew(String url, String virtual_h5PageId) {
        Intrinsics.h(url, "url");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(url));
            bundle.putString(ChainPoint.PAGE_ID, virtual_h5PageId);
            bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = this.app;
            performanceAnalyseProxy.record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, ChainPoint.PageLoadWorkerFramework, bundle);
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy2.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, ChainPoint.PageLoadWorkerFramework, bundle);
            new LoadWorkerFrameworkStartState(bundle).setChainContext(getPageChainContext(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackMidEndNew(String url, String virtual_h5PageId) {
        Intrinsics.h(url, "url");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.PAGE_PATH, url);
            bundle.putString(ChainPoint.PAGE_ID, virtual_h5PageId);
            bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
            Page page = this.page;
            bundle.putString(TmcConstants.KEY_PAGE_RANDOM_ID, String.valueOf(page != null ? page.getPageRandomIdByGAId() : null));
            bundle.putString(TmcConstants.KEY_PAGE_UNIQUE_ID, DeviceUtil.getGAId() + "_" + virtual_h5PageId);
            new ChainMidEndState(bundle).setChainContext(getPageChainContext(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackMidStartNew(String url, String virtual_h5PageId) {
        Intrinsics.h(url, "url");
        Intrinsics.h(virtual_h5PageId, "virtual_h5PageId");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.PAGE_PATH, url);
            bundle.putString(ChainPoint.PAGE_ID, virtual_h5PageId);
            bundle.putString(ChainPoint.PAGE_CATEGOR_TYPE, "2");
            new ChainMidStartState(bundle).setChainContext(getPageChainContext(virtual_h5PageId));
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackOnPageFinished(String url) {
        Bundle startParams;
        Intrinsics.h(url, "url");
        try {
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app = this.app;
            String str = null;
            String appId = app != null ? app.getAppId() : null;
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_H5_PAGE_ONFINISHED;
            Bundle bundle = new Bundle();
            String str2 = ChainPoint.CHAIN_ID;
            App app2 = this.app;
            if (app2 != null && (startParams = app2.getStartParams()) != null) {
                str = startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE);
            }
            bundle.putString(str2, String.valueOf(str));
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(url));
            Unit unit = Unit.f67184a;
            performanceAnalyseProxy.record(appId, pointAnalyseType, "", bundle);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackPageEnd(String pageRandomIdByGAID) {
        App app;
        Bundle startParams;
        Intrinsics.h(pageRandomIdByGAID, "pageRandomIdByGAID");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "page");
            Page page = this.page;
            String valueOf = String.valueOf((page == null || (app = page.getApp()) == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
            bundle.putString(ChainPoint.CHAIN_ID, valueOf);
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(this.loadingUrl));
            bundle.putString(ChainPoint.REPORT_PAGE_PATH, this.loadingUrl);
            bundle.putString(TmcConstants.KEY_PAGE_RANDOM_ID, pageRandomIdByGAID);
            TrackPointUtils.pageRouteTrackEnd(this.page, this.loadingUrl);
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_END, ChainPoint.page, bundle);
            App app3 = this.app;
            TrackPointUtils.pageRouteTrackEnd(app3 != null ? app3.getAppId() : null, valueOf, this.loadingUrl);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackPageFinishedNew(WebView webView, String str) {
        ShowPageStore showPageStore;
        try {
            TmcLogger.d(this.TAG_NEW, "juggist[pointTrackPageFinishedNew] -> originalUrl:" + (webView != null ? webView.getOriginalUrl() : null));
            TmcLogger.d(this.TAG_NEW, "juggist[pointTrackPageFinishedNew] -> url        :" + (webView != null ? webView.getUrl() : null));
            TmcLogger.d(this.TAG_NEW, "juggist[pointTrackPageFinishedNew] -> requestUrl :" + str);
            App app = this.app;
            if (app != null && (showPageStore = (ShowPageStore) app.getData(ShowPageStore.class)) != null) {
                Stack<ShowPageData> findShowPages = showPageStore.findShowPages();
                if (findShowPages.size() == 0) {
                    TmcLogger.d(this.TAG_NEW, "juggist[pointTrackPageFinishedNew] -> showPages.size == 0 return");
                    return;
                }
                ShowPageData peek = findShowPages.peek();
                if (peek == null) {
                    return;
                }
                TmcLogger.d(this.TAG_NEW, "juggist[pointTrackPageFinishedNew] -> showPages:" + peek);
                if (!Intrinsics.c(peek.getRequestUrl(), str)) {
                    TmcLogger.d(this.TAG_NEW, "juggist[pointTrackPageFinishedNew] -> showPage.requestUrl != url return");
                } else {
                    if (peek.getStatus().getType() != ShowPageStatus.PAGE_PROGRESS100.getType()) {
                        TmcLogger.d(this.TAG_NEW, "juggist[pointTrackPageFinishedNew] -> showPage.status != ShowPageStatus.PAGE_PROGRESS100 return");
                        return;
                    }
                    TmcLogger.d(this.TAG_NEW, "所有资源渲染结束");
                    peek.setStatus(ShowPageStatus.PAGE_FINISHED);
                    pointTrackOnPageFinished(str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackPageStart() {
        App app;
        Bundle startParams;
        try {
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "page");
            Page page = this.page;
            String valueOf = String.valueOf((page == null || (app = page.getApp()) == null || (startParams = app.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
            bundle.putString(ChainPoint.CHAIN_ID, valueOf);
            bundle.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(this.loadingUrl));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            App app2 = this.app;
            performanceAnalyseProxy.record(app2 != null ? app2.getAppId() : null, PointAnalyseType.POINT_CHAIN_START, ChainPoint.page, bundle);
            App app3 = this.app;
            String appId = app3 != null ? app3.getAppId() : null;
            String str = this.loadingUrl;
            Page page2 = this.page;
            TrackPointUtils.pageRouteTrackStart(appId, valueOf, str, TmcConstants.NAVIGATION_SHOULD_OVERRIDE_URL, page2 != null ? page2.getPageRandomIdByGAId() : null);
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackProgressChanged100New(WebView webView) {
        ShowPageStore showPageStore;
        try {
            TmcLogger.d(this.TAG_NEW, "juggist[pointTrackProgressChanged100New] -> webView.originalUrl:" + (webView != null ? webView.getOriginalUrl() : null));
            TmcLogger.d(this.TAG_NEW, "juggist[pointTrackProgressChanged100New] -> webView.url:" + (webView != null ? webView.getUrl() : null));
            App app = this.app;
            if (app != null && (showPageStore = (ShowPageStore) app.getData(ShowPageStore.class)) != null) {
                Stack<ShowPageData> findShowPages = showPageStore.findShowPages();
                if (findShowPages.size() == 0) {
                    TmcLogger.d(this.TAG_NEW, "juggist[pointTrackProgressChanged100New] -> showPages.size == 0 return");
                    return;
                }
                ShowPageData peek = findShowPages.peek();
                if (peek == null) {
                    return;
                }
                TmcLogger.d(this.TAG_NEW, "juggist[pointTrackProgressChanged100New] -> originalUrl:" + peek.getOriginalUrl());
                TmcLogger.d(this.TAG_NEW, "juggist[pointTrackProgressChanged100New] -> url        :" + peek.getUrl());
                TmcLogger.d(this.TAG_NEW, "juggist[pointTrackProgressChanged100New] -> requestUrl :" + peek.getRequestUrl());
                TmcLogger.d(this.TAG_NEW, "juggist[pointTrackProgressChanged100New] -> showPages:" + peek);
                if (peek.getStatus().getType() != ShowPageStatus.PAGE_START.getType()) {
                    TmcLogger.d(this.TAG_NEW, "juggist[pointTrackProgressChanged100New] -> showPage.status != ShowPageStatus.PAGE_START return");
                    return;
                }
                boolean z10 = true;
                TmcLogger.d(this.TAG_NEW, "静态资源渲染结束,渲染成功结果:" + (!peek.getLoadFail()));
                peek.setStatus(ShowPageStatus.PAGE_PROGRESS100);
                if (this.trackPointLoadData) {
                    this.trackPointLoadData = false;
                } else {
                    z10 = false;
                }
                if (peek.getLoadFail()) {
                    pointTrackDrawViewFailNew(peek.getRequestUrl(), peek.getVirtual_h5PageId(), z10);
                    return;
                }
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    PrivacyUtils privacyUtils = PrivacyUtils.INSTANCE;
                    App app2 = this.app;
                    privacyUtils.updateNewUserStatus(activity, app2 != null ? app2.getAppId() : null);
                }
                pointTrackDrawViewEndNew(peek.getRequestUrl(), peek.getVirtual_h5PageId(), z10);
            }
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackProgressChangedNew(WebView webView, int i11) {
        ShowPageStore showPageStore;
        if (webView == null) {
            return;
        }
        try {
            TmcLogger.d(this.TAG_NEW, "juggist[pointTrackProgressChangedNew] -> webView.originalUrl:" + webView.getOriginalUrl());
            TmcLogger.d(this.TAG_NEW, "juggist[pointTrackProgressChangedNew] -> webView.url:" + webView.getUrl());
            TmcLogger.d(this.TAG_NEW, "juggist[pointTrackProgressChangedNew] -> webView.progress:" + i11);
            App app = this.app;
            if (app != null && (showPageStore = (ShowPageStore) app.getData(ShowPageStore.class)) != null) {
                Stack<ShowPageData> findShowPages = showPageStore.findShowPages();
                if (findShowPages.size() == 0) {
                    TmcLogger.d(this.TAG_NEW, "juggist[pointTrackProgressChangedNew] -> showPages.size == 0 return");
                    return;
                }
                ShowPageData peek = findShowPages.peek();
                if (peek == null) {
                    return;
                }
                TmcLogger.d(this.TAG_NEW, "juggist[pointTrackProgressChangedNew] -> originalUrl:" + peek.getOriginalUrl());
                TmcLogger.d(this.TAG_NEW, "juggist[pointTrackProgressChangedNew] -> url        :" + peek.getUrl());
                TmcLogger.d(this.TAG_NEW, "juggist[pointTrackProgressChangedNew] -> requestUrl :" + peek.getRequestUrl());
                TmcLogger.d(this.TAG_NEW, "juggist[pointTrackProgressChangedNew] -> showPage:" + peek);
                if (peek.getStatus() == ShowPageStatus.PAGE_START) {
                    TmcLogger.d(this.TAG_NEW, "juggist[pointTrackProgressChangedNew] -> 修改showPage的originalUrl和url");
                    peek.setOriginalUrl(String.valueOf(webView.getOriginalUrl()));
                    peek.setUrl(String.valueOf(webView.getUrl()));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackShouldOverrideUrlLoadingNew(WebView webView, WebResourceRequest webResourceRequest) {
        boolean isRedirect = (Build.VERSION.SDK_INT < 24 || webResourceRequest == null) ? false : webResourceRequest.isRedirect();
        TmcLogger.d(this.TAG_NEW, "juggist[pointTrackShouldOverrideUrlLoadingNew] -> originalUrl:" + (webView != null ? webView.getOriginalUrl() : null));
        TmcLogger.d(this.TAG_NEW, "juggist[pointTrackShouldOverrideUrlLoadingNew] -> url        :" + (webView != null ? webView.getUrl() : null));
        TmcLogger.d(this.TAG_NEW, "juggist[pointTrackShouldOverrideUrlLoadingNew] -> requestUrl :" + (webResourceRequest != null ? webResourceRequest.getUrl() : null) + ", isRedirect:" + isRedirect);
        String currentOriginalUrl = getCurrentOriginalUrl(webView);
        if (currentOriginalUrl == null) {
            currentOriginalUrl = "";
        }
        String currentUrl = getCurrentUrl(webView);
        pointTrackShouldOverrideUrlLoadingNew(currentOriginalUrl, currentUrl != null ? currentUrl : "", String.valueOf(webResourceRequest != null ? webResourceRequest.getUrl() : null), isRedirect);
    }

    public final void pointTrackShouldOverrideUrlLoadingNew(String originalUrl, String url, String requestUrl, boolean z10) {
        Stack<ShowPageData> findShowPages;
        Intrinsics.h(originalUrl, "originalUrl");
        Intrinsics.h(url, "url");
        Intrinsics.h(requestUrl, "requestUrl");
        try {
            App app = this.app;
            ShowPageStore showPageStore = app != null ? (ShowPageStore) app.getData(ShowPageStore.class) : null;
            if (showPageStore == null) {
                App app2 = this.app;
                if (app2 != null) {
                    app2.setData(ShowPageStore.class, new ShowPageStore());
                }
                App app3 = this.app;
                showPageStore = app3 != null ? (ShowPageStore) app3.getData(ShowPageStore.class) : null;
            }
            if (showPageStore != null && (findShowPages = showPageStore.findShowPages()) != null) {
                if (findShowPages.size() == 0) {
                    TmcLogger.d(this.TAG_NEW, "juggist[pointTrackShouldOverrideUrlLoadingNew] -> showPages.size == 0 return");
                    return;
                }
                ShowPageData peek = findShowPages.peek();
                Intrinsics.g(peek, "showPages.peek()");
                ShowPageData showPageData = peek;
                TmcLogger.d(this.TAG_NEW, "juggist[pointTrackShouldOverrideUrlLoadingNew] -> showPages:" + showPageData);
                if (Intrinsics.c(showPageData.getRequestUrl(), requestUrl)) {
                    TmcLogger.d(this.TAG_NEW, "juggist[pointTrackShouldOverrideUrlLoadingNew] -> currentPage.requestUrl == requestUrl return");
                    return;
                }
                int type = showPageData.getStatus().getType();
                ShowPageStatus showPageStatus = ShowPageStatus.SHOULDOVERRIDEURKLOADING;
                if (type == showPageStatus.getType()) {
                    TmcLogger.d(this.TAG_NEW, "juggist[pointTrackShouldOverrideUrlLoadingNew] -> currentPage.status == ShowPageStatus.SHOULDOVERRIDEURKLOADING pointTrackClearNew");
                    ShowPageData pop = findShowPages.pop();
                    if (pop != null) {
                        setExitType(TmcFragment.ExitType.NEW_PAGE_ENTER);
                        pointTrackClearNew(pop.getRequestUrl(), pop.getVirtual_h5PageId(), pop);
                    }
                }
                Page page = this.page;
                String pageId = page != null ? page.getPageId() : null;
                String str = pageId + "_" + this.h5PageId.addAndGet(1);
                TmcLogger.d(this.TAG_NEW, "Add New Page -> requestUrl:" + requestUrl);
                PageChainContext pageChainContext = new PageChainContext();
                App app4 = this.app;
                pageChainContext.setAppChainContext(app4 != null ? app4.getAppChainContext() : null);
                Unit unit = Unit.f67184a;
                findShowPages.add(new ShowPageData(originalUrl, url, requestUrl, str, showPageStatus, false, "", pageChainContext, false, null, null, 0L, 3840, null));
                addNewPageTrack(requestUrl, str, false);
            }
        } catch (Throwable unused) {
        }
    }

    public final void pointTrackStartNew(WebView webView, String str) {
        ShowPageStore showPageStore;
        try {
            TmcLogger.d(this.TAG_NEW, "juggist[pointTrackPageStepStart] -> originalUrl:" + (webView != null ? webView.getOriginalUrl() : null));
            TmcLogger.d(this.TAG_NEW, "juggist[pointTrackPageStepStart] -> url        :" + (webView != null ? webView.getUrl() : null));
            TmcLogger.d(this.TAG_NEW, "juggist[pointTrackPageStepStart] -> requestUrl :" + str);
            App app = this.app;
            if (app != null && (showPageStore = (ShowPageStore) app.getData(ShowPageStore.class)) != null) {
                Stack<ShowPageData> findShowPages = showPageStore.findShowPages();
                if (findShowPages.size() == 0) {
                    TmcLogger.d(this.TAG_NEW, "juggist[pointTrackPageStepStart] -> showPages.size == 0 return");
                    return;
                }
                ShowPageData peek = findShowPages.peek();
                if (peek == null) {
                    return;
                }
                TmcLogger.d(this.TAG_NEW, "juggist[pointTrackPageStepStart] -> showPages:" + peek);
                if (!Intrinsics.c(peek.getRequestUrl(), str)) {
                    TmcLogger.d(this.TAG_NEW, "juggist[pointTrackPageStepStart] -> showPage.requestUrl != url return");
                    return;
                }
                if (peek.getStatus().getType() == ShowPageStatus.SHOULDOVERRIDEURKLOADING.getType() || peek.getStatus().getType() == ShowPageStatus.PAGE_START.getType()) {
                    TmcLogger.d(this.TAG_NEW, "juggist[pointTrackPageStepStart] -> change showPage.status = ShowPageStatus.PAGE_START");
                    peek.setStatus(ShowPageStatus.PAGE_START);
                    String currentOriginalUrl = getCurrentOriginalUrl(webView);
                    String str2 = "";
                    if (currentOriginalUrl == null) {
                        currentOriginalUrl = "";
                    }
                    peek.setOriginalUrl(currentOriginalUrl);
                    String currentUrl = getCurrentUrl(webView);
                    if (currentUrl != null) {
                        str2 = currentUrl;
                    }
                    peek.setUrl(str2);
                    peek.setRequestUrl(str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void redirect(String webviewUrl, String webResourceRequestUrl) {
        Intrinsics.h(webviewUrl, "webviewUrl");
        Intrinsics.h(webResourceRequestUrl, "webResourceRequestUrl");
        try {
            TmcLogger.d(this.TAG, "redirect => webviewUrl: " + webviewUrl + ", webResourceRequestUrl: " + webResourceRequestUrl);
            URL url = new URL(webviewUrl);
            URL url2 = new URL(webResourceRequestUrl);
            String str = url.getHost() + url.getPath();
            String str2 = url2.getHost() + url2.getPath();
            TmcLogger.d(this.TAG, "webviewURLCombine:" + str);
            TmcLogger.d(this.TAG, "webResourceRequestURLCombine:" + str2);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (Intrinsics.c(str, str2)) {
                    TmcLogger.d(this.TAG, "redirect  进入backForward栈 => webviewUrl: " + webviewUrl + ", webResourceRequestUrl: " + webResourceRequestUrl);
                    this.backForwardStack.peek().setCanGoBack(true);
                    return;
                }
                TmcLogger.d(this.TAG, "redirect  开始加载 => webviewUrl: " + webviewUrl + ", webResourceRequestUrl: " + webResourceRequestUrl);
                Page page = this.page;
                String pageId = page != null ? page.getPageId() : null;
                setLoadingUrl(webResourceRequestUrl, false, pageId + "_" + this.h5PageId.addAndGet(1));
                Page page2 = this.page;
                String createPageRandomIdByGAID = page2 != null ? page2.createPageRandomIdByGAID() : null;
                if (createPageRandomIdByGAID == null) {
                    createPageRandomIdByGAID = "null";
                }
                TrackPointUtils.openPageActionTrack(this.page, TmcConstants.NAVIGATION_SHOULD_OVERRIDE_URL, this.loadingUrl, createPageRandomIdByGAID);
                loadingUrlStart(createPageRandomIdByGAID);
                pointTrackPageStart();
                pointTrackCreateRenderStart();
                pointTrackCreateRenderEnd();
                pointTrackLoadRenderFrameworkStart();
                pointTrackLoadRenderFrameworkEnd();
                pointTrackCreateWorkerStart();
                pointTrackCreateWorkerEnd();
                pointTrackLoadWorkerFrameworkStart();
                pointTrackLoadWorkerFrameworkEnd();
                pointTrackDrawViewStart();
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean redirectCanGoBack(WebView webView) {
        TmcLogger.d(this.TAG_REDIRECT, "redirectCanGoBack => originalUrl:" + getCurrentOriginalUrl(webView) + " , url:" + getCurrentUrl(webView));
        if (webView != null) {
            try {
                if (webView.canGoBack()) {
                    String pop = this.pageStartStack.pop();
                    if (pop == null) {
                        return false;
                    }
                    TmcLogger.d(this.TAG_REDIRECT, "exitPage:" + pop);
                    WebBackForwardList copyBackForwardList = webView.copyBackForwardList();
                    Intrinsics.g(copyBackForwardList, "webView.copyBackForwardList()");
                    TmcLogger.d(this.TAG_REDIRECT, "WebBackForwardList.size:" + copyBackForwardList.getSize());
                    int i11 = -1;
                    int i12 = -1;
                    for (int size = copyBackForwardList.getSize() - 1; -1 < size; size--) {
                        TmcLogger.d(this.TAG_REDIRECT, "WebBackForwardList(" + size + ") => originalUrl:" + copyBackForwardList.getItemAtIndex(size).getOriginalUrl() + " , url:" + copyBackForwardList.getItemAtIndex(size).getUrl());
                        if (Intrinsics.c(copyBackForwardList.getItemAtIndex(size).getUrl(), pop)) {
                            if (i12 == -1) {
                                i12 = size;
                            }
                            i11 = size;
                        }
                    }
                    String findPrePage = findPrePage();
                    if (findPrePage == null) {
                        return false;
                    }
                    TmcLogger.d(this.TAG_REDIRECT, "prePage:" + findPrePage);
                    int i13 = 1;
                    WebHistoryItem webHistoryItem = null;
                    for (int i14 = i11 + (-1); -1 < i14; i14--) {
                        WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(i14);
                        if (Intrinsics.c(findPrePage, itemAtIndex.getUrl())) {
                            i13 = i14;
                            webHistoryItem = itemAtIndex;
                        }
                    }
                    if (webHistoryItem != null) {
                        int i15 = i13 - i11;
                        webView.goBackOrForward(i15);
                        goBackNew$default(this, null, 1, null);
                        goBack();
                        TmcLogger.d(this.TAG_REDIRECT, "goBackOrForward(" + i15 + ")");
                        return true;
                    }
                }
            } catch (Throwable th2) {
                TmcLogger.e(this.TAG_REDIRECT, "redirectCanGoBack fail:" + th2);
            }
        }
        TmcLogger.d(this.TAG_REDIRECT, "redirectCanGoBack -> 直接退出");
        return false;
    }

    public final void redirectPageStarted(WebView webView, String str) {
        TmcLogger.d(this.TAG_REDIRECT, "redirectPageStarted ==================>");
        try {
            TmcLogger.d(this.TAG_REDIRECT, "webView.original:" + getCurrentOriginalUrl(webView));
            TmcLogger.d(this.TAG_REDIRECT, "webView.url:" + getCurrentUrl(webView));
            TmcLogger.d(this.TAG_REDIRECT, "url:" + str);
            String currentUrl = getCurrentUrl(webView);
            if (currentUrl != null) {
                this.pageStartStack.add(currentUrl);
            }
        } catch (Throwable unused) {
        }
        TmcLogger.d(this.TAG_REDIRECT, "redirectPageStarted <==================");
    }

    public final void redirectShouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        boolean isRedirect;
        String currentUrl;
        TmcLogger.d(this.TAG_REDIRECT, "redirectShouldOverrideUrlLoading ==================>");
        try {
            if (Build.VERSION.SDK_INT >= 24 && webResourceRequest != null) {
                isRedirect = webResourceRequest.isRedirect();
                if (isRedirect && (currentUrl = getCurrentUrl(webView)) != null) {
                    this.redirectUrls.add(currentUrl);
                    TmcLogger.d(this.TAG_REDIRECT, "webview.original:" + getCurrentOriginalUrl(webView));
                    TmcLogger.d(this.TAG_REDIRECT, "webview.url:" + currentUrl);
                    TmcLogger.d(this.TAG_REDIRECT, "request.url:" + (webResourceRequest != null ? webResourceRequest.getUrl() : null));
                }
            }
        } catch (Throwable unused) {
        }
        TmcLogger.d(this.TAG_REDIRECT, "redirectShouldOverrideUrlLoading <==================");
    }

    public final void setH5EventCenter(IEventCenter iEventCenter) {
        this.h5EventCenter = iEventCenter;
    }

    public final void setH5OnPageFinishedEventCenter(IEventSubscriber iEventSubscriber) {
        this.h5OnPageFinishedEventCenter = iEventSubscriber;
    }

    public final void setLoadingUrl(String loadingUrl, boolean z10, String virtualH5PageId) {
        Intrinsics.h(loadingUrl, "loadingUrl");
        Intrinsics.h(virtualH5PageId, "virtualH5PageId");
        TmcLogger.d(this.TAG, "setLoadingUrl => loadingUrl: " + loadingUrl + " , isFirstLoadHomePage: " + z10 + ", virtual_h5PageId:" + this.virtual_h5PageId);
        this.loadingUrl = loadingUrl;
        this.isFirstLoadHomePage = z10;
        this.virtual_h5PageId = virtualH5PageId;
    }

    public final void setTrackPointLoadData(boolean z10) {
        this.trackPointLoadData = z10;
    }

    public final void updateDomContentLoaded() {
        App app;
        App app2;
        Bundle startParams;
        App app3;
        App app4;
        Bundle startParams2;
        try {
            TmcLogger.d(this.TAG, "updateDomContentLoaded");
            if (this.backForwardStack.size() <= 0) {
                TmcLogger.e(this.TAG, "updateDomContentLoaded fail: backForwardStack.size = 0");
                return;
            }
            PageStatus peek = this.backForwardStack.peek();
            TmcLogger.d(this.TAG, "updateDomContentLoaded => loadingUrl: " + this.loadingUrl + ", isProgressChangedTo100:" + peek.isProgressChangedTo100() + ", isPageFinished: " + peek.isPageFinished());
            if (!Intrinsics.c(this.loadingUrl, peek.getUrl())) {
                TmcLogger.e(this.TAG, "updateDomContentLoaded fail: url不匹配, loadingUrl:" + this.loadingUrl + " , pageStatus.url:" + peek.getUrl());
                return;
            }
            if (peek.isLoadError()) {
                TmcLogger.e(this.TAG, "updateDomContentLoaded fail: 加载页面失败, loadingUrl: " + this.loadingUrl);
                return;
            }
            if (peek.isDomContentLoaded()) {
                return;
            }
            peek.setDomContentLoaded(true);
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "app");
            String str = ChainPoint.CHAIN_ID;
            Page page = this.page;
            String str2 = null;
            bundle.putString(str, (page == null || (app4 = page.getApp()) == null || (startParams2 = app4.getStartParams()) == null) ? null : startParams2.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
            bundle.putString(ChainPoint.APP_DOMCONTENTLOADED_STATUS, String.valueOf(peek.isDomContentLoaded()));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            Page page2 = this.page;
            String appId = (page2 == null || (app3 = page2.getApp()) == null) ? null : app3.getAppId();
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_CHAIN_INSERT;
            performanceAnalyseProxy.record(appId, pointAnalyseType, "", bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putString(ChainPoint.TYPE, "page");
            String str3 = ChainPoint.CHAIN_ID;
            Page page3 = this.page;
            bundle2.putString(str3, (page3 == null || (app2 = page3.getApp()) == null || (startParams = app2.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
            bundle2.putString(ChainPoint.PAGE_DOMCONTENTLOADED_STATUS, String.valueOf(peek.isDomContentLoaded()));
            bundle2.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(peek.getUrl()));
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            Page page4 = this.page;
            if (page4 != null && (app = page4.getApp()) != null) {
                str2 = app.getAppId();
            }
            performanceAnalyseProxy2.record(str2, pointAnalyseType, "", bundle2);
            TmcLogger.d(this.TAG, "updateDomContentLoaded report");
        } catch (EmptyStackException e11) {
            TmcLogger.e(this.TAG, "updateDomContentLoaded fail: " + e11);
        }
    }

    public final void updateProgressStep(ProgressStep step) {
        App app;
        App app2;
        Bundle startParams;
        App app3;
        App app4;
        Bundle startParams2;
        Intrinsics.h(step, "step");
        try {
            if (this.backForwardStack.size() <= 0) {
                TmcLogger.e(this.TAG, "updateProgressStep fail: backForwardStack.size = 0");
                return;
            }
            PageStatus peek = this.backForwardStack.peek();
            TmcLogger.d(this.TAG, "updateProgressStep => loadingUrl: " + this.loadingUrl + ", isProgressChangedTo100:" + peek.isProgressChangedTo100() + ", isPageFinished: " + peek.isPageFinished());
            if (!Intrinsics.c(this.loadingUrl, peek.getUrl())) {
                TmcLogger.e(this.TAG, "updateProgressStep fail: url不匹配, loadingUrl:" + this.loadingUrl + " , pageStatus.url:" + peek.getUrl());
                return;
            }
            if (peek.isLoadError()) {
                TmcLogger.e(this.TAG, "updateProgressStep fail: 加载页面失败, loadingUrl: " + this.loadingUrl);
                return;
            }
            if (peek.getProgressCurrentStep() == null) {
                peek.setProgressStartTime(System.currentTimeMillis());
            }
            peek.setProgressCurrentStep(step);
            int i11 = WhenMappings.$EnumSwitchMapping$0[step.ordinal()];
            if (i11 == 2) {
                ConcurrentHashMap<Integer, Long> progressCollectList = peek.getProgressCollectList();
                ProgressStep progressStep = ProgressStep.STEP_30;
                if (!progressCollectList.containsKey(Integer.valueOf(progressStep.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
            } else if (i11 == 3) {
                ConcurrentHashMap<Integer, Long> progressCollectList2 = peek.getProgressCollectList();
                ProgressStep progressStep2 = ProgressStep.STEP_30;
                if (!progressCollectList2.containsKey(Integer.valueOf(progressStep2.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep2.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
                ConcurrentHashMap<Integer, Long> progressCollectList3 = peek.getProgressCollectList();
                ProgressStep progressStep3 = ProgressStep.STEP_50;
                if (!progressCollectList3.containsKey(Integer.valueOf(progressStep3.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep3.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
            } else if (i11 == 4) {
                ConcurrentHashMap<Integer, Long> progressCollectList4 = peek.getProgressCollectList();
                ProgressStep progressStep4 = ProgressStep.STEP_30;
                if (!progressCollectList4.containsKey(Integer.valueOf(progressStep4.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep4.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
                ConcurrentHashMap<Integer, Long> progressCollectList5 = peek.getProgressCollectList();
                ProgressStep progressStep5 = ProgressStep.STEP_50;
                if (!progressCollectList5.containsKey(Integer.valueOf(progressStep5.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep5.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
                ConcurrentHashMap<Integer, Long> progressCollectList6 = peek.getProgressCollectList();
                ProgressStep progressStep6 = ProgressStep.STEP_70;
                if (!progressCollectList6.containsKey(Integer.valueOf(progressStep6.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep6.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
            } else if (i11 == 5) {
                ConcurrentHashMap<Integer, Long> progressCollectList7 = peek.getProgressCollectList();
                ProgressStep progressStep7 = ProgressStep.STEP_30;
                if (!progressCollectList7.containsKey(Integer.valueOf(progressStep7.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep7.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
                ConcurrentHashMap<Integer, Long> progressCollectList8 = peek.getProgressCollectList();
                ProgressStep progressStep8 = ProgressStep.STEP_50;
                if (!progressCollectList8.containsKey(Integer.valueOf(progressStep8.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep8.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
                ConcurrentHashMap<Integer, Long> progressCollectList9 = peek.getProgressCollectList();
                ProgressStep progressStep9 = ProgressStep.STEP_70;
                if (!progressCollectList9.containsKey(Integer.valueOf(progressStep9.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep9.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
                ConcurrentHashMap<Integer, Long> progressCollectList10 = peek.getProgressCollectList();
                ProgressStep progressStep10 = ProgressStep.STEP_100;
                if (!progressCollectList10.containsKey(Integer.valueOf(progressStep10.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep10.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.TYPE, "app");
            String str = ChainPoint.CHAIN_ID;
            Page page = this.page;
            String str2 = null;
            bundle.putString(str, (page == null || (app4 = page.getApp()) == null || (startParams2 = app4.getStartParams()) == null) ? null : startParams2.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
            bundle.putString(ChainPoint.APP_H5_PROGRESS_STATUS, GsonUtils.toJson(peek.getProgressCollectList()));
            PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            Page page2 = this.page;
            String appId = (page2 == null || (app3 = page2.getApp()) == null) ? null : app3.getAppId();
            PointAnalyseType pointAnalyseType = PointAnalyseType.POINT_CHAIN_INSERT;
            performanceAnalyseProxy.record(appId, pointAnalyseType, "", bundle);
            Bundle bundle2 = new Bundle();
            bundle2.putString(ChainPoint.TYPE, "page");
            String str3 = ChainPoint.CHAIN_ID;
            Page page3 = this.page;
            bundle2.putString(str3, (page3 == null || (app2 = page3.getApp()) == null || (startParams = app2.getStartParams()) == null) ? null : startParams.getString(TmcConstants.EXTRA_UNIQUE_CHAIN_ID, TmcConstants.COLD_OPEN_TYPE));
            bundle2.putString(ChainPoint.PAGE_H5_PROGRESS_STATUS, GsonUtils.toJson(peek.getProgressCollectList()));
            bundle2.putString(ChainPoint.PAGE_PATH, getReportOriginalUrl(peek.getUrl()));
            PerformanceAnalyseProxy performanceAnalyseProxy2 = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
            Page page4 = this.page;
            if (page4 != null && (app = page4.getApp()) != null) {
                str2 = app.getAppId();
            }
            performanceAnalyseProxy2.record(str2, pointAnalyseType, "", bundle2);
            TmcLogger.d(this.TAG, "updateProgressStep: progressCurrentStep=" + peek.getProgressCurrentStep() + ", progressCollectList=" + peek.getProgressCollectList());
        } catch (EmptyStackException e11) {
            TmcLogger.e(this.TAG, "updateProgressStep fail: " + e11);
        }
    }

    public final void updateProgressStepNew(ProgressStep step) {
        ShowPageStore showPageStore;
        Stack<ShowPageData> findShowPages;
        Intrinsics.h(step, "step");
        try {
            App app = this.app;
            ShowPageData peek = (app == null || (showPageStore = (ShowPageStore) app.getData(ShowPageStore.class)) == null || (findShowPages = showPageStore.findShowPages()) == null) ? null : findShowPages.peek();
            if (peek == null) {
                return;
            }
            TmcLogger.d(this.TAG, "updateProgressStep => status:" + peek.getStatus());
            if (peek.getLoadFail()) {
                TmcLogger.e(this.TAG, "updateProgressStep fail: 加载页面失败, loadingUrl: " + peek.getRequestUrl());
                return;
            }
            if (peek.getProgressCurrentStep() == null) {
                peek.setProgressStartTime(System.currentTimeMillis());
            }
            peek.setProgressCurrentStep(step);
            int i11 = WhenMappings.$EnumSwitchMapping$0[step.ordinal()];
            if (i11 == 2) {
                ConcurrentHashMap<Integer, Long> progressCollectList = peek.getProgressCollectList();
                ProgressStep progressStep = ProgressStep.STEP_30;
                if (!progressCollectList.containsKey(Integer.valueOf(progressStep.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
            } else if (i11 == 3) {
                ConcurrentHashMap<Integer, Long> progressCollectList2 = peek.getProgressCollectList();
                ProgressStep progressStep2 = ProgressStep.STEP_30;
                if (!progressCollectList2.containsKey(Integer.valueOf(progressStep2.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep2.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
                ConcurrentHashMap<Integer, Long> progressCollectList3 = peek.getProgressCollectList();
                ProgressStep progressStep3 = ProgressStep.STEP_50;
                if (!progressCollectList3.containsKey(Integer.valueOf(progressStep3.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep3.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
            } else if (i11 == 4) {
                ConcurrentHashMap<Integer, Long> progressCollectList4 = peek.getProgressCollectList();
                ProgressStep progressStep4 = ProgressStep.STEP_30;
                if (!progressCollectList4.containsKey(Integer.valueOf(progressStep4.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep4.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
                ConcurrentHashMap<Integer, Long> progressCollectList5 = peek.getProgressCollectList();
                ProgressStep progressStep5 = ProgressStep.STEP_50;
                if (!progressCollectList5.containsKey(Integer.valueOf(progressStep5.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep5.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
                ConcurrentHashMap<Integer, Long> progressCollectList6 = peek.getProgressCollectList();
                ProgressStep progressStep6 = ProgressStep.STEP_70;
                if (!progressCollectList6.containsKey(Integer.valueOf(progressStep6.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep6.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
            } else if (i11 == 5) {
                ConcurrentHashMap<Integer, Long> progressCollectList7 = peek.getProgressCollectList();
                ProgressStep progressStep7 = ProgressStep.STEP_30;
                if (!progressCollectList7.containsKey(Integer.valueOf(progressStep7.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep7.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
                ConcurrentHashMap<Integer, Long> progressCollectList8 = peek.getProgressCollectList();
                ProgressStep progressStep8 = ProgressStep.STEP_50;
                if (!progressCollectList8.containsKey(Integer.valueOf(progressStep8.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep8.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
                ConcurrentHashMap<Integer, Long> progressCollectList9 = peek.getProgressCollectList();
                ProgressStep progressStep9 = ProgressStep.STEP_70;
                if (!progressCollectList9.containsKey(Integer.valueOf(progressStep9.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep9.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
                ConcurrentHashMap<Integer, Long> progressCollectList10 = peek.getProgressCollectList();
                ProgressStep progressStep10 = ProgressStep.STEP_100;
                if (!progressCollectList10.containsKey(Integer.valueOf(progressStep10.getStep()))) {
                    peek.getProgressCollectList().put(Integer.valueOf(progressStep10.getStep()), Long.valueOf(System.currentTimeMillis() - peek.getProgressStartTime()));
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString(ChainPoint.APP_H5_PROGRESS_STATUS, GsonUtils.toJson(peek.getProgressCollectList()));
            AppInsertState appInsertState = new AppInsertState(bundle);
            App app2 = this.app;
            appInsertState.setChainContext(app2 != null ? app2.getAppChainContext() : null);
            Bundle bundle2 = new Bundle();
            bundle2.putString(ChainPoint.PAGE_H5_PROGRESS_STATUS, GsonUtils.toJson(peek.getProgressCollectList()));
            new PageInsertState(bundle2).setChainContext(getPageChainContext(peek.getVirtual_h5PageId()));
            TmcLogger.d(this.TAG, "updateProgressStep: progressCurrentStep=" + peek.getProgressCurrentStep() + ", progressCollectList=" + peek.getProgressCollectList());
        } catch (EmptyStackException e11) {
            TmcLogger.e(this.TAG, "updateProgressStep fail: " + e11);
        }
    }
}
