package com.transsion.shorttv.ad.playeroverlayad;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.shorttv.ad.common.STCommonNativeAdHelper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final String f52786a;

    /* renamed from: b, reason: collision with root package name */
    private final n0 f52787b;

    /* renamed from: c, reason: collision with root package name */
    private final STCommonNativeAdHelper f52788c;

    /* renamed from: d, reason: collision with root package name */
    private ShortTvPlayerOverlayAdContainer f52789d;

    /* renamed from: e, reason: collision with root package name */
    private e7.e f52790e;

    /* renamed from: f, reason: collision with root package name */
    private Long f52791f;

    /* renamed from: g, reason: collision with root package name */
    private long f52792g;

    /* loaded from: classes6.dex */
    public static final class a extends e7.e {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ ShortTvPlayerOverlayAdContainer f52794g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function0 f52795h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(ShortTvPlayerOverlayAdContainer shortTvPlayerOverlayAdContainer, Function0 function0, long j11) {
            super(j11, 1000L);
            this.f52794g = shortTvPlayerOverlayAdContainer;
            this.f52795h = function0;
        }

        @Override // e7.e
        public void e() {
            e.this.o(this.f52795h);
        }

        @Override // e7.e
        public void f(long j11) {
            long ceil = (float) Math.ceil(((float) j11) / 1000.0f);
            e.this.f52791f = Long.valueOf(ceil);
            TextView countdownView = this.f52794g.getCountdownView();
            if (countdownView != null) {
                countdownView.setText(ceil + "s");
            }
        }
    }

    public e(String sceneId, n0 lifecycleScope) {
        Intrinsics.h(sceneId, "sceneId");
        Intrinsics.h(lifecycleScope, "lifecycleScope");
        this.f52786a = sceneId;
        this.f52787b = lifecycleScope;
        STCommonNativeAdHelper sTCommonNativeAdHelper = new STCommonNativeAdHelper(sceneId, lifecycleScope);
        sTCommonNativeAdHelper.r("overlay");
        this.f52788c = sTCommonNativeAdHelper;
    }

    private final void g() {
        e7.e eVar = this.f52790e;
        if (eVar != null) {
            eVar.d();
        }
        this.f52790e = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(e eVar, Function0 function0, View view) {
        eVar.o(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(ShortTvPlayerOverlayAdContainer shortTvPlayerOverlayAdContainer, final e eVar) {
        NativeWrapperAdView nativeAdView = shortTvPlayerOverlayAdContainer.getNativeAdView();
        if (nativeAdView != null) {
            STCommonNativeAdHelper sTCommonNativeAdHelper = eVar.f52788c;
            Context a11 = com.cloud.sdk.commonutil.util.e.a();
            Intrinsics.g(a11, "getContext(...)");
            sTCommonNativeAdHelper.s(new f(a11), nativeAdView, new Function1() { // from class: com.transsion.shorttv.ad.playeroverlayad.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit n11;
                    n11 = e.n(e.this, ((Boolean) obj).booleanValue());
                    return n11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(e eVar, boolean z10) {
        if (z10) {
            eVar.f52792g = System.currentTimeMillis();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(Function0 function0) {
        f();
        function0.invoke();
    }

    public final void f() {
        STCommonNativeAdHelper.n(this.f52788c, 0, 1, null);
        g();
        this.f52791f = null;
        ShortTvPlayerOverlayAdContainer shortTvPlayerOverlayAdContainer = this.f52789d;
        if (shortTvPlayerOverlayAdContainer != null) {
            shortTvPlayerOverlayAdContainer.removeAdView();
        }
        ShortTvPlayerOverlayAdContainer shortTvPlayerOverlayAdContainer2 = this.f52789d;
        if (shortTvPlayerOverlayAdContainer2 != null) {
            shortTvPlayerOverlayAdContainer2.setVisibility(8);
        }
        this.f52789d = null;
        this.f52792g = 0L;
    }

    public final long h() {
        return this.f52792g;
    }

    public final void i(Function1 callback) {
        Intrinsics.h(callback, "callback");
        this.f52788c.q(callback);
    }

    public final void j() {
        g();
        ShortTvPlayerOverlayAdContainer shortTvPlayerOverlayAdContainer = this.f52789d;
        if (shortTvPlayerOverlayAdContainer != null) {
            shortTvPlayerOverlayAdContainer.removeAdView();
        }
        ShortTvPlayerOverlayAdContainer shortTvPlayerOverlayAdContainer2 = this.f52789d;
        if (shortTvPlayerOverlayAdContainer2 != null) {
            shortTvPlayerOverlayAdContainer2.setVisibility(8);
        }
    }

    public final void k(final ShortTvPlayerOverlayAdContainer adContainerView, final Function0 timerEndCallback) {
        Intrinsics.h(adContainerView, "adContainerView");
        Intrinsics.h(timerEndCallback, "timerEndCallback");
        adContainerView.setVisibility(0);
        adContainerView.bringToFront();
        ImageView closeView = adContainerView.getCloseView();
        if (closeView != null) {
            closeView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.ad.playeroverlayad.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.l(e.this, timerEndCallback, view);
                }
            });
        }
        adContainerView.addAdView();
        adContainerView.post(new Runnable() { // from class: com.transsion.shorttv.ad.playeroverlayad.c
            @Override // java.lang.Runnable
            public final void run() {
                e.m(ShortTvPlayerOverlayAdContainer.this, this);
            }
        });
        this.f52789d = adContainerView;
        g();
        Long l11 = this.f52791f;
        if (l11 == null) {
            l11 = Long.valueOf(com.transsion.ad.scene.a.f42255a.e("ShortTvPlayerOverlayScene"));
            if (l11.longValue() <= 0) {
                l11 = null;
            }
            if (l11 == null) {
                TextView countdownView = adContainerView.getCountdownView();
                if (countdownView != null) {
                    countdownView.setVisibility(8);
                    return;
                }
                return;
            }
        }
        long longValue = l11.longValue();
        TextView countdownView2 = adContainerView.getCountdownView();
        if (countdownView2 != null) {
            countdownView2.setVisibility(0);
        }
        a aVar = new a(adContainerView, timerEndCallback, longValue * 1000);
        this.f52790e = aVar;
        aVar.g();
    }
}
