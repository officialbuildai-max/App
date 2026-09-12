package com.transsion.ad.test.ad_example;

import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.transsion.ad.bidding.base.AbsAdBidding;
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
@DebugMetadata(c = "com.transsion.ad.test.ad_example.TestAdBannerActivity$onCreate$1$1", f = "TestAdBannerActivity.kt", l = {RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class TestAdBannerActivity$onCreate$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TestAdBannerActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestAdBannerActivity$onCreate$1$1(TestAdBannerActivity testAdBannerActivity, Continuation<? super TestAdBannerActivity$onCreate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = testAdBannerActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdBannerActivity$onCreate$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((TestAdBannerActivity$onCreate$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        com.transsion.ad.bidding.banner.a aVar;
        com.transsion.ad.bidding.banner.a aVar2;
        com.transsion.ad.bidding.banner.a aVar3;
        com.transsion.ad.bidding.banner.a aVar4;
        com.transsion.ad.bidding.banner.a aVar5;
        com.transsion.ad.bidding.banner.a aVar6;
        TestAdBannerActivity$bannerListener$1 testAdBannerActivity$bannerListener$1;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            aVar = this.this$0.bannerManager;
            if (aVar != null) {
                aVar.V();
            }
            this.this$0.bannerManager = new com.transsion.ad.bidding.banner.a();
            aVar2 = this.this$0.bannerManager;
            if (aVar2 != null) {
                aVar2.O0("MBBannerTestId");
            }
            aVar3 = this.this$0.bannerManager;
            if (aVar3 != null) {
                aVar3.M0(null);
            }
            aVar4 = this.this$0.bannerManager;
            if (aVar4 != null) {
                aVar4.L0(this.this$0);
            }
            aVar5 = this.this$0.bannerManager;
            if (aVar5 != null) {
                testAdBannerActivity$bannerListener$1 = this.this$0.bannerListener;
                aVar5.N0(testAdBannerActivity$bannerListener$1);
            }
            aVar6 = this.this$0.bannerManager;
            if (aVar6 != null) {
                this.label = 1;
                if (AbsAdBidding.w0(aVar6, 0, false, this, 3, null) == f11) {
                    return f11;
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
