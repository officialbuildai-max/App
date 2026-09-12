package com.transsion.room.sub.viewmodel.subscription;

import bh.b;
import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
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
import lg.a;
import lq.c;
import okhttp3.RequestBody;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.room.sub.viewmodel.subscription.UgcTrendingHomeViewModel$getUgcHomeTrendingData$1", f = "UgcTrendingHomeViewModel.kt", l = {Sdk$SDKMetric.SDKMetricType.AD_VISIBILITY_VALUE}, m = "invokeSuspend")
/* loaded from: classes6.dex */
public final class UgcTrendingHomeViewModel$getUgcHomeTrendingData$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $page;
    final /* synthetic */ String $sort;
    Object L$0;
    int label;
    final /* synthetic */ UgcTrendingHomeViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UgcTrendingHomeViewModel$getUgcHomeTrendingData$1(Integer num, UgcTrendingHomeViewModel ugcTrendingHomeViewModel, String str, Continuation<? super UgcTrendingHomeViewModel$getUgcHomeTrendingData$1> continuation) {
        super(2, continuation);
        this.$page = num;
        this.this$0 = ugcTrendingHomeViewModel;
        this.$sort = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UgcTrendingHomeViewModel$getUgcHomeTrendingData$1(this.$page, this.this$0, this.$sort, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((UgcTrendingHomeViewModel$getUgcHomeTrendingData$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Integer num;
        c cVar;
        UgcTrendingHomeViewModel ugcTrendingHomeViewModel;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
        } catch (Exception e11) {
            e11.printStackTrace();
            a.C0856a c0856a = lg.a.f68962a;
            String simpleName = UgcTrendingHomeViewModel.class.getSimpleName();
            Intrinsics.g(simpleName, "getSimpleName(...)");
            c0856a.i(simpleName, "exceptionHandler " + e11.getMessage(), true);
        }
        if (i11 == 0) {
            ResultKt.b(obj);
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("page", this.$page);
            num = this.this$0.f51852c;
            jsonObject.addProperty("perPage", num);
            jsonObject.addProperty("sort", this.$sort);
            b.a aVar = b.f16553a;
            String jsonElement = jsonObject.toString();
            Intrinsics.g(jsonElement, "toString(...)");
            RequestBody a11 = aVar.a(jsonElement);
            if (a11 != null) {
                UgcTrendingHomeViewModel ugcTrendingHomeViewModel2 = this.this$0;
                cVar = ugcTrendingHomeViewModel2.f51853d;
                String a12 = vg.a.f77447a.a();
                this.L$0 = ugcTrendingHomeViewModel2;
                this.label = 1;
                obj = cVar.a(a12, a11, this);
                if (obj == f11) {
                    return f11;
                }
                ugcTrendingHomeViewModel = ugcTrendingHomeViewModel2;
            }
            return Unit.f67184a;
        }
        if (i11 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ugcTrendingHomeViewModel = (UgcTrendingHomeViewModel) this.L$0;
        ResultKt.b(obj);
        BaseDto baseDto = (BaseDto) obj;
        a.C0856a.f(lg.a.f68962a, "UgcTrendingHomeViewModel", "Feed Home Trending: " + baseDto, false, 4, null);
        ugcTrendingHomeViewModel.f().n(baseDto.getData());
        return Unit.f67184a;
    }
}
