package com.transsion.home.viewmodel;

import bh.b;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.home.bean.OperateItem;
import com.transsion.home.bean.TrendingRequestEntity;
import com.transsion.home.bean.TrendingRespData;
import com.transsion.home.bean.TrendingRespItem;
import com.vungle.ads.internal.protos.Sdk$SDKError;
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
@DebugMetadata(c = "com.transsion.home.viewmodel.SubTabViewModel$getTrendingList$1", f = "SubTabViewModel.kt", l = {Sdk$SDKError.Reason.AD_RESPONSE_EMPTY_VALUE, Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class SubTabViewModel$getTrendingList$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ TrendingRequestEntity $requestEntity;
    final /* synthetic */ String $tabCode;
    final /* synthetic */ int $tabId;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SubTabViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubTabViewModel$getTrendingList$1(TrendingRequestEntity trendingRequestEntity, SubTabViewModel subTabViewModel, String str, int i11, Continuation<? super SubTabViewModel$getTrendingList$1> continuation) {
        super(2, continuation);
        this.$requestEntity = trendingRequestEntity;
        this.this$0 = subTabViewModel;
        this.$tabCode = str;
        this.$tabId = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SubTabViewModel$getTrendingList$1 subTabViewModel$getTrendingList$1 = new SubTabViewModel$getTrendingList$1(this.$requestEntity, this.this$0, this.$tabCode, this.$tabId, continuation);
        subTabViewModel$getTrendingList$1.L$0 = obj;
        return subTabViewModel$getTrendingList$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SubTabViewModel$getTrendingList$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        n0 n0Var;
        boolean z10;
        String valueOf;
        boolean z11;
        ol.e eVar;
        SubTabViewModel subTabViewModel;
        ol.e eVar2;
        BaseDto baseDto;
        boolean z12;
        List<TrendingRespItem> l11;
        List<OperateItem> l12;
        List<TrendingRespItem> l13;
        List<TrendingRespItem> items;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
        } catch (Exception e11) {
            a.C0856a.f(lg.a.f68962a, "SubTabViewModel", String.valueOf(e11.getMessage()), false, 4, null);
            e11.printStackTrace();
            this.this$0.s().n(null);
        }
        if (i11 == 0) {
            ResultKt.b(obj);
            n0Var = (n0) this.L$0;
            TrendingRequestEntity trendingRequestEntity = this.$requestEntity;
            z10 = this.this$0.f45888g;
            if (z10) {
                valueOf = this.$tabCode;
                if (valueOf == null) {
                    valueOf = "";
                }
            } else {
                valueOf = String.valueOf(this.$tabId);
            }
            trendingRequestEntity.setTabId(valueOf);
            this.$requestEntity.setDisablePlaylist(Boxing.a(false));
            b.a aVar = bh.b.f16553a;
            String j11 = com.blankj.utilcode.util.o.j(this.$requestEntity);
            Intrinsics.g(j11, "toJson(...)");
            RequestBody a11 = aVar.a(j11);
            if (a11 != null) {
                SubTabViewModel subTabViewModel2 = this.this$0;
                z11 = subTabViewModel2.f45888g;
                if (z11) {
                    eVar2 = subTabViewModel2.f45886e;
                    String a12 = vg.a.f77447a.a();
                    this.L$0 = n0Var;
                    this.L$1 = subTabViewModel2;
                    this.label = 1;
                    obj = eVar2.d(a12, a11, this);
                    if (obj == f11) {
                        return f11;
                    }
                    subTabViewModel = subTabViewModel2;
                    baseDto = (BaseDto) obj;
                } else {
                    eVar = subTabViewModel2.f45886e;
                    String a13 = vg.a.f77447a.a();
                    this.L$0 = n0Var;
                    this.L$1 = subTabViewModel2;
                    this.label = 2;
                    obj = eVar.b(a13, a11, this);
                    if (obj == f11) {
                        return f11;
                    }
                    subTabViewModel = subTabViewModel2;
                    baseDto = (BaseDto) obj;
                }
            }
            return Unit.f67184a;
        }
        if (i11 == 1) {
            subTabViewModel = (SubTabViewModel) this.L$1;
            n0Var = (n0) this.L$0;
            ResultKt.b(obj);
            baseDto = (BaseDto) obj;
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            subTabViewModel = (SubTabViewModel) this.L$1;
            n0Var = (n0) this.L$0;
            ResultKt.b(obj);
            baseDto = (BaseDto) obj;
        }
        if (Intrinsics.c(baseDto.getCode(), "0")) {
            a.C0856a c0856a = lg.a.f68962a;
            TrendingRespData trendingRespData = (TrendingRespData) baseDto.getData();
            a.C0856a.f(c0856a, "SubTabViewModel", "success " + ((trendingRespData == null || (items = trendingRespData.getItems()) == null) ? null : Boxing.d(items.size())) + " " + n0Var + "@PostListViewModel", false, 4, null);
            z12 = subTabViewModel.f45888g;
            if (z12) {
                TrendingRespData trendingRespData2 = (TrendingRespData) baseDto.getData();
                if (trendingRespData2 == null || (l13 = trendingRespData2.getItems()) == null) {
                    l13 = CollectionsKt.l();
                }
                l12 = subTabViewModel.m(l13);
            } else {
                TrendingRespData trendingRespData3 = (TrendingRespData) baseDto.getData();
                if (trendingRespData3 == null || (l11 = trendingRespData3.getItems()) == null) {
                    l11 = CollectionsKt.l();
                }
                l12 = subTabViewModel.l(l11);
            }
            TrendingRespData trendingRespData4 = (TrendingRespData) baseDto.getData();
            if (trendingRespData4 != null) {
                trendingRespData4.setTransferData(l12);
            }
            subTabViewModel.s().n(baseDto.getData());
        } else {
            a.C0856a.f(lg.a.f68962a, "SubTabViewModel", "code " + baseDto.getCode() + " message " + baseDto.getMsg(), false, 4, null);
        }
        return Unit.f67184a;
    }
}
