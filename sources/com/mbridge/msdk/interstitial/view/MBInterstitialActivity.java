package com.mbridge.msdk.interstitial.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.mbridge.msdk.activity.MBBaseActivity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.y0;
import com.mbridge.msdk.interstitial.controller.a;
import com.mbridge.msdk.mbsignalcommon.mraid.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class MBInterstitialActivity extends MBBaseActivity implements com.mbridge.msdk.mbsignalcommon.mraid.b {
    public static final String INTENT_CAMAPIGN = "campaign";
    public static final String INTENT_UNIT_ID = "unitId";
    public static final long WATI_JS_INVOKE = 2000;
    public static final long WEB_LOAD_TIME = 15000;

    /* renamed from: h, reason: collision with root package name */
    private CampaignEx f36007h;

    /* renamed from: i, reason: collision with root package name */
    private WindVaneWebView f36008i;

    /* renamed from: j, reason: collision with root package name */
    private ImageView f36009j;

    /* renamed from: k, reason: collision with root package name */
    private a.d f36010k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f36011l;

    /* renamed from: m, reason: collision with root package name */
    private com.mbridge.msdk.mbsignalcommon.mraid.d f36012m;
    public ProgressBar mProgressBar;
    public String mUnitid;

    /* renamed from: n, reason: collision with root package name */
    private long f36013n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f36014o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f36015p;

    /* renamed from: t, reason: collision with root package name */
    private com.mbridge.msdk.click.a f36019t;

    /* renamed from: f, reason: collision with root package name */
    private boolean f36005f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f36006g = false;
    public boolean mIsMBPage = false;

    /* renamed from: q, reason: collision with root package name */
    private Handler f36016q = new f();

    /* renamed from: r, reason: collision with root package name */
    Runnable f36017r = new j();

    /* renamed from: s, reason: collision with root package name */
    Runnable f36018s = new k();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProgressBar progressBar = MBInterstitialActivity.this.mProgressBar;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProgressBar progressBar = MBInterstitialActivity.this.mProgressBar;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements NativeListener.NativeTrackingListener {
        c() {
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDismissLoading(Campaign campaign) {
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadFinish(Campaign campaign) {
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadProgress(int i11) {
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadStart(Campaign campaign) {
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            try {
                MBInterstitialActivity.this.hideLoading();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public boolean onInterceptDefaultLoadingDialog() {
            return false;
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            MBInterstitialActivity.this.hideLoading();
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onShowLoading(Campaign campaign) {
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            try {
                MBInterstitialActivity.this.showLoading();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(MBInterstitialActivity.this.f36008i, MBInterstitialActivity.this.f36008i.getLeft(), MBInterstitialActivity.this.f36008i.getTop(), MBInterstitialActivity.this.f36008i.getWidth(), MBInterstitialActivity.this.f36008i.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(MBInterstitialActivity.this.f36008i, MBInterstitialActivity.this.f36008i.getLeft(), MBInterstitialActivity.this.f36008i.getTop(), MBInterstitialActivity.this.f36008i.getWidth(), MBInterstitialActivity.this.f36008i.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(MBInterstitialActivity.this)).b(MBInterstitialActivity.this.f36007h.getId());
        }
    }

    /* loaded from: classes5.dex */
    class f extends Handler {
        f() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    /* loaded from: classes5.dex */
    class g implements com.mbridge.msdk.foundation.feedback.a {
        g() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            String str;
            MBInterstitialActivity.this.onPause();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                }
                str = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b("MBInterstitialActivity", th2.getMessage(), th2);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBInterstitialActivity.this.f36008i, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            String str2;
            MBInterstitialActivity.this.onResume();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                }
                str2 = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b("MBInterstitialActivity", th2.getMessage(), th2);
                str2 = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBInterstitialActivity.this.f36008i, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            String str;
            MBInterstitialActivity.this.onResume();
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b("MBInterstitialActivity", th2.getMessage(), th2);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBInterstitialActivity.this.f36008i, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBInterstitialActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class i extends com.mbridge.msdk.mbsignalcommon.listener.b {
        i() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i11) {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i11, String str, String str2) {
            try {
                MBInterstitialActivity.this.f36011l = true;
                if (MBInterstitialActivity.this.f36010k != null) {
                    MBInterstitialActivity.this.f36010k.a(str);
                }
                MBInterstitialActivity.this.a(3, str);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            MBInterstitialActivity.this.f36011l = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            try {
                if (MBInterstitialActivity.this.f36011l) {
                    return;
                }
                MBInterstitialActivity.this.a(1, "");
                MBInterstitialActivity mBInterstitialActivity = MBInterstitialActivity.this;
                if (mBInterstitialActivity.f36017r != null && mBInterstitialActivity.f36016q != null) {
                    MBInterstitialActivity.this.f36016q.removeCallbacks(MBInterstitialActivity.this.f36017r);
                }
                if (MBInterstitialActivity.this.f36010k != null) {
                    MBInterstitialActivity.this.f36010k.c();
                }
                MBInterstitialActivity mBInterstitialActivity2 = MBInterstitialActivity.this;
                if (!mBInterstitialActivity2.mIsMBPage) {
                    mBInterstitialActivity2.f36016q.postDelayed(MBInterstitialActivity.this.f36018s, 2000L);
                }
                MBInterstitialActivity.this.i();
            } catch (Exception e11) {
                e11.printStackTrace();
                if (MBInterstitialActivity.this.f36010k != null) {
                    MBInterstitialActivity.this.f36010k.a("load page failed");
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str, Bitmap bitmap) {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void b(WebView webView, int i11) {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public boolean b(WebView webView, String str) {
            return true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void c(WebView webView, int i11) {
        }
    }

    /* loaded from: classes5.dex */
    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBInterstitialActivity.this.f36006g) {
                return;
            }
            MBInterstitialActivity.this.f36005f = true;
            if (MBInterstitialActivity.this.f36010k != null) {
                MBInterstitialActivity.this.f36010k.a("load page timeout");
                if (MBInterstitialActivity.this.f36008i != null) {
                    MBInterstitialActivity.this.f36008i.setVisibility(8);
                    MBInterstitialActivity.this.f36008i.setWebViewListener(null);
                    MBInterstitialActivity.this.f36008i.release();
                }
                MBInterstitialActivity.this.hideLoading();
            }
        }
    }

    /* loaded from: classes5.dex */
    class k implements Runnable {
        k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MBInterstitialActivity mBInterstitialActivity = MBInterstitialActivity.this;
            if (mBInterstitialActivity.mIsMBPage) {
                return;
            }
            if (mBInterstitialActivity.f36007h != null && MBInterstitialActivity.this.f36007h.isMraid()) {
                MBInterstitialActivity.this.m();
            }
            com.mbridge.msdk.interstitial.cache.a.a().a(MBInterstitialActivity.this.f36007h, MBInterstitialActivity.this.mUnitid);
            if (MBInterstitialActivity.this.f36005f) {
                return;
            }
            MBInterstitialActivity.this.f36006g = true;
            MBInterstitialActivity.this.hideLoading();
            MBInterstitialActivity.this.showWebView();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class l implements d.b {
        l() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.d.b
        public void a(double d11) {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(MBInterstitialActivity.this.f36008i, d11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class m implements Runnable {
        m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (MBInterstitialActivity.this.f36008i == null || MBInterstitialActivity.this.f36007h == null) {
                    return;
                }
                MBInterstitialActivity.this.f36008i.setVisibility(0);
                if (MBInterstitialActivity.this.f36007h.isMraid()) {
                    MBInterstitialActivity.this.k();
                }
                MBInterstitialActivity.this.j();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MBInterstitialActivity.this.f36008i != null) {
                MBInterstitialActivity.this.f36008i.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i11, String str) {
        CampaignEx campaignEx = this.f36007h;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
        mVar.n(this.f36007h.getRequestId());
        mVar.o(this.f36007h.getRequestIdNotice());
        mVar.b(this.f36007h.getId());
        mVar.d(i11);
        mVar.e(String.valueOf(System.currentTimeMillis() - this.f36013n));
        mVar.g("");
        mVar.m(str);
        mVar.a("5");
        mVar.b(this.f36007h.isMraid() ? com.mbridge.msdk.foundation.entity.m.N : com.mbridge.msdk.foundation.entity.m.O);
        com.mbridge.msdk.foundation.same.report.g.b(mVar, this.mUnitid, this.f36007h);
    }

    private void a(String str) {
        CampaignEx mraidCampaign = getMraidCampaign();
        if (mraidCampaign != null) {
            new com.mbridge.msdk.foundation.same.report.h(getApplicationContext()).a(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.mUnitid, str, mraidCampaign.isBidCampaign());
        }
    }

    private void e() {
        g();
        n();
        f();
        h();
    }

    private void f() {
        try {
            if (com.mbridge.msdk.interstitial.controller.a.f35974r == null || TextUtils.isEmpty(this.mUnitid) || !com.mbridge.msdk.interstitial.controller.a.f35974r.containsKey(this.mUnitid)) {
                return;
            }
            this.f36010k = com.mbridge.msdk.interstitial.controller.a.f35974r.get(this.mUnitid);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void g() {
        Intent intent = getIntent();
        if (intent != null) {
            this.mUnitid = intent.getStringExtra("unitId");
            this.f36007h = (CampaignEx) intent.getSerializableExtra(INTENT_CAMAPIGN);
        }
        CampaignEx campaignEx = this.f36007h;
        if (campaignEx != null && campaignEx.isMraid()) {
            com.mbridge.msdk.mbsignalcommon.mraid.d dVar = new com.mbridge.msdk.mbsignalcommon.mraid.d(this);
            this.f36012m = dVar;
            dVar.c();
            this.f36012m.a(new l());
        }
        CampaignEx campaignEx2 = this.f36007h;
        if (campaignEx2 != null) {
            com.mbridge.msdk.click.c.a(this, campaignEx2.getMaitve(), this.f36007h.getMaitve_src());
        }
    }

    @SuppressLint({"NewApi"})
    private void h() {
        try {
            CampaignEx campaignEx = this.f36007h;
            if (campaignEx == null || (TextUtils.isEmpty(campaignEx.getHtmlUrl()) && !this.f36007h.isMraid())) {
                a.d dVar = this.f36010k;
                if (dVar != null) {
                    dVar.a("htmlurl is null");
                    return;
                }
                return;
            }
            o0.c("MBInterstitialActivity", "url:" + this.f36007h.getHtmlUrl());
            goneWebView();
            this.f36008i.setWebViewListener(new i());
            String htmlUrl = this.f36007h.getHtmlUrl();
            if (this.f36007h.isMraid()) {
                File file = new File(this.f36007h.getMraid());
                if (file.exists() && file.isFile() && file.canRead()) {
                    htmlUrl = "file:////" + this.f36007h.getMraid();
                }
            }
            this.f36013n = System.currentTimeMillis();
            this.f36008i.loadUrl(htmlUrl);
            this.f36016q.postDelayed(this.f36017r, WEB_LOAD_TIME);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        CampaignEx campaignEx = this.f36007h;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        int i11 = getResources().getConfiguration().orientation;
        String str = i11 != 0 ? i11 != 1 ? i11 != 2 ? "UNDEFINED" : TmcStartParams.KEY_LANDSCAPE : "portrait" : "undefined";
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orientation", str);
            jSONObject.put("locked", "true");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        float n11 = k0.n(this);
        float m11 = k0.m(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        float f11 = displayMetrics.widthPixels;
        float f12 = displayMetrics.heightPixels;
        HashMap hashMap = new HashMap();
        hashMap.put("placementType", "Interstitial");
        hashMap.put("state", "default");
        hashMap.put("viewable", "true");
        hashMap.put("currentAppOrientation", jSONObject);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.f36008i, n11, m11);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f36008i, f11, f12);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f36008i, hashMap);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f36008i, this.f36012m.a());
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f36008i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        CampaignEx campaignEx = this.f36007h;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        this.f36008i.post(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
            mVar.n(this.f36007h.getRequestId());
            mVar.o(this.f36007h.getRequestIdNotice());
            mVar.b(this.f36007h.getId());
            mVar.b(this.f36007h.isMraid() ? com.mbridge.msdk.foundation.entity.m.N : com.mbridge.msdk.foundation.entity.m.O);
            com.mbridge.msdk.foundation.same.report.g.d(mVar, getApplicationContext(), this.mUnitid);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void l() {
        com.mbridge.msdk.foundation.same.report.h hVar = new com.mbridge.msdk.foundation.same.report.h(getApplicationContext());
        CampaignEx campaignEx = this.f36007h;
        if (campaignEx != null) {
            hVar.b(campaignEx.getRequestId(), this.f36007h.getRequestIdNotice(), this.f36007h.getId(), this.mUnitid, com.mbridge.msdk.mbsignalcommon.mraid.c.b(this.f36007h.getId()), this.f36007h.isBidCampaign());
            com.mbridge.msdk.mbsignalcommon.mraid.c.a(this.f36007h.getId());
            this.f36014o = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        List<String> pv_urls;
        try {
            com.mbridge.msdk.foundation.controller.c.m().a(this);
            if (!TextUtils.isEmpty(this.f36007h.getImpressionURL())) {
                Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
                CampaignEx campaignEx = this.f36007h;
                com.mbridge.msdk.click.a.a(d11, campaignEx, this.mUnitid, campaignEx.getImpressionURL(), false, true, com.mbridge.msdk.click.retry.a.f34472m);
            }
            if (!TextUtils.isEmpty(this.f36007h.getOnlyImpressionURL())) {
                Context d12 = com.mbridge.msdk.foundation.controller.c.m().d();
                CampaignEx campaignEx2 = this.f36007h;
                com.mbridge.msdk.click.a.a(d12, campaignEx2, this.mUnitid, campaignEx2.getOnlyImpressionURL(), false, true, com.mbridge.msdk.click.retry.a.f34473n);
            }
            com.mbridge.msdk.foundation.same.buffer.b.a(this.mUnitid, this.f36007h, com.vungle.ads.internal.b.PLACEMENT_TYPE_INTERSTITIAL);
            e eVar = new e();
            if (com.mbridge.msdk.foundation.controller.d.a().e()) {
                com.mbridge.msdk.foundation.same.threadpool.a.b().execute(eVar);
            } else {
                eVar.run();
            }
            CampaignEx campaignEx3 = this.f36007h;
            if (campaignEx3 == null || (pv_urls = campaignEx3.getPv_urls()) == null || pv_urls.size() <= 0) {
                return;
            }
            Iterator<String> it = pv_urls.iterator();
            while (it.hasNext()) {
                com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f36007h, this.mUnitid, it.next(), false, true);
            }
        } catch (Throwable th2) {
            o0.a("MBInterstitialActivity", th2.getMessage());
        }
    }

    private void n() {
        CampaignEx campaignEx;
        this.f36009j.setOnClickListener(new h());
        if (this.f36008i == null || (campaignEx = this.f36007h) == null) {
            return;
        }
        com.mbridge.msdk.foundation.same.webview.a aVar = new com.mbridge.msdk.foundation.same.webview.a(campaignEx);
        aVar.a(this.f36007h.getAppName());
        this.f36008i.setCampaignId(this.f36007h.getId());
        this.f36008i.setDownloadListener(aVar);
    }

    public void clickTracking() {
        try {
            if (this.f36007h != null && !y0.a(this.mUnitid)) {
                onIntersClick();
                com.mbridge.msdk.click.a aVar = new com.mbridge.msdk.click.a(getApplicationContext(), this.mUnitid);
                this.f36019t = aVar;
                aVar.a(new c());
                this.f36019t.a(this.f36007h);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void close() {
        finish();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void expand(String str, boolean z10) {
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (!this.f36014o) {
            l();
        }
        if (this.f36015p) {
            return;
        }
        reportPlayableClosed();
    }

    public com.mbridge.msdk.setting.l getIntersUnitSetting() {
        try {
            if (TextUtils.isEmpty(this.mUnitid)) {
                return null;
            }
            com.mbridge.msdk.setting.l e11 = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), this.mUnitid);
            return e11 == null ? com.mbridge.msdk.setting.l.h(this.mUnitid) : e11;
        } catch (Exception e12) {
            e12.printStackTrace();
            return null;
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public CampaignEx getMraidCampaign() {
        return this.f36007h;
    }

    public void goneWebView() {
        try {
            runOnUiThread(new n());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void hideLoading() {
        try {
            runOnUiThread(new b());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void initView() {
        this.f36008i = (WindVaneWebView) findViewById(g0.a(getApplicationContext(), "mbridge_interstitial_wv", "id"));
        this.mProgressBar = (ProgressBar) findViewById(g0.a(getApplicationContext(), "mbridge_interstitial_pb", "id"));
        this.f36009j = (ImageView) findViewById(g0.a(getApplicationContext(), "mbridge_interstitial_iv_close", "id"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            int a11 = g0.a(getApplicationContext(), "mbridge_interstitial_activity", TtmlNode.TAG_LAYOUT);
            if (!g0.a(a11)) {
                g();
                f();
                a.d dVar = this.f36010k;
                if (dVar != null) {
                    dVar.a("not found resource");
                }
                finish();
                return;
            }
            setContentView(a11);
            initView();
            e();
            com.mbridge.msdk.foundation.controller.c.m().a(this);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.mUnitid, this, (ViewGroup) null, (ViewGroup.LayoutParams) null, new g());
            this.f36007h.setCampaignUnitId(this.mUnitid);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.mUnitid, this.f36007h);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            a.d dVar = this.f36010k;
            if (dVar != null) {
                dVar.b();
            }
            com.mbridge.msdk.click.a aVar = this.f36019t;
            if (aVar != null) {
                aVar.a(false);
                this.f36019t.a((NativeListener.NativeTrackingListener) null);
                this.f36019t.c();
            }
            com.mbridge.msdk.mbsignalcommon.mraid.d dVar2 = this.f36012m;
            if (dVar2 != null) {
                dVar2.d();
            }
            if (!this.f36014o) {
                l();
            }
            if (com.mbridge.msdk.interstitial.controller.a.f35974r != null && !TextUtils.isEmpty(this.mUnitid)) {
                com.mbridge.msdk.interstitial.controller.a.f35974r.remove(this.mUnitid);
            }
            this.f36010k = null;
            com.mbridge.msdk.foundation.feedback.b.b().d(this.mUnitid);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void onIntersClick() {
        try {
            a.d dVar = this.f36010k;
            if (dVar != null) {
                dVar.a();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        CampaignEx campaignEx = this.f36007h;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(this.f36008i, "false");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.activity.MBBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        CampaignEx campaignEx = this.f36007h;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(this.f36008i, "true");
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void open(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f36007h.setClickURL(str);
            a(str);
        }
        this.f36007h.setClickTempSource(2);
        this.f36007h.setClickType(2);
        this.f36007h.setTriggerClickSource(2);
        clickTracking();
    }

    public void reportPlayableClosed() {
        if (this.f36007h != null) {
            com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m("2000061", this.f36007h.getId(), this.f36007h.getRequestId(), this.f36007h.getRequestIdNotice(), this.mUnitid, k0.s(com.mbridge.msdk.foundation.controller.c.m().d()));
            mVar.b(this.f36007h.isMraid() ? com.mbridge.msdk.foundation.entity.m.N : com.mbridge.msdk.foundation.entity.m.O);
            com.mbridge.msdk.foundation.same.report.g.b(mVar, com.mbridge.msdk.foundation.controller.c.m().d(), this.mUnitid);
            this.f36015p = true;
        }
    }

    @Override // com.mbridge.msdk.activity.MBBaseActivity
    public void setTopControllerPadding(int i11, int i12, int i13, int i14, int i15) {
        int a11 = t0.a(this, 10.0f);
        if (i12 <= 0) {
            i12 = a11;
        }
        if (i13 <= 0) {
            i13 = a11;
        }
        if (i14 <= 0) {
            i14 = a11;
        }
        if (i15 <= 0) {
            i15 = a11;
        }
        if (this.f36009j != null) {
            int a12 = t0.a(this, 25.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a12, a12);
            layoutParams.addRule(11);
            layoutParams.setMargins(i12, i14, i13, i15);
            this.f36009j.setLayoutParams(layoutParams);
        }
    }

    public void showLoading() {
        try {
            runOnUiThread(new a());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void showWebView() {
        runOnUiThread(new m());
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void unload() {
        close();
    }

    @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
    public void useCustomClose(boolean z10) {
        if (z10) {
            this.f36009j.setImageDrawable(new ColorDrawable(0));
        } else {
            this.f36009j.setImageResource(g0.a(getApplicationContext(), "mbridge_interstitial_close", "drawable"));
        }
    }
}
