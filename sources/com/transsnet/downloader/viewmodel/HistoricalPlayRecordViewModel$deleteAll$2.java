package com.transsnet.downloader.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteAll$2", f = "HistoricalPlayRecordViewModel.kt", l = {364, 365, 366}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class HistoricalPlayRecordViewModel$deleteAll$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $callback;
    int label;
    final /* synthetic */ HistoricalPlayRecordViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoricalPlayRecordViewModel$deleteAll$2(HistoricalPlayRecordViewModel historicalPlayRecordViewModel, Function0<Unit> function0, Continuation<? super HistoricalPlayRecordViewModel$deleteAll$2> continuation) {
        super(2, continuation);
        this.this$0 = historicalPlayRecordViewModel;
        this.$callback = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoricalPlayRecordViewModel$deleteAll$2(this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((HistoricalPlayRecordViewModel$deleteAll$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0054 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L25
            if (r1 == r4) goto L21
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.b(r6)
            goto L55
        L15:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1d:
            kotlin.ResultKt.b(r6)
            goto L46
        L21:
            kotlin.ResultKt.b(r6)
            goto L37
        L25:
            kotlin.ResultKt.b(r6)
            com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel r6 = r5.this$0
            com.transsion.baselib.db.video.VideoDetailPlayDao r6 = com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel.w(r6)
            r5.label = r4
            java.lang.Object r6 = r6.a(r5)
            if (r6 != r0) goto L37
            return r0
        L37:
            com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel r6 = r5.this$0
            com.transsion.baselib.db.video.ShortTVPlayDao r6 = com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel.t(r6)
            r5.label = r3
            java.lang.Object r6 = r6.a(r5)
            if (r6 != r0) goto L46
            return r0
        L46:
            com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel r6 = r5.this$0
            com.transsion.baselib.db.video.UGCVideoDetailPlayDao r6 = com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel.v(r6)
            r5.label = r2
            java.lang.Object r6 = r6.a(r5)
            if (r6 != r0) goto L55
            return r0
        L55:
            kotlin.jvm.functions.Function0<kotlin.Unit> r6 = r5.$callback
            r6.invoke()
            my.d r6 = new my.d
            r6.<init>()
            com.transsnet.flow.event.AppScopeVMlProvider r0 = com.transsnet.flow.event.AppScopeVMlProvider.INSTANCE
            java.lang.Class<com.transsnet.flow.event.FlowEventBus> r1 = com.transsnet.flow.event.FlowEventBus.class
            androidx.lifecycle.t0 r0 = r0.getApplicationScopeViewModel(r1)
            com.transsnet.flow.event.FlowEventBus r0 = (com.transsnet.flow.event.FlowEventBus) r0
            java.lang.Class<my.d> r1 = my.d.class
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "getName(...)"
            kotlin.jvm.internal.Intrinsics.g(r1, r2)
            r2 = 0
            r0.postEvent(r1, r6, r2)
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.viewmodel.HistoricalPlayRecordViewModel$deleteAll$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
