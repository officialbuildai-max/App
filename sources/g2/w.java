package g2;

import android.net.Uri;
import androidx.media3.common.e0;
import androidx.media3.common.t;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
public final class w extends e0 {

    /* renamed from: r, reason: collision with root package name */
    private static final Object f63371r = new Object();

    /* renamed from: s, reason: collision with root package name */
    private static final androidx.media3.common.t f63372s = new t.c().d("SinglePeriodTimeline").i(Uri.EMPTY).a();

    /* renamed from: e, reason: collision with root package name */
    private final long f63373e;

    /* renamed from: f, reason: collision with root package name */
    private final long f63374f;

    /* renamed from: g, reason: collision with root package name */
    private final long f63375g;

    /* renamed from: h, reason: collision with root package name */
    private final long f63376h;

    /* renamed from: i, reason: collision with root package name */
    private final long f63377i;

    /* renamed from: j, reason: collision with root package name */
    private final long f63378j;

    /* renamed from: k, reason: collision with root package name */
    private final long f63379k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f63380l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f63381m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f63382n;

    /* renamed from: o, reason: collision with root package name */
    private final Object f63383o;

    /* renamed from: p, reason: collision with root package name */
    private final androidx.media3.common.t f63384p;

    /* renamed from: q, reason: collision with root package name */
    private final t.g f63385q;

    public w(long j11, long j12, long j13, long j14, long j15, long j16, long j17, boolean z10, boolean z11, boolean z12, Object obj, androidx.media3.common.t tVar, t.g gVar) {
        this.f63373e = j11;
        this.f63374f = j12;
        this.f63375g = j13;
        this.f63376h = j14;
        this.f63377i = j15;
        this.f63378j = j16;
        this.f63379k = j17;
        this.f63380l = z10;
        this.f63381m = z11;
        this.f63382n = z12;
        this.f63383o = obj;
        this.f63384p = (androidx.media3.common.t) androidx.media3.common.util.a.e(tVar);
        this.f63385q = gVar;
    }

    public w(long j11, long j12, long j13, long j14, boolean z10, boolean z11, boolean z12, Object obj, androidx.media3.common.t tVar) {
        this(C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, j11, j12, j13, j14, z10, z11, false, obj, tVar, z12 ? tVar.f10295d : null);
    }

    public w(long j11, boolean z10, boolean z11, boolean z12, Object obj, androidx.media3.common.t tVar) {
        this(j11, j11, 0L, 0L, z10, z11, z12, obj, tVar);
    }

    @Override // androidx.media3.common.e0
    public int b(Object obj) {
        return f63371r.equals(obj) ? 0 : -1;
    }

    @Override // androidx.media3.common.e0
    public e0.b g(int i11, e0.b bVar, boolean z10) {
        androidx.media3.common.util.a.c(i11, 0, 1);
        return bVar.t(null, z10 ? f63371r : null, 0, this.f63376h, -this.f63378j);
    }

    @Override // androidx.media3.common.e0
    public int i() {
        return 1;
    }

    @Override // androidx.media3.common.e0
    public Object m(int i11) {
        androidx.media3.common.util.a.c(i11, 0, 1);
        return f63371r;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r1 > r3) goto L10;
     */
    @Override // androidx.media3.common.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.media3.common.e0.c o(int r25, androidx.media3.common.e0.c r26, long r27) {
        /*
            r24 = this;
            r0 = r24
            r1 = 0
            r2 = 1
            r3 = r25
            androidx.media3.common.util.a.c(r3, r1, r2)
            long r1 = r0.f63379k
            boolean r14 = r0.f63381m
            if (r14 == 0) goto L2e
            boolean r3 = r0.f63382n
            if (r3 != 0) goto L2e
            r3 = 0
            int r3 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r3 == 0) goto L2e
            long r3 = r0.f63377i
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
            java.lang.Object r4 = androidx.media3.common.e0.c.f10023q
            androidx.media3.common.t r5 = r0.f63384p
            java.lang.Object r6 = r0.f63383o
            long r7 = r0.f63373e
            long r9 = r0.f63374f
            long r11 = r0.f63375g
            boolean r13 = r0.f63380l
            androidx.media3.common.t$g r15 = r0.f63385q
            long r1 = r0.f63377i
            r18 = r1
            r21 = 0
            long r1 = r0.f63378j
            r22 = r1
            r20 = 0
            r3 = r26
            androidx.media3.common.e0$c r1 = r3.g(r4, r5, r6, r7, r9, r11, r13, r14, r15, r16, r18, r20, r21, r22)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.w.o(int, androidx.media3.common.e0$c, long):androidx.media3.common.e0$c");
    }

    @Override // androidx.media3.common.e0
    public int p() {
        return 1;
    }
}
