package com.transsion.usercenter.me;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.usercenter.me.MeViewmodel$fetchHistory$1", f = "MeViewmodel.kt", l = {150, 152, 153}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class MeViewmodel$fetchHistory$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ MeViewmodel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeViewmodel$fetchHistory$1(MeViewmodel meViewmodel, Continuation<? super MeViewmodel$fetchHistory$1> continuation) {
        super(2, continuation);
        this.this$0 = meViewmodel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MeViewmodel$fetchHistory$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MeViewmodel$fetchHistory$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0099 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x009f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L2f
            if (r1 == r4) goto L2b
            if (r1 == r3) goto L23
            if (r1 != r2) goto L1b
            java.lang.Object r0 = r6.L$0
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r7)
            goto L9b
        L1b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L23:
            java.lang.Object r1 = r6.L$0
            java.util.List r1 = (java.util.List) r1
            kotlin.ResultKt.b(r7)
            goto L81
        L2b:
            kotlin.ResultKt.b(r7)
            goto L55
        L2f:
            kotlin.ResultKt.b(r7)
            ak.o r7 = ak.o.f721a
            boolean r7 = r7.i()
            if (r7 == 0) goto L40
            java.util.List r7 = kotlin.collections.CollectionsKt.l()
        L3e:
            r1 = r7
            goto L5e
        L40:
            com.transsion.usercenter.me.MeViewmodel r7 = r6.this$0
            com.transsion.baselib.db.video.VideoDetailPlayDao r7 = com.transsion.usercenter.me.MeViewmodel.s(r7)
            com.transsion.usercenter.me.MeViewmodel r1 = r6.this$0
            int r1 = com.transsion.usercenter.me.MeViewmodel.k(r1)
            r6.label = r4
            java.lang.Object r7 = r7.d(r5, r1, r6)
            if (r7 != r0) goto L55
            return r0
        L55:
            java.util.List r7 = (java.util.List) r7
            if (r7 != 0) goto L3e
            java.util.List r7 = kotlin.collections.CollectionsKt.l()
            goto L3e
        L5e:
            ak.o r7 = ak.o.f721a
            boolean r7 = r7.i()
            if (r7 == 0) goto L6a
            kotlin.collections.CollectionsKt.l()
            goto L83
        L6a:
            com.transsion.usercenter.me.MeViewmodel r7 = r6.this$0
            com.transsion.baselib.db.video.ShortTVPlayDao r7 = com.transsion.usercenter.me.MeViewmodel.q(r7)
            com.transsion.usercenter.me.MeViewmodel r4 = r6.this$0
            int r4 = com.transsion.usercenter.me.MeViewmodel.k(r4)
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r7.d(r5, r4, r6)
            if (r7 != r0) goto L81
            return r0
        L81:
            java.util.List r7 = (java.util.List) r7
        L83:
            com.transsion.usercenter.me.MeViewmodel r7 = r6.this$0
            com.transsion.baselib.db.video.UGCVideoDetailPlayDao r7 = com.transsion.usercenter.me.MeViewmodel.r(r7)
            com.transsion.usercenter.me.MeViewmodel r3 = r6.this$0
            int r3 = com.transsion.usercenter.me.MeViewmodel.k(r3)
            r6.L$0 = r1
            r6.label = r2
            java.lang.Object r7 = r7.d(r5, r3, r6)
            if (r7 != r0) goto L9a
            return r0
        L9a:
            r0 = r1
        L9b:
            java.util.List r7 = (java.util.List) r7
            if (r7 != 0) goto La3
            java.util.List r7 = kotlin.collections.CollectionsKt.l()
        La3:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            r1.addAll(r0)
            java.util.Collection r7 = (java.util.Collection) r7
            r1.addAll(r7)
            com.transsion.usercenter.me.MeViewmodel$fetchHistory$1$invokeSuspend$$inlined$sortedByDescending$1 r7 = new com.transsion.usercenter.me.MeViewmodel$fetchHistory$1$invokeSuspend$$inlined$sortedByDescending$1
            r7.<init>()
            java.util.List r7 = kotlin.collections.CollectionsKt.I0(r1, r7)
            com.transsion.usercenter.me.MeViewmodel r0 = r6.this$0
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            int r1 = com.transsion.usercenter.me.MeViewmodel.k(r0)
            java.util.List r7 = kotlin.collections.CollectionsKt.K0(r7, r1)
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.List r7 = kotlin.collections.CollectionsKt.U0(r7)
            com.transsion.usercenter.me.MeViewmodel.w(r0, r7)
            com.transsion.usercenter.me.MeViewmodel r7 = r6.this$0
            com.transsion.usercenter.me.MeViewmodel.v(r7)
            com.transsion.usercenter.me.MeViewmodel r7 = r6.this$0
            androidx.lifecycle.b0 r7 = r7.C()
            com.transsion.usercenter.me.MeViewmodel r0 = r6.this$0
            java.util.List r0 = com.transsion.usercenter.me.MeViewmodel.l(r0)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.List r0 = kotlin.collections.CollectionsKt.U0(r0)
            r7.n(r0)
            kotlin.Unit r7 = kotlin.Unit.f67184a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.usercenter.me.MeViewmodel$fetchHistory$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
