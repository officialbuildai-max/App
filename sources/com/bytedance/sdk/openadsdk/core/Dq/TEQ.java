package com.bytedance.sdk.openadsdk.core.Dq;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.bytedance.sdk.component.adexpress.EjP.uA;
import com.bytedance.sdk.openadsdk.core.Yf;
import com.bytedance.sdk.openadsdk.core.model.sU;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class TEQ extends com.bytedance.sdk.openadsdk.core.widget.Sj.HiB {
    public ArrayList<Integer> Sj;
    private com.bytedance.sdk.component.adexpress.sP.Fmk TEQ;
    private final com.bytedance.sdk.openadsdk.core.model.sU sP;

    public TEQ(Context context, Yf yf2, com.bytedance.sdk.openadsdk.core.model.sU sUVar, com.bytedance.sdk.openadsdk.EjP.Ym ym2, com.bytedance.sdk.component.adexpress.sP.Fmk fmk) {
        super(context, yf2, sUVar.aZ(), ym2, false);
        this.Sj = new ArrayList<>();
        this.sP = sUVar;
        this.TEQ = fmk;
    }

    private String EjP() {
        com.bytedance.sdk.openadsdk.core.model.sU sUVar = this.sP;
        if (sUVar == null) {
            return null;
        }
        if (sUVar.xhi() != null) {
            return this.sP.xhi().Fmk();
        }
        if (this.sP.ndK() != null) {
            return "v3";
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.webkit.WebResourceResponse HiB() {
        /*
            r4 = this;
            com.bytedance.sdk.openadsdk.core.uA r0 = com.bytedance.sdk.openadsdk.core.uA.sP()
            int r0 = r0.uA()
            r1 = 0
            if (r0 != 0) goto Lc
            return r1
        Lc:
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.dNu.Sj()
            android.content.res.Resources r2 = r2.getResources()
            if (r2 == 0) goto L25
            java.io.InputStream r0 = r2.openRawResource(r0)     // Catch: android.content.res.Resources.NotFoundException -> L1b
            goto L26
        L1b:
            r0 = move-exception
            java.lang.String r2 = "ExpressClient"
            java.lang.String r0 = r0.toString()
            com.bytedance.sdk.component.utils.sU.sP(r2, r0)
        L25:
            r0 = r1
        L26:
            if (r0 == 0) goto L35
            android.webkit.WebResourceResponse r1 = new android.webkit.WebResourceResponse
            com.bytedance.sdk.component.adexpress.EjP.uA$Sj r2 = com.bytedance.sdk.component.adexpress.EjP.uA.Sj.IMAGE
            java.lang.String r2 = r2.Sj()
            java.lang.String r3 = "UTF-8"
            r1.<init>(r2, r3, r0)
        L35:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.Dq.TEQ.HiB():android.webkit.WebResourceResponse");
    }

    private WebResourceResponse HiB(String str) {
        InputStream Sj;
        if (TextUtils.isEmpty(str) || (Sj = com.bytedance.sdk.openadsdk.core.EjP.Sj.Sj().Sj(str)) == null) {
            return null;
        }
        WebResourceResponse webResourceResponse = new WebResourceResponse("audio/*", "UTF-8", Sj);
        Sj(webResourceResponse);
        return webResourceResponse;
    }

    private WebResourceResponse Sj(String str, String str2) {
        WebResourceResponse webResourceResponse = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            InputStream Sj = com.bytedance.sdk.openadsdk.uA.EjP.Sj(str, str2);
            if (Sj == null) {
                return null;
            }
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(uA.Sj.IMAGE.Sj(), "utf-8", Sj);
            try {
                Sj(webResourceResponse2);
                return webResourceResponse2;
            } catch (Throwable th2) {
                th = th2;
                webResourceResponse = webResourceResponse2;
                com.bytedance.sdk.component.utils.sU.Sj("ExpressClient", "get image WebResourceResponse error", th);
                return webResourceResponse;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private com.bytedance.sdk.component.adexpress.Sj.sP.Sj Sj(WebView webView, String str) {
        com.bytedance.sdk.openadsdk.core.model.uvD uvd = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals("local://pag_open_icon_id") || str.equals(com.bytedance.sdk.openadsdk.core.Dq.Sj.sP.Sj)) {
            com.bytedance.sdk.component.adexpress.Sj.sP.Sj sj2 = new com.bytedance.sdk.component.adexpress.Sj.sP.Sj();
            sj2.Sj(5);
            sj2.Sj(HiB());
            return sj2;
        }
        sU.Sj xhi = this.sP.xhi();
        if (xhi != null && !TextUtils.isEmpty(str) && str.equals(xhi.EjP())) {
            com.bytedance.sdk.component.adexpress.Sj.sP.Sj sj3 = new com.bytedance.sdk.component.adexpress.Sj.sP.Sj();
            sj3.Sj(5);
            WebResourceResponse HiB = HiB(str);
            sj3.Sj(HiB);
            com.bytedance.sdk.openadsdk.core.EjP.Sj.Sj().Sj(HiB != null);
            return sj3;
        }
        uA.Sj Sj = com.bytedance.sdk.component.adexpress.EjP.uA.Sj(str);
        if (Sj != uA.Sj.IMAGE) {
            Iterator<com.bytedance.sdk.openadsdk.core.model.uvD> it = this.sP.Bml().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.bytedance.sdk.openadsdk.core.model.uvD next = it.next();
                if (!TextUtils.isEmpty(next.Sj()) && !TextUtils.isEmpty(str)) {
                    String Sj2 = next.Sj();
                    if (Sj2.startsWith("https")) {
                        Sj2 = Sj2.replaceFirst("https", "http");
                    }
                    if ((str.startsWith("https") ? str.replaceFirst("https", "http") : str).equals(Sj2)) {
                        uvd = next;
                        break;
                    }
                }
            }
        }
        if (Sj != uA.Sj.IMAGE && uvd == null) {
            return com.bytedance.sdk.component.adexpress.Sj.sP.sP.Sj(str, Sj, "", EjP());
        }
        com.bytedance.sdk.component.adexpress.Sj.sP.Sj sj4 = new com.bytedance.sdk.component.adexpress.Sj.sP.Sj();
        sj4.Sj(5);
        sj4.Sj(Sj(str, com.bytedance.sdk.openadsdk.core.Dq.Sj.sP.Sj(this.sP, str)));
        return sj4;
    }

    private void Sj(long j11, long j12, String str, int i11) {
        com.bytedance.sdk.openadsdk.EjP.Ym ym2 = this.vS;
        if (ym2 == null || ym2.sP() == null) {
            return;
        }
        uA.Sj Sj = com.bytedance.sdk.component.adexpress.EjP.uA.Sj(str);
        if (Sj == uA.Sj.HTML) {
            this.vS.sP().Sj(str, j11, j12, i11);
        } else if (Sj == uA.Sj.JS) {
            this.vS.sP().sP(str, j11, j12, i11);
        }
    }

    private void Sj(WebResourceResponse webResourceResponse) {
        if (webResourceResponse == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(OSSHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        webResourceResponse.setResponseHeaders(hashMap);
    }

    public int Sj() {
        Iterator<Integer> it = this.Sj.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (next.intValue() == 3 || next.intValue() == 2 || next.intValue() == -1) {
                return next.intValue();
            }
        }
        return TextUtils.isEmpty(EjP()) ? -1 : 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.Jcg = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.Dq = false;
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.Sj("ExpressClient", "shouldInterceptRequest error1", th2);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.Sj.HiB, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.adexpress.Sj.sP.Sj Sj = Sj(webView, str);
            Sj(currentTimeMillis, System.currentTimeMillis(), str, (Sj == null || Sj.Sj() == null) ? 2 : 1);
            if (Sj != null && Sj.sP() != 5) {
                Sj.sP();
                this.Sj.add(Integer.valueOf(Sj.sP()));
            }
            if (Sj != null && Sj.Sj() != null) {
                return Sj.Sj();
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.sU.Sj("ExpressClient", "shouldInterceptRequest error2", th2);
        }
        return super.shouldInterceptRequest(webView, str);
    }
}
