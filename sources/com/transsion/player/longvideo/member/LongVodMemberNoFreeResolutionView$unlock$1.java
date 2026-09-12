package com.transsion.player.longvideo.member;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.player.longvideo.member.LongVodMemberNoFreeResolutionView$unlock$1", f = "LongVodMemberNoFreeResolutionView.kt", l = {231, 232}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class LongVodMemberNoFreeResolutionView$unlock$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LongVodMemberNoFreeResolutionView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongVodMemberNoFreeResolutionView$unlock$1(LongVodMemberNoFreeResolutionView longVodMemberNoFreeResolutionView, Continuation<? super LongVodMemberNoFreeResolutionView$unlock$1> continuation) {
        super(2, continuation);
        this.this$0 = longVodMemberNoFreeResolutionView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LongVodMemberNoFreeResolutionView$unlock$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((LongVodMemberNoFreeResolutionView$unlock$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0045  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r5)
            goto L3d
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            kotlin.ResultKt.b(r5)
            goto L32
        L1e:
            kotlin.ResultKt.b(r5)
            com.transsion.player.longvideo.member.ResolutionMemberManager r5 = com.transsion.player.longvideo.member.ResolutionMemberManager.f48259a
            com.transsion.player.longvideo.member.LongVodMemberNoFreeResolutionView r1 = r4.this$0
            go.a r1 = com.transsion.player.longvideo.member.LongVodMemberNoFreeResolutionView.access$getBean$p(r1)
            r4.label = r3
            java.lang.Object r5 = r5.i(r1, r4)
            if (r5 != r0) goto L32
            return r0
        L32:
            r4.label = r2
            r1 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r5 = kotlinx.coroutines.u0.a(r1, r4)
            if (r5 != r0) goto L3d
            return r0
        L3d:
            com.transsion.player.longvideo.member.LongVodMemberNoFreeResolutionView r5 = r4.this$0
            zm.b r5 = com.transsion.player.longvideo.member.LongVodMemberNoFreeResolutionView.access$getListener$p(r5)
            if (r5 == 0) goto L48
            r5.onSuccess()
        L48:
            kotlin.Unit r5 = kotlin.Unit.f67184a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.player.longvideo.member.LongVodMemberNoFreeResolutionView$unlock$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
