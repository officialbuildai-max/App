package com.transsion.ad.bidding.base;

import com.transsion.ad.monopoly.manager.AdPlansStorageManager;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;
import oi.b;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager$preLoadAd$2", f = "AbsBiddingInterceptHiSavanaAdManager.kt", l = {243}, m = "invokeSuspend")
/* loaded from: classes5.dex */
public final class AbsBiddingInterceptHiSavanaAdManager$preLoadAd$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $ctxMap;
    final /* synthetic */ String $sceneId;
    int label;
    final /* synthetic */ AbsBiddingInterceptHiSavanaAdManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsBiddingInterceptHiSavanaAdManager$preLoadAd$2(String str, Map<String, ? extends Object> map, AbsBiddingInterceptHiSavanaAdManager absBiddingInterceptHiSavanaAdManager, Continuation<? super AbsBiddingInterceptHiSavanaAdManager$preLoadAd$2> continuation) {
        super(2, continuation);
        this.$sceneId = str;
        this.$ctxMap = map;
        this.this$0 = absBiddingInterceptHiSavanaAdManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbsBiddingInterceptHiSavanaAdManager$preLoadAd$2(this.$sceneId, this.$ctxMap, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((AbsBiddingInterceptHiSavanaAdManager$preLoadAd$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean k11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.f42207a;
            String str = this.$sceneId;
            Map map = this.$ctxMap;
            if (map == null) {
                map = com.transsion.ad.strategy.d.f42285a.a(null);
            }
            this.label = 1;
            obj = AdPlansStorageManager.i(adPlansStorageManager, str, map, null, new AdPlanSourceManager.AdPlanEnum[0], this, 4, null);
            if (obj == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        List list = (List) obj;
        AbsBiddingInterceptHiSavanaAdManager absBiddingInterceptHiSavanaAdManager = this.this$0;
        b.a.c(absBiddingInterceptHiSavanaAdManager, 0, absBiddingInterceptHiSavanaAdManager.getClassTag() + " --> sceneId = " + this.$sceneId + " preload --> ctxMap: " + this.$ctxMap + ", 可用广告计划：" + list.size(), null, false, 5, null);
        if (list.isEmpty()) {
            return Unit.f67184a;
        }
        k11 = this.this$0.k(list);
        if (k11) {
            b.a.c(this.this$0, 3, "preLoadAd() --> hiId = " + this.this$0.i(), null, false, 4, null);
            ce.b e11 = this.this$0.e();
            if (e11 != null) {
                e11.preload();
            }
        }
        return Unit.f67184a;
    }
}
