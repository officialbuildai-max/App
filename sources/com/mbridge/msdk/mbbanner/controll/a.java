package com.mbridge.msdk.mbbanner.controll;

import android.text.TextUtils;
import android.view.View;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.mbbanner.common.manager.c;
import com.mbridge.msdk.out.BannerAdListener;
import com.mbridge.msdk.out.BannerSize;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.j;
import com.mbridge.msdk.setting.l;
import java.util.List;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: x, reason: collision with root package name */
    private static String f36220x = "BannerController";

    /* renamed from: a, reason: collision with root package name */
    private String f36221a;

    /* renamed from: b, reason: collision with root package name */
    private String f36222b;

    /* renamed from: c, reason: collision with root package name */
    private String f36223c;

    /* renamed from: d, reason: collision with root package name */
    private MBridgeIds f36224d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f36225e;

    /* renamed from: f, reason: collision with root package name */
    private int f36226f;

    /* renamed from: g, reason: collision with root package name */
    private MBBannerView f36227g;

    /* renamed from: h, reason: collision with root package name */
    private int f36228h;

    /* renamed from: i, reason: collision with root package name */
    private int f36229i;

    /* renamed from: j, reason: collision with root package name */
    private int f36230j;

    /* renamed from: l, reason: collision with root package name */
    private BannerAdListener f36232l;

    /* renamed from: m, reason: collision with root package name */
    private CampaignUnit f36233m;

    /* renamed from: n, reason: collision with root package name */
    private c f36234n;

    /* renamed from: o, reason: collision with root package name */
    private l f36235o;

    /* renamed from: p, reason: collision with root package name */
    private j f36236p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f36237q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f36238r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f36239s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f36240t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f36241u;

    /* renamed from: k, reason: collision with root package name */
    private int f36231k = -1;

    /* renamed from: v, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.listener.c f36242v = new C0506a();

    /* renamed from: w, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.listener.b f36243w = new b();

    /* renamed from: com.mbridge.msdk.mbbanner.controll.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0506a implements com.mbridge.msdk.mbbanner.common.listener.c {
        C0506a() {
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.c
        public void a() {
            if (a.this.f36232l != null) {
                a.this.f36232l.showFullScreen(a.this.f36224d);
                a.this.f36241u = true;
                com.mbridge.msdk.mbbanner.common.manager.a.b().a(2, a.this.f36222b, a.this.f36221a, null, null);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.c
        public void a(CampaignEx campaignEx) {
            a.this.c();
            if (a.this.f36232l != null) {
                a.this.f36232l.onLogImpression(a.this.f36224d);
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.c a11 = com.mbridge.msdk.mbbanner.common.report.a.a(a.this.f36221a, campaignEx.getLocalRequestId());
                a11.a(campaignEx);
                a11.g(campaignEx.isBidCampaign() ? "1" : "2");
                int i11 = 1;
                a11.g(a.this.f36234n != null ? a.this.f36234n.c() : 1);
                if (a.this.f36230j != 0) {
                    i11 = 2;
                }
                a11.b(i11);
                a11.c(a.this.f36230j);
                com.mbridge.msdk.mbbanner.common.report.a.a("2000128", a11, (e) null);
                com.mbridge.msdk.mbbanner.common.report.a.a("2000130", a11, (e) null);
            } catch (Exception e11) {
                o0.b(a.f36220x, e11.getMessage());
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.c
        public void a(com.mbridge.msdk.foundation.error.b bVar) {
            a.this.a(bVar);
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.c
        public void a(List<CampaignEx> list) {
            o0.b(a.f36220x, "onShowSuccessed:");
            if (a.this.f36232l != null) {
                a.this.f36232l.onLoadSuccessed(a.this.f36224d);
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.c a11 = com.mbridge.msdk.mbbanner.common.report.a.a(a.this.f36221a, list.get(0).getLocalRequestId());
                a11.b(list);
                a11.g(1);
                a11.d(TextUtils.isEmpty(list.get(0).getBannerUrl()) ? 2 : 1);
                com.mbridge.msdk.mbbanner.common.report.a.a("2000048", a11, (e) null);
            } catch (Exception e11) {
                o0.b(a.f36220x, e11.getMessage());
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.c
        public void b() {
            if (a.this.f36232l != null) {
                a.this.f36232l.onCloseBanner(a.this.f36224d);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.c
        public void c() {
            if (a.this.f36232l != null) {
                a.this.f36232l.onClick(a.this.f36224d);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.c
        public void d() {
            if (a.this.f36232l != null) {
                a.this.f36232l.closeFullScreen(a.this.f36224d);
                a.this.f36241u = false;
                com.mbridge.msdk.mbbanner.common.manager.a.b().a(3, a.this.f36222b, a.this.f36221a, new com.mbridge.msdk.mbbanner.common.data.a(a.this.f36229i + "x" + a.this.f36228h, a.this.f36230j * 1000), a.this.f36243w);
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.c
        public void onLeaveApp() {
            if (a.this.f36232l != null) {
                a.this.f36232l.onLeaveApp(a.this.f36224d);
            }
        }
    }

    /* loaded from: classes5.dex */
    class b implements com.mbridge.msdk.mbbanner.common.listener.b {
        b() {
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.b
        public void a(com.mbridge.msdk.foundation.error.b bVar) {
            a.this.a(2, bVar);
            a.this.a(bVar.f(), bVar);
            a.this.c();
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.b
        public void a(String str, int i11, boolean z10) {
            if (a.this.f36227g != null) {
                a.this.f36240t = true;
                a.this.j();
            }
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.b
        public void a(String str, CampaignUnit campaignUnit, boolean z10) {
            a.this.f36233m = campaignUnit;
            a.this.a(1, (com.mbridge.msdk.foundation.error.b) null);
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.b
        public void b(com.mbridge.msdk.foundation.error.b bVar) {
            a.this.a(bVar.f(), bVar);
            a.this.c();
        }
    }

    public a(MBBannerView mBBannerView, BannerSize bannerSize, String str, String str2) {
        this.f36227g = mBBannerView;
        if (bannerSize != null) {
            this.f36228h = bannerSize.getHeight();
            this.f36229i = bannerSize.getWidth();
        }
        this.f36221a = str2;
        str = TextUtils.isEmpty(str) ? "" : str;
        this.f36222b = str;
        this.f36224d = new MBridgeIds(str, this.f36221a);
        f();
    }

    private int a(int i11) {
        if (i11 <= 0) {
            return i11;
        }
        int i12 = 10;
        if (i11 >= 10) {
            i12 = 180;
            if (i11 <= 180) {
                return i11;
            }
        }
        return i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i11, com.mbridge.msdk.foundation.error.b bVar) {
        try {
            com.mbridge.msdk.foundation.same.report.metrics.c a11 = com.mbridge.msdk.mbbanner.common.report.a.a(this.f36221a, bVar == null ? this.f36233m.getLocalRequestId() : bVar.f());
            e eVar = new e();
            eVar.a("result", Integer.valueOf(i11));
            CampaignUnit campaignUnit = this.f36233m;
            if (campaignUnit != null && !campaignUnit.getAds().isEmpty()) {
                CampaignEx campaignEx = this.f36233m.getAds().get(0);
                if (campaignEx != null) {
                    a11.d(TextUtils.isEmpty(campaignEx.getBannerUrl()) ? 2 : 1);
                }
                a11.b(this.f36233m.getAds());
            }
            if (bVar != null) {
                a11.a(bVar);
            }
            com.mbridge.msdk.mbbanner.common.report.a.a("2000126", a11, eVar);
        } catch (Exception e11) {
            o0.b(f36220x, e11.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.error.b bVar) {
        a(this.f36223c, bVar);
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.mbridge.msdk.foundation.error.b bVar) {
        CampaignUnit campaignUnit;
        String str2 = "";
        if (bVar != null) {
            try {
                str2 = bVar.g();
                if (TextUtils.isEmpty(str)) {
                    str = bVar.f();
                }
            } catch (Throwable th2) {
                o0.b(f36220x, th2.getMessage());
            }
        }
        if (TextUtils.isEmpty(str) && (campaignUnit = this.f36233m) != null) {
            str = campaignUnit.getLocalRequestId();
        }
        com.mbridge.msdk.foundation.same.report.metrics.c a11 = com.mbridge.msdk.mbbanner.common.report.a.a(this.f36221a, str);
        CampaignUnit campaignUnit2 = this.f36233m;
        a11.b(campaignUnit2 != null ? campaignUnit2.getAds() : null);
        a11.a(bVar);
        CampaignUnit campaignUnit3 = this.f36233m;
        if (campaignUnit3 != null && !campaignUnit3.getAds().isEmpty()) {
            a11.d(TextUtils.isEmpty(this.f36233m.getAds().get(0).getBannerUrl()) ? 1 : 2);
        }
        a11.b(true);
        com.mbridge.msdk.mbbanner.common.report.a.a("2000047", a11, (e) null);
        BannerAdListener bannerAdListener = this.f36232l;
        if (bannerAdListener != null) {
            bannerAdListener.onLoadFailed(this.f36224d, str2);
        }
    }

    private boolean a(View view) {
        return true;
    }

    private void b(String str, String str2) {
        if (this.f36236p == null) {
            this.f36236p = new j();
        }
        this.f36236p.a(com.mbridge.msdk.foundation.controller.c.m().d(), str, str2, this.f36221a);
    }

    private void f() {
        b(com.mbridge.msdk.foundation.controller.c.m().b(), com.mbridge.msdk.foundation.controller.c.m().c());
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f36239s || !this.f36240t) {
            return;
        }
        if (!a(this.f36227g)) {
            a(new com.mbridge.msdk.foundation.error.b(880044));
        } else if (this.f36233m != null) {
            if (this.f36234n == null) {
                this.f36234n = new c(this.f36227g, this.f36242v, this.f36222b, this.f36221a, this.f36225e, this.f36235o);
            }
            this.f36234n.a(this.f36223c);
            this.f36234n.b(this.f36237q);
            this.f36234n.d(this.f36238r);
            this.f36234n.a(this.f36225e, this.f36226f);
            this.f36234n.b(this.f36233m);
        } else {
            a(new com.mbridge.msdk.foundation.error.b(880043));
        }
        this.f36240t = false;
    }

    private void k() {
        MBBannerView mBBannerView = this.f36227g;
        if (mBBannerView != null) {
            if (!this.f36237q || !this.f36238r || this.f36241u || b1.a(mBBannerView, 1)) {
                com.mbridge.msdk.mbbanner.common.manager.a.b().a(2, this.f36222b, this.f36221a, null, null);
            } else {
                com.mbridge.msdk.mbbanner.common.manager.a.b().a(3, this.f36222b, this.f36221a, new com.mbridge.msdk.mbbanner.common.data.a(this.f36229i + "x" + this.f36228h, this.f36230j * 1000), this.f36243w);
            }
            if (this.f36237q) {
                return;
            }
            com.mbridge.msdk.mbbanner.common.manager.a.b().a(4, this.f36222b, this.f36221a, null, null);
            com.mbridge.msdk.mbbanner.common.manager.a.b().b(this.f36221a);
        }
    }

    private void l() {
        l e11 = h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), this.f36221a);
        this.f36235o = e11;
        if (e11 == null) {
            this.f36235o = l.i(this.f36221a);
        }
        if (this.f36231k == -1) {
            this.f36230j = a(this.f36235o.D());
        }
        if (this.f36226f == 0) {
            boolean z10 = this.f36235o.g() == 1;
            this.f36225e = z10;
            c cVar = this.f36234n;
            if (cVar != null) {
                cVar.c(z10);
            }
        }
    }

    public void a(int i11, int i12, int i13, int i14) {
        c cVar = this.f36234n;
        if (cVar != null) {
            cVar.a(i11, i12, i13, i14);
        }
    }

    public void a(BannerAdListener bannerAdListener) {
        this.f36232l = bannerAdListener;
    }

    public void a(BannerSize bannerSize) {
        if (bannerSize != null) {
            this.f36228h = bannerSize.getHeight();
            this.f36229i = bannerSize.getWidth();
        }
    }

    public void a(String str, String str2) {
        boolean z10;
        if (this.f36228h < 1 || this.f36229i < 1) {
            a(str2, new com.mbridge.msdk.foundation.error.b(880037));
            return;
        }
        try {
            z10 = com.mbridge.msdk.mbsignalcommon.webEnvCheck.a.b(com.mbridge.msdk.foundation.controller.c.m().d());
        } catch (Exception e11) {
            o0.b(f36220x, e11.getMessage());
            z10 = false;
        }
        if (!z10) {
            a(str2, new com.mbridge.msdk.foundation.error.b(880029));
            return;
        }
        this.f36223c = str2;
        com.mbridge.msdk.mbbanner.common.data.a aVar = new com.mbridge.msdk.mbbanner.common.data.a(this.f36229i + "x" + this.f36228h, this.f36230j * 1000);
        aVar.a(str);
        aVar.c(this.f36222b);
        aVar.b(str2);
        com.mbridge.msdk.mbbanner.common.manager.a.b().b(this.f36222b, this.f36221a, aVar, this.f36243w);
        com.mbridge.msdk.mbbanner.common.manager.a.b().a(1, this.f36222b, this.f36221a, aVar, this.f36243w);
    }

    public void a(boolean z10) {
        this.f36225e = z10;
        this.f36226f = z10 ? 1 : 2;
    }

    public void b() {
        k();
        c cVar = this.f36234n;
        if (cVar != null) {
            cVar.b(this.f36237q);
            this.f36234n.d(this.f36238r);
        }
    }

    public void b(int i11) {
        int a11 = a(i11);
        this.f36231k = a11;
        this.f36230j = a11;
    }

    public void b(boolean z10) {
        this.f36237q = z10;
        b();
        j();
    }

    public void c() {
        if (this.f36239s) {
            return;
        }
        k();
        l();
        com.mbridge.msdk.mbbanner.common.data.a aVar = new com.mbridge.msdk.mbbanner.common.data.a(this.f36229i + "x" + this.f36228h, this.f36230j * 1000);
        aVar.c(this.f36222b);
        aVar.a(true);
        aVar.b(com.mbridge.msdk.mbbanner.common.report.a.b(""));
        com.mbridge.msdk.mbbanner.common.manager.a.b().a(this.f36222b, this.f36221a, aVar, this.f36243w);
    }

    public void c(boolean z10) {
        this.f36238r = z10;
        b();
    }

    public String d() {
        CampaignUnit campaignUnit = this.f36233m;
        return campaignUnit != null ? com.mbridge.msdk.foundation.same.c.b(campaignUnit.getAds()) : "";
    }

    public String e() {
        CampaignUnit campaignUnit = this.f36233m;
        return (campaignUnit == null || campaignUnit.getRequestId() == null) ? "" : this.f36233m.getRequestId();
    }

    public void g() {
        com.mbridge.msdk.mbbanner.common.manager.a.b().a(4, this.f36222b, this.f36221a, new com.mbridge.msdk.mbbanner.common.data.a(this.f36229i + "x" + this.f36228h, this.f36230j * 1000), this.f36243w);
    }

    public void h() {
        com.mbridge.msdk.mbbanner.common.manager.a.b().a(3, this.f36222b, this.f36221a, new com.mbridge.msdk.mbbanner.common.data.a(this.f36229i + "x" + this.f36228h, this.f36230j * 1000), this.f36243w);
    }

    public void i() {
        this.f36239s = true;
        if (this.f36232l != null) {
            this.f36232l = null;
        }
        if (this.f36243w != null) {
            this.f36243w = null;
        }
        if (this.f36242v != null) {
            this.f36242v = null;
        }
        if (this.f36227g != null) {
            this.f36227g = null;
        }
        com.mbridge.msdk.mbbanner.common.manager.a.b().a(4, this.f36222b, this.f36221a, null, null);
        com.mbridge.msdk.mbbanner.common.manager.a.b().b(this.f36221a);
        com.mbridge.msdk.mbbanner.common.manager.a.b().c();
        c cVar = this.f36234n;
        if (cVar != null) {
            cVar.h();
        }
    }
}
