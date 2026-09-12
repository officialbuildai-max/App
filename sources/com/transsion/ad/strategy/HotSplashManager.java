package com.transsion.ad.strategy;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.view.v;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class HotSplashManager extends di.a {

    /* renamed from: e, reason: collision with root package name */
    private static long f42274e;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f42275f;

    /* renamed from: g, reason: collision with root package name */
    private static BiddingInterstitialManager f42276g;

    /* renamed from: d, reason: collision with root package name */
    public static final HotSplashManager f42273d = new HotSplashManager();

    /* renamed from: h, reason: collision with root package name */
    private static final Handler f42277h = new Handler(Looper.getMainLooper());

    private HotSplashManager() {
    }

    private final String B() {
        JsonElement jsonElement;
        Activity b11 = com.blankj.utilcode.util.a.b();
        if (b11 == null) {
            return "topAct is null";
        }
        if (b11.isDestroyed()) {
            return "topAct?.isDestroyed == true";
        }
        ti.o oVar = ti.o.f76388a;
        if (!oVar.a(b11) || oVar.b(b11)) {
            return "处理App在锁屏状态下被拉活";
        }
        hi.c cVar = hi.c.f64590a;
        if (cVar.a()) {
            cVar.b(false);
            return "全搜的时候热启动不展示热启动广告";
        }
        if (f42274e <= 0) {
            return "inBackgroundTime <= 0";
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - f42274e;
        JsonObject b12 = com.transsion.ad.scene.d.f42258a.b(hi.d.f64592a.a());
        int asInt = ((b12 == null || (jsonElement = b12.get("hotSplashInterval")) == null) ? 1 : jsonElement.getAsInt()) * 60000;
        if (elapsedRealtime >= asInt) {
            return "";
        }
        return "不满足最小间隔时间 -- background_time = " + elapsedRealtime + " --- TIME_IN_THE_BACKGROUND = " + asInt;
    }

    private final void C() {
        String a11 = hi.d.f64592a.a();
        ii.b bVar = ii.b.f65371a;
        if (bVar.a(a11)) {
            String B = B();
            if (TextUtils.isEmpty(B)) {
                if (f42276g != null) {
                    ii.b.d(bVar, a11, false, 2, null);
                    return;
                } else {
                    kotlinx.coroutines.i.d(o0.a(y0.b()), null, null, new HotSplashManager$loadHotSplashAd$1(null), 3, null);
                    return;
                }
            }
            oi.a.f71145a.n("ad_int", getClassTag() + " --> loadHotSplashAd() --> msg = " + B, 6, false);
            ii.b.d(bVar, a11, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E() {
        f42273d.C();
    }

    private final void G() {
        BiddingInterstitialManager biddingInterstitialManager = f42276g;
        if (biddingInterstitialManager != null) {
            biddingInterstitialManager.V();
        }
        f42276g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = HotSplashManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final void D() {
        if (hi.d.f64592a.b()) {
            oi.a.o(oi.a.f71145a, "ad_int", getClassTag() + " --> onStop() --> App进入前台", 0, false, 4, null);
            f42275f = false;
            Handler handler = f42277h;
            handler.removeCallbacksAndMessages(null);
            handler.postDelayed(new Runnable() { // from class: com.transsion.ad.strategy.j
                @Override // java.lang.Runnable
                public final void run() {
                    HotSplashManager.E();
                }
            }, 300L);
        }
    }

    public final void F() {
        hi.d dVar = hi.d.f64592a;
        if (dVar.b()) {
            oi.a.o(oi.a.f71145a, "ad_int", getClassTag() + " --> onStop() --> App进入后台", 0, false, 4, null);
            f42274e = SystemClock.elapsedRealtime();
            f42275f = true;
            f42277h.removeCallbacksAndMessages(null);
            String a11 = dVar.a();
            ii.b.f65371a.h(a11);
            BiddingInterstitialManager.Companion.b(BiddingInterstitialManager.f42019w, a11, null, 2, null);
        }
    }

    @Override // di.a
    public void i(TAdErrorCode tAdErrorCode) {
        super.i(tAdErrorCode);
        ii.b.f65371a.e(hi.d.f64592a.a(), false);
        G();
    }

    @Override // di.a
    public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.j(biddingIntermediateMaterialBean);
        if (!ii.b.f65371a.a(hi.d.f64592a.a())) {
            G();
            return;
        }
        Activity b11 = com.blankj.utilcode.util.a.b();
        if (b11 != null) {
            AppCompatActivity appCompatActivity = b11 instanceof AppCompatActivity ? (AppCompatActivity) b11 : null;
            if (appCompatActivity != null) {
                kotlinx.coroutines.i.d(v.a(appCompatActivity), null, null, new HotSplashManager$onBiddingLoad$1$1$1(b11, biddingIntermediateMaterialBean, null), 3, null);
            }
        }
    }

    @Override // di.a
    public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.m(biddingIntermediateMaterialBean);
        ii.b.f65371a.e(hi.d.f64592a.a(), true);
        G();
    }

    @Override // di.a
    public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        super.p(biddingIntermediateMaterialBean);
        ii.b.f65371a.e(hi.d.f64592a.a(), false);
        G();
    }
}
