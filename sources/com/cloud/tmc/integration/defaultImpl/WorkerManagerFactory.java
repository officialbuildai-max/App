package com.cloud.tmc.integration.defaultImpl;

import android.content.Context;
import android.os.Bundle;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.chain.endState.CreateWorkerEndState;
import com.cloud.tmc.integration.chain.endState.LoadWorkerFrameworkEndState;
import com.cloud.tmc.integration.chain.startState.ChainMidStartState;
import com.cloud.tmc.integration.chain.startState.CreateWorkerStartState;
import com.cloud.tmc.integration.chain.startState.LoadWorkerFrameworkStartState;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.WorkerStore;
import com.cloud.tmc.integration.performance.innerworker.IInnerWorkerPool;
import com.cloud.tmc.integration.performanceanalyse.screen.IScreenInspectProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.kernel.engine.EngineRouterManager;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.intf.IPackageConfig;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.ChainPoint;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.performanceanalyse.RenderAnalyseType;
import com.cloud.tmc.kernel.worker.JSI;
import com.cloud.tmc.worker.IWorkerManagerFactory;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016JX\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¨\u0006\u0016"}, d2 = {"Lcom/cloud/tmc/integration/defaultImpl/WorkerManagerFactory;", "Lcom/cloud/tmc/worker/IWorkerManagerFactory;", "()V", "createWorker", "", "engine", "Lcom/cloud/tmc/kernel/engine/IEngine;", "context", "Landroid/content/Context;", "node", "Lcom/cloud/tmc/kernel/node/Node;", "userAgent", "", "workerId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/cloud/tmc/worker/IWorkerManagerFactory$IWorkerListener;", "getWorker", "createWorkerStartTime", "", "createWorkerEndTime", "loadWorkerFrameworkStartTime", "loadWorkerFrameworkEndTime", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class WorkerManagerFactory implements IWorkerManagerFactory {
    /* JADX INFO: Access modifiers changed from: private */
    public final void getWorker(IEngine engine, Context context, Node node, String userAgent, String workerId, IWorkerManagerFactory.IWorkerListener listener, long createWorkerStartTime, long createWorkerEndTime, long loadWorkerFrameworkStartTime, long loadWorkerFrameworkEndTime) {
        App app;
        AppModel appModel;
        AppModel appModel2;
        boolean z10 = node instanceof Page;
        Page page = z10 ? (Page) node : null;
        if ((page != null ? page.getApp() : null) == null) {
            TmcLogger.d("InnerWarmup", "app已摧毁，不再继续执行Worker");
            return;
        }
        JSI worker = ((IInnerWorkerPool) TmcProxy.get(IInnerWorkerPool.class)).getWorker(((IPackageConfig) TmcProxy.get(IPackageConfig.class)).getFrameworkVersion());
        if (worker == null) {
            worker = engine.createWorker(context, node, "");
        } else {
            engine.updateWorker(worker);
        }
        if (node != null) {
            app = (App) node.bubbleFindNode(App.class);
            if (app != null) {
                app.setData(WorkerStore.class, new WorkerStore(workerId));
            }
        } else {
            app = null;
        }
        PageNode pageNode = node instanceof PageNode ? (PageNode) node : null;
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class);
        String appId = app != null ? app.getAppId() : null;
        RenderAnalyseType renderAnalyseType = RenderAnalyseType.CONSOLE;
        Boolean fromWarmup = worker != null ? worker.fromWarmup() : null;
        StringBuilder sb2 = new StringBuilder();
        PageNode pageNode2 = pageNode;
        sb2.append("worker fromWarmup : ");
        sb2.append(fromWarmup);
        performanceAnalyseProxy.record(appId, renderAnalyseType, sb2.toString());
        long startToken = app != null ? app.getStartToken() : -1L;
        if (worker != null) {
            worker.setWorkerId(workerId);
        }
        if (worker != null) {
            worker.setAppId("100000");
        }
        if (worker != null) {
            worker.setNode(app);
        }
        if (AppUtils.INSTANCE.checkUesCommonresApp((app == null || (appModel2 = app.getAppModel()) == null) ? null : appModel2.getMiniappSubtype()) && worker != null) {
            worker.setCommonresId((app == null || (appModel = app.getAppModel()) == null) ? null : appModel.getTemplateMiniappId());
        }
        ((EngineRouterManager) TmcProxy.get(EngineRouterManager.class)).get(startToken).registerWorker(workerId, worker);
        ((IScreenInspectProxy) TmcProxy.get(IScreenInspectProxy.class)).registerWorker(app, worker);
        if (createWorkerEndTime != 0 && createWorkerStartTime != 0) {
            ((PerformanceImprovesProxy) TmcProxy.get(PerformanceImprovesProxy.class)).addPeroformanceImprove(app != null ? app.getAppId() : null, EventConstants.ADDRESS_WORKER);
            Bundle bundle = new Bundle();
            bundle.putLong(ChainPoint.TIME, createWorkerStartTime);
            String str = ChainPoint.PAGE_PATH;
            Page page2 = z10 ? (Page) node : null;
            bundle.putString(str, page2 != null ? page2.getPagePath() : null);
            String str2 = ChainPoint.PAGE_ID;
            Page page3 = z10 ? (Page) node : null;
            bundle.putString(str2, page3 != null ? page3.getPageId() : null);
            Bundle bundle2 = new Bundle();
            bundle2.putLong(ChainPoint.TIME, createWorkerEndTime);
            String str3 = ChainPoint.PAGE_PATH;
            Page page4 = z10 ? (Page) node : null;
            bundle2.putString(str3, page4 != null ? page4.getPagePath() : null);
            String str4 = ChainPoint.PAGE_ID;
            Page page5 = z10 ? (Page) node : null;
            bundle2.putString(str4, page5 != null ? page5.getPageId() : null);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, ChainPoint.PageCreateWorker, bundle);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, ChainPoint.PageCreateWorker, bundle);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_END, ChainPoint.PageCreateWorker, bundle2);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_END, ChainPoint.PageCreateWorker, bundle2);
            new CreateWorkerStartState(bundle).setChainContext(pageNode2 != null ? pageNode2.getPageChainContext() : null);
            new CreateWorkerEndState(bundle2).setChainContext(pageNode2 != null ? pageNode2.getPageChainContext() : null);
        }
        if (loadWorkerFrameworkEndTime != 0 && loadWorkerFrameworkStartTime != 0) {
            Bundle bundle3 = new Bundle();
            bundle3.putLong(ChainPoint.TIME, loadWorkerFrameworkStartTime);
            String str5 = ChainPoint.PAGE_PATH;
            Page page6 = z10 ? (Page) node : null;
            bundle3.putString(str5, page6 != null ? page6.getPagePath() : null);
            String str6 = ChainPoint.PAGE_ID;
            Page page7 = z10 ? (Page) node : null;
            bundle3.putString(str6, page7 != null ? page7.getPageId() : null);
            Bundle bundle4 = new Bundle();
            bundle4.putLong(ChainPoint.TIME, loadWorkerFrameworkEndTime);
            String str7 = ChainPoint.PAGE_PATH;
            Page page8 = z10 ? (Page) node : null;
            bundle4.putString(str7, page8 != null ? page8.getPagePath() : null);
            String str8 = ChainPoint.PAGE_ID;
            Page page9 = z10 ? (Page) node : null;
            bundle4.putString(str8, page9 != null ? page9.getPageId() : null);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_START, ChainPoint.PageLoadWorkerFramework, bundle3);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_START, ChainPoint.PageLoadWorkerFramework, bundle3);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_APP_CHAIN_END, ChainPoint.PageLoadWorkerFramework, bundle4);
            ((PerformanceAnalyseProxy) TmcProxy.get(PerformanceAnalyseProxy.class)).record(app != null ? app.getAppId() : null, PointAnalyseType.POINT_PAGE_CHAIN_END, ChainPoint.PageLoadWorkerFramework, bundle4);
            new LoadWorkerFrameworkStartState(bundle3).setChainContext(pageNode2 != null ? pageNode2.getPageChainContext() : null);
            new LoadWorkerFrameworkEndState(bundle4).setChainContext(pageNode2 != null ? pageNode2.getPageChainContext() : null);
            new ChainMidStartState(bundle4).setChainContext(pageNode2 != null ? pageNode2.getPageChainContext() : null);
        }
        listener.createSuccess(worker);
    }

    @Override // com.cloud.tmc.worker.IWorkerManagerFactory
    public void createWorker(IEngine engine, Context context, Node node, String userAgent, String workerId, IWorkerManagerFactory.IWorkerListener listener) {
        Intrinsics.h(engine, "engine");
        Intrinsics.h(context, "context");
        Intrinsics.h(node, "node");
        Intrinsics.h(userAgent, "userAgent");
        Intrinsics.h(workerId, "workerId");
        Intrinsics.h(listener, "listener");
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = System.currentTimeMillis();
        Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = System.currentTimeMillis();
        Ref.LongRef longRef3 = new Ref.LongRef();
        longRef3.element = System.currentTimeMillis();
        Ref.LongRef longRef4 = new Ref.LongRef();
        longRef4.element = System.currentTimeMillis();
        ((IInnerWorkerPool) TmcProxy.get(IInnerWorkerPool.class)).registerListener(new WorkerManagerFactory$createWorker$1(longRef2, longRef3, longRef4, this, engine, context, node, userAgent, workerId, listener, longRef), ((IPackageConfig) TmcProxy.get(IPackageConfig.class)).getFrameworkVersion());
    }
}
