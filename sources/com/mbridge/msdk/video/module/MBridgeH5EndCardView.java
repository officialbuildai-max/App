package com.mbridge.msdk.video.module;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.y0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.Campaign;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class MBridgeH5EndCardView extends MBridgeH5EndCardViewDiff {
    private int A;
    private long B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private String K;
    Handler L;
    private boolean M;
    private boolean N;
    boolean O;

    /* renamed from: m, reason: collision with root package name */
    protected View f39327m;

    /* renamed from: n, reason: collision with root package name */
    protected RelativeLayout f39328n;

    /* renamed from: o, reason: collision with root package name */
    protected ImageView f39329o;

    /* renamed from: p, reason: collision with root package name */
    protected WindVaneWebView f39330p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f39331q;

    /* renamed from: r, reason: collision with root package name */
    protected Handler f39332r;

    /* renamed from: s, reason: collision with root package name */
    protected String f39333s;

    /* renamed from: t, reason: collision with root package name */
    protected boolean f39334t;

    /* renamed from: u, reason: collision with root package name */
    protected boolean f39335u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f39336v;

    /* renamed from: w, reason: collision with root package name */
    private int f39337w;

    /* renamed from: x, reason: collision with root package name */
    private int f39338x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f39339y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f39340z;

    /* loaded from: classes5.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 100) {
                return;
            }
            if (MBridgeH5EndCardView.this.C) {
                MBridgeH5EndCardView.this.notifyListener.a(Sdk$SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE, "");
            }
            MBridgeH5EndCardView.this.notifyListener.a(103, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MBridgeH5EndCardView.this.onCloseViewClick();
        }
    }

    /* loaded from: classes5.dex */
    class c extends com.mbridge.msdk.mbsignalcommon.listener.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f39343a;

        c(boolean z10) {
            this.f39343a = z10;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView) {
            super.a(webView);
            MBridgeH5EndCardView.this.setCloseVisible(0);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i11) {
            super.a(webView, i11);
            o0.c("WindVaneWebView", "h5EncardView readyStatus:" + i11 + "- isError" + MBridgeH5EndCardView.this.f39335u);
            MBridgeH5EndCardView.this.A = i11;
            if (!MBridgeH5EndCardView.this.f39335u) {
                MBridgeH5EndCardView.this.a(System.currentTimeMillis() - MBridgeH5EndCardView.this.B, false);
            }
            if (this.f39343a) {
                try {
                    com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                    eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 3);
                    eVar.a("result", Integer.valueOf(i11));
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000155", MBridgeH5EndCardView.this.f39280b, eVar);
                } catch (Throwable th2) {
                    o0.b("WindVaneWebView", th2.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i11, String str, String str2) {
            super.a(webView, i11, str, str2);
            MBridgeH5EndCardView mBridgeH5EndCardView = MBridgeH5EndCardView.this;
            if (mBridgeH5EndCardView.f39335u) {
                return;
            }
            mBridgeH5EndCardView.notifyListener.a(Sdk$SDKError.Reason.PROTOBUF_SERIALIZATION_ERROR_VALUE, "onReceivedError " + i11 + str);
            MBridgeH5EndCardView.this.reportRenderResult(str, 3);
            MBridgeH5EndCardView.this.notifyListener.a(127, "");
            MBridgeH5EndCardView.this.notifyListener.a(129, "");
            MBridgeH5EndCardView.this.f39335u = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            super.a(webView, str);
            MBridgeH5EndCardView mBridgeH5EndCardView = MBridgeH5EndCardView.this;
            if (mBridgeH5EndCardView.f39335u) {
                return;
            }
            mBridgeH5EndCardView.f39334t = true;
            mBridgeH5EndCardView.notifyListener.a(100, "");
            if (MBridgeH5EndCardView.this.f39280b != null) {
                m mVar = new m();
                mVar.n(MBridgeH5EndCardView.this.f39280b.getRequestId());
                mVar.o(MBridgeH5EndCardView.this.f39280b.getRequestIdNotice());
                mVar.b(MBridgeH5EndCardView.this.f39280b.getId());
                mVar.d(1);
                mVar.e(String.valueOf(System.currentTimeMillis() - MBridgeH5EndCardView.this.B));
                mVar.m("onPageFinished");
                String str2 = "2";
                if (MBridgeH5EndCardView.this.f39280b.getAdType() == 287) {
                    mVar.a("3");
                } else if (MBridgeH5EndCardView.this.f39280b.getAdType() == 94) {
                    mVar.a("1");
                } else if (MBridgeH5EndCardView.this.f39280b.getAdType() == 42) {
                    mVar.a("2");
                }
                if (MBridgeH5EndCardView.this.f39280b.isMraid()) {
                    mVar.b(m.N);
                } else {
                    mVar.g(MBridgeH5EndCardView.this.f39280b.getendcard_url());
                    if (y0.b(MBridgeH5EndCardView.this.f39280b.getendcard_url()) && MBridgeH5EndCardView.this.f39280b.getendcard_url().contains(".zip")) {
                        str2 = "1";
                    }
                    mVar.f(str2);
                    mVar.b(m.O);
                }
                MBridgeH5EndCardView mBridgeH5EndCardView2 = MBridgeH5EndCardView.this;
                com.mbridge.msdk.foundation.same.report.g.b(mVar, mBridgeH5EndCardView2.unitId, mBridgeH5EndCardView2.f39280b);
            }
            MBridgeH5EndCardView.this.notifyListener.a(120, "");
            if (this.f39343a) {
                return;
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 3);
                eVar.a("result", 1);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000155", MBridgeH5EndCardView.this.f39280b, eVar);
            } catch (Throwable th2) {
                o0.b("WindVaneWebView", th2.getMessage());
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void b(WebView webView, int i11) {
            super.b(webView, i11);
            MBridgeH5EndCardView.this.A = i11;
            if (MBridgeH5EndCardView.this.f39340z) {
                return;
            }
            MBridgeH5EndCardView.this.f39340z = true;
            if (i11 == 1) {
                MBridgeH5EndCardView.this.reportRenderResult(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, 4);
            } else {
                MBridgeH5EndCardView.this.notifyListener.a(127, "");
                MBridgeH5EndCardView.this.reportRenderResult("failed", 6);
            }
        }
    }

    /* loaded from: classes5.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            try {
                o0.a(MBridgeBaseView.TAG, "webviewshow");
                try {
                    int[] iArr = new int[2];
                    MBridgeH5EndCardView.this.f39330p.getLocationOnScreen(iArr);
                    o0.b(MBridgeBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                    JSONObject jSONObject = new JSONObject();
                    Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
                    if (d11 != null) {
                        jSONObject.put("startX", t0.b(d11, iArr[0]));
                        jSONObject.put("startY", t0.b(d11, iArr[1]));
                        jSONObject.put(com.mbridge.msdk.foundation.same.a.f35394l, t0.d(d11));
                    }
                    str = jSONObject.toString();
                } catch (Throwable th2) {
                    o0.b(MBridgeBaseView.TAG, th2.getMessage(), th2);
                    str = "";
                }
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeH5EndCardView.this.f39330p, "webviewshow", Base64.encodeToString(str.toString().getBytes(), 2));
                MBridgeH5EndCardView.this.notifyListener.a(109, "");
                MBridgeH5EndCardView.this.i();
                MBridgeH5EndCardView.this.startCounterEndCardShowTimer();
                com.mbridge.msdk.mbsignalcommon.windvane.f a11 = com.mbridge.msdk.mbsignalcommon.windvane.f.a();
                MBridgeH5EndCardView mBridgeH5EndCardView = MBridgeH5EndCardView.this;
                a11.a((WebView) mBridgeH5EndCardView.f39330p, "oncutoutfetched", Base64.encodeToString(mBridgeH5EndCardView.K.getBytes(), 0));
                MBridgeH5EndCardView.this.e();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements com.mbridge.msdk.foundation.feedback.a {
        e() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 1);
                }
                str = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b(MBridgeBaseView.TAG, th2.getMessage(), th2);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeH5EndCardView.this.f39330p, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            String str2;
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                }
                str2 = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b(MBridgeBaseView.TAG, th2.getMessage(), th2);
                str2 = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeH5EndCardView.this.f39330p, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th2) {
                o0.b(MBridgeBaseView.TAG, th2.getMessage(), th2);
                str = "";
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) MBridgeH5EndCardView.this.f39330p, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private MBridgeH5EndCardView f39347a;

        public f(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f39347a = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Handler handler;
            try {
                Thread.sleep(300L);
            } catch (InterruptedException e11) {
                o0.b("CloseRunnable", e11.getMessage());
            }
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f39347a;
            if (mBridgeH5EndCardView == null || (handler = mBridgeH5EndCardView.L) == null) {
                return;
            }
            handler.sendEmptyMessage(100);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private MBridgeH5EndCardView f39349a;

        public g(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f39349a = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f39349a;
            if (mBridgeH5EndCardView == null || mBridgeH5EndCardView.f39340z) {
                return;
            }
            this.f39349a.f39340z = true;
            this.f39349a.f39334t = false;
            MBridgeH5EndCardView.this.reportRenderResult("timeout", 5);
            this.f39349a.notifyListener.a(127, "");
            o0.a(MBridgeBaseView.TAG, "notify TYPE_NOTIFY_SHOW_NATIVE_ENDCARD");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private MBridgeH5EndCardView f39351a;

        /* renamed from: b, reason: collision with root package name */
        private int f39352b;

        public h(MBridgeH5EndCardView mBridgeH5EndCardView, int i11) {
            this.f39351a = mBridgeH5EndCardView;
            this.f39352b = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f39351a;
            if (mBridgeH5EndCardView == null || mBridgeH5EndCardView.f39280b == null) {
                return;
            }
            try {
                if (mBridgeH5EndCardView.f39339y) {
                    o0.c(MBridgeBaseView.TAG, "insertEndCardReadyState hasInsertLoadEndCardReport true return");
                    return;
                }
                this.f39351a.f39339y = true;
                m mVar = new m("m_download_end", 12, (this.f39352b * 1000) + "", this.f39351a.f39280b.getendcard_url(), this.f39351a.f39280b.getId(), this.f39351a.unitId, "ready timeout", (y0.b(this.f39351a.f39280b.getendcard_url()) && this.f39351a.f39280b.getendcard_url().contains(".zip")) ? "1" : "2");
                try {
                    if (this.f39351a.f39280b.getAdType() == 287) {
                        mVar.a("3");
                    } else if (this.f39351a.f39280b.getAdType() == 94) {
                        mVar.a("1");
                    } else if (this.f39351a.f39280b.getAdType() == 42) {
                        mVar.a("2");
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                mVar.n(this.f39351a.f39280b.getRequestId());
                mVar.k(this.f39351a.f39280b.getCurrentLocalRid());
                mVar.o(this.f39351a.f39280b.getRequestIdNotice());
                mVar.a(this.f39351a.f39280b.getAdSpaceT());
                this.f39351a.isLoadSuccess();
            } catch (Throwable th2) {
                o0.b(MBridgeBaseView.TAG, th2.getMessage(), th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private MBridgeH5EndCardView f39353a;

        public i(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f39353a = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f39353a;
            if (mBridgeH5EndCardView != null) {
                mBridgeH5EndCardView.G = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private MBridgeH5EndCardView f39355a;

        public j(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f39355a = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f39355a;
            if (mBridgeH5EndCardView != null) {
                mBridgeH5EndCardView.H = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class k implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private MBridgeH5EndCardView f39357a;

        public k(MBridgeH5EndCardView mBridgeH5EndCardView) {
            this.f39357a = mBridgeH5EndCardView;
        }

        @Override // java.lang.Runnable
        public void run() {
            MBridgeH5EndCardView mBridgeH5EndCardView = this.f39357a;
            if (mBridgeH5EndCardView != null) {
                if (!mBridgeH5EndCardView.I) {
                    MBridgeH5EndCardView.this.setCloseVisible(0);
                }
                this.f39357a.D = true;
            }
        }
    }

    public MBridgeH5EndCardView(Context context) {
        super(context);
        this.f39331q = false;
        this.f39332r = new Handler();
        this.f39334t = false;
        this.f39335u = false;
        this.f39336v = false;
        this.f39337w = 1;
        this.f39338x = 1;
        this.f39339y = false;
        this.f39340z = false;
        this.A = 1;
        this.B = 0L;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = "";
        this.L = new a(Looper.getMainLooper());
        this.M = false;
        this.N = false;
        this.O = false;
    }

    public MBridgeH5EndCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39331q = false;
        this.f39332r = new Handler();
        this.f39334t = false;
        this.f39335u = false;
        this.f39336v = false;
        this.f39337w = 1;
        this.f39338x = 1;
        this.f39339y = false;
        this.f39340z = false;
        this.A = 1;
        this.B = 0L;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = "";
        this.L = new a(Looper.getMainLooper());
        this.M = false;
        this.N = false;
        this.O = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(13:7|8|(1:50)(1:12)|13|(1:15)(2:46|(1:48)(8:49|17|18|19|(1:21)(2:37|(1:39)(2:40|(1:42)))|22|23|(1:34)(4:27|(1:29)(1:33)|30|32)))|16|17|18|19|(0)(0)|22|23|(2:25|34)(1:35)) */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ac, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0088 A[Catch: all -> 0x002a, NullPointerException -> 0x008e, TryCatch #0 {NullPointerException -> 0x008e, blocks: (B:19:0x007e, B:21:0x0088, B:37:0x0090, B:39:0x009a, B:40:0x009e, B:42:0x00a8), top: B:18:0x007e, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0090 A[Catch: all -> 0x002a, NullPointerException -> 0x008e, TryCatch #0 {NullPointerException -> 0x008e, blocks: (B:19:0x007e, B:21:0x0088, B:37:0x0090, B:39:0x009a, B:40:0x009e, B:42:0x00a8), top: B:18:0x007e, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(long r18, boolean r20) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.module.MBridgeH5EndCardView.a(long, boolean):void");
    }

    private static void a(m mVar, CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.videocommon.setting.c c11 = com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), campaignEx.getCampaignUnitId());
            if (c11 != null) {
                mVar.s(c11.x());
            }
            com.mbridge.msdk.videocommon.setting.a c12 = com.mbridge.msdk.videocommon.setting.b.b().c();
            if (c12 != null) {
                mVar.r(c12.f());
            }
        } catch (Exception e11) {
            o0.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    private boolean a(View view) {
        this.f39329o = (ImageView) view.findViewById(findID("mbridge_windwv_close"));
        this.f39328n = (RelativeLayout) view.findViewById(findID("mbridge_windwv_content_rl"));
        WindVaneWebView windVaneWebView = new WindVaneWebView(getContext());
        this.f39330p = windVaneWebView;
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx != null) {
            windVaneWebView.setLocalRequestId(campaignEx.getCurrentLocalRid());
        }
        this.f39330p.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f39328n.addView(this.f39330p);
        return isNotNULL(this.f39329o, this.f39330p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            CampaignEx campaignEx = this.f39280b;
            if (campaignEx != null) {
                campaignEx.setCampaignUnitId(this.unitId);
                com.mbridge.msdk.foundation.feedback.b.b().d(this.unitId + "_1");
                com.mbridge.msdk.foundation.feedback.b.b().a(this.unitId + "_2", this.f39280b);
            }
            CampaignEx campaignEx2 = this.f39280b;
            if (campaignEx2 == null || !campaignEx2.isMraid()) {
                return;
            }
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().d());
            imageView.setBackgroundResource(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_notice", "drawable"));
            ImageView imageView2 = this.f39329o;
            RelativeLayout.LayoutParams layoutParams = imageView2 != null ? (RelativeLayout.LayoutParams) imageView2.getLayoutParams() : null;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 12.0f), t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 12.0f));
            layoutParams2.addRule(9);
            layoutParams2.addRule(10);
            if (layoutParams != null) {
                layoutParams2.leftMargin = layoutParams.rightMargin;
                layoutParams2.topMargin = layoutParams.topMargin;
                layoutParams2.width = layoutParams.width;
                layoutParams2.height = layoutParams.height;
            } else {
                layoutParams2.leftMargin = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 12.0f);
                layoutParams2.topMargin = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 12.0f);
            }
            addView(imageView, layoutParams2);
            t0.a(4, imageView, this.f39280b, com.mbridge.msdk.foundation.controller.c.m().d(), false, new e());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void f() {
        if (this.M || this.E) {
            return;
        }
        this.M = true;
        int i11 = this.f39337w;
        if (i11 == 0) {
            this.G = true;
            return;
        }
        this.G = false;
        if (i11 > -1) {
            this.f39332r.postDelayed(new i(this), this.f39337w * 1000);
        }
    }

    private void g() {
        if (this.N || this.E) {
            return;
        }
        this.N = true;
        int i11 = this.f39338x;
        if (i11 == 0) {
            this.H = true;
            return;
        }
        this.H = false;
        if (i11 > -1) {
            this.f39332r.postDelayed(new j(this), this.f39338x * 1000);
        }
    }

    private void h() {
        int v11;
        try {
            this.B = System.currentTimeMillis();
            String str = this.f39280b.getendcard_url();
            com.mbridge.msdk.videocommon.setting.c c11 = com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), this.unitId);
            if (this.f39336v && y0.b(str)) {
                if (!str.contains("wfr=1") && (c11 == null || c11.v() <= 0)) {
                    return;
                }
                if (str.contains("wfr=1")) {
                    String[] split = str.split(UrlUtils.AND_MARK);
                    if (split != null && split.length > 0) {
                        for (String str2 : split) {
                            if (y0.b(str2) && str2.contains("to") && str2.split(UrlUtils.EQUAL_MARK) != null && str2.split(UrlUtils.EQUAL_MARK).length > 0) {
                                v11 = t0.a((Object) str2.split(UrlUtils.EQUAL_MARK)[1]);
                                break;
                            }
                        }
                    }
                    v11 = 20;
                } else {
                    if (c11 != null && c11.v() > 0) {
                        v11 = c11.v();
                    }
                    v11 = 20;
                }
                if (v11 >= 0) {
                    excuteEndCardShowTask(v11);
                } else {
                    excuteEndCardShowTask(20);
                }
            }
        } catch (Throwable th2) {
            o0.b(MBridgeBaseView.TAG, th2.getMessage(), th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        int i11 = getResources().getConfiguration().orientation;
        String str = "undefined";
        if (i11 != 0) {
            if (i11 == 1) {
                str = "portrait";
            } else if (i11 == 2) {
                str = TmcStartParams.KEY_LANDSCAPE;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("orientation", str);
            jSONObject.put("locked", "true");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("placementType", "Interstitial");
        hashMap.put("state", "default");
        hashMap.put("viewable", "true");
        hashMap.put("currentAppOrientation", jSONObject);
        if (getContext() instanceof Activity) {
            float n11 = k0.n(getContext());
            float m11 = k0.m(getContext());
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            float f11 = displayMetrics.widthPixels;
            float f12 = displayMetrics.heightPixels;
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.f39330p, n11, m11);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f39330p, f11, f12);
        }
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.f39330p, r7.getLeft(), this.f39330p.getTop(), this.f39330p.getWidth(), this.f39330p.getHeight());
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f39330p, r13.getLeft(), this.f39330p.getTop(), this.f39330p.getWidth(), this.f39330p.getHeight());
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f39330p, hashMap);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f39330p, com.mbridge.msdk.mbsignalcommon.mraid.d.f36562f);
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f39330p);
    }

    public boolean canBackPress() {
        ImageView imageView = this.f39329o;
        return imageView != null && imageView.getVisibility() == 0;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.mbsignalcommon.mraid.b
    public void close() {
        try {
            onCloseViewClick();
        } catch (Exception e11) {
            o0.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void d() {
        super.d();
        if (this.f39283e) {
            this.f39329o.setOnClickListener(new b());
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void defaultShow() {
        super.defaultShow();
    }

    public void excuteEndCardShowTask(int i11) {
        this.f39332r.postDelayed(new h(this, i11), i11 * 1000);
    }

    public void excuteTask() {
        if (this.f39336v || this.f39337w <= -1) {
            return;
        }
        this.f39332r.postDelayed(new k(this), this.f39337w * 1000);
    }

    public void executeEndCardShow(int i11) {
        this.f39332r.postDelayed(new g(this), i11 * 1000);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.mbsignalcommon.mraid.b
    public void expand(String str, boolean z10) {
    }

    protected RelativeLayout.LayoutParams getContentLayoutParams() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.mbsignalcommon.mraid.b
    public CampaignEx getMraidCampaign() {
        return this.f39280b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getURL() {
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null) {
            this.C = false;
            return null;
        }
        this.C = true;
        if (campaignEx.isMraid()) {
            this.f39336v = false;
            String mraid = this.f39280b.getMraid();
            if (TextUtils.isEmpty(mraid)) {
                return this.f39280b.getEndScreenUrl();
            }
            File file = new File(mraid);
            try {
                if (file.exists() && file.isFile() && file.canRead()) {
                    mraid = "file:////" + mraid;
                } else {
                    mraid = this.f39280b.getEndScreenUrl();
                }
                return mraid;
            } catch (Throwable th2) {
                if (!MBridgeConstans.DEBUG) {
                    return mraid;
                }
                th2.printStackTrace();
                return mraid;
            }
        }
        String str = this.f39280b.getendcard_url();
        if (y0.a(str)) {
            this.f39336v = false;
            return this.f39280b.getEndScreenUrl();
        }
        this.f39336v = true;
        String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(str);
        if (!TextUtils.isEmpty(h5ResAddress)) {
            return h5ResAddress + "&native_adtype=" + this.f39280b.getAdType();
        }
        try {
            String path = Uri.parse(str).getPath();
            if (!TextUtils.isEmpty(path) && path.toLowerCase().endsWith(".zip")) {
                String endScreenUrl = this.f39280b.getEndScreenUrl();
                if (TextUtils.isEmpty(endScreenUrl)) {
                    return null;
                }
                this.f39336v = false;
                excuteTask();
                return endScreenUrl;
            }
        } catch (Throwable th3) {
            o0.b(MBridgeBaseView.TAG, th3.getMessage());
        }
        return str + "&native_adtype=" + this.f39280b.getAdType();
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void handlerPlayableException(String str) {
        if (this.f39335u) {
            return;
        }
        this.f39335u = true;
        this.f39334t = false;
        if (this.f39280b != null) {
            m mVar = new m();
            mVar.n(this.f39280b.getRequestId());
            mVar.o(this.f39280b.getRequestIdNotice());
            mVar.b(this.f39280b.getId());
            mVar.m(str);
            com.mbridge.msdk.foundation.same.report.g.a(mVar, this.f39279a.getApplicationContext(), this.unitId);
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_endcard_h5");
        if (g0.a(findLayout)) {
            View inflate = this.f39281c.inflate(findLayout, (ViewGroup) null);
            this.f39327m = inflate;
            try {
                this.f39283e = a(inflate);
            } catch (Exception unused) {
                this.f39283e = false;
            }
            addView(this.f39327m, getContentLayoutParams());
            d();
            j();
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void install(CampaignEx campaignEx) {
    }

    public boolean isLoadSuccess() {
        return this.f39334t;
    }

    public boolean isPlayable() {
        return this.f39336v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        if (this.f39283e) {
            setMatchParent();
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.video.signal.h
    public void notifyCloseBtn(int i11) {
        if (i11 == 0) {
            this.E = true;
        } else {
            if (i11 != 1) {
                return;
            }
            this.F = true;
        }
    }

    public void onBackPress() {
        boolean z10;
        if (this.D || (((z10 = this.E) && this.F) || (!(z10 || !this.G || this.O) || (!z10 && this.H && this.O)))) {
            onCloseViewClick();
        }
    }

    public void onCloseViewClick() {
        try {
            if (this.f39330p != null) {
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.f39330p, "onSystemDestory", "");
                new Thread(new f(this)).start();
            } else {
                this.notifyListener.a(103, "");
                this.notifyListener.a(Sdk$SDKError.Reason.JSON_ENCODE_ERROR_VALUE, "webview is null when closing webview");
            }
        } catch (Exception e11) {
            this.notifyListener.a(103, "");
            this.notifyListener.a(Sdk$SDKError.Reason.JSON_ENCODE_ERROR_VALUE, "close webview exception" + e11.getMessage());
            o0.a(MBridgeBaseView.TAG, e11.getMessage());
        }
        try {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 2);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000152", eVar);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000134", this.f39280b);
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                th2.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onFinishRedirection(Campaign campaign, String str) {
        if (campaign == null) {
            return;
        }
        s0.a(campaign, this);
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onRedirectionFailed(Campaign campaign, String str) {
        if (campaign == null) {
            return;
        }
        s0.a(campaign, this);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeBaseView
    public void onSelfConfigurationChanged(Configuration configuration) {
        super.onSelfConfigurationChanged(configuration);
        orientation(configuration);
    }

    @Override // com.mbridge.msdk.out.BaseTrackingListener
    public void onStartRedirection(Campaign campaign, String str) {
        s0.b(campaign, this);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (i11 != 0 || this.J) {
            return;
        }
        this.J = true;
        setFocusableInTouchMode(true);
        requestFocus();
        requestFocusFromTouch();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null || !campaignEx.isMraid()) {
            return;
        }
        if (z10) {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(this.f39330p, "true");
        } else {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(this.f39330p, "false");
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.mbsignalcommon.mraid.b
    public void open(String str) {
        super.open(str);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void orientation(Configuration configuration) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (configuration.orientation == 2) {
                jSONObject.put("orientation", TmcStartParams.KEY_LANDSCAPE);
            } else {
                jSONObject.put("orientation", "portrait");
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.f39330p, "orientation", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void preLoadData(com.mbridge.msdk.video.signal.factory.b bVar) {
        String url = getURL();
        if (!this.f39283e || this.f39280b == null || TextUtils.isEmpty(url) || this.f39330p == null) {
            reportRenderResult("PL URL IS NULL", 3);
            this.notifyListener.a(127, "");
            this.notifyListener.a(129, "");
        } else {
            this.B = System.currentTimeMillis();
            try {
                reportRenderResult("start", 0);
            } catch (Exception unused) {
            }
            com.mbridge.msdk.foundation.same.webview.a aVar = new com.mbridge.msdk.foundation.same.webview.a(this.f39280b);
            aVar.a(this.f39280b.getAppName());
            this.f39330p.setDownloadListener(aVar);
            this.f39330p.setCampaignId(this.f39280b.getId());
            this.f39330p.setTempTypeForMetrics(3);
            CampaignEx campaignEx = this.f39280b;
            if (campaignEx != null) {
                this.f39330p.setCampaignEx(campaignEx);
            }
            setCloseVisible(8);
            this.f39330p.setApiManagerJSFactory(bVar);
            if (this.f39280b.isMraid()) {
                this.f39330p.setMraidObject(this);
            }
            this.f39330p.setWebViewListener(new c(url.contains("wfr=1") || url.contains("wfl=1")));
            if (TextUtils.isEmpty(this.f39280b.getMraid())) {
                h();
            }
            setHtmlSource(HTMLResourceManager.getInstance().getHtmlContentFromUrl(url));
            if (TextUtils.isEmpty(this.f39333s)) {
                this.f39330p.loadUrl(url);
            } else {
                this.f39330p.loadDataWithBaseURL(url, this.f39333s, "text/html", "UTF-8", null);
            }
        }
        this.O = false;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void readyStatus(int i11) {
    }

    public void release() {
        Handler handler = this.f39332r;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f39332r = null;
        }
        Handler handler2 = this.L;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.L = null;
        }
        this.f39328n.removeAllViews();
        this.f39330p.release();
        this.f39330p = null;
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void reportOpen(String str) {
        CampaignEx mraidCampaign = getMraidCampaign();
        if (mraidCampaign != null) {
            new com.mbridge.msdk.foundation.same.report.h(getContext()).a(mraidCampaign.getRequestId(), mraidCampaign.getRequestIdNotice(), mraidCampaign.getId(), this.unitId, str, this.f39280b.isBidCampaign());
        }
    }

    public void reportRenderResult(String str, int i11) {
        if (this.f39280b == null || this.f39335u) {
            return;
        }
        m mVar = new m();
        mVar.n(this.f39280b.getRequestId());
        mVar.o(this.f39280b.getRequestIdNotice());
        mVar.b(this.f39280b.getId());
        mVar.d(i11);
        mVar.e(String.valueOf(System.currentTimeMillis() - this.B));
        mVar.m(str);
        String str2 = "2";
        if (this.f39280b.getAdType() == 287) {
            mVar.a("3");
        } else if (this.f39280b.getAdType() == 94) {
            mVar.a("1");
        } else if (this.f39280b.getAdType() == 42) {
            mVar.a("2");
        }
        if (this.f39280b.isMraid()) {
            mVar.b(m.N);
        } else {
            mVar.g(this.f39280b.getendcard_url());
            if (y0.b(this.f39280b.getendcard_url()) && this.f39280b.getendcard_url().contains(".zip")) {
                str2 = "1";
            }
            mVar.f(str2);
            mVar.b(m.O);
        }
        com.mbridge.msdk.foundation.same.report.g.b(mVar, this.unitId, this.f39280b);
    }

    public void setCloseDelayShowTime(int i11) {
        this.f39337w = i11;
    }

    public void setCloseVisible(int i11) {
        if (this.f39283e) {
            this.f39329o.setVisibility(i11);
        }
    }

    public void setCloseVisibleForMraid(int i11) {
        if (this.f39283e) {
            this.I = true;
            if (i11 == 4) {
                this.f39329o.setImageDrawable(new ColorDrawable(16711680));
            } else {
                this.f39329o.setImageResource(findDrawable("mbridge_reward_close"));
            }
            this.f39329o.setVisibility(0);
        }
    }

    public void setError(boolean z10) {
        this.f39335u = z10;
    }

    public void setHtmlSource(String str) {
        this.f39333s = str;
    }

    public void setLoadPlayable(boolean z10) {
        this.O = z10;
    }

    public void setNotchValue(String str, int i11, int i12, int i13, int i14) {
        if (!TextUtils.isEmpty(str)) {
            this.K = str;
        }
        CampaignEx campaignEx = this.f39280b;
        if (campaignEx == null || campaignEx.getAdSpaceT() == 2) {
            return;
        }
        o0.b(MBridgeBaseView.TAG, "NOTCH H5ENDCARD " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)));
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f39329o.getLayoutParams();
        int a11 = t0.a(getContext(), 20.0f);
        layoutParams.setMargins(i11 + a11, i13 + a11, i12 + a11, i14 + a11);
        this.f39329o.setLayoutParams(layoutParams);
    }

    public void setPlayCloseBtnTm(int i11) {
        this.f39338x = i11;
    }

    public void setUnitId(String str) {
        this.unitId = str;
    }

    public void startCounterEndCardShowTimer() {
        try {
            String str = this.f39280b.getendcard_url();
            if (y0.b(str) && str.contains("wfl=1")) {
                String[] split = str.split(UrlUtils.AND_MARK);
                int i11 = 15;
                if (split != null && split.length > 0) {
                    for (String str2 : split) {
                        if (y0.b(str2) && str2.contains("timeout") && str2.split(UrlUtils.EQUAL_MARK) != null && str2.split(UrlUtils.EQUAL_MARK).length > 0) {
                            i11 = t0.a((Object) str2.split(UrlUtils.EQUAL_MARK)[1]);
                        }
                    }
                }
                executeEndCardShow(i11);
            }
        } catch (Throwable th2) {
            o0.a(MBridgeBaseView.TAG, th2.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.video.signal.h
    public void toggleCloseBtn(int i11) {
        int visibility = this.f39329o.getVisibility();
        if (i11 == 1) {
            this.D = true;
            visibility = 0;
        } else if (i11 == 2) {
            this.D = false;
            if (this.O) {
                g();
            } else {
                f();
            }
            visibility = 8;
        }
        setCloseVisible(visibility);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.mbsignalcommon.mraid.b
    public void unload() {
        close();
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff, com.mbridge.msdk.mbsignalcommon.mraid.b
    public void useCustomClose(boolean z10) {
        try {
            setCloseVisibleForMraid(z10 ? 4 : 0);
        } catch (Exception e11) {
            o0.b(MBridgeBaseView.TAG, e11.getMessage());
        }
    }

    public void volumeChange(double d11) {
        com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.f39330p, d11);
    }

    @Override // com.mbridge.msdk.video.module.MBridgeH5EndCardViewDiff
    public void webviewshow() {
        WindVaneWebView windVaneWebView = this.f39330p;
        if (windVaneWebView != null) {
            windVaneWebView.post(new d());
        }
    }
}
