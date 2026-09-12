package com.transsion.transfer.wifi.ui;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.transfer.wifi.ui.ShareMbApkDialog$onViewCreated$1", f = "ShareMbApkDialog.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class ShareMbApkDialog$onViewCreated$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ShareMbApkDialog this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareMbApkDialog$onViewCreated$1(ShareMbApkDialog shareMbApkDialog, Continuation<? super ShareMbApkDialog$onViewCreated$1> continuation) {
        super(2, continuation);
        this.this$0 = shareMbApkDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShareMbApkDialog$onViewCreated$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((ShareMbApkDialog$onViewCreated$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0051, code lost:
    
        if (r6 == null) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 != r2) goto Lf
            kotlin.ResultKt.b(r6)
            goto L39
        Lf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L17:
            kotlin.ResultKt.b(r6)
            com.transsion.transfer.wifi.qrcode.QrCodeUtil r6 = com.transsion.transfer.wifi.qrcode.QrCodeUtil.f56030a
            com.transsion.transfer.wifi.ui.ShareMbApkDialog r1 = r5.this$0
            lv.a r1 = com.transsion.transfer.wifi.ui.ShareMbApkDialog.p0(r1)
            java.lang.String r1 = r6.b(r1)
            r3 = 1131413504(0x43700000, float:240.0)
            int r4 = com.blankj.utilcode.util.a0.a(r3)
            int r3 = com.blankj.utilcode.util.a0.a(r3)
            r5.label = r2
            java.lang.Object r6 = r6.f(r1, r4, r3, r5)
            if (r6 != r0) goto L39
            return r0
        L39:
            android.graphics.Bitmap r6 = (android.graphics.Bitmap) r6
            r0 = 0
            if (r6 == 0) goto L53
            com.transsion.transfer.wifi.ui.ShareMbApkDialog r1 = r5.this$0
            gv.e r1 = com.transsion.transfer.wifi.ui.ShareMbApkDialog.o0(r1)
            if (r1 == 0) goto L50
            com.google.android.material.imageview.ShapeableImageView r1 = r1.f64118c
            if (r1 == 0) goto L50
            r1.setImageBitmap(r6)
            kotlin.Unit r6 = kotlin.Unit.f67184a
            goto L51
        L50:
            r6 = r0
        L51:
            if (r6 != 0) goto L83
        L53:
            com.transsion.transfer.wifi.ui.ShareMbApkDialog r6 = r5.this$0
            com.transsion.transfer.wifi.util.g r1 = com.transsion.transfer.wifi.util.g.f56093a
            java.lang.String r2 = r6.getClassTag()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            java.lang.String r2 = " --> createSuccess() --> syncEncodeQRCode() --> 创建二维码失败了"
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r3 = 0
            r4 = 2
            com.transsion.transfer.wifi.util.g.d(r1, r2, r3, r4, r0)
            uh.b$a r0 = uh.b.f76876a
            android.content.res.Resources r1 = r6.getResources()
            int r2 = com.transsion.transfer.R$string.transfer_fail
            java.lang.String r1 = r1.getString(r2)
            r0.e(r1)
            r6.dismissAllowingStateLoss()
        L83:
            kotlin.Unit r6 = kotlin.Unit.f67184a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.transfer.wifi.ui.ShareMbApkDialog$onViewCreated$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
