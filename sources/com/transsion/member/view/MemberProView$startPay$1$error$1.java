package com.transsion.member.view;

import android.app.Activity;
import android.content.Context;
import com.transsion.member.R$string;
import com.transsion.member.dialog.PayFailedDialog;
import com.transsion.memberapi.MemberPriceItem;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.member.view.MemberProView$startPay$1$error$1", f = "MemberProView.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
final class MemberProView$startPay$1$error$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $errorCode;
    final /* synthetic */ String $message;
    int label;
    final /* synthetic */ MemberProView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberProView$startPay$1$error$1(MemberProView memberProView, Integer num, String str, Continuation<? super MemberProView$startPay$1$error$1> continuation) {
        super(2, continuation);
        this.this$0 = memberProView;
        this.$errorCode = num;
        this.$message = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(MemberProView memberProView) {
        MemberPriceItem memberPriceItem;
        memberPriceItem = memberProView.selectedSkuItem;
        if (memberPriceItem != null) {
            String skuId = memberPriceItem.getSkuId();
            if (skuId == null) {
                skuId = "";
            }
            MemberProView.x(memberProView, skuId, false, 2, null);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(MemberProView memberProView) {
        memberProView.k();
        return Unit.f67184a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MemberProView$startPay$1$error$1(this.this$0, this.$errorCode, this.$message, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((MemberProView$startPay$1$error$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        WeakReference weakReference;
        zm.f fVar;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        PayFailedDialog a11 = PayFailedDialog.INSTANCE.a();
        Context context = this.this$0.getContext();
        PayFailedDialog y02 = a11.y0(context != null ? context.getString(R$string.member_pay_failed) : null);
        Context context2 = this.this$0.getContext();
        PayFailedDialog u02 = y02.u0(context2 != null ? context2.getString(R$string.member_pay_failed_dialog_content) : null);
        Context context3 = this.this$0.getContext();
        PayFailedDialog x02 = u02.x0(context3 != null ? context3.getString(R$string.member_pay_failed_dialog_retry) : null);
        Context context4 = this.this$0.getContext();
        PayFailedDialog t02 = x02.t0(context4 != null ? context4.getString(R$string.member_pay_failed_dialog_feedback) : null);
        final MemberProView memberProView = this.this$0;
        PayFailedDialog w02 = t02.w0(new Function0() { // from class: com.transsion.member.view.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit g11;
                g11 = MemberProView$startPay$1$error$1.g(MemberProView.this);
                return g11;
            }
        });
        final MemberProView memberProView2 = this.this$0;
        PayFailedDialog v02 = w02.v0(new Function0() { // from class: com.transsion.member.view.g0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit h11;
                h11 = MemberProView$startPay$1$error$1.h(MemberProView.this);
                return h11;
            }
        });
        weakReference = this.this$0.hostActivity;
        v02.k0(weakReference != null ? (Activity) weakReference.get() : null, "PayFailedDialog");
        fVar = this.this$0.purchaseListener;
        if (fVar != null) {
            fVar.a(this.$errorCode, this.$message);
        }
        return Unit.f67184a;
    }
}
