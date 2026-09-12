package com.transsion.wrapperad.view;

import android.view.ViewGroup;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.wrapperad.view.DownloadTopIrregularView$onScroll$1", f = "DownloadTopIrregularView.kt", l = {Sdk$SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class DownloadTopIrregularView$onScroll$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ ViewGroup.MarginLayoutParams $layoutParams;
    final /* synthetic */ int $mCurrentTopMargin;
    final /* synthetic */ int $minTopMargin;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DownloadTopIrregularView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadTopIrregularView$onScroll$1(int i11, int i12, DownloadTopIrregularView downloadTopIrregularView, ViewGroup.MarginLayoutParams marginLayoutParams, Continuation<? super DownloadTopIrregularView$onScroll$1> continuation) {
        super(2, continuation);
        this.$mCurrentTopMargin = i11;
        this.$minTopMargin = i12;
        this.this$0 = downloadTopIrregularView;
        this.$layoutParams = marginLayoutParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadTopIrregularView$onScroll$1(this.$mCurrentTopMargin, this.$minTopMargin, this.this$0, this.$layoutParams, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DownloadTopIrregularView$onScroll$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0055 -> B:5:0x0058). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.label
            r2 = 1
            if (r1 == 0) goto L25
            if (r1 != r2) goto L1d
            int r1 = r10.I$2
            int r3 = r10.I$1
            int r4 = r10.I$0
            java.lang.Object r5 = r10.L$1
            com.transsion.wrapperad.view.DownloadTopIrregularView r5 = (com.transsion.wrapperad.view.DownloadTopIrregularView) r5
            java.lang.Object r6 = r10.L$0
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            kotlin.ResultKt.b(r11)
            goto L58
        L1d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L25:
            kotlin.ResultKt.b(r11)
            int r11 = r10.$mCurrentTopMargin
            int r1 = r10.$minTopMargin
            int r1 = r11 - r1
            int r1 = r1 / 10
            android.view.ViewGroup$MarginLayoutParams r3 = r10.$layoutParams
            com.transsion.wrapperad.view.DownloadTopIrregularView r4 = r10.this$0
            r5 = 0
            r6 = r3
            r3 = r11
            r9 = r4
            r4 = r1
            r1 = r5
            r5 = r9
        L3b:
            if (r1 >= r4) goto L63
            int r11 = r1 * 10
            int r11 = r3 - r11
            r6.topMargin = r11
            r10.L$0 = r6
            r10.L$1 = r5
            r10.I$0 = r4
            r10.I$1 = r3
            r10.I$2 = r1
            r10.label = r2
            r7 = 4
            java.lang.Object r11 = kotlinx.coroutines.u0.a(r7, r10)
            if (r11 != r0) goto L58
            return r0
        L58:
            android.view.ViewGroup r11 = com.transsion.wrapperad.view.DownloadTopIrregularView.access$getMGeminiViewGroup$p(r5)
            if (r11 == 0) goto L61
            r11.setLayoutParams(r6)
        L61:
            int r1 = r1 + r2
            goto L3b
        L63:
            com.transsion.wrapperad.view.DownloadTopIrregularView r11 = r10.this$0
            com.transsion.ad.view.native_ad.NativeWrapperAdView r11 = com.transsion.wrapperad.view.DownloadTopIrregularView.access$getNativeWrapperAdView$p(r11)
            jg.c.g(r11)
            com.transsion.wrapperad.view.DownloadTopIrregularView r11 = r10.this$0
            android.widget.ImageView r11 = com.transsion.wrapperad.view.DownloadTopIrregularView.access$getCloseImg$p(r11)
            jg.c.g(r11)
            kotlin.Unit r11 = kotlin.Unit.f67184a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.wrapperad.view.DownloadTopIrregularView$onScroll$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
