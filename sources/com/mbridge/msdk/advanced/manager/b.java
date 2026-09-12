package com.mbridge.msdk.advanced.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.y0;
import com.mbridge.msdk.out.MBridgeIds;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: z, reason: collision with root package name */
    private static String f34140z = "NativeAdvancedLoadManager";

    /* renamed from: a, reason: collision with root package name */
    private String f34141a;

    /* renamed from: b, reason: collision with root package name */
    private String f34142b;

    /* renamed from: c, reason: collision with root package name */
    private long f34143c;

    /* renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.advanced.middle.b f34144d;

    /* renamed from: f, reason: collision with root package name */
    private MBNativeAdvancedView f34146f;

    /* renamed from: g, reason: collision with root package name */
    private com.mbridge.msdk.setting.l f34147g;

    /* renamed from: h, reason: collision with root package name */
    private List<CampaignEx> f34148h;

    /* renamed from: i, reason: collision with root package name */
    private CampaignEx f34149i;

    /* renamed from: j, reason: collision with root package name */
    private int f34150j;

    /* renamed from: k, reason: collision with root package name */
    private int f34151k;

    /* renamed from: l, reason: collision with root package name */
    private int f34152l;

    /* renamed from: m, reason: collision with root package name */
    private int f34153m;

    /* renamed from: n, reason: collision with root package name */
    private String f34154n;

    /* renamed from: o, reason: collision with root package name */
    private int f34155o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f34156p;

    /* renamed from: q, reason: collision with root package name */
    private volatile boolean f34157q;

    /* renamed from: r, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f34158r;

    /* renamed from: s, reason: collision with root package name */
    private H5DownLoadManager.ZipDownloadListener f34159s;

    /* renamed from: t, reason: collision with root package name */
    private H5DownLoadManager.ZipDownloadListener f34160t;

    /* renamed from: u, reason: collision with root package name */
    private String f34161u;

    /* renamed from: v, reason: collision with root package name */
    private int f34162v;

    /* renamed from: w, reason: collision with root package name */
    private String f34163w = "";

    /* renamed from: x, reason: collision with root package name */
    private Handler f34164x = new e(Looper.getMainLooper());

    /* renamed from: y, reason: collision with root package name */
    private Runnable f34165y = new f();

    /* renamed from: e, reason: collision with root package name */
    private Context f34145e = com.mbridge.msdk.foundation.controller.c.m().d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements H5DownLoadManager.ZipDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f34166a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f34167b;

        a(CampaignEx campaignEx, int i11) {
            this.f34166a = campaignEx;
            this.f34167b = i11;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            o0.a(b.f34140z, "zip 下载失败： " + str2 + " " + str);
            Message obtain = Message.obtain();
            obtain.what = 2;
            Bundle bundle = new Bundle();
            bundle.putSerializable("campaignex", this.f34166a);
            bundle.putString(NotificationCompat.CATEGORY_MESSAGE, str);
            bundle.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 3);
            obtain.obj = bundle;
            b.this.f34164x.sendMessage(obtain);
            b.this.a(this.f34166a, str2, false, str);
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z10) {
            o0.a(b.f34140z, "zip 下载成功： " + str);
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = this.f34166a;
            obtain.arg1 = this.f34167b;
            b.this.f34164x.sendMessage(obtain);
            if (z10) {
                return;
            }
            b.this.a(this.f34166a, str, true, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.advanced.manager.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0468b extends com.mbridge.msdk.mbsignalcommon.listener.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f34169a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f34170b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f34171c;

        C0468b(CampaignEx campaignEx, int i11, long j11) {
            this.f34169a = campaignEx;
            this.f34170b = i11;
            this.f34171c = j11;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i11) {
            super.a(webView, i11);
            o0.b("NativeAdvancedLoadManager", "=========readyState: " + i11);
            if (i11 != 1) {
                b.this.a(this.f34169a, "readyState 2", this.f34170b);
                com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f34169a, b.this.f34141a, "readyState 2", this.f34171c, 3);
                return;
            }
            b.this.f34146f.setH5Ready(true);
            com.mbridge.msdk.advanced.common.c.a(b.this.f34142b + b.this.f34141a + this.f34169a.getRequestId(), true);
            b.this.h(this.f34169a, this.f34170b);
            com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f34169a, b.this.f34141a, "", this.f34171c, 1);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i11, String str, String str2) {
            super.a(webView, i11, str, str2);
            o0.b("NativeAdvancedLoadManager", "onReceivedError： " + i11 + "  " + str + "  " + str2);
            b.this.a(this.f34169a, str, this.f34170b);
            com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f34169a, b.this.f34141a, "error code:" + i11 + str, this.f34171c, 3);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.a(webView, sslErrorHandler, sslError);
            o0.b("NativeAdvancedLoadManager", "onReceivedSslError: " + sslError.getPrimaryError());
            b.this.a(this.f34169a, "onReceivedSslError:" + sslError.getUrl(), this.f34170b);
            com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f34169a, b.this.f34141a, "error url:" + sslError.getUrl(), this.f34171c, 3);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            super.a(webView, str);
            o0.b("NativeAdvancedLoadManager", "onPageFinished");
            if (!this.f34169a.isHasMBTplMark()) {
                b.this.f34146f.setH5Ready(true);
                o0.b("NativeAdvancedLoadManager", "=======onPageFinished OK");
                com.mbridge.msdk.advanced.common.c.a(b.this.f34142b + b.this.f34141a + this.f34169a.getRequestId(), true);
                b.this.h(this.f34169a, this.f34170b);
                com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f34169a, b.this.f34141a, "", this.f34171c, 1);
            }
            com.mbridge.msdk.advanced.signal.a.a(webView);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MBNativeAdvancedWebview f34173a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f34174b;

        c(MBNativeAdvancedWebview mBNativeAdvancedWebview, String str) {
            this.f34173a = mBNativeAdvancedWebview;
            this.f34174b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f34173a.loadUrl(this.f34174b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f34176a;

        d(CampaignEx campaignEx) {
            this.f34176a = campaignEx;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str) {
            o0.a(b.f34140z, "Video 下载成功： " + str);
            Message obtain = Message.obtain();
            obtain.obj = this.f34176a;
            obtain.what = 5;
            b.this.f34164x.sendMessage(obtain);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str, String str2) {
            o0.a(b.f34140z, "Video 下载失败： " + str);
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putSerializable("campaignex", this.f34176a);
            bundle.putString(NotificationCompat.CATEGORY_MESSAGE, str);
            bundle.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 1);
            obtain.obj = bundle;
            obtain.what = 2;
            b.this.f34164x.sendMessage(obtain);
        }
    }

    /* loaded from: classes5.dex */
    class e extends Handler {
        e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Object obj;
            super.handleMessage(message);
            int i11 = message.what;
            if (i11 == 1) {
                Object obj2 = message.obj;
                int i12 = message.arg1;
                if (obj2 == null || !(obj2 instanceof CampaignEx)) {
                    return;
                }
                CampaignEx campaignEx = (CampaignEx) obj2;
                b.this.a(H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getAdZip()), campaignEx, i12);
                return;
            }
            if (i11 == 2) {
                Object obj3 = message.obj;
                try {
                    if (obj3 instanceof Bundle) {
                        int i13 = ((Bundle) obj3).getInt(NativeComponentConstants.KEY_COMPONENT_TYPE);
                        com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(i13 == 1 ? 880004 : i13 == 2 ? 880007 : i13 == 3 ? 880006 : 880024);
                        String string = ((Bundle) obj3).getString(NotificationCompat.CATEGORY_MESSAGE);
                        CampaignEx campaignEx2 = (CampaignEx) ((Bundle) obj3).getSerializable("campaignex");
                        bVar.c(string);
                        bVar.a(campaignEx2);
                        b bVar2 = b.this;
                        bVar2.a(bVar, bVar2.f34154n, b.this.f34155o, campaignEx2);
                        return;
                    }
                    return;
                } catch (Exception e11) {
                    com.mbridge.msdk.foundation.error.b bVar3 = new com.mbridge.msdk.foundation.error.b(880000);
                    bVar3.a((Throwable) e11);
                    b bVar4 = b.this;
                    bVar4.a(bVar3, bVar4.f34154n, b.this.f34155o, (CampaignEx) null);
                    return;
                }
            }
            if (i11 == 3) {
                Object obj4 = message.obj;
                if (obj4 == null || !(obj4 instanceof CampaignEx)) {
                    return;
                }
                b bVar5 = b.this;
                bVar5.i((CampaignEx) obj4, bVar5.f34155o);
                return;
            }
            if (i11 != 4) {
                if (i11 == 5 && (obj = message.obj) != null && (obj instanceof CampaignEx)) {
                    if (b.this.f34146f != null) {
                        b.this.f34146f.setVideoReady(true);
                    }
                    b bVar6 = b.this;
                    bVar6.i((CampaignEx) obj, bVar6.f34155o);
                    return;
                }
                return;
            }
            Object obj5 = message.obj;
            if (obj5 == null || !(obj5 instanceof CampaignEx)) {
                return;
            }
            if (b.this.f34146f != null) {
                b.this.f34146f.setEndCardReady(true);
            }
            b bVar7 = b.this;
            bVar7.i((CampaignEx) obj5, bVar7.f34155o);
        }
    }

    /* loaded from: classes5.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880010);
            b bVar2 = b.this;
            bVar2.a(bVar, bVar2.f34154n, b.this.f34155o, (CampaignEx) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class g extends com.mbridge.msdk.advanced.request.b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f34180e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f34181f;

        /* loaded from: classes5.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Exception f34183a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ int f34184b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ CampaignUnit f34185c;

            a(Exception exc, int i11, CampaignUnit campaignUnit) {
                this.f34183a = exc;
                this.f34184b = i11;
                this.f34185c = campaignUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880003);
                bVar.a((Throwable) this.f34183a);
                g gVar = g.this;
                b bVar2 = b.this;
                String str = gVar.f34180e;
                int i11 = this.f34184b;
                CampaignUnit campaignUnit = this.f34185c;
                bVar2.a(bVar, str, i11, (campaignUnit == null || campaignUnit.getAds() == null || this.f34185c.getAds().size() == 0) ? null : this.f34185c.getAds().get(0));
            }
        }

        /* renamed from: com.mbridge.msdk.advanced.manager.b$g$b, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0469b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f34187a;

            RunnableC0469b(String str) {
                this.f34187a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880002);
                bVar.c(this.f34187a);
                g gVar = g.this;
                b.this.a(bVar, gVar.f34180e, gVar.f34181f, (CampaignEx) null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i11, String str, int i12) {
            super(i11);
            this.f34180e = str;
            this.f34181f = i12;
        }

        @Override // com.mbridge.msdk.advanced.request.b
        public void a(CampaignUnit campaignUnit, int i11) {
            try {
                b bVar = b.this;
                bVar.a(campaignUnit, i11, bVar.f34141a, this.f34180e);
                b.this.f34163w = campaignUnit.getRequestId();
                b.this.f34148h = campaignUnit.getAds();
            } catch (Exception e11) {
                o0.b(b.f34140z, e11.getMessage());
                o0.c(b.f34140z, "onLoadCompaginSuccess 数据刚请求失败");
                if (b.this.f34164x != null) {
                    b.this.f34164x.post(new a(e11, i11, campaignUnit));
                }
                b.this.f();
            }
        }

        @Override // com.mbridge.msdk.advanced.request.b
        public void b(int i11, String str) {
            o0.b(b.f34140z, str);
            o0.c(b.f34140z, "onLoadCompaginFailed load failed errorCode:" + i11 + " msg:" + str);
            if (b.this.f34164x != null) {
                b.this.f34164x.post(new RunnableC0469b(str));
            }
            b.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class h extends c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f34189a;

        h(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
            this.f34189a = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.same.c.a
        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            com.mbridge.msdk.advanced.report.a.a(str, cVar, this.f34189a, b.this.f34145e, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f34191a;

        i(CampaignEx campaignEx) {
            this.f34191a = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(b.this.f34145e)).a();
            w.a(b.this.f34145e, this.f34191a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class j implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f34193a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f34194b;

        /* loaded from: classes5.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                j jVar = j.this;
                b.this.i(jVar.f34193a, jVar.f34194b);
            }
        }

        /* renamed from: com.mbridge.msdk.advanced.manager.b$j$b, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0470b implements Runnable {
            RunnableC0470b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                j jVar = j.this;
                b.this.i(jVar.f34193a, jVar.f34194b);
            }
        }

        j(CampaignEx campaignEx, int i11) {
            this.f34193a = campaignEx;
            this.f34194b = i11;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            o0.a(b.f34140z, "gifurl 下载失败： " + str2);
            if (b.this.f34164x != null) {
                b.this.f34164x.post(new RunnableC0470b());
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            o0.a(b.f34140z, "giturl 下载成功： " + str);
            if (b.this.f34164x != null) {
                b.this.f34164x.post(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class k implements H5DownLoadManager.ZipDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f34198a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f34199b;

        k(CampaignEx campaignEx, int i11) {
            this.f34198a = campaignEx;
            this.f34199b = i11;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            o0.a(b.f34140z, "endcard 下载失败： " + str2);
            if (b.this.f34146f != null) {
                b.this.f34146f.setEndCardReady(false);
            }
            Message obtain = Message.obtain();
            obtain.what = 2;
            Bundle bundle = new Bundle();
            bundle.putSerializable("campaignex", this.f34198a);
            bundle.putString(NotificationCompat.CATEGORY_MESSAGE, str);
            bundle.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 2);
            obtain.obj = bundle;
            b.this.f34164x.sendMessage(obtain);
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z10) {
            o0.a(b.f34140z, "endcard 下载成功： " + str);
            if (b.this.f34164x != null) {
                Message obtain = Message.obtain();
                obtain.what = 4;
                obtain.obj = this.f34198a;
                obtain.arg1 = this.f34199b;
                b.this.f34164x.sendMessage(obtain);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class l implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f34201a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f34202b;

        /* loaded from: classes5.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l lVar = l.this;
                b.this.i(lVar.f34201a, lVar.f34202b);
            }
        }

        /* renamed from: com.mbridge.msdk.advanced.manager.b$l$b, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0471b implements Runnable {
            RunnableC0471b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l lVar = l.this;
                b.this.i(lVar.f34201a, lVar.f34202b);
            }
        }

        l(CampaignEx campaignEx, int i11) {
            this.f34201a = campaignEx;
            this.f34202b = i11;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            o0.a(b.f34140z, "image 下载失败： " + str2);
            if (b.this.f34164x != null) {
                b.this.f34164x.post(new RunnableC0471b());
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            o0.a(b.f34140z, "image 下载成功： " + str);
            if (b.this.f34164x != null) {
                b.this.f34164x.post(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f34206a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f34207b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f34208c;

        m(File file, CampaignEx campaignEx, int i11) {
            this.f34206a = file;
            this.f34207b = campaignEx;
            this.f34208c = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a("file:////" + this.f34206a.getAbsolutePath(), this.f34207b, this.f34208c);
        }
    }

    public b(String str, String str2, long j11) {
        this.f34142b = str;
        this.f34141a = str2;
    }

    @NonNull
    private com.mbridge.msdk.advanced.request.b a(String str, int i11) {
        g gVar = new g(i11, str, i11);
        gVar.a(str);
        gVar.setUnitId(this.f34141a);
        gVar.setPlacementId(this.f34142b);
        gVar.setAdType(298);
        return gVar;
    }

    private List<CampaignEx> a(CampaignUnit campaignUnit) {
        if (campaignUnit == null || campaignUnit.getAds() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        CampaignEx campaignEx = campaignUnit.getAds().get(0);
        campaignEx.setCampaignUnitId(this.f34141a);
        a(campaignEx);
        this.f34161u = campaignUnit.getSessionId();
        if (campaignEx.getOfferType() != 99 && (!TextUtils.isEmpty(campaignEx.getAdZip()) || !TextUtils.isEmpty(campaignEx.getAdHtml()))) {
            if (t0.c(campaignEx)) {
                campaignEx.setRtinsType(t0.c(this.f34145e, campaignEx.getPackageName()) ? 1 : 2);
            }
            if (com.mbridge.msdk.foundation.same.c.b(this.f34145e, campaignEx)) {
                arrayList.add(campaignEx);
            } else {
                t0.a(this.f34141a, campaignEx, com.mbridge.msdk.foundation.same.a.f35406x);
            }
            a(campaignEx, (com.mbridge.msdk.foundation.same.report.metrics.c) null, (com.mbridge.msdk.foundation.same.report.metrics.callback.a) null);
        }
        return arrayList;
    }

    private void a(long j11) {
        this.f34164x.postDelayed(this.f34165y, j11);
    }

    private void a(Context context, String str, int i11) {
        try {
            if (context == null) {
                a(new com.mbridge.msdk.foundation.error.b(880025), str, i11, (CampaignEx) null);
                return;
            }
            if (y0.a(this.f34141a)) {
                a(new com.mbridge.msdk.foundation.error.b(880032), str, i11, (CampaignEx) null);
                return;
            }
            try {
                com.mbridge.msdk.advanced.manager.d.b(this.f34141a);
            } catch (Throwable th2) {
                o0.b(f34140z, th2.getMessage());
            }
            o0.c(f34140z, "load 开始准备请求参数");
            MBridgeIds mBridgeIds = new MBridgeIds(this.f34142b, this.f34141a);
            com.mbridge.msdk.advanced.request.f fVar = new com.mbridge.msdk.advanced.request.f();
            fVar.d(i11);
            fVar.c(this.f34162v);
            fVar.a(this.f34161u);
            fVar.b(this.f34153m);
            fVar.a(this.f34152l);
            com.mbridge.msdk.foundation.same.net.wrapper.e b11 = com.mbridge.msdk.advanced.request.e.b(context, mBridgeIds, fVar);
            if (b11 == null) {
                o0.c(f34140z, "load 请求参数为空 load失败");
                a(new com.mbridge.msdk.foundation.error.b(880001), str, i11, (CampaignEx) null);
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                b11.a("token", str);
            }
            String d11 = t0.d(this.f34141a);
            if (!TextUtils.isEmpty(d11)) {
                b11.a(com.mbridge.msdk.foundation.same.report.j.f35620b, d11);
            }
            new com.mbridge.msdk.advanced.request.c(context).choiceV3OrV5BySetting(1, b11, a(str, i11), str, com.mbridge.msdk.foundation.same.c.a(this.f34143c, 30000L));
        } catch (Exception e11) {
            o0.b(f34140z, e11.getMessage());
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880020);
            bVar.a((Throwable) e11);
            a(bVar, str, i11, (CampaignEx) null);
            f();
        }
    }

    private void a(CampaignEx campaignEx) {
        new Thread(new i(campaignEx)).start();
    }

    private void a(CampaignEx campaignEx, int i11) {
        String str;
        this.f34160t = new k(campaignEx, i11);
        if (campaignEx != null) {
            r4 = campaignEx.getAabEntity() != null ? campaignEx.getAabEntity().h3c : 0;
            str = campaignEx.getendcard_url();
        } else {
            str = "";
        }
        com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        cVar.a(campaignEx);
        cVar.f(r4);
        H5DownLoadManager.getInstance().downloadH5Res(cVar, str, this.f34160t);
    }

    private void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.c cVar, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
        try {
            com.mbridge.msdk.foundation.same.c.a(campaignEx, this.f34145e, cVar, new h(campaignEx, aVar));
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, String str, int i11) {
        com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880009);
        bVar.c(str);
        a(bVar, this.f34154n, i11, campaignEx);
        com.mbridge.msdk.advanced.report.a.a(2, str, this.f34141a, campaignEx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, String str, boolean z10, String str2) {
        try {
            com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
            mVar.e(2);
            mVar.j("m_download_end");
            if (campaignEx != null) {
                mVar.b(campaignEx.isMraid() ? com.mbridge.msdk.foundation.entity.m.N : com.mbridge.msdk.foundation.entity.m.O);
                mVar.o(campaignEx.getRequestIdNotice());
            }
            mVar.b("url", str);
            mVar.b("scenes", "1");
            if (z10) {
                mVar.d(1);
            } else {
                mVar.d(3);
                mVar.m(str2);
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(mVar, campaignEx);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b(f34140z, e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignUnit campaignUnit, int i11, String str, String str2) {
        List<CampaignEx> a11 = a(campaignUnit);
        if (a11 == null || a11.size() <= 0) {
            o0.c(f34140z, "onload load失败 返回的compaign没有可以用的");
            a(new com.mbridge.msdk.foundation.error.b(880033), str2, i11, (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() == 0) ? null : campaignUnit.getAds().get(0));
            return;
        }
        g();
        o0.c(f34140z, "onload load成功 size:" + a11.size());
        CampaignEx campaignEx = a11.get(0);
        if (!TextUtils.isEmpty(campaignEx.getAdZip()) || (!TextUtils.isEmpty(campaignEx.getAdHtml()) && campaignEx.getAdHtml().contains("<MBTPLMARK>"))) {
            campaignEx.setHasMBTplMark(true);
            campaignEx.setIsMraid(false);
        } else {
            campaignEx.setHasMBTplMark(false);
            campaignEx.setIsMraid(true);
        }
        j(campaignEx, i11);
    }

    private void a(com.mbridge.msdk.foundation.error.b bVar, int i11, CampaignEx campaignEx) {
        if (this.f34157q) {
            return;
        }
        b();
        if (bVar != null) {
            o0.b(f34140z, "real failed: " + bVar.g());
        }
        this.f34157q = true;
        com.mbridge.msdk.advanced.middle.b bVar2 = this.f34144d;
        if (bVar2 != null) {
            bVar2.a(bVar, i11);
        }
    }

    private void a(com.mbridge.msdk.foundation.error.b bVar, int i11, String str) {
        CampaignEx a11 = com.mbridge.msdk.advanced.manager.d.a(this.f34146f, this.f34142b, this.f34141a, str, this.f34150j, true, true);
        if (a11 == null) {
            a(bVar, i11, a11);
        } else {
            o0.b(f34140z, "load failed cache ");
            j(a11, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.error.b bVar, String str, int i11, CampaignEx campaignEx) {
        if (this.f34156p) {
            this.f34156p = false;
            a(bVar, i11, str);
        } else {
            if (bVar != null) {
                bVar.a(campaignEx);
            }
            a(bVar, i11, campaignEx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, CampaignEx campaignEx, int i11) {
        MBNativeAdvancedView mBNativeAdvancedView = this.f34146f;
        if (mBNativeAdvancedView == null || mBNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        com.mbridge.msdk.advanced.report.a.b(this.f34141a, campaignEx);
        com.mbridge.msdk.advanced.signal.b bVar = new com.mbridge.msdk.advanced.signal.b(this.f34146f.getContext(), this.f34142b, this.f34141a);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        bVar.a(arrayList);
        bVar.a(this.f34150j);
        bVar.b(this.f34151k);
        this.f34146f.setAdvancedNativeSignalCommunicationImpl(bVar);
        long currentTimeMillis = System.currentTimeMillis();
        MBNativeAdvancedWebview advancedNativeWebview = this.f34146f.getAdvancedNativeWebview();
        if (advancedNativeWebview == null) {
            a(campaignEx, "webview is null", i11);
            return;
        }
        if (advancedNativeWebview.isDestoryed()) {
            a(campaignEx, "webview is destroyed", i11);
            return;
        }
        advancedNativeWebview.setWebViewListener(new C0468b(campaignEx, i11, currentTimeMillis));
        if (advancedNativeWebview.isDestoryed()) {
            a(new com.mbridge.msdk.foundation.error.b(880031), this.f34154n, i11, campaignEx);
            com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx, this.f34141a, "webview had destory", currentTimeMillis, 3);
            return;
        }
        o0.b(f34140z, "=======开始渲染: " + str);
        Handler handler = this.f34164x;
        if (handler != null) {
            handler.post(new c(advancedNativeWebview, str));
        }
    }

    private void b() {
        this.f34164x.removeCallbacks(this.f34165y);
    }

    private void b(CampaignEx campaignEx, int i11) {
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(campaignEx.getGifUrl(), new j(campaignEx, i11));
    }

    private void c(CampaignEx campaignEx, int i11) {
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(campaignEx.getImageUrl(), new l(campaignEx, i11));
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d6 A[Catch: all -> 0x00b8, Exception -> 0x0131, TRY_ENTER, TryCatch #6 {Exception -> 0x0131, blocks: (B:30:0x00d6, B:32:0x00da, B:34:0x00e0, B:36:0x00e6, B:38:0x00ec, B:40:0x00fe, B:48:0x0107, B:73:0x00b4), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e0 A[Catch: all -> 0x00b8, Exception -> 0x0131, TryCatch #6 {Exception -> 0x0131, blocks: (B:30:0x00d6, B:32:0x00da, B:34:0x00e0, B:36:0x00e6, B:38:0x00ec, B:40:0x00fe, B:48:0x0107, B:73:0x00b4), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011f A[Catch: IOException -> 0x0123, TRY_ENTER, TRY_LEAVE, TryCatch #10 {IOException -> 0x0123, blocks: (B:57:0x013d, B:42:0x011f), top: B:3:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d(com.mbridge.msdk.foundation.entity.CampaignEx r11, int r12) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.advanced.manager.b.d(com.mbridge.msdk.foundation.entity.CampaignEx, int):void");
    }

    private void e(CampaignEx campaignEx, int i11) {
        MBNativeAdvancedView mBNativeAdvancedView = this.f34146f;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.clearResState();
        }
        if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
            o0.a(f34140z, "开始下载zip： " + campaignEx.getAdZip());
            g(campaignEx, i11);
        }
        if (!TextUtils.isEmpty(campaignEx.getAdHtml())) {
            o0.a(f34140z, "开始下载HTML： " + campaignEx.getAdHtml());
            d(campaignEx, i11);
        }
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            o0.a(f34140z, "开始下载Video： " + campaignEx.getVideoUrlEncode());
            f(campaignEx, i11);
        }
        if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
            o0.a(f34140z, "开始下载image： " + campaignEx.getImageUrl());
            c(campaignEx, i11);
        }
        if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
            o0.a(f34140z, "开始下载EndCard： " + campaignEx.getendcard_url());
            a(campaignEx, i11);
        }
        if (TextUtils.isEmpty(campaignEx.getGifUrl())) {
            return;
        }
        o0.a(f34140z, "开始下载gitUrl： " + campaignEx.getGifUrl());
        b(campaignEx, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f34162v = 0;
    }

    private void f(CampaignEx campaignEx, int i11) {
        this.f34158r = new d(campaignEx);
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(campaignEx);
        com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(this.f34145e, this.f34141a, copyOnWriteArrayList, 298, this.f34158r);
        if (!com.mbridge.msdk.videocommon.download.b.getInstance().b(298, this.f34141a, campaignEx.isBidCampaign())) {
            o0.a(f34140z, " load Video");
            com.mbridge.msdk.videocommon.download.b.getInstance().load(this.f34141a);
        } else {
            o0.a(f34140z, " load Video isReady true");
            this.f34146f.setVideoReady(true);
            i(campaignEx, i11);
        }
    }

    private void g() {
        try {
            int i11 = this.f34162v + 1;
            this.f34162v = i11;
            com.mbridge.msdk.setting.l lVar = this.f34147g;
            if (lVar != null) {
                if (i11 > lVar.y()) {
                }
                o0.c(f34140z, "onload 算出 下次的offset是:" + this.f34162v);
            }
            o0.c(f34140z, "onload 重置offset为0");
            this.f34162v = 0;
            o0.c(f34140z, "onload 算出 下次的offset是:" + this.f34162v);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void g(CampaignEx campaignEx, int i11) {
        String str;
        this.f34159s = new a(campaignEx, i11);
        com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        cVar.a(campaignEx);
        if (campaignEx != null) {
            r0 = campaignEx.getAabEntity() != null ? campaignEx.getAabEntity().h3c : 0;
            str = campaignEx.getAdZip();
        } else {
            str = "";
        }
        cVar.f(r0);
        cVar.e(2);
        H5DownLoadManager.getInstance().downloadH5Res(cVar, str, this.f34159s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CampaignEx campaignEx, int i11) {
        if (this.f34146f.isH5Ready()) {
            i(campaignEx, i11);
            com.mbridge.msdk.advanced.report.a.a(1, "", this.f34141a, campaignEx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CampaignEx campaignEx, int i11) {
        if (!com.mbridge.msdk.advanced.manager.d.a(this.f34146f, campaignEx, this.f34142b, this.f34141a) || this.f34157q) {
            return;
        }
        b();
        com.mbridge.msdk.advanced.manager.d.a(campaignEx, this.f34141a);
        this.f34157q = true;
        com.mbridge.msdk.advanced.middle.b bVar = this.f34144d;
        if (bVar != null) {
            bVar.a(campaignEx, i11);
        }
    }

    private void j(CampaignEx campaignEx, int i11) {
        this.f34149i = campaignEx;
        if (com.mbridge.msdk.advanced.manager.d.a(this.f34146f, campaignEx, this.f34142b, this.f34141a)) {
            i(campaignEx, i11);
        } else {
            e(campaignEx, i11);
        }
    }

    public String a(String str) {
        int j11;
        if (this.f34149i == null) {
            return "";
        }
        try {
            com.mbridge.msdk.videocommon.download.a a11 = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f34141a, this.f34149i.getId() + this.f34149i.getVideoUrlEncode() + this.f34149i.getBidToken());
            if (a11 == null || (j11 = a11.j()) != 5) {
                return str;
            }
            String k11 = a11.k();
            if (!new File(k11).exists()) {
                return str;
            }
            o0.b(f34140z, "本地已下载完 拿本地播放地址：" + k11 + " state：" + j11);
            return k11;
        } catch (Exception e11) {
            o0.b(f34140z, e11.getMessage());
            return str;
        }
    }

    public void a(int i11) {
        this.f34150j = i11;
    }

    public void a(int i11, int i12) {
        this.f34153m = i11;
        this.f34152l = i12;
    }

    public void a(com.mbridge.msdk.advanced.middle.b bVar) {
        this.f34144d = bVar;
    }

    public void a(MBNativeAdvancedView mBNativeAdvancedView) {
        this.f34146f = mBNativeAdvancedView;
    }

    public void a(com.mbridge.msdk.setting.l lVar) {
        this.f34147g = lVar;
    }

    public void b(String str, int i11) {
        this.f34157q = false;
        this.f34154n = str;
        this.f34155o = i11;
        this.f34149i = null;
        if (this.f34146f == null) {
            a(new com.mbridge.msdk.foundation.error.b(880030), str, i11, (CampaignEx) null);
            return;
        }
        CampaignEx a11 = TextUtils.isEmpty(str) ? com.mbridge.msdk.advanced.manager.d.a(this.f34146f, this.f34142b, this.f34141a, str, this.f34150j, false, false) : com.mbridge.msdk.advanced.manager.d.a(this.f34146f, this.f34142b, this.f34141a, str, this.f34150j, false, true);
        long timestamp = a11 != null ? a11.getTimestamp() : 0L;
        com.mbridge.msdk.setting.l lVar = this.f34147g;
        if (lVar != null && lVar.t() == 1 && this.f34146f != null && a11 != null) {
            j(a11, i11);
            return;
        }
        this.f34156p = false;
        com.mbridge.msdk.setting.l lVar2 = this.f34147g;
        if (lVar2 != null) {
            List<Integer> c11 = lVar2.c();
            if (c11 == null || c11.size() <= 0) {
                this.f34143c = 30000L;
            } else {
                this.f34143c = c11.get(0).intValue() * 1000;
            }
        } else {
            this.f34143c = 30000L;
        }
        o0.a(f34140z, "开始从V3请求新的 offer，超时 ：" + this.f34143c);
        if (this.f34147g == null || timestamp <= 0 || !TextUtils.isEmpty(str)) {
            a(this.f34143c);
            a(this.f34145e, str, i11);
            return;
        }
        if (System.currentTimeMillis() - timestamp <= this.f34147g.v() * 1000) {
            j(a11, i11);
        } else {
            a(this.f34143c);
            a(this.f34145e, str, i11);
        }
    }

    public String c() {
        return com.mbridge.msdk.foundation.same.c.b(this.f34148h);
    }

    public String d() {
        return this.f34163w;
    }

    public void e() {
        if (this.f34144d != null) {
            this.f34144d = null;
        }
        if (this.f34158r != null) {
            this.f34158r = null;
        }
        if (this.f34159s != null) {
            this.f34159s = null;
        }
    }
}
