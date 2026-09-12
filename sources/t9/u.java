package t9;

import android.net.Uri;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.v1;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes4.dex */
public final class u extends k3 {

    /* renamed from: p, reason: collision with root package name */
    private static final Object f76271p = new Object();

    /* renamed from: q, reason: collision with root package name */
    private static final v1 f76272q = new v1.c().d("SinglePeriodTimeline").i(Uri.EMPTY).a();

    /* renamed from: c, reason: collision with root package name */
    private final long f76273c;

    /* renamed from: d, reason: collision with root package name */
    private final long f76274d;

    /* renamed from: e, reason: collision with root package name */
    private final long f76275e;

    /* renamed from: f, reason: collision with root package name */
    private final long f76276f;

    /* renamed from: g, reason: collision with root package name */
    private final long f76277g;

    /* renamed from: h, reason: collision with root package name */
    private final long f76278h;

    /* renamed from: i, reason: collision with root package name */
    private final long f76279i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f76280j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f76281k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f76282l;

    /* renamed from: m, reason: collision with root package name */
    private final Object f76283m;

    /* renamed from: n, reason: collision with root package name */
    private final v1 f76284n;

    /* renamed from: o, reason: collision with root package name */
    private final v1.g f76285o;

    public u(long j11, long j12, long j13, long j14, long j15, long j16, long j17, boolean z10, boolean z11, boolean z12, Object obj, v1 v1Var, v1.g gVar) {
        this.f76273c = j11;
        this.f76274d = j12;
        this.f76275e = j13;
        this.f76276f = j14;
        this.f76277g = j15;
        this.f76278h = j16;
        this.f76279i = j17;
        this.f76280j = z10;
        this.f76281k = z11;
        this.f76282l = z12;
        this.f76283m = obj;
        this.f76284n = (v1) com.google.android.exoplayer2.util.a.e(v1Var);
        this.f76285o = gVar;
    }

    public u(long j11, long j12, long j13, long j14, boolean z10, boolean z11, boolean z12, Object obj, v1 v1Var) {
        this(C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, j11, j12, j13, j14, z10, z11, false, obj, v1Var, z12 ? v1Var.f27765d : null);
    }

    public u(long j11, boolean z10, boolean z11, boolean z12, Object obj, v1 v1Var) {
        this(j11, j11, 0L, 0L, z10, z11, z12, obj, v1Var);
    }

    @Override // com.google.android.exoplayer2.k3
    public int f(Object obj) {
        return f76271p.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.k3
    public k3.b k(int i11, k3.b bVar, boolean z10) {
        com.google.android.exoplayer2.util.a.c(i11, 0, 1);
        return bVar.v(null, z10 ? f76271p : null, 0, this.f76276f, -this.f76278h);
    }

    @Override // com.google.android.exoplayer2.k3
    public int m() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.k3
    public Object q(int i11) {
        com.google.android.exoplayer2.util.a.c(i11, 0, 1);
        return f76271p;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r1 > r3) goto L10;
     */
    @Override // com.google.android.exoplayer2.k3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.exoplayer2.k3.d s(int r25, com.google.android.exoplayer2.k3.d r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 0
            r2 = 1
            r3 = r25
            com.google.android.exoplayer2.util.a.c(r3, r1, r2)
            long r1 = r0.f76279i
            boolean r14 = r0.f76281k
            if (r14 == 0) goto L2e
            boolean r3 = r0.f76282l
            if (r3 != 0) goto L2e
            r3 = 0
            int r3 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r3 == 0) goto L2e
            long r3 = r0.f76277g
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L27
        L24:
            r16 = r5
            goto L30
        L27:
            long r1 = r1 + r27
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L2e
            goto L24
        L2e:
            r16 = r1
        L30:
            java.lang.Object r4 = com.google.android.exoplayer2.k3.d.f25219r
            com.google.android.exoplayer2.v1 r5 = r0.f76284n
            java.lang.Object r6 = r0.f76283m
            long r7 = r0.f76273c
            long r9 = r0.f76274d
            long r11 = r0.f76275e
            boolean r13 = r0.f76280j
            com.google.android.exoplayer2.v1$g r15 = r0.f76285o
            long r1 = r0.f76277g
            r18 = r1
            r21 = 0
            long r1 = r0.f76278h
            r22 = r1
            r20 = 0
            r3 = r26
            com.google.android.exoplayer2.k3$d r1 = r3.k(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: t9.u.s(int, com.google.android.exoplayer2.k3$d, long):com.google.android.exoplayer2.k3$d");
    }

    @Override // com.google.android.exoplayer2.k3
    public int t() {
        return 1;
    }
}
