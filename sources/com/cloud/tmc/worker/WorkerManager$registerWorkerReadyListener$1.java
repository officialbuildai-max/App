package com.cloud.tmc.worker;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.cloud.tmc.worker.WorkerManager$registerWorkerReadyListener$1", f = "WorkerManager.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
final class WorkerManager$registerWorkerReadyListener$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WorkerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkerManager$registerWorkerReadyListener$1(WorkerManager workerManager, Continuation<? super WorkerManager$registerWorkerReadyListener$1> continuation) {
        super(2, continuation);
        this.this$0 = workerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WorkerManager$registerWorkerReadyListener$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((WorkerManager$registerWorkerReadyListener$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0071, code lost:
    
        r6 = r5.this$0.workerId;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r0 = r5.label
            if (r0 != 0) goto L92
            kotlin.ResultKt.b(r6)
            com.cloud.tmc.worker.WorkerManager r6 = r5.this$0
            java.lang.Class<com.cloud.tmc.kernel.proxy.worker.IWorkerFactory> r0 = com.cloud.tmc.kernel.proxy.worker.IWorkerFactory.class
            java.lang.Object r0 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r0)
            com.cloud.tmc.kernel.proxy.worker.IWorkerFactory r0 = (com.cloud.tmc.kernel.proxy.worker.IWorkerFactory) r0
            com.cloud.tmc.worker.WorkerManager r1 = r5.this$0
            java.lang.String r1 = com.cloud.tmc.worker.WorkerManager.access$getAppId$p(r1)
            com.cloud.tmc.worker.WorkerManager r2 = r5.this$0
            com.cloud.tmc.kernel.node.Node r2 = com.cloud.tmc.worker.WorkerManager.access$getNode$p(r2)
            com.cloud.tmc.kernel.worker.IWorker r0 = r0.createWorker(r1, r2)
            r1 = 0
            if (r0 == 0) goto L4e
            com.cloud.tmc.worker.WorkerManager r2 = r5.this$0
            com.cloud.tmc.worker.WorkerManager$MyWorkLifeCycle r3 = new com.cloud.tmc.worker.WorkerManager$MyWorkLifeCycle
            r3.<init>()
            r0.registerWorkLifeCycle(r3)
            com.cloud.tmc.worker.WorkerManager$MyWorkCall r3 = new com.cloud.tmc.worker.WorkerManager$MyWorkCall
            r3.<init>()
            r0.registerWorkerCallback(r3)
            java.lang.Class<com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy> r3 = com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy.class
            java.lang.Object r3 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r3)
            com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy r3 = (com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy) r3
            java.lang.String r2 = com.cloud.tmc.worker.WorkerManager.access$getAppId$p(r2)
            com.cloud.tmc.kernel.proxy.performanceanalyse.WorkerAnalyseType r4 = com.cloud.tmc.kernel.proxy.performanceanalyse.WorkerAnalyseType.CREATE_START
            r3.record(r2, r4, r1)
            r0.create()
            goto L4f
        L4e:
            r0 = r1
        L4f:
            com.cloud.tmc.worker.WorkerManager.access$setWorker$p(r6, r0)
            com.cloud.tmc.worker.WorkerManager r6 = r5.this$0
            com.cloud.tmc.kernel.worker.IWorker r6 = com.cloud.tmc.worker.WorkerManager.access$getWorker$p(r6)
            if (r6 != 0) goto L8f
            com.cloud.tmc.worker.WorkerManager r6 = r5.this$0
            java.lang.String r6 = com.cloud.tmc.worker.WorkerManager.access$getWorkerId$p(r6)
            r0 = 1
            if (r6 == 0) goto L8a
            com.cloud.tmc.worker.WorkerManager r6 = r5.this$0
            java.lang.String r6 = com.cloud.tmc.worker.WorkerManager.access$getWorkerId$p(r6)
            java.lang.String r2 = "100000"
            boolean r6 = kotlin.jvm.internal.Intrinsics.c(r6, r2)
            if (r6 != 0) goto L8a
            com.cloud.tmc.worker.WorkerManager r6 = r5.this$0
            java.lang.String r6 = com.cloud.tmc.worker.WorkerManager.access$getWorkerId$p(r6)
            if (r6 == 0) goto L84
            r2 = 0
            r3 = 2
            java.lang.String r4 = "warmup_worker_id_"
            boolean r6 = kotlin.text.StringsKt.W(r6, r4, r2, r3, r1)
            if (r6 != r0) goto L84
            goto L8a
        L84:
            com.cloud.tmc.worker.WorkerManager r6 = r5.this$0
            com.cloud.tmc.worker.WorkerManager.access$postCreateWorkerEvent(r6)
            goto L8f
        L8a:
            com.cloud.tmc.worker.WorkerManager r6 = r5.this$0
            com.cloud.tmc.worker.WorkerManager.access$setPendingCreateWorkerFail$p(r6, r0)
        L8f:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        L92:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.worker.WorkerManager$registerWorkerReadyListener$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
