package com.bytedance.sdk.openadsdk.core.Dq;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.component.uA.vS;
import com.bytedance.sdk.openadsdk.core.Dq.TKC;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class HiB extends com.bytedance.sdk.component.uA.vS implements TKC.InterfaceC0260TKC {
    private zR Dq;
    protected boolean EjP;
    private List<String> Fmk;
    protected boolean HiB;
    AtomicBoolean Jcg;
    private com.bytedance.sdk.openadsdk.core.model.sU TEQ;
    private String Ym;
    private int Zq;

    /* renamed from: aa, reason: collision with root package name */
    private int f21095aa;
    private sP sef;
    private TKC uA;
    private long uvD;
    AtomicBoolean vS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class Sj extends vS.Sj {
        public static final Set<String> Sj = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.core.Dq.HiB.Sj.1
            {
                add(".jpeg");
                add(".png");
                add(".bmp");
                add(".gif");
                add(".jpg");
                add(".webp");
            }
        };
        TKC.InterfaceC0260TKC sP;

        public Sj(TKC.InterfaceC0260TKC interfaceC0260TKC) {
            this.sP = interfaceC0260TKC;
        }

        private void Sj(String str) {
            int lastIndexOf;
            TKC.InterfaceC0260TKC interfaceC0260TKC;
            if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(".")) > 0) {
                if (!Sj.contains(str.substring(lastIndexOf).toLowerCase()) || (interfaceC0260TKC = this.sP) == null) {
                    return;
                }
                interfaceC0260TKC.sP(str);
            }
        }

        private void Sj(String str, int i11, String str2) {
            TKC.InterfaceC0260TKC interfaceC0260TKC = this.sP;
            if (interfaceC0260TKC != null) {
                interfaceC0260TKC.Sj(106, i11);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            TKC.InterfaceC0260TKC interfaceC0260TKC = this.sP;
            if (interfaceC0260TKC != null) {
                interfaceC0260TKC.Sj();
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            super.onReceivedError(webView, i11, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                return;
            }
            Sj(webResourceRequest.getUrl().toString());
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest == null || webResourceResponse == null || webResourceRequest.getUrl() == null) {
                return;
            }
            if (webResourceRequest.isForMainFrame()) {
                Sj(webResourceRequest.getUrl().toString(), webResourceResponse.getStatusCode(), "");
            }
            Sj(webResourceRequest.getUrl().toString());
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            this.sP.Sj(str);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static class TKC {
        protected int Sj = 0;
        private com.bytedance.sdk.openadsdk.core.Ym.vS sP = com.bytedance.sdk.openadsdk.core.Ym.vS.Sj();

        TKC() {
        }

        public void Sj() {
            com.bytedance.sdk.openadsdk.core.Ym.vS vSVar;
            int i11 = this.Sj;
            if (i11 != 0 && i11 != 4 && (vSVar = this.sP) != null) {
                vSVar.EjP();
            }
            this.Sj = 4;
            this.sP = null;
        }

        public void Sj(@Nullable View view, @Nullable FriendlyObstructionPurpose friendlyObstructionPurpose) {
            com.bytedance.sdk.openadsdk.core.Ym.vS vSVar = this.sP;
            if (vSVar != null) {
                vSVar.Sj(view, friendlyObstructionPurpose);
            }
        }

        public void Sj(WebView webView) {
            if (webView != null && this.Sj == 0) {
                if (this.sP == null) {
                    this.sP = com.bytedance.sdk.openadsdk.core.Ym.vS.Sj();
                }
                this.sP.Sj(webView);
                this.sP.sP();
                this.Sj = 1;
            }
        }

        public void Sj(boolean z10) {
            com.bytedance.sdk.openadsdk.core.Ym.vS vSVar;
            if (this.Sj == 1 && z10 && (vSVar = this.sP) != null) {
                vSVar.TKC();
                this.Sj = 3;
            }
        }

        public void sP() {
            Sj();
        }
    }

    /* loaded from: classes3.dex */
    public interface sP {
        View Sj();

        void Sj(int i11, int i12);

        void Sj(View view, int i11);

        void e_();

        View sP();
    }

    public HiB(Context context) {
        super(context);
        this.EjP = false;
        this.HiB = false;
        this.vS = new AtomicBoolean(false);
        this.Jcg = new AtomicBoolean(false);
        this.f21095aa = 0;
    }

    private void dx() {
        if (this.Fmk == null) {
            com.bytedance.sdk.openadsdk.EjP.TKC.sP(this.TEQ, this.Ym, "dsp_html_success_url", (JSONObject) null);
        } else {
            com.bytedance.sdk.openadsdk.EjP.TKC.Sj(new com.bytedance.sdk.component.Dq.Dq("dsp_html_error_url") { // from class: com.bytedance.sdk.openadsdk.core.Dq.HiB.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (HiB.this.Fmk != null && HiB.this.Jcg.compareAndSet(false, true)) {
                            JSONObject jSONObject = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            Iterator it = HiB.this.Fmk.iterator();
                            while (it.hasNext()) {
                                jSONArray.put((String) it.next());
                            }
                            jSONObject.put("url", jSONArray);
                            com.bytedance.sdk.openadsdk.EjP.TKC.sP(HiB.this.TEQ, HiB.this.Ym, "dsp_html_error_url", jSONObject);
                            HiB.this.Fmk = null;
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    public void RiZ() {
        sP sPVar = this.sef;
        if (sPVar != null) {
            sPVar.e_();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_duration", SystemClock.elapsedRealtime() - this.uvD);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.EjP.TKC.sP(this.TEQ, this.Ym, "render_html_success", jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Dq.TKC.InterfaceC0260TKC
    public void Sj() {
        if (this.vS.compareAndSet(false, true)) {
            this.EjP = true;
            this.uA.Sj(getWebView());
            this.uA.Sj(this.HiB);
            RiZ();
            dx();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.Dq.TKC.InterfaceC0260TKC
    public void Sj(int i11, int i12) {
        sP sPVar = this.sef;
        if (sPVar != null) {
            sPVar.Sj(i11, i12);
        }
        this.f21095aa = i12;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("error_code", i12);
            jSONObject.put("render_duration", SystemClock.elapsedRealtime() - this.uvD);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.EjP.TKC.sP(this.TEQ, this.Ym, "render_html_fail", jSONObject);
    }

    public void Sj(@Nullable View view, @Nullable FriendlyObstructionPurpose friendlyObstructionPurpose) {
        this.uA.Sj(view, friendlyObstructionPurpose);
    }

    public void Sj(com.bytedance.sdk.openadsdk.core.model.sU sUVar, sP sPVar, String str) {
        this.sef = sPVar;
        this.TEQ = sUVar;
        this.Ym = str;
        this.uA = new TKC();
        this.Dq = new zR(getContext());
        setWebViewClient(new Sj(this));
        setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.sdk.openadsdk.core.Dq.HiB.1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i11) {
                HiB.this.Zq = i11;
                super.onProgressChanged(webView, i11);
                if (i11 >= 100) {
                    HiB.this.Sj();
                }
            }
        });
        com.bytedance.sdk.component.utils.uA.sP().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Dq.HiB.2
            @Override // java.lang.Runnable
            @SuppressLint({"ClickableViewAccessibility"})
            public void run() {
                WebView webView = HiB.this.getWebView();
                if (webView != null) {
                    webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.Dq.HiB.2.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            HiB.this.Dq.onTouchEvent(motionEvent);
                            return false;
                        }
                    });
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @Override // com.bytedance.sdk.openadsdk.core.Dq.TKC.InterfaceC0260TKC
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Sj(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.Dq.HiB.Sj(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.uA.vS, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.EjP) {
            this.uA.Sj(getWebView());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.uA.vS, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.uA.Sj();
        super.onDetachedFromWindow();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("rate", this.Zq / 100.0f);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.EjP.TKC.sP(this.TEQ, this.Ym, "load_rate", jSONObject);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i11) {
        super.onVisibilityChanged(view, i11);
        boolean z10 = i11 == 0;
        this.HiB = z10;
        this.uA.Sj(z10);
    }

    @Override // com.bytedance.sdk.openadsdk.core.Dq.TKC.InterfaceC0260TKC
    public void sP(String str) {
        if (this.Fmk == null) {
            this.Fmk = new ArrayList();
        }
        this.Fmk.add(str);
    }

    public void sU() {
        this.vS.set(false);
        String TX = this.TEQ.TX();
        if (TextUtils.isEmpty(TX)) {
            return;
        }
        String Sj2 = com.bytedance.sdk.openadsdk.core.Ym.HiB.Sj(TX);
        String str = TextUtils.isEmpty(Sj2) ? TX : Sj2;
        this.f21095aa = 0;
        Sj(null, str, "text/html", "UTF-8", null);
        this.uvD = SystemClock.elapsedRealtime();
    }

    @Override // com.bytedance.sdk.component.uA.vS
    public void uvD() {
        this.uA.sP();
        super.uvD();
    }
}
