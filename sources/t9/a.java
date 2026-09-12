package t9;

import g9.a0;

/* loaded from: classes4.dex */
public final class a implements com.google.android.exoplayer2.source.r {

    /* renamed from: a, reason: collision with root package name */
    private final g9.r f76215a;

    /* renamed from: b, reason: collision with root package name */
    private g9.l f76216b;

    /* renamed from: c, reason: collision with root package name */
    private g9.m f76217c;

    public a(g9.r rVar) {
        this.f76215a = rVar;
    }

    @Override // com.google.android.exoplayer2.source.r
    public void a() {
        g9.l lVar = this.f76216b;
        if (lVar instanceof n9.f) {
            ((n9.f) lVar).i();
        }
    }

    @Override // com.google.android.exoplayer2.source.r
    public long b() {
        g9.m mVar = this.f76217c;
        if (mVar != null) {
            return mVar.getPosition();
        }
        return -1L;
    }

    @Override // com.google.android.exoplayer2.source.r
    public int c(a0 a0Var) {
        return ((g9.l) com.google.android.exoplayer2.util.a.e(this.f76216b)).c((g9.m) com.google.android.exoplayer2.util.a.e(this.f76217c), a0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0041, code lost:
    
        if (r6.getPosition() != r11) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0044, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
    
        if (r6.getPosition() != r11) goto L22;
     */
    @Override // com.google.android.exoplayer2.source.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(com.google.android.exoplayer2.upstream.g r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, g9.n r15) {
        /*
            r7 = this;
            g9.f r6 = new g9.f
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.f76217c = r6
            g9.l r8 = r7.f76216b
            if (r8 == 0) goto L10
            return
        L10:
            g9.r r8 = r7.f76215a
            g9.l[] r8 = r8.c(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L20
            r8 = r8[r13]
            r7.f76216b = r8
            goto L76
        L20:
            int r10 = r8.length
            r0 = r13
        L22:
            if (r0 >= r10) goto L72
            r1 = r8[r0]
            boolean r2 = r1.d(r6)     // Catch: java.lang.Throwable -> L35 java.io.EOFException -> L62
            if (r2 == 0) goto L37
            r7.f76216b = r1     // Catch: java.lang.Throwable -> L35 java.io.EOFException -> L62
            com.google.android.exoplayer2.util.a.g(r14)
            r6.resetPeekPosition()
            goto L72
        L35:
            r8 = move-exception
            goto L4e
        L37:
            g9.l r1 = r7.f76216b
            if (r1 != 0) goto L46
            long r1 = r6.getPosition()
            int r1 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r1 != 0) goto L44
            goto L46
        L44:
            r1 = r13
            goto L47
        L46:
            r1 = r14
        L47:
            com.google.android.exoplayer2.util.a.g(r1)
            r6.resetPeekPosition()
            goto L6f
        L4e:
            g9.l r9 = r7.f76216b
            if (r9 != 0) goto L5a
            long r9 = r6.getPosition()
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto L5b
        L5a:
            r13 = r14
        L5b:
            com.google.android.exoplayer2.util.a.g(r13)
            r6.resetPeekPosition()
            throw r8
        L62:
            g9.l r1 = r7.f76216b
            if (r1 != 0) goto L46
            long r1 = r6.getPosition()
            int r1 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r1 != 0) goto L44
            goto L46
        L6f:
            int r0 = r0 + 1
            goto L22
        L72:
            g9.l r10 = r7.f76216b
            if (r10 == 0) goto L7c
        L76:
            g9.l r8 = r7.f76216b
            r8.b(r15)
            return
        L7c:
            com.google.android.exoplayer2.source.UnrecognizedInputFormatException r10 = new com.google.android.exoplayer2.source.UnrecognizedInputFormatException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "None of the available extractors ("
            r11.append(r12)
            java.lang.String r8 = com.google.android.exoplayer2.util.p0.M(r8)
            r11.append(r8)
            java.lang.String r8 = ") could read the stream."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            java.lang.Object r9 = com.google.android.exoplayer2.util.a.e(r9)
            android.net.Uri r9 = (android.net.Uri) r9
            r10.<init>(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: t9.a.d(com.google.android.exoplayer2.upstream.g, android.net.Uri, java.util.Map, long, long, g9.n):void");
    }

    @Override // com.google.android.exoplayer2.source.r
    public void release() {
        g9.l lVar = this.f76216b;
        if (lVar != null) {
            lVar.release();
            this.f76216b = null;
        }
        this.f76217c = null;
    }

    @Override // com.google.android.exoplayer2.source.r
    public void seek(long j11, long j12) {
        ((g9.l) com.google.android.exoplayer2.util.a.e(this.f76216b)).seek(j11, j12);
    }
}
