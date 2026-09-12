package com.transsion.subroom.activity;

import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.startup.pref.consume.AppStartReport;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.subroom.activity.SplashActivity$startSplashAdLoad$1", f = "SplashActivity.kt", l = {194}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class SplashActivity$startSplashAdLoad$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SplashActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashActivity$startSplashAdLoad$1(SplashActivity splashActivity, Continuation<? super SplashActivity$startSplashAdLoad$1> continuation) {
        super(2, continuation);
        this.this$0 = splashActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashActivity$startSplashAdLoad$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SplashActivity$startSplashAdLoad$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        AbsAdBidding O0;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            SplashActivity.W(this.this$0, new com.transsion.ad.bidding.splash.b());
            com.transsion.ad.bidding.splash.b U = SplashActivity.U(this.this$0);
            if (U != null && (O0 = U.O0("ColdStartScene")) != null) {
                final SplashActivity splashActivity = this.this$0;
                AbsAdBidding N0 = O0.N0(new di.a() { // from class: com.transsion.subroom.activity.SplashActivity$startSplashAdLoad$1.1
                    @Override // di.a
                    public void i(TAdErrorCode tAdErrorCode) {
                        super.i(tAdErrorCode);
                        kotlinx.coroutines.k.d(androidx.view.v.a(SplashActivity.this), null, null, new SplashActivity$startSplashAdLoad$1$1$onBiddingError$1(SplashActivity.this, null), 3, null);
                    }

                    @Override // di.a
                    public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                        super.j(biddingIntermediateMaterialBean);
                        kotlinx.coroutines.k.d(androidx.view.v.a(SplashActivity.this), null, null, new SplashActivity$startSplashAdLoad$1$1$onBiddingLoad$1(SplashActivity.this, biddingIntermediateMaterialBean, null), 3, null);
                    }

                    @Override // di.a
                    public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                        super.m(biddingIntermediateMaterialBean);
                        AppStartReport.f54571a.f(new AppStartDotState(AppStartDotState.AD_END, 0L, 2, null));
                        com.transsion.startup.pref.consume.c.f54583a.q();
                    }

                    @Override // di.a
                    public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                        super.p(biddingIntermediateMaterialBean);
                        kotlinx.coroutines.k.d(androidx.view.v.a(SplashActivity.this), null, null, new SplashActivity$startSplashAdLoad$1$1$onBiddingWrapperAdShowError$1(SplashActivity.this, null), 3, null);
                    }
                });
                if (N0 != null) {
                    this.label = 1;
                    if (AbsAdBidding.w0(N0, 0, false, this, 3, null) == f11) {
                        return f11;
                    }
                }
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f67184a;
    }
}
