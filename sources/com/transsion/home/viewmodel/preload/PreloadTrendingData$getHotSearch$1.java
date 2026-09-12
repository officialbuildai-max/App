package com.transsion.home.viewmodel.preload;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.preload.PreloadTrendingData$getHotSearch$1", f = "PreloadTrendingData.kt", l = {TTAdConstant.IMAGE_CODE}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class PreloadTrendingData$getHotSearch$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PreloadTrendingData this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreloadTrendingData$getHotSearch$1(PreloadTrendingData preloadTrendingData, Continuation<? super PreloadTrendingData$getHotSearch$1> continuation) {
        super(2, continuation);
        this.this$0 = preloadTrendingData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PreloadTrendingData$getHotSearch$1 preloadTrendingData$getHotSearch$1 = new PreloadTrendingData$getHotSearch$1(this.this$0, continuation);
        preloadTrendingData$getHotSearch$1.L$0 = obj;
        return preloadTrendingData$getHotSearch$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PreloadTrendingData$getHotSearch$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0096  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.label
            r2 = 1
            if (r1 == 0) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r9.L$0
            com.transsion.home.viewmodel.preload.PreloadTrendingData r0 = (com.transsion.home.viewmodel.preload.PreloadTrendingData) r0
            kotlin.ResultKt.b(r10)     // Catch: java.lang.Throwable -> L13
            goto L3f
        L13:
            r10 = move-exception
            goto L83
        L16:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1e:
            kotlin.ResultKt.b(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.n0 r10 = (kotlinx.coroutines.n0) r10
            com.transsion.home.viewmodel.preload.PreloadTrendingData r10 = r9.this$0
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L13
            ol.e r3 = com.transsion.home.viewmodel.preload.PreloadTrendingData.n(r10)     // Catch: java.lang.Throwable -> L13
            r9.L$0 = r10     // Catch: java.lang.Throwable -> L13
            r9.label = r2     // Catch: java.lang.Throwable -> L13
            r4 = 0
            r5 = 2
            r7 = 1
            r8 = 0
            r6 = r9
            java.lang.Object r1 = ol.e.a.a(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L13
            if (r1 != r0) goto L3d
            return r0
        L3d:
            r0 = r10
            r10 = r1
        L3f:
            com.tn.lib.net.bean.BaseDto r10 = (com.tn.lib.net.bean.BaseDto) r10     // Catch: java.lang.Throwable -> L13
            java.lang.String r1 = r10.getCode()     // Catch: java.lang.Throwable -> L13
            java.lang.String r2 = "0"
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r1, r2)     // Catch: java.lang.Throwable -> L13
            r2 = 0
            if (r1 == 0) goto L70
            androidx.lifecycle.b0 r0 = r0.H()     // Catch: java.lang.Throwable -> L13
            java.lang.Object r1 = r10.getData()     // Catch: java.lang.Throwable -> L13
            r0.n(r1)     // Catch: java.lang.Throwable -> L13
            java.lang.Object r10 = r10.getData()     // Catch: java.lang.Throwable -> L13
            java.lang.String r10 = com.blankj.utilcode.util.o.j(r10)     // Catch: java.lang.Throwable -> L13
            if (r10 == 0) goto L7e
            com.transsion.baselib.report.launch.b r0 = com.transsion.baselib.report.launch.b.f43424a     // Catch: java.lang.Throwable -> L13
            com.tencent.mmkv.MMKV r0 = r0.b()     // Catch: java.lang.Throwable -> L13
            java.lang.String r1 = "hot_search_words"
            r0.putString(r1, r10)     // Catch: java.lang.Throwable -> L13
        L6e:
            r2 = r10
            goto L7e
        L70:
            com.transsion.home.bean.HotSubjectEntity r10 = com.transsion.home.viewmodel.preload.PreloadTrendingData.l(r0)     // Catch: java.lang.Throwable -> L13
            if (r10 == 0) goto L7e
            androidx.lifecycle.b0 r0 = r0.H()     // Catch: java.lang.Throwable -> L13
            r0.n(r10)     // Catch: java.lang.Throwable -> L13
            goto L6e
        L7e:
            java.lang.Object r10 = kotlin.Result.m1185constructorimpl(r2)     // Catch: java.lang.Throwable -> L13
            goto L8d
        L83:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r10 = kotlin.ResultKt.a(r10)
            java.lang.Object r10 = kotlin.Result.m1185constructorimpl(r10)
        L8d:
            com.transsion.home.viewmodel.preload.PreloadTrendingData r0 = r9.this$0
            java.lang.Throwable r10 = kotlin.Result.m1188exceptionOrNullimpl(r10)
            if (r10 != 0) goto L96
            goto La3
        L96:
            com.transsion.home.bean.HotSubjectEntity r10 = com.transsion.home.viewmodel.preload.PreloadTrendingData.l(r0)
            if (r10 == 0) goto La3
            androidx.lifecycle.b0 r0 = r0.H()
            r0.n(r10)
        La3:
            kotlin.Unit r10 = kotlin.Unit.f67184a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.viewmodel.preload.PreloadTrendingData$getHotSearch$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
