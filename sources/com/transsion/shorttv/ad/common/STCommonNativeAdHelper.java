package com.transsion.shorttv.ad.common;

import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.base.r;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.shorttv.ad.AdLoadState;
import java.lang.ref.WeakReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class STCommonNativeAdHelper {

    /* renamed from: a, reason: collision with root package name */
    private final String f52742a;

    /* renamed from: b, reason: collision with root package name */
    private final n0 f52743b;

    /* renamed from: c, reason: collision with root package name */
    private BiddingNativeManager f52744c;

    /* renamed from: d, reason: collision with root package name */
    private BiddingIntermediateMaterialBean f52745d;

    /* renamed from: e, reason: collision with root package name */
    private Function1 f52746e;

    /* renamed from: f, reason: collision with root package name */
    private Function1 f52747f;

    /* renamed from: g, reason: collision with root package name */
    private WeakReference f52748g;

    /* renamed from: h, reason: collision with root package name */
    private String f52749h;

    /* renamed from: i, reason: collision with root package name */
    private AdLoadState f52750i;

    /* renamed from: j, reason: collision with root package name */
    private final STCommonNativeAdHelper$nativeAdListener$1 f52751j;

    /* JADX WARN: Type inference failed for: r2v3, types: [com.transsion.shorttv.ad.common.STCommonNativeAdHelper$nativeAdListener$1] */
    public STCommonNativeAdHelper(String sceneId, n0 scope) {
        Intrinsics.h(sceneId, "sceneId");
        Intrinsics.h(scope, "scope");
        this.f52742a = sceneId;
        this.f52743b = scope;
        this.f52749h = "";
        this.f52750i = AdLoadState.IDLE;
        this.f52751j = new di.a() { // from class: com.transsion.shorttv.ad.common.STCommonNativeAdHelper$nativeAdListener$1
            @Override // di.a
            public void i(TAdErrorCode tAdErrorCode) {
                BiddingNativeManager biddingNativeManager;
                n0 n0Var;
                super.i(tAdErrorCode);
                STCommonNativeAdHelper.this.f52750i = AdLoadState.FAILED;
                ur.a aVar = ur.a.f77012a;
                String o11 = STCommonNativeAdHelper.this.o();
                String str = "onBiddingError, error=" + tAdErrorCode;
                biddingNativeManager = STCommonNativeAdHelper.this.f52744c;
                aVar.d(o11, str, biddingNativeManager != null ? biddingNativeManager.getMSceneId() : null);
                n0Var = STCommonNativeAdHelper.this.f52743b;
                k.d(n0Var, y0.c(), null, new STCommonNativeAdHelper$nativeAdListener$1$onBiddingError$1(STCommonNativeAdHelper.this, null), 2, null);
            }

            @Override // di.a
            public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                BiddingNativeManager biddingNativeManager;
                n0 n0Var;
                super.j(biddingIntermediateMaterialBean);
                STCommonNativeAdHelper.this.f52750i = AdLoadState.SUCCEED;
                ur.a aVar = ur.a.f77012a;
                String o11 = STCommonNativeAdHelper.this.o();
                biddingNativeManager = STCommonNativeAdHelper.this.f52744c;
                aVar.b(o11, "onBiddingLoad", biddingNativeManager != null ? biddingNativeManager.getMSceneId() : null);
                STCommonNativeAdHelper.this.f52745d = biddingIntermediateMaterialBean;
                n0Var = STCommonNativeAdHelper.this.f52743b;
                k.d(n0Var, y0.c(), null, new STCommonNativeAdHelper$nativeAdListener$1$onBiddingLoad$1(STCommonNativeAdHelper.this, null), 2, null);
            }

            @Override // di.a
            public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                BiddingNativeManager biddingNativeManager;
                super.m(biddingIntermediateMaterialBean);
                STCommonNativeAdHelper.this.f52750i = AdLoadState.CLOSED;
                ur.a aVar = ur.a.f77012a;
                String o11 = STCommonNativeAdHelper.this.o();
                biddingNativeManager = STCommonNativeAdHelper.this.f52744c;
                aVar.d(o11, "onBiddingWrapperAdClose", biddingNativeManager != null ? biddingNativeManager.getMSceneId() : null);
                STCommonNativeAdHelper.this.m(4);
            }

            @Override // di.a
            public void n(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                BiddingNativeManager biddingNativeManager;
                n0 n0Var;
                super.n(biddingIntermediateMaterialBean);
                ur.a aVar = ur.a.f77012a;
                String o11 = STCommonNativeAdHelper.this.o();
                biddingNativeManager = STCommonNativeAdHelper.this.f52744c;
                aVar.b(o11, "onBiddingWrapperAdDisplay", biddingNativeManager != null ? biddingNativeManager.getMSceneId() : null);
                n0Var = STCommonNativeAdHelper.this.f52743b;
                k.d(n0Var, y0.c(), null, new STCommonNativeAdHelper$nativeAdListener$1$onBiddingWrapperAdDisplay$1(STCommonNativeAdHelper.this, null), 2, null);
            }

            @Override // di.a
            public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                BiddingNativeManager biddingNativeManager;
                n0 n0Var;
                super.p(biddingIntermediateMaterialBean);
                ur.a aVar = ur.a.f77012a;
                String o11 = STCommonNativeAdHelper.this.o();
                biddingNativeManager = STCommonNativeAdHelper.this.f52744c;
                aVar.d(o11, "onBiddingWrapperAdShowError", biddingNativeManager != null ? biddingNativeManager.getMSceneId() : null);
                n0Var = STCommonNativeAdHelper.this.f52743b;
                k.d(n0Var, y0.c(), null, new STCommonNativeAdHelper$nativeAdListener$1$onBiddingWrapperAdShowError$1(STCommonNativeAdHelper.this, null), 2, null);
            }
        };
    }

    public static /* synthetic */ void n(STCommonNativeAdHelper sTCommonNativeAdHelper, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        sTCommonNativeAdHelper.m(i11);
    }

    public final void m(int i11) {
        this.f52750i = AdLoadState.DESTROYED;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (this.f52744c != null) {
                if (i11 == 0) {
                    ur.a.f77012a.b(this.f52749h, "trigger destroy", this.f52742a);
                } else if (i11 == 1) {
                    ur.a.f77012a.b(this.f52749h, "trigger destroy when load error", this.f52742a);
                } else if (i11 == 2) {
                    ur.a.f77012a.b(this.f52749h, "trigger destroy when show error", this.f52742a);
                } else if (i11 == 3) {
                    ur.a.f77012a.b(this.f52749h, "trigger destroy before load", this.f52742a);
                } else if (i11 != 4) {
                    ur.a.f77012a.b(this.f52749h, "trigger destroy", this.f52742a);
                } else {
                    ur.a.f77012a.b(this.f52749h, "trigger destroy when ad closed", this.f52742a);
                }
                BiddingNativeManager biddingNativeManager = this.f52744c;
                if (biddingNativeManager != null) {
                    biddingNativeManager.V();
                }
                this.f52744c = null;
            }
            this.f52745d = null;
            this.f52746e = null;
            this.f52747f = null;
            WeakReference weakReference = this.f52748g;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.f52748g = null;
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public final String o() {
        return this.f52749h;
    }

    public final String p() {
        return this.f52742a;
    }

    public final void q(Function1 callback) {
        Intrinsics.h(callback, "callback");
        if (this.f52742a.length() == 0) {
            ur.a.f77012a.d(this.f52749h, "trigger load ad error, sceneId is null", this.f52742a);
            return;
        }
        AdLoadState adLoadState = this.f52750i;
        if (adLoadState == AdLoadState.LOADING) {
            ur.a.f77012a.d(this.f52749h, "trigger load ad error, current ad is loading", this.f52742a);
        } else if (adLoadState == AdLoadState.SUCCEED) {
            ur.a.f77012a.d(this.f52749h, "trigger load ad error, current ad is already loaded succeed", this.f52742a);
        } else {
            k.d(this.f52743b, y0.c(), null, new STCommonNativeAdHelper$loadAd$1(this, callback, null), 2, null);
        }
    }

    public final void r(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f52749h = str;
    }

    public final void s(r layoutProvider, NativeWrapperAdView nativeAdView, Function1 function1) {
        Intrinsics.h(layoutProvider, "layoutProvider");
        Intrinsics.h(nativeAdView, "nativeAdView");
        if (this.f52744c != null && this.f52745d != null) {
            k.d(this.f52743b, y0.c(), null, new STCommonNativeAdHelper$showAd$1(this, function1, nativeAdView, layoutProvider, null), 2, null);
            return;
        }
        ur.a.f77012a.d(this.f52749h, "trigger show ad error, nativeManager or maxEcpmObject is null", this.f52742a);
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }
}
