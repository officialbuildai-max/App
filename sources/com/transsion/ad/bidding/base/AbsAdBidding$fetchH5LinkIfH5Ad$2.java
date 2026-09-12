package com.transsion.ad.bidding.base;

import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.monopoly.plan.AdPlanUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/lang/String;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.bidding.base.AbsAdBidding$fetchH5LinkIfH5Ad$2", f = "AbsAdBidding.kt", l = {211}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class AbsAdBidding$fetchH5LinkIfH5Ad$2 extends SuspendLambda implements Function2<n0, Continuation<? super String>, Object> {
    int label;
    final /* synthetic */ AbsAdBidding this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsAdBidding$fetchH5LinkIfH5Ad$2(AbsAdBidding absAdBidding, Continuation<? super AbsAdBidding$fetchH5LinkIfH5Ad$2> continuation) {
        super(2, continuation);
        this.this$0 = absAdBidding;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbsAdBidding$fetchH5LinkIfH5Ad$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super String> continuation) {
        return ((AbsAdBidding$fetchH5LinkIfH5Ad$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            AbsAdBidding absAdBidding = this.this$0;
            this.label = 1;
            obj = absAdBidding.b0(this);
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
        if (list.isEmpty()) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (!Intrinsics.c(((AdPlans) obj2).getAdSource(), AdPlanSourceManager.AdPlanEnum.AD_PLAN_AD_SOURCE_HI.getValue())) {
                arrayList.add(obj2);
            }
        }
        if (arrayList.isEmpty()) {
            return "";
        }
        final Comparator comparator = new Comparator() { // from class: com.transsion.ad.bidding.base.AbsAdBidding$fetchH5LinkIfH5Ad$2$invokeSuspend$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return ComparisonsKt.d(((AdPlans) t11).getBidEcpmCent(), ((AdPlans) t12).getBidEcpmCent());
            }
        };
        AdPlans adPlans = (AdPlans) CollectionsKt.x0(arrayList, new Comparator() { // from class: com.transsion.ad.bidding.base.AbsAdBidding$fetchH5LinkIfH5Ad$2$invokeSuspend$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                int compare = comparator.compare(t11, t12);
                if (compare != 0) {
                    return compare;
                }
                int sort = ((AdPlans) t11).getSort();
                if (sort == null) {
                    sort = Integer.MAX_VALUE;
                }
                int sort2 = ((AdPlans) t12).getSort();
                if (sort2 == null) {
                    sort2 = Integer.MAX_VALUE;
                }
                return ComparisonsKt.d(sort, sort2);
            }
        });
        if (adPlans == null || !AdPlanSourceManager.f42220a.c(adPlans)) {
            return "";
        }
        AdMaterialList a11 = AdPlanUtil.f42221a.a(adPlans);
        String h5Link = a11 != null ? a11.getH5Link() : null;
        return h5Link == null ? "" : h5Link;
    }
}
