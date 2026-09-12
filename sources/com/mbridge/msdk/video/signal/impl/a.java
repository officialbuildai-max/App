package com.mbridge.msdk.video.signal.impl;

import android.app.Activity;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.video.signal.a;

/* loaded from: classes5.dex */
public abstract class a implements com.mbridge.msdk.video.signal.d {

    /* renamed from: j, reason: collision with root package name */
    protected String f39875j;

    /* renamed from: k, reason: collision with root package name */
    protected com.mbridge.msdk.videocommon.setting.c f39876k;

    /* renamed from: l, reason: collision with root package name */
    protected com.mbridge.msdk.click.a f39877l;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f39866a = false;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f39867b = false;

    /* renamed from: c, reason: collision with root package name */
    protected int f39868c = 0;

    /* renamed from: d, reason: collision with root package name */
    protected int f39869d = 0;

    /* renamed from: e, reason: collision with root package name */
    protected int f39870e = 0;

    /* renamed from: f, reason: collision with root package name */
    protected int f39871f = 0;

    /* renamed from: g, reason: collision with root package name */
    protected int f39872g = 0;

    /* renamed from: h, reason: collision with root package name */
    protected int f39873h = 1;

    /* renamed from: i, reason: collision with root package name */
    protected int f39874i = -1;

    /* renamed from: m, reason: collision with root package name */
    public a.InterfaceC0571a f39878m = new C0572a();

    /* renamed from: n, reason: collision with root package name */
    protected int f39879n = 2;

    /* renamed from: o, reason: collision with root package name */
    protected int f39880o = 2;

    /* renamed from: p, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.b f39881p = null;

    /* renamed from: q, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.media.a f39882q = null;

    /* renamed from: r, reason: collision with root package name */
    private com.iab.omid.library.mmadbridge.adsession.a f39883r = null;

    /* renamed from: com.mbridge.msdk.video.signal.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0572a implements a.InterfaceC0571a {
        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0571a
        public void a() {
            o0.a("DefaultJSCommon", "videoLocationReady");
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0571a
        public void a(int i11, String str) {
            o0.a("DefaultJSCommon", "onH5Error,code:" + i11 + "，msg:" + str);
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0571a
        public void a(boolean z10) {
            o0.a("DefaultJSCommon", "onStartInstall");
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDismissLoading(Campaign campaign) {
            o0.a("DefaultJSCommon", "onDismissLoading,campaign:" + campaign);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadFinish(Campaign campaign) {
            o0.a("DefaultJSCommon", "onDownloadFinish,campaign:" + campaign);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadProgress(int i11) {
            o0.a("DefaultJSCommon", "onDownloadProgress,progress:" + i11);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadStart(Campaign campaign) {
            o0.a("DefaultJSCommon", "onDownloadStart,campaign:" + campaign);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            o0.a("DefaultJSCommon", "onFinishRedirection,campaign:" + campaign + ",url:" + str);
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0571a
        public void onInitSuccess() {
            o0.a("DefaultJSCommon", "onInitSuccess");
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public boolean onInterceptDefaultLoadingDialog() {
            o0.a("DefaultJSCommon", "onInterceptDefaultLoadingDialog");
            return false;
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            o0.a("DefaultJSCommon", "onFinishRedirection,campaign:" + campaign + ",url:" + str);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onShowLoading(Campaign campaign) {
            o0.a("DefaultJSCommon", "onShowLoading,campaign:" + campaign);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            o0.a("DefaultJSCommon", "onStartRedirection,campaign:" + campaign + ",url:" + str);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements a.InterfaceC0571a {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.video.signal.d f39884a;

        /* renamed from: b, reason: collision with root package name */
        private a.InterfaceC0571a f39885b;

        public b(com.mbridge.msdk.video.signal.d dVar, a.InterfaceC0571a interfaceC0571a) {
            this.f39884a = dVar;
            this.f39885b = interfaceC0571a;
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0571a
        public void a() {
            a.InterfaceC0571a interfaceC0571a = this.f39885b;
            if (interfaceC0571a != null) {
                interfaceC0571a.a();
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0571a
        public void a(int i11, String str) {
            a.InterfaceC0571a interfaceC0571a = this.f39885b;
            if (interfaceC0571a != null) {
                interfaceC0571a.a(i11, str);
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0571a
        public void a(boolean z10) {
            a.InterfaceC0571a interfaceC0571a = this.f39885b;
            if (interfaceC0571a != null) {
                interfaceC0571a.a(z10);
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDismissLoading(Campaign campaign) {
            a.InterfaceC0571a interfaceC0571a = this.f39885b;
            if (interfaceC0571a != null) {
                interfaceC0571a.onDismissLoading(campaign);
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadFinish(Campaign campaign) {
            a.InterfaceC0571a interfaceC0571a = this.f39885b;
            if (interfaceC0571a != null) {
                interfaceC0571a.onDownloadFinish(campaign);
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadProgress(int i11) {
            a.InterfaceC0571a interfaceC0571a = this.f39885b;
            if (interfaceC0571a != null) {
                interfaceC0571a.onDownloadProgress(i11);
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadStart(Campaign campaign) {
            a.InterfaceC0571a interfaceC0571a = this.f39885b;
            if (interfaceC0571a != null) {
                interfaceC0571a.onDownloadStart(campaign);
            }
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            a.InterfaceC0571a interfaceC0571a = this.f39885b;
            if (interfaceC0571a != null) {
                interfaceC0571a.onFinishRedirection(campaign, str);
            }
            com.mbridge.msdk.video.signal.d dVar = this.f39884a;
            if (dVar != null) {
                dVar.f();
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0571a
        public void onInitSuccess() {
            a.InterfaceC0571a interfaceC0571a = this.f39885b;
            if (interfaceC0571a != null) {
                interfaceC0571a.onInitSuccess();
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public boolean onInterceptDefaultLoadingDialog() {
            a.InterfaceC0571a interfaceC0571a = this.f39885b;
            return interfaceC0571a != null && interfaceC0571a.onInterceptDefaultLoadingDialog();
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            a.InterfaceC0571a interfaceC0571a = this.f39885b;
            if (interfaceC0571a != null) {
                interfaceC0571a.onRedirectionFailed(campaign, str);
            }
            com.mbridge.msdk.video.signal.d dVar = this.f39884a;
            if (dVar != null) {
                dVar.f();
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onShowLoading(Campaign campaign) {
            a.InterfaceC0571a interfaceC0571a = this.f39885b;
            if (interfaceC0571a != null) {
                interfaceC0571a.onShowLoading(campaign);
            }
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            a.InterfaceC0571a interfaceC0571a = this.f39885b;
            if (interfaceC0571a != null) {
                interfaceC0571a.onStartRedirection(campaign, str);
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(int i11) {
        this.f39874i = i11;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(int i11, String str) {
        o0.a("DefaultJSCommon", "statistics,type:" + i11 + ",json:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(a.InterfaceC0571a interfaceC0571a) {
        o0.a("DefaultJSCommon", "setTrackingListener:" + interfaceC0571a);
        this.f39878m = interfaceC0571a;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(String str) {
        o0.a("DefaultJSCommon", "setNotchArea");
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(boolean z10) {
        o0.a("DefaultJSCommon", "setIsShowingTransparent:" + z10);
        this.f39867b = z10;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public boolean a() {
        return this.f39866a;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public int b() {
        return this.f39872g;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void b(int i11) {
        this.f39868c = i11;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void b(boolean z10) {
        this.f39866a = z10;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String c() {
        o0.a("DefaultJSCommon", "init");
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void c(int i11) {
        this.f39870e = i11;
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void click(int i11, String str) {
        o0.a("DefaultJSCommon", "click:type" + i11 + ",pt:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.a
    public int d() {
        o0.a("DefaultJSCommon", "getAlertDialogRole " + this.f39873h);
        return this.f39873h;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void d(int i11) {
        o0.a("DefaultJSCommon", "setAlertDialogRole " + i11);
        this.f39873h = i11;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String e() {
        o0.a("DefaultJSCommon", "getNotchArea");
        return null;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void e(int i11) {
        this.f39869d = i11;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String f(int i11) {
        o0.a("DefaultJSCommon", "getSDKInfo");
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void f() {
        o0.a("DefaultJSCommon", "finish");
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String g() {
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void g(int i11) {
        this.f39879n = i11;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void h() {
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void handlerH5Exception(int i11, String str) {
        o0.a("DefaultJSCommon", "handlerH5Exception,code=" + i11 + ",msg:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.a
    public int i() {
        return this.f39874i;
    }

    public com.iab.omid.library.mmadbridge.adsession.a j() {
        return this.f39883r;
    }

    public com.iab.omid.library.mmadbridge.adsession.b k() {
        return this.f39881p;
    }

    public int l() {
        if (this.f39868c == 0 && this.f39867b) {
            this.f39868c = 1;
        }
        return this.f39868c;
    }

    public int m() {
        if (this.f39869d == 0 && this.f39867b) {
            this.f39869d = 1;
        }
        return this.f39869d;
    }

    public int n() {
        if (this.f39870e == 0 && this.f39867b) {
            this.f39870e = 1;
        }
        return this.f39870e;
    }

    public com.iab.omid.library.mmadbridge.adsession.media.a o() {
        return this.f39882q;
    }

    public boolean p() {
        return this.f39867b;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void release() {
        o0.a("DefaultJSCommon", "release");
        com.mbridge.msdk.click.a aVar = this.f39877l;
        if (aVar != null) {
            aVar.a(false);
            this.f39877l.a((NativeListener.NativeTrackingListener) null);
            this.f39877l.c();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setActivity(Activity activity) {
        o0.a("DefaultJSCommon", "setActivity ");
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setAdEvents(com.iab.omid.library.mmadbridge.adsession.a aVar) {
        this.f39883r = aVar;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setAdSession(com.iab.omid.library.mmadbridge.adsession.b bVar) {
        this.f39881p = bVar;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setRewardUnitSetting(com.mbridge.msdk.videocommon.setting.c cVar) {
        o0.a("DefaultJSCommon", "setSetting:" + cVar);
        this.f39876k = cVar;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setUnitId(String str) {
        o0.a("DefaultJSCommon", "setUnitId:" + str);
        this.f39875j = str;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setVideoEvents(com.iab.omid.library.mmadbridge.adsession.media.a aVar) {
        this.f39882q = aVar;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setWebViewFront(int i11) {
        this.f39872g = i11;
    }
}
