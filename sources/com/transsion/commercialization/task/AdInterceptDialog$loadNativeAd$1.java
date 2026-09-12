package com.transsion.commercialization.task;

import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
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
@DebugMetadata(c = "com.transsion.commercialization.task.AdInterceptDialog$loadNativeAd$1", f = "AdInterceptDialog.kt", l = {269}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class AdInterceptDialog$loadNativeAd$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AdInterceptDialog this$0;

    /* loaded from: classes5.dex */
    public static final class a extends di.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AdInterceptDialog f43898d;

        a(AdInterceptDialog adInterceptDialog) {
            this.f43898d = adInterceptDialog;
        }

        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            this.f43898d.R0();
        }

        @Override // di.a
        public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.j(biddingIntermediateMaterialBean);
            this.f43898d.adObject = biddingIntermediateMaterialBean;
            this.f43898d.R0();
            this.f43898d.y0();
        }

        @Override // di.a
        public void l(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            super.l(biddingIntermediateMaterialBean);
            this.f43898d.E0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdInterceptDialog$loadNativeAd$1(AdInterceptDialog adInterceptDialog, Continuation<? super AdInterceptDialog$loadNativeAd$1> continuation) {
        super(2, continuation);
        this.this$0 = adInterceptDialog;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdInterceptDialog$loadNativeAd$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((AdInterceptDialog$loadNativeAd$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BiddingNativeManager biddingNativeManager;
        BiddingNativeManager biddingNativeManager2;
        BiddingNativeManager biddingNativeManager3;
        BiddingNativeManager biddingNativeManager4;
        String str;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            this.this$0.nativeManager = new BiddingNativeManager();
            biddingNativeManager = this.this$0.nativeManager;
            if (biddingNativeManager != null) {
                biddingNativeManager.O0("DownloadInterceptDialogNativeScene");
            }
            biddingNativeManager2 = this.this$0.nativeManager;
            if (biddingNativeManager2 != null) {
                com.transsion.ad.strategy.d dVar = com.transsion.ad.strategy.d.f42285a;
                str = this.this$0.mGenre;
                biddingNativeManager2.M0(dVar.a(str));
            }
            biddingNativeManager3 = this.this$0.nativeManager;
            if (biddingNativeManager3 != null) {
                biddingNativeManager3.N0(new a(this.this$0));
            }
            biddingNativeManager4 = this.this$0.nativeManager;
            if (biddingNativeManager4 != null) {
                this.label = 1;
                if (AbsAdBidding.w0(biddingNativeManager4, 0, false, this, 3, null) == f11) {
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
