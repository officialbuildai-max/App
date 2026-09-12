package androidx.media3.exoplayer.source;

import androidx.media3.common.util.a1;
import androidx.media3.datasource.a;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.c4;
import androidx.media3.exoplayer.s2;
import androidx.media3.exoplayer.source.q;
import androidx.media3.exoplayer.source.s;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.exoplayer.upstream.m;
import androidx.media3.exoplayer.v2;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class g0 implements q, Loader.b {

    /* renamed from: a, reason: collision with root package name */
    private final w1.h f12856a;

    /* renamed from: b, reason: collision with root package name */
    private final a.InterfaceC0099a f12857b;

    /* renamed from: c, reason: collision with root package name */
    private final w1.n f12858c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.m f12859d;

    /* renamed from: e, reason: collision with root package name */
    private final s.a f12860e;

    /* renamed from: f, reason: collision with root package name */
    private final g2.z f12861f;

    /* renamed from: g, reason: collision with root package name */
    private final ArrayList f12862g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final long f12863h;

    /* renamed from: i, reason: collision with root package name */
    final Loader f12864i;

    /* renamed from: j, reason: collision with root package name */
    final androidx.media3.common.r f12865j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f12866k;

    /* renamed from: l, reason: collision with root package name */
    boolean f12867l;

    /* renamed from: m, reason: collision with root package name */
    byte[] f12868m;

    /* renamed from: n, reason: collision with root package name */
    int f12869n;

    /* loaded from: classes2.dex */
    private final class b implements g2.u {

        /* renamed from: a, reason: collision with root package name */
        private int f12870a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f12871b;

        private b() {
        }

        private void a() {
            if (this.f12871b) {
                return;
            }
            g0.this.f12860e.j(androidx.media3.common.y.k(g0.this.f12865j.f10243o), g0.this.f12865j, 0, null, 0L);
            this.f12871b = true;
        }

        public void b() {
            if (this.f12870a == 2) {
                this.f12870a = 1;
            }
        }

        @Override // g2.u
        public int c(s2 s2Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            a();
            g0 g0Var = g0.this;
            boolean z10 = g0Var.f12867l;
            if (z10 && g0Var.f12868m == null) {
                this.f12870a = 2;
            }
            int i12 = this.f12870a;
            if (i12 == 2) {
                decoderInputBuffer.addFlag(4);
                return -4;
            }
            if ((i11 & 2) != 0 || i12 == 0) {
                s2Var.f12652b = g0Var.f12865j;
                this.f12870a = 1;
                return -5;
            }
            if (!z10) {
                return -3;
            }
            androidx.media3.common.util.a.e(g0Var.f12868m);
            decoderInputBuffer.addFlag(1);
            decoderInputBuffer.f11002e = 0L;
            if ((i11 & 4) == 0) {
                decoderInputBuffer.b(g0.this.f12869n);
                ByteBuffer byteBuffer = decoderInputBuffer.f11000c;
                g0 g0Var2 = g0.this;
                byteBuffer.put(g0Var2.f12868m, 0, g0Var2.f12869n);
            }
            if ((i11 & 1) == 0) {
                this.f12870a = 2;
            }
            return -4;
        }

        @Override // g2.u
        public boolean isReady() {
            return g0.this.f12867l;
        }

        @Override // g2.u
        public void maybeThrowError() {
            g0 g0Var = g0.this;
            if (g0Var.f12866k) {
                return;
            }
            g0Var.f12864i.maybeThrowError();
        }

        @Override // g2.u
        public int skipData(long j11) {
            a();
            if (j11 <= 0 || this.f12870a == 2) {
                return 0;
            }
            this.f12870a = 2;
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c implements Loader.d {

        /* renamed from: a, reason: collision with root package name */
        public final long f12873a = g2.i.a();

        /* renamed from: b, reason: collision with root package name */
        public final w1.h f12874b;

        /* renamed from: c, reason: collision with root package name */
        private final w1.l f12875c;

        /* renamed from: d, reason: collision with root package name */
        private byte[] f12876d;

        public c(w1.h hVar, androidx.media3.datasource.a aVar) {
            this.f12874b = hVar;
            this.f12875c = new w1.l(aVar);
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.d
        public void cancelLoad() {
        }

        @Override // androidx.media3.exoplayer.upstream.Loader.d
        public void load() {
            this.f12875c.g();
            try {
                this.f12875c.a(this.f12874b);
                int i11 = 0;
                while (i11 != -1) {
                    int d11 = (int) this.f12875c.d();
                    byte[] bArr = this.f12876d;
                    if (bArr == null) {
                        this.f12876d = new byte[1024];
                    } else if (d11 == bArr.length) {
                        this.f12876d = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    w1.l lVar = this.f12875c;
                    byte[] bArr2 = this.f12876d;
                    i11 = lVar.read(bArr2, d11, bArr2.length - d11);
                }
                w1.g.a(this.f12875c);
            } catch (Throwable th2) {
                w1.g.a(this.f12875c);
                throw th2;
            }
        }
    }

    public g0(w1.h hVar, a.InterfaceC0099a interfaceC0099a, w1.n nVar, androidx.media3.common.r rVar, long j11, androidx.media3.exoplayer.upstream.m mVar, s.a aVar, boolean z10, androidx.media3.exoplayer.util.c cVar) {
        this.f12856a = hVar;
        this.f12857b = interfaceC0099a;
        this.f12858c = nVar;
        this.f12865j = rVar;
        this.f12863h = j11;
        this.f12859d = mVar;
        this.f12860e = aVar;
        this.f12866k = z10;
        this.f12861f = new g2.z(new androidx.media3.common.f0(rVar));
        this.f12864i = cVar != null ? new Loader(cVar) : new Loader("SingleSampleMediaPeriod");
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public boolean a(v2 v2Var) {
        if (this.f12867l || this.f12864i.i() || this.f12864i.h()) {
            return false;
        }
        androidx.media3.datasource.a createDataSource = this.f12857b.createDataSource();
        w1.n nVar = this.f12858c;
        if (nVar != null) {
            createDataSource.c(nVar);
        }
        this.f12864i.m(new c(this.f12856a, createDataSource), this, this.f12859d.a(1));
        return true;
    }

    @Override // androidx.media3.exoplayer.source.q
    public long b(long j11, c4 c4Var) {
        return j11;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void q(c cVar, long j11, long j12, boolean z10) {
        w1.l lVar = cVar.f12875c;
        g2.i iVar = new g2.i(cVar.f12873a, cVar.f12874b, lVar.e(), lVar.f(), j11, j12, lVar.d());
        this.f12859d.b(cVar.f12873a);
        this.f12860e.t(iVar, 1, -1, null, 0, null, 0L, this.f12863h);
    }

    @Override // androidx.media3.exoplayer.source.q
    public void discardBuffer(long j11, boolean z10) {
    }

    @Override // androidx.media3.exoplayer.source.q
    public long e(j2.z[] zVarArr, boolean[] zArr, g2.u[] uVarArr, boolean[] zArr2, long j11) {
        for (int i11 = 0; i11 < zVarArr.length; i11++) {
            g2.u uVar = uVarArr[i11];
            if (uVar != null && (zVarArr[i11] == null || !zArr[i11])) {
                this.f12862g.remove(uVar);
                uVarArr[i11] = null;
            }
            if (uVarArr[i11] == null && zVarArr[i11] != null) {
                b bVar = new b();
                this.f12862g.add(bVar);
                uVarArr[i11] = bVar;
                zArr2[i11] = true;
            }
        }
        return j11;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void p(c cVar, long j11, long j12) {
        this.f12869n = (int) cVar.f12875c.d();
        this.f12868m = (byte[]) androidx.media3.common.util.a.e(cVar.f12876d);
        this.f12867l = true;
        w1.l lVar = cVar.f12875c;
        g2.i iVar = new g2.i(cVar.f12873a, cVar.f12874b, lVar.e(), lVar.f(), j11, j12, this.f12869n);
        this.f12859d.b(cVar.f12873a);
        this.f12860e.w(iVar, 1, -1, this.f12865j, 0, null, 0L, this.f12863h);
    }

    @Override // androidx.media3.exoplayer.source.q
    public void g(q.a aVar, long j11) {
        aVar.c(this);
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public long getBufferedPositionUs() {
        return this.f12867l ? Long.MIN_VALUE : 0L;
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public long getNextLoadPositionUs() {
        return (this.f12867l || this.f12864i.i()) ? Long.MIN_VALUE : 0L;
    }

    @Override // androidx.media3.exoplayer.source.q
    public g2.z getTrackGroups() {
        return this.f12861f;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Loader.c k(c cVar, long j11, long j12, IOException iOException, int i11) {
        Loader.c g11;
        w1.l lVar = cVar.f12875c;
        g2.i iVar = new g2.i(cVar.f12873a, cVar.f12874b, lVar.e(), lVar.f(), j11, j12, lVar.d());
        long c11 = this.f12859d.c(new m.c(iVar, new g2.j(1, -1, this.f12865j, 0, null, 0L, a1.y1(this.f12863h)), iOException, i11));
        boolean z10 = c11 == C.TIME_UNSET || i11 >= this.f12859d.a(1);
        if (this.f12866k && z10) {
            androidx.media3.common.util.u.i("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException);
            this.f12867l = true;
            g11 = Loader.f13031f;
        } else {
            g11 = c11 != C.TIME_UNSET ? Loader.g(false, c11) : Loader.f13032g;
        }
        Loader.c cVar2 = g11;
        boolean c12 = cVar2.c();
        this.f12860e.y(iVar, 1, -1, this.f12865j, 0, null, 0L, this.f12863h, iOException, !c12);
        if (!c12) {
            this.f12859d.b(cVar.f12873a);
        }
        return cVar2;
    }

    @Override // androidx.media3.exoplayer.upstream.Loader.b
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void o(c cVar, long j11, long j12, int i11) {
        w1.l lVar = cVar.f12875c;
        this.f12860e.C(i11 == 0 ? new g2.i(cVar.f12873a, cVar.f12874b, j11) : new g2.i(cVar.f12873a, cVar.f12874b, lVar.e(), lVar.f(), j11, j12, lVar.d()), 1, -1, this.f12865j, 0, null, 0L, this.f12863h, i11);
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public boolean isLoading() {
        return this.f12864i.i();
    }

    public void j() {
        this.f12864i.k();
    }

    @Override // androidx.media3.exoplayer.source.q
    public void maybeThrowPrepareError() {
    }

    @Override // androidx.media3.exoplayer.source.q
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public void reevaluateBuffer(long j11) {
    }

    @Override // androidx.media3.exoplayer.source.q
    public long seekToUs(long j11) {
        for (int i11 = 0; i11 < this.f12862g.size(); i11++) {
            ((b) this.f12862g.get(i11)).b();
        }
        return j11;
    }
}
