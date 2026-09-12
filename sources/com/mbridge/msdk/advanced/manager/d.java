package com.mbridge.msdk.advanced.manager;

import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.setting.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f34212a = "ResManager";

    /* renamed from: b, reason: collision with root package name */
    private static int f34213b = 1;

    /* renamed from: c, reason: collision with root package name */
    public static e f34214c = e.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends com.mbridge.msdk.mbsignalcommon.listener.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f34215a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f34216b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CampaignEx f34217c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MBNativeAdvancedView f34218d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f34219e;

        a(String str, String str2, CampaignEx campaignEx, MBNativeAdvancedView mBNativeAdvancedView, long j11) {
            this.f34215a = str;
            this.f34216b = str2;
            this.f34217c = campaignEx;
            this.f34218d = mBNativeAdvancedView;
            this.f34219e = j11;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i11) {
            super.a(webView, i11);
            if (i11 != 1) {
                this.f34218d.setH5Ready(false);
                o0.a("WindVaneWebView", "======渲染失败");
                com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f34217c, this.f34216b, "readyState 2", this.f34219e, 3);
                return;
            }
            com.mbridge.msdk.advanced.common.c.a(this.f34215a + this.f34216b + this.f34217c.getRequestId(), true);
            this.f34218d.setH5Ready(true);
            o0.a("WindVaneWebView", "======渲染成功：ready");
            com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f34217c, this.f34216b, "", this.f34219e, 1);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i11, String str, String str2) {
            super.a(webView, i11, str, str2);
            this.f34218d.setH5Ready(false);
            o0.a("WindVaneWebView", "======渲染失败");
            com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f34217c, this.f34216b, "error code:" + i11 + str, this.f34219e, 3);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.a(webView, sslErrorHandler, sslError);
            this.f34218d.setH5Ready(false);
            o0.a("WindVaneWebView", "======渲染失败");
            com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f34217c, this.f34216b, "error url:" + sslError.getUrl(), this.f34219e, 3);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            super.a(webView, str);
            if (!this.f34217c.isHasMBTplMark()) {
                com.mbridge.msdk.advanced.common.c.a(this.f34215a + this.f34216b + this.f34217c.getRequestId(), true);
                this.f34218d.setH5Ready(true);
                o0.a("WindVaneWebView", "======渲染成功：finish");
                com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f34217c, this.f34216b, "", this.f34219e, 1);
            }
            com.mbridge.msdk.advanced.signal.a.a(webView);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MBNativeAdvancedWebview f34220a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f34221b;

        b(MBNativeAdvancedWebview mBNativeAdvancedWebview, String str) {
            this.f34220a = mBNativeAdvancedWebview;
            this.f34221b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f34220a.loadUrl(this.f34221b);
        }
    }

    public static CampaignEx a(MBNativeAdvancedView mBNativeAdvancedView, String str, String str2, String str3, int i11, boolean z10, boolean z11) {
        com.mbridge.msdk.setting.g d11 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d11 == null) {
            d11 = h.b().a();
        }
        long Z = d11.Z() * 1000;
        long a02 = d11.a0() * 1000;
        a(a02, str2);
        List<CampaignEx> a11 = a(str2, str3);
        if (a11 == null || a11.size() <= 0) {
            return null;
        }
        CampaignEx campaignEx = a11.get(0);
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = currentTimeMillis - Z;
        if (!z10) {
            if ((campaignEx.getPlct() <= 0 || (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() < currentTimeMillis) && (campaignEx.getPlct() > 0 || campaignEx.getTimestamp() < j11)) {
                o0.a(f34212a, "========已经超了缓存时间");
                if (campaignEx.isSpareOffer(Z, a02) || mBNativeAdvancedView == null) {
                    return null;
                }
                mBNativeAdvancedView.setVisibility(8);
                return null;
            }
            if (!a(mBNativeAdvancedView, campaignEx, str, str2, i11, z11)) {
                return null;
            }
            o0.b(f34212a, "cache campain is picked:" + campaignEx.getAppName());
            return a(campaignEx);
        }
        if ((campaignEx.getPlct() <= 0 || (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() < currentTimeMillis) && (campaignEx.getPlct() > 0 || campaignEx.getTimestamp() < j11)) {
            if (a(mBNativeAdvancedView, campaignEx, str, str2, i11, z11) && campaignEx.isSpareOffer(Z, a02)) {
                return a(campaignEx);
            }
            if (campaignEx.isSpareOffer(Z, a02) || mBNativeAdvancedView == null) {
                return null;
            }
            mBNativeAdvancedView.setVisibility(8);
            return null;
        }
        if (!a(mBNativeAdvancedView, campaignEx, str, str2, i11, z11)) {
            return null;
        }
        o0.b(f34212a, "cache campain is picked:" + campaignEx.getAppName());
        return a(campaignEx);
    }

    private static CampaignEx a(CampaignEx campaignEx) {
        if (!TextUtils.isEmpty(campaignEx.getAdZip()) || (!TextUtils.isEmpty(campaignEx.getAdHtml()) && campaignEx.getAdHtml().contains("<MBTPLMARK>"))) {
            campaignEx.setHasMBTplMark(true);
            campaignEx.setIsMraid(false);
        } else {
            campaignEx.setHasMBTplMark(false);
            campaignEx.setIsMraid(true);
        }
        return campaignEx;
    }

    private static String a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return "file:///" + file.getAbsolutePath();
            }
            return "";
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Exception e11) {
                e11.getMessage();
            }
        }
    }

    private static List<CampaignEx> a(String str, String str2) {
        if (f34214c == null) {
            f34214c = e.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        return f34214c.b(str, 0, 0, f34213b);
    }

    public static void a(long j11, String str) {
        if (f34214c == null) {
            f34214c = e.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        f34214c.a(j11, str);
    }

    private static void a(MBNativeAdvancedView mBNativeAdvancedView, String str, CampaignEx campaignEx, String str2, String str3, int i11) {
        if (mBNativeAdvancedView == null || mBNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        com.mbridge.msdk.advanced.report.a.b(str3, campaignEx);
        com.mbridge.msdk.advanced.signal.b bVar = new com.mbridge.msdk.advanced.signal.b(mBNativeAdvancedView.getContext(), str2, str3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        bVar.a(arrayList);
        bVar.a(i11);
        mBNativeAdvancedView.setAdvancedNativeSignalCommunicationImpl(bVar);
        MBNativeAdvancedWebview advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview();
        long currentTimeMillis = System.currentTimeMillis();
        advancedNativeWebview.setWebViewListener(new a(str2, str3, campaignEx, mBNativeAdvancedView, currentTimeMillis));
        if (advancedNativeWebview.isDestoryed()) {
            mBNativeAdvancedView.setH5Ready(false);
            com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx, str3, "webview had destory", currentTimeMillis, 3);
            return;
        }
        o0.a(f34212a, "======开始渲染：" + str);
        new Handler(Looper.getMainLooper()).post(new b(advancedNativeWebview, str));
    }

    public static void a(CampaignEx campaignEx, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        if (f34214c == null) {
            f34214c = e.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        f34214c.a(arrayList, str);
    }

    public static boolean a(MBNativeAdvancedView mBNativeAdvancedView, CampaignEx campaignEx, String str, String str2) {
        boolean z10;
        boolean z11 = false;
        if (mBNativeAdvancedView == null) {
            o0.b(f34212a, "mbAdvancedNativeView  is null");
            return false;
        }
        if (TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            z10 = true;
        } else {
            z10 = mBNativeAdvancedView.isVideoReady();
            o0.b(f34212a, "======isReady isVideoReady:" + z10);
        }
        if (z10 && !TextUtils.isEmpty(campaignEx.getAdZip())) {
            z10 = com.mbridge.msdk.advanced.common.c.a(str + str2 + campaignEx.getRequestId());
            o0.b(f34212a, "======isReady getAdZip:" + z10);
        }
        if (z10 && TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml())) {
            z10 = com.mbridge.msdk.advanced.common.c.a(str + str2 + campaignEx.getRequestId());
            o0.b(f34212a, "======isReady getAdHtml:" + z10);
        }
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            o0.b(f34212a, "======isReady getAdHtml  getAdZip all are empty");
        } else {
            z11 = z10;
        }
        if (!z11 || TextUtils.isEmpty(campaignEx.getendcard_url())) {
            return z11;
        }
        boolean isEndCardReady = mBNativeAdvancedView.isEndCardReady();
        o0.b(f34212a, "======isReady isEndCardReady:" + isEndCardReady);
        return isEndCardReady;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x009d, code lost:
    
        if (r17 == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(com.mbridge.msdk.advanced.view.MBNativeAdvancedView r12, com.mbridge.msdk.foundation.entity.CampaignEx r13, java.lang.String r14, java.lang.String r15, int r16, boolean r17) {
        /*
            r6 = r12
            r7 = r14
            r8 = r15
            r9 = 0
            if (r13 == 0) goto Lff
            r12.clearResState()
            java.lang.String r0 = r13.getVideoUrlEncode()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r10 = 1
            if (r0 != 0) goto L29
            com.mbridge.msdk.videocommon.download.b r0 = com.mbridge.msdk.videocommon.download.b.getInstance()
            boolean r1 = r13.isBidCampaign()
            r2 = 298(0x12a, float:4.18E-43)
            boolean r0 = r0.b(r2, r15, r1)
            if (r0 == 0) goto L27
            r12.setVideoReady(r10)
        L27:
            r11 = r0
            goto L2d
        L29:
            r12.setVideoReady(r10)
            r11 = r10
        L2d:
            java.lang.String r0 = r13.getendcard_url()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L52
            boolean r0 = r12.isEndCardReady()
            if (r0 != 0) goto L52
            com.mbridge.msdk.foundation.download.download.H5DownLoadManager r0 = com.mbridge.msdk.foundation.download.download.H5DownLoadManager.getInstance()
            java.lang.String r1 = r13.getendcard_url()
            java.lang.String r0 = r0.getH5ResAddress(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L52
            r12.setEndCardReady(r10)
        L52:
            java.lang.String r0 = r13.getAdZip()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto La0
            boolean r0 = r12.isH5Ready()
            if (r0 != 0) goto La0
            com.mbridge.msdk.foundation.download.download.H5DownLoadManager r0 = com.mbridge.msdk.foundation.download.download.H5DownLoadManager.getInstance()
            java.lang.String r1 = r13.getAdZip()
            java.lang.String r1 = r0.getH5ResAddress(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L9f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r14)
            r0.append(r15)
            java.lang.String r2 = r13.getRequestId()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            boolean r0 = com.mbridge.msdk.advanced.common.c.a(r0)
            if (r0 == 0) goto L94
            r12.setH5Ready(r10)
            goto La0
        L94:
            r0 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            a(r0, r1, r2, r3, r4, r5)
            if (r17 != 0) goto La0
        L9f:
            r11 = r9
        La0:
            java.lang.String r0 = r13.getAdZip()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto Lfe
            java.lang.String r0 = r13.getAdHtml()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto Lfe
            boolean r0 = r12.isH5Ready()
            if (r0 != 0) goto Lfe
            java.lang.String r0 = r13.getAdHtml()
            java.lang.String r1 = a(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto Lff
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r14)
            r0.append(r15)
            java.lang.String r2 = r13.getRequestId()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            boolean r0 = com.mbridge.msdk.advanced.common.c.a(r0)
            if (r0 == 0) goto Lf2
            r12.setH5Ready(r10)
            boolean r0 = r13.isMraid()
            if (r0 == 0) goto Lf0
            r12.setVideoReady(r10)
        Lf0:
            r9 = r10
            goto Lff
        Lf2:
            r0 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            a(r0, r1, r2, r3, r4, r5)
            if (r17 != 0) goto Lfe
            goto Lff
        Lfe:
            r9 = r11
        Lff:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.advanced.manager.d.a(com.mbridge.msdk.advanced.view.MBNativeAdvancedView, com.mbridge.msdk.foundation.entity.CampaignEx, java.lang.String, java.lang.String, int, boolean):boolean");
    }

    public static void b(String str) {
        if (f34214c == null) {
            f34214c = e.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        f34214c.a(str, 0, f34213b);
    }
}
