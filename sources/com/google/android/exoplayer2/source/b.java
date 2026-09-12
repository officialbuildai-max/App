package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.c3;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.source.ClippingMediaSource;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes3.dex */
public final class b implements n, n.a {

    /* renamed from: a, reason: collision with root package name */
    public final n f25770a;

    /* renamed from: b, reason: collision with root package name */
    private n.a f25771b;

    /* renamed from: c, reason: collision with root package name */
    private a[] f25772c = new a[0];

    /* renamed from: d, reason: collision with root package name */
    private long f25773d;

    /* renamed from: e, reason: collision with root package name */
    long f25774e;

    /* renamed from: f, reason: collision with root package name */
    long f25775f;

    /* renamed from: g, reason: collision with root package name */
    private ClippingMediaSource.IllegalClippingException f25776g;

    /* loaded from: classes3.dex */
    private final class a implements t9.s {

        /* renamed from: a, reason: collision with root package name */
        public final t9.s f25777a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f25778b;

        public a(t9.s sVar) {
            this.f25777a = sVar;
        }

        public void a() {
            this.f25778b = false;
        }

        @Override // t9.s
        public int c(p1 p1Var, DecoderInputBuffer decoderInputBuffer, int i11) {
            if (b.this.f()) {
                return -3;
            }
            if (this.f25778b) {
                decoderInputBuffer.k(4);
                return -4;
            }
            int c11 = this.f25777a.c(p1Var, decoderInputBuffer, i11);
            if (c11 == -5) {
                o1 o1Var = (o1) com.google.android.exoplayer2.util.a.e(p1Var.f25652b);
                int i12 = o1Var.B;
                if (i12 != 0 || o1Var.C != 0) {
                    b bVar = b.this;
                    if (bVar.f25774e != 0) {
                        i12 = 0;
                    }
                    p1Var.f25652b = o1Var.b().N(i12).O(bVar.f25775f == Long.MIN_VALUE ? o1Var.C : 0).E();
                }
                return -5;
            }
            b bVar2 = b.this;
            long j11 = bVar2.f25775f;
            if (j11 == Long.MIN_VALUE || ((c11 != -4 || decoderInputBuffer.f24899e < j11) && !(c11 == -3 && bVar2.getBufferedPositionUs() == Long.MIN_VALUE && !decoderInputBuffer.f24898d))) {
                return c11;
            }
            decoderInputBuffer.b();
            decoderInputBuffer.k(4);
            this.f25778b = true;
            return -4;
        }

        @Override // t9.s
        public boolean isReady() {
            return !b.this.f() && this.f25777a.isReady();
        }

        @Override // t9.s
        public void maybeThrowError() {
            this.f25777a.maybeThrowError();
        }

        @Override // t9.s
        public int skipData(long j11) {
            if (b.this.f()) {
                return -3;
            }
            return this.f25777a.skipData(j11);
        }
    }

    public b(n nVar, boolean z10, long j11, long j12) {
        this.f25770a = nVar;
        this.f25773d = z10 ? j11 : C.TIME_UNSET;
        this.f25774e = j11;
        this.f25775f = j12;
    }

    private c3 c(long j11, c3 c3Var) {
        long r11 = p0.r(c3Var.f24889a, 0L, j11 - this.f25774e);
        long j12 = c3Var.f24890b;
        long j13 = this.f25775f;
        long r12 = p0.r(j12, 0L, j13 == Long.MIN_VALUE ? Long.MAX_VALUE : j13 - j11);
        return (r11 == c3Var.f24889a && r12 == c3Var.f24890b) ? c3Var : new c3(r11, r12);
    }

    private static boolean k(long j11, com.google.android.exoplayer2.trackselection.h[] hVarArr) {
        if (j11 != 0) {
            for (com.google.android.exoplayer2.trackselection.h hVar : hVarArr) {
                if (hVar != null) {
                    o1 selectedFormat = hVar.getSelectedFormat();
                    if (!com.google.android.exoplayer2.util.w.a(selectedFormat.f25550l, selectedFormat.f25547i)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.n
    public long a(long j11, c3 c3Var) {
        long j12 = this.f25774e;
        if (j11 == j12) {
            return j12;
        }
        return this.f25770a.a(j11, c(j11, c3Var));
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005e, code lost:
    
        if (r3 > r5) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    @Override // com.google.android.exoplayer2.source.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long b(com.google.android.exoplayer2.trackselection.h[] r13, boolean[] r14, t9.s[] r15, boolean[] r16, long r17) {
        /*
            r12 = this;
            r0 = r12
            r1 = r15
            int r2 = r1.length
            com.google.android.exoplayer2.source.b$a[] r2 = new com.google.android.exoplayer2.source.b.a[r2]
            r0.f25772c = r2
            int r2 = r1.length
            t9.s[] r2 = new t9.s[r2]
            r10 = 0
            r3 = r10
        Lc:
            int r4 = r1.length
            r11 = 0
            if (r3 >= r4) goto L21
            com.google.android.exoplayer2.source.b$a[] r4 = r0.f25772c
            r5 = r1[r3]
            com.google.android.exoplayer2.source.b$a r5 = (com.google.android.exoplayer2.source.b.a) r5
            r4[r3] = r5
            if (r5 == 0) goto L1c
            t9.s r11 = r5.f25777a
        L1c:
            r2[r3] = r11
            int r3 = r3 + 1
            goto Lc
        L21:
            com.google.android.exoplayer2.source.n r3 = r0.f25770a
            r4 = r13
            r5 = r14
            r6 = r2
            r7 = r16
            r8 = r17
            long r3 = r3.b(r4, r5, r6, r7, r8)
            boolean r5 = r12.f()
            if (r5 == 0) goto L43
            long r5 = r0.f25774e
            int r7 = (r17 > r5 ? 1 : (r17 == r5 ? 0 : -1))
            if (r7 != 0) goto L43
            r7 = r13
            boolean r5 = k(r5, r13)
            if (r5 == 0) goto L43
            r5 = r3
            goto L48
        L43:
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L48:
            r0.f25773d = r5
            int r5 = (r3 > r17 ? 1 : (r3 == r17 ? 0 : -1))
            if (r5 == 0) goto L63
            long r5 = r0.f25774e
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 < 0) goto L61
            long r5 = r0.f25775f
            r7 = -9223372036854775808
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 == 0) goto L63
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 > 0) goto L61
            goto L63
        L61:
            r5 = r10
            goto L64
        L63:
            r5 = 1
        L64:
            com.google.android.exoplayer2.util.a.g(r5)
        L67:
            int r5 = r1.length
            if (r10 >= r5) goto L8d
            r5 = r2[r10]
            if (r5 != 0) goto L73
            com.google.android.exoplayer2.source.b$a[] r5 = r0.f25772c
            r5[r10] = r11
            goto L84
        L73:
            com.google.android.exoplayer2.source.b$a[] r6 = r0.f25772c
            r7 = r6[r10]
            if (r7 == 0) goto L7d
            t9.s r7 = r7.f25777a
            if (r7 == r5) goto L84
        L7d:
            com.google.android.exoplayer2.source.b$a r7 = new com.google.android.exoplayer2.source.b$a
            r7.<init>(r5)
            r6[r10] = r7
        L84:
            com.google.android.exoplayer2.source.b$a[] r5 = r0.f25772c
            r5 = r5[r10]
            r1[r10] = r5
            int r10 = r10 + 1
            goto L67
        L8d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.b.b(com.google.android.exoplayer2.trackselection.h[], boolean[], t9.s[], boolean[], long):long");
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean continueLoading(long j11) {
        return this.f25770a.continueLoading(j11);
    }

    @Override // com.google.android.exoplayer2.source.n
    public void discardBuffer(long j11, boolean z10) {
        this.f25770a.discardBuffer(j11, z10);
    }

    @Override // com.google.android.exoplayer2.source.n
    public void e(n.a aVar, long j11) {
        this.f25771b = aVar;
        this.f25770a.e(this, j11);
    }

    boolean f() {
        return this.f25773d != C.TIME_UNSET;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.f25770a.getBufferedPositionUs();
        if (bufferedPositionUs != Long.MIN_VALUE) {
            long j11 = this.f25775f;
            if (j11 == Long.MIN_VALUE || bufferedPositionUs < j11) {
                return bufferedPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.f25770a.getNextLoadPositionUs();
        if (nextLoadPositionUs != Long.MIN_VALUE) {
            long j11 = this.f25775f;
            if (j11 == Long.MIN_VALUE || nextLoadPositionUs < j11) {
                return nextLoadPositionUs;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.exoplayer2.source.n
    public t9.x getTrackGroups() {
        return this.f25770a.getTrackGroups();
    }

    @Override // com.google.android.exoplayer2.source.n.a
    public void h(n nVar) {
        if (this.f25776g != null) {
            return;
        }
        ((n.a) com.google.android.exoplayer2.util.a.e(this.f25771b)).h(this);
    }

    @Override // com.google.android.exoplayer2.source.b0.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void g(n nVar) {
        ((n.a) com.google.android.exoplayer2.util.a.e(this.f25771b)).g(this);
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public boolean isLoading() {
        return this.f25770a.isLoading();
    }

    public void j(ClippingMediaSource.IllegalClippingException illegalClippingException) {
        this.f25776g = illegalClippingException;
    }

    public void l(long j11, long j12) {
        this.f25774e = j11;
        this.f25775f = j12;
    }

    @Override // com.google.android.exoplayer2.source.n
    public void maybeThrowPrepareError() {
        ClippingMediaSource.IllegalClippingException illegalClippingException = this.f25776g;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        this.f25770a.maybeThrowPrepareError();
    }

    @Override // com.google.android.exoplayer2.source.n
    public long readDiscontinuity() {
        if (f()) {
            long j11 = this.f25773d;
            this.f25773d = C.TIME_UNSET;
            long readDiscontinuity = readDiscontinuity();
            return readDiscontinuity != C.TIME_UNSET ? readDiscontinuity : j11;
        }
        long readDiscontinuity2 = this.f25770a.readDiscontinuity();
        if (readDiscontinuity2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        com.google.android.exoplayer2.util.a.g(readDiscontinuity2 >= this.f25774e);
        long j12 = this.f25775f;
        com.google.android.exoplayer2.util.a.g(j12 == Long.MIN_VALUE || readDiscontinuity2 <= j12);
        return readDiscontinuity2;
    }

    @Override // com.google.android.exoplayer2.source.n, com.google.android.exoplayer2.source.b0
    public void reevaluateBuffer(long j11) {
        this.f25770a.reevaluateBuffer(j11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        if (r0 > r6) goto L17;
     */
    @Override // com.google.android.exoplayer2.source.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long seekToUs(long r6) {
        /*
            r5 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5.f25773d = r0
            com.google.android.exoplayer2.source.b$a[] r0 = r5.f25772c
            int r1 = r0.length
            r2 = 0
            r3 = r2
        Lc:
            if (r3 >= r1) goto L18
            r4 = r0[r3]
            if (r4 == 0) goto L15
            r4.a()
        L15:
            int r3 = r3 + 1
            goto Lc
        L18:
            com.google.android.exoplayer2.source.n r0 = r5.f25770a
            long r0 = r0.seekToUs(r6)
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 == 0) goto L34
            long r6 = r5.f25774e
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 < 0) goto L35
            long r6 = r5.f25775f
            r3 = -9223372036854775808
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 == 0) goto L34
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 > 0) goto L35
        L34:
            r2 = 1
        L35:
            com.google.android.exoplayer2.util.a.g(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.b.seekToUs(long):long");
    }
}
