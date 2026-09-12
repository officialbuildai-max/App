package com.cloud.hisavana.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.cloud.hisavana.sdk.api.view.AdBadgeView;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.api.view.StoreMarkView;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.common.widget.InteractiveWebView;
import com.cloud.hisavana.sdk.common.widget.TadmWebView;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageWebViewClient;
import com.cloud.hisavana.sdk.internal.agentpage.bean.AgentPageCurrentAd;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private final p3 f22847a;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f22850d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f22851e;

    /* renamed from: f, reason: collision with root package name */
    private AdChoicesView f22852f;

    /* renamed from: g, reason: collision with root package name */
    private TadmWebView f22853g;

    /* renamed from: h, reason: collision with root package name */
    private InteractiveWebView f22854h;

    /* renamed from: j, reason: collision with root package name */
    private boolean f22856j;

    /* renamed from: p, reason: collision with root package name */
    private long f22862p;

    /* renamed from: r, reason: collision with root package name */
    private r f22864r;

    /* renamed from: b, reason: collision with root package name */
    private AdsDTO f22848b = null;

    /* renamed from: c, reason: collision with root package name */
    private View f22849c = null;

    /* renamed from: i, reason: collision with root package name */
    private boolean f22855i = false;

    /* renamed from: k, reason: collision with root package name */
    private final e7.n f22857k = new e7.n(com.cloud.sdk.commonutil.util.e.a());

    /* renamed from: l, reason: collision with root package name */
    private float f22858l = -1.0f;

    /* renamed from: m, reason: collision with root package name */
    private float f22859m = -1.0f;

    /* renamed from: n, reason: collision with root package name */
    private float f22860n = -1.0f;

    /* renamed from: o, reason: collision with root package name */
    private float f22861o = -1.0f;

    /* renamed from: s, reason: collision with root package name */
    private boolean f22865s = false;

    /* renamed from: t, reason: collision with root package name */
    private boolean f22866t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f22867u = false;

    /* renamed from: v, reason: collision with root package name */
    DrawableResponseListener f22868v = new e();

    /* renamed from: q, reason: collision with root package name */
    private final g f22863q = new g(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements InteractiveWebView.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdsDTO f22869a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ InteractiveWebView f22870b;

        a(AdsDTO adsDTO, InteractiveWebView interactiveWebView) {
            this.f22869a = adsDTO;
            this.f22870b = interactiveWebView;
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.c
        public void a(String str) {
            AthenaTracker.y(this.f22869a, str);
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.c
        public void b() {
            o.this.d(this.f22870b);
        }

        @Override // com.cloud.hisavana.sdk.common.widget.InteractiveWebView.c
        public void c() {
            e4.b().d("BannerGemini", "timeoutShutdown");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements s4 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TadmWebView f22872a;

        b(TadmWebView tadmWebView) {
            this.f22872a = tadmWebView;
        }

        @Override // com.cloud.hisavana.sdk.s4
        public void a() {
        }

        @Override // com.cloud.hisavana.sdk.s4
        public void a(String str, int i11) {
            if (o.this.f22847a != null) {
                o.this.f22847a.P();
                Bundle bundle = new Bundle();
                bundle.putString("s_err_code", i11 + "");
                bundle.putString("error_url", str);
                o.this.f22847a.K(TaErrorCode.ERROR_SHOW_ADM_LOAD_MATERIAL_ERROR, bundle);
            }
        }

        @Override // com.cloud.hisavana.sdk.s4
        public int b(float f11, float f12, float f13, float f14, boolean z10) {
            o.this.f22858l = f11;
            o.this.f22859m = f12;
            o.this.f22860n = f13;
            o.this.f22861o = f14;
            return o.this.q(this.f22872a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements AgentPageJsBridge.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f22874a;

        c(ViewGroup viewGroup) {
            this.f22874a = viewGroup;
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge.a
        public void a() {
            com.cloud.hisavana.sdk.common.tranmeasure.e.c().e(o.this.f22848b, this.f22874a, o.this.f22863q);
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge.a
        public void a(int i11) {
            if (o.this.f22847a != null) {
                o.this.f22847a.H(i11);
            }
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge.a
        public void onClick() {
            if (o.this.f22847a != null) {
                o.this.f22847a.U();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements AgentPageWebViewClient.OverrideListener {

        /* renamed from: a, reason: collision with root package name */
        boolean f22876a = false;

        d() {
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageWebViewClient.OverrideListener
        public boolean OnOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString())) {
                return false;
            }
            AdsDTO m679clone = o.this.f22848b.m679clone();
            m679clone.setAdChoiceClickUrl(webResourceRequest.getUrl().toString());
            N0.m(webView.getContext(), m679clone, true, false, null);
            return true;
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageWebViewClient.OverrideListener
        public boolean OnOverrideUrlLoading(WebView webView, String str) {
            AdsDTO m679clone = o.this.f22848b.m679clone();
            m679clone.setAdChoiceClickUrl(str);
            N0.m(webView.getContext(), m679clone, true, false, null);
            return true;
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageWebViewClient.OverrideListener
        public void onError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            if (webResourceRequest == null || !webResourceRequest.isForMainFrame() || this.f22876a || o.this.f22847a == null) {
                return;
            }
            o.this.f22847a.P();
            Bundle bundle = new Bundle();
            try {
                bundle.putString("s_err_code", webResourceError.getErrorCode() + "");
                o.this.f22847a.K(TaErrorCode.ERROR_SHOW_ADM_LOAD_WEB_ERROR, bundle);
            } catch (Throwable unused) {
            }
        }

        @Override // com.cloud.hisavana.sdk.internal.agentpage.AgentPageWebViewClient.OverrideListener
        public void onPageFinished(WebView webView, String str) {
            if (webView == null || webView.getProgress() != 100) {
                return;
            }
            this.f22876a = true;
        }
    }

    /* loaded from: classes3.dex */
    class e extends DrawableResponseListener {
        e() {
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            try {
                if (o.this.f22847a != null) {
                    if (taErrorCode == null || !(taErrorCode.getErrorCode() == 3007 || taErrorCode.getErrorCode() == 3016)) {
                        o.this.f22847a.J(taErrorCode);
                    } else {
                        o.this.f22847a.K(taErrorCode, new Bundle());
                    }
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        private f() {
        }

        /* synthetic */ f(o oVar, a aVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (o.this.f22848b != null) {
                N0.k(view.getContext(), o.this.f22848b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class g extends com.cloud.hisavana.sdk.common.tranmeasure.a {

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference f22880b;

        public g(o oVar) {
            this.f22880b = new WeakReference(oVar);
        }

        @Override // com.cloud.hisavana.sdk.common.tranmeasure.a, com.cloud.hisavana.sdk.common.tranmeasure.d.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(AdsDTO adsDTO) {
            p3 p3Var;
            super.a(adsDTO);
            e4.b().d("BannerGemini", "onViewImpressed: start impression report");
            o oVar = (o) this.f22880b.get();
            if (oVar == null || (p3Var = oVar.f22847a) == null) {
                return;
            }
            p3Var.V();
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
    public class h implements View.OnClickListener {
        private h() {
        }

        /* synthetic */ h(o oVar, a aVar) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o.this.d(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class i implements View.OnTouchListener {
        private i() {
        }

        /* synthetic */ i(o oVar, a aVar) {
            this();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                o.this.f22858l = motionEvent.getX();
                o.this.f22859m = motionEvent.getY();
                return false;
            }
            if (action != 1) {
                return false;
            }
            o.this.f22860n = motionEvent.getX();
            o.this.f22861o = motionEvent.getY();
            return false;
        }
    }

    public o(p3 p3Var) {
        this.f22847a = p3Var;
    }

    private void A(ViewGroup viewGroup) {
        if (this.f22848b == null) {
            p3 p3Var = this.f22847a;
            if (p3Var != null) {
                p3Var.J(TaErrorCode.ERROR_SHOW_ADBEAN_NULL);
                return;
            }
            return;
        }
        InteractiveWebView interactiveWebView = this.f22854h;
        if (interactiveWebView != null) {
            interactiveWebView.destroy();
        }
        try {
            InteractiveWebView interactiveWebView2 = new InteractiveWebView(com.cloud.sdk.commonutil.util.e.a());
            this.f22854h = interactiveWebView2;
            i(interactiveWebView2, viewGroup);
        } catch (Throwable th2) {
            e4.b().e("BannerGemini", "create webview error: " + Log.getStackTraceString(th2));
            this.f22854h = null;
            p3 p3Var2 = this.f22847a;
            if (p3Var2 != null) {
                p3Var2.J(TaErrorCode.ERROR_SHOW_INTERACTIVE_WEBVIEW_ERROR);
            }
        }
    }

    private void B(ViewGroup viewGroup) {
        int i11;
        AdsDTO adsDTO = this.f22848b;
        if (adsDTO == null) {
            p3 p3Var = this.f22847a;
            if (p3Var != null) {
                p3Var.J(TaErrorCode.ERROR_SHOW_ADBEAN_NULL);
                return;
            }
            return;
        }
        String adImgUrl = adsDTO.getAdImgUrl();
        if ((!TextUtils.equals(this.f22848b.getMaterialStyle(), "B20301") && !TextUtils.equals(this.f22848b.getMaterialStyle(), "B20302") && !TextUtils.equals(this.f22848b.getMaterialStyle(), "B20303")) || this.f22848b.getPackageName() == null || this.f22848b.getNativeObject() == null) {
            i11 = 2;
        } else {
            adImgUrl = this.f22848b.getNativeObject().getLogoUrl();
            i11 = 1;
        }
        e(viewGroup);
        if (this.f22848b.getSource() == 4) {
            AdsDTO adsDTO2 = this.f22848b;
            DrawableResponseListener drawableResponseListener = this.f22868v;
            ImageView imageView = this.f22850d;
            if (imageView == null) {
                imageView = this.f22851e;
            }
            DownLoadRequest.n(adImgUrl, adsDTO2, drawableResponseListener, imageView);
            return;
        }
        AdsDTO adsDTO3 = this.f22848b;
        DrawableResponseListener drawableResponseListener2 = this.f22868v;
        ImageView imageView2 = this.f22850d;
        if (imageView2 == null) {
            imageView2 = this.f22851e;
        }
        DownLoadRequest.o(adImgUrl, adsDTO3, i11, drawableResponseListener2, imageView2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(View view) {
        try {
            AdsDTO adsDTO = this.f22848b;
            if (adsDTO != null) {
                if (adsDTO.getPslinkInfo() != null) {
                    if (view.getId() == R$id.tvBtn) {
                        this.f22848b.getPslinkInfo().setClickType(2);
                        this.f22848b.setTrackUserClickArea(2);
                        e4.b().d("BannerGemini", "pslink half setClickType, click_install");
                    } else {
                        this.f22848b.getPslinkInfo().setClickType(1);
                        this.f22848b.setTrackUserClickArea(1);
                        e4.b().d("BannerGemini", "pslink half setClickType, click_img");
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f22862p > 1000) {
                    q(view);
                    this.f22862p = currentTimeMillis;
                }
            }
        } catch (Exception e11) {
            e4.b().e(Log.getStackTraceString(e11));
        }
    }

    private void f(ViewGroup viewGroup, StoreMarkView storeMarkView) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(storeMarkView);
        arrayList.add(this.f22849c.findViewById(R$id.ad_flag));
        arrayList.add(this.f22849c.findViewById(R$id.ad_close_view));
        arrayList.add(this.f22849c.findViewById(R$id.ps_mark_view));
        p3 p3Var = this.f22847a;
        if (p3Var != null) {
            m0.a(p3Var.v(), this.f22848b, viewGroup, arrayList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void k(com.cloud.hisavana.sdk.common.widget.TadmWebView r7, android.view.ViewGroup r8, boolean r9, boolean r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 442
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.o.k(com.cloud.hisavana.sdk.common.widget.TadmWebView, android.view.ViewGroup, boolean, boolean, boolean):void");
    }

    private void l(AdsDTO adsDTO, View view) {
        AdBadgeView adBadgeView;
        if (adsDTO == null || view == null || (adBadgeView = (AdBadgeView) view.findViewById(R$id.ad_badge_view)) == null) {
            return;
        }
        adBadgeView.setDisplayStyle(adsDTO.getDisplayRule(), com.cloud.hisavana.sdk.common.util.f0.c(adsDTO));
    }

    private void m(AdsDTO adsDTO, View view, boolean z10) {
        AdCloseView adCloseView;
        if (adsDTO == null || view == null || (adCloseView = (AdCloseView) view.findViewById(R$id.ad_close_view)) == null) {
            return;
        }
        if (z10 && this.f22855i) {
            adCloseView.setVisibility(8);
            return;
        }
        adCloseView.setVisibility(0);
        t2.p().g(com.cloud.sdk.commonutil.util.e.a(), adCloseView, this.f22847a, adsDTO, this.f22856j);
        adCloseView.setDisplayStyle(adsDTO.getDisplayRule(), AdCloseView.CloseImageType.CLOSE);
        try {
            String materialStyle = this.f22848b.getMaterialStyle();
            if (this.f22865s && ("B20301".equals(materialStyle) || "B20302".equals(materialStyle) || "B20303".equals(materialStyle))) {
                adCloseView.setCloseStyle(androidx.core.content.b.getDrawable(com.cloud.sdk.commonutil.util.e.a(), R$drawable.hs_ad_banner_close), androidx.core.content.b.getColor(com.cloud.sdk.commonutil.util.e.a(), R$color.ad_banner_close_bg));
            } else {
                if (this.f22866t || this.f22867u || !"B20304".equals(materialStyle)) {
                    return;
                }
                adCloseView.setCloseStyle(androidx.core.content.b.getDrawable(com.cloud.sdk.commonutil.util.e.a(), R$drawable.hs_ad_banner_20304_close), 0);
                adCloseView.setViewSize(24, 24);
            }
        } catch (Throwable unused) {
        }
    }

    private void n(AdsDTO adsDTO, InteractiveWebView interactiveWebView) {
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getIndexLocation())) {
            return;
        }
        if (!new File(adsDTO.getIndexLocation()).exists() || interactiveWebView == null) {
            p3 p3Var = this.f22847a;
            if (p3Var != null) {
                p3Var.P();
            }
            AthenaTracker.S(this.f22848b, 3);
            return;
        }
        interactiveWebView.loadUrl(AdPayload.FILE_SCHEME + adsDTO.getIndexLocation());
    }

    private void o(AdsDTO adsDTO, boolean z10, View view) {
        if (adsDTO == null || view == null) {
            return;
        }
        boolean a11 = com.cloud.hisavana.sdk.common.util.i0.a(adsDTO);
        StoreMarkView storeMarkView = (StoreMarkView) view.findViewById(R$id.ps_mark_view);
        if (storeMarkView != null) {
            storeMarkView.setVisibility(a11 ? 0 : 8);
            storeMarkView.setTextColor(z10 ? -1 : -8882056);
            storeMarkView.setTextSize(z10 ? 8.0f : 6.0f);
            storeMarkView.attachInfo(adsDTO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int q(View view) {
        Context context = view.getContext();
        AdsDTO adsDTO = this.f22848b;
        DownUpPointBean downUpPointBean = new DownUpPointBean(this.f22858l, this.f22859m, this.f22860n, this.f22861o, view.getMeasuredHeight(), view.getMeasuredWidth());
        p3 p3Var = this.f22847a;
        int b11 = N0.b(context, adsDTO, downUpPointBean, p3Var == null ? false : p3Var.p().v());
        AthenaTracker.W(this.f22848b);
        p3 p3Var2 = this.f22847a;
        if (p3Var2 != null) {
            p3Var2.U();
        }
        return b11;
    }

    private void t(ViewGroup viewGroup) {
        AdsDTO adsDTO = this.f22848b;
        if (adsDTO == null || TextUtils.isEmpty(adsDTO.getAdm()) || viewGroup == null) {
            p3 p3Var = this.f22847a;
            if (p3Var != null) {
                AdsDTO adsDTO2 = this.f22848b;
                if (adsDTO2 == null) {
                    p3Var.J(TaErrorCode.ERROR_SHOW_ADBEAN_NULL);
                    return;
                } else if (TextUtils.isEmpty(adsDTO2.getAdm())) {
                    this.f22847a.J(TaErrorCode.ERROR_SHOW_ADM_NULL);
                    return;
                } else {
                    this.f22847a.J(TaErrorCode.ERROR_SHOW_VIEWGROUP_NULL);
                    return;
                }
            }
            return;
        }
        TadmWebView tadmWebView = this.f22853g;
        if (tadmWebView != null) {
            tadmWebView.destroy();
        }
        try {
            this.f22866t = true;
            TadmWebView tadmWebView2 = new TadmWebView(com.cloud.sdk.commonutil.util.e.a());
            this.f22853g = tadmWebView2;
            j(tadmWebView2, viewGroup);
        } catch (Throwable th2) {
            e4.b().e("BannerGemini", "create webview error: " + Log.getStackTraceString(th2));
            this.f22853g = null;
            p3 p3Var2 = this.f22847a;
            if (p3Var2 != null) {
                p3Var2.J(TaErrorCode.ERROR_SHOW_ADM_WEBVIEW_ERROR);
            }
        }
    }

    private void v(AdsDTO adsDTO, View view) {
        AdChoicesView adChoicesView;
        if (adsDTO == null || view == null || (adChoicesView = (AdChoicesView) view.findViewById(R$id.ad_choices_view)) == null) {
            return;
        }
        a aVar = null;
        if (adsDTO.getSource() == 4) {
            DownLoadRequest.n(adsDTO.getAdChoiceImageUrl(), adsDTO, null, adChoicesView);
        } else {
            DownLoadRequest.o(adsDTO.getAdChoiceImageUrl(), adsDTO, 3, null, adChoicesView);
        }
        adChoicesView.setOnClickListener(new f(this, aVar));
        this.f22852f = adChoicesView;
    }

    private void y(ViewGroup viewGroup) {
        if (viewGroup == null) {
            p3 p3Var = this.f22847a;
            if (p3Var != null) {
                p3Var.J(TaErrorCode.ERROR_SHOW_VIEWGROUP_NULL);
                return;
            }
            return;
        }
        TadmWebView tadmWebView = this.f22853g;
        if (tadmWebView != null) {
            tadmWebView.destroy();
        }
        try {
            TadmWebView tadmWebView2 = new TadmWebView(com.cloud.sdk.commonutil.util.e.a());
            this.f22853g = tadmWebView2;
            u(tadmWebView2, viewGroup);
        } catch (Throwable th2) {
            e4.b().e("BannerGemini", "create webview error: " + Log.getStackTraceString(th2));
            this.f22853g = null;
            p3 p3Var2 = this.f22847a;
            if (p3Var2 != null) {
                p3Var2.J(TaErrorCode.ERROR_SHOW_ADM_WEBVIEW_ERROR);
            }
        }
    }

    public void c() {
        com.cloud.sdk.commonutil.util.k.a(this.f22850d);
        com.cloud.sdk.commonutil.util.k.a(this.f22851e);
        com.cloud.sdk.commonutil.util.k.a(this.f22852f);
        TadmWebView tadmWebView = this.f22853g;
        if (tadmWebView != null) {
            tadmWebView.destroy();
            this.f22853g = null;
        }
        InteractiveWebView interactiveWebView = this.f22854h;
        if (interactiveWebView != null) {
            interactiveWebView.destroy();
            this.f22854h = null;
        }
        r rVar = this.f22864r;
        if (rVar != null) {
            rVar.c();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x03f6, code lost:
    
        if (r20.equals(r21.f22848b.getMaterialStyle()) != false) goto L156;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x00a2. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void e(android.view.ViewGroup r22) {
        /*
            Method dump skipped, instructions count: 1302
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.o.e(android.view.ViewGroup):void");
    }

    public void g(ViewGroup viewGroup, boolean z10, boolean z11, AdsDTO adsDTO) {
        this.f22855i = z10;
        this.f22856j = z11;
        if (adsDTO != null) {
            this.f22848b = adsDTO;
            ConfigCodeSeatDTO f11 = this.f22847a.p() != null ? this.f22847a.p().f() : null;
            if (NetStateManager.checkNetworkState(false) && f11 != null && f11.isPriorityH5Ad().booleanValue() && com.cloud.hisavana.sdk.common.util.p0.f(f11.getH5AdUrl())) {
                y(viewGroup);
                return;
            }
            if (!TextUtils.isEmpty(adsDTO.getAdm())) {
                t(viewGroup);
            } else if (adsDTO.isInteractiveAd()) {
                A(viewGroup);
            } else {
                B(viewGroup);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    void i(InteractiveWebView interactiveWebView, ViewGroup viewGroup) {
        char c11;
        boolean z10 = true;
        AdsDTO adsDTO = this.f22848b;
        if (adsDTO == null || viewGroup == null || interactiveWebView == null) {
            TaErrorCode taErrorCode = TaErrorCode.ERROR_SHOW_INTERACTIVE_WEBVIEW_ERROR;
            if (adsDTO == null) {
                taErrorCode = TaErrorCode.ERROR_SHOW_ADBEAN_NULL;
            } else if (viewGroup == null) {
                taErrorCode = TaErrorCode.ERROR_SHOW_VIEWGROUP_NULL;
            }
            p3 p3Var = this.f22847a;
            if (p3Var != null) {
                p3Var.J(taErrorCode);
                return;
            }
            return;
        }
        viewGroup.removeAllViews();
        ((RelativeLayout) viewGroup).setGravity(17);
        if (adsDTO.getNativeObject() == null || adsDTO.getMaterialStyle() == null) {
            e4.b().d("BannerGemini", "TranBanner --> null == mAdBean.nativeBean || null == mAdBean.materialStyle");
            p3 p3Var2 = this.f22847a;
            if (p3Var2 != null) {
                p3Var2.J(TaErrorCode.ERROR_SHOW_NATIVEOBJ_NULL);
                return;
            }
            return;
        }
        e4.b().d("BannerGemini", "*----> TranBanner --> MaterialStyle =" + adsDTO.getMaterialStyle());
        String materialStyle = adsDTO.getMaterialStyle();
        materialStyle.hashCode();
        switch (materialStyle.hashCode()) {
            case 62521314:
                if (materialStyle.equals("B3201")) {
                    c11 = 0;
                    break;
                }
                c11 = 65535;
                break;
            case 1937180532:
                if (materialStyle.equals("B20301")) {
                    c11 = 1;
                    break;
                }
                c11 = 65535;
                break;
            case 1937180533:
                if (materialStyle.equals("B20302")) {
                    c11 = 2;
                    break;
                }
                c11 = 65535;
                break;
            case 1937180534:
                if (materialStyle.equals("B20303")) {
                    c11 = 3;
                    break;
                }
                c11 = 65535;
                break;
            case 1937180535:
                if (materialStyle.equals("B20304")) {
                    c11 = 4;
                    break;
                }
                c11 = 65535;
                break;
            default:
                c11 = 65535;
                break;
        }
        switch (c11) {
            case 0:
                this.f22849c = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.banner_style_3201_layout, viewGroup, false);
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                this.f22849c = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.banner_style_20304_layout, viewGroup, false);
                z10 = false;
                break;
            default:
                e4.b().d("BannerGemini", "TranBanner --> 没有匹配到 materialStyle --> 配置错误 materialStyle=" + adsDTO.getMaterialStyle());
                p3 p3Var3 = this.f22847a;
                if (p3Var3 != null) {
                    p3Var3.J(TaErrorCode.ERROR_SHOW_MATERIAL_STYLE_NULL);
                    return;
                }
                return;
        }
        boolean z11 = z10;
        com.cloud.hisavana.sdk.common.tranmeasure.e.c().e(adsDTO, this.f22849c, this.f22863q);
        AthenaTracker.A(this.f22848b);
        View view = this.f22849c;
        if (view == null) {
            p3 p3Var4 = this.f22847a;
            if (p3Var4 != null) {
                p3Var4.J(TaErrorCode.ERROR_SHOW_RENDERVIEW_NULL);
                return;
            }
            return;
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.ivBanner);
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            interactiveWebView.setLayoutParams(layoutParams);
            List<String> scales = adsDTO.getScales();
            if (scales != null && !scales.isEmpty()) {
                String str = scales.get(0);
                str.hashCode();
                if (str.equals("3:2")) {
                    layoutParams.height = (i7.c.k() * 2) / 3;
                    layoutParams.width = i7.c.k();
                } else if (str.equals("20:3")) {
                    layoutParams.height = (i7.c.k() * 3) / 20;
                    layoutParams.width = i7.c.k();
                }
            }
            frameLayout.addView(interactiveWebView, layoutParams);
            frameLayout.setOnTouchListener(new i(this, null));
            interactiveWebView.setWebClientCallback(adsDTO);
            interactiveWebView.setInteractiveListener(new a(adsDTO, interactiveWebView));
            n(adsDTO, interactiveWebView);
        }
        o(adsDTO, z10, this.f22849c);
        ImageView imageView = (ImageView) this.f22849c.findViewById(R$id.ivIcon);
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        v(adsDTO, this.f22849c);
        l(adsDTO, this.f22849c);
        m(adsDTO, this.f22849c, false);
        interactiveWebView.setVisibility(0);
        if (com.cloud.sdk.commonutil.util.h.e() != 2) {
            viewGroup.addView(this.f22849c, -1, -2);
        } else if (z11) {
            viewGroup.addView(this.f22849c, com.cloud.sdk.commonutil.util.h.a(300.0f), com.cloud.sdk.commonutil.util.h.a(200.0f));
        } else {
            viewGroup.addView(this.f22849c, com.cloud.sdk.commonutil.util.h.a(360.0f), com.cloud.sdk.commonutil.util.h.a(54.0f));
        }
        if (viewGroup.getBackground() != null) {
            viewGroup.getBackground().setAlpha(0);
        }
        viewGroup.setVisibility(0);
        e4.b().d("BannerGemini", "ad banner attachInteractiveAd show...");
    }

    void j(TadmWebView tadmWebView, ViewGroup viewGroup) {
        AdsDTO adsDTO;
        if (viewGroup == null || tadmWebView == null || (adsDTO = this.f22848b) == null || TextUtils.isEmpty(adsDTO.getAdm())) {
            return;
        }
        AthenaTracker.A(this.f22848b);
        if (this.f22864r == null) {
            this.f22864r = new r();
        }
        this.f22864r.d(tadmWebView, this.f22848b, new b(tadmWebView));
        k(tadmWebView, viewGroup, false, false, false);
        tadmWebView.loadDataWithBaseURL(null, this.f22848b.getAdm() + TadmWebView.JS_TEXT, "text/html", "utf-8", null);
    }

    void u(TadmWebView tadmWebView, ViewGroup viewGroup) {
        this.f22867u = true;
        if (viewGroup == null || tadmWebView == null || this.f22848b == null) {
            p3 p3Var = this.f22847a;
            if (p3Var != null) {
                p3Var.J(TaErrorCode.ERROR_SHOW_ADBEAN_NULL);
                return;
            }
            return;
        }
        ConfigCodeSeatDTO f11 = this.f22847a.p() != null ? this.f22847a.p().f() : null;
        if (f11 == null || TextUtils.isEmpty(f11.getH5AdUrl())) {
            e4.b().e("BannerGemini", "getConfig().getH5AdUrl() == null");
            p3 p3Var2 = this.f22847a;
            if (p3Var2 != null) {
                p3Var2.J(TaErrorCode.ERROR_SHOW_H5_ADURL_NULL);
                return;
            }
            return;
        }
        AthenaTracker.A(this.f22848b);
        AthenaTracker.z(0, null, null, this.f22848b);
        tadmWebView.getSettings().setCacheMode(-1);
        tadmWebView.getSettings().setDomStorageEnabled(true);
        CookieManager.getInstance().setAcceptThirdPartyCookies(tadmWebView, true);
        tadmWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
        AgentPageJsBridge agentPageJsBridge = new AgentPageJsBridge();
        agentPageJsBridge.setWebview(tadmWebView);
        AgentPageCurrentAd agentPageCurrentAd = new AgentPageCurrentAd(f11.getH5AdUrl(), this.f22848b.getCodeSeatId(), this.f22848b.getTriggerId());
        agentPageJsBridge.setCurrentAdInfo(agentPageCurrentAd);
        agentPageJsBridge.setAdActionListener(new c(viewGroup));
        agentPageJsBridge.setCurrentAd(this.f22848b);
        tadmWebView.addJavascriptInterface(agentPageJsBridge, AgentPageJsBridge.INTERFACE_NAME);
        AgentPageWebViewClient agentPageWebViewClient = new AgentPageWebViewClient(new d());
        agentPageWebViewClient.setMainPageUrl(f11.getH5AdUrl());
        agentPageWebViewClient.setSource(this.f22848b.getSource());
        tadmWebView.setWebViewClient(agentPageWebViewClient);
        this.f22855i = true;
        k(tadmWebView, viewGroup, true, true, true);
        if (tadmWebView.getLayoutParams() != null) {
            if (tadmWebView.getLayoutParams().width > 0 && tadmWebView.getLayoutParams().height > 0) {
                agentPageCurrentAd.setWidth(tadmWebView.getLayoutParams().width);
                agentPageCurrentAd.setHeight(tadmWebView.getLayoutParams().height);
            } else if (TextUtils.equals(this.f22848b.getMaterialStyle(), "B3201")) {
                agentPageCurrentAd.setHeight(com.cloud.sdk.commonutil.util.h.a(200.0f));
                agentPageCurrentAd.setWidth(com.cloud.sdk.commonutil.util.h.a(300.0f));
            } else {
                agentPageCurrentAd.setHeight(com.cloud.sdk.commonutil.util.h.a(54.0f));
                agentPageCurrentAd.setWidth(com.cloud.sdk.commonutil.util.h.a(360.0f));
            }
        }
        tadmWebView.loadUrl(f11.getH5AdUrl());
    }
}
