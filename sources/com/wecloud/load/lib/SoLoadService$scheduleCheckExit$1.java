package com.wecloud.load.lib;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.wecloud.load.lib.SoLoadService$scheduleCheckExit$1", f = "SoLoadService.kt", l = {558}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class SoLoadService$scheduleCheckExit$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SoLoadService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SoLoadService$scheduleCheckExit$1(SoLoadService soLoadService, Continuation<? super SoLoadService$scheduleCheckExit$1> continuation) {
        super(2, continuation);
        this.this$0 = soLoadService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SoLoadService$scheduleCheckExit$1 soLoadService$scheduleCheckExit$1 = new SoLoadService$scheduleCheckExit$1(this.this$0, continuation);
        soLoadService$scheduleCheckExit$1.L$0 = obj;
        return soLoadService$scheduleCheckExit$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SoLoadService$scheduleCheckExit$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:12:0x008f
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1166)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:1022)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:55)
        */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x006e -> B:7:0x0026). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.label
            r2 = 1
            if (r1 == 0) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.n0 r1 = (kotlinx.coroutines.n0) r1
            kotlin.ResultKt.b(r11)     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
            goto L26
        L13:
            r11 = move-exception
            r6 = r11
            goto L6e
        L16:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1e:
            kotlin.ResultKt.b(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.n0 r11 = (kotlinx.coroutines.n0) r11
            r1 = r11
        L26:
            boolean r11 = kotlinx.coroutines.o0.g(r1)
            if (r11 == 0) goto L9c
            com.wecloud.load.lib.SoLoadService r11 = r10.this$0     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
            com.wecloud.load.lib.bean.SoLoadControlConfig r11 = com.wecloud.load.lib.SoLoadService.c(r11)     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
            if (r11 == 0) goto L52
            boolean r11 = r11.getExitProcess()     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
            if (r11 == 0) goto L52
            com.wecloud.load.lib.DySoLoadManager r11 = com.wecloud.load.lib.DySoLoadManager.f60929a     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
            com.wecloud.load.lib.SoLoadService r3 = r10.this$0     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
            android.app.Application r3 = r3.getApplication()     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
            java.lang.String r4 = "getApplication(...)"
            kotlin.jvm.internal.Intrinsics.g(r3, r4)     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
            java.lang.String r4 = ""
            r11.i(r3, r4)     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
            com.wecloud.load.lib.SoLoadService r11 = r10.this$0     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
            com.wecloud.load.lib.SoLoadService.p(r11)     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
            goto L5d
        L52:
            java.lang.String r11 = "SoLoadManagerExample"
            java.lang.String r3 = "exitProcess 为 false，继续监控"
            int r11 = android.util.Log.d(r11, r3)     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
            kotlin.coroutines.jvm.internal.Boxing.d(r11)     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
        L5d:
            com.wecloud.load.lib.SoLoadService r11 = r10.this$0     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
            long r3 = com.wecloud.load.lib.SoLoadService.h(r11)     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
            r10.L$0 = r1     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
            r10.label = r2     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
            java.lang.Object r11 = kotlinx.coroutines.u0.a(r3, r10)     // Catch: java.lang.Exception -> L13 java.util.concurrent.CancellationException -> L8f
            if (r11 != r0) goto L26
            return r0
        L6e:
            lg.a$a r3 = lg.a.f68962a
            java.lang.String r11 = r6.getMessage()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "监控任务异常: "
            r4.append(r5)
            r4.append(r11)
            java.lang.String r5 = r4.toString()
            r8 = 8
            r9 = 0
            java.lang.String r4 = "SoLoadManagerExample"
            r7 = 0
            lg.a.C0856a.k(r3, r4, r5, r6, r7, r8, r9)
            goto L26
        L8f:
            lg.a$a r3 = lg.a.f68962a
            r7 = 4
            r8 = 0
            java.lang.String r4 = "SoLoadManagerExample"
            java.lang.String r5 = "监控任务被取消"
            r6 = 0
            lg.a.C0856a.f(r3, r4, r5, r6, r7, r8)
            goto L26
        L9c:
            kotlin.Unit r11 = kotlin.Unit.f67184a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wecloud.load.lib.SoLoadService$scheduleCheckExit$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
