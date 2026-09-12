package com.mbridge.msdk.splash.middle;

import android.R;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.c1;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.MBSplashLoadListener;
import com.mbridge.msdk.out.MBSplashShowListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.ZoomOutTypeEnum;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.j;
import com.mbridge.msdk.setting.l;
import com.mbridge.msdk.splash.manager.e;
import com.mbridge.msdk.splash.manager.f;
import com.mbridge.msdk.splash.view.BaseSplashPopView;
import com.mbridge.msdk.splash.view.MBSplashPopView;
import com.mbridge.msdk.splash.view.MBSplashView;

/* loaded from: classes5.dex */
public class c {
    private static String D = "SplashProvider";
    private CampaignEx A;
    private MBSplashPopView B;

    /* renamed from: a, reason: collision with root package name */
    private String f37591a;

    /* renamed from: b, reason: collision with root package name */
    private String f37592b;

    /* renamed from: c, reason: collision with root package name */
    private MBridgeIds f37593c;

    /* renamed from: e, reason: collision with root package name */
    private long f37595e;

    /* renamed from: f, reason: collision with root package name */
    private e f37596f;

    /* renamed from: g, reason: collision with root package name */
    private f f37597g;

    /* renamed from: h, reason: collision with root package name */
    private b f37598h;

    /* renamed from: i, reason: collision with root package name */
    private MBSplashShowListener f37599i;

    /* renamed from: j, reason: collision with root package name */
    private d f37600j;

    /* renamed from: k, reason: collision with root package name */
    private MBSplashView f37601k;

    /* renamed from: l, reason: collision with root package name */
    private ViewGroup f37602l;

    /* renamed from: m, reason: collision with root package name */
    private View f37603m;

    /* renamed from: n, reason: collision with root package name */
    private l f37604n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f37605o;

    /* renamed from: p, reason: collision with root package name */
    private ViewGroup f37606p;

    /* renamed from: q, reason: collision with root package name */
    private j f37607q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f37608r;

    /* renamed from: y, reason: collision with root package name */
    private Activity f37615y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f37616z;

    /* renamed from: d, reason: collision with root package name */
    private int f37594d = 5;

    /* renamed from: s, reason: collision with root package name */
    private int f37609s = 1;

    /* renamed from: t, reason: collision with root package name */
    private int f37610t = k0.n(com.mbridge.msdk.foundation.controller.c.m().d());

    /* renamed from: u, reason: collision with root package name */
    private int f37611u = k0.m(com.mbridge.msdk.foundation.controller.c.m().d());

    /* renamed from: v, reason: collision with root package name */
    private Object f37612v = new Object();

    /* renamed from: w, reason: collision with root package name */
    private Object f37613w = new Object();

    /* renamed from: x, reason: collision with root package name */
    public boolean f37614x = false;
    private boolean C = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f37617a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f37618b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f37619c;

        a(CampaignEx campaignEx, int i11, boolean z10) {
            this.f37617a = campaignEx;
            this.f37618b = i11;
            this.f37619c = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.a(this.f37617a, this.f37618b - 1, this.f37619c);
        }
    }

    public c(Activity activity, String str, String str2) {
        this.f37592b = TextUtils.isEmpty(str) ? "" : str;
        this.f37591a = str2;
        this.f37593c = new MBridgeIds(str, str2);
        this.f37615y = activity;
        b(activity);
    }

    private ViewGroup a(Activity activity) {
        Throwable th2;
        ViewGroup viewGroup;
        if (activity != null && activity.isFinishing()) {
            activity = null;
        }
        if (activity == null) {
            o0.d(D, "splash can't show because, activity is null or activity is finishing");
            return null;
        }
        try {
            viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content);
        } catch (Throwable th3) {
            th2 = th3;
            viewGroup = null;
        }
        try {
            try {
                return (ViewGroup) viewGroup.getChildAt(0);
            } catch (Exception e11) {
                e11.printStackTrace();
                return viewGroup;
            }
        } catch (Throwable th4) {
            th2 = th4;
            th2.printStackTrace();
            return viewGroup;
        }
    }

    private void a(int i11, int i12) {
        int n11 = k0.n(com.mbridge.msdk.foundation.controller.c.m().d());
        int m11 = k0.m(com.mbridge.msdk.foundation.controller.c.m().d());
        int i13 = this.f37609s;
        if (i13 == 1) {
            if (m11 >= i12 * 4) {
                this.f37611u = m11 - i12;
                this.f37610t = n11;
                return;
            } else {
                this.f37611u = 0;
                this.f37610t = 0;
                return;
            }
        }
        if (i13 == 2) {
            if (n11 >= i11 * 4) {
                this.f37610t = n11 - i11;
                this.f37611u = m11;
            } else {
                this.f37611u = 0;
                this.f37610t = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, int i11, boolean z10) {
        if (!com.mbridge.msdk.splash.manager.d.a(this.f37601k, campaignEx)) {
            if (i11 > 0) {
                this.f37597g.f37493y.postDelayed(new a(campaignEx, i11, z10), 1L);
                return;
            }
            d dVar = this.f37600j;
            if (dVar != null) {
                dVar.a(this.f37593c, "campaignEx is not ready");
                return;
            }
            return;
        }
        a(true);
        ViewGroup.LayoutParams layoutParams = this.f37602l.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        } else {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
        this.f37602l.setLayoutParams(layoutParams);
        this.f37602l.removeAllViews();
        this.f37597g.c(this.f37594d);
        this.f37597g.a(this.f37606p);
        this.f37597g.a(this.f37600j);
        o0.b(D, "start show process");
        ViewGroup viewGroup = this.f37602l;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            c1.a(this.f37601k);
            this.f37602l.addView(this.f37601k);
        }
        this.f37597g.a(this.f37608r);
        this.f37597g.a(campaignEx, this.f37601k);
    }

    private void a(String str, int i11) {
        boolean z10;
        synchronized (this.f37612v) {
            try {
                if (this.f37605o) {
                    if (this.f37598h != null) {
                        this.f37598h.a(new com.mbridge.msdk.foundation.error.b(880016, "current unit is loading"), i11);
                        this.f37605o = true;
                    }
                    return;
                }
                this.f37605o = true;
                int i12 = this.f37594d;
                if (i12 < 2 || i12 > 10) {
                    if (this.f37598h != null) {
                        com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880037);
                        bVar.c("countDownTime must in 2 - 10");
                        this.f37598h.a(bVar, i11);
                        return;
                    }
                    return;
                }
                if (this.f37610t == 0 || this.f37611u == 0) {
                    if (this.f37598h != null) {
                        this.f37598h.a(new com.mbridge.msdk.foundation.error.b(880028), i11);
                        return;
                    }
                    return;
                }
                try {
                    z10 = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.b(com.mbridge.msdk.foundation.controller.c.m().d());
                } catch (Exception unused) {
                    z10 = false;
                }
                if (!z10) {
                    if (this.f37598h != null) {
                        this.f37598h.a(new com.mbridge.msdk.foundation.error.b(880029), i11);
                        return;
                    }
                    return;
                }
                this.f37601k.clearResState();
                this.f37604n = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b(), this.f37591a);
                if (this.f37596f == null) {
                    this.f37596f = new e(this.f37592b, this.f37591a, this.f37595e * 1000);
                }
                b bVar2 = this.f37598h;
                if (bVar2 != null) {
                    bVar2.a(str);
                    this.f37596f.a(this.f37598h);
                }
                this.f37601k.resetLoadState();
                this.f37596f.a(this.f37594d);
                this.f37596f.a(this.f37601k);
                this.f37596f.a(this.f37604n);
                this.f37596f.a(this.f37610t, this.f37611u);
                this.f37596f.a(this.f37608r);
                this.f37596f.b(this.f37609s);
                this.f37596f.a(str, i11);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void b(Activity activity) {
        if (this.f37597g == null) {
            if (activity != null) {
                this.f37597g = new f(activity, this.f37592b, this.f37591a);
            } else {
                this.f37597g = new f(com.mbridge.msdk.foundation.controller.c.m().d(), this.f37592b, this.f37591a);
            }
        }
        if (this.f37601k == null) {
            if (activity != null) {
                this.f37601k = new MBSplashView(activity);
            } else {
                this.f37601k = new MBSplashView(com.mbridge.msdk.foundation.controller.c.m().d());
            }
        }
        if (this.f37607q == null) {
            this.f37607q = new j();
        }
        this.f37607q.a(com.mbridge.msdk.foundation.controller.c.m().d(), com.mbridge.msdk.foundation.controller.c.m().b(), com.mbridge.msdk.foundation.controller.c.m().c(), this.f37591a);
    }

    public ViewGroup a(ZoomOutTypeEnum zoomOutTypeEnum) {
        MBSplashPopView mBSplashPopView = new MBSplashPopView(com.mbridge.msdk.foundation.controller.c.m().d(), new BaseSplashPopView.i(this.f37592b, this.f37591a, zoomOutTypeEnum.getIndex(), this.A), this.f37600j);
        this.B = mBSplashPopView;
        return mBSplashPopView;
    }

    public void a() {
        this.A = null;
        if (this.f37599i != null) {
            this.f37599i = null;
        }
        if (this.f37598h != null) {
            this.f37598h = null;
        }
        if (this.f37600j != null) {
            this.f37600j = null;
        }
        e eVar = this.f37596f;
        if (eVar != null) {
            eVar.e();
        }
        f fVar = this.f37597g;
        if (fVar != null) {
            fVar.h();
        }
        if (this.f37615y != null) {
            this.f37615y = null;
        }
    }

    public void a(int i11) {
        this.f37609s = i11;
    }

    public void a(int i11, int i12, int i13, int i14) {
        try {
            MBSplashView mBSplashView = this.f37601k;
            if (mBSplashView != null) {
                mBSplashView.setNotchPadding(i11, i12, i13, i14);
            }
        } catch (Throwable th2) {
            o0.b(D, th2.getMessage());
        }
    }

    public void a(long j11) {
        this.f37595e = j11;
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        this.f37603m = view;
        if (view != null) {
            a(layoutParams.width, layoutParams.height);
            MBSplashView mBSplashView = this.f37601k;
            if (mBSplashView != null) {
                mBSplashView.setIconVg(view, layoutParams);
            }
        }
    }

    public void a(ViewGroup viewGroup) {
        this.f37606p = viewGroup;
    }

    public void a(MBSplashLoadListener mBSplashLoadListener) {
        if (this.f37598h == null) {
            this.f37598h = new b(this, this.f37593c);
        }
        this.f37598h.a(mBSplashLoadListener);
    }

    public void a(MBSplashShowListener mBSplashShowListener) {
        this.f37599i = mBSplashShowListener;
    }

    public void a(String str, Activity activity) {
        ViewGroup a11 = a(activity);
        if (a11 != null) {
            a(str, a11);
        } else if (this.f37598h != null) {
            this.f37598h.a(new com.mbridge.msdk.foundation.error.b(880036), 1);
        }
    }

    public void a(String str, ViewGroup viewGroup) {
        this.f37602l = viewGroup;
        MBSplashView mBSplashView = this.f37601k;
        if (mBSplashView != null) {
            mBSplashView.setDevContainer(viewGroup);
        }
        a(str, 2);
    }

    public void a(boolean z10) {
        MBSplashView mBSplashView = this.f37601k;
        if (mBSplashView != null) {
            mBSplashView.setAllowClickSplash(z10);
        }
    }

    public boolean a(String str) {
        return com.mbridge.msdk.splash.manager.d.a(this.f37601k, this.f37592b, this.f37591a, str, this.f37608r, this.f37594d, false, true) != null;
    }

    public String b() {
        if (this.f37614x) {
            f fVar = this.f37597g;
            return fVar != null ? fVar.c() : "";
        }
        e eVar = this.f37596f;
        return eVar != null ? eVar.c() : "";
    }

    public void b(int i11) {
        this.f37594d = i11;
    }

    public void b(int i11, int i12) {
        a(i12, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(CampaignEx campaignEx, int i11, boolean z10) {
        if (campaignEx != null && z10) {
            if (this.f37604n == null) {
                this.f37604n = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b(), this.f37591a);
            }
            this.f37600j = new d(this, this.f37599i, campaignEx);
        }
        ViewGroup viewGroup = this.f37602l;
        if (viewGroup == null) {
            d dVar = this.f37600j;
            if (dVar != null) {
                dVar.a(this.f37593c, "container is null");
                return;
            }
            return;
        }
        if (this.f37597g == null) {
            this.f37597g = new f(viewGroup.getContext(), this.f37592b, this.f37591a);
        }
        this.A = campaignEx;
        a(campaignEx, i11, z10);
    }

    public void b(String str) {
        a(str, 1);
    }

    public void b(String str, Activity activity) {
        ViewGroup a11 = a(activity);
        if (a11 != null) {
            b(str, a11);
        } else if (this.f37598h != null) {
            this.f37598h.a(new com.mbridge.msdk.foundation.error.b(880036), 1);
        }
    }

    public void b(String str, ViewGroup viewGroup) {
        if (!TextUtils.isEmpty(str)) {
            a(str, viewGroup);
        } else if (this.f37598h != null) {
            this.f37598h.a(new com.mbridge.msdk.foundation.error.b(880035), 1);
        }
    }

    public void b(boolean z10) {
        this.f37605o = z10;
    }

    public String c() {
        if (this.f37614x) {
            f fVar = this.f37597g;
            return fVar != null ? fVar.d() : "";
        }
        e eVar = this.f37596f;
        return eVar != null ? eVar.d() : "";
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            b(str);
        } else if (this.f37598h != null) {
            this.f37598h.a(new com.mbridge.msdk.foundation.error.b(880035), 1);
        }
    }

    public void c(String str, Activity activity) {
        ViewGroup a11 = a(activity);
        if (a11 != null) {
            c(str, a11);
            return;
        }
        MBSplashShowListener mBSplashShowListener = this.f37599i;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(this.f37593c, "activity is except,please check it");
        }
    }

    public void c(String str, ViewGroup viewGroup) {
        this.f37602l = viewGroup;
        MBSplashView mBSplashView = this.f37601k;
        if (mBSplashView != null) {
            mBSplashView.setDevContainer(viewGroup);
        }
        CampaignEx a11 = com.mbridge.msdk.splash.manager.d.a(this.f37601k, this.f37592b, this.f37591a, str, this.f37608r, this.f37594d, true, false);
        if (a11 == null) {
            MBSplashShowListener mBSplashShowListener = this.f37599i;
            if (mBSplashShowListener != null) {
                mBSplashShowListener.onShowFailed(this.f37593c, "campaignEx is vali");
                return;
            }
            return;
        }
        if (this.f37604n == null) {
            this.f37604n = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b(), this.f37591a);
        }
        d dVar = new d(this, this.f37599i, a11);
        this.f37600j = dVar;
        if (this.f37610t == 0 || this.f37611u == 0) {
            dVar.a(this.f37593c, "width or height is 0  or width or height is too small");
            return;
        }
        int i11 = this.f37594d;
        if (i11 >= 2 && i11 <= 10) {
            b(a11, this.f37604n.E(), false);
            return;
        }
        dVar.a(this.f37593c, "countDownTime must in 2 - 10 ,but now is " + this.f37594d);
    }

    public void c(boolean z10) {
        this.f37608r = z10;
    }

    public int d() {
        return this.f37594d;
    }

    public void d(String str, Activity activity) {
        ViewGroup a11 = a(activity);
        if (a11 != null) {
            d(str, a11);
            return;
        }
        MBSplashShowListener mBSplashShowListener = this.f37599i;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(this.f37593c, "activity is except,please check it");
        }
    }

    public void d(String str, ViewGroup viewGroup) {
        if (!TextUtils.isEmpty(str)) {
            c(str, viewGroup);
            return;
        }
        MBSplashShowListener mBSplashShowListener = this.f37599i;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onShowFailed(this.f37593c, "token is null or empty");
        }
    }

    public void d(boolean z10) {
        this.f37616z = z10;
    }

    public long e() {
        return this.f37595e;
    }

    public boolean f() {
        return this.f37608r;
    }

    public boolean g() {
        return this.f37605o;
    }

    public void h() {
        f fVar = this.f37597g;
        if (fVar != null) {
            fVar.f();
        }
        MBSplashPopView mBSplashPopView = this.B;
        if (mBSplashPopView == null || !this.C) {
            return;
        }
        mBSplashPopView.pauseCountDown();
    }

    public void i() {
        f fVar = this.f37597g;
        if (fVar != null) {
            fVar.g();
        }
        MBSplashPopView mBSplashPopView = this.B;
        if (mBSplashPopView == null || !this.C) {
            return;
        }
        mBSplashPopView.reStartCountDown();
    }

    public void j() {
        this.C = true;
        MBSplashPopView mBSplashPopView = this.B;
        if (mBSplashPopView != null) {
            mBSplashPopView.startCountDown();
        }
    }

    public void k() {
        this.C = false;
        MBSplashShowListener mBSplashShowListener = this.f37599i;
        if (mBSplashShowListener != null) {
            mBSplashShowListener.onZoomOutPlayFinish(new MBridgeIds(this.f37592b, this.f37591a));
        }
        MBSplashPopView mBSplashPopView = this.B;
        if (mBSplashPopView != null) {
            mBSplashPopView.release();
        }
    }
}
