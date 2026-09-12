package com.transsion.postdetail.ui.activity;

import com.transsion.postdetail.bean.ReportReason;
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
@DebugMetadata(c = "com.transsion.postdetail.ui.activity.PostFeedbackInputActivity$onSubmit$1", f = "PostFeedbackInputActivity.kt", l = {174, 195}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class PostFeedbackInputActivity$onSubmit$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReportReason $selectedReason;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PostFeedbackInputActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostFeedbackInputActivity$onSubmit$1(PostFeedbackInputActivity postFeedbackInputActivity, ReportReason reportReason, Continuation<? super PostFeedbackInputActivity$onSubmit$1> continuation) {
        super(2, continuation);
        this.this$0 = postFeedbackInputActivity;
        this.$selectedReason = reportReason;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PostFeedbackInputActivity$onSubmit$1 postFeedbackInputActivity$onSubmit$1 = new PostFeedbackInputActivity$onSubmit$1(this.this$0, this.$selectedReason, continuation);
        postFeedbackInputActivity$onSubmit$1.L$0 = obj;
        return postFeedbackInputActivity$onSubmit$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PostFeedbackInputActivity$onSubmit$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00eb A[Catch: all -> 0x001c, TryCatch #1 {all -> 0x001c, blocks: (B:6:0x0015, B:8:0x0146, B:43:0x00b4, B:45:0x00ca, B:48:0x00d3, B:50:0x00eb, B:51:0x00f4, B:53:0x0102, B:57:0x012a, B:60:0x0115), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0102 A[Catch: all -> 0x001c, TryCatch #1 {all -> 0x001c, blocks: (B:6:0x0015, B:8:0x0146, B:43:0x00b4, B:45:0x00ca, B:48:0x00d3, B:50:0x00eb, B:51:0x00f4, B:53:0x0102, B:57:0x012a, B:60:0x0115), top: B:2:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0145 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.activity.PostFeedbackInputActivity$onSubmit$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
