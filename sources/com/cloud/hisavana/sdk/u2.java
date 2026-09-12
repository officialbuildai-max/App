package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.widget.CountTimeView;
import com.cloud.hisavana.sdk.common.widget.InteractiveWebView;
import com.cloud.hisavana.sdk.common.widget.video.SplashAdVideoView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.transsion.push.PushConstants;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class u2 {

    /* renamed from: a, reason: collision with root package name */
    private View f23074a;

    /* renamed from: b, reason: collision with root package name */
    private SplashAdVideoView f23075b;

    /* renamed from: c, reason: collision with root package name */
    private long f23076c;

    /* renamed from: d, reason: collision with root package name */
    private final i1 f23077d;

    /* renamed from: f, reason: collision with root package name */
    private InteractiveWebView f23079f;

    /* renamed from: m, reason: collision with root package name */
    private q4 f23086m;

    /* renamed from: n, reason: collision with root package name */
    private int f23087n;

    /* renamed from: e, reason: collision with root package name */
    private String f23078e = null;

    /* renamed from: g, reason: collision with root package name */
    private float f23080g = -1.0f;

    /* renamed from: h, reason: collision with root package name */
    private float f23081h = -1.0f;

    /* renamed from: i, reason: collision with root package name */
    private float f23082i = -1.0f;

    /* renamed from: j, reason: collision with root package name */
    private float f23083j = -1.0f;

    /* renamed from: k, reason: collision with root package name */
    private boolean f23084k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f23085l = false;

    /* renamed from: o, reason: collision with root package name */
    private final e f23088o = new e(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements InteractiveWebView.c {
        a() {
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.c
        public void a(String str) {
            CountTimeView J;
            e4.b().d("SplashImage", "interactiveEvent: " + str);
            u2.this.l(str);
            if (u2.this.f23077d == null || (J = u2.this.f23077d.J()) == null) {
                return;
            }
            J.cancel();
            J.changeFinishMode();
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.c
        public void b() {
            e4.b().d("SplashImage", "handleClick ");
            u2 u2Var = u2.this;
            u2Var.q(u2Var.f23079f);
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.c
        public void c() {
            e4.b().d("SplashImage", "timeoutShutdown ");
            if (u2.this.f23077d != null) {
                u2.this.f23077d.B0();
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements ValueCallback {
        b() {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            e4.b().e("SplashImage", "onReceiveValue " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c extends DrawableResponseListener {
        c() {
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            u2.this.h(taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (u2.this.f23077d != null) {
                u2.this.f23077d.m0(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d extends DrawableResponseListener {
        d() {
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            u2.this.h(taErrorCode);
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (u2.this.f23077d != null) {
                u2.this.f23077d.m0(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class e extends com.cloud.hisavana.sdk.common.tranmeasure.a {

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference f23093b;

        public e(u2 u2Var) {
            this.f23093b = new WeakReference(u2Var);
        }

        @Override // com.cloud.hisavana.sdk.common.tranmeasure.a, com.cloud.hisavana.sdk.common.tranmeasure.d.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(AdsDTO adsDTO) {
            i1 i1Var;
            super.a(adsDTO);
            e4.b().d("ssp_measure", "onViewImpressed --> view has impression");
            u2 u2Var = (u2) this.f23093b.get();
            if (u2Var == null || u2Var.f23084k || (i1Var = u2Var.f23077d) == null) {
                return;
            }
            u2Var.f23084k = true;
            e4.b().d("ssp_measure", "mSplashAd.adListener().onAdShow()");
            i1Var.Q();
            if (adsDTO == null || adsDTO.getImpBeanRequest() == null) {
                return;
            }
            P.g().k(adsDTO.getImpBeanRequest().pmid);
            if (adsDTO.getSource() == 4) {
                Z.f21623a.q(adsDTO.getAdCreativeId(), adsDTO.getCodeSeatId());
            } else if (adsDTO.isOfflineAd()) {
                adsDTO.setShowNum(Integer.valueOf(adsDTO.getShowNum().intValue() + 1));
                c0.F().q(adsDTO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        private f() {
        }

        /* synthetic */ f(u2 u2Var, a aVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            u2.this.q(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class g implements View.OnTouchListener {
        private g() {
        }

        /* synthetic */ g(u2 u2Var, a aVar) {
            this();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                u2.this.f23080g = motionEvent.getX();
                u2.this.f23081h = motionEvent.getY();
                return false;
            }
            if (action != 1) {
                return false;
            }
            u2.this.f23082i = motionEvent.getX();
            u2.this.f23083j = motionEvent.getY();
            return false;
        }
    }

    public u2(i1 i1Var) {
        this.f23077d = i1Var;
    }

    private void d(View view) {
        if (view instanceof ImageView) {
            com.cloud.sdk.commonutil.util.k.a((ImageView) view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(TaErrorCode taErrorCode) {
        try {
            i1 i1Var = this.f23077d;
            if (i1Var != null) {
                i1Var.D0();
                this.f23077d.e0(taErrorCode);
            }
        } catch (Throwable unused) {
        }
    }

    private void i(AdsDTO adsDTO) {
        if (this.f23074a == null) {
            this.f23074a = new ImageView(this.f23077d.H());
        }
        ((ImageView) this.f23074a).setScaleType(ImageView.ScaleType.CENTER_CROP);
        DownLoadRequest.n(adsDTO.getAdImgUrl(), adsDTO, new d(), (ImageView) this.f23074a);
    }

    private void j(AdsDTO adsDTO, InteractiveWebView interactiveWebView) {
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getIndexLocation()) || interactiveWebView == null) {
            r(TaErrorCode.ERROR_SHOW_INDEXLOCATION_EMPTY);
            i1 i1Var = this.f23077d;
            if (i1Var != null) {
                i1Var.B0();
                return;
            }
            return;
        }
        if (!new File(adsDTO.getIndexLocation()).exists()) {
            r(TaErrorCode.ERROR_SHOW_AD_INTERACTIVEAD_FILE_NOT_EXIST);
            i1 i1Var2 = this.f23077d;
            if (i1Var2 != null) {
                i1Var2.B0();
            }
            AthenaTracker.S(adsDTO, 3);
            return;
        }
        interactiveWebView.loadUrl(AdPayload.FILE_SCHEME + adsDTO.getIndexLocation());
        i1 i1Var3 = this.f23077d;
        if (i1Var3 != null) {
            i1Var3.m0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str) {
        i1 i1Var = this.f23077d;
        if (i1Var == null) {
            e4.b().e("SplashImage", "trackInteractionEvent splashAd is null");
            return;
        }
        AdsDTO adsDTO = i1Var.f22588o;
        if (adsDTO == null) {
            e4.b().e("SplashImage", "trackInteractionEvent adsDto is null");
        } else {
            AthenaTracker.y(adsDTO, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(View view) {
        if (view == null) {
            return;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f23076c <= 1000 || this.f23077d == null) {
                return;
            }
            this.f23076c = currentTimeMillis;
            N0.b(view.getContext(), this.f23077d.f22588o, new DownUpPointBean(this.f23080g, this.f23081h, this.f23082i, this.f23083j, view.getMeasuredHeight(), view.getMeasuredWidth()), this.f23077d.p().v());
            AthenaTracker.W(this.f23077d.f22588o);
            this.f23077d.O();
        } catch (Throwable th2) {
            e4.b().e("ssp", Log.getStackTraceString(th2));
        }
    }

    private void r(TaErrorCode taErrorCode) {
        try {
            i1 i1Var = this.f23077d;
            if (i1Var != null) {
                i1Var.f0(taErrorCode, null);
            }
        } catch (Throwable unused) {
        }
    }

    private void s(AdsDTO adsDTO) {
        e4.b().d("SplashImage", "attachImgAd");
        if (this.f23074a == null) {
            this.f23074a = new ImageView(this.f23077d.H());
        }
        ((ImageView) this.f23074a).setScaleType(ImageView.ScaleType.CENTER_CROP);
        DownLoadRequest.o(adsDTO.getAdImgUrl(), adsDTO, 2, new c(), (ImageView) this.f23074a);
    }

    private void v(View view) {
        if (view == null || this.f23077d == null) {
            return;
        }
        com.cloud.hisavana.sdk.common.tranmeasure.e.c().e(this.f23077d.f22588o, view, this.f23088o);
        String k11 = com.cloud.hisavana.sdk.common.util.r.f22275a.k(this.f23077d.f22588o);
        ViewGroup K = this.f23077d.K();
        a aVar = null;
        if (TextUtils.isEmpty(k11) || K == null) {
            view.setOnTouchListener(new g(this, aVar));
            view.setOnClickListener(new f(this, aVar));
        } else {
            K.setOnTouchListener(new g(this, aVar));
            K.setOnClickListener(new f(this, aVar));
        }
    }

    private void w(AdsDTO adsDTO) {
        e4.b().d("SplashImage", "attachInteractiveAd");
        if (adsDTO == null) {
            h(TaErrorCode.ERROR_SHOW_ADBEAN_NULL);
        } else {
            C(adsDTO);
            j(adsDTO, this.f23079f);
        }
    }

    private void y(AdsDTO adsDTO) {
        e4.b().d("SplashImage", "fillVideoAd");
        if (this.f23075b == null) {
            this.f23075b = new SplashAdVideoView(this.f23077d.H());
        }
        this.f23075b.resetVolumePosition(!TextUtils.isEmpty(com.cloud.hisavana.sdk.common.util.r.f22275a.k(this.f23077d.f22588o)));
        this.f23075b.setAdMediaPlayerListener(this.f23086m);
        String k11 = v2.k(this.f23077d.f22588o);
        if (TextUtils.isEmpty(k11)) {
            r(TaErrorCode.ERROR_SHOW_AD_MAINURL_EMPTY);
            i1 i1Var = this.f23077d;
            if (i1Var != null) {
                i1Var.B0();
                return;
            }
            return;
        }
        this.f23075b.setMediaData(k11, adsDTO, k11.startsWith("http"));
        i1 i1Var2 = this.f23077d;
        if (i1Var2 != null) {
            i1Var2.m0(false);
        }
    }

    public void A(AdsDTO adsDTO) {
        View view;
        if (adsDTO == null) {
            h(TaErrorCode.ERROR_SHOW_ADBEAN_NULL);
            return;
        }
        AthenaTracker.A(adsDTO);
        if (adsDTO.isVastTypeAd()) {
            y(adsDTO);
            view = this.f23075b;
        } else if (adsDTO.isInteractiveAd()) {
            w(adsDTO);
            view = this.f23079f;
        } else if (adsDTO.getSource() != 4) {
            s(adsDTO);
            view = this.f23074a;
        } else if (adsDTO.getDefaultMaterialType() == 1) {
            i(adsDTO);
            view = this.f23074a;
        } else {
            y(adsDTO);
            view = this.f23075b;
        }
        v(view);
    }

    public View B(AdsDTO adsDTO) {
        if (adsDTO != null) {
            return adsDTO.isInteractiveAd() ? this.f23079f : (adsDTO.isVastTypeAd() || adsDTO.getDefaultMaterialType() == 2) ? this.f23075b : this.f23074a;
        }
        e4.b().e("SplashImage", "getView adsDto is null");
        return new View(com.cloud.sdk.commonutil.util.e.a());
    }

    public void C(AdsDTO adsDTO) {
        if (adsDTO == null) {
            e4.b().e("SplashImage", "initializeInteractiveAdView adsDTO is null");
            return;
        }
        if (this.f23079f != null || this.f23077d.H() == null) {
            return;
        }
        a aVar = null;
        try {
            InteractiveWebView interactiveWebView = new InteractiveWebView(this.f23077d.H());
            this.f23079f = interactiveWebView;
            interactiveWebView.setWebClientCallback(adsDTO);
            this.f23079f.setInteractiveListener(new a());
            this.f23079f.setOnTouchListener(new g(this, aVar));
        } catch (Throwable th2) {
            e4.b().e("SplashImage", "create webview error: " + Log.getStackTraceString(th2));
            this.f23079f = null;
        }
    }

    public void D(AdsDTO adsDTO) {
        SplashAdVideoView splashAdVideoView;
        if (adsDTO == null || !adsDTO.isVastTypeAd() || (splashAdVideoView = this.f23075b) == null) {
            return;
        }
        splashAdVideoView.pause();
    }

    public void b() {
        i1 i1Var = this.f23077d;
        if (i1Var != null && i1Var.f22588o != null) {
            com.cloud.hisavana.sdk.common.tranmeasure.e.c().g(this.f23077d.f22588o);
        }
        d(this.f23074a);
        this.f23074a = null;
        InteractiveWebView interactiveWebView = this.f23079f;
        if (interactiveWebView != null) {
            interactiveWebView.setInteractiveListener(null);
            this.f23079f.destroy();
            this.f23079f = null;
        }
        SplashAdVideoView splashAdVideoView = this.f23075b;
        if (splashAdVideoView != null) {
            splashAdVideoView.setAdMediaPlayerListener(null);
            this.f23075b.release();
            this.f23075b = null;
        }
        e4.b().d("ssp", PushConstants.PROVIDER_FIELD_DESTROY);
    }

    public void c(int i11) {
        this.f23087n = i11;
    }

    public void k(q4 q4Var) {
        this.f23086m = q4Var;
    }

    public void z(AdsDTO adsDTO) {
        InteractiveWebView interactiveWebView;
        if (adsDTO == null) {
            return;
        }
        if (adsDTO.isVastTypeAd()) {
            SplashAdVideoView splashAdVideoView = this.f23075b;
            if (splashAdVideoView != null) {
                splashAdVideoView.play();
                return;
            }
            return;
        }
        if (!adsDTO.isInteractiveAd() || (interactiveWebView = this.f23079f) == null) {
            return;
        }
        interactiveWebView.evaluateJavascript("javascript:continuePlay()", new b());
    }
}
