package com.mbridge.msdk.reward.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.cloud.config.utils.ConstantsKt;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.videocommon.a;
import com.transsion.gslb.Utils;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: g, reason: collision with root package name */
    private static ConcurrentHashMap<String, f> f36852g;

    /* renamed from: a, reason: collision with root package name */
    private final m f36853a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f36854b;

    /* renamed from: c, reason: collision with root package name */
    private final String f36855c;

    /* renamed from: d, reason: collision with root package name */
    private final String f36856d;

    /* renamed from: e, reason: collision with root package name */
    private final String f36857e;

    /* renamed from: f, reason: collision with root package name */
    private volatile List<WindVaneWebView> f36858f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList f36859a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f36860b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f36861c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f36862d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f36863e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f36864f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f36865g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ n f36866h;

        a(CopyOnWriteArrayList copyOnWriteArrayList, Context context, String str, int i11, String str2, String str3, String str4, n nVar) {
            this.f36859a = copyOnWriteArrayList;
            this.f36860b = context;
            this.f36861c = str;
            this.f36862d = i11;
            this.f36863e = str2;
            this.f36864f = str3;
            this.f36865g = str4;
            this.f36866h = nVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:133:0x02a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:140:0x0272 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:171:0x0184  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x01ea  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0250  */
        /* JADX WARN: Removed duplicated region for block: B:57:0x02d2  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x038c  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 1001
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.a.run():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.reward.adapter.b$b, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0521b implements x.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f36868a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CampaignEx f36869b;

        C0521b(int i11, CampaignEx campaignEx) {
            this.f36868a = i11;
            this.f36869b = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.tools.x.c
        public void a(String str, DownloadError downloadError) {
            String str2 = "";
            if (downloadError != null) {
                try {
                    if (downloadError.getException() != null) {
                        str2 = downloadError.getException().getMessage();
                    }
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
            int i11 = this.f36868a;
            if (i11 == 0) {
                mVar.e(1);
                mVar.d(3);
                mVar.j("m_download_end");
            } else if (i11 == 1) {
                mVar.e(2);
                mVar.d(3);
                mVar.j("m_download_end");
            } else if (i11 == 2) {
                mVar.e(3);
                mVar.d(3);
                mVar.j("m_download_end");
                mVar.b(this.f36869b.isMraid() ? com.mbridge.msdk.foundation.entity.m.N : com.mbridge.msdk.foundation.entity.m.O);
                mVar.f("1");
            }
            b.b(mVar, this.f36869b);
            mVar.o(this.f36869b.getRequestIdNotice());
            mVar.m(str2);
            mVar.b("scenes", "1");
            mVar.b("url", str);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(mVar, this.f36869b);
        }

        @Override // com.mbridge.msdk.foundation.tools.x.c
        public void a(String str, String str2, String str3, String str4, boolean z10) {
            if (z10) {
                return;
            }
            try {
                com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
                int i11 = this.f36868a;
                if (i11 == 0) {
                    mVar.e(1);
                    mVar.d(1);
                    mVar.j("m_download_end");
                } else if (i11 == 1) {
                    mVar.e(2);
                    mVar.d(1);
                    mVar.j("m_download_end");
                } else if (i11 == 2) {
                    mVar.e(3);
                    mVar.d(1);
                    mVar.j("m_download_end");
                    mVar.b(this.f36869b.isMraid() ? com.mbridge.msdk.foundation.entity.m.N : com.mbridge.msdk.foundation.entity.m.O);
                    mVar.f("1");
                }
                mVar.o(this.f36869b.getRequestIdNotice());
                mVar.b("url", str);
                mVar.b("scenes", "1");
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a(mVar, this.f36869b);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardCampaignsResourceManager", e11.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements H5DownLoadManager.ZipDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f36871a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f36872b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f36873c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CampaignEx f36874d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ n f36875e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f36876f;

        c(String str, String str2, String str3, CampaignEx campaignEx, n nVar, Context context) {
            this.f36871a = str;
            this.f36872b = str2;
            this.f36873c = str3;
            this.f36874d = campaignEx;
            this.f36875e = nVar;
            this.f36876f = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0141 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onFailed(java.lang.String r23, java.lang.String r24) {
            /*
                Method dump skipped, instructions count: 370
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.c.onFailed(java.lang.String, java.lang.String):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x013e  */
        /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onSuccess(java.lang.String r18, java.lang.String r19, boolean r20) {
            /*
                Method dump skipped, instructions count: 326
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.c.onSuccess(java.lang.String, java.lang.String, boolean):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f36878a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f36879b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f36880c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f36881d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f36882e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f36883f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f36884g;

        d(CampaignEx campaignEx, Context context, int i11, String str, String str2, String str3, String str4) {
            this.f36878a = campaignEx;
            this.f36879b = context;
            this.f36880c = i11;
            this.f36881d = str;
            this.f36882e = str2;
            this.f36883f = str3;
            this.f36884g = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f36878a == null || this.f36879b == null) {
                return;
            }
            try {
                com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
                mVar.j("m_download_end");
                Context context = this.f36879b;
                if (context != null) {
                    mVar.c(k0.s(context.getApplicationContext()));
                }
                mVar.d(this.f36880c);
                CampaignEx campaignEx = this.f36878a;
                if (campaignEx != null) {
                    mVar.b(campaignEx.getId());
                    mVar.n(this.f36878a.getRequestId());
                    mVar.k(this.f36878a.getCurrentLocalRid());
                    mVar.o(this.f36878a.getRequestIdNotice());
                }
                mVar.b("url", this.f36881d);
                mVar.t(this.f36881d);
                mVar.m(this.f36882e);
                mVar.u(this.f36883f);
                if (!TextUtils.isEmpty(this.f36884g)) {
                    mVar.q(this.f36884g);
                }
                mVar.e(1);
                mVar.b("scenes", "1");
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a(mVar, this.f36878a);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f36886a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WindVaneWebView f36887b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CampaignEx f36888c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList f36889d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f36890e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.videocommon.setting.c f36891f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f36892g;

        e(boolean z10, WindVaneWebView windVaneWebView, CampaignEx campaignEx, CopyOnWriteArrayList copyOnWriteArrayList, String str, com.mbridge.msdk.videocommon.setting.c cVar, String str2) {
            this.f36886a = z10;
            this.f36887b = windVaneWebView;
            this.f36888c = campaignEx;
            this.f36889d = copyOnWriteArrayList;
            this.f36890e = str;
            this.f36891f = cVar;
            this.f36892g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f36886a, this.f36887b, this.f36888c.getRewardTemplateMode().e(), 0, this.f36888c, (CopyOnWriteArrayList<CampaignEx>) this.f36889d, H5DownLoadManager.getInstance().getH5ResAddress(this.f36888c.getRewardTemplateMode().e()), this.f36890e, this.f36891f, this.f36892g, b.this.f36854b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        boolean f36894a;

        /* renamed from: b, reason: collision with root package name */
        boolean f36895b;

        /* renamed from: c, reason: collision with root package name */
        int f36896c;

        /* renamed from: d, reason: collision with root package name */
        int f36897d;

        /* renamed from: e, reason: collision with root package name */
        String f36898e;

        /* renamed from: f, reason: collision with root package name */
        String f36899f;

        /* renamed from: g, reason: collision with root package name */
        int f36900g;

        /* renamed from: h, reason: collision with root package name */
        CopyOnWriteArrayList<CampaignEx> f36901h;

        /* renamed from: i, reason: collision with root package name */
        CopyOnWriteArrayList<CampaignEx> f36902i;

        public f(boolean z10, boolean z11, int i11, int i12, String str, String str2, int i13, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f36894a = z10;
            this.f36895b = z11;
            this.f36896c = i11;
            this.f36897d = i12;
            this.f36898e = str;
            this.f36899f = str2;
            this.f36900g = i13;
            this.f36901h = copyOnWriteArrayList;
            this.f36902i = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class g extends com.mbridge.msdk.mbsignalcommon.listener.a {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f36903a;

        /* renamed from: b, reason: collision with root package name */
        private final Runnable f36904b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f36905c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f36906d;

        /* renamed from: e, reason: collision with root package name */
        private int f36907e;

        /* renamed from: f, reason: collision with root package name */
        private String f36908f;

        /* renamed from: g, reason: collision with root package name */
        private String f36909g;

        /* renamed from: h, reason: collision with root package name */
        private String f36910h;

        /* renamed from: i, reason: collision with root package name */
        private String f36911i;

        /* renamed from: j, reason: collision with root package name */
        private a.C0573a f36912j;

        /* renamed from: k, reason: collision with root package name */
        private CampaignEx f36913k;

        /* renamed from: l, reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f36914l;

        /* renamed from: m, reason: collision with root package name */
        private com.mbridge.msdk.videocommon.setting.c f36915m;

        /* renamed from: n, reason: collision with root package name */
        private final o f36916n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f36917o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f36918p;

        /* renamed from: q, reason: collision with root package name */
        private boolean f36919q;

        /* renamed from: r, reason: collision with root package name */
        private int f36920r = 0;

        /* renamed from: s, reason: collision with root package name */
        private boolean f36921s;

        /* renamed from: t, reason: collision with root package name */
        private long f36922t;

        public g(boolean z10, Handler handler, Runnable runnable, boolean z11, boolean z12, int i11, String str, String str2, String str3, String str4, a.C0573a c0573a, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.videocommon.setting.c cVar, o oVar, boolean z13, long j11) {
            this.f36903a = handler;
            this.f36904b = runnable;
            this.f36905c = z11;
            this.f36906d = z12;
            this.f36907e = i11;
            this.f36908f = str;
            this.f36910h = str2;
            this.f36909g = str3;
            this.f36911i = str4;
            this.f36912j = c0573a;
            this.f36913k = campaignEx;
            this.f36914l = copyOnWriteArrayList;
            this.f36915m = cVar;
            this.f36916n = oVar;
            this.f36917o = z13;
            this.f36921s = z10;
            this.f36922t = j11;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView) {
            if (webView != null) {
                try {
                    com.mbridge.msdk.video.bt.component.d.c().c(this.f36909g, this.f36911i);
                } catch (Throwable th2) {
                    o0.b("RVWindVaneWebView", th2.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i11) {
            Runnable runnable;
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 1);
                eVar.a("result", Integer.valueOf(i11));
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000155", this.f36913k, eVar);
            } catch (Throwable th2) {
                o0.b("RVWindVaneWebView", th2.getMessage());
            }
            if (this.f36919q) {
                return;
            }
            String str = this.f36909g + "_" + this.f36908f;
            if (i11 == 1) {
                if (this.f36917o) {
                    com.mbridge.msdk.videocommon.a.d(this.f36909g + "_" + this.f36911i);
                } else {
                    com.mbridge.msdk.videocommon.a.c(this.f36909g + "_" + this.f36911i);
                }
                com.mbridge.msdk.videocommon.a.a(this.f36909g + "_" + this.f36911i + "_" + this.f36908f, this.f36912j, true, this.f36917o);
                Handler handler = this.f36903a;
                if (handler != null && (runnable = this.f36904b) != null) {
                    handler.removeCallbacks(runnable);
                }
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f36909g + "_" + this.f36911i + "_" + this.f36908f, true);
                a.C0573a c0573a = this.f36912j;
                if (c0573a != null) {
                    c0573a.a(true);
                }
                o oVar = this.f36916n;
                if (oVar != null) {
                    oVar.a(str, this.f36910h, this.f36909g, this.f36911i, this.f36908f, this.f36912j);
                }
            } else {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f36909g + "_" + this.f36911i + "_" + this.f36908f, false);
                a.C0573a c0573a2 = this.f36912j;
                if (c0573a2 != null) {
                    c0573a2.a(false);
                }
                if (this.f36916n != null) {
                    this.f36916n.a(str, this.f36911i, this.f36908f, this.f36912j, b.b(880008, new MBridgeIds(this.f36910h, this.f36909g, this.f36911i), "readyState:" + i11, null, this.f36913k));
                }
            }
            this.f36919q = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i11, String str, String str2) {
            super.a(webView, i11, str, str2);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f36909g + "_" + this.f36911i + "_" + this.f36908f, false);
            if (this.f36916n != null) {
                String str3 = this.f36909g + "_" + this.f36908f;
                a.C0573a c0573a = this.f36912j;
                if (c0573a != null) {
                    c0573a.a(false);
                }
                this.f36916n.a(str3, this.f36911i, this.f36908f, this.f36912j, b.b(880008, new MBridgeIds(this.f36910h, this.f36909g, this.f36911i), "onReceivedError： " + i11 + "  " + str, null, this.f36913k));
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            Runnable runnable;
            super.a(webView, str);
            if (this.f36918p) {
                return;
            }
            String str2 = this.f36909g + "_" + this.f36908f;
            if (!str.contains("wfr=1")) {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f36909g + "_" + this.f36911i + "_" + this.f36908f, true);
                Handler handler = this.f36903a;
                if (handler != null && (runnable = this.f36904b) != null) {
                    handler.removeCallbacks(runnable);
                }
                a.C0573a c0573a = this.f36912j;
                if (c0573a != null) {
                    c0573a.a(true);
                }
                o oVar = this.f36916n;
                if (oVar != null) {
                    oVar.a(str2, this.f36910h, this.f36909g, this.f36911i, this.f36908f, this.f36912j);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(webView);
            this.f36918p = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a
        public void a(WebView webView, String str, String str2, int i11, int i12) {
            boolean z10 = true;
            if (i11 == 1) {
                try {
                    com.mbridge.msdk.reward.controller.a aVar = new com.mbridge.msdk.reward.controller.a();
                    aVar.e(false);
                    if (i12 != 2) {
                        z10 = false;
                    }
                    aVar.d(z10);
                    aVar.c(str, str2);
                    aVar.a(new com.mbridge.msdk.video.bt.module.orglistener.a(null));
                    aVar.a(false, com.mbridge.msdk.foundation.same.report.metrics.d.b().a(0, i12, str2, true, 1));
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RVWindVaneWebView", e11.getMessage());
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a
        public void a(Object obj, String str) {
            if (obj != null) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    String optString = new JSONObject(str).optString("id");
                    com.mbridge.msdk.video.bt.component.d.c().b(obj, optString);
                    String f11 = com.mbridge.msdk.video.bt.component.d.c().f(optString);
                    CampaignEx c11 = com.mbridge.msdk.video.bt.component.d.c().c(optString);
                    com.mbridge.msdk.videocommon.setting.c d11 = com.mbridge.msdk.video.bt.component.d.c().d(optString);
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    copyOnWriteArrayList.add(c11);
                    WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).f36595b;
                    if (windVaneWebView != null) {
                        b.b().a(this.f36921s, windVaneWebView, c11, (CopyOnWriteArrayList<CampaignEx>) copyOnWriteArrayList, d11, f11, optString, this.f36920r == 0 ? 3 : 6);
                        this.f36920r++;
                    }
                } catch (Throwable th2) {
                    o0.b("RVWindVaneWebView", th2.getMessage());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface h {
        void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList);

        void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.error.b bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class i implements H5DownLoadManager.IH5SourceDownloadListener {

        /* renamed from: b, reason: collision with root package name */
        private int f36924b;

        /* renamed from: c, reason: collision with root package name */
        private final String f36925c;

        /* renamed from: d, reason: collision with root package name */
        private final String f36926d;

        /* renamed from: e, reason: collision with root package name */
        private final String f36927e;

        /* renamed from: f, reason: collision with root package name */
        private CampaignEx f36928f;

        /* renamed from: g, reason: collision with root package name */
        private n f36929g;

        /* renamed from: h, reason: collision with root package name */
        private Handler f36930h;

        /* renamed from: i, reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f36931i;

        /* renamed from: a, reason: collision with root package name */
        private boolean f36923a = false;

        /* renamed from: j, reason: collision with root package name */
        private final long f36932j = System.currentTimeMillis();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f36933a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f36934b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f36935c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f36936d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f36937e;

            a(int i11, long j11, String str, String str2, String str3) {
                this.f36933a = i11;
                this.f36934b = j11;
                this.f36935c = str;
                this.f36936d = str2;
                this.f36937e = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i.this.f36928f == null) {
                    return;
                }
                try {
                    com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m("m_download_end", this.f36933a, this.f36934b + "", this.f36935c, i.this.f36928f.getId(), i.this.f36926d, this.f36936d, "2");
                    mVar.n(i.this.f36928f.getRequestId());
                    mVar.k(i.this.f36928f.getCurrentLocalRid());
                    mVar.o(i.this.f36928f.getRequestIdNotice());
                    mVar.b(i.this.f36928f.getId());
                    mVar.a(i.this.f36928f.getAdSpaceT());
                    mVar.b("scenes", "1");
                    mVar.b("url", this.f36935c);
                    if (i.this.f36928f.getAdType() == 287) {
                        mVar.a("3");
                    } else if (i.this.f36928f.getAdType() == 94) {
                        mVar.a("1");
                    }
                    if (!TextUtils.isEmpty(this.f36937e)) {
                        mVar.q(this.f36937e);
                    }
                    b.b(mVar, i.this.f36928f);
                    com.mbridge.msdk.foundation.same.report.g.a(mVar, i.this.f36926d, i.this.f36928f);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                    }
                }
            }
        }

        public i(int i11, String str, String str2, String str3, CampaignEx campaignEx, n nVar, Handler handler, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f36924b = i11;
            this.f36925c = str;
            this.f36926d = str2;
            this.f36927e = str3;
            this.f36928f = campaignEx;
            this.f36929g = nVar;
            this.f36930h = handler;
            this.f36931i = copyOnWriteArrayList;
        }

        private void a(int i11, long j11, String str, String str2, String str3) {
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new a(i11, j11, str, str2, str3));
        }

        public void a(boolean z10) {
            this.f36923a = z10;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, false);
            int i11 = this.f36924b;
            if (i11 == 313) {
                Message obtain = Message.obtain();
                obtain.what = 201;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36926d);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f36925c);
                bundle.putString(TrackingKey.REQUEST_ID, this.f36927e);
                bundle.putString("key", this.f36926d + "_" + this.f36927e + "_" + this.f36928f.getSecondRequestIndex());
                bundle.putString("url", str);
                bundle.putString("message", str2);
                obtain.setData(bundle);
                this.f36930h.sendMessage(obtain);
                return;
            }
            if (i11 == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36926d);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f36925c);
                bundle2.putString(TrackingKey.REQUEST_ID, this.f36927e);
                bundle2.putString("key", this.f36926d + "_" + this.f36927e + "_" + this.f36928f.getSecondRequestIndex());
                bundle2.putString("url", str);
                bundle2.putString("message", str2);
                obtain2.setData(bundle2);
                this.f36930h.sendMessage(obtain2);
                if (this.f36923a) {
                    a(3, System.currentTimeMillis() - this.f36932j, str, "url download failed", "");
                    return;
                }
                return;
            }
            if (i11 != 859) {
                return;
            }
            Message obtain3 = Message.obtain();
            obtain3.what = Sdk$SDKError.Reason.AD_IS_PLAYING_VALUE;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36926d);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f36925c);
            bundle3.putString(TrackingKey.REQUEST_ID, this.f36927e);
            bundle3.putString("key", this.f36926d + "_" + this.f36927e + "_" + this.f36928f.getSecondRequestIndex());
            bundle3.putString("message", str2);
            obtain3.setData(bundle3);
            this.f36930h.sendMessage(obtain3);
            if (this.f36929g != null) {
                try {
                    this.f36929g.a(str, this.f36927e, b.b(880006, new MBridgeIds(this.f36925c, this.f36926d, this.f36927e), str2, null, null));
                } catch (Exception e11) {
                    o0.b("RewardCampaignsResourceManager", e11.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z10) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, true);
            int i11 = this.f36924b;
            if (i11 == 313) {
                Message obtain = Message.obtain();
                obtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36926d);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f36925c);
                bundle.putString(TrackingKey.REQUEST_ID, this.f36927e);
                bundle.putString("key", this.f36926d + "_" + this.f36927e + "_" + this.f36928f.getSecondRequestIndex());
                bundle.putString("url", str);
                obtain.setData(bundle);
                this.f36930h.sendMessage(obtain);
                return;
            }
            if (i11 == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36926d);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f36925c);
                bundle2.putString(TrackingKey.REQUEST_ID, this.f36927e);
                bundle2.putString("key", this.f36926d + "_" + this.f36927e + "_" + this.f36928f.getSecondRequestIndex());
                bundle2.putString("url", str);
                obtain2.setData(bundle2);
                this.f36930h.sendMessage(obtain2);
                if (this.f36923a) {
                    a(1, System.currentTimeMillis() - this.f36932j, str, "", str2);
                    return;
                }
                return;
            }
            if (i11 != 859) {
                return;
            }
            Message obtain3 = Message.obtain();
            obtain3.what = 105;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36926d);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f36925c);
            bundle3.putString(TrackingKey.REQUEST_ID, this.f36927e);
            bundle3.putString("key", this.f36926d + "_" + this.f36927e + "_" + this.f36928f.getSecondRequestIndex());
            obtain3.setData(bundle3);
            this.f36930h.sendMessage(obtain3);
            n nVar = this.f36929g;
            if (nVar != null) {
                nVar.a(this.f36925c, this.f36926d, this.f36927e, str);
            }
        }
    }

    /* loaded from: classes5.dex */
    private static final class j implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        private Handler f36939a;

        /* renamed from: b, reason: collision with root package name */
        private int f36940b;

        /* renamed from: c, reason: collision with root package name */
        private String f36941c;

        /* renamed from: d, reason: collision with root package name */
        private String f36942d;

        /* renamed from: e, reason: collision with root package name */
        private String f36943e;

        /* renamed from: f, reason: collision with root package name */
        private CampaignEx f36944f;

        /* loaded from: classes5.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f36945a;

            a(String str) {
                this.f36945a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.this.f36944f != null) {
                    try {
                        com.mbridge.msdk.foundation.db.n a11 = com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                        o0.a("RewardCampaignsResourceManager", "campaign is null");
                        com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
                        mVar.j("2000044");
                        mVar.c(k0.s(com.mbridge.msdk.foundation.controller.c.m().d()));
                        mVar.b(j.this.f36944f.getId());
                        mVar.i(j.this.f36944f.getImageUrl());
                        mVar.n(j.this.f36944f.getRequestId());
                        mVar.k(j.this.f36944f.getCurrentLocalRid());
                        mVar.o(j.this.f36944f.getRequestIdNotice());
                        mVar.u(j.this.f36941c);
                        mVar.m(this.f36945a);
                        mVar.b("scenes", "1");
                        a11.a(mVar);
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            o0.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                        }
                    }
                }
            }
        }

        public j(Handler handler, int i11, String str, String str2, String str3, CampaignEx campaignEx) {
            this.f36939a = handler;
            this.f36940b = i11;
            this.f36942d = str;
            this.f36941c = str2;
            this.f36943e = str3;
            this.f36944f = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            Message obtain = Message.obtain();
            obtain.what = this.f36940b == 0 ? Sdk$SDKError.Reason.AD_CONSUMED_VALUE : Sdk$SDKError.Reason.AD_ALREADY_LOADED_VALUE;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36941c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f36942d);
            bundle.putString(TrackingKey.REQUEST_ID, this.f36943e);
            bundle.putString("key", this.f36941c + "_" + this.f36943e + "_" + this.f36944f.getSecondRequestIndex());
            obtain.setData(bundle);
            this.f36939a.sendMessage(obtain);
            a aVar = new a(str);
            if (com.mbridge.msdk.foundation.controller.d.a().e()) {
                com.mbridge.msdk.foundation.same.threadpool.a.b().execute(aVar);
            } else {
                aVar.run();
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            ResDownloadCheckManager.getInstance().setImageDownloadDone(str, true);
            Message obtain = Message.obtain();
            obtain.what = this.f36940b == 0 ? 102 : 104;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36941c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f36942d);
            bundle.putString(TrackingKey.REQUEST_ID, this.f36943e);
            bundle.putString("key", this.f36941c + "_" + this.f36943e + "_" + this.f36944f.getSecondRequestIndex());
            obtain.setData(bundle);
            this.f36939a.sendMessage(obtain);
        }
    }

    /* loaded from: classes5.dex */
    private static final class k implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a, reason: collision with root package name */
        private Handler f36947a;

        /* renamed from: b, reason: collision with root package name */
        private final String f36948b;

        /* renamed from: c, reason: collision with root package name */
        private final String f36949c;

        /* renamed from: d, reason: collision with root package name */
        private final String f36950d;

        /* renamed from: e, reason: collision with root package name */
        private final String f36951e;

        public k(Handler handler, String str, String str2, String str3, String str4) {
            this.f36947a = handler;
            this.f36949c = str;
            this.f36948b = str2;
            this.f36950d = str3;
            this.f36951e = str4;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str) {
            ResDownloadCheckManager.getInstance().setVideoDownloadDone(str, true);
            Message obtain = Message.obtain();
            obtain.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36948b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f36949c);
            bundle.putString(TrackingKey.REQUEST_ID, this.f36950d);
            bundle.putString("key", this.f36951e);
            bundle.putString("url", str);
            obtain.setData(bundle);
            this.f36947a.sendMessage(obtain);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str, String str2) {
            ResDownloadCheckManager.getInstance().setVideoDownloadDone(str2, false);
            Message obtain = Message.obtain();
            obtain.what = 200;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36948b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f36949c);
            bundle.putString(TrackingKey.REQUEST_ID, this.f36950d);
            bundle.putString("url", str2);
            bundle.putString("key", this.f36951e);
            bundle.putString("message", str);
            obtain.setData(bundle);
            this.f36947a.sendMessage(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class l implements H5DownLoadManager.ZipDownloadListener {

        /* renamed from: b, reason: collision with root package name */
        private Context f36953b;

        /* renamed from: c, reason: collision with root package name */
        private String f36954c;

        /* renamed from: d, reason: collision with root package name */
        private String f36955d;

        /* renamed from: e, reason: collision with root package name */
        private String f36956e;

        /* renamed from: f, reason: collision with root package name */
        private CampaignEx f36957f;

        /* renamed from: g, reason: collision with root package name */
        private int f36958g;

        /* renamed from: h, reason: collision with root package name */
        private Handler f36959h;

        /* renamed from: i, reason: collision with root package name */
        private n f36960i;

        /* renamed from: j, reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f36961j;

        /* renamed from: a, reason: collision with root package name */
        private boolean f36952a = false;

        /* renamed from: k, reason: collision with root package name */
        private long f36962k = System.currentTimeMillis();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f36963a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f36964b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f36965c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f36966d;

            a(int i11, String str, String str2, String str3) {
                this.f36963a = i11;
                this.f36964b = str;
                this.f36965c = str2;
                this.f36966d = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (l.this.f36957f == null || l.this.f36953b == null) {
                    return;
                }
                try {
                    com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
                    mVar.j("m_download_end");
                    if (l.this.f36953b != null) {
                        mVar.c(k0.s(l.this.f36953b.getApplicationContext()));
                    }
                    mVar.d(this.f36963a);
                    if (l.this.f36957f != null) {
                        mVar.b(l.this.f36957f.getId());
                        mVar.n(l.this.f36957f.getRequestId());
                        mVar.k(l.this.f36957f.getCurrentLocalRid());
                        mVar.o(l.this.f36957f.getRequestIdNotice());
                    }
                    mVar.t(this.f36964b);
                    mVar.m(this.f36965c);
                    mVar.u(l.this.f36954c);
                    if (!TextUtils.isEmpty(this.f36966d)) {
                        mVar.q(this.f36966d);
                    }
                    mVar.e(2);
                    mVar.b("scenes", "1");
                    mVar.b("url", this.f36964b);
                    b.b(mVar, l.this.f36957f);
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a(mVar, l.this.f36957f);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.mbridge.msdk.reward.adapter.b$l$b, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0522b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f36968a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f36969b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f36970c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f36971d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f36972e;

            RunnableC0522b(int i11, long j11, String str, String str2, String str3) {
                this.f36968a = i11;
                this.f36969b = j11;
                this.f36970c = str;
                this.f36971d = str2;
                this.f36972e = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (l.this.f36957f == null) {
                    return;
                }
                try {
                    com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m("m_download_end", this.f36968a, this.f36969b + "", this.f36970c, l.this.f36957f.getId(), l.this.f36954c, this.f36971d, "1");
                    mVar.n(l.this.f36957f.getRequestId());
                    mVar.k(l.this.f36957f.getCurrentLocalRid());
                    mVar.o(l.this.f36957f.getRequestIdNotice());
                    mVar.b(l.this.f36957f.getId());
                    mVar.a(l.this.f36957f.getAdSpaceT());
                    mVar.q(this.f36972e);
                    mVar.b("scenes", "1");
                    if (l.this.f36957f.getAdType() == 287) {
                        mVar.a("3");
                    } else if (l.this.f36957f.getAdType() == 94) {
                        mVar.a("1");
                    }
                    mVar.b("url", this.f36970c);
                    mVar.e(3);
                    b.b(mVar, l.this.f36957f);
                    com.mbridge.msdk.foundation.same.report.g.a(mVar, l.this.f36954c, l.this.f36957f);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                    }
                }
            }
        }

        public l(Context context, String str, String str2, String str3, CampaignEx campaignEx, int i11, Handler handler, n nVar, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f36953b = context;
            this.f36955d = str;
            this.f36954c = str2;
            this.f36956e = str3;
            this.f36957f = campaignEx;
            this.f36958g = i11;
            this.f36959h = handler;
            this.f36960i = nVar;
            this.f36961j = copyOnWriteArrayList;
        }

        private void a(int i11, long j11, String str, String str2, String str3) {
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new RunnableC0522b(i11, j11, str, str2, str3));
        }

        private void a(int i11, String str, String str2, String str3) {
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new a(i11, str, str2, str3));
        }

        public void a(boolean z10) {
            this.f36952a = z10;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str2, false);
            long currentTimeMillis = System.currentTimeMillis() - this.f36962k;
            int i11 = this.f36958g;
            if (i11 == 313) {
                Message obtain = Message.obtain();
                obtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36954c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f36955d);
                bundle.putString(TrackingKey.REQUEST_ID, this.f36956e);
                bundle.putString("key", this.f36954c + "_" + this.f36956e + "_" + this.f36957f.getSecondRequestIndex());
                bundle.putString("url", str2);
                bundle.putString("message", str);
                obtain.setData(bundle);
                this.f36959h.sendMessage(obtain);
                return;
            }
            if (i11 == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36954c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f36955d);
                bundle2.putString(TrackingKey.REQUEST_ID, this.f36956e);
                bundle2.putString("url", str2);
                bundle2.putString("key", this.f36954c + "_" + this.f36956e + "_" + this.f36957f.getSecondRequestIndex());
                bundle2.putString("message", str);
                obtain2.setData(bundle2);
                this.f36959h.sendMessage(obtain2);
                if (this.f36952a) {
                    a(3, currentTimeMillis, str2, "zip download failed", "");
                    return;
                }
                return;
            }
            if (i11 != 859) {
                return;
            }
            Message obtain3 = Message.obtain();
            obtain3.what = Sdk$SDKError.Reason.AD_IS_LOADING_VALUE;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36954c);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f36955d);
            bundle3.putString(TrackingKey.REQUEST_ID, this.f36956e);
            bundle3.putString("url", str2);
            bundle3.putString("key", this.f36954c + "_" + this.f36956e + "_" + this.f36957f.getSecondRequestIndex());
            bundle3.putString("message", str);
            obtain3.setData(bundle3);
            this.f36959h.sendMessage(obtain3);
            if (this.f36960i != null) {
                try {
                    this.f36960i.a(str2, this.f36956e, b.b(880006, new MBridgeIds(this.f36955d, this.f36954c, this.f36956e), "", null, null));
                } catch (Exception e11) {
                    o0.b("RewardCampaignsResourceManager", e11.getMessage());
                }
            }
            a(3, str2, str, "");
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z10) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, true);
            long currentTimeMillis = System.currentTimeMillis() - this.f36962k;
            int i11 = this.f36958g;
            if (i11 == 313) {
                Message obtain = Message.obtain();
                obtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36954c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.f36955d);
                bundle.putString(TrackingKey.REQUEST_ID, this.f36956e);
                bundle.putString("key", this.f36954c + "_" + this.f36956e + "_" + this.f36957f.getSecondRequestIndex());
                bundle.putString("url", str);
                obtain.setData(bundle);
                this.f36959h.sendMessage(obtain);
                return;
            }
            if (i11 == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36954c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.f36955d);
                bundle2.putString(TrackingKey.REQUEST_ID, this.f36956e);
                bundle2.putString("key", this.f36954c + "_" + this.f36956e + "_" + this.f36957f.getSecondRequestIndex());
                bundle2.putString("url", str);
                obtain2.setData(bundle2);
                this.f36959h.sendMessage(obtain2);
                if (this.f36952a) {
                    a(1, currentTimeMillis, str, "", str2);
                    return;
                }
                return;
            }
            if (i11 != 859) {
                return;
            }
            Message obtain3 = Message.obtain();
            obtain3.what = 103;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f36954c);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.f36955d);
            bundle3.putString(TrackingKey.REQUEST_ID, this.f36956e);
            bundle3.putString("key", this.f36954c + "_" + this.f36956e + "_" + this.f36957f.getSecondRequestIndex());
            obtain3.setData(bundle3);
            this.f36959h.sendMessage(obtain3);
            n nVar = this.f36960i;
            if (nVar != null) {
                nVar.a(this.f36955d, this.f36954c, this.f36956e, str);
            }
            if (z10) {
                return;
            }
            a(1, str, "", str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class m extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private Context f36974a;

        /* renamed from: b, reason: collision with root package name */
        private ConcurrentHashMap<String, h> f36975b;

        /* renamed from: c, reason: collision with root package name */
        private ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> f36976c;

        public m(Looper looper) {
            super(looper);
            this.f36975b = new ConcurrentHashMap<>();
            this.f36976c = new ConcurrentHashMap<>();
        }

        public void a(Context context) {
            this.f36974a = context;
        }

        public void a(String str, h hVar) {
            this.f36975b.put(str, hVar);
        }

        public void a(String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f36976c.put(str, copyOnWriteArrayList);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(17:6|(1:8)|9|(1:244)(1:13)|14|15|16|17|(3:67|68|(4:70|(7:(2:77|(2:79|(2:81|(2:83|(2:86|(1:88)(2:89|(2:93|(1:97))))(1:85))(2:98|(1:100)))(2:101|(1:103)))(2:104|(1:106)))|107|108|109|110|111|113)(10:119|120|121|122|(2:124|(2:126|(2:128|(1:(1:139)(2:137|138)))(1:(4:172|(4:175|(2:179|180)|181|173)|184|185)(2:170|171)))(1:(4:195|(6:198|(1:202)|203|(2:207|208)|209|196)|212|213)(2:193|194)))(1:(4:223|(4:226|(2:228|229)(1:231)|230|224)|232|233)(2:221|222))|140|141|142|143|(3:152|153|155)(2:145|(5:147|148|149|31|32)(1:151)))|28|29))|19|20|21|22|(1:24)(5:(2:39|(2:41|(2:43|(2:45|(1:50))(2:51|(1:53)))(2:54|(1:56)))(2:57|(1:59)))|60|61|62|63)|25|31|32) */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x03b3, code lost:
        
            r0 = e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x03b4, code lost:
        
            r6 = r12;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:257:0x0478  */
        /* JADX WARN: Removed duplicated region for block: B:259:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r12v1, types: [int] */
        /* JADX WARN: Type inference failed for: r12v11 */
        /* JADX WARN: Type inference failed for: r12v2 */
        /* JADX WARN: Type inference failed for: r12v3 */
        /* JADX WARN: Type inference failed for: r12v4 */
        /* JADX WARN: Type inference failed for: r12v5 */
        /* JADX WARN: Type inference failed for: r12v7 */
        /* JADX WARN: Type inference failed for: r12v8 */
        /* JADX WARN: Type inference failed for: r15v12, types: [boolean] */
        /* JADX WARN: Type inference failed for: r15v9 */
        /* JADX WARN: Type inference failed for: r20v0, types: [com.mbridge.msdk.videocommon.download.b] */
        /* JADX WARN: Type inference failed for: r6v10 */
        /* JADX WARN: Type inference failed for: r6v13 */
        /* JADX WARN: Type inference failed for: r6v14, types: [int] */
        /* JADX WARN: Type inference failed for: r6v16 */
        /* JADX WARN: Type inference failed for: r6v17 */
        /* JADX WARN: Type inference failed for: r6v18 */
        /* JADX WARN: Type inference failed for: r6v4 */
        /* JADX WARN: Type inference failed for: r6v5 */
        /* JADX WARN: Type inference failed for: r6v6, types: [int] */
        /* JADX WARN: Type inference failed for: r6v7 */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r6v9 */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void handleMessage(android.os.Message r30) {
            /*
                Method dump skipped, instructions count: 1202
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.m.handleMessage(android.os.Message):void");
        }
    }

    /* loaded from: classes5.dex */
    public interface n {
        void a(String str, String str2, com.mbridge.msdk.foundation.error.b bVar);

        void a(String str, String str2, String str3, String str4);
    }

    /* loaded from: classes5.dex */
    public interface o {
        void a(String str, String str2, String str3, a.C0573a c0573a, com.mbridge.msdk.foundation.error.b bVar);

        void a(String str, String str2, String str3, String str4, String str5, a.C0573a c0573a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class p extends com.mbridge.msdk.mbsignalcommon.listener.b {

        /* renamed from: a, reason: collision with root package name */
        private Handler f36977a;

        /* renamed from: b, reason: collision with root package name */
        private Runnable f36978b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f36979c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f36980d;

        /* renamed from: e, reason: collision with root package name */
        private String f36981e;

        /* renamed from: f, reason: collision with root package name */
        private final o f36982f;

        /* renamed from: g, reason: collision with root package name */
        private final WindVaneWebView f36983g;

        /* renamed from: h, reason: collision with root package name */
        private final String f36984h;

        /* renamed from: i, reason: collision with root package name */
        private final String f36985i;

        /* renamed from: j, reason: collision with root package name */
        private final String f36986j;

        /* renamed from: k, reason: collision with root package name */
        private final a.C0573a f36987k;

        /* renamed from: l, reason: collision with root package name */
        private final CampaignEx f36988l;

        /* renamed from: m, reason: collision with root package name */
        private CopyOnWriteArrayList<CampaignEx> f36989m;

        /* renamed from: n, reason: collision with root package name */
        private long f36990n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f36991o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f36992p;

        /* renamed from: q, reason: collision with root package name */
        private final Runnable f36993q;

        /* renamed from: r, reason: collision with root package name */
        private final Runnable f36994r;

        /* loaded from: classes5.dex */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ o f36995a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ a.C0573a f36996b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f36997c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f36998d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f36999e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f37000f;

            a(o oVar, a.C0573a c0573a, String str, String str2, String str3, String str4) {
                this.f36995a = oVar;
                this.f36996b = c0573a;
                this.f36997c = str;
                this.f36998d = str2;
                this.f36999e = str3;
                this.f37000f = str4;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindVaneWebView b11;
                a.C0573a c0573a;
                if (this.f36995a != null && (c0573a = this.f36996b) != null) {
                    c0573a.a(true);
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f36997c + "_" + this.f36998d + "_" + this.f36999e, true);
                    o oVar = this.f36995a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.f36997c);
                    sb2.append("_");
                    sb2.append(this.f36999e);
                    oVar.a(sb2.toString(), this.f37000f, this.f36997c, this.f36998d, this.f36999e, this.f36996b);
                }
                a.C0573a c0573a2 = this.f36996b;
                if (c0573a2 == null || (b11 = c0573a2.b()) == null) {
                    return;
                }
                try {
                    b11.release();
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("WindVaneWebView", e11.getMessage());
                    }
                }
            }
        }

        /* renamed from: com.mbridge.msdk.reward.adapter.b$p$b, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0523b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ o f37002a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ a.C0573a f37003b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f37004c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f37005d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f37006e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f37007f;

            RunnableC0523b(o oVar, a.C0573a c0573a, String str, String str2, String str3, String str4) {
                this.f37002a = oVar;
                this.f37003b = c0573a;
                this.f37004c = str;
                this.f37005d = str2;
                this.f37006e = str3;
                this.f37007f = str4;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindVaneWebView b11;
                a.C0573a c0573a;
                if (this.f37002a != null && (c0573a = this.f37003b) != null) {
                    c0573a.a(true);
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f37004c + "_" + this.f37005d + "_" + this.f37006e, true);
                    o oVar = this.f37002a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.f37004c);
                    sb2.append("_");
                    sb2.append(this.f37006e);
                    oVar.a(sb2.toString(), this.f37007f, this.f37004c, this.f37005d, this.f37006e, this.f37003b);
                }
                a.C0573a c0573a2 = this.f37003b;
                if (c0573a2 == null || (b11 = c0573a2.b()) == null) {
                    return;
                }
                try {
                    b11.release();
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("WindVaneWebView", e11.getMessage());
                    }
                }
            }
        }

        public p(Handler handler, Runnable runnable, boolean z10, boolean z11, String str, o oVar, WindVaneWebView windVaneWebView, String str2, String str3, String str4, a.C0573a c0573a, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, long j11) {
            this.f36977a = handler;
            this.f36978b = runnable;
            this.f36979c = z10;
            this.f36980d = z11;
            this.f36981e = str;
            this.f36982f = oVar;
            this.f36983g = windVaneWebView;
            this.f36984h = str2;
            this.f36985i = str4;
            this.f36986j = str3;
            this.f36987k = c0573a;
            this.f36988l = campaignEx;
            this.f36989m = copyOnWriteArrayList;
            this.f36990n = j11;
            a aVar = new a(oVar, c0573a, str4, str, str2, str3);
            this.f36994r = aVar;
            this.f36993q = new RunnableC0523b(oVar, c0573a, str4, str, str2, str3);
            if (handler != null) {
                handler.postDelayed(aVar, 5000L);
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i11) {
            Handler handler;
            Runnable runnable;
            Runnable runnable2;
            super.a(webView, i11);
            Handler handler2 = this.f36977a;
            if (handler2 != null && (runnable2 = this.f36993q) != null) {
                handler2.removeCallbacks(runnable2);
            }
            Handler handler3 = this.f36977a;
            if (handler3 != null && (runnable = this.f36994r) != null) {
                handler3.removeCallbacks(runnable);
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 2);
                eVar.a("result", Integer.valueOf(i11));
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000155", this.f36988l, eVar);
            } catch (Throwable th2) {
                o0.b("WindVaneWebView", th2.getMessage());
            }
            if (this.f36992p) {
                return;
            }
            String str = this.f36985i + "_" + this.f36984h;
            if (i11 == 1) {
                Runnable runnable3 = this.f36978b;
                if (runnable3 != null && (handler = this.f36977a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f36985i + "_" + this.f36981e + "_" + this.f36984h, true);
                a.C0573a c0573a = this.f36987k;
                if (c0573a != null) {
                    c0573a.a(true);
                }
                if (this.f36979c) {
                    if (this.f36980d) {
                        com.mbridge.msdk.videocommon.a.a(MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f36988l.getRequestIdNotice(), this.f36987k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f36988l.getRequestIdNotice(), this.f36987k);
                    }
                } else if (this.f36980d) {
                    com.mbridge.msdk.videocommon.a.a(94, this.f36988l.getRequestIdNotice(), this.f36987k);
                } else {
                    com.mbridge.msdk.videocommon.a.b(94, this.f36988l.getRequestIdNotice(), this.f36987k);
                }
                o oVar = this.f36982f;
                if (oVar != null) {
                    oVar.a(str, this.f36986j, this.f36985i, this.f36981e, this.f36984h, this.f36987k);
                }
            } else if (this.f36982f != null) {
                this.f36982f.a(str, this.f36981e, this.f36984h, this.f36987k, b.b(880009, new MBridgeIds(this.f36986j, this.f36985i, this.f36981e), "readyState:" + i11, null, this.f36988l));
            }
            this.f36992p = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i11, String str, String str2) {
            super.a(webView, i11, str, str2);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f36985i + "_" + this.f36981e + "_" + this.f36984h, false);
            Handler handler = this.f36977a;
            if (handler != null) {
                if (this.f36993q != null) {
                    handler.removeCallbacks(this.f36994r);
                }
                Runnable runnable = this.f36993q;
                if (runnable != null) {
                    this.f36977a.removeCallbacks(runnable);
                }
            }
            try {
                String str3 = this.f36985i + "_" + this.f36984h;
                a.C0573a c0573a = this.f36987k;
                if (c0573a != null) {
                    c0573a.a(false);
                }
                if (this.f36982f != null) {
                    this.f36982f.a(str3, this.f36981e, str2, this.f36987k, b.b(880009, new MBridgeIds(this.f36986j, this.f36985i, this.f36981e), i11 + Utils.SEPARATOR + str, null, this.f36988l));
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("WindVaneWebView", e11.getLocalizedMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.a(webView, sslErrorHandler, sslError);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f36985i + "_" + this.f36981e + "_" + this.f36984h, false);
            Handler handler = this.f36977a;
            if (handler != null) {
                if (this.f36993q != null) {
                    handler.removeCallbacks(this.f36994r);
                }
                Runnable runnable = this.f36993q;
                if (runnable != null) {
                    this.f36977a.removeCallbacks(runnable);
                }
            }
            try {
                String str = this.f36985i + "_" + this.f36984h;
                a.C0573a c0573a = this.f36987k;
                if (c0573a != null) {
                    c0573a.a(false);
                }
                if (this.f36982f != null) {
                    MBridgeIds mBridgeIds = new MBridgeIds(this.f36986j, this.f36985i, this.f36981e);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onReceivedSslError:");
                    sb2.append(sslError == null ? "" : Integer.valueOf(sslError.getPrimaryError()));
                    this.f36982f.a(str, this.f36981e, this.f36984h, this.f36987k, b.b(880009, mBridgeIds, sb2.toString(), null, this.f36988l));
                }
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("WindVaneWebView", e11.getLocalizedMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            Runnable runnable;
            Handler handler;
            Runnable runnable2;
            super.a(webView, str);
            Handler handler2 = this.f36977a;
            if (handler2 != null && (runnable2 = this.f36994r) != null) {
                handler2.removeCallbacks(runnable2);
            }
            if (this.f36991o) {
                return;
            }
            if (str.contains("wfr=1")) {
                Handler handler3 = this.f36977a;
                if (handler3 != null && (runnable = this.f36993q) != null) {
                    handler3.postDelayed(runnable, 5000L);
                }
            } else {
                String str2 = this.f36985i + "_" + this.f36984h;
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f36985i + "_" + this.f36981e + "_" + this.f36984h, true);
                Runnable runnable3 = this.f36978b;
                if (runnable3 != null && (handler = this.f36977a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                a.C0573a c0573a = this.f36987k;
                if (c0573a != null) {
                    c0573a.a(true);
                }
                if (this.f36979c) {
                    if (this.f36988l.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f36988l.getRequestIdNotice(), this.f36987k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f36988l.getRequestIdNotice(), this.f36987k);
                    }
                } else if (this.f36988l.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(94, this.f36988l.getRequestIdNotice(), this.f36987k);
                } else {
                    com.mbridge.msdk.videocommon.a.b(94, this.f36988l.getRequestIdNotice(), this.f36987k);
                }
                o oVar = this.f36982f;
                if (oVar != null) {
                    oVar.a(str2, this.f36986j, this.f36985i, this.f36981e, this.f36984h, this.f36987k);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(webView);
            this.f36991o = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class q extends com.mbridge.msdk.mbsignalcommon.listener.b {

        /* renamed from: a, reason: collision with root package name */
        private String f37009a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f37010b;

        /* renamed from: c, reason: collision with root package name */
        private final WindVaneWebView f37011c;

        /* renamed from: d, reason: collision with root package name */
        private final String f37012d;

        /* renamed from: e, reason: collision with root package name */
        private final String f37013e;

        /* renamed from: f, reason: collision with root package name */
        private final a.C0573a f37014f;

        /* renamed from: g, reason: collision with root package name */
        private final CampaignEx f37015g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f37016h;

        /* renamed from: i, reason: collision with root package name */
        private String f37017i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f37018j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f37019k;

        public q(String str, boolean z10, WindVaneWebView windVaneWebView, String str2, String str3, a.C0573a c0573a, CampaignEx campaignEx, boolean z11, String str4) {
            this.f37010b = z10;
            this.f37011c = windVaneWebView;
            this.f37012d = str2;
            this.f37013e = str3;
            this.f37014f = c0573a;
            this.f37015g = campaignEx;
            this.f37009a = str;
            this.f37016h = z11;
            this.f37017i = str4;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i11) {
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 2);
                eVar.a("result", Integer.valueOf(i11));
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000155", this.f37015g, eVar);
            } catch (Throwable th2) {
                o0.b("WindVaneWebView", th2.getMessage());
            }
            if (this.f37019k) {
                return;
            }
            if (this.f37011c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f37009a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i11);
                    jSONObject2.put("error", "");
                    jSONObject.put("data", jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.f37011c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("WindVaneWebView", e11.getLocalizedMessage());
                    }
                }
            }
            String str = this.f37013e + "_" + this.f37015g.getId() + "_" + this.f37015g.getRequestId() + "_" + this.f37012d;
            if (i11 == 1) {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f37013e + "_" + this.f37017i + "_" + this.f37012d, true);
                a.C0573a c0573a = this.f37014f;
                if (c0573a != null) {
                    c0573a.a(true);
                }
                if (this.f37010b) {
                    if (this.f37015g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(str, this.f37014f, false, this.f37016h);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str, this.f37014f, false, this.f37016h);
                    }
                } else if (this.f37015g.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(str, this.f37014f, false, this.f37016h);
                } else {
                    com.mbridge.msdk.videocommon.a.a(str, this.f37014f, false, this.f37016h);
                }
            } else {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f37013e + "_" + this.f37017i + "_" + this.f37012d, false);
                a.C0573a c0573a2 = this.f37014f;
                if (c0573a2 != null) {
                    c0573a2.a(false);
                }
            }
            this.f37019k = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i11, String str, String str2) {
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f37013e + "_" + this.f37017i + "_" + this.f37012d, false);
            a.C0573a c0573a = this.f37014f;
            if (c0573a != null) {
                c0573a.a(false);
            }
            if (this.f37011c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f37009a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", 2);
                    jSONObject2.put("error", str);
                    jSONObject.put("data", jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.f37011c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("WindVaneWebView", e11.getLocalizedMessage());
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            if (this.f37018j) {
                return;
            }
            if (!str.contains("wfr=1")) {
                if (this.f37011c != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", this.f37009a);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", 1);
                        jSONObject2.put("error", "");
                        jSONObject.put("data", jSONObject2);
                        com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.f37011c, "componentReact", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            o0.b("WindVaneWebView", e11.getLocalizedMessage());
                        }
                    }
                }
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.f37013e + "_" + this.f37017i + "_" + this.f37012d, true);
                a.C0573a c0573a = this.f37014f;
                if (c0573a != null) {
                    c0573a.a(true);
                }
                String str2 = this.f37013e + "_" + this.f37015g.getId() + "_" + this.f37015g.getRequestId() + "_" + this.f37012d;
                if (this.f37010b) {
                    if (this.f37015g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.f37015g.getRequestIdNotice(), this.f37014f);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str2, this.f37014f, false, this.f37016h);
                    }
                } else if (this.f37015g.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(94, this.f37015g.getRequestIdNotice(), this.f37014f);
                } else {
                    com.mbridge.msdk.videocommon.a.a(str2, this.f37014f, false, this.f37016h);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(webView);
            this.f37018j = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class r {

        /* renamed from: a, reason: collision with root package name */
        private static final b f37020a = new b(null);
    }

    private b() {
        this.f36855c = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;
        this.f36856d = "down_type";
        this.f36857e = "h3c";
        this.f36858f = new ArrayList(6);
        HandlerThread handlerThread = new HandlerThread("mb-reward-load-thread");
        f36852g = new ConcurrentHashMap<>();
        handlerThread.start();
        this.f36853a = new m(handlerThread.getLooper());
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    private int a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (campaignEx.getAabEntity() != null) {
                    return campaignEx.getAabEntity().h3c;
                }
            } catch (Throwable th2) {
                o0.b("RewardCampaignsResourceManager", th2.getMessage());
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.mbridge.msdk.foundation.same.report.metrics.c a(CampaignEx campaignEx, int i11) {
        com.mbridge.msdk.foundation.same.report.metrics.c a11 = campaignEx != null ? com.mbridge.msdk.foundation.same.report.metrics.d.b().a(campaignEx.getCurrentLocalRid()) : null;
        if (a11 == null) {
            a11 = new com.mbridge.msdk.foundation.same.report.metrics.c();
        }
        a11.a(campaignEx);
        a11.f(a(campaignEx));
        a11.e(i11);
        return a11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i11, CampaignEx campaignEx, String str, String str2) {
        x.a(i11, str, str2, new C0521b(i11, campaignEx), campaignEx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, int i11, CampaignEx campaignEx, String str, String str2, String str3, String str4) {
        com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new d(campaignEx, context, i11, str, str2, str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, String str3, CampaignEx campaignEx, String str4, n nVar, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        if (TextUtils.isEmpty(str4) || campaignEx.isMraid()) {
            return;
        }
        com.mbridge.msdk.foundation.same.report.metrics.c a11 = a(campaignEx, 3);
        if (str4.contains(".zip") && str4.contains(ResourceManager.KEY_MD5FILENAME)) {
            boolean isEmpty = TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str4));
            try {
                l lVar = new l(context, str, str2, str3, campaignEx, 497, this.f36853a, nVar, copyOnWriteArrayList);
                lVar.a(isEmpty);
                H5DownLoadManager.getInstance().downloadH5Res(a11, str4, lVar);
                return;
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                    return;
                }
                return;
            }
        }
        boolean isEmpty2 = TextUtils.isEmpty(HTMLResourceManager.getInstance().getHtmlContentFromUrl(str4));
        try {
            i iVar = new i(497, str, str2, str3, campaignEx, nVar, this.f36853a, copyOnWriteArrayList);
            iVar.a(isEmpty2);
            H5DownLoadManager.getInstance().downloadH5Res(a11, str4, iVar);
        } catch (Exception e12) {
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardCampaignsResourceManager", e12.getLocalizedMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z10, WindVaneWebView windVaneWebView, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.videocommon.setting.c cVar, String str, String str2, int i11) {
        if (windVaneWebView != null) {
            if (campaignEx == null || cVar == null || campaignEx.getRewardTemplateMode() == null || TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", str2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", 2);
                    jSONObject2.put("error", ConstantsKt.ERROR_1000_MESSAGE);
                    jSONObject.put("data", jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    return;
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        o0.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                        return;
                    }
                    return;
                }
            }
            if (!TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                if (TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e()) || !campaignEx.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY)) {
                    new Handler(Looper.getMainLooper()).postDelayed(new e(z10, windVaneWebView, campaignEx, copyOnWriteArrayList, str, cVar, str2), i11 * 1000);
                    return;
                } else {
                    o0.a("RewardCampaignsResourceManager", "getTeamplateUrl contains cmpt=1");
                    return;
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("id", str2);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("result", 1);
                jSONObject4.put("error", ConstantsKt.ERROR_1000_MESSAGE);
                jSONObject3.put("data", jSONObject4);
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    o0.b("RewardCampaignsResourceManager", e12.getLocalizedMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z10, WindVaneWebView windVaneWebView, String str, int i11, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str2, String str3, com.mbridge.msdk.videocommon.setting.c cVar, String str4, boolean z11) {
        com.mbridge.msdk.video.signal.impl.k kVar;
        String requestId;
        try {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a(NativeComponentConstants.KEY_COMPONENT_TYPE, 2);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000154", campaignEx, eVar);
            a.C0573a c0573a = new a.C0573a();
            WindVaneWebView windVaneWebView2 = new WindVaneWebView(com.mbridge.msdk.foundation.controller.c.m().d());
            if (campaignEx != null) {
                windVaneWebView2.setLocalRequestId(campaignEx.getCurrentLocalRid());
            }
            windVaneWebView2.setTempTypeForMetrics(2);
            c0573a.a(windVaneWebView2);
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
                kVar = new com.mbridge.msdk.video.signal.impl.k(null, campaignEx);
                requestId = campaignEx != null ? campaignEx.getRequestId() : "";
            } else {
                CopyOnWriteArrayList<CampaignEx> b11 = com.mbridge.msdk.videocommon.download.b.getInstance().b(str3);
                if (b11 != null && b11.size() > 0) {
                    for (int i12 = 0; i12 < copyOnWriteArrayList.size(); i12++) {
                        CampaignEx campaignEx2 = copyOnWriteArrayList.get(i12);
                        for (CampaignEx campaignEx3 : b11) {
                            if (campaignEx3.getId().equals(campaignEx2.getId()) && campaignEx3.getRequestId().equals(campaignEx2.getRequestId())) {
                                campaignEx2.setReady(true);
                                copyOnWriteArrayList.set(i12, campaignEx2);
                            }
                        }
                    }
                }
                com.mbridge.msdk.video.signal.impl.k kVar2 = new com.mbridge.msdk.video.signal.impl.k(null, campaignEx, copyOnWriteArrayList);
                requestId = copyOnWriteArrayList.get(0).getRequestId();
                kVar = kVar2;
            }
            kVar.g(i11);
            kVar.setUnitId(str3);
            kVar.c(str4);
            kVar.setRewardUnitSetting(cVar);
            kVar.d(z10);
            windVaneWebView2.setWebViewListener(new q(str4, false, windVaneWebView, str, str3, c0573a, campaignEx, z11, requestId));
            windVaneWebView2.setObject(kVar);
            windVaneWebView2.loadUrl(str2);
            windVaneWebView2.setRid(requestId);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.mbridge.msdk.foundation.error.b b(int i11, MBridgeIds mBridgeIds, String str, Throwable th2, CampaignEx campaignEx) {
        com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(i11);
        bVar.a(mBridgeIds);
        bVar.a(th2);
        bVar.c(str);
        bVar.a(campaignEx);
        return bVar;
    }

    public static b b() {
        return r.f37020a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.mbridge.msdk.foundation.entity.m mVar, CampaignEx campaignEx) {
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
            o0.b("RewardCampaignsResourceManager", e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(int i11) {
        if (i11 == 200) {
            return 880004;
        }
        if (i11 == 201) {
            return 880007;
        }
        if (i11 != 203) {
            return i11 != 205 ? 880024 : 880005;
        }
        return 880006;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static synchronized String d(int i11) {
        synchronized (b.class) {
            return i11 != 200 ? i11 != 201 ? i11 != 203 ? i11 != 205 ? TmcConstants.ROUTE_UNKNOWN : "tpl" : "temp" : "zip/html" : "video";
        }
    }

    public synchronized void a(Context context, CampaignEx campaignEx, String str, String str2, String str3, n nVar) {
        try {
            this.f36853a.a(context);
            if (campaignEx != null) {
                String cMPTEntryUrl = campaignEx.getCMPTEntryUrl();
                if (campaignEx.isDynamicView()) {
                    if (t0.a(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, cMPTEntryUrl)) {
                        a(0, campaignEx, campaignEx.getMof_tplid() + "", cMPTEntryUrl);
                    }
                    ResDownloadCheckManager.getInstance().setZipDownloadDone(cMPTEntryUrl, true);
                    Message obtain = Message.obtain();
                    obtain.what = 105;
                    Bundle bundle = new Bundle();
                    bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                    bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                    bundle.putString(TrackingKey.REQUEST_ID, str3);
                    bundle.putString("key", str2 + "_" + str3 + "_" + campaignEx.getSecondRequestIndex());
                    bundle.putString("url", cMPTEntryUrl);
                    obtain.setData(bundle);
                    this.f36853a.sendMessage(obtain);
                    if (nVar != null) {
                        nVar.a(str, str2, str3, cMPTEntryUrl);
                    }
                    return;
                }
            }
            if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
                try {
                    com.mbridge.msdk.foundation.same.report.metrics.c a11 = com.mbridge.msdk.foundation.same.report.metrics.d.b().a(campaignEx.getCurrentLocalRid());
                    if (a11 == null) {
                        a11 = new com.mbridge.msdk.foundation.same.report.metrics.c();
                    }
                    com.mbridge.msdk.foundation.same.report.metrics.c cVar = a11;
                    cVar.a(campaignEx);
                    cVar.e(1);
                    cVar.f(a(campaignEx));
                    H5DownLoadManager.getInstance().downloadH5Res(cVar, campaignEx.getCMPTEntryUrl(), new c(str2, str, str3, campaignEx, nVar, context));
                } catch (Exception e11) {
                    o0.b("RewardCampaignsResourceManager", e11.getLocalizedMessage());
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void a(Context context, boolean z10, int i11, boolean z11, int i12, String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, h hVar, n nVar) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        String str4 = str2 + "_" + str3 + "_" + copyOnWriteArrayList2.get(0).getSecondRequestIndex();
        f36852g.put(str4, new f(z10, z11, i11, copyOnWriteArrayList2.size(), str2, str3, i12, copyOnWriteArrayList2));
        this.f36853a.a(str4, hVar);
        this.f36853a.a(context);
        this.f36853a.a(str4, copyOnWriteArrayList2);
        this.f36853a.post(new a(copyOnWriteArrayList2, context, str2, i12, str, str3, str4, nVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x01a9 A[Catch: all -> 0x003a, TryCatch #5 {, blocks: (B:4:0x0009, B:6:0x0021, B:9:0x0029, B:13:0x0046, B:26:0x0088, B:29:0x008e, B:31:0x0094, B:33:0x00a3, B:35:0x00eb, B:43:0x01a5, B:45:0x01a9, B:47:0x01b4, B:39:0x009d, B:50:0x015b, B:57:0x0104, B:60:0x0112, B:62:0x0124), top: B:3:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01b4 A[Catch: all -> 0x003a, TRY_LEAVE, TryCatch #5 {, blocks: (B:4:0x0009, B:6:0x0021, B:9:0x0029, B:13:0x0046, B:26:0x0088, B:29:0x008e, B:31:0x0094, B:33:0x00a3, B:35:0x00eb, B:43:0x01a5, B:45:0x01a9, B:47:0x01b4, B:39:0x009d, B:50:0x015b, B:57:0x0104, B:60:0x0112, B:62:0x0124), top: B:3:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(boolean r24, android.os.Handler r25, boolean r26, boolean r27, com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r28, java.lang.String r29, int r30, com.mbridge.msdk.foundation.entity.CampaignEx r31, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, com.mbridge.msdk.videocommon.setting.c r38, com.mbridge.msdk.reward.adapter.b.o r39) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.a(boolean, android.os.Handler, boolean, boolean, com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView, java.lang.String, int, com.mbridge.msdk.foundation.entity.CampaignEx, java.util.concurrent.CopyOnWriteArrayList, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.mbridge.msdk.videocommon.setting.c, com.mbridge.msdk.reward.adapter.b$o):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01d5 A[Catch: all -> 0x0044, TRY_ENTER, TryCatch #1 {, blocks: (B:4:0x000b, B:7:0x0031, B:12:0x0049, B:14:0x007c, B:15:0x008a, B:17:0x00a5, B:19:0x00ab, B:21:0x00b5, B:24:0x00bc, B:26:0x00c2, B:27:0x00cc, B:29:0x00d2, B:31:0x00e6, B:33:0x00f4, B:39:0x00fd, B:41:0x0101, B:43:0x0112, B:46:0x015b, B:49:0x016f, B:52:0x018f, B:58:0x01d5, B:59:0x01f7, B:61:0x01fb, B:69:0x010b), top: B:3:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01fb A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x000b, B:7:0x0031, B:12:0x0049, B:14:0x007c, B:15:0x008a, B:17:0x00a5, B:19:0x00ab, B:21:0x00b5, B:24:0x00bc, B:26:0x00c2, B:27:0x00cc, B:29:0x00d2, B:31:0x00e6, B:33:0x00f4, B:39:0x00fd, B:41:0x0101, B:43:0x0112, B:46:0x015b, B:49:0x016f, B:52:0x018f, B:58:0x01d5, B:59:0x01f7, B:61:0x01fb, B:69:0x010b), top: B:3:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(boolean r27, android.os.Handler r28, boolean r29, boolean r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, int r36, com.mbridge.msdk.foundation.entity.CampaignEx r37, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r38, java.lang.String r39, java.lang.String r40, com.mbridge.msdk.videocommon.setting.c r41, com.mbridge.msdk.reward.adapter.b.o r42, boolean r43) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.reward.adapter.b.a(boolean, android.os.Handler, boolean, boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, com.mbridge.msdk.foundation.entity.CampaignEx, java.util.concurrent.CopyOnWriteArrayList, java.lang.String, java.lang.String, com.mbridge.msdk.videocommon.setting.c, com.mbridge.msdk.reward.adapter.b$o, boolean):void");
    }

    public void c() {
    }
}
