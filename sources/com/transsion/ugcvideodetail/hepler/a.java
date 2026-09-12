package com.transsion.ugcvideodetail.hepler;

import com.transsion.player.orplayer.PlayError;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f56417a;

    /* renamed from: b, reason: collision with root package name */
    private final String f56418b;

    /* renamed from: c, reason: collision with root package name */
    private final String f56419c;

    /* renamed from: d, reason: collision with root package name */
    private com.transsion.player.orplayer.g f56420d;

    /* renamed from: e, reason: collision with root package name */
    private UGCVideo f56421e;

    /* renamed from: f, reason: collision with root package name */
    private long f56422f;

    /* renamed from: g, reason: collision with root package name */
    private long f56423g;

    /* renamed from: h, reason: collision with root package name */
    private long f56424h;

    /* renamed from: i, reason: collision with root package name */
    private long f56425i;

    /* renamed from: j, reason: collision with root package name */
    private long f56426j;

    /* renamed from: k, reason: collision with root package name */
    private int f56427k;

    /* renamed from: l, reason: collision with root package name */
    private long f56428l;

    /* renamed from: m, reason: collision with root package name */
    private long f56429m;

    /* renamed from: n, reason: collision with root package name */
    private long f56430n;

    /* renamed from: o, reason: collision with root package name */
    private int f56431o;

    /* renamed from: p, reason: collision with root package name */
    private long f56432p;

    /* renamed from: q, reason: collision with root package name */
    private long f56433q;

    /* renamed from: r, reason: collision with root package name */
    private long f56434r;

    /* renamed from: s, reason: collision with root package name */
    private Integer f56435s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f56436t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f56437u;

    /* renamed from: v, reason: collision with root package name */
    private String f56438v;

    /* renamed from: w, reason: collision with root package name */
    private int f56439w;

    /* renamed from: x, reason: collision with root package name */
    private yj.c f56440x;

    /* renamed from: y, reason: collision with root package name */
    private String f56441y;

    /* renamed from: z, reason: collision with root package name */
    private int f56442z;

    public a(String pageName, String str) {
        Intrinsics.h(pageName, "pageName");
        this.f56417a = pageName;
        this.f56418b = str;
        this.f56419c = a.class.getSimpleName();
        this.f56437u = true;
        this.f56438v = "";
        this.f56439w = -1;
        this.f56441y = "";
    }

    public static /* synthetic */ void d(a aVar, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        aVar.b(z10);
    }

    private final yj.c e() {
        if (this.f56440x == null) {
            this.f56440x = (yj.c) yj.a.f79145a.a(yj.c.class);
        }
        return this.f56440x;
    }

    private final void q(boolean z10) {
        this.f56422f = 0L;
        this.f56423g = 0L;
        this.f56424h = 0L;
        this.f56425i = 0L;
        this.f56426j = 0L;
        this.f56427k = 0;
        this.f56428l = 0L;
        this.f56429m = 0L;
        this.f56430n = 0L;
        this.f56431o = 0;
        this.f56432p = 0L;
        this.f56433q = 0L;
        this.f56434r = 0L;
        if (z10) {
            return;
        }
        this.f56439w = -1;
        this.f56436t = false;
    }

    public final void a() {
        this.f56423g = System.currentTimeMillis();
        a.C0856a.f(lg.a.f68962a, "video_play", "addSurface", false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(boolean r19) {
        /*
            Method dump skipped, instructions count: 457
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.hepler.a.b(boolean):void");
    }

    public final void c(boolean z10, boolean z11) {
        if (z10) {
            b(z11);
        } else {
            q(z11);
        }
    }

    public final void f() {
        this.f56422f = System.currentTimeMillis();
        this.f56437u = true;
        a.C0856a.f(lg.a.f68962a, "video_play", "initView", false, 4, null);
    }

    public final void g() {
        l(this.f56434r);
    }

    public final void h() {
        this.f56426j = System.currentTimeMillis();
    }

    public final void i() {
        if (this.f56426j > 0) {
            this.f56425i += System.currentTimeMillis() - this.f56426j;
            this.f56427k++;
            this.f56426j = 0L;
        }
    }

    public final void j() {
        this.f56431o++;
        this.f56428l = 0L;
    }

    public final void k(PlayError errorInfo) {
        Intrinsics.h(errorInfo, "errorInfo");
        this.f56435s = errorInfo.getErrorCode();
    }

    public final void l(long j11) {
        if (this.f56434r <= 0) {
            com.transsion.player.orplayer.g gVar = this.f56420d;
            this.f56434r = gVar != null ? gVar.getDuration() : 0L;
        }
        long j12 = this.f56429m;
        long j13 = j11 - j12;
        if (1 <= j13 && j13 < 1000) {
            this.f56430n += j11 - j12;
        }
        this.f56429m = j11;
        if (j11 > this.f56428l) {
            this.f56428l = j11;
        }
        yj.c e11 = e();
        if (e11 != null) {
            e11.a(this.f56430n);
        }
    }

    public final void m() {
        a.C0856a.f(lg.a.f68962a, "video_play", "onRenderFirstFrame", false, 4, null);
        this.f56424h = System.currentTimeMillis();
    }

    public final void n() {
        this.f56432p = System.currentTimeMillis();
    }

    public final void o() {
        if (this.f56432p != 0) {
            this.f56433q += System.currentTimeMillis() - this.f56432p;
            this.f56432p = 0L;
        }
    }

    public final void p() {
        d(this, false, 1, null);
    }

    public final void r(Integer num) {
        this.f56439w = num != null ? num.intValue() : -1;
    }

    public final void s(UGCVideo uGCVideo) {
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f56419c;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "setData----->", false, 4, null);
        this.f56421e = uGCVideo;
    }

    public final void t(com.transsion.player.orplayer.g gVar) {
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f56419c;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "setPlayer----->", false, 4, null);
        this.f56420d = gVar;
    }

    public final void u(String url) {
        Intrinsics.h(url, "url");
        this.f56438v = url;
    }
}
