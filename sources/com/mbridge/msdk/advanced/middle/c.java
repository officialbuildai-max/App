package com.mbridge.msdk.advanced.middle;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.advanced.view.MBOutNativeAdvancedViewGroup;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.NativeAdvancedAdListener;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.j;
import com.mbridge.msdk.setting.l;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class c {
    private static String G = "NativeAdvancedProvider";
    private boolean A;
    private boolean B;
    private boolean C;

    /* renamed from: a, reason: collision with root package name */
    private String f34227a;

    /* renamed from: b, reason: collision with root package name */
    private String f34228b;

    /* renamed from: c, reason: collision with root package name */
    private MBridgeIds f34229c;

    /* renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.advanced.manager.b f34230d;

    /* renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.advanced.manager.c f34231e;

    /* renamed from: f, reason: collision with root package name */
    private b f34232f;

    /* renamed from: g, reason: collision with root package name */
    private NativeAdvancedAdListener f34233g;

    /* renamed from: h, reason: collision with root package name */
    private d f34234h;

    /* renamed from: i, reason: collision with root package name */
    private MBNativeAdvancedView f34235i;

    /* renamed from: j, reason: collision with root package name */
    private MBNativeAdvancedWebview f34236j;

    /* renamed from: k, reason: collision with root package name */
    private com.mbridge.msdk.advanced.view.a f34237k;

    /* renamed from: l, reason: collision with root package name */
    private l f34238l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f34239m;

    /* renamed from: n, reason: collision with root package name */
    private j f34240n;

    /* renamed from: x, reason: collision with root package name */
    private JSONObject f34250x;

    /* renamed from: z, reason: collision with root package name */
    private MBOutNativeAdvancedViewGroup f34252z;

    /* renamed from: o, reason: collision with root package name */
    private int f34241o = -1;

    /* renamed from: p, reason: collision with root package name */
    private boolean f34242p = false;

    /* renamed from: q, reason: collision with root package name */
    private int f34243q = 0;

    /* renamed from: r, reason: collision with root package name */
    private boolean f34244r = false;

    /* renamed from: s, reason: collision with root package name */
    private int f34245s = 0;

    /* renamed from: t, reason: collision with root package name */
    private boolean f34246t = false;

    /* renamed from: u, reason: collision with root package name */
    private int f34247u = 0;

    /* renamed from: v, reason: collision with root package name */
    private int f34248v = 0;

    /* renamed from: w, reason: collision with root package name */
    private Object f34249w = new Object();

    /* renamed from: y, reason: collision with root package name */
    private boolean f34251y = false;
    private boolean D = true;
    public boolean E = false;
    private ViewTreeObserver.OnScrollChangedListener F = new a();

    /* loaded from: classes5.dex */
    class a implements ViewTreeObserver.OnScrollChangedListener {

        /* renamed from: com.mbridge.msdk.advanced.middle.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        class RunnableC0472a implements Runnable {
            RunnableC0472a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.D = true;
            }
        }

        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            if (c.this.D) {
                c.this.D = false;
                if (c.this.f34252z != null) {
                    c.this.f34252z.postDelayed(new RunnableC0472a(), 1000L);
                }
                try {
                    c.this.i();
                } catch (Exception e11) {
                    o0.b(c.G, e11.getMessage());
                }
            }
        }
    }

    public c(String str, String str2, Activity activity) {
        this.f34228b = TextUtils.isEmpty(str) ? "" : str;
        this.f34227a = str2;
        this.f34229c = new MBridgeIds(str, str2);
        a(activity);
    }

    private void a(int i11) {
        if (this.f34242p) {
            this.f34241o = i11;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f34236j;
            if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
                return;
            }
            int i12 = this.f34241o;
            if (i12 == 1) {
                this.f34231e.a(true);
                com.mbridge.msdk.advanced.signal.a.a(this.f34236j, "showCloseButton", "", null);
            } else if (i12 == 0) {
                this.f34231e.a(false);
                com.mbridge.msdk.advanced.signal.a.a(this.f34236j, "hideCloseButton", "", null);
            }
        }
    }

    private void a(int i11, int i12) {
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        this.f34248v = i11;
        this.f34247u = i12;
        this.f34252z.setLayoutParams(new ViewGroup.LayoutParams(i12, i11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20, types: [android.content.Context] */
    private void a(Activity activity) {
        com.mbridge.msdk.advanced.view.a aVar;
        if (this.f34231e == null) {
            com.mbridge.msdk.advanced.manager.c cVar = new com.mbridge.msdk.advanced.manager.c(com.mbridge.msdk.foundation.controller.c.m().d(), this.f34228b, this.f34227a);
            this.f34231e = cVar;
            cVar.a(this);
        }
        if (this.f34236j == null) {
            try {
                this.f34236j = new MBNativeAdvancedWebview(com.mbridge.msdk.foundation.controller.c.m().d());
            } catch (Exception e11) {
                o0.b(G, e11.getMessage());
            }
            if (this.f34237k == null) {
                try {
                    this.f34237k = new com.mbridge.msdk.advanced.view.a(this.f34227a, this.f34231e.b(), this);
                } catch (Exception e12) {
                    o0.b(G, e12.getMessage());
                }
            }
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f34236j;
            if (mBNativeAdvancedWebview != null && (aVar = this.f34237k) != null) {
                mBNativeAdvancedWebview.setWebViewClient(aVar);
            }
        }
        if (this.f34235i == null) {
            ?? d11 = com.mbridge.msdk.foundation.controller.c.m().d();
            if (activity == null) {
                activity = d11;
            }
            MBNativeAdvancedView mBNativeAdvancedView = new MBNativeAdvancedView(activity);
            this.f34235i = mBNativeAdvancedView;
            mBNativeAdvancedView.setAdvancedNativeWebview(this.f34236j);
            MBNativeAdvancedWebview mBNativeAdvancedWebview2 = this.f34236j;
            if (mBNativeAdvancedWebview2 != null && mBNativeAdvancedWebview2.getParent() == null) {
                this.f34235i.addView(this.f34236j, new ViewGroup.LayoutParams(-1, -1));
            }
        }
        if (this.f34252z == null) {
            this.f34252z = new MBOutNativeAdvancedViewGroup(com.mbridge.msdk.foundation.controller.c.m().d());
            this.f34252z.setLayoutParams((this.f34247u == 0 || this.f34248v == 0) ? new ViewGroup.LayoutParams(-1, -1) : new ViewGroup.LayoutParams(this.f34247u, this.f34248v));
            this.f34252z.setProvider(this);
            this.f34252z.addView(this.f34235i);
            this.f34252z.getViewTreeObserver().addOnScrollChangedListener(this.F);
        }
        if (this.f34240n == null) {
            this.f34240n = new j();
        }
        this.f34240n.a(com.mbridge.msdk.foundation.controller.c.m().d(), com.mbridge.msdk.foundation.controller.c.m().b(), com.mbridge.msdk.foundation.controller.c.m().c(), this.f34227a);
    }

    private void a(CampaignEx campaignEx) {
        if (com.mbridge.msdk.advanced.manager.d.a(this.f34235i, campaignEx, this.f34228b, this.f34227a)) {
            this.f34231e.a(this.f34234h);
            o0.b(G, "start show process");
            this.f34231e.a(campaignEx, this.f34235i, true);
        }
    }

    private void a(String str, int i11) {
        boolean z10;
        this.D = true;
        synchronized (this.f34249w) {
            try {
                if (this.f34239m) {
                    if (this.f34232f != null) {
                        this.f34232f.a(new com.mbridge.msdk.foundation.error.b(880016, "current unit is loading"), i11);
                        this.f34239m = true;
                    }
                    return;
                }
                this.f34239m = true;
                if (this.f34247u == 0 || this.f34248v == 0) {
                    if (this.f34232f != null) {
                        this.f34232f.a(new com.mbridge.msdk.foundation.error.b(880028), i11);
                        return;
                    }
                    return;
                }
                if (this.f34235i == null) {
                    if (this.f34232f != null) {
                        this.f34232f.a(new com.mbridge.msdk.foundation.error.b(880030), i11);
                        return;
                    }
                    return;
                }
                try {
                    z10 = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.b(com.mbridge.msdk.foundation.controller.c.m().d());
                } catch (Exception e11) {
                    o0.b(G, e11.getMessage());
                    z10 = false;
                }
                if (!z10) {
                    if (this.f34232f != null) {
                        this.f34232f.a(new com.mbridge.msdk.foundation.error.b(880029), i11);
                        return;
                    }
                    return;
                }
                this.f34235i.clearResStateAndRemoveClose();
                l a11 = h.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.f34227a);
                this.f34238l = a11;
                if (a11 == null) {
                    this.f34238l = l.k(this.f34227a);
                }
                if (this.f34230d == null) {
                    this.f34230d = new com.mbridge.msdk.advanced.manager.b(this.f34228b, this.f34227a, 0L);
                }
                b bVar = this.f34232f;
                if (bVar != null) {
                    bVar.a(str);
                    this.f34230d.a(this.f34232f);
                }
                this.f34235i.resetLoadState();
                this.f34230d.a(this.f34235i);
                this.f34230d.a(this.f34238l);
                this.f34230d.a(this.f34247u, this.f34248v);
                this.f34230d.a(this.f34241o);
                this.f34230d.b(str, i11);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void a(JSONObject jSONObject) {
        if (this.f34251y) {
            this.f34250x = jSONObject;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f34236j;
            if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.advanced.signal.a.a(this.f34236j, "setStyleList", "", jSONObject);
        }
    }

    private void c(int i11) {
        if (this.f34244r) {
            this.f34243q = i11;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f34236j;
            if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.advanced.signal.a.a(this.f34236j, "setVolume", CampaignEx.JSON_NATIVE_VIDEO_MUTE, Integer.valueOf(i11));
        }
    }

    private void e(int i11) {
        MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f34236j;
        if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
            return;
        }
        try {
            if (this.f34236j != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("netstat", i11);
                f.a().a((WebView) this.f34236j, "onNetstatChanged", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            }
        } catch (Throwable th2) {
            o0.a(G, th2.getMessage());
        }
    }

    private void g(int i11) {
        if (this.f34246t) {
            this.f34245s = i11;
            MBNativeAdvancedWebview mBNativeAdvancedWebview = this.f34236j;
            if (mBNativeAdvancedWebview == null || mBNativeAdvancedWebview.isDestoryed()) {
                return;
            }
            com.mbridge.msdk.advanced.signal.a.a(this.f34236j, "setVideoPlayMode", "autoPlay", Integer.valueOf(i11));
        }
    }

    private void h() {
        com.mbridge.msdk.advanced.manager.c cVar = this.f34231e;
        if (cVar != null) {
            cVar.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.A && this.B && this.C) {
            CampaignEx a11 = com.mbridge.msdk.advanced.manager.d.a(this.f34235i, this.f34228b, this.f34227a, "", this.f34241o, true, true);
            if (a11 != null) {
                a11.getImpReportType();
            }
            if (b1.a(this.f34235i.getAdvancedNativeWebview(), 0) || this.f34252z.getAlpha() < 0.5f || this.f34252z.getVisibility() != 0) {
                return;
            }
            com.mbridge.msdk.advanced.manager.c cVar = this.f34231e;
            if (cVar != null) {
                cVar.f();
            }
            b(a11);
        }
    }

    private void j() {
        a(this.f34241o);
        c(this.f34243q);
        g(this.f34245s);
        a(this.f34250x);
        e(k0.s(com.mbridge.msdk.foundation.controller.c.m().d()));
    }

    public String a(String str) {
        com.mbridge.msdk.advanced.manager.b bVar = this.f34230d;
        return bVar != null ? bVar.a(str) : "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(CampaignEx campaignEx, boolean z10) {
        j();
        MBOutNativeAdvancedViewGroup mBOutNativeAdvancedViewGroup = this.f34252z;
        if (mBOutNativeAdvancedViewGroup == null || mBOutNativeAdvancedViewGroup.getParent() == null) {
            return;
        }
        if (campaignEx != null && z10) {
            if (this.f34238l == null) {
                this.f34238l = h.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), this.f34227a);
            }
            this.f34234h = new d(this, this.f34233g, campaignEx);
        }
        if (this.f34231e == null) {
            com.mbridge.msdk.advanced.manager.c cVar = new com.mbridge.msdk.advanced.manager.c(com.mbridge.msdk.foundation.controller.c.m().d(), this.f34228b, this.f34227a);
            this.f34231e = cVar;
            cVar.a(this);
        }
        a(campaignEx);
    }

    public void a(NativeAdvancedAdListener nativeAdvancedAdListener) {
        this.f34233g = nativeAdvancedAdListener;
    }

    public void a(boolean z10) {
        this.f34239m = z10;
    }

    public void b() {
        if (this.f34233g != null) {
            this.f34233g = null;
        }
        if (this.f34232f != null) {
            this.f34232f = null;
        }
        if (this.f34234h != null) {
            this.f34234h = null;
        }
        com.mbridge.msdk.advanced.manager.b bVar = this.f34230d;
        if (bVar != null) {
            bVar.a((MBNativeAdvancedView) null);
            this.f34230d.e();
        }
        com.mbridge.msdk.advanced.manager.c cVar = this.f34231e;
        if (cVar != null) {
            cVar.g();
        }
        MBNativeAdvancedView mBNativeAdvancedView = this.f34235i;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.destroy();
        }
        com.mbridge.msdk.advanced.common.c.b(this.f34228b + this.f34227a + e());
        com.mbridge.msdk.advanced.view.a aVar = this.f34237k;
        if (aVar != null) {
            aVar.b();
        }
        MBOutNativeAdvancedViewGroup mBOutNativeAdvancedViewGroup = this.f34252z;
        if (mBOutNativeAdvancedViewGroup != null) {
            mBOutNativeAdvancedViewGroup.getViewTreeObserver().removeOnScrollChangedListener(this.F);
            this.f34252z.removeAllViews();
            this.f34252z = null;
        }
    }

    public void b(int i11) {
        this.f34242p = true;
        a(i11);
    }

    public void b(int i11, int i12) {
        a(i11, i12);
    }

    public void b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            if (this.f34238l == null) {
                this.f34238l = h.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), this.f34227a);
            }
            this.f34234h = new d(this, this.f34233g, campaignEx);
            o0.a(G, "show start");
            if (this.f34247u != 0 && this.f34248v != 0) {
                a(campaignEx, false);
                return;
            }
            d dVar = this.f34234h;
            if (dVar != null) {
                dVar.a(this.f34229c, "width or height is 0  or width or height is too small");
            }
        }
    }

    public void b(JSONObject jSONObject) {
        this.f34251y = true;
        a(jSONObject);
    }

    public boolean b(String str) {
        return (this.f34252z == null || com.mbridge.msdk.advanced.manager.d.a(this.f34235i, this.f34228b, this.f34227a, str, this.f34241o, false, true) == null) ? false : true;
    }

    public String c() {
        if (this.E) {
            com.mbridge.msdk.advanced.manager.c cVar = this.f34231e;
            return cVar != null ? cVar.a() : "";
        }
        com.mbridge.msdk.advanced.manager.b bVar = this.f34230d;
        return bVar != null ? bVar.c() : "";
    }

    public void c(String str) {
        b bVar = new b(this, this.f34229c);
        this.f34232f = bVar;
        bVar.a(this.f34233g);
        this.f34232f.a(str);
        a(str, 2);
    }

    public MBOutNativeAdvancedViewGroup d() {
        return this.f34252z;
    }

    public void d(int i11) {
        this.f34244r = true;
        c(i11);
    }

    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            c(str);
            return;
        }
        NativeAdvancedAdListener nativeAdvancedAdListener = this.f34233g;
        if (nativeAdvancedAdListener != null) {
            nativeAdvancedAdListener.onLoadFailed(this.f34229c, "bid  token is null or empty");
        }
    }

    public String e() {
        if (this.E) {
            com.mbridge.msdk.advanced.manager.c cVar = this.f34231e;
            return cVar != null ? cVar.c() : "";
        }
        com.mbridge.msdk.advanced.manager.b bVar = this.f34230d;
        return bVar != null ? bVar.d() : "";
    }

    public int f() {
        return this.f34241o;
    }

    public void f(int i11) {
        if (i11 == 1) {
            this.A = false;
        } else if (i11 == 2) {
            this.B = false;
        } else if (i11 == 3) {
            this.C = false;
        }
        h();
    }

    public boolean g() {
        return this.f34239m;
    }

    public void h(int i11) {
        this.f34246t = true;
        g(i11);
    }

    public void i(int i11) {
        if (i11 == 1) {
            this.A = true;
        } else if (i11 == 2) {
            this.B = true;
        } else if (i11 == 3) {
            this.C = true;
        }
        try {
            i();
        } catch (Exception e11) {
            o0.b(G, e11.getMessage());
        }
    }
}
