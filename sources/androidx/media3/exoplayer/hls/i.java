package androidx.media3.exoplayer.hls;

import android.net.Uri;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.util.j0;
import androidx.media3.common.util.p0;
import androidx.media3.common.util.r0;
import androidx.media3.common.x;
import androidx.media3.exoplayer.hls.e;
import androidx.media3.exoplayer.hls.playlist.c;
import androidx.media3.exoplayer.upstream.g;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import w1.h;
import y1.f4;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class i extends h2.m {
    private static final AtomicInteger N = new AtomicInteger();
    private final boolean A;
    private final boolean B;
    private final f4 C;
    private final long D;
    private j E;
    private r F;
    private int G;
    private boolean H;
    private volatile boolean I;
    private boolean J;
    private ImmutableList K;
    private boolean L;
    private boolean M;

    /* renamed from: k, reason: collision with root package name */
    public final int f11824k;

    /* renamed from: l, reason: collision with root package name */
    public final int f11825l;

    /* renamed from: m, reason: collision with root package name */
    public final Uri f11826m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f11827n;

    /* renamed from: o, reason: collision with root package name */
    public final int f11828o;

    /* renamed from: p, reason: collision with root package name */
    private final androidx.media3.datasource.a f11829p;

    /* renamed from: q, reason: collision with root package name */
    private final w1.h f11830q;

    /* renamed from: r, reason: collision with root package name */
    private final j f11831r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f11832s;

    /* renamed from: t, reason: collision with root package name */
    private final boolean f11833t;

    /* renamed from: u, reason: collision with root package name */
    private final p0 f11834u;

    /* renamed from: v, reason: collision with root package name */
    private final g f11835v;

    /* renamed from: w, reason: collision with root package name */
    private final List f11836w;

    /* renamed from: x, reason: collision with root package name */
    private final DrmInitData f11837x;

    /* renamed from: y, reason: collision with root package name */
    private final z2.h f11838y;

    /* renamed from: z, reason: collision with root package name */
    private final j0 f11839z;

    private i(g gVar, androidx.media3.datasource.a aVar, w1.h hVar, androidx.media3.common.r rVar, boolean z10, androidx.media3.datasource.a aVar2, w1.h hVar2, boolean z11, Uri uri, List list, int i11, Object obj, long j11, long j12, long j13, int i12, boolean z12, int i13, boolean z13, boolean z14, p0 p0Var, long j14, DrmInitData drmInitData, j jVar, z2.h hVar3, j0 j0Var, boolean z15, f4 f4Var) {
        super(aVar, hVar, rVar, i11, obj, j11, j12, j13);
        this.A = z10;
        this.f11828o = i12;
        this.M = z12;
        this.f11825l = i13;
        this.f11830q = hVar2;
        this.f11829p = aVar2;
        this.H = hVar2 != null;
        this.B = z11;
        this.f11826m = uri;
        this.f11832s = z14;
        this.f11834u = p0Var;
        this.D = j14;
        this.f11833t = z13;
        this.f11835v = gVar;
        this.f11836w = list;
        this.f11837x = drmInitData;
        this.f11831r = jVar;
        this.f11838y = hVar3;
        this.f11839z = j0Var;
        this.f11827n = z15;
        this.C = f4Var;
        this.K = ImmutableList.of();
        this.f11824k = N.getAndIncrement();
    }

    private static androidx.media3.datasource.a g(androidx.media3.datasource.a aVar, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return aVar;
        }
        androidx.media3.common.util.a.e(bArr2);
        return new a(aVar, bArr, bArr2);
    }

    public static i h(g gVar, androidx.media3.datasource.a aVar, androidx.media3.common.r rVar, long j11, androidx.media3.exoplayer.hls.playlist.c cVar, e.C0105e c0105e, Uri uri, List list, int i11, Object obj, boolean z10, t tVar, long j12, i iVar, byte[] bArr, byte[] bArr2, boolean z11, f4 f4Var, g.a aVar2) {
        w1.h hVar;
        androidx.media3.datasource.a aVar3;
        boolean z12;
        z2.h hVar2;
        j0 j0Var;
        j jVar;
        c.g gVar2 = c0105e.f11818a;
        w1.h a11 = new h.b().i(r0.f(cVar.f17066a, gVar2.f11998a)).h(gVar2.f12006i).g(gVar2.f12007j).b(c0105e.f11821d ? 8 : 0).a();
        boolean z13 = bArr != null;
        androidx.media3.datasource.a g11 = g(aVar, bArr, z13 ? j((String) androidx.media3.common.util.a.e(gVar2.f12005h)) : null);
        c.f fVar = gVar2.f11999b;
        if (fVar != null) {
            boolean z14 = bArr2 != null;
            byte[] j13 = z14 ? j((String) androidx.media3.common.util.a.e(fVar.f12005h)) : null;
            hVar = new h.b().i(r0.f(cVar.f17066a, fVar.f11998a)).h(fVar.f12006i).g(fVar.f12007j).a();
            z12 = z14;
            aVar3 = g(aVar, bArr2, j13);
        } else {
            hVar = null;
            aVar3 = null;
            z12 = false;
        }
        long j14 = j11 + gVar2.f12002e;
        long j15 = j14 + gVar2.f12000c;
        int i12 = cVar.f11959j + gVar2.f12001d;
        if (iVar != null) {
            w1.h hVar3 = iVar.f11830q;
            boolean z15 = hVar == hVar3 || (hVar != null && hVar3 != null && hVar.f77634a.equals(hVar3.f77634a) && hVar.f77640g == iVar.f11830q.f77640g);
            boolean z16 = uri.equals(iVar.f11826m) && iVar.J;
            z2.h hVar4 = iVar.f11838y;
            j0 j0Var2 = iVar.f11839z;
            jVar = (z15 && z16 && !iVar.L && iVar.f11825l == i12) ? iVar.E : null;
            hVar2 = hVar4;
            j0Var = j0Var2;
        } else {
            hVar2 = new z2.h();
            j0Var = new j0(10);
            jVar = null;
        }
        return new i(gVar, g11, a11, rVar, z13, aVar3, hVar, z12, uri, list, i11, obj, j14, j15, c0105e.f11819b, c0105e.f11820c, !c0105e.f11821d, i12, gVar2.f12008k, z10, tVar.a(i12), j12, gVar2.f12003f, jVar, hVar2, j0Var, z11, f4Var);
    }

    private void i(androidx.media3.datasource.a aVar, w1.h hVar, boolean z10, boolean z11) {
        w1.h e11;
        long position;
        long j11;
        if (z10) {
            r0 = this.G != 0;
            e11 = hVar;
        } else {
            e11 = hVar.e(this.G);
        }
        try {
            l2.j s11 = s(aVar, e11, z11);
            if (r0) {
                s11.skipFully(this.G);
            }
            while (!this.I && this.E.a(s11)) {
                try {
                    try {
                    } catch (EOFException e12) {
                        if ((this.f64422d.f10234f & 16384) == 0) {
                            throw e12;
                        }
                        this.E.c();
                        position = s11.getPosition();
                        j11 = hVar.f77640g;
                    }
                } catch (Throwable th2) {
                    this.G = (int) (s11.getPosition() - hVar.f77640g);
                    throw th2;
                }
            }
            position = s11.getPosition();
            j11 = hVar.f77640g;
            this.G = (int) (position - j11);
        } finally {
            w1.g.a(aVar);
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

    private static boolean n(e.C0105e c0105e, androidx.media3.exoplayer.hls.playlist.c cVar) {
        c.g gVar = c0105e.f11818a;
        return gVar instanceof c.d ? ((c.d) gVar).f11991l || (c0105e.f11820c == 0 && cVar.f17068c) : cVar.f17068c;
    }

    private void p() {
        i(this.f64427i, this.f64420b, this.A, true);
    }

    private void q() {
        if (this.H) {
            androidx.media3.common.util.a.e(this.f11829p);
            androidx.media3.common.util.a.e(this.f11830q);
            i(this.f11829p, this.f11830q, this.B, false);
            this.G = 0;
            this.H = false;
        }
    }

    private long r(l2.s sVar) {
        sVar.resetPeekPosition();
        try {
            this.f11839z.S(10);
            sVar.peekFully(this.f11839z.e(), 0, 10);
        } catch (EOFException unused) {
        }
        if (this.f11839z.K() != 4801587) {
            return C.TIME_UNSET;
        }
        this.f11839z.X(3);
        int G = this.f11839z.G();
        int i11 = G + 10;
        if (i11 > this.f11839z.b()) {
            byte[] e11 = this.f11839z.e();
            this.f11839z.S(i11);
            System.arraycopy(e11, 0, this.f11839z.e(), 0, 10);
        }
        sVar.peekFully(this.f11839z.e(), 10, G);
        x e12 = this.f11838y.e(this.f11839z.e(), G);
        if (e12 == null) {
            return C.TIME_UNSET;
        }
        int e13 = e12.e();
        for (int i12 = 0; i12 < e13; i12++) {
            x.a d11 = e12.d(i12);
            if (d11 instanceof z2.m) {
                z2.m mVar = (z2.m) d11;
                if ("com.apple.streaming.transportStreamTimestamp".equals(mVar.f79325b)) {
                    System.arraycopy(mVar.f79326c, 0, this.f11839z.e(), 0, 8);
                    this.f11839z.W(0);
                    this.f11839z.V(8);
                    return this.f11839z.A() & 8589934591L;
                }
            }
        }
        return C.TIME_UNSET;
    }

    private l2.j s(androidx.media3.datasource.a aVar, w1.h hVar, boolean z10) {
        long a11 = aVar.a(hVar);
        if (z10) {
            try {
                this.f11834u.j(this.f11832s, this.f64425g, this.D);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            } catch (TimeoutException e11) {
                throw new IOException(e11);
            }
        }
        l2.j jVar = new l2.j(aVar, hVar.f77640g, a11);
        if (this.E == null) {
            long r11 = r(jVar);
            jVar.resetPeekPosition();
            j jVar2 = this.f11831r;
            j f11 = jVar2 != null ? jVar2.f() : this.f11835v.e(hVar.f77634a, this.f64422d, this.f11836w, this.f11834u, aVar.getResponseHeaders(), jVar, this.C);
            this.E = f11;
            if (f11.e()) {
                this.F.f0(r11 != C.TIME_UNSET ? this.f11834u.b(r11) : this.f64425g);
            } else {
                this.F.f0(0L);
            }
            this.F.R();
            this.E.b(this.F);
        }
        this.F.c0(this.f11837x);
        return jVar;
    }

    public static boolean u(i iVar, Uri uri, androidx.media3.exoplayer.hls.playlist.c cVar, e.C0105e c0105e, long j11) {
        if (iVar == null) {
            return false;
        }
        if (uri.equals(iVar.f11826m) && iVar.J) {
            return false;
        }
        return !n(c0105e, cVar) || j11 + c0105e.f11818a.f12002e < iVar.f64426h;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public void cancelLoad() {
        this.I = true;
    }

    @Override // h2.m
    public boolean f() {
        return this.J;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int k(int i11) {
        androidx.media3.common.util.a.g(!this.f11827n);
        if (i11 >= this.K.size()) {
            return 0;
        }
        return ((Integer) this.K.get(i11)).intValue();
    }

    public void l(r rVar, ImmutableList immutableList) {
        this.F = rVar;
        this.K = immutableList;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.d
    public void load() {
        j jVar;
        androidx.media3.common.util.a.e(this.F);
        if (this.E == null && (jVar = this.f11831r) != null && jVar.d()) {
            this.E = this.f11831r;
            this.H = false;
        }
        q();
        if (this.I) {
            return;
        }
        if (!this.f11833t) {
            p();
        }
        this.J = !this.I;
    }

    public void m() {
        this.L = true;
    }

    public boolean o() {
        return this.M;
    }

    public void t() {
        this.M = true;
    }
}
