package com.transsion.subroom.activity;

import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
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

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.subroom.activity.SplashActivity$startSplashAdLoad$1$1$onBiddingLoad$1", f = "SplashActivity.kt", l = {164}, m = "invokeSuspend")
/* loaded from: classes6.dex */
final class SplashActivity$startSplashAdLoad$1$1$onBiddingLoad$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ BiddingIntermediateMaterialBean $maxEcpmObject;
    int label;
    final /* synthetic */ SplashActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.subroom.activity.SplashActivity$startSplashAdLoad$1$1$onBiddingLoad$1$1", f = "SplashActivity.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.transsion.subroom.activity.SplashActivity$startSplashAdLoad$1$1$onBiddingLoad$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        final /* synthetic */ BiddingIntermediateMaterialBean $maxEcpmObject;
        int label;
        final /* synthetic */ SplashActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SplashActivity splashActivity, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = splashActivity;
            this.$maxEcpmObject = biddingIntermediateMaterialBean;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$maxEcpmObject, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            SplashActivity.V(this.this$0, NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, this.$maxEcpmObject);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashActivity$startSplashAdLoad$1$1$onBiddingLoad$1(SplashActivity splashActivity, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, Continuation<? super SplashActivity$startSplashAdLoad$1$1$onBiddingLoad$1> continuation) {
        super(2, continuation);
        this.this$0 = splashActivity;
        this.$maxEcpmObject = biddingIntermediateMaterialBean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashActivity$startSplashAdLoad$1$1$onBiddingLoad$1(this.this$0, this.$maxEcpmObject, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SplashActivity$startSplashAdLoad$1$1$onBiddingLoad$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            a2 c11 = y0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$maxEcpmObject, null);
            this.label = 1;
            if (kotlinx.coroutines.i.g(c11, anonymousClass1, this) == f11) {
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
