package com.transsion.postdetail.layer;

import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.g;
import hj.i;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import yj.c;

/* loaded from: classes6.dex */
public final class b {
    private c C;
    private int F;

    /* renamed from: b, reason: collision with root package name */
    private g f48960b;

    /* renamed from: c, reason: collision with root package name */
    private String f48961c;

    /* renamed from: d, reason: collision with root package name */
    private PostSubjectItem f48962d;

    /* renamed from: e, reason: collision with root package name */
    private long f48963e;

    /* renamed from: f, reason: collision with root package name */
    private long f48964f;

    /* renamed from: g, reason: collision with root package name */
    private long f48965g;

    /* renamed from: h, reason: collision with root package name */
    private long f48966h;

    /* renamed from: i, reason: collision with root package name */
    private long f48967i;

    /* renamed from: j, reason: collision with root package name */
    private int f48968j;

    /* renamed from: k, reason: collision with root package name */
    private Double f48969k;

    /* renamed from: l, reason: collision with root package name */
    private long f48970l;

    /* renamed from: m, reason: collision with root package name */
    private long f48971m;

    /* renamed from: n, reason: collision with root package name */
    private long f48972n;

    /* renamed from: o, reason: collision with root package name */
    private int f48973o;

    /* renamed from: p, reason: collision with root package name */
    private long f48974p;

    /* renamed from: q, reason: collision with root package name */
    private long f48975q;

    /* renamed from: r, reason: collision with root package name */
    private Double f48976r;

    /* renamed from: s, reason: collision with root package name */
    private long f48977s;

    /* renamed from: t, reason: collision with root package name */
    private Integer f48978t;

    /* renamed from: u, reason: collision with root package name */
    private String f48979u;

    /* renamed from: v, reason: collision with root package name */
    private String f48980v;

    /* renamed from: w, reason: collision with root package name */
    private String f48981w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f48982x;

    /* renamed from: a, reason: collision with root package name */
    private final String f48959a = b.class.getSimpleName();

    /* renamed from: y, reason: collision with root package name */
    private boolean f48983y = true;

    /* renamed from: z, reason: collision with root package name */
    private String f48984z = "";
    private String A = "";
    private int B = -1;
    private String D = "";
    private String E = "";
    private String G = "postdetail";

    public static /* synthetic */ void e(b bVar, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        bVar.d(z10);
    }

    private final c f() {
        if (this.C == null) {
            this.C = (c) yj.a.f79145a.a(c.class);
        }
        return this.C;
    }

    private final void q(boolean z10) {
        this.f48963e = 0L;
        this.f48964f = 0L;
        this.f48965g = 0L;
        this.f48966h = 0L;
        this.f48967i = 0L;
        this.f48968j = 0;
        this.f48970l = 0L;
        this.f48971m = 0L;
        this.f48972n = 0L;
        this.f48973o = 0;
        this.f48974p = 0L;
        this.f48975q = 0L;
        this.f48977s = 0L;
        if (z10) {
            return;
        }
        this.B = -1;
        this.f48982x = false;
    }

    public final void A(String url) {
        Intrinsics.h(url, "url");
        this.A = url;
    }

    public final void a(int i11, int i12) {
        this.f48964f = System.currentTimeMillis();
        a.C0856a.f(lg.a.f68962a, "video_play", "addSurface", false, 4, null);
    }

    public final void b() {
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f48959a;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "clickPause", false, 4, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "pause");
        i.f64628a.s(this.G, "module_name", linkedHashMap);
    }

    public final void c() {
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f48959a;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "clickPlay", false, 4, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", MediaItem.MUSIC_FLOAT_STATE_PLAY);
        i.f64628a.s(this.G, "module_name", linkedHashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:130:0x0186  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(boolean r19) {
        /*
            Method dump skipped, instructions count: 680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.layer.b.d(boolean):void");
    }

    public final void g() {
        this.f48963e = System.currentTimeMillis();
        this.f48983y = true;
        a.C0856a.f(lg.a.f68962a, "video_play", "initView", false, 4, null);
    }

    public final void h() {
        this.f48967i = System.currentTimeMillis();
    }

    public final void i() {
        if (this.f48967i > 0) {
            this.f48966h += System.currentTimeMillis() - this.f48967i;
            this.f48968j++;
            this.f48967i = 0L;
        }
    }

    public final void j() {
        this.f48973o++;
        this.f48970l = 0L;
    }

    public final void k(PlayError errorInfo) {
        Intrinsics.h(errorInfo, "errorInfo");
        this.f48978t = errorInfo.getErrorCode();
    }

    public final void l(long j11) {
        g gVar = this.f48960b;
        this.f48977s = gVar != null ? gVar.getDuration() : 0L;
        long j12 = this.f48971m;
        long j13 = j11 - j12;
        if (1 <= j13 && j13 < 1000) {
            this.f48972n += j11 - j12;
        }
        this.f48971m = j11;
        if (j11 > this.f48970l) {
            this.f48970l = j11;
        }
        c f11 = f();
        if (f11 != null) {
            f11.a(this.f48972n);
        }
    }

    public final void m() {
        a.C0856a.f(lg.a.f68962a, "video_play", "onRenderFirstFrame", false, 4, null);
        this.f48965g = System.currentTimeMillis();
    }

    public final void n() {
        this.f48974p = System.currentTimeMillis();
    }

    public final void o() {
        if (this.f48974p != 0) {
            this.f48975q += System.currentTimeMillis() - this.f48974p;
            this.f48974p = 0L;
        }
    }

    public final void p() {
        e(this, false, 1, null);
    }

    public final void r(String str) {
        this.f48980v = str;
    }

    public final void s(String str) {
        this.f48979u = str;
    }

    public final void t(String pageFrom) {
        Intrinsics.h(pageFrom, "pageFrom");
        this.f48984z = pageFrom;
    }

    public final void u(String str) {
        Intrinsics.h(str, "<set-?>");
        this.G = str;
    }

    public final void v(g orPlayer) {
        Intrinsics.h(orPlayer, "orPlayer");
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f48959a;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "setPlayer----->", false, 4, null);
        this.f48960b = orPlayer;
    }

    public final void w(Integer num) {
        this.B = num != null ? num.intValue() : -1;
    }

    public final void x(String str, PostSubjectItem postSubjectItem) {
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f48959a;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "setPostData----->", false, 4, null);
        this.f48961c = str;
        this.f48962d = postSubjectItem;
    }

    public final void y(int i11) {
        this.F = i11;
    }

    public final void z(String subpageName) {
        Intrinsics.h(subpageName, "subpageName");
        this.f48981w = subpageName;
    }
}
