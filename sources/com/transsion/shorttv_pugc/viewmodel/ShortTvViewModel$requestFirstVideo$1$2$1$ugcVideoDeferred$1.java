package com.transsion.shorttv_pugc.viewmodel;

import com.transsion.shorttv_pugc.ShorttvModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "Lcom/transsion/shorttv_pugc/ShorttvModel$UGCVideo;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Lcom/transsion/shorttv_pugc/ShorttvModel$UGCVideo;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel$requestFirstVideo$1$2$1$ugcVideoDeferred$1", f = "ShortTvViewModel.kt", l = {172, 174}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class ShortTvViewModel$requestFirstVideo$1$2$1$ugcVideoDeferred$1 extends SuspendLambda implements Function2<n0, Continuation<? super ShorttvModel.UGCVideo>, Object> {
    final /* synthetic */ String $collectionId;
    final /* synthetic */ String $subjectId;
    final /* synthetic */ Ref.ObjectRef<String> $ugcVideoIdMutable;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ShortTvViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvViewModel$requestFirstVideo$1$2$1$ugcVideoDeferred$1(Ref.ObjectRef<String> objectRef, ShortTvViewModel shortTvViewModel, String str, String str2, Continuation<? super ShortTvViewModel$requestFirstVideo$1$2$1$ugcVideoDeferred$1> continuation) {
        super(2, continuation);
        this.$ugcVideoIdMutable = objectRef;
        this.this$0 = shortTvViewModel;
        this.$collectionId = str;
        this.$subjectId = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ShortTvViewModel$requestFirstVideo$1$2$1$ugcVideoDeferred$1 shortTvViewModel$requestFirstVideo$1$2$1$ugcVideoDeferred$1 = new ShortTvViewModel$requestFirstVideo$1$2$1$ugcVideoDeferred$1(this.$ugcVideoIdMutable, this.this$0, this.$collectionId, this.$subjectId, continuation);
        shortTvViewModel$requestFirstVideo$1$2$1$ugcVideoDeferred$1.L$0 = obj;
        return shortTvViewModel$requestFirstVideo$1$2$1$ugcVideoDeferred$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super ShorttvModel.UGCVideo> continuation) {
        return ((ShortTvViewModel$requestFirstVideo$1$2$1$ugcVideoDeferred$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006a A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r12)
            goto L6b
        L12:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1a:
            java.lang.Object r1 = r11.L$0
            kotlinx.coroutines.n0 r1 = (kotlinx.coroutines.n0) r1
            kotlin.ResultKt.b(r12)
            goto L49
        L22:
            kotlin.ResultKt.b(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.n0 r12 = (kotlinx.coroutines.n0) r12
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r1 = r11.$ugcVideoIdMutable
            T r1 = r1.element
            r5 = r1
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L53
            com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel r1 = r11.this$0
            java.lang.String r6 = r11.$collectionId
            rt.a r4 = com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel.i(r1)
            r11.L$0 = r12
            r11.label = r3
            r7 = 0
            r9 = 4
            r10 = 0
            r8 = r11
            java.lang.Object r12 = rt.a.C0937a.b(r4, r5, r6, r7, r8, r9, r10)
            if (r12 != r0) goto L49
            return r0
        L49:
            com.tn.lib.net.bean.BaseDto r12 = (com.tn.lib.net.bean.BaseDto) r12
            java.lang.Object r12 = r12.getData()
            com.transsion.shorttv_pugc.ShorttvModel$UGCVideo r12 = (com.transsion.shorttv_pugc.ShorttvModel.UGCVideo) r12
            if (r12 != 0) goto L73
        L53:
            com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel r12 = r11.this$0
            java.lang.String r4 = r11.$subjectId
            rt.a r3 = com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel.i(r12)
            r12 = 0
            r11.L$0 = r12
            r11.label = r2
            r5 = 0
            r7 = 2
            r8 = 0
            r6 = r11
            java.lang.Object r12 = rt.a.C0937a.c(r3, r4, r5, r6, r7, r8)
            if (r12 != r0) goto L6b
            return r0
        L6b:
            com.tn.lib.net.bean.BaseDto r12 = (com.tn.lib.net.bean.BaseDto) r12
            java.lang.Object r12 = r12.getData()
            com.transsion.shorttv_pugc.ShorttvModel$UGCVideo r12 = (com.transsion.shorttv_pugc.ShorttvModel.UGCVideo) r12
        L73:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.shorttv_pugc.viewmodel.ShortTvViewModel$requestFirstVideo$1$2$1$ugcVideoDeferred$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
