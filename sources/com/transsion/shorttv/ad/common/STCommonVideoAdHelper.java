package com.transsion.shorttv.ad.common;

import android.app.Activity;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsion.shorttv.ad.AdLoadState;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class STCommonVideoAdHelper {

    /* renamed from: a, reason: collision with root package name */
    private final String f52753a;

    /* renamed from: b, reason: collision with root package name */
    private final n0 f52754b;

    /* renamed from: c, reason: collision with root package name */
    private BiddingVideoManager f52755c;

    /* renamed from: d, reason: collision with root package name */
    private BiddingIntermediateMaterialBean f52756d;

    /* renamed from: e, reason: collision with root package name */
    private Function3 f52757e;

    /* renamed from: f, reason: collision with root package name */
    private Function0 f52758f;

    /* renamed from: g, reason: collision with root package name */
    private Function1 f52759g;

    /* renamed from: h, reason: collision with root package name */
    private String f52760h;

    /* renamed from: i, reason: collision with root package name */
    private AdLoadState f52761i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f52762j;

    /* renamed from: k, reason: collision with root package name */
    private final STCommonVideoAdHelper$videoListener$1 f52763k;

    /* JADX WARN: Type inference failed for: r2v3, types: [com.transsion.shorttv.ad.common.STCommonVideoAdHelper$videoListener$1] */
    public STCommonVideoAdHelper(String sceneId, n0 scope) {
        Intrinsics.h(sceneId, "sceneId");
        Intrinsics.h(scope, "scope");
        this.f52753a = sceneId;
        this.f52754b = scope;
        this.f52760h = "";
        this.f52761i = AdLoadState.IDLE;
        this.f52763k = new di.a() { // from class: com.transsion.shorttv.ad.common.STCommonVideoAdHelper$videoListener$1
            @Override // di.a
            public void i(TAdErrorCode tAdErrorCode) {
                BiddingVideoManager biddingVideoManager;
                n0 n0Var;
                super.i(tAdErrorCode);
                STCommonVideoAdHelper.this.f52761i = AdLoadState.FAILED;
                ur.a aVar = ur.a.f77012a;
                String r11 = STCommonVideoAdHelper.this.r();
                String str = "onBiddingError, error=" + tAdErrorCode;
                biddingVideoManager = STCommonVideoAdHelper.this.f52755c;
                aVar.d(r11, str, biddingVideoManager != null ? biddingVideoManager.getMSceneId() : null);
                n0Var = STCommonVideoAdHelper.this.f52754b;
                k.d(n0Var, y0.c(), null, new STCommonVideoAdHelper$videoListener$1$onBiddingError$1(STCommonVideoAdHelper.this, tAdErrorCode, null), 2, null);
            }

            @Override // di.a
            public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                BiddingVideoManager biddingVideoManager;
                n0 n0Var;
                super.j(biddingIntermediateMaterialBean);
                STCommonVideoAdHelper.this.f52761i = AdLoadState.SUCCEED;
                ur.a aVar = ur.a.f77012a;
                String r11 = STCommonVideoAdHelper.this.r();
                biddingVideoManager = STCommonVideoAdHelper.this.f52755c;
                aVar.b(r11, "onBiddingLoad", biddingVideoManager != null ? biddingVideoManager.getMSceneId() : null);
                STCommonVideoAdHelper.this.f52756d = biddingIntermediateMaterialBean;
                n0Var = STCommonVideoAdHelper.this.f52754b;
                k.d(n0Var, y0.c(), null, new STCommonVideoAdHelper$videoListener$1$onBiddingLoad$1(STCommonVideoAdHelper.this, null), 2, null);
            }

            @Override // di.a
            public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                boolean z10;
                BiddingVideoManager biddingVideoManager;
                boolean z11;
                n0 n0Var;
                super.m(biddingIntermediateMaterialBean);
                STCommonVideoAdHelper.this.f52761i = AdLoadState.CLOSED;
                ur.a aVar = ur.a.f77012a;
                String r11 = STCommonVideoAdHelper.this.r();
                z10 = STCommonVideoAdHelper.this.f52762j;
                String str = "onBiddingWrapperAdClose, isRewarded=" + z10;
                biddingVideoManager = STCommonVideoAdHelper.this.f52755c;
                aVar.b(r11, str, biddingVideoManager != null ? biddingVideoManager.getMSceneId() : null);
                z11 = STCommonVideoAdHelper.this.f52762j;
                n0Var = STCommonVideoAdHelper.this.f52754b;
                k.d(n0Var, y0.c(), null, new STCommonVideoAdHelper$videoListener$1$onBiddingWrapperAdClose$1(STCommonVideoAdHelper.this, z11, null), 2, null);
            }

            @Override // di.a
            public void o(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                BiddingVideoManager biddingVideoManager;
                n0 n0Var;
                super.o(biddingIntermediateMaterialBean);
                ur.a aVar = ur.a.f77012a;
                String r11 = STCommonVideoAdHelper.this.r();
                biddingVideoManager = STCommonVideoAdHelper.this.f52755c;
                aVar.b(r11, "onBiddingWrapperAdRewarded", biddingVideoManager != null ? biddingVideoManager.getMSceneId() : null);
                STCommonVideoAdHelper.this.f52762j = true;
                n0Var = STCommonVideoAdHelper.this.f52754b;
                k.d(n0Var, y0.c(), null, new STCommonVideoAdHelper$videoListener$1$onBiddingWrapperAdRewarded$1(STCommonVideoAdHelper.this, null), 2, null);
            }
        };
    }

    public static /* synthetic */ void q(STCommonVideoAdHelper sTCommonVideoAdHelper, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        sTCommonVideoAdHelper.p(i11);
    }

    public final void p(int i11) {
        this.f52761i = AdLoadState.DESTROYED;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (this.f52755c != null) {
                if (i11 == 0) {
                    ur.a.f77012a.b(this.f52760h, "trigger destroy", this.f52753a);
                } else if (i11 == 1) {
                    ur.a.f77012a.b(this.f52760h, "trigger destroy when load error", this.f52753a);
                } else if (i11 == 3) {
                    ur.a.f77012a.b(this.f52760h, "trigger destroy before load", this.f52753a);
                } else if (i11 != 4) {
                    ur.a.f77012a.b(this.f52760h, "trigger destroy", this.f52753a);
                } else {
                    ur.a.f77012a.b(this.f52760h, "trigger destroy when ad closed", this.f52753a);
                }
                BiddingVideoManager biddingVideoManager = this.f52755c;
                if (biddingVideoManager != null) {
                    biddingVideoManager.V();
                }
                this.f52755c = null;
            }
            this.f52756d = null;
            this.f52757e = null;
            this.f52758f = null;
            this.f52759g = null;
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public final String r() {
        return this.f52760h;
    }

    public final String s() {
        return this.f52753a;
    }

    public final void t(Function3 function3) {
        if (this.f52753a.length() == 0) {
            ur.a.f77012a.d(this.f52760h, "trigger load ad error, sceneId is null", this.f52753a);
            return;
        }
        AdLoadState adLoadState = this.f52761i;
        if (adLoadState == AdLoadState.LOADING) {
            ur.a.f77012a.d(this.f52760h, "trigger load ad error, current ad is loading", this.f52753a);
        } else if (adLoadState == AdLoadState.SUCCEED) {
            ur.a.f77012a.d(this.f52760h, "trigger load ad error, current ad is already loaded succeed", this.f52753a);
        } else {
            k.d(this.f52754b, y0.c(), null, new STCommonVideoAdHelper$loadAd$1(this, function3, null), 2, null);
        }
    }

    public final void u(Activity activity, Function0 function0, Function1 function1) {
        Intrinsics.h(activity, "activity");
        if (this.f52755c == null || this.f52756d == null) {
            ur.a.f77012a.d(this.f52760h, "trigger show ad error, videoManager or maxEcpmObject is null", this.f52753a);
        } else {
            k.d(this.f52754b, y0.c(), null, new STCommonVideoAdHelper$showAd$1(this, function0, function1, activity, null), 2, null);
        }
    }
}
