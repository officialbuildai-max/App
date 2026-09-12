package com.transsion.home.viewmodel;

import bh.b;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.TrendingRequestEntity;
import com.transsion.home.bean.TrendingRespData;
import com.transsion.home.bean.TrendingRespItem;
import com.transsion.moviedetailapi.bean.Pager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import lg.a;
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.home.viewmodel.TrendingUGCViewModel$requestFeedsList$1", f = "TrendingUGCViewModel.kt", l = {274}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class TrendingUGCViewModel$requestFeedsList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ TrendingRequestEntity $requestEntity;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ TrendingUGCViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendingUGCViewModel$requestFeedsList$1(TrendingRequestEntity trendingRequestEntity, TrendingUGCViewModel trendingUGCViewModel, Continuation<? super TrendingUGCViewModel$requestFeedsList$1> continuation) {
        super(2, continuation);
        this.$requestEntity = trendingRequestEntity;
        this.this$0 = trendingUGCViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TrendingUGCViewModel$requestFeedsList$1 trendingUGCViewModel$requestFeedsList$1 = new TrendingUGCViewModel$requestFeedsList$1(this.$requestEntity, this.this$0, continuation);
        trendingUGCViewModel$requestFeedsList$1.L$0 = obj;
        return trendingUGCViewModel$requestFeedsList$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((TrendingUGCViewModel$requestFeedsList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        n0 n0Var;
        ol.e C;
        TrendingUGCViewModel trendingUGCViewModel;
        List<OperateItem> t11;
        String str;
        Integer perPage;
        List<TrendingRespItem> items;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
            try {
            } catch (Exception e11) {
                a.C0856a.f(lg.a.f68962a, "TrendingUGCFragment", String.valueOf(e11.getMessage()), false, 4, null);
                e11.printStackTrace();
                this.this$0.E().n(null);
            }
            if (i11 == 0) {
                ResultKt.b(obj);
                n0Var = (n0) this.L$0;
                b.a aVar = bh.b.f16553a;
                String j11 = com.blankj.utilcode.util.o.j(this.$requestEntity);
                Intrinsics.g(j11, "toJson(...)");
                RequestBody a11 = aVar.a(j11);
                if (a11 != null) {
                    TrendingUGCViewModel trendingUGCViewModel2 = this.this$0;
                    C = trendingUGCViewModel2.C();
                    String a12 = vg.a.f77447a.a();
                    this.L$0 = n0Var;
                    this.L$1 = trendingUGCViewModel2;
                    this.label = 1;
                    obj = C.i(a12, a11, this);
                    if (obj == f11) {
                        return f11;
                    }
                    trendingUGCViewModel = trendingUGCViewModel2;
                }
                return Unit.f67184a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            trendingUGCViewModel = (TrendingUGCViewModel) this.L$1;
            n0Var = (n0) this.L$0;
            ResultKt.b(obj);
            BaseDto baseDto = (BaseDto) obj;
            TrendingRespData trendingRespData = (TrendingRespData) baseDto.getData();
            if (Intrinsics.c(baseDto.getCode(), "0")) {
                a.C0856a.f(lg.a.f68962a, "TrendingUGCFragment", "success " + ((trendingRespData == null || (items = trendingRespData.getItems()) == null) ? null : Boxing.d(items.size())) + " " + n0Var + "@PostListViewModel", false, 4, null);
                if ((trendingRespData != null ? trendingRespData.getPager() : null) != null) {
                    Pager pager = trendingRespData.getPager();
                    if (pager == null || (str = pager.getNextPage()) == null) {
                        str = "1";
                    }
                    trendingUGCViewModel.f45892b = str;
                    Pager pager2 = trendingRespData.getPager();
                    trendingUGCViewModel.f45893c = (pager2 == null || (perPage = pager2.getPerPage()) == null) ? 14 : perPage.intValue();
                }
            } else {
                a.C0856a.f(lg.a.f68962a, "TrendingUGCFragment", "code " + baseDto.getCode() + " message " + baseDto.getMsg(), false, 4, null);
            }
            if (trendingRespData != null) {
                List<TrendingRespItem> items2 = trendingRespData.getItems();
                if (items2 == null) {
                    items2 = CollectionsKt.l();
                }
                t11 = trendingUGCViewModel.t(items2);
                trendingRespData.setTransferData(t11);
            }
            trendingUGCViewModel.E().n(trendingRespData);
            return Unit.f67184a;
        } finally {
            this.this$0.f45894d = false;
        }
    }
}
