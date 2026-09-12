package com.transsion.wrapperad.view;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.wrapperad.view.DownloadTopIrregularView$onScroll$2", f = "DownloadTopIrregularView.kt", l = {135}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class DownloadTopIrregularView$onScroll$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ ViewGroup.MarginLayoutParams $layoutParams;
    final /* synthetic */ int $mCurrentTopMargin;
    final /* synthetic */ int $maxTopMargin;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DownloadTopIrregularView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadTopIrregularView$onScroll$2(DownloadTopIrregularView downloadTopIrregularView, int i11, int i12, ViewGroup.MarginLayoutParams marginLayoutParams, Continuation<? super DownloadTopIrregularView$onScroll$2> continuation) {
        super(2, continuation);
        this.this$0 = downloadTopIrregularView;
        this.$maxTopMargin = i11;
        this.$mCurrentTopMargin = i12;
        this.$layoutParams = marginLayoutParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadTopIrregularView$onScroll$2(this.this$0, this.$maxTopMargin, this.$mCurrentTopMargin, this.$layoutParams, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadTopIrregularView$onScroll$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x006d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0064 -> B:5:0x0067). Please report as a decompilation issue!!! */
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
            if (r1 == 0) goto L25
            if (r1 != r2) goto L1d
            int r1 = r9.I$2
            int r3 = r9.I$1
            int r4 = r9.I$0
            java.lang.Object r5 = r9.L$1
            com.transsion.wrapperad.view.DownloadTopIrregularView r5 = (com.transsion.wrapperad.view.DownloadTopIrregularView) r5
            java.lang.Object r6 = r9.L$0
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            kotlin.ResultKt.b(r10)
            goto L67
        L1d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L25:
            kotlin.ResultKt.b(r10)
            com.transsion.wrapperad.view.DownloadTopIrregularView r10 = r9.this$0
            com.transsion.ad.view.native_ad.NativeWrapperAdView r10 = com.transsion.wrapperad.view.DownloadTopIrregularView.access$getNativeWrapperAdView$p(r10)
            jg.c.k(r10)
            com.transsion.wrapperad.view.DownloadTopIrregularView r10 = r9.this$0
            android.widget.ImageView r10 = com.transsion.wrapperad.view.DownloadTopIrregularView.access$getCloseImg$p(r10)
            jg.c.k(r10)
            int r10 = r9.$maxTopMargin
            int r1 = r9.$mCurrentTopMargin
            int r10 = r10 - r1
            int r10 = r10 / 10
            android.view.ViewGroup$MarginLayoutParams r3 = r9.$layoutParams
            com.transsion.wrapperad.view.DownloadTopIrregularView r4 = r9.this$0
            r5 = 0
            r6 = r3
            r3 = r1
            r1 = r5
            r5 = r4
            r4 = r10
        L4b:
            if (r1 >= r4) goto L72
            int r10 = r1 * 10
            int r10 = r10 + r3
            r6.topMargin = r10
            r9.L$0 = r6
            r9.L$1 = r5
            r9.I$0 = r4
            r9.I$1 = r3
            r9.I$2 = r1
            r9.label = r2
            r7 = 4
            java.lang.Object r10 = kotlinx.coroutines.u0.a(r7, r9)
            if (r10 != r0) goto L67
            return r0
        L67:
            android.view.ViewGroup r10 = com.transsion.wrapperad.view.DownloadTopIrregularView.access$getMGeminiViewGroup$p(r5)
            if (r10 == 0) goto L70
            r10.setLayoutParams(r6)
        L70:
            int r1 = r1 + r2
            goto L4b
        L72:
            kotlin.Unit r10 = kotlin.Unit.f67184a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.wrapperad.view.DownloadTopIrregularView$onScroll$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
