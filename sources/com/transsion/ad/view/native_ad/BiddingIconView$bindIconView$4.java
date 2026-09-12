package com.transsion.ad.view.native_ad;

import android.widget.TextView;
import com.blankj.utilcode.util.i;
import com.transsion.ad.bidding.base.w;
import com.transsion.ad.ps.model.ItemDetail;
import com.transsion.ad.ps.model.RecommendInfo;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "Landroid/widget/TextView;", "<anonymous>", "(Lkotlinx/coroutines/n0;)Landroid/widget/TextView;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.view.native_ad.BiddingIconView$bindIconView$4", f = "BiddingIconView.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class BiddingIconView$bindIconView$4 extends SuspendLambda implements Function2<n0, Continuation<? super TextView>, Object> {
    final /* synthetic */ w $adProviderBean;
    int label;
    final /* synthetic */ BiddingIconView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiddingIconView$bindIconView$4(w wVar, BiddingIconView biddingIconView, Continuation<? super BiddingIconView$bindIconView$4> continuation) {
        super(2, continuation);
        this.$adProviderBean = wVar;
        this.this$0 = biddingIconView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiddingIconView$bindIconView$4(this.$adProviderBean, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super TextView> continuation) {
        return ((BiddingIconView$bindIconView$4) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ItemDetail detail;
        String sourceSize;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Integer d11 = this.$adProviderBean.d();
        if (d11 == null) {
            return null;
        }
        w wVar = this.$adProviderBean;
        BiddingIconView biddingIconView = this.this$0;
        TextView textView = (TextView) wVar.i().findViewById(d11.intValue());
        if (textView == null) {
            return null;
        }
        RecommendInfo mRecommendInfo = biddingIconView.getMRecommendInfo();
        textView.setText(i.b((mRecommendInfo == null || (detail = mRecommendInfo.getDetail()) == null || (sourceSize = detail.getSourceSize()) == null) ? 0L : Long.parseLong(sourceSize), 1));
        return textView;
    }
}
