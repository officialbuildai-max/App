package com.cloud.hisavana.sdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cloud.hisavana.sdk.api.listener.AdCallback;
import com.cloud.hisavana.sdk.api.view.AdBadgeView;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.AdDisclaimerView;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import com.cloud.hisavana.sdk.common.activity.HisavanaSplashActivity;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.VastData;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.widget.CountTimeView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.NativeBean;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.sdk.commonutil.util.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class i1 extends G {
    protected int A;
    private boolean B;
    private boolean C;
    private Float D;
    private final Runnable E;

    /* renamed from: i, reason: collision with root package name */
    private final String f22582i;

    /* renamed from: j, reason: collision with root package name */
    private CountTimeView f22583j;

    /* renamed from: k, reason: collision with root package name */
    private ViewGroup f22584k;

    /* renamed from: l, reason: collision with root package name */
    private View f22585l;

    /* renamed from: m, reason: collision with root package name */
    private u2 f22586m;

    /* renamed from: n, reason: collision with root package name */
    private Context f22587n;

    /* renamed from: o, reason: collision with root package name */
    protected volatile AdsDTO f22588o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f22589p;

    /* renamed from: q, reason: collision with root package name */
    private Handler f22590q;

    /* renamed from: r, reason: collision with root package name */
    private long f22591r;

    /* renamed from: s, reason: collision with root package name */
    private long f22592s;

    /* renamed from: t, reason: collision with root package name */
    private CopyOnWriteArrayList f22593t;

    /* renamed from: u, reason: collision with root package name */
    private AdChoicesView f22594u;

    /* renamed from: v, reason: collision with root package name */
    private LinearLayout f22595v;

    /* renamed from: w, reason: collision with root package name */
    private StoreMarkView f22596w;

    /* renamed from: x, reason: collision with root package name */
    private AdDisclaimerView f22597x;

    /* renamed from: y, reason: collision with root package name */
    private f7.d f22598y;

    /* renamed from: z, reason: collision with root package name */
    private PopupWindow f22599z;

    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e4.b().d("TranSplash", "closeAdRunnable all time is end");
            i1.this.B0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (i1.this.f22583j != null) {
                i1.this.f22583j.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            N0.k(com.cloud.sdk.commonutil.util.e.a(), i1.this.f22588o);
            if (i1.this.f22588o == null || i1.this.f22588o.isOfflineAd() || i1.this.f21586e == null) {
                return;
            }
            i1.this.f21586e.m();
            i1.this.f21586e.k(i1.this.f22588o);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements CountTimeView.b {
        d() {
        }

        @Override // com.cloud.hisavana.sdk.common.widget.CountTimeView.b
        public void onClick() {
            if (i1.this.f22583j != null) {
                i1.this.f22583j.cancel();
            }
            if (i1.this.f21586e != null) {
                i1.this.f21586e.B();
            }
            i1.this.D0();
            AthenaTracker.e0(i1.this.f22588o);
        }

        @Override // com.cloud.hisavana.sdk.common.widget.CountTimeView.b
        public void onFinish() {
            e4.b().d("TranSplash", "splash ad onTimeEnd");
            if (i1.this.f21586e != null) {
                i1.this.f21586e.C();
                i1.this.D0();
            }
        }

        @Override // com.cloud.hisavana.sdk.common.widget.CountTimeView.b
        public void onStart() {
        }
    }

    /* loaded from: classes3.dex */
    public class e extends f4 {
        public e(AdsDTO adsDTO) {
            super(adsDTO);
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void a(C1016p c1016p) {
            e4.b().d("TranSplash", "onPlayerError code=" + c1016p.a() + " msg=" + c1016p.b());
            super.a(c1016p);
            if (i1.this.f21586e != null) {
                i1.this.D0();
                i1.this.f21586e.t(i1.this.V(c1016p), i1.this);
            }
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void e() {
            super.e();
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void f(boolean z10) {
            super.f(z10);
            e4.b().d("TranSplash", "onCompanion");
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void onIsPlayingChanged(boolean z10) {
            e4.b().d("TranSplash", "onIsPlayingChanged isPLaying " + z10);
            super.onIsPlayingChanged(z10);
        }
    }

    public i1(q3 q3Var) {
        super(q3Var);
        this.f22586m = null;
        this.f22587n = null;
        this.f22591r = 10000L;
        this.f22593t = new CopyOnWriteArrayList();
        this.B = false;
        this.C = false;
        this.E = new a();
        this.f22582i = DeviceUtil.o();
    }

    private void A0() {
        VastData videoInfo;
        Integer duration;
        if (this.f22584k == null || this.f22587n == null) {
            return;
        }
        this.f22583j = new CountTimeView(this.f22587n);
        Integer showTime = this.f22588o.getShowTime();
        if (this.f22588o.isVastTypeAd() && (videoInfo = this.f22588o.getVideoInfo()) != null && (duration = videoInfo.getDuration()) != null && duration.intValue() > 1 && duration.intValue() <= 5) {
            showTime = Integer.valueOf(duration.intValue() - 1);
        }
        this.f22583j.setStartTime(showTime.intValue());
        this.f22583j.setCountDownTimerListener(new d());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.f22583j.getLayoutDirection() == 0) {
            layoutParams.setMarginEnd(this.f22587n.getResources().getDimensionPixelOffset(R$dimen.ad_mark_margin_start));
        } else {
            layoutParams.setMarginStart(this.f22587n.getResources().getDimensionPixelOffset(R$dimen.ad_mark_margin_start));
        }
        layoutParams.topMargin = this.f22587n.getResources().getDimensionPixelOffset(R$dimen.ad_mark_margin_top);
        int dimensionPixelSize = this.f22587n.getResources().getDimensionPixelSize(R$dimen.ad_skip_view_width);
        int dimensionPixelOffset = this.f22587n.getResources().getDimensionPixelOffset(R$dimen.ad_skip_view_height);
        layoutParams.width = dimensionPixelSize;
        layoutParams.height = dimensionPixelOffset;
        layoutParams.addRule(21);
        ViewGroup viewGroup = this.f22584k;
        if (viewGroup != null) {
            viewGroup.addView(this.f22583j, layoutParams);
        }
        this.f22583j.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        if (this.C) {
            return;
        }
        try {
            com.cloud.sdk.commonutil.util.k.a(this.f22594u);
            u2 u2Var = this.f22586m;
            if (u2Var != null) {
                u2Var.b();
            }
            CountTimeView countTimeView = this.f22583j;
            if (countTimeView != null) {
                countTimeView.cancel();
                this.f22583j.setCountDownTimerListener(null);
                this.f22583j = null;
            }
            ViewGroup viewGroup = this.f22584k;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
            this.f22584k = null;
            this.f22594u = null;
            this.f22597x = null;
            LinearLayout linearLayout = this.f22595v;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            this.f22595v = null;
            StoreMarkView storeMarkView = this.f22596w;
            if (storeMarkView != null) {
                storeMarkView.removeAllViews();
            }
            this.f22596w = null;
            View view = this.f22585l;
            if (view != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f22585l.getParent()).removeView(this.f22585l);
            }
            this.f22585l = null;
            S();
            e4.b().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "TranSplash，destroy");
            D0();
            f7.d dVar = this.f22598y;
            if (dVar != null) {
                dVar.f();
                this.f22598y = null;
            }
            PopupWindow popupWindow = this.f22599z;
            if (popupWindow != null) {
                popupWindow.dismiss();
                this.f22599z = null;
            }
            this.f22587n = null;
            this.C = true;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TaErrorCode V(C1016p c1016p) {
        switch (c1016p.a()) {
            case TaErrorCode.CODE_SHOW_VIDEO_PLAYER_IO_ERROR /* 6025 */:
                return TaErrorCode.ERROR_SHOW_VIDEO_PLAYER_IO_ERROR;
            case TaErrorCode.CODE_SHOW_VIDEO_PLAYER_DECODE_ERROR /* 6026 */:
                return TaErrorCode.ERROR_SHOW_VIDEO_PLAYER_DECODE_ERROR;
            case TaErrorCode.CODE_SHOW_VIDEO_PLAYER_DRM_ERROR /* 6027 */:
                return TaErrorCode.ERROR_SHOW_VIDEO_PLAYER_DRM_ERROR;
            case TaErrorCode.CODE_SHOW_VIDEO_PLAYER_UNKNOWN_ERROR /* 6028 */:
            default:
                return TaErrorCode.ERROR_SHOW_VIDEO_PLAYER_UNKNOWN_ERROR;
            case TaErrorCode.CODE_SHOW_VIDEO_PLAYER_UNAVAILABLE /* 6029 */:
                return TaErrorCode.ERROR_SHOW_VIDEO_PLAYER_UNAVAILABLE;
        }
    }

    private void X(long j11) {
        this.f22592s = System.currentTimeMillis();
        if (this.f22590q == null) {
            this.f22590q = new Handler(Looper.getMainLooper());
        }
        this.f22590q.postDelayed(this.E, j11);
        e4.b().d("TranSplash", "closeAdDelay " + j11);
    }

    private void Y(Context context) {
        this.f22586m = new u2(this);
        this.f22587n = context;
    }

    private void Z(View view) {
        if (this.f22584k == null) {
            e0(TaErrorCode.ERROR_SHOW_VIEWGROUP_NULL);
            e4.b().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "bg view is null");
            return;
        }
        if (this.f22588o == null) {
            e0(TaErrorCode.ERROR_SHOW_ADBEAN_NULL);
            e4.b().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "ad data is null");
            return;
        }
        e4.b().d("TranSplash", "fillSplash renderView " + view);
        this.f22588o.setMaterialStyle("K01");
        this.f22584k.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        b0(null);
        y0();
    }

    private void a0(View view, String str) {
        if (this.f22584k == null) {
            e0(TaErrorCode.ERROR_SHOW_VIEWGROUP_NULL);
            e4.b().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "bg view is null");
            return;
        }
        if (this.f22588o == null) {
            e0(TaErrorCode.ERROR_SHOW_ADBEAN_NULL);
            e4.b().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "ad data is null");
            return;
        }
        e4.b().d("TranSplash", "fillSplash renderView " + view);
        try {
            this.f22588o.setMaterialStyle("K02");
            View inflate = LayoutInflater.from(this.f22584k.getContext()).inflate(R$layout.splash_style_k02_layout, this.f22584k, false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f22587n.getResources().getDimensionPixelOffset(R$dimen.hisavana_ad_dimen_180), this.f22587n.getResources().getDimensionPixelOffset(R$dimen.hisavana_ad_dimen_400));
            ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R$id.iv_main_image);
            viewGroup.addView(view, layoutParams);
            b0(viewGroup);
            NativeBean nativeObject = this.f22588o.getNativeObject();
            ImageView imageView = (ImageView) inflate.findViewById(R$id.ivIcon);
            if (this.f22588o.getSource() == 4) {
                DownLoadRequest.n(this.f22588o.getLogoUrl(), this.f22588o, null, imageView);
            } else if (nativeObject != null) {
                DownLoadRequest.o(nativeObject.getLogoUrl(), this.f22588o, 1, null, imageView);
            }
            TextView textView = (TextView) inflate.findViewById(R$id.tvName);
            TextView textView2 = (TextView) inflate.findViewById(R$id.tvDescription);
            TextView textView3 = (TextView) inflate.findViewById(R$id.tvBtn);
            if (nativeObject != null) {
                textView.setText(nativeObject.getTitleTxt());
                textView2.setText(str + " · " + nativeObject.getDescriptionTxt());
                textView3.setText(nativeObject.getButtonTxt(this.f22588o.getInstallApk()));
            }
            if (com.cloud.hisavana.sdk.common.util.i0.a(this.f22588o)) {
                StoreMarkView storeMarkView = (StoreMarkView) inflate.findViewById(R$id.ps_mark_view);
                this.f22596w = storeMarkView;
                if (storeMarkView != null) {
                    storeMarkView.setVisibility(0);
                    this.f22596w.setTextSize(8.0f);
                    this.f22596w.setTextColor(-8882056);
                    this.f22596w.attachInfo(this.f22588o);
                }
            }
            this.f22584k.addView(inflate);
        } catch (Throwable unused) {
        }
    }

    private void b0(ViewGroup viewGroup) {
        if (this.f22588o == null || this.f22584k == null || this.f22587n == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.f22584k.getLayoutDirection() == 0) {
            layoutParams.setMarginEnd(this.f22587n.getResources().getDimensionPixelOffset(R$dimen.dimens_16));
        } else {
            layoutParams.setMarginStart(this.f22587n.getResources().getDimensionPixelOffset(R$dimen.dimens_16));
        }
        if (this.f22585l == null) {
            layoutParams.bottomMargin = this.f22587n.getResources().getDimensionPixelOffset(R$dimen.dimens_82);
        } else {
            layoutParams.bottomMargin = this.f22587n.getResources().getDimensionPixelOffset(R$dimen.dimens_48);
        }
        layoutParams.addRule(12);
        layoutParams.addRule(21);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.f22587n).inflate(R$layout.hs_include_ad_flag, this.f22584k, false);
        this.f22595v = linearLayout;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setId(View.generateViewId());
        this.f22594u = (AdChoicesView) this.f22595v.findViewById(R$id.ad_choices_view);
        AdBadgeView adBadgeView = (AdBadgeView) this.f22595v.findViewById(R$id.ad_badge_view);
        AdCloseView adCloseView = (AdCloseView) this.f22595v.findViewById(R$id.ad_close_view);
        d0(this.f22594u);
        if (adBadgeView != null) {
            adBadgeView.setDisplayStyle(this.f22588o.getDisplayRule(), com.cloud.hisavana.sdk.common.util.f0.c(this.f22588o));
        }
        if (adCloseView != null) {
            adCloseView.setDisplayStyle(this.f22588o.getDisplayRule(), AdCloseView.CloseImageType.EXPAND);
            t2.p().f(this.f22587n, adCloseView, this, this.f22588o);
        }
        if (viewGroup == null) {
            this.f22584k.addView(this.f22595v, layoutParams);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(12);
        layoutParams2.addRule(20);
        this.f22595v.setLayoutParams(layoutParams2);
        viewGroup.addView(this.f22595v);
    }

    private void d0(AdChoicesView adChoicesView) {
        if (adChoicesView == null) {
            return;
        }
        if (this.f22588o != null) {
            this.f22588o.setACReady(Boolean.TRUE);
        }
        if (this.f22588o.getSource() == 4) {
            DownLoadRequest.n(this.f22588o.getAdChoiceImageUrl(), this.f22588o, null, adChoicesView);
        } else {
            DownLoadRequest.o(this.f22588o.getAdChoiceImageUrl(), this.f22588o, 3, null, adChoicesView);
        }
        adChoicesView.setOnClickListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(String str, String str2, String str3) {
        f7.d i11 = new f7.d(this.f22584k).j(str).h(str2).i(str3, null);
        this.f22598y = i11;
        i11.k();
    }

    private void x0() {
        ViewParent parent;
        int i11;
        if (this.f22584k == null || this.f22585l == null || this.f22588o.isInteractiveAd() || (parent = this.f22584k.getParent()) == null) {
            return;
        }
        int j11 = i7.c.j();
        if (j11 > 0) {
            Float f11 = this.D;
            float floatValue = f11 != null ? f11.floatValue() : 0.14f;
            e4.b().i("TranSplash", "ssp sdk addLogoLayout heightRatio = " + floatValue);
            i11 = (int) (((float) j11) * floatValue);
        } else {
            i11 = 0;
        }
        if (i11 == 0) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, 0, 0, i11);
        this.f22584k.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, i11);
        layoutParams2.addRule(12);
        if (this.f22585l.getParent() != null) {
            ((ViewGroup) this.f22585l.getParent()).removeView(this.f22585l);
        }
        ((ViewGroup) parent).addView(this.f22585l, layoutParams2);
    }

    private void y0() {
        if (this.f22584k == null || !com.cloud.hisavana.sdk.common.util.i0.a(this.f22588o) || this.f22588o == null) {
            return;
        }
        StoreMarkView storeMarkView = new StoreMarkView(this.f22587n);
        this.f22596w = storeMarkView;
        storeMarkView.setTextSize(8.0f);
        this.f22596w.setTextColor(-1);
        this.f22596w.setVisibility(0);
        this.f22596w.attachInfo(this.f22588o);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.f22587n.getResources().getDimensionPixelOffset(R$dimen.dimens_16);
        layoutParams.addRule(20);
        LinearLayout linearLayout = this.f22595v;
        if (linearLayout == null || linearLayout.getParent() == null) {
            layoutParams.addRule(12);
        } else {
            layoutParams.addRule(8, this.f22595v.getId());
        }
        this.f22584k.addView(this.f22596w, layoutParams);
    }

    private void z0() {
        if (this.f22588o == null || this.f22588o.getDisplayRule() != Constants.AdDisplayRule.RU || this.f22584k == null || this.f22587n == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f22587n.getResources().getDimensionPixelOffset(R$dimen.ad_disclaimer_height));
        layoutParams.addRule(12);
        AdDisclaimerView adDisclaimerView = new AdDisclaimerView(this.f22587n);
        this.f22584k.addView(adDisclaimerView, layoutParams);
        adDisclaimerView.setDisplayStyle(this.f22588o.getDisplayRule(), com.cloud.hisavana.sdk.common.util.f0.f(this.f22588o));
        adDisclaimerView.updateHeightWith(com.cloud.hisavana.sdk.common.util.f0.e(this.f22588o), this.f22584k.getHeight());
        adDisclaimerView.setListener(new AdDisclaimerView.b() { // from class: com.cloud.hisavana.sdk.a4
            @Override // com.cloud.hisavana.sdk.api.view.AdDisclaimerView.b
            public final void a(String str, String str2, String str3) {
                i1.this.h0(str, str2, str3);
            }
        });
        this.f22597x = adDisclaimerView;
    }

    public void B0() {
        e4.b().d("TranSplash", "splash ad close");
        S();
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.p(this.f22588o);
        }
        D0();
    }

    public void C0() {
        X(this.f22591r);
    }

    public void D0() {
        e4.b().d("TranSplash", "closeSplashPage");
        Context context = this.f22587n;
        if (context instanceof HisavanaSplashActivity) {
            if (((HisavanaSplashActivity) context).isFinishing() || ((HisavanaSplashActivity) this.f22587n).isDestroyed()) {
                e4.b().d("TranSplash", "closeSplashPage activity is finishing or destroyed");
            } else {
                ((HisavanaSplashActivity) this.f22587n).finish();
            }
        }
        r4.b().d(this.f22582i);
    }

    public Context H() {
        return this.f22587n;
    }

    public void I() {
        u2 u2Var = this.f22586m;
        if (u2Var != null) {
            u2Var.z(this.f22588o);
        }
    }

    public CountTimeView J() {
        return this.f22583j;
    }

    public ViewGroup K() {
        return this.f22584k;
    }

    public boolean L() {
        if (this.f22588o != null) {
            return this.f22588o.isJumpToHalfscreen();
        }
        return false;
    }

    public boolean M() {
        return this.f22589p;
    }

    public void O() {
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.m();
            this.f21586e.k(this.f22588o);
        }
    }

    public void P() {
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.p(this.f22588o);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q() {
        f();
        k(true);
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.s();
        }
    }

    public void R() {
        u2 u2Var = this.f22586m;
        if (u2Var != null) {
            u2Var.D(this.f22588o);
        }
    }

    public void S() {
        this.f22591r -= System.currentTimeMillis() - this.f22592s;
        e4.b().d("TranSplash", "removeCloseMsg remainForceCloseAdTime " + this.f22591r);
        if (this.f22591r <= 0) {
            this.f22591r = 10000L;
        }
        Handler handler = this.f22590q;
        if (handler != null) {
            handler.removeCallbacks(this.E);
        }
    }

    public AdsDTO T() {
        return this.f22588o;
    }

    public void c0(PopupWindow popupWindow) {
        this.f22599z = popupWindow;
    }

    @Override // com.cloud.hisavana.sdk.G, com.cloud.hisavana.sdk.api.listener.f
    public void d(List list, Bundle bundle) {
        this.f22588o = (list == null || list.isEmpty()) ? null : (AdsDTO) list.get(0);
        super.d(list, bundle);
    }

    public void e0(TaErrorCode taErrorCode) {
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.t(taErrorCode, this);
        }
    }

    public void f0(TaErrorCode taErrorCode, Bundle bundle) {
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.u(taErrorCode, this, bundle);
        }
    }

    public void g0(Float f11) {
        if (f11 == null) {
            return;
        }
        if (f11.floatValue() < 0.1f || f11.floatValue() > 0.2f) {
            this.D = Float.valueOf(0.2f);
        } else {
            this.D = f11;
        }
    }

    public void j0(Context context) {
        Preconditions.a();
        Y(context);
        if (this.f22587n == null || this.f22588o == null) {
            e4.b().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "contex is null or mAdBean is null");
            D0();
            e0(TaErrorCode.ERROR_SHOW_ADBEAN_NULL);
            return;
        }
        this.A = com.cloud.hisavana.sdk.common.util.b.f22230a.b(this.f22588o);
        if (this.f22586m == null) {
            this.f22586m = new u2(this);
        }
        this.f22586m.k(new e(this.f22588o));
        this.f22586m.c(this.A);
        if (r() == 0 && !z()) {
            this.f22586m.A(this.f22588o);
            X(10000L);
        } else {
            e4.b().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "Ad is not ready");
            D0();
            e0(TaErrorCode.ERROR_SHOW_INNER_INVALID);
        }
    }

    public void k0(View view) {
        this.f22585l = view;
    }

    public void l0(ViewGroup viewGroup) {
        this.f22584k = viewGroup;
    }

    @Override // com.cloud.hisavana.sdk.G
    public void m() {
        super.m();
        try {
            HSScopeHelper.f23249a.h(new Runnable() { // from class: com.cloud.hisavana.sdk.b4
                @Override // java.lang.Runnable
                public final void run() {
                    i1.this.N();
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m0(boolean z10) {
        e4.b().d("TranSplash", "fillSplash");
        if (this.f22584k == null) {
            e0(TaErrorCode.ERROR_SHOW_VIEWGROUP_NULL);
            e4.b().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "bg view is null");
            return;
        }
        x0();
        u2 u2Var = this.f22586m;
        View B = u2Var != null ? u2Var.B(this.f22588o) : null;
        if (B == null) {
            e0(TaErrorCode.ERROR_SHOW_SPLASH_VIEW_NULL);
            e4.b().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "Splash view is null");
            return;
        }
        if (B.getParent() != null) {
            ((ViewGroup) B.getParent()).removeView(B);
        }
        String k11 = com.cloud.hisavana.sdk.common.util.r.f22275a.k(this.f22588o);
        if (TextUtils.isEmpty(k11)) {
            Z(B);
        } else {
            a0(B, k11);
        }
        z0();
        A0();
        this.f22584k.postDelayed(new b(), 1000L);
        if (z10) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f22597x);
            arrayList.add(this.f22595v);
            arrayList.add(this.f22596w);
            arrayList.add(this.f22583j);
            m0.a(v(), this.f22588o, this.f22584k, arrayList);
        }
    }

    public void o0(Context context) {
        Preconditions.a();
        Y(context);
        if (this.f22587n == null || this.f22588o == null) {
            e4.b().d(com.cloud.sdk.commonutil.util.c.SPLASH_TAG, "contex is null or mAdBean is null");
            D0();
            e0(TaErrorCode.ERROR_SHOW_ADBEAN_NULL);
        } else if (r() != 0 || z()) {
            D0();
            e0(TaErrorCode.ERROR_SHOW_INNER_INVALID);
        } else {
            r4.b().c(this.f22582i, this);
            HisavanaSplashActivity.T(this.f22587n, this.f22582i, this.B);
        }
    }

    public void p0(boolean z10) {
        this.B = z10;
    }
}
