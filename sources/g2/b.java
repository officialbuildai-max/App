package g2;

import l2.l0;

/* loaded from: classes2.dex */
public final class b implements androidx.media3.exoplayer.source.v {

    /* renamed from: a, reason: collision with root package name */
    private final l2.x f63319a;

    /* renamed from: b, reason: collision with root package name */
    private l2.r f63320b;

    /* renamed from: c, reason: collision with root package name */
    private l2.s f63321c;

    public b(l2.x xVar) {
        this.f63319a = xVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String f(l2.r rVar) {
        return rVar.e().getClass().getSimpleName();
    }

    @Override // androidx.media3.exoplayer.source.v
    public void a() {
        l2.r rVar = this.f63320b;
        if (rVar == null) {
            return;
        }
        l2.r e11 = rVar.e();
        if (e11 instanceof e3.f) {
            ((e3.f) e11).k();
        }
    }

    @Override // androidx.media3.exoplayer.source.v
    public long b() {
        l2.s sVar = this.f63321c;
        if (sVar != null) {
            return sVar.getPosition();
        }
        return -1L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
    
        if (r6.getPosition() != r11) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0050, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0078, code lost:
    
        if (r6.getPosition() != r11) goto L23;
     */
    @Override // androidx.media3.exoplayer.source.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(androidx.media3.common.j r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, l2.t r15) {
        /*
            r7 = this;
            l2.j r6 = new l2.j
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.f63321c = r6
            l2.r r8 = r7.f63320b
            if (r8 == 0) goto L10
            return
        L10:
            l2.x r8 = r7.f63319a
            l2.r[] r8 = r8.c(r9, r10)
            int r10 = r8.length
            com.google.common.collect.ImmutableList$a r10 = com.google.common.collect.ImmutableList.builderWithExpectedSize(r10)
            int r13 = r8.length
            r14 = 0
            r0 = 1
            if (r13 != r0) goto L25
            r8 = r8[r14]
            r7.f63320b = r8
            goto L82
        L25:
            int r13 = r8.length
            r1 = r14
        L27:
            if (r1 >= r13) goto L7e
            r2 = r8[r1]
            boolean r3 = r2.d(r6)     // Catch: java.lang.Throwable -> L3a java.io.EOFException -> L6e
            if (r3 == 0) goto L3c
            r7.f63320b = r2     // Catch: java.lang.Throwable -> L3a java.io.EOFException -> L6e
            androidx.media3.common.util.a.g(r0)
            r6.resetPeekPosition()
            goto L7e
        L3a:
            r8 = move-exception
            goto L5a
        L3c:
            java.util.List r2 = r2.f()     // Catch: java.lang.Throwable -> L3a java.io.EOFException -> L6e
            r10.l(r2)     // Catch: java.lang.Throwable -> L3a java.io.EOFException -> L6e
            l2.r r2 = r7.f63320b
            if (r2 != 0) goto L52
            long r2 = r6.getPosition()
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 != 0) goto L50
            goto L52
        L50:
            r2 = r14
            goto L53
        L52:
            r2 = r0
        L53:
            androidx.media3.common.util.a.g(r2)
            r6.resetPeekPosition()
            goto L7b
        L5a:
            l2.r r9 = r7.f63320b
            if (r9 != 0) goto L66
            long r9 = r6.getPosition()
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto L67
        L66:
            r14 = r0
        L67:
            androidx.media3.common.util.a.g(r14)
            r6.resetPeekPosition()
            throw r8
        L6e:
            l2.r r2 = r7.f63320b
            if (r2 != 0) goto L52
            long r2 = r6.getPosition()
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 != 0) goto L50
            goto L52
        L7b:
            int r1 = r1 + 1
            goto L27
        L7e:
            l2.r r11 = r7.f63320b
            if (r11 == 0) goto L88
        L82:
            l2.r r8 = r7.f63320b
            r8.b(r15)
            return
        L88:
            androidx.media3.exoplayer.source.UnrecognizedInputFormatException r11 = new androidx.media3.exoplayer.source.UnrecognizedInputFormatException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "None of the available extractors ("
            r12.append(r13)
            java.lang.String r13 = ", "
            com.google.common.base.g r13 = com.google.common.base.g.h(r13)
            com.google.common.collect.ImmutableList r8 = com.google.common.collect.ImmutableList.copyOf(r8)
            g2.a r14 = new g2.a
            r14.<init>()
            java.util.List r8 = com.google.common.collect.Lists.o(r8, r14)
            java.lang.String r8 = r13.d(r8)
            r12.append(r8)
            java.lang.String r8 = ") could read the stream."
            r12.append(r8)
            java.lang.String r8 = r12.toString()
            java.lang.Object r9 = androidx.media3.common.util.a.e(r9)
            android.net.Uri r9 = (android.net.Uri) r9
            com.google.common.collect.ImmutableList r10 = r10.e()
            r11.<init>(r8, r9, r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.b.c(androidx.media3.common.j, android.net.Uri, java.util.Map, long, long, l2.t):void");
    }

    @Override // androidx.media3.exoplayer.source.v
    public int d(l0 l0Var) {
        return ((l2.r) androidx.media3.common.util.a.e(this.f63320b)).c((l2.s) androidx.media3.common.util.a.e(this.f63321c), l0Var);
    }

    @Override // androidx.media3.exoplayer.source.v
    public void release() {
        l2.r rVar = this.f63320b;
        if (rVar != null) {
            rVar.release();
            this.f63320b = null;
        }
        this.f63321c = null;
    }

    @Override // androidx.media3.exoplayer.source.v
    public void seek(long j11, long j12) {
        ((l2.r) androidx.media3.common.util.a.e(this.f63320b)).seek(j11, j12);
    }
}
