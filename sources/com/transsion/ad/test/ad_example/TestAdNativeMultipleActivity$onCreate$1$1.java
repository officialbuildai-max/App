package com.transsion.ad.test.ad_example;

import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.test.ad_example.TestAdNativeMultipleActivity;
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
@DebugMetadata(c = "com.transsion.ad.test.ad_example.TestAdNativeMultipleActivity$onCreate$1$1", f = "TestAdNativeMultipleActivity.kt", l = {84}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class TestAdNativeMultipleActivity$onCreate$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TestAdNativeMultipleActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TestAdNativeMultipleActivity$onCreate$1$1(TestAdNativeMultipleActivity testAdNativeMultipleActivity, Continuation<? super TestAdNativeMultipleActivity$onCreate$1$1> continuation) {
        super(2, continuation);
        this.this$0 = testAdNativeMultipleActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TestAdNativeMultipleActivity$onCreate$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((TestAdNativeMultipleActivity$onCreate$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TestAdNativeMultipleActivity.a aVar;
        BiddingNativeManager biddingNativeManager;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            BiddingNativeManager biddingNativeManager2 = this.this$0.nativeManager;
            if (biddingNativeManager2 == null) {
                Intrinsics.z("nativeManager");
                biddingNativeManager2 = null;
            }
            biddingNativeManager2.O0("MBNativeTestId");
            BiddingNativeManager biddingNativeManager3 = this.this$0.nativeManager;
            if (biddingNativeManager3 == null) {
                Intrinsics.z("nativeManager");
                biddingNativeManager3 = null;
            }
            biddingNativeManager3.M0(null);
            BiddingNativeManager biddingNativeManager4 = this.this$0.nativeManager;
            if (biddingNativeManager4 == null) {
                Intrinsics.z("nativeManager");
                biddingNativeManager4 = null;
            }
            biddingNativeManager4.L0(this.this$0);
            BiddingNativeManager biddingNativeManager5 = this.this$0.nativeManager;
            if (biddingNativeManager5 == null) {
                Intrinsics.z("nativeManager");
                biddingNativeManager5 = null;
            }
            aVar = this.this$0.nativeListener;
            biddingNativeManager5.N0(aVar);
            BiddingNativeManager biddingNativeManager6 = this.this$0.nativeManager;
            if (biddingNativeManager6 == null) {
                Intrinsics.z("nativeManager");
                biddingNativeManager = null;
            } else {
                biddingNativeManager = biddingNativeManager6;
            }
            this.label = 1;
            if (AbsAdBidding.w0(biddingNativeManager, 3, false, this, 2, null) == f11) {
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
