package com.transsion.ad.bidding.base;

import android.os.Handler;
import android.os.SystemClock;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
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
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.n0;
import oi.b;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)Ljava/lang/Object;"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.ad.bidding.base.AbsAdBidding$innerLoadAd$2", f = "AbsAdBidding.kt", l = {818, 879}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class AbsAdBidding$innerLoadAd$2 extends SuspendLambda implements Function2<n0, Continuation<? super Object>, Object> {
    final /* synthetic */ int $fetchCount;
    final /* synthetic */ boolean $onlyHi;
    long J$0;
    int label;
    final /* synthetic */ AbsAdBidding this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsAdBidding$innerLoadAd$2(AbsAdBidding absAdBidding, boolean z10, int i11, Continuation<? super AbsAdBidding$innerLoadAd$2> continuation) {
        super(2, continuation);
        this.this$0 = absAdBidding;
        this.$onlyHi = z10;
        this.$fetchCount = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AbsAdBidding absAdBidding) {
        n0 n0Var;
        n0Var = absAdBidding.f41867u;
        kotlinx.coroutines.k.d(n0Var, null, null, new AbsAdBidding$innerLoadAd$2$2$1(absAdBidding, null), 3, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AbsAdBidding$innerLoadAd$2(this.this$0, this.$onlyHi, this.$fetchCount, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<Object> continuation) {
        return ((AbsAdBidding$innerLoadAd$2) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        long j11;
        boolean q02;
        List list;
        AtomicBoolean atomicBoolean;
        Object Y;
        Handler handler;
        long e02;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            AbsAdBidding absAdBidding = this.this$0;
            this.J$0 = elapsedRealtime;
            this.label = 1;
            obj = absAdBidding.b0(this);
            if (obj == f11) {
                return f11;
            }
            j11 = elapsedRealtime;
        } else {
            if (i11 != 1) {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.f67184a;
            }
            j11 = this.J$0;
            ResultKt.b(obj);
        }
        List list2 = (List) obj;
        b.a.c(this.this$0, 3, "innerLoadAd() --> 获取计划耗时 = " + (SystemClock.elapsedRealtime() - j11) + " --> availablePlanList = " + list2.size(), null, false, 4, null);
        if (list2.isEmpty()) {
            this.this$0.i(new TAdErrorCode(1101, "there are currently no plans available"));
            return Unit.f67184a;
        }
        q02 = this.this$0.q0(list2);
        AbsAdBidding absAdBidding2 = this.this$0;
        if (this.$onlyHi) {
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : list2) {
                if (Intrinsics.c(((AdPlans) obj2).getAdSource(), AdPlanSourceManager.AdPlanEnum.AD_PLAN_AD_SOURCE_HI.getValue())) {
                    arrayList.add(obj2);
                }
            }
            list2 = CollectionsKt.U0(arrayList);
        }
        absAdBidding2.f41862p = TypeIntrinsics.c(list2);
        AbsAdBidding absAdBidding3 = this.this$0;
        String mSceneId = absAdBidding3.getMSceneId();
        Map g02 = this.this$0.g0();
        list = this.this$0.f41862p;
        b.a.c(absAdBidding3, 3, "innerLoadAd() --> 开始加载广告 --> sceneId = " + mSceneId + " --> ctxMap = " + g02 + " --> 可用广告计划 availablePlanList?.size = " + (list != null ? Boxing.d(list.size()) : null) + " --> hasHiAdPlan = " + q02, null, false, 4, null);
        this.this$0.f41857k = this.$fetchCount;
        atomicBoolean = this.this$0.f41861o;
        atomicBoolean.set(false);
        if (q02) {
            String mSceneId2 = this.this$0.getMSceneId();
            if (!com.transsion.ad.scene.c.b(com.transsion.ad.scene.c.f42257a, mSceneId2, false, 2, null)) {
                this.this$0.x0(mSceneId2);
            }
        } else if (this.$onlyHi) {
            this.this$0.i(new TAdErrorCode(1101, "onlyHi == true ，但是没有Hi广告计划，不展示广告"));
            return Unit.f67184a;
        }
        if (q02) {
            handler = this.this$0.f41860n;
            final AbsAdBidding absAdBidding4 = this.this$0;
            Runnable runnable = new Runnable() { // from class: com.transsion.ad.bidding.base.k
                @Override // java.lang.Runnable
                public final void run() {
                    AbsAdBidding$innerLoadAd$2.d(AbsAdBidding.this);
                }
            };
            e02 = this.this$0.e0();
            return Boxing.a(handler.postDelayed(runnable, e02));
        }
        AbsAdBidding absAdBidding5 = this.this$0;
        this.label = 2;
        Y = absAdBidding5.Y("仅有包断，直接开始竞价", this);
        if (Y == f11) {
            return f11;
        }
        return Unit.f67184a;
    }
}
