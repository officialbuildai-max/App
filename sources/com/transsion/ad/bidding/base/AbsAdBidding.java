package com.transsion.ad.bidding.base;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.view.LifecycleCoroutineScope;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.transsion.ad.MBAd;
import com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini;
import com.transsion.ad.monopoly.intercept.NonAdShowedTimesManager;
import com.transsion.ad.monopoly.manager.AdPlansStorageManager;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.monopoly.plan.AdPlanUtil;
import com.transsion.ad.ps.attribution.AttributionProduceManager;
import com.transsion.ad.ps.distribute.PsDbManager;
import com.transsion.ad.report.BiddingStateEnum;
import com.transsion.ad.scene.AdSceneDisplayLimitManager;
import com.transsion.ad.strategy.AdOverridePendingTransitionManager;
import com.transsion.ad.strategy.AdUrlParameterManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import kotlinx.coroutines.z;
import oi.b;

/* loaded from: classes5.dex */
public abstract class AbsAdBidding extends di.a implements oi.b {

    /* renamed from: d */
    private String f41850d;

    /* renamed from: e */
    private String f41851e;

    /* renamed from: f */
    private Map f41852f;

    /* renamed from: g */
    private di.a f41853g;

    /* renamed from: h */
    private Context f41854h;

    /* renamed from: i */
    private Integer f41855i;

    /* renamed from: j */
    private AdOverridePendingTransitionManager.AdOverridePendingTransitionEnum f41856j;

    /* renamed from: p */
    private List f41862p;

    /* renamed from: q */
    private BiddingIntermediateMaterialBean f41863q;

    /* renamed from: s */
    private final j0 f41865s;

    /* renamed from: t */
    private final z f41866t;

    /* renamed from: u */
    private final n0 f41867u;

    /* renamed from: k */
    private int f41857k = 1;

    /* renamed from: l */
    private final AtomicBoolean f41858l = new AtomicBoolean(false);

    /* renamed from: m */
    private String f41859m = "";

    /* renamed from: n */
    private final Handler f41860n = new Handler(Looper.getMainLooper());

    /* renamed from: o */
    private final AtomicBoolean f41861o = new AtomicBoolean(false);

    /* renamed from: r */
    private final Handler f41864r = new Handler(Looper.getMainLooper());

    /* loaded from: classes5.dex */
    public static final class a extends AbstractCoroutineContextElement implements j0 {

        /* renamed from: a */
        final /* synthetic */ AbsAdBidding f41868a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(j0.a aVar, AbsAdBidding absAdBidding) {
            super(aVar);
            this.f41868a = absAdBidding;
        }

        @Override // kotlinx.coroutines.j0
        public void o(CoroutineContext coroutineContext, Throwable th2) {
            b.a.c(this.f41868a, 6, "biddingScope coroutine failed: " + th2, null, false, 12, null);
        }
    }

    public AbsAdBidding() {
        a aVar = new a(j0.f68015k1, this);
        this.f41865s = aVar;
        z b11 = l2.b(null, 1, null);
        this.f41866t = b11;
        this.f41867u = o0.a(b11.plus(y0.b()).plus(aVar));
    }

    public static final void A0(AbsAdBidding absAdBidding, TAdErrorCode tAdErrorCode) {
        di.a j02 = absAdBidding.j0();
        if (j02 != null) {
            j02.i(tAdErrorCode);
        }
    }

    public static final void B0(AbsAdBidding absAdBidding, List list) {
        di.a j02 = absAdBidding.j0();
        if (j02 != null) {
            j02.k(list);
        }
    }

    public static final void C0(AbsAdBidding absAdBidding, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        di.a j02 = absAdBidding.j0();
        if (j02 != null) {
            j02.j(biddingIntermediateMaterialBean);
        }
    }

    private final void D0(int i11, List list) {
        b.a.c(this, 3, "onBiddingTime() --> isLoading = " + this.f41858l.get(), null, false, 12, null);
        if (this.f41858l.get()) {
            b.a.c(this, 3, "onBiddingTime() --> before callback size = " + list.size(), null, false, 12, null);
            if (i11 != 1) {
                List m02 = m0(i11, list);
                if (m02.isEmpty()) {
                    i(new TAdErrorCode(1102, "竞价失败 --> maxEcpmBiddingPlanList == null --> biddingPlanList?.size = " + list.size()));
                    return;
                }
                b.a.c(this, 3, "onBiddingLoad() --> 竞价完成 --> fetchCount = " + i11 + " --> maxEcpmObject.size = " + m02.size(), null, false, 4, null);
                k(m02);
                return;
            }
            BiddingIntermediateMaterialBean l02 = l0(list);
            if (l02 == null) {
                i(new TAdErrorCode(1102, "竞价失败 --> maxEcpmObject == null --> biddingPlanList?.size = " + list.size()));
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Double ecpm = ((BiddingIntermediateMaterialBean) it.next()).getEcpm();
                if (ecpm != null) {
                    r2 = ecpm.toString();
                }
                arrayList.add(r2);
            }
            Double ecpm2 = l02.getEcpm();
            AdPlans plans = l02.getPlans();
            String id2 = plans != null ? plans.getId() : null;
            AdPlans plans2 = l02.getPlans();
            b.a.c(this, 3, "onBiddingLoad() --> 竞价完成 --> ecpmList = " + arrayList + " --> ecpm = " + ecpm2 + " --> plans?.id = " + id2 + " --> plans?.name = " + (plans2 != null ? plans2.getName() : null), null, false, 4, null);
            j(l02);
        }
    }

    public static final void E0(AbsAdBidding absAdBidding, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        di.a j02 = absAdBidding.j0();
        if (j02 != null) {
            j02.l(biddingIntermediateMaterialBean);
        }
    }

    public static final void F0(AbsAdBidding absAdBidding, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        di.a j02 = absAdBidding.j0();
        if (j02 != null) {
            j02.m(biddingIntermediateMaterialBean);
        }
    }

    public static final void G0(AbsAdBidding absAdBidding, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        di.a j02 = absAdBidding.j0();
        if (j02 != null) {
            j02.n(biddingIntermediateMaterialBean);
        }
    }

    public static final void H0(AbsAdBidding absAdBidding, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        di.a j02 = absAdBidding.j0();
        if (j02 != null) {
            j02.o(biddingIntermediateMaterialBean);
        }
    }

    public static final void I0(AbsAdBidding absAdBidding, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        di.a j02 = absAdBidding.j0();
        if (j02 != null) {
            j02.p(biddingIntermediateMaterialBean);
        }
    }

    public static /* synthetic */ void R0(AbsAdBidding absAdBidding, Activity activity, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startAdActivity");
        }
        if ((i11 & 4) != 0) {
            z10 = true;
        }
        absAdBidding.Q0(activity, biddingIntermediateMaterialBean, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object T(java.util.List r12, int r13, kotlin.coroutines.Continuation r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.transsion.ad.bidding.base.AbsAdBidding$bidding$1
            if (r0 == 0) goto L13
            r0 = r14
            com.transsion.ad.bidding.base.AbsAdBidding$bidding$1 r0 = (com.transsion.ad.bidding.base.AbsAdBidding$bidding$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.bidding.base.AbsAdBidding$bidding$1 r0 = new com.transsion.ad.bidding.base.AbsAdBidding$bidding$1
            r0.<init>(r11, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            int r13 = r0.I$0
            kotlin.ResultKt.b(r14)
            goto L4d
        L2b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L33:
            kotlin.ResultKt.b(r14)
            r9 = 12
            r10 = 0
            r5 = 3
            java.lang.String r6 = "bidding() --> 执行竞价环节"
            r7 = 0
            r8 = 0
            r4 = r11
            oi.b.a.c(r4, r5, r6, r7, r8, r9, r10)
            r0.I$0 = r13
            r0.label = r3
            java.lang.Object r14 = r11.d0(r12, r13, r0)
            if (r14 != r1) goto L4d
            return r1
        L4d:
            java.util.List r14 = (java.util.List) r14
            int r12 = r14.size()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "bidding() --> 竞价结果 biddingPlanList size = "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r4 = r0.toString()
            r7 = 12
            r8 = 0
            r3 = 3
            r5 = 0
            r6 = 0
            r2 = r11
            oi.b.a.c(r2, r3, r4, r5, r6, r7, r8)
            r11.D0(r13, r14)
            kotlin.Unit r12 = kotlin.Unit.f67184a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.bidding.base.AbsAdBidding.T(java.util.List, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object Y(java.lang.String r13, kotlin.coroutines.Continuation r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.transsion.ad.bidding.base.AbsAdBidding$generalBidding$1
            if (r0 == 0) goto L13
            r0 = r14
            com.transsion.ad.bidding.base.AbsAdBidding$generalBidding$1 r0 = (com.transsion.ad.bidding.base.AbsAdBidding$generalBidding$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.bidding.base.AbsAdBidding$generalBidding$1 r0 = new com.transsion.ad.bidding.base.AbsAdBidding$generalBidding$1
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.b(r14)
            goto Lc7
        L2a:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L32:
            kotlin.ResultKt.b(r14)
            java.util.concurrent.atomic.AtomicBoolean r14 = r12.f41861o
            r2 = 0
            boolean r14 = r14.compareAndSet(r2, r3)
            if (r14 != 0) goto L5c
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "generalBidding() --> 已经处理过，忽略本次调用 --> "
            r14.append(r0)
            r14.append(r13)
            java.lang.String r3 = r14.toString()
            r6 = 12
            r7 = 0
            r2 = 3
            r4 = 0
            r5 = 0
            r1 = r12
            oi.b.a.c(r1, r2, r3, r4, r5, r6, r7)
            kotlin.Unit r13 = kotlin.Unit.f67184a
            return r13
        L5c:
            java.lang.String r14 = r12.getMSceneId()
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 == 0) goto L84
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "generalBidding() --> 场景已经被回收，不执行竞价逻辑 --> "
            r14.append(r0)
            r14.append(r13)
            java.lang.String r3 = r14.toString()
            r6 = 12
            r7 = 0
            r2 = 6
            r4 = 0
            r5 = 0
            r1 = r12
            oi.b.a.c(r1, r2, r3, r4, r5, r6, r7)
            kotlin.Unit r13 = kotlin.Unit.f67184a
            return r13
        L84:
            java.util.List r14 = r12.f41862p
            if (r14 == 0) goto Lce
            java.util.Collection r14 = (java.util.Collection) r14
            boolean r14 = r14.isEmpty()
            r14 = r14 ^ r3
            if (r14 != r3) goto Lce
            android.os.Handler r14 = r12.f41860n
            r2 = 0
            r14.removeCallbacksAndMessages(r2)
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r4 = "generalBidding() --> 广告已经准备好，开始竞价 ---> "
            r14.append(r4)
            r14.append(r13)
            java.lang.String r7 = r14.toString()
            r10 = 12
            r11 = 0
            r6 = 3
            r8 = 0
            r9 = 0
            r5 = r12
            oi.b.a.c(r5, r6, r7, r8, r9, r10, r11)
            java.util.List r13 = r12.f41862p
            if (r13 == 0) goto Lbc
            java.util.Collection r13 = (java.util.Collection) r13
            java.util.List r2 = kotlin.collections.CollectionsKt.U0(r13)
        Lbc:
            int r13 = r12.f41857k
            r0.label = r3
            java.lang.Object r13 = r12.T(r2, r13, r0)
            if (r13 != r1) goto Lc7
            return r1
        Lc7:
            java.util.List r13 = r12.f41862p
            if (r13 == 0) goto Lce
            r13.clear()
        Lce:
            kotlin.Unit r13 = kotlin.Unit.f67184a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.bidding.base.AbsAdBidding.Y(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final AdOverridePendingTransitionManager.AdOverridePendingTransitionEnum Z() {
        return this.f41856j;
    }

    static /* synthetic */ Object c0(AbsAdBidding absAdBidding, Continuation continuation) {
        return AdPlansStorageManager.f42207a.h(absAdBidding.getMSceneId(), absAdBidding.g0(), absAdBidding.getLogTag(), new AdPlanSourceManager.AdPlanEnum[0], continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0337 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00f6 -> B:17:0x0332). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x01b1 -> B:12:0x01b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x0231 -> B:16:0x022c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x025f -> B:16:0x022c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0290 -> B:16:0x022c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x0323 -> B:17:0x0332). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d0(java.util.List r32, int r33, kotlin.coroutines.Continuation r34) {
        /*
            Method dump skipped, instructions count: 824
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.bidding.base.AbsAdBidding.d0(java.util.List, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final long e0() {
        if (com.transsion.ad.scene.c.b(com.transsion.ad.scene.c.f42257a, getMSceneId(), false, 2, null) || r0()) {
            return 0L;
        }
        return com.transsion.ad.scene.a.c(com.transsion.ad.scene.a.f42255a, getMSceneId(), 0, 2, null) * 1000;
    }

    private final BiddingIntermediateMaterialBean l0(List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            b.a.c(this, 5, "getMaxEcpmBiddingPlan() --> biddingList.isNullOrEmpty() == true", null, false, 4, null);
            return null;
        }
        final Comparator comparator = new Comparator() { // from class: com.transsion.ad.bidding.base.AbsAdBidding$getMaxEcpmBiddingPlan$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return ComparisonsKt.d(((BiddingIntermediateMaterialBean) t11).getEcpm(), ((BiddingIntermediateMaterialBean) t12).getEcpm());
            }
        };
        return (BiddingIntermediateMaterialBean) CollectionsKt.x0(list, new Comparator() { // from class: com.transsion.ad.bidding.base.AbsAdBidding$getMaxEcpmBiddingPlan$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                int i11;
                int i12;
                int compare = comparator.compare(t11, t12);
                if (compare != 0) {
                    return compare;
                }
                AdPlans plans = ((BiddingIntermediateMaterialBean) t11).getPlans();
                if (plans == null || (i11 = plans.getSort()) == null) {
                    i11 = Integer.MAX_VALUE;
                }
                AdPlans plans2 = ((BiddingIntermediateMaterialBean) t12).getPlans();
                if (plans2 == null || (i12 = plans2.getSort()) == null) {
                    i12 = Integer.MAX_VALUE;
                }
                return ComparisonsKt.d(i11, i12);
            }
        });
    }

    private final List m0(int i11, List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty() || i11 <= 0) {
            return new ArrayList();
        }
        final Comparator comparator = new Comparator() { // from class: com.transsion.ad.bidding.base.AbsAdBidding$getMaxEcpmBiddingPlanList$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                Double ecpm = ((BiddingIntermediateMaterialBean) t12).getEcpm();
                Double valueOf = Double.valueOf(Double.MIN_VALUE);
                if (ecpm == null) {
                    ecpm = valueOf;
                }
                Double ecpm2 = ((BiddingIntermediateMaterialBean) t11).getEcpm();
                if (ecpm2 != null) {
                    valueOf = ecpm2;
                }
                return ComparisonsKt.d(ecpm, valueOf);
            }
        };
        return CollectionsKt.U0(CollectionsKt.K0(CollectionsKt.I0(list, new Comparator() { // from class: com.transsion.ad.bidding.base.AbsAdBidding$getMaxEcpmBiddingPlanList$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                int i12;
                int i13;
                int compare = comparator.compare(t11, t12);
                if (compare != 0) {
                    return compare;
                }
                AdPlans plans = ((BiddingIntermediateMaterialBean) t11).getPlans();
                if (plans == null || (i12 = plans.getSort()) == null) {
                    i12 = Integer.MAX_VALUE;
                }
                AdPlans plans2 = ((BiddingIntermediateMaterialBean) t12).getPlans();
                if (plans2 == null || (i13 = plans2.getSort()) == null) {
                    i13 = Integer.MAX_VALUE;
                }
                return ComparisonsKt.d(i12, i13);
            }
        }), i11));
    }

    public final boolean q0(List list) {
        List list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            if (AdPlanSourceManager.f42220a.e((AdPlans) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final List s0(List list) {
        Object next;
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AdPlans adPlans = (AdPlans) it.next();
            String adSource = adPlans.getAdSource();
            if (Intrinsics.c(adSource, AdPlanSourceManager.AdPlanEnum.AD_PLAN_AD_SOURCE_HI.getValue())) {
                arrayList2.add(adPlans);
            } else if (Intrinsics.c(adSource, AdPlanSourceManager.AdPlanEnum.AD_PLAN_AD_SOURCE_H5.getValue())) {
                arrayList3.add(adPlans);
            } else {
                arrayList.add(adPlans);
            }
        }
        Object obj = null;
        if (!arrayList2.isEmpty()) {
            Iterator it2 = arrayList2.iterator();
            if (it2.hasNext()) {
                next = it2.next();
                if (it2.hasNext()) {
                    Double bidEcpmCent = ((AdPlans) next).getBidEcpmCent();
                    double doubleValue = bidEcpmCent != null ? bidEcpmCent.doubleValue() : 0.0d;
                    do {
                        Object next2 = it2.next();
                        Double bidEcpmCent2 = ((AdPlans) next2).getBidEcpmCent();
                        double doubleValue2 = bidEcpmCent2 != null ? bidEcpmCent2.doubleValue() : 0.0d;
                        if (Double.compare(doubleValue, doubleValue2) < 0) {
                            next = next2;
                            doubleValue = doubleValue2;
                        }
                    } while (it2.hasNext());
                }
            } else {
                next = null;
            }
            AdPlans adPlans2 = (AdPlans) next;
            if (adPlans2 != null) {
                arrayList.add(adPlans2);
            }
        }
        if (!arrayList3.isEmpty()) {
            Iterator it3 = arrayList3.iterator();
            if (it3.hasNext()) {
                obj = it3.next();
                if (it3.hasNext()) {
                    Double bidEcpmCent3 = ((AdPlans) obj).getBidEcpmCent();
                    double doubleValue3 = bidEcpmCent3 != null ? bidEcpmCent3.doubleValue() : 0.0d;
                    do {
                        Object next3 = it3.next();
                        Double bidEcpmCent4 = ((AdPlans) next3).getBidEcpmCent();
                        double doubleValue4 = bidEcpmCent4 != null ? bidEcpmCent4.doubleValue() : 0.0d;
                        if (Double.compare(doubleValue3, doubleValue4) < 0) {
                            obj = next3;
                            doubleValue3 = doubleValue4;
                        }
                    } while (it3.hasNext());
                }
            }
            AdPlans adPlans3 = (AdPlans) obj;
            if (adPlans3 != null) {
                arrayList.add(adPlans3);
            }
        }
        if (arrayList.size() > 1) {
            CollectionsKt.A(arrayList, new Comparator() { // from class: com.transsion.ad.bidding.base.AbsAdBidding$hiAdPlanDeduplication$$inlined$sortByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t11, T t12) {
                    Double bidEcpmCent5 = ((AdPlans) t12).getBidEcpmCent();
                    Double valueOf = Double.valueOf(bidEcpmCent5 != null ? bidEcpmCent5.doubleValue() : 0.0d);
                    Double bidEcpmCent6 = ((AdPlans) t11).getBidEcpmCent();
                    return ComparisonsKt.d(valueOf, Double.valueOf(bidEcpmCent6 != null ? bidEcpmCent6.doubleValue() : 0.0d));
                }
            });
        }
        return arrayList;
    }

    private final Object t0(boolean z10, int i11, Continuation continuation) {
        Object g11 = kotlinx.coroutines.i.g(y0.b(), new AbsAdBidding$innerLoadAd$2(this, z10, i11, null), continuation);
        return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
    }

    public static /* synthetic */ Object w0(AbsAdBidding absAdBidding, int i11, boolean z10, Continuation continuation, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadAd");
        }
        if ((i12 & 1) != 0) {
            i11 = 1;
        }
        if ((i12 & 2) != 0) {
            z10 = false;
        }
        return absAdBidding.v0(i11, z10, continuation);
    }

    public static final void y0(AbsAdBidding absAdBidding, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, long j11) {
        di.a j02 = absAdBidding.j0();
        if (j02 != null) {
            j02.d(biddingIntermediateMaterialBean, j11);
        }
    }

    public static final void z0(String str) {
        hi.a e11;
        MBAd.a c11 = MBAd.f41805a.c();
        if (c11 == null || (e11 = c11.e()) == null) {
            return;
        }
        e11.b(str);
    }

    public final AbsAdBidding J0(AdOverridePendingTransitionManager.AdOverridePendingTransitionEnum adOverridePendingTransitionEnum) {
        this.f41856j = adOverridePendingTransitionEnum;
        return this;
    }

    public final AbsAdBidding K0(Integer num) {
        this.f41855i = num;
        return this;
    }

    public final AbsAdBidding L0(Context context) {
        Intrinsics.h(context, "context");
        this.f41854h = context;
        return this;
    }

    public final AbsAdBidding M0(Map map) {
        this.f41852f = map;
        return this;
    }

    public final AbsAdBidding N0(di.a aVar) {
        this.f41853g = aVar;
        return this;
    }

    public final AbsAdBidding O0(String str) {
        this.f41850d = str;
        return this;
    }

    public final AbsAdBidding P0(String str) {
        this.f41851e = str;
        return this;
    }

    public final void Q0(Activity activity, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, boolean z10) {
        LifecycleCoroutineScope a11;
        t1 d11;
        v vVar = v.f41947a;
        if (vVar.b()) {
            if (biddingIntermediateMaterialBean != null) {
                biddingIntermediateMaterialBean.setErrorMsg("当前已经有Activity在展示广告了，请勿重复展示广告!");
            }
            p(biddingIntermediateMaterialBean);
            return;
        }
        vVar.d();
        AppCompatActivity appCompatActivity = activity instanceof AppCompatActivity ? (AppCompatActivity) activity : null;
        if (appCompatActivity != null && (a11 = androidx.view.v.a(appCompatActivity)) != null) {
            d11 = kotlinx.coroutines.k.d(a11, null, null, new AbsAdBidding$startAdActivity$1(biddingIntermediateMaterialBean, activity, this, z10, null), 3, null);
            if (d11 != null) {
                return;
            }
        }
        if (biddingIntermediateMaterialBean != null) {
            biddingIntermediateMaterialBean.setErrorMsg("activity is empty");
        }
        p(biddingIntermediateMaterialBean);
        Unit unit = Unit.f67184a;
    }

    public abstract void S(List list, AdPlans adPlans, int i11);

    public boolean U() {
        return false;
    }

    public void V() {
        t1.a.b(this.f41866t, null, 1, null);
        com.transsion.ad.bidding.splash.a a11 = com.transsion.ad.bidding.splash.a.f42086n.a(getMSceneId());
        if (a11 != null) {
            a11.c(this);
        }
        com.transsion.ad.bidding.interstitial.l b11 = com.transsion.ad.bidding.interstitial.l.f42034j.b(getMSceneId());
        if (b11 != null) {
            b11.c(this);
        }
        com.transsion.ad.bidding.video.q b12 = com.transsion.ad.bidding.video.q.f42121j.b(getMSceneId());
        if (b12 != null) {
            b12.c(this);
        }
        AbsBiddingBuyOutGemini h02 = h0();
        if (h02 != null) {
            h02.b();
        }
        N0(null);
        M0(null);
        this.f41854h = null;
        List list = this.f41862p;
        if (list != null) {
            list.clear();
        }
        this.f41860n.removeCallbacksAndMessages(null);
        this.f41863q = null;
        b.a.c(this, 3, "destroy() --> 资源回收", null, false, 4, null);
    }

    public final int W(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        return (biddingIntermediateMaterialBean != null && AdPlanSourceManager.f42220a.c(biddingIntermediateMaterialBean.getPlans())) ? 107 : 102;
    }

    public final Object X(Continuation continuation) {
        return kotlinx.coroutines.i.g(y0.b(), new AbsAdBidding$fetchH5LinkIfH5Ad$2(this, null), continuation);
    }

    @Override // di.a
    public void a(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        AdPlans plans;
        AdPlans plans2;
        AdPlans plans3;
        AdPlans plans4;
        super.a(biddingIntermediateMaterialBean);
        ri.c cVar = ri.c.f74658a;
        String p02 = p0();
        String mSceneId = getMSceneId();
        String id2 = (biddingIntermediateMaterialBean == null || (plans4 = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans4.getId();
        Integer valueOf = Integer.valueOf(W(biddingIntermediateMaterialBean));
        AdPlanUtil adPlanUtil = AdPlanUtil.f42221a;
        AdMaterialList a11 = adPlanUtil.a(biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getPlans() : null);
        String id3 = a11 != null ? a11.getId() : null;
        int a02 = a0();
        boolean a12 = pi.b.f72583a.a(biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getPlans() : null);
        cVar.a((r30 & 1) != 0 ? "" : p02, mSceneId, id2, valueOf, id3, a02, (r30 & 64) != 0 ? false : a12, (r30 & 128) != 0 ? MapsKt.h() : null, adPlanUtil.c(biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getPlans() : null), (r30 & 512) != 0 ? null : (biddingIntermediateMaterialBean == null || (plans3 = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans3.getBidEcpmCent(), (r30 & 1024) != 0 ? null : (biddingIntermediateMaterialBean == null || (plans2 = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans2.getEcpmCent(), (r30 & 2048) != 0 ? null : o0(), (biddingIntermediateMaterialBean == null || (plans = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans.getAdSource());
        com.transsion.ad.strategy.b.f42281a.j(biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getPlans() : null, Z(), getLogTag(), getMSceneId());
        PsDbManager.f42243a.k(biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getPlans() : null);
        l(biddingIntermediateMaterialBean);
    }

    public abstract int a0();

    @Override // di.a
    public void b(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.b(biddingIntermediateMaterialBean);
        m(biddingIntermediateMaterialBean);
    }

    public Object b0(Continuation continuation) {
        return c0(this, continuation);
    }

    @Override // di.a
    public void c(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        AdPlans plans;
        AdPlans plans2;
        AdPlans plans3;
        AdPlans plans4;
        super.c(biddingIntermediateMaterialBean);
        if (biddingIntermediateMaterialBean != null) {
            biddingIntermediateMaterialBean.setExpend(Boolean.TRUE);
        }
        AttributionProduceManager.f42234c.m(biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getPlans() : null);
        ri.c cVar = ri.c.f74658a;
        String p02 = p0();
        String mSceneId = getMSceneId();
        String id2 = (biddingIntermediateMaterialBean == null || (plans4 = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans4.getId();
        Integer valueOf = Integer.valueOf(W(biddingIntermediateMaterialBean));
        AdPlanUtil adPlanUtil = AdPlanUtil.f42221a;
        AdMaterialList a11 = adPlanUtil.a(biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getPlans() : null);
        String id3 = a11 != null ? a11.getId() : null;
        int a02 = a0();
        boolean a12 = pi.b.f72583a.a(biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getPlans() : null);
        cVar.g((r30 & 1) != 0 ? "" : p02, mSceneId, id2, valueOf, id3, a02, (r30 & 64) != 0 ? false : a12, (r30 & 128) != 0 ? MapsKt.h() : null, adPlanUtil.c(biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getPlans() : null), (r30 & 512) != 0 ? null : (biddingIntermediateMaterialBean == null || (plans3 = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans3.getBidEcpmCent(), (r30 & 1024) != 0 ? null : (biddingIntermediateMaterialBean == null || (plans2 = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans2.getEcpmCent(), (r30 & 2048) != 0 ? null : o0(), (biddingIntermediateMaterialBean == null || (plans = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans.getAdSource());
        PsDbManager.f42243a.l(biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getPlans() : null);
        n(biddingIntermediateMaterialBean);
    }

    @Override // di.a
    public void d(final BiddingIntermediateMaterialBean biddingIntermediateMaterialBean, final long j11) {
        AdPlans plans;
        AdPlans plans2;
        AdPlans plans3;
        super.d(biddingIntermediateMaterialBean, j11);
        b.a.c(this, 0, "onBiddingBuyOutDisplayTimestamp() --> name = " + ((biddingIntermediateMaterialBean == null || (plans3 = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans3.getName()) + " --> displayTimestamp = " + j11, null, false, 5, null);
        ri.c cVar = ri.c.f74658a;
        String p02 = p0();
        String mSceneId = getMSceneId();
        String id2 = (biddingIntermediateMaterialBean == null || (plans2 = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans2.getId();
        AdMaterialList a11 = AdPlanUtil.f42221a.a(biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getPlans() : null);
        cVar.d(p02, mSceneId, id2, j11, a11 != null ? a11.getId() : null, a0(), pi.b.f72583a.a(biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getPlans() : null), o0(), biddingIntermediateMaterialBean != null ? Integer.valueOf(biddingIntermediateMaterialBean.getAdSource()).toString() : null, (biddingIntermediateMaterialBean == null || (plans = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans.getAdSource());
        this.f41864r.post(new Runnable() { // from class: com.transsion.ad.bidding.base.h
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.y0(AbsAdBidding.this, biddingIntermediateMaterialBean, j11);
            }
        });
    }

    @Override // di.a
    public void f(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        AdPlans plans;
        super.f(biddingIntermediateMaterialBean);
        boolean h5LinkPreload = (biddingIntermediateMaterialBean == null || (plans = biddingIntermediateMaterialBean.getPlans()) == null) ? false : plans.getH5LinkPreload();
        AdMaterialList a11 = AdPlanUtil.f42221a.a(biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getPlans() : null);
        String h5Link = a11 != null ? a11.getH5Link() : null;
        if (!h5LinkPreload || TextUtils.isEmpty(h5Link)) {
            return;
        }
        AdUrlParameterManager adUrlParameterManager = AdUrlParameterManager.f42267a;
        if (h5Link == null) {
            h5Link = "";
        }
        final String b11 = adUrlParameterManager.b(h5Link, "on Ad show");
        this.f41864r.post(new Runnable() { // from class: com.transsion.ad.bidding.base.c
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.z0(b11);
            }
        });
    }

    public final Context f0() {
        return this.f41854h;
    }

    @Override // di.a
    public void g(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.g(biddingIntermediateMaterialBean);
        o(biddingIntermediateMaterialBean);
    }

    public final Map g0() {
        Map map = this.f41852f;
        return map == null ? MapsKt.h() : map;
    }

    @Override // oi.b
    public String getClassTag() {
        return b.a.a(this);
    }

    @Override // oi.b
    /* renamed from: getSceneId */
    public String getMSceneId() {
        String str = this.f41850d;
        return str == null ? "" : str;
    }

    @Override // di.a
    public void h(TAdErrorCode tAdErrorCode, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.h(tAdErrorCode, biddingIntermediateMaterialBean);
        p(biddingIntermediateMaterialBean);
    }

    public abstract AbsBiddingBuyOutGemini h0();

    @Override // di.a
    public void i(final TAdErrorCode tAdErrorCode) {
        super.i(tAdErrorCode);
        b.a.c(this, 6, "onBiddingError() --> errorMessage = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null), null, false, 12, null);
        this.f41858l.set(false);
        this.f41864r.post(new Runnable() { // from class: com.transsion.ad.bidding.base.e
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.A0(AbsAdBidding.this, tAdErrorCode);
            }
        });
    }

    public final Integer i0() {
        return this.f41855i;
    }

    @Override // di.a
    public void j(final BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        AdPlans plans;
        AdPlans plans2;
        AdPlans plans3;
        AdPlans plans4;
        AdPlans plans5;
        super.j(biddingIntermediateMaterialBean);
        this.f41863q = biddingIntermediateMaterialBean;
        ri.c cVar = ri.c.f74658a;
        String p02 = p0();
        String mSceneId = getMSceneId();
        String str = null;
        Integer valueOf = biddingIntermediateMaterialBean != null ? Integer.valueOf(biddingIntermediateMaterialBean.getAdSource()) : null;
        int a02 = a0();
        String str2 = "竞价成功 --> ecpm = " + (biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getEcpm() : null) + " -- plans?.id = " + ((biddingIntermediateMaterialBean == null || (plans5 = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans5.getId()) + " -- plans?.name = " + ((biddingIntermediateMaterialBean == null || (plans4 = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans4.getName());
        BiddingStateEnum biddingStateEnum = BiddingStateEnum.BIDDING_REPORT_BIDDING_SUCCESS;
        String valueOf2 = String.valueOf(biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getEcpm() : null);
        String valueOf3 = String.valueOf((biddingIntermediateMaterialBean == null || (plans3 = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans3.getId());
        String valueOf4 = String.valueOf((biddingIntermediateMaterialBean == null || (plans2 = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans2.getName());
        String o02 = o0();
        if (biddingIntermediateMaterialBean != null && (plans = biddingIntermediateMaterialBean.getPlans()) != null) {
            str = plans.getAdSource();
        }
        cVar.e(p02, mSceneId, valueOf, a02, biddingStateEnum, str2, null, valueOf2, valueOf3, valueOf4, o02, str);
        this.f41858l.set(false);
        this.f41864r.post(new Runnable() { // from class: com.transsion.ad.bidding.base.b
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.C0(AbsAdBidding.this, biddingIntermediateMaterialBean);
            }
        });
    }

    public final di.a j0() {
        return this.f41853g;
    }

    @Override // di.a
    public void k(final List list) {
        super.k(list);
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                BiddingIntermediateMaterialBean biddingIntermediateMaterialBean = (BiddingIntermediateMaterialBean) it.next();
                biddingIntermediateMaterialBean.setSceneSubId(o0());
                biddingIntermediateMaterialBean.setSceneId(getMSceneId());
                ri.c cVar = ri.c.f74658a;
                String p02 = p0();
                String mSceneId = getMSceneId();
                int adSource = biddingIntermediateMaterialBean.getAdSource();
                int a02 = a0();
                Double ecpm = biddingIntermediateMaterialBean.getEcpm();
                AdPlans plans = biddingIntermediateMaterialBean.getPlans();
                String id2 = plans != null ? plans.getId() : null;
                AdPlans plans2 = biddingIntermediateMaterialBean.getPlans();
                String str = "竞价成功 --> ecpm = " + ecpm + " -- plans?.id = " + id2 + " -- plans?.name = " + (plans2 != null ? plans2.getName() : null);
                BiddingStateEnum biddingStateEnum = BiddingStateEnum.BIDDING_REPORT_BIDDING_SUCCESS;
                String valueOf = String.valueOf(biddingIntermediateMaterialBean.getEcpm());
                AdPlans plans3 = biddingIntermediateMaterialBean.getPlans();
                String valueOf2 = String.valueOf(plans3 != null ? plans3.getId() : null);
                AdPlans plans4 = biddingIntermediateMaterialBean.getPlans();
                String valueOf3 = String.valueOf(plans4 != null ? plans4.getName() : null);
                String o02 = o0();
                AdPlans plans5 = biddingIntermediateMaterialBean.getPlans();
                cVar.e(p02, mSceneId, Integer.valueOf(adSource), a02, biddingStateEnum, str, null, valueOf, valueOf2, valueOf3, o02, plans5 != null ? plans5.getAdSource() : null);
            }
        }
        this.f41858l.set(false);
        this.f41864r.post(new Runnable() { // from class: com.transsion.ad.bidding.base.j
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.B0(AbsAdBidding.this, list);
            }
        });
    }

    public final Handler k0() {
        return this.f41864r;
    }

    @Override // di.a
    public void l(final BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        AdPlans plans;
        b.a.c(this, 0, "onBiddingWrapperAdClick() --> name = " + ((biddingIntermediateMaterialBean == null || (plans = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans.getName()), null, false, 5, null);
        this.f41864r.post(new Runnable() { // from class: com.transsion.ad.bidding.base.g
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.E0(AbsAdBidding.this, biddingIntermediateMaterialBean);
            }
        });
    }

    @Override // di.a
    public void m(final BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        AdPlans plans;
        b.a.c(this, 0, "onBiddingWrapperAdClose() --> name = " + ((biddingIntermediateMaterialBean == null || (plans = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans.getName()), null, false, 5, null);
        v vVar = v.f41947a;
        if (vVar.a(a0())) {
            vVar.c();
        }
        this.f41864r.post(new Runnable() { // from class: com.transsion.ad.bidding.base.a
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.F0(AbsAdBidding.this, biddingIntermediateMaterialBean);
            }
        });
    }

    @Override // di.a
    public void n(final BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        AdPlans plans;
        b.a.c(this, 0, "onBiddingWrapperAdDisplay() --> name = " + ((biddingIntermediateMaterialBean == null || (plans = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans.getName()), null, false, 5, null);
        NonAdShowedTimesManager.f42188a.c(biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getPlans() : null);
        AdSceneDisplayLimitManager.f42253a.b(getMSceneId());
        this.f41864r.post(new Runnable() { // from class: com.transsion.ad.bidding.base.f
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.G0(AbsAdBidding.this, biddingIntermediateMaterialBean);
            }
        });
    }

    public final BiddingIntermediateMaterialBean n0() {
        return this.f41863q;
    }

    @Override // di.a
    public void o(final BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        AdPlans plans;
        b.a.c(this, 0, "onBiddingWrapperAdRewarded() --> name = " + ((biddingIntermediateMaterialBean == null || (plans = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans.getName()), null, false, 5, null);
        this.f41864r.post(new Runnable() { // from class: com.transsion.ad.bidding.base.d
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.H0(AbsAdBidding.this, biddingIntermediateMaterialBean);
            }
        });
    }

    public final String o0() {
        return this.f41851e;
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onClick(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        AdPlans plans;
        AdPlans plans2;
        TAdNativeInfo nativeInfo;
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onClick(tAdNativeInfo, additionalInfo);
        String str = null;
        if (a0() == 2) {
            BiddingIntermediateMaterialBean n02 = n0();
            if (!TextUtils.equals((n02 == null || (nativeInfo = n02.getNativeInfo()) == null) ? null : nativeInfo.getAdId(), tAdNativeInfo != null ? tAdNativeInfo.getAdId() : null)) {
                return;
            }
        }
        ri.c cVar = ri.c.f74658a;
        String p02 = p0();
        String mSceneId = getMSceneId();
        BiddingIntermediateMaterialBean n03 = n0();
        String id2 = (n03 == null || (plans2 = n03.getPlans()) == null) ? null : plans2.getId();
        Integer source = additionalInfo.getSource();
        String codeSeatId = additionalInfo.getCodeSeatId();
        int a02 = a0();
        BiddingIntermediateMaterialBean n04 = n0();
        Double ecpm = n04 != null ? n04.getEcpm() : null;
        String o02 = o0();
        BiddingIntermediateMaterialBean n05 = n0();
        if (n05 != null && (plans = n05.getPlans()) != null) {
            str = plans.getAdSource();
        }
        cVar.a((r30 & 1) != 0 ? "" : p02, mSceneId, id2, source, codeSeatId, a02, (r30 & 64) != 0 ? false : false, (r30 & 128) != 0 ? MapsKt.h() : null, null, (r30 & 512) != 0 ? null : ecpm, (r30 & 1024) != 0 ? null : null, (r30 & 2048) != 0 ? null : o02, str);
        l(n0());
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onClosed(int i11) {
        super.onClosed(i11);
        m(n0());
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadFailure(TAdErrorCode tAdErrorCode, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onLoadFailure(tAdErrorCode, additionalInfo);
        kotlinx.coroutines.k.d(this.f41867u, null, null, new AbsAdBidding$onLoadFailure$1(this, additionalInfo, tAdErrorCode, null), 3, null);
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadSuccess(AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onLoadSuccess(additionalInfo);
        kotlinx.coroutines.k.d(this.f41867u, null, null, new AbsAdBidding$onLoadSuccess$1(this, additionalInfo, null), 3, null);
    }

    @Override // oi.b
    public void onLog(int i11, String str, String str2, boolean z10) {
        b.a.b(this, i11, str, str2, z10);
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onRewarded() {
        super.onRewarded();
        o(n0());
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShow(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        AdPlans plans;
        AdPlans plans2;
        TAdNativeInfo nativeInfo;
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onShow(tAdNativeInfo, additionalInfo);
        String str = null;
        if (a0() == 2) {
            BiddingIntermediateMaterialBean n02 = n0();
            if (!TextUtils.equals((n02 == null || (nativeInfo = n02.getNativeInfo()) == null) ? null : nativeInfo.getAdId(), tAdNativeInfo != null ? tAdNativeInfo.getAdId() : null)) {
                return;
            }
        }
        ri.c cVar = ri.c.f74658a;
        String p02 = p0();
        String mSceneId = getMSceneId();
        BiddingIntermediateMaterialBean n03 = n0();
        String id2 = (n03 == null || (plans2 = n03.getPlans()) == null) ? null : plans2.getId();
        Integer source = additionalInfo.getSource();
        String codeSeatId = additionalInfo.getCodeSeatId();
        int a02 = a0();
        BiddingIntermediateMaterialBean n04 = n0();
        Double ecpm = n04 != null ? n04.getEcpm() : null;
        String o02 = o0();
        BiddingIntermediateMaterialBean n05 = n0();
        if (n05 != null && (plans = n05.getPlans()) != null) {
            str = plans.getAdSource();
        }
        cVar.g((r30 & 1) != 0 ? "" : p02, mSceneId, id2, source, codeSeatId, a02, (r30 & 64) != 0 ? false : false, (r30 & 128) != 0 ? MapsKt.h() : null, null, (r30 & 512) != 0 ? null : ecpm, (r30 & 1024) != 0 ? null : null, (r30 & 2048) != 0 ? null : o02, str);
        n(n0());
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShowError(TAdErrorCode tAdErrorCode, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onShowError(tAdErrorCode, additionalInfo);
        String errorMessage = tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null;
        b.a.c(this, 6, "onShowError() --> errorMessage = " + errorMessage + " --> placementId = " + additionalInfo.getPlacementId(), null, false, 12, null);
        p(n0());
    }

    @Override // di.a
    public void p(final BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        AdPlans plans;
        b.a.c(this, 0, "onBiddingWrapperAdShowError() --> name = " + ((biddingIntermediateMaterialBean == null || (plans = biddingIntermediateMaterialBean.getPlans()) == null) ? null : plans.getName()) + " --> msg = " + (biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getErrorMsg() : null), null, false, 13, null);
        v vVar = v.f41947a;
        if (vVar.a(a0())) {
            vVar.c();
        }
        this.f41864r.post(new Runnable() { // from class: com.transsion.ad.bidding.base.i
            @Override // java.lang.Runnable
            public final void run() {
                AbsAdBidding.I0(AbsAdBidding.this, biddingIntermediateMaterialBean);
            }
        });
    }

    public final String p0() {
        return this.f41859m;
    }

    public abstract boolean r0();

    public final boolean u0(AdPlans adPlans) {
        if ((adPlans != null ? adPlans.getBidEcpmCent() : null) != null) {
            Double bidEcpmCent = adPlans.getBidEcpmCent();
            if ((bidEcpmCent != null ? bidEcpmCent.doubleValue() : 0.0d) != 0.0d) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v0(int r18, boolean r19, kotlin.coroutines.Continuation r20) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.bidding.base.AbsAdBidding.v0(int, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract void x0(String str);
}
