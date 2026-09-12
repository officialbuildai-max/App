package androidx.media3.exoplayer;

import android.os.SystemClock;
import androidx.media3.exoplayer.source.r;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r3 {

    /* renamed from: u, reason: collision with root package name */
    private static final r.b f12624u = new r.b(new Object());

    /* renamed from: a, reason: collision with root package name */
    public final androidx.media3.common.e0 f12625a;

    /* renamed from: b, reason: collision with root package name */
    public final r.b f12626b;

    /* renamed from: c, reason: collision with root package name */
    public final long f12627c;

    /* renamed from: d, reason: collision with root package name */
    public final long f12628d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12629e;

    /* renamed from: f, reason: collision with root package name */
    public final ExoPlaybackException f12630f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f12631g;

    /* renamed from: h, reason: collision with root package name */
    public final g2.z f12632h;

    /* renamed from: i, reason: collision with root package name */
    public final j2.f0 f12633i;

    /* renamed from: j, reason: collision with root package name */
    public final List f12634j;

    /* renamed from: k, reason: collision with root package name */
    public final r.b f12635k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f12636l;

    /* renamed from: m, reason: collision with root package name */
    public final int f12637m;

    /* renamed from: n, reason: collision with root package name */
    public final int f12638n;

    /* renamed from: o, reason: collision with root package name */
    public final androidx.media3.common.z f12639o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f12640p;

    /* renamed from: q, reason: collision with root package name */
    public volatile long f12641q;

    /* renamed from: r, reason: collision with root package name */
    public volatile long f12642r;

    /* renamed from: s, reason: collision with root package name */
    public volatile long f12643s;

    /* renamed from: t, reason: collision with root package name */
    public volatile long f12644t;

    public r3(androidx.media3.common.e0 e0Var, r.b bVar, long j11, long j12, int i11, ExoPlaybackException exoPlaybackException, boolean z10, g2.z zVar, j2.f0 f0Var, List list, r.b bVar2, boolean z11, int i12, int i13, androidx.media3.common.z zVar2, long j13, long j14, long j15, long j16, boolean z12) {
        this.f12625a = e0Var;
        this.f12626b = bVar;
        this.f12627c = j11;
        this.f12628d = j12;
        this.f12629e = i11;
        this.f12630f = exoPlaybackException;
        this.f12631g = z10;
        this.f12632h = zVar;
        this.f12633i = f0Var;
        this.f12634j = list;
        this.f12635k = bVar2;
        this.f12636l = z11;
        this.f12637m = i12;
        this.f12638n = i13;
        this.f12639o = zVar2;
        this.f12641q = j13;
        this.f12642r = j14;
        this.f12643s = j15;
        this.f12644t = j16;
        this.f12640p = z12;
    }

    public static r3 k(j2.f0 f0Var) {
        androidx.media3.common.e0 e0Var = androidx.media3.common.e0.f10007a;
        r.b bVar = f12624u;
        return new r3(e0Var, bVar, C.TIME_UNSET, 0L, 1, null, false, g2.z.f63387d, f0Var, ImmutableList.of(), bVar, false, 1, 0, androidx.media3.common.z.f10645d, 0L, 0L, 0L, 0L, false);
    }

    public static r.b l() {
        return f12624u;
    }

    public r3 a() {
        return new r3(this.f12625a, this.f12626b, this.f12627c, this.f12628d, this.f12629e, this.f12630f, this.f12631g, this.f12632h, this.f12633i, this.f12634j, this.f12635k, this.f12636l, this.f12637m, this.f12638n, this.f12639o, this.f12641q, this.f12642r, m(), SystemClock.elapsedRealtime(), this.f12640p);
    }

    public r3 b(boolean z10) {
        return new r3(this.f12625a, this.f12626b, this.f12627c, this.f12628d, this.f12629e, this.f12630f, z10, this.f12632h, this.f12633i, this.f12634j, this.f12635k, this.f12636l, this.f12637m, this.f12638n, this.f12639o, this.f12641q, this.f12642r, this.f12643s, this.f12644t, this.f12640p);
    }

    public r3 c(r.b bVar) {
        return new r3(this.f12625a, this.f12626b, this.f12627c, this.f12628d, this.f12629e, this.f12630f, this.f12631g, this.f12632h, this.f12633i, this.f12634j, bVar, this.f12636l, this.f12637m, this.f12638n, this.f12639o, this.f12641q, this.f12642r, this.f12643s, this.f12644t, this.f12640p);
    }

    public r3 d(r.b bVar, long j11, long j12, long j13, long j14, g2.z zVar, j2.f0 f0Var, List list) {
        return new r3(this.f12625a, bVar, j12, j13, this.f12629e, this.f12630f, this.f12631g, zVar, f0Var, list, this.f12635k, this.f12636l, this.f12637m, this.f12638n, this.f12639o, this.f12641q, j14, j11, SystemClock.elapsedRealtime(), this.f12640p);
    }

    public r3 e(boolean z10, int i11, int i12) {
        return new r3(this.f12625a, this.f12626b, this.f12627c, this.f12628d, this.f12629e, this.f12630f, this.f12631g, this.f12632h, this.f12633i, this.f12634j, this.f12635k, z10, i11, i12, this.f12639o, this.f12641q, this.f12642r, this.f12643s, this.f12644t, this.f12640p);
    }

    public r3 f(ExoPlaybackException exoPlaybackException) {
        return new r3(this.f12625a, this.f12626b, this.f12627c, this.f12628d, this.f12629e, exoPlaybackException, this.f12631g, this.f12632h, this.f12633i, this.f12634j, this.f12635k, this.f12636l, this.f12637m, this.f12638n, this.f12639o, this.f12641q, this.f12642r, this.f12643s, this.f12644t, this.f12640p);
    }

    public r3 g(androidx.media3.common.z zVar) {
        return new r3(this.f12625a, this.f12626b, this.f12627c, this.f12628d, this.f12629e, this.f12630f, this.f12631g, this.f12632h, this.f12633i, this.f12634j, this.f12635k, this.f12636l, this.f12637m, this.f12638n, zVar, this.f12641q, this.f12642r, this.f12643s, this.f12644t, this.f12640p);
    }

    public r3 h(int i11) {
        return new r3(this.f12625a, this.f12626b, this.f12627c, this.f12628d, i11, this.f12630f, this.f12631g, this.f12632h, this.f12633i, this.f12634j, this.f12635k, this.f12636l, this.f12637m, this.f12638n, this.f12639o, this.f12641q, this.f12642r, this.f12643s, this.f12644t, this.f12640p);
    }

    public r3 i(boolean z10) {
        return new r3(this.f12625a, this.f12626b, this.f12627c, this.f12628d, this.f12629e, this.f12630f, this.f12631g, this.f12632h, this.f12633i, this.f12634j, this.f12635k, this.f12636l, this.f12637m, this.f12638n, this.f12639o, this.f12641q, this.f12642r, this.f12643s, this.f12644t, z10);
    }

    public r3 j(androidx.media3.common.e0 e0Var) {
        return new r3(e0Var, this.f12626b, this.f12627c, this.f12628d, this.f12629e, this.f12630f, this.f12631g, this.f12632h, this.f12633i, this.f12634j, this.f12635k, this.f12636l, this.f12637m, this.f12638n, this.f12639o, this.f12641q, this.f12642r, this.f12643s, this.f12644t, this.f12640p);
    }

    public long m() {
        long j11;
        long j12;
        if (!n()) {
            return this.f12643s;
        }
        do {
            j11 = this.f12644t;
            j12 = this.f12643s;
        } while (j11 != this.f12644t);
        return androidx.media3.common.util.a1.R0(androidx.media3.common.util.a1.y1(j12) + (((float) (SystemClock.elapsedRealtime() - j11)) * this.f12639o.f10648a));
    }

    public boolean n() {
        return this.f12629e == 3 && this.f12636l && this.f12638n == 0;
    }

    public void o(long j11) {
        this.f12643s = j11;
        this.f12644t = SystemClock.elapsedRealtime();
    }
}
