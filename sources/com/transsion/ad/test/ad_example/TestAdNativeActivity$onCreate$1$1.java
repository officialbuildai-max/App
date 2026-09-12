package com.transsion.ad.test.ad_example;

import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.test.ad_example.TestAdNativeActivity$onCreate$1$1", f = "TestAdNativeActivity.kt", l = {69}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class TestAdNativeActivity$onCreate$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TestAdNativeActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestAdNativeActivity$onCreate$1$1(TestAdNativeActivity testAdNativeActivity, Continuation<? super TestAdNativeActivity$onCreate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = testAdNativeActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdNativeActivity$onCreate$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((TestAdNativeActivity$onCreate$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BiddingNativeManager biddingNativeManager;
        BiddingNativeManager biddingNativeManager2;
        BiddingNativeManager biddingNativeManager3;
        BiddingNativeManager biddingNativeManager4;
        TestAdNativeActivity$nativeListener$1 testAdNativeActivity$nativeListener$1;
        BiddingNativeManager biddingNativeManager5;
        BiddingNativeManager biddingNativeManager6;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            biddingNativeManager = this.this$0.nativeManager;
            if (biddingNativeManager == null) {
                Intrinsics.z("nativeManager");
                biddingNativeManager = null;
            }
            biddingNativeManager.O0("MBNativeTestId");
            biddingNativeManager2 = this.this$0.nativeManager;
            if (biddingNativeManager2 == null) {
                Intrinsics.z("nativeManager");
                biddingNativeManager2 = null;
            }
            biddingNativeManager2.M0(null);
            biddingNativeManager3 = this.this$0.nativeManager;
            if (biddingNativeManager3 == null) {
                Intrinsics.z("nativeManager");
                biddingNativeManager3 = null;
            }
            biddingNativeManager3.L0(this.this$0);
            biddingNativeManager4 = this.this$0.nativeManager;
            if (biddingNativeManager4 == null) {
                Intrinsics.z("nativeManager");
                biddingNativeManager4 = null;
            }
            testAdNativeActivity$nativeListener$1 = this.this$0.nativeListener;
            biddingNativeManager4.N0(testAdNativeActivity$nativeListener$1);
            biddingNativeManager5 = this.this$0.nativeManager;
            if (biddingNativeManager5 == null) {
                Intrinsics.z("nativeManager");
                biddingNativeManager6 = null;
            } else {
                biddingNativeManager6 = biddingNativeManager5;
            }
            this.label = 1;
            if (AbsAdBidding.w0(biddingNativeManager6, 0, false, this, 3, null) == f11) {
                return f11;
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
