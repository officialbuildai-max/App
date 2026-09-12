package com.transsion.ugcvideodetail.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getFirstVideoDetailBySubject$1", f = "UGCImmVideoDetailViewModel.kt", l = {141, 157, 163}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UGCImmVideoDetailViewModel$getFirstVideoDetailBySubject$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $subjectId;
    Object L$0;
    int label;
    final /* synthetic */ UGCImmVideoDetailViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCImmVideoDetailViewModel$getFirstVideoDetailBySubject$1(UGCImmVideoDetailViewModel uGCImmVideoDetailViewModel, String str, Continuation<? super UGCImmVideoDetailViewModel$getFirstVideoDetailBySubject$1> continuation) {
        super(2, continuation);
        this.this$0 = uGCImmVideoDetailViewModel;
        this.$subjectId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCImmVideoDetailViewModel$getFirstVideoDetailBySubject$1(this.this$0, this.$subjectId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCImmVideoDetailViewModel$getFirstVideoDetailBySubject$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c6 A[RETURN] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object, com.transsion.ugcvideodetail.api.bean.UGCVideo] */
    /* JADX WARN: Type inference failed for: r1v7 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L31
            if (r1 == r4) goto L2b
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            kotlin.ResultKt.b(r13)
            goto Lc7
        L17:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1f:
            java.lang.Object r1 = r12.L$0
            com.transsion.ugcvideodetail.api.bean.UGCVideo r1 = (com.transsion.ugcvideodetail.api.bean.UGCVideo) r1
            kotlin.ResultKt.b(r13)     // Catch: java.lang.Throwable -> L28
            goto L9b
        L28:
            r13 = move-exception
            goto L9e
        L2b:
            kotlin.ResultKt.b(r13)     // Catch: java.lang.Throwable -> L2f
            goto L49
        L2f:
            r13 = move-exception
            goto L61
        L31:
            kotlin.ResultKt.b(r13)
            com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel r13 = r12.this$0     // Catch: java.lang.Throwable -> L2f
            rv.a r6 = com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel.t0(r13)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r7 = r12.$subjectId     // Catch: java.lang.Throwable -> L2f
            r12.label = r4     // Catch: java.lang.Throwable -> L2f
            r8 = 0
            r10 = 2
            r11 = 0
            r9 = r12
            java.lang.Object r13 = rv.a.C0938a.e(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L2f
            if (r13 != r0) goto L49
            return r0
        L49:
            com.tn.lib.net.bean.BaseDto r13 = (com.tn.lib.net.bean.BaseDto) r13     // Catch: java.lang.Throwable -> L2f
            java.lang.String r1 = r13.getCode()     // Catch: java.lang.Throwable -> L2f
            java.lang.String r4 = "0"
            boolean r1 = kotlin.jvm.internal.Intrinsics.c(r1, r4)     // Catch: java.lang.Throwable -> L2f
            if (r1 != 0) goto L59
            r13 = r5
            goto L5f
        L59:
            java.lang.Object r13 = r13.getData()     // Catch: java.lang.Throwable -> L2f
            com.transsion.ugcvideodetail.api.bean.UGCVideo r13 = (com.transsion.ugcvideodetail.api.bean.UGCVideo) r13     // Catch: java.lang.Throwable -> L2f
        L5f:
            r1 = r13
            goto L7d
        L61:
            lg.a$a r6 = lg.a.f68962a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "getVideoDetailBySubject error:"
            r1.append(r4)
            r1.append(r13)
            java.lang.String r8 = r1.toString()
            r10 = 4
            r11 = 0
            java.lang.String r7 = "UGCImmVideoDetailViewModel"
            r9 = 0
            lg.a.C0856a.l(r6, r7, r8, r9, r10, r11)
            r1 = r5
        L7d:
            if (r1 == 0) goto L84
            java.lang.String r13 = r1.getUgcVideoId()     // Catch: java.lang.Throwable -> L28
            goto L85
        L84:
            r13 = r5
        L85:
            if (r13 == 0) goto Lb9
            int r4 = r13.length()     // Catch: java.lang.Throwable -> L28
            if (r4 != 0) goto L8e
            goto Lb9
        L8e:
            com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel r4 = r12.this$0     // Catch: java.lang.Throwable -> L28
            r12.L$0 = r1     // Catch: java.lang.Throwable -> L28
            r12.label = r3     // Catch: java.lang.Throwable -> L28
            java.lang.Object r13 = com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel.q0(r4, r13, r12)     // Catch: java.lang.Throwable -> L28
            if (r13 != r0) goto L9b
            return r0
        L9b:
            com.transsion.ugcvideodetail.api.bean.UGCVideoPlayInfo r13 = (com.transsion.ugcvideodetail.api.bean.UGCVideoPlayInfo) r13     // Catch: java.lang.Throwable -> L28
            goto Lba
        L9e:
            lg.a$a r6 = lg.a.f68962a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "getVideoPlayInfoBySubject error:"
            r3.append(r4)
            r3.append(r13)
            java.lang.String r8 = r3.toString()
            r10 = 4
            r11 = 0
            java.lang.String r7 = "UGCImmVideoDetailViewModel"
            r9 = 0
            lg.a.C0856a.l(r6, r7, r8, r9, r10, r11)
        Lb9:
            r13 = r5
        Lba:
            com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel r3 = r12.this$0
            r12.L$0 = r5
            r12.label = r2
            java.lang.Object r13 = com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel.z0(r3, r1, r13, r12)
            if (r13 != r0) goto Lc7
            return r0
        Lc7:
            kotlin.Unit r13 = kotlin.Unit.f67184a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.viewmodel.UGCImmVideoDetailViewModel$getFirstVideoDetailBySubject$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
