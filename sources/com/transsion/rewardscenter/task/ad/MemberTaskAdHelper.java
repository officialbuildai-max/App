package com.transsion.rewardscenter.task.ad;

import android.content.Context;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.hisavana.common.bean.TAdErrorCode;
import com.tn.lib.widget.R$string;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingSspNativeManager;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.rewardscenter.task.ad.v;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes6.dex */
public final class MemberTaskAdHelper extends BaseStageTaskAdHelper {

    /* renamed from: r, reason: collision with root package name */
    public static final a f51091r = new a(null);

    /* renamed from: s, reason: collision with root package name */
    public static final int f51092s = 8;

    /* renamed from: t, reason: collision with root package name */
    private static final Lazy f51093t = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.task.ad.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int b02;
            b02 = MemberTaskAdHelper.b0();
            return Integer.valueOf(b02);
        }
    });

    /* renamed from: u, reason: collision with root package name */
    private static final Lazy f51094u = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.task.ad.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int a02;
            a02 = MemberTaskAdHelper.a0();
            return Integer.valueOf(a02);
        }
    });

    /* renamed from: g, reason: collision with root package name */
    private final Context f51095g;

    /* renamed from: h, reason: collision with root package name */
    private final n0 f51096h;

    /* renamed from: i, reason: collision with root package name */
    private BiddingSspNativeManager f51097i;

    /* renamed from: j, reason: collision with root package name */
    private Function1 f51098j;

    /* renamed from: k, reason: collision with root package name */
    private BiddingSspNativeManager f51099k;

    /* renamed from: l, reason: collision with root package name */
    private Function1 f51100l;

    /* renamed from: m, reason: collision with root package name */
    private BiddingVideoManager f51101m;

    /* renamed from: n, reason: collision with root package name */
    private Function1 f51102n;

    /* renamed from: o, reason: collision with root package name */
    private final c f51103o;

    /* renamed from: p, reason: collision with root package name */
    private final b f51104p;

    /* renamed from: q, reason: collision with root package name */
    private final MemberTaskAdHelper$rewardAdListener$1 f51105q;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ((Number) MemberTaskAdHelper.f51094u.getValue()).intValue();
        }

        public final int b() {
            return ((Number) MemberTaskAdHelper.f51093t.getValue()).intValue();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends di.a {
        b() {
        }

        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            Function1 function1 = MemberTaskAdHelper.this.f51100l;
            if (function1 != null) {
                function1.invoke(CollectionsKt.l());
            }
        }

        @Override // di.a
        public void k(List list) {
            Function1 function1;
            super.k(list);
            if (list != null) {
                MemberTaskAdHelper memberTaskAdHelper = MemberTaskAdHelper.this;
                List W = memberTaskAdHelper.W("MemberTaskRegularNativeScene", list, Boolean.FALSE);
                ArrayList arrayList = new ArrayList(CollectionsKt.v(W, 10));
                Iterator it = W.iterator();
                while (it.hasNext()) {
                    arrayList.add(x((BiddingIntermediateMaterialBean) it.next()));
                }
                boolean z10 = memberTaskAdHelper.u() <= 0;
                boolean z11 = memberTaskAdHelper.t() <= 0;
                if (z10) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : arrayList) {
                        if (!((v.a) obj).k()) {
                            arrayList2.add(obj);
                        }
                    }
                    arrayList = arrayList2;
                }
                if (z11) {
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj2 : arrayList) {
                        if (((v.a) obj2).k()) {
                            arrayList3.add(obj2);
                        }
                    }
                    arrayList = arrayList3;
                }
                if (arrayList.isEmpty() || (function1 = memberTaskAdHelper.f51100l) == null) {
                    return;
                }
                function1.invoke(arrayList);
            }
        }

        public final v.a x(BiddingIntermediateMaterialBean bean) {
            Intrinsics.h(bean, "bean");
            return new v.a(bean, null, null, null, null, MemberTaskAdHelper.this.g(bean), MemberTaskAdHelper.this.i(bean), false, 0L, TTAdConstant.VIDEO_URL_CODE, null);
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends di.a {
        c() {
        }

        @Override // di.a
        public void i(TAdErrorCode tAdErrorCode) {
            super.i(tAdErrorCode);
            Function1 function1 = MemberTaskAdHelper.this.f51098j;
            if (function1 != null) {
                function1.invoke(CollectionsKt.l());
            }
        }

        @Override // di.a
        public void k(List list) {
            super.k(list);
            if (list != null) {
                MemberTaskAdHelper memberTaskAdHelper = MemberTaskAdHelper.this;
                List W = memberTaskAdHelper.W("MemberTaskStageNativeScene", list, Boolean.TRUE);
                Function1 function1 = memberTaskAdHelper.f51098j;
                if (function1 != null) {
                    List list2 = W;
                    ArrayList arrayList = new ArrayList(CollectionsKt.v(list2, 10));
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(x((BiddingIntermediateMaterialBean) it.next()));
                    }
                    function1.invoke(arrayList);
                }
            }
        }

        public final v.c x(BiddingIntermediateMaterialBean bean) {
            Intrinsics.h(bean, "bean");
            return new v.c(bean, null, null, null, null, MemberTaskAdHelper.this.g(bean), false, 0L, 0L, 478, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.transsion.rewardscenter.task.ad.MemberTaskAdHelper$rewardAdListener$1] */
    public MemberTaskAdHelper(Context context, n0 n0Var) {
        super(context, n0Var);
        Intrinsics.h(context, "context");
        this.f51095g = context;
        this.f51096h = n0Var;
        this.f51103o = new c();
        this.f51104p = new b();
        this.f51105q = new di.a() { // from class: com.transsion.rewardscenter.task.ad.MemberTaskAdHelper$rewardAdListener$1
            @Override // di.a
            public void i(TAdErrorCode tAdErrorCode) {
                Context context2;
                Function1 function1;
                super.i(tAdErrorCode);
                context2 = MemberTaskAdHelper.this.f51095g;
                String string = context2.getString(R$string.common_failed);
                Intrinsics.g(string, "getString(...)");
                com.transsion.rewardscenter.utils.p.a(false, string);
                function1 = MemberTaskAdHelper.this.f51102n;
                if (function1 != null) {
                    function1.invoke(Boolean.FALSE);
                }
            }

            @Override // di.a
            public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                n0 n0Var2;
                super.j(biddingIntermediateMaterialBean);
                n0Var2 = MemberTaskAdHelper.this.f51096h;
                if (n0Var2 != null) {
                    kotlinx.coroutines.k.d(n0Var2, null, null, new MemberTaskAdHelper$rewardAdListener$1$onBiddingLoad$1(MemberTaskAdHelper.this, biddingIntermediateMaterialBean, null), 3, null);
                }
            }

            @Override // di.a
            public void o(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                Function1 function1;
                super.o(biddingIntermediateMaterialBean);
                if (biddingIntermediateMaterialBean != null) {
                    MemberTaskAdHelper memberTaskAdHelper = MemberTaskAdHelper.this;
                    BaseStageTaskAdHelper.A(memberTaskAdHelper, new v.b(null, 1, null), null, 2, null);
                    function1 = memberTaskAdHelper.f51102n;
                    if (function1 != null) {
                        function1.invoke(Boolean.TRUE);
                    }
                }
            }
        };
    }

    private final void T() {
        BiddingSspNativeManager biddingSspNativeManager = this.f51099k;
        if (biddingSspNativeManager != null) {
            biddingSspNativeManager.N0(null);
        }
        BiddingSspNativeManager biddingSspNativeManager2 = this.f51099k;
        if (biddingSspNativeManager2 != null) {
            biddingSspNativeManager2.V();
        }
        this.f51099k = null;
    }

    private final void U() {
        BiddingVideoManager biddingVideoManager = this.f51101m;
        if (biddingVideoManager != null) {
            biddingVideoManager.N0(null);
        }
        BiddingVideoManager biddingVideoManager2 = this.f51101m;
        if (biddingVideoManager2 != null) {
            biddingVideoManager2.V();
        }
        this.f51101m = null;
    }

    private final void V() {
        BiddingSspNativeManager biddingSspNativeManager = this.f51097i;
        if (biddingSspNativeManager != null) {
            biddingSspNativeManager.N0(null);
        }
        BiddingSspNativeManager biddingSspNativeManager2 = this.f51097i;
        if (biddingSspNativeManager2 != null) {
            biddingSspNativeManager2.V();
        }
        this.f51097i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List W(String str, List list, Boolean bool) {
        Iterator it = list.iterator();
        while (true) {
            String str2 = "Regular";
            if (!it.hasNext()) {
                break;
            }
            BiddingIntermediateMaterialBean biddingIntermediateMaterialBean = (BiddingIntermediateMaterialBean) it.next();
            a.C0856a c0856a = lg.a.f68962a;
            if (Intrinsics.c(bool, Boolean.TRUE)) {
                str2 = "Stage";
            }
            a.C0856a.f(c0856a, "StageTaskAd", "MemberTaskAdHelper ----> " + str2 + " loaded item, packageName: " + g(biddingIntermediateMaterialBean), false, 4, null);
        }
        List I0 = CollectionsKt.I0(list, new Comparator() { // from class: com.transsion.rewardscenter.task.ad.MemberTaskAdHelper$filterAds$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                Double ecpm = ((BiddingIntermediateMaterialBean) t12).getEcpm();
                Double valueOf = Double.valueOf(ecpm != null ? ecpm.doubleValue() : 0.0d);
                Double ecpm2 = ((BiddingIntermediateMaterialBean) t11).getEcpm();
                return ComparisonsKt.d(valueOf, Double.valueOf(ecpm2 != null ? ecpm2.doubleValue() : 0.0d));
            }
        });
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : I0) {
            if (hashSet.add(g((BiddingIntermediateMaterialBean) obj))) {
                arrayList.add(obj);
            }
        }
        ArrayList<BiddingIntermediateMaterialBean> arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (!u.f51176a.m(str, g((BiddingIntermediateMaterialBean) obj2))) {
                arrayList2.add(obj2);
            }
        }
        for (BiddingIntermediateMaterialBean biddingIntermediateMaterialBean2 : arrayList2) {
            a.C0856a c0856a2 = lg.a.f68962a;
            String str3 = Intrinsics.c(bool, Boolean.TRUE) ? "Stage" : "Regular";
            a.C0856a.f(c0856a2, "StageTaskAd", "MemberTaskAdHelper ----> " + str3 + " filtered item, packageName: " + g(biddingIntermediateMaterialBean2), false, 4, null);
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int a0() {
        return com.transsion.ad.scene.a.f42255a.g("MemberTaskRegularNativeScene");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b0() {
        return com.transsion.ad.scene.a.f42255a.g("MemberTaskStageNativeScene");
    }

    public final void Q(v.a data) {
        Intrinsics.h(data, "data");
        if (data.f()) {
            return;
        }
        data.n(true);
        a.C0856a.f(lg.a.f68962a, "StageTaskAd", "MemberTaskAdHelper ----> bindRegularNativeAd", false, 4, null);
        if (this.f51099k == null) {
            R();
        }
        data.p(new NativeWrapperAdView(this.f51095g, null, 2, null));
        data.l(new d0(this.f51095g));
        data.q(new w(this.f51095g));
        NativeWrapperAdView h11 = data.h();
        if (h11 != null) {
            h11.bindSspNativeView(this.f51099k, data.d(), data.j(), data.c());
        }
    }

    public final void R() {
        BiddingSspNativeManager biddingSspNativeManager = new BiddingSspNativeManager();
        this.f51099k = biddingSspNativeManager;
        biddingSspNativeManager.O0("MemberTaskRegularNativeScene");
        biddingSspNativeManager.N0(this.f51104p);
    }

    public final void S() {
        BiddingSspNativeManager biddingSspNativeManager = new BiddingSspNativeManager();
        this.f51097i = biddingSspNativeManager;
        biddingSspNativeManager.O0("MemberTaskStageNativeScene");
        biddingSspNativeManager.N0(this.f51103o);
    }

    public final void X(Function1 callback) {
        Intrinsics.h(callback, "callback");
        this.f51100l = callback;
        if (u() > 0 || t() > 0) {
            T();
            R();
            n0 n0Var = this.f51096h;
            if (n0Var != null) {
                kotlinx.coroutines.k.d(n0Var, y0.b(), null, new MemberTaskAdHelper$loadRegularAd$1(this, null), 2, null);
            }
        }
    }

    public final void Y(Function1 callback) {
        Intrinsics.h(callback, "callback");
        this.f51102n = callback;
        U();
        n0 n0Var = this.f51096h;
        if (n0Var != null) {
            kotlinx.coroutines.k.d(n0Var, y0.b(), null, new MemberTaskAdHelper$loadRewardAd$1(this, null), 2, null);
        }
    }

    public final void Z(Function1 callback) {
        Intrinsics.h(callback, "callback");
        this.f51098j = callback;
        if (v() <= 0) {
            return;
        }
        V();
        n0 n0Var = this.f51096h;
        if (n0Var != null) {
            kotlinx.coroutines.k.d(n0Var, y0.b(), null, new MemberTaskAdHelper$loadStageAd$1(this, null), 2, null);
        }
    }

    @Override // com.transsion.rewardscenter.task.ad.BaseStageTaskAdHelper
    public void c(v.c data) {
        Intrinsics.h(data, "data");
        if (data.f()) {
            return;
        }
        data.n(true);
        if (this.f51097i == null) {
            S();
        }
        data.p(new NativeWrapperAdView(this.f51095g, null, 2, null));
        data.l(new d0(this.f51095g));
        data.r(new w(this.f51095g));
        NativeWrapperAdView h11 = data.h();
        if (h11 != null) {
            h11.bindSspNativeView(this.f51097i, data.d(), data.k(), data.c());
        }
    }

    @Override // com.transsion.rewardscenter.task.ad.BaseStageTaskAdHelper
    public void d() {
        super.d();
        BiddingSspNativeManager biddingSspNativeManager = this.f51097i;
        if (biddingSspNativeManager != null) {
            biddingSspNativeManager.N0(null);
        }
        this.f51097i = null;
        BiddingSspNativeManager biddingSspNativeManager2 = this.f51099k;
        if (biddingSspNativeManager2 != null) {
            biddingSspNativeManager2.N0(null);
        }
        this.f51099k = null;
        U();
        this.f51098j = null;
        this.f51100l = null;
        this.f51102n = null;
    }
}
