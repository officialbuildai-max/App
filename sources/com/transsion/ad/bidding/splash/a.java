package com.transsion.ad.bidding.splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.common.interfacz.OnSkipListener;
import com.hisavana.mediation.ad.TSplashAd;
import com.hisavana.mediation.ad.TSplashView;
import com.transsion.ad.MBAd;
import com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager;
import com.transsion.ad.strategy.d;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a extends AbsBiddingInterceptHiSavanaAdManager {

    /* renamed from: n, reason: collision with root package name */
    public static final C0594a f42086n = new C0594a(null);

    /* renamed from: o, reason: collision with root package name */
    private static final Lazy f42087o = LazyKt.b(new Function0() { // from class: gi.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            HashMap x10;
            x10 = com.transsion.ad.bidding.splash.a.x();
            return x10;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    private TSplashAd f42088i;

    /* renamed from: j, reason: collision with root package name */
    private String f42089j;

    /* renamed from: k, reason: collision with root package name */
    private Integer f42090k;

    /* renamed from: l, reason: collision with root package name */
    private WeakReference f42091l;

    /* renamed from: m, reason: collision with root package name */
    private WeakReference f42092m;

    /* renamed from: com.transsion.ad.bidding.splash.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0594a {
        private C0594a() {
        }

        public /* synthetic */ C0594a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final HashMap b() {
            return (HashMap) a.f42087o.getValue();
        }

        public final a a(String str) {
            String h11;
            if (TextUtils.isEmpty(str) || (h11 = com.transsion.ad.scene.a.f42255a.h(str)) == null) {
                return null;
            }
            a aVar = (a) b().get(h11);
            if (aVar == null) {
                aVar = new a();
                aVar.q(h11);
                b().put(h11, aVar);
            }
            aVar.y(str);
            return aVar;
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements OnSkipListener {
        b() {
        }

        @Override // com.hisavana.common.interfacz.OnSkipListener
        public void onClick() {
            oi.a.o(oi.a.f71145a, "ad_s", "BiddingHisavanaSplashActivity --> onSkipClick()", 0, false, 12, null);
            WeakReference weakReference = a.this.f42091l;
            Context context = weakReference != null ? (Activity) weakReference.get() : null;
            BiddingHisavanaSplashActivity biddingHisavanaSplashActivity = context instanceof BiddingHisavanaSplashActivity ? (BiddingHisavanaSplashActivity) context : null;
            if (biddingHisavanaSplashActivity != null) {
                biddingHisavanaSplashActivity.R();
            }
        }

        @Override // com.hisavana.common.interfacz.OnSkipListener
        public void onTimeReach() {
            oi.a.o(oi.a.f71145a, "ad_s", "BiddingHisavanaSplashActivity --> onTimeReach()", 0, false, 12, null);
            WeakReference weakReference = a.this.f42091l;
            Context context = weakReference != null ? (Activity) weakReference.get() : null;
            BiddingHisavanaSplashActivity biddingHisavanaSplashActivity = context instanceof BiddingHisavanaSplashActivity ? (BiddingHisavanaSplashActivity) context : null;
            if (biddingHisavanaSplashActivity != null) {
                biddingHisavanaSplashActivity.T();
            }
        }
    }

    public static /* synthetic */ void A(a aVar, BiddingHisavanaSplashActivity biddingHisavanaSplashActivity, TSplashView tSplashView, View view, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            view = null;
        }
        aVar.z(biddingHisavanaSplashActivity, tSplashView, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HashMap x() {
        return new HashMap();
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager
    public ce.b e() {
        String str;
        if (this.f42088i == null) {
            TSplashAd tSplashAd = new TSplashAd(Utils.a(), i());
            this.f42088i = tSplashAd;
            tSplashAd.setRequestBody(new TAdRequestBody.AdRequestBodyBuild().setAdditionalListener(this).build());
            TSplashAd tSplashAd2 = this.f42088i;
            if (tSplashAd2 != null) {
                tSplashAd2.setSplashMode(2);
            }
            TSplashAd tSplashAd3 = this.f42088i;
            if (tSplashAd3 != null) {
                tSplashAd3.setOnSkipListener(new b());
            }
            TSplashAd tSplashAd4 = this.f42088i;
            if (tSplashAd4 != null) {
                MBAd mBAd = MBAd.f41805a;
                MBAd.a c11 = mBAd.c();
                if (c11 == null || (str = c11.f()) == null) {
                    str = "";
                }
                MBAd.a c12 = mBAd.c();
                tSplashAd4.setOnlySourceAdx(str, c12 != null ? c12.l() : false);
            }
        }
        return this.f42088i;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager
    public int f() {
        return 5;
    }

    @Override // oi.b
    public String getLogTag() {
        return "ad_s";
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager
    public void o() {
        TSplashAd tSplashAd = this.f42088i;
        if (tSplashAd != null) {
            tSplashAd.destroy();
        }
        this.f42088i = null;
    }

    @Override // com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager
    public void r(Activity topActivity, String sceneId, Integer num, Map map) {
        Object m1185constructorimpl;
        TSplashAd tSplashAd;
        Intrinsics.h(topActivity, "topActivity");
        Intrinsics.h(sceneId, "sceneId");
        this.f42090k = num;
        this.f42092m = new WeakReference(topActivity);
        if (d.f42285a.d(map) && (tSplashAd = this.f42088i) != null) {
            tSplashAd.setContainVulgarContent(true);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Intent intent = new Intent(topActivity, (Class<?>) BiddingHisavanaSplashActivity.class);
            intent.putExtra("key_scene_id", sceneId);
            topActivity.startActivity(intent);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            oi.a.o(oi.a.f71145a, "ad_s", "程序化开屏 show 异常 --> " + m1188exceptionOrNullimpl.getMessage(), 0, false, 12, null);
            di.a h11 = h();
            if (h11 != null) {
                h11.onShowError(new TAdErrorCode(-1, "程序化开屏 show 异常 --> " + m1188exceptionOrNullimpl.getMessage()), new AdditionalInfo());
            }
        }
    }

    public final void y(String str) {
        this.f42089j = str;
    }

    public final void z(BiddingHisavanaSplashActivity activity, TSplashView tSplashView, View view) {
        TSplashAd tSplashAd;
        Intrinsics.h(activity, "activity");
        this.f42091l = new WeakReference(activity);
        if (tSplashView == null || (tSplashAd = this.f42088i) == null) {
            return;
        }
        tSplashAd.showAd(tSplashView, view);
    }
}
