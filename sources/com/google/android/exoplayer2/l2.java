package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.o;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class l2 {

    /* renamed from: s, reason: collision with root package name */
    private static final o.b f25296s = new o.b(new Object());

    /* renamed from: a, reason: collision with root package name */
    public final k3 f25297a;

    /* renamed from: b, reason: collision with root package name */
    public final o.b f25298b;

    /* renamed from: c, reason: collision with root package name */
    public final long f25299c;

    /* renamed from: d, reason: collision with root package name */
    public final long f25300d;

    /* renamed from: e, reason: collision with root package name */
    public final int f25301e;

    /* renamed from: f, reason: collision with root package name */
    public final ExoPlaybackException f25302f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f25303g;

    /* renamed from: h, reason: collision with root package name */
    public final t9.x f25304h;

    /* renamed from: i, reason: collision with root package name */
    public final la.r f25305i;

    /* renamed from: j, reason: collision with root package name */
    public final List f25306j;

    /* renamed from: k, reason: collision with root package name */
    public final o.b f25307k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f25308l;

    /* renamed from: m, reason: collision with root package name */
    public final int f25309m;

    /* renamed from: n, reason: collision with root package name */
    public final n2 f25310n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f25311o;

    /* renamed from: p, reason: collision with root package name */
    public volatile long f25312p;

    /* renamed from: q, reason: collision with root package name */
    public volatile long f25313q;

    /* renamed from: r, reason: collision with root package name */
    public volatile long f25314r;

    public l2(k3 k3Var, o.b bVar, long j11, long j12, int i11, ExoPlaybackException exoPlaybackException, boolean z10, t9.x xVar, la.r rVar, List list, o.b bVar2, boolean z11, int i12, n2 n2Var, long j13, long j14, long j15, boolean z12) {
        this.f25297a = k3Var;
        this.f25298b = bVar;
        this.f25299c = j11;
        this.f25300d = j12;
        this.f25301e = i11;
        this.f25302f = exoPlaybackException;
        this.f25303g = z10;
        this.f25304h = xVar;
        this.f25305i = rVar;
        this.f25306j = list;
        this.f25307k = bVar2;
        this.f25308l = z11;
        this.f25309m = i12;
        this.f25310n = n2Var;
        this.f25312p = j13;
        this.f25313q = j14;
        this.f25314r = j15;
        this.f25311o = z12;
    }

    public static l2 j(la.r rVar) {
        k3 k3Var = k3.f25205a;
        o.b bVar = f25296s;
        return new l2(k3Var, bVar, C.TIME_UNSET, 0L, 1, null, false, t9.x.f76286d, rVar, ImmutableList.of(), bVar, false, 0, n2.f25527d, 0L, 0L, 0L, false);
    }

    public static o.b k() {
        return f25296s;
    }

    public l2 a(boolean z10) {
        return new l2(this.f25297a, this.f25298b, this.f25299c, this.f25300d, this.f25301e, this.f25302f, z10, this.f25304h, this.f25305i, this.f25306j, this.f25307k, this.f25308l, this.f25309m, this.f25310n, this.f25312p, this.f25313q, this.f25314r, this.f25311o);
    }

    public l2 b(o.b bVar) {
        return new l2(this.f25297a, this.f25298b, this.f25299c, this.f25300d, this.f25301e, this.f25302f, this.f25303g, this.f25304h, this.f25305i, this.f25306j, bVar, this.f25308l, this.f25309m, this.f25310n, this.f25312p, this.f25313q, this.f25314r, this.f25311o);
    }

    public l2 c(o.b bVar, long j11, long j12, long j13, long j14, t9.x xVar, la.r rVar, List list) {
        return new l2(this.f25297a, bVar, j12, j13, this.f25301e, this.f25302f, this.f25303g, xVar, rVar, list, this.f25307k, this.f25308l, this.f25309m, this.f25310n, this.f25312p, j14, j11, this.f25311o);
    }

    public l2 d(boolean z10, int i11) {
        return new l2(this.f25297a, this.f25298b, this.f25299c, this.f25300d, this.f25301e, this.f25302f, this.f25303g, this.f25304h, this.f25305i, this.f25306j, this.f25307k, z10, i11, this.f25310n, this.f25312p, this.f25313q, this.f25314r, this.f25311o);
    }

    public l2 e(ExoPlaybackException exoPlaybackException) {
        return new l2(this.f25297a, this.f25298b, this.f25299c, this.f25300d, this.f25301e, exoPlaybackException, this.f25303g, this.f25304h, this.f25305i, this.f25306j, this.f25307k, this.f25308l, this.f25309m, this.f25310n, this.f25312p, this.f25313q, this.f25314r, this.f25311o);
    }

    public l2 f(n2 n2Var) {
        return new l2(this.f25297a, this.f25298b, this.f25299c, this.f25300d, this.f25301e, this.f25302f, this.f25303g, this.f25304h, this.f25305i, this.f25306j, this.f25307k, this.f25308l, this.f25309m, n2Var, this.f25312p, this.f25313q, this.f25314r, this.f25311o);
    }

    public l2 g(int i11) {
        return new l2(this.f25297a, this.f25298b, this.f25299c, this.f25300d, i11, this.f25302f, this.f25303g, this.f25304h, this.f25305i, this.f25306j, this.f25307k, this.f25308l, this.f25309m, this.f25310n, this.f25312p, this.f25313q, this.f25314r, this.f25311o);
    }

    public l2 h(boolean z10) {
        return new l2(this.f25297a, this.f25298b, this.f25299c, this.f25300d, this.f25301e, this.f25302f, this.f25303g, this.f25304h, this.f25305i, this.f25306j, this.f25307k, this.f25308l, this.f25309m, this.f25310n, this.f25312p, this.f25313q, this.f25314r, z10);
    }

    public l2 i(k3 k3Var) {
        return new l2(k3Var, this.f25298b, this.f25299c, this.f25300d, this.f25301e, this.f25302f, this.f25303g, this.f25304h, this.f25305i, this.f25306j, this.f25307k, this.f25308l, this.f25309m, this.f25310n, this.f25312p, this.f25313q, this.f25314r, this.f25311o);
    }
}
