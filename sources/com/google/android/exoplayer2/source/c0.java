package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.c3;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.i0;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class c0 implements n, Loader.b {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.n f25790a;

    /* renamed from: b, reason: collision with root package name */
    private final k.a f25791b;

    /* renamed from: c, reason: collision with root package name */
    private final k0 f25792c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.z f25793d;

    /* renamed from: e, reason: collision with root package name */
    private final p.a f25794e;

    /* renamed from: f, reason: collision with root package name */
    private final t9.x f25795f;

    /* renamed from: h, reason: collision with root package name */
    private final long f25797h;

    /* renamed from: j, reason: collision with root package name */
    final o1 f25799j;

    /* renamed from: k, reason: collision with root package name */
    final boolean f25800k;

    /* renamed from: l, reason: collision with root package name */
    boolean f25801l;

    /* renamed from: m, reason: collision with root package name */
    byte[] f25802m;

    /* renamed from: n, reason: collision with root package name */
    int f25803n;

    /* renamed from: g, reason: collision with root package name */
    private final ArrayList f25796g = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    final Loader f25798i = new Loader("SingleSampleMediaPeriod");

    /* loaded from: classes3.dex */
    private final class b implements t9.s {

        /* renamed from: a, reason: collision with root package name */
        private int f25804a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f25805b;

        private b() {
        }

        private void a() {
            if (this.f25805b) {
                return;
            }
            c0.this.f25794e.i(com.google.android.exoplayer2.util.w.l(c0.this.f25799j.f25550l), c0.this.f25799j, 0, null, 0L);
            this.f25805b = true;
        }

        public void b() {
            if (this.f25804a == 2) {
                this.f25804a = 1;
            }
        }

        @Override // t9.s
        public int c(p1 p1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            a();
            c0 c0Var = c0.this;
            boolean z10 = c0Var.f25801l;
            if (z10 && c0Var.f25802m == null) {
                this.f25804a = 2;
            }
            int i12 = this.f25804a;
            if (i12 == 2) {
                decoderInputBuffer.a(4);
                return -4;
            }
            if ((i11 & 2) != 0 || i12 == 0) {
                p1Var.f25652b = c0Var.f25799j;
                this.f25804a = 1;
                return -5;
            }
            if (!z10) {
                return -3;
            }
            com.google.android.exoplayer2.util.a.e(c0Var.f25802m);
            decoderInputBuffer.a(1);
            decoderInputBuffer.f24899e = 0L;
            if ((i11 & 4) == 0) {
                decoderInputBuffer.m(c0.this.f25803n);
                ByteBuffer byteBuffer = decoderInputBuffer.f24897c;
                c0 c0Var2 = c0.this;
                byteBuffer.put(c0Var2.f25802m, 0, c0Var2.f25803n);
            }
            if ((i11 & 1) == 0) {
                this.f25804a = 2;
            }
            return -4;
        }

        @Override // t9.s
        public boolean isReady() {
            return c0.this.f25801l;
        }

        @Override // t9.s
        public void maybeThrowError() {
            c0 c0Var = c0.this;
            if (c0Var.f25800k) {
                return;
            }
            c0Var.f25798i.maybeThrowError();
        }

        @Override // t9.s
        public int skipData(long j11) {
            a();
            if (j11 <= 0 || this.f25804a == 2) {
                return 0;
            }
            this.f25804a = 2;
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class c implements Loader.d {

        /* renamed from: a, reason: collision with root package name */
        public final long f25807a = t9.h.a();

        /* renamed from: b, reason: collision with root package name */
        public final com.google.android.exoplayer2.upstream.n f25808b;

        /* renamed from: c, reason: collision with root package name */
        private final i0 f25809c;

        /* renamed from: d, reason: collision with root package name */
        private byte[] f25810d;

        public c(com.google.android.exoplayer2.upstream.n nVar, com.google.android.exoplayer2.upstream.k kVar) {
            this.f25808b = nVar;
            this.f25809c = new i0(kVar);
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.d
        public void cancelLoad() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.d
        public void load() {
            this.f25809c.j();
            try {
                this.f25809c.a(this.f25808b);
                int i11 = 0;
                while (i11 != -1) {
                    int f11 = (int) this.f25809c.f();
                    byte[] bArr = this.f25810d;
                    if (bArr == null) {
                        this.f25810d = new byte[1024];
                    } else if (f11 == bArr.length) {
                        this.f25810d = Arrays.copyOf(bArr, bArr.length * 2);
                    }
                    i0 i0Var = this.f25809c;
                    byte[] bArr2 = this.f25810d;
                    i11 = i0Var.read(bArr2, f11, bArr2.length - f11);
                }
                com.google.android.exoplayer2.upstream.m.a(this.f25809c);
            } catch (Throwable th2) {
                com.google.android.exoplayer2.upstream.m.a(this.f25809c);
                throw th2;
            }
        }
    }

    public c0(com.google.android.exoplayer2.upstream.n nVar, k.a aVar, k0 k0Var, o1 o1Var, long j11, com.google.android.exoplayer2.upstream.z zVar, p.a aVar2, boolean z10) {
        this.f25790a = nVar;
        this.f25791b = aVar;
        this.f25792c = k0Var;
        this.f25799j = o1Var;
        this.f25797h = j11;
        this.f25793d = zVar;
        this.f25794e = aVar2;
        this.f25800k = z10;
        this.f25795f = new t9.x(new TrackGroup(o1Var));
    }

    @Override // com.google.android.exoplayer2.source.n
    public long a(long j11, c3 c3Var) {
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.n
    public long b(com.google.android.exoplayer2.trackselection.h[] hVarArr, boolean[] zArr, t9.s[] sVarArr, boolean[] zArr2, long j11) {
        for (int i11 = 0; i11 < hVarArr.length; i11++) {
            t9.s sVar = sVarArr[i11];
            if (sVar != null && (hVarArr[i11] == null || !zArr[i11])) {
                this.f25796g.remove(sVar);
                sVarArr[i11] = null;
            }
            if (sVarArr[i11] == null && hVarArr[i11] != null) {
                b bVar = new b();
                this.f25796g.add(bVar);
                sVarArr[i11] = bVar;
                zArr2[i11] = true;
            }
        }
        return j11;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean continueLoading(long j11) {
        if (this.f25801l || this.f25798i.i() || this.f25798i.h()) {
            return false;
        }
        com.google.android.exoplayer2.upstream.k createDataSource = this.f25791b.createDataSource();
        k0 k0Var = this.f25792c;
        if (k0Var != null) {
            createDataSource.e(k0Var);
        }
        c cVar = new c(this.f25790a, createDataSource);
        this.f25794e.A(new t9.h(cVar.f25807a, this.f25790a, this.f25798i.m(cVar, this, this.f25793d.a(1))), 1, -1, this.f25799j, 0, null, 0L, this.f25797h);
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void j(c cVar, long j11, long j12, boolean z10) {
        i0 i0Var = cVar.f25809c;
        t9.h hVar = new t9.h(cVar.f25807a, cVar.f25808b, i0Var.h(), i0Var.i(), j11, j12, i0Var.f());
        this.f25793d.b(cVar.f25807a);
        this.f25794e.r(hVar, 1, -1, null, 0, null, 0L, this.f25797h);
    }

    @Override // com.google.android.exoplayer2.source.n
    public void discardBuffer(long j11, boolean z10) {
    }

    @Override // com.google.android.exoplayer2.source.n
    public void e(n.a aVar, long j11) {
        aVar.h(this);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void l(c cVar, long j11, long j12) {
        this.f25803n = (int) cVar.f25809c.f();
        this.f25802m = (byte[]) com.google.android.exoplayer2.util.a.e(cVar.f25810d);
        this.f25801l = true;
        i0 i0Var = cVar.f25809c;
        t9.h hVar = new t9.h(cVar.f25807a, cVar.f25808b, i0Var.h(), i0Var.i(), j11, j12, this.f25803n);
        this.f25793d.b(cVar.f25807a);
        this.f25794e.u(hVar, 1, -1, this.f25799j, 0, null, 0L, this.f25797h);
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public Loader.c n(c cVar, long j11, long j12, IOException iOException, int i11) {
        Loader.c g11;
        i0 i0Var = cVar.f25809c;
        t9.h hVar = new t9.h(cVar.f25807a, cVar.f25808b, i0Var.h(), i0Var.i(), j11, j12, i0Var.f());
        long c11 = this.f25793d.c(new z.c(hVar, new t9.i(1, -1, this.f25799j, 0, null, 0L, p0.e1(this.f25797h)), iOException, i11));
        boolean z10 = c11 == C.TIME_UNSET || i11 >= this.f25793d.a(1);
        if (this.f25800k && z10) {
            com.google.android.exoplayer2.util.s.j("SingleSampleMediaPeriod", "Loading failed, treating as end-of-stream.", iOException);
            this.f25801l = true;
            g11 = Loader.f27300f;
        } else {
            g11 = c11 != C.TIME_UNSET ? Loader.g(false, c11) : Loader.f27301g;
        }
        Loader.c cVar2 = g11;
        boolean c12 = cVar2.c();
        this.f25794e.w(hVar, 1, -1, this.f25799j, 0, null, 0L, this.f25797h, iOException, !c12);
        if (!c12) {
            this.f25793d.b(cVar.f25807a);
        }
        return cVar2;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getBufferedPositionUs() {
        return this.f25801l ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getNextLoadPositionUs() {
        return (this.f25801l || this.f25798i.i()) ? Long.MIN_VALUE : 0L;
    }

    @Override // com.google.android.exoplayer2.source.n
    public t9.x getTrackGroups() {
        return this.f25795f;
    }

    public void h() {
        this.f25798i.k();
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean isLoading() {
        return this.f25798i.i();
    }

    @Override // com.google.android.exoplayer2.source.n
    public void maybeThrowPrepareError() {
    }

    @Override // com.google.android.exoplayer2.source.n
    public long readDiscontinuity() {
        return C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public void reevaluateBuffer(long j11) {
    }

    @Override // com.google.android.exoplayer2.source.n
    public long seekToUs(long j11) {
        for (int i11 = 0; i11 < this.f25796g.size(); i11++) {
            ((b) this.f25796g.get(i11)).b();
        }
        return j11;
    }
}
