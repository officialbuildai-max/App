package com.cloud.hisavana.sdk.common.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.cloud.hisavana.sdk.R$id;
import com.cloud.hisavana.sdk.R$string;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.WebPageBean;
import com.cloud.hisavana.sdk.common.util.p0;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.manager.NetStateManager;
import com.cloud.hisavana.sdk.t2;
import com.cloud.sdk.commonutil.util.DeviceUtil;
import com.cloud.sdk.commonutil.util.HSToastUtil;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class PersonalCloseAdActivity extends com.cloud.hisavana.sdk.common.activity.b {

    /* loaded from: classes3.dex */
    class a extends e7.j {
        a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            WebPageBean webPageBean = PersonalCloseAdActivity.this.f21974r;
            if (webPageBean == null) {
                return;
            }
            webPageBean.setLoadStartTime(System.currentTimeMillis());
            if (TextUtils.isEmpty(str) || !p0.e(PersonalCloseAdActivity.this.f21974r.getUrl(), str)) {
                return;
            }
            PersonalCloseAdActivity personalCloseAdActivity = PersonalCloseAdActivity.this;
            if (personalCloseAdActivity.f21971o) {
                return;
            }
            personalCloseAdActivity.f21971o = true;
            AthenaTracker.o0(personalCloseAdActivity.f21974r.getWebId(), PersonalCloseAdActivity.this.f21974r.getUrl(), PersonalCloseAdActivity.this.f21974r.getTargetUrl(), 0, PersonalCloseAdActivity.this.f21974r.getRedirectType(), PersonalCloseAdActivity.this.f21974r.getLoadTime());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            super.onReceivedError(webView, i11, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (PersonalCloseAdActivity.this.f21974r == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString()) || !p0.e(PersonalCloseAdActivity.this.f21974r.getUrl(), webResourceRequest.getUrl().toString())) {
                return;
            }
            PersonalCloseAdActivity personalCloseAdActivity = PersonalCloseAdActivity.this;
            personalCloseAdActivity.f21969m = true;
            personalCloseAdActivity.f21974r.setErrorType("error");
            PersonalCloseAdActivity.this.f21974r.setErrorCode(webResourceError.getErrorCode());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (PersonalCloseAdActivity.this.f21974r == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString()) || !p0.e(PersonalCloseAdActivity.this.f21974r.getUrl(), webResourceRequest.getUrl().toString())) {
                return;
            }
            PersonalCloseAdActivity personalCloseAdActivity = PersonalCloseAdActivity.this;
            personalCloseAdActivity.f21969m = true;
            personalCloseAdActivity.f21974r.setErrorType("error");
            PersonalCloseAdActivity.this.f21974r.setErrorCode(webResourceResponse.getStatusCode());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            if (PersonalCloseAdActivity.this.f21974r == null || TextUtils.isEmpty(sslError.getUrl()) || !p0.e(PersonalCloseAdActivity.this.f21974r.getUrl(), sslError.getUrl())) {
                return;
            }
            PersonalCloseAdActivity personalCloseAdActivity = PersonalCloseAdActivity.this;
            personalCloseAdActivity.f21969m = true;
            personalCloseAdActivity.f21974r.setErrorType("ssl");
            PersonalCloseAdActivity.this.f21974r.setErrorCode(sslError.getPrimaryError());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PersonalCloseAdActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference f21878a;

        /* renamed from: b, reason: collision with root package name */
        private final AdsDTO f21879b;

        /* renamed from: c, reason: collision with root package name */
        private int f21880c;

        /* loaded from: classes3.dex */
        class a implements Preconditions.a {
            a() {
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                t2.p().e(c.this.f21880c);
                Activity activity = (Activity) c.this.f21878a.get();
                if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
                activity.onBackPressed();
            }
        }

        /* loaded from: classes3.dex */
        class b implements Preconditions.a {
            b() {
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                Activity activity = (Activity) c.this.f21878a.get();
                if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
                activity.onBackPressed();
            }
        }

        public c(Activity activity, AdsDTO adsDTO) {
            this.f21878a = new WeakReference(activity);
            this.f21879b = adsDTO;
        }

        @JavascriptInterface
        public void athenaTrack(String str, String str2) {
            e4.b().d("PersonalCloseAdActivity", "athenaTrack -----> eventName = " + str + "  params = " + str2);
            AthenaTracker.P(this.f21879b, str, str2, 8765);
        }

        public void b(int i11) {
            this.f21880c = i11;
        }

        @JavascriptInterface
        public void closePage(String str, String str2) {
            Preconditions.d(new b());
        }

        @JavascriptInterface
        public void personaliseCallback() {
            e4.b().d("PersonalCloseAdActivity", "personaliseCallback");
            Preconditions.d(new a());
        }
    }

    private void A() {
        if (this.f21964h == null || this.f21963g == null) {
            return;
        }
        WebPageBean webPageBean = this.f21974r;
        if (webPageBean != null) {
            webPageBean.setUrl(g7.a.b());
            AthenaTracker.p0(this.f21974r.getWebId(), this.f21974r.getUrl(), this.f21974r.getTargetUrl(), MRAIDPresenter.OPEN);
        }
        StringBuilder sb2 = new StringBuilder(g7.a.b());
        sb2.append("?gaid=");
        sb2.append(DeviceUtil.e());
        sb2.append("&oneid=");
        sb2.append(DeviceUtil.j());
        sb2.append("&ad_creative_id=");
        sb2.append(this.f21964h.getAdCreativeId());
        sb2.append("&industry_id=");
        sb2.append(this.f21964h.getIndustryId());
        sb2.append("&app_id=");
        String str = a7.c.f440b;
        if (str == null) {
            str = "";
        }
        sb2.append(str);
        sb2.append("&code_seat_id=");
        sb2.append(this.f21964h.getCodeSeatId());
        sb2.append("&trigger_id=");
        sb2.append(this.f21964h.getTriggerId());
        sb2.append("&request_id=");
        sb2.append(this.f21964h.getRid());
        sb2.append("&advertiser_id=");
        sb2.append(this.f21964h.getAdvertiserId());
        String sb3 = sb2.toString();
        e4.b().d("PersonalCloseAdActivity", "ad close url == " + sb3);
        q(sb3);
        this.f21963g.loadUrl(sb3);
    }

    private void x() {
        WebPageBean webPageBean = this.f21974r;
        if (webPageBean != null) {
            webPageBean.setUrl(g7.a.b());
            AthenaTracker.p0(this.f21974r.getWebId(), this.f21974r.getUrl(), this.f21974r.getTargetUrl(), MRAIDPresenter.OPEN);
            this.f21969m = true;
            this.f21974r.setErrorType("error");
            this.f21974r.setErrorCode(-2);
            String webId = this.f21974r.getWebId();
            String url = this.f21974r.getUrl();
            String targetUrl = this.f21974r.getTargetUrl();
            int redirectType = this.f21974r.getRedirectType();
            boolean z10 = this.f21969m;
            AthenaTracker.n0(webId, url, targetUrl, redirectType, z10 ? "fail" : NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, z10 ? this.f21974r.getErrorType() : "succeed", this.f21969m ? this.f21974r.getErrorCode() : 8000, -1L);
        }
    }

    private void y() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.layout_title);
        this.f21959c = frameLayout;
        frameLayout.setVisibility(0);
        HSToastUtil.f(getString(R$string.toast_no_network));
        ImageView imageView = this.f21961e;
        if (imageView != null) {
            imageView.setOnClickListener(new b());
        }
    }

    private void z() {
        if (this.f21963g == null) {
            return;
        }
        c cVar = new c(this, this.f21964h);
        this.f21963g.addJavascriptInterface(cVar, "sspWebView");
        cVar.b(getIntent().getIntExtra("close_hash_code", 0));
        A();
    }

    @Override // com.cloud.hisavana.sdk.common.activity.b
    protected WebViewClient h() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cloud.hisavana.sdk.common.activity.b, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (NetStateManager.checkNetworkState(false)) {
            z();
            return;
        }
        x();
        this.f21960d.setVisibility(8);
        findViewById(R$id.layout_no_net).setVisibility(0);
        y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.cloud.hisavana.sdk.common.activity.b, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        FrameLayout frameLayout = this.f21960d;
        if (frameLayout == null || frameLayout.getVisibility() != 8) {
            return;
        }
        t2.p().d();
    }
}
