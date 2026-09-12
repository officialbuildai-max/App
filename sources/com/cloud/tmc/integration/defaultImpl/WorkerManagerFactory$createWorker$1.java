package com.cloud.tmc.integration.defaultImpl;

import android.content.Context;
import com.cloud.tmc.integration.BuildConfig;
import com.cloud.tmc.integration.performance.innerworker.InnerWorkerListener;
import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.utils.ExecutorUtils;
import com.cloud.tmc.worker.IWorkerManagerFactory;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/cloud/tmc/integration/defaultImpl/WorkerManagerFactory$createWorker$1", "Lcom/cloud/tmc/integration/performance/innerworker/InnerWorkerListener;", "createWorkerSuccess", "", "loadWorkerFrameworkSuccess", "warmupFail", "step", "", "warmupSuccess", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes3.dex */
public final class WorkerManagerFactory$createWorker$1 implements InnerWorkerListener {
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref.LongRef $createWorkerEndTime;
    final /* synthetic */ Ref.LongRef $createWorkerStartTime;
    final /* synthetic */ IEngine $engine;
    final /* synthetic */ IWorkerManagerFactory.IWorkerListener $listener;
    final /* synthetic */ Ref.LongRef $loadWorkerFrameworkEndTime;
    final /* synthetic */ Ref.LongRef $loadWorkerFrameworkStartTime;
    final /* synthetic */ Node $node;
    final /* synthetic */ String $userAgent;
    final /* synthetic */ String $workerId;
    final /* synthetic */ WorkerManagerFactory this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WorkerManagerFactory$createWorker$1(Ref.LongRef longRef, Ref.LongRef longRef2, Ref.LongRef longRef3, WorkerManagerFactory workerManagerFactory, IEngine iEngine, Context context, Node node, String str, String str2, IWorkerManagerFactory.IWorkerListener iWorkerListener, Ref.LongRef longRef4) {
        this.$createWorkerEndTime = longRef;
        this.$loadWorkerFrameworkStartTime = longRef2;
        this.$loadWorkerFrameworkEndTime = longRef3;
        this.this$0 = workerManagerFactory;
        this.$engine = iEngine;
        this.$context = context;
        this.$node = node;
        this.$userAgent = str;
        this.$workerId = str2;
        this.$listener = iWorkerListener;
        this.$createWorkerStartTime = longRef4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadWorkerFrameworkSuccess$lambda$0(WorkerManagerFactory this$0, IEngine engine, Context context, Node node, String userAgent, String workerId, IWorkerManagerFactory.IWorkerListener listener, Ref.LongRef createWorkerStartTime, Ref.LongRef createWorkerEndTime, Ref.LongRef loadWorkerFrameworkStartTime, Ref.LongRef loadWorkerFrameworkEndTime) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(engine, "$engine");
        Intrinsics.h(context, "$context");
        Intrinsics.h(node, "$node");
        Intrinsics.h(userAgent, "$userAgent");
        Intrinsics.h(workerId, "$workerId");
        Intrinsics.h(listener, "$listener");
        Intrinsics.h(createWorkerStartTime, "$createWorkerStartTime");
        Intrinsics.h(createWorkerEndTime, "$createWorkerEndTime");
        Intrinsics.h(loadWorkerFrameworkStartTime, "$loadWorkerFrameworkStartTime");
        Intrinsics.h(loadWorkerFrameworkEndTime, "$loadWorkerFrameworkEndTime");
        this$0.getWorker(engine, context, node, userAgent, workerId, listener, createWorkerStartTime.element, createWorkerEndTime.element, loadWorkerFrameworkStartTime.element, loadWorkerFrameworkEndTime.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void warmupFail$lambda$2(WorkerManagerFactory this$0, IEngine engine, Context context, Node node, String userAgent, String workerId, IWorkerManagerFactory.IWorkerListener listener, Ref.LongRef createWorkerStartTime, Ref.LongRef createWorkerEndTime, Ref.LongRef loadWorkerFrameworkStartTime, Ref.LongRef loadWorkerFrameworkEndTime) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(engine, "$engine");
        Intrinsics.h(context, "$context");
        Intrinsics.h(node, "$node");
        Intrinsics.h(userAgent, "$userAgent");
        Intrinsics.h(workerId, "$workerId");
        Intrinsics.h(listener, "$listener");
        Intrinsics.h(createWorkerStartTime, "$createWorkerStartTime");
        Intrinsics.h(createWorkerEndTime, "$createWorkerEndTime");
        Intrinsics.h(loadWorkerFrameworkStartTime, "$loadWorkerFrameworkStartTime");
        Intrinsics.h(loadWorkerFrameworkEndTime, "$loadWorkerFrameworkEndTime");
        this$0.getWorker(engine, context, node, userAgent, workerId, listener, createWorkerStartTime.element, createWorkerEndTime.element, loadWorkerFrameworkStartTime.element, loadWorkerFrameworkEndTime.element);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void warmupSuccess$lambda$1(WorkerManagerFactory this$0, IEngine engine, Context context, Node node, String userAgent, String workerId, IWorkerManagerFactory.IWorkerListener listener, Ref.LongRef createWorkerStartTime, Ref.LongRef createWorkerEndTime, Ref.LongRef loadWorkerFrameworkStartTime, Ref.LongRef loadWorkerFrameworkEndTime) {
        Intrinsics.h(this$0, "this$0");
        Intrinsics.h(engine, "$engine");
        Intrinsics.h(context, "$context");
        Intrinsics.h(node, "$node");
        Intrinsics.h(userAgent, "$userAgent");
        Intrinsics.h(workerId, "$workerId");
        Intrinsics.h(listener, "$listener");
        Intrinsics.h(createWorkerStartTime, "$createWorkerStartTime");
        Intrinsics.h(createWorkerEndTime, "$createWorkerEndTime");
        Intrinsics.h(loadWorkerFrameworkStartTime, "$loadWorkerFrameworkStartTime");
        Intrinsics.h(loadWorkerFrameworkEndTime, "$loadWorkerFrameworkEndTime");
        this$0.getWorker(engine, context, node, userAgent, workerId, listener, createWorkerStartTime.element, createWorkerEndTime.element, loadWorkerFrameworkStartTime.element, loadWorkerFrameworkEndTime.element);
    }

    @Override // com.cloud.tmc.integration.performance.innerworker.InnerWorkerListener
    public void createWorkerSuccess() {
        TmcLogger.d("InnerWarmup", "listener callback => createWorkerSuccess");
        this.$createWorkerEndTime.element = System.currentTimeMillis();
        this.$loadWorkerFrameworkStartTime.element = System.currentTimeMillis();
    }

    @Override // com.cloud.tmc.integration.performance.innerworker.InnerWorkerListener
    public void loadWorkerFrameworkSuccess() {
        TmcLogger.d("InnerWarmup", "listener callback => loadWorkerFrameworkSuccess");
        this.$loadWorkerFrameworkEndTime.element = System.currentTimeMillis();
        final WorkerManagerFactory workerManagerFactory = this.this$0;
        final IEngine iEngine = this.$engine;
        final Context context = this.$context;
        final Node node = this.$node;
        final String str = this.$userAgent;
        final String str2 = this.$workerId;
        final IWorkerManagerFactory.IWorkerListener iWorkerListener = this.$listener;
        final Ref.LongRef longRef = this.$createWorkerStartTime;
        final Ref.LongRef longRef2 = this.$createWorkerEndTime;
        final Ref.LongRef longRef3 = this.$loadWorkerFrameworkStartTime;
        final Ref.LongRef longRef4 = this.$loadWorkerFrameworkEndTime;
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.integration.defaultImpl.i
            @Override // java.lang.Runnable
            public final void run() {
                WorkerManagerFactory$createWorker$1.loadWorkerFrameworkSuccess$lambda$0(WorkerManagerFactory.this, iEngine, context, node, str, str2, iWorkerListener, longRef, longRef2, longRef3, longRef4);
            }
        });
    }

    @Override // com.cloud.tmc.integration.performance.innerworker.InnerWorkerListener
    public void warmupFail(int step) {
        TmcLogger.d("InnerWarmup", "listener callback => worker warmupFail:" + step);
        final Ref.LongRef longRef = this.$createWorkerStartTime;
        longRef.element = 0L;
        final Ref.LongRef longRef2 = this.$createWorkerEndTime;
        longRef2.element = 0L;
        final Ref.LongRef longRef3 = this.$loadWorkerFrameworkStartTime;
        longRef3.element = 0L;
        final Ref.LongRef longRef4 = this.$loadWorkerFrameworkEndTime;
        longRef4.element = 0L;
        final WorkerManagerFactory workerManagerFactory = this.this$0;
        final IEngine iEngine = this.$engine;
        final Context context = this.$context;
        final Node node = this.$node;
        final String str = this.$userAgent;
        final String str2 = this.$workerId;
        final IWorkerManagerFactory.IWorkerListener iWorkerListener = this.$listener;
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.integration.defaultImpl.h
            @Override // java.lang.Runnable
            public final void run() {
                WorkerManagerFactory$createWorker$1.warmupFail$lambda$2(WorkerManagerFactory.this, iEngine, context, node, str, str2, iWorkerListener, longRef, longRef2, longRef3, longRef4);
            }
        });
    }

    @Override // com.cloud.tmc.integration.performance.innerworker.InnerWorkerListener
    public void warmupSuccess() {
        TmcLogger.d("InnerWarmup", "listener callback => worker warmupSuccess");
        this.$createWorkerStartTime.element = System.currentTimeMillis();
        this.$createWorkerEndTime.element = System.currentTimeMillis();
        this.$loadWorkerFrameworkStartTime.element = System.currentTimeMillis();
        this.$loadWorkerFrameworkEndTime.element = System.currentTimeMillis();
        final WorkerManagerFactory workerManagerFactory = this.this$0;
        final IEngine iEngine = this.$engine;
        final Context context = this.$context;
        final Node node = this.$node;
        final String str = this.$userAgent;
        final String str2 = this.$workerId;
        final IWorkerManagerFactory.IWorkerListener iWorkerListener = this.$listener;
        final Ref.LongRef longRef = this.$createWorkerStartTime;
        final Ref.LongRef longRef2 = this.$createWorkerEndTime;
        final Ref.LongRef longRef3 = this.$loadWorkerFrameworkStartTime;
        final Ref.LongRef longRef4 = this.$loadWorkerFrameworkEndTime;
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.cloud.tmc.integration.defaultImpl.j
            @Override // java.lang.Runnable
            public final void run() {
                WorkerManagerFactory$createWorker$1.warmupSuccess$lambda$1(WorkerManagerFactory.this, iEngine, context, node, str, str2, iWorkerListener, longRef, longRef2, longRef3, longRef4);
            }
        });
    }
}
