package com.transsion.postdetail.ui.fragment;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$setSubtitle$1", f = "LocalVideoDetailFragment.kt", l = {1504, 1510}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class LocalVideoDetailFragment$setSubtitle$1 extends SuspendLambda implements Function2<kotlinx.coroutines.n0, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LocalVideoDetailFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoDetailFragment$setSubtitle$1(LocalVideoDetailFragment localVideoDetailFragment, Continuation<? super LocalVideoDetailFragment$setSubtitle$1> continuation) {
        super(2, continuation);
        this.this$0 = localVideoDetailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalVideoDetailFragment$setSubtitle$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.n0 n0Var, Continuation<? super Unit> continuation) {
        return ((LocalVideoDetailFragment$setSubtitle$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r13.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L27
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.b(r14)
            goto La8
        L13:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L1b:
            java.lang.Object r1 = r13.L$1
            com.transsion.baselib.db.download.DownloadBean r1 = (com.transsion.baselib.db.download.DownloadBean) r1
            java.lang.Object r4 = r13.L$0
            com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment r4 = (com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment) r4
            kotlin.ResultKt.b(r14)
            goto L4b
        L27:
            kotlin.ResultKt.b(r14)
            com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment r14 = r13.this$0
            com.transsion.baselib.db.download.DownloadBean r1 = com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment.Q0(r14)
            if (r1 == 0) goto La8
            com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment r4 = r13.this$0
            com.transsion.subtitle.h$a r14 = com.transsion.subtitle.h.f55010a
            com.transsion.subtitle.h r14 = r14.b()
            java.lang.String r5 = r1.getSubtitleResId()
            r13.L$0 = r4
            r13.L$1 = r1
            r13.label = r3
            java.lang.Object r14 = r14.a(r5, r13)
            if (r14 != r0) goto L4b
            return r0
        L4b:
            java.util.List r14 = (java.util.List) r14
            lg.a$a r5 = lg.a.f68962a
            com.transsion.baselib.report.a r6 = com.transsion.baselib.report.a.f43394a
            java.lang.String r6 = r6.a()
            java.lang.String r7 = r1.getTotalTitleName()
            java.lang.String r8 = r1.getSubtitleResId()
            r9 = 0
            if (r14 == 0) goto L69
            int r10 = r14.size()
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.d(r10)
            goto L6a
        L69:
            r10 = r9
        L6a:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "----- setSubtitle, name:"
            r11.append(r12)
            r11.append(r7)
            java.lang.String r7 = ", subtitleResId:"
            r11.append(r7)
            r11.append(r8)
            java.lang.String r7 = ", size = "
            r11.append(r7)
            r11.append(r10)
            java.lang.String r7 = r11.toString()
            java.lang.String[] r7 = new java.lang.String[]{r7}
            r5.p(r6, r7, r3)
            kotlinx.coroutines.a2 r3 = kotlinx.coroutines.y0.c()
            com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$setSubtitle$1$1$1 r5 = new com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$setSubtitle$1$1$1
            r5.<init>(r14, r4, r1, r9)
            r13.L$0 = r9
            r13.L$1 = r9
            r13.label = r2
            java.lang.Object r14 = kotlinx.coroutines.i.g(r3, r5, r13)
            if (r14 != r0) goto La8
            return r0
        La8:
            kotlin.Unit r14 = kotlin.Unit.f67184a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$setSubtitle$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
