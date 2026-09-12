package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.tools.k0;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class m {
    public static int N = 1;
    public static int O;
    private String A;
    private String B;
    private int C;
    private String D;
    private String E;
    private String G;
    private String H;
    private String I;
    private int J;
    private long K;
    private String L;
    private int M;

    /* renamed from: b, reason: collision with root package name */
    private String f35299b;

    /* renamed from: c, reason: collision with root package name */
    private int f35300c;

    /* renamed from: e, reason: collision with root package name */
    private int f35302e;

    /* renamed from: f, reason: collision with root package name */
    private String f35303f;

    /* renamed from: g, reason: collision with root package name */
    private String f35304g;

    /* renamed from: h, reason: collision with root package name */
    private String f35305h;

    /* renamed from: i, reason: collision with root package name */
    private String f35306i;

    /* renamed from: j, reason: collision with root package name */
    private String f35307j;

    /* renamed from: k, reason: collision with root package name */
    private String f35308k;

    /* renamed from: l, reason: collision with root package name */
    private String f35309l;

    /* renamed from: m, reason: collision with root package name */
    private String f35310m;

    /* renamed from: n, reason: collision with root package name */
    private String f35311n;

    /* renamed from: o, reason: collision with root package name */
    private String f35312o;

    /* renamed from: p, reason: collision with root package name */
    private int f35313p;

    /* renamed from: q, reason: collision with root package name */
    private String f35314q;

    /* renamed from: r, reason: collision with root package name */
    private String f35315r;

    /* renamed from: s, reason: collision with root package name */
    private String f35316s;

    /* renamed from: u, reason: collision with root package name */
    private int f35318u;

    /* renamed from: v, reason: collision with root package name */
    private String f35319v;

    /* renamed from: w, reason: collision with root package name */
    private String f35320w;

    /* renamed from: x, reason: collision with root package name */
    private String f35321x;

    /* renamed from: y, reason: collision with root package name */
    private String f35322y;

    /* renamed from: z, reason: collision with root package name */
    private String f35323z;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, String> f35298a = null;

    /* renamed from: d, reason: collision with root package name */
    private int f35301d = 0;

    /* renamed from: t, reason: collision with root package name */
    private int f35317t = 0;
    private int F = 0;

    public m() {
    }

    public m(Context context, CampaignEx campaignEx, int i11, String str, long j11, int i12) {
        if (i12 == 1 || i12 == 287 || i12 == 94) {
            this.f35314q = "m_download_end";
        } else if (i12 == 95) {
            this.f35314q = "2000025";
        }
        int s11 = k0.s(context);
        this.f35318u = s11;
        this.f35319v = k0.a(context, s11);
        this.J = campaignEx.getVideoLength();
        this.f35322y = campaignEx.getRequestId();
        this.f35323z = campaignEx.getRequestIdNotice();
        if (!TextUtils.isEmpty(this.f35320w)) {
            try {
                this.f35320w = URLEncoder.encode(campaignEx.getNoticeUrl() == null ? campaignEx.getClickURL() : campaignEx.getNoticeUrl(), "utf-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
        this.C = i11;
        this.f35306i = str;
        this.K = j11 == 0 ? campaignEx.getVideoSize() : j11;
    }

    public m(String str) {
        this.f35311n = str;
    }

    public m(String str, int i11, int i12, int i13, int i14, String str2, String str3, int i15, String str4, int i16, String str5) {
        this.f35314q = str;
        this.f35318u = i11;
        this.f35319v = str5;
        this.f35313p = i12;
        this.M = i13;
        this.J = i14;
        try {
            if (!TextUtils.isEmpty(str2)) {
                this.f35320w = URLEncoder.encode(str2, "utf-8");
            }
        } catch (UnsupportedEncodingException e11) {
            e11.printStackTrace();
        }
        this.f35321x = str3;
        this.C = i15;
        this.f35306i = str4;
        this.K = i16;
    }

    public m(String str, int i11, int i12, String str2, int i13, String str3, int i14, String str4) {
        this.f35314q = str;
        this.f35318u = i11;
        this.f35319v = str4;
        this.J = i12;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.f35320w = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
        this.C = i13;
        this.f35306i = str3;
        this.K = i14;
    }

    public m(String str, int i11, String str2, String str3, String str4) {
        this.f35314q = str;
        this.f35319v = str4;
        this.f35318u = i11;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.f35320w = URLEncoder.encode(str2, "utf-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
        this.f35321x = str3;
    }

    public m(String str, int i11, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f35314q = str;
        this.C = i11;
        this.f35306i = str2;
        try {
            if (!TextUtils.isEmpty(str3)) {
                this.f35308k = URLEncoder.encode(str3, "utf-8");
            }
        } catch (UnsupportedEncodingException e11) {
            e11.printStackTrace();
        }
        this.f35303f = str4;
        this.I = str5;
        this.f35321x = str6;
        this.f35307j = str7;
        if (Integer.valueOf(str2).intValue() > com.mbridge.msdk.foundation.same.a.L) {
            this.C = 2;
        }
    }

    public m(String str, String str2, String str3, String str4, String str5, int i11) {
        this.f35314q = str;
        this.f35303f = str2;
        this.f35322y = str3;
        this.f35323z = str4;
        this.I = str5;
        this.f35318u = i11;
    }

    public m(String str, String str2, String str3, String str4, String str5, int i11, int i12, String str6) {
        this.f35314q = str;
        this.f35303f = str2;
        this.f35322y = str3;
        this.f35323z = str4;
        this.I = str5;
        this.f35318u = i11;
        this.f35321x = str6;
        this.f35302e = i12;
    }

    public m(String str, String str2, String str3, String str4, String str5, String str6, int i11, String str7) {
        this.f35314q = str;
        this.f35310m = str2;
        this.H = str3;
        this.f35315r = str4;
        this.I = str5;
        this.f35303f = str6;
        this.f35318u = i11;
        this.f35319v = str7;
    }

    public String A() {
        return this.H;
    }

    public String B() {
        return this.I;
    }

    public int C() {
        return this.J;
    }

    public long D() {
        return this.K;
    }

    public String E() {
        return this.L;
    }

    public int F() {
        return this.M;
    }

    public String a() {
        return this.f35299b;
    }

    public String a(String str, String str2) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || (map = this.f35298a) == null) {
            return str2;
        }
        try {
            String str3 = map.get(str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Exception unused) {
            return str2;
        }
    }

    public void a(int i11) {
        this.f35300c = i11;
    }

    public void a(String str) {
        this.f35299b = str;
    }

    public int b() {
        return this.f35300c;
    }

    public void b(int i11) {
        this.f35317t = i11;
    }

    public void b(String str) {
        this.f35303f = str;
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.f35298a == null) {
            this.f35298a = new HashMap();
        }
        try {
            this.f35298a.put(str, str2);
        } catch (Exception unused) {
        }
    }

    public int c() {
        return this.f35302e;
    }

    public void c(int i11) {
        this.f35318u = i11;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f35304g = URLEncoder.encode(str);
    }

    public String d() {
        return this.f35303f;
    }

    public void d(int i11) {
        this.C = i11;
    }

    public void d(String str) {
        this.f35305h = str;
    }

    public String e() {
        return this.f35304g;
    }

    public void e(int i11) {
        this.F = i11;
    }

    public void e(String str) {
        this.f35306i = str;
    }

    public String f() {
        return this.f35305h;
    }

    public void f(String str) {
        this.f35307j = str;
    }

    public String g() {
        return this.f35306i;
    }

    public void g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f35308k = URLEncoder.encode(str, "utf-8");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public String h() {
        return this.f35307j;
    }

    public void h(String str) {
        this.f35309l = str;
    }

    public String i() {
        return this.f35308k;
    }

    public void i(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f35312o = URLEncoder.encode(str, "utf-8");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public String j() {
        return this.f35309l;
    }

    public void j(String str) {
        this.f35314q = str;
    }

    public String k() {
        return this.f35310m;
    }

    public void k(String str) {
        this.f35316s = str;
    }

    public String l() {
        return this.f35312o;
    }

    public void l(String str) {
        this.f35319v = str;
    }

    public int m() {
        return this.f35313p;
    }

    public void m(String str) {
        this.f35321x = str;
    }

    public String n() {
        return this.f35314q;
    }

    public void n(String str) {
        this.f35322y = str;
    }

    public String o() {
        return this.f35315r;
    }

    public void o(String str) {
        this.f35323z = str;
    }

    public int p() {
        return this.f35317t;
    }

    public void p(String str) {
        this.A = str;
    }

    public int q() {
        return this.f35318u;
    }

    public void q(String str) {
        this.B = str;
    }

    public String r() {
        return this.f35319v;
    }

    public void r(String str) {
        this.D = str;
    }

    public String s() {
        return this.f35320w;
    }

    public void s(String str) {
        this.E = str;
    }

    public String t() {
        return TextUtils.isEmpty(this.f35321x) ? "" : this.f35321x;
    }

    public void t(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.G = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e11) {
            e11.printStackTrace();
        }
    }

    @NonNull
    public String toString() {
        return "RewardReportData [key=" + this.f35314q + ", networkType=" + this.f35318u + ", isCompleteView=" + this.f35313p + ", watchedMillis=" + this.M + ", videoLength=" + this.J + ", offerUrl=" + this.f35320w + ", reason=" + this.f35321x + ", result=" + this.C + ", duration=" + this.f35306i + ", videoSize=" + this.K + "]";
    }

    public String u() {
        return this.f35322y;
    }

    public void u(String str) {
        this.I = str;
    }

    public String v() {
        return this.f35323z;
    }

    public void v(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.L = URLEncoder.encode(str, "utf-8");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public String w() {
        return this.A;
    }

    public int x() {
        return this.C;
    }

    public int y() {
        return this.F;
    }

    public String z() {
        return this.G;
    }
}
