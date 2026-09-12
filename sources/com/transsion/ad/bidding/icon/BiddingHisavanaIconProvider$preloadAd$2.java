package com.transsion.ad.bidding.icon;

import com.transsion.ad.monopoly.manager.AdPlansStorageManager;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.bidding.icon.BiddingHisavanaIconProvider$preloadAd$2", f = "BiddingHisavanaIconProvider.kt", l = {109}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class BiddingHisavanaIconProvider$preloadAd$2 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $ctxMap;
    final /* synthetic */ String $sceneId;
    int label;
    final /* synthetic */ BiddingHisavanaIconProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BiddingHisavanaIconProvider$preloadAd$2(String str, BiddingHisavanaIconProvider biddingHisavanaIconProvider, Map<String, ? extends Object> map, Continuation<? super BiddingHisavanaIconProvider$preloadAd$2> continuation) {
        super(2, continuation);
        this.$sceneId = str;
        this.this$0 = biddingHisavanaIconProvider;
        this.$ctxMap = map;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiddingHisavanaIconProvider$preloadAd$2(this.$sceneId, this.this$0, this.$ctxMap, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((BiddingHisavanaIconProvider$preloadAd$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        ce.b e11;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            this.label = 1;
            obj = AdPlansStorageManager.i(AdPlansStorageManager.f42207a, this.$sceneId, com.transsion.ad.strategy.d.f42285a.a(null), null, new AdPlanSourceManager.AdPlanEnum[0], this, 4, null);
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
        oi.a aVar = oi.a.f71145a;
        String classTag = this.this$0.getClassTag();
        String str2 = this.$sceneId;
        Map<String, Object> map = this.$ctxMap;
        int size = list.size();
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((AdPlans) it.next()).getName());
        }
        oi.a.o(aVar, "ad_ic", classTag + " --> sceneId = " + str2 + " preload --> ctxMap: " + map + ", 可用广告计划：" + size + " --> " + arrayList, 0, false, 4, null);
        if (list.isEmpty()) {
            return Unit.f67184a;
        }
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                if (AdPlanSourceManager.f42220a.e((AdPlans) it2.next())) {
                    oi.a aVar2 = oi.a.f71145a;
                    String classTag2 = this.this$0.getClassTag();
                    str = this.this$0.f41988a;
                    oi.a.o(aVar2, "ad_ic", classTag2 + " --> preLoadAd() --> " + str, 0, false, 4, null);
                    e11 = this.this$0.e();
                    if (e11 != null) {
                        e11.preload();
                    }
                    return Unit.f67184a;
                }
            }
        }
        return Unit.f67184a;
    }
}
