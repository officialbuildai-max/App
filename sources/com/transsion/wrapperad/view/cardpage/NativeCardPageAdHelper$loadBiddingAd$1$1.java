package com.transsion.wrapperad.view.cardpage;

import android.content.Context;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.nativead.BiddingSspNativeManager;
import com.transsion.wrapperad.view.cardpage.NativeCardPageAdHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.wrapperad.view.cardpage.NativeCardPageAdHelper$loadBiddingAd$1$1", f = "NativeCardPageAdHelper.kt", l = {85}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class NativeCardPageAdHelper$loadBiddingAd$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ NativeCardPageView $it;
    int label;
    final /* synthetic */ NativeCardPageAdHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeCardPageAdHelper$loadBiddingAd$1$1(NativeCardPageAdHelper nativeCardPageAdHelper, NativeCardPageView nativeCardPageView, Continuation<? super NativeCardPageAdHelper$loadBiddingAd$1$1> continuation) {
        super(2, continuation);
        this.this$0 = nativeCardPageAdHelper;
        this.$it = nativeCardPageView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NativeCardPageAdHelper$loadBiddingAd$1$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((NativeCardPageAdHelper$loadBiddingAd$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        BiddingSspNativeManager biddingSspNativeManager;
        BiddingSspNativeManager biddingSspNativeManager2;
        BiddingSspNativeManager biddingSspNativeManager3;
        BiddingSspNativeManager biddingSspNativeManager4;
        String str;
        BiddingSspNativeManager biddingSspNativeManager5;
        NativeCardPageAdHelper.c cVar;
        Map map;
        String str2;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            this.this$0.f58421k = new BiddingSspNativeManager();
            biddingSspNativeManager = this.this$0.f58421k;
            if (biddingSspNativeManager != null) {
                str2 = this.this$0.f58422l;
                biddingSspNativeManager.O0(str2);
            }
            biddingSspNativeManager2 = this.this$0.f58421k;
            if (biddingSspNativeManager2 != null) {
                map = this.this$0.f58423m;
                biddingSspNativeManager2.M0(map);
            }
            biddingSspNativeManager3 = this.this$0.f58421k;
            if (biddingSspNativeManager3 != null) {
                Context context = this.$it.getContext();
                Intrinsics.g(context, "getContext(...)");
                biddingSspNativeManager3.L0(context);
            }
            biddingSspNativeManager4 = this.this$0.f58421k;
            if (biddingSspNativeManager4 != null) {
                cVar = this.this$0.f58424n;
                biddingSspNativeManager4.N0(cVar);
            }
            com.transsion.ad.scene.a aVar = com.transsion.ad.scene.a.f42255a;
            str = this.this$0.f58422l;
            int i12 = RangesKt.i(RangesKt.f(aVar.g(str), 1), 3);
            biddingSspNativeManager5 = this.this$0.f58421k;
            if (biddingSspNativeManager5 != null) {
                this.label = 1;
                if (AbsAdBidding.w0(biddingSspNativeManager5, i12, false, this, 2, null) == f11) {
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
