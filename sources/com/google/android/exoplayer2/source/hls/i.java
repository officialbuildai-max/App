package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.source.hls.e;
import com.google.android.exoplayer2.source.hls.playlist.d;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.n0;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import e9.u1;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class i extends v9.n {
    private static final AtomicInteger M = new AtomicInteger();
    private final boolean A;
    private final boolean B;
    private final u1 C;
    private j D;
    private p E;
    private int F;
    private boolean G;
    private volatile boolean H;
    private boolean I;
    private ImmutableList J;
    private boolean K;
    private boolean L;

    /* renamed from: k, reason: collision with root package name */
    public final int f26036k;

    /* renamed from: l, reason: collision with root package name */
    public final int f26037l;

    /* renamed from: m, reason: collision with root package name */
    public final Uri f26038m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f26039n;

    /* renamed from: o, reason: collision with root package name */
    public final int f26040o;

    /* renamed from: p, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.k f26041p;

    /* renamed from: q, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.n f26042q;

    /* renamed from: r, reason: collision with root package name */
    private final j f26043r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f26044s;

    /* renamed from: t, reason: collision with root package name */
    private final boolean f26045t;

    /* renamed from: u, reason: collision with root package name */
    private final l0 f26046u;

    /* renamed from: v, reason: collision with root package name */
    private final g f26047v;

    /* renamed from: w, reason: collision with root package name */
    private final List f26048w;

    /* renamed from: x, reason: collision with root package name */
    private final DrmInitData f26049x;

    /* renamed from: y, reason: collision with root package name */
    private final com.google.android.exoplayer2.metadata.id3.b f26050y;

    /* renamed from: z, reason: collision with root package name */
    private final d0 f26051z;

    private i(g gVar, com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, o1 o1Var, boolean z10, com.google.android.exoplayer2.upstream.k kVar2, com.google.android.exoplayer2.upstream.n nVar2, boolean z11, Uri uri, List list, int i11, Object obj, long j11, long j12, long j13, int i12, boolean z12, int i13, boolean z13, boolean z14, l0 l0Var, DrmInitData drmInitData, j jVar, com.google.android.exoplayer2.metadata.id3.b bVar, d0 d0Var, boolean z15, u1 u1Var) {
        super(kVar, nVar, o1Var, i11, obj, j11, j12, j13);
        this.A = z10;
        this.f26040o = i12;
        this.L = z12;
        this.f26037l = i13;
        this.f26042q = nVar2;
        this.f26041p = kVar2;
        this.G = nVar2 != null;
        this.B = z11;
        this.f26038m = uri;
        this.f26044s = z14;
        this.f26046u = l0Var;
        this.f26045t = z13;
        this.f26047v = gVar;
        this.f26048w = list;
        this.f26049x = drmInitData;
        this.f26043r = jVar;
        this.f26050y = bVar;
        this.f26051z = d0Var;
        this.f26039n = z15;
        this.C = u1Var;
        this.J = ImmutableList.of();
        this.f26036k = M.getAndIncrement();
    }

    private static com.google.android.exoplayer2.upstream.k g(com.google.android.exoplayer2.upstream.k kVar, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return kVar;
        }
        com.google.android.exoplayer2.util.a.e(bArr2);
        return new a(kVar, bArr, bArr2);
    }

    public static i h(g gVar, com.google.android.exoplayer2.upstream.k kVar, o1 o1Var, long j11, com.google.android.exoplayer2.source.hls.playlist.d dVar, e.C0372e c0372e, Uri uri, List list, int i11, Object obj, boolean z10, q qVar, i iVar, byte[] bArr, byte[] bArr2, boolean z11, u1 u1Var) {
        boolean z12;
        com.google.android.exoplayer2.upstream.k kVar2;
        com.google.android.exoplayer2.upstream.n nVar;
        boolean z13;
        com.google.android.exoplayer2.metadata.id3.b bVar;
        d0 d0Var;
        j jVar;
        d.e eVar = c0372e.f26028a;
        com.google.android.exoplayer2.upstream.n a11 = new n.b().i(n0.e(dVar.f79073a, eVar.f26203a)).h(eVar.f26211i).g(eVar.f26212j).b(c0372e.f26031d ? 8 : 0).a();
        boolean z14 = bArr != null;
        com.google.android.exoplayer2.upstream.k g11 = g(kVar, bArr, z14 ? j((String) com.google.android.exoplayer2.util.a.e(eVar.f26210h)) : null);
        d.C0374d c0374d = eVar.f26204b;
        if (c0374d != null) {
            boolean z15 = bArr2 != null;
            byte[] j12 = z15 ? j((String) com.google.android.exoplayer2.util.a.e(c0374d.f26210h)) : null;
            z12 = z14;
            nVar = new com.google.android.exoplayer2.upstream.n(n0.e(dVar.f79073a, c0374d.f26203a), c0374d.f26211i, c0374d.f26212j);
            kVar2 = g(kVar, bArr2, j12);
            z13 = z15;
        } else {
            z12 = z14;
            kVar2 = null;
            nVar = null;
            z13 = false;
        }
        long j13 = j11 + eVar.f26207e;
        long j14 = j13 + eVar.f26205c;
        int i12 = dVar.f26183j + eVar.f26206d;
        if (iVar != null) {
            com.google.android.exoplayer2.upstream.n nVar2 = iVar.f26042q;
            boolean z16 = nVar == nVar2 || (nVar != null && nVar2 != null && nVar.f27491a.equals(nVar2.f27491a) && nVar.f27497g == iVar.f26042q.f27497g);
            boolean z17 = uri.equals(iVar.f26038m) && iVar.I;
            bVar = iVar.f26050y;
            d0Var = iVar.f26051z;
            jVar = (z16 && z17 && !iVar.K && iVar.f26037l == i12) ? iVar.D : null;
        } else {
            bVar = new com.google.android.exoplayer2.metadata.id3.b();
            d0Var = new d0(10);
            jVar = null;
        }
        return new i(gVar, g11, a11, o1Var, z12, kVar2, nVar, z13, uri, list, i11, obj, j13, j14, c0372e.f26029b, c0372e.f26030c, !c0372e.f26031d, i12, eVar.f26213k, z10, qVar.a(i12), eVar.f26208f, jVar, bVar, d0Var, z11, u1Var);
    }

    private void i(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, boolean z10, boolean z11) {
        com.google.android.exoplayer2.upstream.n e11;
        long position;
        long j11;
        if (z10) {
            r0 = this.F != 0;
            e11 = nVar;
        } else {
            e11 = nVar.e(this.F);
        }
        try {
            g9.f s11 = s(kVar, e11, z11);
            if (r0) {
                s11.skipFully(this.F);
            }
            while (!this.H && this.D.a(s11)) {
                try {
                    try {
                    } catch (EOFException e12) {
                        if ((this.f77258d.f25543e & 16384) == 0) {
                            throw e12;
                        }
                        this.D.c();
                        position = s11.getPosition();
                        j11 = nVar.f27497g;
                    }
                } catch (Throwable th2) {
                    this.F = (int) (s11.getPosition() - nVar.f27497g);
                    throw th2;
                }
            }
            position = s11.getPosition();
            j11 = nVar.f27497g;
            this.F = (int) (position - j11);
        } finally {
            com.google.android.exoplayer2.upstream.m.a(kVar);
        }
    }

    private static byte[] j(String str) {
        if (com.google.common.base.a.e(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    private static boolean n(e.C0372e c0372e, com.google.android.exoplayer2.source.hls.playlist.d dVar) {
        d.e eVar = c0372e.f26028a;
        return eVar instanceof d.b ? ((d.b) eVar).f26196l || (c0372e.f26030c == 0 && dVar.f79075c) : dVar.f79075c;
    }

    private void p() {
        i(this.f77263i, this.f77256b, this.A, true);
    }

    private void q() {
        if (this.G) {
            com.google.android.exoplayer2.util.a.e(this.f26041p);
            com.google.android.exoplayer2.util.a.e(this.f26042q);
            i(this.f26041p, this.f26042q, this.B, false);
            this.F = 0;
            this.G = false;
        }
    }

    private long r(g9.m mVar) {
        mVar.resetPeekPosition();
        try {
            this.f26051z.L(10);
            mVar.peekFully(this.f26051z.d(), 0, 10);
        } catch (EOFException unused) {
        }
        if (this.f26051z.G() != 4801587) {
            return C.TIME_UNSET;
        }
        this.f26051z.Q(3);
        int C = this.f26051z.C();
        int i11 = C + 10;
        if (i11 > this.f26051z.b()) {
            byte[] d11 = this.f26051z.d();
            this.f26051z.L(i11);
            System.arraycopy(d11, 0, this.f26051z.d(), 0, 10);
        }
        mVar.peekFully(this.f26051z.d(), 10, C);
        Metadata e11 = this.f26050y.e(this.f26051z.d(), C);
        if (e11 == null) {
            return C.TIME_UNSET;
        }
        int length = e11.length();
        for (int i12 = 0; i12 < length; i12++) {
            Metadata.Entry entry = e11.get(i12);
            if (entry instanceof PrivFrame) {
                PrivFrame privFrame = (PrivFrame) entry;
                if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.owner)) {
                    System.arraycopy(privFrame.privateData, 0, this.f26051z.d(), 0, 8);
                    this.f26051z.P(0);
                    this.f26051z.O(8);
                    return this.f26051z.w() & 8589934591L;
                }
            }
        }
        return C.TIME_UNSET;
    }

    private g9.f s(com.google.android.exoplayer2.upstream.k kVar, com.google.android.exoplayer2.upstream.n nVar, boolean z10) {
        long a11 = kVar.a(nVar);
        if (z10) {
            try {
                this.f26046u.h(this.f26044s, this.f77261g);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            }
        }
        g9.f fVar = new g9.f(kVar, nVar.f27497g, a11);
        if (this.D == null) {
            long r11 = r(fVar);
            fVar.resetPeekPosition();
            j jVar = this.f26043r;
            j f11 = jVar != null ? jVar.f() : this.f26047v.a(nVar.f27491a, this.f77258d, this.f26048w, this.f26046u, kVar.getResponseHeaders(), fVar, this.C);
            this.D = f11;
            if (f11.e()) {
                this.E.a0(r11 != C.TIME_UNSET ? this.f26046u.b(r11) : this.f77261g);
            } else {
                this.E.a0(0L);
            }
            this.E.M();
            this.D.b(this.E);
        }
        this.E.X(this.f26049x);
        return fVar;
    }

    public static boolean u(i iVar, Uri uri, com.google.android.exoplayer2.source.hls.playlist.d dVar, e.C0372e c0372e, long j11) {
        if (iVar == null) {
            return false;
        }
        if (uri.equals(iVar.f26038m) && iVar.I) {
            return false;
        }
        return !n(c0372e, dVar) || j11 + c0372e.f26028a.f26207e < iVar.f77262h;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void cancelLoad() {
        this.H = true;
    }

    @Override // v9.n
    public boolean f() {
        return this.I;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int k(int i11) {
        com.google.android.exoplayer2.util.a.g(!this.f26039n);
        if (i11 >= this.J.size()) {
            return 0;
        }
        return ((Integer) this.J.get(i11)).intValue();
    }

    public void l(p pVar, ImmutableList immutableList) {
        this.E = pVar;
        this.J = immutableList;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.d
    public void load() {
        j jVar;
        com.google.android.exoplayer2.util.a.e(this.E);
        if (this.D == null && (jVar = this.f26043r) != null && jVar.d()) {
            this.D = this.f26043r;
            this.G = false;
        }
        q();
        if (this.H) {
            return;
        }
        if (!this.f26045t) {
            p();
        }
        this.I = !this.H;
    }

    public void m() {
        this.K = true;
    }

    public boolean o() {
        return this.L;
    }

    public void t() {
        this.L = true;
    }
}
