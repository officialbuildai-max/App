package androidx.media3.exoplayer.source;

import androidx.media3.common.util.a1;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.c4;
import androidx.media3.exoplayer.s2;
import androidx.media3.exoplayer.source.ClippingMediaSource;
import androidx.media3.exoplayer.source.q;
import androidx.media3.exoplayer.v2;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
public final class b implements q, q.a {

    /* renamed from: a, reason: collision with root package name */
    public final q f12764a;

    /* renamed from: b, reason: collision with root package name */
    private q.a f12765b;

    /* renamed from: c, reason: collision with root package name */
    private a[] f12766c = new a[0];

    /* renamed from: d, reason: collision with root package name */
    private long f12767d;

    /* renamed from: e, reason: collision with root package name */
    long f12768e;

    /* renamed from: f, reason: collision with root package name */
    long f12769f;

    /* renamed from: g, reason: collision with root package name */
    private ClippingMediaSource.IllegalClippingException f12770g;

    /* loaded from: classes2.dex */
    private final class a implements g2.u {

        /* renamed from: a, reason: collision with root package name */
        public final g2.u f12771a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f12772b;

        public a(g2.u uVar) {
            this.f12771a = uVar;
        }

        public void a() {
            this.f12772b = false;
        }

        @Override // g2.u
        public int c(s2 s2Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            if (b.this.j()) {
                return -3;
            }
            if (this.f12772b) {
                decoderInputBuffer.setFlags(4);
                return -4;
            }
            long bufferedPositionUs = b.this.getBufferedPositionUs();
            int c11 = this.f12771a.c(s2Var, decoderInputBuffer, i11);
            if (c11 == -5) {
                androidx.media3.common.r rVar = (androidx.media3.common.r) androidx.media3.common.util.a.e(s2Var.f12652b);
                int i12 = rVar.H;
                if (i12 != 0 || rVar.I != 0) {
                    b bVar = b.this;
                    if (bVar.f12768e != 0) {
                        i12 = 0;
                    }
                    s2Var.f12652b = rVar.b().Z(i12).a0(bVar.f12769f == Long.MIN_VALUE ? rVar.I : 0).N();
                }
                return -5;
            }
            long j11 = b.this.f12769f;
            if (j11 == Long.MIN_VALUE || ((c11 != -4 || decoderInputBuffer.f11002e < j11) && !(c11 == -3 && bufferedPositionUs == Long.MIN_VALUE && !decoderInputBuffer.f11001d))) {
                return c11;
            }
            decoderInputBuffer.clear();
            decoderInputBuffer.setFlags(4);
            this.f12772b = true;
            return -4;
        }

        @Override // g2.u
        public boolean isReady() {
            return !b.this.j() && this.f12771a.isReady();
        }

        @Override // g2.u
        public void maybeThrowError() {
            this.f12771a.maybeThrowError();
        }

        @Override // g2.u
        public int skipData(long j11) {
            if (b.this.j()) {
                return -3;
            }
            return this.f12771a.skipData(j11);
        }
    }

    public b(q qVar, boolean z10, long j11, long j12) {
        this.f12764a = qVar;
        this.f12767d = z10 ? j11 : C.TIME_UNSET;
        this.f12768e = j11;
        this.f12769f = j12;
    }

    private c4 h(long j11, c4 c4Var) {
        long q11 = a1.q(c4Var.f11429a, 0L, j11 - this.f12768e);
        long j12 = c4Var.f11430b;
        long j13 = this.f12769f;
        long q12 = a1.q(j12, 0L, j13 == Long.MIN_VALUE ? Long.MAX_VALUE : j13 - j11);
        return (q11 == c4Var.f11429a && q12 == c4Var.f11430b) ? c4Var : new c4(q11, q12);
    }

    private static long i(long j11, long j12, long j13) {
        long max = Math.max(j11, j12);
        return j13 != Long.MIN_VALUE ? Math.min(max, j13) : max;
    }

    private static boolean m(long j11, long j12, j2.z[] zVarArr) {
        if (j11 < j12) {
            return true;
        }
        if (j11 != 0) {
            for (j2.z zVar : zVarArr) {
                if (zVar != null) {
                    androidx.media3.common.r selectedFormat = zVar.getSelectedFormat();
                    if (!androidx.media3.common.y.a(selectedFormat.f10243o, selectedFormat.f10239k)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public boolean a(v2 v2Var) {
        return this.f12764a.a(v2Var);
    }

    @Override // androidx.media3.exoplayer.source.q
    public long b(long j11, c4 c4Var) {
        long j12 = this.f12768e;
        if (j11 == j12) {
            return j12;
        }
        return this.f12764a.b(j11, h(j11, c4Var));
    }

    @Override // androidx.media3.exoplayer.source.q.a
    public void c(q qVar) {
        if (this.f12770g != null) {
            return;
        }
        ((q.a) androidx.media3.common.util.a.e(this.f12765b)).c(this);
    }

    @Override // androidx.media3.exoplayer.source.q
    public void discardBuffer(long j11, boolean z10) {
        this.f12764a.discardBuffer(j11, z10);
    }

    @Override // androidx.media3.exoplayer.source.q
    public long e(j2.z[] zVarArr, boolean[] zArr, g2.u[] uVarArr, boolean[] zArr2, long j11) {
        this.f12766c = new a[uVarArr.length];
        g2.u[] uVarArr2 = new g2.u[uVarArr.length];
        int i11 = 0;
        while (true) {
            g2.u uVar = null;
            if (i11 >= uVarArr.length) {
                break;
            }
            a[] aVarArr = this.f12766c;
            a aVar = (a) uVarArr[i11];
            aVarArr[i11] = aVar;
            if (aVar != null) {
                uVar = aVar.f12771a;
            }
            uVarArr2[i11] = uVar;
            i11++;
        }
        long e11 = this.f12764a.e(zVarArr, zArr, uVarArr2, zArr2, j11);
        long i12 = i(e11, j11, this.f12769f);
        this.f12767d = (j() && m(e11, j11, zVarArr)) ? i12 : C.TIME_UNSET;
        for (int i13 = 0; i13 < uVarArr.length; i13++) {
            g2.u uVar2 = uVarArr2[i13];
            if (uVar2 == null) {
                this.f12766c[i13] = null;
            } else {
                a[] aVarArr2 = this.f12766c;
                a aVar2 = aVarArr2[i13];
                if (aVar2 == null || aVar2.f12771a != uVar2) {
                    aVarArr2[i13] = new a(uVar2);
                }
            }
            uVarArr[i13] = this.f12766c[i13];
        }
        return i12;
    }

    @Override // androidx.media3.exoplayer.source.q
    public void g(q.a aVar, long j11) {
        this.f12765b = aVar;
        this.f12764a.g(this, j11);
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.f12764a.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j11 = this.f12769f;
            if (j11 == Long.MIN_VALUE || bufferedPositionUs < j11) {
                return bufferedPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.f12764a.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j11 = this.f12769f;
            if (j11 == Long.MIN_VALUE || nextLoadPositionUs < j11) {
                return nextLoadPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // androidx.media3.exoplayer.source.q
    public g2.z getTrackGroups() {
        return this.f12764a.getTrackGroups();
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public boolean isLoading() {
        return this.f12764a.isLoading();
    }

    boolean j() {
        return this.f12767d != C.TIME_UNSET;
    }

    @Override // androidx.media3.exoplayer.source.f0.a
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void f(q qVar) {
        ((q.a) androidx.media3.common.util.a.e(this.f12765b)).f(this);
    }

    public void l(ClippingMediaSource.IllegalClippingException illegalClippingException) {
        this.f12770g = illegalClippingException;
    }

    @Override // androidx.media3.exoplayer.source.q
    public void maybeThrowPrepareError() {
        ClippingMediaSource.IllegalClippingException illegalClippingException = this.f12770g;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        this.f12764a.maybeThrowPrepareError();
    }

    public void n(long j11, long j12) {
        this.f12768e = j11;
        this.f12769f = j12;
    }

    @Override // androidx.media3.exoplayer.source.q
    public long readDiscontinuity() {
        if (!j()) {
            long readDiscontinuity = this.f12764a.readDiscontinuity();
            return readDiscontinuity == C.TIME_UNSET ? C.TIME_UNSET : i(readDiscontinuity, this.f12768e, this.f12769f);
        }
        long j11 = this.f12767d;
        this.f12767d = C.TIME_UNSET;
        long readDiscontinuity2 = readDiscontinuity();
        return readDiscontinuity2 != C.TIME_UNSET ? readDiscontinuity2 : j11;
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public void reevaluateBuffer(long j11) {
        this.f12764a.reevaluateBuffer(j11);
    }

    @Override // androidx.media3.exoplayer.source.q
    public long seekToUs(long j11) {
        this.f12767d = C.TIME_UNSET;
        for (a aVar : this.f12766c) {
            if (aVar != null) {
                aVar.a();
            }
        }
        return i(this.f12764a.seekToUs(j11), this.f12768e, this.f12769f);
    }
}
