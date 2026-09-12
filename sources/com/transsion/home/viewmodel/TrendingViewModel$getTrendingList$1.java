package com.transsion.home.viewmodel;

import bh.b;
import com.tencent.mmkv.MMKV;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.TrendingRequestEntity;
import com.transsion.home.bean.TrendingRespData;
import com.transsion.home.bean.TrendingRespItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.transsion.home.viewmodel.TrendingViewModel$getTrendingList$1", f = "TrendingViewModel.kt", l = {87}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class TrendingViewModel$getTrendingList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $nextPage;
    final /* synthetic */ TrendingRequestEntity $requestEntity;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ TrendingViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrendingViewModel$getTrendingList$1(TrendingRequestEntity trendingRequestEntity, TrendingViewModel trendingViewModel, String str, Continuation<? super TrendingViewModel$getTrendingList$1> continuation) {
        super(2, continuation);
        this.$requestEntity = trendingRequestEntity;
        this.this$0 = trendingViewModel;
        this.$nextPage = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        TrendingViewModel$getTrendingList$1 trendingViewModel$getTrendingList$1 = new TrendingViewModel$getTrendingList$1(this.$requestEntity, this.this$0, this.$nextPage, continuation);
        trendingViewModel$getTrendingList$1.L$0 = obj;
        return trendingViewModel$getTrendingList$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((TrendingViewModel$getTrendingList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        n0 n0Var;
        TrendingViewModel trendingViewModel;
        ol.e eVar;
        String str;
        Integer perRow;
        List<TrendingRespItem> items;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        boolean z10 = true;
        try {
        } catch (Exception e11) {
            a.C0856a.f(lg.a.f68962a, "TrendingViewModel", String.valueOf(e11.getMessage()), false, 4, null);
            e11.printStackTrace();
            this.this$0.X().n(null);
        }
        if (i11 == 0) {
            ResultKt.b(obj);
            n0Var = (n0) this.L$0;
            b.a aVar = bh.b.f16553a;
            String j11 = com.blankj.utilcode.util.o.j(this.$requestEntity);
            Intrinsics.g(j11, "toJson(...)");
            RequestBody a11 = aVar.a(j11);
            if (a11 != null) {
                trendingViewModel = this.this$0;
                String str2 = this.$nextPage;
                eVar = trendingViewModel.f45908o;
                String a12 = vg.a.f77447a.a();
                this.L$0 = n0Var;
                this.L$1 = trendingViewModel;
                this.L$2 = str2;
                this.label = 1;
                obj = eVar.b(a12, a11, this);
                if (obj == f11) {
                    return f11;
                }
                str = str2;
            }
            return Unit.f67184a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        str = (String) this.L$2;
        trendingViewModel = (TrendingViewModel) this.L$1;
        n0Var = (n0) this.L$0;
        ResultKt.b(obj);
        BaseDto baseDto = (BaseDto) obj;
        if (Intrinsics.c(baseDto.getCode(), "0")) {
            a.C0856a c0856a = lg.a.f68962a;
            TrendingRespData trendingRespData = (TrendingRespData) baseDto.getData();
            a.C0856a.f(c0856a, "TrendingViewModel", "success " + ((trendingRespData == null || (items = trendingRespData.getItems()) == null) ? null : Boxing.d(items.size())) + " " + n0Var + "@PostListViewModel", false, 4, null);
            trendingViewModel.X().n(baseDto.getData());
            if (Intrinsics.c(str, "1")) {
                MMKV b11 = rl.e.f74676a.b();
                TrendingRespData trendingRespData2 = (TrendingRespData) baseDto.getData();
                if (trendingRespData2 != null && (perRow = trendingRespData2.getPerRow()) != null && perRow.intValue() == 1) {
                    z10 = false;
                }
                b11.putBoolean("trending_operation_grid_feeds", z10);
            }
        } else {
            a.C0856a.f(lg.a.f68962a, "TrendingViewModel", "code " + baseDto.getCode() + " message " + baseDto.getMsg(), false, 4, null);
            trendingViewModel.X().n(baseDto.getData());
        }
        return Unit.f67184a;
    }
}
