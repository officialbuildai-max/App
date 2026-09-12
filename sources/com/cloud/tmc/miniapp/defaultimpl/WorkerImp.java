package com.cloud.tmc.miniapp.defaultimpl;

import com.cloud.tmc.kernel.proxy.worker.IWorkerFactory;

/* loaded from: classes3.dex */
public final class WorkerImp implements IWorkerFactory {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004a A[Catch: all -> 0x0053, TryCatch #0 {all -> 0x0053, blocks: (B:10:0x003e, B:12:0x004a, B:13:0x0056), top: B:9:0x003e }] */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.cloud.tmc.kernel.worker.IWorker] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.cloud.tmc.kernel.worker.IWorker] */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // com.cloud.tmc.kernel.proxy.worker.IWorkerFactory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.cloud.tmc.kernel.worker.IWorker createWorker(java.lang.String r13, com.cloud.tmc.kernel.node.Node r14) {
        /*
            r12 = this;
            r0 = 0
            int r1 = r12.workerType()     // Catch: java.lang.Throwable -> L2e
            r2 = 2
            java.lang.String r3 = ""
            java.lang.Class<com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy> r4 = com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy.class
            if (r1 == r2) goto L30
            r2 = 3
            if (r1 == r2) goto L10
            goto L3d
        L10:
            java.lang.Object r1 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r4)     // Catch: java.lang.Throwable -> L2e
            com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy r1 = (com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy) r1     // Catch: java.lang.Throwable -> L2e
            com.cloud.tmc.kernel.proxy.performanceanalyse.WorkerAnalyseType r2 = com.cloud.tmc.kernel.proxy.performanceanalyse.WorkerAnalyseType.CONSOLE     // Catch: java.lang.Throwable -> L2e
            java.lang.String r4 = "worker from webview"
            r1.record(r3, r2, r4)     // Catch: java.lang.Throwable -> L2e
            com.cloud.tmc.worker.debug.WebviewWorker r1 = new com.cloud.tmc.worker.debug.WebviewWorker     // Catch: java.lang.Throwable -> L2e
            android.app.Application r8 = com.cloud.tmc.miniapp.ByteAppManager.getSApplication()     // Catch: java.lang.Throwable -> L2e
            r10 = 8
            r11 = 0
            r9 = 0
            r5 = r1
            r6 = r13
            r7 = r14
            r5.<init>(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L2e
            goto L3e
        L2e:
            r13 = move-exception
            goto L66
        L30:
            java.lang.Object r13 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r4)     // Catch: java.lang.Throwable -> L2e
            com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy r13 = (com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy) r13     // Catch: java.lang.Throwable -> L2e
            com.cloud.tmc.kernel.proxy.performanceanalyse.WorkerAnalyseType r14 = com.cloud.tmc.kernel.proxy.performanceanalyse.WorkerAnalyseType.CONSOLE     // Catch: java.lang.Throwable -> L2e
            java.lang.String r1 = "worker from quickJS"
            r13.record(r3, r14, r1)     // Catch: java.lang.Throwable -> L2e
        L3d:
            r1 = r0
        L3e:
            java.lang.Class<com.cloud.tmc.kernel.proxy.worker.JSAheadParamsProxy> r13 = com.cloud.tmc.kernel.proxy.worker.JSAheadParamsProxy.class
            java.lang.Object r13 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r13)     // Catch: java.lang.Throwable -> L53
            com.cloud.tmc.kernel.proxy.worker.JSAheadParamsProxy r13 = (com.cloud.tmc.kernel.proxy.worker.JSAheadParamsProxy) r13     // Catch: java.lang.Throwable -> L53
            java.lang.String r14 = "workerType"
            if (r1 == 0) goto L56
            int r0 = r1.type()     // Catch: java.lang.Throwable -> L53
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L53
            goto L56
        L53:
            r13 = move-exception
            r0 = r1
            goto L66
        L56:
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch: java.lang.Throwable -> L53
            kotlin.Pair r14 = kotlin.TuplesKt.a(r14, r0)     // Catch: java.lang.Throwable -> L53
            java.util.Map r14 = kotlin.collections.MapsKt.f(r14)     // Catch: java.lang.Throwable -> L53
            r13.setParams(r14)     // Catch: java.lang.Throwable -> L53
            goto L89
        L66:
            int r14 = r12.workerType()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "create worker fail : "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r13 = " ; workerType = "
            r1.append(r13)
            r1.append(r14)
            java.lang.String r13 = r1.toString()
            java.lang.String r14 = "miniapp"
            com.cloud.tmc.kernel.log.TmcLogger.e(r14, r13)
            r1 = r0
        L89:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.defaultimpl.WorkerImp.createWorker(java.lang.String, com.cloud.tmc.kernel.node.Node):com.cloud.tmc.kernel.worker.IWorker");
    }

    @Override // com.cloud.tmc.kernel.proxy.worker.IWorkerFactory
    public int workerType() {
        return 3;
    }
}
