package com.cloud.hisavana.sdk.api.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.C1016p;
import com.cloud.hisavana.sdk.N0;
import com.cloud.hisavana.sdk.api.view.MediaView;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.widget.InteractiveFrameLayout;
import com.cloud.hisavana.sdk.common.widget.InteractiveWebView;
import com.cloud.hisavana.sdk.common.widget.TAdWebView;
import com.cloud.hisavana.sdk.common.widget.video.NativeAdVideoView;
import com.cloud.hisavana.sdk.data.bean.request.AdxImpBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.f4;
import com.cloud.hisavana.sdk.u3;
import com.cloud.hisavana.sdk.z3;
import com.cloud.sdk.commonutil.R$id;
import com.cloud.sdk.commonutil.util.k;
import com.cloud.sdk.commonutil.widget.TranCircleImageView;
import com.vungle.ads.internal.model.AdPayload;

/* loaded from: classes3.dex */
public class MediaView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private TranCircleImageView f21698a;

    /* renamed from: b, reason: collision with root package name */
    private AdImage f21699b;

    /* renamed from: c, reason: collision with root package name */
    private NativeAdVideoView f21700c;

    /* renamed from: d, reason: collision with root package name */
    private TAdWebView f21701d;

    /* renamed from: e, reason: collision with root package name */
    private InteractiveFrameLayout f21702e;

    /* renamed from: f, reason: collision with root package name */
    private InteractiveWebView f21703f;

    /* renamed from: g, reason: collision with root package name */
    private int f21704g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f21705h;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f21706i;

    /* renamed from: j, reason: collision with root package name */
    private float f21707j;

    /* renamed from: k, reason: collision with root package name */
    private float f21708k;

    /* renamed from: l, reason: collision with root package name */
    private float f21709l;

    /* renamed from: m, reason: collision with root package name */
    private float f21710m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements InteractiveWebView.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdsDTO f21711a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ z3 f21712b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ TaNativeInfo f21713c;

        a(AdsDTO adsDTO, z3 z3Var, TaNativeInfo taNativeInfo) {
            this.f21711a = adsDTO;
            this.f21712b = z3Var;
            this.f21713c = taNativeInfo;
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.c
        public void a(String str) {
            AthenaTracker.y(this.f21711a, str);
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.c
        public void b() {
            if (MediaView.this.f21703f != null) {
                z3 z3Var = this.f21712b;
                u3 u3Var = z3Var instanceof u3 ? (u3) z3Var : null;
                N0.b(MediaView.this.f21703f.getContext(), this.f21711a, new DownUpPointBean(MediaView.this.f21707j, MediaView.this.f21708k, MediaView.this.f21709l, MediaView.this.f21710m, MediaView.this.f21703f.getMeasuredHeight(), MediaView.this.f21703f.getMeasuredWidth()), u3Var != null && u3Var.p().v());
                AthenaTracker.W(this.f21711a);
                if (u3Var == null || u3Var.Z() == null) {
                    return;
                }
                u3Var.Z().y(this.f21713c);
            }
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.c
        public void c() {
        }
    }

    /* loaded from: classes3.dex */
    public class b extends f4 {
        public b(AdsDTO adsDTO) {
            super(adsDTO);
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void a(C1016p c1016p) {
            super.a(c1016p);
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void b() {
            super.b();
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void c(long j11, long j12, int i11) {
            super.c(j11, j12, i11);
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void e() {
            super.e();
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void onComplete() {
            super.onComplete();
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void onIsPlayingChanged(boolean z10) {
            super.onIsPlayingChanged(z10);
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void onVideoSizeChanged(int i11, int i12) {
            super.onVideoSizeChanged(i11, i12);
        }

        @Override // com.cloud.hisavana.sdk.f4, com.cloud.hisavana.sdk.q4
        public void onVolumeChanged(float f11) {
            super.onVolumeChanged(f11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c implements View.OnTouchListener {
        private c() {
        }

        /* synthetic */ c(MediaView mediaView, a aVar) {
            this();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                MediaView.this.f21707j = motionEvent.getX();
                MediaView.this.f21708k = motionEvent.getY();
                return false;
            }
            if (action != 1) {
                return false;
            }
            MediaView.this.f21709l = motionEvent.getX();
            MediaView.this.f21710m = motionEvent.getY();
            return false;
        }
    }

    public MediaView(@NonNull Context context) {
        this(context, null);
    }

    public MediaView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f21698a = null;
        this.f21699b = null;
        this.f21701d = null;
        this.f21706i = false;
        this.f21710m = -1.0f;
    }

    private FrameLayout.LayoutParams d(int i11, int i12) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i11, i12);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    private void f(TaNativeInfo taNativeInfo, String str) {
        if (taNativeInfo == null) {
            return;
        }
        AdsDTO adItem = taNativeInfo.getAdItem();
        z3 nativeBridge = taNativeInfo.getNativeBridge();
        if (this.f21702e == null) {
            this.f21702e = new InteractiveFrameLayout(getContext());
        }
        this.f21702e.setScale(str);
        if (indexOfChild(this.f21702e) < 0) {
            addView(this.f21702e, d(-1, -1));
        }
        if (this.f21703f == null) {
            InteractiveWebView interactiveWebView = new InteractiveWebView(getContext());
            this.f21703f = interactiveWebView;
            interactiveWebView.setWebClientCallback(adItem);
            this.f21703f.setOnTouchListener(new c(this, null));
            this.f21703f.setInteractiveListener(new a(adItem, nativeBridge, taNativeInfo));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(final InteractiveWebView interactiveWebView, InteractiveFrameLayout interactiveFrameLayout, final String str, int i11, int i12) {
        try {
            ViewParent parent = interactiveWebView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(interactiveWebView);
            }
            interactiveFrameLayout.addView(interactiveWebView, new FrameLayout.LayoutParams(i11, i12));
            this.f21703f.measure(View.MeasureSpec.makeMeasureSpec(i11, 1073741824), View.MeasureSpec.makeMeasureSpec(i12, 1073741824));
            this.f21703f.layout(0, 0, i11, i12);
            interactiveWebView.post(new Runnable() { // from class: c7.c
                @Override // java.lang.Runnable
                public final void run() {
                    MediaView.this.h(interactiveWebView, str);
                }
            });
        } catch (Throwable th2) {
            e4.b().w("MediaView", "setInteractiveView error: " + th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(InteractiveWebView interactiveWebView, String str) {
        if (this.f21706i || interactiveWebView.getParent() == null) {
            return;
        }
        interactiveWebView.loadUrl(AdPayload.FILE_SCHEME + str);
    }

    private void i(AdsDTO adsDTO, boolean z10) {
        if (this.f21700c == null) {
            NativeAdVideoView nativeAdVideoView = new NativeAdVideoView(getContext());
            this.f21700c = nativeAdVideoView;
            nativeAdVideoView.setAdMediaPlayerListener(new b(adsDTO));
        }
        this.f21700c.setUseListMode(z10);
        if (indexOfChild(this.f21700c) < 0) {
            addView(this.f21700c, d(-1, -2));
        }
        TranCircleImageView tranCircleImageView = this.f21698a;
        if (tranCircleImageView == null || !(tranCircleImageView.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) this.f21698a.getParent()).removeView(this.f21698a);
        this.f21698a = null;
    }

    private void l() {
        if (this.f21698a == null) {
            TranCircleImageView tranCircleImageView = new TranCircleImageView(getContext());
            this.f21698a = tranCircleImageView;
            tranCircleImageView.setId(R$id.native_mediaview_iv_id);
        }
        if (indexOfChild(this.f21698a) < 0) {
            addView(this.f21698a, d(-1, -2));
        }
        if (this.f21704g == 2 && this.f21698a.getLayoutParams() != null) {
            this.f21698a.getLayoutParams().height = -2;
        }
        NativeAdVideoView nativeAdVideoView = this.f21700c;
        if (nativeAdVideoView == null || !(nativeAdVideoView.getParent() instanceof ViewGroup)) {
            return;
        }
        this.f21700c.release();
        ((ViewGroup) this.f21700c.getParent()).removeView(this.f21700c);
        this.f21700c = null;
    }

    public void destroy() {
        this.f21706i = true;
        TAdWebView tAdWebView = this.f21701d;
        if (tAdWebView != null) {
            ViewParent parent = tAdWebView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f21701d);
            }
            this.f21701d.stopLoading();
            this.f21701d.getSettings().setJavaScriptEnabled(false);
            this.f21701d.setWebViewClient(null);
            this.f21701d.setWebChromeClient(null);
            this.f21701d.clearHistory();
            this.f21701d.removeAllViews();
            this.f21701d.destroy();
            this.f21701d = null;
        }
        InteractiveWebView interactiveWebView = this.f21703f;
        if (interactiveWebView != null) {
            interactiveWebView.destroy();
            this.f21703f = null;
        }
        NativeAdVideoView nativeAdVideoView = this.f21700c;
        if (nativeAdVideoView != null) {
            nativeAdVideoView.release();
            this.f21700c = null;
        }
        k.a(this.f21698a);
        AdImage adImage = this.f21699b;
        if (adImage != null) {
            adImage.destroy();
        }
        removeAllViews();
    }

    public void init(int i11) {
        this.f21704g = i11;
        if (i11 != 3) {
            l();
        }
    }

    public boolean isAttached() {
        return this.f21705h;
    }

    public void pause() {
        NativeAdVideoView nativeAdVideoView = this.f21700c;
        if (nativeAdVideoView != null) {
            nativeAdVideoView.pause();
        }
    }

    public void play() {
        NativeAdVideoView nativeAdVideoView = this.f21700c;
        if (nativeAdVideoView != null) {
            nativeAdVideoView.play();
        }
    }

    public void setInteractiveView(TaNativeInfo taNativeInfo, final String str, String str2) {
        f(taNativeInfo, str2);
        final InteractiveFrameLayout interactiveFrameLayout = this.f21702e;
        final InteractiveWebView interactiveWebView = this.f21703f;
        if (interactiveFrameLayout == null || interactiveWebView == null) {
            return;
        }
        interactiveFrameLayout.registerGlobalLayoutListener(new InteractiveFrameLayout.a() { // from class: c7.b
            @Override // com.cloud.hisavana.sdk.common.widget.InteractiveFrameLayout.a
            public final void a(int i11, int i12) {
                MediaView.this.g(interactiveWebView, interactiveFrameLayout, str, i11, i12);
            }
        });
    }

    public void setMediaView(AdImage adImage, ImageView.ScaleType scaleType, boolean z10) {
        l();
        TranCircleImageView tranCircleImageView = this.f21698a;
        if (tranCircleImageView == null || scaleType == null) {
            return;
        }
        if (z10) {
            tranCircleImageView.setAdjustViewBounds(true);
            this.f21698a.setMaxWidth(i7.c.k());
            this.f21698a.setMaxHeight(i7.c.j());
        } else {
            tranCircleImageView.setAdjustViewBounds(true);
            this.f21698a.setScaleType(scaleType);
        }
        if (adImage != null) {
            this.f21699b = adImage;
            this.f21705h = adImage.attachView(this.f21698a);
        }
    }

    public void setRadius(float f11, float f12, float f13, float f14) {
        TranCircleImageView tranCircleImageView = this.f21698a;
        if (tranCircleImageView != null) {
            tranCircleImageView.setTopLeftRadius(f11);
            this.f21698a.setTopRightRadius(f12);
            this.f21698a.setBottomLeftRadius(f13);
            this.f21698a.setBottomRightRadius(f14);
            this.f21698a.setCircle((f11 == 0.0f && f12 == 0.0f && f13 == 0.0f && f14 == 0.0f) ? false : true);
            this.f21698a.invalidate();
        }
    }

    public void setVideoView(String str, boolean z10, String str2, AdsDTO adsDTO, boolean z11) {
        i(adsDTO, z11);
        if (TextUtils.isEmpty(str) || this.f21700c == null || adsDTO == null) {
            e4.b().e("MediaView", "setVideoView filePath is null or adVideoView is null or adsDTO is null");
            return;
        }
        AdxImpBean impBeanRequest = adsDTO.getImpBeanRequest();
        if (impBeanRequest != null) {
            e4.b().d("MediaView", "init impBean.isAutoPlayVideoAd " + impBeanRequest.isAutoPlayVideoAd);
            this.f21700c.setPlayWhenReady(impBeanRequest.isAutoPlayVideoAd);
        }
        e4.b().d("MediaView", "isMaterialStyleValid---->" + z10 + "   materialStyle---->" + str2);
        this.f21700c.setShowComponents(true);
        this.f21700c.setAutoReset(true);
        if (adsDTO.getVideoInfo() != null && adsDTO.getVideoInfo().getVideoMask() != null) {
            this.f21700c.setCompanionSize(adsDTO.getVideoInfo().getVideoMask().getResource());
        }
        this.f21700c.setMediaData(str, adsDTO, str.startsWith("http"));
    }
}
