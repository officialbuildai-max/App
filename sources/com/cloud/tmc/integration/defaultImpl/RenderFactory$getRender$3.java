package com.cloud.tmc.integration.defaultImpl;

import android.app.Activity;
import android.os.Bundle;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.performance.innerrender.InnerRenderListener;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.model.CreateParams;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceImprovesProxy;
import com.cloud.tmc.kernel.render.IRender;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.render.IRenderFactory;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/cloud/tmc/integration/defaultImpl/RenderFactory$getRender$3", "Lcom/cloud/tmc/integration/performance/innerrender/InnerRenderListener;", "createRenderSuccess", "", "loadRenderFrameworkSuccess", "warmupFail", "step", "", "warmupSuccess", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class RenderFactory$getRender$3 implements InnerRenderListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Object $context;
    final /* synthetic */ CreateParams $createParams;
    final /* synthetic */ Ref.LongRef $createRenderEndTime;
    final /* synthetic */ Bundle $data;
    final /* synthetic */ IEngine $engineProxy;
    final /* synthetic */ IRenderFactory.IRenderListener $listener;
    final /* synthetic */ Ref.LongRef $loadRenderFrameworkEndTime;
    final /* synthetic */ Ref.LongRef $loadRenderFrameworkStartTime;
    final /* synthetic */ Node $node;
    final /* synthetic */ String $pageId;
    final /* synthetic */ RenderFactory this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RenderFactory$getRender$3(Ref.LongRef longRef, Ref.LongRef longRef2, IEngine iEngine, Ref.LongRef longRef3, Node node, RenderFactory renderFactory, Activity activity, CreateParams createParams, String str, Object obj, IRenderFactory.IRenderListener iRenderListener, Bundle bundle) {
        this.$createRenderEndTime = longRef;
        this.$loadRenderFrameworkStartTime = longRef2;
        this.$engineProxy = iEngine;
        this.$loadRenderFrameworkEndTime = longRef3;
        this.$node = node;
        this.this$0 = renderFactory;
        this.$activity = activity;
        this.$createParams = createParams;
        this.$pageId = str;
        this.$context = obj;
        this.$listener = iRenderListener;
        this.$data = bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadRenderFrameworkSuccess$lambda$0(Node node, RenderFactory this$0, Activity activity, IEngine iEngine, CreateParams createParams, String pageId, Object context, IRenderFactory.IRenderListener listener, Ref.LongRef createRenderEndTime, Ref.LongRef loadRenderFrameworkStartTime, Ref.LongRef loadRenderFrameworkEndTime, Bundle data) {
        IRender createRender;
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(pageId, "$pageId");
        Intrinsics.h(context, "$context");
        Intrinsics.h(listener, "$listener");
        Intrinsics.h(createRenderEndTime, "$createRenderEndTime");
        Intrinsics.h(loadRenderFrameworkStartTime, "$loadRenderFrameworkStartTime");
        Intrinsics.h(loadRenderFrameworkEndTime, "$loadRenderFrameworkEndTime");
        Intrinsics.h(data, "$data");
        PageNode pageNode = node instanceof PageNode ? (PageNode) node : null;
        if ((pageNode != null ? pageNode.getApp() : null) == null) {
            TmcLogger.d("InnerWarmup", "app已摧毁，不再继续执行Render");
        } else {
            createRender = this$0.createRender(activity, iEngine, node, createParams);
            this$0.initRenderEnv(activity, iEngine, node, createParams, pageId, context, createRender, listener, createRenderEndTime.element, loadRenderFrameworkStartTime.element, loadRenderFrameworkEndTime.element, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void warmupFail$lambda$2(Node node, RenderFactory this$0, Activity activity, IEngine iEngine, CreateParams createParams, String pageId, Object context, IRenderFactory.IRenderListener listener, Ref.LongRef createRenderEndTime, Ref.LongRef loadRenderFrameworkStartTime, Ref.LongRef loadRenderFrameworkEndTime, Bundle data) {
        IRender createRender;
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(pageId, "$pageId");
        Intrinsics.h(context, "$context");
        Intrinsics.h(listener, "$listener");
        Intrinsics.h(createRenderEndTime, "$createRenderEndTime");
        Intrinsics.h(loadRenderFrameworkStartTime, "$loadRenderFrameworkStartTime");
        Intrinsics.h(loadRenderFrameworkEndTime, "$loadRenderFrameworkEndTime");
        Intrinsics.h(data, "$data");
        PageNode pageNode = node instanceof PageNode ? (PageNode) node : null;
        if ((pageNode != null ? pageNode.getApp() : null) == null) {
            TmcLogger.d("InnerWarmup", "app已摧毁，不再继续执行Render");
        } else {
            createRender = this$0.createRender(activity, iEngine, node, createParams);
            this$0.initRenderEnv(activity, iEngine, node, createParams, pageId, context, createRender, listener, createRenderEndTime.element, loadRenderFrameworkStartTime.element, loadRenderFrameworkEndTime.element, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void warmupSuccess$lambda$1(Node node, RenderFactory this$0, Activity activity, IEngine iEngine, CreateParams createParams, String pageId, Object context, IRenderFactory.IRenderListener listener, Ref.LongRef createRenderEndTime, Ref.LongRef loadRenderFrameworkStartTime, Ref.LongRef loadRenderFrameworkEndTime, Bundle data) {
        IRender createRender;
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(pageId, "$pageId");
        Intrinsics.h(context, "$context");
        Intrinsics.h(listener, "$listener");
        Intrinsics.h(createRenderEndTime, "$createRenderEndTime");
        Intrinsics.h(loadRenderFrameworkStartTime, "$loadRenderFrameworkStartTime");
        Intrinsics.h(loadRenderFrameworkEndTime, "$loadRenderFrameworkEndTime");
        Intrinsics.h(data, "$data");
        PageNode pageNode = node instanceof PageNode ? (PageNode) node : null;
        if ((pageNode != null ? pageNode.getApp() : null) == null) {
            TmcLogger.d("InnerWarmup", "app已摧毁，不再继续执行Render");
        } else {
            createRender = this$0.createRender(activity, iEngine, node, createParams);
            this$0.initRenderEnv(activity, iEngine, node, createParams, pageId, context, createRender, listener, createRenderEndTime.element, loadRenderFrameworkStartTime.element, loadRenderFrameworkEndTime.element, data);
        }
    }

    @Override // com.cloud.tmc.integration.performance.innerrender.InnerRenderListener
    public void createRenderSuccess() {
        TmcLogger.d("InnerWarmup", "listener callback => createRenderSuccess");
        this.$createRenderEndTime.element = System.currentTimeMillis();
        this.$loadRenderFrameworkStartTime.element = System.currentTimeMillis();
    }

    @Override // com.cloud.tmc.integration.performance.innerrender.InnerRenderListener
    public void loadRenderFrameworkSuccess() {
        TmcLogger.d("InnerWarmup", "listener callback => loadRenderFrameworkSuccess");
        PerformanceImprovesProxy performanceImprovesProxy = (PerformanceImprovesProxy) TmcProxy.get(PerformanceImprovesProxy.class);
        IEngine iEngine = this.$engineProxy;
        performanceImprovesProxy.addPeroformanceImprove(iEngine != null ? iEngine.getAppId() : null, EventConstants.ADDRESS_RENDER);
        this.$loadRenderFrameworkEndTime.element = System.currentTimeMillis();
        final Node node = this.$node;
        final RenderFactory renderFactory = this.this$0;
        final Activity activity = this.$activity;
        final IEngine iEngine2 = this.$engineProxy;
        final CreateParams createParams = this.$createParams;
        final String str = this.$pageId;
        final Object obj = this.$context;
        final IRenderFactory.IRenderListener iRenderListener = this.$listener;
        final Ref.LongRef longRef = this.$createRenderEndTime;
        final Ref.LongRef longRef2 = this.$loadRenderFrameworkStartTime;
        final Ref.LongRef longRef3 = this.$loadRenderFrameworkEndTime;
        final Bundle bundle = this.$data;
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.integration.defaultImpl.f
            @Override // java.lang.Runnable
            public final void run() {
                RenderFactory$getRender$3.loadRenderFrameworkSuccess$lambda$0(Node.this, renderFactory, activity, iEngine2, createParams, str, obj, iRenderListener, longRef, longRef2, longRef3, bundle);
            }
        });
    }

    @Override // com.cloud.tmc.integration.performance.innerrender.InnerRenderListener
    public void warmupFail(int step) {
        TmcLogger.d("InnerWarmup", "listener callback => render warmupFail:" + step);
        final Ref.LongRef longRef = this.$createRenderEndTime;
        longRef.element = 0L;
        final Ref.LongRef longRef2 = this.$loadRenderFrameworkStartTime;
        longRef2.element = 0L;
        final Ref.LongRef longRef3 = this.$loadRenderFrameworkEndTime;
        longRef3.element = 0L;
        final Node node = this.$node;
        final RenderFactory renderFactory = this.this$0;
        final Activity activity = this.$activity;
        final IEngine iEngine = this.$engineProxy;
        final CreateParams createParams = this.$createParams;
        final String str = this.$pageId;
        final Object obj = this.$context;
        final IRenderFactory.IRenderListener iRenderListener = this.$listener;
        final Bundle bundle = this.$data;
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.integration.defaultImpl.e
            @Override // java.lang.Runnable
            public final void run() {
                RenderFactory$getRender$3.warmupFail$lambda$2(Node.this, renderFactory, activity, iEngine, createParams, str, obj, iRenderListener, longRef, longRef2, longRef3, bundle);
            }
        });
    }

    @Override // com.cloud.tmc.integration.performance.innerrender.InnerRenderListener
    public void warmupSuccess() {
        TmcLogger.d("InnerWarmup", "listener callback => render warmupSuccess");
        PerformanceImprovesProxy performanceImprovesProxy = (PerformanceImprovesProxy) TmcProxy.get(PerformanceImprovesProxy.class);
        IEngine iEngine = this.$engineProxy;
        performanceImprovesProxy.addPeroformanceImprove(iEngine != null ? iEngine.getAppId() : null, EventConstants.ADDRESS_RENDER);
        this.$createRenderEndTime.element = System.currentTimeMillis();
        this.$loadRenderFrameworkStartTime.element = System.currentTimeMillis();
        this.$loadRenderFrameworkEndTime.element = System.currentTimeMillis();
        final Node node = this.$node;
        final RenderFactory renderFactory = this.this$0;
        final Activity activity = this.$activity;
        final IEngine iEngine2 = this.$engineProxy;
        final CreateParams createParams = this.$createParams;
        final String str = this.$pageId;
        final Object obj = this.$context;
        final IRenderFactory.IRenderListener iRenderListener = this.$listener;
        final Ref.LongRef longRef = this.$createRenderEndTime;
        final Ref.LongRef longRef2 = this.$loadRenderFrameworkStartTime;
        final Ref.LongRef longRef3 = this.$loadRenderFrameworkEndTime;
        final Bundle bundle = this.$data;
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.integration.defaultImpl.g
            @Override // java.lang.Runnable
            public final void run() {
                RenderFactory$getRender$3.warmupSuccess$lambda$1(Node.this, renderFactory, activity, iEngine2, createParams, str, obj, iRenderListener, longRef, longRef2, longRef3, bundle);
            }
        });
    }
}
