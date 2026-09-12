package androidx.media3.exoplayer.source;

import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.c4;
import androidx.media3.exoplayer.s2;
import androidx.media3.exoplayer.source.q;
import androidx.media3.exoplayer.v2;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
final class k0 implements q, q.a {

    /* renamed from: a, reason: collision with root package name */
    private final q f12928a;

    /* renamed from: b, reason: collision with root package name */
    private final long f12929b;

    /* renamed from: c, reason: collision with root package name */
    private q.a f12930c;

    /* loaded from: classes2.dex */
    private static final class a implements g2.u {

        /* renamed from: a, reason: collision with root package name */
        private final g2.u f12931a;

        /* renamed from: b, reason: collision with root package name */
        private final long f12932b;

        public a(g2.u uVar, long j11) {
            this.f12931a = uVar;
            this.f12932b = j11;
        }

        public g2.u a() {
            return this.f12931a;
        }

        @Override // g2.u
        public int c(s2 s2Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            int c11 = this.f12931a.c(s2Var, decoderInputBuffer, i11);
            if (c11 == -4) {
                decoderInputBuffer.f11002e += this.f12932b;
            }
            return c11;
        }

        @Override // g2.u
        public boolean isReady() {
            return this.f12931a.isReady();
        }

        @Override // g2.u
        public void maybeThrowError() {
            this.f12931a.maybeThrowError();
        }

        @Override // g2.u
        public int skipData(long j11) {
            return this.f12931a.skipData(j11 - this.f12932b);
        }
    }

    public k0(q qVar, long j11) {
        this.f12928a = qVar;
        this.f12929b = j11;
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public boolean a(v2 v2Var) {
        return this.f12928a.a(v2Var.a().f(v2Var.f13132a - this.f12929b).d());
    }

    @Override // androidx.media3.exoplayer.source.q
    public long b(long j11, c4 c4Var) {
        return this.f12928a.b(j11 - this.f12929b, c4Var) + this.f12929b;
    }

    @Override // androidx.media3.exoplayer.source.q.a
    public void c(q qVar) {
        ((q.a) androidx.media3.common.util.a.e(this.f12930c)).c(this);
    }

    @Override // androidx.media3.exoplayer.source.q
    public void discardBuffer(long j11, boolean z10) {
        this.f12928a.discardBuffer(j11 - this.f12929b, z10);
    }

    @Override // androidx.media3.exoplayer.source.q
    public long e(j2.z[] zVarArr, boolean[] zArr, g2.u[] uVarArr, boolean[] zArr2, long j11) {
        g2.u[] uVarArr2 = new g2.u[uVarArr.length];
        int i11 = 0;
        while (true) {
            g2.u uVar = null;
            if (i11 >= uVarArr.length) {
                break;
            }
            a aVar = (a) uVarArr[i11];
            if (aVar != null) {
                uVar = aVar.a();
            }
            uVarArr2[i11] = uVar;
            i11++;
        }
        long e11 = this.f12928a.e(zVarArr, zArr, uVarArr2, zArr2, j11 - this.f12929b);
        for (int i12 = 0; i12 < uVarArr.length; i12++) {
            g2.u uVar2 = uVarArr2[i12];
            if (uVar2 == null) {
                uVarArr[i12] = null;
            } else {
                g2.u uVar3 = uVarArr[i12];
                if (uVar3 == null || ((a) uVar3).a() != uVar2) {
                    uVarArr[i12] = new a(uVar2, this.f12929b);
                }
            }
        }
        return e11 + this.f12929b;
    }

    @Override // androidx.media3.exoplayer.source.q
    public void g(q.a aVar, long j11) {
        this.f12930c = aVar;
        this.f12928a.g(this, j11 - this.f12929b);
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.f12928a.getBufferedPositionUs();
        if (bufferedPositionUs == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return this.f12929b + bufferedPositionUs;
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.f12928a.getNextLoadPositionUs();
        if (nextLoadPositionUs == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return this.f12929b + nextLoadPositionUs;
    }

    @Override // androidx.media3.exoplayer.source.q
    public g2.z getTrackGroups() {
        return this.f12928a.getTrackGroups();
    }

    public q h() {
        return this.f12928a;
    }

    @Override // androidx.media3.exoplayer.source.f0.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void f(q qVar) {
        ((q.a) androidx.media3.common.util.a.e(this.f12930c)).f(this);
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public boolean isLoading() {
        return this.f12928a.isLoading();
    }

    @Override // androidx.media3.exoplayer.source.q
    public void maybeThrowPrepareError() {
        this.f12928a.maybeThrowPrepareError();
    }

    @Override // androidx.media3.exoplayer.source.q
    public long readDiscontinuity() {
        long readDiscontinuity = this.f12928a.readDiscontinuity();
        return readDiscontinuity == C.TIME_UNSET ? C.TIME_UNSET : this.f12929b + readDiscontinuity;
    }

    @Override // androidx.media3.exoplayer.source.q, androidx.media3.exoplayer.source.f0
    public void reevaluateBuffer(long j11) {
        this.f12928a.reevaluateBuffer(j11 - this.f12929b);
    }

    @Override // androidx.media3.exoplayer.source.q
    public long seekToUs(long j11) {
        return this.f12928a.seekToUs(j11 - this.f12929b) + this.f12929b;
    }
}
