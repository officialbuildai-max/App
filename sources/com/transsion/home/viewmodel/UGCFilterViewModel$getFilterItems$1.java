package com.transsion.home.viewmodel;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.ugc.UGCFilterItem;
import com.transsion.home.bean.ugc.UGCFilterResponse;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import lg.a;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.UGCFilterViewModel$getFilterItems$1", f = "UGCFilterViewModel.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_CLOSED_BEFORE_IMPRESSION_VALUE}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class UGCFilterViewModel$getFilterItems$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $category;
    int label;
    final /* synthetic */ UGCFilterViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCFilterViewModel$getFilterItems$1(String str, UGCFilterViewModel uGCFilterViewModel, Continuation<? super UGCFilterViewModel$getFilterItems$1> continuation) {
        super(2, continuation);
        this.$category = str;
        this.this$0 = uGCFilterViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UGCFilterViewModel$getFilterItems$1(this.$category, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UGCFilterViewModel$getFilterItems$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ol.c cVar;
        List<UGCFilterItem> items;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                lg.a.f68962a.c("UGCFilterViewModel", "getFilterItems: category=" + this.$category, false);
                cVar = this.this$0.f45924e;
                String a11 = vg.a.f77447a.a();
                String str = this.$category;
                this.label = 1;
                obj = cVar.c(a11, str, this);
                if (obj == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            BaseDto baseDto = (BaseDto) obj;
            this.this$0.k().n(baseDto);
            a.C0856a c0856a = lg.a.f68962a;
            UGCFilterResponse uGCFilterResponse = (UGCFilterResponse) baseDto.getData();
            c0856a.c("UGCFilterViewModel", "getFilterItems success: items size=" + ((uGCFilterResponse == null || (items = uGCFilterResponse.getItems()) == null) ? 0 : items.size()), false);
        } catch (Exception e11) {
            e11.printStackTrace();
            this.this$0.k().n(null);
            lg.a.f68962a.i("UGCFilterViewModel", "getFilterItems error: " + e11.getMessage() + ", category=" + this.$category, true);
        }
        return Unit.f67184a;
    }
}
