package com.transsion.shorttv.ad.common;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv.ad.common.STCommonNativeAdHelper$loadAd$1", f = "STCommonNativeAdHelper.kt", l = {134}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class STCommonNativeAdHelper$loadAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    int label;
    final /* synthetic */ STCommonNativeAdHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public STCommonNativeAdHelper$loadAd$1(STCommonNativeAdHelper sTCommonNativeAdHelper, Function1<? super Boolean, Unit> function1, Continuation<? super STCommonNativeAdHelper$loadAd$1> continuation) {
        super(2, continuation);
        this.this$0 = sTCommonNativeAdHelper;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new STCommonNativeAdHelper$loadAd$1(this.this$0, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((STCommonNativeAdHelper$loadAd$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00aa  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L10
            goto L91
        L10:
            r8 = move-exception
            goto L98
        L13:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1b:
            kotlin.ResultKt.b(r8)
            com.transsion.shorttv.ad.common.STCommonNativeAdHelper r8 = r7.this$0
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r1 = r7.$callback
            kotlin.Result$Companion r3 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L10
            r3 = 3
            r8.m(r3)     // Catch: java.lang.Throwable -> L10
            ur.a r3 = ur.a.f77012a     // Catch: java.lang.Throwable -> L10
            java.lang.String r4 = r8.o()     // Catch: java.lang.Throwable -> L10
            java.lang.String r5 = "trigger load ad"
            java.lang.String r6 = r8.p()     // Catch: java.lang.Throwable -> L10
            r3.b(r4, r5, r6)     // Catch: java.lang.Throwable -> L10
            com.transsion.shorttv.ad.AdLoadState r3 = com.transsion.shorttv.ad.AdLoadState.LOADING     // Catch: java.lang.Throwable -> L10
            com.transsion.shorttv.ad.common.STCommonNativeAdHelper.h(r8, r3)     // Catch: java.lang.Throwable -> L10
            com.transsion.shorttv.ad.common.STCommonNativeAdHelper.g(r8, r1)     // Catch: java.lang.Throwable -> L10
            com.transsion.ad.bidding.nativead.BiddingNativeManager r1 = new com.transsion.ad.bidding.nativead.BiddingNativeManager     // Catch: java.lang.Throwable -> L10
            r1.<init>()     // Catch: java.lang.Throwable -> L10
            com.transsion.shorttv.ad.common.STCommonNativeAdHelper.k(r8, r1)     // Catch: java.lang.Throwable -> L10
            com.transsion.ad.bidding.nativead.BiddingNativeManager r1 = com.transsion.shorttv.ad.common.STCommonNativeAdHelper.d(r8)     // Catch: java.lang.Throwable -> L10
            if (r1 == 0) goto L54
            java.lang.String r3 = r8.p()     // Catch: java.lang.Throwable -> L10
            r1.O0(r3)     // Catch: java.lang.Throwable -> L10
        L54:
            com.transsion.ad.bidding.nativead.BiddingNativeManager r1 = com.transsion.shorttv.ad.common.STCommonNativeAdHelper.d(r8)     // Catch: java.lang.Throwable -> L10
            r3 = 0
            if (r1 == 0) goto L5e
            r1.M0(r3)     // Catch: java.lang.Throwable -> L10
        L5e:
            com.transsion.ad.bidding.nativead.BiddingNativeManager r1 = com.transsion.shorttv.ad.common.STCommonNativeAdHelper.d(r8)     // Catch: java.lang.Throwable -> L10
            if (r1 == 0) goto L70
            android.content.Context r4 = com.cloud.sdk.commonutil.util.e.a()     // Catch: java.lang.Throwable -> L10
            java.lang.String r5 = "getContext(...)"
            kotlin.jvm.internal.Intrinsics.g(r4, r5)     // Catch: java.lang.Throwable -> L10
            r1.L0(r4)     // Catch: java.lang.Throwable -> L10
        L70:
            com.transsion.ad.bidding.nativead.BiddingNativeManager r1 = com.transsion.shorttv.ad.common.STCommonNativeAdHelper.d(r8)     // Catch: java.lang.Throwable -> L10
            if (r1 == 0) goto L7d
            com.transsion.shorttv.ad.common.STCommonNativeAdHelper$nativeAdListener$1 r4 = com.transsion.shorttv.ad.common.STCommonNativeAdHelper.c(r8)     // Catch: java.lang.Throwable -> L10
            r1.N0(r4)     // Catch: java.lang.Throwable -> L10
        L7d:
            com.transsion.ad.bidding.nativead.BiddingNativeManager r1 = com.transsion.shorttv.ad.common.STCommonNativeAdHelper.d(r8)     // Catch: java.lang.Throwable -> L10
            if (r1 == 0) goto L93
            r7.label = r2     // Catch: java.lang.Throwable -> L10
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            r4 = r7
            java.lang.Object r8 = com.transsion.ad.bidding.base.AbsAdBidding.w0(r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L10
            if (r8 != r0) goto L91
            return r0
        L91:
            kotlin.Unit r3 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L10
        L93:
            java.lang.Object r8 = kotlin.Result.m1185constructorimpl(r3)     // Catch: java.lang.Throwable -> L10
            goto La2
        L98:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r8 = kotlin.ResultKt.a(r8)
            java.lang.Object r8 = kotlin.Result.m1185constructorimpl(r8)
        La2:
            com.transsion.shorttv.ad.common.STCommonNativeAdHelper r0 = r7.this$0
            java.lang.Throwable r8 = kotlin.Result.m1188exceptionOrNullimpl(r8)
            if (r8 == 0) goto Laf
            com.transsion.shorttv.ad.AdLoadState r8 = com.transsion.shorttv.ad.AdLoadState.IDLE
            com.transsion.shorttv.ad.common.STCommonNativeAdHelper.h(r0, r8)
        Laf:
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv.ad.common.STCommonNativeAdHelper$loadAd$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
