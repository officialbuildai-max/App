package com.mbridge.msdk.foundation.same.net.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.n;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.tracker.network.toolbox.h;
import com.mbridge.msdk.tracker.network.toolbox.i;
import com.mbridge.msdk.tracker.p;
import com.mbridge.msdk.tracker.u;
import com.mbridge.msdk.tracker.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public class d {
    public String A;
    private String B;
    public String C;
    public String D;
    private String E;
    public String F;
    private String G;
    public String H;
    private String I;
    public String J;
    public String K;
    private String L;
    public String M;
    private String N;
    public String O;
    private String P;
    public String Q;
    public String R;
    private String S;
    public String T;
    public String U;
    private String V;
    public String W;
    public String X;
    private String Y;
    public String Z;

    /* renamed from: a, reason: collision with root package name */
    private final String f35516a;

    /* renamed from: a0, reason: collision with root package name */
    private String f35517a0;

    /* renamed from: b, reason: collision with root package name */
    public String f35518b;

    /* renamed from: b0, reason: collision with root package name */
    public String f35519b0;

    /* renamed from: c, reason: collision with root package name */
    public String f35520c;

    /* renamed from: c0, reason: collision with root package name */
    private String f35521c0;

    /* renamed from: d, reason: collision with root package name */
    public String f35522d;

    /* renamed from: d0, reason: collision with root package name */
    public String f35523d0;

    /* renamed from: e, reason: collision with root package name */
    public String f35524e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f35525e0;

    /* renamed from: f, reason: collision with root package name */
    public String f35526f;

    /* renamed from: f0, reason: collision with root package name */
    private int f35527f0;

    /* renamed from: g, reason: collision with root package name */
    public String f35528g;

    /* renamed from: h, reason: collision with root package name */
    public String f35529h;

    /* renamed from: i, reason: collision with root package name */
    public String f35530i;

    /* renamed from: j, reason: collision with root package name */
    public String f35531j;

    /* renamed from: k, reason: collision with root package name */
    public String f35532k;

    /* renamed from: l, reason: collision with root package name */
    public String f35533l;

    /* renamed from: m, reason: collision with root package name */
    public String f35534m;

    /* renamed from: n, reason: collision with root package name */
    public int f35535n;

    /* renamed from: o, reason: collision with root package name */
    public int f35536o;

    /* renamed from: p, reason: collision with root package name */
    public int f35537p;

    /* renamed from: q, reason: collision with root package name */
    public int f35538q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f35539r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f35540s;

    /* renamed from: t, reason: collision with root package name */
    public int f35541t;

    /* renamed from: u, reason: collision with root package name */
    public ArrayList<String> f35542u;

    /* renamed from: v, reason: collision with root package name */
    public int f35543v;

    /* renamed from: w, reason: collision with root package name */
    public int f35544w;

    /* renamed from: x, reason: collision with root package name */
    public ArrayList<String> f35545x;

    /* renamed from: y, reason: collision with root package name */
    public String f35546y;

    /* renamed from: z, reason: collision with root package name */
    private String f35547z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final d f35548a = new d();
    }

    private d() {
        this.f35516a = "RequestUrlUtil";
        this.f35518b = DomainNameUtils.getInstance().DEFAULT_HOST_APPLETS;
        this.f35520c = DomainNameUtils.getInstance().DEFAULT_CDN_SPARE_SETTING_URL;
        this.f35522d = DomainNameUtils.getInstance().DEFAULT_HOST_ANALYTICS;
        this.f35524e = DomainNameUtils.getInstance().DEFAULT_HOST_API;
        this.f35526f = DomainNameUtils.getInstance().DEFAULT_HOST_MONITOR_DEFAULT;
        this.f35528g = DomainNameUtils.getInstance().DEFAULT_HOST_PRIVACY;
        this.f35529h = DomainNameUtils.getInstance().DEFAULT_HOST_REVENUE_DEFAULT;
        this.f35530i = DomainNameUtils.getInstance().DEFAULT_HOST_SETTING;
        this.f35531j = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_ANALYTICS;
        this.f35532k = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_MONITOR;
        this.f35533l = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_REVENUE;
        this.f35534m = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_SETTING;
        this.f35535n = 9377;
        this.f35536o = 9377;
        this.f35537p = 9988;
        this.f35538q = 9377;
        this.f35539r = false;
        this.f35540s = false;
        this.f35541t = 1;
        this.f35542u = DomainNameUtils.getInstance().SPARE_SETTING_HOST;
        this.f35543v = 0;
        this.f35544w = 0;
        this.f35545x = DomainNameUtils.getInstance().SPARE_TCP_SETTING_HOST;
        this.f35546y = DomainNameUtils.getInstance().DEFAULT_HB_HOST;
        this.f35547z = "/bid";
        this.A = this.f35546y + this.f35547z;
        this.B = "/sdk/customid";
        this.C = this.f35530i + this.B;
        this.D = this.f35534m + this.B;
        this.E = "/image";
        this.F = this.f35524e + this.E;
        this.G = "/load";
        this.H = this.f35546y + this.G;
        this.I = "/mapping";
        this.J = this.f35530i + this.I;
        this.K = this.f35534m + this.I;
        this.L = "";
        this.M = this.f35529h + this.L;
        this.N = "/batchPaidEvent";
        this.O = this.f35529h + this.N;
        this.P = "/setting";
        this.Q = this.f35530i + this.P;
        this.R = this.f35534m + this.P;
        this.S = "/rewardsetting";
        this.T = this.f35530i + this.S;
        this.U = this.f35534m + this.S;
        this.V = "/appwall/setting";
        this.W = this.f35530i + this.V;
        this.X = this.f35534m + this.V;
        this.Y = "/openapi/ad/v3";
        this.Z = this.f35524e + this.Y;
        this.f35517a0 = "/openapi/ad/v4";
        this.f35519b0 = this.f35524e + this.f35517a0;
        this.f35521c0 = "/openapi/ad/v5";
        this.f35523d0 = this.f35524e + this.f35521c0;
        this.f35525e0 = true;
        this.f35527f0 = 0;
    }

    private p a(int i11) {
        return i11 == 1 ? new p(new m((byte) 2), h().f35532k, h().f35536o) : new p(new h(), h().M, 0);
    }

    private void a() {
        this.O = this.f35529h + this.N;
    }

    private void a(g gVar) {
        com.mbridge.msdk.setting.d y10;
        if (gVar == null || (y10 = gVar.y()) == null || y10.a() == 1) {
            return;
        }
        int b11 = q0.a().b("monitor", NativeComponentConstants.KEY_COMPONENT_TYPE, q0.a().b("t_r_t", 1));
        if (b11 != 0 && b11 != 1) {
            b11 = 0;
        }
        u.a().a(com.mbridge.msdk.foundation.controller.c.m().d(), new x.b().a(new com.mbridge.msdk.foundation.same.report.d()).a(new n()).a(b11, a(b11)).a(q0.a().b("t_m_e_t", MiniAppConfigHelper.DEFAULT_MINI_SCOPE_REQUEST_DIFF)).b(q0.a().b("t_m_e_s", 50)).d(q0.a().b("t_m_r_c", 50)).c(q0.a().b("t_m_t", DefaultLoadControl.DEFAULT_MIN_BUFFER_MS)).e(q0.a().b("t_m_r_t_s", 1)).a(), y10.b() * 1000, com.mbridge.msdk.foundation.same.report.c.b());
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("(https|http)://[-A-Za-z0-9{}+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]").matcher(str.trim()).matches();
    }

    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return Uri.parse(str).getHost();
        } catch (Throwable th2) {
            o0.b("RequestUrlUtil", th2.getMessage());
            return "";
        }
    }

    private void b() {
        this.M = this.f35526f + this.L;
    }

    private void c() {
        this.A = this.f35546y + this.f35547z;
        this.H = this.f35546y + this.G;
        i.b().f(this.f35546y);
    }

    private void d() {
        this.Z = this.f35524e + this.Y;
        this.f35519b0 = this.f35524e + this.f35517a0;
        this.f35523d0 = this.f35524e + this.f35521c0;
        this.F = this.f35524e + this.E;
    }

    public static d h() {
        return b.f35548a;
    }

    public String a(String str, int i11) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("_");
                return split.length > 1 ? a(true, split[1]) : a(true, "");
            }
        } catch (Exception e11) {
            o0.b("RequestUrlUtil", e11.getMessage());
        }
        return i11 % 2 == 0 ? this.f35523d0 : this.Z;
    }

    public String a(boolean z10, String str) {
        if (!z10) {
            return this.A.replace("{}", "");
        }
        if (!this.H.contains("{}") || TextUtils.isEmpty(str)) {
            return this.H.replace("{}", "");
        }
        return this.H.replace("{}", str + "-");
    }

    public void a(boolean z10) {
        this.f35525e0 = z10;
    }

    public void b(int i11) {
        this.f35535n = i11;
    }

    public void c(int i11) {
        this.f35538q = i11;
    }

    public void d(int i11) {
        this.f35527f0 = i11;
    }

    public void e() {
        this.Q = this.f35530i + this.P;
        this.C = this.f35530i + this.B;
        this.T = this.f35530i + this.S;
        this.J = this.f35530i + this.I;
        this.W = this.f35530i + this.V;
    }

    public void f() {
        this.R = this.f35534m + this.P;
        this.D = this.f35534m + this.B;
        this.U = this.f35534m + this.S;
        this.K = this.f35534m + this.I;
        this.X = this.f35534m + this.V;
    }

    public boolean g() {
        try {
            if (this.f35540s) {
                ArrayList<String> arrayList = this.f35545x;
                if (arrayList != null && this.f35544w <= arrayList.size() - 1) {
                    if (!a(this.f35545x.get(this.f35544w))) {
                        this.f35534m = this.f35545x.get(this.f35544w);
                        f();
                    }
                    return true;
                }
            } else {
                ArrayList<String> arrayList2 = this.f35542u;
                if (arrayList2 != null && this.f35543v <= arrayList2.size() - 1) {
                    this.f35530i = this.f35542u.get(this.f35543v);
                    e();
                    return true;
                }
            }
            if (this.f35539r) {
                this.f35543v = 0;
                this.f35544w = 0;
            }
            return false;
        } catch (Throwable th2) {
            o0.a("RequestUrlUtil", th2.getMessage());
            return false;
        }
    }

    public int i() {
        return this.f35527f0;
    }

    public void j() {
        HashMap<String, String> C;
        g d11 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d11 != null) {
            com.mbridge.msdk.setting.a j11 = d11.j();
            if (j11 != null) {
                this.f35533l = j11.f();
                this.f35537p = j11.g();
                this.f35529h = j11.e();
                a();
            }
            com.mbridge.msdk.setting.d y10 = d11.y();
            if (y10 != null) {
                this.f35532k = y10.d();
                this.f35536o = y10.e();
                this.f35526f = y10.c();
                b();
                a(d11);
            }
            this.f35540s = d11.n0() == 2;
            this.f35541t = d11.n0();
            a(!d11.b(2));
            if (d11.C() != null && d11.C().size() > 0 && (C = d11.C()) != null && C.size() > 0) {
                if (C.containsKey("v") && !TextUtils.isEmpty(C.get("v")) && a(C.get("v"))) {
                    this.f35524e = C.get("v");
                    d();
                }
                if (C.containsKey(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(C.get(CampaignEx.JSON_KEY_HB)) && a(C.get(CampaignEx.JSON_KEY_HB))) {
                    this.f35546y = C.get(CampaignEx.JSON_KEY_HB);
                    c();
                }
                if (C.containsKey("lg") && !TextUtils.isEmpty(C.get("lg"))) {
                    String str = C.get("lg");
                    if (a(str)) {
                        this.f35522d = str;
                    } else {
                        this.f35531j = str;
                    }
                }
                if (C.containsKey("lgt") && !TextUtils.isEmpty(C.get("lgt"))) {
                    String str2 = C.get("lgt");
                    if (a(str2)) {
                        String b11 = b(str2);
                        if (!TextUtils.isEmpty(b11)) {
                            this.f35531j = b11;
                        }
                    } else {
                        this.f35531j = str2;
                    }
                }
            }
            String u11 = d11.u();
            if (!TextUtils.isEmpty(u11)) {
                this.f35530i = u11;
                e();
                this.f35542u.add(0, u11);
            }
            String v11 = d11.v();
            if (TextUtils.isEmpty(v11)) {
                return;
            }
            this.f35534m = v11;
            f();
            this.f35545x.add(0, v11);
        }
    }
}
