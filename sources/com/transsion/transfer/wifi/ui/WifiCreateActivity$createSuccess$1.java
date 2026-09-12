package com.transsion.transfer.wifi.ui;

import android.graphics.Bitmap;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.transfer.R$id;
import com.transsion.transfer.wifi.qrcode.QrCodeUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.transfer.wifi.ui.WifiCreateActivity$createSuccess$1", f = "WifiCreateActivity.kt", l = {274, 282}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class WifiCreateActivity$createSuccess$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $duration;
    final /* synthetic */ lv.a $wifiInfoModel;
    long J$0;
    int label;
    final /* synthetic */ WifiCreateActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WifiCreateActivity$createSuccess$1(lv.a aVar, WifiCreateActivity wifiCreateActivity, long j11, Continuation<? super WifiCreateActivity$createSuccess$1> continuation) {
        super(2, continuation);
        this.$wifiInfoModel = aVar;
        this.this$0 = wifiCreateActivity;
        this.$duration = j11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WifiCreateActivity$createSuccess$1(this.$wifiInfoModel, this.this$0, this.$duration, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((WifiCreateActivity$createSuccess$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            long currentTimeMillis = System.currentTimeMillis();
            QrCodeUtil qrCodeUtil = QrCodeUtil.f56030a;
            String b11 = qrCodeUtil.b(this.$wifiInfoModel);
            this.J$0 = currentTimeMillis;
            this.label = 1;
            obj = QrCodeUtil.g(qrCodeUtil, b11, 0, 0, this, 6, null);
            if (obj == f11) {
                return f11;
            }
            j11 = currentTimeMillis;
        } else {
            if (i11 != 1) {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.f67184a;
            }
            j11 = this.J$0;
            ResultKt.b(obj);
        }
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap != null) {
            WifiCreateActivity wifiCreateActivity = this.this$0;
            long j12 = this.$duration;
            ((AppCompatImageView) wifiCreateActivity.findViewById(R$id.ivTransWifiQrCode)).setImageBitmap(bitmap);
            wifiCreateActivity.isCanceled = false;
            kv.c.f68519a.j(j12, System.currentTimeMillis() - j11);
            a2 c11 = y0.c();
            WifiCreateActivity$createSuccess$1$1$1 wifiCreateActivity$createSuccess$1$1$1 = new WifiCreateActivity$createSuccess$1$1$1(wifiCreateActivity, null);
            this.label = 2;
            if (kotlinx.coroutines.i.g(c11, wifiCreateActivity$createSuccess$1$1$1, this) == f11) {
                return f11;
            }
        } else {
            WifiCreateActivity wifiCreateActivity2 = this.this$0;
            long j13 = this.$duration;
            com.transsion.transfer.wifi.util.g.d(com.transsion.transfer.wifi.util.g.f56093a, wifiCreateActivity2.getClassTag() + " --> createSuccess() --> syncEncodeQRCode() --> 创建二维码失败了", false, 2, null);
            wifiCreateActivity2.R0(103, j13);
        }
        return Unit.f67184a;
    }
}
