package com.transsion.wrapperad.view;

import android.content.Context;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import androidx.view.LifecycleCoroutineScope;
import androidx.view.v;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;

/* loaded from: classes7.dex */
public final class NativeSlideshowView$loadTopAd$1 extends di.a {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ NativeSlideshowView f58405d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeSlideshowView$loadTopAd$1(NativeSlideshowView nativeSlideshowView) {
        this.f58405d = nativeSlideshowView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(NativeSlideshowView nativeSlideshowView) {
        NativeWrapperAdView nativeWrapperAdView;
        NativeWrapperAdView nativeWrapperAdView2;
        BiddingNativeManager biddingNativeManager;
        nativeWrapperAdView = nativeSlideshowView.vTop;
        if (nativeWrapperAdView != null) {
            nativeWrapperAdView.setVisibility(0);
        }
        nativeWrapperAdView2 = nativeSlideshowView.vBottom;
        if (nativeWrapperAdView2 != null) {
            nativeWrapperAdView2.setVisibility(8);
        }
        biddingNativeManager = nativeSlideshowView.bottomNative;
        if (biddingNativeManager != null) {
            biddingNativeManager.V();
        }
        nativeSlideshowView.bottomNative = null;
    }

    @Override // di.a
    public void i(TAdErrorCode tAdErrorCode) {
        super.i(tAdErrorCode);
        this.f58405d.i(true);
    }

    @Override // di.a
    public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        Handler handler;
        LifecycleCoroutineScope a11;
        super.j(biddingIntermediateMaterialBean);
        Context context = this.f58405d.getContext();
        if (context != null) {
            NativeSlideshowView nativeSlideshowView = this.f58405d;
            Context context2 = nativeSlideshowView.getContext();
            AppCompatActivity appCompatActivity = context2 instanceof AppCompatActivity ? (AppCompatActivity) context2 : null;
            if (appCompatActivity != null && (a11 = v.a(appCompatActivity)) != null) {
                kotlinx.coroutines.k.d(a11, null, null, new NativeSlideshowView$loadTopAd$1$onBiddingLoad$1$1(context, nativeSlideshowView, biddingIntermediateMaterialBean, null), 3, null);
            }
        }
        handler = this.f58405d.mHandler;
        final NativeSlideshowView nativeSlideshowView2 = this.f58405d;
        handler.postDelayed(new Runnable() { // from class: com.transsion.wrapperad.view.n
            @Override // java.lang.Runnable
            public final void run() {
                NativeSlideshowView$loadTopAd$1.y(NativeSlideshowView.this);
            }
        }, 300L);
        NativeSlideshowView.j(this.f58405d, false, 1, null);
    }
}
