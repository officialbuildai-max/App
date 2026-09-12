package com.transsion.postdetail.layer.local;

import com.hisavana.common.bean.TAdErrorCode;
import com.tencent.mmkv.MMKV;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.t1;

/* loaded from: classes6.dex */
public final class LocalBackAdHelper {

    /* renamed from: a, reason: collision with root package name */
    private final String f48985a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlinx.coroutines.n0 f48986b;

    /* renamed from: c, reason: collision with root package name */
    private final Function0 f48987c;

    /* renamed from: d, reason: collision with root package name */
    private final Function0 f48988d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f48989e;

    /* renamed from: f, reason: collision with root package name */
    private BiddingInterstitialManager f48990f;

    /* renamed from: g, reason: collision with root package name */
    private t1 f48991g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f48992h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f48993i;

    public LocalBackAdHelper(String sceneId, kotlinx.coroutines.n0 scope, Function0 getActivity, Function0 onFinish, boolean z10) {
        Intrinsics.h(sceneId, "sceneId");
        Intrinsics.h(scope, "scope");
        Intrinsics.h(getActivity, "getActivity");
        Intrinsics.h(onFinish, "onFinish");
        this.f48985a = sceneId;
        this.f48986b = scope;
        this.f48987c = getActivity;
        this.f48988d = onFinish;
        this.f48989e = z10;
    }

    public /* synthetic */ LocalBackAdHelper(String str, kotlinx.coroutines.n0 n0Var, Function0 function0, Function0 function02, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, n0Var, function0, function02, (i11 & 16) != 0 ? false : z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        t1 t1Var = this.f48991g;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
        this.f48991g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final di.a n() {
        return new di.a() { // from class: com.transsion.postdetail.layer.local.LocalBackAdHelper$createListener$1
            @Override // di.a
            public void i(TAdErrorCode tAdErrorCode) {
                boolean z10;
                String str;
                Function0 function0;
                super.i(tAdErrorCode);
                z10 = LocalBackAdHelper.this.f48992h;
                if (z10) {
                    return;
                }
                LocalBackAdHelper.this.f48993i = false;
                LocalBackAdHelper.this.m();
                ii.b bVar = ii.b.f65371a;
                str = LocalBackAdHelper.this.f48985a;
                bVar.e(str, false);
                function0 = LocalBackAdHelper.this.f48988d;
                function0.invoke();
            }

            /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
            
                r2 = r8.f48994d.f48990f;
             */
            @Override // di.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void j(com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean r9) {
                /*
                    r8 = this;
                    super.j(r9)
                    com.transsion.postdetail.layer.local.LocalBackAdHelper r0 = com.transsion.postdetail.layer.local.LocalBackAdHelper.this
                    boolean r0 = com.transsion.postdetail.layer.local.LocalBackAdHelper.j(r0)
                    if (r0 == 0) goto Lc
                    return
                Lc:
                    com.transsion.postdetail.layer.local.LocalBackAdHelper r0 = com.transsion.postdetail.layer.local.LocalBackAdHelper.this
                    com.transsion.postdetail.layer.local.LocalBackAdHelper.a(r0)
                    ii.b r0 = ii.b.f65371a
                    com.transsion.postdetail.layer.local.LocalBackAdHelper r1 = com.transsion.postdetail.layer.local.LocalBackAdHelper.this
                    java.lang.String r1 = com.transsion.postdetail.layer.local.LocalBackAdHelper.h(r1)
                    boolean r1 = r0.a(r1)
                    if (r1 != 0) goto L25
                    com.transsion.postdetail.layer.local.LocalBackAdHelper r9 = com.transsion.postdetail.layer.local.LocalBackAdHelper.this
                    com.transsion.postdetail.layer.local.LocalBackAdHelper.c(r9)
                    return
                L25:
                    com.transsion.postdetail.layer.local.LocalBackAdHelper r1 = com.transsion.postdetail.layer.local.LocalBackAdHelper.this
                    kotlin.jvm.functions.Function0 r1 = com.transsion.postdetail.layer.local.LocalBackAdHelper.d(r1)
                    java.lang.Object r1 = r1.invoke()
                    r3 = r1
                    android.app.Activity r3 = (android.app.Activity) r3
                    if (r3 == 0) goto L43
                    com.transsion.postdetail.layer.local.LocalBackAdHelper r1 = com.transsion.postdetail.layer.local.LocalBackAdHelper.this
                    com.transsion.ad.bidding.interstitial.BiddingInterstitialManager r2 = com.transsion.postdetail.layer.local.LocalBackAdHelper.e(r1)
                    if (r2 == 0) goto L43
                    r6 = 4
                    r7 = 0
                    r5 = 0
                    r4 = r9
                    com.transsion.ad.bidding.base.AbsAdBidding.R0(r2, r3, r4, r5, r6, r7)
                L43:
                    com.transsion.postdetail.layer.local.LocalBackAdHelper r9 = com.transsion.postdetail.layer.local.LocalBackAdHelper.this
                    java.lang.String r9 = com.transsion.postdetail.layer.local.LocalBackAdHelper.h(r9)
                    r1 = 2
                    r2 = 0
                    ii.b.g(r0, r9, r2, r1, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.layer.local.LocalBackAdHelper$createListener$1.j(com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean):void");
            }

            @Override // di.a
            public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                String str;
                BiddingInterstitialManager biddingInterstitialManager;
                String str2;
                boolean z10;
                Function0 function0;
                kotlinx.coroutines.n0 n0Var;
                super.m(biddingIntermediateMaterialBean);
                LocalBackAdHelper.this.f48993i = false;
                MMKV b11 = com.transsion.baselib.report.launch.b.f43424a.b();
                str = LocalBackAdHelper.this.f48985a;
                b11.putLong("show_" + str + "_timestamp", System.currentTimeMillis());
                biddingInterstitialManager = LocalBackAdHelper.this.f48990f;
                if (biddingInterstitialManager != null) {
                    biddingInterstitialManager.V();
                }
                ii.b bVar = ii.b.f65371a;
                str2 = LocalBackAdHelper.this.f48985a;
                bVar.e(str2, true);
                z10 = LocalBackAdHelper.this.f48989e;
                if (z10 && ox.e.f72320a.b().c()) {
                    n0Var = LocalBackAdHelper.this.f48986b;
                    kotlinx.coroutines.k.d(n0Var, null, null, new LocalBackAdHelper$createListener$1$onBiddingWrapperAdClose$1(LocalBackAdHelper.this, null), 3, null);
                } else {
                    function0 = LocalBackAdHelper.this.f48988d;
                    function0.invoke();
                }
            }

            @Override // di.a
            public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                boolean z10;
                String str;
                Function0 function0;
                super.p(biddingIntermediateMaterialBean);
                z10 = LocalBackAdHelper.this.f48992h;
                if (z10) {
                    return;
                }
                LocalBackAdHelper.this.f48993i = false;
                LocalBackAdHelper.this.m();
                ii.b bVar = ii.b.f65371a;
                str = LocalBackAdHelper.this.f48985a;
                bVar.e(str, false);
                function0 = LocalBackAdHelper.this.f48988d;
                function0.invoke();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        if (this.f48992h) {
            return;
        }
        this.f48992h = true;
        this.f48993i = false;
        BiddingInterstitialManager biddingInterstitialManager = this.f48990f;
        if (biddingInterstitialManager != null) {
            biddingInterstitialManager.V();
        }
        this.f48990f = null;
        ii.b.f65371a.e(this.f48985a, false);
        this.f48988d.invoke();
    }

    private final void s() {
        t1 d11;
        d11 = kotlinx.coroutines.k.d(this.f48986b, null, null, new LocalBackAdHelper$startTimeout$1(this, null), 3, null);
        this.f48991g = d11;
    }

    public final void o() {
        this.f48993i = false;
        m();
        BiddingInterstitialManager biddingInterstitialManager = this.f48990f;
        if (biddingInterstitialManager != null) {
            biddingInterstitialManager.V();
        }
        this.f48990f = null;
    }

    public final void q(String str) {
        BiddingInterstitialManager.f42019w.a(this.f48985a, com.transsion.ad.strategy.d.f42285a.a(str));
        ii.b.f65371a.h(this.f48985a);
    }

    public final void r(String str) {
        if (this.f48993i) {
            return;
        }
        this.f48992h = false;
        if (!ii.b.f65371a.a(this.f48985a)) {
            this.f48988d.invoke();
            return;
        }
        this.f48993i = true;
        kotlinx.coroutines.k.d(this.f48986b, null, null, new LocalBackAdHelper$show$1(this, str, null), 3, null);
        s();
    }
}
