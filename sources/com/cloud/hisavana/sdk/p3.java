package com.cloud.hisavana.sdk;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import com.cloud.hisavana.sdk.api.adx.TBannerView;
import com.cloud.hisavana.sdk.api.listener.AdCallback;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public final class p3 extends G {

    /* renamed from: i, reason: collision with root package name */
    o f22912i;

    /* renamed from: j, reason: collision with root package name */
    private volatile AdsDTO f22913j;

    /* renamed from: k, reason: collision with root package name */
    a f22914k;

    /* renamed from: l, reason: collision with root package name */
    private ViewGroup f22915l;

    /* renamed from: m, reason: collision with root package name */
    private CopyOnWriteArrayList f22916m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f22917n;

    /* renamed from: o, reason: collision with root package name */
    private WeakReference f22918o;

    /* renamed from: p, reason: collision with root package name */
    public long f22919p;

    /* renamed from: q, reason: collision with root package name */
    public Integer f22920q;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference f22921a;

        /* renamed from: b, reason: collision with root package name */
        private final int f22922b;

        /* renamed from: c, reason: collision with root package name */
        private int f22923c;

        a(p3 p3Var, Looper looper, int i11) {
            super(looper);
            this.f22923c = 1;
            this.f22921a = new WeakReference(p3Var);
            this.f22922b = i11;
        }

        public void a() {
            this.f22923c = 1;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            p3 p3Var;
            super.handleMessage(message);
            int i11 = this.f22923c;
            if (i11 >= this.f22922b) {
                return;
            }
            this.f22923c = i11 + 1;
            WeakReference weakReference = this.f22921a;
            if (weakReference == null || weakReference.get() == null || (p3Var = (p3) this.f22921a.get()) == null) {
                return;
            }
            p3Var.T();
        }
    }

    public p3(q3 q3Var) {
        super(q3Var);
        this.f22913j = null;
        this.f22916m = new CopyOnWriteArrayList();
        this.f22918o = null;
        this.f22919p = 0L;
        this.f22920q = 0;
    }

    private void F() {
        e4.b().d("TranBanner", "postDelayRefresh");
        if (!S() || this.f22913j == null) {
            return;
        }
        this.f21583b.f();
        try {
            this.f22920q = this.f21583b.f().getCarouselCount();
        } catch (Throwable unused) {
        }
        if (this.f22914k == null) {
            this.f22914k = new a(this, Looper.getMainLooper(), this.f22920q.intValue());
        }
        long carouselTime = this.f21583b.f().getCarouselTime() * 1000;
        this.f22919p = carouselTime;
        this.f22914k.sendEmptyMessageDelayed(1, carouselTime);
    }

    private void G() {
        this.f22912i = new o(this);
    }

    private void O(AdsDTO adsDTO) {
        if (adsDTO == null) {
            return;
        }
        com.cloud.hisavana.sdk.common.tranmeasure.e.c().g(adsDTO);
        k4.f22682a.j(adsDTO.getUuid());
    }

    private void Q() {
        ViewGroup viewGroup;
        AdCallback adCallback = this.f21586e;
        if (adCallback == null || (viewGroup = this.f22915l) == null || !(viewGroup instanceof TBannerView)) {
            return;
        }
        adCallback.n((TBannerView) viewGroup, this.f22913j);
    }

    private void R() {
        o oVar;
        if (this.f22913j != null && (oVar = this.f22912i) != null) {
            oVar.g(this.f22915l, this.f21583b.w(), this.f21583b.t(), this.f22913j);
            return;
        }
        if (this.f22913j == null) {
            J(TaErrorCode.ERROR_SHOW_ADBEAN_NULL);
        }
        e4.b().d("TranBanner", "no ad show, set visible gone");
        ViewGroup viewGroup = this.f22915l;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean S() {
        return this.f21583b.f() != null && this.f21583b.f().getCarouselTime() > 0 && this.f21583b.f().getCarouselCount().intValue() > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        a aVar = this.f22914k;
        if (aVar != null) {
            aVar.a();
        }
        e4.b().d("TranBanner", "loadNextAD");
        this.f21583b.d(DeviceUtil.o());
        WeakReference weakReference = this.f22918o;
        if (weakReference == null) {
            e4.b().d("TranBanner", "loadNextAD weakTBannerView is null ,not show");
            return;
        }
        TBannerView tBannerView = (TBannerView) weakReference.get();
        if (tBannerView != null) {
            e4.b().d("TranBanner", "loadNextAD loadAdFromAutoRefresh true");
            tBannerView.loadAdFromAutoRefresh(true);
        }
    }

    public void H(int i11) {
        ViewGroup viewGroup = this.f22915l;
        if (viewGroup instanceof TBannerView) {
            ((TBannerView) viewGroup).setCloseTypeUsedForTrack(Integer.valueOf(i11));
        }
        Q();
    }

    public void I(TBannerView tBannerView) {
        this.f22918o = new WeakReference(tBannerView);
    }

    public void J(TaErrorCode taErrorCode) {
        try {
            AdCallback adCallback = this.f21586e;
            if (adCallback != null) {
                adCallback.t(taErrorCode, this);
            }
        } catch (Throwable unused) {
        }
    }

    public void K(TaErrorCode taErrorCode, Bundle bundle) {
        try {
            AdCallback adCallback = this.f21586e;
            if (adCallback != null) {
                adCallback.u(taErrorCode, this, bundle);
            }
        } catch (Throwable unused) {
        }
    }

    public void M(TBannerView tBannerView) {
        Preconditions.a();
        this.f22915l = tBannerView;
        G();
        if (this.f22915l == null || this.f22913j == null) {
            if (this.f22915l == null) {
                J(TaErrorCode.ERROR_SHOW_VIEWGROUP_NULL);
            } else if (this.f22913j == null) {
                J(TaErrorCode.ERROR_SHOW_ADBEAN_NULL);
            }
            e4.b().d("TranBanner", "bannerView or mAdBean = null");
            return;
        }
        if (r() == 0 && !z()) {
            R();
        } else {
            J(TaErrorCode.ERROR_SHOW_INNER_INVALID);
            e4.b().d("TranBanner", "ad not condition to use");
        }
    }

    public void N(boolean z10) {
        this.f22917n = z10;
        E();
    }

    public void P() {
        ViewGroup viewGroup = this.f22915l;
        if (viewGroup instanceof TBannerView) {
            ((TBannerView) viewGroup).setCloseTypeUsedForTrack(null);
        }
        Q();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U() {
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.m();
            this.f21586e.k(this.f22913j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V() {
        f();
        F();
        k(true);
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.s();
        }
    }

    @Override // com.cloud.hisavana.sdk.G, com.cloud.hisavana.sdk.api.listener.f
    public void b(TaErrorCode taErrorCode, Bundle bundle) {
        if (!this.f22917n) {
            AdCallback adCallback = this.f21586e;
            if (adCallback != null) {
                adCallback.x(this, taErrorCode, bundle);
                return;
            }
            return;
        }
        WeakReference weakReference = this.f22918o;
        if (weakReference == null || ((TBannerView) weakReference.get()) == null) {
            return;
        }
        F();
    }

    @Override // com.cloud.hisavana.sdk.G, com.cloud.hisavana.sdk.api.listener.f
    public void d(List list, Bundle bundle) {
        AdsDTO adsDTO = this.f22913j;
        this.f22913j = (list == null || list.isEmpty()) ? null : (AdsDTO) list.get(0);
        if (!this.f22917n) {
            super.d(list, bundle);
            return;
        }
        this.f21587f = list;
        if (list == null || list.isEmpty()) {
            b(TaErrorCode.ERROR_AD_FETCHED_AD_IS_NULL, bundle);
            return;
        }
        WeakReference weakReference = this.f22918o;
        if (weakReference == null) {
            e4.b().d("TranBanner", "weakTBannerView is null ,not show");
            return;
        }
        TBannerView tBannerView = (TBannerView) weakReference.get();
        if (tBannerView == null) {
            e4.b().d("TranBanner", "tBannerView is null ,not show");
            return;
        }
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.D(this);
        }
        k(false);
        M(tBannerView);
        O(adsDTO);
    }

    @Override // com.cloud.hisavana.sdk.G
    public void m() {
        super.m();
        o oVar = this.f22912i;
        if (oVar != null) {
            oVar.c();
        }
        ViewGroup viewGroup = this.f22915l;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        com.cloud.hisavana.sdk.common.tranmeasure.e.c().g(this.f22913j);
        a aVar = this.f22914k;
        if (aVar != null) {
            aVar.removeMessages(1);
            this.f22914k = null;
        }
    }
}
