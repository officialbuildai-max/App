package com.bytedance.sdk.openadsdk.component.reward.Sj;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.datastore.preferences.protobuf.DescriptorProtos$Edition;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bytedance.sdk.component.adexpress.EjP.uA;
import com.bytedance.sdk.component.uA.vS;
import com.bytedance.sdk.component.utils.ib;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.EjP.TKC;
import com.bytedance.sdk.openadsdk.core.JcM;
import com.bytedance.sdk.openadsdk.core.Yf;
import com.bytedance.sdk.openadsdk.core.model.sU;
import com.bytedance.sdk.openadsdk.core.model.uP;
import com.bytedance.sdk.openadsdk.core.sP.TKC;
import com.bytedance.sdk.openadsdk.core.sP.sP;
import com.bytedance.sdk.openadsdk.core.widget.Sj.vS;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.FPG;
import com.bytedance.sdk.openadsdk.utils.Mts;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.google.logging.type.LogSeverity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import y5.b;

/* loaded from: classes3.dex */
public class TzV implements com.bytedance.sdk.openadsdk.aa.uA {
    private boolean Bml;
    private com.bytedance.sdk.openadsdk.common.EjP Chv;
    protected com.bytedance.sdk.openadsdk.EjP.EjP.HiB Dq;
    private boolean EZ;
    private boolean Ei;
    protected String EjP;
    private final com.bytedance.sdk.openadsdk.component.reward.Sj.Sj FPG;
    private boolean Fm;
    private int Fmk;
    com.bytedance.sdk.openadsdk.EjP.Ym HiB;
    private boolean HpB;
    private long LqL;
    private boolean Mts;
    Yf Sj;
    private com.bytedance.sdk.component.uA.vS TzV;
    private com.bytedance.sdk.openadsdk.common.Fmk WMZ;

    @NonNull
    private final sU Ym;
    private int Zq;
    private String aNB;

    /* renamed from: aa, reason: collision with root package name */
    private final String f21080aa;
    private boolean cX;
    private com.bytedance.sdk.component.uA.vS dNu;

    /* renamed from: db, reason: collision with root package name */
    private long f21081db;
    private String dwU;

    /* renamed from: dx, reason: collision with root package name */
    private boolean f21082dx;
    private vS.Sj gY;

    /* renamed from: ib, reason: collision with root package name */
    private boolean f21083ib;

    /* renamed from: jb, reason: collision with root package name */
    private boolean f21084jb;
    private View kF;
    private float ley;
    private int qRN;
    Yf sP;
    private ILoader sdp;
    private final boolean sef;
    private View uP;
    private int uvD;
    private float wE;
    private com.bytedance.sdk.openadsdk.core.widget.Sj.HiB xD;
    private boolean zR;
    protected boolean TKC = true;
    private boolean RiZ = false;
    private final AtomicBoolean sU = new AtomicBoolean(true);
    int vS = 0;
    String Jcg = "";
    boolean uA = false;
    private SparseArray<TKC.Sj> Yf = new SparseArray<>();
    private boolean LD = true;
    private float fF = -1.0f;
    private float JcM = -1.0f;
    private boolean Wjd = false;
    private long xhi = -1;
    private volatile int ndK = 0;
    private int UHs = -1;
    private volatile int MuB = 0;
    private volatile int IOh = 0;
    private long pfr = 0;
    public boolean TEQ = false;

    /* renamed from: kb, reason: collision with root package name */
    private int f21085kb = -1;

    /* loaded from: classes3.dex */
    public interface EjP {
        void Sj(WebView webView, int i11);

        void Sj(WebView webView, String str);

        void Sj(WebView webView, String str, Bitmap bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Sj extends com.bytedance.sdk.openadsdk.core.sP.Sj implements sP.Sj {
        private final com.bytedance.sdk.openadsdk.component.reward.Sj.Sj Sj;
        private final View.OnClickListener TKC;
        private final View sP;

        public Sj(com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2, View view, View.OnClickListener onClickListener) {
            super(sj2.Fm, sj2.sP, sj2.HiB, sj2.EjP ? 7 : 5);
            this.Sj = sj2;
            this.sP = view;
            this.TKC = onClickListener;
            HashMap hashMap = new HashMap();
            hashMap.put("close_auto_click", Boolean.TRUE);
            hashMap.put("click_scence", 2);
            Sj(hashMap);
            Sj(sj2.kF.TKC());
            Sj(this);
        }

        @Override // com.bytedance.sdk.openadsdk.core.sP.Sj, com.bytedance.sdk.openadsdk.core.sP.sP, com.bytedance.sdk.openadsdk.core.sP.TKC
        public void Sj(View view, float f11, float f12, float f13, float f14, SparseArray<TKC.Sj> sparseArray, boolean z10) {
            if (!((com.bytedance.sdk.openadsdk.core.sP.sP) this).vS.UmR()) {
                super.Sj(view, f11, f12, f13, f14, sparseArray, z10);
                this.Sj.f21075jb.c_();
            } else {
                this.TKC.onClick(view);
                this.sP.setOnTouchListener(null);
                this.sP.setOnClickListener(this.TKC);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.sP.sP.Sj
        public void Sj(View view, int i11) {
            this.sP.setOnTouchListener(null);
            this.sP.setOnClickListener(this.TKC);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class TKC implements com.bytedance.sdk.openadsdk.aa.Ym {
        private final com.bytedance.sdk.component.uA.vS Sj;

        private TKC(com.bytedance.sdk.component.uA.vS vSVar) {
            this.Sj = vSVar;
        }

        @Override // com.bytedance.sdk.openadsdk.aa.Ym
        public void Sj() {
            com.bytedance.sdk.component.uA.vS vSVar = this.Sj;
            if (vSVar == null) {
                return;
            }
            vSVar.Zq();
        }

        @Override // com.bytedance.sdk.openadsdk.aa.Ym
        public void sP() {
            com.bytedance.sdk.component.uA.vS vSVar = this.Sj;
            if (vSVar == null) {
                return;
            }
            vSVar.TzV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class sP implements com.bytedance.sdk.openadsdk.aa.Sj {
        private final View Sj;

        public sP(View view) {
            this.Sj = view;
        }

        @Override // com.bytedance.sdk.openadsdk.aa.Sj
        public int Sj() {
            View view = this.Sj;
            int measuredHeight = view != null ? view.getMeasuredHeight() : -1;
            return measuredHeight <= 0 ? FPG.HiB(com.bytedance.sdk.openadsdk.core.dNu.Sj()) : measuredHeight;
        }

        @Override // com.bytedance.sdk.openadsdk.aa.Sj
        public int sP() {
            View view = this.Sj;
            int measuredWidth = view != null ? view.getMeasuredWidth() : -1;
            return measuredWidth <= 0 ? FPG.TKC(com.bytedance.sdk.openadsdk.core.dNu.Sj()) : measuredWidth;
        }
    }

    public TzV(com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2) {
        this.FPG = sj2;
        this.Ym = sj2.sP;
        this.f21080aa = sj2.HiB;
        this.sef = sj2.EjP;
    }

    private static String Sj(String str, sU sUVar, int i11, int i12, int i13) {
        String str2;
        String str3;
        float tY = sUVar.tY();
        if (!TextUtils.isEmpty(str)) {
            if (i11 == 1) {
                if (str.contains(UrlUtils.QUESTION_MARK)) {
                    str3 = str + UrlUtils.AND_MARK;
                } else {
                    str3 = str + UrlUtils.QUESTION_MARK;
                }
                str = str3 + "orientation=portrait";
            }
            if (str.contains(UrlUtils.QUESTION_MARK)) {
                str2 = str + UrlUtils.AND_MARK;
            } else {
                str2 = str + UrlUtils.QUESTION_MARK;
            }
            str = str2 + "height=" + i12 + "&width=" + i13 + "&aspect_ratio=" + tY;
        }
        return !uP.Jcg(sUVar) ? com.bytedance.sdk.openadsdk.utils.HiB.Sj(str) : str;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void Sj(String str, final EjP ejP) {
        com.bytedance.sdk.component.uA.vS vSVar;
        com.bytedance.sdk.component.uA.vS vSVar2 = this.dNu;
        if (vSVar2 == null || vSVar2.getWebView() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.EjP.Ym sP2 = new com.bytedance.sdk.openadsdk.EjP.Ym(this.Ym, this.dNu.getWebView(), new com.bytedance.sdk.openadsdk.EjP.TEQ() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.7
            @Override // com.bytedance.sdk.openadsdk.EjP.TEQ
            public void Sj(int i11) {
                if (TextUtils.isEmpty(TzV.this.dwU)) {
                    return;
                }
                TKC.Sj.Sj(TzV.this.qRN, TzV.this.ndK, TzV.this.IOh, TzV.this.MuB - TzV.this.IOh, TzV.this.Ym, "landingpage_endcard", i11);
            }
        }, this.UHs).sP(true);
        this.HiB = sP2;
        this.gY = sP2.Sj;
        sP2.Sj(dNu() ? "landingpage_endcard" : str);
        this.HiB.sP(this.f21080aa);
        this.HiB.TKC(true);
        int i11 = Build.VERSION.SDK_INT;
        this.dNu.getWebView().setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.8
            @Override // android.view.View.OnScrollChangeListener
            public void onScrollChange(View view, int i12, int i13, int i14, int i15) {
                com.bytedance.sdk.openadsdk.EjP.Ym ym2 = TzV.this.HiB;
                if (ym2 != null) {
                    ym2.sP(i13);
                }
            }
        });
        Dq dq2 = this.FPG.uP;
        if (dq2 != null) {
            this.HiB.Sj(dq2.EjP());
        }
        com.bytedance.sdk.openadsdk.common.EjP Sj2 = Mts.Sj(this.Ym, this.dNu, this.FPG.Fm, this.f21080aa);
        this.Chv = Sj2;
        if (Sj2 != null) {
            if (dNu()) {
                str = "landingpage_endcard";
            }
            Sj2.Sj(str);
        }
        if (dNu()) {
            Mts.Sj(this.Ym, this.dNu);
        }
        com.bytedance.sdk.openadsdk.core.widget.Sj.HiB hiB = new com.bytedance.sdk.openadsdk.core.widget.Sj.HiB(com.bytedance.sdk.openadsdk.core.dNu.Sj(), this.Sj, this.Ym.aZ(), this.Chv, this.HiB, this.Ym.Ei() || uP.Jcg(this.Ym)) { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.9
            @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str2) {
                super.onPageFinished(webView, str2);
                TzV.this.Bml = false;
                TzV.this.f21082dx = true;
                if (TzV.this.FPG.JcM.wE()) {
                    View TEQ = TzV.this.FPG.Wjd.TEQ();
                    if (TEQ instanceof com.bytedance.sdk.openadsdk.core.HiB.EjP) {
                        ((com.bytedance.sdk.openadsdk.core.HiB.EjP) TEQ).setImageResource(ib.EjP(TzV.this.FPG.Ei, "tt_skip_btn"));
                    }
                }
                DeviceUtils.AudioInfoReceiver.Sj(TzV.this);
                TzV.this.f21085kb = DeviceUtils.Jcg();
                com.bytedance.sdk.openadsdk.EjP.EjP.HiB hiB2 = TzV.this.Dq;
                if (hiB2 != null) {
                    hiB2.vS();
                }
                TzV.this.FPG.uP.sP(str2);
                EjP ejP2 = ejP;
                if (ejP2 != null) {
                    ejP2.Sj(webView, str2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str2, Bitmap bitmap) {
                super.onPageStarted(webView, str2, bitmap);
                com.bytedance.sdk.openadsdk.EjP.EjP.HiB hiB2 = TzV.this.Dq;
                if (hiB2 != null) {
                    hiB2.HiB();
                }
                EjP ejP2 = ejP;
                if (ejP2 != null) {
                    ejP2.Sj(webView, str2, bitmap);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i12, String str2, String str3) {
                super.onReceivedError(webView, i12, str2, str3);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceError != null && webResourceRequest != null && webResourceRequest.getUrl() != null) {
                    StringBuilder sb2 = new StringBuilder("onReceivedError WebResourceError : description=");
                    sb2.append((Object) webResourceError.getDescription());
                    sb2.append("  url =");
                    sb2.append(webResourceRequest.getUrl().toString());
                }
                if (webResourceRequest == null || webResourceRequest.getUrl() == null || !TzV.this.Sj(webResourceRequest.getUrl().toString())) {
                    if (webResourceError != null && webResourceRequest != null && webResourceRequest.isForMainFrame()) {
                        TzV.this.FPG.uP.Sj(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), String.valueOf(webResourceRequest.getUrl()));
                    }
                    if (webResourceRequest == null || webResourceRequest.isForMainFrame()) {
                        TzV.this.sU.set(false);
                        TzV.this.Bml = false;
                    }
                    if (TzV.this.Dq != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (webResourceError != null) {
                                jSONObject.put("code", webResourceError.getErrorCode());
                                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceError.getDescription());
                            }
                            TzV.this.Dq.Sj(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                    if (webResourceError != null) {
                        TzV.this.vS = webResourceError.getErrorCode();
                        TzV.this.Jcg = String.valueOf(webResourceError.getDescription());
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                TzV.this.FPG.uP.Sj(webResourceRequest.isForMainFrame(), webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode());
                if (webResourceRequest.getUrl() != null) {
                    new StringBuilder("onReceivedHttpError:url =").append(webResourceRequest.getUrl().toString());
                }
                if (webResourceRequest.isForMainFrame()) {
                    TzV.this.sU.set(false);
                    TzV.this.Bml = false;
                    TzV.this.vS = webResourceResponse.getStatusCode();
                    TzV.this.Jcg = "onReceivedHttpError";
                }
                if (TzV.this.Dq != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", webResourceResponse.getStatusCode());
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceResponse.getReasonPhrase());
                        TzV.this.Dq.Sj(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
            @TargetApi(21)
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.sU.Sj("TTAD.RFWVM", "shouldInterceptRequest error1", th2);
                    return super.shouldInterceptRequest(webView, webResourceRequest);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str2) {
                if (uP.Jcg(TzV.this.Ym)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    WebResourceResponse Sj3 = com.bytedance.sdk.openadsdk.core.aa.TKC.Sj.Sj().Sj(TzV.this.Ym.UHs().f(), uP.Fmk(TzV.this.Ym), str2);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (TzV.this.Dq != null) {
                        uA.Sj Sj4 = com.bytedance.sdk.component.adexpress.EjP.uA.Sj(str2);
                        int i12 = Sj3 != null ? 1 : 2;
                        if (Sj4 == uA.Sj.HTML) {
                            TzV.this.Dq.Sj(str2, currentTimeMillis, currentTimeMillis2, i12);
                        } else if (Sj4 == uA.Sj.JS) {
                            TzV.this.Dq.sP(str2, currentTimeMillis, currentTimeMillis2, i12);
                        }
                    }
                    return Sj3 != null ? Sj3 : super.shouldInterceptRequest(webView, str2);
                }
                try {
                    if (TextUtils.isEmpty(TzV.this.dwU)) {
                        return super.shouldInterceptRequest(webView, str2);
                    }
                    TzV.sef(TzV.this);
                    WebResourceResponseModel Sj5 = com.bytedance.sdk.openadsdk.Jcg.sP.Sj().Sj(TzV.this.sdp, TzV.this.dwU, str2);
                    if (Sj5 != null && Sj5.getWebResourceResponse() != null) {
                        TzV.uvD(TzV.this);
                        return Sj5.getWebResourceResponse();
                    }
                    if (Sj5 != null && Sj5.getMsg() == 2) {
                        TzV.dNu(TzV.this);
                    }
                    return super.shouldInterceptRequest(webView, str2);
                } catch (Throwable th2) {
                    com.bytedance.sdk.component.utils.sU.Sj("TTAD.RFWVM", "shouldInterceptRequest url error", th2);
                    return super.shouldInterceptRequest(webView, str2);
                }
            }
        };
        this.xD = hiB;
        this.dNu.setWebViewClient(hiB);
        this.xD.Sj(this.Ym);
        this.xD.Sj(this.sef ? "rewarded_video" : "fullscreen_interstitial_ad");
        if (this.Ym.Ei() && (vSVar = this.dNu) != null && vSVar.getWebView() != null) {
            this.dNu.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.10
                private final int sP = com.bytedance.sdk.openadsdk.core.dNu.sP();

                /* JADX WARN: Removed duplicated region for block: B:31:0x00d2 A[Catch: all -> 0x0066, TryCatch #1 {all -> 0x0066, blocks: (B:9:0x001f, B:17:0x0038, B:19:0x0052, B:22:0x006e, B:24:0x00b3, B:26:0x00bd, B:29:0x00ca, B:31:0x00d2, B:33:0x00de, B:34:0x00e7, B:36:0x00f4, B:38:0x015c, B:40:0x0185, B:42:0x018b, B:44:0x0199, B:46:0x01a1, B:50:0x01ad, B:52:0x01b5, B:54:0x01f5, B:60:0x0207, B:64:0x0213, B:66:0x0222, B:67:0x0246, B:69:0x024e, B:70:0x0284, B:72:0x028c, B:73:0x02c4, B:76:0x02f5, B:79:0x0309, B:81:0x0319, B:82:0x0322, B:84:0x032a, B:86:0x0338, B:89:0x0342, B:90:0x0359, B:93:0x034e, B:98:0x0234, B:106:0x0069, B:108:0x00ff, B:110:0x0129, B:112:0x0137, B:114:0x0141, B:116:0x014f), top: B:8:0x001f }] */
                @Override // android.view.View.OnTouchListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public boolean onTouch(android.view.View r20, android.view.MotionEvent r21) {
                    /*
                        Method dump skipped, instructions count: 875
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.AnonymousClass10.onTouch(android.view.View, android.view.MotionEvent):boolean");
                }
            });
        }
        com.bytedance.sdk.component.uA.vS vSVar3 = this.dNu;
        if (vSVar3 != null) {
            vSVar3.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.Sj.EjP(this.Sj, this.HiB, this.Chv) { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.11
                @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.EjP, android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i12) {
                    super.onProgressChanged(webView, i12);
                    EjP ejP2 = ejP;
                    if (ejP2 != null) {
                        ejP2.Sj(webView, i12);
                    }
                }
            });
        }
        Sj(this.dNu);
        if (i11 >= 24) {
            this.dNu.setLayerType(1, null);
        }
        this.dNu.setBackgroundColor(-1);
        this.dNu.setDisplayZoomControls(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Sj(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return this.Ym.Ei() && str.endsWith(".mp4");
    }

    static /* synthetic */ int dNu(TzV tzV) {
        int i11 = tzV.ndK;
        tzV.ndK = i11 + 1;
        return i11;
    }

    private void db() {
        this.sP.Sj("showPlayableEndCardOverlay", (JSONObject) null);
        this.FPG.HpB.sendEmptyMessageDelayed(600, 1000L);
        this.FPG.HpB.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.5
            @Override // java.lang.Runnable
            public void run() {
                TzV.this.xhi();
            }
        }, 1000L);
        com.bytedance.sdk.openadsdk.utils.Fmk fmk = this.FPG.f21078xu;
        if (fmk != null) {
            fmk.Sj(0L);
        }
    }

    private com.bytedance.sdk.openadsdk.EjP.EjP.HiB ndK() {
        return new com.bytedance.sdk.openadsdk.EjP.dNu(uP.Jcg(this.Ym) ? 3 : 2, this.sef ? "rewarded_video" : "fullscreen_interstitial_ad", this.Ym);
    }

    static /* synthetic */ int sef(TzV tzV) {
        int i11 = tzV.MuB;
        tzV.MuB = i11 + 1;
        return i11;
    }

    static /* synthetic */ int uvD(TzV tzV) {
        int i11 = tzV.IOh;
        tzV.IOh = i11 + 1;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xhi() {
        this.Fm = true;
        this.cX = false;
        this.FPG.HpB.removeMessages(600);
        this.FPG.HpB.removeMessages(LogSeverity.ALERT_VALUE);
        this.FPG.HpB.removeMessages(DescriptorProtos$Edition.EDITION_LEGACY_VALUE);
        this.FPG.Mts.EjP(false);
        this.FPG.RiZ.set(true);
        this.FPG.f21076kb.Zq();
        this.Ym.UmR();
        if (this.Ym.UmR() || !Mts.Dq(uP.Sj(this.Ym))) {
            return;
        }
        View TEQ = this.FPG.Wjd.TEQ();
        View.OnClickListener onClickListener = (View.OnClickListener) TEQ.getTag(TEQ.getId());
        if (onClickListener != null) {
            Sj sj2 = new Sj(this.FPG, TEQ, onClickListener);
            TEQ.setOnClickListener(sj2);
            TEQ.setOnTouchListener(sj2);
        }
    }

    public void Dq() {
        if (this.dNu == null) {
            return;
        }
        this.sU.set(this.zR);
        if (this.TzV.getVisibility() == 0 && this.zR) {
            db();
            return;
        }
        this.FPG.Mts.TKC(false);
        this.FPG.uP.Jcg(Dq.TKC);
        Sj(this.Sj, true, false);
        sP(this.Sj, false);
        Sj(this.Sj, false);
        this.dNu.uvD();
        if (this.zR) {
            this.TzV.setVisibility(0);
            Sj(this.sP, this.FPG.ndK, true);
            sP(this.sP, true);
            Sj(this.sP, true);
            this.FPG.HpB.removeMessages(600);
            com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.FPG;
            if (!sj2.FPG.TKC(sj2.f21076kb)) {
                this.FPG.f21076kb.kF();
            }
        } else {
            if (this.FPG.uP.Sj()) {
                this.FPG.uP.Sj(5);
            }
            this.FPG.FPG.EjP();
            this.FPG.f21078xu.Sj(r0.Dq);
        }
        this.cX = true;
    }

    public boolean Ei() {
        return this.Fm;
    }

    public void EjP(boolean z10) {
        if (uP.sP(this.Ym)) {
            return;
        }
        HiB(z10);
    }

    public boolean EjP() {
        return this.Ei;
    }

    public void FPG() {
        FPG.Sj((View) this.TzV, 8);
    }

    public boolean Fm() {
        com.bytedance.sdk.component.uA.vS vSVar = this.dNu;
        return vSVar == null || vSVar.getWebView() == null;
    }

    public Yf Fmk() {
        return this.sP;
    }

    public void HiB() {
        if (uP.HiB(this.Ym)) {
            return;
        }
        vS();
    }

    public void HiB(boolean z10) {
        if (this.Sj == null || this.FPG.Fm.isFinishing()) {
            return;
        }
        this.FPG.uP.HiB(z10);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z10);
            this.Sj.Sj("volumeChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    public boolean HpB() {
        return this.TEQ;
    }

    public void JcM() {
        com.bytedance.sdk.openadsdk.EjP.EjP.HiB hiB = this.Dq;
        if (hiB != null) {
            hiB.TEQ();
        }
    }

    public void Jcg() {
        b UHs = this.Ym.UHs();
        if (UHs == null) {
            return;
        }
        String z10 = UHs.z();
        this.aNB = z10;
        if (TextUtils.isEmpty(z10)) {
            return;
        }
        this.aNB = Sj(this.aNB, this.Ym, this.Fmk, this.uvD, this.Zq);
        this.TzV.setWebViewClient(new com.bytedance.sdk.openadsdk.core.widget.Sj.HiB(com.bytedance.sdk.openadsdk.core.dNu.Sj(), this.sP, this.Ym.aZ(), this.HiB, this.Ym.Ei() || uP.Jcg(this.Ym)) { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.3
            @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                com.bytedance.sdk.openadsdk.EjP.EjP.HiB hiB = TzV.this.Dq;
                if (hiB != null) {
                    hiB.vS();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                com.bytedance.sdk.openadsdk.EjP.EjP.HiB hiB = TzV.this.Dq;
                if (hiB != null) {
                    hiB.HiB();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
            public void onReceivedError(WebView webView, int i11, String str, String str2) {
                if (TzV.this.Sj(str2)) {
                    return;
                }
                TzV.this.zR = false;
                TzV tzV = TzV.this;
                tzV.vS = i11;
                tzV.Jcg = str;
                if (tzV.Dq != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", i11);
                        jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
                        TzV.this.Dq.Sj(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                super.onReceivedError(webView, i11, str, str2);
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
            @TargetApi(23)
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest == null || webResourceRequest.getUrl() == null || !TzV.this.Sj(webResourceRequest.getUrl().toString())) {
                    TzV.this.zR = false;
                    if (TzV.this.Dq != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            if (webResourceError != null) {
                                jSONObject.put("code", webResourceError.getErrorCode());
                                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceError.getDescription());
                            }
                            TzV.this.Dq.Sj(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                    if (webResourceError != null) {
                        TzV.this.vS = webResourceError.getErrorCode();
                        TzV.this.Jcg = String.valueOf(webResourceError.getDescription());
                    }
                    if (webResourceRequest == null) {
                        return;
                    }
                    super.onReceivedError(webView, webResourceRequest, webResourceError);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
            @TargetApi(21)
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                if (webResourceRequest != null && webResourceRequest.isForMainFrame()) {
                    TzV.this.zR = false;
                    if (webResourceResponse != null) {
                        TzV.this.vS = webResourceResponse.getStatusCode();
                        TzV.this.Jcg = "onReceivedHttpError";
                    }
                }
                if (TzV.this.Dq != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (webResourceResponse != null) {
                            jSONObject.put("code", webResourceResponse.getStatusCode());
                            jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, webResourceResponse.getReasonPhrase());
                        }
                        TzV.this.Dq.Sj(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
                if (webResourceRequest != null) {
                    super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                }
            }
        });
        this.TzV.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.Sj.EjP(this.sP, this.HiB) { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.EjP, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i11) {
                super.onProgressChanged(webView, i11);
                if (!TzV.this.FPG.Jcg || TzV.this.FPG.aNB == null) {
                    return;
                }
                TzV.this.FPG.aNB.Sj(webView, i11, TzV.this.gY);
            }
        });
        com.bytedance.sdk.openadsdk.utils.sU.Sj(this.TzV, this.aNB);
        this.zR = true;
    }

    public void Jcg(boolean z10) {
        this.cX = z10;
    }

    public boolean LD() {
        return this.uA;
    }

    public void LqL() {
        com.bytedance.sdk.openadsdk.EjP.EjP.HiB hiB = this.Dq;
        if (hiB != null) {
            hiB.Jcg();
        }
    }

    public void Mts() {
        FPG.Sj((View) this.dNu, 0);
        FPG.Sj((View) this.TzV, 8);
    }

    public boolean RiZ() {
        return this.f21082dx;
    }

    public void Sj() {
        if (this.f21083ib) {
            return;
        }
        this.f21083ib = true;
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.FPG;
        this.Fmk = sj2.sdp;
        this.Zq = sj2.IOh;
        this.uvD = sj2.pfr;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        sP();
        this.pfr = SystemClock.elapsedRealtime() - elapsedRealtime;
    }

    public void Sj(float f11) {
        FPG.Sj(this.dNu, f11);
    }

    public void Sj(int i11) {
        FPG.Sj((View) this.dNu, i11);
        com.bytedance.sdk.component.uA.vS vSVar = this.dNu;
        if (vSVar != null) {
            FPG.Sj((View) vSVar.getWebView(), i11);
        }
        if (this.dNu != null && (this.Ym.Ei() || uP.Jcg(this.Ym))) {
            this.dNu.setLandingPage(true);
            this.dNu.setTag(uP.Jcg(this.Ym) ? this.f21080aa : "landingpage_endcard");
            this.dNu.setMaterialMeta(this.Ym.hif());
        }
        if (i11 == 0 && uP.Dq(this.Ym)) {
            Jcg();
        }
    }

    public void Sj(int i11, int i12) {
        if (this.Sj == null || this.FPG.Fm.isFinishing()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", i11);
            jSONObject.put("height", i12);
            this.Sj.Sj("resize", jSONObject);
        } catch (Exception e11) {
            Log.e("TTAD.RFWVM", "", e11);
        }
    }

    public void Sj(DownloadListener downloadListener) {
        com.bytedance.sdk.component.uA.vS vSVar = this.dNu;
        if (vSVar == null || downloadListener == null) {
            return;
        }
        vSVar.setDownloadListener(downloadListener);
    }

    public void Sj(com.bytedance.sdk.component.uA.vS vSVar) {
        if (vSVar == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.widget.Sj.TKC.Sj(this.FPG.Fm).Sj(false).sP(false).Sj(vSVar.getWebView());
        vSVar.setUserAgentString(com.bytedance.sdk.openadsdk.utils.TzV.Sj(vSVar.getWebView(), BuildConfig.VERSION_CODE));
        vSVar.setMixedContentMode(0);
    }

    public void Sj(com.bytedance.sdk.openadsdk.aa.vS vSVar, String str, final com.bytedance.sdk.openadsdk.core.aa.EjP.sP sPVar) {
        if (this.dNu == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (uP.Jcg(this.Ym)) {
            hashMap.put("click_scence", 3);
        } else {
            hashMap.put("click_scence", 2);
        }
        this.Dq = ndK();
        Yf yf2 = new Yf(this.FPG.Fm);
        this.Sj = yf2;
        yf2.Sj(this.FPG.f21075jb);
        String Lip = this.Ym.Lip();
        this.Sj.sP(this.dNu).Sj(this.Ym).TKC(this.Ym.aZ()).EjP(this.Ym.mZN()).sP(this.Ym.TT() ? 7 : 5).Sj(new sP(this.dNu)).HiB(Lip).Sj(this.dNu).sP(dNu() ? "landingpage_endcard" : str).Sj(hashMap).Sj(this.Dq).Sj(new com.bytedance.sdk.openadsdk.core.widget.HiB() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.16
            @Override // com.bytedance.sdk.openadsdk.core.widget.HiB
            public void Sj() {
                if (TzV.this.xD != null) {
                    TzV.this.xD.TKC();
                }
                com.bytedance.sdk.openadsdk.core.aa.EjP.sP sPVar2 = sPVar;
                if (sPVar2 != null) {
                    sPVar2.EjP();
                }
            }
        }).Sj(new Yf.Sj() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.15
            @Override // com.bytedance.sdk.openadsdk.core.Yf.Sj
            public void Sj() {
                TzV.this.xhi();
            }
        });
        HashMap hashMap2 = new HashMap();
        if (uP.Dq(this.Ym)) {
            hashMap2.put("click_scence", 2);
        }
        Yf yf3 = new Yf(this.FPG.Fm);
        this.sP = yf3;
        yf3.Sj(this.FPG.f21075jb);
        Yf HiB = this.sP.sP(this.TzV).Sj(this.Ym).TKC(this.Ym.aZ()).EjP(this.Ym.mZN()).sP(this.Ym.TT() ? 7 : 5).Sj(new sP(this.TzV)).Sj(this.TzV).HiB(Lip);
        if (dNu()) {
            str = "landingpage_endcard";
        }
        HiB.sP(str).Sj(hashMap2).Sj(this.Dq).Sj(new com.bytedance.sdk.openadsdk.core.widget.HiB() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.18
            @Override // com.bytedance.sdk.openadsdk.core.widget.HiB
            public void Sj() {
                if (TzV.this.xD != null) {
                    TzV.this.xD.TKC();
                }
            }
        }).Sj(new Yf.Sj() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.17
            @Override // com.bytedance.sdk.openadsdk.core.Yf.Sj
            public void Sj() {
                TzV.this.xhi();
            }
        });
        this.Sj.Sj(new TKC(this.dNu));
        this.sP.Sj(new TKC(this.TzV));
        this.Sj.Sj(this.FPG.Wjd.TEQ()).Sj(this.FPG.Chv).Sj(vSVar).Sj(this.FPG.uP.Ym()).Sj(new com.bytedance.sdk.openadsdk.aa.TKC() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.19
            @Override // com.bytedance.sdk.openadsdk.aa.TKC
            public void Sj() {
                TzV.this.HpB = true;
                TzV.this.FPG.Wjd.TEQ().performClick();
            }

            @Override // com.bytedance.sdk.openadsdk.aa.TKC
            public void Sj(boolean z10, int i11, String str2) {
                if (z10) {
                    TzV tzV = TzV.this;
                    tzV.TEQ = true;
                    if (tzV.EZ) {
                        TzV.this.EZ = false;
                        TzV tzV2 = TzV.this;
                        tzV2.Sj(tzV2.FPG.ndK, true);
                    }
                }
                if (!sU.EjP(TzV.this.FPG.sP) || uP.Jcg(TzV.this.FPG.sP)) {
                    return;
                }
                TzV.this.Sj(z10, i11, str2);
            }
        });
        this.Sj.HiB(this.f21084jb);
        this.sP.Sj(this.FPG.Wjd.TEQ()).Sj(new com.bytedance.sdk.openadsdk.aa.TKC() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.2
            @Override // com.bytedance.sdk.openadsdk.aa.TKC
            public void Sj() {
                TzV.this.HpB = true;
                TzV.this.FPG.Wjd.TEQ().performClick();
            }

            @Override // com.bytedance.sdk.openadsdk.aa.TKC
            public void Sj(boolean z10, int i11, String str2) {
            }
        });
    }

    public void Sj(com.bytedance.sdk.openadsdk.common.Fmk fmk) {
        this.WMZ = fmk;
    }

    public void Sj(Yf yf2, boolean z10) {
        if (this.Sj == null || this.FPG.Fm.isFinishing()) {
            return;
        }
        yf2.sP(z10);
    }

    public void Sj(Yf yf2, boolean z10, boolean z11) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", z10);
            jSONObject.put(CampaignEx.JSON_NATIVE_VIDEO_ENDCARD_SHOW, z11);
            com.bytedance.sdk.openadsdk.activity.vS vSVar = this.FPG.HS;
            if (vSVar != null) {
                jSONObject.put("multi_ads_show", vSVar.uP().Dq());
            }
            yf2.Sj("endcard_control_event", jSONObject);
            if (!z11) {
                this.EZ = false;
            } else {
                if (this.f21082dx) {
                    return;
                }
                this.EZ = true;
            }
        } catch (Exception unused) {
        }
    }

    public void Sj(String str, final com.bytedance.sdk.openadsdk.core.aa.EjP.sP sPVar) {
        Sj(str, new EjP() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.12
            @Override // com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.EjP
            public void Sj(WebView webView, int i11) {
                try {
                    if (uP.TzV(TzV.this.FPG.sP) && TzV.this.FPG.sP.eEJ() && !TzV.this.FPG.Fm.isFinishing()) {
                        TzV.this.FPG.uP.TKC(i11);
                    } else {
                        if (!TzV.this.FPG.Jcg || TzV.this.FPG.aNB == null) {
                            return;
                        }
                        TzV.this.FPG.aNB.Sj(webView, i11, TzV.this.gY);
                    }
                } catch (Exception unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.EjP
            public void Sj(WebView webView, String str2) {
                if (TzV.this.FPG.Fm.isFinishing()) {
                    return;
                }
                TzV.this.FPG.uP.sP(TzV.this.TzV());
            }

            @Override // com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.EjP
            public void Sj(WebView webView, String str2, Bitmap bitmap) {
                if (TzV.this.Wjd || !uP.TzV(TzV.this.FPG.sP)) {
                    return;
                }
                TzV.this.Wjd = true;
                TzV.this.FPG.uP.Sj(TzV.this.FPG.vS, TzV.this.FPG.sP, TzV.this.FPG.sP.TT());
                if (!uP.Dq(TzV.this.Ym)) {
                    TzV.this.FPG.HpB.sendEmptyMessageDelayed(600, TzV.this.FPG.uP.uA() * 1000);
                }
                TzV.this.FPG.uP.TEQ();
                TzV.this.FPG.f21075jb.Ym();
            }
        });
        if (uP.TzV(this.FPG.sP)) {
            Sj(this.TzV);
            this.FPG.uP.Sj(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.13
                @Override // android.webkit.DownloadListener
                public void onDownloadStart(String str2, String str3, String str4, String str5, long j11) {
                    TzV.this.FPG.kF.sP();
                    com.bytedance.sdk.openadsdk.core.aa.EjP.sP sPVar2 = sPVar;
                    if (sPVar2 != null) {
                        sPVar2.EjP();
                    }
                }
            });
        }
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.FPG;
        sj2.uP.TKC(sj2.Chv);
        Sj(new DownloadListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.14
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str2, String str3, String str4, String str5, long j11) {
                TzV.this.FPG.kF.sP();
                com.bytedance.sdk.openadsdk.core.aa.EjP.sP sPVar2 = sPVar;
                if (sPVar2 != null) {
                    sPVar2.EjP();
                }
            }
        });
    }

    public void Sj(boolean z10) {
        this.TKC = z10;
    }

    public void Sj(boolean z10, int i11, String str) {
        com.bytedance.sdk.openadsdk.EjP.EjP.HiB hiB = this.Dq;
        if (hiB == null) {
            return;
        }
        if (z10) {
            hiB.sP();
        } else {
            hiB.Sj(i11, str);
        }
    }

    public void Sj(boolean z10, boolean z11) {
        Sj(this.Sj, z10, z11);
    }

    public com.bytedance.sdk.component.uA.vS TEQ() {
        return this.dNu;
    }

    public void TKC(boolean z10) {
        sP(this.Sj, z10);
    }

    public boolean TKC() {
        return this.HpB;
    }

    public boolean TzV() {
        return this.sU.get();
    }

    public boolean WMZ() {
        Yf yf2 = this.Sj;
        if (yf2 == null) {
            return false;
        }
        return yf2.uA();
    }

    public boolean Wjd() {
        return this.f21082dx && this.sU.get();
    }

    public void Yf() {
        com.bytedance.sdk.openadsdk.EjP.Ym ym2 = this.HiB;
        if (ym2 != null) {
            ym2.Sj(System.currentTimeMillis());
        }
    }

    public com.bytedance.sdk.component.uA.vS Ym() {
        return this.TzV;
    }

    public void Zq() {
        b UHs;
        if (uP.HiB(this.Ym)) {
            sU sUVar = this.Ym;
            if (sUVar != null && (UHs = sUVar.UHs()) != null) {
                this.EjP = UHs.z();
            }
        } else {
            this.EjP = uP.Fmk(this.Ym);
        }
        String Sj2 = Sj(this.EjP, this.Ym, this.Fmk, this.uvD, this.Zq);
        this.EjP = Sj2;
        if (TextUtils.isEmpty(Sj2)) {
            return;
        }
        this.f21084jb = this.EjP.contains("use_second_endcard=1");
    }

    public Yf aa() {
        return this.Sj;
    }

    public boolean dNu() {
        String str = this.EjP;
        if (str == null) {
            return false;
        }
        try {
            return Uri.parse(str).getQueryParameterNames().contains("show_landingpage");
        } catch (Exception unused) {
            return false;
        }
    }

    public void dx() {
        com.bytedance.sdk.component.uA.vS vSVar = this.dNu;
        if (vSVar != null) {
            vSVar.Zq();
        }
        com.bytedance.sdk.component.uA.vS vSVar2 = this.TzV;
        if (vSVar2 != null) {
            vSVar2.Zq();
        }
        if (this.xhi > 0) {
            this.f21081db += SystemClock.elapsedRealtime() - this.xhi;
            this.xhi = 0L;
        }
        Yf yf2 = this.Sj;
        if (yf2 != null) {
            yf2.sP(false);
            sP(this.Sj, false);
            Sj(this.Sj, true, false);
        }
        if (this.sP == null || !uP.Dq(this.Ym)) {
            return;
        }
        this.sP.sP(false);
        sP(this.sP, false);
        Sj(this.sP, true, false);
    }

    public void fF() {
        com.bytedance.sdk.openadsdk.EjP.EjP.HiB hiB = this.Dq;
        if (hiB != null) {
            hiB.TKC();
            this.Dq.EjP();
        }
    }

    public int ib() {
        return this.vS;
    }

    public void jb() {
        com.bytedance.sdk.openadsdk.EjP.Ym ym2 = this.HiB;
        if (ym2 != null) {
            ym2.HiB();
        }
    }

    public String kF() {
        return this.Jcg;
    }

    public void ley() {
        com.bytedance.sdk.openadsdk.EjP.EjP.HiB hiB = this.Dq;
        if (hiB != null) {
            hiB.Dq();
        }
    }

    void sP() {
        com.bytedance.sdk.openadsdk.common.Fmk fmk;
        this.kF = this.FPG.Fm.findViewById(R.id.content);
        com.bytedance.sdk.openadsdk.component.reward.Sj.Sj sj2 = this.FPG;
        boolean z10 = sj2.Jcg;
        this.Mts = z10;
        if (!z10 || (fmk = this.WMZ) == null) {
            com.bytedance.sdk.component.uA.vS vSVar = (com.bytedance.sdk.component.uA.vS) sj2.xD.findViewById(com.bytedance.sdk.openadsdk.utils.Zq.sef);
            this.dNu = vSVar;
            if (vSVar == null || !sU.sP(this.Ym)) {
                FPG.Sj((View) this.dNu, 8);
            } else {
                this.dNu.HiB();
            }
        } else {
            this.dNu = fmk.EjP();
        }
        com.bytedance.sdk.component.uA.vS vSVar2 = (com.bytedance.sdk.component.uA.vS) this.FPG.xD.findViewById(com.bytedance.sdk.openadsdk.utils.Zq.uvD);
        this.TzV = vSVar2;
        if (vSVar2 != null && uP.Jcg(this.Ym) && uP.Dq(this.Ym)) {
            this.TzV.HiB();
            this.TzV.setDisplayZoomControls(false);
        } else {
            FPG.Sj((View) this.TzV, 8);
        }
        com.bytedance.sdk.component.uA.vS vSVar3 = this.dNu;
        if (vSVar3 != null) {
            vSVar3.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (TzV.this.dNu == null || TzV.this.dNu.getViewTreeObserver() == null) {
                        return;
                    }
                    TzV.this.dNu.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    int measuredWidth = TzV.this.dNu.getMeasuredWidth();
                    int measuredHeight = TzV.this.dNu.getMeasuredHeight();
                    if (TzV.this.dNu.getVisibility() == 0) {
                        TzV.this.Sj(measuredWidth, measuredHeight);
                    }
                }
            });
        }
        com.bytedance.sdk.component.uA.vS vSVar4 = this.TzV;
        if (vSVar4 != null) {
            vSVar4.setLandingPage(true);
            this.TzV.setTag(uP.Jcg(this.Ym) ? this.f21080aa : "landingpage_endcard");
            this.TzV.setWebViewClient(new vS.Sj());
            this.TzV.setMaterialMeta(this.Ym.hif());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.aa.uA
    public void sP(int i11) {
        int i12 = this.f21085kb;
        if (i12 <= 0 && i11 > 0) {
            EjP(false);
        } else if (i12 > 0 && i11 == 0) {
            EjP(true);
        }
        this.f21085kb = i11;
    }

    public void sP(Yf yf2, boolean z10) {
        try {
            this.FPG.uP.EjP(z10);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("viewStatus", z10 ? 1 : 0);
            yf2.Sj("viewableChange", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void sP(boolean z10) {
        Sj(this.Sj, z10);
    }

    public void sU() {
        com.bytedance.sdk.openadsdk.EjP.EjP.HiB hiB = this.Dq;
        if (hiB != null) {
            hiB.uA();
        }
        com.bytedance.sdk.openadsdk.EjP.Ym ym2 = this.HiB;
        if (ym2 != null) {
            ym2.Dq();
        }
    }

    public com.bytedance.sdk.openadsdk.EjP.Ym sef() {
        return this.HiB;
    }

    public void uA() {
        this.Sj.Sj("showPlayableEndCardOverlay", (JSONObject) null);
        this.FPG.HpB.sendEmptyMessageDelayed(600, 1000L);
        this.FPG.HpB.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.Sj.TzV.6
            @Override // java.lang.Runnable
            public void run() {
                TzV.this.xhi();
            }
        }, 1000L);
        com.bytedance.sdk.openadsdk.utils.Fmk fmk = this.FPG.f21078xu;
        if (fmk != null) {
            fmk.Sj(0L);
        }
    }

    public String uP() {
        return this.EjP;
    }

    public void uvD() {
        com.bytedance.sdk.component.uA.vS vSVar = this.dNu;
        if (vSVar != null) {
            JcM.Sj(vSVar.getWebView());
        }
        com.bytedance.sdk.component.uA.vS vSVar2 = this.TzV;
        if (vSVar2 != null) {
            JcM.Sj(vSVar2.getWebView());
        }
        long j11 = this.f21081db;
        if (j11 > 0) {
            if (this.xhi > 0) {
                this.f21081db = j11 + (SystemClock.elapsedRealtime() - this.xhi);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("endcard_overlay_render_type", sU.TKC(this.Ym) ? 7 : 0);
            } catch (Throwable unused) {
            }
            com.bytedance.sdk.openadsdk.EjP.TKC.Sj(this.FPG.sP, this.f21080aa, "second_endcard_duration", jSONObject, this.f21081db);
        }
        this.dNu = null;
        if (this.Dq != null && !com.bytedance.sdk.openadsdk.core.model.TzV.EjP(this.Ym) && !com.bytedance.sdk.openadsdk.core.model.TzV.HiB(this.Ym) && !sU.TKC(this.Ym)) {
            this.Dq.Sj(true);
            this.Dq.aa();
        }
        Yf yf2 = this.Sj;
        if (yf2 != null) {
            yf2.aa();
        }
        Yf yf3 = this.sP;
        if (yf3 != null) {
            yf3.aa();
        }
        com.bytedance.sdk.openadsdk.EjP.Ym ym2 = this.HiB;
        if (ym2 != null) {
            ym2.EjP(this.Ym.Ei() || uP.Jcg(this.Ym));
        }
        DeviceUtils.AudioInfoReceiver.sP(this);
    }

    public void vS() {
        if (TextUtils.isEmpty(sU.Sj(this.FPG.Ei, this.Ym))) {
            sU sUVar = this.Ym;
            if (sUVar != null && !sUVar.Za() && this.sdp == null && dNu()) {
                this.dwU = this.Ym.eMB();
                this.sdp = com.bytedance.sdk.openadsdk.Jcg.sP.Sj().sP();
                int Sj2 = com.bytedance.sdk.openadsdk.Jcg.sP.Sj().Sj(this.sdp, this.dwU);
                this.qRN = Sj2;
                this.UHs = Sj2 > 0 ? 2 : 0;
                if (!TextUtils.isEmpty(this.dwU)) {
                    com.bytedance.sdk.openadsdk.EjP.Ym ym2 = this.HiB;
                    if (ym2 != null) {
                        ym2.Sj(this.UHs);
                    }
                    TKC.Sj.Sj(this.pfr, this.Ym, "landingpage_endcard", this.sdp, this.dwU);
                }
            }
            if ((!TextUtils.isEmpty(this.EjP) && this.EjP.contains("play.google.com/store")) || com.bytedance.sdk.openadsdk.core.model.TzV.vS(this.Ym) || com.bytedance.sdk.openadsdk.core.model.TzV.HiB(this.Ym)) {
                this.uA = true;
                return;
            }
            StringBuilder sb2 = new StringBuilder("preLoadEndCardForce: return mShouldPreloadEndCard ");
            sb2.append(this.TKC);
            sb2.append(",webViewIsLoading ");
            sb2.append(this.Bml);
            if (this.TKC) {
                if (this.dNu == null || TextUtils.isEmpty(this.EjP) || !sU.sP(this.Ym)) {
                    if (sU.TKC(this.Ym)) {
                        this.FPG.WMZ.TKC();
                    }
                } else {
                    if (this.Bml) {
                        return;
                    }
                    String str = this.EjP + "&is_pre_render=1";
                    com.bytedance.sdk.openadsdk.EjP.Ym ym3 = this.HiB;
                    if (ym3 != null) {
                        ym3.EjP();
                    }
                    if (uP.Jcg(this.Ym)) {
                        com.bytedance.sdk.openadsdk.core.aa.TKC.Sj.Sj().sP(this.Ym);
                    }
                    com.bytedance.sdk.openadsdk.utils.sU.Sj(this.dNu, str);
                    this.FPG.uP.Sj(str);
                    this.Bml = true;
                }
            }
        }
    }

    public void vS(boolean z10) {
        this.Ei = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("endcard_overlay_render_type", sU.TKC(this.Ym) ? 7 : 0);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.EjP.TKC.sP(this.Ym, this.f21080aa, "use_second_endcard", jSONObject);
        this.xhi = SystemClock.elapsedRealtime();
        try {
            if (!sU.TKC(this.Ym)) {
                this.Sj.Sj("click_endcard_close", (JSONObject) null);
            } else if (z10) {
                this.FPG.WMZ.Dq();
                com.bytedance.sdk.openadsdk.EjP.TKC.sP(this.Ym, this.f21080aa, "endcard_close_skip", jSONObject);
            }
        } catch (Exception unused2) {
        }
        this.FPG.f21078xu.Sj(r5.Dq);
    }

    public boolean wE() {
        return sU.TKC(this.Ym) ? this.f21084jb && !this.Ei && this.FPG.WMZ.aa() : this.f21084jb && !this.Ei && this.sU.get() && this.f21082dx;
    }

    public boolean xD() {
        return this.cX;
    }

    public void zR() {
        com.bytedance.sdk.component.uA.vS vSVar = this.dNu;
        if (vSVar != null) {
            vSVar.Fmk();
        }
        com.bytedance.sdk.component.uA.vS vSVar2 = this.TzV;
        if (vSVar2 != null) {
            vSVar2.Fmk();
        }
        if (this.xhi == 0) {
            this.xhi = SystemClock.elapsedRealtime();
        }
        Yf yf2 = this.Sj;
        if (yf2 != null) {
            yf2.Ym();
            com.bytedance.sdk.component.uA.vS vSVar3 = this.dNu;
            if (vSVar3 != null) {
                if (vSVar3.getVisibility() == 0) {
                    this.Sj.sP(true);
                    sP(this.Sj, true);
                    Sj(this.Sj, false, true);
                    if (uP.TEQ(this.Ym) && !this.Fm && this.FPG.sP.UmR()) {
                        uA();
                    }
                } else {
                    this.Sj.sP(false);
                    sP(this.Sj, false);
                    Sj(this.Sj, true, false);
                }
            }
        }
        if (this.sP != null && uP.Dq(this.Ym)) {
            this.sP.Ym();
            com.bytedance.sdk.component.uA.vS vSVar4 = this.TzV;
            if (vSVar4 != null) {
                if (vSVar4.getVisibility() == 0) {
                    this.sP.sP(true);
                    sP(this.sP, true);
                    Sj(this.sP, false, true);
                    if (!this.Fm && this.FPG.sP.UmR()) {
                        db();
                    }
                } else {
                    this.sP.sP(false);
                    sP(this.sP, false);
                    Sj(this.sP, true, false);
                }
            }
        }
        com.bytedance.sdk.openadsdk.EjP.Ym ym2 = this.HiB;
        if (ym2 != null) {
            ym2.Jcg();
        }
    }
}
