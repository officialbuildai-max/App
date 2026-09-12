package com.transsion.postdetail.comment.ui;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.comment.ui.CommentListViewModel$getCommentList$1", f = "CommentListViewModel.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class CommentListViewModel$getCommentList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CommentListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommentListViewModel$getCommentList$1(CommentListViewModel commentListViewModel, Continuation<? super CommentListViewModel$getCommentList$1> continuation) {
        super(2, continuation);
        this.this$0 = commentListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CommentListViewModel$getCommentList$1 commentListViewModel$getCommentList$1 = new CommentListViewModel$getCommentList$1(this.this$0, continuation);
        commentListViewModel$getCommentList$1.L$0 = obj;
        return commentListViewModel$getCommentList$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((CommentListViewModel$getCommentList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00c5  */
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
            r2 = 1
            if (r1 == 0) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r11.L$0
            com.transsion.postdetail.comment.ui.CommentListViewModel r0 = (com.transsion.postdetail.comment.ui.CommentListViewModel) r0
            kotlin.ResultKt.b(r12)     // Catch: java.lang.Throwable -> L13
            goto L61
        L13:
            r12 = move-exception
            goto Lb5
        L16:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1e:
            kotlin.ResultKt.b(r12)
            java.lang.Object r12 = r11.L$0
            kotlinx.coroutines.n0 r12 = (kotlinx.coroutines.n0) r12
            com.transsion.postdetail.comment.ui.CommentListViewModel r12 = r11.this$0
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L13
            bh.b$a r1 = bh.b.f16553a     // Catch: java.lang.Throwable -> L13
            com.transsion.postdetail.bean.PagerBody r3 = new com.transsion.postdetail.bean.PagerBody     // Catch: java.lang.Throwable -> L13
            java.lang.String r4 = com.transsion.postdetail.comment.ui.CommentListViewModel.g(r12)     // Catch: java.lang.Throwable -> L13
            int r5 = com.transsion.postdetail.comment.ui.CommentListViewModel.f(r12)     // Catch: java.lang.Throwable -> L13
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.d(r5)     // Catch: java.lang.Throwable -> L13
            r3.<init>(r4, r5)     // Catch: java.lang.Throwable -> L13
            java.lang.String r3 = com.blankj.utilcode.util.o.j(r3)     // Catch: java.lang.Throwable -> L13
            java.lang.String r4 = "toJson(...)"
            kotlin.jvm.internal.Intrinsics.g(r3, r4)     // Catch: java.lang.Throwable -> L13
            okhttp3.RequestBody r6 = r1.a(r3)     // Catch: java.lang.Throwable -> L13
            if (r6 != 0) goto L4c
            goto Lae
        L4c:
            xo.a r5 = com.transsion.postdetail.comment.ui.CommentListViewModel.e(r12)     // Catch: java.lang.Throwable -> L13
            r11.L$0 = r12     // Catch: java.lang.Throwable -> L13
            r11.label = r2     // Catch: java.lang.Throwable -> L13
            r7 = 0
            r9 = 2
            r10 = 0
            r8 = r11
            java.lang.Object r1 = xo.a.C0990a.a(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L13
            if (r1 != r0) goto L5f
            return r0
        L5f:
            r0 = r12
            r12 = r1
        L61:
            com.tn.lib.net.bean.BaseDto r12 = (com.tn.lib.net.bean.BaseDto) r12     // Catch: java.lang.Throwable -> L13
            java.lang.Object r12 = r12.getData()     // Catch: java.lang.Throwable -> L13
            com.transsion.postdetail.bean.MyCommentListBean r12 = (com.transsion.postdetail.bean.MyCommentListBean) r12     // Catch: java.lang.Throwable -> L13
            if (r12 == 0) goto Lae
            com.transsion.postdetail.bean.Pager r1 = r12.getPager()     // Catch: java.lang.Throwable -> L13
            if (r1 == 0) goto L8e
            java.lang.String r3 = r1.getNextPage()     // Catch: java.lang.Throwable -> L13
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L13
            com.transsion.postdetail.comment.ui.CommentListViewModel.i(r0, r3)     // Catch: java.lang.Throwable -> L13
            r1.getNextPage()     // Catch: java.lang.Throwable -> L13
            java.lang.Boolean r1 = r1.getHasMore()     // Catch: java.lang.Throwable -> L13
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.a(r2)     // Catch: java.lang.Throwable -> L13
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r1, r2)     // Catch: java.lang.Throwable -> L13
            com.transsion.postdetail.comment.ui.CommentListViewModel.h(r0, r1)     // Catch: java.lang.Throwable -> L13
        L8e:
            java.util.List r1 = com.transsion.postdetail.comment.ui.CommentListViewModel.d(r0)     // Catch: java.lang.Throwable -> L13
            java.util.List r12 = r12.getCommentList()     // Catch: java.lang.Throwable -> L13
            if (r12 == 0) goto L9b
        L98:
            java.util.Collection r12 = (java.util.Collection) r12     // Catch: java.lang.Throwable -> L13
            goto La0
        L9b:
            java.util.List r12 = kotlin.collections.CollectionsKt.l()     // Catch: java.lang.Throwable -> L13
            goto L98
        La0:
            r1.addAll(r12)     // Catch: java.lang.Throwable -> L13
            androidx.lifecycle.b0 r12 = r0.m()     // Catch: java.lang.Throwable -> L13
            java.util.List r0 = com.transsion.postdetail.comment.ui.CommentListViewModel.d(r0)     // Catch: java.lang.Throwable -> L13
            r12.n(r0)     // Catch: java.lang.Throwable -> L13
        Lae:
            kotlin.Unit r12 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L13
            java.lang.Object r12 = kotlin.Result.m1185constructorimpl(r12)     // Catch: java.lang.Throwable -> L13
            goto Lbf
        Lb5:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r12 = kotlin.ResultKt.a(r12)
            java.lang.Object r12 = kotlin.Result.m1185constructorimpl(r12)
        Lbf:
            java.lang.Throwable r12 = kotlin.Result.m1188exceptionOrNullimpl(r12)
            if (r12 == 0) goto Ld2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "error:"
            r0.append(r1)
            r0.append(r12)
        Ld2:
            kotlin.Unit r12 = kotlin.Unit.f67184a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.comment.ui.CommentListViewModel$getCommentList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
