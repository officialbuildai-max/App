package com.cloud.tmc.integration.performance.innerworker;

import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.performance.WarmUpCallback;
import com.cloud.tmc.integration.structure.WarmupNode;
import com.cloud.tmc.kernel.framework.FrameworkConstants;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.TmcProxy;
import com.cloud.tmc.kernel.proxy.eventcenter.IEvent;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenter;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventSubscriber;
import com.cloud.tmc.kernel.worker.JSI;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.cloud.tmc.integration.performance.innerworker.InnerWorkerWarmupManager$warmup$1", f = "InnerWorkerWarmupManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class InnerWorkerWarmupManager$warmup$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ InnerWorkerListener $listener;
    final /* synthetic */ WarmUpCallback $warmUpCallback;
    final /* synthetic */ Node $warmupNode;
    final /* synthetic */ JSI $worker;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerWorkerWarmupManager$warmup$1(JSI jsi, Node node, InnerWorkerListener innerWorkerListener, WarmUpCallback warmUpCallback, Continuation<? super InnerWorkerWarmupManager$warmup$1> continuation) {
        super(2, continuation);
        this.$worker = jsi;
        this.$warmupNode = node;
        this.$listener = innerWorkerListener;
        this.$warmUpCallback = warmUpCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(InnerWorkerListener innerWorkerListener, final Node node, final JSI jsi, final WarmUpCallback warmUpCallback) {
        if (innerWorkerListener != null) {
            innerWorkerListener.createWorkerSuccess();
        }
        final IEventCenterFactory iEventCenterFactory = (IEventCenterFactory) TmcProxy.get(IEventCenterFactory.class);
        IEventCenter eventCenterInstance = iEventCenterFactory.getEventCenterInstance(node);
        if (eventCenterInstance != null) {
            eventCenterInstance.register(EventConstants.EVENT_WORKER_ON_MSG_READY, new IEventSubscriber() { // from class: com.cloud.tmc.integration.performance.innerworker.InnerWorkerWarmupManager$warmup$1$1$1
                @Override // com.cloud.tmc.kernel.proxy.eventcenter.IEventSubscriber
                public boolean onEvent(IEvent event) {
                    JSI.this.workerOnMessageReady();
                    IEventCenter eventCenterInstance2 = iEventCenterFactory.getEventCenterInstance(node);
                    if (eventCenterInstance2 != null) {
                        eventCenterInstance2.unregister(EventConstants.EVENT_WORKER_ON_MSG_READY, this);
                    }
                    WarmupNode warmupNode = (WarmupNode) TmcProxy.get(WarmupNode.class);
                    String workerId = JSI.this.getWorkerId();
                    Intrinsics.g(workerId, "worker.workerId");
                    warmupNode.removeNode(workerId);
                    warmUpCallback.warmupResult(true);
                    return true;
                }
            });
        }
        jsi.loadJS("100000", FrameworkConstants.FRAMEWORK_JS);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InnerWorkerWarmupManager$warmup$1(this.$worker, this.$warmupNode, this.$listener, this.$warmUpCallback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((InnerWorkerWarmupManager$warmup$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.$worker.setRenderReady();
        this.$worker.setAppId(FrameworkConstants.APP_MANAGER_APPID);
        this.$worker.setNode(this.$warmupNode);
        final JSI jsi = this.$worker;
        final InnerWorkerListener innerWorkerListener = this.$listener;
        final Node node = this.$warmupNode;
        final WarmUpCallback warmUpCallback = this.$warmUpCallback;
        jsi.registerWorkerReadyListener(new JSI.WorkerReadyListener() { // from class: com.cloud.tmc.integration.performance.innerworker.a
            @Override // com.cloud.tmc.kernel.worker.JSI.WorkerReadyListener
            public final void onWorkerReady() {
                InnerWorkerWarmupManager$warmup$1.invokeSuspend$lambda$0(InnerWorkerListener.this, node, jsi, warmUpCallback);
            }
        });
        return Unit.f67184a;
    }
}
