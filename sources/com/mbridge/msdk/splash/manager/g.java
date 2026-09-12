package com.mbridge.msdk.splash.manager;

import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.MBSplashWebview;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private boolean f37571a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f37572b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends com.mbridge.msdk.mbsignalcommon.listener.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f37573a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MBSplashView f37574b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CampaignEx f37575c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f37576d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f37577e;

        a(c cVar, MBSplashView mBSplashView, CampaignEx campaignEx, String str, long j11) {
            this.f37573a = cVar;
            this.f37574b = mBSplashView;
            this.f37575c = campaignEx;
            this.f37576d = str;
            this.f37577e = j11;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i11) {
            super.a(webView, i11);
            c cVar = this.f37573a;
            if (cVar != null) {
                cVar.a(i11);
            }
            if (i11 == 1) {
                g.this.f37571a = true;
                this.f37574b.setH5Ready(true);
                com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f37575c, this.f37576d, "", this.f37577e, 1);
                com.mbridge.msdk.splash.report.a.a(1, "", this.f37576d, this.f37575c);
                return;
            }
            g.this.f37571a = false;
            this.f37574b.setH5Ready(false);
            com.mbridge.msdk.splash.report.a.a(2, "readyState 2", this.f37576d, this.f37575c);
            com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f37575c, this.f37576d, "readyState 2", this.f37577e, 3);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i11, String str, String str2) {
            super.a(webView, i11, str, str2);
            c cVar = this.f37573a;
            if (cVar != null) {
                cVar.onError(str);
            }
            g.this.b();
            this.f37574b.setH5Ready(false);
            com.mbridge.msdk.splash.report.a.a(2, "error code:" + i11 + str, this.f37576d, this.f37575c);
            com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f37575c, this.f37576d, "error code:" + i11 + str, this.f37577e, 3);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.a(webView, sslErrorHandler, sslError);
            c cVar = this.f37573a;
            if (cVar != null) {
                cVar.onError(sslError.toString());
            }
            g.this.b();
            this.f37574b.setH5Ready(false);
            com.mbridge.msdk.splash.report.a.a(2, "error url:" + sslError.getUrl(), this.f37576d, this.f37575c);
            com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f37575c, this.f37576d, "error url:" + sslError.getUrl(), this.f37577e, 3);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            super.a(webView, str);
            c cVar = this.f37573a;
            if (cVar != null) {
                cVar.a();
            }
            g.this.f37572b = true;
            if (!this.f37575c.isHasMBTplMark()) {
                this.f37574b.setH5Ready(true);
                com.mbridge.msdk.splash.report.a.a(1, "", this.f37576d, this.f37575c);
                com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f37575c, this.f37576d, "", this.f37577e, 1);
            }
            com.mbridge.msdk.splash.signal.c.a(webView);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final g f37579a = new g(null);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a();

        void a(int i11);

        void onError(String str);
    }

    /* loaded from: classes5.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private String f37580a;

        /* renamed from: b, reason: collision with root package name */
        private String f37581b;

        /* renamed from: c, reason: collision with root package name */
        private CampaignEx f37582c;

        /* renamed from: d, reason: collision with root package name */
        private String f37583d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f37584e;

        /* renamed from: f, reason: collision with root package name */
        private int f37585f;

        public CampaignEx a() {
            return this.f37582c;
        }

        public void a(int i11) {
            this.f37585f = i11;
        }

        public void a(CampaignEx campaignEx) {
            this.f37582c = campaignEx;
        }

        public void a(String str) {
            this.f37583d = str;
        }

        public void a(boolean z10) {
            this.f37584e = z10;
        }

        public int b() {
            return this.f37585f;
        }

        public void b(String str) {
            this.f37580a = str;
        }

        public String c() {
            return this.f37583d;
        }

        public void c(String str) {
            this.f37581b = str;
        }

        public String d() {
            return this.f37580a;
        }

        public String e() {
            return this.f37581b;
        }

        public boolean f() {
            return this.f37584e;
        }
    }

    private g() {
        this.f37571a = false;
        this.f37572b = false;
    }

    /* synthetic */ g(a aVar) {
        this();
    }

    public static g a() {
        return b.f37579a;
    }

    public void a(MBSplashView mBSplashView, d dVar, c cVar) {
        if (mBSplashView == null || dVar == null) {
            return;
        }
        String e11 = dVar.e();
        String d11 = dVar.d();
        CampaignEx a11 = dVar.a();
        String c11 = dVar.c();
        boolean f11 = dVar.f();
        int b11 = dVar.b();
        MBSplashWebview splashWebview = mBSplashView.getSplashWebview();
        if (splashWebview == null) {
            return;
        }
        com.mbridge.msdk.splash.signal.b bVar = new com.mbridge.msdk.splash.signal.b(mBSplashView.getContext(), d11, e11);
        ArrayList arrayList = new ArrayList();
        arrayList.add(a11);
        bVar.a(arrayList);
        bVar.a(f11 ? 1 : 0);
        bVar.b(b11);
        mBSplashView.setSplashSignalCommunicationImpl(bVar);
        String requestIdNotice = TextUtils.isEmpty(a11.getRequestId()) ? a11.getRequestIdNotice() : a11.getRequestId();
        String requestId = splashWebview.getRequestId();
        o0.b("WebViewRenderManager", "CampaignEx RequestId = " + requestIdNotice + " WebView RequestId = " + requestId);
        if (!TextUtils.isEmpty(requestId) && requestId.equals(requestIdNotice) && (this.f37571a || this.f37572b)) {
            mBSplashView.setH5Ready(true);
            if (cVar != null) {
                cVar.a(1);
                return;
            }
            return;
        }
        b();
        splashWebview.setRequestId(requestIdNotice);
        com.mbridge.msdk.splash.report.a.b(e11, a11);
        long currentTimeMillis = System.currentTimeMillis();
        splashWebview.setWebViewListener(new a(cVar, mBSplashView, a11, e11, currentTimeMillis));
        if (!splashWebview.isDestoryed()) {
            splashWebview.loadUrl(c11);
        } else {
            mBSplashView.setH5Ready(false);
            com.mbridge.msdk.splash.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), a11, e11, "webview had destory", currentTimeMillis, 3);
        }
    }

    public void b() {
        this.f37571a = false;
        this.f37572b = false;
    }
}
